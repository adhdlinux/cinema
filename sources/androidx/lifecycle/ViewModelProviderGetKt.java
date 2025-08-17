package androidx.lifecycle;

import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.jvm.internal.Intrinsics;

public final class ViewModelProviderGetKt {
    public static final CreationExtras a(ViewModelStoreOwner viewModelStoreOwner) {
        Intrinsics.f(viewModelStoreOwner, "owner");
        if (!(viewModelStoreOwner instanceof HasDefaultViewModelProviderFactory)) {
            return CreationExtras.Empty.f3774b;
        }
        CreationExtras defaultViewModelCreationExtras = ((HasDefaultViewModelProviderFactory) viewModelStoreOwner).getDefaultViewModelCreationExtras();
        Intrinsics.e(defaultViewModelCreationExtras, "{\n        owner.defaultV…ModelCreationExtras\n    }");
        return defaultViewModelCreationExtras;
    }
}
