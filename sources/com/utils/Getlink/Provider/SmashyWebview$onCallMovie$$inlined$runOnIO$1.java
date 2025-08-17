package com.utils.Getlink.Provider;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.utils.Getlink.Provider.SmashyWebview$onCallMovie$$inlined$runOnIO$1", f = "SmashyWebview.kt", l = {155, 156}, m = "invokeSuspend")
public final class SmashyWebview$onCallMovie$$inlined$runOnIO$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: i  reason: collision with root package name */
    int f37439i;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ SmashyWebview f37440j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SmashyWebview$onCallMovie$$inlined$runOnIO$1(Continuation continuation, SmashyWebview smashyWebview) {
        super(2, continuation);
        this.f37440j = smashyWebview;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SmashyWebview$onCallMovie$$inlined$runOnIO$1(continuation, this.f37440j);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SmashyWebview$onCallMovie$$inlined$runOnIO$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f40298a);
    }

    public final Object invokeSuspend(Object obj) {
        Object e2 = IntrinsicsKt__IntrinsicsKt.e();
        int i2 = this.f37439i;
        if (i2 == 0) {
            ResultKt.b(obj);
            SmashyWebview smashyWebview = this.f37440j;
            this.f37439i = 1;
            if (smashyWebview.W(this) == e2) {
                return e2;
            }
        } else if (i2 == 1) {
            ResultKt.b(obj);
        } else if (i2 == 2) {
            ResultKt.b(obj);
            return Unit.f40298a;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        SmashyWebview smashyWebview2 = this.f37440j;
        this.f37439i = 2;
        if (smashyWebview2.J(this) == e2) {
            return e2;
        }
        return Unit.f40298a;
    }
}
