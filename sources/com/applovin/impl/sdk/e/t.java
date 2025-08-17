package com.applovin.impl.sdk.e;

import com.applovin.impl.a.a;
import com.applovin.impl.a.c;
import com.applovin.impl.a.d;
import com.applovin.impl.a.e;
import com.applovin.impl.a.f;
import com.applovin.impl.a.i;
import com.applovin.impl.a.j;
import com.applovin.impl.a.l;
import com.applovin.impl.sdk.c.b;
import com.applovin.impl.sdk.e.o;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.r;
import com.applovin.impl.sdk.v;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdType;
import java.util.HashSet;
import java.util.Set;

class t extends a {

    /* renamed from: a  reason: collision with root package name */
    private final e f15434a;

    /* renamed from: c  reason: collision with root package name */
    private final AppLovinAdLoadListener f15435c;

    t(e eVar, AppLovinAdLoadListener appLovinAdLoadListener, m mVar) {
        super("TaskRenderVastAd", mVar);
        this.f15435c = appLovinAdLoadListener;
        this.f15434a = eVar;
    }

    public void run() {
        if (v.a()) {
            a("Rendering VAST ad...");
        }
        int size = this.f15434a.b().size();
        HashSet hashSet = new HashSet(size);
        HashSet hashSet2 = new HashSet(size);
        String str = "";
        i iVar = null;
        com.applovin.impl.a.m mVar = null;
        d dVar = null;
        c cVar = null;
        String str2 = str;
        for (r next : this.f15434a.b()) {
            r c2 = next.c(l.a(next) ? "Wrapper" : "InLine");
            if (c2 != null) {
                r c3 = c2.c("AdSystem");
                if (c3 != null) {
                    iVar = i.a(c3, iVar, this.f15333b);
                }
                str = l.a(c2, "AdTitle", str);
                str2 = l.a(c2, "Description", str2);
                l.a(c2.a("Impression"), (Set<j>) hashSet, this.f15434a, this.f15333b);
                r b2 = c2.b("ViewableImpression");
                if (b2 != null) {
                    l.a(b2.a("Viewable"), (Set<j>) hashSet, this.f15434a, this.f15333b);
                }
                r c4 = c2.c("AdVerifications");
                if (c4 != null) {
                    cVar = c.a(c4, cVar, this.f15434a, this.f15333b);
                }
                l.a(c2.a("Error"), (Set<j>) hashSet2, this.f15434a, this.f15333b);
                r b3 = c2.b("Creatives");
                if (b3 != null) {
                    for (r next2 : b3.d()) {
                        r b4 = next2.b("Linear");
                        if (b4 != null) {
                            mVar = com.applovin.impl.a.m.a(b4, mVar, this.f15434a, this.f15333b);
                        } else {
                            r c5 = next2.c("CompanionAds");
                            if (c5 != null) {
                                r c6 = c5.c("Companion");
                                if (c6 != null) {
                                    dVar = d.a(c6, dVar, this.f15434a, this.f15333b);
                                }
                            } else if (v.a()) {
                                d("Received and will skip rendering for an unidentified creative: " + next2);
                            }
                        }
                    }
                }
            } else if (v.a()) {
                d("Did not find wrapper or inline response for node: " + next);
            }
        }
        a a2 = new a.C0006a().a(this.f15333b).a(this.f15434a.c()).b(this.f15434a.d()).a(this.f15434a.e()).a(this.f15434a.f()).a(str).b(str2).a(iVar).a(mVar).a(dVar).a(cVar).a((Set<j>) hashSet).a(cVar).b((Set<j>) hashSet2).a();
        f a3 = l.a(a2);
        if (a3 == null) {
            if (v.a()) {
                a("Finished rendering VAST ad: " + a2);
            }
            a2.o().b();
            e eVar = new e(a2, this.f15333b, this.f15435c);
            o.a aVar = o.a.CACHING_OTHER;
            if (((Boolean) this.f15333b.a(b.bi)).booleanValue()) {
                if (a2.getType() == AppLovinAdType.REGULAR) {
                    aVar = o.a.CACHING_INTERSTITIAL;
                } else if (a2.getType() == AppLovinAdType.INCENTIVIZED) {
                    aVar = o.a.CACHING_INCENTIVIZED;
                }
            }
            this.f15333b.S().a((a) eVar, aVar);
            return;
        }
        l.a(this.f15434a, this.f15435c, a3, -6, this.f15333b);
    }
}
