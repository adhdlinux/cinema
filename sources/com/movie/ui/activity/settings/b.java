package com.movie.ui.activity.settings;

import io.reactivex.functions.Function;
import java.util.List;

public final /* synthetic */ class b implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CategoryListFragment f32535b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f32536c;

    public /* synthetic */ b(CategoryListFragment categoryListFragment, int i2) {
        this.f32535b = categoryListFragment;
        this.f32536c = i2;
    }

    public final Object apply(Object obj) {
        return this.f32535b.M(this.f32536c, (List) obj);
    }
}
