package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ThreadContextElement;

public final class ThreadContextKt {

    /* renamed from: a  reason: collision with root package name */
    public static final Symbol f40773a = new Symbol("NO_THREAD_ELEMENTS");

    /* renamed from: b  reason: collision with root package name */
    private static final Function2<Object, CoroutineContext.Element, Object> f40774b = ThreadContextKt$countAll$1.f40777f;

    /* renamed from: c  reason: collision with root package name */
    private static final Function2<ThreadContextElement<?>, CoroutineContext.Element, ThreadContextElement<?>> f40775c = ThreadContextKt$findOne$1.f40778f;

    /* renamed from: d  reason: collision with root package name */
    private static final Function2<ThreadState, CoroutineContext.Element, ThreadState> f40776d = ThreadContextKt$updateState$1.f40779f;

    public static final void a(CoroutineContext coroutineContext, Object obj) {
        if (obj != f40773a) {
            if (obj instanceof ThreadState) {
                ((ThreadState) obj).b(coroutineContext);
                return;
            }
            Object fold = coroutineContext.fold(null, f40775c);
            Intrinsics.d(fold, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
            ((ThreadContextElement) fold).D(coroutineContext, obj);
        }
    }

    public static final Object b(CoroutineContext coroutineContext) {
        Object fold = coroutineContext.fold(0, f40774b);
        Intrinsics.c(fold);
        return fold;
    }

    public static final Object c(CoroutineContext coroutineContext, Object obj) {
        if (obj == null) {
            obj = b(coroutineContext);
        }
        if (obj == 0) {
            return f40773a;
        }
        if (obj instanceof Integer) {
            return coroutineContext.fold(new ThreadState(coroutineContext, ((Number) obj).intValue()), f40776d);
        }
        Intrinsics.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        return ((ThreadContextElement) obj).j0(coroutineContext);
    }
}
