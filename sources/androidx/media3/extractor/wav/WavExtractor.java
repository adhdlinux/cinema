package androidx.media3.extractor.wav;

import android.util.Pair;
import androidx.media3.common.Format;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.ExtractorsFactory;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.WavUtil;
import androidx.media3.extractor.d;
import com.facebook.imageutils.JfifUtil;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.io.IOException;
import java.util.List;
import o.a;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class WavExtractor implements Extractor {

    /* renamed from: h  reason: collision with root package name */
    public static final ExtractorsFactory f9555h = new a();

    /* renamed from: a  reason: collision with root package name */
    private ExtractorOutput f9556a;

    /* renamed from: b  reason: collision with root package name */
    private TrackOutput f9557b;

    /* renamed from: c  reason: collision with root package name */
    private int f9558c = 0;

    /* renamed from: d  reason: collision with root package name */
    private long f9559d = -1;

    /* renamed from: e  reason: collision with root package name */
    private OutputWriter f9560e;

    /* renamed from: f  reason: collision with root package name */
    private int f9561f = -1;

    /* renamed from: g  reason: collision with root package name */
    private long f9562g = -1;

    private static final class ImaAdPcmOutputWriter implements OutputWriter {

        /* renamed from: m  reason: collision with root package name */
        private static final int[] f9563m = {-1, -1, -1, -1, 2, 4, 6, 8, -1, -1, -1, -1, 2, 4, 6, 8};

        /* renamed from: n  reason: collision with root package name */
        private static final int[] f9564n = {7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 19, 21, 23, 25, 28, 31, 34, 37, 41, 45, 50, 55, 60, 66, 73, 80, 88, 97, 107, 118, Sdk$SDKError.Reason.MRAID_DOWNLOAD_JS_ERROR_VALUE, 143, 157, 173, 190, Sdk$SDKError.Reason.INVALID_JSON_BID_PAYLOAD_VALUE, 230, 253, 279, 307, 337, 371, 408, 449, 494, 544, 598, 658, 724, 796, 876, 963, 1060, 1166, 1282, 1411, 1552, 1707, 1878, 2066, 2272, 2499, 2749, 3024, 3327, 3660, 4026, 4428, 4871, 5358, 5894, 6484, 7132, 7845, 8630, 9493, 10442, 11487, 12635, 13899, 15289, 16818, 18500, 20350, 22385, 24623, 27086, 29794, 32767};

        /* renamed from: a  reason: collision with root package name */
        private final ExtractorOutput f9565a;

        /* renamed from: b  reason: collision with root package name */
        private final TrackOutput f9566b;

        /* renamed from: c  reason: collision with root package name */
        private final WavFormat f9567c;

        /* renamed from: d  reason: collision with root package name */
        private final int f9568d;

        /* renamed from: e  reason: collision with root package name */
        private final byte[] f9569e;

        /* renamed from: f  reason: collision with root package name */
        private final ParsableByteArray f9570f;

        /* renamed from: g  reason: collision with root package name */
        private final int f9571g;

        /* renamed from: h  reason: collision with root package name */
        private final Format f9572h;

        /* renamed from: i  reason: collision with root package name */
        private int f9573i;

        /* renamed from: j  reason: collision with root package name */
        private long f9574j;

        /* renamed from: k  reason: collision with root package name */
        private int f9575k;

        /* renamed from: l  reason: collision with root package name */
        private long f9576l;

        public ImaAdPcmOutputWriter(ExtractorOutput extractorOutput, TrackOutput trackOutput, WavFormat wavFormat) throws ParserException {
            this.f9565a = extractorOutput;
            this.f9566b = trackOutput;
            this.f9567c = wavFormat;
            int max = Math.max(1, wavFormat.f9587c / 10);
            this.f9571g = max;
            ParsableByteArray parsableByteArray = new ParsableByteArray(wavFormat.f9591g);
            parsableByteArray.z();
            int z2 = parsableByteArray.z();
            this.f9568d = z2;
            int i2 = wavFormat.f9586b;
            int i3 = (((wavFormat.f9589e - (i2 * 4)) * 8) / (wavFormat.f9590f * i2)) + 1;
            if (z2 == i3) {
                int k2 = Util.k(max, z2);
                this.f9569e = new byte[(wavFormat.f9589e * k2)];
                this.f9570f = new ParsableByteArray(k2 * h(z2, i2));
                int i4 = ((wavFormat.f9587c * wavFormat.f9589e) * 8) / z2;
                this.f9572h = new Format.Builder().o0("audio/raw").M(i4).j0(i4).f0(h(max, i2)).N(wavFormat.f9586b).p0(wavFormat.f9587c).i0(2).K();
                return;
            }
            throw ParserException.a("Expected frames per block: " + i3 + "; got: " + z2, (Throwable) null);
        }

        private void d(byte[] bArr, int i2, ParsableByteArray parsableByteArray) {
            for (int i3 = 0; i3 < i2; i3++) {
                for (int i4 = 0; i4 < this.f9567c.f9586b; i4++) {
                    e(bArr, i3, i4, parsableByteArray.e());
                }
            }
            int g2 = g(this.f9568d * i2);
            parsableByteArray.U(0);
            parsableByteArray.T(g2);
        }

        private void e(byte[] bArr, int i2, int i3, byte[] bArr2) {
            int i4;
            WavFormat wavFormat = this.f9567c;
            int i5 = wavFormat.f9589e;
            int i6 = wavFormat.f9586b;
            int i7 = (i2 * i5) + (i3 * 4);
            int i8 = (i6 * 4) + i7;
            int i9 = (i5 / i6) - 4;
            int i10 = (short) (((bArr[i7 + 1] & 255) << 8) | (bArr[i7] & 255));
            int min = Math.min(bArr[i7 + 2] & 255, 88);
            int i11 = f9564n[min];
            int i12 = ((i2 * this.f9568d * i6) + i3) * 2;
            bArr2[i12] = (byte) (i10 & JfifUtil.MARKER_FIRST_BYTE);
            bArr2[i12 + 1] = (byte) (i10 >> 8);
            for (int i13 = 0; i13 < i9 * 2; i13++) {
                byte b2 = bArr[((i13 / 8) * i6 * 4) + i8 + ((i13 / 2) % 4)] & 255;
                if (i13 % 2 == 0) {
                    i4 = b2 & 15;
                } else {
                    i4 = b2 >> 4;
                }
                int i14 = ((((i4 & 7) * 2) + 1) * i11) >> 3;
                if ((i4 & 8) != 0) {
                    i14 = -i14;
                }
                i10 = Util.p(i10 + i14, -32768, 32767);
                i12 += i6 * 2;
                bArr2[i12] = (byte) (i10 & JfifUtil.MARKER_FIRST_BYTE);
                bArr2[i12 + 1] = (byte) (i10 >> 8);
                int i15 = min + f9563m[i4];
                int[] iArr = f9564n;
                min = Util.p(i15, 0, iArr.length - 1);
                i11 = iArr[min];
            }
        }

        private int f(int i2) {
            return i2 / (this.f9567c.f9586b * 2);
        }

        private int g(int i2) {
            return h(i2, this.f9567c.f9586b);
        }

        private static int h(int i2, int i3) {
            return i2 * 2 * i3;
        }

        private void i(int i2) {
            long c12 = this.f9574j + Util.c1(this.f9576l, 1000000, (long) this.f9567c.f9587c);
            int g2 = g(i2);
            this.f9566b.f(c12, 1, g2, this.f9575k - g2, (TrackOutput.CryptoData) null);
            this.f9576l += (long) i2;
            this.f9575k -= g2;
        }

        public void a(int i2, long j2) {
            this.f9565a.r(new WavSeekMap(this.f9567c, this.f9568d, (long) i2, j2));
            this.f9566b.c(this.f9572h);
        }

        public void b(long j2) {
            this.f9573i = 0;
            this.f9574j = j2;
            this.f9575k = 0;
            this.f9576l = 0;
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x0048  */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x003f A[EDGE_INSN: B:22:0x003f->B:10:0x003f ?: BREAK  , SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:5:0x0021  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean c(androidx.media3.extractor.ExtractorInput r7, long r8) throws java.io.IOException {
            /*
                r6 = this;
                int r0 = r6.f9571g
                int r1 = r6.f9575k
                int r1 = r6.f(r1)
                int r0 = r0 - r1
                int r1 = r6.f9568d
                int r0 = androidx.media3.common.util.Util.k(r0, r1)
                androidx.media3.extractor.wav.WavFormat r1 = r6.f9567c
                int r1 = r1.f9589e
                int r0 = r0 * r1
                r1 = 0
                r3 = 1
                int r4 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
                if (r4 != 0) goto L_0x001e
            L_0x001c:
                r1 = 1
                goto L_0x001f
            L_0x001e:
                r1 = 0
            L_0x001f:
                if (r1 != 0) goto L_0x003f
                int r2 = r6.f9573i
                if (r2 >= r0) goto L_0x003f
                int r2 = r0 - r2
                long r4 = (long) r2
                long r4 = java.lang.Math.min(r4, r8)
                int r2 = (int) r4
                byte[] r4 = r6.f9569e
                int r5 = r6.f9573i
                int r2 = r7.read(r4, r5, r2)
                r4 = -1
                if (r2 != r4) goto L_0x0039
                goto L_0x001c
            L_0x0039:
                int r4 = r6.f9573i
                int r4 = r4 + r2
                r6.f9573i = r4
                goto L_0x001f
            L_0x003f:
                int r7 = r6.f9573i
                androidx.media3.extractor.wav.WavFormat r8 = r6.f9567c
                int r8 = r8.f9589e
                int r7 = r7 / r8
                if (r7 <= 0) goto L_0x0077
                byte[] r8 = r6.f9569e
                androidx.media3.common.util.ParsableByteArray r9 = r6.f9570f
                r6.d(r8, r7, r9)
                int r8 = r6.f9573i
                androidx.media3.extractor.wav.WavFormat r9 = r6.f9567c
                int r9 = r9.f9589e
                int r7 = r7 * r9
                int r8 = r8 - r7
                r6.f9573i = r8
                androidx.media3.common.util.ParsableByteArray r7 = r6.f9570f
                int r7 = r7.g()
                androidx.media3.extractor.TrackOutput r8 = r6.f9566b
                androidx.media3.common.util.ParsableByteArray r9 = r6.f9570f
                r8.b(r9, r7)
                int r8 = r6.f9575k
                int r8 = r8 + r7
                r6.f9575k = r8
                int r7 = r6.f(r8)
                int r8 = r6.f9571g
                if (r7 < r8) goto L_0x0077
                r6.i(r8)
            L_0x0077:
                if (r1 == 0) goto L_0x0084
                int r7 = r6.f9575k
                int r7 = r6.f(r7)
                if (r7 <= 0) goto L_0x0084
                r6.i(r7)
            L_0x0084:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.wav.WavExtractor.ImaAdPcmOutputWriter.c(androidx.media3.extractor.ExtractorInput, long):boolean");
        }
    }

    private interface OutputWriter {
        void a(int i2, long j2) throws ParserException;

        void b(long j2);

        boolean c(ExtractorInput extractorInput, long j2) throws IOException;
    }

    private static final class PassthroughOutputWriter implements OutputWriter {

        /* renamed from: a  reason: collision with root package name */
        private final ExtractorOutput f9577a;

        /* renamed from: b  reason: collision with root package name */
        private final TrackOutput f9578b;

        /* renamed from: c  reason: collision with root package name */
        private final WavFormat f9579c;

        /* renamed from: d  reason: collision with root package name */
        private final Format f9580d;

        /* renamed from: e  reason: collision with root package name */
        private final int f9581e;

        /* renamed from: f  reason: collision with root package name */
        private long f9582f;

        /* renamed from: g  reason: collision with root package name */
        private int f9583g;

        /* renamed from: h  reason: collision with root package name */
        private long f9584h;

        public PassthroughOutputWriter(ExtractorOutput extractorOutput, TrackOutput trackOutput, WavFormat wavFormat, String str, int i2) throws ParserException {
            this.f9577a = extractorOutput;
            this.f9578b = trackOutput;
            this.f9579c = wavFormat;
            int i3 = (wavFormat.f9586b * wavFormat.f9590f) / 8;
            if (wavFormat.f9589e == i3) {
                int i4 = wavFormat.f9587c;
                int i5 = i4 * i3 * 8;
                int max = Math.max(i3, (i4 * i3) / 10);
                this.f9581e = max;
                this.f9580d = new Format.Builder().o0(str).M(i5).j0(i5).f0(max).N(wavFormat.f9586b).p0(wavFormat.f9587c).i0(i2).K();
                return;
            }
            throw ParserException.a("Expected block size: " + i3 + "; got: " + wavFormat.f9589e, (Throwable) null);
        }

        public void a(int i2, long j2) {
            this.f9577a.r(new WavSeekMap(this.f9579c, 1, (long) i2, j2));
            this.f9578b.c(this.f9580d);
        }

        public void b(long j2) {
            this.f9582f = j2;
            this.f9583g = 0;
            this.f9584h = 0;
        }

        public boolean c(ExtractorInput extractorInput, long j2) throws IOException {
            int i2;
            int i3;
            int i4;
            long j3 = j2;
            while (true) {
                i2 = (j3 > 0 ? 1 : (j3 == 0 ? 0 : -1));
                if (i2 <= 0 || (i3 = this.f9583g) >= (i4 = this.f9581e)) {
                    WavFormat wavFormat = this.f9579c;
                    int i5 = wavFormat.f9589e;
                    int i6 = this.f9583g / i5;
                } else {
                    int d2 = this.f9578b.d(extractorInput, (int) Math.min((long) (i4 - i3), j3), true);
                    if (d2 == -1) {
                        j3 = 0;
                    } else {
                        this.f9583g += d2;
                        j3 -= (long) d2;
                    }
                }
            }
            WavFormat wavFormat2 = this.f9579c;
            int i52 = wavFormat2.f9589e;
            int i62 = this.f9583g / i52;
            if (i62 > 0) {
                int i7 = i62 * i52;
                int i8 = this.f9583g - i7;
                this.f9578b.f(this.f9582f + Util.c1(this.f9584h, 1000000, (long) wavFormat2.f9587c), 1, i7, i8, (TrackOutput.CryptoData) null);
                this.f9584h += (long) i62;
                this.f9583g = i8;
            }
            if (i2 <= 0) {
                return true;
            }
            return false;
        }
    }

    @EnsuresNonNull({"extractorOutput", "trackOutput"})
    private void d() {
        Assertions.j(this.f9557b);
        Util.i(this.f9556a);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Extractor[] e() {
        return new Extractor[]{new WavExtractor()};
    }

    private void f(ExtractorInput extractorInput) throws IOException {
        boolean z2;
        if (extractorInput.getPosition() == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.h(z2);
        int i2 = this.f9561f;
        if (i2 != -1) {
            extractorInput.k(i2);
            this.f9558c = 4;
        } else if (WavHeaderReader.a(extractorInput)) {
            extractorInput.k((int) (extractorInput.g() - extractorInput.getPosition()));
            this.f9558c = 1;
        } else {
            throw ParserException.a("Unsupported or unrecognized wav file type.", (Throwable) null);
        }
    }

    @RequiresNonNull({"extractorOutput", "trackOutput"})
    private void h(ExtractorInput extractorInput) throws IOException {
        WavFormat b2 = WavHeaderReader.b(extractorInput);
        int i2 = b2.f9585a;
        if (i2 == 17) {
            this.f9560e = new ImaAdPcmOutputWriter(this.f9556a, this.f9557b, b2);
        } else if (i2 == 6) {
            this.f9560e = new PassthroughOutputWriter(this.f9556a, this.f9557b, b2, "audio/g711-alaw", -1);
        } else if (i2 == 7) {
            this.f9560e = new PassthroughOutputWriter(this.f9556a, this.f9557b, b2, "audio/g711-mlaw", -1);
        } else {
            int a2 = WavUtil.a(i2, b2.f9590f);
            if (a2 != 0) {
                this.f9560e = new PassthroughOutputWriter(this.f9556a, this.f9557b, b2, "audio/raw", a2);
            } else {
                throw ParserException.d("Unsupported WAV format type: " + b2.f9585a);
            }
        }
        this.f9558c = 3;
    }

    private void l(ExtractorInput extractorInput) throws IOException {
        this.f9559d = WavHeaderReader.c(extractorInput);
        this.f9558c = 2;
    }

    private int m(ExtractorInput extractorInput) throws IOException {
        boolean z2;
        if (this.f9562g != -1) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.h(z2);
        if (((OutputWriter) Assertions.f(this.f9560e)).c(extractorInput, this.f9562g - extractorInput.getPosition())) {
            return -1;
        }
        return 0;
    }

    private void n(ExtractorInput extractorInput) throws IOException {
        Pair<Long, Long> e2 = WavHeaderReader.e(extractorInput);
        this.f9561f = ((Long) e2.first).intValue();
        long longValue = ((Long) e2.second).longValue();
        long j2 = this.f9559d;
        if (j2 != -1 && longValue == 4294967295L) {
            longValue = j2;
        }
        this.f9562g = ((long) this.f9561f) + longValue;
        long length = extractorInput.getLength();
        if (length != -1 && this.f9562g > length) {
            Log.h("WavExtractor", "Data exceeds input length: " + this.f9562g + ", " + length);
            this.f9562g = length;
        }
        ((OutputWriter) Assertions.f(this.f9560e)).a(this.f9561f, this.f9562g);
        this.f9558c = 4;
    }

    public void a(long j2, long j3) {
        int i2;
        if (j2 == 0) {
            i2 = 0;
        } else {
            i2 = 4;
        }
        this.f9558c = i2;
        OutputWriter outputWriter = this.f9560e;
        if (outputWriter != null) {
            outputWriter.b(j3);
        }
    }

    public /* synthetic */ Extractor c() {
        return d.b(this);
    }

    public void g(ExtractorOutput extractorOutput) {
        this.f9556a = extractorOutput;
        this.f9557b = extractorOutput.d(0, 1);
        extractorOutput.m();
    }

    public boolean i(ExtractorInput extractorInput) throws IOException {
        return WavHeaderReader.a(extractorInput);
    }

    public /* synthetic */ List j() {
        return d.a(this);
    }

    public int k(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        d();
        int i2 = this.f9558c;
        if (i2 == 0) {
            f(extractorInput);
            return 0;
        } else if (i2 == 1) {
            l(extractorInput);
            return 0;
        } else if (i2 == 2) {
            h(extractorInput);
            return 0;
        } else if (i2 == 3) {
            n(extractorInput);
            return 0;
        } else if (i2 == 4) {
            return m(extractorInput);
        } else {
            throw new IllegalStateException();
        }
    }

    public void release() {
    }
}
