package androidx.lifecycle.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

public final class InitializerViewModelFactoryBuilder {

    /* renamed from: a  reason: collision with root package name */
    private final List<ViewModelInitializer<?>> f3776a = new ArrayList();

    public final <T extends ViewModel> void a(KClass<T> kClass, Function1<? super CreationExtras, ? extends T> function1) {
        Intrinsics.f(kClass, "clazz");
        Intrinsics.f(function1, "initializer");
        this.f3776a.add(new ViewModelInitializer(JvmClassMappingKt.a(kClass), function1));
    }

    public final ViewModelProvider.Factory b() {
        Object[] array = this.f3776a.toArray(new ViewModelInitializer[0]);
        if (array != null) {
            ViewModelInitializer[] viewModelInitializerArr = (ViewModelInitializer[]) array;
            return new InitializerViewModelFactory((ViewModelInitializer[]) Arrays.copyOf(viewModelInitializerArr, viewModelInitializerArr.length));
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }
}
