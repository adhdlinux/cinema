package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.scheduling.Task;

public abstract class DispatchedTask<T> extends Task {

    /* renamed from: d  reason: collision with root package name */
    public int f40628d;

    public DispatchedTask(int i2) {
        this.f40628d = i2;
    }

    public void c(Object obj, Throwable th) {
    }

    public abstract Continuation<T> f();

    public Throwable i(Object obj) {
        CompletedExceptionally completedExceptionally = obj instanceof CompletedExceptionally ? (CompletedExceptionally) obj : null;
        if (completedExceptionally != null) {
            return completedExceptionally.f40605a;
        }
        return null;
    }

    public <T> T j(Object obj) {
        return obj;
    }

    public final void k(Throwable th, Throwable th2) {
        if (th != null || th2 != null) {
            if (!(th == null || th2 == null)) {
                ExceptionsKt__ExceptionsKt.a(th, th2);
            }
            if (th == null) {
                th = th2;
            }
            Intrinsics.c(th);
            CoroutineExceptionHandlerKt.a(f().getContext(), new CoroutinesInternalError("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
        }
    }

    public abstract Object l();

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0086, code lost:
        if (r4.y0() != false) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00af, code lost:
        if (r4.y0() != false) goto L_0x00b1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r10 = this;
            kotlinx.coroutines.scheduling.TaskContext r0 = r10.f40824c
            kotlin.coroutines.Continuation r1 = r10.f()     // Catch:{ all -> 0x00b5 }
            java.lang.String r2 = "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTask>"
            kotlin.jvm.internal.Intrinsics.d(r1, r2)     // Catch:{ all -> 0x00b5 }
            kotlinx.coroutines.internal.DispatchedContinuation r1 = (kotlinx.coroutines.internal.DispatchedContinuation) r1     // Catch:{ all -> 0x00b5 }
            kotlin.coroutines.Continuation<T> r2 = r1.f40729f     // Catch:{ all -> 0x00b5 }
            java.lang.Object r1 = r1.f40731h     // Catch:{ all -> 0x00b5 }
            kotlin.coroutines.CoroutineContext r3 = r2.getContext()     // Catch:{ all -> 0x00b5 }
            java.lang.Object r1 = kotlinx.coroutines.internal.ThreadContextKt.c(r3, r1)     // Catch:{ all -> 0x00b5 }
            kotlinx.coroutines.internal.Symbol r4 = kotlinx.coroutines.internal.ThreadContextKt.f40773a     // Catch:{ all -> 0x00b5 }
            r5 = 0
            if (r1 == r4) goto L_0x0023
            kotlinx.coroutines.UndispatchedCoroutine r4 = kotlinx.coroutines.CoroutineContextKt.g(r2, r3, r1)     // Catch:{ all -> 0x00b5 }
            goto L_0x0024
        L_0x0023:
            r4 = r5
        L_0x0024:
            kotlin.coroutines.CoroutineContext r6 = r2.getContext()     // Catch:{ all -> 0x00a8 }
            java.lang.Object r7 = r10.l()     // Catch:{ all -> 0x00a8 }
            java.lang.Throwable r8 = r10.i(r7)     // Catch:{ all -> 0x00a8 }
            if (r8 != 0) goto L_0x0043
            int r9 = r10.f40628d     // Catch:{ all -> 0x00a8 }
            boolean r9 = kotlinx.coroutines.DispatchedTaskKt.b(r9)     // Catch:{ all -> 0x00a8 }
            if (r9 == 0) goto L_0x0043
            kotlinx.coroutines.Job$Key r9 = kotlinx.coroutines.Job.E0     // Catch:{ all -> 0x00a8 }
            kotlin.coroutines.CoroutineContext$Element r6 = r6.get(r9)     // Catch:{ all -> 0x00a8 }
            kotlinx.coroutines.Job r6 = (kotlinx.coroutines.Job) r6     // Catch:{ all -> 0x00a8 }
            goto L_0x0044
        L_0x0043:
            r6 = r5
        L_0x0044:
            if (r6 == 0) goto L_0x0061
            boolean r9 = r6.isActive()     // Catch:{ all -> 0x00a8 }
            if (r9 != 0) goto L_0x0061
            java.util.concurrent.CancellationException r6 = r6.s()     // Catch:{ all -> 0x00a8 }
            r10.c(r7, r6)     // Catch:{ all -> 0x00a8 }
            kotlin.Result$Companion r7 = kotlin.Result.f40263c     // Catch:{ all -> 0x00a8 }
            java.lang.Object r6 = kotlin.ResultKt.a(r6)     // Catch:{ all -> 0x00a8 }
            java.lang.Object r6 = kotlin.Result.b(r6)     // Catch:{ all -> 0x00a8 }
            r2.resumeWith(r6)     // Catch:{ all -> 0x00a8 }
            goto L_0x007e
        L_0x0061:
            if (r8 == 0) goto L_0x0071
            kotlin.Result$Companion r6 = kotlin.Result.f40263c     // Catch:{ all -> 0x00a8 }
            java.lang.Object r6 = kotlin.ResultKt.a(r8)     // Catch:{ all -> 0x00a8 }
            java.lang.Object r6 = kotlin.Result.b(r6)     // Catch:{ all -> 0x00a8 }
            r2.resumeWith(r6)     // Catch:{ all -> 0x00a8 }
            goto L_0x007e
        L_0x0071:
            kotlin.Result$Companion r6 = kotlin.Result.f40263c     // Catch:{ all -> 0x00a8 }
            java.lang.Object r6 = r10.j(r7)     // Catch:{ all -> 0x00a8 }
            java.lang.Object r6 = kotlin.Result.b(r6)     // Catch:{ all -> 0x00a8 }
            r2.resumeWith(r6)     // Catch:{ all -> 0x00a8 }
        L_0x007e:
            kotlin.Unit r2 = kotlin.Unit.f40298a     // Catch:{ all -> 0x00a8 }
            if (r4 == 0) goto L_0x0088
            boolean r2 = r4.y0()     // Catch:{ all -> 0x00b5 }
            if (r2 == 0) goto L_0x008b
        L_0x0088:
            kotlinx.coroutines.internal.ThreadContextKt.a(r3, r1)     // Catch:{ all -> 0x00b5 }
        L_0x008b:
            r0.a()     // Catch:{ all -> 0x0095 }
            kotlin.Unit r0 = kotlin.Unit.f40298a     // Catch:{ all -> 0x0095 }
            java.lang.Object r0 = kotlin.Result.b(r0)     // Catch:{ all -> 0x0095 }
            goto L_0x00a0
        L_0x0095:
            r0 = move-exception
            kotlin.Result$Companion r1 = kotlin.Result.f40263c
            java.lang.Object r0 = kotlin.ResultKt.a(r0)
            java.lang.Object r0 = kotlin.Result.b(r0)
        L_0x00a0:
            java.lang.Throwable r0 = kotlin.Result.e(r0)
            r10.k(r5, r0)
            goto L_0x00d4
        L_0x00a8:
            r2 = move-exception
            if (r4 == 0) goto L_0x00b1
            boolean r4 = r4.y0()     // Catch:{ all -> 0x00b5 }
            if (r4 == 0) goto L_0x00b4
        L_0x00b1:
            kotlinx.coroutines.internal.ThreadContextKt.a(r3, r1)     // Catch:{ all -> 0x00b5 }
        L_0x00b4:
            throw r2     // Catch:{ all -> 0x00b5 }
        L_0x00b5:
            r1 = move-exception
            kotlin.Result$Companion r2 = kotlin.Result.f40263c     // Catch:{ all -> 0x00c2 }
            r0.a()     // Catch:{ all -> 0x00c2 }
            kotlin.Unit r0 = kotlin.Unit.f40298a     // Catch:{ all -> 0x00c2 }
            java.lang.Object r0 = kotlin.Result.b(r0)     // Catch:{ all -> 0x00c2 }
            goto L_0x00cd
        L_0x00c2:
            r0 = move-exception
            kotlin.Result$Companion r2 = kotlin.Result.f40263c
            java.lang.Object r0 = kotlin.ResultKt.a(r0)
            java.lang.Object r0 = kotlin.Result.b(r0)
        L_0x00cd:
            java.lang.Throwable r0 = kotlin.Result.e(r0)
            r10.k(r1, r0)
        L_0x00d4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.DispatchedTask.run():void");
    }
}
