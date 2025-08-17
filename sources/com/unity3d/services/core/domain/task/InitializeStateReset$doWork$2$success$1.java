package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.webview.WebView;
import com.unity3d.services.core.webview.WebViewApp;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.unity3d.services.core.domain.task.InitializeStateReset$doWork$2$success$1", f = "InitializeStateReset.kt", l = {38}, m = "invokeSuspend")
final class InitializeStateReset$doWork$2$success$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ WebViewApp $currentApp;
    int label;
    final /* synthetic */ InitializeStateReset this$0;

    @DebugMetadata(c = "com.unity3d.services.core.domain.task.InitializeStateReset$doWork$2$success$1$1", f = "InitializeStateReset.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.unity3d.services.core.domain.task.InitializeStateReset$doWork$2$success$1$1  reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(webViewApp, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f40298a);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.e();
            if (this.label == 0) {
                ResultKt.b(obj);
                WebView webView = webViewApp.getWebView();
                if (webView != null) {
                    webView.destroy();
                }
                webViewApp.setWebView((WebView) null);
                return Unit.f40298a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InitializeStateReset$doWork$2$success$1(InitializeStateReset initializeStateReset, WebViewApp webViewApp, Continuation<? super InitializeStateReset$doWork$2$success$1> continuation) {
        super(2, continuation);
        this.this$0 = initializeStateReset;
        this.$currentApp = webViewApp;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InitializeStateReset$doWork$2$success$1(this.this$0, this.$currentApp, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((InitializeStateReset$doWork$2$success$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f40298a);
    }

    public final Object invokeSuspend(Object obj) {
        Object e2 = IntrinsicsKt__IntrinsicsKt.e();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.b(obj);
            CoroutineDispatcher main = this.this$0.dispatchers.getMain();
            final WebViewApp webViewApp = this.$currentApp;
            AnonymousClass1 r12 = new AnonymousClass1((Continuation<? super AnonymousClass1>) null);
            this.label = 1;
            if (BuildersKt.e(main, r12, this) == e2) {
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
