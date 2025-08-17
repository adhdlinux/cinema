package com.movie.ui.activity.payment;

import com.movie.data.model.cinema.KeyResponse;
import com.movie.data.model.payment.bitcoin.BitcoinPaymentInfo;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class n implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PaymentResultFragment f32346b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ BitcoinPaymentInfo f32347c;

    public /* synthetic */ n(PaymentResultFragment paymentResultFragment, BitcoinPaymentInfo bitcoinPaymentInfo) {
        this.f32346b = paymentResultFragment;
        this.f32347c = bitcoinPaymentInfo;
    }

    public final void accept(Object obj) {
        this.f32346b.N(this.f32347c, (KeyResponse) obj);
    }
}
