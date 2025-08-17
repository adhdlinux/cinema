package com.movie.ui.adapter;

import com.movie.data.model.tmvdb.MovieTMDB;
import com.movie.ui.adapter.MoviesAdapter;
import io.reactivex.Observer;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class x implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MoviesAdapter.MovieHolder f33150b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Observer f33151c;

    public /* synthetic */ x(MoviesAdapter.MovieHolder movieHolder, Observer observer) {
        this.f33150b = movieHolder;
        this.f33151c = observer;
    }

    public final void accept(Object obj) {
        this.f33150b.x(this.f33151c, (MovieTMDB.ResultsBean) obj);
    }
}
