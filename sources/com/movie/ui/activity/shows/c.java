package com.movie.ui.activity.shows;

import com.database.entitys.MovieEntity;
import com.movie.data.model.tmvdb.ExternalID;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class c implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MovieEntity f32689b;

    public /* synthetic */ c(MovieEntity movieEntity) {
        this.f32689b = movieEntity;
    }

    public final void accept(Object obj) {
        ShowActivity.J(this.f32689b, (ExternalID) obj);
    }
}
