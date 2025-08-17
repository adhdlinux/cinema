package com.movie.ui.activity.shows.seasons;

import com.uwetrottmann.thetvdb.entities.EpisodesResponse;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class k implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SeasonFragment f32835b;

    public /* synthetic */ k(SeasonFragment seasonFragment) {
        this.f32835b = seasonFragment;
    }

    public final void accept(Object obj) {
        this.f32835b.e0((EpisodesResponse) obj);
    }
}
