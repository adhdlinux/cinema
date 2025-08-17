package androidx.activity;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

public final class ViewTreeOnBackPressedDispatcherOwner {
    public static final void a(View view, OnBackPressedDispatcherOwner onBackPressedDispatcherOwner) {
        Intrinsics.f(view, "<this>");
        Intrinsics.f(onBackPressedDispatcherOwner, "onBackPressedDispatcherOwner");
        view.setTag(R$id.f45a, onBackPressedDispatcherOwner);
    }
}
