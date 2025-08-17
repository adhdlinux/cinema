package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.domain.ISDKDispatchers;
import com.unity3d.services.core.network.core.HttpClient;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

public final class InitializeStateLoadWeb extends MetricTask<Params, LoadWebResult> {
    /* access modifiers changed from: private */
    public final ISDKDispatchers dispatchers;
    /* access modifiers changed from: private */
    public final HttpClient httpClient;
    /* access modifiers changed from: private */
    public final InitializeStateNetworkError initializeStateNetworkError;

    public static final class LoadWebResult {
        private final Configuration config;
        private final String webViewDataString;

        public LoadWebResult(Configuration configuration, String str) {
            Intrinsics.f(configuration, "config");
            Intrinsics.f(str, "webViewDataString");
            this.config = configuration;
            this.webViewDataString = str;
        }

        public static /* synthetic */ LoadWebResult copy$default(LoadWebResult loadWebResult, Configuration configuration, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                configuration = loadWebResult.config;
            }
            if ((i2 & 2) != 0) {
                str = loadWebResult.webViewDataString;
            }
            return loadWebResult.copy(configuration, str);
        }

        public final Configuration component1() {
            return this.config;
        }

        public final String component2() {
            return this.webViewDataString;
        }

        public final LoadWebResult copy(Configuration configuration, String str) {
            Intrinsics.f(configuration, "config");
            Intrinsics.f(str, "webViewDataString");
            return new LoadWebResult(configuration, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LoadWebResult)) {
                return false;
            }
            LoadWebResult loadWebResult = (LoadWebResult) obj;
            return Intrinsics.a(this.config, loadWebResult.config) && Intrinsics.a(this.webViewDataString, loadWebResult.webViewDataString);
        }

        public final Configuration getConfig() {
            return this.config;
        }

        public final String getWebViewDataString() {
            return this.webViewDataString;
        }

        public int hashCode() {
            return (this.config.hashCode() * 31) + this.webViewDataString.hashCode();
        }

        public String toString() {
            return "LoadWebResult(config=" + this.config + ", webViewDataString=" + this.webViewDataString + ')';
        }
    }

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

    public InitializeStateLoadWeb(ISDKDispatchers iSDKDispatchers, InitializeStateNetworkError initializeStateNetworkError2, HttpClient httpClient2) {
        Intrinsics.f(iSDKDispatchers, "dispatchers");
        Intrinsics.f(initializeStateNetworkError2, "initializeStateNetworkError");
        Intrinsics.f(httpClient2, "httpClient");
        this.dispatchers = iSDKDispatchers;
        this.initializeStateNetworkError = initializeStateNetworkError2;
        this.httpClient = httpClient2;
    }

    public String getMetricName() {
        return getMetricNameForInitializeTask("download_web_view");
    }

    public Object doWork(Params params, Continuation<? super LoadWebResult> continuation) {
        return BuildersKt.e(this.dispatchers.getDefault(), new InitializeStateLoadWeb$doWork$2(params, this, (Continuation<? super InitializeStateLoadWeb$doWork$2>) null), continuation);
    }
}
