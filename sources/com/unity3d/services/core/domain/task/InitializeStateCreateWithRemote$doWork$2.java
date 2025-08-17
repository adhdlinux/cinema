package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.configuration.ErrorState;
import com.unity3d.services.core.domain.task.InitializeStateCreateWithRemote;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.webview.WebViewApp;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.unity3d.services.core.domain.task.InitializeStateCreateWithRemote$doWork$2", f = "InitializeStateCreateWithRemote.kt", l = {}, m = "invokeSuspend")
final class InitializeStateCreateWithRemote$doWork$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Configuration>, Object> {
    final /* synthetic */ InitializeStateCreateWithRemote.Params $params;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InitializeStateCreateWithRemote$doWork$2(InitializeStateCreateWithRemote.Params params, Continuation<? super InitializeStateCreateWithRemote$doWork$2> continuation) {
        super(2, continuation);
        this.$params = params;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InitializeStateCreateWithRemote$doWork$2(this.$params, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Configuration> continuation) {
        return ((InitializeStateCreateWithRemote$doWork$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f40298a);
    }

    public final Object invokeSuspend(Object obj) {
        String str;
        Object unused = IntrinsicsKt__IntrinsicsKt.e();
        if (this.label == 0) {
            ResultKt.b(obj);
            DeviceLog.debug("Unity Ads init: creating webapp");
            Configuration config = this.$params.getConfig();
            try {
                ErrorState create = WebViewApp.create(config, true);
                if (create == null) {
                    return config;
                }
                if (WebViewApp.getCurrentApp().getWebAppFailureMessage() != null) {
                    str = WebViewApp.getCurrentApp().getWebAppFailureMessage();
                } else {
                    str = "Unity Ads WebApp creation failed";
                }
                DeviceLog.error(str);
                throw new InitializationException(create, new Exception(str), config);
            } catch (IllegalThreadStateException e2) {
                DeviceLog.exception("Illegal Thread", e2);
                throw new InitializationException(ErrorState.CreateWebApp, e2, config);
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
