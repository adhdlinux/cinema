package com.movie.ui.fragment;

import android.view.View;
import com.database.entitys.MovieEntity;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class t0 implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MoviesFragment f33592b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MovieEntity f33593c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ View f33594d;

    public /* synthetic */ t0(MoviesFragment moviesFragment, MovieEntity movieEntity, View view) {
        this.f33592b = moviesFragment;
        this.f33593c = movieEntity;
        this.f33594d = view;
    }

    public final void accept(Object obj) {
        this.f33592b.N(this.f33593c, this.f33594d, (Throwable) obj);
    }
}
