package com.movie.ui.activity.sources.episodesPack;

import com.movie.data.model.TorrentObject;
import io.reactivex.functions.Function;

public final /* synthetic */ class p implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ EpisodesActivity f32961b;

    public /* synthetic */ p(EpisodesActivity episodesActivity) {
        this.f32961b = episodesActivity;
    }

    public final Object apply(Object obj) {
        return this.f32961b.v0((TorrentObject.FileBean) obj);
    }
}
