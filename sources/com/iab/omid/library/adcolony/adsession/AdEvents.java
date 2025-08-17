package com.iab.omid.library.adcolony.adsession;

import com.iab.omid.library.adcolony.adsession.media.VastProperties;
import com.iab.omid.library.adcolony.d.e;

public final class AdEvents {

    /* renamed from: a  reason: collision with root package name */
    private final a f31287a;

    private AdEvents(a aVar) {
        this.f31287a = aVar;
    }

    public static AdEvents a(AdSession adSession) {
        a aVar = (a) adSession;
        e.d(adSession, "AdSession is null");
        e.i(aVar);
        e.g(aVar);
        AdEvents adEvents = new AdEvents(aVar);
        aVar.v().d(adEvents);
        return adEvents;
    }

    public void b() {
        e.g(this.f31287a);
        e.k(this.f31287a);
        if (!this.f31287a.t()) {
            try {
                this.f31287a.g();
            } catch (Exception unused) {
            }
        }
        if (this.f31287a.t()) {
            this.f31287a.o();
        }
    }

    public void c() {
        e.h(this.f31287a);
        e.k(this.f31287a);
        this.f31287a.q();
    }

    public void d(VastProperties vastProperties) {
        e.d(vastProperties, "VastProperties is null");
        e.h(this.f31287a);
        e.k(this.f31287a);
        this.f31287a.l(vastProperties.a());
    }
}
