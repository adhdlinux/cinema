package com.facebook.ads.internal.p.b.a;

import java.io.File;

public class g extends e {

    /* renamed from: a  reason: collision with root package name */
    private final long f20485a;

    public g(long j2) {
        if (j2 > 0) {
            this.f20485a = j2;
            return;
        }
        throw new IllegalArgumentException("Max size must be positive number!");
    }

    public /* bridge */ /* synthetic */ void a(File file) {
        super.a(file);
    }

    /* access modifiers changed from: protected */
    public boolean a(File file, long j2, int i2) {
        return j2 <= this.f20485a;
    }
}
