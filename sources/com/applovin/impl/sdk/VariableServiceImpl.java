package com.applovin.impl.sdk;

import android.os.Bundle;
import com.applovin.impl.sdk.c.d;
import com.applovin.impl.sdk.e.a;
import com.applovin.impl.sdk.e.m;
import com.applovin.impl.sdk.e.o;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinVariableService;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class VariableServiceImpl implements AppLovinVariableService {

    /* renamed from: a  reason: collision with root package name */
    private final m f14990a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final AtomicBoolean f14991b = new AtomicBoolean();

    /* renamed from: c  reason: collision with root package name */
    private final AtomicBoolean f14992c = new AtomicBoolean();
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public AppLovinVariableService.OnVariablesUpdateListener f14993d;

    /* renamed from: e  reason: collision with root package name */
    private Bundle f14994e;

    /* renamed from: f  reason: collision with root package name */
    private final Object f14995f = new Object();

    VariableServiceImpl(m mVar) {
        this.f14990a = mVar;
        String str = (String) mVar.a(d.f15224j);
        if (StringUtils.isValidString(str)) {
            updateVariables(JsonUtils.deserialize(str));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0052, code lost:
        return r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.Object a(java.lang.String r4, java.lang.Object r5, java.lang.Class<?> r6) {
        /*
            r3 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            if (r0 == 0) goto L_0x0014
            boolean r4 = com.applovin.impl.sdk.v.a()
            if (r4 == 0) goto L_0x0013
            java.lang.String r4 = "AppLovinVariableService"
            java.lang.String r6 = "Unable to retrieve variable value for empty name"
            com.applovin.impl.sdk.v.i(r4, r6)
        L_0x0013:
            return r5
        L_0x0014:
            boolean r0 = com.applovin.impl.sdk.v.a()
            if (r0 == 0) goto L_0x0029
            com.applovin.impl.sdk.m r0 = r3.f14990a
            boolean r0 = r0.d()
            if (r0 != 0) goto L_0x0029
            java.lang.String r0 = "AppLovinSdk"
            java.lang.String r1 = "Attempted to retrieve variable before SDK initialization. Please wait until after the SDK has initialized, e.g. AppLovinSdk.initializeSdk(Context, SdkInitializationListener)."
            com.applovin.impl.sdk.v.h(r0, r1)
        L_0x0029:
            java.lang.Object r0 = r3.f14995f
            monitor-enter(r0)
            android.os.Bundle r1 = r3.f14994e     // Catch:{ all -> 0x0096 }
            if (r1 != 0) goto L_0x0053
            boolean r6 = com.applovin.impl.sdk.v.a()     // Catch:{ all -> 0x0096 }
            if (r6 == 0) goto L_0x0051
            java.lang.String r6 = "AppLovinVariableService"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0096 }
            r1.<init>()     // Catch:{ all -> 0x0096 }
            java.lang.String r2 = "Unable to retrieve variable value for name \""
            r1.append(r2)     // Catch:{ all -> 0x0096 }
            r1.append(r4)     // Catch:{ all -> 0x0096 }
            java.lang.String r4 = "\". No variables returned by the server."
            r1.append(r4)     // Catch:{ all -> 0x0096 }
            java.lang.String r4 = r1.toString()     // Catch:{ all -> 0x0096 }
            com.applovin.impl.sdk.v.i(r6, r4)     // Catch:{ all -> 0x0096 }
        L_0x0051:
            monitor-exit(r0)     // Catch:{ all -> 0x0096 }
            return r5
        L_0x0053:
            java.lang.Class<java.lang.String> r1 = java.lang.String.class
            boolean r1 = r6.equals(r1)     // Catch:{ all -> 0x0096 }
            if (r1 == 0) goto L_0x0065
            android.os.Bundle r6 = r3.f14994e     // Catch:{ all -> 0x0096 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x0096 }
            java.lang.String r4 = r6.getString(r4, r5)     // Catch:{ all -> 0x0096 }
            monitor-exit(r0)     // Catch:{ all -> 0x0096 }
            return r4
        L_0x0065:
            java.lang.Class<java.lang.Boolean> r1 = java.lang.Boolean.class
            boolean r6 = r6.equals(r1)     // Catch:{ all -> 0x0096 }
            if (r6 == 0) goto L_0x007f
            android.os.Bundle r6 = r3.f14994e     // Catch:{ all -> 0x0096 }
            java.lang.Boolean r5 = (java.lang.Boolean) r5     // Catch:{ all -> 0x0096 }
            boolean r5 = r5.booleanValue()     // Catch:{ all -> 0x0096 }
            boolean r4 = r6.getBoolean(r4, r5)     // Catch:{ all -> 0x0096 }
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)     // Catch:{ all -> 0x0096 }
            monitor-exit(r0)     // Catch:{ all -> 0x0096 }
            return r4
        L_0x007f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0096 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0096 }
            r6.<init>()     // Catch:{ all -> 0x0096 }
            java.lang.String r1 = "Unable to retrieve variable value for "
            r6.append(r1)     // Catch:{ all -> 0x0096 }
            r6.append(r4)     // Catch:{ all -> 0x0096 }
            java.lang.String r4 = r6.toString()     // Catch:{ all -> 0x0096 }
            r5.<init>(r4)     // Catch:{ all -> 0x0096 }
            throw r5     // Catch:{ all -> 0x0096 }
        L_0x0096:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0096 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.VariableServiceImpl.a(java.lang.String, java.lang.Object, java.lang.Class):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f14995f
            monitor-enter(r0)
            com.applovin.sdk.AppLovinVariableService$OnVariablesUpdateListener r1 = r3.f14993d     // Catch:{ all -> 0x001f }
            if (r1 == 0) goto L_0x001d
            android.os.Bundle r1 = r3.f14994e     // Catch:{ all -> 0x001f }
            if (r1 != 0) goto L_0x000c
            goto L_0x001d
        L_0x000c:
            java.lang.Object r1 = r1.clone()     // Catch:{ all -> 0x001f }
            android.os.Bundle r1 = (android.os.Bundle) r1     // Catch:{ all -> 0x001f }
            com.applovin.impl.sdk.VariableServiceImpl$2 r2 = new com.applovin.impl.sdk.VariableServiceImpl$2     // Catch:{ all -> 0x001f }
            r2.<init>(r1)     // Catch:{ all -> 0x001f }
            r1 = 1
            com.applovin.sdk.AppLovinSdkUtils.runOnUiThread(r1, r2)     // Catch:{ all -> 0x001f }
            monitor-exit(r0)     // Catch:{ all -> 0x001f }
            return
        L_0x001d:
            monitor-exit(r0)     // Catch:{ all -> 0x001f }
            return
        L_0x001f:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x001f }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.VariableServiceImpl.a():void");
    }

    public boolean getBoolean(String str) {
        return getBoolean(str, false);
    }

    public boolean getBoolean(String str, boolean z2) {
        return ((Boolean) a(str, Boolean.valueOf(z2), Boolean.class)).booleanValue();
    }

    public String getString(String str) {
        return getString(str, (String) null);
    }

    public String getString(String str, String str2) {
        return (String) a(str, str2, String.class);
    }

    @Deprecated
    public void loadVariables() {
        String str;
        if (this.f14990a.d()) {
            if (this.f14991b.compareAndSet(false, true)) {
                this.f14990a.S().a((a) new m(this.f14990a, new m.a() {
                    public void a() {
                        VariableServiceImpl.this.f14991b.set(false);
                    }
                }), o.a.BACKGROUND);
                return;
            } else if (v.a()) {
                str = "Ignored explicit variables load. Service is already in the process of retrieving the latest set of variables.";
            } else {
                return;
            }
        } else if (v.a()) {
            str = "The AppLovin SDK is waiting for the initial variables to be returned upon completing initialization.";
        } else {
            return;
        }
        v.i("AppLovinVariableService", str);
    }

    @Deprecated
    public void setOnVariablesUpdateListener(AppLovinVariableService.OnVariablesUpdateListener onVariablesUpdateListener) {
        this.f14993d = onVariablesUpdateListener;
        synchronized (this.f14995f) {
            if (onVariablesUpdateListener != null) {
                if (this.f14994e != null && this.f14992c.compareAndSet(false, true)) {
                    if (v.a()) {
                        this.f14990a.A().b("AppLovinVariableService", "Setting initial listener");
                    }
                    a();
                }
            }
        }
    }

    public String toString() {
        return "VariableService{variables=" + this.f14994e + ", listener=" + this.f14993d + '}';
    }

    public void updateVariables(JSONObject jSONObject) {
        if (v.a()) {
            v A = this.f14990a.A();
            A.b("AppLovinVariableService", "Updating variables: " + jSONObject + "...");
        }
        synchronized (this.f14995f) {
            this.f14994e = JsonUtils.toBundle(jSONObject);
            a();
            this.f14990a.a(d.f15224j, jSONObject.toString());
        }
    }
}
