package com.movie.ui.activity.settings.subfragment;

import com.original.tase.model.debrid.realdebrid.RealDebridUserInfor;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class p implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PremiumAccountFragment f32659b;

    public /* synthetic */ p(PremiumAccountFragment premiumAccountFragment) {
        this.f32659b = premiumAccountFragment;
    }

    public final void accept(Object obj) {
        this.f32659b.lambda$getRealDebirdUserInfo$2((RealDebridUserInfor) obj);
    }
}
