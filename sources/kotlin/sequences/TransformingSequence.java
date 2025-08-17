package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

public final class TransformingSequence<T, R> implements Sequence<R> {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Sequence<T> f40508a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Function1<T, R> f40509b;

    public TransformingSequence(Sequence<? extends T> sequence, Function1<? super T, ? extends R> function1) {
        Intrinsics.f(sequence, "sequence");
        Intrinsics.f(function1, "transformer");
        this.f40508a = sequence;
        this.f40509b = function1;
    }

    public Iterator<R> iterator() {
        return new TransformingSequence$iterator$1(this);
    }
}
