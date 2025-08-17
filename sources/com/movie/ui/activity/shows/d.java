package com.movie.ui.activity.shows;

import com.database.entitys.MovieEntity;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class d implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ShowActivity f32690b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MovieEntity f32691c;

    public /* synthetic */ d(ShowActivity showActivity, MovieEntity movieEntity) {
        this.f32690b = showActivity;
        this.f32691c = movieEntity;
    }

    public final void accept(Object obj) {
        this.f32690b.K(this.f32691c, (Throwable) obj);
    }
}
