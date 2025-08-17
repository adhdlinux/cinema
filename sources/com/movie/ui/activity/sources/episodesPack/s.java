package com.movie.ui.activity.sources.episodesPack;

import com.movie.data.model.TorrentObject;
import io.reactivex.functions.Function;

public final /* synthetic */ class s implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ EpisodesActivity f32964b;

    public /* synthetic */ s(EpisodesActivity episodesActivity) {
        this.f32964b = episodesActivity;
    }

    public final Object apply(Object obj) {
        return this.f32964b.o0((TorrentObject.FileBean) obj);
    }
}
