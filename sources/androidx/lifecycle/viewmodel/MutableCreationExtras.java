package androidx.lifecycle.viewmodel;

import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class MutableCreationExtras extends CreationExtras {
    public MutableCreationExtras() {
        this((CreationExtras) null, 1, (DefaultConstructorMarker) null);
    }

    public MutableCreationExtras(CreationExtras creationExtras) {
        Intrinsics.f(creationExtras, "initialExtras");
        b().putAll(creationExtras.b());
    }

    public <T> T a(CreationExtras.Key<T> key) {
        Intrinsics.f(key, "key");
        return b().get(key);
    }

    public final <T> void c(CreationExtras.Key<T> key, T t2) {
        Intrinsics.f(key, "key");
        b().put(key, t2);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MutableCreationExtras(CreationExtras creationExtras, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? CreationExtras.Empty.f3774b : creationExtras);
    }
}
