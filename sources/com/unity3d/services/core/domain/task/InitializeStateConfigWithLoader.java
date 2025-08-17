package com.unity3d.services.core.domain.task;

import com.unity3d.services.ads.token.TokenStorage;
import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.di.IServiceProvider;
import com.unity3d.services.core.domain.ISDKDispatchers;
import com.unity3d.services.core.domain.task.BaseTask;
import com.unity3d.services.core.request.metrics.SDKMetricsSender;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

public final class InitializeStateConfigWithLoader implements BaseTask<Params, Configuration> {
    /* access modifiers changed from: private */
    public final ISDKDispatchers dispatchers;
    /* access modifiers changed from: private */
    public final InitializeStateNetworkError initializeStateNetworkError;
    /* access modifiers changed from: private */
    public final SDKMetricsSender sdkMetricsSender;
    /* access modifiers changed from: private */
    public final TokenStorage tokenStorage;

    public static final class Params implements BaseParams {
        private final Configuration config;

        public Params(Configuration configuration) {
            Intrinsics.f(configuration, "config");
            this.config = configuration;
        }

        public static /* synthetic */ Params copy$default(Params params, Configuration configuration, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                configuration = params.config;
            }
            return params.copy(configuration);
        }

        public final Configuration component1() {
            return this.config;
        }

        public final Params copy(Configuration configuration) {
            Intrinsics.f(configuration, "config");
            return new Params(configuration);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Params) && Intrinsics.a(this.config, ((Params) obj).config);
        }

        public final Configuration getConfig() {
            return this.config;
        }

        public int hashCode() {
            return this.config.hashCode();
        }

        public String toString() {
            return "Params(config=" + this.config + ')';
        }
    }

    public InitializeStateConfigWithLoader(ISDKDispatchers iSDKDispatchers, InitializeStateNetworkError initializeStateNetworkError2, TokenStorage tokenStorage2, SDKMetricsSender sDKMetricsSender) {
        Intrinsics.f(iSDKDispatchers, "dispatchers");
        Intrinsics.f(initializeStateNetworkError2, "initializeStateNetworkError");
        Intrinsics.f(tokenStorage2, "tokenStorage");
        Intrinsics.f(sDKMetricsSender, "sdkMetricsSender");
        this.dispatchers = iSDKDispatchers;
        this.initializeStateNetworkError = initializeStateNetworkError2;
        this.tokenStorage = tokenStorage2;
        this.sdkMetricsSender = sDKMetricsSender;
    }

    public IServiceProvider getServiceProvider() {
        return BaseTask.DefaultImpls.getServiceProvider(this);
    }

    public Object doWork(Params params, Continuation<? super Configuration> continuation) {
        return BuildersKt.e(this.dispatchers.getDefault(), new InitializeStateConfigWithLoader$doWork$2(params, this, (Continuation<? super InitializeStateConfigWithLoader$doWork$2>) null), continuation);
    }

    public Object invoke(Params params, Continuation<? super Configuration> continuation) {
        return BaseTask.DefaultImpls.invoke(this, params, continuation);
    }
}
