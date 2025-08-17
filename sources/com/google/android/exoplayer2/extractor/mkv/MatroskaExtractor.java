package com.google.android.exoplayer2.extractor.mkv;

import android.util.Pair;
import android.util.SparseArray;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imageutils.JfifUtil;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.TrueHdSampleRechunker;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.LongArray;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.ColorInfo;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.startapp.y1;
import com.unity3d.services.core.device.MimeTypes;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public class MatroskaExtractor implements Extractor {

    /* renamed from: c0  reason: collision with root package name */
    public static final ExtractorsFactory f24424c0 = new a();

    /* renamed from: d0  reason: collision with root package name */
    private static final byte[] f24425d0 = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
    /* access modifiers changed from: private */

    /* renamed from: e0  reason: collision with root package name */
    public static final byte[] f24426e0 = Util.p0("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");

    /* renamed from: f0  reason: collision with root package name */
    private static final byte[] f24427f0 = {68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};

    /* renamed from: g0  reason: collision with root package name */
    private static final byte[] f24428g0 = {87, 69, 66, 86, 84, 84, 10, 10, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 10};
    /* access modifiers changed from: private */

    /* renamed from: h0  reason: collision with root package name */
    public static final UUID f24429h0 = new UUID(72057594037932032L, -9223371306706625679L);
    /* access modifiers changed from: private */

    /* renamed from: i0  reason: collision with root package name */
    public static final Map<String, Integer> f24430i0;
    private long A;
    private long B;
    private LongArray C;
    private LongArray D;
    private boolean E;
    private boolean F;
    private int G;
    private long H;
    private long I;
    private int J;
    private int K;
    private int[] L;
    private int M;
    private int N;
    private int O;
    private int P;
    private boolean Q;
    private long R;
    private int S;
    private int T;
    private int U;
    private boolean V;
    private boolean W;
    private boolean X;
    private int Y;
    private byte Z;

    /* renamed from: a  reason: collision with root package name */
    private final EbmlReader f24431a;

    /* renamed from: a0  reason: collision with root package name */
    private boolean f24432a0;

    /* renamed from: b  reason: collision with root package name */
    private final VarintReader f24433b;

    /* renamed from: b0  reason: collision with root package name */
    private ExtractorOutput f24434b0;

    /* renamed from: c  reason: collision with root package name */
    private final SparseArray<Track> f24435c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f24436d;

    /* renamed from: e  reason: collision with root package name */
    private final ParsableByteArray f24437e;

    /* renamed from: f  reason: collision with root package name */
    private final ParsableByteArray f24438f;

    /* renamed from: g  reason: collision with root package name */
    private final ParsableByteArray f24439g;

    /* renamed from: h  reason: collision with root package name */
    private final ParsableByteArray f24440h;

    /* renamed from: i  reason: collision with root package name */
    private final ParsableByteArray f24441i;

    /* renamed from: j  reason: collision with root package name */
    private final ParsableByteArray f24442j;

    /* renamed from: k  reason: collision with root package name */
    private final ParsableByteArray f24443k;

    /* renamed from: l  reason: collision with root package name */
    private final ParsableByteArray f24444l;

    /* renamed from: m  reason: collision with root package name */
    private final ParsableByteArray f24445m;

    /* renamed from: n  reason: collision with root package name */
    private final ParsableByteArray f24446n;

    /* renamed from: o  reason: collision with root package name */
    private ByteBuffer f24447o;

    /* renamed from: p  reason: collision with root package name */
    private long f24448p;

    /* renamed from: q  reason: collision with root package name */
    private long f24449q;

    /* renamed from: r  reason: collision with root package name */
    private long f24450r;

    /* renamed from: s  reason: collision with root package name */
    private long f24451s;

    /* renamed from: t  reason: collision with root package name */
    private long f24452t;

    /* renamed from: u  reason: collision with root package name */
    private Track f24453u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f24454v;

    /* renamed from: w  reason: collision with root package name */
    private int f24455w;

    /* renamed from: x  reason: collision with root package name */
    private long f24456x;

    /* renamed from: y  reason: collision with root package name */
    private boolean f24457y;

    /* renamed from: z  reason: collision with root package name */
    private long f24458z;

    private final class InnerEbmlProcessor implements EbmlProcessor {
        private InnerEbmlProcessor() {
        }

        public void a(int i2) throws ParserException {
            MatroskaExtractor.this.o(i2);
        }

        public void b(int i2, double d2) throws ParserException {
            MatroskaExtractor.this.r(i2, d2);
        }

        public void c(int i2, long j2) throws ParserException {
            MatroskaExtractor.this.x(i2, j2);
        }

        public int d(int i2) {
            return MatroskaExtractor.this.u(i2);
        }

        public boolean e(int i2) {
            return MatroskaExtractor.this.z(i2);
        }

        public void f(int i2, String str) throws ParserException {
            MatroskaExtractor.this.H(i2, str);
        }

        public void g(int i2, long j2, long j3) throws ParserException {
            MatroskaExtractor.this.G(i2, j2, j3);
        }

        public void h(int i2, int i3, ExtractorInput extractorInput) throws IOException {
            MatroskaExtractor.this.l(i2, i3, extractorInput);
        }
    }

    protected static final class Track {
        public int A = -1;
        public int B = 1000;
        public int C = 200;
        public float D = -1.0f;
        public float E = -1.0f;
        public float F = -1.0f;
        public float G = -1.0f;
        public float H = -1.0f;
        public float I = -1.0f;
        public float J = -1.0f;
        public float K = -1.0f;
        public float L = -1.0f;
        public float M = -1.0f;
        public byte[] N;
        public int O = 1;
        public int P = -1;
        public int Q = 8000;
        public long R = 0;
        public long S = 0;
        public TrueHdSampleRechunker T;
        public boolean U;
        public boolean V = true;
        /* access modifiers changed from: private */
        public String W = "eng";
        public TrackOutput X;
        public int Y;

        /* renamed from: a  reason: collision with root package name */
        public String f24460a;

        /* renamed from: b  reason: collision with root package name */
        public String f24461b;

        /* renamed from: c  reason: collision with root package name */
        public int f24462c;

        /* renamed from: d  reason: collision with root package name */
        public int f24463d;

        /* renamed from: e  reason: collision with root package name */
        public int f24464e;

        /* renamed from: f  reason: collision with root package name */
        public int f24465f;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public int f24466g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f24467h;

        /* renamed from: i  reason: collision with root package name */
        public byte[] f24468i;

        /* renamed from: j  reason: collision with root package name */
        public TrackOutput.CryptoData f24469j;

        /* renamed from: k  reason: collision with root package name */
        public byte[] f24470k;

        /* renamed from: l  reason: collision with root package name */
        public DrmInitData f24471l;

        /* renamed from: m  reason: collision with root package name */
        public int f24472m = -1;

        /* renamed from: n  reason: collision with root package name */
        public int f24473n = -1;

        /* renamed from: o  reason: collision with root package name */
        public int f24474o = -1;

        /* renamed from: p  reason: collision with root package name */
        public int f24475p = -1;

        /* renamed from: q  reason: collision with root package name */
        public int f24476q = 0;

        /* renamed from: r  reason: collision with root package name */
        public int f24477r = -1;

        /* renamed from: s  reason: collision with root package name */
        public float f24478s = 0.0f;

        /* renamed from: t  reason: collision with root package name */
        public float f24479t = 0.0f;

        /* renamed from: u  reason: collision with root package name */
        public float f24480u = 0.0f;

        /* renamed from: v  reason: collision with root package name */
        public byte[] f24481v = null;

        /* renamed from: w  reason: collision with root package name */
        public int f24482w = -1;

        /* renamed from: x  reason: collision with root package name */
        public boolean f24483x = false;

        /* renamed from: y  reason: collision with root package name */
        public int f24484y = -1;

        /* renamed from: z  reason: collision with root package name */
        public int f24485z = -1;

        protected Track() {
        }

        /* access modifiers changed from: private */
        @EnsuresNonNull({"output"})
        public void f() {
            Assertions.e(this.X);
        }

        @EnsuresNonNull({"codecPrivate"})
        private byte[] g(String str) throws ParserException {
            byte[] bArr = this.f24470k;
            if (bArr != null) {
                return bArr;
            }
            throw ParserException.a("Missing CodecPrivate for codec " + str, (Throwable) null);
        }

        private byte[] h() {
            if (this.D == -1.0f || this.E == -1.0f || this.F == -1.0f || this.G == -1.0f || this.H == -1.0f || this.I == -1.0f || this.J == -1.0f || this.K == -1.0f || this.L == -1.0f || this.M == -1.0f) {
                return null;
            }
            byte[] bArr = new byte[25];
            ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
            order.put((byte) 0);
            order.putShort((short) ((int) ((this.D * 50000.0f) + 0.5f)));
            order.putShort((short) ((int) ((this.E * 50000.0f) + 0.5f)));
            order.putShort((short) ((int) ((this.F * 50000.0f) + 0.5f)));
            order.putShort((short) ((int) ((this.G * 50000.0f) + 0.5f)));
            order.putShort((short) ((int) ((this.H * 50000.0f) + 0.5f)));
            order.putShort((short) ((int) ((this.I * 50000.0f) + 0.5f)));
            order.putShort((short) ((int) ((this.J * 50000.0f) + 0.5f)));
            order.putShort((short) ((int) ((this.K * 50000.0f) + 0.5f)));
            order.putShort((short) ((int) (this.L + 0.5f)));
            order.putShort((short) ((int) (this.M + 0.5f)));
            order.putShort((short) this.B);
            order.putShort((short) this.C);
            return bArr;
        }

        private static Pair<String, List<byte[]>> k(ParsableByteArray parsableByteArray) throws ParserException {
            try {
                parsableByteArray.V(16);
                long x2 = parsableByteArray.x();
                if (x2 == 1482049860) {
                    return new Pair<>("video/divx", (Object) null);
                }
                if (x2 == 859189832) {
                    return new Pair<>("video/3gpp", (Object) null);
                }
                if (x2 == 826496599) {
                    byte[] e2 = parsableByteArray.e();
                    for (int f2 = parsableByteArray.f() + 20; f2 < e2.length - 4; f2++) {
                        if (e2[f2] == 0 && e2[f2 + 1] == 0 && e2[f2 + 2] == 1 && e2[f2 + 3] == 15) {
                            return new Pair<>("video/wvc1", Collections.singletonList(Arrays.copyOfRange(e2, f2, e2.length)));
                        }
                    }
                    throw ParserException.a("Failed to find FourCC VC1 initialization data", (Throwable) null);
                }
                Log.i("MatroskaExtractor", "Unknown FourCC. Setting mimeType to video/x-unknown");
                return new Pair<>("video/x-unknown", (Object) null);
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw ParserException.a("Error parsing FourCC private data", (Throwable) null);
            }
        }

        private static boolean l(ParsableByteArray parsableByteArray) throws ParserException {
            try {
                int z2 = parsableByteArray.z();
                if (z2 == 1) {
                    return true;
                }
                if (z2 != 65534) {
                    return false;
                }
                parsableByteArray.U(24);
                if (parsableByteArray.A() == MatroskaExtractor.f24429h0.getMostSignificantBits() && parsableByteArray.A() == MatroskaExtractor.f24429h0.getLeastSignificantBits()) {
                    return true;
                }
                return false;
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw ParserException.a("Error parsing MS/ACM codec private", (Throwable) null);
            }
        }

        private static List<byte[]> m(byte[] bArr) throws ParserException {
            byte b2;
            byte b3;
            try {
                if (bArr[0] == 2) {
                    int i2 = 1;
                    int i3 = 0;
                    while (true) {
                        b2 = bArr[i2];
                        if ((b2 & 255) != 255) {
                            break;
                        }
                        i3 += JfifUtil.MARKER_FIRST_BYTE;
                        i2++;
                    }
                    int i4 = i2 + 1;
                    int i5 = i3 + (b2 & 255);
                    int i6 = 0;
                    while (true) {
                        b3 = bArr[i4];
                        if ((b3 & 255) != 255) {
                            break;
                        }
                        i6 += JfifUtil.MARKER_FIRST_BYTE;
                        i4++;
                    }
                    int i7 = i4 + 1;
                    int i8 = i6 + (b3 & 255);
                    if (bArr[i7] == 1) {
                        byte[] bArr2 = new byte[i5];
                        System.arraycopy(bArr, i7, bArr2, 0, i5);
                        int i9 = i7 + i5;
                        if (bArr[i9] == 3) {
                            int i10 = i9 + i8;
                            if (bArr[i10] == 5) {
                                byte[] bArr3 = new byte[(bArr.length - i10)];
                                System.arraycopy(bArr, i10, bArr3, 0, bArr.length - i10);
                                ArrayList arrayList = new ArrayList(2);
                                arrayList.add(bArr2);
                                arrayList.add(bArr3);
                                return arrayList;
                            }
                            throw ParserException.a("Error parsing vorbis codec private", (Throwable) null);
                        }
                        throw ParserException.a("Error parsing vorbis codec private", (Throwable) null);
                    }
                    throw ParserException.a("Error parsing vorbis codec private", (Throwable) null);
                }
                throw ParserException.a("Error parsing vorbis codec private", (Throwable) null);
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw ParserException.a("Error parsing vorbis codec private", (Throwable) null);
            }
        }

        /* access modifiers changed from: private */
        public boolean o(boolean z2) {
            if ("A_OPUS".equals(this.f24461b)) {
                return z2;
            }
            if (this.f24465f > 0) {
                return true;
            }
            return false;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v16, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v13, resolved type: java.lang.String} */
        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* JADX WARNING: Code restructure failed: missing block: B:117:0x02a5, code lost:
            r4 = r1;
            r1 = null;
            r3 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:132:0x030c, code lost:
            r1 = null;
            r3 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:133:0x030e, code lost:
            r4 = -1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:134:0x030f, code lost:
            r6 = -1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:142:0x0362, code lost:
            r4 = -1;
            r6 = -1;
            r18 = r3;
            r3 = r1;
            r1 = r18;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:145:0x0398, code lost:
            r3 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:148:0x03a0, code lost:
            r1 = null;
            r3 = null;
            r4 = -1;
            r6 = com.google.protobuf.CodedOutputStream.DEFAULT_BUFFER_SIZE;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:157:0x040f, code lost:
            r1 = null;
            r3 = null;
            r17 = "audio/x-unknown";
         */
        /* JADX WARNING: Code restructure failed: missing block: B:164:0x0425, code lost:
            if (r0.N == null) goto L_0x0438;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:165:0x0427, code lost:
            r7 = com.google.android.exoplayer2.video.DolbyVisionConfig.a(new com.google.android.exoplayer2.util.ParsableByteArray(r0.N));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:166:0x0432, code lost:
            if (r7 == null) goto L_0x0438;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:167:0x0434, code lost:
            r3 = r7.f28851c;
            r17 = "video/dolby-vision";
         */
        /* JADX WARNING: Code restructure failed: missing block: B:168:0x0438, code lost:
            r7 = r17;
            r10 = r0.V | 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:169:0x0440, code lost:
            if (r0.U == false) goto L_0x0444;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:170:0x0442, code lost:
            r9 = 2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:171:0x0444, code lost:
            r9 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:172:0x0445, code lost:
            r9 = r9 | r10;
            r10 = new com.google.android.exoplayer2.Format.Builder();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:173:0x044f, code lost:
            if (com.google.android.exoplayer2.util.MimeTypes.o(r7) == false) goto L_0x0463;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:174:0x0451, code lost:
            r10.J(r0.O).h0(r0.Q).a0(r4);
            r5 = 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:176:0x0467, code lost:
            if (com.google.android.exoplayer2.util.MimeTypes.s(r7) == false) goto L_0x053e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:178:0x046b, code lost:
            if (r0.f24476q != 0) goto L_0x047f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:179:0x046d, code lost:
            r2 = r0.f24474o;
            r4 = -1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:180:0x0470, code lost:
            if (r2 != -1) goto L_0x0474;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:181:0x0472, code lost:
            r2 = r0.f24472m;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:182:0x0474, code lost:
            r0.f24474o = r2;
            r2 = r0.f24475p;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:183:0x0478, code lost:
            if (r2 != -1) goto L_0x047c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:184:0x047a, code lost:
            r2 = r0.f24473n;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:185:0x047c, code lost:
            r0.f24475p = r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:186:0x047f, code lost:
            r4 = -1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:187:0x0480, code lost:
            r2 = r0.f24474o;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:188:0x0482, code lost:
            if (r2 == r4) goto L_0x0494;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:189:0x0484, code lost:
            r5 = r0.f24475p;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:190:0x0486, code lost:
            if (r5 == r4) goto L_0x0494;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:191:0x0488, code lost:
            r2 = ((float) (r0.f24473n * r2)) / ((float) (r0.f24472m * r5));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:192:0x0494, code lost:
            r2 = -1.0f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:194:0x0498, code lost:
            if (r0.f24483x == false) goto L_0x04a9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:195:0x049a, code lost:
            r8 = new com.google.android.exoplayer2.video.ColorInfo(r0.f24484y, r0.A, r0.f24485z, h());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:197:0x04ab, code lost:
            if (r0.f24460a == null) goto L_0x04c9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:199:0x04b7, code lost:
            if (com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.e().containsKey(r0.f24460a) == false) goto L_0x04c9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:200:0x04b9, code lost:
            r4 = ((java.lang.Integer) com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.e().get(r0.f24460a)).intValue();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:202:0x04cb, code lost:
            if (r0.f24477r != 0) goto L_0x0519;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:204:0x04d4, code lost:
            if (java.lang.Float.compare(r0.f24478s, 0.0f) != 0) goto L_0x0519;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:206:0x04dc, code lost:
            if (java.lang.Float.compare(r0.f24479t, 0.0f) != 0) goto L_0x0519;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:208:0x04e4, code lost:
            if (java.lang.Float.compare(r0.f24480u, 0.0f) != 0) goto L_0x04e8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:209:0x04e6, code lost:
            r4 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:211:0x04f0, code lost:
            if (java.lang.Float.compare(r0.f24479t, 90.0f) != 0) goto L_0x04f5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:212:0x04f2, code lost:
            r4 = 90;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:214:0x04fd, code lost:
            if (java.lang.Float.compare(r0.f24479t, -180.0f) == 0) goto L_0x0517;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:216:0x0507, code lost:
            if (java.lang.Float.compare(r0.f24479t, 180.0f) != 0) goto L_0x050a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:218:0x0512, code lost:
            if (java.lang.Float.compare(r0.f24479t, -90.0f) != 0) goto L_0x0519;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:219:0x0514, code lost:
            r4 = com.facebook.imagepipeline.common.RotationOptions.ROTATE_270;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:220:0x0517, code lost:
            r4 = com.facebook.imagepipeline.common.RotationOptions.ROTATE_180;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:221:0x0519, code lost:
            r10.n0(r0.f24472m).S(r0.f24473n).c0(r2).f0(r4).d0(r0.f24481v).j0(r0.f24482w).L(r8);
            r5 = 2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:223:0x0542, code lost:
            if ("application/x-subrip".equals(r7) != false) goto L_0x056a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:225:0x0548, code lost:
            if ("text/x-ssa".equals(r7) != false) goto L_0x056a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:227:0x054e, code lost:
            if ("text/vtt".equals(r7) != false) goto L_0x056a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:229:0x0554, code lost:
            if ("application/vobsub".equals(r7) != false) goto L_0x056a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:231:0x055a, code lost:
            if ("application/pgs".equals(r7) != false) goto L_0x056a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:233:0x0560, code lost:
            if ("application/dvbsubs".equals(r7) == false) goto L_0x0563;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:235:0x0569, code lost:
            throw com.google.android.exoplayer2.ParserException.a("Unexpected MIME type.", (java.lang.Throwable) null);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:236:0x056a, code lost:
            r5 = 3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:238:0x056d, code lost:
            if (r0.f24460a == null) goto L_0x0580;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:240:0x0579, code lost:
            if (com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.e().containsKey(r0.f24460a) != false) goto L_0x0580;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:241:0x057b, code lost:
            r10.W(r0.f24460a);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:242:0x0580, code lost:
            r1 = r10.T(r21).g0(r7).Y(r6).X(r0.W).i0(r9).V(r1).K(r3).O(r0.f24471l).G();
            r2 = r20.d(r0.f24462c, r5);
            r0.X = r2;
            r2.d(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:243:0x05b7, code lost:
            return;
         */
        /* JADX WARNING: Multi-variable type inference failed */
        @org.checkerframework.checker.nullness.qual.RequiresNonNull({"codecId"})
        @org.checkerframework.checker.nullness.qual.EnsuresNonNull({"this.output"})
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void i(com.google.android.exoplayer2.extractor.ExtractorOutput r20, int r21) throws com.google.android.exoplayer2.ParserException {
            /*
                r19 = this;
                r0 = r19
                java.lang.String r1 = r0.f24461b
                r1.hashCode()
                int r2 = r1.hashCode()
                r3 = 32
                r4 = 16
                r7 = 8
                r9 = 3
                switch(r2) {
                    case -2095576542: goto L_0x01c1;
                    case -2095575984: goto L_0x01b5;
                    case -1985379776: goto L_0x01a9;
                    case -1784763192: goto L_0x019d;
                    case -1730367663: goto L_0x0191;
                    case -1482641358: goto L_0x0185;
                    case -1482641357: goto L_0x0179;
                    case -1373388978: goto L_0x016d;
                    case -933872740: goto L_0x015f;
                    case -538363189: goto L_0x0151;
                    case -538363109: goto L_0x0143;
                    case -425012669: goto L_0x0135;
                    case -356037306: goto L_0x0127;
                    case 62923557: goto L_0x0119;
                    case 62923603: goto L_0x010b;
                    case 62927045: goto L_0x00fd;
                    case 82318131: goto L_0x00ef;
                    case 82338133: goto L_0x00e1;
                    case 82338134: goto L_0x00d3;
                    case 99146302: goto L_0x00c5;
                    case 444813526: goto L_0x00b7;
                    case 542569478: goto L_0x00a9;
                    case 635596514: goto L_0x009b;
                    case 725948237: goto L_0x008d;
                    case 725957860: goto L_0x0080;
                    case 738597099: goto L_0x0073;
                    case 855502857: goto L_0x0066;
                    case 1045209816: goto L_0x0059;
                    case 1422270023: goto L_0x004c;
                    case 1809237540: goto L_0x003f;
                    case 1950749482: goto L_0x0032;
                    case 1950789798: goto L_0x0025;
                    case 1951062397: goto L_0x0018;
                    default: goto L_0x0015;
                }
            L_0x0015:
                r1 = -1
                goto L_0x01cc
            L_0x0018:
                java.lang.String r2 = "A_OPUS"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0021
                goto L_0x0015
            L_0x0021:
                r1 = 32
                goto L_0x01cc
            L_0x0025:
                java.lang.String r2 = "A_FLAC"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x002e
                goto L_0x0015
            L_0x002e:
                r1 = 31
                goto L_0x01cc
            L_0x0032:
                java.lang.String r2 = "A_EAC3"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x003b
                goto L_0x0015
            L_0x003b:
                r1 = 30
                goto L_0x01cc
            L_0x003f:
                java.lang.String r2 = "V_MPEG2"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0048
                goto L_0x0015
            L_0x0048:
                r1 = 29
                goto L_0x01cc
            L_0x004c:
                java.lang.String r2 = "S_TEXT/UTF8"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0055
                goto L_0x0015
            L_0x0055:
                r1 = 28
                goto L_0x01cc
            L_0x0059:
                java.lang.String r2 = "S_TEXT/WEBVTT"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0062
                goto L_0x0015
            L_0x0062:
                r1 = 27
                goto L_0x01cc
            L_0x0066:
                java.lang.String r2 = "V_MPEGH/ISO/HEVC"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x006f
                goto L_0x0015
            L_0x006f:
                r1 = 26
                goto L_0x01cc
            L_0x0073:
                java.lang.String r2 = "S_TEXT/ASS"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x007c
                goto L_0x0015
            L_0x007c:
                r1 = 25
                goto L_0x01cc
            L_0x0080:
                java.lang.String r2 = "A_PCM/INT/LIT"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0089
                goto L_0x0015
            L_0x0089:
                r1 = 24
                goto L_0x01cc
            L_0x008d:
                java.lang.String r2 = "A_PCM/INT/BIG"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0097
                goto L_0x0015
            L_0x0097:
                r1 = 23
                goto L_0x01cc
            L_0x009b:
                java.lang.String r2 = "A_PCM/FLOAT/IEEE"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x00a5
                goto L_0x0015
            L_0x00a5:
                r1 = 22
                goto L_0x01cc
            L_0x00a9:
                java.lang.String r2 = "A_DTS/EXPRESS"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x00b3
                goto L_0x0015
            L_0x00b3:
                r1 = 21
                goto L_0x01cc
            L_0x00b7:
                java.lang.String r2 = "V_THEORA"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x00c1
                goto L_0x0015
            L_0x00c1:
                r1 = 20
                goto L_0x01cc
            L_0x00c5:
                java.lang.String r2 = "S_HDMV/PGS"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x00cf
                goto L_0x0015
            L_0x00cf:
                r1 = 19
                goto L_0x01cc
            L_0x00d3:
                java.lang.String r2 = "V_VP9"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x00dd
                goto L_0x0015
            L_0x00dd:
                r1 = 18
                goto L_0x01cc
            L_0x00e1:
                java.lang.String r2 = "V_VP8"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x00eb
                goto L_0x0015
            L_0x00eb:
                r1 = 17
                goto L_0x01cc
            L_0x00ef:
                java.lang.String r2 = "V_AV1"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x00f9
                goto L_0x0015
            L_0x00f9:
                r1 = 16
                goto L_0x01cc
            L_0x00fd:
                java.lang.String r2 = "A_DTS"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0107
                goto L_0x0015
            L_0x0107:
                r1 = 15
                goto L_0x01cc
            L_0x010b:
                java.lang.String r2 = "A_AC3"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0115
                goto L_0x0015
            L_0x0115:
                r1 = 14
                goto L_0x01cc
            L_0x0119:
                java.lang.String r2 = "A_AAC"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0123
                goto L_0x0015
            L_0x0123:
                r1 = 13
                goto L_0x01cc
            L_0x0127:
                java.lang.String r2 = "A_DTS/LOSSLESS"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0131
                goto L_0x0015
            L_0x0131:
                r1 = 12
                goto L_0x01cc
            L_0x0135:
                java.lang.String r2 = "S_VOBSUB"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x013f
                goto L_0x0015
            L_0x013f:
                r1 = 11
                goto L_0x01cc
            L_0x0143:
                java.lang.String r2 = "V_MPEG4/ISO/AVC"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x014d
                goto L_0x0015
            L_0x014d:
                r1 = 10
                goto L_0x01cc
            L_0x0151:
                java.lang.String r2 = "V_MPEG4/ISO/ASP"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x015b
                goto L_0x0015
            L_0x015b:
                r1 = 9
                goto L_0x01cc
            L_0x015f:
                java.lang.String r2 = "S_DVBSUB"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0169
                goto L_0x0015
            L_0x0169:
                r1 = 8
                goto L_0x01cc
            L_0x016d:
                java.lang.String r2 = "V_MS/VFW/FOURCC"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0177
                goto L_0x0015
            L_0x0177:
                r1 = 7
                goto L_0x01cc
            L_0x0179:
                java.lang.String r2 = "A_MPEG/L3"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0183
                goto L_0x0015
            L_0x0183:
                r1 = 6
                goto L_0x01cc
            L_0x0185:
                java.lang.String r2 = "A_MPEG/L2"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x018f
                goto L_0x0015
            L_0x018f:
                r1 = 5
                goto L_0x01cc
            L_0x0191:
                java.lang.String r2 = "A_VORBIS"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x019b
                goto L_0x0015
            L_0x019b:
                r1 = 4
                goto L_0x01cc
            L_0x019d:
                java.lang.String r2 = "A_TRUEHD"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x01a7
                goto L_0x0015
            L_0x01a7:
                r1 = 3
                goto L_0x01cc
            L_0x01a9:
                java.lang.String r2 = "A_MS/ACM"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x01b3
                goto L_0x0015
            L_0x01b3:
                r1 = 2
                goto L_0x01cc
            L_0x01b5:
                java.lang.String r2 = "V_MPEG4/ISO/SP"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x01bf
                goto L_0x0015
            L_0x01bf:
                r1 = 1
                goto L_0x01cc
            L_0x01c1:
                java.lang.String r2 = "V_MPEG4/ISO/AP"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x01cb
                goto L_0x0015
            L_0x01cb:
                r1 = 0
            L_0x01cc:
                java.lang.String r2 = "application/dvbsubs"
                java.lang.String r12 = "application/pgs"
                java.lang.String r13 = "application/vobsub"
                java.lang.String r14 = "text/vtt"
                java.lang.String r15 = "text/x-ssa"
                java.lang.String r5 = "application/x-subrip"
                r16 = 4096(0x1000, float:5.74E-42)
                java.lang.String r6 = ". Setting mimeType to "
                java.lang.String r17 = "audio/raw"
                java.lang.String r11 = "MatroskaExtractor"
                java.lang.String r10 = "audio/x-unknown"
                r8 = 0
                switch(r1) {
                    case 0: goto L_0x0415;
                    case 1: goto L_0x0415;
                    case 2: goto L_0x03c5;
                    case 3: goto L_0x03ba;
                    case 4: goto L_0x03a7;
                    case 5: goto L_0x039e;
                    case 6: goto L_0x039b;
                    case 7: goto L_0x037f;
                    case 8: goto L_0x036b;
                    case 9: goto L_0x0415;
                    case 10: goto L_0x0349;
                    case 11: goto L_0x033b;
                    case 12: goto L_0x0338;
                    case 13: goto L_0x031b;
                    case 14: goto L_0x0318;
                    case 15: goto L_0x0315;
                    case 16: goto L_0x0312;
                    case 17: goto L_0x030a;
                    case 18: goto L_0x0307;
                    case 19: goto L_0x0302;
                    case 20: goto L_0x02ff;
                    case 21: goto L_0x0315;
                    case 22: goto L_0x02d9;
                    case 23: goto L_0x02aa;
                    case 24: goto L_0x027f;
                    case 25: goto L_0x026c;
                    case 26: goto L_0x0251;
                    case 27: goto L_0x024b;
                    case 28: goto L_0x0247;
                    case 29: goto L_0x0243;
                    case 30: goto L_0x023f;
                    case 31: goto L_0x0231;
                    case 32: goto L_0x01ed;
                    default: goto L_0x01e6;
                }
            L_0x01e6:
                java.lang.String r1 = "Unrecognized codec identifier."
                com.google.android.exoplayer2.ParserException r1 = com.google.android.exoplayer2.ParserException.a(r1, r8)
                throw r1
            L_0x01ed:
                java.util.ArrayList r1 = new java.util.ArrayList
                r1.<init>(r9)
                java.lang.String r3 = r0.f24461b
                byte[] r3 = r0.g(r3)
                r1.add(r3)
                java.nio.ByteBuffer r3 = java.nio.ByteBuffer.allocate(r7)
                java.nio.ByteOrder r4 = java.nio.ByteOrder.LITTLE_ENDIAN
                java.nio.ByteBuffer r3 = r3.order(r4)
                long r10 = r0.R
                java.nio.ByteBuffer r3 = r3.putLong(r10)
                byte[] r3 = r3.array()
                r1.add(r3)
                java.nio.ByteBuffer r3 = java.nio.ByteBuffer.allocate(r7)
                java.nio.ByteBuffer r3 = r3.order(r4)
                long r6 = r0.S
                java.nio.ByteBuffer r3 = r3.putLong(r6)
                byte[] r3 = r3.array()
                r1.add(r3)
                java.lang.String r17 = "audio/opus"
                r16 = 5760(0x1680, float:8.071E-42)
                r3 = r8
                r4 = -1
                r6 = 5760(0x1680, float:8.071E-42)
                goto L_0x0423
            L_0x0231:
                java.lang.String r1 = r0.f24461b
                byte[] r1 = r0.g(r1)
                java.util.List r1 = java.util.Collections.singletonList(r1)
                java.lang.String r17 = "audio/flac"
                goto L_0x0398
            L_0x023f:
                java.lang.String r17 = "audio/eac3"
                goto L_0x030c
            L_0x0243:
                java.lang.String r17 = "video/mpeg2"
                goto L_0x030c
            L_0x0247:
                r17 = r5
                goto L_0x030c
            L_0x024b:
                r1 = r8
                r3 = r1
                r17 = r14
                goto L_0x030e
            L_0x0251:
                com.google.android.exoplayer2.util.ParsableByteArray r1 = new com.google.android.exoplayer2.util.ParsableByteArray
                java.lang.String r3 = r0.f24461b
                byte[] r3 = r0.g(r3)
                r1.<init>((byte[]) r3)
                com.google.android.exoplayer2.video.HevcConfig r1 = com.google.android.exoplayer2.video.HevcConfig.a(r1)
                java.util.List<byte[]> r3 = r1.f28866a
                int r4 = r1.f28867b
                r0.Y = r4
                java.lang.String r1 = r1.f28874i
                java.lang.String r17 = "video/hevc"
                goto L_0x0362
            L_0x026c:
                byte[] r1 = com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.f24426e0
                java.lang.String r3 = r0.f24461b
                byte[] r3 = r0.g(r3)
                com.google.common.collect.ImmutableList r1 = com.google.common.collect.ImmutableList.t(r1, r3)
                r3 = r8
                r17 = r15
                goto L_0x030e
            L_0x027f:
                int r1 = r0.P
                int r1 = com.google.android.exoplayer2.util.Util.d0(r1)
                if (r1 != 0) goto L_0x02a5
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r3 = "Unsupported little endian PCM bit depth: "
                r1.append(r3)
                int r3 = r0.P
                r1.append(r3)
                r1.append(r6)
                r1.append(r10)
                java.lang.String r1 = r1.toString()
                com.google.android.exoplayer2.util.Log.i(r11, r1)
                goto L_0x040f
            L_0x02a5:
                r4 = r1
                r1 = r8
                r3 = r1
                goto L_0x030f
            L_0x02aa:
                int r1 = r0.P
                if (r1 != r7) goto L_0x02b2
                r1 = r8
                r3 = r1
                r4 = 3
                goto L_0x030f
            L_0x02b2:
                if (r1 != r4) goto L_0x02bb
                r1 = 268435456(0x10000000, float:2.5243549E-29)
                r1 = r8
                r3 = r1
                r4 = 268435456(0x10000000, float:2.5243549E-29)
                goto L_0x030f
            L_0x02bb:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r3 = "Unsupported big endian PCM bit depth: "
                r1.append(r3)
                int r3 = r0.P
                r1.append(r3)
                r1.append(r6)
                r1.append(r10)
                java.lang.String r1 = r1.toString()
                com.google.android.exoplayer2.util.Log.i(r11, r1)
                goto L_0x040f
            L_0x02d9:
                int r1 = r0.P
                if (r1 != r3) goto L_0x02e1
                r1 = r8
                r3 = r1
                r4 = 4
                goto L_0x030f
            L_0x02e1:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r3 = "Unsupported floating point PCM bit depth: "
                r1.append(r3)
                int r3 = r0.P
                r1.append(r3)
                r1.append(r6)
                r1.append(r10)
                java.lang.String r1 = r1.toString()
                com.google.android.exoplayer2.util.Log.i(r11, r1)
                goto L_0x040f
            L_0x02ff:
                java.lang.String r17 = "video/x-unknown"
                goto L_0x030c
            L_0x0302:
                r1 = r8
                r3 = r1
                r17 = r12
                goto L_0x030e
            L_0x0307:
                java.lang.String r17 = "video/x-vnd.on2.vp9"
                goto L_0x030c
            L_0x030a:
                java.lang.String r17 = "video/x-vnd.on2.vp8"
            L_0x030c:
                r1 = r8
                r3 = r1
            L_0x030e:
                r4 = -1
            L_0x030f:
                r6 = -1
                goto L_0x0423
            L_0x0312:
                java.lang.String r17 = "video/av01"
                goto L_0x030c
            L_0x0315:
                java.lang.String r17 = "audio/vnd.dts"
                goto L_0x030c
            L_0x0318:
                java.lang.String r17 = "audio/ac3"
                goto L_0x030c
            L_0x031b:
                java.lang.String r1 = r0.f24461b
                byte[] r1 = r0.g(r1)
                java.util.List r1 = java.util.Collections.singletonList(r1)
                byte[] r3 = r0.f24470k
                com.google.android.exoplayer2.audio.AacUtil$Config r3 = com.google.android.exoplayer2.audio.AacUtil.f(r3)
                int r4 = r3.f23633a
                r0.Q = r4
                int r4 = r3.f23634b
                r0.O = r4
                java.lang.String r3 = r3.f23635c
                java.lang.String r17 = "audio/mp4a-latm"
                goto L_0x030e
            L_0x0338:
                java.lang.String r17 = "audio/vnd.dts.hd"
                goto L_0x030c
            L_0x033b:
                java.lang.String r1 = r0.f24461b
                byte[] r1 = r0.g(r1)
                com.google.common.collect.ImmutableList r1 = com.google.common.collect.ImmutableList.s(r1)
                r3 = r8
                r17 = r13
                goto L_0x030e
            L_0x0349:
                com.google.android.exoplayer2.util.ParsableByteArray r1 = new com.google.android.exoplayer2.util.ParsableByteArray
                java.lang.String r3 = r0.f24461b
                byte[] r3 = r0.g(r3)
                r1.<init>((byte[]) r3)
                com.google.android.exoplayer2.video.AvcConfig r1 = com.google.android.exoplayer2.video.AvcConfig.b(r1)
                java.util.List<byte[]> r3 = r1.f28832a
                int r4 = r1.f28833b
                r0.Y = r4
                java.lang.String r1 = r1.f28837f
                java.lang.String r17 = "video/avc"
            L_0x0362:
                r4 = -1
                r6 = -1
                r18 = r3
                r3 = r1
                r1 = r18
                goto L_0x0423
            L_0x036b:
                r1 = 4
                byte[] r3 = new byte[r1]
                java.lang.String r4 = r0.f24461b
                byte[] r4 = r0.g(r4)
                r6 = 0
                java.lang.System.arraycopy(r4, r6, r3, r6, r1)
                com.google.common.collect.ImmutableList r1 = com.google.common.collect.ImmutableList.s(r3)
                r17 = r2
                goto L_0x0398
            L_0x037f:
                com.google.android.exoplayer2.util.ParsableByteArray r1 = new com.google.android.exoplayer2.util.ParsableByteArray
                java.lang.String r3 = r0.f24461b
                byte[] r3 = r0.g(r3)
                r1.<init>((byte[]) r3)
                android.util.Pair r1 = k(r1)
                java.lang.Object r3 = r1.first
                r17 = r3
                java.lang.String r17 = (java.lang.String) r17
                java.lang.Object r1 = r1.second
                java.util.List r1 = (java.util.List) r1
            L_0x0398:
                r3 = r8
                goto L_0x030e
            L_0x039b:
                java.lang.String r17 = "audio/mpeg"
                goto L_0x03a0
            L_0x039e:
                java.lang.String r17 = "audio/mpeg-L2"
            L_0x03a0:
                r1 = r8
                r3 = r1
                r4 = -1
                r6 = 4096(0x1000, float:5.74E-42)
                goto L_0x0423
            L_0x03a7:
                java.lang.String r1 = r0.f24461b
                byte[] r1 = r0.g(r1)
                java.util.List r1 = m(r1)
                java.lang.String r17 = "audio/vorbis"
                r16 = 8192(0x2000, float:1.14794E-41)
                r3 = r8
                r4 = -1
                r6 = 8192(0x2000, float:1.14794E-41)
                goto L_0x0423
            L_0x03ba:
                com.google.android.exoplayer2.extractor.TrueHdSampleRechunker r1 = new com.google.android.exoplayer2.extractor.TrueHdSampleRechunker
                r1.<init>()
                r0.T = r1
                java.lang.String r17 = "audio/true-hd"
                goto L_0x030c
            L_0x03c5:
                com.google.android.exoplayer2.util.ParsableByteArray r1 = new com.google.android.exoplayer2.util.ParsableByteArray
                java.lang.String r3 = r0.f24461b
                byte[] r3 = r0.g(r3)
                r1.<init>((byte[]) r3)
                boolean r1 = l(r1)
                if (r1 == 0) goto L_0x03fb
                int r1 = r0.P
                int r1 = com.google.android.exoplayer2.util.Util.d0(r1)
                if (r1 != 0) goto L_0x02a5
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r3 = "Unsupported PCM bit depth: "
                r1.append(r3)
                int r3 = r0.P
                r1.append(r3)
                r1.append(r6)
                r1.append(r10)
                java.lang.String r1 = r1.toString()
                com.google.android.exoplayer2.util.Log.i(r11, r1)
                goto L_0x040f
            L_0x03fb:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r3 = "Non-PCM MS/ACM is unsupported. Setting mimeType to "
                r1.append(r3)
                r1.append(r10)
                java.lang.String r1 = r1.toString()
                com.google.android.exoplayer2.util.Log.i(r11, r1)
            L_0x040f:
                r1 = r8
                r3 = r1
                r17 = r10
                goto L_0x030e
            L_0x0415:
                byte[] r1 = r0.f24470k
                if (r1 != 0) goto L_0x041b
                r1 = r8
                goto L_0x041f
            L_0x041b:
                java.util.List r1 = java.util.Collections.singletonList(r1)
            L_0x041f:
                java.lang.String r17 = "video/mp4v-es"
                goto L_0x0398
            L_0x0423:
                byte[] r7 = r0.N
                if (r7 == 0) goto L_0x0438
                com.google.android.exoplayer2.util.ParsableByteArray r7 = new com.google.android.exoplayer2.util.ParsableByteArray
                byte[] r10 = r0.N
                r7.<init>((byte[]) r10)
                com.google.android.exoplayer2.video.DolbyVisionConfig r7 = com.google.android.exoplayer2.video.DolbyVisionConfig.a(r7)
                if (r7 == 0) goto L_0x0438
                java.lang.String r3 = r7.f28851c
                java.lang.String r17 = "video/dolby-vision"
            L_0x0438:
                r7 = r17
                boolean r10 = r0.V
                r11 = 0
                r10 = r10 | r11
                boolean r9 = r0.U
                if (r9 == 0) goto L_0x0444
                r9 = 2
                goto L_0x0445
            L_0x0444:
                r9 = 0
            L_0x0445:
                r9 = r9 | r10
                com.google.android.exoplayer2.Format$Builder r10 = new com.google.android.exoplayer2.Format$Builder
                r10.<init>()
                boolean r17 = com.google.android.exoplayer2.util.MimeTypes.o(r7)
                if (r17 == 0) goto L_0x0463
                int r2 = r0.O
                com.google.android.exoplayer2.Format$Builder r2 = r10.J(r2)
                int r5 = r0.Q
                com.google.android.exoplayer2.Format$Builder r2 = r2.h0(r5)
                r2.a0(r4)
                r5 = 1
                goto L_0x056b
            L_0x0463:
                boolean r4 = com.google.android.exoplayer2.util.MimeTypes.s(r7)
                if (r4 == 0) goto L_0x053e
                int r2 = r0.f24476q
                if (r2 != 0) goto L_0x047f
                int r2 = r0.f24474o
                r4 = -1
                if (r2 != r4) goto L_0x0474
                int r2 = r0.f24472m
            L_0x0474:
                r0.f24474o = r2
                int r2 = r0.f24475p
                if (r2 != r4) goto L_0x047c
                int r2 = r0.f24473n
            L_0x047c:
                r0.f24475p = r2
                goto L_0x0480
            L_0x047f:
                r4 = -1
            L_0x0480:
                int r2 = r0.f24474o
                if (r2 == r4) goto L_0x0494
                int r5 = r0.f24475p
                if (r5 == r4) goto L_0x0494
                int r12 = r0.f24473n
                int r12 = r12 * r2
                float r2 = (float) r12
                int r12 = r0.f24472m
                int r12 = r12 * r5
                float r5 = (float) r12
                float r2 = r2 / r5
                goto L_0x0496
            L_0x0494:
                r2 = -1082130432(0xffffffffbf800000, float:-1.0)
            L_0x0496:
                boolean r5 = r0.f24483x
                if (r5 == 0) goto L_0x04a9
                byte[] r5 = r19.h()
                com.google.android.exoplayer2.video.ColorInfo r8 = new com.google.android.exoplayer2.video.ColorInfo
                int r12 = r0.f24484y
                int r13 = r0.A
                int r14 = r0.f24485z
                r8.<init>(r12, r13, r14, r5)
            L_0x04a9:
                java.lang.String r5 = r0.f24460a
                if (r5 == 0) goto L_0x04c9
                java.util.Map r5 = com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.f24430i0
                java.lang.String r12 = r0.f24460a
                boolean r5 = r5.containsKey(r12)
                if (r5 == 0) goto L_0x04c9
                java.util.Map r4 = com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.f24430i0
                java.lang.String r5 = r0.f24460a
                java.lang.Object r4 = r4.get(r5)
                java.lang.Integer r4 = (java.lang.Integer) r4
                int r4 = r4.intValue()
            L_0x04c9:
                int r5 = r0.f24477r
                if (r5 != 0) goto L_0x0519
                float r5 = r0.f24478s
                r12 = 0
                int r5 = java.lang.Float.compare(r5, r12)
                if (r5 != 0) goto L_0x0519
                float r5 = r0.f24479t
                int r5 = java.lang.Float.compare(r5, r12)
                if (r5 != 0) goto L_0x0519
                float r5 = r0.f24480u
                int r5 = java.lang.Float.compare(r5, r12)
                if (r5 != 0) goto L_0x04e8
                r4 = 0
                goto L_0x0519
            L_0x04e8:
                float r5 = r0.f24479t
                r11 = 1119092736(0x42b40000, float:90.0)
                int r5 = java.lang.Float.compare(r5, r11)
                if (r5 != 0) goto L_0x04f5
                r4 = 90
                goto L_0x0519
            L_0x04f5:
                float r5 = r0.f24479t
                r11 = -1020002304(0xffffffffc3340000, float:-180.0)
                int r5 = java.lang.Float.compare(r5, r11)
                if (r5 == 0) goto L_0x0517
                float r5 = r0.f24479t
                r11 = 1127481344(0x43340000, float:180.0)
                int r5 = java.lang.Float.compare(r5, r11)
                if (r5 != 0) goto L_0x050a
                goto L_0x0517
            L_0x050a:
                float r5 = r0.f24479t
                r11 = -1028390912(0xffffffffc2b40000, float:-90.0)
                int r5 = java.lang.Float.compare(r5, r11)
                if (r5 != 0) goto L_0x0519
                r4 = 270(0x10e, float:3.78E-43)
                goto L_0x0519
            L_0x0517:
                r4 = 180(0xb4, float:2.52E-43)
            L_0x0519:
                int r5 = r0.f24472m
                com.google.android.exoplayer2.Format$Builder r5 = r10.n0(r5)
                int r11 = r0.f24473n
                com.google.android.exoplayer2.Format$Builder r5 = r5.S(r11)
                com.google.android.exoplayer2.Format$Builder r2 = r5.c0(r2)
                com.google.android.exoplayer2.Format$Builder r2 = r2.f0(r4)
                byte[] r4 = r0.f24481v
                com.google.android.exoplayer2.Format$Builder r2 = r2.d0(r4)
                int r4 = r0.f24482w
                com.google.android.exoplayer2.Format$Builder r2 = r2.j0(r4)
                r2.L(r8)
                r5 = 2
                goto L_0x056b
            L_0x053e:
                boolean r4 = r5.equals(r7)
                if (r4 != 0) goto L_0x056a
                boolean r4 = r15.equals(r7)
                if (r4 != 0) goto L_0x056a
                boolean r4 = r14.equals(r7)
                if (r4 != 0) goto L_0x056a
                boolean r4 = r13.equals(r7)
                if (r4 != 0) goto L_0x056a
                boolean r4 = r12.equals(r7)
                if (r4 != 0) goto L_0x056a
                boolean r2 = r2.equals(r7)
                if (r2 == 0) goto L_0x0563
                goto L_0x056a
            L_0x0563:
                java.lang.String r1 = "Unexpected MIME type."
                com.google.android.exoplayer2.ParserException r1 = com.google.android.exoplayer2.ParserException.a(r1, r8)
                throw r1
            L_0x056a:
                r5 = 3
            L_0x056b:
                java.lang.String r2 = r0.f24460a
                if (r2 == 0) goto L_0x0580
                java.util.Map r2 = com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.f24430i0
                java.lang.String r4 = r0.f24460a
                boolean r2 = r2.containsKey(r4)
                if (r2 != 0) goto L_0x0580
                java.lang.String r2 = r0.f24460a
                r10.W(r2)
            L_0x0580:
                r2 = r21
                com.google.android.exoplayer2.Format$Builder r2 = r10.T(r2)
                com.google.android.exoplayer2.Format$Builder r2 = r2.g0(r7)
                com.google.android.exoplayer2.Format$Builder r2 = r2.Y(r6)
                java.lang.String r4 = r0.W
                com.google.android.exoplayer2.Format$Builder r2 = r2.X(r4)
                com.google.android.exoplayer2.Format$Builder r2 = r2.i0(r9)
                com.google.android.exoplayer2.Format$Builder r1 = r2.V(r1)
                com.google.android.exoplayer2.Format$Builder r1 = r1.K(r3)
                com.google.android.exoplayer2.drm.DrmInitData r2 = r0.f24471l
                com.google.android.exoplayer2.Format$Builder r1 = r1.O(r2)
                com.google.android.exoplayer2.Format r1 = r1.G()
                int r2 = r0.f24462c
                r3 = r20
                com.google.android.exoplayer2.extractor.TrackOutput r2 = r3.d(r2, r5)
                r0.X = r2
                r2.d(r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.Track.i(com.google.android.exoplayer2.extractor.ExtractorOutput, int):void");
        }

        @RequiresNonNull({"output"})
        public void j() {
            TrueHdSampleRechunker trueHdSampleRechunker = this.T;
            if (trueHdSampleRechunker != null) {
                trueHdSampleRechunker.a(this.X, this.f24469j);
            }
        }

        public void n() {
            TrueHdSampleRechunker trueHdSampleRechunker = this.T;
            if (trueHdSampleRechunker != null) {
                trueHdSampleRechunker.b();
            }
        }
    }

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("htc_video_rotA-000", 0);
        hashMap.put("htc_video_rotA-090", 90);
        hashMap.put("htc_video_rotA-180", Integer.valueOf(RotationOptions.ROTATE_180));
        hashMap.put("htc_video_rotA-270", Integer.valueOf(RotationOptions.ROTATE_270));
        f24430i0 = Collections.unmodifiableMap(hashMap);
    }

    public MatroskaExtractor() {
        this(0);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Extractor[] A() {
        return new Extractor[]{new MatroskaExtractor()};
    }

    private boolean B(PositionHolder positionHolder, long j2) {
        if (this.f24457y) {
            this.A = j2;
            positionHolder.f24231a = this.f24458z;
            this.f24457y = false;
            return true;
        }
        if (this.f24454v) {
            long j3 = this.A;
            if (j3 != -1) {
                positionHolder.f24231a = j3;
                this.A = -1;
                return true;
            }
        }
        return false;
    }

    private void C(ExtractorInput extractorInput, int i2) throws IOException {
        if (this.f24439g.g() < i2) {
            if (this.f24439g.b() < i2) {
                ParsableByteArray parsableByteArray = this.f24439g;
                parsableByteArray.c(Math.max(parsableByteArray.b() * 2, i2));
            }
            extractorInput.readFully(this.f24439g.e(), this.f24439g.g(), i2 - this.f24439g.g());
            this.f24439g.T(i2);
        }
    }

    private void D() {
        this.S = 0;
        this.T = 0;
        this.U = 0;
        this.V = false;
        this.W = false;
        this.X = false;
        this.Y = 0;
        this.Z = 0;
        this.f24432a0 = false;
        this.f24442j.Q(0);
    }

    private long E(long j2) throws ParserException {
        long j3 = this.f24450r;
        if (j3 != -9223372036854775807L) {
            return Util.R0(j2, j3, 1000);
        }
        throw ParserException.a("Can't scale timecode prior to timecodeScale being set.", (Throwable) null);
    }

    private static void F(String str, long j2, byte[] bArr) {
        int i2;
        byte[] bArr2;
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case 738597099:
                if (str.equals("S_TEXT/ASS")) {
                    c2 = 0;
                    break;
                }
                break;
            case 1045209816:
                if (str.equals("S_TEXT/WEBVTT")) {
                    c2 = 1;
                    break;
                }
                break;
            case 1422270023:
                if (str.equals("S_TEXT/UTF8")) {
                    c2 = 2;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                bArr2 = s(j2, "%01d:%02d:%02d:%02d", NotificationOptions.SKIP_STEP_TEN_SECONDS_IN_MS);
                i2 = 21;
                break;
            case 1:
                bArr2 = s(j2, "%02d:%02d:%02d.%03d", 1000);
                i2 = 25;
                break;
            case 2:
                bArr2 = s(j2, "%02d:%02d:%02d,%03d", 1000);
                i2 = 19;
                break;
            default:
                throw new IllegalArgumentException();
        }
        System.arraycopy(bArr2, 0, bArr, i2, bArr2.length);
    }

    @RequiresNonNull({"#2.output"})
    private int I(ExtractorInput extractorInput, Track track, int i2, boolean z2) throws IOException {
        boolean z3;
        boolean z4;
        int i3;
        if ("S_TEXT/UTF8".equals(track.f24461b)) {
            J(extractorInput, f24425d0, i2);
            return q();
        } else if ("S_TEXT/ASS".equals(track.f24461b)) {
            J(extractorInput, f24427f0, i2);
            return q();
        } else if ("S_TEXT/WEBVTT".equals(track.f24461b)) {
            J(extractorInput, f24428g0, i2);
            return q();
        } else {
            TrackOutput trackOutput = track.X;
            boolean z5 = true;
            if (!this.V) {
                if (track.f24467h) {
                    this.O &= -1073741825;
                    int i4 = 128;
                    if (!this.W) {
                        extractorInput.readFully(this.f24439g.e(), 0, 1);
                        this.S++;
                        if ((this.f24439g.e()[0] & y1.f36938c) != 128) {
                            this.Z = this.f24439g.e()[0];
                            this.W = true;
                        } else {
                            throw ParserException.a("Extension bit is set in signal byte", (Throwable) null);
                        }
                    }
                    byte b2 = this.Z;
                    if ((b2 & 1) == 1) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (z3) {
                        if ((b2 & 2) == 2) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        this.O |= 1073741824;
                        if (!this.f24432a0) {
                            extractorInput.readFully(this.f24444l.e(), 0, 8);
                            this.S += 8;
                            this.f24432a0 = true;
                            byte[] e2 = this.f24439g.e();
                            if (!z4) {
                                i4 = 0;
                            }
                            e2[0] = (byte) (i4 | 8);
                            this.f24439g.U(0);
                            trackOutput.f(this.f24439g, 1, 1);
                            this.T++;
                            this.f24444l.U(0);
                            trackOutput.f(this.f24444l, 8, 1);
                            this.T += 8;
                        }
                        if (z4) {
                            if (!this.X) {
                                extractorInput.readFully(this.f24439g.e(), 0, 1);
                                this.S++;
                                this.f24439g.U(0);
                                this.Y = this.f24439g.H();
                                this.X = true;
                            }
                            int i5 = this.Y * 4;
                            this.f24439g.Q(i5);
                            extractorInput.readFully(this.f24439g.e(), 0, i5);
                            this.S += i5;
                            short s2 = (short) ((this.Y / 2) + 1);
                            int i6 = (s2 * 6) + 2;
                            ByteBuffer byteBuffer = this.f24447o;
                            if (byteBuffer == null || byteBuffer.capacity() < i6) {
                                this.f24447o = ByteBuffer.allocate(i6);
                            }
                            this.f24447o.position(0);
                            this.f24447o.putShort(s2);
                            int i7 = 0;
                            int i8 = 0;
                            while (true) {
                                i3 = this.Y;
                                if (i7 >= i3) {
                                    break;
                                }
                                int L2 = this.f24439g.L();
                                if (i7 % 2 == 0) {
                                    this.f24447o.putShort((short) (L2 - i8));
                                } else {
                                    this.f24447o.putInt(L2 - i8);
                                }
                                i7++;
                                i8 = L2;
                            }
                            int i9 = (i2 - this.S) - i8;
                            if (i3 % 2 == 1) {
                                this.f24447o.putInt(i9);
                            } else {
                                this.f24447o.putShort((short) i9);
                                this.f24447o.putInt(0);
                            }
                            this.f24445m.S(this.f24447o.array(), i6);
                            trackOutput.f(this.f24445m, i6, 1);
                            this.T += i6;
                        }
                    }
                } else {
                    byte[] bArr = track.f24468i;
                    if (bArr != null) {
                        this.f24442j.S(bArr, bArr.length);
                    }
                }
                if (track.o(z2)) {
                    this.O |= 268435456;
                    this.f24446n.Q(0);
                    int g2 = (this.f24442j.g() + i2) - this.S;
                    this.f24439g.Q(4);
                    this.f24439g.e()[0] = (byte) ((g2 >> 24) & JfifUtil.MARKER_FIRST_BYTE);
                    this.f24439g.e()[1] = (byte) ((g2 >> 16) & JfifUtil.MARKER_FIRST_BYTE);
                    this.f24439g.e()[2] = (byte) ((g2 >> 8) & JfifUtil.MARKER_FIRST_BYTE);
                    this.f24439g.e()[3] = (byte) (g2 & JfifUtil.MARKER_FIRST_BYTE);
                    trackOutput.f(this.f24439g, 4, 2);
                    this.T += 4;
                }
                this.V = true;
            }
            int g3 = i2 + this.f24442j.g();
            if (!"V_MPEG4/ISO/AVC".equals(track.f24461b) && !"V_MPEGH/ISO/HEVC".equals(track.f24461b)) {
                if (track.T != null) {
                    if (this.f24442j.g() != 0) {
                        z5 = false;
                    }
                    Assertions.g(z5);
                    track.T.d(extractorInput);
                }
                while (true) {
                    int i10 = this.S;
                    if (i10 >= g3) {
                        break;
                    }
                    int K2 = K(extractorInput, trackOutput, g3 - i10);
                    this.S += K2;
                    this.T += K2;
                }
            } else {
                byte[] e3 = this.f24438f.e();
                e3[0] = 0;
                e3[1] = 0;
                e3[2] = 0;
                int i11 = track.Y;
                int i12 = 4 - i11;
                while (this.S < g3) {
                    int i13 = this.U;
                    if (i13 == 0) {
                        L(extractorInput, e3, i12, i11);
                        this.S += i11;
                        this.f24438f.U(0);
                        this.U = this.f24438f.L();
                        this.f24437e.U(0);
                        trackOutput.c(this.f24437e, 4);
                        this.T += 4;
                    } else {
                        int K3 = K(extractorInput, trackOutput, i13);
                        this.S += K3;
                        this.T += K3;
                        this.U -= K3;
                    }
                }
            }
            if ("A_VORBIS".equals(track.f24461b)) {
                this.f24440h.U(0);
                trackOutput.c(this.f24440h, 4);
                this.T += 4;
            }
            return q();
        }
    }

    private void J(ExtractorInput extractorInput, byte[] bArr, int i2) throws IOException {
        int length = bArr.length + i2;
        if (this.f24443k.b() < length) {
            this.f24443k.R(Arrays.copyOf(bArr, length + i2));
        } else {
            System.arraycopy(bArr, 0, this.f24443k.e(), 0, bArr.length);
        }
        extractorInput.readFully(this.f24443k.e(), bArr.length, i2);
        this.f24443k.U(0);
        this.f24443k.T(length);
    }

    private int K(ExtractorInput extractorInput, TrackOutput trackOutput, int i2) throws IOException {
        int a2 = this.f24442j.a();
        if (a2 <= 0) {
            return trackOutput.b(extractorInput, i2, false);
        }
        int min = Math.min(i2, a2);
        trackOutput.c(this.f24442j, min);
        return min;
    }

    private void L(ExtractorInput extractorInput, byte[] bArr, int i2, int i3) throws IOException {
        int min = Math.min(i3, this.f24442j.a());
        extractorInput.readFully(bArr, i2 + min, i3 - min);
        if (min > 0) {
            this.f24442j.l(bArr, i2, min);
        }
    }

    @EnsuresNonNull({"cueTimesUs", "cueClusterPositions"})
    private void h(int i2) throws ParserException {
        if (this.C == null || this.D == null) {
            throw ParserException.a("Element " + i2 + " must be in a Cues", (Throwable) null);
        }
    }

    @EnsuresNonNull({"currentTrack"})
    private void j(int i2) throws ParserException {
        if (this.f24453u == null) {
            throw ParserException.a("Element " + i2 + " must be in a TrackEntry", (Throwable) null);
        }
    }

    @EnsuresNonNull({"extractorOutput"})
    private void k() {
        Assertions.i(this.f24434b0);
    }

    private SeekMap m(LongArray longArray, LongArray longArray2) {
        int i2;
        if (this.f24449q == -1 || this.f24452t == -9223372036854775807L || longArray == null || longArray.c() == 0 || longArray2 == null || longArray2.c() != longArray.c()) {
            return new SeekMap.Unseekable(this.f24452t);
        }
        int c2 = longArray.c();
        int[] iArr = new int[c2];
        long[] jArr = new long[c2];
        long[] jArr2 = new long[c2];
        long[] jArr3 = new long[c2];
        int i3 = 0;
        for (int i4 = 0; i4 < c2; i4++) {
            jArr3[i4] = longArray.b(i4);
            jArr[i4] = this.f24449q + longArray2.b(i4);
        }
        while (true) {
            i2 = c2 - 1;
            if (i3 >= i2) {
                break;
            }
            int i5 = i3 + 1;
            iArr[i3] = (int) (jArr[i5] - jArr[i3]);
            jArr2[i3] = jArr3[i5] - jArr3[i3];
            i3 = i5;
        }
        iArr[i2] = (int) ((this.f24449q + this.f24448p) - jArr[i2]);
        long j2 = this.f24452t - jArr3[i2];
        jArr2[i2] = j2;
        if (j2 <= 0) {
            Log.i("MatroskaExtractor", "Discarding last cue point with unexpected duration: " + j2);
            iArr = Arrays.copyOf(iArr, i2);
            jArr = Arrays.copyOf(jArr, i2);
            jArr2 = Arrays.copyOf(jArr2, i2);
            jArr3 = Arrays.copyOf(jArr3, i2);
        }
        return new ChunkIndex(iArr, jArr, jArr2, jArr3);
    }

    @RequiresNonNull({"#1.output"})
    private void n(Track track, long j2, int i2, int i3, int i4) {
        TrueHdSampleRechunker trueHdSampleRechunker = track.T;
        if (trueHdSampleRechunker != null) {
            trueHdSampleRechunker.c(track.X, j2, i2, i3, i4, track.f24469j);
        } else {
            if ("S_TEXT/UTF8".equals(track.f24461b) || "S_TEXT/ASS".equals(track.f24461b) || "S_TEXT/WEBVTT".equals(track.f24461b)) {
                if (this.K > 1) {
                    Log.i("MatroskaExtractor", "Skipping subtitle sample in laced block.");
                } else {
                    long j3 = this.I;
                    if (j3 == -9223372036854775807L) {
                        Log.i("MatroskaExtractor", "Skipping subtitle sample with no duration.");
                    } else {
                        F(track.f24461b, j3, this.f24443k.e());
                        int f2 = this.f24443k.f();
                        while (true) {
                            if (f2 >= this.f24443k.g()) {
                                break;
                            } else if (this.f24443k.e()[f2] == 0) {
                                this.f24443k.T(f2);
                                break;
                            } else {
                                f2++;
                            }
                        }
                        TrackOutput trackOutput = track.X;
                        ParsableByteArray parsableByteArray = this.f24443k;
                        trackOutput.c(parsableByteArray, parsableByteArray.g());
                        i3 += this.f24443k.g();
                    }
                }
            }
            if ((268435456 & i2) != 0) {
                if (this.K > 1) {
                    this.f24446n.Q(0);
                } else {
                    int g2 = this.f24446n.g();
                    track.X.f(this.f24446n, g2, 2);
                    i3 += g2;
                }
            }
            track.X.e(j2, i2, i3, i4, track.f24469j);
        }
        this.F = true;
    }

    private static int[] p(int[] iArr, int i2) {
        if (iArr == null) {
            return new int[i2];
        }
        if (iArr.length >= i2) {
            return iArr;
        }
        return new int[Math.max(iArr.length * 2, i2)];
    }

    private int q() {
        int i2 = this.T;
        D();
        return i2;
    }

    private static byte[] s(long j2, String str, long j3) {
        boolean z2;
        if (j2 != -9223372036854775807L) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.a(z2);
        int i2 = (int) (j2 / 3600000000L);
        long j4 = j2 - ((((long) i2) * 3600) * 1000000);
        int i3 = (int) (j4 / 60000000);
        long j5 = j4 - ((((long) i3) * 60) * 1000000);
        int i4 = (int) (j5 / 1000000);
        int i5 = (int) ((j5 - (((long) i4) * 1000000)) / j3);
        return Util.p0(String.format(Locale.US, str, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}));
    }

    private static boolean y(String str) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -2095576542:
                if (str.equals("V_MPEG4/ISO/AP")) {
                    c2 = 0;
                    break;
                }
                break;
            case -2095575984:
                if (str.equals("V_MPEG4/ISO/SP")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1985379776:
                if (str.equals("A_MS/ACM")) {
                    c2 = 2;
                    break;
                }
                break;
            case -1784763192:
                if (str.equals("A_TRUEHD")) {
                    c2 = 3;
                    break;
                }
                break;
            case -1730367663:
                if (str.equals("A_VORBIS")) {
                    c2 = 4;
                    break;
                }
                break;
            case -1482641358:
                if (str.equals("A_MPEG/L2")) {
                    c2 = 5;
                    break;
                }
                break;
            case -1482641357:
                if (str.equals("A_MPEG/L3")) {
                    c2 = 6;
                    break;
                }
                break;
            case -1373388978:
                if (str.equals("V_MS/VFW/FOURCC")) {
                    c2 = 7;
                    break;
                }
                break;
            case -933872740:
                if (str.equals("S_DVBSUB")) {
                    c2 = 8;
                    break;
                }
                break;
            case -538363189:
                if (str.equals("V_MPEG4/ISO/ASP")) {
                    c2 = 9;
                    break;
                }
                break;
            case -538363109:
                if (str.equals("V_MPEG4/ISO/AVC")) {
                    c2 = 10;
                    break;
                }
                break;
            case -425012669:
                if (str.equals("S_VOBSUB")) {
                    c2 = 11;
                    break;
                }
                break;
            case -356037306:
                if (str.equals("A_DTS/LOSSLESS")) {
                    c2 = 12;
                    break;
                }
                break;
            case 62923557:
                if (str.equals("A_AAC")) {
                    c2 = 13;
                    break;
                }
                break;
            case 62923603:
                if (str.equals("A_AC3")) {
                    c2 = 14;
                    break;
                }
                break;
            case 62927045:
                if (str.equals("A_DTS")) {
                    c2 = 15;
                    break;
                }
                break;
            case 82318131:
                if (str.equals("V_AV1")) {
                    c2 = 16;
                    break;
                }
                break;
            case 82338133:
                if (str.equals("V_VP8")) {
                    c2 = 17;
                    break;
                }
                break;
            case 82338134:
                if (str.equals("V_VP9")) {
                    c2 = 18;
                    break;
                }
                break;
            case 99146302:
                if (str.equals("S_HDMV/PGS")) {
                    c2 = 19;
                    break;
                }
                break;
            case 444813526:
                if (str.equals("V_THEORA")) {
                    c2 = 20;
                    break;
                }
                break;
            case 542569478:
                if (str.equals("A_DTS/EXPRESS")) {
                    c2 = 21;
                    break;
                }
                break;
            case 635596514:
                if (str.equals("A_PCM/FLOAT/IEEE")) {
                    c2 = 22;
                    break;
                }
                break;
            case 725948237:
                if (str.equals("A_PCM/INT/BIG")) {
                    c2 = 23;
                    break;
                }
                break;
            case 725957860:
                if (str.equals("A_PCM/INT/LIT")) {
                    c2 = 24;
                    break;
                }
                break;
            case 738597099:
                if (str.equals("S_TEXT/ASS")) {
                    c2 = 25;
                    break;
                }
                break;
            case 855502857:
                if (str.equals("V_MPEGH/ISO/HEVC")) {
                    c2 = 26;
                    break;
                }
                break;
            case 1045209816:
                if (str.equals("S_TEXT/WEBVTT")) {
                    c2 = 27;
                    break;
                }
                break;
            case 1422270023:
                if (str.equals("S_TEXT/UTF8")) {
                    c2 = 28;
                    break;
                }
                break;
            case 1809237540:
                if (str.equals("V_MPEG2")) {
                    c2 = 29;
                    break;
                }
                break;
            case 1950749482:
                if (str.equals("A_EAC3")) {
                    c2 = 30;
                    break;
                }
                break;
            case 1950789798:
                if (str.equals("A_FLAC")) {
                    c2 = 31;
                    break;
                }
                break;
            case 1951062397:
                if (str.equals("A_OPUS")) {
                    c2 = ' ';
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case ' ':
                return true;
            default:
                return false;
        }
    }

    /* access modifiers changed from: protected */
    public void G(int i2, long j2, long j3) throws ParserException {
        k();
        if (i2 == 160) {
            this.Q = false;
            this.R = 0;
        } else if (i2 == 174) {
            this.f24453u = new Track();
        } else if (i2 == 187) {
            this.E = false;
        } else if (i2 == 19899) {
            this.f24455w = -1;
            this.f24456x = -1;
        } else if (i2 == 20533) {
            t(i2).f24467h = true;
        } else if (i2 == 21968) {
            t(i2).f24483x = true;
        } else if (i2 == 408125543) {
            long j4 = this.f24449q;
            if (j4 == -1 || j4 == j2) {
                this.f24449q = j2;
                this.f24448p = j3;
                return;
            }
            throw ParserException.a("Multiple Segment elements not supported", (Throwable) null);
        } else if (i2 == 475249515) {
            this.C = new LongArray();
            this.D = new LongArray();
        } else if (i2 != 524531317 || this.f24454v) {
        } else {
            if (!this.f24436d || this.f24458z == -1) {
                this.f24434b0.u(new SeekMap.Unseekable(this.f24452t));
                this.f24454v = true;
                return;
            }
            this.f24457y = true;
        }
    }

    /* access modifiers changed from: protected */
    public void H(int i2, String str) throws ParserException {
        if (i2 == 134) {
            t(i2).f24461b = str;
        } else if (i2 != 17026) {
            if (i2 == 21358) {
                t(i2).f24460a = str;
            } else if (i2 == 2274716) {
                String unused = t(i2).W = str;
            }
        } else if (!"webm".equals(str) && !"matroska".equals(str)) {
            throw ParserException.a("DocType " + str + " not supported", (Throwable) null);
        }
    }

    public void a(long j2, long j3) {
        this.B = -9223372036854775807L;
        this.G = 0;
        this.f24431a.reset();
        this.f24433b.e();
        D();
        for (int i2 = 0; i2 < this.f24435c.size(); i2++) {
            this.f24435c.valueAt(i2).n();
        }
    }

    public final void c(ExtractorOutput extractorOutput) {
        this.f24434b0 = extractorOutput;
    }

    public final boolean g(ExtractorInput extractorInput) throws IOException {
        return new Sniffer().b(extractorInput);
    }

    public final int i(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        this.F = false;
        boolean z2 = true;
        while (z2 && !this.F) {
            z2 = this.f24431a.a(extractorInput);
            if (z2 && B(positionHolder, extractorInput.getPosition())) {
                return 1;
            }
        }
        if (z2) {
            return 0;
        }
        for (int i2 = 0; i2 < this.f24435c.size(); i2++) {
            Track valueAt = this.f24435c.valueAt(i2);
            valueAt.f();
            valueAt.j();
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    public void l(int i2, int i3, ExtractorInput extractorInput) throws IOException {
        Track track;
        Track track2;
        Track track3;
        long j2;
        int i4;
        byte b2;
        int i5;
        int i6 = i2;
        int i7 = i3;
        ExtractorInput extractorInput2 = extractorInput;
        int i8 = 0;
        int i9 = 1;
        if (i6 == 161 || i6 == 163) {
            if (this.G == 0) {
                this.M = (int) this.f24433b.d(extractorInput2, false, true, 8);
                this.N = this.f24433b.b();
                this.I = -9223372036854775807L;
                this.G = 1;
                this.f24439g.Q(0);
            }
            Track track4 = this.f24435c.get(this.M);
            if (track4 == null) {
                extractorInput2.k(i7 - this.N);
                this.G = 0;
                return;
            }
            track4.f();
            if (this.G == 1) {
                C(extractorInput2, 3);
                int i10 = (this.f24439g.e()[2] & 6) >> 1;
                byte b3 = 255;
                if (i10 == 0) {
                    this.K = 1;
                    int[] p2 = p(this.L, 1);
                    this.L = p2;
                    p2[0] = (i7 - this.N) - 3;
                } else {
                    int i11 = 4;
                    C(extractorInput2, 4);
                    int i12 = (this.f24439g.e()[3] & 255) + 1;
                    this.K = i12;
                    int[] p3 = p(this.L, i12);
                    this.L = p3;
                    if (i10 == 2) {
                        int i13 = this.K;
                        Arrays.fill(p3, 0, i13, ((i7 - this.N) - 4) / i13);
                    } else if (i10 == 1) {
                        int i14 = 0;
                        int i15 = 0;
                        while (true) {
                            i4 = this.K;
                            if (i14 >= i4 - 1) {
                                break;
                            }
                            this.L[i14] = 0;
                            do {
                                i11++;
                                C(extractorInput2, i11);
                                b2 = this.f24439g.e()[i11 - 1] & 255;
                                int[] iArr = this.L;
                                i5 = iArr[i14] + b2;
                                iArr[i14] = i5;
                            } while (b2 == 255);
                            i15 += i5;
                            i14++;
                        }
                        this.L[i4 - 1] = ((i7 - this.N) - i11) - i15;
                    } else if (i10 == 3) {
                        int i16 = 0;
                        int i17 = 0;
                        while (true) {
                            int i18 = this.K;
                            if (i16 >= i18 - 1) {
                                track2 = track4;
                                this.L[i18 - 1] = ((i7 - this.N) - i11) - i17;
                                break;
                            }
                            this.L[i16] = i8;
                            i11++;
                            C(extractorInput2, i11);
                            int i19 = i11 - 1;
                            if (this.f24439g.e()[i19] != 0) {
                                int i20 = 0;
                                while (true) {
                                    if (i20 >= 8) {
                                        track3 = track4;
                                        j2 = 0;
                                        break;
                                    }
                                    int i21 = i9 << (7 - i20);
                                    if ((this.f24439g.e()[i19] & i21) != 0) {
                                        int i22 = i11 + i20;
                                        C(extractorInput2, i22);
                                        track3 = track4;
                                        j2 = (long) ((~i21) & this.f24439g.e()[i19] & b3);
                                        int i23 = i19 + 1;
                                        while (i23 < i22) {
                                            j2 = (j2 << 8) | ((long) (this.f24439g.e()[i23] & b3));
                                            i23++;
                                            i22 = i22;
                                            b3 = 255;
                                        }
                                        int i24 = i22;
                                        if (i16 > 0) {
                                            j2 -= (1 << ((i20 * 7) + 6)) - 1;
                                        }
                                        i11 = i24;
                                    } else {
                                        Track track5 = track4;
                                        i20++;
                                        i9 = 1;
                                        b3 = 255;
                                    }
                                }
                                if (j2 >= -2147483648L && j2 <= 2147483647L) {
                                    int i25 = (int) j2;
                                    int[] iArr2 = this.L;
                                    if (i16 != 0) {
                                        i25 += iArr2[i16 - 1];
                                    }
                                    iArr2[i16] = i25;
                                    i17 += i25;
                                    i16++;
                                    track4 = track3;
                                    i8 = 0;
                                    i9 = 1;
                                    b3 = 255;
                                }
                            } else {
                                throw ParserException.a("No valid varint length mask found", (Throwable) null);
                            }
                        }
                        throw ParserException.a("EBML lacing sample size out of range.", (Throwable) null);
                    } else {
                        throw ParserException.a("Unexpected lacing value: " + i10, (Throwable) null);
                    }
                }
                track2 = track4;
                this.H = this.B + E((long) ((this.f24439g.e()[0] << 8) | (this.f24439g.e()[1] & 255)));
                track = track2;
                this.O = (track.f24463d == 2 || (i6 == 163 && (this.f24439g.e()[2] & y1.f36938c) == 128)) ? 1 : 0;
                this.G = 2;
                this.J = 0;
            } else {
                track = track4;
            }
            if (i6 == 163) {
                while (true) {
                    int i26 = this.J;
                    if (i26 < this.K) {
                        n(track, ((long) ((this.J * track.f24464e) / 1000)) + this.H, this.O, I(extractorInput2, track, this.L[i26], false), 0);
                        this.J++;
                    } else {
                        this.G = 0;
                        return;
                    }
                }
            } else {
                while (true) {
                    int i27 = this.J;
                    if (i27 < this.K) {
                        int[] iArr3 = this.L;
                        iArr3[i27] = I(extractorInput2, track, iArr3[i27], true);
                        this.J++;
                    } else {
                        return;
                    }
                }
            }
        } else if (i6 != 165) {
            if (i6 == 16877) {
                v(t(i2), extractorInput2, i7);
            } else if (i6 == 16981) {
                j(i2);
                byte[] bArr = new byte[i7];
                this.f24453u.f24468i = bArr;
                extractorInput2.readFully(bArr, 0, i7);
            } else if (i6 == 18402) {
                byte[] bArr2 = new byte[i7];
                extractorInput2.readFully(bArr2, 0, i7);
                t(i2).f24469j = new TrackOutput.CryptoData(1, bArr2, 0, 0);
            } else if (i6 == 21419) {
                Arrays.fill(this.f24441i.e(), (byte) 0);
                extractorInput2.readFully(this.f24441i.e(), 4 - i7, i7);
                this.f24441i.U(0);
                this.f24455w = (int) this.f24441i.J();
            } else if (i6 == 25506) {
                j(i2);
                byte[] bArr3 = new byte[i7];
                this.f24453u.f24470k = bArr3;
                extractorInput2.readFully(bArr3, 0, i7);
            } else if (i6 == 30322) {
                j(i2);
                byte[] bArr4 = new byte[i7];
                this.f24453u.f24481v = bArr4;
                extractorInput2.readFully(bArr4, 0, i7);
            } else {
                throw ParserException.a("Unexpected id: " + i6, (Throwable) null);
            }
        } else if (this.G == 2) {
            w(this.f24435c.get(this.M), this.P, extractorInput2, i7);
        }
    }

    /* access modifiers changed from: protected */
    public void o(int i2) throws ParserException {
        k();
        if (i2 != 160) {
            if (i2 == 174) {
                Track track = (Track) Assertions.i(this.f24453u);
                String str = track.f24461b;
                if (str != null) {
                    if (y(str)) {
                        track.i(this.f24434b0, track.f24462c);
                        this.f24435c.put(track.f24462c, track);
                    }
                    this.f24453u = null;
                    return;
                }
                throw ParserException.a("CodecId is missing in TrackEntry element", (Throwable) null);
            } else if (i2 == 19899) {
                int i3 = this.f24455w;
                if (i3 != -1) {
                    long j2 = this.f24456x;
                    if (j2 != -1) {
                        if (i3 == 475249515) {
                            this.f24458z = j2;
                            return;
                        }
                        return;
                    }
                }
                throw ParserException.a("Mandatory element SeekID or SeekPosition not found", (Throwable) null);
            } else if (i2 == 25152) {
                j(i2);
                Track track2 = this.f24453u;
                if (!track2.f24467h) {
                    return;
                }
                if (track2.f24469j != null) {
                    track2.f24471l = new DrmInitData(new DrmInitData.SchemeData(C.f22816a, MimeTypes.VIDEO_WEBM, this.f24453u.f24469j.f24240b));
                    return;
                }
                throw ParserException.a("Encrypted Track found but ContentEncKeyID was not found", (Throwable) null);
            } else if (i2 == 28032) {
                j(i2);
                Track track3 = this.f24453u;
                if (track3.f24467h && track3.f24468i != null) {
                    throw ParserException.a("Combining encryption and compression is not supported", (Throwable) null);
                }
            } else if (i2 == 357149030) {
                if (this.f24450r == -9223372036854775807L) {
                    this.f24450r = 1000000;
                }
                long j3 = this.f24451s;
                if (j3 != -9223372036854775807L) {
                    this.f24452t = E(j3);
                }
            } else if (i2 != 374648427) {
                if (i2 == 475249515) {
                    if (!this.f24454v) {
                        this.f24434b0.u(m(this.C, this.D));
                        this.f24454v = true;
                    }
                    this.C = null;
                    this.D = null;
                }
            } else if (this.f24435c.size() != 0) {
                this.f24434b0.m();
            } else {
                throw ParserException.a("No valid tracks were found", (Throwable) null);
            }
        } else if (this.G == 2) {
            Track track4 = this.f24435c.get(this.M);
            track4.f();
            if (this.R > 0 && "A_OPUS".equals(track4.f24461b)) {
                this.f24446n.R(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(this.R).array());
            }
            int i4 = 0;
            for (int i5 = 0; i5 < this.K; i5++) {
                i4 += this.L[i5];
            }
            int i6 = 0;
            while (i6 < this.K) {
                long j4 = this.H + ((long) ((track4.f24464e * i6) / 1000));
                int i7 = this.O;
                if (i6 == 0 && !this.Q) {
                    i7 |= 1;
                }
                int i8 = this.L[i6];
                int i9 = i4 - i8;
                n(track4, j4, i7, i8, i9);
                i6++;
                i4 = i9;
            }
            this.G = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void r(int i2, double d2) throws ParserException {
        if (i2 == 181) {
            t(i2).Q = (int) d2;
        } else if (i2 != 17545) {
            switch (i2) {
                case 21969:
                    t(i2).D = (float) d2;
                    return;
                case 21970:
                    t(i2).E = (float) d2;
                    return;
                case 21971:
                    t(i2).F = (float) d2;
                    return;
                case 21972:
                    t(i2).G = (float) d2;
                    return;
                case 21973:
                    t(i2).H = (float) d2;
                    return;
                case 21974:
                    t(i2).I = (float) d2;
                    return;
                case 21975:
                    t(i2).J = (float) d2;
                    return;
                case 21976:
                    t(i2).K = (float) d2;
                    return;
                case 21977:
                    t(i2).L = (float) d2;
                    return;
                case 21978:
                    t(i2).M = (float) d2;
                    return;
                default:
                    switch (i2) {
                        case 30323:
                            t(i2).f24478s = (float) d2;
                            return;
                        case 30324:
                            t(i2).f24479t = (float) d2;
                            return;
                        case 30325:
                            t(i2).f24480u = (float) d2;
                            return;
                        default:
                            return;
                    }
            }
        } else {
            this.f24451s = (long) d2;
        }
    }

    public final void release() {
    }

    /* access modifiers changed from: protected */
    public Track t(int i2) throws ParserException {
        j(i2);
        return this.f24453u;
    }

    /* access modifiers changed from: protected */
    public int u(int i2) {
        switch (i2) {
            case MRAID_JS_WRITE_FAILED_VALUE:
            case PRIVACY_URL_ERROR_VALUE:
            case 155:
            case 159:
            case 176:
            case 179:
            case 186:
            case 215:
            case 231:
            case 238:
            case 241:
            case 251:
            case 16871:
            case 16980:
            case 17029:
            case 17143:
            case 18401:
            case 18408:
            case 20529:
            case 20530:
            case 21420:
            case 21432:
            case 21680:
            case 21682:
            case 21690:
            case 21930:
            case 21945:
            case 21946:
            case 21947:
            case 21948:
            case 21949:
            case 21998:
            case 22186:
            case 22203:
            case 25188:
            case 30114:
            case 30321:
            case 2352003:
            case 2807729:
                return 2;
            case STORE_REGION_CODE_ERROR_VALUE:
            case 17026:
            case 21358:
            case 2274716:
                return 3;
            case 160:
            case 166:
            case 174:
            case 183:
            case 187:
            case 224:
            case JfifUtil.MARKER_APP1:
            case 16868:
            case 18407:
            case 19899:
            case 20532:
            case 20533:
            case 21936:
            case 21968:
            case 25152:
            case 28032:
            case 30113:
            case 30320:
            case 290298740:
            case 357149030:
            case 374648427:
            case 408125543:
            case 440786851:
            case 475249515:
            case 524531317:
                return 1;
            case 161:
            case 163:
            case 165:
            case 16877:
            case 16981:
            case 18402:
            case 21419:
            case 25506:
            case 30322:
                return 4;
            case 181:
            case 17545:
            case 21969:
            case 21970:
            case 21971:
            case 21972:
            case 21973:
            case 21974:
            case 21975:
            case 21976:
            case 21977:
            case 21978:
            case 30323:
            case 30324:
            case 30325:
                return 5;
            default:
                return 0;
        }
    }

    /* access modifiers changed from: protected */
    public void v(Track track, ExtractorInput extractorInput, int i2) throws IOException {
        if (track.f24466g == 1685485123 || track.f24466g == 1685480259) {
            byte[] bArr = new byte[i2];
            track.N = bArr;
            extractorInput.readFully(bArr, 0, i2);
            return;
        }
        extractorInput.k(i2);
    }

    /* access modifiers changed from: protected */
    public void w(Track track, int i2, ExtractorInput extractorInput, int i3) throws IOException {
        if (i2 != 4 || !"V_VP9".equals(track.f24461b)) {
            extractorInput.k(i3);
            return;
        }
        this.f24446n.Q(i3);
        extractorInput.readFully(this.f24446n.e(), 0, i3);
    }

    /* access modifiers changed from: protected */
    public void x(int i2, long j2) throws ParserException {
        if (i2 != 20529) {
            if (i2 != 20530) {
                boolean z2 = false;
                switch (i2) {
                    case MRAID_JS_WRITE_FAILED_VALUE:
                        t(i2).f24463d = (int) j2;
                        return;
                    case PRIVACY_URL_ERROR_VALUE:
                        Track t2 = t(i2);
                        if (j2 == 1) {
                            z2 = true;
                        }
                        t2.V = z2;
                        return;
                    case 155:
                        this.I = E(j2);
                        return;
                    case 159:
                        t(i2).O = (int) j2;
                        return;
                    case 176:
                        t(i2).f24472m = (int) j2;
                        return;
                    case 179:
                        h(i2);
                        this.C.a(E(j2));
                        return;
                    case 186:
                        t(i2).f24473n = (int) j2;
                        return;
                    case 215:
                        t(i2).f24462c = (int) j2;
                        return;
                    case 231:
                        this.B = E(j2);
                        return;
                    case 238:
                        this.P = (int) j2;
                        return;
                    case 241:
                        if (!this.E) {
                            h(i2);
                            this.D.a(j2);
                            this.E = true;
                            return;
                        }
                        return;
                    case 251:
                        this.Q = true;
                        return;
                    case 16871:
                        int unused = t(i2).f24466g = (int) j2;
                        return;
                    case 16980:
                        if (j2 != 3) {
                            throw ParserException.a("ContentCompAlgo " + j2 + " not supported", (Throwable) null);
                        }
                        return;
                    case 17029:
                        if (j2 < 1 || j2 > 2) {
                            throw ParserException.a("DocTypeReadVersion " + j2 + " not supported", (Throwable) null);
                        }
                        return;
                    case 17143:
                        if (j2 != 1) {
                            throw ParserException.a("EBMLReadVersion " + j2 + " not supported", (Throwable) null);
                        }
                        return;
                    case 18401:
                        if (j2 != 5) {
                            throw ParserException.a("ContentEncAlgo " + j2 + " not supported", (Throwable) null);
                        }
                        return;
                    case 18408:
                        if (j2 != 1) {
                            throw ParserException.a("AESSettingsCipherMode " + j2 + " not supported", (Throwable) null);
                        }
                        return;
                    case 21420:
                        this.f24456x = j2 + this.f24449q;
                        return;
                    case 21432:
                        int i3 = (int) j2;
                        j(i2);
                        if (i3 == 0) {
                            this.f24453u.f24482w = 0;
                            return;
                        } else if (i3 == 1) {
                            this.f24453u.f24482w = 2;
                            return;
                        } else if (i3 == 3) {
                            this.f24453u.f24482w = 1;
                            return;
                        } else if (i3 == 15) {
                            this.f24453u.f24482w = 3;
                            return;
                        } else {
                            return;
                        }
                    case 21680:
                        t(i2).f24474o = (int) j2;
                        return;
                    case 21682:
                        t(i2).f24476q = (int) j2;
                        return;
                    case 21690:
                        t(i2).f24475p = (int) j2;
                        return;
                    case 21930:
                        Track t3 = t(i2);
                        if (j2 == 1) {
                            z2 = true;
                        }
                        t3.U = z2;
                        return;
                    case 21998:
                        t(i2).f24465f = (int) j2;
                        return;
                    case 22186:
                        t(i2).R = j2;
                        return;
                    case 22203:
                        t(i2).S = j2;
                        return;
                    case 25188:
                        t(i2).P = (int) j2;
                        return;
                    case 30114:
                        this.R = j2;
                        return;
                    case 30321:
                        j(i2);
                        int i4 = (int) j2;
                        if (i4 == 0) {
                            this.f24453u.f24477r = 0;
                            return;
                        } else if (i4 == 1) {
                            this.f24453u.f24477r = 1;
                            return;
                        } else if (i4 == 2) {
                            this.f24453u.f24477r = 2;
                            return;
                        } else if (i4 == 3) {
                            this.f24453u.f24477r = 3;
                            return;
                        } else {
                            return;
                        }
                    case 2352003:
                        t(i2).f24464e = (int) j2;
                        return;
                    case 2807729:
                        this.f24450r = j2;
                        return;
                    default:
                        switch (i2) {
                            case 21945:
                                j(i2);
                                int i5 = (int) j2;
                                if (i5 == 1) {
                                    this.f24453u.A = 2;
                                    return;
                                } else if (i5 == 2) {
                                    this.f24453u.A = 1;
                                    return;
                                } else {
                                    return;
                                }
                            case 21946:
                                j(i2);
                                int c2 = ColorInfo.c((int) j2);
                                if (c2 != -1) {
                                    this.f24453u.f24485z = c2;
                                    return;
                                }
                                return;
                            case 21947:
                                j(i2);
                                this.f24453u.f24483x = true;
                                int b2 = ColorInfo.b((int) j2);
                                if (b2 != -1) {
                                    this.f24453u.f24484y = b2;
                                    return;
                                }
                                return;
                            case 21948:
                                t(i2).B = (int) j2;
                                return;
                            case 21949:
                                t(i2).C = (int) j2;
                                return;
                            default:
                                return;
                        }
                }
            } else if (j2 != 1) {
                throw ParserException.a("ContentEncodingScope " + j2 + " not supported", (Throwable) null);
            }
        } else if (j2 != 0) {
            throw ParserException.a("ContentEncodingOrder " + j2 + " not supported", (Throwable) null);
        }
    }

    /* access modifiers changed from: protected */
    public boolean z(int i2) {
        return i2 == 357149030 || i2 == 524531317 || i2 == 475249515 || i2 == 374648427;
    }

    public MatroskaExtractor(int i2) {
        this(new DefaultEbmlReader(), i2);
    }

    MatroskaExtractor(EbmlReader ebmlReader, int i2) {
        this.f24449q = -1;
        this.f24450r = -9223372036854775807L;
        this.f24451s = -9223372036854775807L;
        this.f24452t = -9223372036854775807L;
        this.f24458z = -1;
        this.A = -1;
        this.B = -9223372036854775807L;
        this.f24431a = ebmlReader;
        ebmlReader.b(new InnerEbmlProcessor());
        this.f24436d = (i2 & 1) == 0;
        this.f24433b = new VarintReader();
        this.f24435c = new SparseArray<>();
        this.f24439g = new ParsableByteArray(4);
        this.f24440h = new ParsableByteArray(ByteBuffer.allocate(4).putInt(-1).array());
        this.f24441i = new ParsableByteArray(4);
        this.f24437e = new ParsableByteArray(NalUnitUtil.f28716a);
        this.f24438f = new ParsableByteArray(4);
        this.f24442j = new ParsableByteArray();
        this.f24443k = new ParsableByteArray();
        this.f24444l = new ParsableByteArray(8);
        this.f24445m = new ParsableByteArray();
        this.f24446n = new ParsableByteArray();
        this.L = new int[1];
    }
}
