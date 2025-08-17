package com.movie.ui.fragment;

import android.view.View;
import com.database.entitys.MovieEntity;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class s0 implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MoviesFragment f33589b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f33590c;

    public /* synthetic */ s0(MoviesFragment moviesFragment, View view) {
        this.f33589b = moviesFragment;
        this.f33590c = view;
    }

    public final void accept(Object obj) {
        this.f33589b.M(this.f33590c, (MovieEntity) obj);
    }
}
