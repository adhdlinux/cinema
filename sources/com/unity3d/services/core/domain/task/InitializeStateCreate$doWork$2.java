package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.configuration.ErrorState;
import com.unity3d.services.core.domain.task.InitializeStateCreate;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.webview.WebViewApp;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.unity3d.services.core.domain.task.InitializeStateCreate$doWork$2", f = "InitializeStateCreate.kt", l = {}, m = "invokeSuspend")
final class InitializeStateCreate$doWork$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Configuration>, Object> {
    final /* synthetic */ InitializeStateCreate.Params $params;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InitializeStateCreate$doWork$2(InitializeStateCreate.Params params, Continuation<? super InitializeStateCreate$doWork$2> continuation) {
        super(2, continuation);
        this.$params = params;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InitializeStateCreate$doWork$2(this.$params, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Configuration> continuation) {
        return ((InitializeStateCreate$doWork$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f40298a);
    }

    public final Object invokeSuspend(Object obj) {
        String str;
        Object unused = IntrinsicsKt__IntrinsicsKt.e();
        if (this.label == 0) {
            ResultKt.b(obj);
            DeviceLog.debug("Unity Ads init: creating webapp");
            Configuration config = this.$params.getConfig();
            config.setWebViewData(this.$params.getWebViewData());
            try {
                ErrorState create = WebViewApp.create(config, false);
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
