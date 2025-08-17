package com.movie.ui.activity.shows.episodes.pageviewDialog;

import com.movie.data.model.tmvdb.ExternalID;
import io.reactivex.functions.Function;

public final /* synthetic */ class d implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PageViewDialog f32762b;

    public /* synthetic */ d(PageViewDialog pageViewDialog) {
        this.f32762b = pageViewDialog;
    }

    public final Object apply(Object obj) {
        return this.f32762b.N((ExternalID) obj);
    }
}
