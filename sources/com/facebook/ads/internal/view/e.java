package com.facebook.ads.internal.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.internal.a.b;
import com.facebook.ads.internal.adapters.p;
import com.facebook.ads.internal.adapters.q;
import com.facebook.ads.internal.j.a;
import com.facebook.ads.internal.m.c;
import com.facebook.ads.internal.q.a.k;
import com.facebook.ads.internal.view.a;
import com.facebook.ads.internal.view.b.a;
import com.facebook.react.uimanager.events.PointerEventHelper;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class e implements a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final String f21149a = "e";
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final a.C0037a f21150b;

    /* renamed from: c  reason: collision with root package name */
    private final com.facebook.ads.internal.view.b.a f21151c;

    /* renamed from: d  reason: collision with root package name */
    private final a.b f21152d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final q f21153e;

    /* renamed from: f  reason: collision with root package name */
    private final c f21154f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public p f21155g;

    /* renamed from: h  reason: collision with root package name */
    private long f21156h = System.currentTimeMillis();
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public long f21157i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public a.C0033a f21158j;

    public e(final AudienceNetworkActivity audienceNetworkActivity, final c cVar, a.C0037a aVar) {
        this.f21150b = aVar;
        this.f21154f = cVar;
        AnonymousClass1 r02 = new a.c() {

            /* renamed from: d  reason: collision with root package name */
            private long f21162d = 0;

            public void a() {
                e.this.f21153e.b();
            }

            public void a(String str, Map<String, String> map) {
                Uri parse = Uri.parse(str);
                if (!"fbad".equals(parse.getScheme()) || !MRAIDPresenter.CLOSE.equals(parse.getAuthority())) {
                    long j2 = this.f21162d;
                    long currentTimeMillis = System.currentTimeMillis();
                    this.f21162d = currentTimeMillis;
                    if (currentTimeMillis - j2 >= 1000) {
                        if ("fbad".equals(parse.getScheme()) && com.facebook.ads.internal.a.c.a(parse.getAuthority())) {
                            e.this.f21150b.a("com.facebook.ads.interstitial.clicked");
                        }
                        b a2 = com.facebook.ads.internal.a.c.a(audienceNetworkActivity, cVar, e.this.f21155g.c(), parse, map);
                        if (a2 != null) {
                            try {
                                a.C0033a unused = e.this.f21158j = a2.a();
                                long unused2 = e.this.f21157i = System.currentTimeMillis();
                                a2.b();
                            } catch (Exception e2) {
                                Log.e(e.f21149a, "Error executing action", e2);
                            }
                        }
                    }
                } else {
                    audienceNetworkActivity.finish();
                }
            }

            public void b() {
                e.this.f21153e.a();
            }
        };
        this.f21152d = r02;
        com.facebook.ads.internal.view.b.a aVar2 = new com.facebook.ads.internal.view.b.a(audienceNetworkActivity, new WeakReference(r02), 1);
        this.f21151c = aVar2;
        aVar2.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        AudienceNetworkActivity audienceNetworkActivity2 = audienceNetworkActivity;
        c cVar2 = cVar;
        com.facebook.ads.internal.view.b.a aVar3 = aVar2;
        this.f21153e = new q(audienceNetworkActivity2, cVar2, aVar3, aVar2.getViewabilityChecker(), new com.facebook.ads.internal.adapters.c() {
            public void a() {
                e.this.f21150b.a("com.facebook.ads.interstitial.impression.logged");
            }
        });
        aVar.a((View) aVar2);
    }

    public void a(Intent intent, Bundle bundle, AudienceNetworkActivity audienceNetworkActivity) {
        if (bundle == null || !bundle.containsKey("dataModel")) {
            p b2 = p.b(intent);
            this.f21155g = b2;
            if (b2 != null) {
                this.f21153e.a(b2);
                this.f21151c.loadDataWithBaseURL(com.facebook.ads.internal.q.c.b.a(), this.f21155g.d(), AudienceNetworkActivity.WEBVIEW_MIME_TYPE, AudienceNetworkActivity.WEBVIEW_ENCODING, (String) null);
                this.f21151c.a(this.f21155g.h(), this.f21155g.i());
                return;
            }
            return;
        }
        p a2 = p.a(bundle.getBundle("dataModel"));
        this.f21155g = a2;
        if (a2 != null) {
            this.f21151c.loadDataWithBaseURL(com.facebook.ads.internal.q.c.b.a(), this.f21155g.d(), AudienceNetworkActivity.WEBVIEW_MIME_TYPE, AudienceNetworkActivity.WEBVIEW_ENCODING, (String) null);
            this.f21151c.a(this.f21155g.h(), this.f21155g.i());
        }
    }

    public void a(Bundle bundle) {
        p pVar = this.f21155g;
        if (pVar != null) {
            bundle.putBundle("dataModel", pVar.j());
        }
    }

    public void i() {
        this.f21151c.onPause();
    }

    public void j() {
        a.C0033a aVar;
        p pVar;
        long j2 = this.f21157i;
        if (!(j2 <= 0 || (aVar = this.f21158j) == null || (pVar = this.f21155g) == null)) {
            com.facebook.ads.internal.j.b.a(com.facebook.ads.internal.j.a.a(j2, aVar, pVar.g()));
        }
        this.f21151c.onResume();
    }

    public void onDestroy() {
        p pVar = this.f21155g;
        if (pVar != null) {
            com.facebook.ads.internal.j.b.a(com.facebook.ads.internal.j.a.a(this.f21156h, a.C0033a.XOUT, pVar.g()));
            if (!TextUtils.isEmpty(this.f21155g.c())) {
                HashMap hashMap = new HashMap();
                this.f21151c.getViewabilityChecker().a((Map<String, String>) hashMap);
                hashMap.put(PointerEventHelper.POINTER_TYPE_TOUCH, k.a(this.f21151c.getTouchData()));
                this.f21154f.i(this.f21155g.c(), hashMap);
            }
        }
        com.facebook.ads.internal.q.c.b.a(this.f21151c);
        this.f21151c.destroy();
    }

    public void setListener(a.C0037a aVar) {
    }
}
