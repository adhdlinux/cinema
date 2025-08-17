package com.movie.ui.activity.shows.seasons;

import io.reactivex.Observer;
import io.reactivex.functions.Action;

public final /* synthetic */ class b implements Action {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SeasonFragment f32823b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Observer f32824c;

    public /* synthetic */ b(SeasonFragment seasonFragment, Observer observer) {
        this.f32823b = seasonFragment;
        this.f32824c = observer;
    }

    public final void run() {
        this.f32823b.g0(this.f32824c);
    }
}
