package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Timeline;

public abstract class ForwardingTimeline extends Timeline {

    /* renamed from: g  reason: collision with root package name */
    protected final Timeline f25751g;

    public ForwardingTimeline(Timeline timeline) {
        this.f25751g = timeline;
    }

    public int e(boolean z2) {
        return this.f25751g.e(z2);
    }

    public int f(Object obj) {
        return this.f25751g.f(obj);
    }

    public int g(boolean z2) {
        return this.f25751g.g(z2);
    }

    public int i(int i2, int i3, boolean z2) {
        return this.f25751g.i(i2, i3, z2);
    }

    public Timeline.Period k(int i2, Timeline.Period period, boolean z2) {
        return this.f25751g.k(i2, period, z2);
    }

    public int m() {
        return this.f25751g.m();
    }

    public int p(int i2, int i3, boolean z2) {
        return this.f25751g.p(i2, i3, z2);
    }

    public Object q(int i2) {
        return this.f25751g.q(i2);
    }

    public Timeline.Window s(int i2, Timeline.Window window, long j2) {
        return this.f25751g.s(i2, window, j2);
    }

    public int t() {
        return this.f25751g.t();
    }
}
