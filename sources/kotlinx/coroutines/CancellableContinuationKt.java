package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlinx.coroutines.internal.DispatchedContinuation;

public final class CancellableContinuationKt {
    public static final void a(CancellableContinuation<?> cancellableContinuation, DisposableHandle disposableHandle) {
        cancellableContinuation.b(new DisposeOnCancel(disposableHandle));
    }

    public static final <T> CancellableContinuationImpl<T> b(Continuation<? super T> continuation) {
        if (!(continuation instanceof DispatchedContinuation)) {
            return new CancellableContinuationImpl<>(continuation, 1);
        }
        CancellableContinuationImpl<T> n2 = ((DispatchedContinuation) continuation).n();
        if (n2 != null) {
            if (!n2.K()) {
                n2 = null;
            }
            if (n2 != null) {
                return n2;
            }
        }
        return new CancellableContinuationImpl<>(continuation, 2);
    }
}
