package com.bumptech.glide.load.resource.bitmap;

import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.util.Preconditions;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

public final class DefaultImageHeaderParser implements ImageHeaderParser {

    /* renamed from: a  reason: collision with root package name */
    static final byte[] f16821a = "Exif\u0000\u0000".getBytes(Charset.forName("UTF-8"));

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f16822b = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    private static final class ByteBufferReader implements Reader {

        /* renamed from: a  reason: collision with root package name */
        private final ByteBuffer f16823a;

        ByteBufferReader(ByteBuffer byteBuffer) {
            this.f16823a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        public int a() throws Reader.EndOfFileException {
            return (c() << 8) | c();
        }

        public int b(byte[] bArr, int i2) {
            int min = Math.min(i2, this.f16823a.remaining());
            if (min == 0) {
                return -1;
            }
            this.f16823a.get(bArr, 0, min);
            return min;
        }

        public short c() throws Reader.EndOfFileException {
            if (this.f16823a.remaining() >= 1) {
                return (short) (this.f16823a.get() & 255);
            }
            throw new Reader.EndOfFileException();
        }

        public long skip(long j2) {
            int min = (int) Math.min((long) this.f16823a.remaining(), j2);
            ByteBuffer byteBuffer = this.f16823a;
            byteBuffer.position(byteBuffer.position() + min);
            return (long) min;
        }
    }

    private static final class RandomAccessReader {

        /* renamed from: a  reason: collision with root package name */
        private final ByteBuffer f16824a;

        RandomAccessReader(byte[] bArr, int i2) {
            this.f16824a = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i2);
        }

        private boolean c(int i2, int i3) {
            return this.f16824a.remaining() - i2 >= i3;
        }

        /* access modifiers changed from: package-private */
        public short a(int i2) {
            if (c(i2, 2)) {
                return this.f16824a.getShort(i2);
            }
            return -1;
        }

        /* access modifiers changed from: package-private */
        public int b(int i2) {
            if (c(i2, 4)) {
                return this.f16824a.getInt(i2);
            }
            return -1;
        }

        /* access modifiers changed from: package-private */
        public int d() {
            return this.f16824a.remaining();
        }

        /* access modifiers changed from: package-private */
        public void e(ByteOrder byteOrder) {
            this.f16824a.order(byteOrder);
        }
    }

    private interface Reader {

        public static final class EndOfFileException extends IOException {
            EndOfFileException() {
                super("Unexpectedly reached end of a file");
            }
        }

        int a() throws IOException;

        int b(byte[] bArr, int i2) throws IOException;

        short c() throws IOException;

        long skip(long j2) throws IOException;
    }

    private static final class StreamReader implements Reader {

        /* renamed from: a  reason: collision with root package name */
        private final InputStream f16825a;

        StreamReader(InputStream inputStream) {
            this.f16825a = inputStream;
        }

        public int a() throws IOException {
            return (c() << 8) | c();
        }

        public int b(byte[] bArr, int i2) throws IOException {
            int i3 = 0;
            int i4 = 0;
            while (i3 < i2 && (i4 = this.f16825a.read(bArr, i3, i2 - i3)) != -1) {
                i3 += i4;
            }
            if (i3 != 0 || i4 != -1) {
                return i3;
            }
            throw new Reader.EndOfFileException();
        }

        public short c() throws IOException {
            int read = this.f16825a.read();
            if (read != -1) {
                return (short) read;
            }
            throw new Reader.EndOfFileException();
        }

        public long skip(long j2) throws IOException {
            if (j2 < 0) {
                return 0;
            }
            long j3 = j2;
            while (j3 > 0) {
                long skip = this.f16825a.skip(j3);
                if (skip <= 0) {
                    if (this.f16825a.read() == -1) {
                        break;
                    }
                    skip = 1;
                }
                j3 -= skip;
            }
            return j2 - j3;
        }
    }

    private static int d(int i2, int i3) {
        return i2 + 2 + (i3 * 12);
    }

    private int e(Reader reader, ArrayPool arrayPool) throws IOException {
        byte[] bArr;
        try {
            int a2 = reader.a();
            if (!g(a2)) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Parser doesn't handle magic number: " + a2);
                }
                return -1;
            }
            int i2 = i(reader);
            if (i2 == -1) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Failed to parse exif segment length, or exif segment not found");
                }
                return -1;
            }
            bArr = (byte[]) arrayPool.c(i2, byte[].class);
            int k2 = k(reader, bArr, i2);
            arrayPool.put(bArr);
            return k2;
        } catch (Reader.EndOfFileException unused) {
            return -1;
        } catch (Throwable th) {
            arrayPool.put(bArr);
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003b, code lost:
        return com.bumptech.glide.load.ImageHeaderParser.ImageType.PNG;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0039 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.bumptech.glide.load.ImageHeaderParser.ImageType f(com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader r6) throws java.io.IOException {
        /*
            r5 = this;
            int r0 = r6.a()     // Catch:{ EndOfFileException -> 0x00a0 }
            r1 = 65496(0xffd8, float:9.178E-41)
            if (r0 != r1) goto L_0x000c
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.JPEG     // Catch:{ EndOfFileException -> 0x00a0 }
            return r6
        L_0x000c:
            int r0 = r0 << 8
            short r1 = r6.c()     // Catch:{ EndOfFileException -> 0x00a0 }
            r0 = r0 | r1
            r1 = 4671814(0x474946, float:6.546606E-39)
            if (r0 != r1) goto L_0x001b
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.GIF     // Catch:{ EndOfFileException -> 0x00a0 }
            return r6
        L_0x001b:
            int r0 = r0 << 8
            short r1 = r6.c()     // Catch:{ EndOfFileException -> 0x00a0 }
            r0 = r0 | r1
            r1 = -1991225785(0xffffffff89504e47, float:-2.5073895E-33)
            if (r0 != r1) goto L_0x003c
            r0 = 21
            r6.skip(r0)     // Catch:{ EndOfFileException -> 0x00a0 }
            short r6 = r6.c()     // Catch:{ EndOfFileException -> 0x0039 }
            r0 = 3
            if (r6 < r0) goto L_0x0036
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.PNG_A     // Catch:{ EndOfFileException -> 0x0039 }
            goto L_0x0038
        L_0x0036:
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.PNG     // Catch:{ EndOfFileException -> 0x0039 }
        L_0x0038:
            return r6
        L_0x0039:
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.PNG     // Catch:{ EndOfFileException -> 0x00a0 }
            return r6
        L_0x003c:
            r1 = 1380533830(0x52494646, float:2.16116855E11)
            if (r0 == r1) goto L_0x0044
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.UNKNOWN     // Catch:{ EndOfFileException -> 0x00a0 }
            return r6
        L_0x0044:
            r0 = 4
            r6.skip(r0)     // Catch:{ EndOfFileException -> 0x00a0 }
            int r2 = r6.a()     // Catch:{ EndOfFileException -> 0x00a0 }
            int r2 = r2 << 16
            int r3 = r6.a()     // Catch:{ EndOfFileException -> 0x00a0 }
            r2 = r2 | r3
            r3 = 1464156752(0x57454250, float:2.16888601E14)
            if (r2 == r3) goto L_0x005c
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.UNKNOWN     // Catch:{ EndOfFileException -> 0x00a0 }
            return r6
        L_0x005c:
            int r2 = r6.a()     // Catch:{ EndOfFileException -> 0x00a0 }
            int r2 = r2 << 16
            int r3 = r6.a()     // Catch:{ EndOfFileException -> 0x00a0 }
            r2 = r2 | r3
            r3 = r2 & -256(0xffffffffffffff00, float:NaN)
            r4 = 1448097792(0x56503800, float:5.7234734E13)
            if (r3 == r4) goto L_0x0071
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.UNKNOWN     // Catch:{ EndOfFileException -> 0x00a0 }
            return r6
        L_0x0071:
            r2 = r2 & 255(0xff, float:3.57E-43)
            r3 = 88
            if (r2 != r3) goto L_0x0088
            r6.skip(r0)     // Catch:{ EndOfFileException -> 0x00a0 }
            short r6 = r6.c()     // Catch:{ EndOfFileException -> 0x00a0 }
            r6 = r6 & 16
            if (r6 == 0) goto L_0x0085
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.WEBP_A     // Catch:{ EndOfFileException -> 0x00a0 }
            goto L_0x0087
        L_0x0085:
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.WEBP     // Catch:{ EndOfFileException -> 0x00a0 }
        L_0x0087:
            return r6
        L_0x0088:
            r3 = 76
            if (r2 != r3) goto L_0x009d
            r6.skip(r0)     // Catch:{ EndOfFileException -> 0x00a0 }
            short r6 = r6.c()     // Catch:{ EndOfFileException -> 0x00a0 }
            r6 = r6 & 8
            if (r6 == 0) goto L_0x009a
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.WEBP_A     // Catch:{ EndOfFileException -> 0x00a0 }
            goto L_0x009c
        L_0x009a:
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.WEBP     // Catch:{ EndOfFileException -> 0x00a0 }
        L_0x009c:
            return r6
        L_0x009d:
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.WEBP     // Catch:{ EndOfFileException -> 0x00a0 }
            return r6
        L_0x00a0:
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.UNKNOWN
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.f(com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser$Reader):com.bumptech.glide.load.ImageHeaderParser$ImageType");
    }

    private static boolean g(int i2) {
        return (i2 & 65496) == 65496 || i2 == 19789 || i2 == 18761;
    }

    private boolean h(byte[] bArr, int i2) {
        boolean z2;
        if (bArr == null || i2 <= f16821a.length) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2) {
            int i3 = 0;
            while (true) {
                byte[] bArr2 = f16821a;
                if (i3 >= bArr2.length) {
                    break;
                } else if (bArr[i3] != bArr2[i3]) {
                    return false;
                } else {
                    i3++;
                }
            }
        }
        return z2;
    }

    private int i(Reader reader) throws IOException {
        short c2;
        int a2;
        long j2;
        long skip;
        do {
            short c3 = reader.c();
            if (c3 != 255) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Unknown segmentId=" + c3);
                }
                return -1;
            }
            c2 = reader.c();
            if (c2 == 218) {
                return -1;
            }
            if (c2 == 217) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Found MARKER_EOI in exif segment");
                }
                return -1;
            }
            a2 = reader.a() - 2;
            if (c2 == 225) {
                return a2;
            }
            j2 = (long) a2;
            skip = reader.skip(j2);
        } while (skip == j2);
        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
            Log.d("DfltImageHeaderParser", "Unable to skip enough data, type: " + c2 + ", wanted to skip: " + a2 + ", but actually skipped: " + skip);
        }
        return -1;
    }

    private static int j(RandomAccessReader randomAccessReader) {
        ByteOrder byteOrder;
        short a2 = randomAccessReader.a(6);
        if (a2 == 18761) {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        } else if (a2 != 19789) {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Unknown endianness = " + a2);
            }
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else {
            byteOrder = ByteOrder.BIG_ENDIAN;
        }
        randomAccessReader.e(byteOrder);
        int b2 = randomAccessReader.b(10) + 6;
        short a3 = randomAccessReader.a(b2);
        for (int i2 = 0; i2 < a3; i2++) {
            int d2 = d(b2, i2);
            short a4 = randomAccessReader.a(d2);
            if (a4 == 274) {
                short a5 = randomAccessReader.a(d2 + 2);
                if (a5 >= 1 && a5 <= 12) {
                    int b3 = randomAccessReader.b(d2 + 4);
                    if (b3 >= 0) {
                        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            Log.d("DfltImageHeaderParser", "Got tagIndex=" + i2 + " tagType=" + a4 + " formatCode=" + a5 + " componentCount=" + b3);
                        }
                        int i3 = b3 + f16822b[a5];
                        if (i3 <= 4) {
                            int i4 = d2 + 8;
                            if (i4 < 0 || i4 > randomAccessReader.d()) {
                                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                    Log.d("DfltImageHeaderParser", "Illegal tagValueOffset=" + i4 + " tagType=" + a4);
                                }
                            } else if (i3 >= 0 && i3 + i4 <= randomAccessReader.d()) {
                                return randomAccessReader.a(i4);
                            } else {
                                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                    Log.d("DfltImageHeaderParser", "Illegal number of bytes for TI tag data tagType=" + a4);
                                }
                            }
                        } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            Log.d("DfltImageHeaderParser", "Got byte count > 4, not orientation, continuing, formatCode=" + a5);
                        }
                    } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                        Log.d("DfltImageHeaderParser", "Negative tiff component count");
                    }
                } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Got invalid format code = " + a5);
                }
            }
        }
        return -1;
    }

    private int k(Reader reader, byte[] bArr, int i2) throws IOException {
        int b2 = reader.b(bArr, i2);
        if (b2 != i2) {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Unable to read exif segment data, length: " + i2 + ", actually read: " + b2);
            }
            return -1;
        } else if (h(bArr, i2)) {
            return j(new RandomAccessReader(bArr, i2));
        } else {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Missing jpeg exif preamble");
            }
            return -1;
        }
    }

    public ImageHeaderParser.ImageType a(ByteBuffer byteBuffer) throws IOException {
        return f(new ByteBufferReader((ByteBuffer) Preconditions.d(byteBuffer)));
    }

    public ImageHeaderParser.ImageType b(InputStream inputStream) throws IOException {
        return f(new StreamReader((InputStream) Preconditions.d(inputStream)));
    }

    public int c(InputStream inputStream, ArrayPool arrayPool) throws IOException {
        return e(new StreamReader((InputStream) Preconditions.d(inputStream)), (ArrayPool) Preconditions.d(arrayPool));
    }
}
