package com.squareup.picasso;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import com.facebook.imagepipeline.memory.BitmapCounterConfig;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestHandler;
import com.unity3d.services.ads.adunit.AdUnitActivity;
import java.io.IOException;
import okio.Okio;
import okio.Source;

class MediaStoreRequestHandler extends ContentStreamRequestHandler {
    private static final String[] CONTENT_ORIENTATION = {AdUnitActivity.EXTRA_ORIENTATION};

    enum PicassoKind {
        MICRO(3, 96, 96),
        MINI(1, 512, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT),
        FULL(2, -1, -1);
        
        final int androidKind;
        final int height;
        final int width;

        private PicassoKind(int i2, int i3, int i4) {
            this.androidKind = i2;
            this.width = i3;
            this.height = i4;
        }
    }

    MediaStoreRequestHandler(Context context) {
        super(context);
    }

    static int getExifOrientation(ContentResolver contentResolver, Uri uri) {
        Cursor cursor = null;
        try {
            Cursor query = contentResolver.query(uri, CONTENT_ORIENTATION, (String) null, (String[]) null, (String) null);
            if (query != null) {
                if (query.moveToFirst()) {
                    int i2 = query.getInt(0);
                    query.close();
                    return i2;
                }
            }
            if (query != null) {
                query.close();
            }
            return 0;
        } catch (RuntimeException unused) {
            if (cursor != null) {
                cursor.close();
            }
            return 0;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    static PicassoKind getPicassoKind(int i2, int i3) {
        PicassoKind picassoKind = PicassoKind.MICRO;
        if (i2 <= picassoKind.width && i3 <= picassoKind.height) {
            return picassoKind;
        }
        PicassoKind picassoKind2 = PicassoKind.MINI;
        if (i2 > picassoKind2.width || i3 > picassoKind2.height) {
            return PicassoKind.FULL;
        }
        return picassoKind2;
    }

    public boolean canHandleRequest(Request request) {
        Uri uri = request.uri;
        if (!"content".equals(uri.getScheme()) || !"media".equals(uri.getAuthority())) {
            return false;
        }
        return true;
    }

    public RequestHandler.Result load(Request request, int i2) throws IOException {
        boolean z2;
        Bitmap bitmap;
        int i3;
        Request request2 = request;
        ContentResolver contentResolver = this.context.getContentResolver();
        int exifOrientation = getExifOrientation(contentResolver, request2.uri);
        String type = contentResolver.getType(request2.uri);
        if (type == null || !type.startsWith("video/")) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (request.hasSize()) {
            PicassoKind picassoKind = getPicassoKind(request2.targetWidth, request2.targetHeight);
            if (!z2 && picassoKind == PicassoKind.FULL) {
                return new RequestHandler.Result((Bitmap) null, Okio.l(getInputStream(request)), Picasso.LoadedFrom.DISK, exifOrientation);
            }
            long parseId = ContentUris.parseId(request2.uri);
            BitmapFactory.Options createBitmapOptions = RequestHandler.createBitmapOptions(request);
            createBitmapOptions.inJustDecodeBounds = true;
            BitmapFactory.Options options = createBitmapOptions;
            RequestHandler.calculateInSampleSize(request2.targetWidth, request2.targetHeight, picassoKind.width, picassoKind.height, createBitmapOptions, request);
            if (z2) {
                if (picassoKind == PicassoKind.FULL) {
                    i3 = 1;
                } else {
                    i3 = picassoKind.androidKind;
                }
                bitmap = MediaStore.Video.Thumbnails.getThumbnail(contentResolver, parseId, i3, options);
            } else {
                bitmap = MediaStore.Images.Thumbnails.getThumbnail(contentResolver, parseId, picassoKind.androidKind, options);
            }
            if (bitmap != null) {
                return new RequestHandler.Result(bitmap, (Source) null, Picasso.LoadedFrom.DISK, exifOrientation);
            }
        }
        return new RequestHandler.Result((Bitmap) null, Okio.l(getInputStream(request)), Picasso.LoadedFrom.DISK, exifOrientation);
    }
}
