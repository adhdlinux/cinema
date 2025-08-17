package com.movie.ui.activity.payment;

import com.movie.data.api.MoviesApi;
import dagger.MembersInjector;

public final class PaymentResultFragment_MembersInjector implements MembersInjector<PaymentResultFragment> {
    public static void a(PaymentResultFragment paymentResultFragment, MoviesApi moviesApi) {
        paymentResultFragment.f32301d = moviesApi;
    }
}
