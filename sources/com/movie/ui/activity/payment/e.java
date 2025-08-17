package com.movie.ui.activity.payment;

import com.movie.data.model.payment.bitcoin.BitcoinAddressResponse;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class e implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PaymentProcessingFragment f32310b;

    public /* synthetic */ e(PaymentProcessingFragment paymentProcessingFragment) {
        this.f32310b = paymentProcessingFragment;
    }

    public final void accept(Object obj) {
        this.f32310b.Y((BitcoinAddressResponse) obj);
    }
}
