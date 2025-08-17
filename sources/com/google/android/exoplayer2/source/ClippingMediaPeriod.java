package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.source.ClippingMediaSource;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;

public final class ClippingMediaPeriod implements MediaPeriod, MediaPeriod.Callback {

    /* renamed from: b  reason: collision with root package name */
    public final MediaPeriod f25696b;

    /* renamed from: c  reason: collision with root package name */
    private MediaPeriod.Callback f25697c;

    /* renamed from: d  reason: collision with root package name */
    private ClippingSampleStream[] f25698d = new ClippingSampleStream[0];

    /* renamed from: e  reason: collision with root package name */
    private long f25699e;

    /* renamed from: f  reason: collision with root package name */
    long f25700f;

    /* renamed from: g  reason: collision with root package name */
    long f25701g;

    /* renamed from: h  reason: collision with root package name */
    private ClippingMediaSource.IllegalClippingException f25702h;

    private final class ClippingSampleStream implements SampleStream {

        /* renamed from: b  reason: collision with root package name */
        public final SampleStream f25703b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f25704c;

        public ClippingSampleStream(SampleStream sampleStream) {
            this.f25703b = sampleStream;
        }

        public void a() throws IOException {
            this.f25703b.a();
        }

        public void b() {
            this.f25704c = false;
        }

        public int d(long j2) {
            if (ClippingMediaPeriod.this.q()) {
                return -3;
            }
            return this.f25703b.d(j2);
        }

        public boolean isReady() {
            return !ClippingMediaPeriod.this.q() && this.f25703b.isReady();
        }

        public int m(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i2) {
            if (ClippingMediaPeriod.this.q()) {
                return -3;
            }
            if (this.f25704c) {
                decoderInputBuffer.o(4);
                return -4;
            }
            int m2 = this.f25703b.m(formatHolder, decoderInputBuffer, i2);
            if (m2 == -5) {
                Format format = (Format) Assertions.e(formatHolder.f23112b);
                int i3 = format.C;
                if (!(i3 == 0 && format.D == 0)) {
                    ClippingMediaPeriod clippingMediaPeriod = ClippingMediaPeriod.this;
                    int i4 = 0;
                    if (clippingMediaPeriod.f25700f != 0) {
                        i3 = 0;
                    }
                    if (clippingMediaPeriod.f25701g == Long.MIN_VALUE) {
                        i4 = format.D;
                    }
                    formatHolder.f23112b = format.b().P(i3).Q(i4).G();
                }
                return -5;
            }
            ClippingMediaPeriod clippingMediaPeriod2 = ClippingMediaPeriod.this;
            long j2 = clippingMediaPeriod2.f25701g;
            if (j2 == Long.MIN_VALUE || ((m2 != -4 || decoderInputBuffer.f23963f < j2) && (m2 != -3 || clippingMediaPeriod2.e() != Long.MIN_VALUE || decoderInputBuffer.f23962e))) {
                return m2;
            }
            decoderInputBuffer.f();
            decoderInputBuffer.o(4);
            this.f25704c = true;
            return -4;
        }
    }

    public ClippingMediaPeriod(MediaPeriod mediaPeriod, boolean z2, long j2, long j3) {
        long j4;
        this.f25696b = mediaPeriod;
        if (z2) {
            j4 = j2;
        } else {
            j4 = -9223372036854775807L;
        }
        this.f25699e = j4;
        this.f25700f = j2;
        this.f25701g = j3;
    }

    private SeekParameters m(long j2, SeekParameters seekParameters) {
        long j3;
        long r2 = Util.r(seekParameters.f23457a, 0, j2 - this.f25700f);
        long j4 = seekParameters.f23458b;
        long j5 = this.f25701g;
        if (j5 == Long.MIN_VALUE) {
            j3 = Long.MAX_VALUE;
        } else {
            j3 = j5 - j2;
        }
        long r3 = Util.r(j4, 0, j3);
        if (r2 == seekParameters.f23457a && r3 == seekParameters.f23458b) {
            return seekParameters;
        }
        return new SeekParameters(r2, r3);
    }

    private static boolean v(long j2, ExoTrackSelection[] exoTrackSelectionArr) {
        if (j2 != 0) {
            for (ExoTrackSelection exoTrackSelection : exoTrackSelectionArr) {
                if (exoTrackSelection != null) {
                    Format l2 = exoTrackSelection.l();
                    if (!MimeTypes.a(l2.f23071m, l2.f23068j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public long b() {
        long b2 = this.f25696b.b();
        if (b2 != Long.MIN_VALUE) {
            long j2 = this.f25701g;
            if (j2 == Long.MIN_VALUE || b2 < j2) {
                return b2;
            }
        }
        return Long.MIN_VALUE;
    }

    public boolean c() {
        return this.f25696b.c();
    }

    public long e() {
        long e2 = this.f25696b.e();
        if (e2 != Long.MIN_VALUE) {
            long j2 = this.f25701g;
            if (j2 == Long.MIN_VALUE || e2 < j2) {
                return e2;
            }
        }
        return Long.MIN_VALUE;
    }

    public void f(long j2) {
        this.f25696b.f(j2);
    }

    public long g(long j2, SeekParameters seekParameters) {
        long j3 = this.f25700f;
        if (j2 == j3) {
            return j3;
        }
        return this.f25696b.g(j2, m(j2, seekParameters));
    }

    public boolean h(long j2) {
        return this.f25696b.h(j2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0032, code lost:
        if (r0 > r7) goto L_0x0035;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long i(long r7) {
        /*
            r6 = this;
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r6.f25699e = r0
            com.google.android.exoplayer2.source.ClippingMediaPeriod$ClippingSampleStream[] r0 = r6.f25698d
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
            com.google.android.exoplayer2.source.MediaPeriod r0 = r6.f25696b
            long r0 = r0.i(r7)
            int r3 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r3 == 0) goto L_0x0034
            long r7 = r6.f25700f
            int r3 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r3 < 0) goto L_0x0035
            long r7 = r6.f25701g
            r3 = -9223372036854775808
            int r5 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x0034
            int r3 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r3 > 0) goto L_0x0035
        L_0x0034:
            r2 = 1
        L_0x0035:
            com.google.android.exoplayer2.util.Assertions.g(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.ClippingMediaPeriod.i(long):long");
    }

    public long j() {
        boolean z2;
        if (q()) {
            long j2 = this.f25699e;
            this.f25699e = -9223372036854775807L;
            long j3 = j();
            if (j3 != -9223372036854775807L) {
                return j3;
            }
            return j2;
        }
        long j4 = this.f25696b.j();
        if (j4 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        boolean z3 = true;
        if (j4 >= this.f25700f) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.g(z2);
        long j5 = this.f25701g;
        if (j5 != Long.MIN_VALUE && j4 > j5) {
            z3 = false;
        }
        Assertions.g(z3);
        return j4;
    }

    public void l() throws IOException {
        ClippingMediaSource.IllegalClippingException illegalClippingException = this.f25702h;
        if (illegalClippingException == null) {
            this.f25696b.l();
            return;
        }
        throw illegalClippingException;
    }

    public TrackGroupArray n() {
        return this.f25696b.n();
    }

    public void o(long j2, boolean z2) {
        this.f25696b.o(j2, z2);
    }

    public void p(MediaPeriod mediaPeriod) {
        if (this.f25702h == null) {
            ((MediaPeriod.Callback) Assertions.e(this.f25697c)).p(this);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean q() {
        return this.f25699e != -9223372036854775807L;
    }

    public void r(MediaPeriod.Callback callback, long j2) {
        this.f25697c = callback;
        this.f25696b.r(this, j2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005e, code lost:
        if (r2 > r4) goto L_0x0061;
     */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x006a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long s(com.google.android.exoplayer2.trackselection.ExoTrackSelection[] r13, boolean[] r14, com.google.android.exoplayer2.source.SampleStream[] r15, boolean[] r16, long r17) {
        /*
            r12 = this;
            r0 = r12
            r1 = r15
            int r2 = r1.length
            com.google.android.exoplayer2.source.ClippingMediaPeriod$ClippingSampleStream[] r2 = new com.google.android.exoplayer2.source.ClippingMediaPeriod.ClippingSampleStream[r2]
            r0.f25698d = r2
            int r2 = r1.length
            com.google.android.exoplayer2.source.SampleStream[] r9 = new com.google.android.exoplayer2.source.SampleStream[r2]
            r10 = 0
            r2 = 0
        L_0x000c:
            int r3 = r1.length
            r11 = 0
            if (r2 >= r3) goto L_0x0021
            com.google.android.exoplayer2.source.ClippingMediaPeriod$ClippingSampleStream[] r3 = r0.f25698d
            r4 = r1[r2]
            com.google.android.exoplayer2.source.ClippingMediaPeriod$ClippingSampleStream r4 = (com.google.android.exoplayer2.source.ClippingMediaPeriod.ClippingSampleStream) r4
            r3[r2] = r4
            if (r4 == 0) goto L_0x001c
            com.google.android.exoplayer2.source.SampleStream r11 = r4.f25703b
        L_0x001c:
            r9[r2] = r11
            int r2 = r2 + 1
            goto L_0x000c
        L_0x0021:
            com.google.android.exoplayer2.source.MediaPeriod r2 = r0.f25696b
            r3 = r13
            r4 = r14
            r5 = r9
            r6 = r16
            r7 = r17
            long r2 = r2.s(r3, r4, r5, r6, r7)
            boolean r4 = r12.q()
            if (r4 == 0) goto L_0x0043
            long r4 = r0.f25700f
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
            r0.f25699e = r4
            int r4 = (r2 > r17 ? 1 : (r2 == r17 ? 0 : -1))
            if (r4 == 0) goto L_0x0063
            long r4 = r0.f25700f
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 < 0) goto L_0x0061
            long r4 = r0.f25701g
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
            com.google.android.exoplayer2.util.Assertions.g(r4)
        L_0x0067:
            int r4 = r1.length
            if (r10 >= r4) goto L_0x008d
            r4 = r9[r10]
            if (r4 != 0) goto L_0x0073
            com.google.android.exoplayer2.source.ClippingMediaPeriod$ClippingSampleStream[] r4 = r0.f25698d
            r4[r10] = r11
            goto L_0x0084
        L_0x0073:
            com.google.android.exoplayer2.source.ClippingMediaPeriod$ClippingSampleStream[] r5 = r0.f25698d
            r6 = r5[r10]
            if (r6 == 0) goto L_0x007d
            com.google.android.exoplayer2.source.SampleStream r6 = r6.f25703b
            if (r6 == r4) goto L_0x0084
        L_0x007d:
            com.google.android.exoplayer2.source.ClippingMediaPeriod$ClippingSampleStream r6 = new com.google.android.exoplayer2.source.ClippingMediaPeriod$ClippingSampleStream
            r6.<init>(r4)
            r5[r10] = r6
        L_0x0084:
            com.google.android.exoplayer2.source.ClippingMediaPeriod$ClippingSampleStream[] r4 = r0.f25698d
            r4 = r4[r10]
            r1[r10] = r4
            int r10 = r10 + 1
            goto L_0x0067
        L_0x008d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.ClippingMediaPeriod.s(com.google.android.exoplayer2.trackselection.ExoTrackSelection[], boolean[], com.google.android.exoplayer2.source.SampleStream[], boolean[], long):long");
    }

    /* renamed from: t */
    public void d(MediaPeriod mediaPeriod) {
        ((MediaPeriod.Callback) Assertions.e(this.f25697c)).d(this);
    }

    public void u(ClippingMediaSource.IllegalClippingException illegalClippingException) {
        this.f25702h = illegalClippingException;
    }

    public void w(long j2, long j3) {
        this.f25700f = j2;
        this.f25701g = j3;
    }
}
