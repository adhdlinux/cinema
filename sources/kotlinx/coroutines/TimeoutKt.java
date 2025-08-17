package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.intrinsics.UndispatchedKt;

public final class TimeoutKt {
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0016, code lost:
        if (r4 == null) goto L_0x0018;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final kotlinx.coroutines.TimeoutCancellationException a(long r2, kotlinx.coroutines.Delay r4, kotlinx.coroutines.Job r5) {
        /*
            boolean r0 = r4 instanceof kotlinx.coroutines.DelayWithTimeoutDiagnostics
            if (r0 == 0) goto L_0x0007
            kotlinx.coroutines.DelayWithTimeoutDiagnostics r4 = (kotlinx.coroutines.DelayWithTimeoutDiagnostics) r4
            goto L_0x0008
        L_0x0007:
            r4 = 0
        L_0x0008:
            if (r4 == 0) goto L_0x0018
            kotlin.time.Duration$Companion r0 = kotlin.time.Duration.f40567c
            kotlin.time.DurationUnit r0 = kotlin.time.DurationUnit.MILLISECONDS
            long r0 = kotlin.time.DurationKt.s(r2, r0)
            java.lang.String r4 = r4.E(r0)
            if (r4 != 0) goto L_0x002e
        L_0x0018:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r0 = "Timed out waiting for "
            r4.append(r0)
            r4.append(r2)
            java.lang.String r2 = " ms"
            r4.append(r2)
            java.lang.String r4 = r4.toString()
        L_0x002e:
            kotlinx.coroutines.TimeoutCancellationException r2 = new kotlinx.coroutines.TimeoutCancellationException
            r2.<init>(r4, r5)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.TimeoutKt.a(long, kotlinx.coroutines.Delay, kotlinx.coroutines.Job):kotlinx.coroutines.TimeoutCancellationException");
    }

    private static final <U, T extends U> Object b(TimeoutCoroutine<U, ? super T> timeoutCoroutine, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2) {
        JobKt.d(timeoutCoroutine, DelayKt.b(timeoutCoroutine.f40768e.getContext()).A(timeoutCoroutine.f40688f, timeoutCoroutine, timeoutCoroutine.getContext()));
        return UndispatchedKt.c(timeoutCoroutine, timeoutCoroutine, function2);
    }

    public static final <T> Object c(long j2, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        if (j2 > 0) {
            Object b2 = b(new TimeoutCoroutine(j2, continuation), function2);
            if (b2 == IntrinsicsKt__IntrinsicsKt.e()) {
                DebugProbesKt.c(continuation);
            }
            return b2;
        }
        throw new TimeoutCancellationException("Timed out immediately");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> java.lang.Object d(long r7, kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> r9, kotlin.coroutines.Continuation<? super T> r10) {
        /*
            boolean r0 = r10 instanceof kotlinx.coroutines.TimeoutKt$withTimeoutOrNull$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            kotlinx.coroutines.TimeoutKt$withTimeoutOrNull$1 r0 = (kotlinx.coroutines.TimeoutKt$withTimeoutOrNull$1) r0
            int r1 = r0.f40693m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f40693m = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.TimeoutKt$withTimeoutOrNull$1 r0 = new kotlinx.coroutines.TimeoutKt$withTimeoutOrNull$1
            r0.<init>(r10)
        L_0x0018:
            java.lang.Object r10 = r0.f40692l
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.e()
            int r2 = r0.f40693m
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x003c
            if (r2 != r4) goto L_0x0034
            java.lang.Object r7 = r0.f40691k
            kotlin.jvm.internal.Ref$ObjectRef r7 = (kotlin.jvm.internal.Ref$ObjectRef) r7
            java.lang.Object r8 = r0.f40690j
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            kotlin.ResultKt.b(r10)     // Catch:{ TimeoutCancellationException -> 0x0032 }
            goto L_0x006b
        L_0x0032:
            r8 = move-exception
            goto L_0x006e
        L_0x0034:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x003c:
            kotlin.ResultKt.b(r10)
            r5 = 0
            int r10 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r10 > 0) goto L_0x0046
            return r3
        L_0x0046:
            kotlin.jvm.internal.Ref$ObjectRef r10 = new kotlin.jvm.internal.Ref$ObjectRef
            r10.<init>()
            r0.f40690j = r9     // Catch:{ TimeoutCancellationException -> 0x006c }
            r0.f40691k = r10     // Catch:{ TimeoutCancellationException -> 0x006c }
            r0.f40689i = r7     // Catch:{ TimeoutCancellationException -> 0x006c }
            r0.f40693m = r4     // Catch:{ TimeoutCancellationException -> 0x006c }
            kotlinx.coroutines.TimeoutCoroutine r2 = new kotlinx.coroutines.TimeoutCoroutine     // Catch:{ TimeoutCancellationException -> 0x006c }
            r2.<init>(r7, r0)     // Catch:{ TimeoutCancellationException -> 0x006c }
            r10.f40429b = r2     // Catch:{ TimeoutCancellationException -> 0x006c }
            java.lang.Object r7 = b(r2, r9)     // Catch:{ TimeoutCancellationException -> 0x006c }
            java.lang.Object r8 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.e()     // Catch:{ TimeoutCancellationException -> 0x006c }
            if (r7 != r8) goto L_0x0067
            kotlin.coroutines.jvm.internal.DebugProbesKt.c(r0)     // Catch:{ TimeoutCancellationException -> 0x006c }
        L_0x0067:
            if (r7 != r1) goto L_0x006a
            return r1
        L_0x006a:
            r10 = r7
        L_0x006b:
            return r10
        L_0x006c:
            r8 = move-exception
            r7 = r10
        L_0x006e:
            kotlinx.coroutines.Job r9 = r8.f40687b
            T r7 = r7.f40429b
            if (r9 != r7) goto L_0x0075
            return r3
        L_0x0075:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.TimeoutKt.d(long, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
