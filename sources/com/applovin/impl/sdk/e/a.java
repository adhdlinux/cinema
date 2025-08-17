package com.applovin.impl.sdk.e;

import android.content.Context;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.v;

public abstract class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final String f15332a;
    /* access modifiers changed from: protected */

    /* renamed from: b  reason: collision with root package name */
    public final m f15333b;

    /* renamed from: c  reason: collision with root package name */
    private final v f15334c;

    /* renamed from: d  reason: collision with root package name */
    private final Context f15335d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f15336e;

    public a(String str, m mVar) {
        this(str, mVar, false);
    }

    public a(String str, m mVar, boolean z2) {
        this.f15332a = str;
        this.f15333b = mVar;
        this.f15334c = mVar.A();
        this.f15335d = mVar.L();
        this.f15336e = z2;
    }

    /* access modifiers changed from: protected */
    public void a(String str) {
        this.f15334c.b(this.f15332a, str);
    }

    /* access modifiers changed from: protected */
    public void a(String str, Throwable th) {
        this.f15334c.b(this.f15332a, str, th);
    }

    /* access modifiers changed from: protected */
    public void b(String str) {
        this.f15334c.c(this.f15332a, str);
    }

    /* access modifiers changed from: protected */
    public void c(String str) {
        this.f15334c.d(this.f15332a, str);
    }

    /* access modifiers changed from: protected */
    public m d() {
        return this.f15333b;
    }

    /* access modifiers changed from: protected */
    public void d(String str) {
        this.f15334c.e(this.f15332a, str);
    }

    public String e() {
        return this.f15332a;
    }

    /* access modifiers changed from: protected */
    public Context f() {
        return this.f15335d;
    }

    public boolean g() {
        return this.f15336e;
    }
}
