package com.movie.ui.activity.sources;

import com.database.entitys.TvWatchedEpisode;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class q implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SourceActivity f32987b;

    public /* synthetic */ q(SourceActivity sourceActivity) {
        this.f32987b = sourceActivity;
    }

    public final void accept(Object obj) {
        this.f32987b.A0((TvWatchedEpisode) obj);
    }
}
