package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.configuration.ErrorState;
import com.unity3d.services.core.domain.ISDKDispatchers;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

public final class InitializeStateError extends MetricTask<Params, Unit> {
    private final ISDKDispatchers dispatchers;

    public static final class Params implements BaseParams {
        private final Configuration config;
        private final ErrorState errorState;
        private final Exception exception;

        public Params(ErrorState errorState2, Exception exc, Configuration configuration) {
            Intrinsics.f(errorState2, "errorState");
            Intrinsics.f(exc, "exception");
            Intrinsics.f(configuration, "config");
            this.errorState = errorState2;
            this.exception = exc;
            this.config = configuration;
        }

        public static /* synthetic */ Params copy$default(Params params, ErrorState errorState2, Exception exc, Configuration configuration, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                errorState2 = params.errorState;
            }
            if ((i2 & 2) != 0) {
                exc = params.exception;
            }
            if ((i2 & 4) != 0) {
                configuration = params.config;
            }
            return params.copy(errorState2, exc, configuration);
        }

        public final ErrorState component1() {
            return this.errorState;
        }

        public final Exception component2() {
            return this.exception;
        }

        public final Configuration component3() {
            return this.config;
        }

        public final Params copy(ErrorState errorState2, Exception exc, Configuration configuration) {
            Intrinsics.f(errorState2, "errorState");
            Intrinsics.f(exc, "exception");
            Intrinsics.f(configuration, "config");
            return new Params(errorState2, exc, configuration);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Params)) {
                return false;
            }
            Params params = (Params) obj;
            return this.errorState == params.errorState && Intrinsics.a(this.exception, params.exception) && Intrinsics.a(this.config, params.config);
        }

        public final Configuration getConfig() {
            return this.config;
        }

        public final ErrorState getErrorState() {
            return this.errorState;
        }

        public final Exception getException() {
            return this.exception;
        }

        public int hashCode() {
            return (((this.errorState.hashCode() * 31) + this.exception.hashCode()) * 31) + this.config.hashCode();
        }

        public String toString() {
            return "Params(errorState=" + this.errorState + ", exception=" + this.exception + ", config=" + this.config + ')';
        }
    }

    public InitializeStateError(ISDKDispatchers iSDKDispatchers) {
        Intrinsics.f(iSDKDispatchers, "dispatchers");
        this.dispatchers = iSDKDispatchers;
    }

    public String getMetricName() {
        return getMetricNameForInitializeTask(MRAIDPresenter.ERROR);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object doWork(com.unity3d.services.core.domain.task.InitializeStateError.Params r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.unity3d.services.core.domain.task.InitializeStateError$doWork$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.unity3d.services.core.domain.task.InitializeStateError$doWork$1 r0 = (com.unity3d.services.core.domain.task.InitializeStateError$doWork$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.unity3d.services.core.domain.task.InitializeStateError$doWork$1 r0 = new com.unity3d.services.core.domain.task.InitializeStateError$doWork$1
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.e()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.b(r7)
            goto L_0x0049
        L_0x0029:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0031:
            kotlin.ResultKt.b(r7)
            com.unity3d.services.core.domain.ISDKDispatchers r7 = r5.dispatchers
            kotlinx.coroutines.CoroutineDispatcher r7 = r7.getDefault()
            com.unity3d.services.core.domain.task.InitializeStateError$doWork$2 r2 = new com.unity3d.services.core.domain.task.InitializeStateError$doWork$2
            r4 = 0
            r2.<init>(r6, r4)
            r0.label = r3
            java.lang.Object r6 = kotlinx.coroutines.BuildersKt.e(r7, r2, r0)
            if (r6 != r1) goto L_0x0049
            return r1
        L_0x0049:
            kotlin.Unit r6 = kotlin.Unit.f40298a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.domain.task.InitializeStateError.doWork(com.unity3d.services.core.domain.task.InitializeStateError$Params, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
