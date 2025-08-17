package com.movie.ui.activity.shows;

import android.view.View;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class b implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ShowActivity f32687b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f32688c;

    public /* synthetic */ b(ShowActivity showActivity, View view) {
        this.f32687b = showActivity;
        this.f32688c = view;
    }

    public final void accept(Object obj) {
        this.f32687b.I(this.f32688c, (Throwable) obj);
    }
}
