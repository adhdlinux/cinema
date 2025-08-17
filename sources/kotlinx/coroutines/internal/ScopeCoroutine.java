package kotlinx.coroutines.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.CompletionStateKt;

public class ScopeCoroutine<T> extends AbstractCoroutine<T> implements CoroutineStackFrame {

    /* renamed from: e  reason: collision with root package name */
    public final Continuation<T> f40768e;

    public ScopeCoroutine(CoroutineContext coroutineContext, Continuation<? super T> continuation) {
        super(coroutineContext, true, true);
        this.f40768e = continuation;
    }

    /* access modifiers changed from: protected */
    public final boolean T() {
        return true;
    }

    public final CoroutineStackFrame getCallerFrame() {
        Continuation<T> continuation = this.f40768e;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void n(Object obj) {
        DispatchedContinuationKt.c(IntrinsicsKt__IntrinsicsJvmKt.c(this.f40768e), CompletionStateKt.a(obj, this.f40768e), (Function1) null, 2, (Object) null);
    }

    /* access modifiers changed from: protected */
    public void u0(Object obj) {
        Continuation<T> continuation = this.f40768e;
        continuation.resumeWith(CompletionStateKt.a(obj, continuation));
    }
}
