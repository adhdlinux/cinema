package androidx.core.view;

import android.view.View;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

public final class ViewKt {
    public static final Sequence<View> a(View view) {
        Intrinsics.f(view, "<this>");
        return SequencesKt__SequenceBuilderKt.b(new ViewKt$allViews$1(view, (Continuation<? super ViewKt$allViews$1>) null));
    }
}
