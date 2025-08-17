package com.vungle.ads.internal.load;

import com.vungle.ads.internal.model.Placement;
import com.vungle.ads.internal.network.Response;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DefaultAdLoader f37869b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Placement f37870c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Response f37871d;

    public /* synthetic */ d(DefaultAdLoader defaultAdLoader, Placement placement, Response response) {
        this.f37869b = defaultAdLoader;
        this.f37870c = placement;
        this.f37871d = response;
    }

    public final void run() {
        DefaultAdLoader$fetchAdMetadata$1.m183onResponse$lambda0(this.f37869b, this.f37870c, this.f37871d);
    }
}
