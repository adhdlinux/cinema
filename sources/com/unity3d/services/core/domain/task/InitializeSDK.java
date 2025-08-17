package com.unity3d.services.core.domain.task;

import com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridgeBase;
import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.configuration.ErrorState;
import com.unity3d.services.core.domain.ISDKDispatchers;
import com.unity3d.services.core.domain.task.InitializeStateError;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

public final class InitializeSDK extends MetricTask<EmptyParams, Unit> {
    /* access modifiers changed from: private */
    public final ConfigFileFromLocalStorage configFileFromLocalStorage;
    private final ISDKDispatchers dispatchers;
    /* access modifiers changed from: private */
    public final InitializeStateComplete initializeStateComplete;
    /* access modifiers changed from: private */
    public final InitializeStateConfig initializeStateConfig;
    /* access modifiers changed from: private */
    public final InitializeStateCreate initializeStateCreate;
    /* access modifiers changed from: private */
    public final InitializeStateCreateWithRemote initializeStateCreateWithRemote;
    private final InitializeStateError initializeStateError;
    /* access modifiers changed from: private */
    public final InitializeStateLoadCache initializeStateLoadCache;
    /* access modifiers changed from: private */
    public final InitializeStateLoadWeb initializeStateLoadWeb;
    /* access modifiers changed from: private */
    public final InitializeStateReset initializeStateReset;

    public InitializeSDK(ISDKDispatchers iSDKDispatchers, ConfigFileFromLocalStorage configFileFromLocalStorage2, InitializeStateReset initializeStateReset2, InitializeStateError initializeStateError2, InitializeStateConfig initializeStateConfig2, InitializeStateCreate initializeStateCreate2, InitializeStateLoadCache initializeStateLoadCache2, InitializeStateCreateWithRemote initializeStateCreateWithRemote2, InitializeStateLoadWeb initializeStateLoadWeb2, InitializeStateComplete initializeStateComplete2) {
        Intrinsics.f(iSDKDispatchers, "dispatchers");
        Intrinsics.f(configFileFromLocalStorage2, "configFileFromLocalStorage");
        Intrinsics.f(initializeStateReset2, "initializeStateReset");
        Intrinsics.f(initializeStateError2, "initializeStateError");
        Intrinsics.f(initializeStateConfig2, "initializeStateConfig");
        Intrinsics.f(initializeStateCreate2, "initializeStateCreate");
        Intrinsics.f(initializeStateLoadCache2, "initializeStateLoadCache");
        Intrinsics.f(initializeStateCreateWithRemote2, "initializeStateCreateWithRemote");
        Intrinsics.f(initializeStateLoadWeb2, "initializeStateLoadWeb");
        Intrinsics.f(initializeStateComplete2, "initializeStateComplete");
        this.dispatchers = iSDKDispatchers;
        this.configFileFromLocalStorage = configFileFromLocalStorage2;
        this.initializeStateReset = initializeStateReset2;
        this.initializeStateError = initializeStateError2;
        this.initializeStateConfig = initializeStateConfig2;
        this.initializeStateCreate = initializeStateCreate2;
        this.initializeStateLoadCache = initializeStateLoadCache2;
        this.initializeStateCreateWithRemote = initializeStateCreateWithRemote2;
        this.initializeStateLoadWeb = initializeStateLoadWeb2;
        this.initializeStateComplete = initializeStateComplete2;
    }

    /* access modifiers changed from: private */
    public final Object executeErrorState(ErrorState errorState, Throwable th, Configuration configuration, Continuation<? super Unit> continuation) {
        String str;
        InitializeStateError initializeStateError2 = this.initializeStateError;
        if (th != null) {
            str = th.getMessage();
        } else {
            str = null;
        }
        Object invoke = initializeStateError2.invoke(new InitializeStateError.Params(errorState, new Exception(str), configuration), continuation);
        if (invoke == IntrinsicsKt__IntrinsicsKt.e()) {
            return invoke;
        }
        return Unit.f40298a;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object handleInitializationException(com.unity3d.services.core.domain.task.InitializationException r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.unity3d.services.core.domain.task.InitializeSDK$handleInitializationException$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.unity3d.services.core.domain.task.InitializeSDK$handleInitializationException$1 r0 = (com.unity3d.services.core.domain.task.InitializeSDK$handleInitializationException$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.unity3d.services.core.domain.task.InitializeSDK$handleInitializationException$1 r0 = new com.unity3d.services.core.domain.task.InitializeSDK$handleInitializationException$1
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.e()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 == r3) goto L_0x002d
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x002d:
            java.lang.Object r6 = r0.L$0
            com.unity3d.services.core.domain.task.InitializationException r6 = (com.unity3d.services.core.domain.task.InitializationException) r6
            kotlin.ResultKt.b(r7)
            goto L_0x004f
        L_0x0035:
            kotlin.ResultKt.b(r7)
            com.unity3d.services.core.configuration.ErrorState r7 = r6.getErrorState()
            java.lang.Exception r2 = r6.getOriginalException()
            com.unity3d.services.core.configuration.Configuration r4 = r6.getConfig()
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r7 = r5.executeErrorState(r7, r2, r4, r0)
            if (r7 != r1) goto L_0x004f
            return r1
        L_0x004f:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.domain.task.InitializeSDK.handleInitializationException(com.unity3d.services.core.domain.task.InitializationException, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public String getMetricName() {
        return getMetricNameForInitializeTask(MobileAdsBridgeBase.initializeMethodName);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object doWork(com.unity3d.services.core.domain.task.EmptyParams r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r5 = r6 instanceof com.unity3d.services.core.domain.task.InitializeSDK$doWork$1
            if (r5 == 0) goto L_0x0013
            r5 = r6
            com.unity3d.services.core.domain.task.InitializeSDK$doWork$1 r5 = (com.unity3d.services.core.domain.task.InitializeSDK$doWork$1) r5
            int r0 = r5.label
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r0 & r1
            if (r2 == 0) goto L_0x0013
            int r0 = r0 - r1
            r5.label = r0
            goto L_0x0018
        L_0x0013:
            com.unity3d.services.core.domain.task.InitializeSDK$doWork$1 r5 = new com.unity3d.services.core.domain.task.InitializeSDK$doWork$1
            r5.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r5.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.e()
            int r1 = r5.label
            r2 = 1
            if (r1 == 0) goto L_0x0031
            if (r1 != r2) goto L_0x0029
            kotlin.ResultKt.b(r6)
            goto L_0x0049
        L_0x0029:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0031:
            kotlin.ResultKt.b(r6)
            com.unity3d.services.core.domain.ISDKDispatchers r6 = r4.dispatchers
            kotlinx.coroutines.CoroutineDispatcher r6 = r6.getDefault()
            com.unity3d.services.core.domain.task.InitializeSDK$doWork$2 r1 = new com.unity3d.services.core.domain.task.InitializeSDK$doWork$2
            r3 = 0
            r1.<init>(r4, r3)
            r5.label = r2
            java.lang.Object r5 = kotlinx.coroutines.BuildersKt.e(r6, r1, r5)
            if (r5 != r0) goto L_0x0049
            return r0
        L_0x0049:
            kotlin.Unit r5 = kotlin.Unit.f40298a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.domain.task.InitializeSDK.doWork(com.unity3d.services.core.domain.task.EmptyParams, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
