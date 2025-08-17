package com.movie.ui.activity.payment;

import androidx.appcompat.app.AlertDialog;
import com.movie.ui.activity.payment.PaymentProcessingFragment;
import io.reactivex.functions.Consumer;
import okhttp3.ResponseBody;

public final /* synthetic */ class j implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PaymentProcessingFragment.AnonymousClass2 f32316b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AlertDialog f32317c;

    public /* synthetic */ j(PaymentProcessingFragment.AnonymousClass2 r12, AlertDialog alertDialog) {
        this.f32316b = r12;
        this.f32317c = alertDialog;
    }

    public final void accept(Object obj) {
        this.f32316b.c(this.f32317c, (ResponseBody) obj);
    }
}
