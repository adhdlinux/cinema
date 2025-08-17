package com.adcolony.sdk;

import android.app.AlertDialog;
import android.content.Context;
import android.view.View;
import com.adcolony.sdk.e0;
import com.unity3d.services.ads.adunit.AdUnitActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class d {

    /* renamed from: a  reason: collision with root package name */
    private ConcurrentHashMap<String, Runnable> f13060a;

    /* renamed from: b  reason: collision with root package name */
    private HashMap<String, c> f13061b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public ConcurrentHashMap<String, AdColonyInterstitial> f13062c;

    /* renamed from: d  reason: collision with root package name */
    private ConcurrentHashMap<String, AdColonyAdViewListener> f13063d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public ConcurrentHashMap<String, AdColonyAdViewListener> f13064e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public Map<String, AdColonyAdView> f13065f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final Object f13066g = new Object();

    class a implements j0 {
        a() {
        }

        public void a(h0 h0Var) {
            d.this.y(h0Var);
        }
    }

    class b implements j0 {

        class a implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ h0 f13069b;

            a(h0 h0Var) {
                this.f13069b = h0Var;
            }

            public void run() {
                AdColonyInterstitial adColonyInterstitial = (AdColonyInterstitial) d.this.f13062c.get(c0.E(this.f13069b.a(), "id"));
                if (adColonyInterstitial != null && adColonyInterstitial.w() != null) {
                    adColonyInterstitial.w().b(adColonyInterstitial);
                }
            }
        }

        b() {
        }

        public void a(h0 h0Var) {
            z0.A(new a(h0Var));
        }
    }

    class c implements j0 {

        class a implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ h0 f13072b;

            a(h0 h0Var) {
                this.f13072b = h0Var;
            }

            public void run() {
                AdColonyInterstitial adColonyInterstitial = (AdColonyInterstitial) d.this.f13062c.get(c0.E(this.f13072b.a(), "id"));
                if (adColonyInterstitial != null && adColonyInterstitial.w() != null) {
                    adColonyInterstitial.w().a(adColonyInterstitial);
                }
            }
        }

        c() {
        }

        public void a(h0 h0Var) {
            z0.A(new a(h0Var));
        }
    }

    /* renamed from: com.adcolony.sdk.d$d  reason: collision with other inner class name */
    class C0001d implements j0 {
        C0001d() {
        }

        public void a(h0 h0Var) {
            d.this.H(h0Var);
        }
    }

    class e implements j0 {
        e() {
        }

        public void a(h0 h0Var) {
            d.this.G(h0Var);
        }
    }

    class f implements j0 {
        f() {
        }

        public void a(h0 h0Var) {
            boolean unused = d.this.E(h0Var);
        }
    }

    class g implements j0 {
        g(d dVar) {
        }

        public void a(h0 h0Var) {
            f1 q2 = c0.q();
            c0.w(q2, "success", true);
            h0Var.b(q2).e();
        }
    }

    class h implements j0 {

        class a implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ h0 f13077b;

            a(h hVar, h0 h0Var) {
                this.f13077b = h0Var;
            }

            public void run() {
                h0 h0Var = this.f13077b;
                h0Var.b(h0Var.a()).e();
            }
        }

        h(d dVar) {
        }

        public void a(h0 h0Var) {
            z0.A(new a(this, h0Var));
        }
    }

    class i implements j0 {
        i(d dVar) {
        }

        public void a(h0 h0Var) {
            o0.m().c(h0Var);
        }
    }

    class j implements Runnable {
        j(d dVar) {
        }

        public void run() {
            r A0 = a.f().A0();
            if (A0.a() != null) {
                A0.a().dismiss();
                A0.d((AlertDialog) null);
            }
        }
    }

    class k implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f13078b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ h0 f13079c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ AdColonyAdViewListener f13080d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f13081e;

        k(Context context, h0 h0Var, AdColonyAdViewListener adColonyAdViewListener, String str) {
            this.f13078b = context;
            this.f13079c = h0Var;
            this.f13080d = adColonyAdViewListener;
            this.f13081e = str;
        }

        public void run() {
            AdColonyAdView adColonyAdView;
            try {
                adColonyAdView = new AdColonyAdView(this.f13078b, this.f13079c, this.f13080d);
            } catch (RuntimeException e2) {
                new e0.a().c(e2.toString()).d(e0.f13114i);
                adColonyAdView = null;
            }
            synchronized (d.this.f13066g) {
                if (d.this.f13064e.remove(this.f13081e) != null) {
                    if (adColonyAdView == null) {
                        d.this.d(this.f13080d);
                        return;
                    }
                    d.this.f13065f.put(this.f13081e, adColonyAdView);
                    adColonyAdView.setOmidManager(this.f13080d.c());
                    adColonyAdView.e();
                    this.f13080d.b((p0) null);
                    this.f13080d.h(adColonyAdView);
                }
            }
        }
    }

    class l implements j0 {

        class a implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ h0 f13084b;

            a(h0 h0Var) {
                this.f13084b = h0Var;
            }

            public void run() {
                d.this.r(this.f13084b);
            }
        }

        l() {
        }

        public void a(h0 h0Var) {
            z0.A(new a(h0Var));
        }
    }

    class m implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ h0 f13086b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ AdColonyInterstitial f13087c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ AdColonyInterstitialListener f13088d;

        m(d dVar, h0 h0Var, AdColonyInterstitial adColonyInterstitial, AdColonyInterstitialListener adColonyInterstitialListener) {
            this.f13086b = h0Var;
            this.f13087c = adColonyInterstitial;
            this.f13088d = adColonyInterstitialListener;
        }

        public void run() {
            f1 a2 = this.f13086b.a();
            if (this.f13087c.s() == null) {
                this.f13087c.f(c0.C(a2, "iab"));
            }
            this.f13087c.g(c0.E(a2, "ad_id"));
            this.f13087c.o(c0.E(a2, "creative_id"));
            this.f13087c.L(c0.E(a2, "view_network_pass_filter"));
            p0 s2 = this.f13087c.s();
            if (!(s2 == null || s2.o() == 2)) {
                try {
                    s2.c();
                } catch (IllegalArgumentException unused) {
                    new e0.a().c("IllegalArgumentException when creating omid session").d(e0.f13114i);
                }
            }
            this.f13088d.i(this.f13087c);
        }
    }

    class n implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AdColonyAdViewListener f13089b;

        n(d dVar, AdColonyAdViewListener adColonyAdViewListener) {
            this.f13089b = adColonyAdViewListener;
        }

        public void run() {
            AdColonyAdViewListener adColonyAdViewListener = this.f13089b;
            adColonyAdViewListener.i(AdColony.a(adColonyAdViewListener.d()));
            if (!a.h()) {
                new e0.a().c("RequestNotFilled called for AdView due to a missing context. ").d(e0.f13114i);
            }
        }
    }

    class q implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AdColonyInterstitialListener f13090b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ AdColonyInterstitial f13091c;

        q(d dVar, AdColonyInterstitialListener adColonyInterstitialListener, AdColonyInterstitial adColonyInterstitial) {
            this.f13090b = adColonyInterstitialListener;
            this.f13091c = adColonyInterstitial;
        }

        public void run() {
            a.f().f0(false);
            this.f13090b.d(this.f13091c);
        }
    }

    class r implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f13092b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ b1 f13093c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ c f13094d;

        r(String str, b1 b1Var, c cVar) {
            this.f13092b = str;
            this.f13093c = b1Var;
            this.f13094d = cVar;
        }

        public void run() {
            p0 p0Var;
            int i2;
            try {
                AdColonyInterstitial adColonyInterstitial = d.this.z().get(this.f13092b);
                AdColonyAdView adColonyAdView = d.this.s().get(this.f13092b);
                if (adColonyInterstitial == null) {
                    p0Var = null;
                } else {
                    p0Var = adColonyInterstitial.s();
                }
                if (p0Var == null && adColonyAdView != null) {
                    p0Var = adColonyAdView.getOmidManager();
                }
                if (p0Var == null) {
                    i2 = -1;
                } else {
                    i2 = p0Var.o();
                }
                if (p0Var != null && i2 == 2) {
                    p0Var.d(this.f13093c);
                    p0Var.e(this.f13094d);
                }
            } catch (IllegalArgumentException unused) {
                new e0.a().c("IllegalArgumentException when creating omid session").d(e0.f13114i);
            }
        }
    }

    class s implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ c f13096b;

        s(d dVar, c cVar) {
            this.f13096b = cVar;
        }

        public void run() {
            for (int i2 = 0; i2 < this.f13096b.E().size(); i2++) {
                a.g(this.f13096b.G().get(i2), this.f13096b.E().get(i2));
            }
            this.f13096b.G().clear();
            this.f13096b.E().clear();
            this.f13096b.removeAllViews();
            c cVar = this.f13096b;
            cVar.A = null;
            cVar.f13026z = null;
            for (b1 next : cVar.L().values()) {
                if (!(next instanceof e)) {
                    if (next instanceof c1) {
                        a.f().E((c1) next);
                    } else {
                        next.x();
                    }
                }
            }
            for (a1 next2 : this.f13096b.K().values()) {
                next2.L();
                next2.N();
            }
            this.f13096b.K().clear();
            this.f13096b.J().clear();
            this.f13096b.L().clear();
            this.f13096b.C().clear();
            this.f13096b.v().clear();
            this.f13096b.y().clear();
            this.f13096b.A().clear();
            this.f13096b.f13014n = true;
        }
    }

    class t implements j0 {

        class a implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ h0 f13098b;

            a(h0 h0Var) {
                this.f13098b = h0Var;
            }

            public void run() {
                boolean unused = d.this.u(this.f13098b);
            }
        }

        t() {
        }

        public void a(h0 h0Var) {
            z0.A(new a(h0Var));
        }
    }

    class u implements j0 {
        u() {
        }

        public void a(h0 h0Var) {
            boolean unused = d.this.J(h0Var);
        }
    }

    class v implements j0 {
        v() {
        }

        public void a(h0 h0Var) {
            boolean unused = d.this.I(h0Var);
        }
    }

    class w implements j0 {
        w() {
        }

        public void a(h0 h0Var) {
            boolean unused = d.this.C(h0Var);
        }
    }

    class x implements j0 {
        x() {
        }

        public void a(h0 h0Var) {
            boolean unused = d.this.K(h0Var);
        }
    }

    class y implements j0 {
        y() {
        }

        public void a(h0 h0Var) {
            d.this.o(h0Var);
        }
    }

    class z implements j0 {
        z() {
        }

        public void a(h0 h0Var) {
            d.this.k(h0Var);
        }
    }

    d() {
    }

    /* access modifiers changed from: private */
    public boolean C(h0 h0Var) {
        AdColonyInterstitialListener adColonyInterstitialListener;
        f1 a2 = h0Var.a();
        int A = c0.A(a2, "status");
        if (A == 5 || A == 1 || A == 0 || A == 6) {
            return false;
        }
        String E = c0.E(a2, "id");
        AdColonyInterstitial remove = this.f13062c.remove(E);
        if (remove == null) {
            adColonyInterstitialListener = null;
        } else {
            adColonyInterstitialListener = remove.w();
        }
        if (adColonyInterstitialListener == null) {
            i(h0Var.c(), E);
            return false;
        }
        z0.A(new q(this, adColonyInterstitialListener, remove));
        remove.F();
        remove.e((c) null);
        return true;
    }

    /* access modifiers changed from: private */
    public boolean E(h0 h0Var) {
        String E = c0.E(h0Var.a(), "id");
        f1 q2 = c0.q();
        c0.n(q2, "id", E);
        Context a2 = a.a();
        if (a2 == null) {
            c0.w(q2, "has_audio", false);
            h0Var.b(q2).e();
            return false;
        }
        boolean z2 = z0.z(z0.d(a2));
        double a3 = z0.a(z0.d(a2));
        c0.w(q2, "has_audio", z2);
        c0.k(q2, "volume", a3);
        h0Var.b(q2).e();
        return z2;
    }

    /* access modifiers changed from: private */
    public boolean I(h0 h0Var) {
        f1 a2 = h0Var.a();
        String c2 = h0Var.c();
        String E = c0.E(a2, "ad_session_id");
        int A = c0.A(a2, "view_id");
        c cVar = this.f13061b.get(E);
        if (cVar == null) {
            i(c2, E);
            return false;
        }
        View view = cVar.v().get(Integer.valueOf(A));
        if (view == null) {
            i(c2, "" + A);
            return false;
        }
        cVar.removeView(view);
        cVar.addView(view, view.getLayoutParams());
        return true;
    }

    /* access modifiers changed from: private */
    public boolean J(h0 h0Var) {
        f1 a2 = h0Var.a();
        String c2 = h0Var.c();
        String E = c0.E(a2, "ad_session_id");
        int A = c0.A(a2, "view_id");
        c cVar = this.f13061b.get(E);
        if (cVar == null) {
            i(c2, E);
            return false;
        }
        View view = cVar.v().get(Integer.valueOf(A));
        if (view == null) {
            i(c2, "" + A);
            return false;
        }
        view.bringToFront();
        return true;
    }

    /* access modifiers changed from: private */
    public boolean K(h0 h0Var) {
        boolean z2;
        f1 a2 = h0Var.a();
        String E = c0.E(a2, "id");
        AdColonyInterstitial adColonyInterstitial = this.f13062c.get(E);
        AdColonyAdView adColonyAdView = this.f13065f.get(E);
        int a3 = c0.a(a2, AdUnitActivity.EXTRA_ORIENTATION, -1);
        if (adColonyAdView != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (adColonyInterstitial != null || z2) {
            c0.n(c0.q(), "id", E);
            if (adColonyInterstitial != null) {
                adColonyInterstitial.c(a3);
                adColonyInterstitial.E();
            }
            return true;
        }
        i(h0Var.c(), E);
        return false;
    }

    /* access modifiers changed from: private */
    public void d(AdColonyAdViewListener adColonyAdViewListener) {
        z0.A(new n(this, adColonyAdViewListener));
    }

    private void e(AdColonyInterstitial adColonyInterstitial) {
        adColonyInterstitial.H();
        if (!a.h()) {
            e0.a c2 = new e0.a().c("RequestNotFilled called due to a missing context. ");
            c2.c("Interstitial with adSessionId(" + adColonyInterstitial.j() + ").").d(e0.f13114i);
        }
    }

    /* access modifiers changed from: private */
    public boolean u(h0 h0Var) {
        String E = c0.E(h0Var.a(), "ad_session_id");
        c cVar = this.f13061b.get(E);
        if (cVar == null) {
            i(h0Var.c(), E);
            return false;
        }
        g(cVar);
        return true;
    }

    /* access modifiers changed from: package-private */
    public List<AdColonyInterstitial> D() {
        ArrayList arrayList = new ArrayList();
        for (AdColonyInterstitial next : z().values()) {
            if (!next.A()) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public void F() {
        this.f13060a = new ConcurrentHashMap<>();
        this.f13061b = new HashMap<>();
        this.f13062c = new ConcurrentHashMap<>();
        this.f13063d = new ConcurrentHashMap<>();
        this.f13064e = new ConcurrentHashMap<>();
        this.f13065f = Collections.synchronizedMap(new HashMap());
        a.e("AdContainer.create", new l());
        a.e("AdContainer.destroy", new t());
        a.e("AdContainer.move_view_to_index", new u());
        a.e("AdContainer.move_view_to_front", new v());
        a.e("AdSession.finish_fullscreen_ad", new w());
        a.e("AdSession.start_fullscreen_ad", new x());
        a.e("AdSession.ad_view_available", new y());
        a.e("AdSession.ad_view_unavailable", new z());
        a.e("AdSession.expiring", new a());
        a.e("AdSession.audio_stopped", new b());
        a.e("AdSession.audio_started", new c());
        a.e("AdSession.interstitial_available", new C0001d());
        a.e("AdSession.interstitial_unavailable", new e());
        a.e("AdSession.has_audio", new f());
        a.e("WebView.prepare", new g(this));
        a.e("AdSession.expanded", new h(this));
        a.e("AdColony.odt_event", new i(this));
    }

    /* access modifiers changed from: package-private */
    public boolean G(h0 h0Var) {
        AdColonyInterstitialListener adColonyInterstitialListener;
        String E = c0.E(h0Var.a(), "id");
        AdColonyInterstitial remove = this.f13062c.remove(E);
        if (remove == null) {
            adColonyInterstitialListener = null;
        } else {
            adColonyInterstitialListener = remove.w();
        }
        if (adColonyInterstitialListener == null) {
            i(h0Var.c(), E);
            return false;
        }
        z0.C(this.f13060a.remove(E));
        e(remove);
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean H(h0 h0Var) {
        f1 a2 = h0Var.a();
        String E = c0.E(a2, "id");
        AdColonyInterstitial adColonyInterstitial = this.f13062c.get(E);
        if (adColonyInterstitial == null || adColonyInterstitial.B()) {
            return false;
        }
        AdColonyInterstitialListener w2 = adColonyInterstitial.w();
        if (w2 == null) {
            i(h0Var.c(), E);
            return false;
        }
        z0.C(this.f13060a.remove(E));
        if (!a.h()) {
            e(adColonyInterstitial);
            return false;
        }
        adColonyInterstitial.M();
        adColonyInterstitial.g(c0.E(a2, "ad_id"));
        adColonyInterstitial.o(c0.E(a2, "creative_id"));
        adColonyInterstitial.q(c0.E(a2, "ad_request_id"));
        z0.A(new m(this, h0Var, adColonyInterstitial, w2));
        return true;
    }

    /* access modifiers changed from: package-private */
    public void b() {
        for (AdColonyInterstitial next : this.f13062c.values()) {
            if (next != null && next.D()) {
                next.t("Controller was reloaded and current ad was closed");
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void c(Context context, f1 f1Var, String str) {
        h0 h0Var = new h0("AdSession.finish_fullscreen_ad", 0);
        c0.u(f1Var, "status", 1);
        h0Var.d(f1Var);
        new e0.a().c(str).d(e0.f13113h);
        ((b) context).c(h0Var);
    }

    /* access modifiers changed from: package-private */
    public void f(b1 b1Var, String str, c cVar) {
        z0.A(new r(str, b1Var, cVar));
    }

    /* access modifiers changed from: package-private */
    public void g(c cVar) {
        z0.A(new s(this, cVar));
        AdColonyAdView adColonyAdView = this.f13065f.get(cVar.b());
        if (adColonyAdView == null || adColonyAdView.d()) {
            this.f13061b.remove(cVar.b());
            cVar.f13026z = null;
        }
    }

    /* access modifiers changed from: package-private */
    public void i(String str, String str2) {
        new e0.a().c("Message '").c(str).c("' sent with invalid id: ").c(str2).d(e0.f13113h);
    }

    /* access modifiers changed from: package-private */
    public boolean k(h0 h0Var) {
        String E = c0.E(h0Var.a(), "id");
        AdColonyAdViewListener remove = this.f13063d.remove(E);
        if (remove == null) {
            i(h0Var.c(), E);
            return false;
        }
        z0.C(this.f13060a.remove(E));
        d(remove);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void m() {
        HashSet<AdColonyAdViewListener> hashSet = new HashSet<>();
        synchronized (this.f13066g) {
            for (String remove : this.f13064e.keySet()) {
                AdColonyAdViewListener remove2 = this.f13064e.remove(remove);
                if (remove2 != null) {
                    hashSet.add(remove2);
                }
            }
            for (String remove3 : this.f13063d.keySet()) {
                AdColonyAdViewListener remove4 = this.f13063d.remove(remove3);
                if (remove4 != null) {
                    hashSet.add(remove4);
                }
            }
        }
        for (AdColonyAdViewListener d2 : hashSet) {
            d(d2);
        }
        for (String next : this.f13062c.keySet()) {
            AdColonyInterstitial adColonyInterstitial = this.f13062c.get(next);
            if (adColonyInterstitial != null && adColonyInterstitial.C()) {
                this.f13062c.remove(next);
                e(adColonyInterstitial);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean o(h0 h0Var) {
        String E = c0.E(h0Var.a(), "id");
        AdColonyAdViewListener remove = this.f13063d.remove(E);
        if (remove == null) {
            i(h0Var.c(), E);
            return false;
        }
        this.f13064e.put(E, remove);
        z0.C(this.f13060a.remove(E));
        Context a2 = a.a();
        if (a2 == null) {
            d(remove);
            return false;
        }
        z0.A(new k(a2, h0Var, remove, E));
        return true;
    }

    /* access modifiers changed from: package-private */
    public HashMap<String, c> p() {
        return this.f13061b;
    }

    /* access modifiers changed from: package-private */
    public boolean r(h0 h0Var) {
        Context a2 = a.a();
        if (a2 == null) {
            return false;
        }
        f1 a3 = h0Var.a();
        String E = c0.E(a3, "ad_session_id");
        c cVar = new c(a2.getApplicationContext(), E);
        cVar.H(h0Var);
        this.f13061b.put(E, cVar);
        if (c0.A(a3, "width") == 0) {
            AdColonyInterstitial adColonyInterstitial = this.f13062c.get(E);
            if (adColonyInterstitial == null) {
                i(h0Var.c(), E);
                return false;
            }
            adColonyInterstitial.e(cVar);
        } else {
            cVar.r(false);
        }
        f1 q2 = c0.q();
        c0.w(q2, "success", true);
        h0Var.b(q2).e();
        return true;
    }

    /* access modifiers changed from: package-private */
    public Map<String, AdColonyAdView> s() {
        return this.f13065f;
    }

    /* access modifiers changed from: package-private */
    public ConcurrentHashMap<String, AdColonyAdViewListener> w() {
        return this.f13063d;
    }

    /* access modifiers changed from: package-private */
    public boolean y(h0 h0Var) {
        f1 a2 = h0Var.a();
        String E = c0.E(a2, "id");
        if (c0.A(a2, "type") != 0) {
            return true;
        }
        AdColonyInterstitial remove = this.f13062c.remove(E);
        if (!a.h() || remove == null || !remove.G()) {
            i(h0Var.c(), E);
            return true;
        }
        z0.A(new j(this));
        return true;
    }

    /* access modifiers changed from: package-private */
    public ConcurrentHashMap<String, AdColonyInterstitial> z() {
        return this.f13062c;
    }
}
