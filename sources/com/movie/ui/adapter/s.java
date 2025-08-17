package com.movie.ui.adapter;

import com.database.entitys.MovieEntity;
import com.movie.ui.adapter.MoviesAdapter;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;

public final /* synthetic */ class s implements ObservableSource {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MoviesAdapter.MovieHolder f33142b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MovieEntity f33143c;

    public /* synthetic */ s(MoviesAdapter.MovieHolder movieHolder, MovieEntity movieEntity) {
        this.f33142b = movieHolder;
        this.f33143c = movieEntity;
    }

    public final void subscribe(Observer observer) {
        this.f33142b.E(this.f33143c, observer);
    }
}
