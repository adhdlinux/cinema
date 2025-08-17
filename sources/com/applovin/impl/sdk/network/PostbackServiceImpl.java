package com.applovin.impl.sdk.network;

import com.applovin.impl.sdk.e.a;
import com.applovin.impl.sdk.e.g;
import com.applovin.impl.sdk.e.o;
import com.applovin.impl.sdk.m;
import com.applovin.sdk.AppLovinPostbackListener;
import com.applovin.sdk.AppLovinPostbackService;

public class PostbackServiceImpl implements AppLovinPostbackService {

    /* renamed from: a  reason: collision with root package name */
    private final m f15601a;

    public PostbackServiceImpl(m mVar) {
        this.f15601a = mVar;
    }

    public void dispatchPostbackAsync(String str, AppLovinPostbackListener appLovinPostbackListener) {
        dispatchPostbackRequest(i.b(this.f15601a).a(str).c(false).a(), appLovinPostbackListener);
    }

    public void dispatchPostbackRequest(i iVar, o.a aVar, AppLovinPostbackListener appLovinPostbackListener) {
        this.f15601a.S().a((a) new g(iVar, aVar, this.f15601a, appLovinPostbackListener), aVar);
    }

    public void dispatchPostbackRequest(i iVar, AppLovinPostbackListener appLovinPostbackListener) {
        dispatchPostbackRequest(iVar, o.a.POSTBACKS, appLovinPostbackListener);
    }

    public String toString() {
        return "PostbackService{}";
    }
}
