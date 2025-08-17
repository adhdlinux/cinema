package androidx.exifinterface.media;

import android.content.res.AssetManager;
import android.system.OsConstants;
import android.util.Log;
import androidx.exifinterface.media.ExifInterfaceUtils;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imageutils.JfifUtil;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Pattern;
import java.util.zip.CRC32;

public class ExifInterface {
    static final byte[] A = {-1, -40, -1};
    private static final byte[] B = {102, 116, 121, 112};
    private static final byte[] C = {109, 105, 102, 49};
    private static final byte[] D = {104, 101, 105, 99};
    private static final byte[] E = {79, 76, 89, 77, 80, 0};
    private static final byte[] F = {79, 76, 89, 77, 80, 85, 83, 0, 73, 73};
    private static final byte[] G = {-119, 80, 78, 71, 13, 10, 26, 10};
    private static final byte[] H = {101, 88, 73, 102};
    private static final byte[] I = {73, 72, 68, 82};
    private static final byte[] J = {73, 69, 78, 68};
    private static final byte[] K = {82, 73, 70, 70};
    private static final byte[] L = {87, 69, 66, 80};
    private static final byte[] M = {69, 88, 73, 70};
    private static final byte[] N = {-99, 1, 42};
    private static final byte[] O = "VP8X".getBytes(Charset.defaultCharset());
    private static final byte[] P = "VP8L".getBytes(Charset.defaultCharset());
    private static final byte[] Q = "VP8 ".getBytes(Charset.defaultCharset());
    private static final byte[] R = "ANIM".getBytes(Charset.defaultCharset());
    private static final byte[] S = "ANMF".getBytes(Charset.defaultCharset());
    private static SimpleDateFormat T;
    private static SimpleDateFormat U;
    static final String[] V = {"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};
    static final int[] W = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
    static final byte[] X = {65, 83, 67, 73, 73, 0, 0, 0};
    private static final ExifTag[] Y;
    private static final ExifTag[] Z;

    /* renamed from: a0  reason: collision with root package name */
    private static final ExifTag[] f3177a0;

    /* renamed from: b0  reason: collision with root package name */
    private static final ExifTag[] f3178b0;

    /* renamed from: c0  reason: collision with root package name */
    private static final ExifTag[] f3179c0;

    /* renamed from: d0  reason: collision with root package name */
    private static final ExifTag f3180d0 = new ExifTag("StripOffsets", 273, 3);

    /* renamed from: e0  reason: collision with root package name */
    private static final ExifTag[] f3181e0;

    /* renamed from: f0  reason: collision with root package name */
    private static final ExifTag[] f3182f0;

    /* renamed from: g0  reason: collision with root package name */
    private static final ExifTag[] f3183g0;

    /* renamed from: h0  reason: collision with root package name */
    private static final ExifTag[] f3184h0;

    /* renamed from: i0  reason: collision with root package name */
    static final ExifTag[][] f3185i0;

    /* renamed from: j0  reason: collision with root package name */
    private static final ExifTag[] f3186j0 = {new ExifTag("SubIFDPointer", 330, 4), new ExifTag("ExifIFDPointer", 34665, 4), new ExifTag("GPSInfoIFDPointer", 34853, 4), new ExifTag("InteroperabilityIFDPointer", 40965, 4), new ExifTag("CameraSettingsIFDPointer", 8224, 1), new ExifTag("ImageProcessingIFDPointer", 8256, 1)};

    /* renamed from: k0  reason: collision with root package name */
    private static final HashMap<Integer, ExifTag>[] f3187k0;

    /* renamed from: l0  reason: collision with root package name */
    private static final HashMap<String, ExifTag>[] f3188l0;

    /* renamed from: m0  reason: collision with root package name */
    private static final HashSet<String> f3189m0 = new HashSet<>(Arrays.asList(new String[]{"FNumber", "DigitalZoomRatio", "ExposureTime", "SubjectDistance", "GPSTimeStamp"}));

    /* renamed from: n0  reason: collision with root package name */
    private static final HashMap<Integer, Integer> f3190n0 = new HashMap<>();

    /* renamed from: o0  reason: collision with root package name */
    static final Charset f3191o0;

    /* renamed from: p0  reason: collision with root package name */
    static final byte[] f3192p0;

    /* renamed from: q0  reason: collision with root package name */
    private static final byte[] f3193q0;

    /* renamed from: r0  reason: collision with root package name */
    private static final Pattern f3194r0 = Pattern.compile(".*[1-9].*");

    /* renamed from: s0  reason: collision with root package name */
    private static final Pattern f3195s0 = Pattern.compile("^(\\d{2}):(\\d{2}):(\\d{2})$");

    /* renamed from: t0  reason: collision with root package name */
    private static final Pattern f3196t0 = Pattern.compile("^(\\d{4}):(\\d{2}):(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");

    /* renamed from: u  reason: collision with root package name */
    private static final boolean f3197u = Log.isLoggable("ExifInterface", 3);

    /* renamed from: u0  reason: collision with root package name */
    private static final Pattern f3198u0 = Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");

    /* renamed from: v  reason: collision with root package name */
    private static final List<Integer> f3199v = Arrays.asList(new Integer[]{1, 6, 3, 8});

    /* renamed from: w  reason: collision with root package name */
    private static final List<Integer> f3200w = Arrays.asList(new Integer[]{2, 7, 4, 5});

    /* renamed from: x  reason: collision with root package name */
    public static final int[] f3201x = {8, 8, 8};

    /* renamed from: y  reason: collision with root package name */
    public static final int[] f3202y = {4};

    /* renamed from: z  reason: collision with root package name */
    public static final int[] f3203z = {8};

    /* renamed from: a  reason: collision with root package name */
    private String f3204a;

    /* renamed from: b  reason: collision with root package name */
    private FileDescriptor f3205b;

    /* renamed from: c  reason: collision with root package name */
    private AssetManager.AssetInputStream f3206c;

    /* renamed from: d  reason: collision with root package name */
    private int f3207d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f3208e;

    /* renamed from: f  reason: collision with root package name */
    private final HashMap<String, ExifAttribute>[] f3209f;

    /* renamed from: g  reason: collision with root package name */
    private Set<Integer> f3210g;

    /* renamed from: h  reason: collision with root package name */
    private ByteOrder f3211h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f3212i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f3213j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f3214k;

    /* renamed from: l  reason: collision with root package name */
    private int f3215l;

    /* renamed from: m  reason: collision with root package name */
    private int f3216m;

    /* renamed from: n  reason: collision with root package name */
    private byte[] f3217n;

    /* renamed from: o  reason: collision with root package name */
    private int f3218o;

    /* renamed from: p  reason: collision with root package name */
    private int f3219p;

    /* renamed from: q  reason: collision with root package name */
    private int f3220q;

    /* renamed from: r  reason: collision with root package name */
    private int f3221r;

    /* renamed from: s  reason: collision with root package name */
    private int f3222s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f3223t;

    private static class ByteOrderedDataInputStream extends InputStream implements DataInput {

        /* renamed from: f  reason: collision with root package name */
        private static final ByteOrder f3227f = ByteOrder.LITTLE_ENDIAN;

        /* renamed from: g  reason: collision with root package name */
        private static final ByteOrder f3228g = ByteOrder.BIG_ENDIAN;

        /* renamed from: b  reason: collision with root package name */
        final DataInputStream f3229b;

        /* renamed from: c  reason: collision with root package name */
        private ByteOrder f3230c;

        /* renamed from: d  reason: collision with root package name */
        int f3231d;

        /* renamed from: e  reason: collision with root package name */
        private byte[] f3232e;

        ByteOrderedDataInputStream(byte[] bArr) throws IOException {
            this(new ByteArrayInputStream(bArr), ByteOrder.BIG_ENDIAN);
        }

        public int a() {
            return this.f3231d;
        }

        public int available() throws IOException {
            return this.f3229b.available();
        }

        public long f() throws IOException {
            return ((long) readInt()) & 4294967295L;
        }

        public void i(ByteOrder byteOrder) {
            this.f3230c = byteOrder;
        }

        public void k(int i2) throws IOException {
            int i3 = 0;
            while (i3 < i2) {
                int i4 = i2 - i3;
                int skip = (int) this.f3229b.skip((long) i4);
                if (skip <= 0) {
                    if (this.f3232e == null) {
                        this.f3232e = new byte[8192];
                    }
                    skip = this.f3229b.read(this.f3232e, 0, Math.min(8192, i4));
                    if (skip == -1) {
                        throw new EOFException("Reached EOF while skipping " + i2 + " bytes.");
                    }
                }
                i3 += skip;
            }
            this.f3231d += i3;
        }

        public void mark(int i2) {
            throw new UnsupportedOperationException("Mark is currently unsupported");
        }

        public int read() throws IOException {
            this.f3231d++;
            return this.f3229b.read();
        }

        public boolean readBoolean() throws IOException {
            this.f3231d++;
            return this.f3229b.readBoolean();
        }

        public byte readByte() throws IOException {
            this.f3231d++;
            int read = this.f3229b.read();
            if (read >= 0) {
                return (byte) read;
            }
            throw new EOFException();
        }

        public char readChar() throws IOException {
            this.f3231d += 2;
            return this.f3229b.readChar();
        }

        public double readDouble() throws IOException {
            return Double.longBitsToDouble(readLong());
        }

        public float readFloat() throws IOException {
            return Float.intBitsToFloat(readInt());
        }

        public void readFully(byte[] bArr, int i2, int i3) throws IOException {
            this.f3231d += i3;
            this.f3229b.readFully(bArr, i2, i3);
        }

        public int readInt() throws IOException {
            this.f3231d += 4;
            int read = this.f3229b.read();
            int read2 = this.f3229b.read();
            int read3 = this.f3229b.read();
            int read4 = this.f3229b.read();
            if ((read | read2 | read3 | read4) >= 0) {
                ByteOrder byteOrder = this.f3230c;
                if (byteOrder == f3227f) {
                    return (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
                }
                if (byteOrder == f3228g) {
                    return (read << 24) + (read2 << 16) + (read3 << 8) + read4;
                }
                throw new IOException("Invalid byte order: " + this.f3230c);
            }
            throw new EOFException();
        }

        public String readLine() throws IOException {
            Log.d("ExifInterface", "Currently unsupported");
            return null;
        }

        public long readLong() throws IOException {
            this.f3231d += 8;
            int read = this.f3229b.read();
            int read2 = this.f3229b.read();
            int read3 = this.f3229b.read();
            int read4 = this.f3229b.read();
            int read5 = this.f3229b.read();
            int read6 = this.f3229b.read();
            int read7 = this.f3229b.read();
            int read8 = this.f3229b.read();
            if ((read | read2 | read3 | read4 | read5 | read6 | read7 | read8) >= 0) {
                ByteOrder byteOrder = this.f3230c;
                if (byteOrder == f3227f) {
                    return (((long) read8) << 56) + (((long) read7) << 48) + (((long) read6) << 40) + (((long) read5) << 32) + (((long) read4) << 24) + (((long) read3) << 16) + (((long) read2) << 8) + ((long) read);
                }
                int i2 = read2;
                if (byteOrder == f3228g) {
                    return (((long) read) << 56) + (((long) i2) << 48) + (((long) read3) << 40) + (((long) read4) << 32) + (((long) read5) << 24) + (((long) read6) << 16) + (((long) read7) << 8) + ((long) read8);
                }
                throw new IOException("Invalid byte order: " + this.f3230c);
            }
            throw new EOFException();
        }

        public short readShort() throws IOException {
            this.f3231d += 2;
            int read = this.f3229b.read();
            int read2 = this.f3229b.read();
            if ((read | read2) >= 0) {
                ByteOrder byteOrder = this.f3230c;
                if (byteOrder == f3227f) {
                    return (short) ((read2 << 8) + read);
                }
                if (byteOrder == f3228g) {
                    return (short) ((read << 8) + read2);
                }
                throw new IOException("Invalid byte order: " + this.f3230c);
            }
            throw new EOFException();
        }

        public String readUTF() throws IOException {
            this.f3231d += 2;
            return this.f3229b.readUTF();
        }

        public int readUnsignedByte() throws IOException {
            this.f3231d++;
            return this.f3229b.readUnsignedByte();
        }

        public int readUnsignedShort() throws IOException {
            this.f3231d += 2;
            int read = this.f3229b.read();
            int read2 = this.f3229b.read();
            if ((read | read2) >= 0) {
                ByteOrder byteOrder = this.f3230c;
                if (byteOrder == f3227f) {
                    return (read2 << 8) + read;
                }
                if (byteOrder == f3228g) {
                    return (read << 8) + read2;
                }
                throw new IOException("Invalid byte order: " + this.f3230c);
            }
            throw new EOFException();
        }

        public void reset() {
            throw new UnsupportedOperationException("Reset is currently unsupported");
        }

        public int skipBytes(int i2) throws IOException {
            throw new UnsupportedOperationException("skipBytes is currently unsupported");
        }

        ByteOrderedDataInputStream(InputStream inputStream) throws IOException {
            this(inputStream, ByteOrder.BIG_ENDIAN);
        }

        ByteOrderedDataInputStream(InputStream inputStream, ByteOrder byteOrder) throws IOException {
            this.f3230c = ByteOrder.BIG_ENDIAN;
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            this.f3229b = dataInputStream;
            dataInputStream.mark(0);
            this.f3231d = 0;
            this.f3230c = byteOrder;
        }

        public int read(byte[] bArr, int i2, int i3) throws IOException {
            int read = this.f3229b.read(bArr, i2, i3);
            this.f3231d += read;
            return read;
        }

        public void readFully(byte[] bArr) throws IOException {
            this.f3231d += bArr.length;
            this.f3229b.readFully(bArr);
        }
    }

    private static class ExifAttribute {

        /* renamed from: a  reason: collision with root package name */
        public final int f3233a;

        /* renamed from: b  reason: collision with root package name */
        public final int f3234b;

        /* renamed from: c  reason: collision with root package name */
        public final long f3235c;

        /* renamed from: d  reason: collision with root package name */
        public final byte[] f3236d;

        ExifAttribute(int i2, int i3, byte[] bArr) {
            this(i2, i3, -1, bArr);
        }

        public static ExifAttribute a(String str) {
            byte[] bytes = (str + 0).getBytes(ExifInterface.f3191o0);
            return new ExifAttribute(2, bytes.length, bytes);
        }

        public static ExifAttribute b(long j2, ByteOrder byteOrder) {
            return c(new long[]{j2}, byteOrder);
        }

        public static ExifAttribute c(long[] jArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(ExifInterface.W[4] * jArr.length)]);
            wrap.order(byteOrder);
            for (long j2 : jArr) {
                wrap.putInt((int) j2);
            }
            return new ExifAttribute(4, jArr.length, wrap.array());
        }

        public static ExifAttribute d(Rational rational, ByteOrder byteOrder) {
            return e(new Rational[]{rational}, byteOrder);
        }

        public static ExifAttribute e(Rational[] rationalArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(ExifInterface.W[5] * rationalArr.length)]);
            wrap.order(byteOrder);
            for (Rational rational : rationalArr) {
                wrap.putInt((int) rational.f3241a);
                wrap.putInt((int) rational.f3242b);
            }
            return new ExifAttribute(5, rationalArr.length, wrap.array());
        }

        public static ExifAttribute f(int i2, ByteOrder byteOrder) {
            return g(new int[]{i2}, byteOrder);
        }

        public static ExifAttribute g(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(ExifInterface.W[3] * iArr.length)]);
            wrap.order(byteOrder);
            for (int i2 : iArr) {
                wrap.putShort((short) i2);
            }
            return new ExifAttribute(3, iArr.length, wrap.array());
        }

        public double h(ByteOrder byteOrder) {
            Object k2 = k(byteOrder);
            if (k2 == null) {
                throw new NumberFormatException("NULL can't be converted to a double value");
            } else if (k2 instanceof String) {
                return Double.parseDouble((String) k2);
            } else {
                if (k2 instanceof long[]) {
                    long[] jArr = (long[]) k2;
                    if (jArr.length == 1) {
                        return (double) jArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (k2 instanceof int[]) {
                    int[] iArr = (int[]) k2;
                    if (iArr.length == 1) {
                        return (double) iArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (k2 instanceof double[]) {
                    double[] dArr = (double[]) k2;
                    if (dArr.length == 1) {
                        return dArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (k2 instanceof Rational[]) {
                    Rational[] rationalArr = (Rational[]) k2;
                    if (rationalArr.length == 1) {
                        return rationalArr[0].a();
                    }
                    throw new NumberFormatException("There are more than one component");
                } else {
                    throw new NumberFormatException("Couldn't find a double value");
                }
            }
        }

        public int i(ByteOrder byteOrder) {
            Object k2 = k(byteOrder);
            if (k2 == null) {
                throw new NumberFormatException("NULL can't be converted to a integer value");
            } else if (k2 instanceof String) {
                return Integer.parseInt((String) k2);
            } else {
                if (k2 instanceof long[]) {
                    long[] jArr = (long[]) k2;
                    if (jArr.length == 1) {
                        return (int) jArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (k2 instanceof int[]) {
                    int[] iArr = (int[]) k2;
                    if (iArr.length == 1) {
                        return iArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else {
                    throw new NumberFormatException("Couldn't find a integer value");
                }
            }
        }

        public String j(ByteOrder byteOrder) {
            Object k2 = k(byteOrder);
            if (k2 == null) {
                return null;
            }
            if (k2 instanceof String) {
                return (String) k2;
            }
            StringBuilder sb = new StringBuilder();
            int i2 = 0;
            if (k2 instanceof long[]) {
                long[] jArr = (long[]) k2;
                while (i2 < jArr.length) {
                    sb.append(jArr[i2]);
                    i2++;
                    if (i2 != jArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            } else if (k2 instanceof int[]) {
                int[] iArr = (int[]) k2;
                while (i2 < iArr.length) {
                    sb.append(iArr[i2]);
                    i2++;
                    if (i2 != iArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            } else if (k2 instanceof double[]) {
                double[] dArr = (double[]) k2;
                while (i2 < dArr.length) {
                    sb.append(dArr[i2]);
                    i2++;
                    if (i2 != dArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            } else if (!(k2 instanceof Rational[])) {
                return null;
            } else {
                Rational[] rationalArr = (Rational[]) k2;
                while (i2 < rationalArr.length) {
                    sb.append(rationalArr[i2].f3241a);
                    sb.append('/');
                    sb.append(rationalArr[i2].f3242b);
                    i2++;
                    if (i2 != rationalArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:163:0x019b A[SYNTHETIC, Splitter:B:163:0x019b] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Object k(java.nio.ByteOrder r11) {
            /*
                r10 = this;
                java.lang.String r0 = "IOException occurred while closing InputStream"
                java.lang.String r1 = "ExifInterface"
                r2 = 0
                androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream r3 = new androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream     // Catch:{ IOException -> 0x0185, all -> 0x0183 }
                byte[] r4 = r10.f3236d     // Catch:{ IOException -> 0x0185, all -> 0x0183 }
                r3.<init>((byte[]) r4)     // Catch:{ IOException -> 0x0185, all -> 0x0183 }
                r3.i(r11)     // Catch:{ IOException -> 0x0181 }
                int r11 = r10.f3233a     // Catch:{ IOException -> 0x0181 }
                r4 = 0
                r5 = 1
                switch(r11) {
                    case 1: goto L_0x0148;
                    case 2: goto L_0x00fd;
                    case 3: goto L_0x00e3;
                    case 4: goto L_0x00c9;
                    case 5: goto L_0x00a6;
                    case 6: goto L_0x0148;
                    case 7: goto L_0x00fd;
                    case 8: goto L_0x008c;
                    case 9: goto L_0x0072;
                    case 10: goto L_0x004d;
                    case 11: goto L_0x0032;
                    case 12: goto L_0x0018;
                    default: goto L_0x0016;
                }     // Catch:{ IOException -> 0x0181 }
            L_0x0016:
                goto L_0x0178
            L_0x0018:
                int r11 = r10.f3234b     // Catch:{ IOException -> 0x0181 }
                double[] r11 = new double[r11]     // Catch:{ IOException -> 0x0181 }
            L_0x001c:
                int r5 = r10.f3234b     // Catch:{ IOException -> 0x0181 }
                if (r4 >= r5) goto L_0x0029
                double r5 = r3.readDouble()     // Catch:{ IOException -> 0x0181 }
                r11[r4] = r5     // Catch:{ IOException -> 0x0181 }
                int r4 = r4 + 1
                goto L_0x001c
            L_0x0029:
                r3.close()     // Catch:{ IOException -> 0x002d }
                goto L_0x0031
            L_0x002d:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x0031:
                return r11
            L_0x0032:
                int r11 = r10.f3234b     // Catch:{ IOException -> 0x0181 }
                double[] r11 = new double[r11]     // Catch:{ IOException -> 0x0181 }
            L_0x0036:
                int r5 = r10.f3234b     // Catch:{ IOException -> 0x0181 }
                if (r4 >= r5) goto L_0x0044
                float r5 = r3.readFloat()     // Catch:{ IOException -> 0x0181 }
                double r5 = (double) r5     // Catch:{ IOException -> 0x0181 }
                r11[r4] = r5     // Catch:{ IOException -> 0x0181 }
                int r4 = r4 + 1
                goto L_0x0036
            L_0x0044:
                r3.close()     // Catch:{ IOException -> 0x0048 }
                goto L_0x004c
            L_0x0048:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x004c:
                return r11
            L_0x004d:
                int r11 = r10.f3234b     // Catch:{ IOException -> 0x0181 }
                androidx.exifinterface.media.ExifInterface$Rational[] r11 = new androidx.exifinterface.media.ExifInterface.Rational[r11]     // Catch:{ IOException -> 0x0181 }
            L_0x0051:
                int r5 = r10.f3234b     // Catch:{ IOException -> 0x0181 }
                if (r4 >= r5) goto L_0x0069
                int r5 = r3.readInt()     // Catch:{ IOException -> 0x0181 }
                long r5 = (long) r5     // Catch:{ IOException -> 0x0181 }
                int r7 = r3.readInt()     // Catch:{ IOException -> 0x0181 }
                long r7 = (long) r7     // Catch:{ IOException -> 0x0181 }
                androidx.exifinterface.media.ExifInterface$Rational r9 = new androidx.exifinterface.media.ExifInterface$Rational     // Catch:{ IOException -> 0x0181 }
                r9.<init>(r5, r7)     // Catch:{ IOException -> 0x0181 }
                r11[r4] = r9     // Catch:{ IOException -> 0x0181 }
                int r4 = r4 + 1
                goto L_0x0051
            L_0x0069:
                r3.close()     // Catch:{ IOException -> 0x006d }
                goto L_0x0071
            L_0x006d:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x0071:
                return r11
            L_0x0072:
                int r11 = r10.f3234b     // Catch:{ IOException -> 0x0181 }
                int[] r11 = new int[r11]     // Catch:{ IOException -> 0x0181 }
            L_0x0076:
                int r5 = r10.f3234b     // Catch:{ IOException -> 0x0181 }
                if (r4 >= r5) goto L_0x0083
                int r5 = r3.readInt()     // Catch:{ IOException -> 0x0181 }
                r11[r4] = r5     // Catch:{ IOException -> 0x0181 }
                int r4 = r4 + 1
                goto L_0x0076
            L_0x0083:
                r3.close()     // Catch:{ IOException -> 0x0087 }
                goto L_0x008b
            L_0x0087:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x008b:
                return r11
            L_0x008c:
                int r11 = r10.f3234b     // Catch:{ IOException -> 0x0181 }
                int[] r11 = new int[r11]     // Catch:{ IOException -> 0x0181 }
            L_0x0090:
                int r5 = r10.f3234b     // Catch:{ IOException -> 0x0181 }
                if (r4 >= r5) goto L_0x009d
                short r5 = r3.readShort()     // Catch:{ IOException -> 0x0181 }
                r11[r4] = r5     // Catch:{ IOException -> 0x0181 }
                int r4 = r4 + 1
                goto L_0x0090
            L_0x009d:
                r3.close()     // Catch:{ IOException -> 0x00a1 }
                goto L_0x00a5
            L_0x00a1:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x00a5:
                return r11
            L_0x00a6:
                int r11 = r10.f3234b     // Catch:{ IOException -> 0x0181 }
                androidx.exifinterface.media.ExifInterface$Rational[] r11 = new androidx.exifinterface.media.ExifInterface.Rational[r11]     // Catch:{ IOException -> 0x0181 }
            L_0x00aa:
                int r5 = r10.f3234b     // Catch:{ IOException -> 0x0181 }
                if (r4 >= r5) goto L_0x00c0
                long r5 = r3.f()     // Catch:{ IOException -> 0x0181 }
                long r7 = r3.f()     // Catch:{ IOException -> 0x0181 }
                androidx.exifinterface.media.ExifInterface$Rational r9 = new androidx.exifinterface.media.ExifInterface$Rational     // Catch:{ IOException -> 0x0181 }
                r9.<init>(r5, r7)     // Catch:{ IOException -> 0x0181 }
                r11[r4] = r9     // Catch:{ IOException -> 0x0181 }
                int r4 = r4 + 1
                goto L_0x00aa
            L_0x00c0:
                r3.close()     // Catch:{ IOException -> 0x00c4 }
                goto L_0x00c8
            L_0x00c4:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x00c8:
                return r11
            L_0x00c9:
                int r11 = r10.f3234b     // Catch:{ IOException -> 0x0181 }
                long[] r11 = new long[r11]     // Catch:{ IOException -> 0x0181 }
            L_0x00cd:
                int r5 = r10.f3234b     // Catch:{ IOException -> 0x0181 }
                if (r4 >= r5) goto L_0x00da
                long r5 = r3.f()     // Catch:{ IOException -> 0x0181 }
                r11[r4] = r5     // Catch:{ IOException -> 0x0181 }
                int r4 = r4 + 1
                goto L_0x00cd
            L_0x00da:
                r3.close()     // Catch:{ IOException -> 0x00de }
                goto L_0x00e2
            L_0x00de:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x00e2:
                return r11
            L_0x00e3:
                int r11 = r10.f3234b     // Catch:{ IOException -> 0x0181 }
                int[] r11 = new int[r11]     // Catch:{ IOException -> 0x0181 }
            L_0x00e7:
                int r5 = r10.f3234b     // Catch:{ IOException -> 0x0181 }
                if (r4 >= r5) goto L_0x00f4
                int r5 = r3.readUnsignedShort()     // Catch:{ IOException -> 0x0181 }
                r11[r4] = r5     // Catch:{ IOException -> 0x0181 }
                int r4 = r4 + 1
                goto L_0x00e7
            L_0x00f4:
                r3.close()     // Catch:{ IOException -> 0x00f8 }
                goto L_0x00fc
            L_0x00f8:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x00fc:
                return r11
            L_0x00fd:
                int r11 = r10.f3234b     // Catch:{ IOException -> 0x0181 }
                byte[] r6 = androidx.exifinterface.media.ExifInterface.X     // Catch:{ IOException -> 0x0181 }
                int r6 = r6.length     // Catch:{ IOException -> 0x0181 }
                if (r11 < r6) goto L_0x011a
                r11 = 0
            L_0x0105:
                byte[] r6 = androidx.exifinterface.media.ExifInterface.X     // Catch:{ IOException -> 0x0181 }
                int r7 = r6.length     // Catch:{ IOException -> 0x0181 }
                if (r11 >= r7) goto L_0x0117
                byte[] r7 = r10.f3236d     // Catch:{ IOException -> 0x0181 }
                byte r7 = r7[r11]     // Catch:{ IOException -> 0x0181 }
                byte r8 = r6[r11]     // Catch:{ IOException -> 0x0181 }
                if (r7 == r8) goto L_0x0114
                r5 = 0
                goto L_0x0117
            L_0x0114:
                int r11 = r11 + 1
                goto L_0x0105
            L_0x0117:
                if (r5 == 0) goto L_0x011a
                int r4 = r6.length     // Catch:{ IOException -> 0x0181 }
            L_0x011a:
                java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0181 }
                r11.<init>()     // Catch:{ IOException -> 0x0181 }
            L_0x011f:
                int r5 = r10.f3234b     // Catch:{ IOException -> 0x0181 }
                if (r4 >= r5) goto L_0x013b
                byte[] r5 = r10.f3236d     // Catch:{ IOException -> 0x0181 }
                byte r5 = r5[r4]     // Catch:{ IOException -> 0x0181 }
                if (r5 != 0) goto L_0x012a
                goto L_0x013b
            L_0x012a:
                r6 = 32
                if (r5 < r6) goto L_0x0133
                char r5 = (char) r5     // Catch:{ IOException -> 0x0181 }
                r11.append(r5)     // Catch:{ IOException -> 0x0181 }
                goto L_0x0138
            L_0x0133:
                r5 = 63
                r11.append(r5)     // Catch:{ IOException -> 0x0181 }
            L_0x0138:
                int r4 = r4 + 1
                goto L_0x011f
            L_0x013b:
                java.lang.String r11 = r11.toString()     // Catch:{ IOException -> 0x0181 }
                r3.close()     // Catch:{ IOException -> 0x0143 }
                goto L_0x0147
            L_0x0143:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x0147:
                return r11
            L_0x0148:
                byte[] r11 = r10.f3236d     // Catch:{ IOException -> 0x0181 }
                int r6 = r11.length     // Catch:{ IOException -> 0x0181 }
                if (r6 != r5) goto L_0x0168
                byte r6 = r11[r4]     // Catch:{ IOException -> 0x0181 }
                if (r6 < 0) goto L_0x0168
                if (r6 > r5) goto L_0x0168
                java.lang.String r11 = new java.lang.String     // Catch:{ IOException -> 0x0181 }
                char[] r5 = new char[r5]     // Catch:{ IOException -> 0x0181 }
                int r6 = r6 + 48
                char r6 = (char) r6     // Catch:{ IOException -> 0x0181 }
                r5[r4] = r6     // Catch:{ IOException -> 0x0181 }
                r11.<init>(r5)     // Catch:{ IOException -> 0x0181 }
                r3.close()     // Catch:{ IOException -> 0x0163 }
                goto L_0x0167
            L_0x0163:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x0167:
                return r11
            L_0x0168:
                java.lang.String r4 = new java.lang.String     // Catch:{ IOException -> 0x0181 }
                java.nio.charset.Charset r5 = androidx.exifinterface.media.ExifInterface.f3191o0     // Catch:{ IOException -> 0x0181 }
                r4.<init>(r11, r5)     // Catch:{ IOException -> 0x0181 }
                r3.close()     // Catch:{ IOException -> 0x0173 }
                goto L_0x0177
            L_0x0173:
                r11 = move-exception
                android.util.Log.e(r1, r0, r11)
            L_0x0177:
                return r4
            L_0x0178:
                r3.close()     // Catch:{ IOException -> 0x017c }
                goto L_0x0180
            L_0x017c:
                r11 = move-exception
                android.util.Log.e(r1, r0, r11)
            L_0x0180:
                return r2
            L_0x0181:
                r11 = move-exception
                goto L_0x0187
            L_0x0183:
                r11 = move-exception
                goto L_0x0199
            L_0x0185:
                r11 = move-exception
                r3 = r2
            L_0x0187:
                java.lang.String r4 = "IOException occurred during reading a value"
                android.util.Log.w(r1, r4, r11)     // Catch:{ all -> 0x0197 }
                if (r3 == 0) goto L_0x0196
                r3.close()     // Catch:{ IOException -> 0x0192 }
                goto L_0x0196
            L_0x0192:
                r11 = move-exception
                android.util.Log.e(r1, r0, r11)
            L_0x0196:
                return r2
            L_0x0197:
                r11 = move-exception
                r2 = r3
            L_0x0199:
                if (r2 == 0) goto L_0x01a3
                r2.close()     // Catch:{ IOException -> 0x019f }
                goto L_0x01a3
            L_0x019f:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x01a3:
                throw r11
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.ExifAttribute.k(java.nio.ByteOrder):java.lang.Object");
        }

        public String toString() {
            return "(" + ExifInterface.V[this.f3233a] + ", data length:" + this.f3236d.length + ")";
        }

        ExifAttribute(int i2, int i3, long j2, byte[] bArr) {
            this.f3233a = i2;
            this.f3234b = i3;
            this.f3235c = j2;
            this.f3236d = bArr;
        }
    }

    private static class Rational {

        /* renamed from: a  reason: collision with root package name */
        public final long f3241a;

        /* renamed from: b  reason: collision with root package name */
        public final long f3242b;

        Rational(long j2, long j3) {
            if (j3 == 0) {
                this.f3241a = 0;
                this.f3242b = 1;
                return;
            }
            this.f3241a = j2;
            this.f3242b = j3;
        }

        public double a() {
            return ((double) this.f3241a) / ((double) this.f3242b);
        }

        public String toString() {
            return this.f3241a + "/" + this.f3242b;
        }
    }

    static {
        ExifTag[] exifTagArr = {new ExifTag("NewSubfileType", 254, 4), new ExifTag("SubfileType", JfifUtil.MARKER_FIRST_BYTE, 4), new ExifTag("ImageWidth", UserVerificationMethods.USER_VERIFY_HANDPRINT, 3, 4), new ExifTag("ImageLength", 257, 3, 4), new ExifTag("BitsPerSample", 258, 3), new ExifTag("Compression", 259, 3), new ExifTag("PhotometricInterpretation", 262, 3), new ExifTag("ImageDescription", RotationOptions.ROTATE_270, 2), new ExifTag("Make", 271, 2), new ExifTag("Model", 272, 2), new ExifTag("StripOffsets", 273, 3, 4), new ExifTag("Orientation", TiffUtil.TIFF_TAG_ORIENTATION, 3), new ExifTag("SamplesPerPixel", 277, 3), new ExifTag("RowsPerStrip", 278, 3, 4), new ExifTag("StripByteCounts", 279, 3, 4), new ExifTag("XResolution", 282, 5), new ExifTag("YResolution", 283, 5), new ExifTag("PlanarConfiguration", 284, 3), new ExifTag("ResolutionUnit", 296, 3), new ExifTag("TransferFunction", 301, 3), new ExifTag("Software", Sdk$SDKError.Reason.MRAID_BRIDGE_ERROR_VALUE, 2), new ExifTag("DateTime", 306, 2), new ExifTag("Artist", 315, 2), new ExifTag("WhitePoint", Sdk$SDKError.Reason.AD_CLOSED_MISSING_HEARTBEAT_VALUE, 5), new ExifTag("PrimaryChromaticities", Sdk$SDKError.Reason.SILENT_MODE_MONITOR_ERROR_VALUE, 5), new ExifTag("SubIFDPointer", 330, 4), new ExifTag("JPEGInterchangeFormat", 513, 4), new ExifTag("JPEGInterchangeFormatLength", 514, 4), new ExifTag("YCbCrCoefficients", 529, 5), new ExifTag("YCbCrSubSampling", 530, 3), new ExifTag("YCbCrPositioning", 531, 3), new ExifTag("ReferenceBlackWhite", 532, 5), new ExifTag("Copyright", 33432, 2), new ExifTag("ExifIFDPointer", 34665, 4), new ExifTag("GPSInfoIFDPointer", 34853, 4), new ExifTag("SensorTopBorder", 4, 4), new ExifTag("SensorLeftBorder", 5, 4), new ExifTag("SensorBottomBorder", 6, 4), new ExifTag("SensorRightBorder", 7, 4), new ExifTag("ISO", 23, 3), new ExifTag("JpgFromRaw", 46, 7), new ExifTag("Xmp", TypefaceStyle.BOLD, 1)};
        Y = exifTagArr;
        ExifTag[] exifTagArr2 = {new ExifTag("ExposureTime", 33434, 5), new ExifTag("FNumber", 33437, 5), new ExifTag("ExposureProgram", 34850, 3), new ExifTag("SpectralSensitivity", 34852, 2), new ExifTag("PhotographicSensitivity", 34855, 3), new ExifTag("OECF", 34856, 7), new ExifTag("SensitivityType", 34864, 3), new ExifTag("StandardOutputSensitivity", 34865, 4), new ExifTag("RecommendedExposureIndex", 34866, 4), new ExifTag("ISOSpeed", 34867, 4), new ExifTag("ISOSpeedLatitudeyyy", 34868, 4), new ExifTag("ISOSpeedLatitudezzz", 34869, 4), new ExifTag("ExifVersion", 36864, 2), new ExifTag("DateTimeOriginal", 36867, 2), new ExifTag("DateTimeDigitized", 36868, 2), new ExifTag("OffsetTime", 36880, 2), new ExifTag("OffsetTimeOriginal", 36881, 2), new ExifTag("OffsetTimeDigitized", 36882, 2), new ExifTag("ComponentsConfiguration", 37121, 7), new ExifTag("CompressedBitsPerPixel", 37122, 5), new ExifTag("ShutterSpeedValue", 37377, 10), new ExifTag("ApertureValue", 37378, 5), new ExifTag("BrightnessValue", 37379, 10), new ExifTag("ExposureBiasValue", 37380, 10), new ExifTag("MaxApertureValue", 37381, 5), new ExifTag("SubjectDistance", 37382, 5), new ExifTag("MeteringMode", 37383, 3), new ExifTag("LightSource", 37384, 3), new ExifTag("Flash", 37385, 3), new ExifTag("FocalLength", 37386, 5), new ExifTag("SubjectArea", 37396, 3), new ExifTag("MakerNote", 37500, 7), new ExifTag("UserComment", 37510, 7), new ExifTag("SubSecTime", 37520, 2), new ExifTag("SubSecTimeOriginal", 37521, 2), new ExifTag("SubSecTimeDigitized", 37522, 2), new ExifTag("FlashpixVersion", 40960, 7), new ExifTag("ColorSpace", 40961, 3), new ExifTag("PixelXDimension", 40962, 3, 4), new ExifTag("PixelYDimension", 40963, 3, 4), new ExifTag("RelatedSoundFile", 40964, 2), new ExifTag("InteroperabilityIFDPointer", 40965, 4), new ExifTag("FlashEnergy", 41483, 5), new ExifTag("SpatialFrequencyResponse", 41484, 7), new ExifTag("FocalPlaneXResolution", 41486, 5), new ExifTag("FocalPlaneYResolution", 41487, 5), new ExifTag("FocalPlaneResolutionUnit", 41488, 3), new ExifTag("SubjectLocation", 41492, 3), new ExifTag("ExposureIndex", 41493, 5), new ExifTag("SensingMethod", 41495, 3), new ExifTag("FileSource", 41728, 7), new ExifTag("SceneType", 41729, 7), new ExifTag("CFAPattern", 41730, 7), new ExifTag("CustomRendered", 41985, 3), new ExifTag("ExposureMode", 41986, 3), new ExifTag("WhiteBalance", 41987, 3), new ExifTag("DigitalZoomRatio", 41988, 5), new ExifTag("FocalLengthIn35mmFilm", 41989, 3), new ExifTag("SceneCaptureType", 41990, 3), new ExifTag("GainControl", 41991, 3), new ExifTag("Contrast", 41992, 3), new ExifTag("Saturation", 41993, 3), new ExifTag("Sharpness", 41994, 3), new ExifTag("DeviceSettingDescription", 41995, 7), new ExifTag("SubjectDistanceRange", 41996, 3), new ExifTag("ImageUniqueID", 42016, 2), new ExifTag("CameraOwnerName", 42032, 2), new ExifTag("BodySerialNumber", 42033, 2), new ExifTag("LensSpecification", 42034, 5), new ExifTag("LensMake", 42035, 2), new ExifTag("LensModel", 42036, 2), new ExifTag("Gamma", 42240, 5), new ExifTag("DNGVersion", 50706, 1), new ExifTag("DefaultCropSize", 50720, 3, 4)};
        Z = exifTagArr2;
        ExifTag[] exifTagArr3 = {new ExifTag("GPSVersionID", 0, 1), new ExifTag("GPSLatitudeRef", 1, 2), new ExifTag("GPSLatitude", 2, 5, 10), new ExifTag("GPSLongitudeRef", 3, 2), new ExifTag("GPSLongitude", 4, 5, 10), new ExifTag("GPSAltitudeRef", 5, 1), new ExifTag("GPSAltitude", 6, 5), new ExifTag("GPSTimeStamp", 7, 5), new ExifTag("GPSSatellites", 8, 2), new ExifTag("GPSStatus", 9, 2), new ExifTag("GPSMeasureMode", 10, 2), new ExifTag("GPSDOP", 11, 5), new ExifTag("GPSSpeedRef", 12, 2), new ExifTag("GPSSpeed", 13, 5), new ExifTag("GPSTrackRef", 14, 2), new ExifTag("GPSTrack", 15, 5), new ExifTag("GPSImgDirectionRef", 16, 2), new ExifTag("GPSImgDirection", 17, 5), new ExifTag("GPSMapDatum", 18, 2), new ExifTag("GPSDestLatitudeRef", 19, 2), new ExifTag("GPSDestLatitude", 20, 5), new ExifTag("GPSDestLongitudeRef", 21, 2), new ExifTag("GPSDestLongitude", 22, 5), new ExifTag("GPSDestBearingRef", 23, 2), new ExifTag("GPSDestBearing", 24, 5), new ExifTag("GPSDestDistanceRef", 25, 2), new ExifTag("GPSDestDistance", 26, 5), new ExifTag("GPSProcessingMethod", 27, 7), new ExifTag("GPSAreaInformation", 28, 7), new ExifTag("GPSDateStamp", 29, 2), new ExifTag("GPSDifferential", 30, 3), new ExifTag("GPSHPositioningError", 31, 5)};
        f3177a0 = exifTagArr3;
        ExifTag[] exifTagArr4 = {new ExifTag("InteroperabilityIndex", 1, 2)};
        f3178b0 = exifTagArr4;
        ExifTag[] exifTagArr5 = {new ExifTag("NewSubfileType", 254, 4), new ExifTag("SubfileType", JfifUtil.MARKER_FIRST_BYTE, 4), new ExifTag("ThumbnailImageWidth", UserVerificationMethods.USER_VERIFY_HANDPRINT, 3, 4), new ExifTag("ThumbnailImageLength", 257, 3, 4), new ExifTag("BitsPerSample", 258, 3), new ExifTag("Compression", 259, 3), new ExifTag("PhotometricInterpretation", 262, 3), new ExifTag("ImageDescription", RotationOptions.ROTATE_270, 2), new ExifTag("Make", 271, 2), new ExifTag("Model", 272, 2), new ExifTag("StripOffsets", 273, 3, 4), new ExifTag("ThumbnailOrientation", TiffUtil.TIFF_TAG_ORIENTATION, 3), new ExifTag("SamplesPerPixel", 277, 3), new ExifTag("RowsPerStrip", 278, 3, 4), new ExifTag("StripByteCounts", 279, 3, 4), new ExifTag("XResolution", 282, 5), new ExifTag("YResolution", 283, 5), new ExifTag("PlanarConfiguration", 284, 3), new ExifTag("ResolutionUnit", 296, 3), new ExifTag("TransferFunction", 301, 3), new ExifTag("Software", Sdk$SDKError.Reason.MRAID_BRIDGE_ERROR_VALUE, 2), new ExifTag("DateTime", 306, 2), new ExifTag("Artist", 315, 2), new ExifTag("WhitePoint", Sdk$SDKError.Reason.AD_CLOSED_MISSING_HEARTBEAT_VALUE, 5), new ExifTag("PrimaryChromaticities", Sdk$SDKError.Reason.SILENT_MODE_MONITOR_ERROR_VALUE, 5), new ExifTag("SubIFDPointer", 330, 4), new ExifTag("JPEGInterchangeFormat", 513, 4), new ExifTag("JPEGInterchangeFormatLength", 514, 4), new ExifTag("YCbCrCoefficients", 529, 5), new ExifTag("YCbCrSubSampling", 530, 3), new ExifTag("YCbCrPositioning", 531, 3), new ExifTag("ReferenceBlackWhite", 532, 5), new ExifTag("Copyright", 33432, 2), new ExifTag("ExifIFDPointer", 34665, 4), new ExifTag("GPSInfoIFDPointer", 34853, 4), new ExifTag("DNGVersion", 50706, 1), new ExifTag("DefaultCropSize", 50720, 3, 4)};
        f3179c0 = exifTagArr5;
        ExifTag[] exifTagArr6 = {new ExifTag("ThumbnailImage", UserVerificationMethods.USER_VERIFY_HANDPRINT, 7), new ExifTag("CameraSettingsIFDPointer", 8224, 4), new ExifTag("ImageProcessingIFDPointer", 8256, 4)};
        f3181e0 = exifTagArr6;
        ExifTag[] exifTagArr7 = {new ExifTag("PreviewImageStart", 257, 4), new ExifTag("PreviewImageLength", 258, 4)};
        f3182f0 = exifTagArr7;
        ExifTag[] exifTagArr8 = {new ExifTag("AspectFrame", 4371, 3)};
        f3183g0 = exifTagArr8;
        ExifTag[] exifTagArr9 = {new ExifTag("ColorSpace", 55, 3)};
        f3184h0 = exifTagArr9;
        ExifTag[][] exifTagArr10 = {exifTagArr, exifTagArr2, exifTagArr3, exifTagArr4, exifTagArr5, exifTagArr, exifTagArr6, exifTagArr7, exifTagArr8, exifTagArr9};
        f3185i0 = exifTagArr10;
        f3187k0 = new HashMap[exifTagArr10.length];
        f3188l0 = new HashMap[exifTagArr10.length];
        Charset forName = Charset.forName("US-ASCII");
        f3191o0 = forName;
        f3192p0 = "Exif\u0000\u0000".getBytes(forName);
        f3193q0 = "http://ns.adobe.com/xap/1.0/\u0000".getBytes(forName);
        Locale locale = Locale.US;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", locale);
        T = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", locale);
        U = simpleDateFormat2;
        simpleDateFormat2.setTimeZone(TimeZone.getTimeZone("UTC"));
        int i2 = 0;
        while (true) {
            ExifTag[][] exifTagArr11 = f3185i0;
            if (i2 < exifTagArr11.length) {
                f3187k0[i2] = new HashMap<>();
                f3188l0[i2] = new HashMap<>();
                for (ExifTag exifTag : exifTagArr11[i2]) {
                    f3187k0[i2].put(Integer.valueOf(exifTag.f3237a), exifTag);
                    f3188l0[i2].put(exifTag.f3238b, exifTag);
                }
                i2++;
            } else {
                HashMap<Integer, Integer> hashMap = f3190n0;
                ExifTag[] exifTagArr12 = f3186j0;
                hashMap.put(Integer.valueOf(exifTagArr12[0].f3237a), 5);
                hashMap.put(Integer.valueOf(exifTagArr12[1].f3237a), 1);
                hashMap.put(Integer.valueOf(exifTagArr12[2].f3237a), 2);
                hashMap.put(Integer.valueOf(exifTagArr12[3].f3237a), 3);
                hashMap.put(Integer.valueOf(exifTagArr12[4].f3237a), 7);
                hashMap.put(Integer.valueOf(exifTagArr12[5].f3237a), 8);
                return;
            }
        }
    }

    public ExifInterface(String str) throws IOException {
        ExifTag[][] exifTagArr = f3185i0;
        this.f3209f = new HashMap[exifTagArr.length];
        this.f3210g = new HashSet(exifTagArr.length);
        this.f3211h = ByteOrder.BIG_ENDIAN;
        if (str != null) {
            r(str);
            return;
        }
        throw new NullPointerException("filename cannot be null");
    }

    private boolean A(HashMap hashMap) throws IOException {
        ExifAttribute exifAttribute;
        int i2;
        ExifAttribute exifAttribute2 = (ExifAttribute) hashMap.get("BitsPerSample");
        if (exifAttribute2 != null) {
            int[] iArr = (int[]) exifAttribute2.k(this.f3211h);
            int[] iArr2 = f3201x;
            if (Arrays.equals(iArr2, iArr)) {
                return true;
            }
            if (this.f3207d == 3 && (exifAttribute = (ExifAttribute) hashMap.get("PhotometricInterpretation")) != null && (((i2 = exifAttribute.i(this.f3211h)) == 1 && Arrays.equals(iArr, f3203z)) || (i2 == 6 && Arrays.equals(iArr, iArr2)))) {
                return true;
            }
        }
        if (!f3197u) {
            return false;
        }
        Log.d("ExifInterface", "Unsupported data type value");
        return false;
    }

    private boolean B(HashMap hashMap) throws IOException {
        ExifAttribute exifAttribute = (ExifAttribute) hashMap.get("ImageLength");
        ExifAttribute exifAttribute2 = (ExifAttribute) hashMap.get("ImageWidth");
        if (exifAttribute == null || exifAttribute2 == null) {
            return false;
        }
        int i2 = exifAttribute.i(this.f3211h);
        int i3 = exifAttribute2.i(this.f3211h);
        if (i2 > 512 || i3 > 512) {
            return false;
        }
        return true;
    }

    private boolean C(byte[] bArr) throws IOException {
        int i2 = 0;
        while (true) {
            byte[] bArr2 = K;
            if (i2 >= bArr2.length) {
                int i3 = 0;
                while (true) {
                    byte[] bArr3 = L;
                    if (i3 >= bArr3.length) {
                        return true;
                    }
                    if (bArr[K.length + i3 + 4] != bArr3[i3]) {
                        return false;
                    }
                    i3++;
                }
            } else if (bArr[i2] != bArr2[i2]) {
                return false;
            } else {
                i2++;
            }
        }
    }

    private void D(InputStream inputStream) {
        if (inputStream != null) {
            int i2 = 0;
            while (i2 < f3185i0.length) {
                try {
                    this.f3209f[i2] = new HashMap<>();
                    i2++;
                } catch (IOException | UnsupportedOperationException e2) {
                    boolean z2 = f3197u;
                    if (z2) {
                        Log.w("ExifInterface", "Invalid image: ExifInterface got an unsupported image format file(ExifInterface supports JPEG and some RAW image formats only) or a corrupted JPEG file to ExifInterface.", e2);
                    }
                    a();
                    if (!z2) {
                        return;
                    }
                } catch (Throwable th) {
                    a();
                    if (f3197u) {
                        F();
                    }
                    throw th;
                }
            }
            if (!this.f3208e) {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 5000);
                this.f3207d = g(bufferedInputStream);
                inputStream = bufferedInputStream;
            }
            if (M(this.f3207d)) {
                SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream = new SeekableByteOrderedDataInputStream(inputStream);
                if (this.f3208e) {
                    n(seekableByteOrderedDataInputStream);
                } else {
                    int i3 = this.f3207d;
                    if (i3 == 12) {
                        e(seekableByteOrderedDataInputStream);
                    } else if (i3 == 7) {
                        h(seekableByteOrderedDataInputStream);
                    } else if (i3 == 10) {
                        m(seekableByteOrderedDataInputStream);
                    } else {
                        k(seekableByteOrderedDataInputStream);
                    }
                }
                seekableByteOrderedDataInputStream.q((long) this.f3219p);
                L(seekableByteOrderedDataInputStream);
            } else {
                ByteOrderedDataInputStream byteOrderedDataInputStream = new ByteOrderedDataInputStream(inputStream);
                int i4 = this.f3207d;
                if (i4 == 4) {
                    f(byteOrderedDataInputStream, 0, 0);
                } else if (i4 == 13) {
                    i(byteOrderedDataInputStream);
                } else if (i4 == 9) {
                    j(byteOrderedDataInputStream);
                } else if (i4 == 14) {
                    o(byteOrderedDataInputStream);
                }
            }
            a();
            if (!f3197u) {
                return;
            }
            F();
            return;
        }
        throw new NullPointerException("inputstream shouldn't be null");
    }

    private void E(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        ByteOrder G2 = G(byteOrderedDataInputStream);
        this.f3211h = G2;
        byteOrderedDataInputStream.i(G2);
        int readUnsignedShort = byteOrderedDataInputStream.readUnsignedShort();
        int i2 = this.f3207d;
        if (i2 == 7 || i2 == 10 || readUnsignedShort == 42) {
            int readInt = byteOrderedDataInputStream.readInt();
            if (readInt >= 8) {
                int i3 = readInt - 8;
                if (i3 > 0) {
                    byteOrderedDataInputStream.k(i3);
                    return;
                }
                return;
            }
            throw new IOException("Invalid first Ifd offset: " + readInt);
        }
        throw new IOException("Invalid start code: " + Integer.toHexString(readUnsignedShort));
    }

    private void F() {
        for (int i2 = 0; i2 < this.f3209f.length; i2++) {
            Log.d("ExifInterface", "The size of tag group[" + i2 + "]: " + this.f3209f[i2].size());
            for (Map.Entry next : this.f3209f[i2].entrySet()) {
                ExifAttribute exifAttribute = (ExifAttribute) next.getValue();
                Log.d("ExifInterface", "tagName: " + ((String) next.getKey()) + ", tagType: " + exifAttribute.toString() + ", tagValue: '" + exifAttribute.j(this.f3211h) + "'");
            }
        }
    }

    private ByteOrder G(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        short readShort = byteOrderedDataInputStream.readShort();
        if (readShort == 18761) {
            if (f3197u) {
                Log.d("ExifInterface", "readExifSegment: Byte Align II");
            }
            return ByteOrder.LITTLE_ENDIAN;
        } else if (readShort == 19789) {
            if (f3197u) {
                Log.d("ExifInterface", "readExifSegment: Byte Align MM");
            }
            return ByteOrder.BIG_ENDIAN;
        } else {
            throw new IOException("Invalid byte order: " + Integer.toHexString(readShort));
        }
    }

    private void H(byte[] bArr, int i2) throws IOException {
        SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream = new SeekableByteOrderedDataInputStream(bArr);
        E(seekableByteOrderedDataInputStream);
        I(seekableByteOrderedDataInputStream, i2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x0133  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x013b  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0229  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0247  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0283  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void I(androidx.exifinterface.media.ExifInterface.SeekableByteOrderedDataInputStream r30, int r31) throws java.io.IOException {
        /*
            r29 = this;
            r0 = r29
            r1 = r30
            r2 = r31
            java.util.Set<java.lang.Integer> r3 = r0.f3210g
            int r4 = r1.f3231d
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r3.add(r4)
            short r3 = r30.readShort()
            boolean r4 = f3197u
            java.lang.String r5 = "ExifInterface"
            if (r4 == 0) goto L_0x002f
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r6 = "numberOfDirectoryEntry: "
            r4.append(r6)
            r4.append(r3)
            java.lang.String r4 = r4.toString()
            android.util.Log.d(r5, r4)
        L_0x002f:
            if (r3 > 0) goto L_0x0032
            return
        L_0x0032:
            r4 = 0
            r6 = 0
        L_0x0034:
            r7 = 5
            if (r6 >= r3) goto L_0x0323
            int r12 = r30.readUnsignedShort()
            int r13 = r30.readUnsignedShort()
            int r15 = r30.readInt()
            int r14 = r30.a()
            long r8 = (long) r14
            r18 = 4
            long r8 = r8 + r18
            java.util.HashMap<java.lang.Integer, androidx.exifinterface.media.ExifInterface$ExifTag>[] r14 = f3187k0
            r14 = r14[r2]
            java.lang.Integer r11 = java.lang.Integer.valueOf(r12)
            java.lang.Object r11 = r14.get(r11)
            androidx.exifinterface.media.ExifInterface$ExifTag r11 = (androidx.exifinterface.media.ExifInterface.ExifTag) r11
            boolean r14 = f3197u
            r10 = 3
            if (r14 == 0) goto L_0x0090
            java.lang.Object[] r7 = new java.lang.Object[r7]
            java.lang.Integer r23 = java.lang.Integer.valueOf(r31)
            r7[r4] = r23
            java.lang.Integer r23 = java.lang.Integer.valueOf(r12)
            r21 = 1
            r7[r21] = r23
            if (r11 == 0) goto L_0x0074
            java.lang.String r4 = r11.f3238b
            goto L_0x0075
        L_0x0074:
            r4 = 0
        L_0x0075:
            r22 = 2
            r7[r22] = r4
            java.lang.Integer r4 = java.lang.Integer.valueOf(r13)
            r7[r10] = r4
            java.lang.Integer r4 = java.lang.Integer.valueOf(r15)
            r20 = 4
            r7[r20] = r4
            java.lang.String r4 = "ifdType: %d, tagNumber: %d, tagName: %s, dataFormat: %d, numberOfComponents: %d"
            java.lang.String r4 = java.lang.String.format(r4, r7)
            android.util.Log.d(r5, r4)
        L_0x0090:
            r4 = 7
            if (r11 != 0) goto L_0x00ae
            if (r14 == 0) goto L_0x00a9
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r10 = "Skip the tag entry since tag number is not defined: "
            r7.append(r10)
            r7.append(r12)
            java.lang.String r7 = r7.toString()
            android.util.Log.d(r5, r7)
        L_0x00a9:
            r10 = r5
            r25 = r6
            goto L_0x012e
        L_0x00ae:
            if (r13 <= 0) goto L_0x0115
            int[] r7 = W
            int r10 = r7.length
            if (r13 < r10) goto L_0x00b6
            goto L_0x0115
        L_0x00b6:
            boolean r10 = r11.a(r13)
            if (r10 != 0) goto L_0x00e1
            if (r14 == 0) goto L_0x00a9
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r10 = "Skip the tag entry since data format ("
            r7.append(r10)
            java.lang.String[] r10 = V
            r10 = r10[r13]
            r7.append(r10)
            java.lang.String r10 = ") is unexpected for tag: "
            r7.append(r10)
            java.lang.String r10 = r11.f3238b
            r7.append(r10)
            java.lang.String r7 = r7.toString()
            android.util.Log.d(r5, r7)
            goto L_0x00a9
        L_0x00e1:
            if (r13 != r4) goto L_0x00e5
            int r13 = r11.f3239c
        L_0x00e5:
            r10 = r5
            long r4 = (long) r15
            r7 = r7[r13]
            r25 = r6
            long r6 = (long) r7
            long r4 = r4 * r6
            r6 = 0
            int r26 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r26 < 0) goto L_0x00fe
            r6 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r26 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r26 <= 0) goto L_0x00fc
            goto L_0x00fe
        L_0x00fc:
            r6 = 1
            goto L_0x0131
        L_0x00fe:
            if (r14 == 0) goto L_0x0130
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Skip the tag entry since the number of components is invalid: "
            r6.append(r7)
            r6.append(r15)
            java.lang.String r6 = r6.toString()
            android.util.Log.d(r10, r6)
            goto L_0x0130
        L_0x0115:
            r10 = r5
            r25 = r6
            if (r14 == 0) goto L_0x012e
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Skip the tag entry since data format is invalid: "
            r4.append(r5)
            r4.append(r13)
            java.lang.String r4 = r4.toString()
            android.util.Log.d(r10, r4)
        L_0x012e:
            r4 = 0
        L_0x0130:
            r6 = 0
        L_0x0131:
            if (r6 != 0) goto L_0x013b
            r1.q(r8)
            r26 = r3
            r8 = r10
            goto L_0x031a
        L_0x013b:
            java.lang.String r6 = "Compression"
            int r7 = (r4 > r18 ? 1 : (r4 == r18 ? 0 : -1))
            if (r7 <= 0) goto L_0x01c5
            int r7 = r30.readInt()
            r26 = r3
            if (r14 == 0) goto L_0x0160
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r27 = r8
            java.lang.String r8 = "seek to data offset: "
            r3.append(r8)
            r3.append(r7)
            java.lang.String r3 = r3.toString()
            android.util.Log.d(r10, r3)
            goto L_0x0162
        L_0x0160:
            r27 = r8
        L_0x0162:
            int r3 = r0.f3207d
            r8 = 7
            if (r3 != r8) goto L_0x01bc
            java.lang.String r3 = r11.f3238b
            java.lang.String r8 = "MakerNote"
            boolean r3 = r8.equals(r3)
            if (r3 == 0) goto L_0x0174
            r0.f3220q = r7
            goto L_0x01bc
        L_0x0174:
            r3 = 6
            if (r2 != r3) goto L_0x01bc
            java.lang.String r8 = "ThumbnailImage"
            java.lang.String r9 = r11.f3238b
            boolean r8 = r8.equals(r9)
            if (r8 == 0) goto L_0x01bc
            r0.f3221r = r7
            r0.f3222s = r15
            java.nio.ByteOrder r8 = r0.f3211h
            androidx.exifinterface.media.ExifInterface$ExifAttribute r3 = androidx.exifinterface.media.ExifInterface.ExifAttribute.f(r3, r8)
            int r8 = r0.f3221r
            long r8 = (long) r8
            r18 = r15
            java.nio.ByteOrder r15 = r0.f3211h
            androidx.exifinterface.media.ExifInterface$ExifAttribute r8 = androidx.exifinterface.media.ExifInterface.ExifAttribute.b(r8, r15)
            int r9 = r0.f3222s
            r24 = r10
            long r9 = (long) r9
            java.nio.ByteOrder r15 = r0.f3211h
            androidx.exifinterface.media.ExifInterface$ExifAttribute r9 = androidx.exifinterface.media.ExifInterface.ExifAttribute.b(r9, r15)
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r10 = r0.f3209f
            r15 = 4
            r10 = r10[r15]
            r10.put(r6, r3)
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r3 = r0.f3209f
            r3 = r3[r15]
            java.lang.String r10 = "JPEGInterchangeFormat"
            r3.put(r10, r8)
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r3 = r0.f3209f
            r3 = r3[r15]
            java.lang.String r8 = "JPEGInterchangeFormatLength"
            r3.put(r8, r9)
            goto L_0x01c0
        L_0x01bc:
            r24 = r10
            r18 = r15
        L_0x01c0:
            long r7 = (long) r7
            r1.q(r7)
            goto L_0x01cd
        L_0x01c5:
            r26 = r3
            r27 = r8
            r24 = r10
            r18 = r15
        L_0x01cd:
            java.util.HashMap<java.lang.Integer, java.lang.Integer> r3 = f3190n0
            java.lang.Integer r7 = java.lang.Integer.valueOf(r12)
            java.lang.Object r3 = r3.get(r7)
            java.lang.Integer r3 = (java.lang.Integer) r3
            if (r14 == 0) goto L_0x01fa
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "nextIfdType: "
            r7.append(r8)
            r7.append(r3)
            java.lang.String r8 = " byteCount: "
            r7.append(r8)
            r7.append(r4)
            java.lang.String r7 = r7.toString()
            r8 = r24
            android.util.Log.d(r8, r7)
            goto L_0x01fc
        L_0x01fa:
            r8 = r24
        L_0x01fc:
            r7 = 8
            if (r3 == 0) goto L_0x02a0
            r4 = 3
            if (r13 == r4) goto L_0x0222
            r4 = 4
            if (r13 == r4) goto L_0x021d
            if (r13 == r7) goto L_0x0218
            r4 = 9
            if (r13 == r4) goto L_0x0213
            r4 = 13
            if (r13 == r4) goto L_0x0213
            r4 = -1
            goto L_0x0227
        L_0x0213:
            int r4 = r30.readInt()
            goto L_0x0226
        L_0x0218:
            short r4 = r30.readShort()
            goto L_0x0226
        L_0x021d:
            long r4 = r30.f()
            goto L_0x0227
        L_0x0222:
            int r4 = r30.readUnsignedShort()
        L_0x0226:
            long r4 = (long) r4
        L_0x0227:
            if (r14 == 0) goto L_0x0241
            r6 = 2
            java.lang.Object[] r6 = new java.lang.Object[r6]
            java.lang.Long r7 = java.lang.Long.valueOf(r4)
            r9 = 0
            r6[r9] = r7
            java.lang.String r7 = r11.f3238b
            r9 = 1
            r6[r9] = r7
            java.lang.String r7 = "Offset: %d, tagName: %s"
            java.lang.String r6 = java.lang.String.format(r7, r6)
            android.util.Log.d(r8, r6)
        L_0x0241:
            r6 = 0
            int r9 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r9 <= 0) goto L_0x0283
            java.util.Set<java.lang.Integer> r6 = r0.f3210g
            int r7 = (int) r4
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            boolean r6 = r6.contains(r7)
            if (r6 != 0) goto L_0x025f
            r1.q(r4)
            int r3 = r3.intValue()
            r0.I(r1, r3)
            goto L_0x0299
        L_0x025f:
            if (r14 == 0) goto L_0x0299
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Skip jump into the IFD since it has already been read: IfdType "
            r6.append(r7)
            r6.append(r3)
            java.lang.String r3 = " (at "
            r6.append(r3)
            r6.append(r4)
            java.lang.String r3 = ")"
            r6.append(r3)
            java.lang.String r3 = r6.toString()
            android.util.Log.d(r8, r3)
            goto L_0x0299
        L_0x0283:
            if (r14 == 0) goto L_0x0299
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r6 = "Skip jump into the IFD since its offset is invalid: "
            r3.append(r6)
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            android.util.Log.d(r8, r3)
        L_0x0299:
            r9 = r27
            r1.q(r9)
            goto L_0x031a
        L_0x02a0:
            r9 = r27
            int r3 = r30.a()
            int r12 = r0.f3219p
            int r3 = r3 + r12
            int r5 = (int) r4
            byte[] r4 = new byte[r5]
            r1.readFully(r4)
            androidx.exifinterface.media.ExifInterface$ExifAttribute r5 = new androidx.exifinterface.media.ExifInterface$ExifAttribute
            long r14 = (long) r3
            r19 = r14
            r14 = r5
            r3 = r18
            r15 = r13
            r16 = r3
            r17 = r19
            r19 = r4
            r14.<init>(r15, r16, r17, r19)
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r3 = r0.f3209f
            r3 = r3[r2]
            java.lang.String r4 = r11.f3238b
            r3.put(r4, r5)
            java.lang.String r3 = "DNGVersion"
            java.lang.String r4 = r11.f3238b
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x02d7
            r3 = 3
            r0.f3207d = r3
        L_0x02d7:
            java.lang.String r3 = "Make"
            java.lang.String r4 = r11.f3238b
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x02eb
            java.lang.String r3 = "Model"
            java.lang.String r4 = r11.f3238b
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x02f9
        L_0x02eb:
            java.nio.ByteOrder r3 = r0.f3211h
            java.lang.String r3 = r5.j(r3)
            java.lang.String r4 = "PENTAX"
            boolean r3 = r3.contains(r4)
            if (r3 != 0) goto L_0x030c
        L_0x02f9:
            java.lang.String r3 = r11.f3238b
            boolean r3 = r6.equals(r3)
            if (r3 == 0) goto L_0x030e
            java.nio.ByteOrder r3 = r0.f3211h
            int r3 = r5.i(r3)
            r4 = 65535(0xffff, float:9.1834E-41)
            if (r3 != r4) goto L_0x030e
        L_0x030c:
            r0.f3207d = r7
        L_0x030e:
            int r3 = r30.a()
            long r3 = (long) r3
            int r5 = (r3 > r9 ? 1 : (r3 == r9 ? 0 : -1))
            if (r5 == 0) goto L_0x031a
            r1.q(r9)
        L_0x031a:
            int r6 = r25 + 1
            short r6 = (short) r6
            r5 = r8
            r3 = r26
            r4 = 0
            goto L_0x0034
        L_0x0323:
            r8 = r5
            int r2 = r30.readInt()
            boolean r3 = f3197u
            if (r3 == 0) goto L_0x033f
            r4 = 1
            java.lang.Object[] r4 = new java.lang.Object[r4]
            java.lang.Integer r5 = java.lang.Integer.valueOf(r2)
            r6 = 0
            r4[r6] = r5
            java.lang.String r5 = "nextIfdOffset: %d"
            java.lang.String r4 = java.lang.String.format(r5, r4)
            android.util.Log.d(r8, r4)
        L_0x033f:
            long r4 = (long) r2
            r9 = 0
            int r6 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r6 <= 0) goto L_0x0389
            java.util.Set<java.lang.Integer> r6 = r0.f3210g
            java.lang.Integer r9 = java.lang.Integer.valueOf(r2)
            boolean r6 = r6.contains(r9)
            if (r6 != 0) goto L_0x0372
            r1.q(r4)
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r2 = r0.f3209f
            r3 = 4
            r2 = r2[r3]
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x0364
            r0.I(r1, r3)
            goto L_0x039f
        L_0x0364:
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r2 = r0.f3209f
            r2 = r2[r7]
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x039f
            r0.I(r1, r7)
            goto L_0x039f
        L_0x0372:
            if (r3 == 0) goto L_0x039f
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Stop reading file since re-reading an IFD may cause an infinite loop: "
            r1.append(r3)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            android.util.Log.d(r8, r1)
            goto L_0x039f
        L_0x0389:
            if (r3 == 0) goto L_0x039f
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Stop reading file since a wrong offset may cause an infinite loop: "
            r1.append(r3)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            android.util.Log.d(r8, r1)
        L_0x039f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.I(androidx.exifinterface.media.ExifInterface$SeekableByteOrderedDataInputStream, int):void");
    }

    private void J(int i2, String str, String str2) {
        if (!this.f3209f[i2].isEmpty() && this.f3209f[i2].get(str) != null) {
            HashMap<String, ExifAttribute> hashMap = this.f3209f[i2];
            hashMap.put(str2, hashMap.get(str));
            this.f3209f[i2].remove(str);
        }
    }

    private void K(SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream, int i2) throws IOException {
        ExifAttribute exifAttribute = this.f3209f[i2].get("ImageLength");
        ExifAttribute exifAttribute2 = this.f3209f[i2].get("ImageWidth");
        if (exifAttribute == null || exifAttribute2 == null) {
            ExifAttribute exifAttribute3 = this.f3209f[i2].get("JPEGInterchangeFormat");
            ExifAttribute exifAttribute4 = this.f3209f[i2].get("JPEGInterchangeFormatLength");
            if (exifAttribute3 != null && exifAttribute4 != null) {
                int i3 = exifAttribute3.i(this.f3211h);
                int i4 = exifAttribute3.i(this.f3211h);
                seekableByteOrderedDataInputStream.q((long) i3);
                byte[] bArr = new byte[i4];
                seekableByteOrderedDataInputStream.read(bArr);
                f(new ByteOrderedDataInputStream(bArr), i3, i2);
            }
        }
    }

    private void L(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        HashMap<String, ExifAttribute> hashMap = this.f3209f[4];
        ExifAttribute exifAttribute = hashMap.get("Compression");
        if (exifAttribute != null) {
            int i2 = exifAttribute.i(this.f3211h);
            this.f3218o = i2;
            if (i2 != 1) {
                if (i2 == 6) {
                    p(byteOrderedDataInputStream, hashMap);
                    return;
                } else if (i2 != 7) {
                    return;
                }
            }
            if (A(hashMap)) {
                q(byteOrderedDataInputStream, hashMap);
                return;
            }
            return;
        }
        this.f3218o = 6;
        p(byteOrderedDataInputStream, hashMap);
    }

    private static boolean M(int i2) {
        return (i2 == 4 || i2 == 9 || i2 == 13 || i2 == 14) ? false : true;
    }

    private void N(int i2, int i3) throws IOException {
        if (!this.f3209f[i2].isEmpty() && !this.f3209f[i3].isEmpty()) {
            ExifAttribute exifAttribute = this.f3209f[i2].get("ImageLength");
            ExifAttribute exifAttribute2 = this.f3209f[i2].get("ImageWidth");
            ExifAttribute exifAttribute3 = this.f3209f[i3].get("ImageLength");
            ExifAttribute exifAttribute4 = this.f3209f[i3].get("ImageWidth");
            if (exifAttribute == null || exifAttribute2 == null) {
                if (f3197u) {
                    Log.d("ExifInterface", "First image does not contain valid size information");
                }
            } else if (exifAttribute3 != null && exifAttribute4 != null) {
                int i4 = exifAttribute.i(this.f3211h);
                int i5 = exifAttribute2.i(this.f3211h);
                int i6 = exifAttribute3.i(this.f3211h);
                int i7 = exifAttribute4.i(this.f3211h);
                if (i4 < i6 && i5 < i7) {
                    HashMap<String, ExifAttribute>[] hashMapArr = this.f3209f;
                    HashMap<String, ExifAttribute> hashMap = hashMapArr[i2];
                    hashMapArr[i2] = hashMapArr[i3];
                    hashMapArr[i3] = hashMap;
                }
            } else if (f3197u) {
                Log.d("ExifInterface", "Second image does not contain valid size information");
            }
        } else if (f3197u) {
            Log.d("ExifInterface", "Cannot perform swap since only one image data exists");
        }
    }

    private void O(SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream, int i2) throws IOException {
        ExifAttribute exifAttribute;
        ExifAttribute exifAttribute2;
        ExifAttribute exifAttribute3 = this.f3209f[i2].get("DefaultCropSize");
        ExifAttribute exifAttribute4 = this.f3209f[i2].get("SensorTopBorder");
        ExifAttribute exifAttribute5 = this.f3209f[i2].get("SensorLeftBorder");
        ExifAttribute exifAttribute6 = this.f3209f[i2].get("SensorBottomBorder");
        ExifAttribute exifAttribute7 = this.f3209f[i2].get("SensorRightBorder");
        if (exifAttribute3 != null) {
            if (exifAttribute3.f3233a == 5) {
                Rational[] rationalArr = (Rational[]) exifAttribute3.k(this.f3211h);
                if (rationalArr == null || rationalArr.length != 2) {
                    Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(rationalArr));
                    return;
                }
                exifAttribute2 = ExifAttribute.d(rationalArr[0], this.f3211h);
                exifAttribute = ExifAttribute.d(rationalArr[1], this.f3211h);
            } else {
                int[] iArr = (int[]) exifAttribute3.k(this.f3211h);
                if (iArr == null || iArr.length != 2) {
                    Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(iArr));
                    return;
                }
                exifAttribute2 = ExifAttribute.f(iArr[0], this.f3211h);
                exifAttribute = ExifAttribute.f(iArr[1], this.f3211h);
            }
            this.f3209f[i2].put("ImageWidth", exifAttribute2);
            this.f3209f[i2].put("ImageLength", exifAttribute);
        } else if (exifAttribute4 == null || exifAttribute5 == null || exifAttribute6 == null || exifAttribute7 == null) {
            K(seekableByteOrderedDataInputStream, i2);
        } else {
            int i3 = exifAttribute4.i(this.f3211h);
            int i4 = exifAttribute6.i(this.f3211h);
            int i5 = exifAttribute7.i(this.f3211h);
            int i6 = exifAttribute5.i(this.f3211h);
            if (i4 > i3 && i5 > i6) {
                ExifAttribute f2 = ExifAttribute.f(i4 - i3, this.f3211h);
                ExifAttribute f3 = ExifAttribute.f(i5 - i6, this.f3211h);
                this.f3209f[i2].put("ImageLength", f2);
                this.f3209f[i2].put("ImageWidth", f3);
            }
        }
    }

    private void P() throws IOException {
        N(0, 5);
        N(0, 4);
        N(5, 4);
        ExifAttribute exifAttribute = this.f3209f[1].get("PixelXDimension");
        ExifAttribute exifAttribute2 = this.f3209f[1].get("PixelYDimension");
        if (!(exifAttribute == null || exifAttribute2 == null)) {
            this.f3209f[0].put("ImageWidth", exifAttribute);
            this.f3209f[0].put("ImageLength", exifAttribute2);
        }
        if (this.f3209f[4].isEmpty() && B(this.f3209f[5])) {
            HashMap<String, ExifAttribute>[] hashMapArr = this.f3209f;
            hashMapArr[4] = hashMapArr[5];
            hashMapArr[5] = new HashMap<>();
        }
        if (!B(this.f3209f[4])) {
            Log.d("ExifInterface", "No image meets the size requirements of a thumbnail image.");
        }
        J(0, "ThumbnailOrientation", "Orientation");
        J(0, "ThumbnailImageLength", "ImageLength");
        J(0, "ThumbnailImageWidth", "ImageWidth");
        J(5, "ThumbnailOrientation", "Orientation");
        J(5, "ThumbnailImageLength", "ImageLength");
        J(5, "ThumbnailImageWidth", "ImageWidth");
        J(4, "Orientation", "ThumbnailOrientation");
        J(4, "ImageLength", "ThumbnailImageLength");
        J(4, "ImageWidth", "ThumbnailImageWidth");
    }

    private void a() {
        String b2 = b("DateTimeOriginal");
        if (b2 != null && b("DateTime") == null) {
            this.f3209f[0].put("DateTime", ExifAttribute.a(b2));
        }
        if (b("ImageWidth") == null) {
            this.f3209f[0].put("ImageWidth", ExifAttribute.b(0, this.f3211h));
        }
        if (b("ImageLength") == null) {
            this.f3209f[0].put("ImageLength", ExifAttribute.b(0, this.f3211h));
        }
        if (b("Orientation") == null) {
            this.f3209f[0].put("Orientation", ExifAttribute.b(0, this.f3211h));
        }
        if (b("LightSource") == null) {
            this.f3209f[1].put("LightSource", ExifAttribute.b(0, this.f3211h));
        }
    }

    private ExifAttribute d(String str) {
        if (str != null) {
            if ("ISOSpeedRatings".equals(str)) {
                if (f3197u) {
                    Log.d("ExifInterface", "getExifAttribute: Replacing TAG_ISO_SPEED_RATINGS with TAG_PHOTOGRAPHIC_SENSITIVITY.");
                }
                str = "PhotographicSensitivity";
            }
            for (int i2 = 0; i2 < f3185i0.length; i2++) {
                ExifAttribute exifAttribute = this.f3209f[i2].get(str);
                if (exifAttribute != null) {
                    return exifAttribute;
                }
            }
            return null;
        }
        throw new NullPointerException("tag shouldn't be null");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0138, code lost:
        r13 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0141, code lost:
        throw new java.lang.UnsupportedOperationException("Failed to read EXIF from HEIF file. Given stream is either malformed or unsupported.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0142, code lost:
        r1.release();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0145, code lost:
        throw r13;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:54:0x013a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void e(final androidx.exifinterface.media.ExifInterface.SeekableByteOrderedDataInputStream r13) throws java.io.IOException {
        /*
            r12 = this;
            java.lang.String r0 = "yes"
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 28
            if (r1 < r2) goto L_0x0146
            android.media.MediaMetadataRetriever r1 = new android.media.MediaMetadataRetriever
            r1.<init>()
            androidx.exifinterface.media.ExifInterface$1 r2 = new androidx.exifinterface.media.ExifInterface$1     // Catch:{ RuntimeException -> 0x013a }
            r2.<init>(r13)     // Catch:{ RuntimeException -> 0x013a }
            androidx.exifinterface.media.ExifInterfaceUtils.Api23Impl.a(r1, r2)     // Catch:{ RuntimeException -> 0x013a }
            r2 = 33
            java.lang.String r2 = r1.extractMetadata(r2)     // Catch:{ RuntimeException -> 0x013a }
            r3 = 34
            java.lang.String r3 = r1.extractMetadata(r3)     // Catch:{ RuntimeException -> 0x013a }
            r4 = 26
            java.lang.String r4 = r1.extractMetadata(r4)     // Catch:{ RuntimeException -> 0x013a }
            r5 = 17
            java.lang.String r5 = r1.extractMetadata(r5)     // Catch:{ RuntimeException -> 0x013a }
            boolean r4 = r0.equals(r4)     // Catch:{ RuntimeException -> 0x013a }
            if (r4 == 0) goto L_0x0046
            r0 = 29
            java.lang.String r0 = r1.extractMetadata(r0)     // Catch:{ RuntimeException -> 0x013a }
            r4 = 30
            java.lang.String r4 = r1.extractMetadata(r4)     // Catch:{ RuntimeException -> 0x013a }
            r5 = 31
            java.lang.String r5 = r1.extractMetadata(r5)     // Catch:{ RuntimeException -> 0x013a }
            goto L_0x0062
        L_0x0046:
            boolean r0 = r0.equals(r5)     // Catch:{ RuntimeException -> 0x013a }
            if (r0 == 0) goto L_0x005f
            r0 = 18
            java.lang.String r0 = r1.extractMetadata(r0)     // Catch:{ RuntimeException -> 0x013a }
            r4 = 19
            java.lang.String r4 = r1.extractMetadata(r4)     // Catch:{ RuntimeException -> 0x013a }
            r5 = 24
            java.lang.String r5 = r1.extractMetadata(r5)     // Catch:{ RuntimeException -> 0x013a }
            goto L_0x0062
        L_0x005f:
            r0 = 0
            r4 = r0
            r5 = r4
        L_0x0062:
            r6 = 0
            if (r0 == 0) goto L_0x0078
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r7 = r12.f3209f     // Catch:{ RuntimeException -> 0x013a }
            r7 = r7[r6]     // Catch:{ RuntimeException -> 0x013a }
            java.lang.String r8 = "ImageWidth"
            int r9 = java.lang.Integer.parseInt(r0)     // Catch:{ RuntimeException -> 0x013a }
            java.nio.ByteOrder r10 = r12.f3211h     // Catch:{ RuntimeException -> 0x013a }
            androidx.exifinterface.media.ExifInterface$ExifAttribute r9 = androidx.exifinterface.media.ExifInterface.ExifAttribute.f(r9, r10)     // Catch:{ RuntimeException -> 0x013a }
            r7.put(r8, r9)     // Catch:{ RuntimeException -> 0x013a }
        L_0x0078:
            if (r4 == 0) goto L_0x008d
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r7 = r12.f3209f     // Catch:{ RuntimeException -> 0x013a }
            r7 = r7[r6]     // Catch:{ RuntimeException -> 0x013a }
            java.lang.String r8 = "ImageLength"
            int r9 = java.lang.Integer.parseInt(r4)     // Catch:{ RuntimeException -> 0x013a }
            java.nio.ByteOrder r10 = r12.f3211h     // Catch:{ RuntimeException -> 0x013a }
            androidx.exifinterface.media.ExifInterface$ExifAttribute r9 = androidx.exifinterface.media.ExifInterface.ExifAttribute.f(r9, r10)     // Catch:{ RuntimeException -> 0x013a }
            r7.put(r8, r9)     // Catch:{ RuntimeException -> 0x013a }
        L_0x008d:
            r7 = 6
            if (r5 == 0) goto L_0x00b7
            int r8 = java.lang.Integer.parseInt(r5)     // Catch:{ RuntimeException -> 0x013a }
            r9 = 90
            if (r8 == r9) goto L_0x00a7
            r9 = 180(0xb4, float:2.52E-43)
            if (r8 == r9) goto L_0x00a5
            r9 = 270(0x10e, float:3.78E-43)
            if (r8 == r9) goto L_0x00a2
            r8 = 1
            goto L_0x00a8
        L_0x00a2:
            r8 = 8
            goto L_0x00a8
        L_0x00a5:
            r8 = 3
            goto L_0x00a8
        L_0x00a7:
            r8 = 6
        L_0x00a8:
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r9 = r12.f3209f     // Catch:{ RuntimeException -> 0x013a }
            r9 = r9[r6]     // Catch:{ RuntimeException -> 0x013a }
            java.lang.String r10 = "Orientation"
            java.nio.ByteOrder r11 = r12.f3211h     // Catch:{ RuntimeException -> 0x013a }
            androidx.exifinterface.media.ExifInterface$ExifAttribute r8 = androidx.exifinterface.media.ExifInterface.ExifAttribute.f(r8, r11)     // Catch:{ RuntimeException -> 0x013a }
            r9.put(r10, r8)     // Catch:{ RuntimeException -> 0x013a }
        L_0x00b7:
            if (r2 == 0) goto L_0x010a
            if (r3 == 0) goto L_0x010a
            int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ RuntimeException -> 0x013a }
            int r3 = java.lang.Integer.parseInt(r3)     // Catch:{ RuntimeException -> 0x013a }
            if (r3 <= r7) goto L_0x0102
            long r8 = (long) r2     // Catch:{ RuntimeException -> 0x013a }
            r13.q(r8)     // Catch:{ RuntimeException -> 0x013a }
            byte[] r8 = new byte[r7]     // Catch:{ RuntimeException -> 0x013a }
            int r9 = r13.read(r8)     // Catch:{ RuntimeException -> 0x013a }
            if (r9 != r7) goto L_0x00fa
            int r2 = r2 + r7
            int r3 = r3 + -6
            byte[] r7 = f3192p0     // Catch:{ RuntimeException -> 0x013a }
            boolean r7 = java.util.Arrays.equals(r8, r7)     // Catch:{ RuntimeException -> 0x013a }
            if (r7 == 0) goto L_0x00f2
            byte[] r7 = new byte[r3]     // Catch:{ RuntimeException -> 0x013a }
            int r13 = r13.read(r7)     // Catch:{ RuntimeException -> 0x013a }
            if (r13 != r3) goto L_0x00ea
            r12.f3219p = r2     // Catch:{ RuntimeException -> 0x013a }
            r12.H(r7, r6)     // Catch:{ RuntimeException -> 0x013a }
            goto L_0x010a
        L_0x00ea:
            java.io.IOException r13 = new java.io.IOException     // Catch:{ RuntimeException -> 0x013a }
            java.lang.String r0 = "Can't read exif"
            r13.<init>(r0)     // Catch:{ RuntimeException -> 0x013a }
            throw r13     // Catch:{ RuntimeException -> 0x013a }
        L_0x00f2:
            java.io.IOException r13 = new java.io.IOException     // Catch:{ RuntimeException -> 0x013a }
            java.lang.String r0 = "Invalid identifier"
            r13.<init>(r0)     // Catch:{ RuntimeException -> 0x013a }
            throw r13     // Catch:{ RuntimeException -> 0x013a }
        L_0x00fa:
            java.io.IOException r13 = new java.io.IOException     // Catch:{ RuntimeException -> 0x013a }
            java.lang.String r0 = "Can't read identifier"
            r13.<init>(r0)     // Catch:{ RuntimeException -> 0x013a }
            throw r13     // Catch:{ RuntimeException -> 0x013a }
        L_0x0102:
            java.io.IOException r13 = new java.io.IOException     // Catch:{ RuntimeException -> 0x013a }
            java.lang.String r0 = "Invalid exif length"
            r13.<init>(r0)     // Catch:{ RuntimeException -> 0x013a }
            throw r13     // Catch:{ RuntimeException -> 0x013a }
        L_0x010a:
            boolean r13 = f3197u     // Catch:{ RuntimeException -> 0x013a }
            if (r13 == 0) goto L_0x0134
            java.lang.String r13 = "ExifInterface"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ RuntimeException -> 0x013a }
            r2.<init>()     // Catch:{ RuntimeException -> 0x013a }
            java.lang.String r3 = "Heif meta: "
            r2.append(r3)     // Catch:{ RuntimeException -> 0x013a }
            r2.append(r0)     // Catch:{ RuntimeException -> 0x013a }
            java.lang.String r0 = "x"
            r2.append(r0)     // Catch:{ RuntimeException -> 0x013a }
            r2.append(r4)     // Catch:{ RuntimeException -> 0x013a }
            java.lang.String r0 = ", rotation "
            r2.append(r0)     // Catch:{ RuntimeException -> 0x013a }
            r2.append(r5)     // Catch:{ RuntimeException -> 0x013a }
            java.lang.String r0 = r2.toString()     // Catch:{ RuntimeException -> 0x013a }
            android.util.Log.d(r13, r0)     // Catch:{ RuntimeException -> 0x013a }
        L_0x0134:
            r1.release()
            return
        L_0x0138:
            r13 = move-exception
            goto L_0x0142
        L_0x013a:
            java.lang.UnsupportedOperationException r13 = new java.lang.UnsupportedOperationException     // Catch:{ all -> 0x0138 }
            java.lang.String r0 = "Failed to read EXIF from HEIF file. Given stream is either malformed or unsupported."
            r13.<init>(r0)     // Catch:{ all -> 0x0138 }
            throw r13     // Catch:{ all -> 0x0138 }
        L_0x0142:
            r1.release()
            throw r13
        L_0x0146:
            java.lang.UnsupportedOperationException r13 = new java.lang.UnsupportedOperationException
            java.lang.String r0 = "Reading EXIF from HEIF files is supported from SDK 28 and above"
            r13.<init>(r0)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.e(androidx.exifinterface.media.ExifInterface$SeekableByteOrderedDataInputStream):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0184 A[LOOP:0: B:8:0x0038->B:60:0x0184, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x018e A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void f(androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream r22, int r23, int r24) throws java.io.IOException {
        /*
            r21 = this;
            r0 = r21
            r1 = r22
            r2 = r24
            boolean r3 = f3197u
            java.lang.String r4 = "ExifInterface"
            if (r3 == 0) goto L_0x0020
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "getJpegAttributes starting with: "
            r3.append(r5)
            r3.append(r1)
            java.lang.String r3 = r3.toString()
            android.util.Log.d(r4, r3)
        L_0x0020:
            java.nio.ByteOrder r3 = java.nio.ByteOrder.BIG_ENDIAN
            r1.i(r3)
            byte r3 = r22.readByte()
            java.lang.String r5 = "Invalid marker: "
            r6 = -1
            if (r3 != r6) goto L_0x01d8
            byte r7 = r22.readByte()
            r8 = -40
            if (r7 != r8) goto L_0x01bd
            r3 = 2
            r5 = 2
        L_0x0038:
            byte r7 = r22.readByte()
            if (r7 != r6) goto L_0x01a0
            r7 = 1
            int r5 = r5 + r7
            byte r8 = r22.readByte()
            boolean r9 = f3197u
            if (r9 == 0) goto L_0x0062
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "Found JPEG segment indicator: "
            r10.append(r11)
            r11 = r8 & 255(0xff, float:3.57E-43)
            java.lang.String r11 = java.lang.Integer.toHexString(r11)
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            android.util.Log.d(r4, r10)
        L_0x0062:
            int r5 = r5 + r7
            r10 = -39
            if (r8 == r10) goto L_0x019a
            r10 = -38
            if (r8 != r10) goto L_0x006d
            goto L_0x019a
        L_0x006d:
            int r10 = r22.readUnsignedShort()
            int r10 = r10 - r3
            int r5 = r5 + r3
            if (r9 == 0) goto L_0x009e
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r11 = "JPEG segment: "
            r9.append(r11)
            r11 = r8 & 255(0xff, float:3.57E-43)
            java.lang.String r11 = java.lang.Integer.toHexString(r11)
            r9.append(r11)
            java.lang.String r11 = " (length: "
            r9.append(r11)
            int r11 = r10 + 2
            r9.append(r11)
            java.lang.String r11 = ")"
            r9.append(r11)
            java.lang.String r9 = r9.toString()
            android.util.Log.d(r4, r9)
        L_0x009e:
            java.lang.String r9 = "Invalid length"
            if (r10 < 0) goto L_0x0194
            r11 = -31
            r12 = 0
            if (r8 == r11) goto L_0x0121
            r11 = -2
            if (r8 == r11) goto L_0x00f3
            switch(r8) {
                case -64: goto L_0x00ba;
                case -63: goto L_0x00ba;
                case -62: goto L_0x00ba;
                case -61: goto L_0x00ba;
                default: goto L_0x00ad;
            }
        L_0x00ad:
            switch(r8) {
                case -59: goto L_0x00ba;
                case -58: goto L_0x00ba;
                case -57: goto L_0x00ba;
                default: goto L_0x00b0;
            }
        L_0x00b0:
            switch(r8) {
                case -55: goto L_0x00ba;
                case -54: goto L_0x00ba;
                case -53: goto L_0x00ba;
                default: goto L_0x00b3;
            }
        L_0x00b3:
            switch(r8) {
                case -51: goto L_0x00ba;
                case -50: goto L_0x00ba;
                case -49: goto L_0x00ba;
                default: goto L_0x00b6;
            }
        L_0x00b6:
            r20 = r4
            goto L_0x0182
        L_0x00ba:
            r1.k(r7)
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r7 = r0.f3209f
            r7 = r7[r2]
            r8 = 4
            if (r2 == r8) goto L_0x00c7
            java.lang.String r11 = "ImageLength"
            goto L_0x00c9
        L_0x00c7:
            java.lang.String r11 = "ThumbnailImageLength"
        L_0x00c9:
            int r12 = r22.readUnsignedShort()
            long r12 = (long) r12
            java.nio.ByteOrder r14 = r0.f3211h
            androidx.exifinterface.media.ExifInterface$ExifAttribute r12 = androidx.exifinterface.media.ExifInterface.ExifAttribute.b(r12, r14)
            r7.put(r11, r12)
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r7 = r0.f3209f
            r7 = r7[r2]
            if (r2 == r8) goto L_0x00e0
            java.lang.String r8 = "ImageWidth"
            goto L_0x00e2
        L_0x00e0:
            java.lang.String r8 = "ThumbnailImageWidth"
        L_0x00e2:
            int r11 = r22.readUnsignedShort()
            long r11 = (long) r11
            java.nio.ByteOrder r13 = r0.f3211h
            androidx.exifinterface.media.ExifInterface$ExifAttribute r11 = androidx.exifinterface.media.ExifInterface.ExifAttribute.b(r11, r13)
            r7.put(r8, r11)
            int r10 = r10 + -5
            goto L_0x00b6
        L_0x00f3:
            byte[] r8 = new byte[r10]
            int r11 = r1.read(r8)
            if (r11 != r10) goto L_0x0119
            java.lang.String r10 = "UserComment"
            java.lang.String r11 = r0.b(r10)
            if (r11 != 0) goto L_0x0115
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r11 = r0.f3209f
            r7 = r11[r7]
            java.lang.String r11 = new java.lang.String
            java.nio.charset.Charset r13 = f3191o0
            r11.<init>(r8, r13)
            androidx.exifinterface.media.ExifInterface$ExifAttribute r8 = androidx.exifinterface.media.ExifInterface.ExifAttribute.a(r11)
            r7.put(r10, r8)
        L_0x0115:
            r20 = r4
            goto L_0x0181
        L_0x0119:
            java.io.IOException r1 = new java.io.IOException
            java.lang.String r2 = "Invalid exif"
            r1.<init>(r2)
            throw r1
        L_0x0121:
            byte[] r8 = new byte[r10]
            r1.readFully(r8)
            int r11 = r5 + r10
            byte[] r13 = f3192p0
            boolean r14 = androidx.exifinterface.media.ExifInterfaceUtils.d(r8, r13)
            if (r14 == 0) goto L_0x0147
            int r7 = r13.length
            byte[] r7 = java.util.Arrays.copyOfRange(r8, r7, r10)
            int r5 = r23 + r5
            int r8 = r13.length
            int r5 = r5 + r8
            r0.f3219p = r5
            r0.H(r7, r2)
            androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream r5 = new androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream
            r5.<init>((byte[]) r7)
            r0.L(r5)
            goto L_0x017e
        L_0x0147:
            byte[] r13 = f3193q0
            boolean r14 = androidx.exifinterface.media.ExifInterfaceUtils.d(r8, r13)
            if (r14 == 0) goto L_0x017e
            int r14 = r13.length
            int r5 = r5 + r14
            int r13 = r13.length
            byte[] r8 = java.util.Arrays.copyOfRange(r8, r13, r10)
            java.lang.String r10 = "Xmp"
            java.lang.String r13 = r0.b(r10)
            if (r13 != 0) goto L_0x017e
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r13 = r0.f3209f
            r13 = r13[r12]
            androidx.exifinterface.media.ExifInterface$ExifAttribute r15 = new androidx.exifinterface.media.ExifInterface$ExifAttribute
            r16 = 1
            int r14 = r8.length
            r20 = r4
            long r3 = (long) r5
            r5 = r14
            r14 = r15
            r6 = r15
            r15 = r16
            r16 = r5
            r17 = r3
            r19 = r8
            r14.<init>(r15, r16, r17, r19)
            r13.put(r10, r6)
            r0.f3223t = r7
            goto L_0x0180
        L_0x017e:
            r20 = r4
        L_0x0180:
            r5 = r11
        L_0x0181:
            r10 = 0
        L_0x0182:
            if (r10 < 0) goto L_0x018e
            r1.k(r10)
            int r5 = r5 + r10
            r4 = r20
            r3 = 2
            r6 = -1
            goto L_0x0038
        L_0x018e:
            java.io.IOException r1 = new java.io.IOException
            r1.<init>(r9)
            throw r1
        L_0x0194:
            java.io.IOException r1 = new java.io.IOException
            r1.<init>(r9)
            throw r1
        L_0x019a:
            java.nio.ByteOrder r2 = r0.f3211h
            r1.i(r2)
            return
        L_0x01a0:
            java.io.IOException r1 = new java.io.IOException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Invalid marker:"
            r2.append(r3)
            r3 = r7 & 255(0xff, float:3.57E-43)
            java.lang.String r3 = java.lang.Integer.toHexString(r3)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x01bd:
            java.io.IOException r1 = new java.io.IOException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r5)
            r3 = r3 & 255(0xff, float:3.57E-43)
            java.lang.String r3 = java.lang.Integer.toHexString(r3)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x01d8:
            java.io.IOException r1 = new java.io.IOException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r5)
            r3 = r3 & 255(0xff, float:3.57E-43)
            java.lang.String r3 = java.lang.Integer.toHexString(r3)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.f(androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream, int, int):void");
    }

    private int g(BufferedInputStream bufferedInputStream) throws IOException {
        bufferedInputStream.mark(5000);
        byte[] bArr = new byte[5000];
        bufferedInputStream.read(bArr);
        bufferedInputStream.reset();
        if (u(bArr)) {
            return 4;
        }
        if (x(bArr)) {
            return 9;
        }
        if (t(bArr)) {
            return 12;
        }
        if (v(bArr)) {
            return 7;
        }
        if (y(bArr)) {
            return 10;
        }
        if (w(bArr)) {
            return 13;
        }
        if (C(bArr)) {
            return 14;
        }
        return 0;
    }

    private void h(SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream) throws IOException {
        int i2;
        int i3;
        k(seekableByteOrderedDataInputStream);
        ExifAttribute exifAttribute = this.f3209f[1].get("MakerNote");
        if (exifAttribute != null) {
            SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream2 = new SeekableByteOrderedDataInputStream(exifAttribute.f3236d);
            seekableByteOrderedDataInputStream2.i(this.f3211h);
            byte[] bArr = E;
            byte[] bArr2 = new byte[bArr.length];
            seekableByteOrderedDataInputStream2.readFully(bArr2);
            seekableByteOrderedDataInputStream2.q(0);
            byte[] bArr3 = F;
            byte[] bArr4 = new byte[bArr3.length];
            seekableByteOrderedDataInputStream2.readFully(bArr4);
            if (Arrays.equals(bArr2, bArr)) {
                seekableByteOrderedDataInputStream2.q(8);
            } else if (Arrays.equals(bArr4, bArr3)) {
                seekableByteOrderedDataInputStream2.q(12);
            }
            I(seekableByteOrderedDataInputStream2, 6);
            ExifAttribute exifAttribute2 = this.f3209f[7].get("PreviewImageStart");
            ExifAttribute exifAttribute3 = this.f3209f[7].get("PreviewImageLength");
            if (!(exifAttribute2 == null || exifAttribute3 == null)) {
                this.f3209f[5].put("JPEGInterchangeFormat", exifAttribute2);
                this.f3209f[5].put("JPEGInterchangeFormatLength", exifAttribute3);
            }
            ExifAttribute exifAttribute4 = this.f3209f[8].get("AspectFrame");
            if (exifAttribute4 != null) {
                int[] iArr = (int[]) exifAttribute4.k(this.f3211h);
                if (iArr == null || iArr.length != 4) {
                    Log.w("ExifInterface", "Invalid aspect frame values. frame=" + Arrays.toString(iArr));
                    return;
                }
                int i4 = iArr[2];
                int i5 = iArr[0];
                if (i4 > i5 && (i2 = iArr[3]) > (i3 = iArr[1])) {
                    int i6 = (i4 - i5) + 1;
                    int i7 = (i2 - i3) + 1;
                    if (i6 < i7) {
                        int i8 = i6 + i7;
                        i7 = i8 - i7;
                        i6 = i8 - i7;
                    }
                    ExifAttribute f2 = ExifAttribute.f(i6, this.f3211h);
                    ExifAttribute f3 = ExifAttribute.f(i7, this.f3211h);
                    this.f3209f[0].put("ImageWidth", f2);
                    this.f3209f[0].put("ImageLength", f3);
                }
            }
        }
    }

    private void i(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        if (f3197u) {
            Log.d("ExifInterface", "getPngAttributes starting with: " + byteOrderedDataInputStream);
        }
        byteOrderedDataInputStream.i(ByteOrder.BIG_ENDIAN);
        byte[] bArr = G;
        byteOrderedDataInputStream.k(bArr.length);
        int length = bArr.length + 0;
        while (true) {
            try {
                int readInt = byteOrderedDataInputStream.readInt();
                int i2 = length + 4;
                byte[] bArr2 = new byte[4];
                if (byteOrderedDataInputStream.read(bArr2) == 4) {
                    int i3 = i2 + 4;
                    if (i3 == 16) {
                        if (!Arrays.equals(bArr2, I)) {
                            throw new IOException("Encountered invalid PNG file--IHDR chunk should appearas the first chunk");
                        }
                    }
                    if (!Arrays.equals(bArr2, J)) {
                        if (Arrays.equals(bArr2, H)) {
                            byte[] bArr3 = new byte[readInt];
                            if (byteOrderedDataInputStream.read(bArr3) == readInt) {
                                int readInt2 = byteOrderedDataInputStream.readInt();
                                CRC32 crc32 = new CRC32();
                                crc32.update(bArr2);
                                crc32.update(bArr3);
                                if (((int) crc32.getValue()) == readInt2) {
                                    this.f3219p = i3;
                                    H(bArr3, 0);
                                    P();
                                    L(new ByteOrderedDataInputStream(bArr3));
                                    return;
                                }
                                throw new IOException("Encountered invalid CRC value for PNG-EXIF chunk.\n recorded CRC value: " + readInt2 + ", calculated CRC value: " + crc32.getValue());
                            }
                            throw new IOException("Failed to read given length for given PNG chunk type: " + ExifInterfaceUtils.a(bArr2));
                        }
                        int i4 = readInt + 4;
                        byteOrderedDataInputStream.k(i4);
                        length = i3 + i4;
                    } else {
                        return;
                    }
                } else {
                    throw new IOException("Encountered invalid length while parsing PNG chunktype");
                }
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt PNG file.");
            }
        }
    }

    private void j(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        boolean z2 = f3197u;
        if (z2) {
            Log.d("ExifInterface", "getRafAttributes starting with: " + byteOrderedDataInputStream);
        }
        byteOrderedDataInputStream.k(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        byte[] bArr3 = new byte[4];
        byteOrderedDataInputStream.read(bArr);
        byteOrderedDataInputStream.read(bArr2);
        byteOrderedDataInputStream.read(bArr3);
        int i2 = ByteBuffer.wrap(bArr).getInt();
        int i3 = ByteBuffer.wrap(bArr2).getInt();
        int i4 = ByteBuffer.wrap(bArr3).getInt();
        byte[] bArr4 = new byte[i3];
        byteOrderedDataInputStream.k(i2 - byteOrderedDataInputStream.a());
        byteOrderedDataInputStream.read(bArr4);
        f(new ByteOrderedDataInputStream(bArr4), i2, 5);
        byteOrderedDataInputStream.k(i4 - byteOrderedDataInputStream.a());
        byteOrderedDataInputStream.i(ByteOrder.BIG_ENDIAN);
        int readInt = byteOrderedDataInputStream.readInt();
        if (z2) {
            Log.d("ExifInterface", "numberOfDirectoryEntry: " + readInt);
        }
        for (int i5 = 0; i5 < readInt; i5++) {
            int readUnsignedShort = byteOrderedDataInputStream.readUnsignedShort();
            int readUnsignedShort2 = byteOrderedDataInputStream.readUnsignedShort();
            if (readUnsignedShort == f3180d0.f3237a) {
                short readShort = byteOrderedDataInputStream.readShort();
                short readShort2 = byteOrderedDataInputStream.readShort();
                ExifAttribute f2 = ExifAttribute.f(readShort, this.f3211h);
                ExifAttribute f3 = ExifAttribute.f(readShort2, this.f3211h);
                this.f3209f[0].put("ImageLength", f2);
                this.f3209f[0].put("ImageWidth", f3);
                if (f3197u) {
                    Log.d("ExifInterface", "Updated to length: " + readShort + ", width: " + readShort2);
                    return;
                }
                return;
            }
            byteOrderedDataInputStream.k(readUnsignedShort2);
        }
    }

    private void k(SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream) throws IOException {
        ExifAttribute exifAttribute;
        E(seekableByteOrderedDataInputStream);
        I(seekableByteOrderedDataInputStream, 0);
        O(seekableByteOrderedDataInputStream, 0);
        O(seekableByteOrderedDataInputStream, 5);
        O(seekableByteOrderedDataInputStream, 4);
        P();
        if (this.f3207d == 8 && (exifAttribute = this.f3209f[1].get("MakerNote")) != null) {
            SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream2 = new SeekableByteOrderedDataInputStream(exifAttribute.f3236d);
            seekableByteOrderedDataInputStream2.i(this.f3211h);
            seekableByteOrderedDataInputStream2.k(6);
            I(seekableByteOrderedDataInputStream2, 9);
            ExifAttribute exifAttribute2 = this.f3209f[9].get("ColorSpace");
            if (exifAttribute2 != null) {
                this.f3209f[1].put("ColorSpace", exifAttribute2);
            }
        }
    }

    private void m(SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream) throws IOException {
        if (f3197u) {
            Log.d("ExifInterface", "getRw2Attributes starting with: " + seekableByteOrderedDataInputStream);
        }
        k(seekableByteOrderedDataInputStream);
        ExifAttribute exifAttribute = this.f3209f[0].get("JpgFromRaw");
        if (exifAttribute != null) {
            f(new ByteOrderedDataInputStream(exifAttribute.f3236d), (int) exifAttribute.f3235c, 5);
        }
        ExifAttribute exifAttribute2 = this.f3209f[0].get("ISO");
        ExifAttribute exifAttribute3 = this.f3209f[1].get("PhotographicSensitivity");
        if (exifAttribute2 != null && exifAttribute3 == null) {
            this.f3209f[1].put("PhotographicSensitivity", exifAttribute2);
        }
    }

    private void n(SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream) throws IOException {
        byte[] bArr = f3192p0;
        seekableByteOrderedDataInputStream.k(bArr.length);
        byte[] bArr2 = new byte[seekableByteOrderedDataInputStream.available()];
        seekableByteOrderedDataInputStream.readFully(bArr2);
        this.f3219p = bArr.length;
        H(bArr2, 0);
    }

    private void o(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        if (f3197u) {
            Log.d("ExifInterface", "getWebpAttributes starting with: " + byteOrderedDataInputStream);
        }
        byteOrderedDataInputStream.i(ByteOrder.LITTLE_ENDIAN);
        byteOrderedDataInputStream.k(K.length);
        int readInt = byteOrderedDataInputStream.readInt() + 8;
        byte[] bArr = L;
        byteOrderedDataInputStream.k(bArr.length);
        int length = bArr.length + 8;
        while (true) {
            try {
                byte[] bArr2 = new byte[4];
                if (byteOrderedDataInputStream.read(bArr2) == 4) {
                    int readInt2 = byteOrderedDataInputStream.readInt();
                    int i2 = length + 4 + 4;
                    if (Arrays.equals(M, bArr2)) {
                        byte[] bArr3 = new byte[readInt2];
                        if (byteOrderedDataInputStream.read(bArr3) == readInt2) {
                            this.f3219p = i2;
                            H(bArr3, 0);
                            L(new ByteOrderedDataInputStream(bArr3));
                            return;
                        }
                        throw new IOException("Failed to read given length for given PNG chunk type: " + ExifInterfaceUtils.a(bArr2));
                    }
                    if (readInt2 % 2 == 1) {
                        readInt2++;
                    }
                    length = i2 + readInt2;
                    if (length != readInt) {
                        if (length <= readInt) {
                            byteOrderedDataInputStream.k(readInt2);
                        } else {
                            throw new IOException("Encountered WebP file with invalid chunk size");
                        }
                    } else {
                        return;
                    }
                } else {
                    throw new IOException("Encountered invalid length while parsing WebP chunktype");
                }
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt WebP file.");
            }
        }
    }

    private void p(ByteOrderedDataInputStream byteOrderedDataInputStream, HashMap hashMap) throws IOException {
        ExifAttribute exifAttribute = (ExifAttribute) hashMap.get("JPEGInterchangeFormat");
        ExifAttribute exifAttribute2 = (ExifAttribute) hashMap.get("JPEGInterchangeFormatLength");
        if (exifAttribute != null && exifAttribute2 != null) {
            int i2 = exifAttribute.i(this.f3211h);
            int i3 = exifAttribute2.i(this.f3211h);
            if (this.f3207d == 7) {
                i2 += this.f3220q;
            }
            if (i2 > 0 && i3 > 0) {
                this.f3212i = true;
                if (this.f3204a == null && this.f3206c == null && this.f3205b == null) {
                    byte[] bArr = new byte[i3];
                    byteOrderedDataInputStream.skip((long) i2);
                    byteOrderedDataInputStream.read(bArr);
                    this.f3217n = bArr;
                }
                this.f3215l = i2;
                this.f3216m = i3;
            }
            if (f3197u) {
                Log.d("ExifInterface", "Setting thumbnail attributes with offset: " + i2 + ", length: " + i3);
            }
        }
    }

    private void q(ByteOrderedDataInputStream byteOrderedDataInputStream, HashMap hashMap) throws IOException {
        ByteOrderedDataInputStream byteOrderedDataInputStream2 = byteOrderedDataInputStream;
        HashMap hashMap2 = hashMap;
        ExifAttribute exifAttribute = (ExifAttribute) hashMap2.get("StripOffsets");
        ExifAttribute exifAttribute2 = (ExifAttribute) hashMap2.get("StripByteCounts");
        if (exifAttribute != null && exifAttribute2 != null) {
            long[] c2 = ExifInterfaceUtils.c(exifAttribute.k(this.f3211h));
            long[] c3 = ExifInterfaceUtils.c(exifAttribute2.k(this.f3211h));
            if (c2 == null || c2.length == 0) {
                Log.w("ExifInterface", "stripOffsets should not be null or have zero length.");
            } else if (c3 == null || c3.length == 0) {
                Log.w("ExifInterface", "stripByteCounts should not be null or have zero length.");
            } else if (c2.length != c3.length) {
                Log.w("ExifInterface", "stripOffsets and stripByteCounts should have same length.");
            } else {
                long j2 = 0;
                for (long j3 : c3) {
                    j2 += j3;
                }
                int i2 = (int) j2;
                byte[] bArr = new byte[i2];
                int i3 = 1;
                this.f3214k = true;
                this.f3213j = true;
                this.f3212i = true;
                int i4 = 0;
                int i5 = 0;
                int i6 = 0;
                while (i4 < c2.length) {
                    int i7 = (int) c2[i4];
                    int i8 = (int) c3[i4];
                    if (i4 < c2.length - i3 && ((long) (i7 + i8)) != c2[i4 + 1]) {
                        this.f3214k = false;
                    }
                    int i9 = i7 - i5;
                    if (i9 < 0) {
                        Log.d("ExifInterface", "Invalid strip offset value");
                        return;
                    }
                    long j4 = (long) i9;
                    if (byteOrderedDataInputStream2.skip(j4) != j4) {
                        Log.d("ExifInterface", "Failed to skip " + i9 + " bytes.");
                        return;
                    }
                    int i10 = i5 + i9;
                    byte[] bArr2 = new byte[i8];
                    if (byteOrderedDataInputStream2.read(bArr2) != i8) {
                        Log.d("ExifInterface", "Failed to read " + i8 + " bytes.");
                        return;
                    }
                    i5 = i10 + i8;
                    System.arraycopy(bArr2, 0, bArr, i6, i8);
                    i6 += i8;
                    i4++;
                    i3 = 1;
                }
                this.f3217n = bArr;
                if (this.f3214k) {
                    this.f3215l = (int) c2[0];
                    this.f3216m = i2;
                }
            }
        }
    }

    private void r(String str) throws IOException {
        if (str != null) {
            FileInputStream fileInputStream = null;
            this.f3206c = null;
            this.f3204a = str;
            try {
                FileInputStream fileInputStream2 = new FileInputStream(str);
                try {
                    if (z(fileInputStream2.getFD())) {
                        this.f3205b = fileInputStream2.getFD();
                    } else {
                        this.f3205b = null;
                    }
                    D(fileInputStream2);
                    ExifInterfaceUtils.b(fileInputStream2);
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    ExifInterfaceUtils.b(fileInputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                ExifInterfaceUtils.b(fileInputStream);
                throw th;
            }
        } else {
            throw new NullPointerException("filename cannot be null");
        }
    }

    private static boolean s(BufferedInputStream bufferedInputStream) throws IOException {
        byte[] bArr = f3192p0;
        bufferedInputStream.mark(bArr.length);
        byte[] bArr2 = new byte[bArr.length];
        bufferedInputStream.read(bArr2);
        bufferedInputStream.reset();
        int i2 = 0;
        while (true) {
            byte[] bArr3 = f3192p0;
            if (i2 >= bArr3.length) {
                return true;
            }
            if (bArr2[i2] != bArr3[i2]) {
                return false;
            }
            i2++;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:58:0x0092 A[Catch:{ all -> 0x008b }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00a1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean t(byte[] r15) throws java.io.IOException {
        /*
            r14 = this;
            r0 = 0
            r1 = 0
            androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream r2 = new androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream     // Catch:{ Exception -> 0x008d }
            r2.<init>((byte[]) r15)     // Catch:{ Exception -> 0x008d }
            int r1 = r2.readInt()     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            long r3 = (long) r1     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            r1 = 4
            byte[] r5 = new byte[r1]     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            r2.read(r5)     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            byte[] r6 = B     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            boolean r5 = java.util.Arrays.equals(r5, r6)     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            if (r5 != 0) goto L_0x001e
            r2.close()
            return r0
        L_0x001e:
            r5 = 8
            r7 = 1
            int r9 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r9 != 0) goto L_0x0034
            long r3 = r2.readLong()     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            r9 = 16
            int r11 = (r3 > r9 ? 1 : (r3 == r9 ? 0 : -1))
            if (r11 >= 0) goto L_0x0035
            r2.close()
            return r0
        L_0x0034:
            r9 = r5
        L_0x0035:
            int r11 = r15.length     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            long r11 = (long) r11     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            int r13 = (r3 > r11 ? 1 : (r3 == r11 ? 0 : -1))
            if (r13 <= 0) goto L_0x003d
            int r15 = r15.length     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            long r3 = (long) r15
        L_0x003d:
            long r3 = r3 - r9
            int r15 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r15 >= 0) goto L_0x0046
            r2.close()
            return r0
        L_0x0046:
            byte[] r15 = new byte[r1]     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            r5 = 0
            r9 = 0
            r10 = 0
        L_0x004c:
            r11 = 4
            long r11 = r3 / r11
            int r13 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r13 >= 0) goto L_0x0081
            int r11 = r2.read(r15)     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            if (r11 == r1) goto L_0x005e
            r2.close()
            return r0
        L_0x005e:
            int r11 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r11 != 0) goto L_0x0063
            goto L_0x007f
        L_0x0063:
            byte[] r11 = C     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            boolean r11 = java.util.Arrays.equals(r15, r11)     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            r12 = 1
            if (r11 == 0) goto L_0x006e
            r9 = 1
            goto L_0x0077
        L_0x006e:
            byte[] r11 = D     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            boolean r11 = java.util.Arrays.equals(r15, r11)     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            if (r11 == 0) goto L_0x0077
            r10 = 1
        L_0x0077:
            if (r9 == 0) goto L_0x007f
            if (r10 == 0) goto L_0x007f
            r2.close()
            return r12
        L_0x007f:
            long r5 = r5 + r7
            goto L_0x004c
        L_0x0081:
            r2.close()
            goto L_0x009e
        L_0x0085:
            r15 = move-exception
            r1 = r2
            goto L_0x009f
        L_0x0088:
            r15 = move-exception
            r1 = r2
            goto L_0x008e
        L_0x008b:
            r15 = move-exception
            goto L_0x009f
        L_0x008d:
            r15 = move-exception
        L_0x008e:
            boolean r2 = f3197u     // Catch:{ all -> 0x008b }
            if (r2 == 0) goto L_0x0099
            java.lang.String r2 = "ExifInterface"
            java.lang.String r3 = "Exception parsing HEIF file type box."
            android.util.Log.d(r2, r3, r15)     // Catch:{ all -> 0x008b }
        L_0x0099:
            if (r1 == 0) goto L_0x009e
            r1.close()
        L_0x009e:
            return r0
        L_0x009f:
            if (r1 == 0) goto L_0x00a4
            r1.close()
        L_0x00a4:
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.t(byte[]):boolean");
    }

    private static boolean u(byte[] bArr) throws IOException {
        int i2 = 0;
        while (true) {
            byte[] bArr2 = A;
            if (i2 >= bArr2.length) {
                return true;
            }
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
            i2++;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x002a  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0031  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean v(byte[] r4) throws java.io.IOException {
        /*
            r3 = this;
            r0 = 0
            r1 = 0
            androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream r2 = new androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream     // Catch:{ Exception -> 0x002e, all -> 0x0027 }
            r2.<init>((byte[]) r4)     // Catch:{ Exception -> 0x002e, all -> 0x0027 }
            java.nio.ByteOrder r4 = r3.G(r2)     // Catch:{ Exception -> 0x0024, all -> 0x0021 }
            r3.f3211h = r4     // Catch:{ Exception -> 0x0024, all -> 0x0021 }
            r2.i(r4)     // Catch:{ Exception -> 0x0024, all -> 0x0021 }
            short r4 = r2.readShort()     // Catch:{ Exception -> 0x0024, all -> 0x0021 }
            r1 = 20306(0x4f52, float:2.8455E-41)
            if (r4 == r1) goto L_0x001c
            r1 = 21330(0x5352, float:2.989E-41)
            if (r4 != r1) goto L_0x001d
        L_0x001c:
            r0 = 1
        L_0x001d:
            r2.close()
            return r0
        L_0x0021:
            r4 = move-exception
            r1 = r2
            goto L_0x0028
        L_0x0024:
            r1 = r2
            goto L_0x002f
        L_0x0027:
            r4 = move-exception
        L_0x0028:
            if (r1 == 0) goto L_0x002d
            r1.close()
        L_0x002d:
            throw r4
        L_0x002e:
        L_0x002f:
            if (r1 == 0) goto L_0x0034
            r1.close()
        L_0x0034:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.v(byte[]):boolean");
    }

    private boolean w(byte[] bArr) throws IOException {
        int i2 = 0;
        while (true) {
            byte[] bArr2 = G;
            if (i2 >= bArr2.length) {
                return true;
            }
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
            i2++;
        }
    }

    private boolean x(byte[] bArr) throws IOException {
        byte[] bytes = "FUJIFILMCCD-RAW".getBytes(Charset.defaultCharset());
        for (int i2 = 0; i2 < bytes.length; i2++) {
            if (bArr[i2] != bytes[i2]) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0026  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x002d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean y(byte[] r4) throws java.io.IOException {
        /*
            r3 = this;
            r0 = 0
            r1 = 0
            androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream r2 = new androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream     // Catch:{ Exception -> 0x002a, all -> 0x0023 }
            r2.<init>((byte[]) r4)     // Catch:{ Exception -> 0x002a, all -> 0x0023 }
            java.nio.ByteOrder r4 = r3.G(r2)     // Catch:{ Exception -> 0x0020, all -> 0x001d }
            r3.f3211h = r4     // Catch:{ Exception -> 0x0020, all -> 0x001d }
            r2.i(r4)     // Catch:{ Exception -> 0x0020, all -> 0x001d }
            short r4 = r2.readShort()     // Catch:{ Exception -> 0x0020, all -> 0x001d }
            r1 = 85
            if (r4 != r1) goto L_0x0019
            r0 = 1
        L_0x0019:
            r2.close()
            return r0
        L_0x001d:
            r4 = move-exception
            r1 = r2
            goto L_0x0024
        L_0x0020:
            r1 = r2
            goto L_0x002b
        L_0x0023:
            r4 = move-exception
        L_0x0024:
            if (r1 == 0) goto L_0x0029
            r1.close()
        L_0x0029:
            throw r4
        L_0x002a:
        L_0x002b:
            if (r1 == 0) goto L_0x0030
            r1.close()
        L_0x0030:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.y(byte[]):boolean");
    }

    private static boolean z(FileDescriptor fileDescriptor) {
        try {
            ExifInterfaceUtils.Api21Impl.c(fileDescriptor, 0, OsConstants.SEEK_CUR);
            return true;
        } catch (Exception unused) {
            if (!f3197u) {
                return false;
            }
            Log.d("ExifInterface", "The file descriptor for the given input is not seekable");
            return false;
        }
    }

    public String b(String str) {
        if (str != null) {
            ExifAttribute d2 = d(str);
            if (d2 != null) {
                if (!f3189m0.contains(str)) {
                    return d2.j(this.f3211h);
                }
                if (str.equals("GPSTimeStamp")) {
                    int i2 = d2.f3233a;
                    if (i2 == 5 || i2 == 10) {
                        Rational[] rationalArr = (Rational[]) d2.k(this.f3211h);
                        if (rationalArr == null || rationalArr.length != 3) {
                            Log.w("ExifInterface", "Invalid GPS Timestamp array. array=" + Arrays.toString(rationalArr));
                            return null;
                        }
                        Rational rational = rationalArr[0];
                        Rational rational2 = rationalArr[1];
                        Rational rational3 = rationalArr[2];
                        return String.format("%02d:%02d:%02d", new Object[]{Integer.valueOf((int) (((float) rational.f3241a) / ((float) rational.f3242b))), Integer.valueOf((int) (((float) rational2.f3241a) / ((float) rational2.f3242b))), Integer.valueOf((int) (((float) rational3.f3241a) / ((float) rational3.f3242b)))});
                    }
                    Log.w("ExifInterface", "GPS Timestamp format is not rational. format=" + d2.f3233a);
                    return null;
                }
                try {
                    return Double.toString(d2.h(this.f3211h));
                } catch (NumberFormatException unused) {
                }
            }
            return null;
        }
        throw new NullPointerException("tag shouldn't be null");
    }

    public int c(String str, int i2) {
        if (str != null) {
            ExifAttribute d2 = d(str);
            if (d2 == null) {
                return i2;
            }
            try {
                return d2.i(this.f3211h);
            } catch (NumberFormatException unused) {
                return i2;
            }
        } else {
            throw new NullPointerException("tag shouldn't be null");
        }
    }

    public int l() {
        switch (c("Orientation", 1)) {
            case 3:
            case 4:
                return RotationOptions.ROTATE_180;
            case 5:
            case 8:
                return RotationOptions.ROTATE_270;
            case 6:
            case 7:
                return 90;
            default:
                return 0;
        }
    }

    private static class SeekableByteOrderedDataInputStream extends ByteOrderedDataInputStream {
        SeekableByteOrderedDataInputStream(byte[] bArr) throws IOException {
            super(bArr);
            this.f3229b.mark(Integer.MAX_VALUE);
        }

        public void q(long j2) throws IOException {
            int i2 = this.f3231d;
            if (((long) i2) > j2) {
                this.f3231d = 0;
                this.f3229b.reset();
            } else {
                j2 -= (long) i2;
            }
            k((int) j2);
        }

        SeekableByteOrderedDataInputStream(InputStream inputStream) throws IOException {
            super(inputStream);
            if (inputStream.markSupported()) {
                this.f3229b.mark(Integer.MAX_VALUE);
                return;
            }
            throw new IllegalArgumentException("Cannot create SeekableByteOrderedDataInputStream with stream that does not support mark/reset");
        }
    }

    static class ExifTag {

        /* renamed from: a  reason: collision with root package name */
        public final int f3237a;

        /* renamed from: b  reason: collision with root package name */
        public final String f3238b;

        /* renamed from: c  reason: collision with root package name */
        public final int f3239c;

        /* renamed from: d  reason: collision with root package name */
        public final int f3240d;

        ExifTag(String str, int i2, int i3) {
            this.f3238b = str;
            this.f3237a = i2;
            this.f3239c = i3;
            this.f3240d = -1;
        }

        /* access modifiers changed from: package-private */
        public boolean a(int i2) {
            int i3;
            int i4 = this.f3239c;
            if (i4 == 7 || i2 == 7 || i4 == i2 || (i3 = this.f3240d) == i2) {
                return true;
            }
            if ((i4 == 4 || i3 == 4) && i2 == 3) {
                return true;
            }
            if ((i4 == 9 || i3 == 9) && i2 == 8) {
                return true;
            }
            if ((i4 == 12 || i3 == 12) && i2 == 11) {
                return true;
            }
            return false;
        }

        ExifTag(String str, int i2, int i3, int i4) {
            this.f3238b = str;
            this.f3237a = i2;
            this.f3239c = i3;
            this.f3240d = i4;
        }
    }

    public ExifInterface(InputStream inputStream) throws IOException {
        this(inputStream, 0);
    }

    public ExifInterface(InputStream inputStream, int i2) throws IOException {
        ExifTag[][] exifTagArr = f3185i0;
        this.f3209f = new HashMap[exifTagArr.length];
        this.f3210g = new HashSet(exifTagArr.length);
        this.f3211h = ByteOrder.BIG_ENDIAN;
        if (inputStream != null) {
            this.f3204a = null;
            if (i2 == 1) {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, f3192p0.length);
                if (!s(bufferedInputStream)) {
                    Log.w("ExifInterface", "Given data does not follow the structure of an Exif-only data.");
                    return;
                }
                this.f3208e = true;
                this.f3206c = null;
                this.f3205b = null;
                inputStream = bufferedInputStream;
            } else if (inputStream instanceof AssetManager.AssetInputStream) {
                this.f3206c = (AssetManager.AssetInputStream) inputStream;
                this.f3205b = null;
            } else {
                if (inputStream instanceof FileInputStream) {
                    FileInputStream fileInputStream = (FileInputStream) inputStream;
                    if (z(fileInputStream.getFD())) {
                        this.f3206c = null;
                        this.f3205b = fileInputStream.getFD();
                    }
                }
                this.f3206c = null;
                this.f3205b = null;
            }
            D(inputStream);
            return;
        }
        throw new NullPointerException("inputStream cannot be null");
    }
}
