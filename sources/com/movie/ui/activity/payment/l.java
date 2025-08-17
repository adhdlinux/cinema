package com.movie.ui.activity.payment;

import com.movie.data.model.AppConfig;
import com.movie.data.model.payment.bitcoin.BitcoinPaymentInfo;
import io.reactivex.functions.Function;

public final /* synthetic */ class l implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PaymentResultFragment f32342b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ BitcoinPaymentInfo f32343c;

    public /* synthetic */ l(PaymentResultFragment paymentResultFragment, BitcoinPaymentInfo bitcoinPaymentInfo) {
        this.f32342b = paymentResultFragment;
        this.f32343c = bitcoinPaymentInfo;
    }

    public final Object apply(Object obj) {
        return this.f32342b.L(this.f32343c, (AppConfig) obj);
    }
}
