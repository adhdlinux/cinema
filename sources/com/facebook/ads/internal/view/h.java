package com.facebook.ads.internal.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.internal.adapters.a.g;
import com.facebook.ads.internal.d.b;
import com.facebook.ads.internal.j.a;
import com.facebook.ads.internal.q.a.u;
import com.facebook.ads.internal.q.a.x;
import com.facebook.ads.internal.r.a;
import com.facebook.ads.internal.view.component.a.d;
import com.facebook.ads.internal.view.f.a;
import com.facebook.ads.internal.view.f.b.c;
import com.facebook.ads.internal.view.f.b.d;
import com.facebook.ads.internal.view.f.b.e;
import com.facebook.ads.internal.view.f.b.i;
import com.facebook.ads.internal.view.f.b.j;
import com.facebook.ads.internal.view.f.b.k;
import com.facebook.ads.internal.view.f.b.l;
import com.facebook.ads.internal.view.f.b.m;
import com.facebook.ads.internal.view.f.c.d;
import com.facebook.ads.internal.view.f.c.f;
import com.facebook.ads.internal.view.f.c.o;
import com.facebook.react.uimanager.events.PointerEventHelper;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class h extends i {

    /* renamed from: e  reason: collision with root package name */
    private final AudienceNetworkActivity.BackButtonInterceptor f21561e = new AudienceNetworkActivity.BackButtonInterceptor() {
        public boolean interceptBackButton() {
            return !h.this.f21615c.a();
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private final e f21562f;

    /* renamed from: g  reason: collision with root package name */
    private final k f21563g;

    /* renamed from: h  reason: collision with root package name */
    private final i f21564h;

    /* renamed from: i  reason: collision with root package name */
    private final c f21565i;

    /* renamed from: j  reason: collision with root package name */
    private final m f21566j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public final a f21567k;

    /* renamed from: l  reason: collision with root package name */
    private final o f21568l;

    /* renamed from: m  reason: collision with root package name */
    private final f f21569m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public final g f21570n;

    /* renamed from: o  reason: collision with root package name */
    private final com.facebook.ads.internal.adapters.a.h f21571o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public final com.facebook.ads.internal.r.a f21572p;

    /* renamed from: q  reason: collision with root package name */
    private final a.C0035a f21573q;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public final u f21574r;

    /* renamed from: s  reason: collision with root package name */
    private final b f21575s;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public final AtomicBoolean f21576t;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public final AtomicBoolean f21577u;

    /* renamed from: v  reason: collision with root package name */
    private final com.facebook.ads.internal.view.f.c f21578v;
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public AudienceNetworkActivity f21579w;

    /* renamed from: x  reason: collision with root package name */
    private com.facebook.ads.internal.view.f.a.a f21580x;

    /* renamed from: y  reason: collision with root package name */
    private long f21581y;
    /* access modifiers changed from: private */

    /* renamed from: z  reason: collision with root package name */
    public boolean f21582z;

    public h(Context context, com.facebook.ads.internal.m.c cVar, g gVar, b bVar) {
        super(context, cVar);
        AnonymousClass2 r10 = new e() {
            public void a(d dVar) {
                if (h.this.getAudienceNetworkListener() != null) {
                    h.this.getAudienceNetworkListener().a("videoInterstitalEvent", dVar);
                }
                if (!h.this.f21582z) {
                    h.this.f21567k.f();
                    h.this.f21567k.k();
                    boolean unused = h.this.f21582z = true;
                }
                if (h.this.f21579w != null) {
                    h.this.f21579w.finish();
                }
            }
        };
        this.f21562f = r10;
        AnonymousClass3 r02 = new k() {
            public void a(j jVar) {
                if (h.this.getAudienceNetworkListener() != null) {
                    h.this.getAudienceNetworkListener().a("videoInterstitalEvent", jVar);
                }
            }
        };
        this.f21563g = r02;
        AnonymousClass4 r12 = new i() {
            public void a(com.facebook.ads.internal.view.f.b.h hVar) {
                if (h.this.getAudienceNetworkListener() != null) {
                    h.this.getAudienceNetworkListener().a("videoInterstitalEvent", hVar);
                }
            }
        };
        this.f21564h = r12;
        AnonymousClass5 r2 = new c() {
            public void a(com.facebook.ads.internal.view.f.b.b bVar) {
                h.this.f21576t.set(true);
                if (h.this.getAudienceNetworkListener() != null) {
                    h.this.getAudienceNetworkListener().a("videoInterstitalEvent", bVar);
                }
            }
        };
        this.f21565i = r2;
        AnonymousClass6 r3 = new m() {
            public void a(l lVar) {
                if (!h.this.f21582z) {
                    h.this.f21577u.set(h.this.f21567k.j());
                    h.this.a();
                }
                if (h.this.getAudienceNetworkListener() != null) {
                    h.this.getAudienceNetworkListener().a("videoInterstitalEvent", lVar);
                }
                h.this.f21572p.a();
            }
        };
        this.f21566j = r3;
        this.f21574r = new u();
        this.f21576t = new AtomicBoolean(false);
        this.f21577u = new AtomicBoolean(false);
        this.f21582z = false;
        com.facebook.ads.internal.view.f.a aVar = new com.facebook.ads.internal.view.f.a(getContext());
        this.f21567k = aVar;
        aVar.setVideoProgressReportIntervalMs(gVar.h());
        x.a((View) aVar);
        x.a((View) aVar, 0);
        this.f21570n = gVar;
        com.facebook.ads.internal.adapters.a.h hVar = gVar.d().get(0);
        this.f21571o = hVar;
        this.f21575s = bVar;
        this.f21568l = new o(getContext());
        this.f21569m = new f(context);
        aVar.getEventBus().a((T[]) new com.facebook.ads.internal.j.f[]{r02, r12, r2, r10, r3});
        setupPlugins(hVar);
        AnonymousClass7 r9 = new a.C0035a() {
            public void a() {
                if (!h.this.f21574r.b()) {
                    h.this.f21574r.a();
                    HashMap hashMap = new HashMap();
                    if (!TextUtils.isEmpty(h.this.f21570n.c())) {
                        h.this.f21572p.a((Map<String, String>) hashMap);
                        hashMap.put(PointerEventHelper.POINTER_TYPE_TOUCH, com.facebook.ads.internal.q.a.k.a(h.this.f21574r.e()));
                        h hVar = h.this;
                        hVar.f21614b.a(hVar.f21570n.c(), hashMap);
                        if (h.this.getAudienceNetworkListener() != null) {
                            h.this.getAudienceNetworkListener().a("com.facebook.ads.interstitial.impression.logged");
                        }
                    }
                }
            }
        };
        this.f21573q = r9;
        com.facebook.ads.internal.r.a aVar2 = new com.facebook.ads.internal.r.a(this, 1, r9);
        this.f21572p = aVar2;
        aVar2.a(gVar.f());
        aVar2.b(gVar.g());
        this.f21578v = new com.facebook.ads.internal.view.f.b(getContext(), this.f21614b, aVar, gVar.c());
        aVar.setVideoURI(a(hVar.c().a()));
    }

    private String a(String str) {
        b bVar = this.f21575s;
        String b2 = (bVar == null || str == null) ? "" : bVar.b(str);
        return TextUtils.isEmpty(b2) ? str : b2;
    }

    /* access modifiers changed from: private */
    public void a() {
        this.f21569m.setVisibility(this.f21577u.get() ? 0 : 8);
    }

    private void setUpContent(int i2) {
        com.facebook.ads.internal.view.component.a.b a2 = com.facebook.ads.internal.view.component.a.c.a(new d.a(getContext(), this.f21614b, getAudienceNetworkListener(), this.f21570n, this.f21567k, this.f21572p, this.f21574r).a(i.f21613a).b(i2).a(this.f21568l).a((View) this.f21569m).a());
        a();
        a(a2, a2.a(), i2);
    }

    private void setupPlugins(com.facebook.ads.internal.adapters.a.h hVar) {
        this.f21567k.d();
        this.f21567k.a((com.facebook.ads.internal.view.f.a.b) this.f21568l);
        this.f21567k.a((com.facebook.ads.internal.view.f.a.b) this.f21569m);
        if (!TextUtils.isEmpty(hVar.c().g())) {
            com.facebook.ads.internal.view.f.c.g gVar = new com.facebook.ads.internal.view.f.c.g(getContext());
            this.f21567k.a((com.facebook.ads.internal.view.f.a.b) gVar);
            gVar.setImage(hVar.c().g());
        }
        com.facebook.ads.internal.view.f.c.l lVar = new com.facebook.ads.internal.view.f.c.l(getContext(), true);
        this.f21567k.a((com.facebook.ads.internal.view.f.a.b) lVar);
        this.f21567k.a((com.facebook.ads.internal.view.f.a.b) new com.facebook.ads.internal.view.f.c.d(lVar, hVar.c().e() ? d.a.FADE_OUT_ON_PLAY : d.a.VISIBLE, true));
        this.f21567k.a((com.facebook.ads.internal.view.f.a.b) new com.facebook.ads.internal.view.f.c.k(getContext()));
        this.f21567k.a((com.facebook.ads.internal.view.f.a.b) this.f21615c);
    }

    public void a(Intent intent, Bundle bundle, AudienceNetworkActivity audienceNetworkActivity) {
        super.a(audienceNetworkActivity, this.f21570n);
        this.f21579w = audienceNetworkActivity;
        setUpContent(audienceNetworkActivity.getResources().getConfiguration().orientation);
        this.f21579w.addBackButtonInterceptor(this.f21561e);
        com.facebook.ads.internal.adapters.a.h hVar = this.f21570n.d().get(0);
        if (hVar.c().e()) {
            this.f21567k.setVolume(hVar.c().f() ? 1.0f : 0.0f);
            this.f21567k.a(com.facebook.ads.internal.view.f.a.a.AUTO_STARTED);
        }
        this.f21581y = System.currentTimeMillis();
    }

    public void a(Bundle bundle) {
    }

    public void i() {
        if (!this.f21582z && this.f21567k.getState() == com.facebook.ads.internal.view.f.d.d.STARTED) {
            this.f21580x = this.f21567k.getVideoStartReason();
            this.f21567k.a(false);
        }
    }

    public void j() {
        com.facebook.ads.internal.view.f.a.a aVar;
        if (!this.f21582z && (aVar = this.f21580x) != null) {
            this.f21567k.a(aVar);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        removeAllViews();
        x.b(this.f21567k);
        x.b(this.f21568l);
        x.b(this.f21569m);
        setUpContent(configuration.orientation);
        super.onConfigurationChanged(configuration);
    }

    public void onDestroy() {
        if (!this.f21582z) {
            if (!this.f21576t.get()) {
                this.f21567k.e();
            }
            g gVar = this.f21570n;
            if (gVar != null) {
                com.facebook.ads.internal.j.b.a(com.facebook.ads.internal.j.a.a(this.f21581y, a.C0033a.XOUT, gVar.e()));
                if (!TextUtils.isEmpty(this.f21570n.c())) {
                    HashMap hashMap = new HashMap();
                    this.f21572p.a((Map<String, String>) hashMap);
                    hashMap.put(PointerEventHelper.POINTER_TYPE_TOUCH, com.facebook.ads.internal.q.a.k.a(this.f21574r.e()));
                    this.f21614b.i(this.f21570n.c(), hashMap);
                }
            }
            this.f21567k.f();
            this.f21567k.k();
            this.f21582z = true;
        }
        this.f21572p.c();
        this.f21579w = null;
        super.onDestroy();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.f21574r.a(motionEvent, this, this);
        return super.onInterceptTouchEvent(motionEvent);
    }
}
