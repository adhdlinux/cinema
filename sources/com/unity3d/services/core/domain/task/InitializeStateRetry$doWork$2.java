package com.unity3d.services.core.domain.task;

import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.unity3d.services.core.domain.task.InitializeStateRetry$doWork$2", f = "InitializeStateRetry.kt", l = {}, m = "invokeSuspend")
final class InitializeStateRetry$doWork$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit>>, Object> {
    int label;

    InitializeStateRetry$doWork$2(Continuation<? super InitializeStateRetry$doWork$2> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InitializeStateRetry$doWork$2(continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<Unit>> continuation) {
        return ((InitializeStateRetry$doWork$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f40298a);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        Object unused = IntrinsicsKt__IntrinsicsKt.e();
        if (this.label == 0) {
            ResultKt.b(obj);
            try {
                Result.Companion companion = Result.f40263c;
                obj2 = Result.b(Unit.f40298a);
            } catch (CancellationException e2) {
                throw e2;
            } catch (Throwable th) {
                Result.Companion companion2 = Result.f40263c;
                obj2 = Result.b(ResultKt.a(th));
            }
            if (Result.h(obj2)) {
                obj2 = Result.b(obj2);
            } else {
                Throwable e3 = Result.e(obj2);
                if (e3 != null) {
                    obj2 = Result.b(ResultKt.a(e3));
                }
            }
            return Result.a(obj2);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
