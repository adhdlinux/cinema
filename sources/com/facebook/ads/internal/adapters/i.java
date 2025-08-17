package com.facebook.ads.internal.adapters;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.facebook.ads.AdError;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.internal.a.e;
import com.facebook.ads.internal.h.d;
import com.facebook.ads.internal.j.a;
import com.facebook.ads.internal.j.b;
import com.facebook.ads.internal.m.c;
import com.facebook.ads.internal.view.b.a;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

public class i extends BannerAdapter {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final String f19819a = "i";

    /* renamed from: b  reason: collision with root package name */
    private a.b f19820b;

    /* renamed from: c  reason: collision with root package name */
    private a f19821c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public q f19822d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public BannerAdapterListener f19823e;

    /* renamed from: f  reason: collision with root package name */
    private Map<String, Object> f19824f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public c f19825g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public Context f19826h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public long f19827i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public a.C0033a f19828j;

    private void a(d dVar) {
        this.f19827i = 0;
        this.f19828j = null;
        final p a2 = p.a((JSONObject) this.f19824f.get("data"));
        if (e.a(this.f19826h, a2, this.f19825g)) {
            this.f19823e.onBannerError(this, AdError.NO_FILL);
            return;
        }
        this.f19820b = new a.c() {
            public void a() {
                i.this.f19822d.b();
            }

            public void a(int i2) {
                if (i2 == 0 && i.this.f19827i > 0 && i.this.f19828j != null) {
                    b.a(com.facebook.ads.internal.j.a.a(i.this.f19827i, i.this.f19828j, a2.g()));
                    long unused = i.this.f19827i = 0;
                    a.C0033a unused2 = i.this.f19828j = null;
                }
            }

            public void a(String str, Map<String, String> map) {
                Uri parse = Uri.parse(str);
                if ("fbad".equals(parse.getScheme()) && com.facebook.ads.internal.a.c.a(parse.getAuthority()) && i.this.f19823e != null) {
                    i.this.f19823e.onBannerAdClicked(i.this);
                }
                com.facebook.ads.internal.a.b a2 = com.facebook.ads.internal.a.c.a(i.this.f19826h, i.this.f19825g, a2.c(), parse, map);
                if (a2 != null) {
                    try {
                        a.C0033a unused = i.this.f19828j = a2.a();
                        long unused2 = i.this.f19827i = System.currentTimeMillis();
                        a2.b();
                    } catch (Exception e2) {
                        Log.e(i.f19819a, "Error executing action", e2);
                    }
                }
            }

            public void b() {
                if (i.this.f19822d != null) {
                    i.this.f19822d.a();
                }
            }
        };
        com.facebook.ads.internal.view.b.a aVar = new com.facebook.ads.internal.view.b.a(this.f19826h, new WeakReference(this.f19820b), dVar.f());
        this.f19821c = aVar;
        aVar.a(dVar.h(), dVar.i());
        AnonymousClass2 r10 = new c() {
            public void a() {
                if (i.this.f19823e != null) {
                    i.this.f19823e.onBannerLoggingImpression(i.this);
                }
            }
        };
        Context context = this.f19826h;
        c cVar = this.f19825g;
        com.facebook.ads.internal.view.b.a aVar2 = this.f19821c;
        q qVar = new q(context, cVar, aVar2, aVar2.getViewabilityChecker(), r10);
        this.f19822d = qVar;
        qVar.a(a2);
        this.f19821c.loadDataWithBaseURL(com.facebook.ads.internal.q.c.b.a(), a2.d(), AudienceNetworkActivity.WEBVIEW_MIME_TYPE, AudienceNetworkActivity.WEBVIEW_ENCODING, (String) null);
        BannerAdapterListener bannerAdapterListener = this.f19823e;
        if (bannerAdapterListener != null) {
            bannerAdapterListener.onBannerAdLoaded(this, this.f19821c);
        }
    }

    public void loadBannerAd(Context context, c cVar, com.facebook.ads.internal.protocol.e eVar, BannerAdapterListener bannerAdapterListener, Map<String, Object> map) {
        this.f19826h = context;
        this.f19825g = cVar;
        this.f19823e = bannerAdapterListener;
        this.f19824f = map;
        a((d) map.get("definition"));
    }

    public void onDestroy() {
        com.facebook.ads.internal.view.b.a aVar = this.f19821c;
        if (aVar != null) {
            aVar.destroy();
            this.f19821c = null;
            this.f19820b = null;
        }
    }
}
