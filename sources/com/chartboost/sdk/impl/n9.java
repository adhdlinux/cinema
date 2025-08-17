package com.chartboost.sdk.impl;

import android.content.SharedPreferences;
import com.chartboost.sdk.impl.tb;
import com.chartboost.sdk.privacy.model.DataUseConsent;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class n9 {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f18259a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public final SharedPreferences f18260b;

    /* renamed from: c  reason: collision with root package name */
    public final z4 f18261c;

    public n9(SharedPreferences sharedPreferences, z4 z4Var) {
        this.f18260b = sharedPreferences;
        this.f18261c = z4Var;
        b();
    }

    public HashMap a() {
        return this.f18259a;
    }

    public void b(DataUseConsent dataUseConsent) {
        w7.a("Chartboost", "Added privacy standard: " + dataUseConsent.getPrivacyStandard() + " with consent: " + dataUseConsent.getConsent());
        this.f18259a.put(dataUseConsent.getPrivacyStandard(), dataUseConsent);
        c();
    }

    public final void c() {
        if (this.f18260b != null) {
            JSONArray jSONArray = new JSONArray();
            for (DataUseConsent a2 : this.f18259a.values()) {
                jSONArray.put(a(a2));
            }
            a(this.f18260b, jSONArray);
        }
    }

    public void a(String str) {
        this.f18259a.remove(str);
        c();
    }

    public final void a(JSONException jSONException) {
        this.f18261c.track(d4.a(tb.d.DECODING_ERROR, jSONException.getMessage(), "", ""));
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0078 A[Catch:{ JSONException -> 0x0112 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00c4 A[Catch:{ JSONException -> 0x0112 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00eb A[Catch:{ JSONException -> 0x0112 }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00f5 A[Catch:{ JSONException -> 0x0112 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b() {
        /*
            r14 = this;
            java.lang.String r0 = "privacyStandard"
            java.lang.String r1 = "consent"
            android.content.SharedPreferences r2 = r14.f18260b
            if (r2 == 0) goto L_0x0119
            java.lang.String r3 = "privacy_standards"
            java.lang.String r4 = ""
            java.lang.String r2 = r2.getString(r3, r4)
            if (r2 == 0) goto L_0x0119
            boolean r3 = r2.isEmpty()
            if (r3 != 0) goto L_0x0119
            org.json.JSONArray r3 = new org.json.JSONArray     // Catch:{ JSONException -> 0x0112 }
            r3.<init>(r2)     // Catch:{ JSONException -> 0x0112 }
            int r2 = r3.length()     // Catch:{ JSONException -> 0x0112 }
            r4 = 0
            r5 = 0
        L_0x0023:
            if (r5 >= r2) goto L_0x0119
            org.json.JSONObject r6 = r3.getJSONObject(r5)     // Catch:{ JSONException -> 0x0112 }
            java.lang.String r7 = r6.getString(r0)     // Catch:{ JSONException -> 0x0112 }
            java.lang.String r8 = r6.getString(r1)     // Catch:{ JSONException -> 0x0112 }
            int r9 = r7.hashCode()     // Catch:{ JSONException -> 0x0112 }
            r10 = -1172350233(0xffffffffba1f5ae7, float:-6.078914E-4)
            r11 = 3
            r12 = 2
            r13 = 1
            if (r9 == r10) goto L_0x006b
            r10 = 3168159(0x30579f, float:4.439536E-39)
            if (r9 == r10) goto L_0x0061
            r10 = 3319983(0x32a8af, float:4.652287E-39)
            if (r9 == r10) goto L_0x0057
            r10 = 94846581(0x5a73e75, float:1.5727548E-35)
            if (r9 == r10) goto L_0x004d
            goto L_0x0075
        L_0x004d:
            java.lang.String r9 = "coppa"
            boolean r9 = r7.equals(r9)     // Catch:{ JSONException -> 0x0112 }
            if (r9 == 0) goto L_0x0075
            r9 = 2
            goto L_0x0076
        L_0x0057:
            java.lang.String r9 = "lgpd"
            boolean r9 = r7.equals(r9)     // Catch:{ JSONException -> 0x0112 }
            if (r9 == 0) goto L_0x0075
            r9 = 3
            goto L_0x0076
        L_0x0061:
            java.lang.String r9 = "gdpr"
            boolean r9 = r7.equals(r9)     // Catch:{ JSONException -> 0x0112 }
            if (r9 == 0) goto L_0x0075
            r9 = 0
            goto L_0x0076
        L_0x006b:
            java.lang.String r9 = "us_privacy"
            boolean r9 = r7.equals(r9)     // Catch:{ JSONException -> 0x0112 }
            if (r9 == 0) goto L_0x0075
            r9 = 1
            goto L_0x0076
        L_0x0075:
            r9 = -1
        L_0x0076:
            if (r9 == 0) goto L_0x00c4
            if (r9 == r13) goto L_0x00a0
            if (r9 == r12) goto L_0x0096
            if (r9 == r11) goto L_0x008c
            com.chartboost.sdk.privacy.model.Custom r8 = new com.chartboost.sdk.privacy.model.Custom     // Catch:{ JSONException -> 0x0112 }
            java.lang.String r9 = r6.getString(r0)     // Catch:{ JSONException -> 0x0112 }
            java.lang.String r6 = r6.getString(r1)     // Catch:{ JSONException -> 0x0112 }
            r8.<init>(r9, r6)     // Catch:{ JSONException -> 0x0112 }
            goto L_0x00e9
        L_0x008c:
            com.chartboost.sdk.privacy.model.LGPD r8 = new com.chartboost.sdk.privacy.model.LGPD     // Catch:{ JSONException -> 0x0112 }
            boolean r6 = r6.getBoolean(r1)     // Catch:{ JSONException -> 0x0112 }
            r8.<init>(r6)     // Catch:{ JSONException -> 0x0112 }
            goto L_0x00e9
        L_0x0096:
            com.chartboost.sdk.privacy.model.COPPA r8 = new com.chartboost.sdk.privacy.model.COPPA     // Catch:{ JSONException -> 0x0112 }
            boolean r6 = r6.getBoolean(r1)     // Catch:{ JSONException -> 0x0112 }
            r8.<init>(r6)     // Catch:{ JSONException -> 0x0112 }
            goto L_0x00e9
        L_0x00a0:
            com.chartboost.sdk.privacy.model.CCPA$CCPA_CONSENT r6 = com.chartboost.sdk.privacy.model.CCPA.CCPA_CONSENT.OPT_IN_SALE     // Catch:{ JSONException -> 0x0112 }
            java.lang.String r9 = r6.getValue()     // Catch:{ JSONException -> 0x0112 }
            boolean r9 = r9.equals(r8)     // Catch:{ JSONException -> 0x0112 }
            if (r9 == 0) goto L_0x00b2
            com.chartboost.sdk.privacy.model.CCPA r8 = new com.chartboost.sdk.privacy.model.CCPA     // Catch:{ JSONException -> 0x0112 }
            r8.<init>(r6)     // Catch:{ JSONException -> 0x0112 }
            goto L_0x00e9
        L_0x00b2:
            com.chartboost.sdk.privacy.model.CCPA$CCPA_CONSENT r6 = com.chartboost.sdk.privacy.model.CCPA.CCPA_CONSENT.OPT_OUT_SALE     // Catch:{ JSONException -> 0x0112 }
            java.lang.String r9 = r6.getValue()     // Catch:{ JSONException -> 0x0112 }
            boolean r8 = r9.equals(r8)     // Catch:{ JSONException -> 0x0112 }
            if (r8 == 0) goto L_0x00e8
            com.chartboost.sdk.privacy.model.CCPA r8 = new com.chartboost.sdk.privacy.model.CCPA     // Catch:{ JSONException -> 0x0112 }
            r8.<init>(r6)     // Catch:{ JSONException -> 0x0112 }
            goto L_0x00e9
        L_0x00c4:
            com.chartboost.sdk.privacy.model.GDPR$GDPR_CONSENT r6 = com.chartboost.sdk.privacy.model.GDPR.GDPR_CONSENT.BEHAVIORAL     // Catch:{ JSONException -> 0x0112 }
            java.lang.String r9 = r6.getValue()     // Catch:{ JSONException -> 0x0112 }
            boolean r9 = r9.equals(r8)     // Catch:{ JSONException -> 0x0112 }
            if (r9 == 0) goto L_0x00d6
            com.chartboost.sdk.privacy.model.GDPR r8 = new com.chartboost.sdk.privacy.model.GDPR     // Catch:{ JSONException -> 0x0112 }
            r8.<init>(r6)     // Catch:{ JSONException -> 0x0112 }
            goto L_0x00e9
        L_0x00d6:
            com.chartboost.sdk.privacy.model.GDPR$GDPR_CONSENT r6 = com.chartboost.sdk.privacy.model.GDPR.GDPR_CONSENT.NON_BEHAVIORAL     // Catch:{ JSONException -> 0x0112 }
            java.lang.String r9 = r6.getValue()     // Catch:{ JSONException -> 0x0112 }
            boolean r8 = r9.equals(r8)     // Catch:{ JSONException -> 0x0112 }
            if (r8 == 0) goto L_0x00e8
            com.chartboost.sdk.privacy.model.GDPR r8 = new com.chartboost.sdk.privacy.model.GDPR     // Catch:{ JSONException -> 0x0112 }
            r8.<init>(r6)     // Catch:{ JSONException -> 0x0112 }
            goto L_0x00e9
        L_0x00e8:
            r8 = 0
        L_0x00e9:
            if (r8 == 0) goto L_0x00f5
            java.util.HashMap r6 = r14.f18259a     // Catch:{ JSONException -> 0x0112 }
            java.lang.String r7 = r8.getPrivacyStandard()     // Catch:{ JSONException -> 0x0112 }
            r6.put(r7, r8)     // Catch:{ JSONException -> 0x0112 }
            goto L_0x010e
        L_0x00f5:
            r14.b((java.lang.String) r7)     // Catch:{ JSONException -> 0x0112 }
            java.lang.String r6 = "Chartboost"
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0112 }
            r8.<init>()     // Catch:{ JSONException -> 0x0112 }
            java.lang.String r9 = "Failed to load consent: "
            r8.append(r9)     // Catch:{ JSONException -> 0x0112 }
            r8.append(r7)     // Catch:{ JSONException -> 0x0112 }
            java.lang.String r7 = r8.toString()     // Catch:{ JSONException -> 0x0112 }
            com.chartboost.sdk.impl.w7.a(r6, r7)     // Catch:{ JSONException -> 0x0112 }
        L_0x010e:
            int r5 = r5 + 1
            goto L_0x0023
        L_0x0112:
            r0 = move-exception
            r14.a((org.json.JSONException) r0)
            r0.printStackTrace()
        L_0x0119:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.n9.b():void");
    }

    public final void a(SharedPreferences sharedPreferences, JSONArray jSONArray) {
        if (sharedPreferences != null && jSONArray != null) {
            sharedPreferences.edit().putString("privacy_standards", jSONArray.toString()).apply();
        }
    }

    public final JSONObject a(DataUseConsent dataUseConsent) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("privacyStandard", dataUseConsent.getPrivacyStandard());
            jSONObject.put("consent", dataUseConsent.getConsent());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public final void b(String str) {
        this.f18261c.track(d4.a(tb.d.PERSISTED_DATA_READING_ERROR, str, "", ""));
    }
}
