package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

public class VideoDecoder<T> implements ResourceDecoder<T, Bitmap> {

    /* renamed from: d  reason: collision with root package name */
    public static final Option<Long> f16891d = Option.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, new Option.CacheKeyUpdater<Long>() {

        /* renamed from: a  reason: collision with root package name */
        private final ByteBuffer f16897a = ByteBuffer.allocate(8);

        /* renamed from: b */
        public void a(byte[] bArr, Long l2, MessageDigest messageDigest) {
            messageDigest.update(bArr);
            synchronized (this.f16897a) {
                this.f16897a.position(0);
                messageDigest.update(this.f16897a.putLong(l2.longValue()).array());
            }
        }
    });

    /* renamed from: e  reason: collision with root package name */
    public static final Option<Integer> f16892e = Option.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, new Option.CacheKeyUpdater<Integer>() {

        /* renamed from: a  reason: collision with root package name */
        private final ByteBuffer f16898a = ByteBuffer.allocate(4);

        /* renamed from: b */
        public void a(byte[] bArr, Integer num, MessageDigest messageDigest) {
            if (num != null) {
                messageDigest.update(bArr);
                synchronized (this.f16898a) {
                    this.f16898a.position(0);
                    messageDigest.update(this.f16898a.putInt(num.intValue()).array());
                }
            }
        }
    });

    /* renamed from: f  reason: collision with root package name */
    private static final MediaMetadataRetrieverFactory f16893f = new MediaMetadataRetrieverFactory();

    /* renamed from: a  reason: collision with root package name */
    private final MediaMetadataRetrieverInitializer<T> f16894a;

    /* renamed from: b  reason: collision with root package name */
    private final BitmapPool f16895b;

    /* renamed from: c  reason: collision with root package name */
    private final MediaMetadataRetrieverFactory f16896c;

    private static final class AssetFileDescriptorInitializer implements MediaMetadataRetrieverInitializer<AssetFileDescriptor> {
        private AssetFileDescriptorInitializer() {
        }

        /* renamed from: b */
        public void a(MediaMetadataRetriever mediaMetadataRetriever, AssetFileDescriptor assetFileDescriptor) {
            mediaMetadataRetriever.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        }
    }

    static final class ByteBufferInitializer implements MediaMetadataRetrieverInitializer<ByteBuffer> {
        ByteBufferInitializer() {
        }

        /* renamed from: b */
        public void a(MediaMetadataRetriever mediaMetadataRetriever, final ByteBuffer byteBuffer) {
            mediaMetadataRetriever.setDataSource(new MediaDataSource() {
                public void close() {
                }

                public long getSize() {
                    return (long) byteBuffer.limit();
                }

                public int readAt(long j2, byte[] bArr, int i2, int i3) {
                    if (j2 >= ((long) byteBuffer.limit())) {
                        return -1;
                    }
                    byteBuffer.position((int) j2);
                    int min = Math.min(i3, byteBuffer.remaining());
                    byteBuffer.get(bArr, i2, min);
                    return min;
                }
            });
        }
    }

    static class MediaMetadataRetrieverFactory {
        MediaMetadataRetrieverFactory() {
        }

        public MediaMetadataRetriever a() {
            return new MediaMetadataRetriever();
        }
    }

    interface MediaMetadataRetrieverInitializer<T> {
        void a(MediaMetadataRetriever mediaMetadataRetriever, T t2);
    }

    static final class ParcelFileDescriptorInitializer implements MediaMetadataRetrieverInitializer<ParcelFileDescriptor> {
        ParcelFileDescriptorInitializer() {
        }

        /* renamed from: b */
        public void a(MediaMetadataRetriever mediaMetadataRetriever, ParcelFileDescriptor parcelFileDescriptor) {
            mediaMetadataRetriever.setDataSource(parcelFileDescriptor.getFileDescriptor());
        }
    }

    VideoDecoder(BitmapPool bitmapPool, MediaMetadataRetrieverInitializer<T> mediaMetadataRetrieverInitializer) {
        this(bitmapPool, mediaMetadataRetrieverInitializer, f16893f);
    }

    public static ResourceDecoder<AssetFileDescriptor, Bitmap> c(BitmapPool bitmapPool) {
        return new VideoDecoder(bitmapPool, new AssetFileDescriptorInitializer());
    }

    public static ResourceDecoder<ByteBuffer, Bitmap> d(BitmapPool bitmapPool) {
        return new VideoDecoder(bitmapPool, new ByteBufferInitializer());
    }

    private static Bitmap e(MediaMetadataRetriever mediaMetadataRetriever, long j2, int i2, int i3, int i4, DownsampleStrategy downsampleStrategy) {
        Bitmap bitmap;
        if (Build.VERSION.SDK_INT < 27 || i3 == Integer.MIN_VALUE || i4 == Integer.MIN_VALUE || downsampleStrategy == DownsampleStrategy.f16831f) {
            bitmap = null;
        } else {
            bitmap = g(mediaMetadataRetriever, j2, i2, i3, i4, downsampleStrategy);
        }
        if (bitmap == null) {
            return f(mediaMetadataRetriever, j2, i2);
        }
        return bitmap;
    }

    private static Bitmap f(MediaMetadataRetriever mediaMetadataRetriever, long j2, int i2) {
        return mediaMetadataRetriever.getFrameAtTime(j2, i2);
    }

    @TargetApi(27)
    private static Bitmap g(MediaMetadataRetriever mediaMetadataRetriever, long j2, int i2, int i3, int i4, DownsampleStrategy downsampleStrategy) {
        try {
            int parseInt = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
            int parseInt2 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
            int parseInt3 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
            if (parseInt3 == 90 || parseInt3 == 270) {
                int i5 = parseInt2;
                parseInt2 = parseInt;
                parseInt = i5;
            }
            float b2 = downsampleStrategy.b(parseInt, parseInt2, i3, i4);
            return mediaMetadataRetriever.getScaledFrameAtTime(j2, i2, Math.round(((float) parseInt) * b2), Math.round(b2 * ((float) parseInt2)));
        } catch (Throwable th) {
            if (!Log.isLoggable("VideoDecoder", 3)) {
                return null;
            }
            Log.d("VideoDecoder", "Exception trying to decode frame on oreo+", th);
            return null;
        }
    }

    public static ResourceDecoder<ParcelFileDescriptor, Bitmap> h(BitmapPool bitmapPool) {
        return new VideoDecoder(bitmapPool, new ParcelFileDescriptorInitializer());
    }

    public boolean a(T t2, Options options) {
        return true;
    }

    public Resource<Bitmap> b(T t2, int i2, int i3, Options options) throws IOException {
        long longValue = ((Long) options.c(f16891d)).longValue();
        if (longValue >= 0 || longValue == -1) {
            Integer num = (Integer) options.c(f16892e);
            if (num == null) {
                num = 2;
            }
            DownsampleStrategy downsampleStrategy = (DownsampleStrategy) options.c(DownsampleStrategy.f16833h);
            if (downsampleStrategy == null) {
                downsampleStrategy = DownsampleStrategy.f16832g;
            }
            DownsampleStrategy downsampleStrategy2 = downsampleStrategy;
            MediaMetadataRetriever a2 = this.f16896c.a();
            try {
                this.f16894a.a(a2, t2);
                Bitmap e2 = e(a2, longValue, num.intValue(), i2, i3, downsampleStrategy2);
                a2.release();
                return BitmapResource.c(e2, this.f16895b);
            } catch (RuntimeException e3) {
                throw new IOException(e3);
            } catch (Throwable th) {
                a2.release();
                throw th;
            }
        } else {
            throw new IllegalArgumentException("Requested frame must be non-negative, or DEFAULT_FRAME, given: " + longValue);
        }
    }

    VideoDecoder(BitmapPool bitmapPool, MediaMetadataRetrieverInitializer<T> mediaMetadataRetrieverInitializer, MediaMetadataRetrieverFactory mediaMetadataRetrieverFactory) {
        this.f16895b = bitmapPool;
        this.f16894a = mediaMetadataRetrieverInitializer;
        this.f16896c = mediaMetadataRetrieverFactory;
    }
}
