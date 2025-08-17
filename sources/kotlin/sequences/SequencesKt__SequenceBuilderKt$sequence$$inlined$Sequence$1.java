package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.functions.Function2;

public final class SequencesKt__SequenceBuilderKt$sequence$$inlined$Sequence$1 implements Sequence<T> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Function2 f40505a;

    public SequencesKt__SequenceBuilderKt$sequence$$inlined$Sequence$1(Function2 function2) {
        this.f40505a = function2;
    }

    public Iterator<T> iterator() {
        return SequencesKt__SequenceBuilderKt.a(this.f40505a);
    }
}
