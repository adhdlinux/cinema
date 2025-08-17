package com.applovin.impl.mediation.debugger.ui.b;

import android.app.Activity;
import android.content.Context;
import com.applovin.communicator.AppLovinCommunicator;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.mediation.debugger.b.b.b;
import com.applovin.impl.mediation.debugger.ui.d.c;
import com.applovin.impl.mediation.debugger.ui.d.d;
import com.applovin.impl.sdk.e;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.impl.sdk.utils.f;
import com.applovin.impl.sdk.v;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.R;
import com.facebook.react.uimanager.ViewProps;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class b extends d implements AppLovinCommunicatorSubscriber {

    /* renamed from: a  reason: collision with root package name */
    private m f14639a;

    /* renamed from: b  reason: collision with root package name */
    private List<com.applovin.impl.mediation.debugger.b.a.a> f14640b;

    /* renamed from: d  reason: collision with root package name */
    private String f14641d;

    /* renamed from: e  reason: collision with root package name */
    private String f14642e;

    /* renamed from: f  reason: collision with root package name */
    private String f14643f;

    /* renamed from: g  reason: collision with root package name */
    private final StringBuilder f14644g = new StringBuilder("");

    /* renamed from: h  reason: collision with root package name */
    private final AtomicBoolean f14645h = new AtomicBoolean();

    /* renamed from: i  reason: collision with root package name */
    private boolean f14646i = false;

    /* renamed from: j  reason: collision with root package name */
    private List<com.applovin.impl.mediation.debugger.b.b.b> f14647j = new ArrayList();

    /* renamed from: k  reason: collision with root package name */
    private List<com.applovin.impl.mediation.debugger.b.b.b> f14648k = new ArrayList();

    /* renamed from: l  reason: collision with root package name */
    private List<com.applovin.impl.mediation.debugger.b.b.b> f14649l = new ArrayList();

    /* renamed from: m  reason: collision with root package name */
    private List<com.applovin.impl.mediation.debugger.b.a.d> f14650m = new ArrayList();

    /* renamed from: n  reason: collision with root package name */
    private List<com.applovin.impl.mediation.debugger.b.a.d> f14651n = new ArrayList();

    /* renamed from: o  reason: collision with root package name */
    private List<c> f14652o = new ArrayList();

    /* renamed from: p  reason: collision with root package name */
    private List<c> f14653p = new ArrayList();

    /* renamed from: q  reason: collision with root package name */
    private List<c> f14654q = new ArrayList();

    /* renamed from: r  reason: collision with root package name */
    private List<c> f14655r = new ArrayList();

    /* renamed from: s  reason: collision with root package name */
    private List<c> f14656s = new ArrayList();

    /* renamed from: t  reason: collision with root package name */
    private List<c> f14657t = new ArrayList();

    /* renamed from: u  reason: collision with root package name */
    private List<c> f14658u = new ArrayList();

    public enum a {
        AD_UNITS,
        SELECT_LIVE_NETWORKS,
        COUNT
    }

    /* renamed from: com.applovin.impl.mediation.debugger.ui.b.b$b  reason: collision with other inner class name */
    public enum C0018b {
        APP_INFO,
        MAX,
        PRIVACY,
        ADS,
        INCOMPLETE_NETWORKS,
        COMPLETED_NETWORKS,
        MISSING_NETWORKS,
        COUNT
    }

    public b(Context context) {
        super(context);
    }

    private c a(String str, String str2) {
        c.a a2 = c.p().a(str);
        if (StringUtils.isValidString(str2)) {
            a2.b(str2);
        } else {
            a2.a(R.drawable.applovin_ic_x_mark);
            a2.c(f.a(R.color.applovin_sdk_xmarkColor, this.f14736c));
        }
        return a2.a();
    }

    private void a(c.a aVar, String str) {
        aVar.c("MAX Ad Review").d(str).a(R.drawable.applovin_ic_x_mark).c(f.a(R.color.applovin_sdk_xmarkColor, this.f14736c)).a(true);
    }

    private void a(StringBuilder sb, String str) {
        String sb2 = sb.toString();
        if (sb2.length() + str.length() >= ((Integer) this.f14639a.a(com.applovin.impl.sdk.c.b.al)).intValue()) {
            v.f("MediationDebuggerListAdapter", sb2);
            this.f14644g.append(sb2);
            sb.setLength(1);
        }
        sb.append(str);
    }

    private void a(List<com.applovin.impl.mediation.debugger.b.b.b> list) {
        List<com.applovin.impl.mediation.debugger.b.b.b> list2;
        for (com.applovin.impl.mediation.debugger.b.b.b next : list) {
            if (!next.g()) {
                if (next.a() == b.a.INCOMPLETE_INTEGRATION || next.a() == b.a.INVALID_INTEGRATION) {
                    list2 = this.f14647j;
                } else if (next.a() == b.a.COMPLETE) {
                    list2 = this.f14648k;
                } else if (next.a() == b.a.MISSING) {
                    list2 = this.f14649l;
                }
                list2.add(next);
            }
        }
    }

    private void b(List<com.applovin.impl.mediation.debugger.b.a.a> list) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (com.applovin.impl.mediation.debugger.b.a.a e2 : list) {
            com.applovin.impl.mediation.debugger.b.a.c e3 = e2.e();
            for (com.applovin.impl.mediation.debugger.b.a.b a2 : e3.a()) {
                hashSet.add(a2.a());
            }
            for (com.applovin.impl.mediation.debugger.b.a.b a3 : e3.b()) {
                hashSet2.add(a3.a());
            }
        }
        this.f14650m = new ArrayList(hashSet);
        this.f14651n = new ArrayList(hashSet2);
        Collections.sort(this.f14650m);
        Collections.sort(this.f14651n);
    }

    private List<c> c(List<com.applovin.impl.mediation.debugger.b.b.b> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (com.applovin.impl.mediation.debugger.b.b.b aVar : list) {
            arrayList.add(new com.applovin.impl.mediation.debugger.ui.b.a.a(aVar, this.f14736c));
        }
        return arrayList;
    }

    private void l() {
        Map<String, String> metaData;
        StringBuilder sb = new StringBuilder("\n========== MEDIATION DEBUGGER ==========");
        sb.append("\n========== APP INFO ==========");
        sb.append("\nDev Build - " + Utils.isPubInDebugMode(this.f14736c, this.f14639a));
        StringBuilder sb2 = new StringBuilder();
        sb2.append("\nTest Mode - ");
        sb2.append(this.f14639a.J().a() ? ViewProps.ENABLED : "disabled");
        sb.append(sb2.toString());
        sb.append("\nTarget SDK - " + this.f14639a.V().h().get("target_sdk"));
        sb.append("\n========== MAX ==========");
        String str = AppLovinSdk.VERSION;
        String str2 = (String) this.f14639a.a(com.applovin.impl.sdk.c.b.dz);
        String a2 = e.a();
        sb.append("\nSDK Version - " + str);
        StringBuilder sb3 = new StringBuilder();
        sb3.append("\nPlugin Version - ");
        String str3 = "None";
        if (!StringUtils.isValidString(str2)) {
            str2 = str3;
        }
        sb3.append(str2);
        sb.append(sb3.toString());
        StringBuilder sb4 = new StringBuilder();
        sb4.append("\nAd Review Version - ");
        if (!StringUtils.isValidString(a2)) {
            a2 = "Disabled";
        }
        sb4.append(a2);
        sb.append(sb4.toString());
        if (this.f14639a.g() && (metaData = Utils.getMetaData(this.f14639a.p())) != null) {
            String str4 = metaData.get("UnityVersion");
            StringBuilder sb5 = new StringBuilder();
            sb5.append("\nUnity Version - ");
            if (StringUtils.isValidString(str4)) {
                str3 = str4;
            }
            sb5.append(str3);
            sb.append(sb5.toString());
        }
        sb.append("\n========== PRIVACY ==========");
        sb.append(j.a(this.f14736c));
        sb.append("\n========== NETWORKS ==========");
        for (com.applovin.impl.mediation.debugger.b.b.b w2 : this.f14648k) {
            a(sb, w2.w());
        }
        for (com.applovin.impl.mediation.debugger.b.b.b w3 : this.f14647j) {
            a(sb, w3.w());
        }
        sb.append("\n========== AD UNITS ==========");
        for (com.applovin.impl.mediation.debugger.b.a.a f2 : this.f14640b) {
            a(sb, f2.f());
        }
        sb.append("\n========== END ==========");
        v.f("MediationDebuggerListAdapter", sb.toString());
        this.f14644g.append(sb.toString());
    }

    private List<c> m() {
        String str;
        ArrayList arrayList = new ArrayList(5);
        try {
            str = this.f14736c.getPackageManager().getPackageInfo(this.f14736c.getPackageName(), 0).versionName;
        } catch (Throwable unused) {
            str = null;
        }
        arrayList.add(c.p().a("Package Name").b(this.f14736c.getPackageName()).a());
        c.a a2 = c.p().a("App Version");
        String str2 = "None";
        if (!StringUtils.isValidString(str)) {
            str = str2;
        }
        arrayList.add(a2.b(str).a());
        arrayList.add(c.p().a("OS").b(Utils.getAndroidOSInfo()).a());
        arrayList.add(c.p().a("Account").b(StringUtils.isValidString(this.f14643f) ? this.f14643f : str2).a());
        c.a a3 = c.p().a("Mediation Provider");
        if (StringUtils.isValidString(this.f14639a.t())) {
            str2 = this.f14639a.t();
        }
        arrayList.add(a3.b(str2).a());
        arrayList.add(c.p().a("OM SDK Version").b(this.f14639a.al().c()).a());
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x00c4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.List<com.applovin.impl.mediation.debugger.ui.d.c> n() {
        /*
            r6 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = 4
            r0.<init>(r1)
            com.applovin.impl.mediation.debugger.ui.d.c$a r1 = com.applovin.impl.mediation.debugger.ui.d.c.p()
            java.lang.String r2 = "SDK Version"
            com.applovin.impl.mediation.debugger.ui.d.c$a r1 = r1.a((java.lang.String) r2)
            java.lang.String r2 = com.applovin.sdk.AppLovinSdk.VERSION
            com.applovin.impl.mediation.debugger.ui.d.c$a r1 = r1.b((java.lang.String) r2)
            com.applovin.impl.mediation.debugger.ui.d.c r1 = r1.a()
            r0.add(r1)
            com.applovin.impl.sdk.m r1 = r6.f14639a
            com.applovin.impl.sdk.c.b<java.lang.String> r2 = com.applovin.impl.sdk.c.b.dz
            java.lang.Object r1 = r1.a(r2)
            java.lang.String r1 = (java.lang.String) r1
            com.applovin.impl.mediation.debugger.ui.d.c$a r2 = com.applovin.impl.mediation.debugger.ui.d.c.p()
            java.lang.String r3 = "Plugin Version"
            com.applovin.impl.mediation.debugger.ui.d.c$a r2 = r2.a((java.lang.String) r3)
            boolean r3 = com.applovin.impl.sdk.utils.StringUtils.isValidString(r1)
            java.lang.String r4 = "None"
            if (r3 == 0) goto L_0x003a
            goto L_0x003b
        L_0x003a:
            r1 = r4
        L_0x003b:
            com.applovin.impl.mediation.debugger.ui.d.c$a r1 = r2.b((java.lang.String) r1)
            com.applovin.impl.mediation.debugger.ui.d.c r1 = r1.a()
            r0.add(r1)
            com.applovin.impl.mediation.debugger.ui.d.c$a r1 = com.applovin.impl.mediation.debugger.ui.d.c.p()
            java.lang.String r2 = "Ad Review Version"
            com.applovin.impl.mediation.debugger.ui.d.c$a r1 = r1.a((java.lang.String) r2)
            java.lang.String r2 = com.applovin.impl.sdk.e.a()
            boolean r3 = com.applovin.impl.sdk.utils.StringUtils.isValidString(r2)
            if (r3 == 0) goto L_0x0096
            java.lang.String r3 = com.applovin.impl.sdk.e.b()
            boolean r5 = com.applovin.impl.sdk.utils.StringUtils.isValidString(r3)
            if (r5 == 0) goto L_0x0092
            com.applovin.impl.sdk.m r5 = r6.f14639a
            java.lang.String r5 = r5.z()
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x0071
            goto L_0x0092
        L_0x0071:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "MAX Ad Review integrated with wrong SDK key. Please check that your "
            r2.<init>(r3)
            com.applovin.impl.sdk.m r3 = r6.f14639a
            boolean r3 = r3.g()
            if (r3 == 0) goto L_0x0083
            java.lang.String r3 = "SDK key is downloaded"
            goto L_0x0085
        L_0x0083:
            java.lang.String r3 = "Gradle plugin snippet is integrated"
        L_0x0085:
            r2.append(r3)
            java.lang.String r3 = " from the correct account."
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            goto L_0x0098
        L_0x0092:
            r1.b((java.lang.String) r2)
            goto L_0x009b
        L_0x0096:
            java.lang.String r2 = "Integrating MAX Ad review is OPTIONAL. This feature gives developers unprecedented transparency into the creatives the users see in their apps."
        L_0x0098:
            r6.a((com.applovin.impl.mediation.debugger.ui.d.c.a) r1, (java.lang.String) r2)
        L_0x009b:
            com.applovin.impl.mediation.debugger.ui.d.c r1 = r1.a()
            r0.add(r1)
            com.applovin.impl.sdk.m r1 = r6.f14639a
            boolean r1 = r1.g()
            if (r1 == 0) goto L_0x00ce
            com.applovin.impl.sdk.m r1 = r6.f14639a
            com.applovin.sdk.AppLovinSdkSettings r1 = r1.p()
            java.util.Map r1 = com.applovin.impl.sdk.utils.Utils.getMetaData(r1)
            if (r1 == 0) goto L_0x00ce
            java.lang.String r2 = "UnityVersion"
            java.lang.Object r1 = r1.get(r2)
            java.lang.String r1 = (java.lang.String) r1
            boolean r2 = com.applovin.impl.sdk.utils.StringUtils.isValidString(r1)
            if (r2 == 0) goto L_0x00c5
            r4 = r1
        L_0x00c5:
            java.lang.String r1 = "Unity Version"
            com.applovin.impl.mediation.debugger.ui.d.c r1 = r6.a((java.lang.String) r1, (java.lang.String) r4)
            r0.add(r1)
        L_0x00ce:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.mediation.debugger.ui.b.b.n():java.util.List");
    }

    private List<c> o() {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(new com.applovin.impl.mediation.debugger.ui.b.a.b(j.a(), true, this.f14736c));
        arrayList.add(new com.applovin.impl.mediation.debugger.ui.b.a.b(j.b(), false, this.f14736c));
        arrayList.add(new com.applovin.impl.mediation.debugger.ui.b.a.b(j.c(), true, this.f14736c));
        return arrayList;
    }

    private List<c> p() {
        ArrayList arrayList = new ArrayList(2);
        c.a p2 = c.p();
        arrayList.add(p2.a("View Ad Units (" + this.f14640b.size() + ")").a(this.f14736c).a(true).a());
        arrayList.add(q());
        return arrayList;
    }

    private c q() {
        c.a p2 = c.p();
        if (!this.f14639a.J().a()) {
            p2.a(this.f14736c);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.f14639a.J().c() != null ? "" : "Select ");
        sb.append("Live Network");
        return p2.a(sb.toString()).b(this.f14639a.J().a() ? "Enable" : null).b(-16776961).d("Ad loads are not supported while Test Mode is enabled. Please restart the app and make sure your GAID has not been enabled for test mode and that you are not on an emulator.").a(true).a();
    }

    /* access modifiers changed from: protected */
    public int a(int i2) {
        return (i2 == C0018b.APP_INFO.ordinal() ? this.f14652o : i2 == C0018b.MAX.ordinal() ? this.f14653p : i2 == C0018b.PRIVACY.ordinal() ? this.f14654q : i2 == C0018b.ADS.ordinal() ? this.f14655r : i2 == C0018b.INCOMPLETE_NETWORKS.ordinal() ? this.f14656s : i2 == C0018b.COMPLETED_NETWORKS.ordinal() ? this.f14657t : this.f14658u).size();
    }

    public void a(List<com.applovin.impl.mediation.debugger.b.b.b> list, List<com.applovin.impl.mediation.debugger.b.a.a> list2, String str, String str2, String str3, m mVar) {
        Activity an;
        this.f14639a = mVar;
        this.f14640b = list2;
        this.f14641d = str;
        this.f14642e = str2;
        this.f14643f = str3;
        if (!(this.f14736c instanceof Activity) && (an = mVar.an()) != null) {
            this.f14736c = an;
        }
        if (list != null && this.f14645h.compareAndSet(false, true)) {
            mVar.A().b("MediationDebuggerListAdapter", "Populating networks...");
            a(list);
            b(list2);
            this.f14652o.addAll(m());
            this.f14653p.addAll(n());
            this.f14654q.addAll(o());
            this.f14655r.addAll(p());
            this.f14656s = c(this.f14647j);
            this.f14657t = c(this.f14648k);
            this.f14658u = c(this.f14649l);
            ArrayList arrayList = new ArrayList(2);
            arrayList.add("privacy_setting_updated");
            arrayList.add("network_sdk_version_updated");
            AppLovinCommunicator.getInstance(this.f14736c).subscribe((AppLovinCommunicatorSubscriber) this, (List<String>) arrayList);
            l();
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() {
            public void run() {
                b.this.notifyDataSetChanged();
            }
        });
    }

    public void a(boolean z2) {
        this.f14646i = z2;
    }

    public boolean a() {
        return this.f14645h.get();
    }

    /* access modifiers changed from: protected */
    public int b() {
        return C0018b.COUNT.ordinal();
    }

    /* access modifiers changed from: protected */
    public c b(int i2) {
        return i2 == C0018b.APP_INFO.ordinal() ? new com.applovin.impl.mediation.debugger.ui.d.e("APP INFO") : i2 == C0018b.MAX.ordinal() ? new com.applovin.impl.mediation.debugger.ui.d.e("MAX") : i2 == C0018b.PRIVACY.ordinal() ? new com.applovin.impl.mediation.debugger.ui.d.e("PRIVACY") : i2 == C0018b.ADS.ordinal() ? new com.applovin.impl.mediation.debugger.ui.d.e("ADS") : i2 == C0018b.INCOMPLETE_NETWORKS.ordinal() ? new com.applovin.impl.mediation.debugger.ui.d.e("INCOMPLETE INTEGRATIONS") : i2 == C0018b.COMPLETED_NETWORKS.ordinal() ? new com.applovin.impl.mediation.debugger.ui.d.e("COMPLETED INTEGRATIONS") : new com.applovin.impl.mediation.debugger.ui.d.e("MISSING INTEGRATIONS");
    }

    /* access modifiers changed from: protected */
    public List<c> c(int i2) {
        return i2 == C0018b.APP_INFO.ordinal() ? this.f14652o : i2 == C0018b.MAX.ordinal() ? this.f14653p : i2 == C0018b.PRIVACY.ordinal() ? this.f14654q : i2 == C0018b.ADS.ordinal() ? this.f14655r : i2 == C0018b.INCOMPLETE_NETWORKS.ordinal() ? this.f14656s : i2 == C0018b.COMPLETED_NETWORKS.ordinal() ? this.f14657t : this.f14658u;
    }

    public boolean c() {
        return this.f14646i;
    }

    public m d() {
        return this.f14639a;
    }

    public List<com.applovin.impl.mediation.debugger.b.a.a> e() {
        return this.f14640b;
    }

    public String f() {
        return this.f14641d;
    }

    public String g() {
        return this.f14642e;
    }

    public String getCommunicatorId() {
        return "MediationDebuggerListAdapter";
    }

    public List<com.applovin.impl.mediation.debugger.b.a.d> h() {
        return this.f14650m;
    }

    public List<com.applovin.impl.mediation.debugger.b.a.d> i() {
        return this.f14651n;
    }

    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        if ("privacy_setting_updated".equals(appLovinCommunicatorMessage.getTopic())) {
            this.f14654q = o();
        } else if ("network_sdk_version_updated".equals(appLovinCommunicatorMessage.getTopic())) {
            this.f14656s = c(this.f14647j);
            this.f14657t = c(this.f14648k);
        } else {
            return;
        }
        j();
    }

    public String toString() {
        return "MediationDebuggerListAdapter{isInitialized=" + this.f14645h.get() + "}";
    }
}
