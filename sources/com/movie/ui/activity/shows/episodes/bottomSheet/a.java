package com.movie.ui.activity.shows.episodes.bottomSheet;

import com.movie.data.model.tmvdb.ExternalID;
import io.reactivex.functions.Function;

public final /* synthetic */ class a implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ EpisodeBottomSheetFragment f32731b;

    public /* synthetic */ a(EpisodeBottomSheetFragment episodeBottomSheetFragment) {
        this.f32731b = episodeBottomSheetFragment;
    }

    public final Object apply(Object obj) {
        return this.f32731b.I((ExternalID) obj);
    }
}
