package androidx.media3.exoplayer;

import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Clock;

final class DefaultMediaClock implements MediaClock {

    /* renamed from: b  reason: collision with root package name */
    private final StandaloneMediaClock f5216b;

    /* renamed from: c  reason: collision with root package name */
    private final PlaybackParametersListener f5217c;

    /* renamed from: d  reason: collision with root package name */
    private Renderer f5218d;

    /* renamed from: e  reason: collision with root package name */
    private MediaClock f5219e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f5220f = true;

    /* renamed from: g  reason: collision with root package name */
    private boolean f5221g;

    public interface PlaybackParametersListener {
        void r(PlaybackParameters playbackParameters);
    }

    public DefaultMediaClock(PlaybackParametersListener playbackParametersListener, Clock clock) {
        this.f5217c = playbackParametersListener;
        this.f5216b = new StandaloneMediaClock(clock);
    }

    private boolean f(boolean z2) {
        Renderer renderer = this.f5218d;
        if (renderer == null || renderer.a() || ((z2 && this.f5218d.getState() != 2) || (!this.f5218d.isReady() && (z2 || this.f5218d.g())))) {
            return true;
        }
        return false;
    }

    private void j(boolean z2) {
        if (f(z2)) {
            this.f5220f = true;
            if (this.f5221g) {
                this.f5216b.c();
                return;
            }
            return;
        }
        MediaClock mediaClock = (MediaClock) Assertions.f(this.f5219e);
        long n2 = mediaClock.n();
        if (this.f5220f) {
            if (n2 < this.f5216b.n()) {
                this.f5216b.d();
                return;
            }
            this.f5220f = false;
            if (this.f5221g) {
                this.f5216b.c();
            }
        }
        this.f5216b.a(n2);
        PlaybackParameters b2 = mediaClock.b();
        if (!b2.equals(this.f5216b.b())) {
            this.f5216b.e(b2);
            this.f5217c.r(b2);
        }
    }

    public void a(Renderer renderer) {
        if (renderer == this.f5218d) {
            this.f5219e = null;
            this.f5218d = null;
            this.f5220f = true;
        }
    }

    public PlaybackParameters b() {
        MediaClock mediaClock = this.f5219e;
        if (mediaClock != null) {
            return mediaClock.b();
        }
        return this.f5216b.b();
    }

    public void c(Renderer renderer) throws ExoPlaybackException {
        MediaClock mediaClock;
        MediaClock s2 = renderer.s();
        if (s2 != null && s2 != (mediaClock = this.f5219e)) {
            if (mediaClock == null) {
                this.f5219e = s2;
                this.f5218d = renderer;
                s2.e(this.f5216b.b());
                return;
            }
            throw ExoPlaybackException.f(new IllegalStateException("Multiple renderer media clocks enabled."), 1000);
        }
    }

    public void d(long j2) {
        this.f5216b.a(j2);
    }

    public void e(PlaybackParameters playbackParameters) {
        MediaClock mediaClock = this.f5219e;
        if (mediaClock != null) {
            mediaClock.e(playbackParameters);
            playbackParameters = this.f5219e.b();
        }
        this.f5216b.e(playbackParameters);
    }

    public void g() {
        this.f5221g = true;
        this.f5216b.c();
    }

    public void h() {
        this.f5221g = false;
        this.f5216b.d();
    }

    public long i(boolean z2) {
        j(z2);
        return n();
    }

    public long n() {
        if (this.f5220f) {
            return this.f5216b.n();
        }
        return ((MediaClock) Assertions.f(this.f5219e)).n();
    }

    public boolean w() {
        if (this.f5220f) {
            return this.f5216b.w();
        }
        return ((MediaClock) Assertions.f(this.f5219e)).w();
    }
}
