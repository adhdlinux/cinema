package com.iab.omid.library.adcolony.adsession;

import android.view.View;
import com.iab.omid.library.adcolony.b.c;
import com.iab.omid.library.adcolony.b.f;
import com.iab.omid.library.adcolony.d.e;
import com.iab.omid.library.adcolony.publisher.AdSessionStatePublisher;
import com.iab.omid.library.adcolony.publisher.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;
import org.json.JSONObject;

public class a extends AdSession {

    /* renamed from: k  reason: collision with root package name */
    private static final Pattern f31342k = Pattern.compile("^[a-zA-Z0-9 ]+$");

    /* renamed from: a  reason: collision with root package name */
    private final AdSessionContext f31343a;

    /* renamed from: b  reason: collision with root package name */
    private final AdSessionConfiguration f31344b;

    /* renamed from: c  reason: collision with root package name */
    private final List<c> f31345c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private com.iab.omid.library.adcolony.e.a f31346d;

    /* renamed from: e  reason: collision with root package name */
    private AdSessionStatePublisher f31347e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f31348f = false;

    /* renamed from: g  reason: collision with root package name */
    private boolean f31349g = false;

    /* renamed from: h  reason: collision with root package name */
    private final String f31350h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f31351i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f31352j;

    a(AdSessionConfiguration adSessionConfiguration, AdSessionContext adSessionContext) {
        this.f31344b = adSessionConfiguration;
        this.f31343a = adSessionContext;
        this.f31350h = UUID.randomUUID().toString();
        p((View) null);
        this.f31347e = (adSessionContext.c() == AdSessionContextType.HTML || adSessionContext.c() == AdSessionContextType.JAVASCRIPT) ? new com.iab.omid.library.adcolony.publisher.a(adSessionContext.j()) : new b(adSessionContext.f(), adSessionContext.g());
        this.f31347e.a();
        com.iab.omid.library.adcolony.b.a.a().b(this);
        this.f31347e.e(adSessionConfiguration);
    }

    private void A() {
        if (this.f31352j) {
            throw new IllegalStateException("Loaded event can only be sent once");
        }
    }

    private c h(View view) {
        for (c next : this.f31345c) {
            if (next.a().get() == view) {
                return next;
            }
        }
        return null;
    }

    private void j(String str) {
        if (str == null) {
            return;
        }
        if (str.length() > 50) {
            throw new IllegalArgumentException("FriendlyObstruction has detailed reason over 50 characters in length");
        } else if (!f31342k.matcher(str).matches()) {
            throw new IllegalArgumentException("FriendlyObstruction has detailed reason that contains characters not in [a-z][A-Z][0-9] or space");
        }
    }

    private static void m(View view) {
        if (view == null) {
            throw new IllegalArgumentException("FriendlyObstruction is null");
        }
    }

    private void p(View view) {
        this.f31346d = new com.iab.omid.library.adcolony.e.a(view);
    }

    private void r(View view) {
        Collection<a> c2 = com.iab.omid.library.adcolony.b.a.a().c();
        if (c2 != null && !c2.isEmpty()) {
            for (a next : c2) {
                if (next != this && next.s() == view) {
                    next.f31346d.clear();
                }
            }
        }
    }

    private void z() {
        if (this.f31351i) {
            throw new IllegalStateException("Impression event can only be sent once");
        }
    }

    public void B() {
        if (!this.f31349g) {
            this.f31345c.clear();
        }
    }

    public void a(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, String str) {
        if (!this.f31349g) {
            m(view);
            j(str);
            if (h(view) == null) {
                this.f31345c.add(new c(view, friendlyObstructionPurpose, str));
            }
        }
    }

    public void c(ErrorType errorType, String str) {
        if (!this.f31349g) {
            e.d(errorType, "Error type is null");
            e.f(str, "Message is null");
            v().f(errorType, str);
            return;
        }
        throw new IllegalStateException("AdSession is finished");
    }

    public void d() {
        if (!this.f31349g) {
            this.f31346d.clear();
            B();
            this.f31349g = true;
            v().t();
            com.iab.omid.library.adcolony.b.a.a().f(this);
            v().o();
            this.f31347e = null;
        }
    }

    public String e() {
        return this.f31350h;
    }

    public void f(View view) {
        if (!this.f31349g) {
            e.d(view, "AdView is null");
            if (s() != view) {
                p(view);
                v().x();
                r(view);
            }
        }
    }

    public void g() {
        if (!this.f31348f) {
            this.f31348f = true;
            com.iab.omid.library.adcolony.b.a.a().d(this);
            this.f31347e.b(f.a().e());
            this.f31347e.g(this, this.f31343a);
        }
    }

    public List<c> i() {
        return this.f31345c;
    }

    public void k(List<com.iab.omid.library.adcolony.e.a> list) {
        if (n()) {
            ArrayList arrayList = new ArrayList();
            for (com.iab.omid.library.adcolony.e.a aVar : list) {
                View view = (View) aVar.get();
                if (view != null) {
                    arrayList.add(view);
                }
            }
            throw null;
        }
    }

    /* access modifiers changed from: package-private */
    public void l(JSONObject jSONObject) {
        A();
        v().m(jSONObject);
        this.f31352j = true;
    }

    public boolean n() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public void o() {
        z();
        v().u();
        this.f31351i = true;
    }

    /* access modifiers changed from: package-private */
    public void q() {
        A();
        v().w();
        this.f31352j = true;
    }

    public View s() {
        return (View) this.f31346d.get();
    }

    public boolean t() {
        return this.f31348f && !this.f31349g;
    }

    public boolean u() {
        return this.f31348f;
    }

    public AdSessionStatePublisher v() {
        return this.f31347e;
    }

    public boolean w() {
        return this.f31349g;
    }

    public boolean x() {
        return this.f31344b.b();
    }

    public boolean y() {
        return this.f31344b.c();
    }
}
