package com.movie.ui.adapter;

import com.database.entitys.MovieEntity;
import com.movie.ui.adapter.MoviesAdapter;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;

public final /* synthetic */ class r implements ObservableSource {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MoviesAdapter.MovieHolder f33140b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MovieEntity f33141c;

    public /* synthetic */ r(MoviesAdapter.MovieHolder movieHolder, MovieEntity movieEntity) {
        this.f33140b = movieHolder;
        this.f33141c = movieEntity;
    }

    public final void subscribe(Observer observer) {
        this.f33140b.A(this.f33141c, observer);
    }
}
