package a0;

import com.chartboost.sdk.ads.Banner;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f3b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Banner f4c;

    public /* synthetic */ a(boolean z2, Banner banner) {
        this.f3b = z2;
        this.f4c = banner;
    }

    public final void run() {
        Banner.postSessionNotStartedInMainThread$lambda$0(this.f3b, this.f4c);
    }
}
