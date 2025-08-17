package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.domain.ISDKDispatchers;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

public final class InitializeStateCreateWithRemote extends MetricTask<Params, Configuration> {
    private final ISDKDispatchers dispatchers;

    public static final class Params implements BaseParams {
        private Configuration config;

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

        public final void setConfig(Configuration configuration) {
            Intrinsics.f(configuration, "<set-?>");
            this.config = configuration;
        }

        public String toString() {
            return "Params(config=" + this.config + ')';
        }
    }

    public InitializeStateCreateWithRemote(ISDKDispatchers iSDKDispatchers) {
        Intrinsics.f(iSDKDispatchers, "dispatchers");
        this.dispatchers = iSDKDispatchers;
    }

    public String getMetricName() {
        return getMetricNameForInitializeTask("create_web_view");
    }

    public Object doWork(Params params, Continuation<? super Configuration> continuation) {
        return BuildersKt.e(this.dispatchers.getDefault(), new InitializeStateCreateWithRemote$doWork$2(params, (Continuation<? super InitializeStateCreateWithRemote$doWork$2>) null), continuation);
    }
}
