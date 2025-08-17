package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.configuration.InitializeEventsMetricSender;
import com.unity3d.services.core.network.core.HttpClient;
import com.unity3d.services.core.network.model.HttpRequest;
import com.unity3d.services.core.network.model.HttpResponse;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.unity3d.services.core.domain.task.InitializeStateLoadWeb$doWork$2$webViewDataResult$1$1", f = "InitializeStateLoadWeb.kt", l = {53}, m = "invokeSuspend")
final class InitializeStateLoadWeb$doWork$2$webViewDataResult$1$1 extends SuspendLambda implements Function2<Integer, Continuation<? super HttpResponse>, Object> {
    final /* synthetic */ HttpRequest $request;
    /* synthetic */ int I$0;
    int label;
    final /* synthetic */ InitializeStateLoadWeb this$0;

    @DebugMetadata(c = "com.unity3d.services.core.domain.task.InitializeStateLoadWeb$doWork$2$webViewDataResult$1$1$1", f = "InitializeStateLoadWeb.kt", l = {53}, m = "invokeSuspend")
    /* renamed from: com.unity3d.services.core.domain.task.InitializeStateLoadWeb$doWork$2$webViewDataResult$1$1$1  reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super HttpResponse>, Object> {
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(initializeStateLoadWeb, httpRequest, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super HttpResponse> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f40298a);
        }

        public final Object invokeSuspend(Object obj) {
            Object e2 = IntrinsicsKt__IntrinsicsKt.e();
            int i2 = this.label;
            if (i2 == 0) {
                ResultKt.b(obj);
                HttpClient access$getHttpClient$p = initializeStateLoadWeb.httpClient;
                HttpRequest httpRequest = httpRequest;
                this.label = 1;
                obj = access$getHttpClient$p.execute(httpRequest, this);
                if (obj == e2) {
                    return e2;
                }
            } else if (i2 == 1) {
                ResultKt.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return obj;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InitializeStateLoadWeb$doWork$2$webViewDataResult$1$1(InitializeStateLoadWeb initializeStateLoadWeb, HttpRequest httpRequest, Continuation<? super InitializeStateLoadWeb$doWork$2$webViewDataResult$1$1> continuation) {
        super(2, continuation);
        this.this$0 = initializeStateLoadWeb;
        this.$request = httpRequest;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        InitializeStateLoadWeb$doWork$2$webViewDataResult$1$1 initializeStateLoadWeb$doWork$2$webViewDataResult$1$1 = new InitializeStateLoadWeb$doWork$2$webViewDataResult$1$1(this.this$0, this.$request, continuation);
        initializeStateLoadWeb$doWork$2$webViewDataResult$1$1.I$0 = ((Number) obj).intValue();
        return initializeStateLoadWeb$doWork$2$webViewDataResult$1$1;
    }

    public final Object invoke(int i2, Continuation<? super HttpResponse> continuation) {
        return ((InitializeStateLoadWeb$doWork$2$webViewDataResult$1$1) create(Integer.valueOf(i2), continuation)).invokeSuspend(Unit.f40298a);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke(((Number) obj).intValue(), (Continuation<? super HttpResponse>) (Continuation) obj2);
    }

    public final Object invokeSuspend(Object obj) {
        Object e2 = IntrinsicsKt__IntrinsicsKt.e();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.b(obj);
            if (this.I$0 > 0) {
                InitializeEventsMetricSender.getInstance().onRetryWebview();
            }
            CoroutineDispatcher io2 = this.this$0.dispatchers.getIo();
            final InitializeStateLoadWeb initializeStateLoadWeb = this.this$0;
            final HttpRequest httpRequest = this.$request;
            AnonymousClass1 r12 = new AnonymousClass1((Continuation<? super AnonymousClass1>) null);
            this.label = 1;
            obj = BuildersKt.e(io2, r12, this);
            if (obj == e2) {
                return e2;
            }
        } else if (i2 == 1) {
            ResultKt.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }
}
