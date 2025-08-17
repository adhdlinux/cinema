package kotlin.sequences;

import java.util.Iterator;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

public abstract class SequenceScope<T> {
    public abstract Object a(T t2, Continuation<? super Unit> continuation);

    public abstract Object f(Iterator<? extends T> it2, Continuation<? super Unit> continuation);

    public final Object i(Sequence<? extends T> sequence, Continuation<? super Unit> continuation) {
        Object f2 = f(sequence.iterator(), continuation);
        return f2 == IntrinsicsKt__IntrinsicsKt.e() ? f2 : Unit.f40298a;
    }
}
