package com.movie.ui.activity.sources;

import com.movie.data.model.MovieInfo;
import io.reactivex.functions.Action;

public final /* synthetic */ class e0 implements Action {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SourceActivity f32911b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MovieInfo f32912c;

    public /* synthetic */ e0(SourceActivity sourceActivity, MovieInfo movieInfo) {
        this.f32911b = sourceActivity;
        this.f32912c = movieInfo;
    }

    public final void run() {
        this.f32911b.b1(this.f32912c);
    }
}
