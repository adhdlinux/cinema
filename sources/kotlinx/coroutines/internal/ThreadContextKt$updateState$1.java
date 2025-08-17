package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.ThreadContextElement;

final class ThreadContextKt$updateState$1 extends Lambda implements Function2<ThreadState, CoroutineContext.Element, ThreadState> {

    /* renamed from: f  reason: collision with root package name */
    public static final ThreadContextKt$updateState$1 f40779f = new ThreadContextKt$updateState$1();

    ThreadContextKt$updateState$1() {
        super(2);
    }

    /* renamed from: a */
    public final ThreadState invoke(ThreadState threadState, CoroutineContext.Element element) {
        if (element instanceof ThreadContextElement) {
            ThreadContextElement threadContextElement = (ThreadContextElement) element;
            threadState.a(threadContextElement, threadContextElement.j0(threadState.f40782a));
        }
        return threadState;
    }
}
