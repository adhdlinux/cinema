package com.movie.ui.activity.settings.subfragment;

import com.uwetrottmann.trakt5.entities.User;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class u implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PremiumAccountFragment f32663b;

    public /* synthetic */ u(PremiumAccountFragment premiumAccountFragment) {
        this.f32663b = premiumAccountFragment;
    }

    public final void accept(Object obj) {
        this.f32663b.lambda$getTraktUserInfo$14((User) obj);
    }
}
