package kotlin.coroutines;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

public interface CoroutineContext {

    public static final class DefaultImpls {
        public static CoroutineContext a(CoroutineContext coroutineContext, CoroutineContext coroutineContext2) {
            Intrinsics.f(coroutineContext2, "context");
            if (coroutineContext2 == EmptyCoroutineContext.f40358b) {
                return coroutineContext;
            }
            return (CoroutineContext) coroutineContext2.fold(coroutineContext, CoroutineContext$plus$1.f40357f);
        }
    }

    public interface Element extends CoroutineContext {

        public static final class DefaultImpls {
            public static <R> R a(Element element, R r2, Function2<? super R, ? super Element, ? extends R> function2) {
                Intrinsics.f(function2, "operation");
                return function2.invoke(r2, element);
            }

            public static <E extends Element> E b(Element element, Key<E> key) {
                Intrinsics.f(key, "key");
                if (!Intrinsics.a(element.getKey(), key)) {
                    return null;
                }
                Intrinsics.d(element, "null cannot be cast to non-null type E of kotlin.coroutines.CoroutineContext.Element.get");
                return element;
            }

            public static CoroutineContext c(Element element, Key<?> key) {
                Intrinsics.f(key, "key");
                if (Intrinsics.a(element.getKey(), key)) {
                    return EmptyCoroutineContext.f40358b;
                }
                return element;
            }

            public static CoroutineContext d(Element element, CoroutineContext coroutineContext) {
                Intrinsics.f(coroutineContext, "context");
                return DefaultImpls.a(element, coroutineContext);
            }
        }

        <E extends Element> E get(Key<E> key);

        Key<?> getKey();
    }

    public interface Key<E extends Element> {
    }

    <R> R fold(R r2, Function2<? super R, ? super Element, ? extends R> function2);

    <E extends Element> E get(Key<E> key);

    CoroutineContext minusKey(Key<?> key);

    CoroutineContext plus(CoroutineContext coroutineContext);
}
