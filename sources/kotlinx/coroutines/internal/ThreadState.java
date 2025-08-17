package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ThreadContextElement;

final class ThreadState {

    /* renamed from: a  reason: collision with root package name */
    public final CoroutineContext f40782a;

    /* renamed from: b  reason: collision with root package name */
    private final Object[] f40783b;

    /* renamed from: c  reason: collision with root package name */
    private final ThreadContextElement<Object>[] f40784c;

    /* renamed from: d  reason: collision with root package name */
    private int f40785d;

    public ThreadState(CoroutineContext coroutineContext, int i2) {
        this.f40782a = coroutineContext;
        this.f40783b = new Object[i2];
        this.f40784c = new ThreadContextElement[i2];
    }

    public final void a(ThreadContextElement<?> threadContextElement, Object obj) {
        Object[] objArr = this.f40783b;
        int i2 = this.f40785d;
        objArr[i2] = obj;
        ThreadContextElement<Object>[] threadContextElementArr = this.f40784c;
        this.f40785d = i2 + 1;
        Intrinsics.d(threadContextElement, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        threadContextElementArr[i2] = threadContextElement;
    }

    public final void b(CoroutineContext coroutineContext) {
        int length = this.f40784c.length - 1;
        if (length >= 0) {
            while (true) {
                int i2 = length - 1;
                ThreadContextElement<Object> threadContextElement = this.f40784c[length];
                Intrinsics.c(threadContextElement);
                threadContextElement.D(coroutineContext, this.f40783b[length]);
                if (i2 >= 0) {
                    length = i2;
                } else {
                    return;
                }
            }
        }
    }
}
