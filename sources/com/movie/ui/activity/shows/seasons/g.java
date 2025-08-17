package com.movie.ui.activity.shows.seasons;

import com.database.entitys.MovieEntity;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;

public final /* synthetic */ class g implements ObservableSource {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SeasonFragment f32831b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MovieEntity f32832c;

    public /* synthetic */ g(SeasonFragment seasonFragment, MovieEntity movieEntity) {
        this.f32831b = seasonFragment;
        this.f32832c = movieEntity;
    }

    public final void subscribe(Observer observer) {
        this.f32831b.h0(this.f32832c, observer);
    }
}
