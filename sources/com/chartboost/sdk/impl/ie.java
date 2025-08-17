package com.chartboost.sdk.impl;

import android.content.Context;

public class ie {

    /* renamed from: a  reason: collision with root package name */
    public boolean f17963a;

    public String a() {
        return "1.4.9-Chartboost";
    }

    public void a(Context context) {
        b(context);
        if (!b()) {
            a(true);
            ff.c().a(context);
            ce.g().a(context);
            vd.a(context);
            me.a(context);
            ve.a(context);
            bf.b().a(context);
            sd.a().a(context);
        }
    }

    public final void b(Context context) {
        df.a((Object) context, "Application Context cannot be null");
    }

    public void c() {
        df.a();
        sd.a().d();
    }

    public void a(boolean z2) {
        this.f17963a = z2;
    }

    public boolean b() {
        return this.f17963a;
    }
}
