package com.vungle.ads.internal.executor;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VungleThreadPoolExecutor f37855b;

    public /* synthetic */ c(VungleThreadPoolExecutor vungleThreadPoolExecutor) {
        this.f37855b = vungleThreadPoolExecutor;
    }

    public final void run() {
        VungleThreadPoolExecutor.m175submit$lambda1(this.f37855b);
    }
}
