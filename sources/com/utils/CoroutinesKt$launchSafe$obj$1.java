package com.utils;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import timber.log.Timber;

@DebugMetadata(c = "com.utils.CoroutinesKt$launchSafe$obj$1", f = "Coroutines.kt", l = {18}, m = "invokeSuspend")
final class CoroutinesKt$launchSafe$obj$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: i  reason: collision with root package name */
    int f37228i;

    /* renamed from: j  reason: collision with root package name */
    private /* synthetic */ Object f37229j;

    /* renamed from: k  reason: collision with root package name */
    final /* synthetic */ Function2<CoroutineScope, Continuation<? super Unit>, Object> f37230k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CoroutinesKt$launchSafe$obj$1(Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super CoroutinesKt$launchSafe$obj$1> continuation) {
        super(2, continuation);
        this.f37230k = function2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CoroutinesKt$launchSafe$obj$1 coroutinesKt$launchSafe$obj$1 = new CoroutinesKt$launchSafe$obj$1(this.f37230k, continuation);
        coroutinesKt$launchSafe$obj$1.f37229j = obj;
        return coroutinesKt$launchSafe$obj$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CoroutinesKt$launchSafe$obj$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f40298a);
    }

    public final Object invokeSuspend(Object obj) {
        Object e2 = IntrinsicsKt__IntrinsicsKt.e();
        int i2 = this.f37228i;
        if (i2 == 0) {
            ResultKt.b(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.f37229j;
            Function2<CoroutineScope, Continuation<? super Unit>, Object> function2 = this.f37230k;
            this.f37228i = 1;
            if (function2.invoke(coroutineScope, this) == e2) {
                return e2;
            }
        } else if (i2 == 1) {
            try {
                ResultKt.b(obj);
            } catch (Throwable th) {
                Timber.f42178a.d(th, "CoroutineScope", new Object[0]);
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.f40298a;
    }
}
