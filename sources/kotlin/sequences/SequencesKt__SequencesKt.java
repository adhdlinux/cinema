package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

class SequencesKt__SequencesKt extends SequencesKt__SequencesJVMKt {
    public static <T> Sequence<T> c(Iterator<? extends T> it2) {
        Intrinsics.f(it2, "<this>");
        return d(new SequencesKt__SequencesKt$asSequence$$inlined$Sequence$1(it2));
    }

    public static <T> Sequence<T> d(Sequence<? extends T> sequence) {
        Intrinsics.f(sequence, "<this>");
        if (sequence instanceof ConstrainedOnceSequence) {
            return sequence;
        }
        return new ConstrainedOnceSequence(sequence);
    }

    public static <T> Sequence<T> e(Function0<? extends T> function0, Function1<? super T, ? extends T> function1) {
        Intrinsics.f(function0, "seedFunction");
        Intrinsics.f(function1, "nextFunction");
        return new GeneratorSequence(function0, function1);
    }
}
