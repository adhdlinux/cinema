package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;

public final class Unconfined extends CoroutineDispatcher {

    /* renamed from: c  reason: collision with root package name */
    public static final Unconfined f40694c = new Unconfined();

    private Unconfined() {
    }

    public void o0(CoroutineContext coroutineContext, Runnable runnable) {
        YieldContext yieldContext = (YieldContext) coroutineContext.get(YieldContext.f40697c);
        if (yieldContext != null) {
            yieldContext.f40698b = true;
            return;
        }
        throw new UnsupportedOperationException("Dispatchers.Unconfined.dispatch function can only be used by the yield function. If you wrap Unconfined dispatcher in your code, make sure you properly delegate isDispatchNeeded and dispatch calls.");
    }

    public boolean p0(CoroutineContext coroutineContext) {
        return false;
    }

    public String toString() {
        return "Dispatchers.Unconfined";
    }
}
