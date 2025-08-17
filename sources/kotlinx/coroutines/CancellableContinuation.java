package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

public interface CancellableContinuation<T> extends Continuation<T> {
    void b(Function1<? super Throwable, Unit> function1);

    void d(T t2, Function1<? super Throwable, Unit> function1);

    Object e(T t2, Object obj, Function1<? super Throwable, Unit> function1);

    void g(CoroutineDispatcher coroutineDispatcher, T t2);

    void h(Object obj);
}
