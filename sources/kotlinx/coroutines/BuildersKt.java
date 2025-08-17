package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;

public final class BuildersKt {
    public static final Job a(CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return BuildersKt__Builders_commonKt.a(coroutineScope, coroutineContext, coroutineStart, function2);
    }

    public static final <T> T c(CoroutineContext coroutineContext, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2) throws InterruptedException {
        return BuildersKt__BuildersKt.a(coroutineContext, function2);
    }

    public static final <T> Object e(CoroutineContext coroutineContext, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        return BuildersKt__Builders_commonKt.c(coroutineContext, function2, continuation);
    }
}
