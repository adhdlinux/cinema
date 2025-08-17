package com.movie.ui.activity.payment;

import com.movie.data.api.MoviesApi;
import dagger.MembersInjector;

public final class PaymentProcessingFragment_MembersInjector implements MembersInjector<PaymentProcessingFragment> {
    public static void a(PaymentProcessingFragment paymentProcessingFragment, MoviesApi moviesApi) {
        paymentProcessingFragment.f32269d = moviesApi;
    }
}
