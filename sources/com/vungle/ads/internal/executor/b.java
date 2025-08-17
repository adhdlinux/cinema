package com.vungle.ads.internal.executor;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VungleThreadPoolExecutor f37854b;

    public /* synthetic */ b(VungleThreadPoolExecutor vungleThreadPoolExecutor) {
        this.f37854b = vungleThreadPoolExecutor;
    }

    public final void run() {
        VungleThreadPoolExecutor.m176submit$lambda2(this.f37854b);
    }
}
