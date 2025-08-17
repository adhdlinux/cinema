package com.movie.ui.activity.settings;

import com.database.entitys.CategoryEntity;
import io.reactivex.functions.Function;
import java.util.List;

public final /* synthetic */ class a implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CategoryListFragment f32533b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CategoryEntity.Type f32534c;

    public /* synthetic */ a(CategoryListFragment categoryListFragment, CategoryEntity.Type type) {
        this.f32533b = categoryListFragment;
        this.f32534c = type;
    }

    public final Object apply(Object obj) {
        return this.f32533b.L(this.f32534c, (List) obj);
    }
}
