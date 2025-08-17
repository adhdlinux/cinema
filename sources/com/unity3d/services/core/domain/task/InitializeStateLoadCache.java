package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.domain.ISDKDispatchers;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.misc.Utilities;
import com.unity3d.services.core.properties.SdkProperties;
import java.io.File;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

public final class InitializeStateLoadCache extends MetricTask<Params, LoadCacheResult> {
    private final ISDKDispatchers dispatchers;

    public static final class LoadCacheResult {
        private final boolean hasHashMismatch;
        private final String webViewData;

        public LoadCacheResult(boolean z2, String str) {
            this.hasHashMismatch = z2;
            this.webViewData = str;
        }

        public static /* synthetic */ LoadCacheResult copy$default(LoadCacheResult loadCacheResult, boolean z2, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                z2 = loadCacheResult.hasHashMismatch;
            }
            if ((i2 & 2) != 0) {
                str = loadCacheResult.webViewData;
            }
            return loadCacheResult.copy(z2, str);
        }

        public final boolean component1() {
            return this.hasHashMismatch;
        }

        public final String component2() {
            return this.webViewData;
        }

        public final LoadCacheResult copy(boolean z2, String str) {
            return new LoadCacheResult(z2, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LoadCacheResult)) {
                return false;
            }
            LoadCacheResult loadCacheResult = (LoadCacheResult) obj;
            return this.hasHashMismatch == loadCacheResult.hasHashMismatch && Intrinsics.a(this.webViewData, loadCacheResult.webViewData);
        }

        public final boolean getHasHashMismatch() {
            return this.hasHashMismatch;
        }

        public final String getWebViewData() {
            return this.webViewData;
        }

        public int hashCode() {
            boolean z2 = this.hasHashMismatch;
            if (z2) {
                z2 = true;
            }
            int i2 = (z2 ? 1 : 0) * true;
            String str = this.webViewData;
            return i2 + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "LoadCacheResult(hasHashMismatch=" + this.hasHashMismatch + ", webViewData=" + this.webViewData + ')';
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ LoadCacheResult(boolean z2, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(z2, (i2 & 2) != 0 ? null : str);
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

    public InitializeStateLoadCache(ISDKDispatchers iSDKDispatchers) {
        Intrinsics.f(iSDKDispatchers, "dispatchers");
        this.dispatchers = iSDKDispatchers;
    }

    /* access modifiers changed from: private */
    public final byte[] getWebViewData() {
        try {
            return Utilities.readFileBytes(new File(SdkProperties.getLocalWebViewFile()));
        } catch (Exception e2) {
            DeviceLog.debug("Unity Ads init: webapp not found in local cache: " + e2.getMessage());
            return null;
        }
    }

    public String getMetricName() {
        return getMetricNameForInitializeTask("read_local_webview");
    }

    public Object doWork(Params params, Continuation<? super LoadCacheResult> continuation) {
        return BuildersKt.e(this.dispatchers.getDefault(), new InitializeStateLoadCache$doWork$2(this, params, (Continuation<? super InitializeStateLoadCache$doWork$2>) null), continuation);
    }
}
