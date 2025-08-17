package com.google.android.exoplayer2;

import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.MediaClock;
import com.google.android.exoplayer2.util.StandaloneMediaClock;

final class DefaultMediaClock implements MediaClock {

    /* renamed from: b  reason: collision with root package name */
    private final StandaloneMediaClock f22868b;

    /* renamed from: c  reason: collision with root package name */
    private final PlaybackParametersListener f22869c;

    /* renamed from: d  reason: collision with root package name */
    private Renderer f22870d;

    /* renamed from: e  reason: collision with root package name */
    private MediaClock f22871e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f22872f = true;

    /* renamed from: g  reason: collision with root package name */
    private boolean f22873g;

    public interface PlaybackParametersListener {
        void onPlaybackParametersChanged(PlaybackParameters playbackParameters);
    }

    public DefaultMediaClock(PlaybackParametersListener playbackParametersListener, Clock clock) {
        this.f22869c = playbackParametersListener;
        this.f22868b = new StandaloneMediaClock(clock);
    }

    private boolean f(boolean z2) {
        Renderer renderer = this.f22870d;
        if (renderer == null || renderer.a() || (!this.f22870d.isReady() && (z2 || this.f22870d.g()))) {
            return true;
        }
        return false;
    }

    private void j(boolean z2) {
        if (f(z2)) {
            this.f22872f = true;
            if (this.f22873g) {
                this.f22868b.c();
                return;
            }
            return;
        }
        MediaClock mediaClock = (MediaClock) Assertions.e(this.f22871e);
        long n2 = mediaClock.n();
        if (this.f22872f) {
            if (n2 < this.f22868b.n()) {
                this.f22868b.d();
                return;
            }
            this.f22872f = false;
            if (this.f22873g) {
                this.f22868b.c();
            }
        }
        this.f22868b.a(n2);
        PlaybackParameters b2 = mediaClock.b();
        if (!b2.equals(this.f22868b.b())) {
            this.f22868b.e(b2);
            this.f22869c.onPlaybackParametersChanged(b2);
        }
    }

    public void a(Renderer renderer) {
        if (renderer == this.f22870d) {
            this.f22871e = null;
            this.f22870d = null;
            this.f22872f = true;
        }
    }

    public PlaybackParameters b() {
        MediaClock mediaClock = this.f22871e;
        if (mediaClock != null) {
            return mediaClock.b();
        }
        return this.f22868b.b();
    }

    public void c(Renderer renderer) throws ExoPlaybackException {
        MediaClock mediaClock;
        MediaClock s2 = renderer.s();
        if (s2 != null && s2 != (mediaClock = this.f22871e)) {
            if (mediaClock == null) {
                this.f22871e = s2;
                this.f22870d = renderer;
                s2.e(this.f22868b.b());
                return;
            }
            throw ExoPlaybackException.h(new IllegalStateException("Multiple renderer media clocks enabled."));
        }
    }

    public void d(long j2) {
        this.f22868b.a(j2);
    }

    public void e(PlaybackParameters playbackParameters) {
        MediaClock mediaClock = this.f22871e;
        if (mediaClock != null) {
            mediaClock.e(playbackParameters);
            playbackParameters = this.f22871e.b();
        }
        this.f22868b.e(playbackParameters);
    }

    public void g() {
        this.f22873g = true;
        this.f22868b.c();
    }

    public void h() {
        this.f22873g = false;
        this.f22868b.d();
    }

    public long i(boolean z2) {
        j(z2);
        return n();
    }

    public long n() {
        if (this.f22872f) {
            return this.f22868b.n();
        }
        return ((MediaClock) Assertions.e(this.f22871e)).n();
    }
}
