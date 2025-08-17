package com.applovin.impl.sdk.e;

import android.app.Activity;
import com.applovin.impl.sdk.c.b;
import com.applovin.impl.sdk.e;
import com.applovin.impl.sdk.e.o;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.impl.sdk.utils.k;
import com.applovin.impl.sdk.utils.p;
import com.applovin.impl.sdk.v;
import com.applovin.sdk.AppLovinSdk;
import com.facebook.hermes.intl.Constants;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class n extends a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final m f15376a;

    public n(m mVar) {
        super("TaskInitializeSdk", mVar);
        this.f15376a = mVar;
    }

    private void a() {
        if (!this.f15376a.D().a()) {
            Activity an = this.f15376a.an();
            if (an != null) {
                this.f15376a.D().a(an);
            } else {
                this.f15376a.S().a((a) new z(this.f15376a, true, new Runnable() {
                    public void run() {
                        n.this.f15376a.D().a(n.this.f15376a.af().a());
                    }
                }), o.a.MAIN, TimeUnit.SECONDS.toMillis(1));
            }
        }
    }

    private void b() {
        String str;
        if (!this.f15376a.e()) {
            boolean d2 = this.f15376a.K().d();
            if (d2) {
                str = this.f15376a.V().k().f15744b + " (use this for test devices)";
            } else {
                str = "<Enable verbose logging to see the GAID to use for test devices - https://monetization-support.applovin.com/hc/en-us/articles/236114328-How-can-I-expose-verbose-logging-for-the-SDK>";
            }
            Map<String, Object> d3 = this.f15376a.V().d();
            Map<String, Object> c2 = this.f15376a.V().c();
            k kVar = new k();
            kVar.a().a("=====AppLovin SDK=====");
            kVar.a("===SDK Versions===").a("Version", AppLovinSdk.VERSION).a("Plugin Version", this.f15376a.a(b.dz)).a("Ad Review Version", e.a()).a("OM SDK Version", this.f15376a.al().c());
            kVar.a("===Device Info===").a("OS", Utils.getAndroidOSInfo()).a("GAID", str).a("Model", d3.get("model")).a("Locale", d3.get(Constants.LOCALE)).a("Emulator", d3.get("sim")).a("Tablet", d3.get("is_tablet"));
            kVar.a("===App Info===").a("Application ID", c2.get("package_name")).a("Target SDK", c2.get("target_sdk")).a("ExoPlayer Version", Integer.valueOf(Utils.tryToGetExoPlayerVersionCode()));
            kVar.a("===SDK Settings===").a("SDK Key", this.f15376a.z()).a("Mediation Provider", this.f15376a.t()).a("TG", p.a(this.f15376a)).a("Test Mode On", Boolean.valueOf(this.f15376a.J().a())).a("Verbose Logging On", Boolean.valueOf(d2));
            kVar.a("===Privacy States===\nPlease review AppLovin MAX documentation to be compliant with regional privacy policies.").a(j.a(f()));
            kVar.a();
            v.f("AppLovinSdk", kVar.toString());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x014e, code lost:
        if (r12.f15376a.d() != false) goto L_0x01b1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x01ad, code lost:
        if (r12.f15376a.d() != false) goto L_0x01b1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x01b0, code lost:
        r2 = "failed";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x01b1, code lost:
        r8.append(r2);
        r8.append(" in ");
        r8.append(java.lang.System.currentTimeMillis() - r6);
        r8.append("ms");
        a(r8.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r12 = this;
            java.lang.String r0 = "ms"
            java.lang.String r1 = " in "
            java.lang.String r2 = "succeeded"
            java.lang.String r3 = "failed"
            java.lang.String r4 = " initialization "
            java.lang.String r5 = "AppLovin SDK "
            long r6 = java.lang.System.currentTimeMillis()
            boolean r8 = com.applovin.impl.sdk.v.a()
            if (r8 == 0) goto L_0x0031
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "Initializing AppLovin SDK v"
            r8.append(r9)
            java.lang.String r9 = com.applovin.sdk.AppLovinSdk.VERSION
            r8.append(r9)
            java.lang.String r9 = "..."
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            r12.a(r8)
        L_0x0031:
            com.applovin.impl.sdk.m r8 = r12.f15376a     // Catch:{ all -> 0x0151 }
            com.applovin.impl.sdk.d.g r8 = r8.T()     // Catch:{ all -> 0x0151 }
            com.applovin.impl.sdk.d.f r9 = com.applovin.impl.sdk.d.f.f15303b     // Catch:{ all -> 0x0151 }
            r8.c(r9)     // Catch:{ all -> 0x0151 }
            com.applovin.impl.sdk.m r8 = r12.f15376a     // Catch:{ all -> 0x0151 }
            com.applovin.impl.sdk.q r8 = r8.ab()     // Catch:{ all -> 0x0151 }
            android.content.Context r9 = r12.f()     // Catch:{ all -> 0x0151 }
            r8.a((android.content.Context) r9)     // Catch:{ all -> 0x0151 }
            com.applovin.impl.sdk.m r8 = r12.f15376a     // Catch:{ all -> 0x0151 }
            com.applovin.impl.sdk.q r8 = r8.ab()     // Catch:{ all -> 0x0151 }
            android.content.Context r9 = r12.f()     // Catch:{ all -> 0x0151 }
            r8.b((android.content.Context) r9)     // Catch:{ all -> 0x0151 }
            com.applovin.impl.sdk.m r8 = r12.f15376a     // Catch:{ all -> 0x0151 }
            com.applovin.impl.sdk.e.o r8 = r8.S()     // Catch:{ all -> 0x0151 }
            com.applovin.impl.sdk.e.b r9 = new com.applovin.impl.sdk.e.b     // Catch:{ all -> 0x0151 }
            com.applovin.impl.sdk.m r10 = r12.f15376a     // Catch:{ all -> 0x0151 }
            r9.<init>(r10)     // Catch:{ all -> 0x0151 }
            com.applovin.impl.sdk.e.o$a r10 = com.applovin.impl.sdk.e.o.a.MAIN     // Catch:{ all -> 0x0151 }
            r8.a((com.applovin.impl.sdk.e.a) r9, (com.applovin.impl.sdk.e.o.a) r10)     // Catch:{ all -> 0x0151 }
            com.applovin.impl.sdk.m r8 = r12.f15376a     // Catch:{ all -> 0x0151 }
            com.applovin.impl.sdk.o r8 = r8.V()     // Catch:{ all -> 0x0151 }
            r8.e()     // Catch:{ all -> 0x0151 }
            com.applovin.impl.sdk.m r8 = r12.f15376a     // Catch:{ all -> 0x0151 }
            com.applovin.impl.sdk.utils.n r8 = r8.ah()     // Catch:{ all -> 0x0151 }
            r8.a()     // Catch:{ all -> 0x0151 }
            android.content.Context r8 = r12.f()     // Catch:{ all -> 0x0151 }
            com.applovin.impl.sdk.m r9 = r12.f15376a     // Catch:{ all -> 0x0151 }
            boolean r8 = com.applovin.impl.sdk.utils.Utils.isPubInDebugMode(r8, r9)     // Catch:{ all -> 0x0151 }
            if (r8 == 0) goto L_0x008b
            com.applovin.impl.sdk.m r8 = r12.f15376a     // Catch:{ all -> 0x0151 }
            r8.h()     // Catch:{ all -> 0x0151 }
        L_0x008b:
            r12.b()     // Catch:{ all -> 0x0151 }
            com.applovin.impl.sdk.m r8 = r12.f15376a     // Catch:{ all -> 0x0151 }
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r9 = com.applovin.impl.sdk.c.b.dT     // Catch:{ all -> 0x0151 }
            java.lang.Object r8 = r8.a(r9)     // Catch:{ all -> 0x0151 }
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch:{ all -> 0x0151 }
            boolean r8 = r8.booleanValue()     // Catch:{ all -> 0x0151 }
            if (r8 == 0) goto L_0x00a6
            com.applovin.impl.sdk.e.n$1 r8 = new com.applovin.impl.sdk.e.n$1     // Catch:{ all -> 0x0151 }
            r8.<init>()     // Catch:{ all -> 0x0151 }
            com.applovin.sdk.AppLovinSdkUtils.runOnUiThread(r8)     // Catch:{ all -> 0x0151 }
        L_0x00a6:
            r12.a()     // Catch:{ all -> 0x0151 }
            com.applovin.impl.sdk.m r8 = r12.f15376a     // Catch:{ all -> 0x0151 }
            r9 = 1
            r8.a((boolean) r9)     // Catch:{ all -> 0x0151 }
            com.applovin.impl.sdk.m r8 = r12.f15376a     // Catch:{ all -> 0x0151 }
            com.applovin.impl.sdk.network.f r8 = r8.U()     // Catch:{ all -> 0x0151 }
            r8.c()     // Catch:{ all -> 0x0151 }
            com.applovin.impl.sdk.m r8 = r12.f15376a     // Catch:{ all -> 0x0151 }
            com.applovin.sdk.AppLovinEventService r8 = r8.w()     // Catch:{ all -> 0x0151 }
            com.applovin.impl.sdk.EventServiceImpl r8 = (com.applovin.impl.sdk.EventServiceImpl) r8     // Catch:{ all -> 0x0151 }
            r8.maybeTrackAppOpenEvent()     // Catch:{ all -> 0x0151 }
            com.applovin.impl.sdk.m r8 = r12.f15376a     // Catch:{ all -> 0x0151 }
            com.applovin.impl.mediation.debugger.a r8 = r8.G()     // Catch:{ all -> 0x0151 }
            boolean r8 = r8.b()     // Catch:{ all -> 0x0151 }
            if (r8 == 0) goto L_0x00d7
            com.applovin.impl.sdk.m r8 = r12.f15376a     // Catch:{ all -> 0x0151 }
            boolean r8 = r8.e()     // Catch:{ all -> 0x0151 }
            if (r8 == 0) goto L_0x00fd
        L_0x00d7:
            com.applovin.impl.sdk.m r8 = r12.f15376a     // Catch:{ all -> 0x0151 }
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r9 = com.applovin.impl.sdk.c.a.f15186h     // Catch:{ all -> 0x0151 }
            java.lang.Object r8 = r8.a(r9)     // Catch:{ all -> 0x0151 }
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch:{ all -> 0x0151 }
            boolean r8 = r8.booleanValue()     // Catch:{ all -> 0x0151 }
            if (r8 == 0) goto L_0x0106
            com.applovin.impl.sdk.m r8 = r12.f15376a     // Catch:{ all -> 0x0151 }
            android.content.Context r8 = r8.L()     // Catch:{ all -> 0x0151 }
            com.applovin.impl.sdk.m r9 = r12.f15376a     // Catch:{ all -> 0x0151 }
            boolean r8 = com.applovin.impl.sdk.utils.Utils.isPubInDebugMode(r8, r9)     // Catch:{ all -> 0x0151 }
            if (r8 == 0) goto L_0x0106
            com.applovin.impl.sdk.m r8 = r12.f15376a     // Catch:{ all -> 0x0151 }
            boolean r8 = r8.f()     // Catch:{ all -> 0x0151 }
            if (r8 == 0) goto L_0x0106
        L_0x00fd:
            com.applovin.impl.sdk.m r8 = r12.f15376a     // Catch:{ all -> 0x0151 }
            com.applovin.impl.mediation.debugger.a r8 = r8.G()     // Catch:{ all -> 0x0151 }
            r8.a()     // Catch:{ all -> 0x0151 }
        L_0x0106:
            com.applovin.impl.sdk.m r8 = r12.f15376a
            com.applovin.impl.sdk.a.f r8 = r8.al()
            r8.a()
            com.applovin.impl.sdk.m r8 = r12.f15376a
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r9 = com.applovin.impl.sdk.c.b.az
            java.lang.Object r8 = r8.a(r9)
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L_0x0132
            com.applovin.impl.sdk.m r8 = r12.f15376a
            com.applovin.impl.sdk.c.b<java.lang.Long> r9 = com.applovin.impl.sdk.c.b.aA
            java.lang.Object r8 = r8.a(r9)
            java.lang.Long r8 = (java.lang.Long) r8
            long r8 = r8.longValue()
            com.applovin.impl.sdk.m r10 = r12.f15376a
            r10.a((long) r8)
        L_0x0132:
            boolean r8 = com.applovin.impl.sdk.v.a()
            if (r8 == 0) goto L_0x01c9
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r5)
            java.lang.String r5 = com.applovin.sdk.AppLovinSdk.VERSION
            r8.append(r5)
            r8.append(r4)
            com.applovin.impl.sdk.m r4 = r12.f15376a
            boolean r4 = r4.d()
            if (r4 == 0) goto L_0x01b0
            goto L_0x01b1
        L_0x0151:
            r8 = move-exception
            boolean r9 = com.applovin.impl.sdk.v.a()     // Catch:{ all -> 0x01ca }
            if (r9 == 0) goto L_0x015f
            java.lang.String r9 = "AppLovinSdk"
            java.lang.String r10 = "Failed to initialize SDK!"
            com.applovin.impl.sdk.v.c(r9, r10, r8)     // Catch:{ all -> 0x01ca }
        L_0x015f:
            com.applovin.impl.sdk.m r8 = r12.f15376a     // Catch:{ all -> 0x01ca }
            r9 = 0
            r8.a((boolean) r9)     // Catch:{ all -> 0x01ca }
            com.applovin.impl.sdk.m r8 = r12.f15376a
            com.applovin.impl.sdk.a.f r8 = r8.al()
            r8.a()
            com.applovin.impl.sdk.m r8 = r12.f15376a
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r9 = com.applovin.impl.sdk.c.b.az
            java.lang.Object r8 = r8.a(r9)
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L_0x0191
            com.applovin.impl.sdk.m r8 = r12.f15376a
            com.applovin.impl.sdk.c.b<java.lang.Long> r9 = com.applovin.impl.sdk.c.b.aA
            java.lang.Object r8 = r8.a(r9)
            java.lang.Long r8 = (java.lang.Long) r8
            long r8 = r8.longValue()
            com.applovin.impl.sdk.m r10 = r12.f15376a
            r10.a((long) r8)
        L_0x0191:
            boolean r8 = com.applovin.impl.sdk.v.a()
            if (r8 == 0) goto L_0x01c9
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r5)
            java.lang.String r5 = com.applovin.sdk.AppLovinSdk.VERSION
            r8.append(r5)
            r8.append(r4)
            com.applovin.impl.sdk.m r4 = r12.f15376a
            boolean r4 = r4.d()
            if (r4 == 0) goto L_0x01b0
            goto L_0x01b1
        L_0x01b0:
            r2 = r3
        L_0x01b1:
            r8.append(r2)
            r8.append(r1)
            long r1 = java.lang.System.currentTimeMillis()
            long r1 = r1 - r6
            r8.append(r1)
            r8.append(r0)
            java.lang.String r0 = r8.toString()
            r12.a(r0)
        L_0x01c9:
            return
        L_0x01ca:
            r8 = move-exception
            com.applovin.impl.sdk.m r9 = r12.f15376a
            com.applovin.impl.sdk.a.f r9 = r9.al()
            r9.a()
            com.applovin.impl.sdk.m r9 = r12.f15376a
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r10 = com.applovin.impl.sdk.c.b.az
            java.lang.Object r9 = r9.a(r10)
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L_0x01f7
            com.applovin.impl.sdk.m r9 = r12.f15376a
            com.applovin.impl.sdk.c.b<java.lang.Long> r10 = com.applovin.impl.sdk.c.b.aA
            java.lang.Object r9 = r9.a(r10)
            java.lang.Long r9 = (java.lang.Long) r9
            long r9 = r9.longValue()
            com.applovin.impl.sdk.m r11 = r12.f15376a
            r11.a((long) r9)
        L_0x01f7:
            boolean r9 = com.applovin.impl.sdk.v.a()
            if (r9 == 0) goto L_0x022f
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r5)
            java.lang.String r5 = com.applovin.sdk.AppLovinSdk.VERSION
            r9.append(r5)
            r9.append(r4)
            com.applovin.impl.sdk.m r4 = r12.f15376a
            boolean r4 = r4.d()
            if (r4 == 0) goto L_0x0216
            goto L_0x0217
        L_0x0216:
            r2 = r3
        L_0x0217:
            r9.append(r2)
            r9.append(r1)
            long r1 = java.lang.System.currentTimeMillis()
            long r1 = r1 - r6
            r9.append(r1)
            r9.append(r0)
            java.lang.String r0 = r9.toString()
            r12.a(r0)
        L_0x022f:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.e.n.run():void");
    }
}
