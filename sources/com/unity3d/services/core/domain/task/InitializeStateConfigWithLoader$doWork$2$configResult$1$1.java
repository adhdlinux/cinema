package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.configuration.IConfigurationLoader;
import com.unity3d.services.core.configuration.IConfigurationLoaderListener;
import com.unity3d.services.core.configuration.InitializeEventsMetricSender;
import com.unity3d.services.core.extensions.AbortRetryException;
import com.unity3d.services.core.request.metrics.Metric;
import com.unity3d.services.core.request.metrics.SDKMetricsSender;
import com.unity3d.services.core.request.metrics.TSIMetric;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader$doWork$2$configResult$1$1", f = "InitializeStateConfigWithLoader.kt", l = {63}, m = "invokeSuspend")
final class InitializeStateConfigWithLoader$doWork$2$configResult$1$1 extends SuspendLambda implements Function2<Integer, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref$ObjectRef<Configuration> $config;
    final /* synthetic */ Ref$ObjectRef<IConfigurationLoader> $configurationLoader;
    /* synthetic */ int I$0;
    int label;
    final /* synthetic */ InitializeStateConfigWithLoader this$0;

    @DebugMetadata(c = "com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader$doWork$2$configResult$1$1$1", f = "InitializeStateConfigWithLoader.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader$doWork$2$configResult$1$1$1  reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(ref$ObjectRef, ref$ObjectRef2, initializeStateConfigWithLoader, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f40298a);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.e();
            if (this.label == 0) {
                ResultKt.b(obj);
                final Ref$ObjectRef<Configuration> ref$ObjectRef = ref$ObjectRef2;
                final InitializeStateConfigWithLoader initializeStateConfigWithLoader = initializeStateConfigWithLoader;
                ((IConfigurationLoader) ref$ObjectRef.f40429b).loadConfiguration(new IConfigurationLoaderListener() {
                    public void onError(String str) {
                        Intrinsics.f(str, "errorMsg");
                        SDKMetricsSender access$getSdkMetricsSender$p = initializeStateConfigWithLoader.sdkMetricsSender;
                        Metric newEmergencySwitchOff = TSIMetric.newEmergencySwitchOff();
                        Intrinsics.e(newEmergencySwitchOff, "newEmergencySwitchOff()");
                        access$getSdkMetricsSender$p.sendMetric(newEmergencySwitchOff);
                        throw new AbortRetryException(str);
                    }

                    public void onSuccess(Configuration configuration) {
                        Intrinsics.f(configuration, "configuration");
                        ref$ObjectRef.f40429b = configuration;
                        configuration.saveToDisk();
                        initializeStateConfigWithLoader.tokenStorage.setInitToken(((Configuration) ref$ObjectRef.f40429b).getUnifiedAuctionToken());
                    }
                });
                return Unit.f40298a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InitializeStateConfigWithLoader$doWork$2$configResult$1$1(InitializeStateConfigWithLoader initializeStateConfigWithLoader, Ref$ObjectRef<IConfigurationLoader> ref$ObjectRef, Ref$ObjectRef<Configuration> ref$ObjectRef2, Continuation<? super InitializeStateConfigWithLoader$doWork$2$configResult$1$1> continuation) {
        super(2, continuation);
        this.this$0 = initializeStateConfigWithLoader;
        this.$configurationLoader = ref$ObjectRef;
        this.$config = ref$ObjectRef2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        InitializeStateConfigWithLoader$doWork$2$configResult$1$1 initializeStateConfigWithLoader$doWork$2$configResult$1$1 = new InitializeStateConfigWithLoader$doWork$2$configResult$1$1(this.this$0, this.$configurationLoader, this.$config, continuation);
        initializeStateConfigWithLoader$doWork$2$configResult$1$1.I$0 = ((Number) obj).intValue();
        return initializeStateConfigWithLoader$doWork$2$configResult$1$1;
    }

    public final Object invoke(int i2, Continuation<? super Unit> continuation) {
        return ((InitializeStateConfigWithLoader$doWork$2$configResult$1$1) create(Integer.valueOf(i2), continuation)).invokeSuspend(Unit.f40298a);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke(((Number) obj).intValue(), (Continuation<? super Unit>) (Continuation) obj2);
    }

    public final Object invokeSuspend(Object obj) {
        Object e2 = IntrinsicsKt__IntrinsicsKt.e();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.b(obj);
            if (this.I$0 > 0) {
                InitializeEventsMetricSender.getInstance().onRetryConfig();
            }
            CoroutineDispatcher io2 = this.this$0.dispatchers.getIo();
            final Ref$ObjectRef<IConfigurationLoader> ref$ObjectRef = this.$configurationLoader;
            final Ref$ObjectRef<Configuration> ref$ObjectRef2 = this.$config;
            final InitializeStateConfigWithLoader initializeStateConfigWithLoader = this.this$0;
            AnonymousClass1 r12 = new AnonymousClass1((Continuation<? super AnonymousClass1>) null);
            this.label = 1;
            if (BuildersKt.e(io2, r12, this) == e2) {
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
