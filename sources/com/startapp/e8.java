package com.startapp;

import com.startapp.sdk.adsbase.StartAppSDKInternal;
import com.startapp.sdk.adsbase.cache.CacheMetaData;
import com.startapp.sdk.adsbase.cache.FailuresHandler;
import java.util.concurrent.TimeUnit;

public class e8 extends f8 {

    /* renamed from: e  reason: collision with root package name */
    public final FailuresHandler f34450e = CacheMetaData.b().a().c();

    /* renamed from: f  reason: collision with root package name */
    public int f34451f = 0;

    /* renamed from: g  reason: collision with root package name */
    public boolean f34452g = false;

    public e8(j8 j8Var) {
        super(j8Var);
    }

    public boolean a() {
        boolean z2;
        boolean z3;
        String str = StartAppSDKInternal.f36218a;
        StartAppSDKInternal startAppSDKInternal = StartAppSDKInternal.c.f36252a;
        if (!startAppSDKInternal.f36223f || startAppSDKInternal.f36224g || startAppSDKInternal.f36226i) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (!z2) {
            return false;
        }
        FailuresHandler failuresHandler = this.f34450e;
        if (failuresHandler == null || failuresHandler.a() == null) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (!z3) {
            return false;
        }
        if (this.f34452g) {
            return this.f34450e.b();
        }
        return true;
    }

    public long b() {
        Long l2;
        if (this.f34451f >= this.f34450e.a().size() || (l2 = this.f34521c) == null) {
            return -1;
        }
        long millis = TimeUnit.SECONDS.toMillis((long) this.f34450e.a().get(this.f34451f).intValue()) - (System.currentTimeMillis() - l2.longValue());
        if (millis >= 0) {
            return millis;
        }
        return 0;
    }

    public void c() {
        if (this.f34451f == this.f34450e.a().size() - 1) {
            this.f34452g = true;
        } else {
            this.f34451f++;
        }
        super.c();
    }

    public void f() {
        e();
        this.f34451f = 0;
        this.f34452g = false;
    }
}
