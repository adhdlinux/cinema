package com.movie.ui.activity.payment;

import com.movie.data.model.AppConfig;
import com.movie.data.model.payment.bitcoin.BitcoinPaymentInfo;
import io.reactivex.functions.Function;

public final /* synthetic */ class m implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PaymentResultFragment f32344b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ BitcoinPaymentInfo f32345c;

    public /* synthetic */ m(PaymentResultFragment paymentResultFragment, BitcoinPaymentInfo bitcoinPaymentInfo) {
        this.f32344b = paymentResultFragment;
        this.f32345c = bitcoinPaymentInfo;
    }

    public final Object apply(Object obj) {
        return this.f32344b.M(this.f32345c, (AppConfig) obj);
    }
}
