package com.applovin.impl.sdk.nativeAd;

import com.applovin.impl.sdk.e.a;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.impl.sdk.v;
import com.applovin.mediation.MaxAdFormat;
import org.json.JSONArray;
import org.json.JSONObject;

public class d extends a {

    /* renamed from: a  reason: collision with root package name */
    private final JSONObject f15577a;

    /* renamed from: c  reason: collision with root package name */
    private final AppLovinNativeAdLoadListener f15578c;

    public d(JSONObject jSONObject, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener, m mVar) {
        super("TaskProcessNativeAdResponse", mVar);
        this.f15577a = jSONObject;
        this.f15578c = appLovinNativeAdLoadListener;
    }

    public void run() {
        JSONArray jSONArray = JsonUtils.getJSONArray(this.f15577a, "ads", new JSONArray());
        if (jSONArray.length() > 0) {
            if (v.a()) {
                a("Processing ad...");
            }
            this.f15333b.S().a((a) new e(JsonUtils.getJSONObject(jSONArray, 0, new JSONObject()), this.f15577a, this.f15578c, this.f15333b));
            return;
        }
        if (v.a()) {
            c("No ads were returned from the server");
        }
        Utils.maybeHandleNoFillResponseForPublisher("native_native", MaxAdFormat.NATIVE, this.f15577a, this.f15333b);
        this.f15578c.onNativeAdLoadFailed(204);
    }
}
