package com.vungle.ads.internal.network;

import okhttp3.Interceptor;
import okhttp3.Response;

public final /* synthetic */ class d implements Interceptor {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ VungleApiClient f37899a;

    public /* synthetic */ d(VungleApiClient vungleApiClient) {
        this.f37899a = vungleApiClient;
    }

    public final Response intercept(Interceptor.Chain chain) {
        return VungleApiClient.m192responseInterceptor$lambda0(this.f37899a, chain);
    }
}
