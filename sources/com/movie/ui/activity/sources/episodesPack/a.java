package com.movie.ui.activity.sources.episodesPack;

import com.movie.data.model.TorrentObject;
import io.reactivex.functions.Function;

public final /* synthetic */ class a implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ EpisodesActivity f32949b;

    public /* synthetic */ a(EpisodesActivity episodesActivity) {
        this.f32949b = episodesActivity;
    }

    public final Object apply(Object obj) {
        return this.f32949b.r0((TorrentObject.FileBean) obj);
    }
}
