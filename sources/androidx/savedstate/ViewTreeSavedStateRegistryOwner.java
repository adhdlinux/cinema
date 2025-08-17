package androidx.savedstate;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

public final class ViewTreeSavedStateRegistryOwner {
    public static final void a(View view, SavedStateRegistryOwner savedStateRegistryOwner) {
        Intrinsics.f(view, "<this>");
        view.setTag(R$id.f11558a, savedStateRegistryOwner);
    }
}
