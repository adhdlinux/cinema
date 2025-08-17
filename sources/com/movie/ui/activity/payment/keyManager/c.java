package com.movie.ui.activity.payment.keyManager;

import com.movie.data.model.cinema.KeyResponse;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class c implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ KeyManager f32337b;

    public /* synthetic */ c(KeyManager keyManager) {
        this.f32337b = keyManager;
    }

    public final void accept(Object obj) {
        this.f32337b.K((KeyResponse) obj);
    }
}
