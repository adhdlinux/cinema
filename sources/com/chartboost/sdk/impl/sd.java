package com.chartboost.sdk.impl;

import android.content.Context;
import com.chartboost.sdk.impl.qe;
import java.util.Date;

public class sd implements qe.a {

    /* renamed from: f  reason: collision with root package name */
    public static sd f18603f = new sd(new qe());

    /* renamed from: a  reason: collision with root package name */
    public ze f18604a = new ze();

    /* renamed from: b  reason: collision with root package name */
    public Date f18605b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f18606c;

    /* renamed from: d  reason: collision with root package name */
    public qe f18607d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f18608e;

    public sd(qe qeVar) {
        this.f18607d = qeVar;
    }

    public static sd a() {
        return f18603f;
    }

    public Date b() {
        Date date = this.f18605b;
        if (date != null) {
            return (Date) date.clone();
        }
        return null;
    }

    public final void c() {
        if (this.f18606c && this.f18605b != null) {
            for (qd k2 : ke.c().a()) {
                k2.k().a(b());
            }
        }
    }

    public void d() {
        Date a2 = this.f18604a.a();
        Date date = this.f18605b;
        if (date == null || a2.after(date)) {
            this.f18605b = a2;
            c();
        }
    }

    public void a(Context context) {
        if (!this.f18606c) {
            this.f18607d.a(context);
            this.f18607d.a((qe.a) this);
            this.f18607d.e();
            this.f18608e = this.f18607d.c();
            this.f18606c = true;
        }
    }

    public void a(boolean z2) {
        if (!this.f18608e && z2) {
            d();
        }
        this.f18608e = z2;
    }
}
