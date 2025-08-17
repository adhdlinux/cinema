package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.internal.ThreadContextKt;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.intrinsics.UndispatchedKt;

final /* synthetic */ class BuildersKt__Builders_commonKt {
    public static final Job a(CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        AbstractCoroutine abstractCoroutine;
        CoroutineContext e2 = CoroutineContextKt.e(coroutineScope, coroutineContext);
        if (coroutineStart.c()) {
            abstractCoroutine = new LazyStandaloneCoroutine(e2, function2);
        } else {
            abstractCoroutine = new StandaloneCoroutine(e2, true);
        }
        abstractCoroutine.x0(coroutineStart, abstractCoroutine, function2);
        return abstractCoroutine;
    }

    public static /* synthetic */ Job b(CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2 function2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.f40358b;
        }
        if ((i2 & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return BuildersKt.a(coroutineScope, coroutineContext, coroutineStart, function2);
    }

    /* JADX INFO: finally extract failed */
    public static final <T> Object c(CoroutineContext coroutineContext, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        Object obj;
        CoroutineContext context = continuation.getContext();
        CoroutineContext d2 = CoroutineContextKt.d(context, coroutineContext);
        JobKt.e(d2);
        if (d2 == context) {
            ScopeCoroutine scopeCoroutine = new ScopeCoroutine(d2, continuation);
            obj = UndispatchedKt.b(scopeCoroutine, scopeCoroutine, function2);
        } else {
            ContinuationInterceptor.Key key = ContinuationInterceptor.C0;
            if (Intrinsics.a(d2.get(key), context.get(key))) {
                UndispatchedCoroutine undispatchedCoroutine = new UndispatchedCoroutine(d2, continuation);
                CoroutineContext context2 = undispatchedCoroutine.getContext();
                Object c2 = ThreadContextKt.c(context2, (Object) null);
                try {
                    Object b2 = UndispatchedKt.b(undispatchedCoroutine, undispatchedCoroutine, function2);
                    ThreadContextKt.a(context2, c2);
                    obj = b2;
                } catch (Throwable th) {
                    ThreadContextKt.a(context2, c2);
                    throw th;
                }
            } else {
                DispatchedCoroutine dispatchedCoroutine = new DispatchedCoroutine(d2, continuation);
                CancellableKt.d(function2, dispatchedCoroutine, dispatchedCoroutine, (Function1) null, 4, (Object) null);
                obj = dispatchedCoroutine.y0();
            }
        }
        if (obj == IntrinsicsKt__IntrinsicsKt.e()) {
            DebugProbesKt.c(continuation);
        }
        return obj;
    }
}
