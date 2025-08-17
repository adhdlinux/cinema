package com.startapp;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.webkit.WebView;
import com.iab.omid.library.startio.adsession.FriendlyObstructionPurpose;
import com.iab.omid.library.startio.publisher.AdSessionStatePublisher;
import com.startapp.sdk.omsdk.AdVerification;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

public class me {

    /* renamed from: a  reason: collision with root package name */
    public final s f34939a;

    /* renamed from: b  reason: collision with root package name */
    public final r f34940b;

    /* renamed from: c  reason: collision with root package name */
    public final y f34941c;

    /* renamed from: d  reason: collision with root package name */
    public final AtomicBoolean f34942d = new AtomicBoolean();

    /* renamed from: e  reason: collision with root package name */
    public final AtomicBoolean f34943e = new AtomicBoolean();

    public me(WebView webView) {
        s a2 = p.a(webView);
        this.f34939a = a2;
        this.f34940b = p.a(webView.getContext(), a2);
        this.f34941c = null;
    }

    public void a() {
        s sVar = this.f34939a;
        if (sVar != null) {
            x xVar = (x) sVar;
            if (!xVar.f36852h) {
                xVar.f36849e.clear();
                if (!xVar.f36852h) {
                    xVar.f36848d.clear();
                }
                xVar.f36852h = true;
                l.f34848a.a(xVar.f36850f.c(), "finishSession", new Object[0]);
                g gVar = g.f34545a;
                boolean b2 = gVar.b();
                gVar.f34546b.remove(xVar);
                gVar.f34547c.remove(xVar);
                if (b2 && !gVar.b()) {
                    m a2 = m.a();
                    a2.getClass();
                    d0 d0Var = d0.f34311a;
                    d0Var.getClass();
                    Handler handler = d0.f34313c;
                    if (handler != null) {
                        handler.removeCallbacks(d0.f34315e);
                        d0.f34313c = null;
                    }
                    d0Var.f34316f.clear();
                    d0.f34312b.post(new e0(d0Var));
                    h hVar = h.f34604a;
                    hVar.f34605b = false;
                    hVar.f34606c = false;
                    hVar.f34607d = null;
                    e eVar = a2.f34889e;
                    eVar.f34387a.getContentResolver().unregisterContentObserver(eVar);
                }
                xVar.f36850f.b();
                xVar.f36850f = null;
            }
        }
    }

    public void b() {
        if (this.f34940b != null && this.f34942d.compareAndSet(false, true)) {
            r rVar = this.f34940b;
            p.b(rVar.f35730a);
            p.c(rVar.f35730a);
            if (!rVar.f35730a.c()) {
                try {
                    rVar.f35730a.a();
                } catch (Exception unused) {
                }
            }
            if (rVar.f35730a.c()) {
                x xVar = rVar.f35730a;
                if (!xVar.f36854j) {
                    l.f34848a.a(xVar.f36850f.c(), "publishImpressionEvent", new Object[0]);
                    xVar.f36854j = true;
                    return;
                }
                throw new IllegalStateException("Impression event can only be sent once");
            }
        }
    }

    public boolean c() {
        return this.f34939a != null;
    }

    public void d() {
        if (this.f34940b != null && this.f34943e.compareAndSet(false, true)) {
            r rVar = this.f34940b;
            p.a(rVar.f35730a);
            p.c(rVar.f35730a);
            x xVar = rVar.f35730a;
            if (!xVar.f36855k) {
                l.f34848a.a(xVar.f36850f.c(), "publishLoadedEvent", new Object[0]);
                xVar.f36855k = true;
                return;
            }
            throw new IllegalStateException("Loaded event can only be sent once");
        }
    }

    public void e() {
        s sVar = this.f34939a;
        if (sVar != null) {
            sVar.a();
        }
    }

    public me(Context context, AdVerification adVerification, boolean z2) {
        s b2 = p.b(context, adVerification, z2);
        this.f34939a = b2;
        this.f34940b = p.a(context, b2);
        this.f34941c = z2 ? p.b(context, b2) : null;
    }

    public void a(View view) {
        s sVar = this.f34939a;
        if (sVar != null) {
            x xVar = (x) sVar;
            if (!xVar.f36852h) {
                p.a((Object) view, "AdView is null");
                if (xVar.b() != view) {
                    xVar.f36849e = new ng(view);
                    AdSessionStatePublisher adSessionStatePublisher = xVar.f36850f;
                    adSessionStatePublisher.getClass();
                    adSessionStatePublisher.f31613e = System.nanoTime();
                    adSessionStatePublisher.f31612d = AdSessionStatePublisher.a.AD_STATE_IDLE;
                    Collection<T> unmodifiableCollection = Collections.unmodifiableCollection(g.f34545a.f34546b);
                    if (unmodifiableCollection != null && !unmodifiableCollection.isEmpty()) {
                        for (T t2 : unmodifiableCollection) {
                            if (t2 != xVar && t2.b() == view) {
                                t2.f36849e.clear();
                            }
                        }
                    }
                }
            }
        }
    }

    public void a(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, String str) {
        i iVar;
        s sVar = this.f34939a;
        if (sVar != null) {
            x xVar = (x) sVar;
            if (!xVar.f36852h) {
                if (view != null) {
                    Iterator<i> it2 = xVar.f36848d.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            iVar = null;
                            break;
                        }
                        iVar = it2.next();
                        if (iVar.f34674a.get() == view) {
                            break;
                        }
                    }
                    if (iVar == null) {
                        xVar.f36848d.add(new i(view, friendlyObstructionPurpose, (String) null));
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("FriendlyObstruction is null");
            }
        }
    }
}
