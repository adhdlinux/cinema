package com.applovin.impl.mediation.debugger.a;

import com.amazon.device.ads.DTBAdSize;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.mediation.MaxAdFormat;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import org.json.JSONObject;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private final String f14482a;

    /* renamed from: b  reason: collision with root package name */
    private DTBAdSize f14483b;

    private enum a {
        VIDEO,
        DISPLAY,
        INTERSTITIAL
    }

    public b(String str, JSONObject jSONObject, MaxAdFormat maxAdFormat) {
        this.f14482a = str;
        this.f14483b = a(JsonUtils.getInt(jSONObject, "type", a(maxAdFormat).ordinal()), maxAdFormat, str);
    }

    private DTBAdSize a(int i2, MaxAdFormat maxAdFormat, String str) {
        try {
            if (a.VIDEO.ordinal() == i2) {
                return new DTBAdSize.DTBVideo(Sdk$SDKError.Reason.WEBVIEW_ERROR_VALUE, 480, str);
            }
            if (a.DISPLAY.ordinal() == i2) {
                return new DTBAdSize(maxAdFormat.getSize().getWidth(), maxAdFormat.getSize().getHeight(), str);
            }
            if (a.INTERSTITIAL.ordinal() == i2) {
                return new DTBAdSize.DTBInterstitialAdSize(str);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private a a(MaxAdFormat maxAdFormat) {
        return maxAdFormat.isAdViewAd() ? a.DISPLAY : a.INTERSTITIAL;
    }

    public DTBAdSize a() {
        return this.f14483b;
    }
}
