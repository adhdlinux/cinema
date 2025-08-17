package b0;

import com.chartboost.sdk.ads.Ad;
import com.chartboost.sdk.callbacks.AdCallback;
import com.chartboost.sdk.impl.d;

public final /* synthetic */ class i implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AdCallback f12723b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Ad f12724c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f12725d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f12726e;

    public /* synthetic */ i(AdCallback adCallback, Ad ad, String str, int i2) {
        this.f12723b = adCallback;
        this.f12724c = ad;
        this.f12725d = str;
        this.f12726e = i2;
    }

    public final void run() {
        d.a(this.f12723b, this.f12724c, this.f12725d, this.f12726e);
    }
}
