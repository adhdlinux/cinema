package com.movie.ui.activity.payment.keyManager;

import com.movie.data.model.AppConfig;
import com.movie.data.model.cinema.KeyResponse;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class e implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ KeyManager f32339b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ KeyResponse.DevicesBean f32340c;

    public /* synthetic */ e(KeyManager keyManager, KeyResponse.DevicesBean devicesBean) {
        this.f32339b = keyManager;
        this.f32340c = devicesBean;
    }

    public final void accept(Object obj) {
        this.f32339b.I(this.f32340c, (AppConfig) obj);
    }
}
