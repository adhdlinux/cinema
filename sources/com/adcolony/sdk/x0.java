package com.adcolony.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.adcolony.sdk.e0;
import com.facebook.common.util.UriUtil;
import com.google.android.gms.common.internal.ImagesContract;
import com.unity3d.services.ads.adunit.AdUnitActivity;

class x0 {

    class a implements j0 {
        a() {
        }

        public void a(h0 h0Var) {
            boolean unused = x0.this.p(h0Var);
        }
    }

    class b implements j0 {
        b() {
        }

        public void a(h0 h0Var) {
            boolean unused = x0.this.c(h0Var);
        }
    }

    class c implements j0 {
        c() {
        }

        public void a(h0 h0Var) {
            x0.this.i(h0Var);
        }
    }

    class d implements j0 {
        d() {
        }

        public void a(h0 h0Var) {
            boolean unused = x0.this.x(h0Var);
        }
    }

    class e implements j0 {
        e() {
        }

        public void a(h0 h0Var) {
            boolean unused = x0.this.t(h0Var);
        }
    }

    class f implements j0 {
        f() {
        }

        public void a(h0 h0Var) {
            boolean unused = x0.this.s(h0Var);
        }
    }

    class g implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f13497b;

        g(x0 x0Var, String str) {
            this.f13497b = str;
        }

        public void run() {
            f1 q2 = c0.q();
            c0.n(q2, "type", "open_hook");
            c0.n(q2, "message", this.f13497b);
            new h0("CustomMessage.controller_send", 0, q2).e();
        }
    }

    class h implements j0 {
        h() {
        }

        public void a(h0 h0Var) {
            x0.this.r(h0Var);
        }
    }

    class i implements j0 {
        i() {
        }

        public void a(h0 h0Var) {
            x0.this.w(h0Var);
        }
    }

    class j implements j0 {
        j() {
        }

        public void a(h0 h0Var) {
            x0.this.u(h0Var);
        }
    }

    class k implements j0 {
        k() {
        }

        public void a(h0 h0Var) {
            x0.this.y(h0Var);
        }
    }

    class l implements j0 {
        l() {
        }

        public void a(h0 h0Var) {
            x0.this.q(h0Var);
        }
    }

    class m implements j0 {
        m() {
        }

        public void a(h0 h0Var) {
            x0.this.n(h0Var);
        }
    }

    class n implements j0 {
        n() {
        }

        public void a(h0 h0Var) {
            x0.this.l(h0Var);
        }
    }

    class o implements j0 {
        o() {
        }

        public void a(h0 h0Var) {
            x0.this.e(h0Var);
        }
    }

    class p implements j0 {
        p() {
        }

        public void a(h0 h0Var) {
            x0.this.v(h0Var);
        }
    }

    x0() {
    }

    /* access modifiers changed from: private */
    public boolean c(h0 h0Var) {
        Activity activity;
        String E = c0.E(h0Var.a(), "ad_session_id");
        if (a.a() instanceof Activity) {
            activity = (Activity) a.a();
        } else {
            activity = null;
        }
        boolean z2 = activity instanceof AdColonyAdViewActivity;
        if (!(activity instanceof b)) {
            return false;
        }
        if (z2) {
            ((AdColonyAdViewActivity) activity).f();
            return true;
        }
        f1 q2 = c0.q();
        c0.n(q2, "id", E);
        new h0("AdSession.on_request_close", ((b) activity).f12950d, q2).e();
        return true;
    }

    private boolean g(String str) {
        if (a.f().T().s().get(str) == null) {
            return false;
        }
        f1 q2 = c0.q();
        c0.n(q2, "ad_session_id", str);
        new h0("MRAID.on_event", 1, q2).e();
        return true;
    }

    private void k(String str) {
        if (!z0.m(new g(this, str))) {
            new e0.a().c("Executing ADCSystem.sendOpenCustomMessage failed").d(e0.f13114i);
        }
    }

    /* access modifiers changed from: private */
    public boolean p(h0 h0Var) {
        f1 a2 = h0Var.a();
        d T = a.f().T();
        String E = c0.E(a2, "ad_session_id");
        AdColonyInterstitial adColonyInterstitial = T.z().get(E);
        AdColonyAdView adColonyAdView = T.s().get(E);
        if ((adColonyInterstitial == null || adColonyInterstitial.w() == null || adColonyInterstitial.p() == null) && (adColonyAdView == null || adColonyAdView.getListener() == null)) {
            return false;
        }
        if (adColonyAdView == null) {
            new h0("AdUnit.make_in_app_purchase", adColonyInterstitial.p().I()).e();
        }
        b(E);
        g(E);
        return true;
    }

    /* access modifiers changed from: private */
    public boolean s(h0 h0Var) {
        f1 a2 = h0Var.a();
        String E = c0.E(c0.C(a2, "clickOverride"), ImagesContract.URL);
        String E2 = c0.E(a2, "ad_session_id");
        d T = a.f().T();
        AdColonyInterstitial adColonyInterstitial = T.z().get(E2);
        AdColonyAdView adColonyAdView = T.s().get(E2);
        if (adColonyInterstitial != null) {
            adColonyInterstitial.k(E);
            return true;
        } else if (adColonyAdView == null) {
            return false;
        } else {
            adColonyAdView.setClickOverride(E);
            return true;
        }
    }

    /* access modifiers changed from: private */
    public boolean t(h0 h0Var) {
        int i2;
        f1 a2 = h0Var.a();
        String E = c0.E(a2, "ad_session_id");
        int A = c0.A(a2, AdUnitActivity.EXTRA_ORIENTATION);
        d T = a.f().T();
        AdColonyAdView adColonyAdView = T.s().get(E);
        AdColonyInterstitial adColonyInterstitial = T.z().get(E);
        Context a3 = a.a();
        if (adColonyAdView != null) {
            adColonyAdView.setOrientation(A);
        } else if (adColonyInterstitial != null) {
            adColonyInterstitial.c(A);
        }
        if (adColonyInterstitial == null && adColonyAdView == null) {
            new e0.a().c("Invalid ad session id sent with set orientation properties message: ").c(E).d(e0.f13114i);
            return false;
        } else if (!(a3 instanceof b)) {
            return true;
        } else {
            b bVar = (b) a3;
            if (adColonyAdView == null) {
                i2 = adColonyInterstitial.u();
            } else {
                i2 = adColonyAdView.getOrientation();
            }
            bVar.b(i2);
            return true;
        }
    }

    /* access modifiers changed from: private */
    public boolean x(h0 h0Var) {
        AdColonyAdView adColonyAdView = a.f().T().s().get(c0.E(h0Var.a(), "ad_session_id"));
        if (adColonyAdView == null) {
            return false;
        }
        adColonyAdView.setNoCloseButton(c0.t(h0Var.a(), "use_custom_close"));
        return true;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        a.e("System.open_store", new h());
        a.e("System.telephone", new i());
        a.e("System.sms", new j());
        a.e("System.vibrate", new k());
        a.e("System.open_browser", new l());
        a.e("System.mail", new m());
        a.e("System.launch_app", new n());
        a.e("System.create_calendar_event", new o());
        a.e("System.social_post", new p());
        a.e("System.make_in_app_purchase", new a());
        a.e("System.close", new b());
        a.e("System.expand", new c());
        a.e("System.use_custom_close", new d());
        a.e("System.set_orientation_properties", new e());
        a.e("System.click_override", new f());
    }

    /* access modifiers changed from: package-private */
    public void b(String str) {
        AdColonyAdViewListener adColonyAdViewListener;
        d T = a.f().T();
        AdColonyInterstitial adColonyInterstitial = T.z().get(str);
        if (adColonyInterstitial == null || adColonyInterstitial.w() == null || !adColonyInterstitial.y()) {
            AdColonyAdView adColonyAdView = T.s().get(str);
            if (adColonyAdView != null) {
                adColonyAdViewListener = adColonyAdView.getListener();
            } else {
                adColonyAdViewListener = null;
            }
            if (adColonyAdView != null && adColonyAdViewListener != null && adColonyAdView.c()) {
                adColonyAdViewListener.e(adColonyAdView);
                return;
            }
            return;
        }
        adColonyInterstitial.w().c(adColonyInterstitial);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x01aa  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x01ce  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x01ed  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean e(com.adcolony.sdk.h0 r25) {
        /*
            r24 = this;
            r0 = r24
            r1 = r25
            com.adcolony.sdk.f1 r2 = com.adcolony.sdk.c0.q()
            com.adcolony.sdk.f1 r3 = r25.a()
            java.lang.String r4 = "ad_session_id"
            java.lang.String r4 = com.adcolony.sdk.c0.E(r3, r4)
            java.lang.String r5 = "params"
            com.adcolony.sdk.f1 r3 = com.adcolony.sdk.c0.C(r3, r5)
            java.lang.String r5 = "recurrence"
            com.adcolony.sdk.f1 r5 = com.adcolony.sdk.c0.C(r3, r5)
            com.adcolony.sdk.e1 r6 = com.adcolony.sdk.c0.c()
            com.adcolony.sdk.e1 r7 = com.adcolony.sdk.c0.c()
            com.adcolony.sdk.e1 r8 = com.adcolony.sdk.c0.c()
            java.lang.String r9 = "description"
            java.lang.String r10 = com.adcolony.sdk.c0.E(r3, r9)
            java.lang.String r11 = "location"
            com.adcolony.sdk.c0.E(r3, r11)
            java.lang.String r11 = "start"
            java.lang.String r11 = com.adcolony.sdk.c0.E(r3, r11)
            java.lang.String r12 = "end"
            java.lang.String r12 = com.adcolony.sdk.c0.E(r3, r12)
            java.lang.String r13 = "summary"
            java.lang.String r3 = com.adcolony.sdk.c0.E(r3, r13)
            java.lang.String r13 = ""
            if (r5 == 0) goto L_0x0078
            boolean r14 = r5.q()
            if (r14 != 0) goto L_0x0078
            java.lang.String r6 = "expires"
            java.lang.String r6 = com.adcolony.sdk.c0.E(r5, r6)
            java.lang.String r7 = "frequency"
            java.lang.String r7 = com.adcolony.sdk.c0.E(r5, r7)
            java.util.Locale r8 = java.util.Locale.getDefault()
            java.lang.String r7 = r7.toUpperCase(r8)
            java.lang.String r8 = "daysInWeek"
            com.adcolony.sdk.e1 r8 = com.adcolony.sdk.c0.d(r5, r8)
            java.lang.String r14 = "daysInMonth"
            com.adcolony.sdk.e1 r14 = com.adcolony.sdk.c0.d(r5, r14)
            java.lang.String r15 = "daysInYear"
            com.adcolony.sdk.e1 r15 = com.adcolony.sdk.c0.d(r5, r15)
            goto L_0x007d
        L_0x0078:
            r14 = r7
            r15 = r8
            r7 = r13
            r8 = r6
            r6 = r7
        L_0x007d:
            boolean r13 = r3.equals(r13)
            if (r13 == 0) goto L_0x0084
            r3 = r10
        L_0x0084:
            java.util.Date r11 = com.adcolony.sdk.z0.N(r11)
            java.util.Date r12 = com.adcolony.sdk.z0.N(r12)
            java.util.Date r6 = com.adcolony.sdk.z0.N(r6)
            java.lang.String r13 = "success"
            if (r11 == 0) goto L_0x0206
            if (r12 != 0) goto L_0x0098
            goto L_0x0206
        L_0x0098:
            long r0 = r11.getTime()
            r16 = r13
            long r12 = r12.getTime()
            r17 = 0
            if (r6 == 0) goto L_0x00b5
            long r19 = r6.getTime()
            long r21 = r11.getTime()
            long r19 = r19 - r21
            r21 = 1000(0x3e8, double:4.94E-321)
            long r19 = r19 / r21
            goto L_0x00b7
        L_0x00b5:
            r19 = r17
        L_0x00b7:
            java.lang.String r6 = "DAILY"
            boolean r6 = r7.equals(r6)
            r21 = 1
            if (r6 == 0) goto L_0x00cd
            r17 = 86400(0x15180, double:4.26873E-319)
            long r19 = r19 / r17
        L_0x00c6:
            long r17 = r19 + r21
        L_0x00c8:
            r19 = r12
            r11 = r17
            goto L_0x00f7
        L_0x00cd:
            java.lang.String r6 = "WEEKLY"
            boolean r6 = r7.equals(r6)
            if (r6 == 0) goto L_0x00db
            r17 = 604800(0x93a80, double:2.98811E-318)
            long r19 = r19 / r17
            goto L_0x00c6
        L_0x00db:
            java.lang.String r6 = "MONTHLY"
            boolean r6 = r7.equals(r6)
            if (r6 == 0) goto L_0x00e9
            r17 = 2629800(0x2820a8, double:1.299294E-317)
            long r19 = r19 / r17
            goto L_0x00c6
        L_0x00e9:
            java.lang.String r6 = "YEARLY"
            boolean r6 = r7.equals(r6)
            if (r6 == 0) goto L_0x00c8
            r17 = 31557600(0x1e187e0, double:1.5591526E-316)
            long r19 = r19 / r17
            goto L_0x00c6
        L_0x00f7:
            java.lang.String r6 = "endTime"
            java.lang.String r13 = "beginTime"
            r17 = r4
            java.lang.String r4 = "title"
            r18 = r2
            java.lang.String r2 = "vnd.android.cursor.item/event"
            r21 = r6
            java.lang.String r6 = "android.intent.action.EDIT"
            if (r5 == 0) goto L_0x01aa
            boolean r5 = r5.q()
            if (r5 != 0) goto L_0x01aa
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r22 = r0
            java.lang.String r0 = "FREQ="
            r5.append(r0)
            r5.append(r7)
            java.lang.String r0 = ";COUNT="
            r5.append(r0)
            r5.append(r11)
            java.lang.String r0 = r5.toString()
            int r1 = r8.e()     // Catch:{ JSONException -> 0x0184 }
            if (r1 == 0) goto L_0x0148
            java.lang.String r1 = com.adcolony.sdk.z0.g(r8)     // Catch:{ JSONException -> 0x0184 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0184 }
            r5.<init>()     // Catch:{ JSONException -> 0x0184 }
            r5.append(r0)     // Catch:{ JSONException -> 0x0184 }
            java.lang.String r7 = ";BYDAY="
            r5.append(r7)     // Catch:{ JSONException -> 0x0184 }
            r5.append(r1)     // Catch:{ JSONException -> 0x0184 }
            java.lang.String r0 = r5.toString()     // Catch:{ JSONException -> 0x0184 }
        L_0x0148:
            int r1 = r14.e()     // Catch:{ JSONException -> 0x0184 }
            if (r1 == 0) goto L_0x0166
            java.lang.String r1 = com.adcolony.sdk.z0.w(r14)     // Catch:{ JSONException -> 0x0184 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0184 }
            r5.<init>()     // Catch:{ JSONException -> 0x0184 }
            r5.append(r0)     // Catch:{ JSONException -> 0x0184 }
            java.lang.String r7 = ";BYMONTHDAY="
            r5.append(r7)     // Catch:{ JSONException -> 0x0184 }
            r5.append(r1)     // Catch:{ JSONException -> 0x0184 }
            java.lang.String r0 = r5.toString()     // Catch:{ JSONException -> 0x0184 }
        L_0x0166:
            int r1 = r15.e()     // Catch:{ JSONException -> 0x0184 }
            if (r1 == 0) goto L_0x0184
            java.lang.String r1 = com.adcolony.sdk.z0.w(r15)     // Catch:{ JSONException -> 0x0184 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0184 }
            r5.<init>()     // Catch:{ JSONException -> 0x0184 }
            r5.append(r0)     // Catch:{ JSONException -> 0x0184 }
            java.lang.String r7 = ";BYYEARDAY="
            r5.append(r7)     // Catch:{ JSONException -> 0x0184 }
            r5.append(r1)     // Catch:{ JSONException -> 0x0184 }
            java.lang.String r0 = r5.toString()     // Catch:{ JSONException -> 0x0184 }
        L_0x0184:
            android.content.Intent r1 = new android.content.Intent
            r1.<init>(r6)
            android.content.Intent r1 = r1.setType(r2)
            android.content.Intent r1 = r1.putExtra(r4, r3)
            android.content.Intent r1 = r1.putExtra(r9, r10)
            r7 = r22
            android.content.Intent r1 = r1.putExtra(r13, r7)
            r11 = r19
            r5 = r21
            android.content.Intent r1 = r1.putExtra(r5, r11)
            java.lang.String r2 = "rrule"
            android.content.Intent r0 = r1.putExtra(r2, r0)
            goto L_0x01c8
        L_0x01aa:
            r7 = r0
            r11 = r19
            r5 = r21
            android.content.Intent r0 = new android.content.Intent
            r0.<init>(r6)
            android.content.Intent r0 = r0.setType(r2)
            android.content.Intent r0 = r0.putExtra(r4, r3)
            android.content.Intent r0 = r0.putExtra(r9, r10)
            android.content.Intent r0 = r0.putExtra(r13, r7)
            android.content.Intent r0 = r0.putExtra(r5, r11)
        L_0x01c8:
            boolean r0 = com.adcolony.sdk.z0.k(r0)
            if (r0 == 0) goto L_0x01ed
            r0 = 1
            r2 = r16
            r1 = r18
            com.adcolony.sdk.c0.w(r1, r2, r0)
            r3 = r25
            com.adcolony.sdk.h0 r1 = r3.b(r1)
            r1.e()
            r4 = r24
            r1 = r17
            r4.h(r1)
            r4.b(r1)
            r4.g(r1)
            return r0
        L_0x01ed:
            r4 = r24
            r3 = r25
            r2 = r16
            r1 = r18
            r0 = 0
            java.lang.String r5 = "Unable to create Calendar Event."
            com.adcolony.sdk.z0.o(r5, r0)
            com.adcolony.sdk.c0.w(r1, r2, r0)
            com.adcolony.sdk.h0 r1 = r3.b(r1)
            r1.e()
            return r0
        L_0x0206:
            r4 = r24
            r3 = r1
            r1 = r2
            r2 = r13
            r0 = 0
            java.lang.String r5 = "Unable to create Calendar Event"
            com.adcolony.sdk.z0.o(r5, r0)
            com.adcolony.sdk.c0.w(r1, r2, r0)
            com.adcolony.sdk.h0 r1 = r3.b(r1)
            r1.e()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adcolony.sdk.x0.e(com.adcolony.sdk.h0):boolean");
    }

    /* access modifiers changed from: package-private */
    public void h(String str) {
        AdColonyAdViewListener adColonyAdViewListener;
        d T = a.f().T();
        AdColonyInterstitial adColonyInterstitial = T.z().get(str);
        if (adColonyInterstitial == null || adColonyInterstitial.w() == null) {
            AdColonyAdView adColonyAdView = T.s().get(str);
            if (adColonyAdView != null) {
                adColonyAdViewListener = adColonyAdView.getListener();
            } else {
                adColonyAdViewListener = null;
            }
            if (adColonyAdView != null && adColonyAdViewListener != null) {
                adColonyAdViewListener.f(adColonyAdView);
                return;
            }
            return;
        }
        adColonyInterstitial.w().g(adColonyInterstitial);
    }

    /* access modifiers changed from: package-private */
    public boolean i(h0 h0Var) {
        f1 a2 = h0Var.a();
        Context a3 = a.a();
        if (a3 != null && a.i()) {
            String E = c0.E(a2, "ad_session_id");
            k f2 = a.f();
            AdColonyAdView adColonyAdView = f2.T().s().get(E);
            if (adColonyAdView != null && ((adColonyAdView.getTrustedDemandSource() || adColonyAdView.c()) && f2.r0() != adColonyAdView)) {
                adColonyAdView.setExpandMessage(h0Var);
                adColonyAdView.setExpandedWidth(c0.A(a2, "width"));
                adColonyAdView.setExpandedHeight(c0.A(a2, "height"));
                adColonyAdView.setOrientation(c0.a(a2, AdUnitActivity.EXTRA_ORIENTATION, -1));
                adColonyAdView.setNoCloseButton(c0.t(a2, "use_custom_close"));
                f2.v(adColonyAdView);
                f2.y(adColonyAdView.getContainer());
                Intent intent = new Intent(a3, AdColonyAdViewActivity.class);
                g(E);
                b(E);
                z0.k(intent);
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean l(h0 h0Var) {
        f1 q2 = c0.q();
        f1 a2 = h0Var.a();
        String E = c0.E(a2, "ad_session_id");
        if (c0.t(a2, "deep_link")) {
            return r(h0Var);
        }
        Context a3 = a.a();
        if (a3 == null) {
            return false;
        }
        if (z0.k(a3.getPackageManager().getLaunchIntentForPackage(c0.E(a2, "handle")))) {
            c0.w(q2, "success", true);
            h0Var.b(q2).e();
            h(E);
            b(E);
            g(E);
            return true;
        }
        z0.o("Failed to launch external application.", 0);
        c0.w(q2, "success", false);
        h0Var.b(q2).e();
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean n(h0 h0Var) {
        f1 q2 = c0.q();
        f1 a2 = h0Var.a();
        e1 d2 = c0.d(a2, "recipients");
        boolean t2 = c0.t(a2, "html");
        String E = c0.E(a2, "subject");
        String E2 = c0.E(a2, "body");
        String E3 = c0.E(a2, "ad_session_id");
        String[] strArr = new String[d2.e()];
        for (int i2 = 0; i2 < d2.e(); i2++) {
            strArr[i2] = c0.s(d2, i2);
        }
        Intent intent = new Intent("android.intent.action.SEND");
        if (!t2) {
            intent.setType("plain/text");
        }
        intent.putExtra("android.intent.extra.SUBJECT", E).putExtra("android.intent.extra.TEXT", E2).putExtra("android.intent.extra.EMAIL", strArr);
        if (z0.k(intent)) {
            c0.w(q2, "success", true);
            h0Var.b(q2).e();
            h(E3);
            b(E3);
            g(E3);
            return true;
        }
        z0.o("Failed to send email.", 0);
        c0.w(q2, "success", false);
        h0Var.b(q2).e();
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean q(h0 h0Var) {
        f1 q2 = c0.q();
        f1 a2 = h0Var.a();
        String E = c0.E(a2, ImagesContract.URL);
        String E2 = c0.E(a2, "ad_session_id");
        AdColonyAdView adColonyAdView = a.f().T().s().get(E2);
        if (adColonyAdView != null && !adColonyAdView.getTrustedDemandSource() && !adColonyAdView.c()) {
            return false;
        }
        if (E.startsWith("browser")) {
            E = E.replaceFirst("browser", UriUtil.HTTP_SCHEME);
        }
        if (E.startsWith("safari")) {
            E = E.replaceFirst("safari", UriUtil.HTTP_SCHEME);
        }
        k(E);
        if (z0.k(new Intent("android.intent.action.VIEW", Uri.parse(E)))) {
            c0.w(q2, "success", true);
            h0Var.b(q2).e();
            h(E2);
            b(E2);
            g(E2);
            return true;
        }
        z0.o("Failed to launch browser.", 0);
        c0.w(q2, "success", false);
        h0Var.b(q2).e();
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean r(h0 h0Var) {
        f1 q2 = c0.q();
        f1 a2 = h0Var.a();
        String E = c0.E(a2, "product_id");
        String E2 = c0.E(a2, "ad_session_id");
        if (E.equals("")) {
            E = c0.E(a2, "handle");
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(E));
        k(E);
        if (z0.k(intent)) {
            c0.w(q2, "success", true);
            h0Var.b(q2).e();
            h(E2);
            b(E2);
            g(E2);
            return true;
        }
        z0.o("Unable to open.", 0);
        c0.w(q2, "success", false);
        h0Var.b(q2).e();
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean u(h0 h0Var) {
        f1 a2 = h0Var.a();
        f1 q2 = c0.q();
        String E = c0.E(a2, "ad_session_id");
        e1 d2 = c0.d(a2, "recipients");
        String str = "";
        for (int i2 = 0; i2 < d2.e(); i2++) {
            if (i2 != 0) {
                str = str + ";";
            }
            str = str + c0.s(d2, i2);
        }
        if (z0.k(new Intent("android.intent.action.VIEW", Uri.parse("smsto:" + str)).putExtra("sms_body", c0.E(a2, "body")))) {
            c0.w(q2, "success", true);
            h0Var.b(q2).e();
            h(E);
            b(E);
            g(E);
            return true;
        }
        z0.o("Failed to create sms.", 0);
        c0.w(q2, "success", false);
        h0Var.b(q2).e();
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean v(h0 h0Var) {
        f1 q2 = c0.q();
        f1 a2 = h0Var.a();
        Intent type = new Intent("android.intent.action.SEND").setType("text/plain");
        Intent putExtra = type.putExtra("android.intent.extra.TEXT", c0.E(a2, "text") + " " + c0.E(a2, ImagesContract.URL));
        String E = c0.E(a2, "ad_session_id");
        if (z0.l(putExtra, true)) {
            c0.w(q2, "success", true);
            h0Var.b(q2).e();
            h(E);
            b(E);
            g(E);
            return true;
        }
        z0.o("Unable to create social post.", 0);
        c0.w(q2, "success", false);
        h0Var.b(q2).e();
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean w(h0 h0Var) {
        f1 q2 = c0.q();
        f1 a2 = h0Var.a();
        Intent intent = new Intent("android.intent.action.DIAL");
        Intent data = intent.setData(Uri.parse("tel:" + c0.E(a2, "phone_number")));
        String E = c0.E(a2, "ad_session_id");
        if (z0.k(data)) {
            c0.w(q2, "success", true);
            h0Var.b(q2).e();
            h(E);
            b(E);
            g(E);
            return true;
        }
        z0.o("Failed to dial number.", 0);
        c0.w(q2, "success", false);
        h0Var.b(q2).e();
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean y(h0 h0Var) {
        Context a2 = a.a();
        if (a2 == null) {
            return false;
        }
        int a3 = c0.a(h0Var.a(), "length_ms", 500);
        f1 q2 = c0.q();
        e1 I = z0.I(a2);
        boolean z2 = false;
        for (int i2 = 0; i2 < I.e(); i2++) {
            if (c0.s(I, i2).equals("android.permission.VIBRATE")) {
                z2 = true;
            }
        }
        if (!z2) {
            new e0.a().c("No vibrate permission detected.").d(e0.f13111f);
            c0.w(q2, "success", false);
            h0Var.b(q2).e();
            return false;
        } else if (z0.j(a2, (long) a3)) {
            c0.w(q2, "success", true);
            h0Var.b(q2).e();
            return true;
        } else {
            c0.w(q2, "success", false);
            h0Var.b(q2).e();
            return false;
        }
    }
}
