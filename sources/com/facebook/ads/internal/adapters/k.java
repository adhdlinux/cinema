package com.facebook.ads.internal.adapters;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import com.facebook.ads.AdError;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.CacheFlag;
import com.facebook.ads.InterstitialAdActivity;
import com.facebook.ads.internal.a.e;
import com.facebook.ads.internal.adapters.a.g;
import com.facebook.ads.internal.adapters.a.h;
import com.facebook.ads.internal.d.b;
import com.facebook.ads.internal.h.d;
import com.facebook.ads.internal.m.c;
import com.facebook.ads.internal.settings.a;
import com.unity3d.services.ads.adunit.AdUnitActivity;
import com.unity3d.services.core.device.MimeTypes;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.json.JSONObject;

public class k extends InterstitialAdapter {

    /* renamed from: a  reason: collision with root package name */
    private static final ConcurrentMap<String, com.facebook.ads.internal.view.a> f19854a = new ConcurrentHashMap();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final String f19855b = UUID.randomUUID().toString();

    /* renamed from: c  reason: collision with root package name */
    private String f19856c;

    /* renamed from: d  reason: collision with root package name */
    private long f19857d;

    /* renamed from: e  reason: collision with root package name */
    private Context f19858e;

    /* renamed from: f  reason: collision with root package name */
    private t f19859f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public InterstitialAdapterListener f19860g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public boolean f19861h = false;

    /* renamed from: i  reason: collision with root package name */
    private p f19862i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public a f19863j = a.UNSPECIFIED;

    /* renamed from: k  reason: collision with root package name */
    private g f19864k;

    /* renamed from: l  reason: collision with root package name */
    private a.C0036a f19865l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public boolean f19866m;

    public enum a {
        UNSPECIFIED,
        VERTICAL,
        HORIZONTAL;

        public static a a(int i2) {
            return i2 == 0 ? UNSPECIFIED : i2 == 2 ? HORIZONTAL : VERTICAL;
        }
    }

    private int a() {
        int rotation = ((WindowManager) this.f19858e.getSystemService("window")).getDefaultDisplay().getRotation();
        a aVar = this.f19863j;
        if (aVar == a.UNSPECIFIED) {
            return -1;
        }
        return aVar == a.HORIZONTAL ? (rotation == 2 || rotation == 3) ? 8 : 0 : rotation != 2 ? 1 : 9;
    }

    public static com.facebook.ads.internal.view.a a(String str) {
        return f19854a.get(str);
    }

    public static void a(com.facebook.ads.internal.view.a aVar) {
        for (Map.Entry next : f19854a.entrySet()) {
            if (next.getValue() == aVar) {
                f19854a.remove(next.getKey());
            }
        }
    }

    /* access modifiers changed from: private */
    public static void b(String str, com.facebook.ads.internal.view.a aVar) {
        f19854a.put(str, aVar);
    }

    public void loadInterstitialAd(Context context, InterstitialAdapterListener interstitialAdapterListener, Map<String, Object> map, c cVar, final EnumSet<CacheFlag> enumSet) {
        b bVar;
        com.facebook.ads.internal.d.a aVar;
        this.f19858e = context;
        this.f19860g = interstitialAdapterListener;
        this.f19856c = (String) map.get(AudienceNetworkActivity.PLACEMENT_ID);
        this.f19857d = ((Long) map.get(AudienceNetworkActivity.REQUEST_TIME)).longValue();
        JSONObject jSONObject = (JSONObject) map.get("data");
        d dVar = (d) map.get("definition");
        if (jSONObject.has("markup")) {
            this.f19865l = a.C0036a.INTERSTITIAL_WEB_VIEW;
            p a2 = p.a(jSONObject);
            this.f19862i = a2;
            if (e.a(context, a2, cVar)) {
                interstitialAdapterListener.onInterstitialError(this, AdError.NO_FILL);
                return;
            }
            t tVar = new t(context, this.f19855b, this, this.f19860g);
            this.f19859f = tVar;
            tVar.a();
            Map<String, String> f2 = this.f19862i.f();
            if (f2.containsKey(AdUnitActivity.EXTRA_ORIENTATION)) {
                this.f19863j = a.a(Integer.parseInt(f2.get(AdUnitActivity.EXTRA_ORIENTATION)));
            }
            this.f19861h = true;
            InterstitialAdapterListener interstitialAdapterListener2 = this.f19860g;
            if (interstitialAdapterListener2 != null) {
                interstitialAdapterListener2.onInterstitialAdLoaded(this);
            }
        } else if (jSONObject.has(MimeTypes.BASE_TYPE_VIDEO)) {
            this.f19865l = a.C0036a.INTERSTITIAL_OLD_NATIVE_VIDEO;
            t tVar2 = new t(context, this.f19855b, this, this.f19860g);
            this.f19859f = tVar2;
            tVar2.a();
            final l lVar = new l();
            lVar.a(context, (com.facebook.ads.a.a) new com.facebook.ads.a.a() {
                public void a(s sVar) {
                    boolean unused = k.this.f19861h = true;
                    if (k.this.f19860g != null) {
                        k.this.f19860g.onInterstitialAdLoaded(k.this);
                    }
                }

                public void a(s sVar, View view) {
                    a unused = k.this.f19863j = lVar.k();
                    k.b(k.this.f19855b, (com.facebook.ads.internal.view.a) lVar);
                }

                public void a(s sVar, AdError adError) {
                    lVar.l();
                    k.this.f19860g.onInterstitialError(k.this, adError);
                }

                public void b(s sVar) {
                    k.this.f19860g.onInterstitialAdClicked(k.this, "", true);
                }

                public void c(s sVar) {
                    k.this.f19860g.onInterstitialLoggingImpression(k.this);
                }

                public void d(s sVar) {
                }
            }, map, cVar, enumSet);
        } else {
            g a3 = g.a(jSONObject, context);
            this.f19864k = a3;
            if (dVar != null) {
                a3.a(dVar.k());
            }
            if (this.f19864k.d().size() == 0) {
                this.f19860g.onInterstitialError(this, AdError.NO_FILL);
            }
            t tVar3 = new t(context, this.f19855b, this, this.f19860g);
            this.f19859f = tVar3;
            tVar3.a();
            if (jSONObject.has("carousel")) {
                this.f19865l = a.C0036a.INTERSTITIAL_NATIVE_CAROUSEL;
                bVar = new b(context);
                bVar.a(this.f19864k.a().b(), -1, -1);
                List<h> d2 = this.f19864k.d();
                boolean contains = enumSet.contains(CacheFlag.VIDEO);
                for (h next : d2) {
                    bVar.a(next.c().g(), next.c().i(), next.c().h());
                    if (contains && !TextUtils.isEmpty(next.c().a())) {
                        bVar.a(next.c().g());
                    }
                }
                aVar = new com.facebook.ads.internal.d.a() {
                    private void a(boolean z2) {
                        boolean unused = k.this.f19866m = z2 && (enumSet.contains(CacheFlag.NONE) ^ true);
                        boolean unused2 = k.this.f19861h = true;
                        k.this.f19860g.onInterstitialAdLoaded(k.this);
                    }

                    public void a() {
                        a(true);
                    }

                    public void b() {
                        a(false);
                    }
                };
            } else if (jSONObject.has("video_url")) {
                this.f19865l = a.C0036a.INTERSTITIAL_NATIVE_VIDEO;
                bVar = new b(context);
                com.facebook.ads.internal.adapters.a.b c2 = this.f19864k.d().get(0).c();
                bVar.a(c2.g(), c2.i(), c2.h());
                bVar.a(this.f19864k.a().b(), -1, -1);
                if (enumSet.contains(CacheFlag.VIDEO)) {
                    bVar.a(c2.a());
                }
                aVar = new com.facebook.ads.internal.d.a() {
                    private void a(boolean z2) {
                        boolean unused = k.this.f19866m = z2;
                        boolean unused2 = k.this.f19861h = true;
                        k.this.f19860g.onInterstitialAdLoaded(k.this);
                    }

                    public void a() {
                        a(enumSet.contains(CacheFlag.VIDEO));
                    }

                    public void b() {
                        a(false);
                    }
                };
            } else {
                this.f19865l = a.C0036a.INTERSTITIAL_NATIVE_IMAGE;
                bVar = new b(context);
                com.facebook.ads.internal.adapters.a.b c3 = this.f19864k.d().get(0).c();
                bVar.a(c3.g(), c3.i(), c3.h());
                bVar.a(this.f19864k.a().b(), -1, -1);
                aVar = new com.facebook.ads.internal.d.a() {
                    private void c() {
                        boolean unused = k.this.f19861h = true;
                        k.this.f19860g.onInterstitialAdLoaded(k.this);
                    }

                    public void a() {
                        c();
                    }

                    public void b() {
                        c();
                    }
                };
            }
            bVar.a(aVar);
        }
    }

    public void onDestroy() {
        t tVar = this.f19859f;
        if (tVar != null) {
            tVar.b();
        }
    }

    public boolean show() {
        if (!this.f19861h) {
            InterstitialAdapterListener interstitialAdapterListener = this.f19860g;
            if (interstitialAdapterListener == null) {
                return false;
            }
            interstitialAdapterListener.onInterstitialError(this, AdError.INTERNAL_ERROR);
            return false;
        }
        Intent intent = new Intent(this.f19858e, AudienceNetworkActivity.class);
        intent.putExtra(AudienceNetworkActivity.PREDEFINED_ORIENTATION_KEY, a());
        intent.putExtra(AudienceNetworkActivity.AUDIENCE_NETWORK_UNIQUE_ID_EXTRA, this.f19855b);
        intent.putExtra(AudienceNetworkActivity.PLACEMENT_ID, this.f19856c);
        intent.putExtra(AudienceNetworkActivity.REQUEST_TIME, this.f19857d);
        intent.putExtra(AudienceNetworkActivity.VIEW_TYPE, this.f19865l);
        intent.putExtra(AudienceNetworkActivity.USE_CACHE, this.f19866m);
        g gVar = this.f19864k;
        if (gVar != null) {
            intent.putExtra("ad_data_bundle", gVar);
        } else {
            p pVar = this.f19862i;
            if (pVar != null) {
                pVar.a(intent);
            }
        }
        intent.addFlags(268435456);
        try {
            this.f19858e.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException unused) {
            intent.setClass(this.f19858e, InterstitialAdActivity.class);
            this.f19858e.startActivity(intent);
            return true;
        }
    }
}
