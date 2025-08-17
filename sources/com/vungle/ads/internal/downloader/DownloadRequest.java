package com.vungle.ads.internal.downloader;

import com.facebook.common.util.UriUtil;
import com.vungle.ads.AnalyticsClient;
import com.vungle.ads.TimeIntervalMetric;
import com.vungle.ads.internal.Constants;
import com.vungle.ads.internal.model.AdAsset;
import com.vungle.ads.internal.model.AdPayload;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import com.vungle.ads.internal.util.LogEntry;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class DownloadRequest {
    private final AdAsset asset;
    private final AtomicBoolean cancelled;
    private TimeIntervalMetric downloadDuration;
    private final LogEntry logEntry;
    private final Priority priority;

    public enum Priority {
        CRITICAL(-2147483647),
        HIGHEST(0),
        HIGH(1),
        LOWEST(Integer.MAX_VALUE);
        
        private final int priority;

        private Priority(int i2) {
            this.priority = i2;
        }

        public final int getPriority() {
            return this.priority;
        }
    }

    public DownloadRequest(Priority priority2, AdAsset adAsset, LogEntry logEntry2) {
        Intrinsics.f(priority2, "priority");
        Intrinsics.f(adAsset, UriUtil.LOCAL_ASSET_SCHEME);
        this.priority = priority2;
        this.asset = adAsset;
        this.logEntry = logEntry2;
        this.cancelled = new AtomicBoolean(false);
    }

    public final void cancel() {
        this.cancelled.set(true);
    }

    public final AdAsset getAsset() {
        return this.asset;
    }

    public final LogEntry getLogEntry$vungle_ads_release() {
        return this.logEntry;
    }

    /* renamed from: getPriority  reason: collision with other method in class */
    public final Priority m173getPriority() {
        return this.priority;
    }

    public final boolean isCancelled() {
        return this.cancelled.get();
    }

    public final boolean isHtmlTemplate() {
        return Intrinsics.a(this.asset.getAdIdentifier(), AdPayload.KEY_VM);
    }

    public final boolean isMainVideo() {
        return Intrinsics.a(this.asset.getAdIdentifier(), Constants.KEY_MAIN_VIDEO);
    }

    public final boolean isTemplate() {
        return this.asset.getFileType() == AdAsset.FileType.ZIP || isHtmlTemplate();
    }

    public final void startRecord() {
        TimeIntervalMetric timeIntervalMetric = new TimeIntervalMetric(Sdk$SDKMetric.SDKMetricType.TEMPLATE_DOWNLOAD_DURATION_MS);
        this.downloadDuration = timeIntervalMetric;
        timeIntervalMetric.markStart();
    }

    public final void stopRecord() {
        TimeIntervalMetric timeIntervalMetric = this.downloadDuration;
        if (timeIntervalMetric != null) {
            timeIntervalMetric.markEnd();
            AnalyticsClient.INSTANCE.logMetric$vungle_ads_release(timeIntervalMetric, this.logEntry, this.asset.getServerPath());
        }
    }

    public String toString() {
        return "DownloadRequest{, priority=" + this.priority + ", url='" + this.asset.getServerPath() + "', path='" + this.asset.getLocalPath() + "', cancelled=" + this.cancelled + ", logEntry=" + this.logEntry + '}';
    }

    public final int getPriority() {
        return this.priority.getPriority();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DownloadRequest(Priority priority2, AdAsset adAsset, LogEntry logEntry2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(priority2, adAsset, (i2 & 4) != 0 ? null : logEntry2);
    }
}
