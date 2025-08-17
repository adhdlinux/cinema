package com.startapp;

import android.content.Context;
import com.startapp.sdk.components.ComponentLocator;

public class y8 {

    /* renamed from: a  reason: collision with root package name */
    public final z8 f36951a;

    /* renamed from: b  reason: collision with root package name */
    public final long f36952b;

    /* renamed from: c  reason: collision with root package name */
    public String f36953c;

    /* renamed from: d  reason: collision with root package name */
    public String f36954d;

    /* renamed from: e  reason: collision with root package name */
    public String f36955e;

    /* renamed from: f  reason: collision with root package name */
    public Object f36956f;

    /* renamed from: g  reason: collision with root package name */
    public String f36957g;

    /* renamed from: h  reason: collision with root package name */
    public Long f36958h;

    /* renamed from: i  reason: collision with root package name */
    public String f36959i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f36960j;

    /* renamed from: k  reason: collision with root package name */
    public String f36961k;

    public y8(z8 z8Var) {
        if (z8Var != z8.f36997d) {
            this.f36951a = z8Var;
        } else {
            this.f36951a = z8.f36996c;
        }
        z8 z8Var2 = this.f36951a;
        if (z8Var2 == z8.f36996c || z8Var2 == z8.f36995b) {
            this.f36959i = lb.a(lb.a(0));
        }
        this.f36952b = 0;
    }

    public void a(Context context) {
        Context a2 = ia.a(context);
        if (a2 != null) {
            try {
                ComponentLocator.a(a2).k().a(this, (d9) null);
            } catch (Throwable unused) {
            }
        }
    }

    public String toString() {
        return super.toString();
    }

    public void a(Context context, d9 d9Var) {
        Context a2 = ia.a(context);
        if (a2 == null) {
            d9Var.a(this, 3);
            return;
        }
        try {
            ComponentLocator.a(a2).k().a(this, d9Var);
        } catch (Throwable unused) {
            d9Var.a(this, 0);
        }
    }

    public y8(Throwable th) {
        this.f36951a = z8.f36997d;
        this.f36955e = lb.b(th);
        this.f36954d = lb.a(lb.a(th));
        this.f36959i = lb.a(lb.a(1));
        this.f36952b = 0;
    }

    public static void a(Context context, Throwable th) {
        try {
            new y8(th).a(context);
        } catch (Throwable unused) {
        }
    }

    public static void a(Context context, Throwable th, z8 z8Var) {
        try {
            new y8(th, z8Var).a(context);
        } catch (Throwable unused) {
        }
    }

    public y8(Throwable th, z8 z8Var) {
        boolean z2 = z8Var == z8.f36999f;
        this.f36951a = z8Var;
        this.f36955e = lb.b(th);
        this.f36954d = lb.a(lb.a(th));
        this.f36959i = z2 ? th.getClass().getName() : lb.a(lb.a(1));
        this.f36952b = 0;
    }

    public y8(z8 z8Var, long j2) {
        this.f36951a = z8Var;
        this.f36952b = j2;
    }
}
