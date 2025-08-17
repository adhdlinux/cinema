package com.movie.ui.activity.shows;

import com.database.entitys.MovieEntity;
import io.reactivex.functions.Action;

public final /* synthetic */ class e implements Action {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ShowActivity f32692b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MovieEntity f32693c;

    public /* synthetic */ e(ShowActivity showActivity, MovieEntity movieEntity) {
        this.f32692b = showActivity;
        this.f32693c = movieEntity;
    }

    public final void run() {
        this.f32692b.L(this.f32693c);
    }
}
