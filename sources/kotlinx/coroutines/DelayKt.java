package kotlinx.coroutines;

import com.facebook.common.time.Clock;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugProbesKt;

public final class DelayKt {
    public static final Object a(long j2, Continuation<? super Unit> continuation) {
        if (j2 <= 0) {
            return Unit.f40298a;
        }
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.c(continuation), 1);
        cancellableContinuationImpl.A();
        if (j2 < Clock.MAX_TIME) {
            b(cancellableContinuationImpl.getContext()).k(j2, cancellableContinuationImpl);
        }
        Object x2 = cancellableContinuationImpl.x();
        if (x2 == IntrinsicsKt__IntrinsicsKt.e()) {
            DebugProbesKt.c(continuation);
        }
        if (x2 == IntrinsicsKt__IntrinsicsKt.e()) {
            return x2;
        }
        return Unit.f40298a;
    }

    public static final Delay b(CoroutineContext coroutineContext) {
        CoroutineContext.Element element = coroutineContext.get(ContinuationInterceptor.C0);
        Delay delay = element instanceof Delay ? (Delay) element : null;
        return delay == null ? DefaultExecutorKt.a() : delay;
    }
}
