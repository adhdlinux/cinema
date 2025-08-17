package com.chartboost.sdk.impl;

import android.content.SharedPreferences;
import com.chartboost.sdk.impl.u;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;

public final class ta {

    /* renamed from: a  reason: collision with root package name */
    public final SharedPreferences f18643a;

    /* renamed from: b  reason: collision with root package name */
    public String f18644b;

    /* renamed from: c  reason: collision with root package name */
    public long f18645c;

    /* renamed from: d  reason: collision with root package name */
    public int f18646d = f();

    /* renamed from: e  reason: collision with root package name */
    public int f18647e;

    /* renamed from: f  reason: collision with root package name */
    public int f18648f;

    /* renamed from: g  reason: collision with root package name */
    public int f18649g;

    public ta(SharedPreferences sharedPreferences) {
        Intrinsics.f(sharedPreferences, "mPrefs");
        this.f18643a = sharedPreferences;
    }

    public final void a() {
        this.f18644b = b();
        this.f18645c = System.currentTimeMillis();
        this.f18647e = 0;
        this.f18648f = 0;
        this.f18649g = 0;
        this.f18646d++;
        g();
    }

    public final int b(u uVar) {
        if (Intrinsics.a(uVar, u.b.f18736g)) {
            return this.f18647e;
        }
        if (Intrinsics.a(uVar, u.c.f18737g)) {
            return this.f18648f;
        }
        if (Intrinsics.a(uVar, u.a.f18735g)) {
            return this.f18649g;
        }
        return 0;
    }

    public final int c() {
        return this.f18646d;
    }

    public final long d() {
        return System.currentTimeMillis() - this.f18645c;
    }

    public final String e() {
        return this.f18644b;
    }

    public final int f() {
        return this.f18643a.getInt("session_key", 0);
    }

    public final void g() {
        SharedPreferences.Editor putInt;
        SharedPreferences.Editor edit = this.f18643a.edit();
        if (edit != null && (putInt = edit.putInt("session_key", this.f18646d)) != null) {
            putInt.apply();
        }
    }

    public final ua h() {
        return new ua(this.f18644b, d(), this.f18646d, b(u.a.f18735g), b(u.c.f18737g), b(u.b.f18736g));
    }

    public final String b() {
        String uuid = UUID.randomUUID().toString();
        Intrinsics.e(uuid, "randomUUID().toString()");
        return w1.a(uuid);
    }

    public final void a(u uVar) {
        Intrinsics.f(uVar, "type");
        if (Intrinsics.a(uVar, u.b.f18736g)) {
            this.f18647e++;
        } else if (Intrinsics.a(uVar, u.c.f18737g)) {
            this.f18648f++;
        } else if (Intrinsics.a(uVar, u.a.f18735g)) {
            this.f18649g++;
        }
    }
}
