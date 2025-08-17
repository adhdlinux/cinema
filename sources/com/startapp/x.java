package com.startapp;

import android.provider.Settings;
import android.view.View;
import com.iab.omid.library.startio.adsession.AdSessionContextType;
import com.iab.omid.library.startio.adsession.Owner;
import com.iab.omid.library.startio.publisher.AdSessionStatePublisher;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

public class x extends s {

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f36845a = Pattern.compile("^[a-zA-Z0-9 ]+$");

    /* renamed from: b  reason: collision with root package name */
    public final u f36846b;

    /* renamed from: c  reason: collision with root package name */
    public final t f36847c;

    /* renamed from: d  reason: collision with root package name */
    public final List<i> f36848d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public ng f36849e;

    /* renamed from: f  reason: collision with root package name */
    public AdSessionStatePublisher f36850f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f36851g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f36852h = false;

    /* renamed from: i  reason: collision with root package name */
    public final String f36853i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f36854j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f36855k;

    public x(t tVar, u uVar) {
        this.f36847c = tVar;
        this.f36846b = uVar;
        this.f36853i = UUID.randomUUID().toString();
        a((View) null);
        this.f36850f = (uVar.a() == AdSessionContextType.HTML || uVar.a() == AdSessionContextType.JAVASCRIPT) ? new b0(uVar.d()) : new c0(uVar.b(), uVar.c());
        this.f36850f.d();
        g.a().a(this);
        this.f36850f.a(tVar);
    }

    public void a() {
        if (!this.f36851g) {
            this.f36851g = true;
            g gVar = g.f34545a;
            boolean b2 = gVar.b();
            gVar.f34547c.add(this);
            if (!b2) {
                m a2 = m.a();
                a2.getClass();
                h hVar = h.f34604a;
                hVar.f34607d = a2;
                hVar.f34605b = true;
                hVar.f34606c = false;
                hVar.a();
                d0.f34311a.a();
                e eVar = a2.f34889e;
                eVar.f34391e = eVar.a();
                eVar.b();
                eVar.f34387a.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, eVar);
            }
            float f2 = m.a().f34886b;
            AdSessionStatePublisher adSessionStatePublisher = this.f36850f;
            l.f34848a.a(adSessionStatePublisher.c(), "setDeviceVolume", Float.valueOf(f2));
            this.f36850f.a(this, this.f36846b);
        }
    }

    public final void a(View view) {
        this.f36849e = new ng((View) null);
    }

    public View b() {
        return (View) this.f36849e.get();
    }

    public boolean c() {
        return this.f36851g && !this.f36852h;
    }

    public boolean d() {
        if (Owner.NATIVE == this.f36847c.f36536a) {
            return true;
        }
        return false;
    }

    public boolean e() {
        if (Owner.NATIVE == this.f36847c.f36537b) {
            return true;
        }
        return false;
    }
}
