package com.chartboost.sdk.impl;

import android.util.Log;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

public final class vc {

    /* renamed from: a  reason: collision with root package name */
    public long f18868a;

    /* renamed from: b  reason: collision with root package name */
    public int f18869b;

    /* renamed from: c  reason: collision with root package name */
    public int f18870c;

    /* renamed from: d  reason: collision with root package name */
    public long f18871d;

    /* renamed from: e  reason: collision with root package name */
    public long f18872e;

    /* renamed from: f  reason: collision with root package name */
    public long f18873f;

    /* renamed from: g  reason: collision with root package name */
    public int f18874g;

    /* renamed from: h  reason: collision with root package name */
    public final r2 f18875h;

    /* renamed from: i  reason: collision with root package name */
    public volatile long f18876i;

    /* renamed from: j  reason: collision with root package name */
    public volatile int f18877j;

    public vc(long j2, int i2, int i3, long j3, long j4, long j5, int i4, r2 r2Var) {
        this.f18868a = j2;
        this.f18869b = i2;
        this.f18870c = i3;
        this.f18871d = j3;
        this.f18872e = j4;
        this.f18873f = j5;
        this.f18874g = i4;
        this.f18875h = r2Var;
    }

    public final void a(int i2) {
        this.f18874g = i2;
    }

    public final long b() {
        return this.f18868a;
    }

    public final void c(long j2) {
        this.f18868a = j2;
    }

    public final void d(long j2) {
        this.f18871d = j2;
    }

    public final void e(long j2) {
        this.f18872e = j2;
    }

    public final void f(long j2) {
        this.f18873f = j2;
    }

    public final boolean g() {
        boolean z2;
        h();
        if (this.f18877j >= c()) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            la.a("Video loading limit reached, will resume in timeToResetWindow: " + d());
        }
        String a2 = wc.f18906a;
        Log.d(a2, "isMaxCountForTimeWindowReached() - " + z2);
        return z2;
    }

    public final void h() {
        Log.d(wc.f18906a, "resetWindowWhenTimeReached()");
        if (e() > f()) {
            Log.d(wc.f18906a, "resetWindowWhenTimeReached() - timer and count reset");
            la.a("Video loading limit reset");
            this.f18877j = 0;
            this.f18876i = 0;
        }
    }

    public final long i() {
        return f() - (ab.a() - this.f18876i);
    }

    public final void a() {
        Log.d(wc.f18906a, "addDownloadToTimeWindow() - timeWindowStartTimeStamp " + this.f18876i + ", timeWindowCachedVideosCount " + this.f18877j);
        if (this.f18876i == 0) {
            this.f18876i = ab.a();
        }
        this.f18877j++;
    }

    public final void b(int i2) {
        this.f18869b = i2;
    }

    public final void c(int i2) {
        this.f18870c = i2;
    }

    public final long d() {
        return f() - e();
    }

    public final long e() {
        return ab.a() - this.f18876i;
    }

    public final long f() {
        r2 r2Var = this.f18875h;
        return ((r2Var == null || !r2Var.d()) ? this.f18871d : this.f18872e) * ((long) 1000);
    }

    public final boolean b(long j2) {
        return j2 >= this.f18868a;
    }

    public final int c() {
        r2 r2Var = this.f18875h;
        if (r2Var == null || !r2Var.d()) {
            return this.f18869b;
        }
        return this.f18870c;
    }

    public final boolean a(File file) {
        Intrinsics.f(file, "file");
        return a(file.lastModified());
    }

    public final boolean a(long j2) {
        return ab.a() - j2 > this.f18873f * ((long) 1000);
    }
}
