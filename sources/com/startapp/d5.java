package com.startapp;

import android.app.Activity;
import android.content.Context;
import android.util.Pair;
import com.startapp.sdk.ads.video.VideoUtil$VideoEligibility;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.adsbase.model.GetAdRequest;
import com.startapp.sdk.common.SDKException;
import com.unity3d.services.core.device.MimeTypes;
import java.util.Map;

public class d5 extends GetAdRequest {
    public GetAdRequest.VideoRequestType S0;
    public GetAdRequest.VideoRequestMode T0 = GetAdRequest.VideoRequestMode.INTERSTITIAL;

    public void a(Context context, AdPreferences adPreferences, AdPreferences.Placement placement, Pair<String, String> pair) {
        super.a(context, adPreferences, placement, pair);
        Ad.AdType adType = this.R0;
        if (adType != null) {
            if (adType == Ad.AdType.NON_VIDEO) {
                this.S0 = GetAdRequest.VideoRequestType.DISABLED;
            } else if (adType == Ad.AdType.VIDEO_NO_VAST) {
                this.S0 = GetAdRequest.VideoRequestType.FORCED_NONVAST;
            } else if (b()) {
                this.S0 = GetAdRequest.VideoRequestType.FORCED;
            }
        } else if (p.b(context) == VideoUtil$VideoEligibility.ELIGIBLE) {
            Map<Activity, Integer> map = lb.f34876a;
            this.S0 = GetAdRequest.VideoRequestType.ENABLED;
        } else {
            this.S0 = GetAdRequest.VideoRequestType.DISABLED;
        }
        Ad.AdType adType2 = this.R0;
        if (adType2 == Ad.AdType.REWARDED_VIDEO) {
            this.T0 = GetAdRequest.VideoRequestMode.REWARDED;
        }
        if (adType2 == Ad.AdType.VIDEO) {
            this.T0 = GetAdRequest.VideoRequestMode.INTERSTITIAL;
        }
    }

    public void a(eb ebVar) throws SDKException {
        super.a(ebVar);
        ebVar.a(MimeTypes.BASE_TYPE_VIDEO, (Object) this.S0, false, true);
        ebVar.a("videoMode", (Object) this.T0, false, true);
    }
}
