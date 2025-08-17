package com.google.android.gms.common.api.internal;

import android.os.SystemClock;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ConnectionTelemetryConfiguration;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.RootTelemetryConfigManager;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

final class zacd implements OnCompleteListener {
    private final GoogleApiManager zaa;
    private final int zab;
    private final ApiKey zac;
    private final long zad;
    private final long zae;

    @VisibleForTesting
    zacd(GoogleApiManager googleApiManager, int i2, ApiKey apiKey, long j2, long j3, String str, String str2) {
        this.zaa = googleApiManager;
        this.zab = i2;
        this.zac = apiKey;
        this.zad = j2;
        this.zae = j3;
    }

    static zacd zaa(GoogleApiManager googleApiManager, int i2, ApiKey apiKey) {
        boolean z2;
        long j2;
        long j3;
        if (!googleApiManager.zaF()) {
            return null;
        }
        RootTelemetryConfiguration config = RootTelemetryConfigManager.getInstance().getConfig();
        if (config == null) {
            z2 = true;
        } else if (!config.getMethodInvocationTelemetryEnabled()) {
            return null;
        } else {
            z2 = config.getMethodTimingTelemetryEnabled();
            zabq zak = googleApiManager.zak(apiKey);
            if (zak != null) {
                if (!(zak.zaf() instanceof BaseGmsClient)) {
                    return null;
                }
                BaseGmsClient baseGmsClient = (BaseGmsClient) zak.zaf();
                if (baseGmsClient.hasConnectionInfo() && !baseGmsClient.isConnecting()) {
                    ConnectionTelemetryConfiguration zab2 = zab(zak, baseGmsClient, i2);
                    if (zab2 == null) {
                        return null;
                    }
                    zak.zaq();
                    z2 = zab2.getMethodTimingTelemetryEnabled();
                }
            }
        }
        if (z2) {
            j2 = System.currentTimeMillis();
        } else {
            j2 = 0;
        }
        if (z2) {
            j3 = SystemClock.elapsedRealtime();
        } else {
            j3 = 0;
        }
        return new zacd(googleApiManager, i2, apiKey, j2, j3, (String) null, (String) null);
    }

    private static ConnectionTelemetryConfiguration zab(zabq zabq, BaseGmsClient baseGmsClient, int i2) {
        int[] methodInvocationMethodKeyAllowlist;
        int[] methodInvocationMethodKeyDisallowlist;
        ConnectionTelemetryConfiguration telemetryConfiguration = baseGmsClient.getTelemetryConfiguration();
        if (telemetryConfiguration == null || !telemetryConfiguration.getMethodInvocationTelemetryEnabled() || ((methodInvocationMethodKeyAllowlist = telemetryConfiguration.getMethodInvocationMethodKeyAllowlist()) != null ? !ArrayUtils.contains(methodInvocationMethodKeyAllowlist, i2) : !((methodInvocationMethodKeyDisallowlist = telemetryConfiguration.getMethodInvocationMethodKeyDisallowlist()) == null || !ArrayUtils.contains(methodInvocationMethodKeyDisallowlist, i2))) || zabq.zac() >= telemetryConfiguration.getMaxMethodInvocationsLogged()) {
            return null;
        }
        return telemetryConfiguration;
    }

    public final void onComplete(Task task) {
        zabq zak;
        boolean z2;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        long j2;
        long j3;
        int i8;
        if (this.zaa.zaF()) {
            RootTelemetryConfiguration config = RootTelemetryConfigManager.getInstance().getConfig();
            if ((config == null || config.getMethodInvocationTelemetryEnabled()) && (zak = this.zaa.zak(this.zac)) != null && (zak.zaf() instanceof BaseGmsClient)) {
                BaseGmsClient baseGmsClient = (BaseGmsClient) zak.zaf();
                boolean z3 = true;
                if (this.zad > 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                int gCoreServiceId = baseGmsClient.getGCoreServiceId();
                if (config != null) {
                    boolean methodTimingTelemetryEnabled = z2 & config.getMethodTimingTelemetryEnabled();
                    int batchPeriodMillis = config.getBatchPeriodMillis();
                    int maxMethodInvocationsInBatch = config.getMaxMethodInvocationsInBatch();
                    i4 = config.getVersion();
                    if (baseGmsClient.hasConnectionInfo() && !baseGmsClient.isConnecting()) {
                        ConnectionTelemetryConfiguration zab2 = zab(zak, baseGmsClient, this.zab);
                        if (zab2 != null) {
                            if (!zab2.getMethodTimingTelemetryEnabled() || this.zad <= 0) {
                                z3 = false;
                            }
                            maxMethodInvocationsInBatch = zab2.getMaxMethodInvocationsLogged();
                            methodTimingTelemetryEnabled = z3;
                        } else {
                            return;
                        }
                    }
                    i3 = batchPeriodMillis;
                    i2 = maxMethodInvocationsInBatch;
                } else {
                    i4 = 0;
                    i3 = 5000;
                    i2 = 100;
                }
                GoogleApiManager googleApiManager = this.zaa;
                if (task.isSuccessful()) {
                    i6 = 0;
                    i5 = 0;
                } else {
                    if (task.isCanceled()) {
                        i6 = 100;
                    } else {
                        Exception exception = task.getException();
                        if (exception instanceof ApiException) {
                            Status status = ((ApiException) exception).getStatus();
                            int statusCode = status.getStatusCode();
                            ConnectionResult connectionResult = status.getConnectionResult();
                            if (connectionResult == null) {
                                i8 = -1;
                            } else {
                                i8 = connectionResult.getErrorCode();
                            }
                            i5 = i8;
                            i6 = statusCode;
                        } else {
                            i6 = 101;
                        }
                    }
                    i5 = -1;
                }
                if (z2) {
                    long j4 = this.zad;
                    j2 = System.currentTimeMillis();
                    j3 = j4;
                    i7 = (int) (SystemClock.elapsedRealtime() - this.zae);
                } else {
                    j3 = 0;
                    j2 = 0;
                    i7 = -1;
                }
                googleApiManager.zay(new MethodInvocation(this.zab, i6, i5, j3, j2, (String) null, (String) null, gCoreServiceId, i7), i4, (long) i3, i2);
            }
        }
    }
}
