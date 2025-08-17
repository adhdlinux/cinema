package androidx.media3.exoplayer;

import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.Util;
import e.v;

public final class StandaloneMediaClock implements MediaClock {

    /* renamed from: b  reason: collision with root package name */
    private final Clock f5517b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f5518c;

    /* renamed from: d  reason: collision with root package name */
    private long f5519d;

    /* renamed from: e  reason: collision with root package name */
    private long f5520e;

    /* renamed from: f  reason: collision with root package name */
    private PlaybackParameters f5521f = PlaybackParameters.f4303d;

    public StandaloneMediaClock(Clock clock) {
        this.f5517b = clock;
    }

    public void a(long j2) {
        this.f5519d = j2;
        if (this.f5518c) {
            this.f5520e = this.f5517b.elapsedRealtime();
        }
    }

    public PlaybackParameters b() {
        return this.f5521f;
    }

    public void c() {
        if (!this.f5518c) {
            this.f5520e = this.f5517b.elapsedRealtime();
            this.f5518c = true;
        }
    }

    public void d() {
        if (this.f5518c) {
            a(n());
            this.f5518c = false;
        }
    }

    public void e(PlaybackParameters playbackParameters) {
        if (this.f5518c) {
            a(n());
        }
        this.f5521f = playbackParameters;
    }

    public long n() {
        long j2;
        long j3 = this.f5519d;
        if (!this.f5518c) {
            return j3;
        }
        long elapsedRealtime = this.f5517b.elapsedRealtime() - this.f5520e;
        PlaybackParameters playbackParameters = this.f5521f;
        if (playbackParameters.f4306a == 1.0f) {
            j2 = Util.P0(elapsedRealtime);
        } else {
            j2 = playbackParameters.a(elapsedRealtime);
        }
        return j3 + j2;
    }

    public /* synthetic */ boolean w() {
        return v.a(this);
    }
}
