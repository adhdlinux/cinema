package com.google.android.exoplayer2.extractor.wav;

import android.util.Pair;
import com.facebook.imageutils.JfifUtil;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.WavUtil;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.io.IOException;
import n0.a;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class WavExtractor implements Extractor {

    /* renamed from: h  reason: collision with root package name */
    public static final ExtractorsFactory f25131h = new a();

    /* renamed from: a  reason: collision with root package name */
    private ExtractorOutput f25132a;

    /* renamed from: b  reason: collision with root package name */
    private TrackOutput f25133b;

    /* renamed from: c  reason: collision with root package name */
    private int f25134c = 0;

    /* renamed from: d  reason: collision with root package name */
    private long f25135d = -1;

    /* renamed from: e  reason: collision with root package name */
    private OutputWriter f25136e;

    /* renamed from: f  reason: collision with root package name */
    private int f25137f = -1;

    /* renamed from: g  reason: collision with root package name */
    private long f25138g = -1;

    private static final class ImaAdPcmOutputWriter implements OutputWriter {

        /* renamed from: m  reason: collision with root package name */
        private static final int[] f25139m = {-1, -1, -1, -1, 2, 4, 6, 8, -1, -1, -1, -1, 2, 4, 6, 8};

        /* renamed from: n  reason: collision with root package name */
        private static final int[] f25140n = {7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 19, 21, 23, 25, 28, 31, 34, 37, 41, 45, 50, 55, 60, 66, 73, 80, 88, 97, 107, 118, Sdk$SDKError.Reason.MRAID_DOWNLOAD_JS_ERROR_VALUE, 143, 157, 173, 190, Sdk$SDKError.Reason.INVALID_JSON_BID_PAYLOAD_VALUE, 230, 253, 279, 307, 337, 371, 408, 449, 494, 544, 598, 658, 724, 796, 876, 963, 1060, 1166, 1282, 1411, 1552, 1707, 1878, 2066, 2272, 2499, 2749, 3024, 3327, 3660, 4026, 4428, 4871, 5358, 5894, 6484, 7132, 7845, 8630, 9493, 10442, 11487, 12635, 13899, 15289, 16818, 18500, 20350, 22385, 24623, 27086, 29794, 32767};

        /* renamed from: a  reason: collision with root package name */
        private final ExtractorOutput f25141a;

        /* renamed from: b  reason: collision with root package name */
        private final TrackOutput f25142b;

        /* renamed from: c  reason: collision with root package name */
        private final WavFormat f25143c;

        /* renamed from: d  reason: collision with root package name */
        private final int f25144d;

        /* renamed from: e  reason: collision with root package name */
        private final byte[] f25145e;

        /* renamed from: f  reason: collision with root package name */
        private final ParsableByteArray f25146f;

        /* renamed from: g  reason: collision with root package name */
        private final int f25147g;

        /* renamed from: h  reason: collision with root package name */
        private final Format f25148h;

        /* renamed from: i  reason: collision with root package name */
        private int f25149i;

        /* renamed from: j  reason: collision with root package name */
        private long f25150j;

        /* renamed from: k  reason: collision with root package name */
        private int f25151k;

        /* renamed from: l  reason: collision with root package name */
        private long f25152l;

        public ImaAdPcmOutputWriter(ExtractorOutput extractorOutput, TrackOutput trackOutput, WavFormat wavFormat) throws ParserException {
            this.f25141a = extractorOutput;
            this.f25142b = trackOutput;
            this.f25143c = wavFormat;
            int max = Math.max(1, wavFormat.f25163c / 10);
            this.f25147g = max;
            ParsableByteArray parsableByteArray = new ParsableByteArray(wavFormat.f25167g);
            parsableByteArray.z();
            int z2 = parsableByteArray.z();
            this.f25144d = z2;
            int i2 = wavFormat.f25162b;
            int i3 = (((wavFormat.f25165e - (i2 * 4)) * 8) / (wavFormat.f25166f * i2)) + 1;
            if (z2 == i3) {
                int l2 = Util.l(max, z2);
                this.f25145e = new byte[(wavFormat.f25165e * l2)];
                this.f25146f = new ParsableByteArray(l2 * h(z2, i2));
                int i4 = ((wavFormat.f25163c * wavFormat.f25165e) * 8) / z2;
                this.f25148h = new Format.Builder().g0("audio/raw").I(i4).b0(i4).Y(h(max, i2)).J(wavFormat.f25162b).h0(wavFormat.f25163c).a0(2).G();
                return;
            }
            throw ParserException.a("Expected frames per block: " + i3 + "; got: " + z2, (Throwable) null);
        }

        private void d(byte[] bArr, int i2, ParsableByteArray parsableByteArray) {
            for (int i3 = 0; i3 < i2; i3++) {
                for (int i4 = 0; i4 < this.f25143c.f25162b; i4++) {
                    e(bArr, i3, i4, parsableByteArray.e());
                }
            }
            int g2 = g(this.f25144d * i2);
            parsableByteArray.U(0);
            parsableByteArray.T(g2);
        }

        private void e(byte[] bArr, int i2, int i3, byte[] bArr2) {
            int i4;
            WavFormat wavFormat = this.f25143c;
            int i5 = wavFormat.f25165e;
            int i6 = wavFormat.f25162b;
            int i7 = (i2 * i5) + (i3 * 4);
            int i8 = (i6 * 4) + i7;
            int i9 = (i5 / i6) - 4;
            int i10 = (short) (((bArr[i7 + 1] & 255) << 8) | (bArr[i7] & 255));
            int min = Math.min(bArr[i7 + 2] & 255, 88);
            int i11 = f25140n[min];
            int i12 = ((i2 * this.f25144d * i6) + i3) * 2;
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
                i10 = Util.q(i10 + i14, -32768, 32767);
                i12 += i6 * 2;
                bArr2[i12] = (byte) (i10 & JfifUtil.MARKER_FIRST_BYTE);
                bArr2[i12 + 1] = (byte) (i10 >> 8);
                int i15 = min + f25139m[i4];
                int[] iArr = f25140n;
                min = Util.q(i15, 0, iArr.length - 1);
                i11 = iArr[min];
            }
        }

        private int f(int i2) {
            return i2 / (this.f25143c.f25162b * 2);
        }

        private int g(int i2) {
            return h(i2, this.f25143c.f25162b);
        }

        private static int h(int i2, int i3) {
            return i2 * 2 * i3;
        }

        private void i(int i2) {
            long R0 = this.f25150j + Util.R0(this.f25152l, 1000000, (long) this.f25143c.f25163c);
            int g2 = g(i2);
            this.f25142b.e(R0, 1, g2, this.f25151k - g2, (TrackOutput.CryptoData) null);
            this.f25152l += (long) i2;
            this.f25151k -= g2;
        }

        public void a(int i2, long j2) {
            this.f25141a.u(new WavSeekMap(this.f25143c, this.f25144d, (long) i2, j2));
            this.f25142b.d(this.f25148h);
        }

        public void b(long j2) {
            this.f25149i = 0;
            this.f25150j = j2;
            this.f25151k = 0;
            this.f25152l = 0;
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x0048  */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x003f A[EDGE_INSN: B:22:0x003f->B:10:0x003f ?: BREAK  , SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:5:0x0021  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean c(com.google.android.exoplayer2.extractor.ExtractorInput r7, long r8) throws java.io.IOException {
            /*
                r6 = this;
                int r0 = r6.f25147g
                int r1 = r6.f25151k
                int r1 = r6.f(r1)
                int r0 = r0 - r1
                int r1 = r6.f25144d
                int r0 = com.google.android.exoplayer2.util.Util.l(r0, r1)
                com.google.android.exoplayer2.extractor.wav.WavFormat r1 = r6.f25143c
                int r1 = r1.f25165e
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
                int r2 = r6.f25149i
                if (r2 >= r0) goto L_0x003f
                int r2 = r0 - r2
                long r4 = (long) r2
                long r4 = java.lang.Math.min(r4, r8)
                int r2 = (int) r4
                byte[] r4 = r6.f25145e
                int r5 = r6.f25149i
                int r2 = r7.read(r4, r5, r2)
                r4 = -1
                if (r2 != r4) goto L_0x0039
                goto L_0x001c
            L_0x0039:
                int r4 = r6.f25149i
                int r4 = r4 + r2
                r6.f25149i = r4
                goto L_0x001f
            L_0x003f:
                int r7 = r6.f25149i
                com.google.android.exoplayer2.extractor.wav.WavFormat r8 = r6.f25143c
                int r8 = r8.f25165e
                int r7 = r7 / r8
                if (r7 <= 0) goto L_0x0077
                byte[] r8 = r6.f25145e
                com.google.android.exoplayer2.util.ParsableByteArray r9 = r6.f25146f
                r6.d(r8, r7, r9)
                int r8 = r6.f25149i
                com.google.android.exoplayer2.extractor.wav.WavFormat r9 = r6.f25143c
                int r9 = r9.f25165e
                int r7 = r7 * r9
                int r8 = r8 - r7
                r6.f25149i = r8
                com.google.android.exoplayer2.util.ParsableByteArray r7 = r6.f25146f
                int r7 = r7.g()
                com.google.android.exoplayer2.extractor.TrackOutput r8 = r6.f25142b
                com.google.android.exoplayer2.util.ParsableByteArray r9 = r6.f25146f
                r8.c(r9, r7)
                int r8 = r6.f25151k
                int r8 = r8 + r7
                r6.f25151k = r8
                int r7 = r6.f(r8)
                int r8 = r6.f25147g
                if (r7 < r8) goto L_0x0077
                r6.i(r8)
            L_0x0077:
                if (r1 == 0) goto L_0x0084
                int r7 = r6.f25151k
                int r7 = r6.f(r7)
                if (r7 <= 0) goto L_0x0084
                r6.i(r7)
            L_0x0084:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.wav.WavExtractor.ImaAdPcmOutputWriter.c(com.google.android.exoplayer2.extractor.ExtractorInput, long):boolean");
        }
    }

    private interface OutputWriter {
        void a(int i2, long j2) throws ParserException;

        void b(long j2);

        boolean c(ExtractorInput extractorInput, long j2) throws IOException;
    }

    private static final class PassthroughOutputWriter implements OutputWriter {

        /* renamed from: a  reason: collision with root package name */
        private final ExtractorOutput f25153a;

        /* renamed from: b  reason: collision with root package name */
        private final TrackOutput f25154b;

        /* renamed from: c  reason: collision with root package name */
        private final WavFormat f25155c;

        /* renamed from: d  reason: collision with root package name */
        private final Format f25156d;

        /* renamed from: e  reason: collision with root package name */
        private final int f25157e;

        /* renamed from: f  reason: collision with root package name */
        private long f25158f;

        /* renamed from: g  reason: collision with root package name */
        private int f25159g;

        /* renamed from: h  reason: collision with root package name */
        private long f25160h;

        public PassthroughOutputWriter(ExtractorOutput extractorOutput, TrackOutput trackOutput, WavFormat wavFormat, String str, int i2) throws ParserException {
            this.f25153a = extractorOutput;
            this.f25154b = trackOutput;
            this.f25155c = wavFormat;
            int i3 = (wavFormat.f25162b * wavFormat.f25166f) / 8;
            if (wavFormat.f25165e == i3) {
                int i4 = wavFormat.f25163c;
                int i5 = i4 * i3 * 8;
                int max = Math.max(i3, (i4 * i3) / 10);
                this.f25157e = max;
                this.f25156d = new Format.Builder().g0(str).I(i5).b0(i5).Y(max).J(wavFormat.f25162b).h0(wavFormat.f25163c).a0(i2).G();
                return;
            }
            throw ParserException.a("Expected block size: " + i3 + "; got: " + wavFormat.f25165e, (Throwable) null);
        }

        public void a(int i2, long j2) {
            this.f25153a.u(new WavSeekMap(this.f25155c, 1, (long) i2, j2));
            this.f25154b.d(this.f25156d);
        }

        public void b(long j2) {
            this.f25158f = j2;
            this.f25159g = 0;
            this.f25160h = 0;
        }

        public boolean c(ExtractorInput extractorInput, long j2) throws IOException {
            int i2;
            int i3;
            int i4;
            long j3 = j2;
            while (true) {
                i2 = (j3 > 0 ? 1 : (j3 == 0 ? 0 : -1));
                if (i2 <= 0 || (i3 = this.f25159g) >= (i4 = this.f25157e)) {
                    WavFormat wavFormat = this.f25155c;
                    int i5 = wavFormat.f25165e;
                    int i6 = this.f25159g / i5;
                } else {
                    int b2 = this.f25154b.b(extractorInput, (int) Math.min((long) (i4 - i3), j3), true);
                    if (b2 == -1) {
                        j3 = 0;
                    } else {
                        this.f25159g += b2;
                        j3 -= (long) b2;
                    }
                }
            }
            WavFormat wavFormat2 = this.f25155c;
            int i52 = wavFormat2.f25165e;
            int i62 = this.f25159g / i52;
            if (i62 > 0) {
                int i7 = i62 * i52;
                int i8 = this.f25159g - i7;
                this.f25154b.e(this.f25158f + Util.R0(this.f25160h, 1000000, (long) wavFormat2.f25163c), 1, i7, i8, (TrackOutput.CryptoData) null);
                this.f25160h += (long) i62;
                this.f25159g = i8;
            }
            if (i2 <= 0) {
                return true;
            }
            return false;
        }
    }

    @EnsuresNonNull({"extractorOutput", "trackOutput"})
    private void d() {
        Assertions.i(this.f25133b);
        Util.j(this.f25132a);
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
        Assertions.g(z2);
        int i2 = this.f25137f;
        if (i2 != -1) {
            extractorInput.k(i2);
            this.f25134c = 4;
        } else if (WavHeaderReader.a(extractorInput)) {
            extractorInput.k((int) (extractorInput.g() - extractorInput.getPosition()));
            this.f25134c = 1;
        } else {
            throw ParserException.a("Unsupported or unrecognized wav file type.", (Throwable) null);
        }
    }

    @RequiresNonNull({"extractorOutput", "trackOutput"})
    private void h(ExtractorInput extractorInput) throws IOException {
        WavFormat b2 = WavHeaderReader.b(extractorInput);
        int i2 = b2.f25161a;
        if (i2 == 17) {
            this.f25136e = new ImaAdPcmOutputWriter(this.f25132a, this.f25133b, b2);
        } else if (i2 == 6) {
            this.f25136e = new PassthroughOutputWriter(this.f25132a, this.f25133b, b2, "audio/g711-alaw", -1);
        } else if (i2 == 7) {
            this.f25136e = new PassthroughOutputWriter(this.f25132a, this.f25133b, b2, "audio/g711-mlaw", -1);
        } else {
            int a2 = WavUtil.a(i2, b2.f25166f);
            if (a2 != 0) {
                this.f25136e = new PassthroughOutputWriter(this.f25132a, this.f25133b, b2, "audio/raw", a2);
            } else {
                throw ParserException.e("Unsupported WAV format type: " + b2.f25161a);
            }
        }
        this.f25134c = 3;
    }

    private void j(ExtractorInput extractorInput) throws IOException {
        this.f25135d = WavHeaderReader.c(extractorInput);
        this.f25134c = 2;
    }

    private int k(ExtractorInput extractorInput) throws IOException {
        boolean z2;
        if (this.f25138g != -1) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.g(z2);
        if (((OutputWriter) Assertions.e(this.f25136e)).c(extractorInput, this.f25138g - extractorInput.getPosition())) {
            return -1;
        }
        return 0;
    }

    private void l(ExtractorInput extractorInput) throws IOException {
        Pair<Long, Long> e2 = WavHeaderReader.e(extractorInput);
        this.f25137f = ((Long) e2.first).intValue();
        long longValue = ((Long) e2.second).longValue();
        long j2 = this.f25135d;
        if (j2 != -1 && longValue == 4294967295L) {
            longValue = j2;
        }
        this.f25138g = ((long) this.f25137f) + longValue;
        long length = extractorInput.getLength();
        if (length != -1 && this.f25138g > length) {
            Log.i("WavExtractor", "Data exceeds input length: " + this.f25138g + ", " + length);
            this.f25138g = length;
        }
        ((OutputWriter) Assertions.e(this.f25136e)).a(this.f25137f, this.f25138g);
        this.f25134c = 4;
    }

    public void a(long j2, long j3) {
        int i2;
        if (j2 == 0) {
            i2 = 0;
        } else {
            i2 = 4;
        }
        this.f25134c = i2;
        OutputWriter outputWriter = this.f25136e;
        if (outputWriter != null) {
            outputWriter.b(j3);
        }
    }

    public void c(ExtractorOutput extractorOutput) {
        this.f25132a = extractorOutput;
        this.f25133b = extractorOutput.d(0, 1);
        extractorOutput.m();
    }

    public boolean g(ExtractorInput extractorInput) throws IOException {
        return WavHeaderReader.a(extractorInput);
    }

    public int i(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        d();
        int i2 = this.f25134c;
        if (i2 == 0) {
            f(extractorInput);
            return 0;
        } else if (i2 == 1) {
            j(extractorInput);
            return 0;
        } else if (i2 == 2) {
            h(extractorInput);
            return 0;
        } else if (i2 == 3) {
            l(extractorInput);
            return 0;
        } else if (i2 == 4) {
            return k(extractorInput);
        } else {
            throw new IllegalStateException();
        }
    }

    public void release() {
    }
}
