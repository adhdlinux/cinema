package com.movie.ui.fragment;

import com.movie.data.model.tmvdb.MovieTMDB;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class h implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MovieFragment f33347b;

    public /* synthetic */ h(MovieFragment movieFragment) {
        this.f33347b = movieFragment;
    }

    public final void accept(Object obj) {
        this.f33347b.x0((MovieTMDB.ResultsBean) obj);
    }
}
