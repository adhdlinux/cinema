package com.applovin.impl.mediation.debugger;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import com.applovin.impl.mediation.debugger.b.b.b;
import com.applovin.impl.sdk.e.o;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.network.b;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.v;
import com.applovin.mediation.MaxDebuggerActivity;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

public class a implements b.c<JSONObject> {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static WeakReference<MaxDebuggerActivity> f14464a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final AtomicBoolean f14465b = new AtomicBoolean();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final m f14466c;

    /* renamed from: d  reason: collision with root package name */
    private final v f14467d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final com.applovin.impl.mediation.debugger.ui.b.b f14468e;

    /* renamed from: f  reason: collision with root package name */
    private final Map<String, com.applovin.impl.mediation.debugger.b.b.b> f14469f = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    private final AtomicBoolean f14470g = new AtomicBoolean();

    /* renamed from: h  reason: collision with root package name */
    private boolean f14471h;

    /* renamed from: i  reason: collision with root package name */
    private int f14472i = 2;

    /* renamed from: j  reason: collision with root package name */
    private boolean f14473j;

    /* renamed from: k  reason: collision with root package name */
    private final Context f14474k;

    public a(m mVar) {
        this.f14466c = mVar;
        this.f14467d = mVar.A();
        Context L = mVar.L();
        this.f14474k = L;
        this.f14468e = new com.applovin.impl.mediation.debugger.ui.b.b(L);
    }

    private List<com.applovin.impl.mediation.debugger.b.b.b> a(JSONObject jSONObject, m mVar) {
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "networks", new JSONArray());
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONArray, i2, (JSONObject) null);
            if (jSONObject2 != null) {
                com.applovin.impl.mediation.debugger.b.b.b bVar = new com.applovin.impl.mediation.debugger.b.b.b(jSONObject2, mVar);
                arrayList.add(bVar);
                this.f14469f.put(bVar.m(), bVar);
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    private List<com.applovin.impl.mediation.debugger.b.a.a> a(JSONObject jSONObject, List<com.applovin.impl.mediation.debugger.b.b.b> list, m mVar) {
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "ad_units", new JSONArray());
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONArray, i2, (JSONObject) null);
            if (jSONObject2 != null) {
                arrayList.add(new com.applovin.impl.mediation.debugger.b.a.a(jSONObject2, this.f14469f, mVar));
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    private void a(List<com.applovin.impl.mediation.debugger.b.b.b> list) {
        boolean z2;
        Iterator<com.applovin.impl.mediation.debugger.b.b.b> it2 = list.iterator();
        while (true) {
            if (!it2.hasNext()) {
                z2 = false;
                break;
            }
            com.applovin.impl.mediation.debugger.b.b.b next = it2.next();
            if (next.e() && next.a() == b.a.INVALID_INTEGRATION) {
                z2 = true;
                break;
            }
        }
        if (z2) {
            AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
                public void run() {
                    new AlertDialog.Builder(a.this.f14466c.af().a()).setTitle("Review Integration Errors").setMessage("Looks like MAX Mediation Debugger flagged several errors in your build. Make sure to resolve these before you go live.\n\nNote that this prompt will only be shown in your development builds. Live apps will not be affected.").setPositiveButton("Show Mediation Debugger", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i2) {
                            a.this.c();
                        }
                    }).setNegativeButton("DISMISS", (DialogInterface.OnClickListener) null).create().show();
                }
            }, TimeUnit.SECONDS.toMillis(2));
        }
    }

    private void f() {
        this.f14466c.af().a(new com.applovin.impl.sdk.utils.a() {
            public void onActivityCreated(Activity activity, Bundle bundle) {
                if (activity instanceof MaxDebuggerActivity) {
                    v.f("AppLovinSdk", "Started mediation debugger");
                    if (!a.this.g() || a.f14464a.get() != activity) {
                        MaxDebuggerActivity maxDebuggerActivity = (MaxDebuggerActivity) activity;
                        WeakReference unused = a.f14464a = new WeakReference(maxDebuggerActivity);
                        maxDebuggerActivity.setListAdapter(a.this.f14468e, a.this.f14466c.af());
                    }
                    a.f14465b.set(false);
                }
            }

            public void onActivityDestroyed(Activity activity) {
                if (activity instanceof MaxDebuggerActivity) {
                    v.f("AppLovinSdk", "Mediation debugger destroyed");
                    WeakReference unused = a.f14464a = null;
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public boolean g() {
        WeakReference<MaxDebuggerActivity> weakReference = f14464a;
        return (weakReference == null || weakReference.get() == null) ? false : true;
    }

    public void a() {
        if (this.f14470g.compareAndSet(false, true)) {
            this.f14466c.S().a((com.applovin.impl.sdk.e.a) new com.applovin.impl.mediation.debugger.c.a(this, this.f14466c), o.a.MEDIATION_MAIN);
        }
    }

    public void a(int i2, String str, JSONObject jSONObject) {
        v vVar = this.f14467d;
        vVar.e("MediationDebuggerService", "Unable to fetch mediation debugger info: server returned " + i2);
        v.i("AppLovinSdk", "Unable to show mediation debugger.");
        this.f14468e.a((List<com.applovin.impl.mediation.debugger.b.b.b>) null, (List<com.applovin.impl.mediation.debugger.b.a.a>) null, (String) null, (String) null, (String) null, this.f14466c);
        this.f14470g.set(false);
    }

    public void a(JSONObject jSONObject, int i2) {
        List<com.applovin.impl.mediation.debugger.b.b.b> a2 = a(jSONObject, this.f14466c);
        List<com.applovin.impl.mediation.debugger.b.a.a> a3 = a(jSONObject, a2, this.f14466c);
        JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONObject, "alert", (JSONObject) null);
        List<com.applovin.impl.mediation.debugger.b.b.b> list = a2;
        this.f14468e.a(list, a3, JsonUtils.getString(jSONObject2, "title", (String) null), JsonUtils.getString(jSONObject2, "message", (String) null), JsonUtils.getString(jSONObject, "account_id", (String) null), this.f14466c);
        if (b()) {
            AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
                public void run() {
                    a.this.c();
                }
            }, TimeUnit.SECONDS.toMillis((long) this.f14472i));
        } else {
            a(a2);
        }
    }

    public void a(boolean z2, int i2) {
        this.f14471h = z2;
        this.f14472i = i2;
    }

    public boolean b() {
        return this.f14471h;
    }

    public void c() {
        a();
        if (g() || !f14465b.compareAndSet(false, true)) {
            v.i("AppLovinSdk", "Mediation debugger is already showing");
            return;
        }
        if (!this.f14473j) {
            f();
            this.f14473j = true;
        }
        Intent intent = new Intent(this.f14474k, MaxDebuggerActivity.class);
        intent.setFlags(268435456);
        v.f("AppLovinSdk", "Starting mediation debugger...");
        this.f14474k.startActivity(intent);
    }

    public String toString() {
        return "MediationDebuggerService{, listAdapter=" + this.f14468e + "}";
    }
}
