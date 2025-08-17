package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.ThreadContextElement;

final class ThreadContextKt$findOne$1 extends Lambda implements Function2<ThreadContextElement<?>, CoroutineContext.Element, ThreadContextElement<?>> {

    /* renamed from: f  reason: collision with root package name */
    public static final ThreadContextKt$findOne$1 f40778f = new ThreadContextKt$findOne$1();

    ThreadContextKt$findOne$1() {
        super(2);
    }

    /* renamed from: a */
    public final ThreadContextElement<?> invoke(ThreadContextElement<?> threadContextElement, CoroutineContext.Element element) {
        if (threadContextElement != null) {
            return threadContextElement;
        }
        if (element instanceof ThreadContextElement) {
            return (ThreadContextElement) element;
        }
        return null;
    }
}
