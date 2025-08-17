package com.applovin.impl.sdk.a;

import android.webkit.WebView;
import com.applovin.impl.sdk.nativeAd.AppLovinNativeAdImpl;
import com.applovin.impl.sdk.v;
import com.iab.omid.library.applovin.adsession.AdSessionConfiguration;
import com.iab.omid.library.applovin.adsession.AdSessionContext;
import com.iab.omid.library.applovin.adsession.CreativeType;
import com.iab.omid.library.applovin.adsession.ImpressionType;
import com.iab.omid.library.applovin.adsession.Owner;

public class e extends b {
    public e(AppLovinNativeAdImpl appLovinNativeAdImpl) {
        super(appLovinNativeAdImpl);
    }

    /* access modifiers changed from: protected */
    public AdSessionConfiguration a() {
        try {
            return AdSessionConfiguration.createAdSessionConfiguration(CreativeType.NATIVE_DISPLAY, ImpressionType.BEGIN_TO_RENDER, Owner.NATIVE, Owner.NONE, false);
        } catch (Throwable th) {
            if (v.a()) {
                this.f15004c.b(this.f15005d, "Failed to create ad session configuration", th);
            }
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public AdSessionContext a(WebView webView) {
        try {
            return AdSessionContext.createNativeAdSessionContext(this.f15003b.al().d(), this.f15003b.al().e(), this.f15002a.getOpenMeasurementVerificationScriptResources(), this.f15002a.getOpenMeasurementContentUrl(), this.f15002a.getOpenMeasurementCustomReferenceData());
        } catch (Throwable th) {
            if (v.a()) {
                this.f15004c.b(this.f15005d, "Failed to create ad session context", th);
            }
            return null;
        }
    }
}
