package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.domain.ISDKDispatchers;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

public final class InitializeStateCreate extends MetricTask<Params, Configuration> {
    private final ISDKDispatchers dispatchers;

    public static final class Params implements BaseParams {
        private final Configuration config;
        private final String webViewData;

        public Params(Configuration configuration, String str) {
            Intrinsics.f(configuration, "config");
            Intrinsics.f(str, "webViewData");
            this.config = configuration;
            this.webViewData = str;
        }

        public static /* synthetic */ Params copy$default(Params params, Configuration configuration, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                configuration = params.config;
            }
            if ((i2 & 2) != 0) {
                str = params.webViewData;
            }
            return params.copy(configuration, str);
        }

        public final Configuration component1() {
            return this.config;
        }

        public final String component2() {
            return this.webViewData;
        }

        public final Params copy(Configuration configuration, String str) {
            Intrinsics.f(configuration, "config");
            Intrinsics.f(str, "webViewData");
            return new Params(configuration, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Params)) {
                return false;
            }
            Params params = (Params) obj;
            return Intrinsics.a(this.config, params.config) && Intrinsics.a(this.webViewData, params.webViewData);
        }

        public final Configuration getConfig() {
            return this.config;
        }

        public final String getWebViewData() {
            return this.webViewData;
        }

        public int hashCode() {
            return (this.config.hashCode() * 31) + this.webViewData.hashCode();
        }

        public String toString() {
            return "Params(config=" + this.config + ", webViewData=" + this.webViewData + ')';
        }
    }

    public InitializeStateCreate(ISDKDispatchers iSDKDispatchers) {
        Intrinsics.f(iSDKDispatchers, "dispatchers");
        this.dispatchers = iSDKDispatchers;
    }

    public String getMetricName() {
        return getMetricNameForInitializeTask("create_web_view");
    }

    public Object doWork(Params params, Continuation<? super Configuration> continuation) {
        return BuildersKt.e(this.dispatchers.getDefault(), new InitializeStateCreate$doWork$2(params, (Continuation<? super InitializeStateCreate$doWork$2>) null), continuation);
    }
}
