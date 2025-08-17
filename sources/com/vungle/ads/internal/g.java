package com.vungle.ads.internal;

import java.util.concurrent.Callable;
import kotlin.Lazy;

public final /* synthetic */ class g implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Lazy f37860b;

    public /* synthetic */ g(Lazy lazy) {
        this.f37860b = lazy;
    }

    public final Object call() {
        return VungleInternal.m167getAvailableBidTokens$lambda3(this.f37860b);
    }
}
