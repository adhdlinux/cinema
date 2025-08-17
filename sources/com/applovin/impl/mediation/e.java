package com.applovin.impl.mediation;

import android.app.Activity;
import com.applovin.impl.mediation.a.f;
import com.applovin.impl.sdk.c.d;
import com.applovin.impl.sdk.e.a;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.v;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.mediation.adapter.parameters.MaxAdapterInitializationParameters;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class e {

    /* renamed from: a  reason: collision with root package name */
    private final m f14793a;

    /* renamed from: b  reason: collision with root package name */
    private final v f14794b;

    /* renamed from: c  reason: collision with root package name */
    private final AtomicBoolean f14795c = new AtomicBoolean();

    /* renamed from: d  reason: collision with root package name */
    private final JSONArray f14796d = new JSONArray();

    /* renamed from: e  reason: collision with root package name */
    private final LinkedHashSet<String> f14797e = new LinkedHashSet<>();

    /* renamed from: f  reason: collision with root package name */
    private final Object f14798f = new Object();

    /* renamed from: g  reason: collision with root package name */
    private List<f> f14799g;

    public e(m mVar) {
        this.f14793a = mVar;
        this.f14794b = mVar.A();
    }

    private List<f> a(JSONArray jSONArray, JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            arrayList.add(new f(Collections.EMPTY_MAP, JsonUtils.getJSONObject(jSONArray, i2, (JSONObject) null), jSONObject, this.f14793a));
        }
        return arrayList;
    }

    public void a(Activity activity) {
        if (this.f14795c.compareAndSet(false, true)) {
            String str = (String) this.f14793a.a(d.f15239y);
            if (StringUtils.isValidString(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    List<f> a2 = a(JsonUtils.getJSONArray(jSONObject, this.f14793a.J().a() ? "test_mode_auto_init_adapters" : "auto_init_adapters", new JSONArray()), jSONObject);
                    this.f14799g = a2;
                    this.f14793a.S().a((a) new com.applovin.impl.mediation.c.a(a2, activity, this.f14793a));
                } catch (JSONException e2) {
                    if (v.a()) {
                        this.f14794b.b("MediationAdapterInitializationManager", "Failed to parse auto-init adapters JSON", e2);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(f fVar, long j2, MaxAdapter.InitializationStatus initializationStatus, String str) {
        boolean z2;
        if (initializationStatus != null && initializationStatus != MaxAdapter.InitializationStatus.INITIALIZING) {
            synchronized (this.f14798f) {
                z2 = !a(fVar);
                if (z2) {
                    this.f14797e.add(fVar.K());
                    JSONObject jSONObject = new JSONObject();
                    JsonUtils.putString(jSONObject, "class", fVar.K());
                    JsonUtils.putString(jSONObject, "init_status", String.valueOf(initializationStatus.getCode()));
                    JsonUtils.putString(jSONObject, "error_message", JSONObject.quote(str));
                    this.f14796d.put(jSONObject);
                }
            }
            if (z2) {
                this.f14793a.a(fVar);
                this.f14793a.E().processAdapterInitializationPostback(fVar, j2, initializationStatus, str);
                this.f14793a.ag().a(initializationStatus, fVar.K());
            }
        }
    }

    public void a(f fVar, Activity activity) {
        a(fVar, activity, (Runnable) null);
    }

    public void a(f fVar, Activity activity, Runnable runnable) {
        List<f> list;
        if (this.f14793a.J().a() && (list = this.f14799g) != null) {
            Iterator<f> it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    fVar = null;
                    break;
                }
                f next = it2.next();
                if (next.K().equals(fVar.K())) {
                    fVar = next;
                    break;
                }
            }
        }
        if (fVar != null) {
            g a2 = this.f14793a.C().a(fVar);
            if (a2 != null) {
                if (v.a()) {
                    v vVar = this.f14794b;
                    vVar.c("MediationAdapterInitializationManager", "Initializing adapter " + fVar);
                }
                a2.a((MaxAdapterInitializationParameters) MaxAdapterParametersImpl.a(fVar), activity, runnable);
            } else if (runnable != null) {
                runnable.run();
            }
        } else if (runnable != null) {
            runnable.run();
        }
    }

    public void a(MaxAdapter.InitializationStatus initializationStatus) {
        this.f14793a.ag().a(initializationStatus, "com.applovin.mediation.adapters.AppLovinMediationAdapter");
    }

    public boolean a() {
        return this.f14795c.get();
    }

    /* access modifiers changed from: package-private */
    public boolean a(f fVar) {
        boolean contains;
        synchronized (this.f14798f) {
            contains = this.f14797e.contains(fVar.K());
        }
        return contains;
    }

    public LinkedHashSet<String> b() {
        LinkedHashSet<String> linkedHashSet;
        synchronized (this.f14798f) {
            linkedHashSet = this.f14797e;
        }
        return linkedHashSet;
    }

    public JSONArray c() {
        JSONArray jSONArray;
        synchronized (this.f14798f) {
            jSONArray = this.f14796d;
        }
        return jSONArray;
    }
}
