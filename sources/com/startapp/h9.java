package com.startapp;

import android.util.Pair;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.startapp.sdk.adsbase.SimpleTokenUtils;
import com.startapp.sdk.common.SDKException;
import com.unity3d.services.ads.adunit.AdUnitActivity;
import java.util.Map;

public class h9 extends q6 {

    /* renamed from: h0  reason: collision with root package name */
    public final y8 f34627h0;

    /* renamed from: i0  reason: collision with root package name */
    public String f34628i0;

    /* renamed from: j0  reason: collision with root package name */
    public String f34629j0;

    /* renamed from: k0  reason: collision with root package name */
    public String f34630k0;

    /* renamed from: l0  reason: collision with root package name */
    public String f34631l0;

    /* renamed from: m0  reason: collision with root package name */
    public String f34632m0;

    /* renamed from: n0  reason: collision with root package name */
    public String f34633n0;

    /* renamed from: o0  reason: collision with root package name */
    public String f34634o0;

    /* renamed from: p0  reason: collision with root package name */
    public Map<String, String> f34635p0;

    public h9(y8 y8Var) {
        super(8);
        this.f34627h0 = y8Var;
    }

    public void a(eb ebVar) throws SDKException {
        String str;
        Pair pair;
        super.a(ebVar);
        y8 y8Var = this.f34627h0;
        Long l2 = y8Var.f36958h;
        if (l2 != null) {
            str = l2.toString();
        } else {
            str = fc.a();
        }
        ebVar.a(fc.f34530b, (Object) str, true, true);
        ebVar.a(fc.f34531c, (Object) fc.a(str), true, true);
        ebVar.a("category", (Object) y8Var.f36951a.f37008o, true, true);
        ebVar.a(AppMeasurementSdk.ConditionalUserProperty.VALUE, (Object) y8Var.f36954d, false, true);
        ebVar.a("d", (Object) y8Var.f36957g, false, true);
        ebVar.a("appActivity", (Object) y8Var.f36959i, false, true);
        ebVar.a("details", (Object) y8Var.f36955e, false, true);
        ebVar.a("details_json", y8Var.f36956f, false, true);
        ebVar.a("isService", (Object) Boolean.valueOf(y8Var.f36960j), false, true);
        ebVar.a(AdUnitActivity.EXTRA_ORIENTATION, (Object) this.f34628i0, false, true);
        ebVar.a("usedRam", (Object) this.f34629j0, false, true);
        ebVar.a("freeRam", (Object) this.f34630k0, false, true);
        ebVar.a("sessionTime", (Object) null, false, true);
        ebVar.a("cellScanRes", (Object) this.f34631l0, false, true);
        ebVar.a("sens", (Object) this.f34632m0, false, true);
        ebVar.a("bt", (Object) this.f34633n0, false, true);
        ebVar.a("packagingType", (Object) this.f34634o0, false, true);
        Pair<String, String> a2 = SimpleTokenUtils.a();
        if (SimpleTokenUtils.f36205e != null) {
            pair = new Pair(((SimpleTokenUtils.TokenType) SimpleTokenUtils.f36205e.first).toString(), SimpleTokenUtils.f36205e.second);
        } else {
            pair = new Pair(SimpleTokenUtils.TokenType.T2.toString(), "");
        }
        ebVar.a((String) a2.first, a2.second, false, true);
        ebVar.a((String) pair.first, pair.second, false, true);
        Map<String, String> map = this.f34635p0;
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                ebVar.a((String) next.getKey(), next.getValue(), false, true);
            }
        }
        ebVar.a("rcd", (Object) null, false, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0031 A[Catch:{ all -> 0x005e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(android.content.Context r9, com.startapp.sdk.adsbase.model.AdPreferences r10) {
        /*
            r8 = this;
            super.b(r9, r10)
            android.content.res.Resources r10 = r9.getResources()
            r0 = 1
            if (r10 == 0) goto L_0x001d
            android.content.res.Configuration r10 = r10.getConfiguration()
            if (r10 == 0) goto L_0x001d
            int r10 = r10.orientation
            r1 = 2
            if (r10 != r1) goto L_0x0018
            java.lang.String r10 = "landscape"
            goto L_0x001f
        L_0x0018:
            if (r10 != r0) goto L_0x001d
            java.lang.String r10 = "portrait"
            goto L_0x001f
        L_0x001d:
            java.lang.String r10 = "undefined"
        L_0x001f:
            r8.f34628i0 = r10
            r10 = 0
            java.lang.String[] r10 = new java.lang.String[]{r10, r10}
            r1 = 0
            java.lang.String r2 = "activity"
            java.lang.Object r2 = r9.getSystemService(r2)     // Catch:{ all -> 0x005e }
            android.app.ActivityManager r2 = (android.app.ActivityManager) r2     // Catch:{ all -> 0x005e }
            if (r2 == 0) goto L_0x0073
            android.app.ActivityManager$MemoryInfo r3 = new android.app.ActivityManager$MemoryInfo     // Catch:{ all -> 0x005e }
            r3.<init>()     // Catch:{ all -> 0x005e }
            r2.getMemoryInfo(r3)     // Catch:{ all -> 0x005e }
            long r4 = r3.availMem     // Catch:{ all -> 0x005e }
            r6 = 1048576(0x100000, double:5.180654E-318)
            long r4 = r4 / r6
            java.lang.String r2 = java.lang.Long.toString(r4)     // Catch:{ all -> 0x005e }
            r10[r1] = r2     // Catch:{ all -> 0x005e }
            int r2 = com.startapp.hc.f34643a     // Catch:{ all -> 0x005e }
            long r4 = r3.totalMem     // Catch:{ all -> 0x005e }
            java.lang.Long r2 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x005e }
            if (r2 == 0) goto L_0x0073
            long r4 = r2.longValue()     // Catch:{ all -> 0x005e }
            long r2 = r3.availMem     // Catch:{ all -> 0x005e }
            long r4 = r4 - r2
            long r4 = r4 / r6
            java.lang.String r2 = java.lang.Long.toString(r4)     // Catch:{ all -> 0x005e }
            r10[r0] = r2     // Catch:{ all -> 0x005e }
            goto L_0x0073
        L_0x005e:
            r2 = move-exception
            java.lang.Class<java.lang.SecurityException> r3 = java.lang.SecurityException.class
            boolean r3 = com.startapp.lb.a((java.lang.Throwable) r2, (java.lang.Class<? extends java.lang.Throwable>) r3)
            if (r3 != 0) goto L_0x0073
            java.lang.Class<android.os.RemoteException> r3 = android.os.RemoteException.class
            boolean r3 = com.startapp.lb.a((java.lang.Throwable) r2, (java.lang.Class<? extends java.lang.Throwable>) r3)
            if (r3 == 0) goto L_0x0070
            goto L_0x0073
        L_0x0070:
            com.startapp.y8.a((android.content.Context) r9, (java.lang.Throwable) r2)
        L_0x0073:
            r9 = r10[r1]
            r8.f34630k0 = r9
            r9 = r10[r0]
            r8.f34629j0 = r9
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.h9.b(android.content.Context, com.startapp.sdk.adsbase.model.AdPreferences):void");
    }

    public String toString() {
        return this.f34627h0.toString();
    }
}
