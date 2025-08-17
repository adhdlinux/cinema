package com.chartboost.sdk.impl;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.chartboost.sdk.impl.td;
import com.chartboost.sdk.impl.wd;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public class ac implements td.a {

    /* renamed from: i  reason: collision with root package name */
    public static ac f17225i = new ac();

    /* renamed from: j  reason: collision with root package name */
    public static Handler f17226j = new Handler(Looper.getMainLooper());

    /* renamed from: k  reason: collision with root package name */
    public static Handler f17227k = null;

    /* renamed from: l  reason: collision with root package name */
    public static final Runnable f17228l = new b();

    /* renamed from: m  reason: collision with root package name */
    public static final Runnable f17229m = new c();

    /* renamed from: a  reason: collision with root package name */
    public List f17230a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public int f17231b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f17232c = false;

    /* renamed from: d  reason: collision with root package name */
    public final List f17233d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public de f17234e = new de();

    /* renamed from: f  reason: collision with root package name */
    public wd f17235f = new wd();

    /* renamed from: g  reason: collision with root package name */
    public fe f17236g = new fe(new oe());

    /* renamed from: h  reason: collision with root package name */
    public long f17237h;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            ac.this.f17236g.b();
        }
    }

    public class b implements Runnable {
        public void run() {
            ac.h().m();
        }
    }

    public class c implements Runnable {
        public void run() {
            if (ac.f17227k != null) {
                ac.f17227k.post(ac.f17228l);
                ac.f17227k.postDelayed(ac.f17229m, 200);
            }
        }
    }

    public static ac h() {
        return f17225i;
    }

    public final void d() {
        a(ze.b() - this.f17237h);
    }

    public final void e() {
        this.f17231b = 0;
        this.f17233d.clear();
        this.f17232c = false;
        Iterator it2 = ke.c().a().iterator();
        while (true) {
            if (it2.hasNext()) {
                if (((qd) it2.next()).g()) {
                    this.f17232c = true;
                    break;
                }
            } else {
                break;
            }
        }
        this.f17237h = ze.b();
    }

    public void f() {
        this.f17235f.e();
        long b2 = ze.b();
        td a2 = this.f17234e.a();
        if (this.f17235f.b().size() > 0) {
            Iterator it2 = this.f17235f.b().iterator();
            while (it2.hasNext()) {
                String str = (String) it2.next();
                JSONObject a3 = a2.a((View) null);
                a(str, this.f17235f.a(str), a3);
                me.b(a3);
                HashSet hashSet = new HashSet();
                hashSet.add(str);
                this.f17236g.a(a3, hashSet, b2);
            }
        }
        if (this.f17235f.c().size() > 0) {
            JSONObject a4 = a2.a((View) null);
            a((View) null, a2, a4, ne.PARENT_VIEW, false);
            me.b(a4);
            this.f17236g.b(a4, this.f17235f.c(), b2);
            if (this.f17232c) {
                for (qd a5 : ke.c().a()) {
                    a5.a(this.f17233d);
                }
            }
        } else {
            this.f17236g.b();
        }
        this.f17235f.a();
    }

    public void g() {
        l();
    }

    public void i() {
        j();
    }

    public final void j() {
        if (f17227k == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            f17227k = handler;
            handler.post(f17228l);
            f17227k.postDelayed(f17229m, 200);
        }
    }

    public void k() {
        g();
        this.f17230a.clear();
        f17226j.post(new a());
    }

    public final void l() {
        Handler handler = f17227k;
        if (handler != null) {
            handler.removeCallbacks(f17229m);
            f17227k = null;
        }
    }

    public final void m() {
        e();
        f();
        d();
    }

    public final void a(long j2) {
        if (this.f17230a.size() > 0) {
            Iterator it2 = this.f17230a.iterator();
            if (it2.hasNext()) {
                zb.a(it2.next());
                TimeUnit.NANOSECONDS.toMillis(j2);
                throw null;
            }
        }
    }

    public final boolean b(View view, JSONObject jSONObject) {
        String d2 = this.f17235f.d(view);
        if (d2 == null) {
            return false;
        }
        me.a(jSONObject, d2);
        me.a(jSONObject, Boolean.valueOf(this.f17235f.f(view)));
        this.f17235f.d();
        return true;
    }

    public final void a(View view, td tdVar, JSONObject jSONObject, ne neVar, boolean z2) {
        tdVar.a(view, jSONObject, this, neVar == ne.PARENT_VIEW, z2);
    }

    public void a(View view, td tdVar, JSONObject jSONObject, boolean z2) {
        ne e2;
        if (ef.d(view) && (e2 = this.f17235f.e(view)) != ne.UNDERLYING_VIEW) {
            JSONObject a2 = tdVar.a(view);
            me.a(jSONObject, a2);
            if (!b(view, a2)) {
                boolean z3 = z2 || a(view, a2);
                if (this.f17232c && e2 == ne.OBSTRUCTION_VIEW && !z3) {
                    this.f17233d.add(new yd(view));
                }
                a(view, tdVar, a2, e2, z3);
            }
            this.f17231b++;
        }
    }

    public final void a(String str, View view, JSONObject jSONObject) {
        td b2 = this.f17234e.b();
        String b3 = this.f17235f.b(str);
        if (b3 != null) {
            JSONObject a2 = b2.a(view);
            me.a(a2, str);
            me.b(a2, b3);
            me.a(jSONObject, a2);
        }
    }

    public final boolean a(View view, JSONObject jSONObject) {
        wd.a c2 = this.f17235f.c(view);
        if (c2 == null) {
            return false;
        }
        me.a(jSONObject, c2);
        return true;
    }
}
