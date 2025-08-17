package com.applovin.impl.sdk.e;

import com.applovin.impl.sdk.ad.b;
import com.applovin.impl.sdk.ad.d;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.impl.sdk.v;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;
import org.json.JSONArray;
import org.json.JSONObject;

public class p extends a implements AppLovinAdLoadListener {

    /* renamed from: a  reason: collision with root package name */
    private final JSONObject f15416a;

    /* renamed from: c  reason: collision with root package name */
    private final d f15417c;

    /* renamed from: d  reason: collision with root package name */
    private final b f15418d;

    /* renamed from: e  reason: collision with root package name */
    private final AppLovinAdLoadListener f15419e;

    public p(JSONObject jSONObject, d dVar, b bVar, AppLovinAdLoadListener appLovinAdLoadListener, m mVar) {
        super("TaskProcessAdResponse", mVar);
        if (jSONObject == null) {
            throw new IllegalArgumentException("No response specified");
        } else if (dVar != null) {
            this.f15416a = jSONObject;
            this.f15417c = dVar;
            this.f15418d = bVar;
            this.f15419e = appLovinAdLoadListener;
        } else {
            throw new IllegalArgumentException("No zone specified");
        }
    }

    /* JADX WARNING: type inference failed for: r0v10, types: [com.applovin.impl.sdk.e.a] */
    /* JADX WARNING: type inference failed for: r1v11, types: [com.applovin.impl.sdk.e.q] */
    /* JADX WARNING: type inference failed for: r1v12, types: [com.applovin.impl.sdk.e.s] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(org.json.JSONObject r8) {
        /*
            r7 = this;
            java.lang.String r0 = "type"
            java.lang.String r1 = "undefined"
            java.lang.String r0 = com.applovin.impl.sdk.utils.JsonUtils.getString(r8, r0, r1)
            java.lang.String r1 = "applovin"
            boolean r1 = r1.equalsIgnoreCase(r0)
            if (r1 == 0) goto L_0x0033
            boolean r0 = com.applovin.impl.sdk.v.a()
            if (r0 == 0) goto L_0x001b
            java.lang.String r0 = "Starting task for AppLovin ad..."
            r7.a(r0)
        L_0x001b:
            com.applovin.impl.sdk.e.s r0 = new com.applovin.impl.sdk.e.s
            org.json.JSONObject r3 = r7.f15416a
            com.applovin.impl.sdk.ad.b r4 = r7.f15418d
            com.applovin.impl.sdk.m r6 = r7.f15333b
            r1 = r0
            r2 = r8
            r5 = r7
            r1.<init>(r2, r3, r4, r5, r6)
        L_0x0029:
            com.applovin.impl.sdk.m r8 = r7.f15333b
            com.applovin.impl.sdk.e.o r8 = r8.S()
            r8.a((com.applovin.impl.sdk.e.a) r0)
            goto L_0x009b
        L_0x0033:
            java.lang.String r1 = "vast"
            boolean r1 = r1.equalsIgnoreCase(r0)
            if (r1 == 0) goto L_0x005a
            boolean r0 = com.applovin.impl.sdk.v.a()
            if (r0 == 0) goto L_0x0046
            java.lang.String r0 = "Starting task for VAST ad..."
            r7.a(r0)
        L_0x0046:
            org.json.JSONObject r0 = r7.f15416a
            com.applovin.impl.sdk.ad.b r1 = r7.f15418d
            com.applovin.impl.sdk.m r2 = r7.f15333b
            com.applovin.impl.sdk.e.r r8 = com.applovin.impl.sdk.e.r.a(r8, r0, r1, r7, r2)
            com.applovin.impl.sdk.m r0 = r7.f15333b
            com.applovin.impl.sdk.e.o r0 = r0.S()
            r0.a((com.applovin.impl.sdk.e.a) r8)
            goto L_0x009b
        L_0x005a:
            java.lang.String r1 = "js_tag"
            boolean r1 = r1.equalsIgnoreCase(r0)
            if (r1 == 0) goto L_0x007c
            boolean r0 = com.applovin.impl.sdk.v.a()
            if (r0 == 0) goto L_0x006d
            java.lang.String r0 = "Starting task for JS tag ad..."
            r7.a(r0)
        L_0x006d:
            com.applovin.impl.sdk.e.q r0 = new com.applovin.impl.sdk.e.q
            org.json.JSONObject r3 = r7.f15416a
            com.applovin.impl.sdk.ad.b r4 = r7.f15418d
            com.applovin.impl.sdk.m r6 = r7.f15333b
            r1 = r0
            r2 = r8
            r5 = r7
            r1.<init>(r2, r3, r4, r5, r6)
            goto L_0x0029
        L_0x007c:
            boolean r8 = com.applovin.impl.sdk.v.a()
            if (r8 == 0) goto L_0x0096
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r1 = "Unable to process ad of unknown type: "
            r8.append(r1)
            r8.append(r0)
            java.lang.String r8 = r8.toString()
            r7.c(r8)
        L_0x0096:
            r8 = -800(0xfffffffffffffce0, float:NaN)
            r7.failedToReceiveAd(r8)
        L_0x009b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.e.p.a(org.json.JSONObject):void");
    }

    public void adReceived(AppLovinAd appLovinAd) {
        AppLovinAdLoadListener appLovinAdLoadListener = this.f15419e;
        if (appLovinAdLoadListener != null) {
            appLovinAdLoadListener.adReceived(appLovinAd);
        }
    }

    public void failedToReceiveAd(int i2) {
        AppLovinAdLoadListener appLovinAdLoadListener = this.f15419e;
        if (appLovinAdLoadListener != null) {
            appLovinAdLoadListener.failedToReceiveAd(i2);
        }
    }

    public void run() {
        JSONArray jSONArray = JsonUtils.getJSONArray(this.f15416a, "ads", new JSONArray());
        if (jSONArray.length() > 0) {
            if (v.a()) {
                a("Processing ad...");
            }
            a(JsonUtils.getJSONObject(jSONArray, 0, new JSONObject()));
            return;
        }
        if (v.a()) {
            c("No ads were returned from the server");
        }
        Utils.maybeHandleNoFillResponseForPublisher(this.f15417c.a(), this.f15417c.b(), this.f15416a, this.f15333b);
        failedToReceiveAd(204);
    }
}
