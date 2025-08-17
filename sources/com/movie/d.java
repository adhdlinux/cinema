package com.movie;

import com.movie.data.model.AppConfig;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class d implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FreeMoviesApp f31894b;

    public /* synthetic */ d(FreeMoviesApp freeMoviesApp) {
        this.f31894b = freeMoviesApp;
    }

    public final void accept(Object obj) {
        this.f31894b.t((AppConfig) obj);
    }
}
