package com.movie.ui.activity.sources.episodesPack;

import com.database.entitys.TvWatchedEpisode;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class b implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ EpisodesActivity f32950b;

    public /* synthetic */ b(EpisodesActivity episodesActivity) {
        this.f32950b = episodesActivity;
    }

    public final void accept(Object obj) {
        this.f32950b.j0((TvWatchedEpisode) obj);
    }
}
