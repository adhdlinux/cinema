package kotlinx.coroutines.internal;

import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

public final class DispatchedContinuationKt {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final Symbol f40732a = new Symbol("UNDEFINED");

    /* renamed from: b  reason: collision with root package name */
    public static final Symbol f40733b = new Symbol("REUSABLE_CLAIMED");

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x008f, code lost:
        if (r8.y0() != false) goto L_0x0091;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> void b(kotlin.coroutines.Continuation<? super T> r6, java.lang.Object r7, kotlin.jvm.functions.Function1<? super java.lang.Throwable, kotlin.Unit> r8) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.internal.DispatchedContinuation
            if (r0 == 0) goto L_0x00b6
            kotlinx.coroutines.internal.DispatchedContinuation r6 = (kotlinx.coroutines.internal.DispatchedContinuation) r6
            java.lang.Object r8 = kotlinx.coroutines.CompletionStateKt.b(r7, r8)
            kotlinx.coroutines.CoroutineDispatcher r0 = r6.f40728e
            kotlin.coroutines.CoroutineContext r1 = r6.getContext()
            boolean r0 = r0.p0(r1)
            r1 = 1
            if (r0 == 0) goto L_0x0026
            r6.f40730g = r8
            r6.f40628d = r1
            kotlinx.coroutines.CoroutineDispatcher r7 = r6.f40728e
            kotlin.coroutines.CoroutineContext r8 = r6.getContext()
            r7.o0(r8, r6)
            goto L_0x00b9
        L_0x0026:
            kotlinx.coroutines.ThreadLocalEventLoop r0 = kotlinx.coroutines.ThreadLocalEventLoop.f40685a
            kotlinx.coroutines.EventLoop r0 = r0.b()
            boolean r2 = r0.y0()
            if (r2 == 0) goto L_0x003b
            r6.f40730g = r8
            r6.f40628d = r1
            r0.u0(r6)
            goto L_0x00b9
        L_0x003b:
            r0.w0(r1)
            r2 = 0
            kotlin.coroutines.CoroutineContext r3 = r6.getContext()     // Catch:{ all -> 0x00a9 }
            kotlinx.coroutines.Job$Key r4 = kotlinx.coroutines.Job.E0     // Catch:{ all -> 0x00a9 }
            kotlin.coroutines.CoroutineContext$Element r3 = r3.get(r4)     // Catch:{ all -> 0x00a9 }
            kotlinx.coroutines.Job r3 = (kotlinx.coroutines.Job) r3     // Catch:{ all -> 0x00a9 }
            if (r3 == 0) goto L_0x0069
            boolean r4 = r3.isActive()     // Catch:{ all -> 0x00a9 }
            if (r4 != 0) goto L_0x0069
            java.util.concurrent.CancellationException r3 = r3.s()     // Catch:{ all -> 0x00a9 }
            r6.c(r8, r3)     // Catch:{ all -> 0x00a9 }
            kotlin.Result$Companion r8 = kotlin.Result.f40263c     // Catch:{ all -> 0x00a9 }
            java.lang.Object r8 = kotlin.ResultKt.a(r3)     // Catch:{ all -> 0x00a9 }
            java.lang.Object r8 = kotlin.Result.b(r8)     // Catch:{ all -> 0x00a9 }
            r6.resumeWith(r8)     // Catch:{ all -> 0x00a9 }
            r8 = 1
            goto L_0x006a
        L_0x0069:
            r8 = 0
        L_0x006a:
            if (r8 != 0) goto L_0x00a2
            kotlin.coroutines.Continuation<T> r8 = r6.f40729f     // Catch:{ all -> 0x00a9 }
            java.lang.Object r3 = r6.f40731h     // Catch:{ all -> 0x00a9 }
            kotlin.coroutines.CoroutineContext r4 = r8.getContext()     // Catch:{ all -> 0x00a9 }
            java.lang.Object r3 = kotlinx.coroutines.internal.ThreadContextKt.c(r4, r3)     // Catch:{ all -> 0x00a9 }
            kotlinx.coroutines.internal.Symbol r5 = kotlinx.coroutines.internal.ThreadContextKt.f40773a     // Catch:{ all -> 0x00a9 }
            if (r3 == r5) goto L_0x0081
            kotlinx.coroutines.UndispatchedCoroutine r8 = kotlinx.coroutines.CoroutineContextKt.g(r8, r4, r3)     // Catch:{ all -> 0x00a9 }
            goto L_0x0082
        L_0x0081:
            r8 = r2
        L_0x0082:
            kotlin.coroutines.Continuation<T> r5 = r6.f40729f     // Catch:{ all -> 0x0095 }
            r5.resumeWith(r7)     // Catch:{ all -> 0x0095 }
            kotlin.Unit r7 = kotlin.Unit.f40298a     // Catch:{ all -> 0x0095 }
            if (r8 == 0) goto L_0x0091
            boolean r7 = r8.y0()     // Catch:{ all -> 0x00a9 }
            if (r7 == 0) goto L_0x00a2
        L_0x0091:
            kotlinx.coroutines.internal.ThreadContextKt.a(r4, r3)     // Catch:{ all -> 0x00a9 }
            goto L_0x00a2
        L_0x0095:
            r7 = move-exception
            if (r8 == 0) goto L_0x009e
            boolean r8 = r8.y0()     // Catch:{ all -> 0x00a9 }
            if (r8 == 0) goto L_0x00a1
        L_0x009e:
            kotlinx.coroutines.internal.ThreadContextKt.a(r4, r3)     // Catch:{ all -> 0x00a9 }
        L_0x00a1:
            throw r7     // Catch:{ all -> 0x00a9 }
        L_0x00a2:
            boolean r7 = r0.B0()     // Catch:{ all -> 0x00a9 }
            if (r7 != 0) goto L_0x00a2
            goto L_0x00ad
        L_0x00a9:
            r7 = move-exception
            r6.k(r7, r2)     // Catch:{ all -> 0x00b1 }
        L_0x00ad:
            r0.r0(r1)
            goto L_0x00b9
        L_0x00b1:
            r6 = move-exception
            r0.r0(r1)
            throw r6
        L_0x00b6:
            r6.resumeWith(r7)
        L_0x00b9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.DispatchedContinuationKt.b(kotlin.coroutines.Continuation, java.lang.Object, kotlin.jvm.functions.Function1):void");
    }

    public static /* synthetic */ void c(Continuation continuation, Object obj, Function1 function1, int i2, Object obj2) {
        if ((i2 & 2) != 0) {
            function1 = null;
        }
        b(continuation, obj, function1);
    }
}
