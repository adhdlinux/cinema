package com.unity3d.services;

import com.unity3d.services.core.domain.task.EmptyParams;
import com.unity3d.services.core.domain.task.InitializeSDK;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.unity3d.services.UnityAdsSDK$initialize$1", f = "UnityAdsSDK.kt", l = {23}, m = "invokeSuspend")
final class UnityAdsSDK$initialize$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    UnityAdsSDK$initialize$1(Continuation<? super UnityAdsSDK$initialize$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UnityAdsSDK$initialize$1(continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((UnityAdsSDK$initialize$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f40298a);
    }

    public final Object invokeSuspend(Object obj) {
        Object e2 = IntrinsicsKt__IntrinsicsKt.e();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.b(obj);
            InitializeSDK access$getInitializeSDK = UnityAdsSDK.INSTANCE.getInitializeSDK();
            EmptyParams emptyParams = EmptyParams.INSTANCE;
            this.label = 1;
            if (access$getInitializeSDK.invoke(emptyParams, this) == e2) {
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
