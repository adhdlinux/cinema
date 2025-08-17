package com.movie.ui.fragment;

import com.movie.data.model.MovieInfo;
import com.utils.Getlink.Provider.BaseProvider;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public final /* synthetic */ class c implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MovieInfo f33323b;

    public /* synthetic */ c(MovieInfo movieInfo) {
        this.f33323b = movieInfo;
    }

    public final Object apply(Object obj) {
        return ((BaseProvider) obj).F(this.f33323b).subscribeOn(Schedulers.c());
    }
}
