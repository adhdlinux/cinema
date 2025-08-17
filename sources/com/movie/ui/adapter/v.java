package com.movie.ui.adapter;

import com.movie.data.model.tmvdb.TvTMDB;
import com.movie.ui.adapter.MoviesAdapter;
import io.reactivex.Observer;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class v implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MoviesAdapter.MovieHolder f33147b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Observer f33148c;

    public /* synthetic */ v(MoviesAdapter.MovieHolder movieHolder, Observer observer) {
        this.f33147b = movieHolder;
        this.f33148c = observer;
    }

    public final void accept(Object obj) {
        this.f33147b.t(this.f33148c, (TvTMDB.ResultsBean) obj);
    }
}
