package com.iab.omid.library.vungle.internal;

import android.content.Context;
import com.iab.omid.library.vungle.internal.d;
import com.iab.omid.library.vungle.utils.f;
import java.util.Date;

public class a implements d.a {

    /* renamed from: f  reason: collision with root package name */
    private static a f31696f = new a(new d());

    /* renamed from: a  reason: collision with root package name */
    protected f f31697a = new f();

    /* renamed from: b  reason: collision with root package name */
    private Date f31698b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f31699c;

    /* renamed from: d  reason: collision with root package name */
    private d f31700d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f31701e;

    private a(d dVar) {
        this.f31700d = dVar;
    }

    public static a a() {
        return f31696f;
    }

    private void d() {
        if (this.f31699c && this.f31698b != null) {
            for (com.iab.omid.library.vungle.adsession.a m2 : c.e().a()) {
                m2.m().h(c());
            }
        }
    }

    public void a(boolean z2) {
        if (!this.f31701e && z2) {
            e();
        }
        this.f31701e = z2;
    }

    public void b(Context context) {
        if (!this.f31699c) {
            this.f31700d.a(context);
            this.f31700d.b(this);
            this.f31700d.i();
            this.f31701e = this.f31700d.g();
            this.f31699c = true;
        }
    }

    public Date c() {
        Date date = this.f31698b;
        if (date != null) {
            return (Date) date.clone();
        }
        return null;
    }

    public void e() {
        Date a2 = this.f31697a.a();
        Date date = this.f31698b;
        if (date == null || a2.after(date)) {
            this.f31698b = a2;
            d();
        }
    }
}
