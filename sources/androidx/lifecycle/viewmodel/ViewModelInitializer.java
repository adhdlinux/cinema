package androidx.lifecycle.viewmodel;

import androidx.lifecycle.ViewModel;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

public final class ViewModelInitializer<T extends ViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Class<T> f3778a;

    /* renamed from: b  reason: collision with root package name */
    private final Function1<CreationExtras, T> f3779b;

    public ViewModelInitializer(Class<T> cls, Function1<? super CreationExtras, ? extends T> function1) {
        Intrinsics.f(cls, "clazz");
        Intrinsics.f(function1, "initializer");
        this.f3778a = cls;
        this.f3779b = function1;
    }

    public final Class<T> a() {
        return this.f3778a;
    }

    public final Function1<CreationExtras, T> b() {
        return this.f3779b;
    }
}
