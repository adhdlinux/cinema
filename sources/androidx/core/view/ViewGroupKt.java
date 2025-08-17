package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

public final class ViewGroupKt {
    public static final Sequence<View> a(ViewGroup viewGroup) {
        Intrinsics.f(viewGroup, "<this>");
        return new ViewGroupKt$children$1(viewGroup);
    }

    public static final Sequence<View> b(ViewGroup viewGroup) {
        Intrinsics.f(viewGroup, "<this>");
        return SequencesKt__SequenceBuilderKt.b(new ViewGroupKt$descendants$1(viewGroup, (Continuation<? super ViewGroupKt$descendants$1>) null));
    }

    public static final Iterator<View> c(ViewGroup viewGroup) {
        Intrinsics.f(viewGroup, "<this>");
        return new ViewGroupKt$iterator$1(viewGroup);
    }
}
