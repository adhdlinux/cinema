package com.movie.ui.activity.shows.overview;

import com.uwetrottmann.thetvdb.entities.Series;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class c implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OverviewFragment f32774b;

    public /* synthetic */ c(OverviewFragment overviewFragment) {
        this.f32774b = overviewFragment;
    }

    public final void accept(Object obj) {
        this.f32774b.O((Series) obj);
    }
}
