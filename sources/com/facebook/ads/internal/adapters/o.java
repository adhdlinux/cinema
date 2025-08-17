package com.facebook.ads.internal.adapters;

import android.content.Context;
import android.view.View;
import com.facebook.ads.internal.n.c;
import com.facebook.ads.internal.n.f;
import com.facebook.ads.internal.n.h;
import com.facebook.ads.internal.n.j;
import com.facebook.ads.internal.n.k;
import com.facebook.ads.internal.n.m;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.facebook.ads.internal.protocol.a;
import com.facebook.ads.internal.q.a.d;
import com.flurry.android.FlurryAgent;
import com.flurry.android.ads.FlurryAdErrorType;
import com.flurry.android.ads.FlurryAdNative;
import com.flurry.android.ads.FlurryAdNativeAsset;
import com.flurry.android.ads.FlurryAdNativeListener;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class o extends y implements u {

    /* renamed from: a  reason: collision with root package name */
    private static volatile boolean f19948a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public z f19949b;

    /* renamed from: c  reason: collision with root package name */
    private FlurryAdNative f19950c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public boolean f19951d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public String f19952e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public String f19953f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public String f19954g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public String f19955h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public String f19956i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public h f19957j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public h f19958k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public h f19959l;

    public String A() {
        return null;
    }

    public String B() {
        return null;
    }

    public m C() {
        return m.DEFAULT;
    }

    public int D() {
        return 0;
    }

    public String E() {
        return null;
    }

    public List<f> F() {
        return null;
    }

    public int G() {
        return 0;
    }

    public int H() {
        return 0;
    }

    public c I() {
        return c.FLURRY;
    }

    public f J() {
        return f.YAHOO;
    }

    public void a(int i2) {
    }

    public void a(final Context context, z zVar, com.facebook.ads.internal.m.c cVar, Map<String, Object> map, f.c cVar2) {
        JSONObject jSONObject = (JSONObject) map.get("data");
        String optString = jSONObject.optString("api_key");
        String optString2 = jSONObject.optString("placement_id");
        synchronized (o.class) {
            if (!f19948a) {
                d.a(context, v.a(J()) + " Initializing");
                FlurryAgent.setLogEnabled(true);
                FlurryAgent.init(context, optString);
                f19948a = true;
            }
        }
        d.a(context, v.a(J()) + " Loading");
        this.f19949b = zVar;
        FlurryAdNative flurryAdNative = new FlurryAdNative(context, optString2);
        this.f19950c = flurryAdNative;
        flurryAdNative.setListener(new FlurryAdNativeListener() {
            public void onAppExit(FlurryAdNative flurryAdNative) {
            }

            public void onClicked(FlurryAdNative flurryAdNative) {
                if (o.this.f19949b != null) {
                    o.this.f19949b.c(o.this);
                }
            }

            public void onCloseFullscreen(FlurryAdNative flurryAdNative) {
            }

            public void onCollapsed(FlurryAdNative flurryAdNative) {
            }

            public void onError(FlurryAdNative flurryAdNative, FlurryAdErrorType flurryAdErrorType, int i2) {
                Context context = context;
                d.a(context, v.a(o.this.J()) + " Failed with FlurryError: " + flurryAdErrorType.toString());
                if (o.this.f19949b != null) {
                    o.this.f19949b.a(o.this, a.a(AdErrorType.MEDIATION_ERROR, flurryAdErrorType.toString()));
                }
            }

            public void onExpanded(FlurryAdNative flurryAdNative) {
            }

            public void onFetched(FlurryAdNative flurryAdNative) {
                String str;
                o oVar;
                if (o.this.f19949b != null) {
                    if (flurryAdNative.isVideoAd()) {
                        Context context = context;
                        d.a(context, v.a(o.this.J()) + " Failed. AN does not support Flurry video ads");
                        o.this.f19949b.a(o.this, new a(AdErrorType.MEDIATION_ERROR, "video ad"));
                        return;
                    }
                    boolean unused = o.this.f19951d = true;
                    FlurryAdNativeAsset asset = flurryAdNative.getAsset("headline");
                    if (asset != null) {
                        String unused2 = o.this.f19952e = asset.getValue();
                    }
                    FlurryAdNativeAsset asset2 = flurryAdNative.getAsset("summary");
                    if (asset2 != null) {
                        String unused3 = o.this.f19953f = asset2.getValue();
                    }
                    FlurryAdNativeAsset asset3 = flurryAdNative.getAsset("source");
                    if (asset3 != null) {
                        String unused4 = o.this.f19954g = asset3.getValue();
                    }
                    FlurryAdNativeAsset asset4 = flurryAdNative.getAsset("appCategory");
                    if (asset4 != null) {
                        String unused5 = o.this.f19956i = asset4.getValue();
                    }
                    FlurryAdNativeAsset asset5 = flurryAdNative.getAsset("callToAction");
                    if (asset5 != null) {
                        String unused6 = o.this.f19955h = asset5.getValue();
                    } else {
                        if (flurryAdNative.getAsset("appRating") != null) {
                            oVar = o.this;
                            str = "Install Now";
                        } else {
                            oVar = o.this;
                            str = "Learn More";
                        }
                        String unused7 = oVar.f19955h = str;
                    }
                    FlurryAdNativeAsset asset6 = flurryAdNative.getAsset("secImage");
                    if (asset6 != null) {
                        h unused8 = o.this.f19957j = new h(asset6.getValue(), 82, 82);
                    }
                    FlurryAdNativeAsset asset7 = flurryAdNative.getAsset("secHqImage");
                    if (asset7 != null) {
                        h unused9 = o.this.f19958k = new h(asset7.getValue(), 1200, 627);
                    }
                    FlurryAdNativeAsset asset8 = flurryAdNative.getAsset("secBrandingLogo");
                    if (asset8 != null) {
                        h unused10 = o.this.f19959l = new h(asset8.getValue(), 20, 20);
                    }
                    Context context2 = context;
                    d.a(context2, v.a(o.this.J()) + " Loaded");
                    o.this.f19949b.a(o.this);
                }
            }

            public void onImpressionLogged(FlurryAdNative flurryAdNative) {
                if (o.this.f19949b != null) {
                    o.this.f19949b.b(o.this);
                }
            }

            public void onShowFullscreen(FlurryAdNative flurryAdNative) {
            }
        });
        this.f19950c.fetchAd();
    }

    public void a(View view, List<View> list) {
        FlurryAdNative flurryAdNative = this.f19950c;
        if (flurryAdNative != null) {
            flurryAdNative.setTrackingView(view);
        }
    }

    public void a(z zVar) {
        this.f19949b = zVar;
    }

    public void a(Map<String, String> map) {
    }

    public void b(Map<String, String> map) {
    }

    public void b_() {
        FlurryAdNative flurryAdNative = this.f19950c;
        if (flurryAdNative != null) {
            flurryAdNative.removeTrackingView();
        }
    }

    public String c() {
        return null;
    }

    public boolean c_() {
        return this.f19951d;
    }

    public boolean d() {
        return false;
    }

    public boolean e() {
        return false;
    }

    public boolean f() {
        return false;
    }

    public boolean g() {
        return true;
    }

    public int h() {
        return 0;
    }

    public int i() {
        return 0;
    }

    public int j() {
        return 0;
    }

    public h k() {
        return this.f19957j;
    }

    public h l() {
        return this.f19958k;
    }

    public k m() {
        return null;
    }

    public String n() {
        return null;
    }

    public String o() {
        return null;
    }

    public void onDestroy() {
        b_();
        this.f19949b = null;
        FlurryAdNative flurryAdNative = this.f19950c;
        if (flurryAdNative != null) {
            flurryAdNative.destroy();
            this.f19950c = null;
        }
    }

    public String p() {
        return this.f19953f;
    }

    public String q() {
        return this.f19955h;
    }

    public String r() {
        return this.f19956i;
    }

    public String s() {
        return null;
    }

    public String t() {
        return null;
    }

    public String u() {
        return null;
    }

    public String v() {
        return null;
    }

    public j w() {
        return null;
    }

    public h x() {
        return this.f19959l;
    }

    public String y() {
        return null;
    }

    public String z() {
        return "Ad";
    }
}
