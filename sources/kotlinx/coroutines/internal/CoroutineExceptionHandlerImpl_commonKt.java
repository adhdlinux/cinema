package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;

public final class CoroutineExceptionHandlerImpl_commonKt {
    public static final void a(CoroutineContext coroutineContext, Throwable th) {
        for (CoroutineExceptionHandler handleException : CoroutineExceptionHandlerImplKt.a()) {
            try {
                handleException.handleException(coroutineContext, th);
            } catch (ExceptionSuccessfullyProcessed unused) {
                return;
            } catch (Throwable th2) {
                CoroutineExceptionHandlerImplKt.b(CoroutineExceptionHandlerKt.b(th, th2));
            }
        }
        try {
            ExceptionsKt__ExceptionsKt.a(th, new DiagnosticCoroutineContextException(coroutineContext));
        } catch (Throwable unused2) {
        }
        CoroutineExceptionHandlerImplKt.b(th);
    }
}
