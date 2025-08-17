package com.movie.ui.fragment;

import com.database.entitys.MovieEntity;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class e implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MovieFragment f33326b;

    public /* synthetic */ e(MovieFragment movieFragment) {
        this.f33326b = movieFragment;
    }

    public final void accept(Object obj) {
        this.f33326b.G0((MovieEntity) obj);
    }
}
