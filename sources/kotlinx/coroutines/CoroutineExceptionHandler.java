package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;

public interface CoroutineExceptionHandler extends CoroutineContext.Element {
    public static final Key D0 = Key.f40614b;

    public static final class DefaultImpls {
        public static <R> R a(CoroutineExceptionHandler coroutineExceptionHandler, R r2, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
            return CoroutineContext.Element.DefaultImpls.a(coroutineExceptionHandler, r2, function2);
        }

        public static <E extends CoroutineContext.Element> E b(CoroutineExceptionHandler coroutineExceptionHandler, CoroutineContext.Key<E> key) {
            return CoroutineContext.Element.DefaultImpls.b(coroutineExceptionHandler, key);
        }

        public static CoroutineContext c(CoroutineExceptionHandler coroutineExceptionHandler, CoroutineContext.Key<?> key) {
            return CoroutineContext.Element.DefaultImpls.c(coroutineExceptionHandler, key);
        }

        public static CoroutineContext d(CoroutineExceptionHandler coroutineExceptionHandler, CoroutineContext coroutineContext) {
            return CoroutineContext.Element.DefaultImpls.d(coroutineExceptionHandler, coroutineContext);
        }
    }

    public static final class Key implements CoroutineContext.Key<CoroutineExceptionHandler> {

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ Key f40614b = new Key();

        private Key() {
        }
    }

    void handleException(CoroutineContext coroutineContext, Throwable th);
}
