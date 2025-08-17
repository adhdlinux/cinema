package a0;

import com.chartboost.sdk.ads.Rewarded;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f7b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Rewarded f8c;

    public /* synthetic */ c(boolean z2, Rewarded rewarded) {
        this.f7b = z2;
        this.f8c = rewarded;
    }

    public final void run() {
        Rewarded.postSessionNotStartedInMainThread$lambda$0(this.f7b, this.f8c);
    }
}
