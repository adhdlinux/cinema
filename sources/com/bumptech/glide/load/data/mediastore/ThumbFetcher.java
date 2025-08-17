package com.bumptech.glide.load.data.mediastore;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.ExifOrientationStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ThumbFetcher implements DataFetcher<InputStream> {

    /* renamed from: b  reason: collision with root package name */
    private final Uri f16345b;

    /* renamed from: c  reason: collision with root package name */
    private final ThumbnailStreamOpener f16346c;

    /* renamed from: d  reason: collision with root package name */
    private InputStream f16347d;

    static class ImageThumbnailQuery implements ThumbnailQuery {

        /* renamed from: b  reason: collision with root package name */
        private static final String[] f16348b = {"_data"};

        /* renamed from: a  reason: collision with root package name */
        private final ContentResolver f16349a;

        ImageThumbnailQuery(ContentResolver contentResolver) {
            this.f16349a = contentResolver;
        }

        public Cursor a(Uri uri) {
            String lastPathSegment = uri.getLastPathSegment();
            return this.f16349a.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, f16348b, "kind = 1 AND image_id = ?", new String[]{lastPathSegment}, (String) null);
        }
    }

    static class VideoThumbnailQuery implements ThumbnailQuery {

        /* renamed from: b  reason: collision with root package name */
        private static final String[] f16350b = {"_data"};

        /* renamed from: a  reason: collision with root package name */
        private final ContentResolver f16351a;

        VideoThumbnailQuery(ContentResolver contentResolver) {
            this.f16351a = contentResolver;
        }

        public Cursor a(Uri uri) {
            String lastPathSegment = uri.getLastPathSegment();
            return this.f16351a.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, f16350b, "kind = 1 AND video_id = ?", new String[]{lastPathSegment}, (String) null);
        }
    }

    ThumbFetcher(Uri uri, ThumbnailStreamOpener thumbnailStreamOpener) {
        this.f16345b = uri;
        this.f16346c = thumbnailStreamOpener;
    }

    private static ThumbFetcher c(Context context, Uri uri, ThumbnailQuery thumbnailQuery) {
        return new ThumbFetcher(uri, new ThumbnailStreamOpener(Glide.c(context).j().g(), thumbnailQuery, Glide.c(context).e(), context.getContentResolver()));
    }

    public static ThumbFetcher f(Context context, Uri uri) {
        return c(context, uri, new ImageThumbnailQuery(context.getContentResolver()));
    }

    public static ThumbFetcher g(Context context, Uri uri) {
        return c(context, uri, new VideoThumbnailQuery(context.getContentResolver()));
    }

    private InputStream h() throws FileNotFoundException {
        int i2;
        InputStream d2 = this.f16346c.d(this.f16345b);
        if (d2 != null) {
            i2 = this.f16346c.a(this.f16345b);
        } else {
            i2 = -1;
        }
        if (i2 != -1) {
            return new ExifOrientationStream(d2, i2);
        }
        return d2;
    }

    public Class<InputStream> a() {
        return InputStream.class;
    }

    public void b() {
        InputStream inputStream = this.f16347d;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    public void cancel() {
    }

    public DataSource d() {
        return DataSource.LOCAL;
    }

    public void e(Priority priority, DataFetcher.DataCallback<? super InputStream> dataCallback) {
        try {
            InputStream h2 = h();
            this.f16347d = h2;
            dataCallback.f(h2);
        } catch (FileNotFoundException e2) {
            if (Log.isLoggable("MediaStoreThumbFetcher", 3)) {
                Log.d("MediaStoreThumbFetcher", "Failed to find thumbnail file", e2);
            }
            dataCallback.c(e2);
        }
    }
}
