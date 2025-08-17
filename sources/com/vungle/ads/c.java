package com.vungle.ads;

import com.vungle.ads.internal.executor.VungleThreadPoolExecutor;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VungleThreadPoolExecutor f37828b;

    public /* synthetic */ c(VungleThreadPoolExecutor vungleThreadPoolExecutor) {
        this.f37828b = vungleThreadPoolExecutor;
    }

    public final void run() {
        AnalyticsClient.m113init$lambda1(this.f37828b);
    }
}
