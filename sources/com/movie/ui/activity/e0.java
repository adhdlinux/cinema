package com.movie.ui.activity;

import com.movie.data.model.tmvdb.MovieTMDB;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class e0 implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MovieDetailsActivity f32220b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f32221c;

    public /* synthetic */ e0(MovieDetailsActivity movieDetailsActivity, boolean z2) {
        this.f32220b = movieDetailsActivity;
        this.f32221c = z2;
    }

    public final void accept(Object obj) {
        this.f32220b.M(this.f32221c, (MovieTMDB.ResultsBean) obj);
    }
}
