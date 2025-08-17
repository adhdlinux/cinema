package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader$doWork$2", f = "InitializeStateConfigWithLoader.kt", l = {52, 94, 97}, m = "invokeSuspend")
final class InitializeStateConfigWithLoader$doWork$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Configuration>, Object> {
    final /* synthetic */ InitializeStateConfigWithLoader.Params $params;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ InitializeStateConfigWithLoader this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InitializeStateConfigWithLoader$doWork$2(InitializeStateConfigWithLoader.Params params, InitializeStateConfigWithLoader initializeStateConfigWithLoader, Continuation<? super InitializeStateConfigWithLoader$doWork$2> continuation) {
        super(2, continuation);
        this.$params = params;
        this.this$0 = initializeStateConfigWithLoader;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        InitializeStateConfigWithLoader$doWork$2 initializeStateConfigWithLoader$doWork$2 = new InitializeStateConfigWithLoader$doWork$2(this.$params, this.this$0, continuation);
        initializeStateConfigWithLoader$doWork$2.L$0 = obj;
        return initializeStateConfigWithLoader$doWork$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Configuration> continuation) {
        return ((InitializeStateConfigWithLoader$doWork$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f40298a);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v40, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v19, resolved type: kotlin.jvm.internal.Ref$ObjectRef} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v41, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v30, resolved type: kotlin.jvm.internal.Ref$ObjectRef} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v44, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v21, resolved type: kotlin.jvm.internal.Ref$ObjectRef} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v45, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v32, resolved type: kotlin.jvm.internal.Ref$ObjectRef} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v46, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v15, resolved type: kotlin.jvm.internal.Ref$ObjectRef} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0128  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x016c  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x01a5  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x01ca  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r18) {
        /*
            r17 = this;
            r9 = r17
            java.lang.Object r10 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.e()
            int r0 = r9.label
            r11 = 0
            r12 = 3
            r13 = 2
            r1 = 1
            if (r0 == 0) goto L_0x0056
            if (r0 == r1) goto L_0x0040
            if (r0 == r13) goto L_0x0029
            if (r0 != r12) goto L_0x0021
            java.lang.Object r0 = r9.L$1
            kotlin.jvm.internal.Ref$ObjectRef r0 = (kotlin.jvm.internal.Ref$ObjectRef) r0
            java.lang.Object r1 = r9.L$0
            kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref$ObjectRef) r1
            kotlin.ResultKt.b(r18)
            goto L_0x019b
        L_0x0021:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0029:
            java.lang.Object r0 = r9.L$2
            r1 = r0
            kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref$ObjectRef) r1
            java.lang.Object r0 = r9.L$1
            r2 = r0
            kotlin.jvm.internal.Ref$ObjectRef r2 = (kotlin.jvm.internal.Ref$ObjectRef) r2
            java.lang.Object r0 = r9.L$0
            r3 = r0
            kotlin.jvm.internal.Ref$ObjectRef r3 = (kotlin.jvm.internal.Ref$ObjectRef) r3
            kotlin.ResultKt.b(r18)     // Catch:{ all -> 0x003d }
            goto L_0x0152
        L_0x003d:
            r0 = move-exception
            goto L_0x015b
        L_0x0040:
            java.lang.Object r0 = r9.L$2
            r1 = r0
            kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref$ObjectRef) r1
            java.lang.Object r0 = r9.L$1
            r2 = r0
            kotlin.jvm.internal.Ref$ObjectRef r2 = (kotlin.jvm.internal.Ref$ObjectRef) r2
            java.lang.Object r0 = r9.L$0
            kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
            kotlin.ResultKt.b(r18)     // Catch:{ all -> 0x0053 }
            goto L_0x010d
        L_0x0053:
            r0 = move-exception
            goto L_0x0117
        L_0x0056:
            kotlin.ResultKt.b(r18)
            java.lang.Object r0 = r9.L$0
            kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
            com.unity3d.services.core.configuration.PrivacyConfigStorage r2 = com.unity3d.services.core.configuration.PrivacyConfigStorage.getInstance()
            com.unity3d.services.core.device.reader.DeviceInfoDataFactory r3 = new com.unity3d.services.core.device.reader.DeviceInfoDataFactory
            r3.<init>()
            kotlin.jvm.internal.Ref$ObjectRef r14 = new kotlin.jvm.internal.Ref$ObjectRef
            r14.<init>()
            com.unity3d.services.core.configuration.ConfigurationLoader r4 = new com.unity3d.services.core.configuration.ConfigurationLoader
            com.unity3d.services.core.configuration.ConfigurationRequestFactory r5 = new com.unity3d.services.core.configuration.ConfigurationRequestFactory
            com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader$Params r6 = r9.$params
            com.unity3d.services.core.configuration.Configuration r6 = r6.getConfig()
            com.unity3d.services.core.configuration.InitRequestType r7 = com.unity3d.services.core.configuration.InitRequestType.TOKEN
            com.unity3d.services.core.device.reader.IDeviceInfoDataContainer r7 = r3.getDeviceInfoData(r7)
            r5.<init>(r6, r7)
            com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader r6 = r9.this$0
            com.unity3d.services.core.di.IServiceProvider r6 = r6.getServiceProvider()
            com.unity3d.services.core.di.IServicesRegistry r6 = r6.getRegistry()
            java.lang.Class<com.unity3d.services.core.request.metrics.SDKMetricsSender> r7 = com.unity3d.services.core.request.metrics.SDKMetricsSender.class
            kotlin.reflect.KClass r7 = kotlin.jvm.internal.Reflection.b(r7)
            java.lang.String r8 = ""
            java.lang.Object r6 = r6.getService(r8, r7)
            com.unity3d.services.core.request.metrics.SDKMetricsSender r6 = (com.unity3d.services.core.request.metrics.SDKMetricsSender) r6
            r4.<init>(r5, r6)
            r14.f40429b = r4
            com.unity3d.services.core.configuration.PrivacyConfigurationLoader r5 = new com.unity3d.services.core.configuration.PrivacyConfigurationLoader
            com.unity3d.services.core.configuration.IConfigurationLoader r4 = (com.unity3d.services.core.configuration.IConfigurationLoader) r4
            com.unity3d.services.core.configuration.ConfigurationRequestFactory r6 = new com.unity3d.services.core.configuration.ConfigurationRequestFactory
            com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader$Params r7 = r9.$params
            com.unity3d.services.core.configuration.Configuration r7 = r7.getConfig()
            com.unity3d.services.core.configuration.InitRequestType r8 = com.unity3d.services.core.configuration.InitRequestType.PRIVACY
            com.unity3d.services.core.device.reader.IDeviceInfoDataContainer r3 = r3.getDeviceInfoData(r8)
            r6.<init>(r7, r3)
            r5.<init>(r4, r6, r2)
            r14.f40429b = r5
            kotlin.jvm.internal.Ref$ObjectRef r15 = new kotlin.jvm.internal.Ref$ObjectRef
            r15.<init>()
            com.unity3d.services.core.configuration.Configuration r2 = new com.unity3d.services.core.configuration.Configuration
            r2.<init>()
            r15.f40429b = r2
            com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader$Params r2 = r9.$params
            com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader r3 = r9.this$0
            kotlin.Result$Companion r4 = kotlin.Result.f40263c     // Catch:{ all -> 0x0114 }
            com.unity3d.services.core.configuration.Configuration r4 = r2.getConfig()     // Catch:{ all -> 0x0114 }
            int r4 = r4.getMaxRetries()     // Catch:{ all -> 0x0114 }
            com.unity3d.services.core.configuration.Configuration r5 = r2.getConfig()     // Catch:{ all -> 0x0114 }
            double r5 = r5.getRetryScalingFactor()     // Catch:{ all -> 0x0114 }
            com.unity3d.services.core.configuration.Configuration r7 = r2.getConfig()     // Catch:{ all -> 0x0114 }
            long r7 = r7.getRetryDelay()     // Catch:{ all -> 0x0114 }
            com.unity3d.services.core.domain.task.InitializationException r12 = new com.unity3d.services.core.domain.task.InitializationException     // Catch:{ all -> 0x0114 }
            com.unity3d.services.core.configuration.ErrorState r13 = com.unity3d.services.core.configuration.ErrorState.NetworkConfigRequest     // Catch:{ all -> 0x0114 }
            java.lang.Exception r1 = new java.lang.Exception     // Catch:{ all -> 0x0114 }
            r1.<init>()     // Catch:{ all -> 0x0114 }
            com.unity3d.services.core.configuration.Configuration r2 = r2.getConfig()     // Catch:{ all -> 0x0114 }
            r12.<init>(r13, r1, r2)     // Catch:{ all -> 0x0114 }
            com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader$doWork$2$configResult$1$1 r13 = new com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader$doWork$2$configResult$1$1     // Catch:{ all -> 0x0114 }
            r13.<init>(r3, r14, r15, r11)     // Catch:{ all -> 0x0114 }
            r9.L$0 = r0     // Catch:{ all -> 0x0114 }
            r9.L$1 = r14     // Catch:{ all -> 0x0114 }
            r9.L$2 = r15     // Catch:{ all -> 0x0114 }
            r0 = 1
            r9.label = r0     // Catch:{ all -> 0x0114 }
            r1 = r7
            r3 = r4
            r4 = r5
            r6 = r12
            r7 = r13
            r8 = r17
            java.lang.Object r0 = com.unity3d.services.core.extensions.TaskExtensionsKt.withRetry(r1, r3, r4, r6, r7, r8)     // Catch:{ all -> 0x0114 }
            if (r0 != r10) goto L_0x010b
            return r10
        L_0x010b:
            r2 = r14
            r1 = r15
        L_0x010d:
            kotlin.Unit r0 = kotlin.Unit.f40298a     // Catch:{ all -> 0x0053 }
            java.lang.Object r0 = kotlin.Result.b(r0)     // Catch:{ all -> 0x0053 }
            goto L_0x0121
        L_0x0114:
            r0 = move-exception
            r2 = r14
            r1 = r15
        L_0x0117:
            kotlin.Result$Companion r3 = kotlin.Result.f40263c
            java.lang.Object r0 = kotlin.ResultKt.a(r0)
            java.lang.Object r0 = kotlin.Result.b(r0)
        L_0x0121:
            r3 = r2
            boolean r2 = kotlin.Result.g(r0)
            if (r2 == 0) goto L_0x01ca
            java.lang.Throwable r0 = kotlin.Result.e(r0)
            boolean r2 = r0 instanceof com.unity3d.services.core.extensions.AbortRetryException
            if (r2 != 0) goto L_0x01ba
            com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader r0 = r9.this$0
            com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader$Params r2 = r9.$params
            com.unity3d.services.core.domain.task.InitializeStateNetworkError r0 = r0.initializeStateNetworkError     // Catch:{ all -> 0x0159 }
            com.unity3d.services.core.domain.task.InitializeStateNetworkError$Params r4 = new com.unity3d.services.core.domain.task.InitializeStateNetworkError$Params     // Catch:{ all -> 0x0159 }
            com.unity3d.services.core.configuration.Configuration r2 = r2.getConfig()     // Catch:{ all -> 0x0159 }
            r4.<init>(r2)     // Catch:{ all -> 0x0159 }
            r9.L$0 = r3     // Catch:{ all -> 0x0159 }
            r9.L$1 = r1     // Catch:{ all -> 0x0159 }
            r9.L$2 = r1     // Catch:{ all -> 0x0159 }
            r2 = 2
            r9.label = r2     // Catch:{ all -> 0x0159 }
            java.lang.Object r0 = r0.invoke(r4, r9)     // Catch:{ all -> 0x0159 }
            if (r0 != r10) goto L_0x0151
            return r10
        L_0x0151:
            r2 = r1
        L_0x0152:
            kotlin.Unit r0 = kotlin.Unit.f40298a     // Catch:{ all -> 0x003d }
            java.lang.Object r0 = kotlin.Result.b(r0)     // Catch:{ all -> 0x003d }
            goto L_0x0165
        L_0x0159:
            r0 = move-exception
            r2 = r1
        L_0x015b:
            kotlin.Result$Companion r4 = kotlin.Result.f40263c
            java.lang.Object r0 = kotlin.ResultKt.a(r0)
            java.lang.Object r0 = kotlin.Result.b(r0)
        L_0x0165:
            r8 = r2
            boolean r0 = kotlin.Result.h(r0)
            if (r0 == 0) goto L_0x01a5
            com.unity3d.services.core.configuration.IInitializeEventsMetricSender r0 = com.unity3d.services.core.configuration.InitializeEventsMetricSender.getInstance()
            r0.onRetryConfig()
            com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader r0 = r9.this$0
            com.unity3d.services.core.domain.ISDKDispatchers r0 = r0.dispatchers
            kotlinx.coroutines.CoroutineDispatcher r0 = r0.getIo()
            com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader$doWork$2$1 r12 = new com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader$doWork$2$1
            com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader r5 = r9.this$0
            com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader$Params r6 = r9.$params
            r7 = 0
            r2 = r12
            r4 = r8
            r2.<init>(r3, r4, r5, r6, r7)
            r9.L$0 = r8
            r9.L$1 = r1
            r9.L$2 = r11
            r2 = 3
            r9.label = r2
            java.lang.Object r0 = kotlinx.coroutines.BuildersKt.e(r0, r12, r9)
            if (r0 != r10) goto L_0x0199
            return r10
        L_0x0199:
            r0 = r1
            r1 = r8
        L_0x019b:
            T r2 = r1.f40429b
            com.unity3d.services.core.configuration.Configuration r2 = (com.unity3d.services.core.configuration.Configuration) r2
            r16 = r1
            r1 = r0
            r0 = r16
            goto L_0x01d0
        L_0x01a5:
            com.unity3d.services.core.domain.task.InitializationException r0 = new com.unity3d.services.core.domain.task.InitializationException
            com.unity3d.services.core.configuration.ErrorState r1 = com.unity3d.services.core.configuration.ErrorState.NetworkConfigRequest
            java.lang.Exception r2 = new java.lang.Exception
            java.lang.String r3 = "No connected events within the timeout!"
            r2.<init>(r3)
            com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader$Params r3 = r9.$params
            com.unity3d.services.core.configuration.Configuration r3 = r3.getConfig()
            r0.<init>(r1, r2, r3)
            throw r0
        L_0x01ba:
            com.unity3d.services.core.domain.task.InitializationException r1 = new com.unity3d.services.core.domain.task.InitializationException
            com.unity3d.services.core.configuration.ErrorState r2 = com.unity3d.services.core.configuration.ErrorState.NetworkConfigRequest
            java.lang.Exception r0 = (java.lang.Exception) r0
            com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader$Params r3 = r9.$params
            com.unity3d.services.core.configuration.Configuration r3 = r3.getConfig()
            r1.<init>(r2, r0, r3)
            throw r1
        L_0x01ca:
            T r0 = r1.f40429b
            r2 = r0
            com.unity3d.services.core.configuration.Configuration r2 = (com.unity3d.services.core.configuration.Configuration) r2
            r0 = r1
        L_0x01d0:
            r1.f40429b = r2
            T r0 = r0.f40429b
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader$doWork$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
