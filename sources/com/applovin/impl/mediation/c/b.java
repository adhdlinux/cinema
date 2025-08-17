package com.applovin.impl.mediation.c;

import android.content.Context;
import com.applovin.impl.mediation.a.g;
import com.applovin.impl.mediation.a.h;
import com.applovin.impl.sdk.c.d;
import com.applovin.impl.sdk.e.o;
import com.applovin.impl.sdk.e.z;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.v;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.sdk.AppLovinSdkUtils;
import com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b extends com.applovin.impl.sdk.e.a {

    /* renamed from: a  reason: collision with root package name */
    private static String f14381a;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final MaxAdFormat f14382c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, Object> f14383d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final Context f14384e;

    /* renamed from: f  reason: collision with root package name */
    private final a f14385f;

    public interface a {
        void a(JSONArray jSONArray);
    }

    /* renamed from: com.applovin.impl.mediation.c.b$b  reason: collision with other inner class name */
    private static class C0013b implements g.a, Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final a f14389a;

        /* renamed from: b  reason: collision with root package name */
        private final Object f14390b;

        /* renamed from: c  reason: collision with root package name */
        private int f14391c;

        /* renamed from: d  reason: collision with root package name */
        private final AtomicBoolean f14392d;

        /* renamed from: e  reason: collision with root package name */
        private final Collection<g> f14393e;

        /* renamed from: f  reason: collision with root package name */
        private final v f14394f;

        private C0013b(int i2, a aVar, v vVar) {
            this.f14391c = i2;
            this.f14389a = aVar;
            this.f14394f = vVar;
            this.f14390b = new Object();
            this.f14393e = new ArrayList(i2);
            this.f14392d = new AtomicBoolean();
        }

        private void a() {
            ArrayList<g> arrayList;
            String str;
            String d2;
            synchronized (this.f14390b) {
                arrayList = new ArrayList<>(this.f14393e);
            }
            JSONArray jSONArray = new JSONArray();
            for (g gVar : arrayList) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    h a2 = gVar.a();
                    jSONObject.put("name", a2.L());
                    jSONObject.put("class", a2.K());
                    jSONObject.put("adapter_version", gVar.c());
                    jSONObject.put("sdk_version", gVar.b());
                    JSONObject jSONObject2 = new JSONObject();
                    if (StringUtils.isValidString(gVar.e())) {
                        str = "error_message";
                        d2 = gVar.e();
                    } else {
                        str = "signal";
                        d2 = gVar.d();
                    }
                    jSONObject2.put(str, d2);
                    jSONObject.put("data", jSONObject2);
                    jSONArray.put(jSONObject);
                    if (v.a()) {
                        v vVar = this.f14394f;
                        vVar.b("TaskCollectSignals", "Collected signal from " + a2);
                    }
                } catch (JSONException e2) {
                    if (v.a()) {
                        this.f14394f.b("TaskCollectSignals", "Failed to create signal data", e2);
                    }
                }
            }
            a(jSONArray);
        }

        private void a(JSONArray jSONArray) {
            a aVar = this.f14389a;
            if (aVar != null) {
                aVar.a(jSONArray);
            }
        }

        public void a(g gVar) {
            boolean z2;
            synchronized (this.f14390b) {
                this.f14393e.add(gVar);
                int i2 = this.f14391c - 1;
                this.f14391c = i2;
                z2 = i2 < 1;
            }
            if (z2 && this.f14392d.compareAndSet(false, true)) {
                a();
            }
        }

        public void run() {
            if (this.f14392d.compareAndSet(false, true)) {
                a();
            }
        }
    }

    static {
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(a("APPLOVIN_NETWORK", "com.applovin.mediation.adapters.AppLovinMediationAdapter"));
            a("FACEBOOK_NETWORK", "com.applovin.mediation.adapters.FacebookMediationAdapter").put("run_on_ui_thread", false);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("signal_providers", jSONArray);
            f14381a = jSONObject.toString();
        } catch (JSONException unused) {
        }
    }

    public b(MaxAdFormat maxAdFormat, Map<String, Object> map, Context context, m mVar, a aVar) {
        super("TaskCollectSignals", mVar);
        this.f14382c = maxAdFormat;
        this.f14383d = map;
        this.f14384e = context;
        this.f14385f = aVar;
    }

    private static JSONObject a(String str, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("name", str);
        jSONObject.put("class", str2);
        jSONObject.put("adapter_timeout_ms", HttpUrlConnectionNetworkFetcher.HTTP_DEFAULT_TIMEOUT);
        jSONObject.put("max_signal_length", 32768);
        jSONObject.put("scode", "");
        return jSONObject;
    }

    private void a(final h hVar, final g.a aVar) {
        if (hVar.S()) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    b.this.f15333b.E().collectSignal(b.this.f14382c, hVar, b.this.f14384e, aVar);
                }
            });
        } else {
            this.f15333b.E().collectSignal(this.f14382c, hVar, this.f14384e, aVar);
        }
    }

    private void a(JSONArray jSONArray, JSONObject jSONObject) throws JSONException, InterruptedException {
        C0013b bVar = new C0013b(jSONArray.length(), this.f14385f, this.f15333b.A());
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            a(new h(this.f14383d, jSONArray.getJSONObject(i2), jSONObject, this.f15333b), (g.a) bVar);
        }
        this.f15333b.S().a((com.applovin.impl.sdk.e.a) new z(this.f15333b, bVar), o.a.MAIN, ((Long) this.f15333b.a(com.applovin.impl.sdk.c.a.f15189k)).longValue());
    }

    private void b(String str, Throwable th) {
        if (v.a()) {
            a("No signals collected: " + str, th);
        }
        a aVar = this.f14385f;
        if (aVar != null) {
            aVar.a(new JSONArray());
        }
    }

    public void run() {
        String str;
        try {
            JSONObject jSONObject = new JSONObject((String) this.f15333b.b(d.f15238x, f14381a));
            JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "signal_providers", (JSONArray) null);
            if (jSONArray != null) {
                if (jSONArray.length() != 0) {
                    a(jSONArray, jSONObject);
                    return;
                }
            }
            b("No signal providers found", (Throwable) null);
        } catch (JSONException e2) {
            th = e2;
            str = "Failed to parse signals JSON";
            b(str, th);
        } catch (InterruptedException e3) {
            th = e3;
            str = "Failed to wait for signals";
            b(str, th);
        } catch (Throwable th) {
            th = th;
            str = "Failed to collect signals";
            b(str, th);
        }
    }
}
