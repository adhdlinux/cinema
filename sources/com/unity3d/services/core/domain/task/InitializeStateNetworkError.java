package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.connectivity.ConnectivityMonitor;
import com.unity3d.services.core.connectivity.IConnectivityListener;
import com.unity3d.services.core.domain.ISDKDispatchers;
import com.unity3d.services.core.log.DeviceLog;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

public final class InitializeStateNetworkError extends MetricTask<Params, Unit> implements IConnectivityListener {
    /* access modifiers changed from: private */
    public int connectedEventThreshold = 10000;
    private Continuation<? super Unit> continuation;
    private final ISDKDispatchers dispatchers;
    private long lastConnectedEventTimeMs;
    /* access modifiers changed from: private */
    public int maximumConnectedEvents = 500;
    private int receivedConnectedEvents;

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

    public InitializeStateNetworkError(ISDKDispatchers iSDKDispatchers) {
        Intrinsics.f(iSDKDispatchers, "dispatchers");
        this.dispatchers = iSDKDispatchers;
    }

    private final boolean shouldHandleConnectedEvent() {
        if (System.currentTimeMillis() - this.lastConnectedEventTimeMs < ((long) this.connectedEventThreshold) || this.receivedConnectedEvents > this.maximumConnectedEvents) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public final void startListening(Continuation<? super Unit> continuation2) {
        this.continuation = continuation2;
        ConnectivityMonitor.addListener(this);
    }

    public String getMetricName() {
        return getMetricNameForInitializeTask("error_network");
    }

    public void onConnected() {
        this.receivedConnectedEvents++;
        DeviceLog.debug("Unity Ads init got connected event");
        if (shouldHandleConnectedEvent()) {
            Continuation<? super Unit> continuation2 = this.continuation;
            if (continuation2 != null) {
                Result.Companion companion = Result.f40263c;
                continuation2.resumeWith(Result.b(Unit.f40298a));
            }
            this.continuation = null;
        }
        if (this.receivedConnectedEvents > this.maximumConnectedEvents) {
            ConnectivityMonitor.removeListener(this);
        }
        this.lastConnectedEventTimeMs = System.currentTimeMillis();
    }

    public void onDisconnected() {
        DeviceLog.debug("Unity Ads init got disconnected event");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object doWork(com.unity3d.services.core.domain.task.InitializeStateNetworkError.Params r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.unity3d.services.core.domain.task.InitializeStateNetworkError$doWork$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.unity3d.services.core.domain.task.InitializeStateNetworkError$doWork$1 r0 = (com.unity3d.services.core.domain.task.InitializeStateNetworkError$doWork$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.unity3d.services.core.domain.task.InitializeStateNetworkError$doWork$1 r0 = new com.unity3d.services.core.domain.task.InitializeStateNetworkError$doWork$1
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
            com.unity3d.services.core.domain.task.InitializeStateNetworkError$doWork$2 r2 = new com.unity3d.services.core.domain.task.InitializeStateNetworkError$doWork$2
            r4 = 0
            r2.<init>(r5, r6, r4)
            r0.label = r3
            java.lang.Object r6 = kotlinx.coroutines.BuildersKt.e(r7, r2, r0)
            if (r6 != r1) goto L_0x0049
            return r1
        L_0x0049:
            kotlin.Unit r6 = kotlin.Unit.f40298a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.domain.task.InitializeStateNetworkError.doWork(com.unity3d.services.core.domain.task.InitializeStateNetworkError$Params, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
