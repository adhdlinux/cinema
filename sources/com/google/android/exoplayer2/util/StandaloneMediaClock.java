package com.google.android.exoplayer2.util;

import com.google.android.exoplayer2.PlaybackParameters;

public final class StandaloneMediaClock implements MediaClock {

    /* renamed from: b  reason: collision with root package name */
    private final Clock f28791b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f28792c;

    /* renamed from: d  reason: collision with root package name */
    private long f28793d;

    /* renamed from: e  reason: collision with root package name */
    private long f28794e;

    /* renamed from: f  reason: collision with root package name */
    private PlaybackParameters f28795f = PlaybackParameters.f23395e;

    public StandaloneMediaClock(Clock clock) {
        this.f28791b = clock;
    }

    public void a(long j2) {
        this.f28793d = j2;
        if (this.f28792c) {
            this.f28794e = this.f28791b.elapsedRealtime();
        }
    }

    public PlaybackParameters b() {
        return this.f28795f;
    }

    public void c() {
        if (!this.f28792c) {
            this.f28794e = this.f28791b.elapsedRealtime();
            this.f28792c = true;
        }
    }

    public void d() {
        if (this.f28792c) {
            a(n());
            this.f28792c = false;
        }
    }

    public void e(PlaybackParameters playbackParameters) {
        if (this.f28792c) {
            a(n());
        }
        this.f28795f = playbackParameters;
    }

    public long n() {
        long j2;
        long j3 = this.f28793d;
        if (!this.f28792c) {
            return j3;
        }
        long elapsedRealtime = this.f28791b.elapsedRealtime() - this.f28794e;
        PlaybackParameters playbackParameters = this.f28795f;
        if (playbackParameters.f23399b == 1.0f) {
            j2 = Util.F0(elapsedRealtime);
        } else {
            j2 = playbackParameters.b(elapsedRealtime);
        }
        return j3 + j2;
    }
}
