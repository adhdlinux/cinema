package com.movie.ui.activity.payment;

import com.movie.data.model.payment.bitcoin.BitcoinPaymentInfo;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class h implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PaymentProcessingFragment f32314b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CompositeDisposable f32315c;

    public /* synthetic */ h(PaymentProcessingFragment paymentProcessingFragment, CompositeDisposable compositeDisposable) {
        this.f32314b = paymentProcessingFragment;
        this.f32315c = compositeDisposable;
    }

    public final void accept(Object obj) {
        this.f32314b.V(this.f32315c, (BitcoinPaymentInfo) obj);
    }
}
