package com.unity3d.services.core.domain.task;

import android.app.Application;
import com.unity3d.services.core.api.Lifecycle;
import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.domain.ISDKDispatchers;
import com.unity3d.services.core.lifecycle.LifecycleListener;
import com.unity3d.services.core.properties.ClientProperties;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

public class InitializeStateReset extends MetricTask<Params, Configuration> {
    /* access modifiers changed from: private */
    public final ISDKDispatchers dispatchers;

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

    public InitializeStateReset(ISDKDispatchers iSDKDispatchers) {
        Intrinsics.f(iSDKDispatchers, "dispatchers");
        this.dispatchers = iSDKDispatchers;
    }

    /* access modifiers changed from: private */
    public final void unregisterLifecycleCallbacks() {
        if (Lifecycle.getLifecycleListener() != null) {
            Application application = ClientProperties.getApplication();
            if (application != null) {
                application.unregisterActivityLifecycleCallbacks(Lifecycle.getLifecycleListener());
            }
            Lifecycle.setLifecycleListener((LifecycleListener) null);
        }
    }

    public Object doWork(Params params, Continuation<? super Configuration> continuation) {
        return BuildersKt.e(this.dispatchers.getDefault(), new InitializeStateReset$doWork$2(params, this, (Continuation<? super InitializeStateReset$doWork$2>) null), continuation);
    }

    public String getMetricName() {
        return getMetricNameForInitializeTask("reset");
    }
}
