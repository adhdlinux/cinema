package com.applovin.impl.mediation.debugger.a;

import com.amazon.device.ads.AdError;
import com.amazon.device.ads.DTBAdCallback;
import com.amazon.device.ads.DTBAdRequest;
import com.amazon.device.ads.DTBAdResponse;
import com.amazon.device.ads.DTBAdSize;
import com.applovin.mediation.MaxAdFormat;
import java.util.Arrays;
import java.util.List;

public class a implements DTBAdCallback {

    /* renamed from: a  reason: collision with root package name */
    private final MaxAdFormat f14479a;

    /* renamed from: b  reason: collision with root package name */
    private final C0014a f14480b;

    /* renamed from: c  reason: collision with root package name */
    private DTBAdRequest f14481c;

    /* renamed from: com.applovin.impl.mediation.debugger.a.a$a  reason: collision with other inner class name */
    public interface C0014a {
        void onAdLoadFailed(AdError adError, MaxAdFormat maxAdFormat);

        void onAdResponseLoaded(DTBAdResponse dTBAdResponse, MaxAdFormat maxAdFormat);
    }

    public a(b bVar, MaxAdFormat maxAdFormat, C0014a aVar) {
        this((List<b>) Arrays.asList(new b[]{bVar}), maxAdFormat, aVar);
    }

    public a(List<b> list, MaxAdFormat maxAdFormat, C0014a aVar) {
        this.f14479a = maxAdFormat;
        this.f14480b = aVar;
        try {
            DTBAdSize[] dTBAdSizeArr = new DTBAdSize[list.size()];
            for (int i2 = 0; i2 < list.size(); i2++) {
                dTBAdSizeArr[i2] = list.get(i2).a();
            }
            DTBAdRequest dTBAdRequest = new DTBAdRequest();
            this.f14481c = dTBAdRequest;
            dTBAdRequest.setSizes(dTBAdSizeArr);
        } catch (Throwable unused) {
        }
    }

    public void a() {
        this.f14481c.loadAd(this);
    }

    public void onFailure(AdError adError) {
        this.f14480b.onAdLoadFailed(adError, this.f14479a);
    }

    public void onSuccess(DTBAdResponse dTBAdResponse) {
        this.f14480b.onAdResponseLoaded(dTBAdResponse, this.f14479a);
    }
}
