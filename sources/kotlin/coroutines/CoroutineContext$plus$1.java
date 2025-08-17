package kotlin.coroutines;

import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

final class CoroutineContext$plus$1 extends Lambda implements Function2<CoroutineContext, CoroutineContext.Element, CoroutineContext> {

    /* renamed from: f  reason: collision with root package name */
    public static final CoroutineContext$plus$1 f40357f = new CoroutineContext$plus$1();

    CoroutineContext$plus$1() {
        super(2);
    }

    /* renamed from: a */
    public final CoroutineContext invoke(CoroutineContext coroutineContext, CoroutineContext.Element element) {
        CombinedContext combinedContext;
        Intrinsics.f(coroutineContext, "acc");
        Intrinsics.f(element, "element");
        CoroutineContext minusKey = coroutineContext.minusKey(element.getKey());
        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.f40358b;
        if (minusKey == emptyCoroutineContext) {
            return element;
        }
        ContinuationInterceptor.Key key = ContinuationInterceptor.C0;
        ContinuationInterceptor continuationInterceptor = (ContinuationInterceptor) minusKey.get(key);
        if (continuationInterceptor == null) {
            combinedContext = new CombinedContext(minusKey, element);
        } else {
            CoroutineContext minusKey2 = minusKey.minusKey(key);
            if (minusKey2 == emptyCoroutineContext) {
                return new CombinedContext(element, continuationInterceptor);
            }
            combinedContext = new CombinedContext(new CombinedContext(minusKey2, element), continuationInterceptor);
        }
        return combinedContext;
    }
}
