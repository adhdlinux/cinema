package kotlinx.coroutines;

import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.AbstractCoroutineContextKey;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.LimitedDispatcher;
import kotlinx.coroutines.internal.LimitedDispatcherKt;

public abstract class CoroutineDispatcher extends AbstractCoroutineContextElement implements ContinuationInterceptor {

    /* renamed from: b  reason: collision with root package name */
    public static final Key f40612b = new Key((DefaultConstructorMarker) null);

    public static final class Key extends AbstractCoroutineContextKey<ContinuationInterceptor, CoroutineDispatcher> {
        private Key() {
            super(ContinuationInterceptor.C0, AnonymousClass1.f40613f);
        }

        public /* synthetic */ Key(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public CoroutineDispatcher() {
        super(ContinuationInterceptor.C0);
    }

    public final void a(Continuation<?> continuation) {
        Intrinsics.d(continuation, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        ((DispatchedContinuation) continuation).r();
    }

    public final <T> Continuation<T> f(Continuation<? super T> continuation) {
        return new DispatchedContinuation(this, continuation);
    }

    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        return ContinuationInterceptor.DefaultImpls.a(this, key);
    }

    public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        return ContinuationInterceptor.DefaultImpls.b(this, key);
    }

    public abstract void o0(CoroutineContext coroutineContext, Runnable runnable);

    public boolean p0(CoroutineContext coroutineContext) {
        return true;
    }

    public CoroutineDispatcher q0(int i2) {
        LimitedDispatcherKt.a(i2);
        return new LimitedDispatcher(this, i2);
    }

    public String toString() {
        return DebugStringsKt.a(this) + '@' + DebugStringsKt.b(this);
    }
}
