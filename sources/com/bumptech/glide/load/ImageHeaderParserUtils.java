package com.bumptech.glide.load;

import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public final class ImageHeaderParserUtils {

    private interface OrientationReader {
        int a(ImageHeaderParser imageHeaderParser) throws IOException;
    }

    private interface TypeReader {
        ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) throws IOException;
    }

    private ImageHeaderParserUtils() {
    }

    public static int a(List<ImageHeaderParser> list, final ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, final ArrayPool arrayPool) throws IOException {
        return c(list, new OrientationReader() {
            /* JADX WARNING: Removed duplicated region for block: B:14:0x002c A[SYNTHETIC, Splitter:B:14:0x002c] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public int a(com.bumptech.glide.load.ImageHeaderParser r5) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream r1 = new com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream     // Catch:{ all -> 0x0029 }
                    java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ all -> 0x0029 }
                    com.bumptech.glide.load.data.ParcelFileDescriptorRewinder r3 = com.bumptech.glide.load.data.ParcelFileDescriptorRewinder.this     // Catch:{ all -> 0x0029 }
                    android.os.ParcelFileDescriptor r3 = r3.a()     // Catch:{ all -> 0x0029 }
                    java.io.FileDescriptor r3 = r3.getFileDescriptor()     // Catch:{ all -> 0x0029 }
                    r2.<init>(r3)     // Catch:{ all -> 0x0029 }
                    com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool r3 = r3     // Catch:{ all -> 0x0029 }
                    r1.<init>(r2, r3)     // Catch:{ all -> 0x0029 }
                    com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool r0 = r3     // Catch:{ all -> 0x0026 }
                    int r5 = r5.c(r1, r0)     // Catch:{ all -> 0x0026 }
                    r1.close()     // Catch:{ IOException -> 0x0020 }
                L_0x0020:
                    com.bumptech.glide.load.data.ParcelFileDescriptorRewinder r0 = com.bumptech.glide.load.data.ParcelFileDescriptorRewinder.this
                    r0.a()
                    return r5
                L_0x0026:
                    r5 = move-exception
                    r0 = r1
                    goto L_0x002a
                L_0x0029:
                    r5 = move-exception
                L_0x002a:
                    if (r0 == 0) goto L_0x002f
                    r0.close()     // Catch:{ IOException -> 0x002f }
                L_0x002f:
                    com.bumptech.glide.load.data.ParcelFileDescriptorRewinder r0 = com.bumptech.glide.load.data.ParcelFileDescriptorRewinder.this
                    r0.a()
                    throw r5
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.ImageHeaderParserUtils.AnonymousClass5.a(com.bumptech.glide.load.ImageHeaderParser):int");
            }
        });
    }

    public static int b(List<ImageHeaderParser> list, final InputStream inputStream, final ArrayPool arrayPool) throws IOException {
        if (inputStream == null) {
            return -1;
        }
        if (!inputStream.markSupported()) {
            inputStream = new RecyclableBufferedInputStream(inputStream, arrayPool);
        }
        inputStream.mark(5242880);
        return c(list, new OrientationReader() {
            public int a(ImageHeaderParser imageHeaderParser) throws IOException {
                try {
                    return imageHeaderParser.c(inputStream, arrayPool);
                } finally {
                    inputStream.reset();
                }
            }
        });
    }

    private static int c(List<ImageHeaderParser> list, OrientationReader orientationReader) throws IOException {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            int a2 = orientationReader.a(list.get(i2));
            if (a2 != -1) {
                return a2;
            }
        }
        return -1;
    }

    public static ImageHeaderParser.ImageType d(List<ImageHeaderParser> list, final ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, final ArrayPool arrayPool) throws IOException {
        return g(list, new TypeReader() {
            /* JADX WARNING: Removed duplicated region for block: B:14:0x002a A[SYNTHETIC, Splitter:B:14:0x002a] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public com.bumptech.glide.load.ImageHeaderParser.ImageType a(com.bumptech.glide.load.ImageHeaderParser r5) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream r1 = new com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream     // Catch:{ all -> 0x0027 }
                    java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ all -> 0x0027 }
                    com.bumptech.glide.load.data.ParcelFileDescriptorRewinder r3 = com.bumptech.glide.load.data.ParcelFileDescriptorRewinder.this     // Catch:{ all -> 0x0027 }
                    android.os.ParcelFileDescriptor r3 = r3.a()     // Catch:{ all -> 0x0027 }
                    java.io.FileDescriptor r3 = r3.getFileDescriptor()     // Catch:{ all -> 0x0027 }
                    r2.<init>(r3)     // Catch:{ all -> 0x0027 }
                    com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool r3 = r3     // Catch:{ all -> 0x0027 }
                    r1.<init>(r2, r3)     // Catch:{ all -> 0x0027 }
                    com.bumptech.glide.load.ImageHeaderParser$ImageType r5 = r5.b(r1)     // Catch:{ all -> 0x0024 }
                    r1.close()     // Catch:{ IOException -> 0x001e }
                L_0x001e:
                    com.bumptech.glide.load.data.ParcelFileDescriptorRewinder r0 = com.bumptech.glide.load.data.ParcelFileDescriptorRewinder.this
                    r0.a()
                    return r5
                L_0x0024:
                    r5 = move-exception
                    r0 = r1
                    goto L_0x0028
                L_0x0027:
                    r5 = move-exception
                L_0x0028:
                    if (r0 == 0) goto L_0x002d
                    r0.close()     // Catch:{ IOException -> 0x002d }
                L_0x002d:
                    com.bumptech.glide.load.data.ParcelFileDescriptorRewinder r0 = com.bumptech.glide.load.data.ParcelFileDescriptorRewinder.this
                    r0.a()
                    throw r5
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.ImageHeaderParserUtils.AnonymousClass3.a(com.bumptech.glide.load.ImageHeaderParser):com.bumptech.glide.load.ImageHeaderParser$ImageType");
            }
        });
    }

    public static ImageHeaderParser.ImageType e(List<ImageHeaderParser> list, final InputStream inputStream, ArrayPool arrayPool) throws IOException {
        if (inputStream == null) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        if (!inputStream.markSupported()) {
            inputStream = new RecyclableBufferedInputStream(inputStream, arrayPool);
        }
        inputStream.mark(5242880);
        return g(list, new TypeReader() {
            public ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) throws IOException {
                try {
                    return imageHeaderParser.b(inputStream);
                } finally {
                    inputStream.reset();
                }
            }
        });
    }

    public static ImageHeaderParser.ImageType f(List<ImageHeaderParser> list, final ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer == null) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        return g(list, new TypeReader() {
            public ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) throws IOException {
                return imageHeaderParser.a(byteBuffer);
            }
        });
    }

    private static ImageHeaderParser.ImageType g(List<ImageHeaderParser> list, TypeReader typeReader) throws IOException {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            ImageHeaderParser.ImageType a2 = typeReader.a(list.get(i2));
            if (a2 != ImageHeaderParser.ImageType.UNKNOWN) {
                return a2;
            }
        }
        return ImageHeaderParser.ImageType.UNKNOWN;
    }
}
