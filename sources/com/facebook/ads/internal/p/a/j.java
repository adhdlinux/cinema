package com.facebook.ads.internal.p.a;

public enum j {
    GET(true, false),
    POST(true, true);
    

    /* renamed from: c  reason: collision with root package name */
    private boolean f20467c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f20468d;

    private j(boolean z2, boolean z3) {
        this.f20467c = z2;
        this.f20468d = z3;
    }

    public boolean a() {
        return this.f20467c;
    }

    public boolean b() {
        return this.f20468d;
    }

    public String c() {
        return toString();
    }
}
