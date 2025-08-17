package com.movie.ui.fragment.favored;

import io.reactivex.functions.Consumer;
import java.util.List;

public final /* synthetic */ class a implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FavoredMoviesFragment f33342b;

    public /* synthetic */ a(FavoredMoviesFragment favoredMoviesFragment) {
        this.f33342b = favoredMoviesFragment;
    }

    public final void accept(Object obj) {
        this.f33342b.W((List) obj);
    }
}
