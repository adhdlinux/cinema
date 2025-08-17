package com.applovin.impl.mediation;

import android.content.Context;
import com.applovin.impl.mediation.ads.a;
import com.applovin.impl.mediation.c.b;
import com.applovin.impl.mediation.c.c;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.impl.sdk.utils.j;
import com.applovin.impl.sdk.v;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;

public class d {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final m f14430a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, b> f14431b = new HashMap(4);

    /* renamed from: c  reason: collision with root package name */
    private final Object f14432c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, com.applovin.impl.mediation.a.a> f14433d = new HashMap(4);

    /* renamed from: e  reason: collision with root package name */
    private final Object f14434e = new Object();

    private static class a implements a.C0011a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final m f14442a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final WeakReference<Context> f14443b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final d f14444c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public final b f14445d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public final MaxAdFormat f14446e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public final Map<String, Object> f14447f;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public final Map<String, Object> f14448g;

        /* renamed from: h  reason: collision with root package name */
        private final int f14449h;

        private a(Map<String, Object> map, Map<String, Object> map2, b bVar, MaxAdFormat maxAdFormat, d dVar, m mVar, Context context) {
            this.f14442a = mVar;
            this.f14443b = new WeakReference<>(context);
            this.f14444c = dVar;
            this.f14445d = bVar;
            this.f14446e = maxAdFormat;
            this.f14448g = map2;
            this.f14447f = map;
            this.f14449h = CollectionUtils.getBoolean(map2, "disable_auto_retries") ? -1 : (!maxAdFormat.isAdViewAd() || !CollectionUtils.getBoolean(map2, "auto_refresh_stopped")) ? ((Integer) mVar.a(com.applovin.impl.sdk.c.a.N)).intValue() : Math.min(2, ((Integer) mVar.a(com.applovin.impl.sdk.c.a.N)).intValue());
        }

        public void onAdClicked(MaxAd maxAd) {
        }

        public void onAdDisplayFailed(MaxAd maxAd, MaxError maxError) {
        }

        public void onAdDisplayed(MaxAd maxAd) {
        }

        public void onAdHidden(MaxAd maxAd) {
            throw new IllegalStateException("Wrong callback invoked for ad: " + maxAd);
        }

        public void onAdLoadFailed(final String str, MaxError maxError) {
            if (!this.f14442a.a(com.applovin.impl.sdk.c.a.O, this.f14446e) || this.f14445d.f14456c >= this.f14449h) {
                int unused = this.f14445d.f14456c = 0;
                this.f14445d.f14455b.set(false);
                if (this.f14445d.f14457d != null) {
                    ((MaxErrorImpl) maxError).setLoadTag(this.f14445d.f14454a);
                    j.a((MaxAdListener) this.f14445d.f14457d, str, maxError);
                    a.C0011a unused2 = this.f14445d.f14457d = null;
                    return;
                }
                return;
            }
            b.e(this.f14445d);
            final int pow = (int) Math.pow(2.0d, (double) this.f14445d.f14456c);
            AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
                public void run() {
                    a.this.f14448g.put("retry_delay_sec", Integer.valueOf(pow));
                    a.this.f14448g.put("retry_attempt", Integer.valueOf(a.this.f14445d.f14456c));
                    Context context = (Context) a.this.f14443b.get();
                    if (context == null) {
                        context = a.this.f14442a.L();
                    }
                    a.this.f14444c.a(str, a.this.f14446e, a.this.f14447f, a.this.f14448g, context, a.this);
                }
            }, TimeUnit.SECONDS.toMillis((long) pow));
        }

        public void onAdLoaded(MaxAd maxAd) {
            com.applovin.impl.mediation.a.a aVar = (com.applovin.impl.mediation.a.a) maxAd;
            aVar.a(this.f14445d.f14454a);
            int unused = this.f14445d.f14456c = 0;
            if (this.f14445d.f14457d != null) {
                aVar.g().e().a(this.f14445d.f14457d);
                this.f14445d.f14457d.onAdLoaded(aVar);
                if (aVar.d().endsWith("load")) {
                    this.f14445d.f14457d.onAdRevenuePaid(aVar);
                }
                a.C0011a unused2 = this.f14445d.f14457d = null;
                if ((this.f14442a.b(com.applovin.impl.sdk.c.a.M).contains(maxAd.getAdUnitId()) || this.f14442a.a(com.applovin.impl.sdk.c.a.L, maxAd.getFormat())) && !this.f14442a.J().a() && !this.f14442a.J().b()) {
                    Context context = this.f14443b.get();
                    if (context == null) {
                        context = this.f14442a.L();
                    }
                    this.f14444c.a(maxAd.getAdUnitId(), maxAd.getFormat(), this.f14447f, this.f14448g, context, this);
                    return;
                }
            } else {
                this.f14444c.a(aVar);
            }
            this.f14445d.f14455b.set(false);
        }

        public void onAdRevenuePaid(MaxAd maxAd) {
        }
    }

    private static class b {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final String f14454a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final AtomicBoolean f14455b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public int f14456c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public volatile a.C0011a f14457d;

        private b(String str) {
            this.f14455b = new AtomicBoolean();
            this.f14454a = str;
        }

        static /* synthetic */ int e(b bVar) {
            int i2 = bVar.f14456c;
            bVar.f14456c = i2 + 1;
            return i2;
        }
    }

    public d(m mVar) {
        this.f14430a = mVar;
    }

    private b a(String str, String str2) {
        String str3;
        b bVar;
        synchronized (this.f14432c) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            if (StringUtils.isValidString(str2)) {
                str3 = "-" + str2;
            } else {
                str3 = "";
            }
            sb.append(str3);
            String sb2 = sb.toString();
            bVar = this.f14431b.get(sb2);
            if (bVar == null) {
                bVar = new b(str2);
                this.f14431b.put(sb2, bVar);
            }
        }
        return bVar;
    }

    /* access modifiers changed from: private */
    public void a(com.applovin.impl.mediation.a.a aVar) {
        synchronized (this.f14434e) {
            if (this.f14433d.containsKey(aVar.getAdUnitId()) && v.a()) {
                v.i("AppLovinSdk", "Ad in cache already: " + aVar.getAdUnitId());
            }
            this.f14433d.put(aVar.getAdUnitId(), aVar);
        }
    }

    /* access modifiers changed from: private */
    public void a(String str, MaxAdFormat maxAdFormat, Map<String, Object> map, Map<String, Object> map2, Context context, a.C0011a aVar) {
        final String str2 = str;
        final MaxAdFormat maxAdFormat2 = maxAdFormat;
        final Map<String, Object> map3 = map;
        final Map<String, Object> map4 = map2;
        final Context context2 = context;
        final a.C0011a aVar2 = aVar;
        this.f14430a.S().a((com.applovin.impl.sdk.e.a) new com.applovin.impl.mediation.c.b(maxAdFormat, map, context, this.f14430a, new b.a() {
            public void a(JSONArray jSONArray) {
                d.this.f14430a.S().a((com.applovin.impl.sdk.e.a) new c(str2, maxAdFormat2, map3, map4, jSONArray, context2, d.this.f14430a, aVar2));
            }
        }), com.applovin.impl.mediation.d.c.a(maxAdFormat));
    }

    private com.applovin.impl.mediation.a.a b(String str) {
        com.applovin.impl.mediation.a.a aVar;
        synchronized (this.f14434e) {
            aVar = this.f14433d.get(str);
            this.f14433d.remove(str);
        }
        return aVar;
    }

    public void a(String str, String str2, MaxAdFormat maxAdFormat, Map<String, Object> map, Map<String, Object> map2, Context context, a.C0011a aVar) {
        a.C0011a aVar2 = aVar;
        com.applovin.impl.mediation.a.a b2 = (this.f14430a.J().b() || Utils.isDspDemoApp(this.f14430a.L())) ? null : b(str);
        String str3 = str2;
        if (b2 != null) {
            b2.a(str2);
            b2.g().e().a(aVar2);
            aVar2.onAdLoaded(b2);
            if (b2.d().endsWith("load")) {
                aVar2.onAdRevenuePaid(b2);
            }
        }
        b a2 = a(str, str2);
        if (a2.f14455b.compareAndSet(false, true)) {
            if (b2 == null) {
                a.C0011a unused = a2.f14457d = aVar2;
            }
            a(str, maxAdFormat, map, map2, context, new a(map, map2, a2, maxAdFormat, this, this.f14430a, context));
            return;
        }
        if (!(a2.f14457d == null || a2.f14457d == aVar2 || !v.a())) {
            StringBuilder sb = new StringBuilder();
            sb.append("Attempting to load ad for same ad unit id (");
            String str4 = str;
            sb.append(str);
            sb.append(") while another ad load is already in progress!");
            v.h("MediationAdLoadManager", sb.toString());
        }
        a.C0011a unused2 = a2.f14457d = aVar2;
    }

    public boolean a(String str) {
        boolean z2;
        synchronized (this.f14434e) {
            z2 = this.f14433d.get(str) != null;
        }
        return z2;
    }
}
