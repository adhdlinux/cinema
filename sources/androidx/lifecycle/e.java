package androidx.lifecycle;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.jvm.internal.Intrinsics;

public final /* synthetic */ class e {
    public static ViewModel a(ViewModelProvider.Factory factory, Class cls) {
        Intrinsics.f(cls, "modelClass");
        throw new UnsupportedOperationException("Factory.create(String) is unsupported.  This Factory requires `CreationExtras` to be passed into `create` method.");
    }

    public static ViewModel b(ViewModelProvider.Factory factory, Class cls, CreationExtras creationExtras) {
        Intrinsics.f(cls, "modelClass");
        Intrinsics.f(creationExtras, "extras");
        return factory.b(cls);
    }
}
