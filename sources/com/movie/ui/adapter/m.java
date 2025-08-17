package com.movie.ui.adapter;

import android.view.View;
import com.database.entitys.MovieEntity;
import com.movie.ui.adapter.MoviesAdapter;

public final /* synthetic */ class m implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MoviesAdapter.MovieHolder f33132b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MovieEntity f33133c;

    public /* synthetic */ m(MoviesAdapter.MovieHolder movieHolder, MovieEntity movieEntity) {
        this.f33132b = movieHolder;
        this.f33133c = movieEntity;
    }

    public final void onClick(View view) {
        this.f33132b.s(this.f33133c, view);
    }
}
