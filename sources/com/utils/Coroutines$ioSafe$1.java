package com.utils;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.utils.Coroutines$ioSafe$1", f = "Coroutines.kt", l = {39}, m = "invokeSuspend")
final class Coroutines$ioSafe$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: i  reason: collision with root package name */
    int f37224i;

    /* renamed from: j  reason: collision with root package name */
    private /* synthetic */ Object f37225j;

    /* renamed from: k  reason: collision with root package name */
    final /* synthetic */ Function3<CoroutineScope, T, Continuation<? super Unit>, Object> f37226k;

    /* renamed from: l  reason: collision with root package name */
    final /* synthetic */ T f37227l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Coroutines$ioSafe$1(Function3<? super CoroutineScope, ? super T, ? super Continuation<? super Unit>, ? extends Object> function3, T t2, Continuation<? super Coroutines$ioSafe$1> continuation) {
        super(2, continuation);
        this.f37226k = function3;
        this.f37227l = t2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Coroutines$ioSafe$1 coroutines$ioSafe$1 = new Coroutines$ioSafe$1(this.f37226k, this.f37227l, continuation);
        coroutines$ioSafe$1.f37225j = obj;
        return coroutines$ioSafe$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((Coroutines$ioSafe$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f40298a);
    }

    public final Object invokeSuspend(Object obj) {
        Object e2 = IntrinsicsKt__IntrinsicsKt.e();
        int i2 = this.f37224i;
        if (i2 == 0) {
            ResultKt.b(obj);
            Function3<CoroutineScope, T, Continuation<? super Unit>, Object> function3 = this.f37226k;
            T t2 = this.f37227l;
            this.f37224i = 1;
            if (function3.invoke((CoroutineScope) this.f37225j, t2, this) == e2) {
                return e2;
            }
        } else if (i2 == 1) {
            ResultKt.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.f40298a;
    }
}
