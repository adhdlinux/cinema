package com.vungle.ads.internal.load;

import com.vungle.ads.MraidJsError;
import com.vungle.ads.internal.downloader.AssetDownloadListener;
import com.vungle.ads.internal.downloader.DownloadRequest;
import com.vungle.ads.internal.executor.VungleThreadPoolExecutor;
import com.vungle.ads.internal.model.AdPayload;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import com.vungle.ads.internal.util.FileUtility;
import com.vungle.ads.internal.util.LogEntry;
import com.vungle.ads.internal.util.Logger;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

public final class MraidJsLoader$downloadJs$1$2 implements AssetDownloadListener {
    final /* synthetic */ AdPayload $advertisement;
    final /* synthetic */ VungleThreadPoolExecutor $executor;
    final /* synthetic */ File $jsPath;
    final /* synthetic */ File $mraidJsFile;

    MraidJsLoader$downloadJs$1$2(VungleThreadPoolExecutor vungleThreadPoolExecutor, AdPayload adPayload, File file, File file2) {
        this.$executor = vungleThreadPoolExecutor;
        this.$advertisement = adPayload;
        this.$jsPath = file;
        this.$mraidJsFile = file2;
    }

    /* access modifiers changed from: private */
    /* renamed from: onError$lambda-0  reason: not valid java name */
    public static final void m185onError$lambda0(AssetDownloadListener.DownloadError downloadError, DownloadRequest downloadRequest, AdPayload adPayload, File file) {
        Integer num;
        String str;
        Throwable cause;
        Intrinsics.f(downloadRequest, "$downloadRequest");
        Intrinsics.f(file, "$jsPath");
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("download mraid js error: ");
            LogEntry logEntry = null;
            if (downloadError != null) {
                num = Integer.valueOf(downloadError.getServerCode());
            } else {
                num = null;
            }
            sb.append(num);
            sb.append(". Failed to load ");
            sb.append(downloadRequest.getAsset().getServerPath());
            sb.append(", reason: ");
            if (downloadError == null || (cause = downloadError.getCause()) == null) {
                str = null;
            } else {
                str = cause.getMessage();
            }
            sb.append(str);
            String sb2 = sb.toString();
            Logger.Companion.d("MraidJsLoader", sb2);
            MraidJsError mraidJsError = new MraidJsError(Sdk$SDKError.Reason.MRAID_DOWNLOAD_JS_ERROR, sb2);
            if (adPayload != null) {
                logEntry = adPayload.getLogEntry$vungle_ads_release();
            }
            mraidJsError.setLogEntry$vungle_ads_release(logEntry).logErrorNoReturnValue$vungle_ads_release();
            FileUtility.deleteContents(file);
        } catch (Exception e2) {
            Logger.Companion.e("MraidJsLoader", "Failed to delete js assets", e2);
        } catch (Throwable th) {
            MraidJsLoader.INSTANCE.notifyListeners(12);
            throw th;
        }
        MraidJsLoader.INSTANCE.notifyListeners(12);
    }

    /* access modifiers changed from: private */
    /* renamed from: onSuccess$lambda-1  reason: not valid java name */
    public static final void m186onSuccess$lambda1(File file, File file2, AdPayload adPayload, File file3) {
        LogEntry logEntry;
        Intrinsics.f(file, "$file");
        Intrinsics.f(file2, "$mraidJsFile");
        Intrinsics.f(file3, "$jsPath");
        try {
            if (!file.exists() || file.length() <= 0) {
                Sdk$SDKError.Reason reason = Sdk$SDKError.Reason.MRAID_JS_WRITE_FAILED;
                MraidJsError mraidJsError = new MraidJsError(reason, "Mraid js downloaded but write failure: " + file2.getAbsolutePath());
                if (adPayload != null) {
                    logEntry = adPayload.getLogEntry$vungle_ads_release();
                } else {
                    logEntry = null;
                }
                mraidJsError.setLogEntry$vungle_ads_release(logEntry).logErrorNoReturnValue$vungle_ads_release();
                FileUtility.deleteContents(file3);
                MraidJsLoader.INSTANCE.notifyListeners(12);
                return;
            }
            MraidJsLoader.INSTANCE.notifyListeners(10);
        } catch (Exception e2) {
            Logger.Companion.e("MraidJsLoader", "Failed to delete js assets", e2);
            MraidJsLoader.INSTANCE.notifyListeners(12);
        }
    }

    public void onError(AssetDownloadListener.DownloadError downloadError, DownloadRequest downloadRequest) {
        Intrinsics.f(downloadRequest, "downloadRequest");
        this.$executor.execute(new g(downloadError, downloadRequest, this.$advertisement, this.$jsPath));
    }

    public void onSuccess(File file, DownloadRequest downloadRequest) {
        Intrinsics.f(file, "file");
        Intrinsics.f(downloadRequest, "downloadRequest");
        this.$executor.execute(new h(file, this.$mraidJsFile, this.$advertisement, this.$jsPath));
    }
}
