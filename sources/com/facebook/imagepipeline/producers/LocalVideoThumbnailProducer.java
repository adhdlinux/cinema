package com.facebook.imagepipeline.producers;

import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.bitmaps.SimpleBitmapReleaser;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.producers.ProducerContext;
import com.facebook.imagepipeline.request.ImageRequest;
import com.google.android.gms.common.internal.ImagesContract;
import com.unity3d.services.core.device.MimeTypes;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.concurrent.Executor;

public class LocalVideoThumbnailProducer implements Producer<CloseableReference<CloseableImage>> {
    static final String CREATED_THUMBNAIL = "createdThumbnail";
    public static final String PRODUCER_NAME = "VideoThumbnailProducer";
    /* access modifiers changed from: private */
    public final ContentResolver mContentResolver;
    private final Executor mExecutor;

    public LocalVideoThumbnailProducer(Executor executor, ContentResolver contentResolver) {
        this.mExecutor = executor;
        this.mContentResolver = contentResolver;
    }

    /* access modifiers changed from: private */
    public static int calculateKind(ImageRequest imageRequest) {
        return (imageRequest.getPreferredWidth() > 96 || imageRequest.getPreferredHeight() > 96) ? 1 : 3;
    }

    /* access modifiers changed from: private */
    public static Bitmap createThumbnailFromContentProvider(ContentResolver contentResolver, Uri uri) {
        try {
            ParcelFileDescriptor openFileDescriptor = contentResolver.openFileDescriptor(uri, "r");
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(openFileDescriptor.getFileDescriptor());
            return mediaMetadataRetriever.getFrameAtTime(-1);
        } catch (FileNotFoundException unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public String getLocalFilePath(ImageRequest imageRequest) {
        String[] strArr;
        String str;
        Uri uri;
        Uri sourceUri = imageRequest.getSourceUri();
        if (UriUtil.isLocalFileUri(sourceUri)) {
            return imageRequest.getSourceFile().getPath();
        }
        if (UriUtil.isLocalContentUri(sourceUri)) {
            if ("com.android.providers.media.documents".equals(sourceUri.getAuthority())) {
                String documentId = DocumentsContract.getDocumentId(sourceUri);
                str = "_id=?";
                uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                strArr = new String[]{documentId.split(":")[1]};
            } else {
                uri = sourceUri;
                str = null;
                strArr = null;
            }
            Cursor query = this.mContentResolver.query(uri, new String[]{"_data"}, str, strArr, (String) null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        return query.getString(query.getColumnIndexOrThrow("_data"));
                    }
                } finally {
                    query.close();
                }
            }
            if (query != null) {
                query.close();
            }
        }
        return null;
    }

    public void produceResults(Consumer<CloseableReference<CloseableImage>> consumer, ProducerContext producerContext) {
        final ProducerListener2 producerListener = producerContext.getProducerListener();
        final ImageRequest imageRequest = producerContext.getImageRequest();
        producerContext.putOriginExtra(ImagesContract.LOCAL, MimeTypes.BASE_TYPE_VIDEO);
        final ProducerContext producerContext2 = producerContext;
        final AnonymousClass1 r02 = new StatefulProducerRunnable<CloseableReference<CloseableImage>>(consumer, producerListener, producerContext, PRODUCER_NAME) {
            /* access modifiers changed from: protected */
            public void onFailure(Exception exc) {
                super.onFailure(exc);
                producerListener.onUltimateProducerReached(producerContext2, LocalVideoThumbnailProducer.PRODUCER_NAME, false);
                producerContext2.putOriginExtra(ImagesContract.LOCAL);
            }

            /* access modifiers changed from: protected */
            public void disposeResult(CloseableReference<CloseableImage> closeableReference) {
                CloseableReference.closeSafely((CloseableReference<?>) closeableReference);
            }

            /* access modifiers changed from: protected */
            public Map<String, String> getExtraMapOnSuccess(CloseableReference<CloseableImage> closeableReference) {
                return ImmutableMap.of(LocalVideoThumbnailProducer.CREATED_THUMBNAIL, String.valueOf(closeableReference != null));
            }

            /* access modifiers changed from: protected */
            public CloseableReference<CloseableImage> getResult() throws Exception {
                String str;
                Bitmap bitmap;
                try {
                    str = LocalVideoThumbnailProducer.this.getLocalFilePath(imageRequest);
                } catch (IllegalArgumentException unused) {
                    str = null;
                }
                if (str != null) {
                    bitmap = ThumbnailUtils.createVideoThumbnail(str, LocalVideoThumbnailProducer.calculateKind(imageRequest));
                } else {
                    bitmap = LocalVideoThumbnailProducer.createThumbnailFromContentProvider(LocalVideoThumbnailProducer.this.mContentResolver, imageRequest.getSourceUri());
                }
                if (bitmap == null) {
                    return null;
                }
                CloseableStaticBitmap closeableStaticBitmap = new CloseableStaticBitmap(bitmap, (ResourceReleaser<Bitmap>) SimpleBitmapReleaser.getInstance(), ImmutableQualityInfo.FULL_QUALITY, 0);
                producerContext2.setExtra(ProducerContext.ExtraKeys.IMAGE_FORMAT, "thumbnail");
                closeableStaticBitmap.setImageExtras(producerContext2.getExtras());
                return CloseableReference.of(closeableStaticBitmap);
            }

            /* access modifiers changed from: protected */
            public void onSuccess(CloseableReference<CloseableImage> closeableReference) {
                super.onSuccess(closeableReference);
                producerListener.onUltimateProducerReached(producerContext2, LocalVideoThumbnailProducer.PRODUCER_NAME, closeableReference != null);
                producerContext2.putOriginExtra(ImagesContract.LOCAL);
            }
        };
        producerContext.addCallbacks(new BaseProducerContextCallbacks() {
            public void onCancellationRequested() {
                r02.cancel();
            }
        });
        this.mExecutor.execute(r02);
    }
}
