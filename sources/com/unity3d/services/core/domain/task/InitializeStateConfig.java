package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.domain.ISDKDispatchers;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

public final class InitializeStateConfig extends MetricTask<Params, Configuration> {
    private final ISDKDispatchers dispatchers;
    /* access modifiers changed from: private */
    public final InitializeStateConfigWithLoader initializeStateConfigWithLoader;

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

    public InitializeStateConfig(ISDKDispatchers iSDKDispatchers, InitializeStateConfigWithLoader initializeStateConfigWithLoader2) {
        Intrinsics.f(iSDKDispatchers, "dispatchers");
        Intrinsics.f(initializeStateConfigWithLoader2, "initializeStateConfigWithLoader");
        this.dispatchers = iSDKDispatchers;
        this.initializeStateConfigWithLoader = initializeStateConfigWithLoader2;
    }

    public String getMetricName() {
        return getMetricNameForInitializeTask("config_fetch");
    }

    public Object doWork(Params params, Continuation<? super Configuration> continuation) {
        return BuildersKt.e(this.dispatchers.getDefault(), new InitializeStateConfig$doWork$2(params, this, (Continuation<? super InitializeStateConfig$doWork$2>) null), continuation);
    }
}
