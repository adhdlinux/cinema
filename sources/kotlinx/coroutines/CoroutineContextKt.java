package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.internal.Ref$ObjectRef;

public final class CoroutineContextKt {
    private static final CoroutineContext a(CoroutineContext coroutineContext, CoroutineContext coroutineContext2, boolean z2) {
        boolean c2 = c(coroutineContext);
        boolean c3 = c(coroutineContext2);
        if (!c2 && !c3) {
            return coroutineContext.plus(coroutineContext2);
        }
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.f40429b = coroutineContext2;
        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.f40358b;
        CoroutineContext coroutineContext3 = (CoroutineContext) coroutineContext.fold(emptyCoroutineContext, new CoroutineContextKt$foldCopies$folded$1(ref$ObjectRef, z2));
        if (c3) {
            ref$ObjectRef.f40429b = ((CoroutineContext) ref$ObjectRef.f40429b).fold(emptyCoroutineContext, CoroutineContextKt$foldCopies$1.f40608f);
        }
        return coroutineContext3.plus((CoroutineContext) ref$ObjectRef.f40429b);
    }

    public static final String b(CoroutineContext coroutineContext) {
        return null;
    }

    private static final boolean c(CoroutineContext coroutineContext) {
        return ((Boolean) coroutineContext.fold(Boolean.FALSE, CoroutineContextKt$hasCopyableElements$1.f40611f)).booleanValue();
    }

    public static final CoroutineContext d(CoroutineContext coroutineContext, CoroutineContext coroutineContext2) {
        if (!c(coroutineContext2)) {
            return coroutineContext.plus(coroutineContext2);
        }
        return a(coroutineContext, coroutineContext2, false);
    }

    public static final CoroutineContext e(CoroutineScope coroutineScope, CoroutineContext coroutineContext) {
        CoroutineContext a2 = a(coroutineScope.c(), coroutineContext, true);
        if (a2 == Dispatchers.a() || a2.get(ContinuationInterceptor.C0) != null) {
            return a2;
        }
        return a2.plus(Dispatchers.a());
    }

    public static final UndispatchedCoroutine<?> f(CoroutineStackFrame coroutineStackFrame) {
        while (!(coroutineStackFrame instanceof DispatchedCoroutine) && (coroutineStackFrame = coroutineStackFrame.getCallerFrame()) != null) {
            if (coroutineStackFrame instanceof UndispatchedCoroutine) {
                return (UndispatchedCoroutine) coroutineStackFrame;
            }
        }
        return null;
    }

    public static final UndispatchedCoroutine<?> g(Continuation<?> continuation, CoroutineContext coroutineContext, Object obj) {
        boolean z2;
        if (!(continuation instanceof CoroutineStackFrame)) {
            return null;
        }
        if (coroutineContext.get(UndispatchedMarker.f40696b) != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            return null;
        }
        UndispatchedCoroutine<?> f2 = f((CoroutineStackFrame) continuation);
        if (f2 != null) {
            f2.z0(coroutineContext, obj);
        }
        return f2;
    }
}
