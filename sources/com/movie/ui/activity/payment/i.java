package com.movie.ui.activity.payment;

import android.util.Log;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class i implements Consumer {
    public final void accept(Object obj) {
        Log.d("PAYMENT", ((Throwable) obj).getMessage());
    }
}
