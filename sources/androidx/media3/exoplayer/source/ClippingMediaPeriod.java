package androidx.media3.exoplayer.source;

import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.SeekParameters;
import androidx.media3.exoplayer.source.ClippingMediaSource;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import java.io.IOException;

public final class ClippingMediaPeriod implements MediaPeriod, MediaPeriod.Callback {

    /* renamed from: b  reason: collision with root package name */
    public final MediaPeriod f6820b;

    /* renamed from: c  reason: collision with root package name */
    private MediaPeriod.Callback f6821c;

    /* renamed from: d  reason: collision with root package name */
    private ClippingSampleStream[] f6822d = new ClippingSampleStream[0];

    /* renamed from: e  reason: collision with root package name */
    private long f6823e;

    /* renamed from: f  reason: collision with root package name */
    long f6824f;

    /* renamed from: g  reason: collision with root package name */
    long f6825g;

    /* renamed from: h  reason: collision with root package name */
    private ClippingMediaSource.IllegalClippingException f6826h;

    private final class ClippingSampleStream implements SampleStream {

        /* renamed from: b  reason: collision with root package name */
        public final SampleStream f6827b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f6828c;

        public ClippingSampleStream(SampleStream sampleStream) {
            this.f6827b = sampleStream;
        }

        public void a() throws IOException {
            this.f6827b.a();
        }

        public void b() {
            this.f6828c = false;
        }

        public int d(long j2) {
            if (ClippingMediaPeriod.this.r()) {
                return -3;
            }
            return this.f6827b.d(j2);
        }

        public boolean isReady() {
            return !ClippingMediaPeriod.this.r() && this.f6827b.isReady();
        }

        public int m(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i2) {
            if (ClippingMediaPeriod.this.r()) {
                return -3;
            }
            if (this.f6828c) {
                decoderInputBuffer.setFlags(4);
                return -4;
            }
            long e2 = ClippingMediaPeriod.this.e();
            int m2 = this.f6827b.m(formatHolder, decoderInputBuffer, i2);
            if (m2 == -5) {
                Format format = (Format) Assertions.f(formatHolder.f5385b);
                int i3 = format.E;
                if (!(i3 == 0 && format.F == 0)) {
                    ClippingMediaPeriod clippingMediaPeriod = ClippingMediaPeriod.this;
                    int i4 = 0;
                    if (clippingMediaPeriod.f6824f != 0) {
                        i3 = 0;
                    }
                    if (clippingMediaPeriod.f6825g == Long.MIN_VALUE) {
                        i4 = format.F;
                    }
                    formatHolder.f5385b = format.a().V(i3).W(i4).K();
                }
                return -5;
            }
            long j2 = ClippingMediaPeriod.this.f6825g;
            if (j2 == Long.MIN_VALUE || ((m2 != -4 || decoderInputBuffer.f5069f < j2) && (m2 != -3 || e2 != Long.MIN_VALUE || decoderInputBuffer.f5068e))) {
                return m2;
            }
            decoderInputBuffer.clear();
            decoderInputBuffer.setFlags(4);
            this.f6828c = true;
            return -4;
        }
    }

    public ClippingMediaPeriod(MediaPeriod mediaPeriod, boolean z2, long j2, long j3) {
        long j4;
        this.f6820b = mediaPeriod;
        if (z2) {
            j4 = j2;
        } else {
            j4 = -9223372036854775807L;
        }
        this.f6823e = j4;
        this.f6824f = j2;
        this.f6825g = j3;
    }

    private SeekParameters d(long j2, SeekParameters seekParameters) {
        long j3;
        long q2 = Util.q(seekParameters.f5515a, 0, j2 - this.f6824f);
        long j4 = seekParameters.f5516b;
        long j5 = this.f6825g;
        if (j5 == Long.MIN_VALUE) {
            j3 = Long.MAX_VALUE;
        } else {
            j3 = j5 - j2;
        }
        long q3 = Util.q(j4, 0, j3);
        if (q2 == seekParameters.f5515a && q3 == seekParameters.f5516b) {
            return seekParameters;
        }
        return new SeekParameters(q2, q3);
    }

    private static boolean v(long j2, ExoTrackSelection[] exoTrackSelectionArr) {
        if (j2 != 0) {
            for (ExoTrackSelection exoTrackSelection : exoTrackSelectionArr) {
                if (exoTrackSelection != null) {
                    Format l2 = exoTrackSelection.l();
                    if (!MimeTypes.a(l2.f4015n, l2.f4011j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public long b() {
        long b2 = this.f6820b.b();
        if (b2 != Long.MIN_VALUE) {
            long j2 = this.f6825g;
            if (j2 == Long.MIN_VALUE || b2 < j2) {
                return b2;
            }
        }
        return Long.MIN_VALUE;
    }

    public boolean c() {
        return this.f6820b.c();
    }

    public long e() {
        long e2 = this.f6820b.e();
        if (e2 != Long.MIN_VALUE) {
            long j2 = this.f6825g;
            if (j2 == Long.MIN_VALUE || e2 < j2) {
                return e2;
            }
        }
        return Long.MIN_VALUE;
    }

    public void f(long j2) {
        this.f6820b.f(j2);
    }

    public boolean g(LoadingInfo loadingInfo) {
        return this.f6820b.g(loadingInfo);
    }

    public long h(long j2, SeekParameters seekParameters) {
        long j3 = this.f6824f;
        if (j2 == j3) {
            return j3;
        }
        return this.f6820b.h(j2, d(j2, seekParameters));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0032, code lost:
        if (r0 > r7) goto L_0x0035;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long i(long r7) {
        /*
            r6 = this;
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r6.f6823e = r0
            androidx.media3.exoplayer.source.ClippingMediaPeriod$ClippingSampleStream[] r0 = r6.f6822d
            int r1 = r0.length
            r2 = 0
            r3 = 0
        L_0x000c:
            if (r3 >= r1) goto L_0x0018
            r4 = r0[r3]
            if (r4 == 0) goto L_0x0015
            r4.b()
        L_0x0015:
            int r3 = r3 + 1
            goto L_0x000c
        L_0x0018:
            androidx.media3.exoplayer.source.MediaPeriod r0 = r6.f6820b
            long r0 = r0.i(r7)
            int r3 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r3 == 0) goto L_0x0034
            long r7 = r6.f6824f
            int r3 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r3 < 0) goto L_0x0035
            long r7 = r6.f6825g
            r3 = -9223372036854775808
            int r5 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x0034
            int r3 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r3 > 0) goto L_0x0035
        L_0x0034:
            r2 = 1
        L_0x0035:
            androidx.media3.common.util.Assertions.h(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.source.ClippingMediaPeriod.i(long):long");
    }

    public long j() {
        boolean z2;
        if (r()) {
            long j2 = this.f6823e;
            this.f6823e = -9223372036854775807L;
            long j3 = j();
            if (j3 != -9223372036854775807L) {
                return j3;
            }
            return j2;
        }
        long j4 = this.f6820b.j();
        if (j4 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        boolean z3 = true;
        if (j4 >= this.f6824f) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.h(z2);
        long j5 = this.f6825g;
        if (j5 != Long.MIN_VALUE && j4 > j5) {
            z3 = false;
        }
        Assertions.h(z3);
        return j4;
    }

    public void l() throws IOException {
        ClippingMediaSource.IllegalClippingException illegalClippingException = this.f6826h;
        if (illegalClippingException == null) {
            this.f6820b.l();
            return;
        }
        throw illegalClippingException;
    }

    public void m(MediaPeriod mediaPeriod) {
        if (this.f6826h == null) {
            ((MediaPeriod.Callback) Assertions.f(this.f6821c)).m(this);
        }
    }

    public TrackGroupArray n() {
        return this.f6820b.n();
    }

    public void o(long j2, boolean z2) {
        this.f6820b.o(j2, z2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005e, code lost:
        if (r2 > r4) goto L_0x0061;
     */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x006a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long q(androidx.media3.exoplayer.trackselection.ExoTrackSelection[] r13, boolean[] r14, androidx.media3.exoplayer.source.SampleStream[] r15, boolean[] r16, long r17) {
        /*
            r12 = this;
            r0 = r12
            r1 = r15
            int r2 = r1.length
            androidx.media3.exoplayer.source.ClippingMediaPeriod$ClippingSampleStream[] r2 = new androidx.media3.exoplayer.source.ClippingMediaPeriod.ClippingSampleStream[r2]
            r0.f6822d = r2
            int r2 = r1.length
            androidx.media3.exoplayer.source.SampleStream[] r9 = new androidx.media3.exoplayer.source.SampleStream[r2]
            r10 = 0
            r2 = 0
        L_0x000c:
            int r3 = r1.length
            r11 = 0
            if (r2 >= r3) goto L_0x0021
            androidx.media3.exoplayer.source.ClippingMediaPeriod$ClippingSampleStream[] r3 = r0.f6822d
            r4 = r1[r2]
            androidx.media3.exoplayer.source.ClippingMediaPeriod$ClippingSampleStream r4 = (androidx.media3.exoplayer.source.ClippingMediaPeriod.ClippingSampleStream) r4
            r3[r2] = r4
            if (r4 == 0) goto L_0x001c
            androidx.media3.exoplayer.source.SampleStream r11 = r4.f6827b
        L_0x001c:
            r9[r2] = r11
            int r2 = r2 + 1
            goto L_0x000c
        L_0x0021:
            androidx.media3.exoplayer.source.MediaPeriod r2 = r0.f6820b
            r3 = r13
            r4 = r14
            r5 = r9
            r6 = r16
            r7 = r17
            long r2 = r2.q(r3, r4, r5, r6, r7)
            boolean r4 = r12.r()
            if (r4 == 0) goto L_0x0043
            long r4 = r0.f6824f
            int r6 = (r17 > r4 ? 1 : (r17 == r4 ? 0 : -1))
            if (r6 != 0) goto L_0x0043
            r6 = r13
            boolean r4 = v(r4, r13)
            if (r4 == 0) goto L_0x0043
            r4 = r2
            goto L_0x0048
        L_0x0043:
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L_0x0048:
            r0.f6823e = r4
            int r4 = (r2 > r17 ? 1 : (r2 == r17 ? 0 : -1))
            if (r4 == 0) goto L_0x0063
            long r4 = r0.f6824f
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 < 0) goto L_0x0061
            long r4 = r0.f6825g
            r6 = -9223372036854775808
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x0063
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 > 0) goto L_0x0061
            goto L_0x0063
        L_0x0061:
            r4 = 0
            goto L_0x0064
        L_0x0063:
            r4 = 1
        L_0x0064:
            androidx.media3.common.util.Assertions.h(r4)
        L_0x0067:
            int r4 = r1.length
            if (r10 >= r4) goto L_0x008d
            r4 = r9[r10]
            if (r4 != 0) goto L_0x0073
            androidx.media3.exoplayer.source.ClippingMediaPeriod$ClippingSampleStream[] r4 = r0.f6822d
            r4[r10] = r11
            goto L_0x0084
        L_0x0073:
            androidx.media3.exoplayer.source.ClippingMediaPeriod$ClippingSampleStream[] r5 = r0.f6822d
            r6 = r5[r10]
            if (r6 == 0) goto L_0x007d
            androidx.media3.exoplayer.source.SampleStream r6 = r6.f6827b
            if (r6 == r4) goto L_0x0084
        L_0x007d:
            androidx.media3.exoplayer.source.ClippingMediaPeriod$ClippingSampleStream r6 = new androidx.media3.exoplayer.source.ClippingMediaPeriod$ClippingSampleStream
            r6.<init>(r4)
            r5[r10] = r6
        L_0x0084:
            androidx.media3.exoplayer.source.ClippingMediaPeriod$ClippingSampleStream[] r4 = r0.f6822d
            r4 = r4[r10]
            r1[r10] = r4
            int r10 = r10 + 1
            goto L_0x0067
        L_0x008d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.source.ClippingMediaPeriod.q(androidx.media3.exoplayer.trackselection.ExoTrackSelection[], boolean[], androidx.media3.exoplayer.source.SampleStream[], boolean[], long):long");
    }

    /* access modifiers changed from: package-private */
    public boolean r() {
        return this.f6823e != -9223372036854775807L;
    }

    public void s(MediaPeriod.Callback callback, long j2) {
        this.f6821c = callback;
        this.f6820b.s(this, j2);
    }

    /* renamed from: t */
    public void p(MediaPeriod mediaPeriod) {
        ((MediaPeriod.Callback) Assertions.f(this.f6821c)).p(this);
    }

    public void u(ClippingMediaSource.IllegalClippingException illegalClippingException) {
        this.f6826h = illegalClippingException;
    }

    public void w(long j2, long j3) {
        this.f6824f = j2;
        this.f6825g = j3;
    }
}
