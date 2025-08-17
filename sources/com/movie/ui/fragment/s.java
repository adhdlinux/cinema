package com.movie.ui.fragment;

import com.database.entitys.MovieEntity;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class s implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MovieFragment f33588b;

    public /* synthetic */ s(MovieFragment movieFragment) {
        this.f33588b = movieFragment;
    }

    public final void accept(Object obj) {
        this.f33588b.z0((MovieEntity) obj);
    }
}
