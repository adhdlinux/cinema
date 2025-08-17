package com.facebook.ads.internal.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.ImageView;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.internal.adapters.a.h;
import com.facebook.ads.internal.j.a;
import com.facebook.ads.internal.m.c;
import com.facebook.ads.internal.q.a.k;
import com.facebook.ads.internal.q.a.u;
import com.facebook.ads.internal.r.a;
import com.facebook.ads.internal.view.b.d;
import com.facebook.ads.internal.view.b.e;
import com.facebook.ads.internal.view.component.a.b;
import com.facebook.ads.internal.view.component.a.d;
import com.facebook.react.uimanager.events.PointerEventHelper;
import java.util.HashMap;
import java.util.Map;

public class g extends i {
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final com.facebook.ads.internal.adapters.a.g f21554e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final a f21555f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final u f21556g = new u();

    /* renamed from: h  reason: collision with root package name */
    private final a.C0035a f21557h;

    /* renamed from: i  reason: collision with root package name */
    private long f21558i;

    public g(Context context, com.facebook.ads.internal.adapters.a.g gVar, c cVar) {
        super(context, cVar);
        this.f21554e = gVar;
        AnonymousClass1 r2 = new a.C0035a() {
            public void a() {
                if (!g.this.f21556g.b()) {
                    g.this.f21556g.a();
                    HashMap hashMap = new HashMap();
                    g.this.f21555f.a((Map<String, String>) hashMap);
                    hashMap.put(PointerEventHelper.POINTER_TYPE_TOUCH, k.a(g.this.f21556g.e()));
                    g gVar = g.this;
                    gVar.f21614b.a(gVar.f21554e.c(), hashMap);
                    if (g.this.getAudienceNetworkListener() != null) {
                        g.this.getAudienceNetworkListener().a("com.facebook.ads.interstitial.impression.logged");
                    }
                }
            }
        };
        this.f21557h = r2;
        a aVar = new a(this, 100, r2);
        this.f21555f = aVar;
        aVar.a(gVar.f());
    }

    private void setUpContent(int i2) {
        h hVar = this.f21554e.d().get(0);
        ImageView imageView = new ImageView(getContext());
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        imageView.setAdjustViewBounds(true);
        d a2 = new d(imageView).a(hVar.c().i(), hVar.c().h());
        a2.a((e) new e() {
            public void a(boolean z2) {
                if (z2) {
                    g.this.f21555f.a();
                }
            }
        });
        a2.a(hVar.c().g());
        b a3 = com.facebook.ads.internal.view.component.a.c.a(new d.a(getContext(), this.f21614b, getAudienceNetworkListener(), this.f21554e, imageView, this.f21555f, this.f21556g).a(i.f21613a).b(i2).a());
        a(a3, a3.a(), i2);
    }

    public void a(Intent intent, Bundle bundle, AudienceNetworkActivity audienceNetworkActivity) {
        super.a(audienceNetworkActivity, this.f21554e);
        setUpContent(audienceNetworkActivity.getResources().getConfiguration().orientation);
        this.f21558i = System.currentTimeMillis();
    }

    public void a(Bundle bundle) {
    }

    public void i() {
    }

    public void j() {
    }

    public void onConfigurationChanged(Configuration configuration) {
        removeAllViews();
        setUpContent(configuration.orientation);
        super.onConfigurationChanged(configuration);
    }

    public void onDestroy() {
        com.facebook.ads.internal.adapters.a.g gVar = this.f21554e;
        if (gVar != null) {
            com.facebook.ads.internal.j.b.a(com.facebook.ads.internal.j.a.a(this.f21558i, a.C0033a.XOUT, gVar.e()));
            if (!TextUtils.isEmpty(this.f21554e.c())) {
                HashMap hashMap = new HashMap();
                this.f21555f.a((Map<String, String>) hashMap);
                hashMap.put(PointerEventHelper.POINTER_TYPE_TOUCH, k.a(this.f21556g.e()));
                this.f21614b.i(this.f21554e.c(), hashMap);
            }
        }
        this.f21555f.c();
        super.onDestroy();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.f21556g.a(motionEvent, this, this);
        return super.onInterceptTouchEvent(motionEvent);
    }
}
