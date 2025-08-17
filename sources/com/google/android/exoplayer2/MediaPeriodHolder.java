package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.ClippingMediaPeriod;
import com.google.android.exoplayer2.source.EmptySampleStream;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectorResult;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;

final class MediaPeriodHolder {

    /* renamed from: a  reason: collision with root package name */
    public final MediaPeriod f23304a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f23305b;

    /* renamed from: c  reason: collision with root package name */
    public final SampleStream[] f23306c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f23307d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f23308e;

    /* renamed from: f  reason: collision with root package name */
    public MediaPeriodInfo f23309f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f23310g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean[] f23311h;

    /* renamed from: i  reason: collision with root package name */
    private final RendererCapabilities[] f23312i;

    /* renamed from: j  reason: collision with root package name */
    private final TrackSelector f23313j;

    /* renamed from: k  reason: collision with root package name */
    private final MediaSourceList f23314k;

    /* renamed from: l  reason: collision with root package name */
    private MediaPeriodHolder f23315l;

    /* renamed from: m  reason: collision with root package name */
    private TrackGroupArray f23316m = TrackGroupArray.f26007e;

    /* renamed from: n  reason: collision with root package name */
    private TrackSelectorResult f23317n;

    /* renamed from: o  reason: collision with root package name */
    private long f23318o;

    public MediaPeriodHolder(RendererCapabilities[] rendererCapabilitiesArr, long j2, TrackSelector trackSelector, Allocator allocator, MediaSourceList mediaSourceList, MediaPeriodInfo mediaPeriodInfo, TrackSelectorResult trackSelectorResult) {
        this.f23312i = rendererCapabilitiesArr;
        this.f23318o = j2;
        this.f23313j = trackSelector;
        this.f23314k = mediaSourceList;
        MediaSource.MediaPeriodId mediaPeriodId = mediaPeriodInfo.f23319a;
        this.f23305b = mediaPeriodId.f25793a;
        this.f23309f = mediaPeriodInfo;
        this.f23317n = trackSelectorResult;
        this.f23306c = new SampleStream[rendererCapabilitiesArr.length];
        this.f23311h = new boolean[rendererCapabilitiesArr.length];
        this.f23304a = e(mediaPeriodId, mediaSourceList, allocator, mediaPeriodInfo.f23320b, mediaPeriodInfo.f23322d);
    }

    private void c(SampleStream[] sampleStreamArr) {
        int i2 = 0;
        while (true) {
            RendererCapabilities[] rendererCapabilitiesArr = this.f23312i;
            if (i2 < rendererCapabilitiesArr.length) {
                if (rendererCapabilitiesArr[i2].d() == -2 && this.f23317n.c(i2)) {
                    sampleStreamArr[i2] = new EmptySampleStream();
                }
                i2++;
            } else {
                return;
            }
        }
    }

    private static MediaPeriod e(MediaSource.MediaPeriodId mediaPeriodId, MediaSourceList mediaSourceList, Allocator allocator, long j2, long j3) {
        MediaPeriod h2 = mediaSourceList.h(mediaPeriodId, allocator, j2);
        if (j3 != -9223372036854775807L) {
            return new ClippingMediaPeriod(h2, true, 0, j3);
        }
        return h2;
    }

    private void f() {
        if (r()) {
            int i2 = 0;
            while (true) {
                TrackSelectorResult trackSelectorResult = this.f23317n;
                if (i2 < trackSelectorResult.f27820a) {
                    boolean c2 = trackSelectorResult.c(i2);
                    ExoTrackSelection exoTrackSelection = this.f23317n.f27822c[i2];
                    if (c2 && exoTrackSelection != null) {
                        exoTrackSelection.disable();
                    }
                    i2++;
                } else {
                    return;
                }
            }
        }
    }

    private void g(SampleStream[] sampleStreamArr) {
        int i2 = 0;
        while (true) {
            RendererCapabilities[] rendererCapabilitiesArr = this.f23312i;
            if (i2 < rendererCapabilitiesArr.length) {
                if (rendererCapabilitiesArr[i2].d() == -2) {
                    sampleStreamArr[i2] = null;
                }
                i2++;
            } else {
                return;
            }
        }
    }

    private void h() {
        if (r()) {
            int i2 = 0;
            while (true) {
                TrackSelectorResult trackSelectorResult = this.f23317n;
                if (i2 < trackSelectorResult.f27820a) {
                    boolean c2 = trackSelectorResult.c(i2);
                    ExoTrackSelection exoTrackSelection = this.f23317n.f27822c[i2];
                    if (c2 && exoTrackSelection != null) {
                        exoTrackSelection.enable();
                    }
                    i2++;
                } else {
                    return;
                }
            }
        }
    }

    private boolean r() {
        return this.f23315l == null;
    }

    private static void u(MediaSourceList mediaSourceList, MediaPeriod mediaPeriod) {
        try {
            if (mediaPeriod instanceof ClippingMediaPeriod) {
                mediaSourceList.z(((ClippingMediaPeriod) mediaPeriod).f25696b);
            } else {
                mediaSourceList.z(mediaPeriod);
            }
        } catch (RuntimeException e2) {
            Log.d("MediaPeriodHolder", "Period release failed.", e2);
        }
    }

    public void A() {
        MediaPeriod mediaPeriod = this.f23304a;
        if (mediaPeriod instanceof ClippingMediaPeriod) {
            long j2 = this.f23309f.f23322d;
            if (j2 == -9223372036854775807L) {
                j2 = Long.MIN_VALUE;
            }
            ((ClippingMediaPeriod) mediaPeriod).w(0, j2);
        }
    }

    public long a(TrackSelectorResult trackSelectorResult, long j2, boolean z2) {
        return b(trackSelectorResult, j2, z2, new boolean[this.f23312i.length]);
    }

    public long b(TrackSelectorResult trackSelectorResult, long j2, boolean z2, boolean[] zArr) {
        boolean z3;
        TrackSelectorResult trackSelectorResult2 = trackSelectorResult;
        int i2 = 0;
        while (true) {
            boolean z4 = true;
            if (i2 >= trackSelectorResult2.f27820a) {
                break;
            }
            boolean[] zArr2 = this.f23311h;
            if (z2 || !trackSelectorResult.b(this.f23317n, i2)) {
                z4 = false;
            }
            zArr2[i2] = z4;
            i2++;
        }
        g(this.f23306c);
        f();
        this.f23317n = trackSelectorResult2;
        h();
        long s2 = this.f23304a.s(trackSelectorResult2.f27822c, this.f23311h, this.f23306c, zArr, j2);
        c(this.f23306c);
        this.f23308e = false;
        int i3 = 0;
        while (true) {
            SampleStream[] sampleStreamArr = this.f23306c;
            if (i3 >= sampleStreamArr.length) {
                return s2;
            }
            if (sampleStreamArr[i3] != null) {
                Assertions.g(trackSelectorResult.c(i3));
                if (this.f23312i[i3].d() != -2) {
                    this.f23308e = true;
                }
            } else {
                if (trackSelectorResult2.f27822c[i3] == null) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                Assertions.g(z3);
            }
            i3++;
        }
    }

    public void d(long j2) {
        Assertions.g(r());
        this.f23304a.h(y(j2));
    }

    public long i() {
        long j2;
        if (!this.f23307d) {
            return this.f23309f.f23320b;
        }
        if (this.f23308e) {
            j2 = this.f23304a.e();
        } else {
            j2 = Long.MIN_VALUE;
        }
        if (j2 == Long.MIN_VALUE) {
            return this.f23309f.f23323e;
        }
        return j2;
    }

    public MediaPeriodHolder j() {
        return this.f23315l;
    }

    public long k() {
        if (!this.f23307d) {
            return 0;
        }
        return this.f23304a.b();
    }

    public long l() {
        return this.f23318o;
    }

    public long m() {
        return this.f23309f.f23320b + this.f23318o;
    }

    public TrackGroupArray n() {
        return this.f23316m;
    }

    public TrackSelectorResult o() {
        return this.f23317n;
    }

    public void p(float f2, Timeline timeline) throws ExoPlaybackException {
        this.f23307d = true;
        this.f23316m = this.f23304a.n();
        TrackSelectorResult v2 = v(f2, timeline);
        MediaPeriodInfo mediaPeriodInfo = this.f23309f;
        long j2 = mediaPeriodInfo.f23320b;
        long j3 = mediaPeriodInfo.f23323e;
        if (j3 != -9223372036854775807L && j2 >= j3) {
            j2 = Math.max(0, j3 - 1);
        }
        long a2 = a(v2, j2, false);
        long j4 = this.f23318o;
        MediaPeriodInfo mediaPeriodInfo2 = this.f23309f;
        this.f23318o = j4 + (mediaPeriodInfo2.f23320b - a2);
        this.f23309f = mediaPeriodInfo2.b(a2);
    }

    public boolean q() {
        if (!this.f23307d || (this.f23308e && this.f23304a.e() != Long.MIN_VALUE)) {
            return false;
        }
        return true;
    }

    public void s(long j2) {
        Assertions.g(r());
        if (this.f23307d) {
            this.f23304a.f(y(j2));
        }
    }

    public void t() {
        f();
        u(this.f23314k, this.f23304a);
    }

    public TrackSelectorResult v(float f2, Timeline timeline) throws ExoPlaybackException {
        TrackSelectorResult h2 = this.f23313j.h(this.f23312i, n(), this.f23309f.f23319a, timeline);
        for (ExoTrackSelection exoTrackSelection : h2.f27822c) {
            if (exoTrackSelection != null) {
                exoTrackSelection.d(f2);
            }
        }
        return h2;
    }

    public void w(MediaPeriodHolder mediaPeriodHolder) {
        if (mediaPeriodHolder != this.f23315l) {
            f();
            this.f23315l = mediaPeriodHolder;
            h();
        }
    }

    public void x(long j2) {
        this.f23318o = j2;
    }

    public long y(long j2) {
        return j2 - l();
    }

    public long z(long j2) {
        return j2 + l();
    }
}
