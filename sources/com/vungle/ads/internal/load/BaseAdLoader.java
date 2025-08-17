package com.vungle.ads.internal.load;

import android.content.Context;
import com.vungle.ads.AdExpiredError;
import com.vungle.ads.AdPayloadError;
import com.vungle.ads.AdResponseEmptyError;
import com.vungle.ads.AnalyticsClient;
import com.vungle.ads.AssetDownloadError;
import com.vungle.ads.AssetRequestError;
import com.vungle.ads.AssetResponseDataError;
import com.vungle.ads.IndexHtmlError;
import com.vungle.ads.InvalidAssetUrlError;
import com.vungle.ads.InvalidEventIdError;
import com.vungle.ads.InvalidTemplateURLError;
import com.vungle.ads.MraidJsError;
import com.vungle.ads.NativeAssetError;
import com.vungle.ads.OmSdkJsError;
import com.vungle.ads.ServiceLocator;
import com.vungle.ads.SingleValueMetric;
import com.vungle.ads.TemplateUnzipError;
import com.vungle.ads.TimeIntervalMetric;
import com.vungle.ads.VungleError;
import com.vungle.ads.internal.ConfigManager;
import com.vungle.ads.internal.Constants;
import com.vungle.ads.internal.downloader.AssetDownloadListener;
import com.vungle.ads.internal.downloader.DownloadRequest;
import com.vungle.ads.internal.downloader.Downloader;
import com.vungle.ads.internal.executor.Executors;
import com.vungle.ads.internal.model.AdAsset;
import com.vungle.ads.internal.model.AdPayload;
import com.vungle.ads.internal.model.ConfigPayload;
import com.vungle.ads.internal.network.TpatSender;
import com.vungle.ads.internal.network.VungleApiClient;
import com.vungle.ads.internal.omsdk.OMInjector;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import com.vungle.ads.internal.signals.SignalManager;
import com.vungle.ads.internal.util.FileUtility;
import com.vungle.ads.internal.util.LogEntry;
import com.vungle.ads.internal.util.Logger;
import com.vungle.ads.internal.util.PathProvider;
import com.vungle.ads.internal.util.UnzipUtility;
import com.vungle.ads.internal.util.Utils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public abstract class BaseAdLoader {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String DOWNLOADED_FILE_NOT_FOUND = "Downloaded file not found!";
    private static final String TAG = "BaseAdLoader";
    private final List<AdAsset> adAssets = new ArrayList();
    /* access modifiers changed from: private */
    public AdLoaderCallback adLoaderCallback;
    private TimeIntervalMetric adOptionalDownloadDurationMetric = new TimeIntervalMetric(Sdk$SDKMetric.SDKMetricType.AD_OPTIONAL_DOWNLOAD_DURATION_MS);
    private final AdRequest adRequest;
    private TimeIntervalMetric adRequiredDownloadDurationMetric = new TimeIntervalMetric(Sdk$SDKMetric.SDKMetricType.AD_REQUIRED_DOWNLOAD_DURATION_MS);
    private AdPayload advertisement;
    private TimeIntervalMetric assetDownloadDurationMetric = new TimeIntervalMetric(Sdk$SDKMetric.SDKMetricType.ASSET_DOWNLOAD_DURATION_MS);
    private final Context context;
    /* access modifiers changed from: private */
    public final AtomicLong downloadCount = new AtomicLong(0);
    /* access modifiers changed from: private */
    public final AtomicLong downloadRequiredCount = new AtomicLong(0);
    private final Downloader downloader;
    /* access modifiers changed from: private */
    public AtomicBoolean fullyDownloaded = new AtomicBoolean(true);
    private LogEntry logEntry;
    /* access modifiers changed from: private */
    public SingleValueMetric mainVideoSizeMetric = new SingleValueMetric(Sdk$SDKMetric.SDKMetricType.ASSET_FILE_SIZE);
    private AtomicBoolean notifyFailed = new AtomicBoolean(false);
    private AtomicBoolean notifySuccess = new AtomicBoolean(false);
    private final OMInjector omInjector;
    private final PathProvider pathProvider;
    /* access modifiers changed from: private */
    public AtomicBoolean requiredAssetDownloaded = new AtomicBoolean(true);
    private final Executors sdkExecutors;
    /* access modifiers changed from: private */
    public SingleValueMetric templateHtmlSizeMetric = new SingleValueMetric(Sdk$SDKMetric.SDKMetricType.TEMPLATE_HTML_SIZE);
    /* access modifiers changed from: private */
    public SingleValueMetric templateSizeMetric = new SingleValueMetric(Sdk$SDKMetric.SDKMetricType.TEMPLATE_ZIP_SIZE);
    private final VungleApiClient vungleApiClient;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public BaseAdLoader(Context context2, VungleApiClient vungleApiClient2, Executors executors, OMInjector oMInjector, Downloader downloader2, PathProvider pathProvider2, AdRequest adRequest2) {
        Intrinsics.f(context2, "context");
        Intrinsics.f(vungleApiClient2, "vungleApiClient");
        Intrinsics.f(executors, "sdkExecutors");
        Intrinsics.f(oMInjector, "omInjector");
        Intrinsics.f(downloader2, "downloader");
        Intrinsics.f(pathProvider2, "pathProvider");
        Intrinsics.f(adRequest2, "adRequest");
        this.context = context2;
        this.vungleApiClient = vungleApiClient2;
        this.sdkExecutors = executors;
        this.omInjector = oMInjector;
        this.downloader = downloader2;
        this.pathProvider = pathProvider2;
        this.adRequest = adRequest2;
    }

    /* access modifiers changed from: private */
    public final void downloadAssets() {
        this.assetDownloadDurationMetric.markStart();
        this.adRequiredDownloadDurationMetric.markStart();
        this.adOptionalDownloadDurationMetric.markStart();
        this.downloadCount.set((long) this.adAssets.size());
        AtomicLong atomicLong = this.downloadRequiredCount;
        ArrayList arrayList = new ArrayList();
        for (Object next : this.adAssets) {
            if (((AdAsset) next).isRequired()) {
                arrayList.add(next);
            }
        }
        atomicLong.set((long) arrayList.size());
        for (AdAsset next2 : this.adAssets) {
            DownloadRequest downloadRequest = new DownloadRequest(getAssetPriority(next2), next2, this.logEntry);
            if (downloadRequest.isTemplate()) {
                downloadRequest.startRecord();
            }
            this.downloader.download(downloadRequest, getAssetDownloadListener());
        }
    }

    private final boolean fileIsValid(File file, AdAsset adAsset) {
        return file.exists() && file.length() == adAsset.getFileSize();
    }

    private final AssetDownloadListener getAssetDownloadListener() {
        return new BaseAdLoader$assetDownloadListener$1(this);
    }

    private final DownloadRequest.Priority getAssetPriority(AdAsset adAsset) {
        if (adAsset.isRequired()) {
            return DownloadRequest.Priority.CRITICAL;
        }
        return DownloadRequest.Priority.HIGHEST;
    }

    private final File getDestinationDir(AdPayload adPayload) {
        return this.pathProvider.getDownloadsDirForAd(adPayload.eventId());
    }

    private final VungleError getErrorInfo(AdPayload adPayload) {
        Integer num;
        Integer num2;
        boolean z2;
        boolean z3;
        boolean z4;
        AdPayload.AdUnit adUnit = adPayload.adUnit();
        String str = null;
        if (adUnit != null) {
            num = adUnit.getErrorCode();
        } else {
            num = null;
        }
        AdPayload.AdUnit adUnit2 = adPayload.adUnit();
        if (adUnit2 != null) {
            num2 = adUnit2.getSleep();
        } else {
            num2 = null;
        }
        AdPayload.AdUnit adUnit3 = adPayload.adUnit();
        if (adUnit3 != null) {
            str = adUnit3.getInfo();
        }
        String str2 = "Response error: " + num2 + ", Request failed with error: " + num + ", " + str;
        boolean z5 = false;
        if ((num != null && num.intValue() == 10001) || (num != null && num.intValue() == 10002)) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2 && (num == null || num.intValue() != 20001)) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (!z3 && (num == null || num.intValue() != 30001)) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (z4 || (num != null && num.intValue() == 30002)) {
            z5 = true;
        }
        if (!z5) {
            return new AdPayloadError(Sdk$SDKError.Reason.PLACEMENT_SLEEP, str2);
        }
        Sdk$SDKError.Reason forNumber = Sdk$SDKError.Reason.forNumber(num.intValue());
        Intrinsics.e(forNumber, "forNumber(errorCode)");
        return new AdPayloadError(forNumber, str2);
    }

    private final VungleError getTemplateError(AdPayload adPayload) {
        AdPayload.TemplateSettings templateSettings;
        boolean z2;
        String str;
        String str2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        String str3;
        String str4;
        AdPayload.AdUnit adUnit = adPayload.adUnit();
        if (adUnit != null) {
            templateSettings = adUnit.getTemplateSettings();
        } else {
            templateSettings = null;
        }
        if (templateSettings == null) {
            return new AssetResponseDataError("Missing template settings");
        }
        Map<String, AdPayload.CacheableReplacement> cacheableReplacements = templateSettings.getCacheableReplacements();
        if (!adPayload.isNativeTemplateType()) {
            AdPayload.AdUnit adUnit2 = adPayload.adUnit();
            if (adUnit2 != null) {
                str = adUnit2.getTemplateURL();
            } else {
                str = null;
            }
            AdPayload.AdUnit adUnit3 = adPayload.adUnit();
            if (adUnit3 != null) {
                str2 = adUnit3.getVmURL();
            } else {
                str2 = null;
            }
            if (str == null || str.length() == 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                if (str2 == null || str2.length() == 0) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (z6) {
                    return new InvalidTemplateURLError("Failed to prepare null vmURL or templateURL for downloading.");
                }
            }
            if (str == null || str.length() == 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (z4 || Utils.INSTANCE.isUrlValid(str)) {
                if (str2 == null || str2.length() == 0) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (!z5 && !Utils.INSTANCE.isUrlValid(str2)) {
                    return new AssetRequestError("Failed to load vm url: " + str2);
                }
            } else {
                return new AssetRequestError("Failed to load template: " + str);
            }
        } else if (cacheableReplacements != null) {
            AdPayload.CacheableReplacement cacheableReplacement = cacheableReplacements.get("MAIN_IMAGE");
            if (cacheableReplacement != null) {
                str3 = cacheableReplacement.getUrl();
            } else {
                str3 = null;
            }
            if (str3 == null) {
                return new NativeAssetError("Unable to load null main image.");
            }
            AdPayload.CacheableReplacement cacheableReplacement2 = cacheableReplacements.get("VUNGLE_PRIVACY_ICON_URL");
            if (cacheableReplacement2 != null) {
                str4 = cacheableReplacement2.getUrl();
            } else {
                str4 = null;
            }
            if (str4 == null) {
                return new NativeAssetError("Unable to load null privacy image.");
            }
        }
        if (cacheableReplacements != null) {
            for (Map.Entry<String, AdPayload.CacheableReplacement> value : cacheableReplacements.entrySet()) {
                String url = ((AdPayload.CacheableReplacement) value.getValue()).getUrl();
                if (url == null || url.length() == 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    return new InvalidAssetUrlError("Invalid asset URL " + url);
                } else if (!Utils.INSTANCE.isUrlValid(url)) {
                    return new AssetRequestError("Invalid asset URL " + url);
                }
            }
        }
        return null;
    }

    /* renamed from: handleAdMetaData$lambda-5  reason: not valid java name */
    private static final SignalManager m178handleAdMetaData$lambda5(Lazy<SignalManager> lazy) {
        return lazy.getValue();
    }

    public static /* synthetic */ void handleAdMetaData$vungle_ads_release$default(BaseAdLoader baseAdLoader, AdPayload adPayload, SingleValueMetric singleValueMetric, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                singleValueMetric = null;
            }
            baseAdLoader.handleAdMetaData$vungle_ads_release(adPayload, singleValueMetric);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: handleAdMetaData");
    }

    private final boolean injectMraidJS(File file) {
        try {
            File file2 = new File(file.getPath(), Constants.AD_MRAID_JS_FILE_NAME);
            File file3 = new File(this.pathProvider.getJsAssetDir(ConfigManager.INSTANCE.getMraidJsVersion()), Constants.MRAID_JS_FILE_NAME);
            if (file3.exists()) {
                File unused = FilesKt__UtilsKt.f(file3, file2, true, 0, 4, (Object) null);
                return true;
            }
            new MraidJsError(Sdk$SDKError.Reason.MRAID_JS_DOES_NOT_EXIST, "mraid js source file not exist.").setLogEntry$vungle_ads_release(this.logEntry).logErrorNoReturnValue$vungle_ads_release();
            return false;
        } catch (Exception e2) {
            Logger.Companion companion = Logger.Companion;
            companion.e(TAG, "Failed to inject mraid.js: " + e2.getMessage());
            Sdk$SDKError.Reason reason = Sdk$SDKError.Reason.MRAID_JS_COPY_FAILED;
            new MraidJsError(reason, "Failed to copy mraid js to ad folder: " + e2.getMessage()).setLogEntry$vungle_ads_release(this.logEntry).logErrorNoReturnValue$vungle_ads_release();
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: loadAd$lambda-0  reason: not valid java name */
    public static final void m179loadAd$lambda0(BaseAdLoader baseAdLoader) {
        Intrinsics.f(baseAdLoader, "this$0");
        baseAdLoader.requestAd();
    }

    private final void onAdReady() {
        AdPayload adPayload = this.advertisement;
        if (adPayload != null && !this.notifyFailed.get() && this.notifySuccess.compareAndSet(false, true)) {
            onAdLoadReady();
            AdLoaderCallback adLoaderCallback2 = this.adLoaderCallback;
            if (adLoaderCallback2 != null) {
                adLoaderCallback2.onSuccess(adPayload);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void onDownloadCompleted(AdRequest adRequest2) {
        Logger.Companion companion = Logger.Companion;
        companion.d(TAG, "All download completed " + adRequest2);
        AdPayload adPayload = this.advertisement;
        if (adPayload != null) {
            adPayload.setAssetFullyDownloaded();
        }
        onAdReady();
        this.assetDownloadDurationMetric.markEnd();
        AnalyticsClient analyticsClient = AnalyticsClient.INSTANCE;
        AnalyticsClient.logMetric$vungle_ads_release$default(analyticsClient, this.assetDownloadDurationMetric, this.logEntry, (String) null, 4, (Object) null);
        this.adOptionalDownloadDurationMetric.markEnd();
        AnalyticsClient.logMetric$vungle_ads_release$default(analyticsClient, this.adOptionalDownloadDurationMetric, this.logEntry, (String) null, 4, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void onRequiredDownloadCompleted() {
        this.adRequiredDownloadDurationMetric.markEnd();
        AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, this.adRequiredDownloadDurationMetric, this.logEntry, (String) null, 4, (Object) null);
        onAdReady();
    }

    /* access modifiers changed from: private */
    public final boolean processVmTemplate(AdAsset adAsset, AdPayload adPayload) {
        boolean z2;
        if (adPayload == null || adAsset.getStatus() != AdAsset.Status.DOWNLOAD_SUCCESS) {
            return false;
        }
        if (adAsset.getLocalPath().length() == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            return false;
        }
        File file = new File(adAsset.getLocalPath());
        if (!fileIsValid(file, adAsset)) {
            return false;
        }
        File destinationDir = getDestinationDir(adPayload);
        if (destinationDir == null || !destinationDir.isDirectory()) {
            Logger.Companion.e(TAG, "Unable to access Destination Directory");
            return false;
        } else if (adAsset.getFileType() == AdAsset.FileType.ZIP && !unzipFile(file, destinationDir)) {
            return false;
        } else {
            if (adPayload.omEnabled()) {
                try {
                    this.omInjector.injectJsFiles$vungle_ads_release(destinationDir);
                } catch (Exception e2) {
                    Logger.Companion companion = Logger.Companion;
                    companion.e(TAG, "Failed to inject OMSDK: " + e2.getMessage());
                    Sdk$SDKError.Reason reason = Sdk$SDKError.Reason.OMSDK_JS_WRITE_FAILED;
                    new OmSdkJsError(reason, "Failed to inject OMSDK: " + e2.getMessage()).setLogEntry$vungle_ads_release(this.logEntry).logErrorNoReturnValue$vungle_ads_release();
                }
            }
            boolean injectMraidJS = injectMraidJS(destinationDir);
            FileUtility.printDirectoryTree(destinationDir);
            return injectMraidJS;
        }
    }

    private final boolean unzipFile(File file, File file2) {
        ArrayList arrayList = new ArrayList();
        for (AdAsset next : this.adAssets) {
            if (next.getFileType() == AdAsset.FileType.ASSET) {
                arrayList.add(next.getLocalPath());
            }
        }
        try {
            UnzipUtility unzipUtility = UnzipUtility.INSTANCE;
            String path = file.getPath();
            String path2 = file2.getPath();
            Intrinsics.e(path2, "destinationDir.path");
            unzipUtility.unzip(path, path2, new BaseAdLoader$unzipFile$1(arrayList));
            if (!new File(file2.getPath(), Constants.AD_INDEX_FILE_NAME).exists()) {
                new IndexHtmlError(Sdk$SDKError.Reason.INVALID_INDEX_URL, "Failed to retrieve indexFileUrl from the Ad").setLogEntry$vungle_ads_release(this.logEntry).logErrorNoReturnValue$vungle_ads_release();
                return false;
            }
            FileUtility.delete(file);
            return true;
        } catch (Exception e2) {
            new TemplateUnzipError("Unzip failed: " + e2.getMessage()).setLogEntry$vungle_ads_release(this.logEntry).logErrorNoReturnValue$vungle_ads_release();
            return false;
        }
    }

    private final VungleError validateAdMetadata(AdPayload adPayload) {
        String str;
        boolean z2;
        AdPayload.AdUnit adUnit = adPayload.adUnit();
        if (adUnit != null && adUnit.getSleep() != null) {
            return getErrorInfo(adPayload);
        }
        String referenceId = this.adRequest.getPlacement().getReferenceId();
        AdPayload adPayload2 = this.advertisement;
        String str2 = null;
        if (adPayload2 != null) {
            str = adPayload2.placementId();
        } else {
            str = null;
        }
        if (!Intrinsics.a(referenceId, str)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Requests and responses don't match ");
            AdPayload adPayload3 = this.advertisement;
            if (adPayload3 != null) {
                str2 = adPayload3.placementId();
            }
            sb.append(str2);
            sb.append('.');
            return new AdResponseEmptyError(sb.toString());
        }
        VungleError templateError = getTemplateError(adPayload);
        if (templateError != null) {
            return templateError;
        }
        if (adPayload.hasExpired()) {
            return new AdExpiredError("The ad markup has expired for playback.");
        }
        String eventId = adPayload.eventId();
        if (eventId == null || eventId.length() == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            return new InvalidEventIdError("Event id is invalid.");
        }
        return null;
    }

    public final void cancel() {
        this.downloader.cancelAll();
    }

    public final AdRequest getAdRequest() {
        return this.adRequest;
    }

    public final AdPayload getAdvertisement$vungle_ads_release() {
        return this.advertisement;
    }

    public final Context getContext() {
        return this.context;
    }

    public final LogEntry getLogEntry$vungle_ads_release() {
        return this.logEntry;
    }

    public final PathProvider getPathProvider() {
        return this.pathProvider;
    }

    public final Executors getSdkExecutors() {
        return this.sdkExecutors;
    }

    public final VungleApiClient getVungleApiClient() {
        return this.vungleApiClient;
    }

    public final void handleAdMetaData$vungle_ads_release(AdPayload adPayload, SingleValueMetric singleValueMetric) {
        List<String> loadAdUrls;
        Intrinsics.f(adPayload, "advertisement");
        this.advertisement = adPayload;
        adPayload.setLogEntry$vungle_ads_release(this.logEntry);
        LogEntry logEntry2 = this.logEntry;
        if (logEntry2 != null) {
            logEntry2.setEventId$vungle_ads_release(adPayload.eventId());
        }
        LogEntry logEntry3 = this.logEntry;
        if (logEntry3 != null) {
            logEntry3.setCreativeId$vungle_ads_release(adPayload.getCreativeId());
        }
        LogEntry logEntry4 = this.logEntry;
        if (logEntry4 != null) {
            logEntry4.setAdSource$vungle_ads_release(adPayload.getAdSource());
        }
        ConfigPayload config = adPayload.config();
        if (config != null) {
            ConfigManager.INSTANCE.initWithConfig$vungle_ads_release(this.context, config, false, singleValueMetric);
        }
        VungleError validateAdMetadata = validateAdMetadata(adPayload);
        if (validateAdMetadata != null) {
            onAdLoadFailed(validateAdMetadata.setLogEntry$vungle_ads_release(this.logEntry).logError$vungle_ads_release());
            return;
        }
        File destinationDir = getDestinationDir(adPayload);
        if (destinationDir == null || !destinationDir.isDirectory() || !destinationDir.exists()) {
            Sdk$SDKError.Reason reason = Sdk$SDKError.Reason.ASSET_WRITE_ERROR;
            onAdLoadFailed(new AssetDownloadError(reason, "Invalid directory. " + destinationDir).setLogEntry$vungle_ads_release(this.logEntry).logError$vungle_ads_release());
            return;
        }
        ServiceLocator.Companion companion = ServiceLocator.Companion;
        Lazy a2 = LazyKt__LazyJVMKt.a(LazyThreadSafetyMode.SYNCHRONIZED, new BaseAdLoader$handleAdMetaData$$inlined$inject$1(this.context));
        AdPayload.AdUnit adUnit = adPayload.adUnit();
        if (!(adUnit == null || (loadAdUrls = adUnit.getLoadAdUrls()) == null)) {
            TpatSender tpatSender = new TpatSender(this.vungleApiClient, this.logEntry, this.sdkExecutors.getIoExecutor(), this.pathProvider, m178handleAdMetaData$lambda5(a2));
            for (String sendTpat : loadAdUrls) {
                tpatSender.sendTpat(sendTpat, this.sdkExecutors.getJobExecutor());
            }
        }
        if (!this.adAssets.isEmpty()) {
            this.adAssets.clear();
        }
        this.adAssets.addAll(adPayload.getDownloadableAssets(destinationDir));
        if (this.adAssets.isEmpty()) {
            onAdLoadFailed(new AssetDownloadError(Sdk$SDKError.Reason.INVALID_ASSET_URL, "No assets to download.").setLogEntry$vungle_ads_release(this.logEntry).logError$vungle_ads_release());
        } else {
            MraidJsLoader.INSTANCE.downloadJs(this.pathProvider, this.downloader, this.sdkExecutors.getBackgroundExecutor(), new BaseAdLoader$handleAdMetaData$3(this), adPayload);
        }
    }

    public final void loadAd(AdLoaderCallback adLoaderCallback2) {
        Intrinsics.f(adLoaderCallback2, "adLoaderCallback");
        this.adLoaderCallback = adLoaderCallback2;
        this.sdkExecutors.getBackgroundExecutor().execute(new a(this));
    }

    public final void onAdLoadFailed(VungleError vungleError) {
        AdLoaderCallback adLoaderCallback2;
        Intrinsics.f(vungleError, MRAIDPresenter.ERROR);
        if (!this.notifySuccess.get() && this.notifyFailed.compareAndSet(false, true) && (adLoaderCallback2 = this.adLoaderCallback) != null) {
            adLoaderCallback2.onFailure(vungleError);
        }
    }

    public abstract void onAdLoadReady();

    /* access modifiers changed from: protected */
    public abstract void requestAd();

    public final void setAdvertisement$vungle_ads_release(AdPayload adPayload) {
        this.advertisement = adPayload;
    }

    public final void setLogEntry$vungle_ads_release(LogEntry logEntry2) {
        this.logEntry = logEntry2;
    }
}
