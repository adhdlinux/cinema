package androidx.media3.exoplayer.source;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.SeekParameters;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.upstream.Allocator;
import java.io.IOException;

public final class MaskingMediaPeriod implements MediaPeriod, MediaPeriod.Callback {

    /* renamed from: b  reason: collision with root package name */
    public final MediaSource.MediaPeriodId f6943b;

    /* renamed from: c  reason: collision with root package name */
    private final long f6944c;

    /* renamed from: d  reason: collision with root package name */
    private final Allocator f6945d;

    /* renamed from: e  reason: collision with root package name */
    private MediaSource f6946e;

    /* renamed from: f  reason: collision with root package name */
    private MediaPeriod f6947f;

    /* renamed from: g  reason: collision with root package name */
    private MediaPeriod.Callback f6948g;

    /* renamed from: h  reason: collision with root package name */
    private PrepareListener f6949h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f6950i;

    /* renamed from: j  reason: collision with root package name */
    private long f6951j = -9223372036854775807L;

    public interface PrepareListener {
        void a(MediaSource.MediaPeriodId mediaPeriodId, IOException iOException);

        void b(MediaSource.MediaPeriodId mediaPeriodId);
    }

    public MaskingMediaPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j2) {
        this.f6943b = mediaPeriodId;
        this.f6945d = allocator;
        this.f6944c = j2;
    }

    private long u(long j2) {
        long j3 = this.f6951j;
        return j3 != -9223372036854775807L ? j3 : j2;
    }

    public long b() {
        return ((MediaPeriod) Util.i(this.f6947f)).b();
    }

    public boolean c() {
        MediaPeriod mediaPeriod = this.f6947f;
        return mediaPeriod != null && mediaPeriod.c();
    }

    public void d(MediaSource.MediaPeriodId mediaPeriodId) {
        long u2 = u(this.f6944c);
        MediaPeriod i2 = ((MediaSource) Assertions.f(this.f6946e)).i(mediaPeriodId, this.f6945d, u2);
        this.f6947f = i2;
        if (this.f6948g != null) {
            i2.s(this, u2);
        }
    }

    public long e() {
        return ((MediaPeriod) Util.i(this.f6947f)).e();
    }

    public void f(long j2) {
        ((MediaPeriod) Util.i(this.f6947f)).f(j2);
    }

    public boolean g(LoadingInfo loadingInfo) {
        MediaPeriod mediaPeriod = this.f6947f;
        return mediaPeriod != null && mediaPeriod.g(loadingInfo);
    }

    public long h(long j2, SeekParameters seekParameters) {
        return ((MediaPeriod) Util.i(this.f6947f)).h(j2, seekParameters);
    }

    public long i(long j2) {
        return ((MediaPeriod) Util.i(this.f6947f)).i(j2);
    }

    public long j() {
        return ((MediaPeriod) Util.i(this.f6947f)).j();
    }

    public void l() throws IOException {
        try {
            MediaPeriod mediaPeriod = this.f6947f;
            if (mediaPeriod != null) {
                mediaPeriod.l();
                return;
            }
            MediaSource mediaSource = this.f6946e;
            if (mediaSource != null) {
                mediaSource.c();
            }
        } catch (IOException e2) {
            PrepareListener prepareListener = this.f6949h;
            if (prepareListener == null) {
                throw e2;
            } else if (!this.f6950i) {
                this.f6950i = true;
                prepareListener.a(this.f6943b, e2);
            }
        }
    }

    public void m(MediaPeriod mediaPeriod) {
        ((MediaPeriod.Callback) Util.i(this.f6948g)).m(this);
        PrepareListener prepareListener = this.f6949h;
        if (prepareListener != null) {
            prepareListener.b(this.f6943b);
        }
    }

    public TrackGroupArray n() {
        return ((MediaPeriod) Util.i(this.f6947f)).n();
    }

    public void o(long j2, boolean z2) {
        ((MediaPeriod) Util.i(this.f6947f)).o(j2, z2);
    }

    public long q(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j2) {
        long j3;
        long j4 = this.f6951j;
        if (j4 == -9223372036854775807L || j2 != this.f6944c) {
            j3 = j2;
        } else {
            j3 = j4;
        }
        this.f6951j = -9223372036854775807L;
        return ((MediaPeriod) Util.i(this.f6947f)).q(exoTrackSelectionArr, zArr, sampleStreamArr, zArr2, j3);
    }

    public long r() {
        return this.f6951j;
    }

    public void s(MediaPeriod.Callback callback, long j2) {
        this.f6948g = callback;
        MediaPeriod mediaPeriod = this.f6947f;
        if (mediaPeriod != null) {
            mediaPeriod.s(this, u(this.f6944c));
        }
    }

    public long t() {
        return this.f6944c;
    }

    /* renamed from: v */
    public void p(MediaPeriod mediaPeriod) {
        ((MediaPeriod.Callback) Util.i(this.f6948g)).p(this);
    }

    public void w(long j2) {
        this.f6951j = j2;
    }

    public void x() {
        if (this.f6947f != null) {
            ((MediaSource) Assertions.f(this.f6946e)).l(this.f6947f);
        }
    }

    public void y(MediaSource mediaSource) {
        boolean z2;
        if (this.f6946e == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.h(z2);
        this.f6946e = mediaSource;
    }
}
