package com.applovin.impl.sdk;

import android.content.Intent;
import android.text.TextUtils;
import com.applovin.impl.sdk.c.b;
import com.applovin.impl.sdk.c.d;
import com.applovin.impl.sdk.e.a;
import com.applovin.impl.sdk.e.o;
import com.applovin.impl.sdk.e.z;
import com.applovin.impl.sdk.network.h;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.sdk.AppLovinEventParameters;
import com.applovin.sdk.AppLovinEventService;
import com.applovin.sdk.AppLovinEventTypes;
import com.google.android.gms.cast.HlsSegmentFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class EventServiceImpl implements AppLovinEventService {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final m f14982a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, Object> f14983b;

    /* renamed from: c  reason: collision with root package name */
    private final AtomicBoolean f14984c = new AtomicBoolean();

    public EventServiceImpl(m mVar) {
        this.f14982a = mVar;
        if (((Boolean) mVar.a(b.be)).booleanValue()) {
            this.f14983b = JsonUtils.toStringObjectMap((String) mVar.b(d.f15234t, JsonUtils.EMPTY_JSON), new HashMap());
            return;
        }
        this.f14983b = new HashMap();
        mVar.a(d.f15234t, JsonUtils.EMPTY_JSON);
    }

    /* access modifiers changed from: private */
    public String a() {
        return ((String) this.f14982a.a(b.aV)) + "4.0/pix";
    }

    /* access modifiers changed from: private */
    public Map<String, String> a(p pVar, Map<String, String> map) {
        HashMap hashMap = new HashMap();
        if (map != null) {
            hashMap.putAll(map);
        }
        boolean contains = this.f14982a.b(b.bc).contains(pVar.a());
        hashMap.put("AppLovin-Event", contains ? pVar.a() : "postinstall");
        if (!contains) {
            hashMap.put("AppLovin-Sub-Event", pVar.a());
        }
        return hashMap;
    }

    /* access modifiers changed from: private */
    public Map<String, String> a(p pVar, boolean z2) {
        boolean contains = this.f14982a.b(b.bc).contains(pVar.a());
        Map<String, Object> a2 = this.f14982a.V().a((Map<String, String>) null, z2, false);
        a2.put("event", contains ? pVar.a() : "postinstall");
        a2.put("event_id", pVar.d());
        a2.put(HlsSegmentFormat.TS, Long.toString(pVar.c()));
        if (!contains) {
            a2.put("sub_event", pVar.a());
        }
        return Utils.stringifyObjectMap(a2);
    }

    /* access modifiers changed from: private */
    public String b() {
        return ((String) this.f14982a.a(b.aW)) + "4.0/pix";
    }

    private void c() {
        if (((Boolean) this.f14982a.a(b.be)).booleanValue()) {
            this.f14982a.a(d.f15234t, CollectionUtils.toJsonString(this.f14983b, JsonUtils.EMPTY_JSON));
        }
    }

    public Map<String, Object> getSuperProperties() {
        return new HashMap(this.f14983b);
    }

    public void maybeTrackAppOpenEvent() {
        if (this.f14984c.compareAndSet(false, true)) {
            this.f14982a.w().trackEvent("landing");
        }
    }

    public void setSuperProperty(Object obj, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (obj == null) {
                this.f14983b.remove(str);
            } else {
                List<String> b2 = this.f14982a.b(b.bd);
                if (Utils.objectIsOfType(obj, b2, this.f14982a)) {
                    this.f14983b.put(str, Utils.sanitizeSuperProperty(obj, this.f14982a));
                } else if (v.a()) {
                    v.i("AppLovinEventService", "Failed to set super property '" + obj + "' for key '" + str + "' - valid super property types include: " + b2);
                    return;
                } else {
                    return;
                }
            }
            c();
        } else if (v.a()) {
            v.i("AppLovinEventService", "Super property key cannot be null or empty");
        }
    }

    public String toString() {
        return "EventService{}";
    }

    public void trackCheckout(String str, Map<String, String> map) {
        HashMap hashMap;
        if (map == null) {
            hashMap = new HashMap(1);
        }
        hashMap.put(AppLovinEventParameters.CHECKOUT_TRANSACTION_IDENTIFIER, str);
        trackEvent(AppLovinEventTypes.USER_COMPLETED_CHECKOUT, hashMap);
    }

    public void trackEvent(String str) {
        trackEvent(str, new HashMap());
    }

    public void trackEvent(String str, Map<String, String> map) {
        trackEvent(str, map, (Map<String, String>) null);
    }

    public void trackEvent(String str, Map<String, String> map, final Map<String, String> map2) {
        if (v.a()) {
            v A = this.f14982a.A();
            A.b("AppLovinEventService", "Tracking event: \"" + str + "\" with parameters: " + map);
        }
        final p pVar = new p(str, map, this.f14983b);
        try {
            this.f14982a.S().a((a) new z(this.f14982a, new Runnable() {
                public void run() {
                    EventServiceImpl.this.f14982a.U().a(h.o().c(EventServiceImpl.this.a()).d(EventServiceImpl.this.b()).a((Map<String, String>) EventServiceImpl.this.a(pVar, false)).b((Map<String, String>) EventServiceImpl.this.a(pVar, (Map<String, String>) map2)).c(pVar.b()).b(((Boolean) EventServiceImpl.this.f14982a.a(b.ey)).booleanValue()).a(((Boolean) EventServiceImpl.this.f14982a.a(b.ep)).booleanValue()).a());
                }
            }), o.a.BACKGROUND);
        } catch (Throwable th) {
            if (v.a()) {
                v A2 = this.f14982a.A();
                A2.b("AppLovinEventService", "Unable to track event: " + pVar, th);
            }
        }
    }

    public void trackEventSynchronously(String str) {
        if (v.a()) {
            v A = this.f14982a.A();
            A.b("AppLovinEventService", "Tracking event: \"" + str + "\" synchronously");
        }
        p pVar = new p(str, new HashMap(), this.f14983b);
        this.f14982a.U().a(h.o().c(a()).d(b()).a(a(pVar, true)).b(a(pVar, (Map<String, String>) null)).c(pVar.b()).b(((Boolean) this.f14982a.a(b.ey)).booleanValue()).a(((Boolean) this.f14982a.a(b.ep)).booleanValue()).a());
    }

    public void trackInAppPurchase(Intent intent, Map<String, String> map) {
        HashMap hashMap;
        if (map == null) {
            hashMap = new HashMap();
        }
        try {
            hashMap.put(AppLovinEventParameters.IN_APP_PURCHASE_DATA, intent.getStringExtra("INAPP_PURCHASE_DATA"));
            hashMap.put(AppLovinEventParameters.IN_APP_DATA_SIGNATURE, intent.getStringExtra("INAPP_DATA_SIGNATURE"));
        } catch (Throwable th) {
            if (v.a()) {
                v.c("AppLovinEventService", "Unable to track in app purchase - invalid purchase intent", th);
            }
        }
        trackEvent("iap", hashMap);
    }
}
