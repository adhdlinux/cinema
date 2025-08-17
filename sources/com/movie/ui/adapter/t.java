package com.movie.ui.adapter;

import com.database.entitys.MovieEntity;
import com.movie.ui.adapter.MoviesAdapter;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class t implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MoviesAdapter.MovieHolder f33144b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MovieEntity f33145c;

    public /* synthetic */ t(MoviesAdapter.MovieHolder movieHolder, MovieEntity movieEntity) {
        this.f33144b = movieHolder;
        this.f33145c = movieEntity;
    }

    public final void accept(Object obj) {
        this.f33144b.v(this.f33145c, (MoviesAdapter.MovieHolder.HolderImage) obj);
    }
}
