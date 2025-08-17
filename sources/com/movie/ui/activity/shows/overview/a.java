package com.movie.ui.activity.shows.overview;

import com.movie.data.model.tmvdb.TvTMDB;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class a implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OverviewFragment f32772b;

    public /* synthetic */ a(OverviewFragment overviewFragment) {
        this.f32772b = overviewFragment;
    }

    public final void accept(Object obj) {
        this.f32772b.M((TvTMDB.ResultsBean) obj);
    }
}
