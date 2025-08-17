package com.vungle.ads.internal;

import com.vungle.ads.BidTokenCallback;
import kotlin.Lazy;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BidTokenCallback f37858b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Lazy f37859c;

    public /* synthetic */ f(BidTokenCallback bidTokenCallback, Lazy lazy) {
        this.f37858b = bidTokenCallback;
        this.f37859c = lazy;
    }

    public final void run() {
        VungleInternal.m170getAvailableBidTokensAsync$lambda6(this.f37858b, this.f37859c);
    }
}
