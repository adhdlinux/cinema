package com.vungle.ads;

import android.os.Build;
import com.vungle.ads.internal.executor.VungleThreadPoolExecutor;
import com.vungle.ads.internal.network.VungleApiClient;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import com.vungle.ads.internal.util.LogEntry;
import com.vungle.ads.internal.util.Logger;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class AnalyticsClient {
    public static final AnalyticsClient INSTANCE = new AnalyticsClient();
    private static final int MAX_BATCH_SIZE = 20;
    private static final long REFRESH_TIME_MILLIS = 5000;
    private static final String TAG = "AnalyticsClient";
    private static final BlockingQueue<Sdk$SDKError.Builder> errors = new LinkedBlockingQueue();
    private static VungleThreadPoolExecutor executor;
    private static LogLevel logLevel = LogLevel.ERROR_LOG_LEVEL_ERROR;
    private static final BlockingQueue<Sdk$SDKMetric.Builder> metrics = new LinkedBlockingQueue();
    private static boolean metricsEnabled;
    private static final BlockingQueue<Sdk$SDKError.Builder> pendingErrors = new LinkedBlockingQueue();
    private static final BlockingQueue<Sdk$SDKMetric.Builder> pendingMetrics = new LinkedBlockingQueue();
    private static boolean refreshEnabled = true;
    private static VungleApiClient vungleApiClient;

    public enum LogLevel {
        ERROR_LOG_LEVEL_OFF(0),
        ERROR_LOG_LEVEL_ERROR(1),
        ERROR_LOG_LEVEL_DEBUG(2);
        
        public static final Companion Companion = null;
        private final int level;

        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final LogLevel fromValue(int i2) {
                LogLevel logLevel = LogLevel.ERROR_LOG_LEVEL_DEBUG;
                if (i2 == logLevel.getLevel()) {
                    return logLevel;
                }
                LogLevel logLevel2 = LogLevel.ERROR_LOG_LEVEL_ERROR;
                if (i2 == logLevel2.getLevel()) {
                    return logLevel2;
                }
                LogLevel logLevel3 = LogLevel.ERROR_LOG_LEVEL_OFF;
                if (i2 == logLevel3.getLevel()) {
                    return logLevel3;
                }
                return logLevel2;
            }
        }

        static {
            Companion = new Companion((DefaultConstructorMarker) null);
        }

        private LogLevel(int i2) {
            this.level = i2;
        }

        public final int getLevel() {
            return this.level;
        }
    }

    public interface RequestListener {
        void onFailure();

        void onSuccess();
    }

    private AnalyticsClient() {
    }

    private final void flushErrors() {
        VungleApiClient vungleApiClient2;
        Logger.Companion companion = Logger.Companion;
        StringBuilder sb = new StringBuilder();
        sb.append("Sending ");
        BlockingQueue<Sdk$SDKError.Builder> blockingQueue = errors;
        sb.append(blockingQueue.size());
        sb.append(" errors");
        companion.d(TAG, sb.toString());
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        blockingQueue.drainTo(linkedBlockingQueue);
        if (!linkedBlockingQueue.isEmpty() && (vungleApiClient2 = vungleApiClient) != null) {
            vungleApiClient2.reportErrors(linkedBlockingQueue, new AnalyticsClient$flushErrors$1(linkedBlockingQueue));
        }
    }

    private final void flushMetrics() {
        VungleApiClient vungleApiClient2;
        Logger.Companion companion = Logger.Companion;
        StringBuilder sb = new StringBuilder();
        sb.append("Sending ");
        BlockingQueue<Sdk$SDKMetric.Builder> blockingQueue = metrics;
        sb.append(blockingQueue.size());
        sb.append(" metrics");
        companion.d(TAG, sb.toString());
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        blockingQueue.drainTo(linkedBlockingQueue);
        if (!linkedBlockingQueue.isEmpty() && (vungleApiClient2 = vungleApiClient) != null) {
            vungleApiClient2.reportMetrics(linkedBlockingQueue, new AnalyticsClient$flushMetrics$1(linkedBlockingQueue));
        }
    }

    private final Sdk$SDKMetric.Builder genMetric(Sdk$SDKMetric.SDKMetricType sDKMetricType, long j2, LogEntry logEntry, String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        String adSource$vungle_ads_release;
        Sdk$SDKMetric.Builder value = Sdk$SDKMetric.newBuilder().setType(sDKMetricType).setValue(j2);
        String str6 = Build.MANUFACTURER;
        Sdk$SDKMetric.Builder model = value.setMake(str6).setModel(Build.MODEL);
        if (Intrinsics.a("Amazon", str6)) {
            str2 = "amazon";
        } else {
            str2 = "android";
        }
        Sdk$SDKMetric.Builder osVersion = model.setOs(str2).setOsVersion(String.valueOf(Build.VERSION.SDK_INT));
        String str7 = "";
        if (logEntry == null || (str3 = logEntry.getPlacementRefId$vungle_ads_release()) == null) {
            str3 = str7;
        }
        Sdk$SDKMetric.Builder placementReferenceId = osVersion.setPlacementReferenceId(str3);
        if (logEntry == null || (str4 = logEntry.getCreativeId$vungle_ads_release()) == null) {
            str4 = str7;
        }
        Sdk$SDKMetric.Builder creativeId = placementReferenceId.setCreativeId(str4);
        if (logEntry == null || (str5 = logEntry.getEventId$vungle_ads_release()) == null) {
            str5 = str7;
        }
        Sdk$SDKMetric.Builder eventId = creativeId.setEventId(str5);
        if (str == null) {
            str = str7;
        }
        Sdk$SDKMetric.Builder meta = eventId.setMeta(str);
        if (!(logEntry == null || (adSource$vungle_ads_release = logEntry.getAdSource$vungle_ads_release()) == null)) {
            str7 = adSource$vungle_ads_release;
        }
        Sdk$SDKMetric.Builder adSource = meta.setAdSource(str7);
        Intrinsics.e(adSource, "newBuilder()\n           …logEntry?.adSource ?: \"\")");
        return adSource;
    }

    static /* synthetic */ Sdk$SDKMetric.Builder genMetric$default(AnalyticsClient analyticsClient, Sdk$SDKMetric.SDKMetricType sDKMetricType, long j2, LogEntry logEntry, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j2 = 0;
        }
        return analyticsClient.genMetric(sDKMetricType, j2, (i2 & 4) != 0 ? null : logEntry, (i2 & 8) != 0 ? null : str);
    }

    private final Sdk$SDKError.Builder genSDKError(Sdk$SDKError.Reason reason, String str, LogEntry logEntry) {
        String str2;
        String str3;
        String str4;
        String str5;
        String adSource$vungle_ads_release;
        Sdk$SDKError.Builder newBuilder = Sdk$SDKError.newBuilder();
        String str6 = Build.MANUFACTURER;
        if (Intrinsics.a("Amazon", str6)) {
            str2 = "amazon";
        } else {
            str2 = "android";
        }
        Sdk$SDKError.Builder at = newBuilder.setOs(str2).setOsVersion(String.valueOf(Build.VERSION.SDK_INT)).setMake(str6).setModel(Build.MODEL).setReason(reason).setMessage(str).setAt(System.currentTimeMillis());
        String str7 = "";
        if (logEntry == null || (str3 = logEntry.getPlacementRefId$vungle_ads_release()) == null) {
            str3 = str7;
        }
        Sdk$SDKError.Builder placementReferenceId = at.setPlacementReferenceId(str3);
        if (logEntry == null || (str4 = logEntry.getCreativeId$vungle_ads_release()) == null) {
            str4 = str7;
        }
        Sdk$SDKError.Builder creativeId = placementReferenceId.setCreativeId(str4);
        if (logEntry == null || (str5 = logEntry.getEventId$vungle_ads_release()) == null) {
            str5 = str7;
        }
        Sdk$SDKError.Builder eventId = creativeId.setEventId(str5);
        if (!(logEntry == null || (adSource$vungle_ads_release = logEntry.getAdSource$vungle_ads_release()) == null)) {
            str7 = adSource$vungle_ads_release;
        }
        Sdk$SDKError.Builder adSource = eventId.setAdSource(str7);
        Intrinsics.e(adSource, "newBuilder()\n           …ce(entry?.adSource ?: \"\")");
        return adSource;
    }

    static /* synthetic */ Sdk$SDKError.Builder genSDKError$default(AnalyticsClient analyticsClient, Sdk$SDKError.Reason reason, String str, LogEntry logEntry, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            logEntry = null;
        }
        return analyticsClient.genSDKError(reason, str, logEntry);
    }

    public static /* synthetic */ void getErrors$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getExecutor$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getMetrics$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getMetricsEnabled$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getPendingErrors$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getPendingMetrics$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getRefreshEnabled$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getVungleApiClient$vungle_ads_release$annotations() {
    }

    /* access modifiers changed from: private */
    /* renamed from: init$lambda-1  reason: not valid java name */
    public static final void m113init$lambda1(VungleThreadPoolExecutor vungleThreadPoolExecutor) {
        Intrinsics.f(vungleThreadPoolExecutor, "$executor");
        vungleThreadPoolExecutor.execute(new a());
    }

    /* access modifiers changed from: private */
    /* renamed from: init$lambda-1$lambda-0  reason: not valid java name */
    public static final void m114init$lambda1$lambda0() {
        INSTANCE.report();
    }

    /* access modifiers changed from: private */
    /* renamed from: logError$lambda-2  reason: not valid java name */
    public static final void m115logError$lambda2(Sdk$SDKError.Reason reason, String str, LogEntry logEntry) {
        Intrinsics.f(reason, "$reason");
        Intrinsics.f(str, "$message");
        INSTANCE.logErrorInSameThread(reason, str, logEntry);
    }

    public static /* synthetic */ void logError$vungle_ads_release$default(AnalyticsClient analyticsClient, Sdk$SDKError.Reason reason, String str, LogEntry logEntry, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            logEntry = null;
        }
        analyticsClient.logError$vungle_ads_release(reason, str, logEntry);
    }

    private final synchronized void logErrorInSameThread(Sdk$SDKError.Reason reason, String str, LogEntry logEntry) {
        if (logLevel != LogLevel.ERROR_LOG_LEVEL_OFF) {
            try {
                Sdk$SDKError.Builder genSDKError = genSDKError(reason, str, logEntry);
                BlockingQueue<Sdk$SDKError.Builder> blockingQueue = errors;
                blockingQueue.put(genSDKError);
                Logger.Companion companion = Logger.Companion;
                companion.w(TAG, "Logging error: " + reason + " with message: " + str);
                if (blockingQueue.size() >= 20) {
                    report();
                }
            } catch (Exception e2) {
                Logger.Companion.e(TAG, "Cannot logError", e2);
            }
        } else {
            return;
        }
        return;
    }

    static /* synthetic */ void logErrorInSameThread$default(AnalyticsClient analyticsClient, Sdk$SDKError.Reason reason, String str, LogEntry logEntry, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            logEntry = null;
        }
        analyticsClient.logErrorInSameThread(reason, str, logEntry);
    }

    /* access modifiers changed from: private */
    /* renamed from: logMetric$lambda-3  reason: not valid java name */
    public static final void m116logMetric$lambda3(Sdk$SDKMetric.SDKMetricType sDKMetricType, long j2, LogEntry logEntry, String str) {
        Intrinsics.f(sDKMetricType, "$metricType");
        INSTANCE.logMetricInSameThread(sDKMetricType, j2, logEntry, str);
    }

    public static /* synthetic */ void logMetric$vungle_ads_release$default(AnalyticsClient analyticsClient, Sdk$SDKMetric.SDKMetricType sDKMetricType, long j2, LogEntry logEntry, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j2 = 0;
        }
        analyticsClient.logMetric$vungle_ads_release(sDKMetricType, j2, (i2 & 4) != 0 ? null : logEntry, (i2 & 8) != 0 ? null : str);
    }

    private final synchronized void logMetricInSameThread(Sdk$SDKMetric.SDKMetricType sDKMetricType, long j2, LogEntry logEntry, String str) {
        String str2;
        if (metricsEnabled) {
            try {
                Sdk$SDKMetric.Builder genMetric = genMetric(sDKMetricType, j2, logEntry, str);
                BlockingQueue<Sdk$SDKMetric.Builder> blockingQueue = metrics;
                blockingQueue.put(genMetric);
                Logger.Companion companion = Logger.Companion;
                StringBuilder sb = new StringBuilder();
                sb.append("Logging Metric ");
                sb.append(sDKMetricType);
                sb.append(" with value ");
                sb.append(j2);
                sb.append(" for placement ");
                if (logEntry != null) {
                    str2 = logEntry.getPlacementRefId$vungle_ads_release();
                } else {
                    str2 = null;
                }
                sb.append(str2);
                companion.d(TAG, sb.toString());
                if (blockingQueue.size() >= 20) {
                    report();
                }
            } catch (Exception e2) {
                Logger.Companion.e(TAG, "Cannot logMetrics", e2);
            }
        } else {
            return;
        }
        return;
    }

    static /* synthetic */ void logMetricInSameThread$default(AnalyticsClient analyticsClient, Sdk$SDKMetric.SDKMetricType sDKMetricType, long j2, LogEntry logEntry, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j2 = 0;
        }
        analyticsClient.logMetricInSameThread(sDKMetricType, j2, (i2 & 4) != 0 ? null : logEntry, (i2 & 8) != 0 ? null : str);
    }

    private final synchronized void report() {
        if (logLevel != LogLevel.ERROR_LOG_LEVEL_OFF && errors.size() > 0) {
            flushErrors();
        }
        if (metricsEnabled && metrics.size() > 0) {
            flushMetrics();
        }
    }

    public final BlockingQueue<Sdk$SDKError.Builder> getErrors$vungle_ads_release() {
        return errors;
    }

    public final VungleThreadPoolExecutor getExecutor$vungle_ads_release() {
        return executor;
    }

    public final BlockingQueue<Sdk$SDKMetric.Builder> getMetrics$vungle_ads_release() {
        return metrics;
    }

    public final boolean getMetricsEnabled$vungle_ads_release() {
        return metricsEnabled;
    }

    public final BlockingQueue<Sdk$SDKError.Builder> getPendingErrors$vungle_ads_release() {
        return pendingErrors;
    }

    public final BlockingQueue<Sdk$SDKMetric.Builder> getPendingMetrics$vungle_ads_release() {
        return pendingMetrics;
    }

    public final boolean getRefreshEnabled$vungle_ads_release() {
        return refreshEnabled;
    }

    public final VungleApiClient getVungleApiClient$vungle_ads_release() {
        return vungleApiClient;
    }

    public final void init$vungle_ads_release(VungleApiClient vungleApiClient2, VungleThreadPoolExecutor vungleThreadPoolExecutor, int i2, boolean z2) {
        Intrinsics.f(vungleApiClient2, "vungleApiClient");
        Intrinsics.f(vungleThreadPoolExecutor, "executor");
        executor = vungleThreadPoolExecutor;
        vungleApiClient = vungleApiClient2;
        try {
            BlockingQueue<Sdk$SDKError.Builder> blockingQueue = pendingErrors;
            if (!blockingQueue.isEmpty()) {
                blockingQueue.drainTo(errors);
            }
        } catch (Exception e2) {
            Logger.Companion.e(TAG, "Failed to add pendingErrors to errors queue.", e2);
        }
        try {
            BlockingQueue<Sdk$SDKMetric.Builder> blockingQueue2 = pendingMetrics;
            if (!blockingQueue2.isEmpty()) {
                blockingQueue2.drainTo(metrics);
            }
        } catch (Exception e3) {
            Logger.Companion.e(TAG, "Failed to add pendingMetrics to metrics queue.", e3);
        }
        if (refreshEnabled) {
            Executors.newSingleThreadScheduledExecutor().scheduleWithFixedDelay(new c(vungleThreadPoolExecutor), 0, REFRESH_TIME_MILLIS, TimeUnit.MILLISECONDS);
        }
        updateErrorLevelAndMetricEnabled$vungle_ads_release(i2, z2);
        if (i2 == LogLevel.ERROR_LOG_LEVEL_DEBUG.getLevel()) {
            Logger.Companion.enable(true);
        } else if (i2 == LogLevel.ERROR_LOG_LEVEL_ERROR.getLevel()) {
            Logger.Companion.enable(false);
        } else if (i2 == LogLevel.ERROR_LOG_LEVEL_OFF.getLevel()) {
            Logger.Companion.enable(false);
        }
    }

    public final synchronized void logError$vungle_ads_release(Sdk$SDKError.Reason reason, String str, LogEntry logEntry) {
        Intrinsics.f(reason, "reason");
        Intrinsics.f(str, "message");
        try {
            VungleThreadPoolExecutor vungleThreadPoolExecutor = executor;
            if (vungleThreadPoolExecutor == null) {
                pendingErrors.put(genSDKError(reason, str, logEntry));
                return;
            } else if (vungleThreadPoolExecutor != null) {
                vungleThreadPoolExecutor.execute(new b(reason, str, logEntry));
            }
        } catch (Exception e2) {
            Logger.Companion companion = Logger.Companion;
            companion.e(TAG, "Cannot logError " + reason + ", " + str + ", " + logEntry, e2);
        }
    }

    public final synchronized void logMetric$vungle_ads_release(Sdk$SDKMetric.SDKMetricType sDKMetricType, long j2, LogEntry logEntry, String str) {
        Intrinsics.f(sDKMetricType, "metricType");
        try {
            VungleThreadPoolExecutor vungleThreadPoolExecutor = executor;
            if (vungleThreadPoolExecutor == null) {
                pendingMetrics.put(genMetric(sDKMetricType, j2, logEntry, str));
                return;
            } else if (vungleThreadPoolExecutor != null) {
                vungleThreadPoolExecutor.execute(new d(sDKMetricType, j2, logEntry, str));
            }
        } catch (Exception e2) {
            Logger.Companion companion = Logger.Companion;
            companion.e(TAG, "Cannot logMetric " + sDKMetricType + ", " + j2 + ", " + logEntry + ", " + str, e2);
        }
        return;
    }

    public final void setExecutor$vungle_ads_release(VungleThreadPoolExecutor vungleThreadPoolExecutor) {
        executor = vungleThreadPoolExecutor;
    }

    public final void setMetricsEnabled$vungle_ads_release(boolean z2) {
        metricsEnabled = z2;
    }

    public final void setRefreshEnabled$vungle_ads_release(boolean z2) {
        refreshEnabled = z2;
    }

    public final void setVungleApiClient$vungle_ads_release(VungleApiClient vungleApiClient2) {
        vungleApiClient = vungleApiClient2;
    }

    public final synchronized void updateErrorLevelAndMetricEnabled$vungle_ads_release(int i2, boolean z2) {
        logLevel = LogLevel.Companion.fromValue(i2);
        metricsEnabled = z2;
    }

    public static /* synthetic */ void logMetric$vungle_ads_release$default(AnalyticsClient analyticsClient, SingleValueMetric singleValueMetric, LogEntry logEntry, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            logEntry = null;
        }
        if ((i2 & 4) != 0) {
            str = singleValueMetric.getMeta();
        }
        analyticsClient.logMetric$vungle_ads_release(singleValueMetric, logEntry, str);
    }

    public static /* synthetic */ void logMetric$vungle_ads_release$default(AnalyticsClient analyticsClient, TimeIntervalMetric timeIntervalMetric, LogEntry logEntry, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            logEntry = null;
        }
        if ((i2 & 4) != 0) {
            str = timeIntervalMetric.getMeta();
        }
        analyticsClient.logMetric$vungle_ads_release(timeIntervalMetric, logEntry, str);
    }

    public static /* synthetic */ void logMetric$vungle_ads_release$default(AnalyticsClient analyticsClient, OneShotTimeIntervalMetric oneShotTimeIntervalMetric, LogEntry logEntry, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            logEntry = null;
        }
        if ((i2 & 4) != 0) {
            str = oneShotTimeIntervalMetric.getMeta();
        }
        analyticsClient.logMetric$vungle_ads_release(oneShotTimeIntervalMetric, logEntry, str);
    }

    public final synchronized void logMetric$vungle_ads_release(SingleValueMetric singleValueMetric, LogEntry logEntry, String str) {
        Intrinsics.f(singleValueMetric, "singleValueMetric");
        logMetric$vungle_ads_release(singleValueMetric.getMetricType(), singleValueMetric.getValue(), logEntry, str);
    }

    public final synchronized void logMetric$vungle_ads_release(TimeIntervalMetric timeIntervalMetric, LogEntry logEntry, String str) {
        Intrinsics.f(timeIntervalMetric, "timeIntervalMetric");
        logMetric$vungle_ads_release(timeIntervalMetric.getMetricType(), timeIntervalMetric.getValue(), logEntry, str);
    }

    public final synchronized void logMetric$vungle_ads_release(OneShotTimeIntervalMetric oneShotTimeIntervalMetric, LogEntry logEntry, String str) {
        Intrinsics.f(oneShotTimeIntervalMetric, "oneShotTimeIntervalMetric");
        if (!oneShotTimeIntervalMetric.isLogged()) {
            logMetric$vungle_ads_release((TimeIntervalMetric) oneShotTimeIntervalMetric, logEntry, str);
            oneShotTimeIntervalMetric.markLogged();
        }
    }
}
