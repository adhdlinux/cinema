package com.movie.ui.activity.settings.subfragment;

import com.original.tase.model.debrid.premiumize.PremiumizeUserInfo;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class w implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PremiumAccountFragment f32665b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f32666c;

    public /* synthetic */ w(PremiumAccountFragment premiumAccountFragment, String str) {
        this.f32665b = premiumAccountFragment;
        this.f32666c = str;
    }

    public final void accept(Object obj) {
        this.f32665b.lambda$getPremiumizeDebirdUserInfo$10(this.f32666c, (PremiumizeUserInfo) obj);
    }
}
