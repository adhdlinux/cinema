package com.movie.ui.activity.payment;

import com.movie.data.model.payment.bitcoin.ProductResponse;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class b implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ChooseProductFragment f32308b;

    public /* synthetic */ b(ChooseProductFragment chooseProductFragment) {
        this.f32308b = chooseProductFragment;
    }

    public final void accept(Object obj) {
        this.f32308b.N((ProductResponse) obj);
    }
}
