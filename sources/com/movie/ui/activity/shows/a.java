package com.movie.ui.activity.shows;

import android.view.View;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class a implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ShowActivity f32685b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f32686c;

    public /* synthetic */ a(ShowActivity showActivity, View view) {
        this.f32685b = showActivity;
        this.f32686c = view;
    }

    public final void accept(Object obj) {
        this.f32685b.H(this.f32686c, (String) obj);
    }
}
