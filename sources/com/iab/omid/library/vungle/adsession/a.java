package com.iab.omid.library.vungle.adsession;

import android.view.View;
import com.iab.omid.library.vungle.internal.c;
import com.iab.omid.library.vungle.internal.e;
import com.iab.omid.library.vungle.internal.f;
import com.iab.omid.library.vungle.internal.i;
import com.iab.omid.library.vungle.publisher.AdSessionStatePublisher;
import com.iab.omid.library.vungle.publisher.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

public class a extends AdSession {

    /* renamed from: a  reason: collision with root package name */
    private final AdSessionContext f31682a;

    /* renamed from: b  reason: collision with root package name */
    private final AdSessionConfiguration f31683b;

    /* renamed from: c  reason: collision with root package name */
    private final f f31684c;

    /* renamed from: d  reason: collision with root package name */
    private com.iab.omid.library.vungle.weakreference.a f31685d;

    /* renamed from: e  reason: collision with root package name */
    private AdSessionStatePublisher f31686e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f31687f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f31688g;

    /* renamed from: h  reason: collision with root package name */
    private final String f31689h;

    a(AdSessionConfiguration adSessionConfiguration, AdSessionContext adSessionContext) {
        this(adSessionConfiguration, adSessionContext, UUID.randomUUID().toString());
    }

    a(AdSessionConfiguration adSessionConfiguration, AdSessionContext adSessionContext, String str) {
        this.f31684c = new f();
        this.f31687f = false;
        this.f31688g = false;
        this.f31683b = adSessionConfiguration;
        this.f31682a = adSessionContext;
        this.f31689h = str;
        g((View) null);
        this.f31686e = (adSessionContext.b() == AdSessionContextType.HTML || adSessionContext.b() == AdSessionContextType.JAVASCRIPT) ? new com.iab.omid.library.vungle.publisher.a(str, adSessionContext.i()) : new b(str, adSessionContext.e(), adSessionContext.f());
        this.f31686e.p();
        c.e().b(this);
        this.f31686e.d(adSessionConfiguration);
    }

    private void e(View view) {
        Collection<a> c2 = c.e().c();
        if (c2 != null && !c2.isEmpty()) {
            for (a next : c2) {
                if (next != this && next.h() == view) {
                    next.f31685d.clear();
                }
            }
        }
    }

    private void g(View view) {
        this.f31685d = new com.iab.omid.library.vungle.weakreference.a(view);
    }

    public void b() {
        if (!this.f31688g) {
            this.f31685d.clear();
            n();
            this.f31688g = true;
            m().n();
            c.e().d(this);
            m().j();
            this.f31686e = null;
        }
    }

    public void c(View view) {
        if (!this.f31688g && h() != view) {
            g(view);
            m().a();
            e(view);
        }
    }

    public void d() {
        if (!this.f31687f && this.f31686e != null) {
            this.f31687f = true;
            c.e().f(this);
            this.f31686e.b(i.d().c());
            this.f31686e.h(com.iab.omid.library.vungle.internal.a.a().c());
            this.f31686e.e(this, this.f31682a);
        }
    }

    public void f(List<com.iab.omid.library.vungle.weakreference.a> list) {
        if (j()) {
            ArrayList arrayList = new ArrayList();
            for (com.iab.omid.library.vungle.weakreference.a aVar : list) {
                View view = (View) aVar.get();
                if (view != null) {
                    arrayList.add(view);
                }
            }
            throw null;
        }
    }

    public View h() {
        return (View) this.f31685d.get();
    }

    public List<e> i() {
        return this.f31684c.a();
    }

    public boolean j() {
        return false;
    }

    public boolean k() {
        return this.f31687f && !this.f31688g;
    }

    public String l() {
        return this.f31689h;
    }

    public AdSessionStatePublisher m() {
        return this.f31686e;
    }

    public void n() {
        if (!this.f31688g) {
            this.f31684c.b();
        }
    }
}
