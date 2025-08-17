package com.movie.ui.activity.sources;

import com.movie.data.model.MovieInfo;
import com.utils.Getlink.Provider.BaseProvider;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public final /* synthetic */ class d0 implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MovieInfo f32910b;

    public /* synthetic */ d0(MovieInfo movieInfo) {
        this.f32910b = movieInfo;
    }

    public final Object apply(Object obj) {
        return ((BaseProvider) obj).F(this.f32910b).subscribeOn(Schedulers.c());
    }
}
