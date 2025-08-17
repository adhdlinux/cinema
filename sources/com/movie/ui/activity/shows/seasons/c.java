package com.movie.ui.activity.shows.seasons;

import com.uwetrottmann.thetvdb.entities.EpisodesResponse;
import io.reactivex.functions.Function;

public final /* synthetic */ class c implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SeasonFragment f32825b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f32826c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f32827d;

    public /* synthetic */ c(SeasonFragment seasonFragment, int i2, int i3) {
        this.f32825b = seasonFragment;
        this.f32826c = i2;
        this.f32827d = i3;
    }

    public final Object apply(Object obj) {
        return this.f32825b.k0(this.f32826c, this.f32827d, (EpisodesResponse) obj);
    }
}
