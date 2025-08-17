package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.di.IServiceProvider;
import com.unity3d.services.core.domain.ISDKDispatchers;
import com.unity3d.services.core.domain.task.BaseTask;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

public final class InitializeStateRetry implements BaseTask<Params, Result<? extends Unit>> {
    private final ISDKDispatchers dispatchers;

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

    public InitializeStateRetry(ISDKDispatchers iSDKDispatchers) {
        Intrinsics.f(iSDKDispatchers, "dispatchers");
        this.dispatchers = iSDKDispatchers;
    }

    /* renamed from: doWork-gIAlu-s  reason: not valid java name */
    public Object doWork(Params params, Continuation<? super Result<Unit>> continuation) {
        return BuildersKt.e(this.dispatchers.getDefault(), new InitializeStateRetry$doWork$2((Continuation<? super InitializeStateRetry$doWork$2>) null), continuation);
    }

    public IServiceProvider getServiceProvider() {
        return BaseTask.DefaultImpls.getServiceProvider(this);
    }

    /* renamed from: invoke-gIAlu-s  reason: not valid java name */
    public Object invoke(Params params, Continuation<? super Result<Unit>> continuation) {
        return BaseTask.DefaultImpls.invoke(this, params, continuation);
    }
}
