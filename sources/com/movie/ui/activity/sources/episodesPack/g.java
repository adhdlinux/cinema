package com.movie.ui.activity.sources.episodesPack;

import com.original.tase.model.media.MediaSource;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class g implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ EpisodesActivity f32953b;

    public /* synthetic */ g(EpisodesActivity episodesActivity) {
        this.f32953b = episodesActivity;
    }

    public final void accept(Object obj) {
        this.f32953b.k0((MediaSource) obj);
    }
}
