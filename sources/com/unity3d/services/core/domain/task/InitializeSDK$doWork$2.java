package com.unity3d.services.core.domain.task;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.unity3d.services.core.domain.task.InitializeSDK$doWork$2", f = "InitializeSDK.kt", l = {41, 46, 48, 53, 55, 61, 66, 69, 75, 77, 90, 92, 101, 103, 106}, m = "invokeSuspend")
final class InitializeSDK$doWork$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ InitializeSDK this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InitializeSDK$doWork$2(InitializeSDK initializeSDK, Continuation<? super InitializeSDK$doWork$2> continuation) {
        super(2, continuation);
        this.this$0 = initializeSDK;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        InitializeSDK$doWork$2 initializeSDK$doWork$2 = new InitializeSDK$doWork$2(this.this$0, continuation);
        initializeSDK$doWork$2.L$0 = obj;
        return initializeSDK$doWork$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((InitializeSDK$doWork$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f40298a);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v87, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v41, resolved type: kotlinx.coroutines.CoroutineScope} */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00f0, code lost:
        r12 = kotlin.Result.b((com.unity3d.services.core.configuration.Configuration) r12);
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0273 A[Catch:{ all -> 0x0059 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x028b  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x02b7  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x032b  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x037a A[Catch:{ all -> 0x0025 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x0392  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x03c9 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0160  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0189  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x01bc  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x01dc  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0216  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0239  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.e()
            int r1 = r11.label
            r2 = 0
            switch(r1) {
                case 0: goto L_0x00c0;
                case 1: goto L_0x00b8;
                case 2: goto L_0x00a8;
                case 3: goto L_0x00a1;
                case 4: goto L_0x0091;
                case 5: goto L_0x0082;
                case 6: goto L_0x0070;
                case 7: goto L_0x006b;
                case 8: goto L_0x005c;
                case 9: goto L_0x004a;
                case 10: goto L_0x0043;
                case 11: goto L_0x0035;
                case 12: goto L_0x0028;
                case 13: goto L_0x001e;
                case 14: goto L_0x0017;
                case 15: goto L_0x0012;
                default: goto L_0x000a;
            }
        L_0x000a:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L_0x0012:
            kotlin.ResultKt.b(r12)
            goto L_0x03ca
        L_0x0017:
            java.lang.Object r1 = r11.L$0
            kotlin.ResultKt.b(r12)
            goto L_0x03a9
        L_0x001e:
            java.lang.Object r1 = r11.L$0
            kotlin.ResultKt.b(r12)     // Catch:{ all -> 0x0025 }
            goto L_0x037b
        L_0x0025:
            r12 = move-exception
            goto L_0x0382
        L_0x0028:
            java.lang.Object r1 = r11.L$2
            java.lang.Object r3 = r11.L$1
            java.lang.Object r4 = r11.L$0
            kotlinx.coroutines.CoroutineScope r4 = (kotlinx.coroutines.CoroutineScope) r4
            kotlin.ResultKt.b(r12)
            goto L_0x0343
        L_0x0035:
            java.lang.Object r1 = r11.L$1
            java.lang.Object r3 = r11.L$0
            kotlinx.coroutines.CoroutineScope r3 = (kotlinx.coroutines.CoroutineScope) r3
            kotlin.ResultKt.b(r12)     // Catch:{ all -> 0x0040 }
            goto L_0x030f
        L_0x0040:
            r12 = move-exception
            goto L_0x0318
        L_0x0043:
            java.lang.Object r0 = r11.L$0
            kotlin.ResultKt.b(r12)
            goto L_0x02a5
        L_0x004a:
            java.lang.Object r1 = r11.L$2
            java.lang.Object r3 = r11.L$1
            com.unity3d.services.core.configuration.Configuration r3 = (com.unity3d.services.core.configuration.Configuration) r3
            java.lang.Object r4 = r11.L$0
            kotlinx.coroutines.CoroutineScope r4 = (kotlinx.coroutines.CoroutineScope) r4
            kotlin.ResultKt.b(r12)     // Catch:{ all -> 0x0059 }
            goto L_0x0274
        L_0x0059:
            r12 = move-exception
            goto L_0x027b
        L_0x005c:
            java.lang.Object r1 = r11.L$2
            java.lang.Object r3 = r11.L$1
            com.unity3d.services.core.configuration.Configuration r3 = (com.unity3d.services.core.configuration.Configuration) r3
            java.lang.Object r4 = r11.L$0
            kotlinx.coroutines.CoroutineScope r4 = (kotlinx.coroutines.CoroutineScope) r4
            kotlin.ResultKt.b(r12)
            goto L_0x0250
        L_0x006b:
            kotlin.ResultKt.b(r12)
            goto L_0x0236
        L_0x0070:
            java.lang.Object r1 = r11.L$2
            java.lang.Object r3 = r11.L$1
            com.unity3d.services.core.configuration.Configuration r3 = (com.unity3d.services.core.configuration.Configuration) r3
            java.lang.Object r4 = r11.L$0
            kotlinx.coroutines.CoroutineScope r4 = (kotlinx.coroutines.CoroutineScope) r4
            kotlin.ResultKt.b(r12)     // Catch:{ all -> 0x007f }
            goto L_0x01ff
        L_0x007f:
            r12 = move-exception
            goto L_0x0206
        L_0x0082:
            java.lang.Object r1 = r11.L$2
            java.lang.Object r3 = r11.L$1
            com.unity3d.services.core.configuration.Configuration r3 = (com.unity3d.services.core.configuration.Configuration) r3
            java.lang.Object r4 = r11.L$0
            kotlinx.coroutines.CoroutineScope r4 = (kotlinx.coroutines.CoroutineScope) r4
            kotlin.ResultKt.b(r12)
            goto L_0x01d2
        L_0x0091:
            java.lang.Object r1 = r11.L$1
            com.unity3d.services.core.configuration.Configuration r1 = (com.unity3d.services.core.configuration.Configuration) r1
            java.lang.Object r3 = r11.L$0
            kotlinx.coroutines.CoroutineScope r3 = (kotlinx.coroutines.CoroutineScope) r3
            kotlin.ResultKt.b(r12)     // Catch:{ all -> 0x009e }
            goto L_0x01a2
        L_0x009e:
            r12 = move-exception
            goto L_0x01a9
        L_0x00a1:
            java.lang.Object r0 = r11.L$0
            kotlin.ResultKt.b(r12)
            goto L_0x0177
        L_0x00a8:
            java.lang.Object r1 = r11.L$1
            com.unity3d.services.core.configuration.Configuration r1 = (com.unity3d.services.core.configuration.Configuration) r1
            java.lang.Object r3 = r11.L$0
            kotlinx.coroutines.CoroutineScope r3 = (kotlinx.coroutines.CoroutineScope) r3
            kotlin.ResultKt.b(r12)     // Catch:{ all -> 0x00b5 }
            goto L_0x0149
        L_0x00b5:
            r12 = move-exception
            goto L_0x0150
        L_0x00b8:
            java.lang.Object r1 = r11.L$0
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            kotlin.ResultKt.b(r12)     // Catch:{ all -> 0x00f7 }
            goto L_0x00f0
        L_0x00c0:
            kotlin.ResultKt.b(r12)
            java.lang.Object r12 = r11.L$0
            r1 = r12
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            com.unity3d.services.core.configuration.IInitializeEventsMetricSender r12 = com.unity3d.services.core.configuration.InitializeEventsMetricSender.getInstance()
            r12.didInitStart()
            com.unity3d.services.core.lifecycle.CachedLifecycle.register()
            java.lang.String r12 = "Unity Ads Init: Loading Config File From Local Storage"
            com.unity3d.services.core.log.DeviceLog.debug(r12)
            com.unity3d.services.core.domain.task.InitializeSDK r12 = r11.this$0
            kotlin.Result$Companion r3 = kotlin.Result.f40263c     // Catch:{ all -> 0x00f7 }
            com.unity3d.services.core.domain.task.ConfigFileFromLocalStorage r12 = r12.configFileFromLocalStorage     // Catch:{ all -> 0x00f7 }
            com.unity3d.services.core.domain.task.ConfigFileFromLocalStorage$Params r3 = new com.unity3d.services.core.domain.task.ConfigFileFromLocalStorage$Params     // Catch:{ all -> 0x00f7 }
            r3.<init>()     // Catch:{ all -> 0x00f7 }
            r11.L$0 = r1     // Catch:{ all -> 0x00f7 }
            r4 = 1
            r11.label = r4     // Catch:{ all -> 0x00f7 }
            java.lang.Object r12 = r12.invoke(r3, r11)     // Catch:{ all -> 0x00f7 }
            if (r12 != r0) goto L_0x00f0
            return r0
        L_0x00f0:
            com.unity3d.services.core.configuration.Configuration r12 = (com.unity3d.services.core.configuration.Configuration) r12     // Catch:{ all -> 0x00f7 }
            java.lang.Object r12 = kotlin.Result.b(r12)     // Catch:{ all -> 0x00f7 }
            goto L_0x0102
        L_0x00f7:
            r12 = move-exception
            kotlin.Result$Companion r3 = kotlin.Result.f40263c
            java.lang.Object r12 = kotlin.ResultKt.a(r12)
            java.lang.Object r12 = kotlin.Result.b(r12)
        L_0x0102:
            r3 = r1
            java.lang.Throwable r1 = kotlin.Result.e(r12)
            if (r1 == 0) goto L_0x0121
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Unity Ads Init: Could not load config file from local storage: "
            r4.append(r5)
            java.lang.String r1 = r1.getMessage()
            r4.append(r1)
            java.lang.String r1 = r4.toString()
            com.unity3d.services.core.log.DeviceLog.debug(r1)
        L_0x0121:
            com.unity3d.services.core.configuration.Configuration r1 = new com.unity3d.services.core.configuration.Configuration
            r1.<init>()
            boolean r4 = kotlin.Result.g(r12)
            if (r4 == 0) goto L_0x012d
            r12 = r1
        L_0x012d:
            r1 = r12
            com.unity3d.services.core.configuration.Configuration r1 = (com.unity3d.services.core.configuration.Configuration) r1
            com.unity3d.services.core.domain.task.InitializeSDK r12 = r11.this$0
            com.unity3d.services.core.domain.task.InitializeStateReset r12 = r12.initializeStateReset     // Catch:{ all -> 0x00b5 }
            com.unity3d.services.core.domain.task.InitializeStateReset$Params r4 = new com.unity3d.services.core.domain.task.InitializeStateReset$Params     // Catch:{ all -> 0x00b5 }
            r4.<init>(r1)     // Catch:{ all -> 0x00b5 }
            r11.L$0 = r3     // Catch:{ all -> 0x00b5 }
            r11.L$1 = r1     // Catch:{ all -> 0x00b5 }
            r5 = 2
            r11.label = r5     // Catch:{ all -> 0x00b5 }
            java.lang.Object r12 = r12.invoke(r4, r11)     // Catch:{ all -> 0x00b5 }
            if (r12 != r0) goto L_0x0149
            return r0
        L_0x0149:
            com.unity3d.services.core.configuration.Configuration r12 = (com.unity3d.services.core.configuration.Configuration) r12     // Catch:{ all -> 0x00b5 }
            java.lang.Object r12 = kotlin.Result.b(r12)     // Catch:{ all -> 0x00b5 }
            goto L_0x015a
        L_0x0150:
            kotlin.Result$Companion r4 = kotlin.Result.f40263c
            java.lang.Object r12 = kotlin.ResultKt.a(r12)
            java.lang.Object r12 = kotlin.Result.b(r12)
        L_0x015a:
            boolean r4 = kotlin.Result.g(r12)
            if (r4 == 0) goto L_0x0189
            com.unity3d.services.core.domain.task.InitializeSDK r3 = r11.this$0
            com.unity3d.services.core.configuration.ErrorState r4 = com.unity3d.services.core.configuration.ErrorState.ResetWebApp
            java.lang.Throwable r5 = kotlin.Result.e(r12)
            r11.L$0 = r12
            r11.L$1 = r2
            r2 = 3
            r11.label = r2
            java.lang.Object r1 = r3.executeErrorState(r4, r5, r1, r11)
            if (r1 != r0) goto L_0x0176
            return r0
        L_0x0176:
            r0 = r12
        L_0x0177:
            java.lang.Throwable r12 = kotlin.Result.e(r0)
            if (r12 != 0) goto L_0x0188
            java.lang.Exception r12 = new java.lang.Exception
            com.unity3d.services.core.configuration.ErrorState r0 = com.unity3d.services.core.configuration.ErrorState.ResetWebApp
            java.lang.String r0 = r0.toString()
            r12.<init>(r0)
        L_0x0188:
            throw r12
        L_0x0189:
            com.unity3d.services.core.domain.task.InitializeSDK r12 = r11.this$0
            com.unity3d.services.core.domain.task.InitializeStateConfig r12 = r12.initializeStateConfig     // Catch:{ all -> 0x009e }
            com.unity3d.services.core.domain.task.InitializeStateConfig$Params r4 = new com.unity3d.services.core.domain.task.InitializeStateConfig$Params     // Catch:{ all -> 0x009e }
            r4.<init>(r1)     // Catch:{ all -> 0x009e }
            r11.L$0 = r3     // Catch:{ all -> 0x009e }
            r11.L$1 = r1     // Catch:{ all -> 0x009e }
            r5 = 4
            r11.label = r5     // Catch:{ all -> 0x009e }
            java.lang.Object r12 = r12.invoke(r4, r11)     // Catch:{ all -> 0x009e }
            if (r12 != r0) goto L_0x01a2
            return r0
        L_0x01a2:
            com.unity3d.services.core.configuration.Configuration r12 = (com.unity3d.services.core.configuration.Configuration) r12     // Catch:{ all -> 0x009e }
            java.lang.Object r12 = kotlin.Result.b(r12)     // Catch:{ all -> 0x009e }
            goto L_0x01b3
        L_0x01a9:
            kotlin.Result$Companion r4 = kotlin.Result.f40263c
            java.lang.Object r12 = kotlin.ResultKt.a(r12)
            java.lang.Object r12 = kotlin.Result.b(r12)
        L_0x01b3:
            r4 = r3
            r3 = r1
            r1 = r12
            boolean r12 = kotlin.Result.g(r1)
            if (r12 == 0) goto L_0x01d2
            com.unity3d.services.core.domain.task.InitializeSDK r12 = r11.this$0
            com.unity3d.services.core.domain.task.InitializationException r5 = com.unity3d.services.core.domain.ResultExtensionsKt.getInitializationExceptionOrThrow(r1)
            r11.L$0 = r4
            r11.L$1 = r3
            r11.L$2 = r1
            r6 = 5
            r11.label = r6
            java.lang.Object r12 = r12.handleInitializationException(r5, r11)
            if (r12 != r0) goto L_0x01d2
            return r0
        L_0x01d2:
            com.unity3d.services.core.configuration.IExperiments r12 = r3.getExperiments()
            boolean r12 = r12.isNativeWebViewCacheEnabled()
            if (r12 == 0) goto L_0x0250
            com.unity3d.services.core.domain.task.InitializeSDK r12 = r11.this$0
            kotlin.Result$Companion r5 = kotlin.Result.f40263c     // Catch:{ all -> 0x007f }
            com.unity3d.services.core.domain.task.InitializeStateCreateWithRemote r12 = r12.initializeStateCreateWithRemote     // Catch:{ all -> 0x007f }
            com.unity3d.services.core.domain.task.InitializeStateCreateWithRemote$Params r5 = new com.unity3d.services.core.domain.task.InitializeStateCreateWithRemote$Params     // Catch:{ all -> 0x007f }
            kotlin.ResultKt.b(r1)     // Catch:{ all -> 0x007f }
            r6 = r1
            com.unity3d.services.core.configuration.Configuration r6 = (com.unity3d.services.core.configuration.Configuration) r6     // Catch:{ all -> 0x007f }
            r5.<init>(r6)     // Catch:{ all -> 0x007f }
            r11.L$0 = r4     // Catch:{ all -> 0x007f }
            r11.L$1 = r3     // Catch:{ all -> 0x007f }
            r11.L$2 = r1     // Catch:{ all -> 0x007f }
            r6 = 6
            r11.label = r6     // Catch:{ all -> 0x007f }
            java.lang.Object r12 = r12.invoke(r5, r11)     // Catch:{ all -> 0x007f }
            if (r12 != r0) goto L_0x01ff
            return r0
        L_0x01ff:
            com.unity3d.services.core.configuration.Configuration r12 = (com.unity3d.services.core.configuration.Configuration) r12     // Catch:{ all -> 0x007f }
            java.lang.Object r12 = kotlin.Result.b(r12)     // Catch:{ all -> 0x007f }
            goto L_0x0210
        L_0x0206:
            kotlin.Result$Companion r5 = kotlin.Result.f40263c
            java.lang.Object r12 = kotlin.ResultKt.a(r12)
            java.lang.Object r12 = kotlin.Result.b(r12)
        L_0x0210:
            boolean r5 = kotlin.Result.h(r12)
            if (r5 == 0) goto L_0x0239
            com.unity3d.services.core.domain.task.InitializeSDK r12 = r11.this$0
            com.unity3d.services.core.domain.task.InitializeStateComplete r12 = r12.initializeStateComplete
            com.unity3d.services.core.domain.task.InitializeStateComplete$Params r3 = new com.unity3d.services.core.domain.task.InitializeStateComplete$Params
            kotlin.ResultKt.b(r1)
            com.unity3d.services.core.configuration.Configuration r1 = (com.unity3d.services.core.configuration.Configuration) r1
            r3.<init>(r1)
            r11.L$0 = r2
            r11.L$1 = r2
            r11.L$2 = r2
            r1 = 7
            r11.label = r1
            java.lang.Object r12 = r12.invoke(r3, r11)
            if (r12 != r0) goto L_0x0236
            return r0
        L_0x0236:
            kotlin.Unit r12 = kotlin.Unit.f40298a
            return r12
        L_0x0239:
            com.unity3d.services.core.domain.task.InitializeSDK r5 = r11.this$0
            com.unity3d.services.core.domain.task.InitializationException r12 = com.unity3d.services.core.domain.ResultExtensionsKt.getInitializationExceptionOrThrow(r12)
            r11.L$0 = r4
            r11.L$1 = r3
            r11.L$2 = r1
            r6 = 8
            r11.label = r6
            java.lang.Object r12 = r5.handleInitializationException(r12, r11)
            if (r12 != r0) goto L_0x0250
            return r0
        L_0x0250:
            com.unity3d.services.core.domain.task.InitializeSDK r12 = r11.this$0
            kotlin.Result$Companion r5 = kotlin.Result.f40263c     // Catch:{ all -> 0x0059 }
            com.unity3d.services.core.domain.task.InitializeStateLoadCache r12 = r12.initializeStateLoadCache     // Catch:{ all -> 0x0059 }
            com.unity3d.services.core.domain.task.InitializeStateLoadCache$Params r5 = new com.unity3d.services.core.domain.task.InitializeStateLoadCache$Params     // Catch:{ all -> 0x0059 }
            kotlin.ResultKt.b(r1)     // Catch:{ all -> 0x0059 }
            r6 = r1
            com.unity3d.services.core.configuration.Configuration r6 = (com.unity3d.services.core.configuration.Configuration) r6     // Catch:{ all -> 0x0059 }
            r5.<init>(r6)     // Catch:{ all -> 0x0059 }
            r11.L$0 = r4     // Catch:{ all -> 0x0059 }
            r11.L$1 = r3     // Catch:{ all -> 0x0059 }
            r11.L$2 = r1     // Catch:{ all -> 0x0059 }
            r6 = 9
            r11.label = r6     // Catch:{ all -> 0x0059 }
            java.lang.Object r12 = r12.invoke(r5, r11)     // Catch:{ all -> 0x0059 }
            if (r12 != r0) goto L_0x0274
            return r0
        L_0x0274:
            com.unity3d.services.core.domain.task.InitializeStateLoadCache$LoadCacheResult r12 = (com.unity3d.services.core.domain.task.InitializeStateLoadCache.LoadCacheResult) r12     // Catch:{ all -> 0x0059 }
            java.lang.Object r12 = kotlin.Result.b(r12)     // Catch:{ all -> 0x0059 }
            goto L_0x0285
        L_0x027b:
            kotlin.Result$Companion r5 = kotlin.Result.f40263c
            java.lang.Object r12 = kotlin.ResultKt.a(r12)
            java.lang.Object r12 = kotlin.Result.b(r12)
        L_0x0285:
            boolean r5 = kotlin.Result.g(r12)
            if (r5 == 0) goto L_0x02b7
            com.unity3d.services.core.domain.task.InitializeSDK r1 = r11.this$0
            com.unity3d.services.core.configuration.ErrorState r4 = com.unity3d.services.core.configuration.ErrorState.LoadCache
            java.lang.Throwable r5 = kotlin.Result.e(r12)
            r11.L$0 = r12
            r11.L$1 = r2
            r11.L$2 = r2
            r2 = 10
            r11.label = r2
            java.lang.Object r1 = r1.executeErrorState(r4, r5, r3, r11)
            if (r1 != r0) goto L_0x02a4
            return r0
        L_0x02a4:
            r0 = r12
        L_0x02a5:
            java.lang.Throwable r12 = kotlin.Result.e(r0)
            if (r12 != 0) goto L_0x02b6
            java.lang.Exception r12 = new java.lang.Exception
            com.unity3d.services.core.configuration.ErrorState r0 = com.unity3d.services.core.configuration.ErrorState.LoadCache
            java.lang.String r0 = r0.toString()
            r12.<init>(r0)
        L_0x02b6:
            throw r12
        L_0x02b7:
            kotlin.ResultKt.b(r12)
            com.unity3d.services.core.domain.task.InitializeStateLoadCache$LoadCacheResult r12 = (com.unity3d.services.core.domain.task.InitializeStateLoadCache.LoadCacheResult) r12
            boolean r5 = r12.getHasHashMismatch()
            if (r5 == 0) goto L_0x0351
            com.unity3d.services.core.configuration.IExperiments r3 = r3.getExperiments()
            boolean r3 = r3.isWebViewAsyncDownloadEnabled()
            if (r3 == 0) goto L_0x02ec
            java.lang.String r3 = r12.getWebViewData()
            if (r3 == 0) goto L_0x02ec
            kotlinx.coroutines.CoroutineName r5 = new kotlinx.coroutines.CoroutineName
            java.lang.String r3 = "LaunchLoadWeb"
            r5.<init>(r3)
            r6 = 0
            com.unity3d.services.core.domain.task.InitializeSDK$doWork$2$webViewData$1 r7 = new com.unity3d.services.core.domain.task.InitializeSDK$doWork$2$webViewData$1
            com.unity3d.services.core.domain.task.InitializeSDK r3 = r11.this$0
            r7.<init>(r3, r1, r2)
            r8 = 2
            r9 = 0
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.b(r4, r5, r6, r7, r8, r9)
            java.lang.String r12 = r12.getWebViewData()
            goto L_0x0357
        L_0x02ec:
            com.unity3d.services.core.domain.task.InitializeSDK r12 = r11.this$0
            com.unity3d.services.core.domain.task.InitializeStateLoadWeb r12 = r12.initializeStateLoadWeb     // Catch:{ all -> 0x0316 }
            com.unity3d.services.core.domain.task.InitializeStateLoadWeb$Params r3 = new com.unity3d.services.core.domain.task.InitializeStateLoadWeb$Params     // Catch:{ all -> 0x0316 }
            kotlin.ResultKt.b(r1)     // Catch:{ all -> 0x0316 }
            r5 = r1
            com.unity3d.services.core.configuration.Configuration r5 = (com.unity3d.services.core.configuration.Configuration) r5     // Catch:{ all -> 0x0316 }
            r3.<init>(r5)     // Catch:{ all -> 0x0316 }
            r11.L$0 = r4     // Catch:{ all -> 0x0316 }
            r11.L$1 = r1     // Catch:{ all -> 0x0316 }
            r11.L$2 = r2     // Catch:{ all -> 0x0316 }
            r5 = 11
            r11.label = r5     // Catch:{ all -> 0x0316 }
            java.lang.Object r12 = r12.invoke(r3, r11)     // Catch:{ all -> 0x0316 }
            if (r12 != r0) goto L_0x030e
            return r0
        L_0x030e:
            r3 = r4
        L_0x030f:
            com.unity3d.services.core.domain.task.InitializeStateLoadWeb$LoadWebResult r12 = (com.unity3d.services.core.domain.task.InitializeStateLoadWeb.LoadWebResult) r12     // Catch:{ all -> 0x0040 }
            java.lang.Object r12 = kotlin.Result.b(r12)     // Catch:{ all -> 0x0040 }
            goto L_0x0322
        L_0x0316:
            r12 = move-exception
            r3 = r4
        L_0x0318:
            kotlin.Result$Companion r4 = kotlin.Result.f40263c
            java.lang.Object r12 = kotlin.ResultKt.a(r12)
            java.lang.Object r12 = kotlin.Result.b(r12)
        L_0x0322:
            r10 = r1
            r1 = r12
            r12 = r10
            boolean r4 = kotlin.Result.g(r1)
            if (r4 == 0) goto L_0x0344
            com.unity3d.services.core.domain.task.InitializeSDK r4 = r11.this$0
            com.unity3d.services.core.domain.task.InitializationException r5 = com.unity3d.services.core.domain.ResultExtensionsKt.getInitializationExceptionOrThrow(r1)
            r11.L$0 = r3
            r11.L$1 = r12
            r11.L$2 = r1
            r3 = 12
            r11.label = r3
            java.lang.Object r3 = r4.handleInitializationException(r5, r11)
            if (r3 != r0) goto L_0x0342
            return r0
        L_0x0342:
            r3 = r12
        L_0x0343:
            r12 = r3
        L_0x0344:
            kotlin.ResultKt.b(r1)
            com.unity3d.services.core.domain.task.InitializeStateLoadWeb$LoadWebResult r1 = (com.unity3d.services.core.domain.task.InitializeStateLoadWeb.LoadWebResult) r1
            java.lang.String r1 = r1.getWebViewDataString()
            r10 = r1
            r1 = r12
            r12 = r10
            goto L_0x0357
        L_0x0351:
            java.lang.String r12 = r12.getWebViewData()
            if (r12 == 0) goto L_0x03cd
        L_0x0357:
            com.unity3d.services.core.domain.task.InitializeSDK r3 = r11.this$0
            kotlin.Result$Companion r4 = kotlin.Result.f40263c     // Catch:{ all -> 0x0025 }
            com.unity3d.services.core.domain.task.InitializeStateCreate r3 = r3.initializeStateCreate     // Catch:{ all -> 0x0025 }
            com.unity3d.services.core.domain.task.InitializeStateCreate$Params r4 = new com.unity3d.services.core.domain.task.InitializeStateCreate$Params     // Catch:{ all -> 0x0025 }
            kotlin.ResultKt.b(r1)     // Catch:{ all -> 0x0025 }
            r5 = r1
            com.unity3d.services.core.configuration.Configuration r5 = (com.unity3d.services.core.configuration.Configuration) r5     // Catch:{ all -> 0x0025 }
            r4.<init>(r5, r12)     // Catch:{ all -> 0x0025 }
            r11.L$0 = r1     // Catch:{ all -> 0x0025 }
            r11.L$1 = r2     // Catch:{ all -> 0x0025 }
            r11.L$2 = r2     // Catch:{ all -> 0x0025 }
            r12 = 13
            r11.label = r12     // Catch:{ all -> 0x0025 }
            java.lang.Object r12 = r3.invoke(r4, r11)     // Catch:{ all -> 0x0025 }
            if (r12 != r0) goto L_0x037b
            return r0
        L_0x037b:
            com.unity3d.services.core.configuration.Configuration r12 = (com.unity3d.services.core.configuration.Configuration) r12     // Catch:{ all -> 0x0025 }
            java.lang.Object r12 = kotlin.Result.b(r12)     // Catch:{ all -> 0x0025 }
            goto L_0x038c
        L_0x0382:
            kotlin.Result$Companion r3 = kotlin.Result.f40263c
            java.lang.Object r12 = kotlin.ResultKt.a(r12)
            java.lang.Object r12 = kotlin.Result.b(r12)
        L_0x038c:
            boolean r3 = kotlin.Result.g(r12)
            if (r3 == 0) goto L_0x03a9
            com.unity3d.services.core.domain.task.InitializeSDK r3 = r11.this$0
            com.unity3d.services.core.domain.task.InitializationException r12 = com.unity3d.services.core.domain.ResultExtensionsKt.getInitializationExceptionOrThrow(r12)
            r11.L$0 = r1
            r11.L$1 = r2
            r11.L$2 = r2
            r4 = 14
            r11.label = r4
            java.lang.Object r12 = r3.handleInitializationException(r12, r11)
            if (r12 != r0) goto L_0x03a9
            return r0
        L_0x03a9:
            com.unity3d.services.core.domain.task.InitializeSDK r12 = r11.this$0
            com.unity3d.services.core.domain.task.InitializeStateComplete r12 = r12.initializeStateComplete
            com.unity3d.services.core.domain.task.InitializeStateComplete$Params r3 = new com.unity3d.services.core.domain.task.InitializeStateComplete$Params
            kotlin.ResultKt.b(r1)
            com.unity3d.services.core.configuration.Configuration r1 = (com.unity3d.services.core.configuration.Configuration) r1
            r3.<init>(r1)
            r11.L$0 = r2
            r11.L$1 = r2
            r11.L$2 = r2
            r1 = 15
            r11.label = r1
            java.lang.Object r12 = r12.invoke(r3, r11)
            if (r12 != r0) goto L_0x03ca
            return r0
        L_0x03ca:
            kotlin.Unit r12 = kotlin.Unit.f40298a
            return r12
        L_0x03cd:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "WebView is missing."
            java.lang.String r0 = r0.toString()
            r12.<init>(r0)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.domain.task.InitializeSDK$doWork$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
