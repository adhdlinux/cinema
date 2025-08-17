package com.vungle.ads.internal.load;

import com.vungle.ads.MraidJsError;
import com.vungle.ads.internal.ConfigManager;
import com.vungle.ads.internal.Constants;
import com.vungle.ads.internal.downloader.DownloadRequest;
import com.vungle.ads.internal.downloader.Downloader;
import com.vungle.ads.internal.executor.VungleThreadPoolExecutor;
import com.vungle.ads.internal.model.AdAsset;
import com.vungle.ads.internal.model.AdPayload;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import com.vungle.ads.internal.util.FileUtility;
import com.vungle.ads.internal.util.LogEntry;
import com.vungle.ads.internal.util.Logger;
import com.vungle.ads.internal.util.PathProvider;
import java.io.File;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

public final class MraidJsLoader {
    public static final MraidJsLoader INSTANCE = new MraidJsLoader();
    public static final int MRAID_AVAILABLE = 13;
    public static final int MRAID_DOWNLOADED = 10;
    public static final int MRAID_DOWNLOAD_FAILED = 12;
    public static final int MRAID_INVALID_ENDPOINT = 11;
    private static final String TAG = "MraidJsLoader";
    private static final AtomicBoolean isDownloading = new AtomicBoolean(false);
    private static final CopyOnWriteArrayList<DownloadResultListener> listeners = new CopyOnWriteArrayList<>();

    public interface DownloadResultListener {
        void onDownloadResult(int i2);
    }

    private MraidJsLoader() {
    }

    public static /* synthetic */ void downloadJs$default(MraidJsLoader mraidJsLoader, PathProvider pathProvider, Downloader downloader, VungleThreadPoolExecutor vungleThreadPoolExecutor, DownloadResultListener downloadResultListener, AdPayload adPayload, int i2, Object obj) {
        mraidJsLoader.downloadJs(pathProvider, downloader, vungleThreadPoolExecutor, (i2 & 8) != 0 ? null : downloadResultListener, (i2 & 16) != 0 ? null : adPayload);
    }

    /* access modifiers changed from: private */
    /* renamed from: downloadJs$lambda-1  reason: not valid java name */
    public static final void m184downloadJs$lambda1(DownloadResultListener downloadResultListener, AdPayload adPayload, PathProvider pathProvider, Downloader downloader, VungleThreadPoolExecutor vungleThreadPoolExecutor) {
        Intrinsics.f(pathProvider, "$pathProvider");
        Intrinsics.f(downloader, "$downloader");
        Intrinsics.f(vungleThreadPoolExecutor, "$executor");
        if (downloadResultListener != null) {
            try {
                listeners.add(downloadResultListener);
            } catch (Exception e2) {
                Logger.Companion.e(TAG, "Failed to download mraid js", e2);
                return;
            }
        }
        boolean z2 = true;
        if (isDownloading.getAndSet(true)) {
            Logger.Companion.w(TAG, "mraid js is downloading, waiting for the previous request.");
            return;
        }
        ConfigManager configManager = ConfigManager.INSTANCE;
        String mraidEndpoint = configManager.getMraidEndpoint();
        if (mraidEndpoint != null) {
            if (mraidEndpoint.length() != 0) {
                z2 = false;
            }
        }
        LogEntry logEntry = null;
        if (z2) {
            MraidJsError mraidJsError = new MraidJsError(Sdk$SDKError.Reason.MRAID_DOWNLOAD_JS_ERROR, "Mraid endpoint is empty");
            if (adPayload != null) {
                logEntry = adPayload.getLogEntry$vungle_ads_release();
            }
            mraidJsError.setLogEntry$vungle_ads_release(logEntry).logErrorNoReturnValue$vungle_ads_release();
            INSTANCE.notifyListeners(11);
            return;
        }
        File file = new File(pathProvider.getJsAssetDir(configManager.getMraidJsVersion()), Constants.MRAID_JS_FILE_NAME);
        if (file.exists()) {
            Logger.Companion.w(TAG, "mraid js already downloaded");
            INSTANCE.notifyListeners(13);
            return;
        }
        File jsDir = pathProvider.getJsDir();
        FileUtility.deleteContents(jsDir);
        String absolutePath = file.getAbsolutePath();
        Intrinsics.e(absolutePath, "mraidJsFile.absolutePath");
        AdAsset adAsset = new AdAsset(Constants.MRAID_JS_FILE_NAME, mraidEndpoint + "/mraid.min.js", absolutePath, AdAsset.FileType.ASSET, true);
        DownloadRequest.Priority priority = DownloadRequest.Priority.HIGH;
        if (adPayload != null) {
            logEntry = adPayload.getLogEntry$vungle_ads_release();
        }
        downloader.download(new DownloadRequest(priority, adAsset, logEntry), new MraidJsLoader$downloadJs$1$2(vungleThreadPoolExecutor, adPayload, jsDir, file));
    }

    /* access modifiers changed from: private */
    public final void notifyListeners(int i2) {
        for (DownloadResultListener onDownloadResult : listeners) {
            onDownloadResult.onDownloadResult(i2);
        }
        listeners.clear();
        isDownloading.set(false);
    }

    public final void downloadJs(PathProvider pathProvider, Downloader downloader, VungleThreadPoolExecutor vungleThreadPoolExecutor, DownloadResultListener downloadResultListener, AdPayload adPayload) {
        Intrinsics.f(pathProvider, "pathProvider");
        Intrinsics.f(downloader, "downloader");
        Intrinsics.f(vungleThreadPoolExecutor, "executor");
        vungleThreadPoolExecutor.execute(new f(downloadResultListener, adPayload, pathProvider, downloader, vungleThreadPoolExecutor));
    }
}
