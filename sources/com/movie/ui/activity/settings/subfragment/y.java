package com.movie.ui.activity.settings.subfragment;

import com.original.tase.model.debrid.realdebrid.RealDebridGetTokenResult;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class y implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PremiumAccountFragment f32668b;

    public /* synthetic */ y(PremiumAccountFragment premiumAccountFragment) {
        this.f32668b = premiumAccountFragment;
    }

    public final void accept(Object obj) {
        this.f32668b.lambda$loginRealDebird$4((RealDebridGetTokenResult) obj);
    }
}
