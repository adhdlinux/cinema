package androidx.media3.exoplayer.source;

import androidx.media3.common.Timeline;

public abstract class ForwardingTimeline extends Timeline {

    /* renamed from: e  reason: collision with root package name */
    protected final Timeline f6929e;

    public ForwardingTimeline(Timeline timeline) {
        this.f6929e = timeline;
    }

    public int a(boolean z2) {
        return this.f6929e.a(z2);
    }

    public int b(Object obj) {
        return this.f6929e.b(obj);
    }

    public int c(boolean z2) {
        return this.f6929e.c(z2);
    }

    public int e(int i2, int i3, boolean z2) {
        return this.f6929e.e(i2, i3, z2);
    }

    public Timeline.Period g(int i2, Timeline.Period period, boolean z2) {
        return this.f6929e.g(i2, period, z2);
    }

    public int i() {
        return this.f6929e.i();
    }

    public int l(int i2, int i3, boolean z2) {
        return this.f6929e.l(i2, i3, z2);
    }

    public Object m(int i2) {
        return this.f6929e.m(i2);
    }

    public Timeline.Window o(int i2, Timeline.Window window, long j2) {
        return this.f6929e.o(i2, window, j2);
    }

    public int p() {
        return this.f6929e.p();
    }
}
