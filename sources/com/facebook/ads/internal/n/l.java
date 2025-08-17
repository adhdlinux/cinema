package com.facebook.ads.internal.n;

public enum l {
    HEIGHT_100(-1, 100),
    HEIGHT_120(-1, 120),
    HEIGHT_300(-1, 300),
    HEIGHT_400(-1, 400);
    

    /* renamed from: e  reason: collision with root package name */
    private final int f20395e;

    /* renamed from: f  reason: collision with root package name */
    private final int f20396f;

    private l(int i2, int i3) {
        this.f20395e = i2;
        this.f20396f = i3;
    }

    public int a() {
        return this.f20395e;
    }

    public int b() {
        return this.f20396f;
    }

    public int c() {
        int i2 = this.f20396f;
        if (i2 == 100) {
            return 1;
        }
        if (i2 == 120) {
            return 2;
        }
        if (i2 != 300) {
            return i2 != 400 ? -1 : 4;
        }
        return 3;
    }
}
