package com.movie.ui.activity;

import com.movie.data.model.payment.bitcoin.BitcoinAddressResponse;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class t implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MemberActivationActivity f33037b;

    public /* synthetic */ t(MemberActivationActivity memberActivationActivity) {
        this.f33037b = memberActivationActivity;
    }

    public final void accept(Object obj) {
        this.f33037b.N((BitcoinAddressResponse) obj);
    }
}
