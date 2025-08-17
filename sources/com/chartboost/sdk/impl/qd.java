package com.chartboost.sdk.impl;

import android.view.View;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

public class qd extends p {

    /* renamed from: k  reason: collision with root package name */
    public static final Pattern f18484k = Pattern.compile("^[a-zA-Z0-9 ]+$");

    /* renamed from: a  reason: collision with root package name */
    public final r f18485a;

    /* renamed from: b  reason: collision with root package name */
    public final q f18486b;

    /* renamed from: c  reason: collision with root package name */
    public final List f18487c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public yd f18488d;

    /* renamed from: e  reason: collision with root package name */
    public t f18489e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f18490f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f18491g = false;

    /* renamed from: h  reason: collision with root package name */
    public final String f18492h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f18493i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f18494j;

    public qd(q qVar, r rVar) {
        this.f18486b = qVar;
        this.f18485a = rVar;
        String uuid = UUID.randomUUID().toString();
        this.f18492h = uuid;
        e((View) null);
        this.f18489e = (rVar.a() == s.f18534c || rVar.a() == s.f18536e) ? new ud(uuid, rVar.h()) : new ae(uuid, rVar.d(), rVar.e());
        this.f18489e.j();
        ke.c().a(this);
        this.f18489e.a(qVar);
    }

    public static void b(View view) {
        if (view == null) {
            throw new IllegalArgumentException("FriendlyObstruction is null");
        }
    }

    public final void a(String str) {
        if (str == null) {
            return;
        }
        if (str.length() > 50) {
            throw new IllegalArgumentException("FriendlyObstruction has detailed reason over 50 characters in length");
        } else if (!f18484k.matcher(str).matches()) {
            throw new IllegalArgumentException("FriendlyObstruction has detailed reason that contains characters not in [a-z][A-Z][0-9] or space");
        }
    }

    public final void c() {
        if (this.f18493i) {
            throw new IllegalStateException("Impression event can only be sent once");
        }
    }

    public final void d() {
        if (this.f18494j) {
            throw new IllegalStateException("Loaded event can only be sent once");
        }
    }

    public View e() {
        return (View) this.f18488d.get();
    }

    public List f() {
        return this.f18487c;
    }

    public boolean g() {
        return false;
    }

    public boolean h() {
        return this.f18490f && !this.f18491g;
    }

    public boolean i() {
        return this.f18491g;
    }

    public String j() {
        return this.f18492h;
    }

    public t k() {
        return this.f18489e;
    }

    public boolean l() {
        return this.f18486b.a();
    }

    public boolean m() {
        return this.f18486b.b();
    }

    public boolean n() {
        return this.f18490f;
    }

    public void o() {
        c();
        k().g();
        this.f18493i = true;
    }

    public void p() {
        d();
        k().i();
        this.f18494j = true;
    }

    public void q() {
        if (!this.f18491g) {
            this.f18487c.clear();
        }
    }

    public void a(List list) {
        if (g()) {
            ArrayList arrayList = new ArrayList();
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                View view = (View) ((yd) it2.next()).get();
                if (view != null) {
                    arrayList.add(view);
                }
            }
            throw null;
        }
    }

    public void b() {
        if (!this.f18490f) {
            this.f18490f = true;
            ke.c().c(this);
            this.f18489e.a(ff.c().b());
            this.f18489e.a(sd.a().b());
            this.f18489e.a(this, this.f18485a);
        }
    }

    public final we c(View view) {
        for (we weVar : this.f18487c) {
            if (weVar.c().get() == view) {
                return weVar;
            }
        }
        return null;
    }

    public final void d(View view) {
        Collection<qd> b2 = ke.c().b();
        if (b2 != null && !b2.isEmpty()) {
            for (qd qdVar : b2) {
                if (qdVar != this && qdVar.e() == view) {
                    qdVar.f18488d.clear();
                }
            }
        }
    }

    public final void e(View view) {
        this.f18488d = new yd(view);
    }

    public void a(View view, x5 x5Var, String str) {
        if (!this.f18491g) {
            b(view);
            a(str);
            if (c(view) == null) {
                this.f18487c.add(new we(view, x5Var, str));
            }
        }
    }

    public void a() {
        if (!this.f18491g) {
            this.f18488d.clear();
            q();
            this.f18491g = true;
            k().f();
            ke.c().b(this);
            k().b();
            this.f18489e = null;
        }
    }

    public void a(View view) {
        if (!this.f18491g) {
            df.a((Object) view, "AdView is null");
            if (e() != view) {
                e(view);
                k().a();
                d(view);
            }
        }
    }
}
