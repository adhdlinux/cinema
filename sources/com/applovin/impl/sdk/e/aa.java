package com.applovin.impl.sdk.e;

import com.applovin.impl.sdk.ad.e;
import com.applovin.impl.sdk.b.c;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinErrorCodes;
import java.util.Collections;
import java.util.Map;
import org.json.JSONObject;

public class aa extends ab {

    /* renamed from: a  reason: collision with root package name */
    private final e f15337a;

    /* renamed from: c  reason: collision with root package name */
    private final AppLovinAdRewardListener f15338c;

    public aa(e eVar, AppLovinAdRewardListener appLovinAdRewardListener, m mVar) {
        super("TaskValidateAppLovinReward", mVar);
        this.f15337a = eVar;
        this.f15338c = appLovinAdRewardListener;
    }

    public String a() {
        return "2.0/vr";
    }

    /* access modifiers changed from: protected */
    public void a(int i2) {
        String str;
        super.a(i2);
        if (i2 < 400 || i2 >= 500) {
            this.f15338c.validationRequestFailed(this.f15337a, i2);
            str = "network_timeout";
        } else {
            this.f15338c.userRewardRejected(this.f15337a, Collections.emptyMap());
            str = "rejected";
        }
        this.f15337a.a(c.a(str));
    }

    /* access modifiers changed from: protected */
    public void a(c cVar) {
        this.f15337a.a(cVar);
        String b2 = cVar.b();
        Map<String, String> a2 = cVar.a();
        if (b2.equals("accepted")) {
            this.f15338c.userRewardVerified(this.f15337a, a2);
        } else if (b2.equals("quota_exceeded")) {
            this.f15338c.userOverQuota(this.f15337a, a2);
        } else if (b2.equals("rejected")) {
            this.f15338c.userRewardRejected(this.f15337a, a2);
        } else {
            this.f15338c.validationRequestFailed(this.f15337a, AppLovinErrorCodes.INCENTIVIZED_UNKNOWN_SERVER_ERROR);
        }
    }

    /* access modifiers changed from: protected */
    public void a(JSONObject jSONObject) {
        JsonUtils.putString(jSONObject, "zone_id", this.f15337a.getAdZone().a());
        String clCode = this.f15337a.getClCode();
        if (!StringUtils.isValidString(clCode)) {
            clCode = "NO_CLCODE";
        }
        JsonUtils.putString(jSONObject, "clcode", clCode);
    }

    /* access modifiers changed from: protected */
    public boolean b() {
        return this.f15337a.aE();
    }
}
