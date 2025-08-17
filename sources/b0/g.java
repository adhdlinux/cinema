package b0;

import com.chartboost.sdk.ads.Ad;
import com.chartboost.sdk.callbacks.AdCallback;
import com.chartboost.sdk.events.ShowError;
import com.chartboost.sdk.impl.d;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Ad f12710b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AdCallback f12711c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f12712d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ShowError f12713e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ d f12714f;

    public /* synthetic */ g(Ad ad, AdCallback adCallback, String str, ShowError showError, d dVar) {
        this.f12710b = ad;
        this.f12711c = adCallback;
        this.f12712d = str;
        this.f12713e = showError;
        this.f12714f = dVar;
    }

    public final void run() {
        d.a(this.f12710b, this.f12711c, this.f12712d, this.f12713e, this.f12714f);
    }
}
