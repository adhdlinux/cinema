package com.vungle.ads.internal.load;

import com.vungle.ads.AnalyticsClient;
import com.vungle.ads.AssetDownloadError;
import com.vungle.ads.SingleValueMetric;
import com.vungle.ads.internal.downloader.AssetDownloadListener;
import com.vungle.ads.internal.downloader.DownloadRequest;
import com.vungle.ads.internal.model.AdAsset;
import com.vungle.ads.internal.model.AdPayload;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import com.vungle.ads.internal.util.Logger;
import java.io.File;
import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;

public final class BaseAdLoader$assetDownloadListener$1 implements AssetDownloadListener {
    final /* synthetic */ BaseAdLoader this$0;

    BaseAdLoader$assetDownloadListener$1(BaseAdLoader baseAdLoader) {
        this.this$0 = baseAdLoader;
    }

    /* access modifiers changed from: private */
    /* renamed from: onError$lambda-0  reason: not valid java name */
    public static final void m180onError$lambda0(BaseAdLoader baseAdLoader, DownloadRequest downloadRequest, AssetDownloadListener.DownloadError downloadError) {
        Integer num;
        Intrinsics.f(baseAdLoader, "this$0");
        Intrinsics.f(downloadRequest, "$downloadRequest");
        baseAdLoader.fullyDownloaded.set(false);
        if (downloadRequest.getAsset().isRequired()) {
            baseAdLoader.requiredAssetDownloaded.set(false);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Failed to download assets. required=");
        sb.append(downloadRequest.getAsset().isRequired());
        sb.append(" reason=");
        Throwable th = null;
        if (downloadError != null) {
            num = Integer.valueOf(downloadError.getReason());
        } else {
            num = null;
        }
        sb.append(num);
        sb.append(" cause=");
        if (downloadError != null) {
            th = downloadError.getCause();
        }
        sb.append(th);
        String sb2 = sb.toString();
        if (downloadRequest.getAsset().isRequired() && baseAdLoader.downloadRequiredCount.decrementAndGet() <= 0) {
            baseAdLoader.onAdLoadFailed(new AssetDownloadError(Sdk$SDKError.Reason.ASSET_RESPONSE_DATA_ERROR, sb2).setLogEntry$vungle_ads_release(baseAdLoader.getLogEntry$vungle_ads_release()).logError$vungle_ads_release());
            baseAdLoader.cancel();
        } else if (baseAdLoader.downloadCount.decrementAndGet() <= 0) {
            baseAdLoader.onAdLoadFailed(new AssetDownloadError(Sdk$SDKError.Reason.ASSET_RESPONSE_DATA_ERROR, sb2).setLogEntry$vungle_ads_release(baseAdLoader.getLogEntry$vungle_ads_release()).logError$vungle_ads_release());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onSuccess$lambda-1  reason: not valid java name */
    public static final void m181onSuccess$lambda1(File file, BaseAdLoader$assetDownloadListener$1 baseAdLoader$assetDownloadListener$1, DownloadRequest downloadRequest, BaseAdLoader baseAdLoader) {
        SingleValueMetric singleValueMetric;
        Intrinsics.f(file, "$file");
        Intrinsics.f(baseAdLoader$assetDownloadListener$1, "this$0");
        Intrinsics.f(downloadRequest, "$downloadRequest");
        Intrinsics.f(baseAdLoader, "this$1");
        if (!file.exists()) {
            baseAdLoader$assetDownloadListener$1.onError(new AssetDownloadListener.DownloadError(-1, new IOException("Downloaded file not found!"), AssetDownloadListener.DownloadError.ErrorReason.Companion.getFILE_NOT_FOUND_ERROR()), downloadRequest);
            return;
        }
        AdAsset asset = downloadRequest.getAsset();
        asset.setFileSize(file.length());
        asset.setStatus(AdAsset.Status.DOWNLOAD_SUCCESS);
        if (downloadRequest.isTemplate()) {
            downloadRequest.stopRecord();
            if (downloadRequest.isHtmlTemplate()) {
                singleValueMetric = baseAdLoader.templateHtmlSizeMetric;
            } else {
                singleValueMetric = baseAdLoader.templateSizeMetric;
            }
            singleValueMetric.setValue(Long.valueOf(file.length()));
            AnalyticsClient.INSTANCE.logMetric$vungle_ads_release(singleValueMetric, baseAdLoader.getLogEntry$vungle_ads_release(), asset.getServerPath());
        } else if (downloadRequest.isMainVideo()) {
            baseAdLoader.mainVideoSizeMetric.setValue(Long.valueOf(file.length()));
            AnalyticsClient.INSTANCE.logMetric$vungle_ads_release(baseAdLoader.mainVideoSizeMetric, baseAdLoader.getLogEntry$vungle_ads_release(), asset.getServerPath());
        }
        AdPayload advertisement$vungle_ads_release = baseAdLoader.getAdvertisement$vungle_ads_release();
        if (advertisement$vungle_ads_release != null) {
            advertisement$vungle_ads_release.updateAdAssetPath(asset);
        }
        if (downloadRequest.isTemplate() && !baseAdLoader.processVmTemplate(asset, baseAdLoader.getAdvertisement$vungle_ads_release())) {
            baseAdLoader.fullyDownloaded.set(false);
            if (asset.isRequired()) {
                baseAdLoader.requiredAssetDownloaded.set(false);
            }
        }
        if (asset.isRequired() && baseAdLoader.downloadRequiredCount.decrementAndGet() <= 0) {
            if (baseAdLoader.requiredAssetDownloaded.get()) {
                baseAdLoader.onRequiredDownloadCompleted();
            } else {
                baseAdLoader.onAdLoadFailed(new AssetDownloadError(Sdk$SDKError.Reason.ASSET_RESPONSE_DATA_ERROR, "Failed to download required assets.").setLogEntry$vungle_ads_release(baseAdLoader.getLogEntry$vungle_ads_release()).logError$vungle_ads_release());
                baseAdLoader.cancel();
                return;
            }
        }
        if (baseAdLoader.downloadCount.decrementAndGet() > 0) {
            return;
        }
        if (baseAdLoader.fullyDownloaded.get()) {
            baseAdLoader.onDownloadCompleted(baseAdLoader.getAdRequest());
        } else {
            baseAdLoader.onAdLoadFailed(new AssetDownloadError(Sdk$SDKError.Reason.ASSET_RESPONSE_DATA_ERROR, "Failed to download assets.").setLogEntry$vungle_ads_release(baseAdLoader.getLogEntry$vungle_ads_release()).logError$vungle_ads_release());
        }
    }

    public void onError(AssetDownloadListener.DownloadError downloadError, DownloadRequest downloadRequest) {
        Integer num;
        Intrinsics.f(downloadRequest, "downloadRequest");
        Logger.Companion companion = Logger.Companion;
        StringBuilder sb = new StringBuilder();
        sb.append("onError called: reason ");
        Throwable th = null;
        if (downloadError != null) {
            num = Integer.valueOf(downloadError.getReason());
        } else {
            num = null;
        }
        sb.append(num);
        sb.append("; cause ");
        if (downloadError != null) {
            th = downloadError.getCause();
        }
        sb.append(th);
        companion.e("BaseAdLoader", sb.toString());
        this.this$0.getSdkExecutors().getBackgroundExecutor().execute(new b(this.this$0, downloadRequest, downloadError));
    }

    public void onSuccess(File file, DownloadRequest downloadRequest) {
        Intrinsics.f(file, "file");
        Intrinsics.f(downloadRequest, "downloadRequest");
        this.this$0.getSdkExecutors().getBackgroundExecutor().execute(new c(file, this, downloadRequest, this.this$0));
    }
}
