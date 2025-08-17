package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

final class CoroutineContextKt$foldCopies$1 extends Lambda implements Function2<CoroutineContext, CoroutineContext.Element, CoroutineContext> {

    /* renamed from: f  reason: collision with root package name */
    public static final CoroutineContextKt$foldCopies$1 f40608f = new CoroutineContextKt$foldCopies$1();

    CoroutineContextKt$foldCopies$1() {
        super(2);
    }

    /* renamed from: a */
    public final CoroutineContext invoke(CoroutineContext coroutineContext, CoroutineContext.Element element) {
        if (element instanceof CopyableThreadContextElement) {
            return coroutineContext.plus(((CopyableThreadContextElement) element).B());
        }
        return coroutineContext.plus(element);
    }
}
