package com.movie.ui.adapter;

import com.movie.ui.adapter.MoviesAdapter;
import io.reactivex.functions.Function;
import okhttp3.ResponseBody;

public final /* synthetic */ class n implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MoviesAdapter.MovieHolder f33134b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f33135c;

    public /* synthetic */ n(MoviesAdapter.MovieHolder movieHolder, String str) {
        this.f33134b = movieHolder;
        this.f33135c = str;
    }

    public final Object apply(Object obj) {
        return this.f33134b.B(this.f33135c, (ResponseBody) obj);
    }
}
