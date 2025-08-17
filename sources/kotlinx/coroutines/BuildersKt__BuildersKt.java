package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;

final /* synthetic */ class BuildersKt__BuildersKt {
    public static final <T> T a(CoroutineContext coroutineContext, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2) throws InterruptedException {
        CoroutineContext coroutineContext2;
        EventLoop eventLoop;
        EventLoop eventLoop2;
        Thread currentThread = Thread.currentThread();
        ContinuationInterceptor continuationInterceptor = (ContinuationInterceptor) coroutineContext.get(ContinuationInterceptor.C0);
        if (continuationInterceptor == null) {
            eventLoop = ThreadLocalEventLoop.f40685a.b();
            coroutineContext2 = CoroutineContextKt.e(GlobalScope.f40653b, coroutineContext.plus(eventLoop));
        } else {
            EventLoop eventLoop3 = null;
            if (continuationInterceptor instanceof EventLoop) {
                eventLoop2 = (EventLoop) continuationInterceptor;
            } else {
                eventLoop2 = null;
            }
            if (eventLoop2 != null) {
                if (eventLoop2.C0()) {
                    eventLoop3 = eventLoop2;
                }
                if (eventLoop3 != null) {
                    eventLoop = eventLoop3;
                    coroutineContext2 = CoroutineContextKt.e(GlobalScope.f40653b, coroutineContext);
                }
            }
            eventLoop = ThreadLocalEventLoop.f40685a.a();
            coroutineContext2 = CoroutineContextKt.e(GlobalScope.f40653b, coroutineContext);
        }
        BlockingCoroutine blockingCoroutine = new BlockingCoroutine(coroutineContext2, currentThread, eventLoop);
        blockingCoroutine.x0(CoroutineStart.DEFAULT, blockingCoroutine, function2);
        return blockingCoroutine.y0();
    }

    public static /* synthetic */ Object b(CoroutineContext coroutineContext, Function2 function2, int i2, Object obj) throws InterruptedException {
        if ((i2 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.f40358b;
        }
        return BuildersKt.c(coroutineContext, function2);
    }
}
