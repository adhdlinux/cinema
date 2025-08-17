package com.google.android.exoplayer2.decoder;

public abstract class Buffer {

    /* renamed from: b  reason: collision with root package name */
    private int f23935b;

    public final void e(int i2) {
        this.f23935b = i2 | this.f23935b;
    }

    public void f() {
        this.f23935b = 0;
    }

    public final void g(int i2) {
        this.f23935b = (~i2) & this.f23935b;
    }

    /* access modifiers changed from: protected */
    public final boolean h(int i2) {
        return (this.f23935b & i2) == i2;
    }

    public final boolean i() {
        return h(268435456);
    }

    public final boolean j() {
        return h(Integer.MIN_VALUE);
    }

    public final boolean k() {
        return h(4);
    }

    public final boolean l() {
        return h(134217728);
    }

    public final boolean m() {
        return h(1);
    }

    public final boolean n() {
        return h(536870912);
    }

    public final void o(int i2) {
        this.f23935b = i2;
    }
}
