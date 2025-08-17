package kotlin.sequences;

import java.util.Iterator;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

class SequencesKt__SequenceBuilderKt {
    public static final <T> Iterator<T> a(Function2<? super SequenceScope<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics.f(function2, "block");
        SequenceBuilderIterator sequenceBuilderIterator = new SequenceBuilderIterator();
        sequenceBuilderIterator.l(IntrinsicsKt__IntrinsicsJvmKt.a(function2, sequenceBuilderIterator, sequenceBuilderIterator));
        return sequenceBuilderIterator;
    }

    public static <T> Sequence<T> b(Function2<? super SequenceScope<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics.f(function2, "block");
        return new SequencesKt__SequenceBuilderKt$sequence$$inlined$Sequence$1(function2);
    }
}
