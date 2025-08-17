package kotlin.coroutines;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

public interface ContinuationInterceptor extends CoroutineContext.Element {
    public static final Key C0 = Key.f40356b;

    public static final class DefaultImpls {
        public static <E extends CoroutineContext.Element> E a(ContinuationInterceptor continuationInterceptor, CoroutineContext.Key<E> key) {
            Intrinsics.f(key, "key");
            if (key instanceof AbstractCoroutineContextKey) {
                AbstractCoroutineContextKey abstractCoroutineContextKey = (AbstractCoroutineContextKey) key;
                if (!abstractCoroutineContextKey.a(continuationInterceptor.getKey())) {
                    return null;
                }
                E b2 = abstractCoroutineContextKey.b(continuationInterceptor);
                if (b2 instanceof CoroutineContext.Element) {
                    return b2;
                }
                return null;
            } else if (ContinuationInterceptor.C0 != key) {
                return null;
            } else {
                Intrinsics.d(continuationInterceptor, "null cannot be cast to non-null type E of kotlin.coroutines.ContinuationInterceptor.get");
                return continuationInterceptor;
            }
        }

        public static CoroutineContext b(ContinuationInterceptor continuationInterceptor, CoroutineContext.Key<?> key) {
            Intrinsics.f(key, "key");
            if (key instanceof AbstractCoroutineContextKey) {
                AbstractCoroutineContextKey abstractCoroutineContextKey = (AbstractCoroutineContextKey) key;
                if (!abstractCoroutineContextKey.a(continuationInterceptor.getKey()) || abstractCoroutineContextKey.b(continuationInterceptor) == null) {
                    return continuationInterceptor;
                }
                return EmptyCoroutineContext.f40358b;
            } else if (ContinuationInterceptor.C0 == key) {
                return EmptyCoroutineContext.f40358b;
            } else {
                return continuationInterceptor;
            }
        }
    }

    public static final class Key implements CoroutineContext.Key<ContinuationInterceptor> {

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ Key f40356b = new Key();

        private Key() {
        }
    }

    void a(Continuation<?> continuation);

    <T> Continuation<T> f(Continuation<? super T> continuation);
}
