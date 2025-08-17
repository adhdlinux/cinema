package com.movie.ui.activity.shows.seasons;

import io.reactivex.Observer;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class l implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SeasonFragment f32836b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Observer f32837c;

    public /* synthetic */ l(SeasonFragment seasonFragment, Observer observer) {
        this.f32836b = seasonFragment;
        this.f32837c = observer;
    }

    public final void accept(Object obj) {
        this.f32836b.f0(this.f32837c, (Throwable) obj);
    }
}
