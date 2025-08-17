package androidx.media3.extractor.mkv;

import android.util.Pair;
import android.util.SparseArray;
import androidx.media3.common.C;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.LongArray;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.container.NalUnitUtil;
import androidx.media3.extractor.ChunkIndex;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.ExtractorsFactory;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.TrueHdSampleRechunker;
import androidx.media3.extractor.d;
import androidx.media3.extractor.text.SubtitleParser;
import androidx.media3.extractor.text.SubtitleTranscodingExtractorOutput;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imageutils.JfifUtil;
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
    @Deprecated

    /* renamed from: e0  reason: collision with root package name */
    public static final ExtractorsFactory f8404e0 = new a();

    /* renamed from: f0  reason: collision with root package name */
    private static final byte[] f8405f0 = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
    /* access modifiers changed from: private */

    /* renamed from: g0  reason: collision with root package name */
    public static final byte[] f8406g0 = Util.t0("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");

    /* renamed from: h0  reason: collision with root package name */
    private static final byte[] f8407h0 = {68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};

    /* renamed from: i0  reason: collision with root package name */
    private static final byte[] f8408i0 = {87, 69, 66, 86, 84, 84, 10, 10, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 10};
    /* access modifiers changed from: private */

    /* renamed from: j0  reason: collision with root package name */
    public static final UUID f8409j0 = new UUID(72057594037932032L, -9223371306706625679L);
    /* access modifiers changed from: private */

    /* renamed from: k0  reason: collision with root package name */
    public static final Map<String, Integer> f8410k0;
    private boolean A;
    private long B;
    private long C;
    private long D;
    private LongArray E;
    private LongArray F;
    private boolean G;
    private boolean H;
    private int I;
    private long J;
    private long K;
    private int L;
    private int M;
    private int[] N;
    private int O;
    private int P;
    private int Q;
    private int R;
    private boolean S;
    private long T;
    private int U;
    private int V;
    private int W;
    private boolean X;
    private boolean Y;
    private boolean Z;

    /* renamed from: a  reason: collision with root package name */
    private final EbmlReader f8411a;

    /* renamed from: a0  reason: collision with root package name */
    private int f8412a0;

    /* renamed from: b  reason: collision with root package name */
    private final VarintReader f8413b;

    /* renamed from: b0  reason: collision with root package name */
    private byte f8414b0;

    /* renamed from: c  reason: collision with root package name */
    private final SparseArray<Track> f8415c;

    /* renamed from: c0  reason: collision with root package name */
    private boolean f8416c0;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f8417d;

    /* renamed from: d0  reason: collision with root package name */
    private ExtractorOutput f8418d0;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f8419e;

    /* renamed from: f  reason: collision with root package name */
    private final SubtitleParser.Factory f8420f;

    /* renamed from: g  reason: collision with root package name */
    private final ParsableByteArray f8421g;

    /* renamed from: h  reason: collision with root package name */
    private final ParsableByteArray f8422h;

    /* renamed from: i  reason: collision with root package name */
    private final ParsableByteArray f8423i;

    /* renamed from: j  reason: collision with root package name */
    private final ParsableByteArray f8424j;

    /* renamed from: k  reason: collision with root package name */
    private final ParsableByteArray f8425k;

    /* renamed from: l  reason: collision with root package name */
    private final ParsableByteArray f8426l;

    /* renamed from: m  reason: collision with root package name */
    private final ParsableByteArray f8427m;

    /* renamed from: n  reason: collision with root package name */
    private final ParsableByteArray f8428n;

    /* renamed from: o  reason: collision with root package name */
    private final ParsableByteArray f8429o;

    /* renamed from: p  reason: collision with root package name */
    private final ParsableByteArray f8430p;

    /* renamed from: q  reason: collision with root package name */
    private ByteBuffer f8431q;

    /* renamed from: r  reason: collision with root package name */
    private long f8432r;

    /* renamed from: s  reason: collision with root package name */
    private long f8433s;

    /* renamed from: t  reason: collision with root package name */
    private long f8434t;

    /* renamed from: u  reason: collision with root package name */
    private long f8435u;

    /* renamed from: v  reason: collision with root package name */
    private long f8436v;

    /* renamed from: w  reason: collision with root package name */
    private Track f8437w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f8438x;

    /* renamed from: y  reason: collision with root package name */
    private int f8439y;

    /* renamed from: z  reason: collision with root package name */
    private long f8440z;

    private final class InnerEbmlProcessor implements EbmlProcessor {
        private InnerEbmlProcessor() {
        }

        public void a(int i2) throws ParserException {
            MatroskaExtractor.this.q(i2);
        }

        public void b(int i2, double d2) throws ParserException {
            MatroskaExtractor.this.t(i2, d2);
        }

        public void c(int i2, long j2) throws ParserException {
            MatroskaExtractor.this.z(i2, j2);
        }

        public int d(int i2) {
            return MatroskaExtractor.this.w(i2);
        }

        public boolean e(int i2) {
            return MatroskaExtractor.this.B(i2);
        }

        public void f(int i2, String str) throws ParserException {
            MatroskaExtractor.this.J(i2, str);
        }

        public void g(int i2, long j2, long j3) throws ParserException {
            MatroskaExtractor.this.I(i2, j2, j3);
        }

        public void h(int i2, int i3, ExtractorInput extractorInput) throws IOException {
            MatroskaExtractor.this.n(i2, i3, extractorInput);
        }
    }

    protected static final class Track {
        public int A = -1;
        public int B = -1;
        public int C = 1000;
        public int D = 200;
        public float E = -1.0f;
        public float F = -1.0f;
        public float G = -1.0f;
        public float H = -1.0f;
        public float I = -1.0f;
        public float J = -1.0f;
        public float K = -1.0f;
        public float L = -1.0f;
        public float M = -1.0f;
        public float N = -1.0f;
        public byte[] O;
        public int P = 1;
        public int Q = -1;
        public int R = 8000;
        public long S = 0;
        public long T = 0;
        public TrueHdSampleRechunker U;
        public boolean V;
        public boolean W = true;
        /* access modifiers changed from: private */
        public String X = "eng";
        public TrackOutput Y;
        public int Z;

        /* renamed from: a  reason: collision with root package name */
        public String f8442a;

        /* renamed from: b  reason: collision with root package name */
        public String f8443b;

        /* renamed from: c  reason: collision with root package name */
        public int f8444c;

        /* renamed from: d  reason: collision with root package name */
        public int f8445d;

        /* renamed from: e  reason: collision with root package name */
        public int f8446e;

        /* renamed from: f  reason: collision with root package name */
        public int f8447f;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public int f8448g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f8449h;

        /* renamed from: i  reason: collision with root package name */
        public byte[] f8450i;

        /* renamed from: j  reason: collision with root package name */
        public TrackOutput.CryptoData f8451j;

        /* renamed from: k  reason: collision with root package name */
        public byte[] f8452k;

        /* renamed from: l  reason: collision with root package name */
        public DrmInitData f8453l;

        /* renamed from: m  reason: collision with root package name */
        public int f8454m = -1;

        /* renamed from: n  reason: collision with root package name */
        public int f8455n = -1;

        /* renamed from: o  reason: collision with root package name */
        public int f8456o = -1;

        /* renamed from: p  reason: collision with root package name */
        public int f8457p = -1;

        /* renamed from: q  reason: collision with root package name */
        public int f8458q = -1;

        /* renamed from: r  reason: collision with root package name */
        public int f8459r = 0;

        /* renamed from: s  reason: collision with root package name */
        public int f8460s = -1;

        /* renamed from: t  reason: collision with root package name */
        public float f8461t = 0.0f;

        /* renamed from: u  reason: collision with root package name */
        public float f8462u = 0.0f;

        /* renamed from: v  reason: collision with root package name */
        public float f8463v = 0.0f;

        /* renamed from: w  reason: collision with root package name */
        public byte[] f8464w = null;

        /* renamed from: x  reason: collision with root package name */
        public int f8465x = -1;

        /* renamed from: y  reason: collision with root package name */
        public boolean f8466y = false;

        /* renamed from: z  reason: collision with root package name */
        public int f8467z = -1;

        protected Track() {
        }

        /* access modifiers changed from: private */
        @EnsuresNonNull({"output"})
        public void f() {
            Assertions.f(this.Y);
        }

        @EnsuresNonNull({"codecPrivate"})
        private byte[] g(String str) throws ParserException {
            byte[] bArr = this.f8452k;
            if (bArr != null) {
                return bArr;
            }
            throw ParserException.a("Missing CodecPrivate for codec " + str, (Throwable) null);
        }

        private byte[] h() {
            if (this.E == -1.0f || this.F == -1.0f || this.G == -1.0f || this.H == -1.0f || this.I == -1.0f || this.J == -1.0f || this.K == -1.0f || this.L == -1.0f || this.M == -1.0f || this.N == -1.0f) {
                return null;
            }
            byte[] bArr = new byte[25];
            ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
            order.put((byte) 0);
            order.putShort((short) ((int) ((this.E * 50000.0f) + 0.5f)));
            order.putShort((short) ((int) ((this.F * 50000.0f) + 0.5f)));
            order.putShort((short) ((int) ((this.G * 50000.0f) + 0.5f)));
            order.putShort((short) ((int) ((this.H * 50000.0f) + 0.5f)));
            order.putShort((short) ((int) ((this.I * 50000.0f) + 0.5f)));
            order.putShort((short) ((int) ((this.J * 50000.0f) + 0.5f)));
            order.putShort((short) ((int) ((this.K * 50000.0f) + 0.5f)));
            order.putShort((short) ((int) ((this.L * 50000.0f) + 0.5f)));
            order.putShort((short) ((int) (this.M + 0.5f)));
            order.putShort((short) ((int) (this.N + 0.5f)));
            order.putShort((short) this.C);
            order.putShort((short) this.D);
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
                Log.h("MatroskaExtractor", "Unknown FourCC. Setting mimeType to video/x-unknown");
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
                if (parsableByteArray.A() == MatroskaExtractor.f8409j0.getMostSignificantBits() && parsableByteArray.A() == MatroskaExtractor.f8409j0.getLeastSignificantBits()) {
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
            if ("A_OPUS".equals(this.f8443b)) {
                return z2;
            }
            if (this.f8447f > 0) {
                return true;
            }
            return false;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v16, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v12, resolved type: java.lang.String} */
        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* JADX WARNING: Code restructure failed: missing block: B:117:0x02a5, code lost:
            r4 = r1;
            r1 = null;
            r3 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:136:0x031e, code lost:
            r1 = null;
            r3 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:137:0x0320, code lost:
            r4 = -1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:138:0x0321, code lost:
            r6 = -1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:146:0x0374, code lost:
            r4 = -1;
            r6 = -1;
            r18 = r3;
            r3 = r1;
            r1 = r18;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:149:0x03aa, code lost:
            r3 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:152:0x03b2, code lost:
            r1 = null;
            r3 = null;
            r4 = -1;
            r6 = com.google.protobuf.CodedOutputStream.DEFAULT_BUFFER_SIZE;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:161:0x0421, code lost:
            r1 = null;
            r3 = null;
            r17 = "audio/x-unknown";
         */
        /* JADX WARNING: Code restructure failed: missing block: B:168:0x0437, code lost:
            if (r0.O == null) goto L_0x044a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:169:0x0439, code lost:
            r7 = androidx.media3.extractor.DolbyVisionConfig.a(new androidx.media3.common.util.ParsableByteArray(r0.O));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:170:0x0444, code lost:
            if (r7 == null) goto L_0x044a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:171:0x0446, code lost:
            r3 = r7.f7997c;
            r17 = "video/dolby-vision";
         */
        /* JADX WARNING: Code restructure failed: missing block: B:172:0x044a, code lost:
            r7 = r17;
            r11 = 0;
            r8 = r0.W | 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:173:0x0452, code lost:
            if (r0.V == false) goto L_0x0456;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:174:0x0454, code lost:
            r12 = 2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:175:0x0456, code lost:
            r12 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:176:0x0457, code lost:
            r8 = r8 | r12;
            r12 = new androidx.media3.common.Format.Builder();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:177:0x0461, code lost:
            if (androidx.media3.common.MimeTypes.o(r7) == false) goto L_0x0475;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:178:0x0463, code lost:
            r12.N(r0.P).p0(r0.R).i0(r4);
            r5 = 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:180:0x0479, code lost:
            if (androidx.media3.common.MimeTypes.s(r7) == false) goto L_0x0571;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:182:0x047d, code lost:
            if (r0.f8459r != 0) goto L_0x0491;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:183:0x047f, code lost:
            r2 = r0.f8457p;
            r4 = -1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:184:0x0482, code lost:
            if (r2 != -1) goto L_0x0486;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:185:0x0484, code lost:
            r2 = r0.f8454m;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:186:0x0486, code lost:
            r0.f8457p = r2;
            r2 = r0.f8458q;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:187:0x048a, code lost:
            if (r2 != -1) goto L_0x048e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:188:0x048c, code lost:
            r2 = r0.f8455n;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:189:0x048e, code lost:
            r0.f8458q = r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:190:0x0491, code lost:
            r4 = -1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:191:0x0492, code lost:
            r2 = r0.f8457p;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:192:0x0494, code lost:
            if (r2 == r4) goto L_0x04a6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:193:0x0496, code lost:
            r5 = r0.f8458q;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:194:0x0498, code lost:
            if (r5 == r4) goto L_0x04a6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:195:0x049a, code lost:
            r2 = ((float) (r0.f8455n * r2)) / ((float) (r0.f8454m * r5));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:196:0x04a6, code lost:
            r2 = -1.0f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:198:0x04aa, code lost:
            if (r0.f8466y == false) goto L_0x04db;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:199:0x04ac, code lost:
            r9 = new androidx.media3.common.ColorInfo.Builder().d(r0.f8467z).c(r0.B).e(r0.A).f(h()).g(r0.f8456o).b(r0.f8456o).a();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:201:0x04dd, code lost:
            if (r0.f8442a == null) goto L_0x04fb;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:203:0x04e9, code lost:
            if (androidx.media3.extractor.mkv.MatroskaExtractor.e().containsKey(r0.f8442a) == false) goto L_0x04fb;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:204:0x04eb, code lost:
            r4 = ((java.lang.Integer) androidx.media3.extractor.mkv.MatroskaExtractor.e().get(r0.f8442a)).intValue();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:206:0x04fd, code lost:
            if (r0.f8460s != 0) goto L_0x054b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:208:0x0506, code lost:
            if (java.lang.Float.compare(r0.f8461t, 0.0f) != 0) goto L_0x054b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:210:0x050e, code lost:
            if (java.lang.Float.compare(r0.f8462u, 0.0f) != 0) goto L_0x054b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:212:0x0516, code lost:
            if (java.lang.Float.compare(r0.f8463v, 0.0f) != 0) goto L_0x0519;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:214:0x0521, code lost:
            if (java.lang.Float.compare(r0.f8463v, 90.0f) != 0) goto L_0x0526;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:215:0x0523, code lost:
            r11 = 90;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:217:0x052e, code lost:
            if (java.lang.Float.compare(r0.f8463v, -180.0f) == 0) goto L_0x0548;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:219:0x0538, code lost:
            if (java.lang.Float.compare(r0.f8463v, 180.0f) != 0) goto L_0x053b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:221:0x0543, code lost:
            if (java.lang.Float.compare(r0.f8463v, -90.0f) != 0) goto L_0x054b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:222:0x0545, code lost:
            r11 = com.facebook.imagepipeline.common.RotationOptions.ROTATE_270;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:223:0x0548, code lost:
            r11 = com.facebook.imagepipeline.common.RotationOptions.ROTATE_180;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:224:0x054b, code lost:
            r11 = r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:225:0x054c, code lost:
            r12.v0(r0.f8454m).Y(r0.f8455n).k0(r2).n0(r11).l0(r0.f8464w).r0(r0.f8465x).P(r9);
            r5 = 2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:227:0x0575, code lost:
            if ("application/x-subrip".equals(r7) != false) goto L_0x059f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:229:0x057b, code lost:
            if ("text/x-ssa".equals(r7) != false) goto L_0x059f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:231:0x0581, code lost:
            if ("text/vtt".equals(r7) != false) goto L_0x059f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:233:0x0587, code lost:
            if ("application/vobsub".equals(r7) != false) goto L_0x059f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:235:0x058d, code lost:
            if ("application/pgs".equals(r7) != false) goto L_0x059f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:237:0x0595, code lost:
            if ("application/dvbsubs".equals(r7) == false) goto L_0x0598;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:239:0x059e, code lost:
            throw androidx.media3.common.ParserException.a("Unexpected MIME type.", (java.lang.Throwable) null);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:240:0x059f, code lost:
            r5 = 3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:242:0x05a2, code lost:
            if (r0.f8442a == null) goto L_0x05b5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:244:0x05ae, code lost:
            if (androidx.media3.extractor.mkv.MatroskaExtractor.e().containsKey(r0.f8442a) != false) goto L_0x05b5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:245:0x05b0, code lost:
            r12.c0(r0.f8442a);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:246:0x05b5, code lost:
            r1 = r12.Z(r21).o0(r7).f0(r6).e0(r0.X).q0(r8).b0(r1).O(r3).U(r0.f8453l).K();
            r2 = r20.d(r0.f8444c, r5);
            r0.Y = r2;
            r2.c(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:247:0x05ec, code lost:
            return;
         */
        /* JADX WARNING: Multi-variable type inference failed */
        @org.checkerframework.checker.nullness.qual.RequiresNonNull({"codecId"})
        @org.checkerframework.checker.nullness.qual.EnsuresNonNull({"this.output"})
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void i(androidx.media3.extractor.ExtractorOutput r20, int r21) throws androidx.media3.common.ParserException {
            /*
                r19 = this;
                r0 = r19
                java.lang.String r1 = r0.f8443b
                r1.hashCode()
                int r2 = r1.hashCode()
                r3 = 24
                r4 = 16
                r6 = 32
                r8 = 8
                r10 = 3
                switch(r2) {
                    case -2095576542: goto L_0x01c3;
                    case -2095575984: goto L_0x01b7;
                    case -1985379776: goto L_0x01ab;
                    case -1784763192: goto L_0x019f;
                    case -1730367663: goto L_0x0193;
                    case -1482641358: goto L_0x0187;
                    case -1482641357: goto L_0x017b;
                    case -1373388978: goto L_0x016f;
                    case -933872740: goto L_0x0161;
                    case -538363189: goto L_0x0153;
                    case -538363109: goto L_0x0145;
                    case -425012669: goto L_0x0137;
                    case -356037306: goto L_0x0129;
                    case 62923557: goto L_0x011b;
                    case 62923603: goto L_0x010d;
                    case 62927045: goto L_0x00ff;
                    case 82318131: goto L_0x00f1;
                    case 82338133: goto L_0x00e3;
                    case 82338134: goto L_0x00d5;
                    case 99146302: goto L_0x00c7;
                    case 444813526: goto L_0x00b9;
                    case 542569478: goto L_0x00ab;
                    case 635596514: goto L_0x009d;
                    case 725948237: goto L_0x008f;
                    case 725957860: goto L_0x0082;
                    case 738597099: goto L_0x0075;
                    case 855502857: goto L_0x0068;
                    case 1045209816: goto L_0x005b;
                    case 1422270023: goto L_0x004e;
                    case 1809237540: goto L_0x0041;
                    case 1950749482: goto L_0x0034;
                    case 1950789798: goto L_0x0027;
                    case 1951062397: goto L_0x001a;
                    default: goto L_0x0017;
                }
            L_0x0017:
                r1 = -1
                goto L_0x01ce
            L_0x001a:
                java.lang.String r2 = "A_OPUS"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0023
                goto L_0x0017
            L_0x0023:
                r1 = 32
                goto L_0x01ce
            L_0x0027:
                java.lang.String r2 = "A_FLAC"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0030
                goto L_0x0017
            L_0x0030:
                r1 = 31
                goto L_0x01ce
            L_0x0034:
                java.lang.String r2 = "A_EAC3"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x003d
                goto L_0x0017
            L_0x003d:
                r1 = 30
                goto L_0x01ce
            L_0x0041:
                java.lang.String r2 = "V_MPEG2"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x004a
                goto L_0x0017
            L_0x004a:
                r1 = 29
                goto L_0x01ce
            L_0x004e:
                java.lang.String r2 = "S_TEXT/UTF8"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0057
                goto L_0x0017
            L_0x0057:
                r1 = 28
                goto L_0x01ce
            L_0x005b:
                java.lang.String r2 = "S_TEXT/WEBVTT"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0064
                goto L_0x0017
            L_0x0064:
                r1 = 27
                goto L_0x01ce
            L_0x0068:
                java.lang.String r2 = "V_MPEGH/ISO/HEVC"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0071
                goto L_0x0017
            L_0x0071:
                r1 = 26
                goto L_0x01ce
            L_0x0075:
                java.lang.String r2 = "S_TEXT/ASS"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x007e
                goto L_0x0017
            L_0x007e:
                r1 = 25
                goto L_0x01ce
            L_0x0082:
                java.lang.String r2 = "A_PCM/INT/LIT"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x008b
                goto L_0x0017
            L_0x008b:
                r1 = 24
                goto L_0x01ce
            L_0x008f:
                java.lang.String r2 = "A_PCM/INT/BIG"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0099
                goto L_0x0017
            L_0x0099:
                r1 = 23
                goto L_0x01ce
            L_0x009d:
                java.lang.String r2 = "A_PCM/FLOAT/IEEE"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x00a7
                goto L_0x0017
            L_0x00a7:
                r1 = 22
                goto L_0x01ce
            L_0x00ab:
                java.lang.String r2 = "A_DTS/EXPRESS"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x00b5
                goto L_0x0017
            L_0x00b5:
                r1 = 21
                goto L_0x01ce
            L_0x00b9:
                java.lang.String r2 = "V_THEORA"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x00c3
                goto L_0x0017
            L_0x00c3:
                r1 = 20
                goto L_0x01ce
            L_0x00c7:
                java.lang.String r2 = "S_HDMV/PGS"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x00d1
                goto L_0x0017
            L_0x00d1:
                r1 = 19
                goto L_0x01ce
            L_0x00d5:
                java.lang.String r2 = "V_VP9"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x00df
                goto L_0x0017
            L_0x00df:
                r1 = 18
                goto L_0x01ce
            L_0x00e3:
                java.lang.String r2 = "V_VP8"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x00ed
                goto L_0x0017
            L_0x00ed:
                r1 = 17
                goto L_0x01ce
            L_0x00f1:
                java.lang.String r2 = "V_AV1"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x00fb
                goto L_0x0017
            L_0x00fb:
                r1 = 16
                goto L_0x01ce
            L_0x00ff:
                java.lang.String r2 = "A_DTS"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0109
                goto L_0x0017
            L_0x0109:
                r1 = 15
                goto L_0x01ce
            L_0x010d:
                java.lang.String r2 = "A_AC3"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0117
                goto L_0x0017
            L_0x0117:
                r1 = 14
                goto L_0x01ce
            L_0x011b:
                java.lang.String r2 = "A_AAC"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0125
                goto L_0x0017
            L_0x0125:
                r1 = 13
                goto L_0x01ce
            L_0x0129:
                java.lang.String r2 = "A_DTS/LOSSLESS"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0133
                goto L_0x0017
            L_0x0133:
                r1 = 12
                goto L_0x01ce
            L_0x0137:
                java.lang.String r2 = "S_VOBSUB"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0141
                goto L_0x0017
            L_0x0141:
                r1 = 11
                goto L_0x01ce
            L_0x0145:
                java.lang.String r2 = "V_MPEG4/ISO/AVC"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x014f
                goto L_0x0017
            L_0x014f:
                r1 = 10
                goto L_0x01ce
            L_0x0153:
                java.lang.String r2 = "V_MPEG4/ISO/ASP"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x015d
                goto L_0x0017
            L_0x015d:
                r1 = 9
                goto L_0x01ce
            L_0x0161:
                java.lang.String r2 = "S_DVBSUB"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x016b
                goto L_0x0017
            L_0x016b:
                r1 = 8
                goto L_0x01ce
            L_0x016f:
                java.lang.String r2 = "V_MS/VFW/FOURCC"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0179
                goto L_0x0017
            L_0x0179:
                r1 = 7
                goto L_0x01ce
            L_0x017b:
                java.lang.String r2 = "A_MPEG/L3"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0185
                goto L_0x0017
            L_0x0185:
                r1 = 6
                goto L_0x01ce
            L_0x0187:
                java.lang.String r2 = "A_MPEG/L2"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0191
                goto L_0x0017
            L_0x0191:
                r1 = 5
                goto L_0x01ce
            L_0x0193:
                java.lang.String r2 = "A_VORBIS"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x019d
                goto L_0x0017
            L_0x019d:
                r1 = 4
                goto L_0x01ce
            L_0x019f:
                java.lang.String r2 = "A_TRUEHD"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x01a9
                goto L_0x0017
            L_0x01a9:
                r1 = 3
                goto L_0x01ce
            L_0x01ab:
                java.lang.String r2 = "A_MS/ACM"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x01b5
                goto L_0x0017
            L_0x01b5:
                r1 = 2
                goto L_0x01ce
            L_0x01b7:
                java.lang.String r2 = "V_MPEG4/ISO/SP"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x01c1
                goto L_0x0017
            L_0x01c1:
                r1 = 1
                goto L_0x01ce
            L_0x01c3:
                java.lang.String r2 = "V_MPEG4/ISO/AP"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x01cd
                goto L_0x0017
            L_0x01cd:
                r1 = 0
            L_0x01ce:
                java.lang.String r2 = "application/pgs"
                java.lang.String r13 = "application/vobsub"
                java.lang.String r14 = "text/vtt"
                java.lang.String r15 = "text/x-ssa"
                java.lang.String r5 = "application/x-subrip"
                r16 = 4096(0x1000, float:5.74E-42)
                java.lang.String r7 = ". Setting mimeType to "
                java.lang.String r17 = "audio/raw"
                java.lang.String r12 = "MatroskaExtractor"
                java.lang.String r11 = "audio/x-unknown"
                r9 = 0
                switch(r1) {
                    case 0: goto L_0x0427;
                    case 1: goto L_0x0427;
                    case 2: goto L_0x03d7;
                    case 3: goto L_0x03cc;
                    case 4: goto L_0x03b9;
                    case 5: goto L_0x03b0;
                    case 6: goto L_0x03ad;
                    case 7: goto L_0x0391;
                    case 8: goto L_0x037d;
                    case 9: goto L_0x0427;
                    case 10: goto L_0x035b;
                    case 11: goto L_0x034d;
                    case 12: goto L_0x034a;
                    case 13: goto L_0x032d;
                    case 14: goto L_0x032a;
                    case 15: goto L_0x0327;
                    case 16: goto L_0x0324;
                    case 17: goto L_0x031c;
                    case 18: goto L_0x0319;
                    case 19: goto L_0x0316;
                    case 20: goto L_0x0313;
                    case 21: goto L_0x0327;
                    case 22: goto L_0x02ed;
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
                androidx.media3.common.ParserException r1 = androidx.media3.common.ParserException.a(r1, r9)
                throw r1
            L_0x01ed:
                java.util.ArrayList r1 = new java.util.ArrayList
                r1.<init>(r10)
                java.lang.String r3 = r0.f8443b
                byte[] r3 = r0.g(r3)
                r1.add(r3)
                java.nio.ByteBuffer r3 = java.nio.ByteBuffer.allocate(r8)
                java.nio.ByteOrder r4 = java.nio.ByteOrder.LITTLE_ENDIAN
                java.nio.ByteBuffer r3 = r3.order(r4)
                long r6 = r0.S
                java.nio.ByteBuffer r3 = r3.putLong(r6)
                byte[] r3 = r3.array()
                r1.add(r3)
                java.nio.ByteBuffer r3 = java.nio.ByteBuffer.allocate(r8)
                java.nio.ByteBuffer r3 = r3.order(r4)
                long r6 = r0.T
                java.nio.ByteBuffer r3 = r3.putLong(r6)
                byte[] r3 = r3.array()
                r1.add(r3)
                java.lang.String r17 = "audio/opus"
                r16 = 5760(0x1680, float:8.071E-42)
                r3 = r9
                r4 = -1
                r6 = 5760(0x1680, float:8.071E-42)
                goto L_0x0435
            L_0x0231:
                java.lang.String r1 = r0.f8443b
                byte[] r1 = r0.g(r1)
                java.util.List r1 = java.util.Collections.singletonList(r1)
                java.lang.String r17 = "audio/flac"
                goto L_0x03aa
            L_0x023f:
                java.lang.String r17 = "audio/eac3"
                goto L_0x031e
            L_0x0243:
                java.lang.String r17 = "video/mpeg2"
                goto L_0x031e
            L_0x0247:
                r17 = r5
                goto L_0x031e
            L_0x024b:
                r1 = r9
                r3 = r1
                r17 = r14
                goto L_0x0320
            L_0x0251:
                androidx.media3.common.util.ParsableByteArray r1 = new androidx.media3.common.util.ParsableByteArray
                java.lang.String r3 = r0.f8443b
                byte[] r3 = r0.g(r3)
                r1.<init>((byte[]) r3)
                androidx.media3.extractor.HevcConfig r1 = androidx.media3.extractor.HevcConfig.a(r1)
                java.util.List<byte[]> r3 = r1.f8038a
                int r4 = r1.f8039b
                r0.Z = r4
                java.lang.String r1 = r1.f8049l
                java.lang.String r17 = "video/hevc"
                goto L_0x0374
            L_0x026c:
                byte[] r1 = androidx.media3.extractor.mkv.MatroskaExtractor.f8406g0
                java.lang.String r3 = r0.f8443b
                byte[] r3 = r0.g(r3)
                com.google.common.collect.ImmutableList r1 = com.google.common.collect.ImmutableList.t(r1, r3)
                r3 = r9
                r17 = r15
                goto L_0x0320
            L_0x027f:
                int r1 = r0.Q
                int r1 = androidx.media3.common.util.Util.g0(r1)
                if (r1 != 0) goto L_0x02a5
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r3 = "Unsupported little endian PCM bit depth: "
                r1.append(r3)
                int r3 = r0.Q
                r1.append(r3)
                r1.append(r7)
                r1.append(r11)
                java.lang.String r1 = r1.toString()
                androidx.media3.common.util.Log.h(r12, r1)
                goto L_0x0421
            L_0x02a5:
                r4 = r1
                r1 = r9
                r3 = r1
                goto L_0x0321
            L_0x02aa:
                int r1 = r0.Q
                if (r1 != r8) goto L_0x02b3
                r1 = r9
                r3 = r1
                r4 = 3
                goto L_0x0321
            L_0x02b3:
                if (r1 != r4) goto L_0x02bd
                r1 = 268435456(0x10000000, float:2.5243549E-29)
                r1 = r9
                r3 = r1
                r4 = 268435456(0x10000000, float:2.5243549E-29)
                goto L_0x0321
            L_0x02bd:
                if (r1 != r3) goto L_0x02c6
                r1 = 1342177280(0x50000000, float:8.5899346E9)
                r1 = r9
                r3 = r1
                r4 = 1342177280(0x50000000, float:8.5899346E9)
                goto L_0x0321
            L_0x02c6:
                if (r1 != r6) goto L_0x02cf
                r1 = 1610612736(0x60000000, float:3.6893488E19)
                r1 = r9
                r3 = r1
                r4 = 1610612736(0x60000000, float:3.6893488E19)
                goto L_0x0321
            L_0x02cf:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r3 = "Unsupported big endian PCM bit depth: "
                r1.append(r3)
                int r3 = r0.Q
                r1.append(r3)
                r1.append(r7)
                r1.append(r11)
                java.lang.String r1 = r1.toString()
                androidx.media3.common.util.Log.h(r12, r1)
                goto L_0x0421
            L_0x02ed:
                int r1 = r0.Q
                if (r1 != r6) goto L_0x02f5
                r1 = r9
                r3 = r1
                r4 = 4
                goto L_0x0321
            L_0x02f5:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r3 = "Unsupported floating point PCM bit depth: "
                r1.append(r3)
                int r3 = r0.Q
                r1.append(r3)
                r1.append(r7)
                r1.append(r11)
                java.lang.String r1 = r1.toString()
                androidx.media3.common.util.Log.h(r12, r1)
                goto L_0x0421
            L_0x0313:
                java.lang.String r17 = "video/x-unknown"
                goto L_0x031e
            L_0x0316:
                r17 = r2
                goto L_0x031e
            L_0x0319:
                java.lang.String r17 = "video/x-vnd.on2.vp9"
                goto L_0x031e
            L_0x031c:
                java.lang.String r17 = "video/x-vnd.on2.vp8"
            L_0x031e:
                r1 = r9
                r3 = r1
            L_0x0320:
                r4 = -1
            L_0x0321:
                r6 = -1
                goto L_0x0435
            L_0x0324:
                java.lang.String r17 = "video/av01"
                goto L_0x031e
            L_0x0327:
                java.lang.String r17 = "audio/vnd.dts"
                goto L_0x031e
            L_0x032a:
                java.lang.String r17 = "audio/ac3"
                goto L_0x031e
            L_0x032d:
                java.lang.String r1 = r0.f8443b
                byte[] r1 = r0.g(r1)
                java.util.List r1 = java.util.Collections.singletonList(r1)
                byte[] r3 = r0.f8452k
                androidx.media3.extractor.AacUtil$Config r3 = androidx.media3.extractor.AacUtil.e(r3)
                int r4 = r3.f7895a
                r0.R = r4
                int r4 = r3.f7896b
                r0.P = r4
                java.lang.String r3 = r3.f7897c
                java.lang.String r17 = "audio/mp4a-latm"
                goto L_0x0320
            L_0x034a:
                java.lang.String r17 = "audio/vnd.dts.hd"
                goto L_0x031e
            L_0x034d:
                java.lang.String r1 = r0.f8443b
                byte[] r1 = r0.g(r1)
                com.google.common.collect.ImmutableList r1 = com.google.common.collect.ImmutableList.s(r1)
                r3 = r9
                r17 = r13
                goto L_0x0320
            L_0x035b:
                androidx.media3.common.util.ParsableByteArray r1 = new androidx.media3.common.util.ParsableByteArray
                java.lang.String r3 = r0.f8443b
                byte[] r3 = r0.g(r3)
                r1.<init>((byte[]) r3)
                androidx.media3.extractor.AvcConfig r1 = androidx.media3.extractor.AvcConfig.b(r1)
                java.util.List<byte[]> r3 = r1.f7917a
                int r4 = r1.f7918b
                r0.Z = r4
                java.lang.String r1 = r1.f7928l
                java.lang.String r17 = "video/avc"
            L_0x0374:
                r4 = -1
                r6 = -1
                r18 = r3
                r3 = r1
                r1 = r18
                goto L_0x0435
            L_0x037d:
                r1 = 4
                byte[] r3 = new byte[r1]
                java.lang.String r4 = r0.f8443b
                byte[] r4 = r0.g(r4)
                r6 = 0
                java.lang.System.arraycopy(r4, r6, r3, r6, r1)
                com.google.common.collect.ImmutableList r1 = com.google.common.collect.ImmutableList.s(r3)
                java.lang.String r17 = "application/dvbsubs"
                goto L_0x03aa
            L_0x0391:
                androidx.media3.common.util.ParsableByteArray r1 = new androidx.media3.common.util.ParsableByteArray
                java.lang.String r3 = r0.f8443b
                byte[] r3 = r0.g(r3)
                r1.<init>((byte[]) r3)
                android.util.Pair r1 = k(r1)
                java.lang.Object r3 = r1.first
                r17 = r3
                java.lang.String r17 = (java.lang.String) r17
                java.lang.Object r1 = r1.second
                java.util.List r1 = (java.util.List) r1
            L_0x03aa:
                r3 = r9
                goto L_0x0320
            L_0x03ad:
                java.lang.String r17 = "audio/mpeg"
                goto L_0x03b2
            L_0x03b0:
                java.lang.String r17 = "audio/mpeg-L2"
            L_0x03b2:
                r1 = r9
                r3 = r1
                r4 = -1
                r6 = 4096(0x1000, float:5.74E-42)
                goto L_0x0435
            L_0x03b9:
                java.lang.String r1 = r0.f8443b
                byte[] r1 = r0.g(r1)
                java.util.List r1 = m(r1)
                java.lang.String r17 = "audio/vorbis"
                r16 = 8192(0x2000, float:1.14794E-41)
                r3 = r9
                r4 = -1
                r6 = 8192(0x2000, float:1.14794E-41)
                goto L_0x0435
            L_0x03cc:
                androidx.media3.extractor.TrueHdSampleRechunker r1 = new androidx.media3.extractor.TrueHdSampleRechunker
                r1.<init>()
                r0.U = r1
                java.lang.String r17 = "audio/true-hd"
                goto L_0x031e
            L_0x03d7:
                androidx.media3.common.util.ParsableByteArray r1 = new androidx.media3.common.util.ParsableByteArray
                java.lang.String r3 = r0.f8443b
                byte[] r3 = r0.g(r3)
                r1.<init>((byte[]) r3)
                boolean r1 = l(r1)
                if (r1 == 0) goto L_0x040d
                int r1 = r0.Q
                int r1 = androidx.media3.common.util.Util.g0(r1)
                if (r1 != 0) goto L_0x02a5
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r3 = "Unsupported PCM bit depth: "
                r1.append(r3)
                int r3 = r0.Q
                r1.append(r3)
                r1.append(r7)
                r1.append(r11)
                java.lang.String r1 = r1.toString()
                androidx.media3.common.util.Log.h(r12, r1)
                goto L_0x0421
            L_0x040d:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r3 = "Non-PCM MS/ACM is unsupported. Setting mimeType to "
                r1.append(r3)
                r1.append(r11)
                java.lang.String r1 = r1.toString()
                androidx.media3.common.util.Log.h(r12, r1)
            L_0x0421:
                r1 = r9
                r3 = r1
                r17 = r11
                goto L_0x0320
            L_0x0427:
                byte[] r1 = r0.f8452k
                if (r1 != 0) goto L_0x042d
                r1 = r9
                goto L_0x0431
            L_0x042d:
                java.util.List r1 = java.util.Collections.singletonList(r1)
            L_0x0431:
                java.lang.String r17 = "video/mp4v-es"
                goto L_0x03aa
            L_0x0435:
                byte[] r7 = r0.O
                if (r7 == 0) goto L_0x044a
                androidx.media3.common.util.ParsableByteArray r7 = new androidx.media3.common.util.ParsableByteArray
                byte[] r8 = r0.O
                r7.<init>((byte[]) r8)
                androidx.media3.extractor.DolbyVisionConfig r7 = androidx.media3.extractor.DolbyVisionConfig.a(r7)
                if (r7 == 0) goto L_0x044a
                java.lang.String r3 = r7.f7997c
                java.lang.String r17 = "video/dolby-vision"
            L_0x044a:
                r7 = r17
                boolean r8 = r0.W
                r11 = 0
                r8 = r8 | r11
                boolean r12 = r0.V
                if (r12 == 0) goto L_0x0456
                r12 = 2
                goto L_0x0457
            L_0x0456:
                r12 = 0
            L_0x0457:
                r8 = r8 | r12
                androidx.media3.common.Format$Builder r12 = new androidx.media3.common.Format$Builder
                r12.<init>()
                boolean r16 = androidx.media3.common.MimeTypes.o(r7)
                if (r16 == 0) goto L_0x0475
                int r2 = r0.P
                androidx.media3.common.Format$Builder r2 = r12.N(r2)
                int r5 = r0.R
                androidx.media3.common.Format$Builder r2 = r2.p0(r5)
                r2.i0(r4)
                r5 = 1
                goto L_0x05a0
            L_0x0475:
                boolean r4 = androidx.media3.common.MimeTypes.s(r7)
                if (r4 == 0) goto L_0x0571
                int r2 = r0.f8459r
                if (r2 != 0) goto L_0x0491
                int r2 = r0.f8457p
                r4 = -1
                if (r2 != r4) goto L_0x0486
                int r2 = r0.f8454m
            L_0x0486:
                r0.f8457p = r2
                int r2 = r0.f8458q
                if (r2 != r4) goto L_0x048e
                int r2 = r0.f8455n
            L_0x048e:
                r0.f8458q = r2
                goto L_0x0492
            L_0x0491:
                r4 = -1
            L_0x0492:
                int r2 = r0.f8457p
                if (r2 == r4) goto L_0x04a6
                int r5 = r0.f8458q
                if (r5 == r4) goto L_0x04a6
                int r10 = r0.f8455n
                int r10 = r10 * r2
                float r2 = (float) r10
                int r10 = r0.f8454m
                int r10 = r10 * r5
                float r5 = (float) r10
                float r2 = r2 / r5
                goto L_0x04a8
            L_0x04a6:
                r2 = -1082130432(0xffffffffbf800000, float:-1.0)
            L_0x04a8:
                boolean r5 = r0.f8466y
                if (r5 == 0) goto L_0x04db
                byte[] r5 = r19.h()
                androidx.media3.common.ColorInfo$Builder r9 = new androidx.media3.common.ColorInfo$Builder
                r9.<init>()
                int r10 = r0.f8467z
                androidx.media3.common.ColorInfo$Builder r9 = r9.d(r10)
                int r10 = r0.B
                androidx.media3.common.ColorInfo$Builder r9 = r9.c(r10)
                int r10 = r0.A
                androidx.media3.common.ColorInfo$Builder r9 = r9.e(r10)
                androidx.media3.common.ColorInfo$Builder r5 = r9.f(r5)
                int r9 = r0.f8456o
                androidx.media3.common.ColorInfo$Builder r5 = r5.g(r9)
                int r9 = r0.f8456o
                androidx.media3.common.ColorInfo$Builder r5 = r5.b(r9)
                androidx.media3.common.ColorInfo r9 = r5.a()
            L_0x04db:
                java.lang.String r5 = r0.f8442a
                if (r5 == 0) goto L_0x04fb
                java.util.Map r5 = androidx.media3.extractor.mkv.MatroskaExtractor.f8410k0
                java.lang.String r10 = r0.f8442a
                boolean r5 = r5.containsKey(r10)
                if (r5 == 0) goto L_0x04fb
                java.util.Map r4 = androidx.media3.extractor.mkv.MatroskaExtractor.f8410k0
                java.lang.String r5 = r0.f8442a
                java.lang.Object r4 = r4.get(r5)
                java.lang.Integer r4 = (java.lang.Integer) r4
                int r4 = r4.intValue()
            L_0x04fb:
                int r5 = r0.f8460s
                if (r5 != 0) goto L_0x054b
                float r5 = r0.f8461t
                r10 = 0
                int r5 = java.lang.Float.compare(r5, r10)
                if (r5 != 0) goto L_0x054b
                float r5 = r0.f8462u
                int r5 = java.lang.Float.compare(r5, r10)
                if (r5 != 0) goto L_0x054b
                float r5 = r0.f8463v
                int r5 = java.lang.Float.compare(r5, r10)
                if (r5 != 0) goto L_0x0519
                goto L_0x054c
            L_0x0519:
                float r5 = r0.f8463v
                r10 = 1119092736(0x42b40000, float:90.0)
                int r5 = java.lang.Float.compare(r5, r10)
                if (r5 != 0) goto L_0x0526
                r11 = 90
                goto L_0x054c
            L_0x0526:
                float r5 = r0.f8463v
                r10 = -1020002304(0xffffffffc3340000, float:-180.0)
                int r5 = java.lang.Float.compare(r5, r10)
                if (r5 == 0) goto L_0x0548
                float r5 = r0.f8463v
                r10 = 1127481344(0x43340000, float:180.0)
                int r5 = java.lang.Float.compare(r5, r10)
                if (r5 != 0) goto L_0x053b
                goto L_0x0548
            L_0x053b:
                float r5 = r0.f8463v
                r10 = -1028390912(0xffffffffc2b40000, float:-90.0)
                int r5 = java.lang.Float.compare(r5, r10)
                if (r5 != 0) goto L_0x054b
                r11 = 270(0x10e, float:3.78E-43)
                goto L_0x054c
            L_0x0548:
                r11 = 180(0xb4, float:2.52E-43)
                goto L_0x054c
            L_0x054b:
                r11 = r4
            L_0x054c:
                int r4 = r0.f8454m
                androidx.media3.common.Format$Builder r4 = r12.v0(r4)
                int r5 = r0.f8455n
                androidx.media3.common.Format$Builder r4 = r4.Y(r5)
                androidx.media3.common.Format$Builder r2 = r4.k0(r2)
                androidx.media3.common.Format$Builder r2 = r2.n0(r11)
                byte[] r4 = r0.f8464w
                androidx.media3.common.Format$Builder r2 = r2.l0(r4)
                int r4 = r0.f8465x
                androidx.media3.common.Format$Builder r2 = r2.r0(r4)
                r2.P(r9)
                r5 = 2
                goto L_0x05a0
            L_0x0571:
                boolean r4 = r5.equals(r7)
                if (r4 != 0) goto L_0x059f
                boolean r4 = r15.equals(r7)
                if (r4 != 0) goto L_0x059f
                boolean r4 = r14.equals(r7)
                if (r4 != 0) goto L_0x059f
                boolean r4 = r13.equals(r7)
                if (r4 != 0) goto L_0x059f
                boolean r2 = r2.equals(r7)
                if (r2 != 0) goto L_0x059f
                java.lang.String r2 = "application/dvbsubs"
                boolean r2 = r2.equals(r7)
                if (r2 == 0) goto L_0x0598
                goto L_0x059f
            L_0x0598:
                java.lang.String r1 = "Unexpected MIME type."
                androidx.media3.common.ParserException r1 = androidx.media3.common.ParserException.a(r1, r9)
                throw r1
            L_0x059f:
                r5 = 3
            L_0x05a0:
                java.lang.String r2 = r0.f8442a
                if (r2 == 0) goto L_0x05b5
                java.util.Map r2 = androidx.media3.extractor.mkv.MatroskaExtractor.f8410k0
                java.lang.String r4 = r0.f8442a
                boolean r2 = r2.containsKey(r4)
                if (r2 != 0) goto L_0x05b5
                java.lang.String r2 = r0.f8442a
                r12.c0(r2)
            L_0x05b5:
                r2 = r21
                androidx.media3.common.Format$Builder r2 = r12.Z(r2)
                androidx.media3.common.Format$Builder r2 = r2.o0(r7)
                androidx.media3.common.Format$Builder r2 = r2.f0(r6)
                java.lang.String r4 = r0.X
                androidx.media3.common.Format$Builder r2 = r2.e0(r4)
                androidx.media3.common.Format$Builder r2 = r2.q0(r8)
                androidx.media3.common.Format$Builder r1 = r2.b0(r1)
                androidx.media3.common.Format$Builder r1 = r1.O(r3)
                androidx.media3.common.DrmInitData r2 = r0.f8453l
                androidx.media3.common.Format$Builder r1 = r1.U(r2)
                androidx.media3.common.Format r1 = r1.K()
                int r2 = r0.f8444c
                r3 = r20
                androidx.media3.extractor.TrackOutput r2 = r3.d(r2, r5)
                r0.Y = r2
                r2.c(r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.mkv.MatroskaExtractor.Track.i(androidx.media3.extractor.ExtractorOutput, int):void");
        }

        @RequiresNonNull({"output"})
        public void j() {
            TrueHdSampleRechunker trueHdSampleRechunker = this.U;
            if (trueHdSampleRechunker != null) {
                trueHdSampleRechunker.a(this.Y, this.f8451j);
            }
        }

        public void n() {
            TrueHdSampleRechunker trueHdSampleRechunker = this.U;
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
        f8410k0 = Collections.unmodifiableMap(hashMap);
    }

    @Deprecated
    public MatroskaExtractor() {
        this(new DefaultEbmlReader(), 2, SubtitleParser.Factory.f8798a);
    }

    private static boolean A(String str) {
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

    /* access modifiers changed from: private */
    public static /* synthetic */ Extractor[] C() {
        return new Extractor[]{new MatroskaExtractor(SubtitleParser.Factory.f8798a, 2)};
    }

    private boolean D(PositionHolder positionHolder, long j2) {
        if (this.A) {
            this.C = j2;
            positionHolder.f8069a = this.B;
            this.A = false;
            return true;
        }
        if (this.f8438x) {
            long j3 = this.C;
            if (j3 != -1) {
                positionHolder.f8069a = j3;
                this.C = -1;
                return true;
            }
        }
        return false;
    }

    private void E(ExtractorInput extractorInput, int i2) throws IOException {
        if (this.f8423i.g() < i2) {
            if (this.f8423i.b() < i2) {
                ParsableByteArray parsableByteArray = this.f8423i;
                parsableByteArray.c(Math.max(parsableByteArray.b() * 2, i2));
            }
            extractorInput.readFully(this.f8423i.e(), this.f8423i.g(), i2 - this.f8423i.g());
            this.f8423i.T(i2);
        }
    }

    private void F() {
        this.U = 0;
        this.V = 0;
        this.W = 0;
        this.X = false;
        this.Y = false;
        this.Z = false;
        this.f8412a0 = 0;
        this.f8414b0 = 0;
        this.f8416c0 = false;
        this.f8426l.Q(0);
    }

    private long G(long j2) throws ParserException {
        long j3 = this.f8434t;
        if (j3 != -9223372036854775807L) {
            return Util.c1(j2, j3, 1000);
        }
        throw ParserException.a("Can't scale timecode prior to timecodeScale being set.", (Throwable) null);
    }

    private static void H(String str, long j2, byte[] bArr) {
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
                bArr2 = u(j2, "%01d:%02d:%02d:%02d", NotificationOptions.SKIP_STEP_TEN_SECONDS_IN_MS);
                i2 = 21;
                break;
            case 1:
                bArr2 = u(j2, "%02d:%02d:%02d.%03d", 1000);
                i2 = 25;
                break;
            case 2:
                bArr2 = u(j2, "%02d:%02d:%02d,%03d", 1000);
                i2 = 19;
                break;
            default:
                throw new IllegalArgumentException();
        }
        System.arraycopy(bArr2, 0, bArr, i2, bArr2.length);
    }

    @RequiresNonNull({"#2.output"})
    private int K(ExtractorInput extractorInput, Track track, int i2, boolean z2) throws IOException {
        boolean z3;
        boolean z4;
        int i3;
        if ("S_TEXT/UTF8".equals(track.f8443b)) {
            L(extractorInput, f8405f0, i2);
            return s();
        } else if ("S_TEXT/ASS".equals(track.f8443b)) {
            L(extractorInput, f8407h0, i2);
            return s();
        } else if ("S_TEXT/WEBVTT".equals(track.f8443b)) {
            L(extractorInput, f8408i0, i2);
            return s();
        } else {
            TrackOutput trackOutput = track.Y;
            boolean z5 = true;
            if (!this.X) {
                if (track.f8449h) {
                    this.Q &= -1073741825;
                    int i4 = 128;
                    if (!this.Y) {
                        extractorInput.readFully(this.f8423i.e(), 0, 1);
                        this.U++;
                        if ((this.f8423i.e()[0] & y1.f36938c) != 128) {
                            this.f8414b0 = this.f8423i.e()[0];
                            this.Y = true;
                        } else {
                            throw ParserException.a("Extension bit is set in signal byte", (Throwable) null);
                        }
                    }
                    byte b2 = this.f8414b0;
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
                        this.Q |= 1073741824;
                        if (!this.f8416c0) {
                            extractorInput.readFully(this.f8428n.e(), 0, 8);
                            this.U += 8;
                            this.f8416c0 = true;
                            byte[] e2 = this.f8423i.e();
                            if (!z4) {
                                i4 = 0;
                            }
                            e2[0] = (byte) (i4 | 8);
                            this.f8423i.U(0);
                            trackOutput.a(this.f8423i, 1, 1);
                            this.V++;
                            this.f8428n.U(0);
                            trackOutput.a(this.f8428n, 8, 1);
                            this.V += 8;
                        }
                        if (z4) {
                            if (!this.Z) {
                                extractorInput.readFully(this.f8423i.e(), 0, 1);
                                this.U++;
                                this.f8423i.U(0);
                                this.f8412a0 = this.f8423i.H();
                                this.Z = true;
                            }
                            int i5 = this.f8412a0 * 4;
                            this.f8423i.Q(i5);
                            extractorInput.readFully(this.f8423i.e(), 0, i5);
                            this.U += i5;
                            short s2 = (short) ((this.f8412a0 / 2) + 1);
                            int i6 = (s2 * 6) + 2;
                            ByteBuffer byteBuffer = this.f8431q;
                            if (byteBuffer == null || byteBuffer.capacity() < i6) {
                                this.f8431q = ByteBuffer.allocate(i6);
                            }
                            this.f8431q.position(0);
                            this.f8431q.putShort(s2);
                            int i7 = 0;
                            int i8 = 0;
                            while (true) {
                                i3 = this.f8412a0;
                                if (i7 >= i3) {
                                    break;
                                }
                                int L2 = this.f8423i.L();
                                if (i7 % 2 == 0) {
                                    this.f8431q.putShort((short) (L2 - i8));
                                } else {
                                    this.f8431q.putInt(L2 - i8);
                                }
                                i7++;
                                i8 = L2;
                            }
                            int i9 = (i2 - this.U) - i8;
                            if (i3 % 2 == 1) {
                                this.f8431q.putInt(i9);
                            } else {
                                this.f8431q.putShort((short) i9);
                                this.f8431q.putInt(0);
                            }
                            this.f8429o.S(this.f8431q.array(), i6);
                            trackOutput.a(this.f8429o, i6, 1);
                            this.V += i6;
                        }
                    }
                } else {
                    byte[] bArr = track.f8450i;
                    if (bArr != null) {
                        this.f8426l.S(bArr, bArr.length);
                    }
                }
                if (track.o(z2)) {
                    this.Q |= 268435456;
                    this.f8430p.Q(0);
                    int g2 = (this.f8426l.g() + i2) - this.U;
                    this.f8423i.Q(4);
                    this.f8423i.e()[0] = (byte) ((g2 >> 24) & JfifUtil.MARKER_FIRST_BYTE);
                    this.f8423i.e()[1] = (byte) ((g2 >> 16) & JfifUtil.MARKER_FIRST_BYTE);
                    this.f8423i.e()[2] = (byte) ((g2 >> 8) & JfifUtil.MARKER_FIRST_BYTE);
                    this.f8423i.e()[3] = (byte) (g2 & JfifUtil.MARKER_FIRST_BYTE);
                    trackOutput.a(this.f8423i, 4, 2);
                    this.V += 4;
                }
                this.X = true;
            }
            int g3 = i2 + this.f8426l.g();
            if (!"V_MPEG4/ISO/AVC".equals(track.f8443b) && !"V_MPEGH/ISO/HEVC".equals(track.f8443b)) {
                if (track.U != null) {
                    if (this.f8426l.g() != 0) {
                        z5 = false;
                    }
                    Assertions.h(z5);
                    track.U.d(extractorInput);
                }
                while (true) {
                    int i10 = this.U;
                    if (i10 >= g3) {
                        break;
                    }
                    int M2 = M(extractorInput, trackOutput, g3 - i10);
                    this.U += M2;
                    this.V += M2;
                }
            } else {
                byte[] e3 = this.f8422h.e();
                e3[0] = 0;
                e3[1] = 0;
                e3[2] = 0;
                int i11 = track.Z;
                int i12 = 4 - i11;
                while (this.U < g3) {
                    int i13 = this.W;
                    if (i13 == 0) {
                        N(extractorInput, e3, i12, i11);
                        this.U += i11;
                        this.f8422h.U(0);
                        this.W = this.f8422h.L();
                        this.f8421g.U(0);
                        trackOutput.b(this.f8421g, 4);
                        this.V += 4;
                    } else {
                        int M3 = M(extractorInput, trackOutput, i13);
                        this.U += M3;
                        this.V += M3;
                        this.W -= M3;
                    }
                }
            }
            if ("A_VORBIS".equals(track.f8443b)) {
                this.f8424j.U(0);
                trackOutput.b(this.f8424j, 4);
                this.V += 4;
            }
            return s();
        }
    }

    private void L(ExtractorInput extractorInput, byte[] bArr, int i2) throws IOException {
        int length = bArr.length + i2;
        if (this.f8427m.b() < length) {
            this.f8427m.R(Arrays.copyOf(bArr, length + i2));
        } else {
            System.arraycopy(bArr, 0, this.f8427m.e(), 0, bArr.length);
        }
        extractorInput.readFully(this.f8427m.e(), bArr.length, i2);
        this.f8427m.U(0);
        this.f8427m.T(length);
    }

    private int M(ExtractorInput extractorInput, TrackOutput trackOutput, int i2) throws IOException {
        int a2 = this.f8426l.a();
        if (a2 <= 0) {
            return trackOutput.d(extractorInput, i2, false);
        }
        int min = Math.min(i2, a2);
        trackOutput.b(this.f8426l, min);
        return min;
    }

    private void N(ExtractorInput extractorInput, byte[] bArr, int i2, int i3) throws IOException {
        int min = Math.min(i3, this.f8426l.a());
        extractorInput.readFully(bArr, i2 + min, i3 - min);
        if (min > 0) {
            this.f8426l.l(bArr, i2, min);
        }
    }

    @EnsuresNonNull({"cueTimesUs", "cueClusterPositions"})
    private void h(int i2) throws ParserException {
        if (this.E == null || this.F == null) {
            throw ParserException.a("Element " + i2 + " must be in a Cues", (Throwable) null);
        }
    }

    @EnsuresNonNull({"currentTrack"})
    private void l(int i2) throws ParserException {
        if (this.f8437w == null) {
            throw ParserException.a("Element " + i2 + " must be in a TrackEntry", (Throwable) null);
        }
    }

    @EnsuresNonNull({"extractorOutput"})
    private void m() {
        Assertions.j(this.f8418d0);
    }

    private SeekMap o(LongArray longArray, LongArray longArray2) {
        int i2;
        if (this.f8433s == -1 || this.f8436v == -9223372036854775807L || longArray == null || longArray.c() == 0 || longArray2 == null || longArray2.c() != longArray.c()) {
            return new SeekMap.Unseekable(this.f8436v);
        }
        int c2 = longArray.c();
        int[] iArr = new int[c2];
        long[] jArr = new long[c2];
        long[] jArr2 = new long[c2];
        long[] jArr3 = new long[c2];
        int i3 = 0;
        for (int i4 = 0; i4 < c2; i4++) {
            jArr3[i4] = longArray.b(i4);
            jArr[i4] = this.f8433s + longArray2.b(i4);
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
        iArr[i2] = (int) ((this.f8433s + this.f8432r) - jArr[i2]);
        long j2 = this.f8436v - jArr3[i2];
        jArr2[i2] = j2;
        if (j2 <= 0) {
            Log.h("MatroskaExtractor", "Discarding last cue point with unexpected duration: " + j2);
            iArr = Arrays.copyOf(iArr, i2);
            jArr = Arrays.copyOf(jArr, i2);
            jArr2 = Arrays.copyOf(jArr2, i2);
            jArr3 = Arrays.copyOf(jArr3, i2);
        }
        return new ChunkIndex(iArr, jArr, jArr2, jArr3);
    }

    @RequiresNonNull({"#1.output"})
    private void p(Track track, long j2, int i2, int i3, int i4) {
        TrueHdSampleRechunker trueHdSampleRechunker = track.U;
        if (trueHdSampleRechunker != null) {
            trueHdSampleRechunker.c(track.Y, j2, i2, i3, i4, track.f8451j);
        } else {
            if ("S_TEXT/UTF8".equals(track.f8443b) || "S_TEXT/ASS".equals(track.f8443b) || "S_TEXT/WEBVTT".equals(track.f8443b)) {
                if (this.M > 1) {
                    Log.h("MatroskaExtractor", "Skipping subtitle sample in laced block.");
                } else {
                    long j3 = this.K;
                    if (j3 == -9223372036854775807L) {
                        Log.h("MatroskaExtractor", "Skipping subtitle sample with no duration.");
                    } else {
                        H(track.f8443b, j3, this.f8427m.e());
                        int f2 = this.f8427m.f();
                        while (true) {
                            if (f2 >= this.f8427m.g()) {
                                break;
                            } else if (this.f8427m.e()[f2] == 0) {
                                this.f8427m.T(f2);
                                break;
                            } else {
                                f2++;
                            }
                        }
                        TrackOutput trackOutput = track.Y;
                        ParsableByteArray parsableByteArray = this.f8427m;
                        trackOutput.b(parsableByteArray, parsableByteArray.g());
                        i3 += this.f8427m.g();
                    }
                }
            }
            if ((268435456 & i2) != 0) {
                if (this.M > 1) {
                    this.f8430p.Q(0);
                } else {
                    int g2 = this.f8430p.g();
                    track.Y.a(this.f8430p, g2, 2);
                    i3 += g2;
                }
            }
            track.Y.f(j2, i2, i3, i4, track.f8451j);
        }
        this.H = true;
    }

    private static int[] r(int[] iArr, int i2) {
        if (iArr == null) {
            return new int[i2];
        }
        if (iArr.length >= i2) {
            return iArr;
        }
        return new int[Math.max(iArr.length * 2, i2)];
    }

    private int s() {
        int i2 = this.V;
        F();
        return i2;
    }

    private static byte[] u(long j2, String str, long j3) {
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
        return Util.t0(String.format(Locale.US, str, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}));
    }

    /* access modifiers changed from: protected */
    public boolean B(int i2) {
        return i2 == 357149030 || i2 == 524531317 || i2 == 475249515 || i2 == 374648427;
    }

    /* access modifiers changed from: protected */
    public void I(int i2, long j2, long j3) throws ParserException {
        m();
        if (i2 == 160) {
            this.S = false;
            this.T = 0;
        } else if (i2 == 174) {
            this.f8437w = new Track();
        } else if (i2 == 187) {
            this.G = false;
        } else if (i2 == 19899) {
            this.f8439y = -1;
            this.f8440z = -1;
        } else if (i2 == 20533) {
            v(i2).f8449h = true;
        } else if (i2 == 21968) {
            v(i2).f8466y = true;
        } else if (i2 == 408125543) {
            long j4 = this.f8433s;
            if (j4 == -1 || j4 == j2) {
                this.f8433s = j2;
                this.f8432r = j3;
                return;
            }
            throw ParserException.a("Multiple Segment elements not supported", (Throwable) null);
        } else if (i2 == 475249515) {
            this.E = new LongArray();
            this.F = new LongArray();
        } else if (i2 != 524531317 || this.f8438x) {
        } else {
            if (!this.f8417d || this.B == -1) {
                this.f8418d0.r(new SeekMap.Unseekable(this.f8436v));
                this.f8438x = true;
                return;
            }
            this.A = true;
        }
    }

    /* access modifiers changed from: protected */
    public void J(int i2, String str) throws ParserException {
        if (i2 == 134) {
            v(i2).f8443b = str;
        } else if (i2 != 17026) {
            if (i2 == 21358) {
                v(i2).f8442a = str;
            } else if (i2 == 2274716) {
                String unused = v(i2).X = str;
            }
        } else if (!"webm".equals(str) && !"matroska".equals(str)) {
            throw ParserException.a("DocType " + str + " not supported", (Throwable) null);
        }
    }

    public void a(long j2, long j3) {
        this.D = -9223372036854775807L;
        this.I = 0;
        this.f8411a.reset();
        this.f8413b.e();
        F();
        for (int i2 = 0; i2 < this.f8415c.size(); i2++) {
            this.f8415c.valueAt(i2).n();
        }
    }

    public /* synthetic */ Extractor c() {
        return d.b(this);
    }

    public final void g(ExtractorOutput extractorOutput) {
        this.f8418d0 = extractorOutput;
        if (this.f8419e) {
            extractorOutput = new SubtitleTranscodingExtractorOutput(extractorOutput, this.f8420f);
        }
        this.f8418d0 = extractorOutput;
    }

    public final boolean i(ExtractorInput extractorInput) throws IOException {
        return new Sniffer().b(extractorInput);
    }

    public /* synthetic */ List j() {
        return d.a(this);
    }

    public final int k(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        this.H = false;
        boolean z2 = true;
        while (z2 && !this.H) {
            z2 = this.f8411a.a(extractorInput);
            if (z2 && D(positionHolder, extractorInput.getPosition())) {
                return 1;
            }
        }
        if (z2) {
            return 0;
        }
        for (int i2 = 0; i2 < this.f8415c.size(); i2++) {
            Track valueAt = this.f8415c.valueAt(i2);
            valueAt.f();
            valueAt.j();
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    public void n(int i2, int i3, ExtractorInput extractorInput) throws IOException {
        Track track;
        Track track2;
        int i4;
        Track track3;
        long j2;
        int i5;
        byte b2;
        int i6;
        int i7 = i2;
        int i8 = i3;
        ExtractorInput extractorInput2 = extractorInput;
        int i9 = 0;
        int i10 = 1;
        if (i7 == 161 || i7 == 163) {
            if (this.I == 0) {
                this.O = (int) this.f8413b.d(extractorInput2, false, true, 8);
                this.P = this.f8413b.b();
                this.K = -9223372036854775807L;
                this.I = 1;
                this.f8423i.Q(0);
            }
            Track track4 = this.f8415c.get(this.O);
            if (track4 == null) {
                extractorInput2.k(i8 - this.P);
                this.I = 0;
                return;
            }
            track4.f();
            if (this.I == 1) {
                E(extractorInput2, 3);
                int i11 = (this.f8423i.e()[2] & 6) >> 1;
                byte b3 = 255;
                if (i11 == 0) {
                    this.M = 1;
                    int[] r2 = r(this.N, 1);
                    this.N = r2;
                    r2[0] = (i8 - this.P) - 3;
                } else {
                    int i12 = 4;
                    E(extractorInput2, 4);
                    int i13 = (this.f8423i.e()[3] & 255) + 1;
                    this.M = i13;
                    int[] r3 = r(this.N, i13);
                    this.N = r3;
                    if (i11 == 2) {
                        int i14 = this.M;
                        Arrays.fill(r3, 0, i14, ((i8 - this.P) - 4) / i14);
                    } else if (i11 == 1) {
                        int i15 = 0;
                        int i16 = 0;
                        while (true) {
                            i5 = this.M;
                            if (i15 >= i5 - 1) {
                                break;
                            }
                            this.N[i15] = 0;
                            do {
                                i12++;
                                E(extractorInput2, i12);
                                b2 = this.f8423i.e()[i12 - 1] & 255;
                                int[] iArr = this.N;
                                i6 = iArr[i15] + b2;
                                iArr[i15] = i6;
                            } while (b2 == 255);
                            i16 += i6;
                            i15++;
                        }
                        this.N[i5 - 1] = ((i8 - this.P) - i12) - i16;
                    } else if (i11 == 3) {
                        int i17 = 0;
                        int i18 = 0;
                        while (true) {
                            int i19 = this.M;
                            if (i17 >= i19 - 1) {
                                track2 = track4;
                                this.N[i19 - 1] = ((i8 - this.P) - i12) - i18;
                                break;
                            }
                            this.N[i17] = i9;
                            i12++;
                            E(extractorInput2, i12);
                            int i20 = i12 - 1;
                            if (this.f8423i.e()[i20] != 0) {
                                int i21 = 0;
                                while (true) {
                                    if (i21 >= 8) {
                                        track3 = track4;
                                        j2 = 0;
                                        break;
                                    }
                                    int i22 = i10 << (7 - i21);
                                    if ((this.f8423i.e()[i20] & i22) != 0) {
                                        int i23 = i12 + i21;
                                        E(extractorInput2, i23);
                                        track3 = track4;
                                        j2 = (long) ((~i22) & this.f8423i.e()[i20] & b3);
                                        int i24 = i20 + 1;
                                        while (i24 < i23) {
                                            j2 = (j2 << 8) | ((long) (this.f8423i.e()[i24] & b3));
                                            i24++;
                                            i23 = i23;
                                            b3 = 255;
                                        }
                                        int i25 = i23;
                                        if (i17 > 0) {
                                            j2 -= (1 << ((i21 * 7) + 6)) - 1;
                                        }
                                        i12 = i25;
                                    } else {
                                        Track track5 = track4;
                                        i21++;
                                        i10 = 1;
                                        b3 = 255;
                                    }
                                }
                                if (j2 >= -2147483648L && j2 <= 2147483647L) {
                                    int i26 = (int) j2;
                                    int[] iArr2 = this.N;
                                    if (i17 != 0) {
                                        i26 += iArr2[i17 - 1];
                                    }
                                    iArr2[i17] = i26;
                                    i18 += i26;
                                    i17++;
                                    track4 = track3;
                                    i9 = 0;
                                    i10 = 1;
                                    b3 = 255;
                                }
                            } else {
                                throw ParserException.a("No valid varint length mask found", (Throwable) null);
                            }
                        }
                        throw ParserException.a("EBML lacing sample size out of range.", (Throwable) null);
                    } else {
                        throw ParserException.a("Unexpected lacing value: " + i11, (Throwable) null);
                    }
                }
                track2 = track4;
                this.J = this.D + G((long) ((this.f8423i.e()[0] << 8) | (this.f8423i.e()[1] & 255)));
                track = track2;
                if (track.f8445d == 2 || (i7 == 163 && (this.f8423i.e()[2] & y1.f36938c) == 128)) {
                    i4 = 1;
                } else {
                    i4 = 0;
                }
                this.Q = i4;
                this.I = 2;
                this.L = 0;
            } else {
                track = track4;
            }
            if (i7 == 163) {
                while (true) {
                    int i27 = this.L;
                    if (i27 < this.M) {
                        p(track, ((long) ((this.L * track.f8446e) / 1000)) + this.J, this.Q, K(extractorInput2, track, this.N[i27], false), 0);
                        this.L++;
                    } else {
                        this.I = 0;
                        return;
                    }
                }
            } else {
                while (true) {
                    int i28 = this.L;
                    if (i28 < this.M) {
                        int[] iArr3 = this.N;
                        iArr3[i28] = K(extractorInput2, track, iArr3[i28], true);
                        this.L++;
                    } else {
                        return;
                    }
                }
            }
        } else if (i7 != 165) {
            if (i7 == 16877) {
                x(v(i2), extractorInput2, i8);
            } else if (i7 == 16981) {
                l(i2);
                byte[] bArr = new byte[i8];
                this.f8437w.f8450i = bArr;
                extractorInput2.readFully(bArr, 0, i8);
            } else if (i7 == 18402) {
                byte[] bArr2 = new byte[i8];
                extractorInput2.readFully(bArr2, 0, i8);
                v(i2).f8451j = new TrackOutput.CryptoData(1, bArr2, 0, 0);
            } else if (i7 == 21419) {
                Arrays.fill(this.f8425k.e(), (byte) 0);
                extractorInput2.readFully(this.f8425k.e(), 4 - i8, i8);
                this.f8425k.U(0);
                this.f8439y = (int) this.f8425k.J();
            } else if (i7 == 25506) {
                l(i2);
                byte[] bArr3 = new byte[i8];
                this.f8437w.f8452k = bArr3;
                extractorInput2.readFully(bArr3, 0, i8);
            } else if (i7 == 30322) {
                l(i2);
                byte[] bArr4 = new byte[i8];
                this.f8437w.f8464w = bArr4;
                extractorInput2.readFully(bArr4, 0, i8);
            } else {
                throw ParserException.a("Unexpected id: " + i7, (Throwable) null);
            }
        } else if (this.I == 2) {
            y(this.f8415c.get(this.O), this.R, extractorInput2, i8);
        }
    }

    /* access modifiers changed from: protected */
    public void q(int i2) throws ParserException {
        m();
        if (i2 != 160) {
            if (i2 == 174) {
                Track track = (Track) Assertions.j(this.f8437w);
                String str = track.f8443b;
                if (str != null) {
                    if (A(str)) {
                        track.i(this.f8418d0, track.f8444c);
                        this.f8415c.put(track.f8444c, track);
                    }
                    this.f8437w = null;
                    return;
                }
                throw ParserException.a("CodecId is missing in TrackEntry element", (Throwable) null);
            } else if (i2 == 19899) {
                int i3 = this.f8439y;
                if (i3 != -1) {
                    long j2 = this.f8440z;
                    if (j2 != -1) {
                        if (i3 == 475249515) {
                            this.B = j2;
                            return;
                        }
                        return;
                    }
                }
                throw ParserException.a("Mandatory element SeekID or SeekPosition not found", (Throwable) null);
            } else if (i2 == 25152) {
                l(i2);
                Track track2 = this.f8437w;
                if (!track2.f8449h) {
                    return;
                }
                if (track2.f8451j != null) {
                    track2.f8453l = new DrmInitData(new DrmInitData.SchemeData(C.f3930a, MimeTypes.VIDEO_WEBM, this.f8437w.f8451j.f8087b));
                    return;
                }
                throw ParserException.a("Encrypted Track found but ContentEncKeyID was not found", (Throwable) null);
            } else if (i2 == 28032) {
                l(i2);
                Track track3 = this.f8437w;
                if (track3.f8449h && track3.f8450i != null) {
                    throw ParserException.a("Combining encryption and compression is not supported", (Throwable) null);
                }
            } else if (i2 == 357149030) {
                if (this.f8434t == -9223372036854775807L) {
                    this.f8434t = 1000000;
                }
                long j3 = this.f8435u;
                if (j3 != -9223372036854775807L) {
                    this.f8436v = G(j3);
                }
            } else if (i2 != 374648427) {
                if (i2 == 475249515) {
                    if (!this.f8438x) {
                        this.f8418d0.r(o(this.E, this.F));
                        this.f8438x = true;
                    }
                    this.E = null;
                    this.F = null;
                }
            } else if (this.f8415c.size() != 0) {
                this.f8418d0.m();
            } else {
                throw ParserException.a("No valid tracks were found", (Throwable) null);
            }
        } else if (this.I == 2) {
            Track track4 = this.f8415c.get(this.O);
            track4.f();
            if (this.T > 0 && "A_OPUS".equals(track4.f8443b)) {
                this.f8430p.R(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(this.T).array());
            }
            int i4 = 0;
            for (int i5 = 0; i5 < this.M; i5++) {
                i4 += this.N[i5];
            }
            int i6 = 0;
            while (i6 < this.M) {
                long j4 = this.J + ((long) ((track4.f8446e * i6) / 1000));
                int i7 = this.Q;
                if (i6 == 0 && !this.S) {
                    i7 |= 1;
                }
                int i8 = this.N[i6];
                int i9 = i4 - i8;
                p(track4, j4, i7, i8, i9);
                i6++;
                i4 = i9;
            }
            this.I = 0;
        }
    }

    public final void release() {
    }

    /* access modifiers changed from: protected */
    public void t(int i2, double d2) throws ParserException {
        if (i2 == 181) {
            v(i2).R = (int) d2;
        } else if (i2 != 17545) {
            switch (i2) {
                case 21969:
                    v(i2).E = (float) d2;
                    return;
                case 21970:
                    v(i2).F = (float) d2;
                    return;
                case 21971:
                    v(i2).G = (float) d2;
                    return;
                case 21972:
                    v(i2).H = (float) d2;
                    return;
                case 21973:
                    v(i2).I = (float) d2;
                    return;
                case 21974:
                    v(i2).J = (float) d2;
                    return;
                case 21975:
                    v(i2).K = (float) d2;
                    return;
                case 21976:
                    v(i2).L = (float) d2;
                    return;
                case 21977:
                    v(i2).M = (float) d2;
                    return;
                case 21978:
                    v(i2).N = (float) d2;
                    return;
                default:
                    switch (i2) {
                        case 30323:
                            v(i2).f8461t = (float) d2;
                            return;
                        case 30324:
                            v(i2).f8462u = (float) d2;
                            return;
                        case 30325:
                            v(i2).f8463v = (float) d2;
                            return;
                        default:
                            return;
                    }
            }
        } else {
            this.f8435u = (long) d2;
        }
    }

    /* access modifiers changed from: protected */
    public Track v(int i2) throws ParserException {
        l(i2);
        return this.f8437w;
    }

    /* access modifiers changed from: protected */
    public int w(int i2) {
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
            case 21938:
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
            case JfifUtil.MARKER_APP1 /*225*/:
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
    public void x(Track track, ExtractorInput extractorInput, int i2) throws IOException {
        if (track.f8448g == 1685485123 || track.f8448g == 1685480259) {
            byte[] bArr = new byte[i2];
            track.O = bArr;
            extractorInput.readFully(bArr, 0, i2);
            return;
        }
        extractorInput.k(i2);
    }

    /* access modifiers changed from: protected */
    public void y(Track track, int i2, ExtractorInput extractorInput, int i3) throws IOException {
        if (i2 != 4 || !"V_VP9".equals(track.f8443b)) {
            extractorInput.k(i3);
            return;
        }
        this.f8430p.Q(i3);
        extractorInput.readFully(this.f8430p.e(), 0, i3);
    }

    /* access modifiers changed from: protected */
    public void z(int i2, long j2) throws ParserException {
        if (i2 != 20529) {
            if (i2 != 20530) {
                boolean z2 = false;
                switch (i2) {
                    case MRAID_JS_WRITE_FAILED_VALUE:
                        v(i2).f8445d = (int) j2;
                        return;
                    case PRIVACY_URL_ERROR_VALUE:
                        Track v2 = v(i2);
                        if (j2 == 1) {
                            z2 = true;
                        }
                        v2.W = z2;
                        return;
                    case 155:
                        this.K = G(j2);
                        return;
                    case 159:
                        v(i2).P = (int) j2;
                        return;
                    case 176:
                        v(i2).f8454m = (int) j2;
                        return;
                    case 179:
                        h(i2);
                        this.E.a(G(j2));
                        return;
                    case 186:
                        v(i2).f8455n = (int) j2;
                        return;
                    case 215:
                        v(i2).f8444c = (int) j2;
                        return;
                    case 231:
                        this.D = G(j2);
                        return;
                    case 238:
                        this.R = (int) j2;
                        return;
                    case 241:
                        if (!this.G) {
                            h(i2);
                            this.F.a(j2);
                            this.G = true;
                            return;
                        }
                        return;
                    case 251:
                        this.S = true;
                        return;
                    case 16871:
                        int unused = v(i2).f8448g = (int) j2;
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
                        this.f8440z = j2 + this.f8433s;
                        return;
                    case 21432:
                        int i3 = (int) j2;
                        l(i2);
                        if (i3 == 0) {
                            this.f8437w.f8465x = 0;
                            return;
                        } else if (i3 == 1) {
                            this.f8437w.f8465x = 2;
                            return;
                        } else if (i3 == 3) {
                            this.f8437w.f8465x = 1;
                            return;
                        } else if (i3 == 15) {
                            this.f8437w.f8465x = 3;
                            return;
                        } else {
                            return;
                        }
                    case 21680:
                        v(i2).f8457p = (int) j2;
                        return;
                    case 21682:
                        v(i2).f8459r = (int) j2;
                        return;
                    case 21690:
                        v(i2).f8458q = (int) j2;
                        return;
                    case 21930:
                        Track v3 = v(i2);
                        if (j2 == 1) {
                            z2 = true;
                        }
                        v3.V = z2;
                        return;
                    case 21938:
                        l(i2);
                        Track track = this.f8437w;
                        track.f8466y = true;
                        track.f8456o = (int) j2;
                        return;
                    case 21998:
                        v(i2).f8447f = (int) j2;
                        return;
                    case 22186:
                        v(i2).S = j2;
                        return;
                    case 22203:
                        v(i2).T = j2;
                        return;
                    case 25188:
                        v(i2).Q = (int) j2;
                        return;
                    case 30114:
                        this.T = j2;
                        return;
                    case 30321:
                        l(i2);
                        int i4 = (int) j2;
                        if (i4 == 0) {
                            this.f8437w.f8460s = 0;
                            return;
                        } else if (i4 == 1) {
                            this.f8437w.f8460s = 1;
                            return;
                        } else if (i4 == 2) {
                            this.f8437w.f8460s = 2;
                            return;
                        } else if (i4 == 3) {
                            this.f8437w.f8460s = 3;
                            return;
                        } else {
                            return;
                        }
                    case 2352003:
                        v(i2).f8446e = (int) j2;
                        return;
                    case 2807729:
                        this.f8434t = j2;
                        return;
                    default:
                        switch (i2) {
                            case 21945:
                                l(i2);
                                int i5 = (int) j2;
                                if (i5 == 1) {
                                    this.f8437w.B = 2;
                                    return;
                                } else if (i5 == 2) {
                                    this.f8437w.B = 1;
                                    return;
                                } else {
                                    return;
                                }
                            case 21946:
                                l(i2);
                                int k2 = ColorInfo.k((int) j2);
                                if (k2 != -1) {
                                    this.f8437w.A = k2;
                                    return;
                                }
                                return;
                            case 21947:
                                l(i2);
                                this.f8437w.f8466y = true;
                                int j3 = ColorInfo.j((int) j2);
                                if (j3 != -1) {
                                    this.f8437w.f8467z = j3;
                                    return;
                                }
                                return;
                            case 21948:
                                v(i2).C = (int) j2;
                                return;
                            case 21949:
                                v(i2).D = (int) j2;
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

    public MatroskaExtractor(SubtitleParser.Factory factory, int i2) {
        this(new DefaultEbmlReader(), i2, factory);
    }

    MatroskaExtractor(EbmlReader ebmlReader, int i2, SubtitleParser.Factory factory) {
        this.f8433s = -1;
        this.f8434t = -9223372036854775807L;
        this.f8435u = -9223372036854775807L;
        this.f8436v = -9223372036854775807L;
        this.B = -1;
        this.C = -1;
        this.D = -9223372036854775807L;
        this.f8411a = ebmlReader;
        ebmlReader.b(new InnerEbmlProcessor());
        this.f8420f = factory;
        boolean z2 = false;
        this.f8417d = (i2 & 1) == 0;
        this.f8419e = (i2 & 2) == 0 ? true : z2;
        this.f8413b = new VarintReader();
        this.f8415c = new SparseArray<>();
        this.f8423i = new ParsableByteArray(4);
        this.f8424j = new ParsableByteArray(ByteBuffer.allocate(4).putInt(-1).array());
        this.f8425k = new ParsableByteArray(4);
        this.f8421g = new ParsableByteArray(NalUnitUtil.f4748a);
        this.f8422h = new ParsableByteArray(4);
        this.f8426l = new ParsableByteArray();
        this.f8427m = new ParsableByteArray();
        this.f8428n = new ParsableByteArray(8);
        this.f8429o = new ParsableByteArray();
        this.f8430p = new ParsableByteArray();
        this.N = new int[1];
    }
}
