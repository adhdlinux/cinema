package com.movie.ui.activity.payment;

import com.movie.data.model.payment.bitcoin.BitcoinAddressResponse;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class g implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PaymentProcessingFragment f32311b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CompositeDisposable f32312c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ BitcoinAddressResponse f32313d;

    public /* synthetic */ g(PaymentProcessingFragment paymentProcessingFragment, CompositeDisposable compositeDisposable, BitcoinAddressResponse bitcoinAddressResponse) {
        this.f32311b = paymentProcessingFragment;
        this.f32312c = compositeDisposable;
        this.f32313d = bitcoinAddressResponse;
    }

    public final void accept(Object obj) {
        this.f32311b.X(this.f32312c, this.f32313d, (Long) obj);
    }
}
