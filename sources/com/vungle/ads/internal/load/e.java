package com.vungle.ads.internal.load;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DefaultAdLoader f37872b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Throwable f37873c;

    public /* synthetic */ e(DefaultAdLoader defaultAdLoader, Throwable th) {
        this.f37872b = defaultAdLoader;
        this.f37873c = th;
    }

    public final void run() {
        DefaultAdLoader$fetchAdMetadata$1.m182onFailure$lambda1(this.f37872b, this.f37873c);
    }
}
