package com.movie.ui.adapter;

import com.database.entitys.MovieEntity;
import com.movie.ui.adapter.MoviesAdapter;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;

public final /* synthetic */ class q implements ObservableSource {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MoviesAdapter.MovieHolder f33138b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MovieEntity f33139c;

    public /* synthetic */ q(MoviesAdapter.MovieHolder movieHolder, MovieEntity movieEntity) {
        this.f33138b = movieHolder;
        this.f33139c = movieEntity;
    }

    public final void subscribe(Observer observer) {
        this.f33138b.z(this.f33139c, observer);
    }
}
