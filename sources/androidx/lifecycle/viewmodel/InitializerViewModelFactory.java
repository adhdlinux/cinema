package androidx.lifecycle.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.e;
import kotlin.jvm.internal.Intrinsics;

public final class InitializerViewModelFactory implements ViewModelProvider.Factory {

    /* renamed from: a  reason: collision with root package name */
    private final ViewModelInitializer<?>[] f3775a;

    public InitializerViewModelFactory(ViewModelInitializer<?>... viewModelInitializerArr) {
        Intrinsics.f(viewModelInitializerArr, "initializers");
        this.f3775a = viewModelInitializerArr;
    }

    public <T extends ViewModel> T a(Class<T> cls, CreationExtras creationExtras) {
        Intrinsics.f(cls, "modelClass");
        Intrinsics.f(creationExtras, "extras");
        T t2 = null;
        for (ViewModelInitializer<?> viewModelInitializer : this.f3775a) {
            if (Intrinsics.a(viewModelInitializer.a(), cls)) {
                T invoke = viewModelInitializer.b().invoke(creationExtras);
                if (invoke instanceof ViewModel) {
                    t2 = (ViewModel) invoke;
                } else {
                    t2 = null;
                }
            }
        }
        if (t2 != null) {
            return t2;
        }
        throw new IllegalArgumentException("No initializer set for given class " + cls.getName());
    }

    public /* synthetic */ ViewModel b(Class cls) {
        return e.a(this, cls);
    }
}
