package kotlinx.coroutines;

import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.internal.ThreadContextKt;

public final class UndispatchedCoroutine<T> extends ScopeCoroutine<T> {

    /* renamed from: f  reason: collision with root package name */
    private final ThreadLocal<Pair<CoroutineContext, Object>> f40695f;
    private volatile boolean threadLocalIsSet;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public UndispatchedCoroutine(kotlin.coroutines.CoroutineContext r3, kotlin.coroutines.Continuation<? super T> r4) {
        /*
            r2 = this;
            kotlinx.coroutines.UndispatchedMarker r0 = kotlinx.coroutines.UndispatchedMarker.f40696b
            kotlin.coroutines.CoroutineContext$Element r1 = r3.get(r0)
            if (r1 != 0) goto L_0x000d
            kotlin.coroutines.CoroutineContext r0 = r3.plus(r0)
            goto L_0x000e
        L_0x000d:
            r0 = r3
        L_0x000e:
            r2.<init>(r0, r4)
            java.lang.ThreadLocal r0 = new java.lang.ThreadLocal
            r0.<init>()
            r2.f40695f = r0
            kotlin.coroutines.CoroutineContext r4 = r4.getContext()
            kotlin.coroutines.ContinuationInterceptor$Key r0 = kotlin.coroutines.ContinuationInterceptor.C0
            kotlin.coroutines.CoroutineContext$Element r4 = r4.get(r0)
            boolean r4 = r4 instanceof kotlinx.coroutines.CoroutineDispatcher
            if (r4 != 0) goto L_0x0031
            r4 = 0
            java.lang.Object r4 = kotlinx.coroutines.internal.ThreadContextKt.c(r3, r4)
            kotlinx.coroutines.internal.ThreadContextKt.a(r3, r4)
            r2.z0(r3, r4)
        L_0x0031:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.UndispatchedCoroutine.<init>(kotlin.coroutines.CoroutineContext, kotlin.coroutines.Continuation):void");
    }

    /* access modifiers changed from: protected */
    public void u0(Object obj) {
        if (this.threadLocalIsSet) {
            Pair pair = this.f40695f.get();
            if (pair != null) {
                ThreadContextKt.a((CoroutineContext) pair.a(), pair.b());
            }
            this.f40695f.remove();
        }
        Object a2 = CompletionStateKt.a(obj, this.f40768e);
        Continuation<T> continuation = this.f40768e;
        CoroutineContext context = continuation.getContext();
        UndispatchedCoroutine<?> undispatchedCoroutine = null;
        Object c2 = ThreadContextKt.c(context, undispatchedCoroutine);
        if (c2 != ThreadContextKt.f40773a) {
            undispatchedCoroutine = CoroutineContextKt.g(continuation, context, c2);
        }
        try {
            this.f40768e.resumeWith(a2);
            Unit unit = Unit.f40298a;
        } finally {
            if (undispatchedCoroutine == null || undispatchedCoroutine.y0()) {
                ThreadContextKt.a(context, c2);
            }
        }
    }

    public final boolean y0() {
        boolean z2;
        if (!this.threadLocalIsSet || this.f40695f.get() != null) {
            z2 = false;
        } else {
            z2 = true;
        }
        this.f40695f.remove();
        return !z2;
    }

    public final void z0(CoroutineContext coroutineContext, Object obj) {
        this.threadLocalIsSet = true;
        this.f40695f.set(TuplesKt.a(coroutineContext, obj));
    }
}
