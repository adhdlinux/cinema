package com.movie.ui.activity.settings;

import io.reactivex.functions.Consumer;
import java.util.List;

public final /* synthetic */ class c implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CategoryListFragment f32537b;

    public /* synthetic */ c(CategoryListFragment categoryListFragment) {
        this.f32537b = categoryListFragment;
    }

    public final void accept(Object obj) {
        this.f32537b.N((List) obj);
    }
}
