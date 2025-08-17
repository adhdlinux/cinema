package kotlin.coroutines.jvm.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

public abstract class ContinuationImpl extends BaseContinuationImpl {
    private final CoroutineContext _context;
    private transient Continuation<Object> intercepted;

    public ContinuationImpl(Continuation<Object> continuation, CoroutineContext coroutineContext) {
        super(continuation);
        this._context = coroutineContext;
    }

    public CoroutineContext getContext() {
        CoroutineContext coroutineContext = this._context;
        Intrinsics.c(coroutineContext);
        return coroutineContext;
    }

    public final Continuation<Object> intercepted() {
        Continuation<Object> continuation = this.intercepted;
        if (continuation == null) {
            ContinuationInterceptor continuationInterceptor = (ContinuationInterceptor) getContext().get(ContinuationInterceptor.C0);
            if (continuationInterceptor == null || (continuation = continuationInterceptor.f(this)) == null) {
                continuation = this;
            }
            this.intercepted = continuation;
        }
        return continuation;
    }

    /* access modifiers changed from: protected */
    public void releaseIntercepted() {
        Continuation<Object> continuation = this.intercepted;
        if (!(continuation == null || continuation == this)) {
            CoroutineContext.Element element = getContext().get(ContinuationInterceptor.C0);
            Intrinsics.c(element);
            ((ContinuationInterceptor) element).a(continuation);
        }
        this.intercepted = CompletedContinuation.f40370b;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ContinuationImpl(Continuation<Object> continuation) {
        this(continuation, continuation != null ? continuation.getContext() : null);
    }
}
