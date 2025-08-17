package androidx.media3.exoplayer;

import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.source.ClippingMediaPeriod;
import androidx.media3.exoplayer.source.EmptySampleStream;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.SampleStream;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.trackselection.TrackSelector;
import androidx.media3.exoplayer.trackselection.TrackSelectorResult;
import androidx.media3.exoplayer.upstream.Allocator;
import java.io.IOException;

final class MediaPeriodHolder {

    /* renamed from: a  reason: collision with root package name */
    public final MediaPeriod f5401a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f5402b;

    /* renamed from: c  reason: collision with root package name */
    public final SampleStream[] f5403c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f5404d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f5405e;

    /* renamed from: f  reason: collision with root package name */
    public MediaPeriodInfo f5406f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f5407g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean[] f5408h;

    /* renamed from: i  reason: collision with root package name */
    private final RendererCapabilities[] f5409i;

    /* renamed from: j  reason: collision with root package name */
    private final TrackSelector f5410j;

    /* renamed from: k  reason: collision with root package name */
    private final MediaSourceList f5411k;

    /* renamed from: l  reason: collision with root package name */
    private MediaPeriodHolder f5412l;

    /* renamed from: m  reason: collision with root package name */
    private TrackGroupArray f5413m = TrackGroupArray.f7176d;

    /* renamed from: n  reason: collision with root package name */
    private TrackSelectorResult f5414n;

    /* renamed from: o  reason: collision with root package name */
    private long f5415o;

    interface Factory {
        MediaPeriodHolder a(MediaPeriodInfo mediaPeriodInfo, long j2);
    }

    public MediaPeriodHolder(RendererCapabilities[] rendererCapabilitiesArr, long j2, TrackSelector trackSelector, Allocator allocator, MediaSourceList mediaSourceList, MediaPeriodInfo mediaPeriodInfo, TrackSelectorResult trackSelectorResult) {
        this.f5409i = rendererCapabilitiesArr;
        this.f5415o = j2;
        this.f5410j = trackSelector;
        this.f5411k = mediaSourceList;
        MediaSource.MediaPeriodId mediaPeriodId = mediaPeriodInfo.f5416a;
        this.f5402b = mediaPeriodId.f6971a;
        this.f5406f = mediaPeriodInfo;
        this.f5414n = trackSelectorResult;
        this.f5403c = new SampleStream[rendererCapabilitiesArr.length];
        this.f5408h = new boolean[rendererCapabilitiesArr.length];
        this.f5401a = f(mediaPeriodId, mediaSourceList, allocator, mediaPeriodInfo.f5417b, mediaPeriodInfo.f5419d);
    }

    private void c(SampleStream[] sampleStreamArr) {
        int i2 = 0;
        while (true) {
            RendererCapabilities[] rendererCapabilitiesArr = this.f5409i;
            if (i2 < rendererCapabilitiesArr.length) {
                if (rendererCapabilitiesArr[i2].d() == -2 && this.f5414n.c(i2)) {
                    sampleStreamArr[i2] = new EmptySampleStream();
                }
                i2++;
            } else {
                return;
            }
        }
    }

    private static MediaPeriod f(MediaSource.MediaPeriodId mediaPeriodId, MediaSourceList mediaSourceList, Allocator allocator, long j2, long j3) {
        MediaPeriod h2 = mediaSourceList.h(mediaPeriodId, allocator, j2);
        if (j3 != -9223372036854775807L) {
            return new ClippingMediaPeriod(h2, true, 0, j3);
        }
        return h2;
    }

    private void g() {
        if (t()) {
            int i2 = 0;
            while (true) {
                TrackSelectorResult trackSelectorResult = this.f5414n;
                if (i2 < trackSelectorResult.f7472a) {
                    boolean c2 = trackSelectorResult.c(i2);
                    ExoTrackSelection exoTrackSelection = this.f5414n.f7474c[i2];
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

    private void h(SampleStream[] sampleStreamArr) {
        int i2 = 0;
        while (true) {
            RendererCapabilities[] rendererCapabilitiesArr = this.f5409i;
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

    private void i() {
        if (t()) {
            int i2 = 0;
            while (true) {
                TrackSelectorResult trackSelectorResult = this.f5414n;
                if (i2 < trackSelectorResult.f7472a) {
                    boolean c2 = trackSelectorResult.c(i2);
                    ExoTrackSelection exoTrackSelection = this.f5414n.f7474c[i2];
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

    private boolean t() {
        return this.f5412l == null;
    }

    private static void w(MediaSourceList mediaSourceList, MediaPeriod mediaPeriod) {
        try {
            if (mediaPeriod instanceof ClippingMediaPeriod) {
                mediaSourceList.A(((ClippingMediaPeriod) mediaPeriod).f6820b);
            } else {
                mediaSourceList.A(mediaPeriod);
            }
        } catch (RuntimeException e2) {
            Log.d("MediaPeriodHolder", "Period release failed.", e2);
        }
    }

    public long A(long j2) {
        return j2 - m();
    }

    public long B(long j2) {
        return j2 + m();
    }

    public void C() {
        MediaPeriod mediaPeriod = this.f5401a;
        if (mediaPeriod instanceof ClippingMediaPeriod) {
            long j2 = this.f5406f.f5419d;
            if (j2 == -9223372036854775807L) {
                j2 = Long.MIN_VALUE;
            }
            ((ClippingMediaPeriod) mediaPeriod).w(0, j2);
        }
    }

    public long a(TrackSelectorResult trackSelectorResult, long j2, boolean z2) {
        return b(trackSelectorResult, j2, z2, new boolean[this.f5409i.length]);
    }

    public long b(TrackSelectorResult trackSelectorResult, long j2, boolean z2, boolean[] zArr) {
        boolean z3;
        TrackSelectorResult trackSelectorResult2 = trackSelectorResult;
        int i2 = 0;
        while (true) {
            boolean z4 = true;
            if (i2 >= trackSelectorResult2.f7472a) {
                break;
            }
            boolean[] zArr2 = this.f5408h;
            if (z2 || !trackSelectorResult.b(this.f5414n, i2)) {
                z4 = false;
            }
            zArr2[i2] = z4;
            i2++;
        }
        h(this.f5403c);
        g();
        this.f5414n = trackSelectorResult2;
        i();
        long q2 = this.f5401a.q(trackSelectorResult2.f7474c, this.f5408h, this.f5403c, zArr, j2);
        c(this.f5403c);
        this.f5405e = false;
        int i3 = 0;
        while (true) {
            SampleStream[] sampleStreamArr = this.f5403c;
            if (i3 >= sampleStreamArr.length) {
                return q2;
            }
            if (sampleStreamArr[i3] != null) {
                Assertions.h(trackSelectorResult.c(i3));
                if (this.f5409i[i3].d() != -2) {
                    this.f5405e = true;
                }
            } else {
                if (trackSelectorResult2.f7474c[i3] == null) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                Assertions.h(z3);
            }
            i3++;
        }
    }

    public boolean d(MediaPeriodInfo mediaPeriodInfo) {
        if (MediaPeriodQueue.d(this.f5406f.f5420e, mediaPeriodInfo.f5420e)) {
            MediaPeriodInfo mediaPeriodInfo2 = this.f5406f;
            if (mediaPeriodInfo2.f5417b != mediaPeriodInfo.f5417b || !mediaPeriodInfo2.f5416a.equals(mediaPeriodInfo.f5416a)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public void e(long j2, float f2, long j3) {
        Assertions.h(t());
        this.f5401a.g(new LoadingInfo.Builder().f(A(j2)).g(f2).e(j3).d());
    }

    public long j() {
        long j2;
        if (!this.f5404d) {
            return this.f5406f.f5417b;
        }
        if (this.f5405e) {
            j2 = this.f5401a.e();
        } else {
            j2 = Long.MIN_VALUE;
        }
        if (j2 == Long.MIN_VALUE) {
            return this.f5406f.f5420e;
        }
        return j2;
    }

    public MediaPeriodHolder k() {
        return this.f5412l;
    }

    public long l() {
        if (!this.f5404d) {
            return 0;
        }
        return this.f5401a.b();
    }

    public long m() {
        return this.f5415o;
    }

    public long n() {
        return this.f5406f.f5417b + this.f5415o;
    }

    public TrackGroupArray o() {
        return this.f5413m;
    }

    public TrackSelectorResult p() {
        return this.f5414n;
    }

    public void q(float f2, Timeline timeline) throws ExoPlaybackException {
        this.f5404d = true;
        this.f5413m = this.f5401a.n();
        TrackSelectorResult x2 = x(f2, timeline);
        MediaPeriodInfo mediaPeriodInfo = this.f5406f;
        long j2 = mediaPeriodInfo.f5417b;
        long j3 = mediaPeriodInfo.f5420e;
        if (j3 != -9223372036854775807L && j2 >= j3) {
            j2 = Math.max(0, j3 - 1);
        }
        long a2 = a(x2, j2, false);
        long j4 = this.f5415o;
        MediaPeriodInfo mediaPeriodInfo2 = this.f5406f;
        this.f5415o = j4 + (mediaPeriodInfo2.f5417b - a2);
        this.f5406f = mediaPeriodInfo2.b(a2);
    }

    public boolean r() {
        try {
            if (!this.f5404d) {
                this.f5401a.l();
            } else {
                for (SampleStream sampleStream : this.f5403c) {
                    if (sampleStream != null) {
                        sampleStream.a();
                    }
                }
            }
            return false;
        } catch (IOException unused) {
            return true;
        }
    }

    public boolean s() {
        if (!this.f5404d || (this.f5405e && this.f5401a.e() != Long.MIN_VALUE)) {
            return false;
        }
        return true;
    }

    public void u(long j2) {
        Assertions.h(t());
        if (this.f5404d) {
            this.f5401a.f(A(j2));
        }
    }

    public void v() {
        g();
        w(this.f5411k, this.f5401a);
    }

    public TrackSelectorResult x(float f2, Timeline timeline) throws ExoPlaybackException {
        TrackSelectorResult k2 = this.f5410j.k(this.f5409i, o(), this.f5406f.f5416a, timeline);
        for (int i2 = 0; i2 < k2.f7472a; i2++) {
            boolean z2 = true;
            if (k2.c(i2)) {
                if (k2.f7474c[i2] == null && this.f5409i[i2].d() != -2) {
                    z2 = false;
                }
                Assertions.h(z2);
            } else {
                if (k2.f7474c[i2] != null) {
                    z2 = false;
                }
                Assertions.h(z2);
            }
        }
        for (ExoTrackSelection exoTrackSelection : k2.f7474c) {
            if (exoTrackSelection != null) {
                exoTrackSelection.d(f2);
            }
        }
        return k2;
    }

    public void y(MediaPeriodHolder mediaPeriodHolder) {
        if (mediaPeriodHolder != this.f5412l) {
            g();
            this.f5412l = mediaPeriodHolder;
            i();
        }
    }

    public void z(long j2) {
        this.f5415o = j2;
    }
}
