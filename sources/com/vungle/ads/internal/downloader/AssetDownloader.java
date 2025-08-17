package com.vungle.ads.internal.downloader;

import com.vungle.ads.NoSpaceError;
import com.vungle.ads.OutOfMemory;
import com.vungle.ads.internal.ConfigManager;
import com.vungle.ads.internal.downloader.AssetDownloadListener;
import com.vungle.ads.internal.executor.VungleThreadPoolExecutor;
import com.vungle.ads.internal.util.Logger;
import com.vungle.ads.internal.util.PathProvider;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Cache;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.RealResponseBody;
import okio.GzipSource;
import okio.Okio;

public final class AssetDownloader implements Downloader {
    private static final String CONTENT_ENCODING = "Content-Encoding";
    private static final String CONTENT_TYPE = "Content-Type";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int DOWNLOAD_CHUNK_SIZE = 2048;
    private static final String GZIP = "gzip";
    private static final int MINIMUM_SPACE_REQUIRED_MB = 20971520;
    private static final String TAG = "AssetDownloader";
    private final VungleThreadPoolExecutor downloadExecutor;
    private final Lazy okHttpClient$delegate = LazyKt__LazyJVMKt.b(new AssetDownloader$okHttpClient$2(this));
    /* access modifiers changed from: private */
    public final PathProvider pathProvider;
    private final List<DownloadRequest> transitioning = new ArrayList();

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private static final class OkHttpSingleton {
        public static final OkHttpSingleton INSTANCE = new OkHttpSingleton();
        private static OkHttpClient client;

        private OkHttpSingleton() {
        }

        public final OkHttpClient createOkHttpClient(PathProvider pathProvider) {
            Intrinsics.f(pathProvider, "pathProvider");
            OkHttpClient okHttpClient = client;
            if (okHttpClient != null) {
                return okHttpClient;
            }
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            TimeUnit timeUnit = TimeUnit.SECONDS;
            OkHttpClient.Builder followSslRedirects = builder.readTimeout(60, timeUnit).connectTimeout(60, timeUnit).cache((Cache) null).followRedirects(true).followSslRedirects(true);
            ConfigManager configManager = ConfigManager.INSTANCE;
            if (configManager.isCleverCacheEnabled()) {
                long cleverCacheDiskSize = configManager.getCleverCacheDiskSize();
                int cleverCacheDiskPercentage = configManager.getCleverCacheDiskPercentage();
                String absolutePath = pathProvider.getCleverCacheDir().getAbsolutePath();
                Intrinsics.e(absolutePath, "pathProvider.getCleverCacheDir().absolutePath");
                long min = Math.min(cleverCacheDiskSize, (pathProvider.getAvailableBytes(absolutePath) * ((long) cleverCacheDiskPercentage)) / ((long) 100));
                if (min > 0) {
                    followSslRedirects.cache(new Cache(pathProvider.getCleverCacheDir(), min));
                } else {
                    Logger.Companion.w("OkHttpClientWrapper", "cache disk capacity size <=0, no clever cache active.");
                }
            }
            OkHttpClient build = followSslRedirects.build();
            client = build;
            return build;
        }
    }

    public AssetDownloader(VungleThreadPoolExecutor vungleThreadPoolExecutor, PathProvider pathProvider2) {
        Intrinsics.f(vungleThreadPoolExecutor, "downloadExecutor");
        Intrinsics.f(pathProvider2, "pathProvider");
        this.downloadExecutor = vungleThreadPoolExecutor;
        this.pathProvider = pathProvider2;
    }

    private final boolean checkSpaceAvailable(DownloadRequest downloadRequest) {
        PathProvider pathProvider2 = this.pathProvider;
        String absolutePath = pathProvider2.getVungleDir().getAbsolutePath();
        Intrinsics.e(absolutePath, "pathProvider.getVungleDir().absolutePath");
        long availableBytes = pathProvider2.getAvailableBytes(absolutePath);
        if (availableBytes >= 20971520) {
            return true;
        }
        new NoSpaceError("Insufficient space " + availableBytes).setLogEntry$vungle_ads_release(downloadRequest.getLogEntry$vungle_ads_release()).logErrorNoReturnValue$vungle_ads_release();
        return false;
    }

    private final ResponseBody decodeGzipIfNeeded(Response response) {
        ResponseBody body = response.body();
        if (!StringsKt__StringsJVMKt.t(GZIP, Response.header$default(response, CONTENT_ENCODING, (String) null, 2, (Object) null), true) || body == null) {
            return body;
        }
        return new RealResponseBody(Response.header$default(response, "Content-Type", (String) null, 2, (Object) null), -1, Okio.d(new GzipSource(body.source())));
    }

    private final void deliverError(DownloadRequest downloadRequest, AssetDownloadListener assetDownloadListener, AssetDownloadListener.DownloadError downloadError) {
        if (assetDownloadListener != null) {
            assetDownloadListener.onError(downloadError, downloadRequest);
        }
    }

    private final void deliverSuccess(File file, DownloadRequest downloadRequest, AssetDownloadListener assetDownloadListener) {
        Logger.Companion companion = Logger.Companion;
        companion.d(TAG, "On success " + downloadRequest);
        if (assetDownloadListener != null) {
            assetDownloadListener.onSuccess(file, downloadRequest);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: download$lambda-0  reason: not valid java name */
    public static final void m172download$lambda0(AssetDownloader assetDownloader, DownloadRequest downloadRequest, AssetDownloadListener assetDownloadListener) {
        Intrinsics.f(assetDownloader, "this$0");
        assetDownloader.deliverError(downloadRequest, assetDownloadListener, new AssetDownloadListener.DownloadError(-1, new OutOfMemory("Cannot complete " + downloadRequest + " : Out of Memory"), AssetDownloadListener.DownloadError.ErrorReason.Companion.getINTERNAL_ERROR()));
    }

    private final OkHttpClient getOkHttpClient() {
        return (OkHttpClient) this.okHttpClient$delegate.getValue();
    }

    private final boolean isValidUrl(String str) {
        return !(str == null || str.length() == 0) && HttpUrl.Companion.parse(str) != null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v1, resolved type: okhttp3.Call} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: okio.BufferedSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: okio.BufferedSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v2, resolved type: okhttp3.Call} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v4, resolved type: okhttp3.Call} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v9, resolved type: okio.BufferedSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: okio.BufferedSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v5, resolved type: okhttp3.Call} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v10, resolved type: okhttp3.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v6, resolved type: okhttp3.Call} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v11, resolved type: okhttp3.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v12, resolved type: okhttp3.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v7, resolved type: okhttp3.Call} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v8, resolved type: okhttp3.Call} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v20, resolved type: okio.BufferedSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v9, resolved type: okhttp3.Call} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v10, resolved type: okhttp3.Call} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v12, resolved type: okhttp3.Call} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v16, resolved type: okhttp3.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v18, resolved type: okhttp3.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v23, resolved type: okio.BufferedSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v20, resolved type: okhttp3.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v29, resolved type: okhttp3.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v29, resolved type: okio.BufferedSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v30, resolved type: okhttp3.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v30, resolved type: okio.BufferedSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v31, resolved type: okio.BufferedSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v31, resolved type: okhttp3.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v32, resolved type: okio.BufferedSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v33, resolved type: okio.BufferedSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v14, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v34, resolved type: okio.BufferedSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v17, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v18, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v35, resolved type: okio.BufferedSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v36, resolved type: okio.BufferedSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v20, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v22, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v40, resolved type: okio.BufferedSink} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v24, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v47, resolved type: okio.BufferedSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v26, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v49, resolved type: okio.BufferedSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v38, resolved type: okhttp3.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v50, resolved type: okio.BufferedSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v41, resolved type: okhttp3.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v13, resolved type: okhttp3.Call} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v51, resolved type: okio.BufferedSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v42, resolved type: okhttp3.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v14, resolved type: okhttp3.Call} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v52, resolved type: okio.BufferedSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v48, resolved type: okio.BufferedSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v53, resolved type: okio.BufferedSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v50, resolved type: okio.BufferedSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v51, resolved type: okio.BufferedSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v55, resolved type: okio.BufferedSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v56, resolved type: okio.BufferedSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v52, resolved type: okhttp3.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v57, resolved type: okio.BufferedSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v53, resolved type: okhttp3.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v54, resolved type: okio.BufferedSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v56, resolved type: okio.BufferedSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v59, resolved type: okio.BufferedSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v60, resolved type: okio.BufferedSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v58, resolved type: okio.BufferedSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v60, resolved type: okio.BufferedSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v61, resolved type: okio.BufferedSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v61, resolved type: okio.BufferedSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v62, resolved type: okio.BufferedSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v63, resolved type: okio.BufferedSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v64, resolved type: okio.BufferedSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v65, resolved type: okio.BufferedSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v66, resolved type: okio.BufferedSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v67, resolved type: okio.BufferedSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v67, resolved type: okhttp3.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v68, resolved type: okhttp3.Response} */
    /* JADX WARNING: type inference failed for: r15v13 */
    /* JADX WARNING: type inference failed for: r15v19 */
    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x0213, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x0214, code lost:
        r10 = r26;
        r11 = r3;
        r1 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x0328, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x0329, code lost:
        r10 = r26;
        r11 = r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x0339, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x033a, code lost:
        r10 = r26;
        r11 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x033d, code lost:
        r16 = r14;
        r1 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x034a, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x034b, code lost:
        r10 = r26;
        r11 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x034f, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x0350, code lost:
        r10 = r26;
        r11 = r3;
        r2 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:202:0x0403, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:203:0x0404, code lost:
        r16 = r14;
        r1 = null;
        r4 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:204:0x040a, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:205:0x040b, code lost:
        r4 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:207:0x040f, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:208:0x0410, code lost:
        r10 = r2;
        r11 = r3;
        r2 = r4;
        r4 = r15;
        r3 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:210:0x041a, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:211:0x041b, code lost:
        r10 = r2;
        r11 = r3;
        r2 = r4;
        r16 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:213:0x0422, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:214:0x0423, code lost:
        r10 = r2;
        r11 = r3;
        r2 = r4;
        r3 = r1;
        r16 = r14;
        r1 = null;
        r4 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:235:0x0469, code lost:
        r21 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:237:?, code lost:
        new com.vungle.ads.AssetRequestError("Failed to load asset: " + r26.getAsset().getServerPath()).setLogEntry$vungle_ads_release(r26.getLogEntry$vungle_ads_release()).logErrorNoReturnValue$vungle_ads_release();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:238:0x0493, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:239:0x0494, code lost:
        r9 = r25;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:240:0x0498, code lost:
        r21 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:244:0x04a2, code lost:
        new com.vungle.ads.AssetFailedStatusCodeError(r8, java.lang.Integer.valueOf(r15), r0.getMessage()).setLogEntry$vungle_ads_release(r26.getLogEntry$vungle_ads_release()).logErrorNoReturnValue$vungle_ads_release();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:247:0x04d0, code lost:
        r0 = r13.body();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:248:0x04d5, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:254:0x04e5, code lost:
        r12.cancel();
        r0 = kotlin.Unit.f40298a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:257:0x0512, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:260:0x051b, code lost:
        r1 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:262:0x051e, code lost:
        r9 = r25;
        r9.deliverError(r10, r11, r3);
        r14 = r20;
        r2 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:263:0x0528, code lost:
        r9 = r25;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:264:0x052e, code lost:
        if (r0 == r2.getCANCELLED()) goto L_0x0530;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:265:0x0530, code lost:
        r0 = new java.lang.StringBuilder();
        r2 = r21;
        r0.append(r2);
        r0.append(r10);
        r14.d(TAG, r0.toString());
        r14 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:266:0x0547, code lost:
        r14 = r20;
        r2 = r21;
        r9.deliverSuccess(r14, r10, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:268:0x055c, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:269:0x055d, code lost:
        r9 = r25;
        r14 = r20;
        r2 = r21;
        r4 = r4;
        r1 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:276:0x056e, code lost:
        r17 = r13.body();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:277:0x0575, code lost:
        r17 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:283:0x0586, code lost:
        r12.cancel();
        r3 = kotlin.Unit.f40298a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:286:0x05b7, code lost:
        r19 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:289:0x05c1, code lost:
        r19 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:292:0x05c9, code lost:
        if (r3 == r4.getCANCELLED()) goto L_0x05cb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:293:0x05cb, code lost:
        r1.d(TAG, r2 + r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:294:0x05de, code lost:
        r9.deliverSuccess(r14, r10, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:295:0x05e2, code lost:
        r9.deliverError(r10, r11, r16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x01a0, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x01a1, code lost:
        r16 = r15;
        r10 = r2;
        r11 = r3;
        r2 = r4;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x0328 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:128:0x0290] */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x0339 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:98:0x0201] */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x034a A[ExcHandler: all (th java.lang.Throwable), PHI: r15 
      PHI: (r15v22 java.lang.Object) = (r15v24 java.lang.Object), (r15v26 java.lang.Object) binds: [B:95:0x01f9, B:89:0x01e4] A[DONT_GENERATE, DONT_INLINE], Splitter:B:89:0x01e4] */
    /* JADX WARNING: Removed duplicated region for block: B:202:0x0403 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:195:0x03bf] */
    /* JADX WARNING: Removed duplicated region for block: B:210:0x041a A[ExcHandler: all (th java.lang.Throwable), Splitter:B:47:0x0161] */
    /* JADX WARNING: Removed duplicated region for block: B:233:0x0467 A[SYNTHETIC, Splitter:B:233:0x0467] */
    /* JADX WARNING: Removed duplicated region for block: B:240:0x0498 A[Catch:{ all -> 0x0493, all -> 0x055c }] */
    /* JADX WARNING: Removed duplicated region for block: B:247:0x04d0  */
    /* JADX WARNING: Removed duplicated region for block: B:248:0x04d5  */
    /* JADX WARNING: Removed duplicated region for block: B:254:0x04e5  */
    /* JADX WARNING: Removed duplicated region for block: B:257:0x0512  */
    /* JADX WARNING: Removed duplicated region for block: B:260:0x051b  */
    /* JADX WARNING: Removed duplicated region for block: B:262:0x051e  */
    /* JADX WARNING: Removed duplicated region for block: B:263:0x0528  */
    /* JADX WARNING: Removed duplicated region for block: B:276:0x056e  */
    /* JADX WARNING: Removed duplicated region for block: B:277:0x0575  */
    /* JADX WARNING: Removed duplicated region for block: B:283:0x0586  */
    /* JADX WARNING: Removed duplicated region for block: B:286:0x05b7  */
    /* JADX WARNING: Removed duplicated region for block: B:289:0x05c1  */
    /* JADX WARNING: Removed duplicated region for block: B:291:0x05c5  */
    /* JADX WARNING: Removed duplicated region for block: B:295:0x05e2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void launchRequest(com.vungle.ads.internal.downloader.DownloadRequest r26, com.vungle.ads.internal.downloader.AssetDownloadListener r27) {
        /*
            r25 = this;
            r1 = r25
            r2 = r26
            r3 = r27
            java.lang.String r4 = "On cancel "
            java.lang.String r5 = "download status: "
            com.vungle.ads.internal.util.Logger$Companion r0 = com.vungle.ads.internal.util.Logger.Companion
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "launch request in thread: "
            r6.append(r7)
            java.lang.Thread r7 = java.lang.Thread.currentThread()
            long r7 = r7.getId()
            r6.append(r7)
            java.lang.String r7 = " request: "
            r6.append(r7)
            com.vungle.ads.internal.model.AdAsset r7 = r26.getAsset()
            java.lang.String r7 = r7.getServerPath()
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            java.lang.String r7 = "AssetDownloader"
            r0.d(r7, r6)
            boolean r6 = r26.isCancelled()
            if (r6 == 0) goto L_0x0070
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Request "
            r3.append(r4)
            com.vungle.ads.internal.model.AdAsset r2 = r26.getAsset()
            java.lang.String r2 = r2.getServerPath()
            r3.append(r2)
            java.lang.String r2 = " is cancelled before starting"
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            r0.d(r7, r2)
            com.vungle.ads.internal.downloader.AssetDownloadListener$Progress r0 = new com.vungle.ads.internal.downloader.AssetDownloadListener$Progress
            r0.<init>()
            com.vungle.ads.internal.downloader.AssetDownloadListener$Progress$ProgressStatus$Companion r2 = com.vungle.ads.internal.downloader.AssetDownloadListener.Progress.ProgressStatus.Companion
            int r2 = r2.getCANCELLED()
            r0.setStatus(r2)
            return
        L_0x0070:
            com.vungle.ads.internal.downloader.AssetDownloadListener$Progress r6 = new com.vungle.ads.internal.downloader.AssetDownloadListener$Progress
            r6.<init>()
            long r8 = java.lang.System.currentTimeMillis()
            r6.setTimestampDownloadStart(r8)
            com.vungle.ads.internal.model.AdAsset r0 = r26.getAsset()
            java.lang.String r8 = r0.getServerPath()
            com.vungle.ads.internal.model.AdAsset r0 = r26.getAsset()
            java.lang.String r0 = r0.getLocalPath()
            int r9 = r8.length()
            r11 = 1
            if (r9 != 0) goto L_0x0095
            r9 = 1
            goto L_0x0096
        L_0x0095:
            r9 = 0
        L_0x0096:
            r12 = -1
            if (r9 != 0) goto L_0x05ea
            boolean r9 = r1.isValidUrl(r8)
            if (r9 != 0) goto L_0x00a1
            goto L_0x05ea
        L_0x00a1:
            int r9 = r0.length()
            if (r9 != 0) goto L_0x00a9
            r9 = 1
            goto L_0x00aa
        L_0x00a9:
            r9 = 0
        L_0x00aa:
            if (r9 == 0) goto L_0x00df
            com.vungle.ads.internal.downloader.AssetDownloadListener$DownloadError r4 = new com.vungle.ads.internal.downloader.AssetDownloadListener$DownloadError
            com.vungle.ads.AssetDownloadError r5 = new com.vungle.ads.AssetDownloadError
            com.vungle.ads.internal.protos.Sdk$SDKError$Reason r6 = com.vungle.ads.internal.protos.Sdk$SDKError.Reason.ASSET_WRITE_ERROR
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "invalid path: "
            r7.append(r8)
            r7.append(r0)
            java.lang.String r0 = r7.toString()
            r5.<init>(r6, r0)
            com.vungle.ads.internal.util.LogEntry r0 = r26.getLogEntry$vungle_ads_release()
            com.vungle.ads.VungleError r0 = r5.setLogEntry$vungle_ads_release(r0)
            com.vungle.ads.VungleError r0 = r0.logError$vungle_ads_release()
            com.vungle.ads.internal.downloader.AssetDownloadListener$DownloadError$ErrorReason$Companion r5 = com.vungle.ads.internal.downloader.AssetDownloadListener.DownloadError.ErrorReason.Companion
            int r5 = r5.getFILE_NOT_FOUND_ERROR()
            r4.<init>(r12, r0, r5)
            r1.deliverError(r2, r3, r4)
            return
        L_0x00df:
            boolean r9 = r25.checkSpaceAvailable(r26)
            r13 = 0
            if (r9 != 0) goto L_0x0106
            com.vungle.ads.internal.downloader.AssetDownloadListener$DownloadError r0 = new com.vungle.ads.internal.downloader.AssetDownloadListener$DownloadError
            com.vungle.ads.NoSpaceError r4 = new com.vungle.ads.NoSpaceError
            r4.<init>(r13, r11, r13)
            com.vungle.ads.internal.util.LogEntry r5 = r26.getLogEntry$vungle_ads_release()
            com.vungle.ads.VungleError r4 = r4.setLogEntry$vungle_ads_release(r5)
            com.vungle.ads.VungleError r4 = r4.logError$vungle_ads_release()
            com.vungle.ads.internal.downloader.AssetDownloadListener$DownloadError$ErrorReason$Companion r5 = com.vungle.ads.internal.downloader.AssetDownloadListener.DownloadError.ErrorReason.Companion
            int r5 = r5.getDISK_ERROR()
            r0.<init>(r12, r4, r5)
            r1.deliverError(r2, r3, r0)
            return
        L_0x0106:
            java.io.File r9 = new java.io.File
            r9.<init>(r0)
            r14 = r13
            r0 = 0
        L_0x010d:
            if (r0 != 0) goto L_0x05e8
            java.io.File r0 = r9.getParentFile()     // Catch:{ Exception -> 0x044c, all -> 0x043e }
            if (r0 == 0) goto L_0x0139
            boolean r15 = r0.exists()     // Catch:{ Exception -> 0x012c, all -> 0x011f }
            if (r15 != 0) goto L_0x0139
            r0.mkdirs()     // Catch:{ Exception -> 0x012c, all -> 0x011f }
            goto L_0x0139
        L_0x011f:
            r0 = move-exception
            r10 = r2
            r11 = r3
            r2 = r4
            r4 = r13
            r12 = r4
            r16 = r14
            r14 = r9
            r9 = r1
            r1 = r12
            goto L_0x056c
        L_0x012c:
            r0 = move-exception
            r10 = r2
            r11 = r3
            r2 = r4
            r4 = r13
            r12 = r4
            r16 = r14
            r15 = -1
            r3 = r1
            r1 = r12
            goto L_0x0458
        L_0x0139:
            boolean r0 = r9.exists()     // Catch:{ Exception -> 0x044c, all -> 0x043e }
            if (r0 == 0) goto L_0x0146
            long r17 = r9.length()     // Catch:{ Exception -> 0x012c, all -> 0x011f }
            r10 = r17
            goto L_0x0148
        L_0x0146:
            r10 = 0
        L_0x0148:
            okhttp3.Request$Builder r0 = new okhttp3.Request$Builder     // Catch:{ Exception -> 0x044c, all -> 0x043e }
            r0.<init>()     // Catch:{ Exception -> 0x044c, all -> 0x043e }
            okhttp3.Request$Builder r0 = r0.url((java.lang.String) r8)     // Catch:{ Exception -> 0x044c, all -> 0x043e }
            okhttp3.OkHttpClient r12 = r25.getOkHttpClient()     // Catch:{ Exception -> 0x044c, all -> 0x043e }
            okhttp3.Request r0 = r0.build()     // Catch:{ Exception -> 0x044c, all -> 0x043e }
            okhttp3.Call r12 = r12.newCall(r0)     // Catch:{ Exception -> 0x044c, all -> 0x043e }
            okhttp3.Response r13 = r12.execute()     // Catch:{ Exception -> 0x0434, all -> 0x042c }
            int r15 = r13.code()     // Catch:{ Exception -> 0x0422, all -> 0x041a }
            boolean r0 = r13.isSuccessful()     // Catch:{ Exception -> 0x040f, all -> 0x041a }
            if (r0 == 0) goto L_0x03b8
            okhttp3.Response r0 = r13.cacheResponse()     // Catch:{ Exception -> 0x03a8, all -> 0x039b }
            if (r0 == 0) goto L_0x01ad
            com.vungle.ads.AnalyticsClient r0 = com.vungle.ads.AnalyticsClient.INSTANCE     // Catch:{ Exception -> 0x01a0, all -> 0x041a }
            r16 = r15
            com.vungle.ads.SingleValueMetric r15 = new com.vungle.ads.SingleValueMetric     // Catch:{ Exception -> 0x0199, all -> 0x041a }
            r21 = r4
            com.vungle.ads.internal.protos.Sdk$SDKMetric$SDKMetricType r4 = com.vungle.ads.internal.protos.Sdk$SDKMetric.SDKMetricType.CACHED_ASSETS_USED     // Catch:{ Exception -> 0x0191, all -> 0x0188 }
            r15.<init>(r4)     // Catch:{ Exception -> 0x0191, all -> 0x0188 }
            com.vungle.ads.internal.util.LogEntry r4 = r26.getLogEntry$vungle_ads_release()     // Catch:{ Exception -> 0x0191, all -> 0x0188 }
            r0.logMetric$vungle_ads_release((com.vungle.ads.SingleValueMetric) r15, (com.vungle.ads.internal.util.LogEntry) r4, (java.lang.String) r8)     // Catch:{ Exception -> 0x0191, all -> 0x0188 }
            kotlin.Unit r0 = kotlin.Unit.f40298a     // Catch:{ Exception -> 0x0191, all -> 0x0188 }
            goto L_0x01b1
        L_0x0188:
            r0 = move-exception
            r10 = r2
            r11 = r3
            r16 = r14
            r2 = r21
            goto L_0x0420
        L_0x0191:
            r0 = move-exception
            r10 = r2
            r11 = r3
            r15 = r16
            r2 = r21
            goto L_0x01a6
        L_0x0199:
            r0 = move-exception
            r10 = r2
            r11 = r3
            r2 = r4
            r15 = r16
            goto L_0x01a6
        L_0x01a0:
            r0 = move-exception
            r16 = r15
            r10 = r2
            r11 = r3
            r2 = r4
        L_0x01a6:
            r4 = 0
            r3 = r1
            r16 = r14
            r1 = 0
            goto L_0x0458
        L_0x01ad:
            r21 = r4
            r16 = r15
        L_0x01b1:
            okhttp3.ResponseBody r0 = r1.decodeGzipIfNeeded(r13)     // Catch:{ Exception -> 0x0395, all -> 0x038b }
            if (r0 == 0) goto L_0x01bc
            okio.BufferedSource r4 = r0.source()     // Catch:{ Exception -> 0x0191, all -> 0x0188 }
            goto L_0x01bd
        L_0x01bc:
            r4 = 0
        L_0x01bd:
            com.vungle.ads.internal.util.Logger$Companion r15 = com.vungle.ads.internal.util.Logger.Companion     // Catch:{ Exception -> 0x0382, all -> 0x0375 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x036c, all -> 0x035e }
            r1.<init>()     // Catch:{ Exception -> 0x036c, all -> 0x035e }
            java.lang.String r2 = "Start download from bytes:"
            r1.append(r2)     // Catch:{ Exception -> 0x035a, all -> 0x0356 }
            r1.append(r10)     // Catch:{ Exception -> 0x035a, all -> 0x0356 }
            java.lang.String r2 = ", url: "
            r1.append(r2)     // Catch:{ Exception -> 0x035a, all -> 0x0356 }
            r1.append(r8)     // Catch:{ Exception -> 0x035a, all -> 0x0356 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x035a, all -> 0x0356 }
            r15.d(r7, r1)     // Catch:{ Exception -> 0x035a, all -> 0x0356 }
            r1 = 0
            int r15 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r15 != 0) goto L_0x01f6
            r1 = 0
            r2 = 1
            r15 = 0
            okio.Sink r17 = okio.Okio__JvmOkioKt.h(r9, r1, r2, r15)     // Catch:{ Exception -> 0x01e9, all -> 0x034a }
            goto L_0x01fd
        L_0x01e9:
            r0 = move-exception
            r10 = r26
            r11 = r3
            r1 = r15
        L_0x01ee:
            r15 = r16
            r2 = r21
            r3 = r25
            goto L_0x03b4
        L_0x01f6:
            r1 = 0
            r2 = 1
            r15 = 0
            okio.Sink r17 = okio.Okio.a(r9)     // Catch:{ Exception -> 0x034f, all -> 0x034a }
        L_0x01fd:
            okio.BufferedSink r1 = okio.Okio.c(r17)     // Catch:{ Exception -> 0x034f, all -> 0x034a }
            com.vungle.ads.internal.downloader.AssetDownloadListener$Progress$ProgressStatus$Companion r17 = com.vungle.ads.internal.downloader.AssetDownloadListener.Progress.ProgressStatus.Companion     // Catch:{ Exception -> 0x0340, all -> 0x0339 }
            int r2 = r17.getSTARTED()     // Catch:{ Exception -> 0x0340, all -> 0x0339 }
            r6.setStatus(r2)     // Catch:{ Exception -> 0x0340, all -> 0x0339 }
            if (r0 == 0) goto L_0x0218
            long r22 = r0.contentLength()     // Catch:{ Exception -> 0x0213, all -> 0x0339 }
            r2 = r22
            goto L_0x021a
        L_0x0213:
            r0 = move-exception
            r10 = r26
            r11 = r3
            goto L_0x01ee
        L_0x0218:
            r2 = 0
        L_0x021a:
            r6.setSizeBytes(r2)     // Catch:{ Exception -> 0x032e, all -> 0x0328 }
            r6.setStartBytes(r10)     // Catch:{ Exception -> 0x032e, all -> 0x0328 }
        L_0x0220:
            if (r4 == 0) goto L_0x023a
            okio.Buffer r0 = r1.c()     // Catch:{ Exception -> 0x022d, all -> 0x0328 }
            r2 = 2048(0x800, double:1.0118E-320)
            long r2 = r4.read(r0, r2)     // Catch:{ Exception -> 0x022d, all -> 0x0328 }
            goto L_0x023c
        L_0x022d:
            r0 = move-exception
            r3 = r25
            r10 = r26
            r11 = r27
            r15 = r16
            r2 = r21
            goto L_0x03b4
        L_0x023a:
            r2 = -1
        L_0x023c:
            kotlin.Unit r0 = kotlin.Unit.f40298a     // Catch:{ Exception -> 0x032e, all -> 0x0328 }
            r10 = 0
            int r0 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1))
            if (r0 <= 0) goto L_0x0290
            boolean r0 = r9.exists()     // Catch:{ Exception -> 0x022d, all -> 0x0328 }
            if (r0 == 0) goto L_0x0267
            boolean r0 = r26.isCancelled()     // Catch:{ Exception -> 0x022d, all -> 0x0328 }
            if (r0 == 0) goto L_0x025a
            com.vungle.ads.internal.downloader.AssetDownloadListener$Progress$ProgressStatus$Companion r0 = com.vungle.ads.internal.downloader.AssetDownloadListener.Progress.ProgressStatus.Companion     // Catch:{ Exception -> 0x022d, all -> 0x0328 }
            int r0 = r0.getCANCELLED()     // Catch:{ Exception -> 0x022d, all -> 0x0328 }
            r6.setStatus(r0)     // Catch:{ Exception -> 0x022d, all -> 0x0328 }
            goto L_0x0290
        L_0x025a:
            com.vungle.ads.internal.downloader.AssetDownloadListener$Progress$ProgressStatus$Companion r0 = com.vungle.ads.internal.downloader.AssetDownloadListener.Progress.ProgressStatus.Companion     // Catch:{ Exception -> 0x022d, all -> 0x0328 }
            int r0 = r0.getIN_PROGRESS()     // Catch:{ Exception -> 0x022d, all -> 0x0328 }
            r6.setStatus(r0)     // Catch:{ Exception -> 0x022d, all -> 0x0328 }
            r1.h()     // Catch:{ Exception -> 0x022d, all -> 0x0328 }
            goto L_0x0220
        L_0x0267:
            com.vungle.ads.AssetWriteError r0 = new com.vungle.ads.AssetWriteError     // Catch:{ Exception -> 0x022d, all -> 0x0328 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x022d, all -> 0x0328 }
            r2.<init>()     // Catch:{ Exception -> 0x022d, all -> 0x0328 }
            java.lang.String r3 = "Asset save error "
            r2.append(r3)     // Catch:{ Exception -> 0x022d, all -> 0x0328 }
            r2.append(r8)     // Catch:{ Exception -> 0x022d, all -> 0x0328 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x022d, all -> 0x0328 }
            r0.<init>(r2)     // Catch:{ Exception -> 0x022d, all -> 0x0328 }
            com.vungle.ads.internal.util.LogEntry r2 = r26.getLogEntry$vungle_ads_release()     // Catch:{ Exception -> 0x022d, all -> 0x0328 }
            com.vungle.ads.VungleError r0 = r0.setLogEntry$vungle_ads_release(r2)     // Catch:{ Exception -> 0x022d, all -> 0x0328 }
            r0.logErrorNoReturnValue$vungle_ads_release()     // Catch:{ Exception -> 0x022d, all -> 0x0328 }
            com.vungle.ads.internal.downloader.Downloader$RequestException r0 = new com.vungle.ads.internal.downloader.Downloader$RequestException     // Catch:{ Exception -> 0x022d, all -> 0x0328 }
            java.lang.String r2 = "File is not existing"
            r0.<init>(r2)     // Catch:{ Exception -> 0x022d, all -> 0x0328 }
            throw r0     // Catch:{ Exception -> 0x022d, all -> 0x0328 }
        L_0x0290:
            r1.flush()     // Catch:{ Exception -> 0x032e, all -> 0x0328 }
            int r0 = r6.getStatus()     // Catch:{ Exception -> 0x032e, all -> 0x0328 }
            com.vungle.ads.internal.downloader.AssetDownloadListener$Progress$ProgressStatus$Companion r2 = com.vungle.ads.internal.downloader.AssetDownloadListener.Progress.ProgressStatus.Companion     // Catch:{ Exception -> 0x032e, all -> 0x0328 }
            int r3 = r2.getIN_PROGRESS()     // Catch:{ Exception -> 0x032e, all -> 0x0328 }
            if (r0 != r3) goto L_0x02a6
            int r0 = r2.getDONE()     // Catch:{ Exception -> 0x022d, all -> 0x0328 }
            r6.setStatus(r0)     // Catch:{ Exception -> 0x022d, all -> 0x0328 }
        L_0x02a6:
            okhttp3.ResponseBody r0 = r13.body()
            if (r0 == 0) goto L_0x02b5
            okhttp3.ResponseBody r0 = r13.body()
            if (r0 == 0) goto L_0x02b5
            r0.close()
        L_0x02b5:
            r12.cancel()
            com.vungle.ads.internal.util.FileUtility r0 = com.vungle.ads.internal.util.FileUtility.INSTANCE
            r0.closeQuietly(r1)
            r0.closeQuietly(r4)
            com.vungle.ads.internal.util.Logger$Companion r0 = com.vungle.ads.internal.util.Logger.Companion
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r5)
            int r3 = r6.getStatus()
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            r0.d(r7, r1)
            int r1 = r6.getStatus()
            int r3 = r2.getERROR()
            if (r1 != r3) goto L_0x02e4
        L_0x02e2:
            r3 = 1
            goto L_0x02ec
        L_0x02e4:
            int r3 = r2.getSTARTED()
            if (r1 != r3) goto L_0x02eb
            goto L_0x02e2
        L_0x02eb:
            r3 = 0
        L_0x02ec:
            if (r3 == 0) goto L_0x02fa
            r3 = r25
            r10 = r26
            r11 = r27
            r3.deliverError(r10, r11, r14)
            r2 = r21
            goto L_0x0320
        L_0x02fa:
            r3 = r25
            r10 = r26
            r11 = r27
            int r2 = r2.getCANCELLED()
            if (r1 != r2) goto L_0x031b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r2 = r21
            r1.append(r2)
            r1.append(r10)
            java.lang.String r1 = r1.toString()
            r0.d(r7, r1)
            goto L_0x0320
        L_0x031b:
            r2 = r21
            r3.deliverSuccess(r9, r10, r11)
        L_0x0320:
            r24 = r9
            r9 = r3
            r3 = r14
            r14 = r24
            goto L_0x054e
        L_0x0328:
            r0 = move-exception
            r10 = r26
            r11 = r27
            goto L_0x033d
        L_0x032e:
            r0 = move-exception
            r3 = r25
            r10 = r26
            r11 = r27
            r2 = r21
            goto L_0x03b2
        L_0x0339:
            r0 = move-exception
            r10 = r26
            r11 = r3
        L_0x033d:
            r16 = r14
            goto L_0x0365
        L_0x0340:
            r0 = move-exception
            r10 = r26
            r11 = r3
            r2 = r21
            r3 = r25
            goto L_0x03b2
        L_0x034a:
            r0 = move-exception
            r10 = r26
            r11 = r3
            goto L_0x0362
        L_0x034f:
            r0 = move-exception
            r10 = r26
            r11 = r3
            r2 = r21
            goto L_0x0372
        L_0x0356:
            r0 = move-exception
            r10 = r26
            goto L_0x0360
        L_0x035a:
            r0 = move-exception
            r10 = r26
            goto L_0x036e
        L_0x035e:
            r0 = move-exception
            r10 = r2
        L_0x0360:
            r11 = r3
            r15 = 0
        L_0x0362:
            r16 = r14
            r1 = r15
        L_0x0365:
            r2 = r21
            r14 = r9
            r9 = r25
            goto L_0x056c
        L_0x036c:
            r0 = move-exception
            r10 = r2
        L_0x036e:
            r11 = r3
            r2 = r21
            r15 = 0
        L_0x0372:
            r3 = r25
            goto L_0x0389
        L_0x0375:
            r0 = move-exception
            r10 = r2
            r11 = r3
            r15 = 0
            r16 = r14
            r2 = r21
            r14 = r9
            r9 = r1
            r1 = r15
            goto L_0x056c
        L_0x0382:
            r0 = move-exception
            r10 = r2
            r11 = r3
            r2 = r21
            r15 = 0
            r3 = r1
        L_0x0389:
            r1 = r15
            goto L_0x03b2
        L_0x038b:
            r0 = move-exception
            r10 = r2
            r11 = r3
            r15 = 0
            r16 = r14
            r4 = r15
            r2 = r21
            goto L_0x03a3
        L_0x0395:
            r0 = move-exception
            r10 = r2
            r11 = r3
            r2 = r21
            goto L_0x03ae
        L_0x039b:
            r0 = move-exception
            r10 = r2
            r11 = r3
            r15 = 0
            r2 = r4
            r16 = r14
            r4 = r15
        L_0x03a3:
            r14 = r9
            r9 = r1
            r1 = r4
            goto L_0x056c
        L_0x03a8:
            r0 = move-exception
            r10 = r2
            r11 = r3
            r2 = r4
            r16 = r15
        L_0x03ae:
            r15 = 0
            r3 = r1
            r1 = r15
            r4 = r1
        L_0x03b2:
            r15 = r16
        L_0x03b4:
            r16 = r14
            goto L_0x0458
        L_0x03b8:
            r10 = r2
            r11 = r3
            r2 = r4
            r16 = r15
            r15 = 0
            r3 = r1
            com.vungle.ads.AssetFailedStatusCodeError r0 = new com.vungle.ads.AssetFailedStatusCodeError     // Catch:{ Exception -> 0x040a, all -> 0x0403 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r16)     // Catch:{ Exception -> 0x040a, all -> 0x0403 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x040a, all -> 0x0403 }
            r4.<init>()     // Catch:{ Exception -> 0x040a, all -> 0x0403 }
            java.lang.String r15 = "Asset download does not success: "
            r4.append(r15)     // Catch:{ Exception -> 0x040a, all -> 0x0403 }
            java.lang.String r15 = r13.message()     // Catch:{ Exception -> 0x040a, all -> 0x0403 }
            r4.append(r15)     // Catch:{ Exception -> 0x040a, all -> 0x0403 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x040a, all -> 0x0403 }
            r0.<init>(r8, r1, r4)     // Catch:{ Exception -> 0x040a, all -> 0x0403 }
            com.vungle.ads.internal.util.LogEntry r1 = r26.getLogEntry$vungle_ads_release()     // Catch:{ Exception -> 0x040a, all -> 0x0403 }
            com.vungle.ads.VungleError r0 = r0.setLogEntry$vungle_ads_release(r1)     // Catch:{ Exception -> 0x040a, all -> 0x0403 }
            r0.logErrorNoReturnValue$vungle_ads_release()     // Catch:{ Exception -> 0x040a, all -> 0x0403 }
            com.vungle.ads.internal.downloader.Downloader$RequestException r0 = new com.vungle.ads.internal.downloader.Downloader$RequestException     // Catch:{ Exception -> 0x040a, all -> 0x0403 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x040a, all -> 0x0403 }
            r1.<init>()     // Catch:{ Exception -> 0x040a, all -> 0x0403 }
            java.lang.String r4 = "Code: "
            r1.append(r4)     // Catch:{ Exception -> 0x040a, all -> 0x0403 }
            r4 = r16
            r1.append(r4)     // Catch:{ Exception -> 0x0401, all -> 0x0403 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0401, all -> 0x0403 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x0401, all -> 0x0403 }
            throw r0     // Catch:{ Exception -> 0x0401, all -> 0x0403 }
        L_0x0401:
            r0 = move-exception
            goto L_0x040d
        L_0x0403:
            r0 = move-exception
            r16 = r14
            r1 = 0
            r4 = 0
            goto L_0x056a
        L_0x040a:
            r0 = move-exception
            r4 = r16
        L_0x040d:
            r15 = r4
            goto L_0x0415
        L_0x040f:
            r0 = move-exception
            r10 = r2
            r11 = r3
            r2 = r4
            r4 = r15
            r3 = r1
        L_0x0415:
            r16 = r14
            r1 = 0
            r4 = 0
            goto L_0x0458
        L_0x041a:
            r0 = move-exception
            r10 = r2
            r11 = r3
            r2 = r4
            r16 = r14
        L_0x0420:
            r4 = 0
            goto L_0x0447
        L_0x0422:
            r0 = move-exception
            r10 = r2
            r11 = r3
            r2 = r4
            r3 = r1
            r16 = r14
            r1 = 0
            r4 = 0
            goto L_0x0457
        L_0x042c:
            r0 = move-exception
            r10 = r2
            r11 = r3
            r2 = r4
            r16 = r14
            r4 = 0
            goto L_0x0446
        L_0x0434:
            r0 = move-exception
            r10 = r2
            r11 = r3
            r2 = r4
            r3 = r1
            r16 = r14
            r1 = 0
            r4 = 0
            goto L_0x0456
        L_0x043e:
            r0 = move-exception
            r10 = r2
            r11 = r3
            r2 = r4
            r16 = r14
            r4 = 0
            r12 = 0
        L_0x0446:
            r13 = 0
        L_0x0447:
            r14 = r9
            r9 = r1
            r1 = 0
            goto L_0x056c
        L_0x044c:
            r0 = move-exception
            r10 = r2
            r11 = r3
            r2 = r4
            r3 = r1
            r16 = r14
            r1 = 0
            r4 = 0
            r12 = 0
        L_0x0456:
            r13 = 0
        L_0x0457:
            r15 = -1
        L_0x0458:
            com.vungle.ads.internal.util.Logger$Companion r14 = com.vungle.ads.internal.util.Logger.Companion     // Catch:{ all -> 0x0569 }
            r20 = r9
            java.lang.String r9 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x0564 }
            r14.e(r7, r9)     // Catch:{ all -> 0x0564 }
            boolean r9 = r0 instanceof java.net.ProtocolException     // Catch:{ all -> 0x0564 }
            if (r9 == 0) goto L_0x0498
            com.vungle.ads.AssetRequestError r9 = new com.vungle.ads.AssetRequestError     // Catch:{ all -> 0x0493 }
            r21 = r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x055c }
            r2.<init>()     // Catch:{ all -> 0x055c }
            java.lang.String r3 = "Failed to load asset: "
            r2.append(r3)     // Catch:{ all -> 0x055c }
            com.vungle.ads.internal.model.AdAsset r3 = r26.getAsset()     // Catch:{ all -> 0x055c }
            java.lang.String r3 = r3.getServerPath()     // Catch:{ all -> 0x055c }
            r2.append(r3)     // Catch:{ all -> 0x055c }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x055c }
            r9.<init>(r2)     // Catch:{ all -> 0x055c }
            com.vungle.ads.internal.util.LogEntry r2 = r26.getLogEntry$vungle_ads_release()     // Catch:{ all -> 0x055c }
            com.vungle.ads.VungleError r2 = r9.setLogEntry$vungle_ads_release(r2)     // Catch:{ all -> 0x055c }
            r2.logErrorNoReturnValue$vungle_ads_release()     // Catch:{ all -> 0x055c }
            goto L_0x04ba
        L_0x0493:
            r0 = move-exception
            r9 = r25
            goto L_0x0566
        L_0x0498:
            r21 = r2
            boolean r2 = r0 instanceof java.net.UnknownHostException     // Catch:{ all -> 0x055c }
            if (r2 != 0) goto L_0x04a2
            boolean r2 = r0 instanceof java.io.IOException     // Catch:{ all -> 0x055c }
            if (r2 == 0) goto L_0x04ba
        L_0x04a2:
            com.vungle.ads.AssetFailedStatusCodeError r2 = new com.vungle.ads.AssetFailedStatusCodeError     // Catch:{ all -> 0x055c }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r15)     // Catch:{ all -> 0x055c }
            java.lang.String r9 = r0.getMessage()     // Catch:{ all -> 0x055c }
            r2.<init>(r8, r3, r9)     // Catch:{ all -> 0x055c }
            com.vungle.ads.internal.util.LogEntry r3 = r26.getLogEntry$vungle_ads_release()     // Catch:{ all -> 0x055c }
            com.vungle.ads.VungleError r2 = r2.setLogEntry$vungle_ads_release(r3)     // Catch:{ all -> 0x055c }
            r2.logErrorNoReturnValue$vungle_ads_release()     // Catch:{ all -> 0x055c }
        L_0x04ba:
            com.vungle.ads.internal.downloader.AssetDownloadListener$Progress$ProgressStatus$Companion r2 = com.vungle.ads.internal.downloader.AssetDownloadListener.Progress.ProgressStatus.Companion     // Catch:{ all -> 0x055c }
            int r3 = r2.getERROR()     // Catch:{ all -> 0x055c }
            r6.setStatus(r3)     // Catch:{ all -> 0x055c }
            com.vungle.ads.internal.downloader.AssetDownloadListener$DownloadError r3 = new com.vungle.ads.internal.downloader.AssetDownloadListener$DownloadError     // Catch:{ all -> 0x055c }
            com.vungle.ads.internal.downloader.AssetDownloadListener$DownloadError$ErrorReason$Companion r9 = com.vungle.ads.internal.downloader.AssetDownloadListener.DownloadError.ErrorReason.Companion     // Catch:{ all -> 0x055c }
            int r9 = r9.getREQUEST_ERROR()     // Catch:{ all -> 0x055c }
            r3.<init>(r15, r0, r9)     // Catch:{ all -> 0x055c }
            if (r13 == 0) goto L_0x04d5
            okhttp3.ResponseBody r0 = r13.body()
            goto L_0x04d6
        L_0x04d5:
            r0 = 0
        L_0x04d6:
            if (r0 == 0) goto L_0x04e3
            okhttp3.ResponseBody r0 = r13.body()
            if (r0 == 0) goto L_0x04e3
            r0.close()
            kotlin.Unit r0 = kotlin.Unit.f40298a
        L_0x04e3:
            if (r12 == 0) goto L_0x04ea
            r12.cancel()
            kotlin.Unit r0 = kotlin.Unit.f40298a
        L_0x04ea:
            com.vungle.ads.internal.util.FileUtility r0 = com.vungle.ads.internal.util.FileUtility.INSTANCE
            r0.closeQuietly(r1)
            r0.closeQuietly(r4)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r5)
            int r1 = r6.getStatus()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r14.d(r7, r0)
            int r0 = r6.getStatus()
            int r1 = r2.getERROR()
            if (r0 != r1) goto L_0x0514
        L_0x0512:
            r1 = 1
            goto L_0x051c
        L_0x0514:
            int r1 = r2.getSTARTED()
            if (r0 != r1) goto L_0x051b
            goto L_0x0512
        L_0x051b:
            r1 = 0
        L_0x051c:
            if (r1 == 0) goto L_0x0528
            r9 = r25
            r9.deliverError(r10, r11, r3)
            r14 = r20
            r2 = r21
            goto L_0x054e
        L_0x0528:
            r9 = r25
            int r1 = r2.getCANCELLED()
            if (r0 != r1) goto L_0x0547
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r2 = r21
            r0.append(r2)
            r0.append(r10)
            java.lang.String r0 = r0.toString()
            r14.d(r7, r0)
            r14 = r20
            goto L_0x054e
        L_0x0547:
            r14 = r20
            r2 = r21
            r9.deliverSuccess(r14, r10, r11)
        L_0x054e:
            kotlin.Unit r0 = kotlin.Unit.f40298a
            r4 = r2
            r1 = r9
            r2 = r10
            r9 = r14
            r0 = 1
            r12 = -1
            r13 = 0
            r14 = r3
            r3 = r11
            r11 = 1
            goto L_0x010d
        L_0x055c:
            r0 = move-exception
            r9 = r25
            r14 = r20
            r2 = r21
            goto L_0x056c
        L_0x0564:
            r0 = move-exception
            r9 = r3
        L_0x0566:
            r14 = r20
            goto L_0x056c
        L_0x0569:
            r0 = move-exception
        L_0x056a:
            r14 = r9
            r9 = r3
        L_0x056c:
            if (r13 == 0) goto L_0x0575
            okhttp3.ResponseBody r3 = r13.body()
            r17 = r3
            goto L_0x0577
        L_0x0575:
            r17 = 0
        L_0x0577:
            if (r17 == 0) goto L_0x0584
            okhttp3.ResponseBody r3 = r13.body()
            if (r3 == 0) goto L_0x0584
            r3.close()
            kotlin.Unit r3 = kotlin.Unit.f40298a
        L_0x0584:
            if (r12 == 0) goto L_0x058b
            r12.cancel()
            kotlin.Unit r3 = kotlin.Unit.f40298a
        L_0x058b:
            com.vungle.ads.internal.util.FileUtility r3 = com.vungle.ads.internal.util.FileUtility.INSTANCE
            r3.closeQuietly(r1)
            r3.closeQuietly(r4)
            com.vungle.ads.internal.util.Logger$Companion r1 = com.vungle.ads.internal.util.Logger.Companion
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r5)
            int r4 = r6.getStatus()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r1.d(r7, r3)
            int r3 = r6.getStatus()
            com.vungle.ads.internal.downloader.AssetDownloadListener$Progress$ProgressStatus$Companion r4 = com.vungle.ads.internal.downloader.AssetDownloadListener.Progress.ProgressStatus.Companion
            int r5 = r4.getERROR()
            if (r3 != r5) goto L_0x05ba
        L_0x05b7:
            r19 = 1
            goto L_0x05c3
        L_0x05ba:
            int r5 = r4.getSTARTED()
            if (r3 != r5) goto L_0x05c1
            goto L_0x05b7
        L_0x05c1:
            r19 = 0
        L_0x05c3:
            if (r19 != 0) goto L_0x05e2
            int r4 = r4.getCANCELLED()
            if (r3 != r4) goto L_0x05de
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r2)
            r3.append(r10)
            java.lang.String r2 = r3.toString()
            r1.d(r7, r2)
            goto L_0x05e7
        L_0x05de:
            r9.deliverSuccess(r14, r10, r11)
            goto L_0x05e7
        L_0x05e2:
            r13 = r16
            r9.deliverError(r10, r11, r13)
        L_0x05e7:
            throw r0
        L_0x05e8:
            r9 = r1
            return
        L_0x05ea:
            r9 = r1
            r10 = r2
            r11 = r3
            com.vungle.ads.internal.downloader.AssetDownloadListener$DownloadError r0 = new com.vungle.ads.internal.downloader.AssetDownloadListener$DownloadError
            com.vungle.ads.AssetDownloadError r1 = new com.vungle.ads.AssetDownloadError
            com.vungle.ads.internal.protos.Sdk$SDKError$Reason r2 = com.vungle.ads.internal.protos.Sdk$SDKError.Reason.INVALID_ASSET_URL
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "invalid url: "
            r3.append(r4)
            r3.append(r8)
            java.lang.String r3 = r3.toString()
            r1.<init>(r2, r3)
            com.vungle.ads.internal.util.LogEntry r2 = r26.getLogEntry$vungle_ads_release()
            com.vungle.ads.VungleError r1 = r1.setLogEntry$vungle_ads_release(r2)
            com.vungle.ads.VungleError r1 = r1.logError$vungle_ads_release()
            com.vungle.ads.internal.downloader.AssetDownloadListener$DownloadError$ErrorReason$Companion r2 = com.vungle.ads.internal.downloader.AssetDownloadListener.DownloadError.ErrorReason.Companion
            int r2 = r2.getINTERNAL_ERROR()
            r3 = -1
            r0.<init>(r3, r1, r2)
            r9.deliverError(r10, r11, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.downloader.AssetDownloader.launchRequest(com.vungle.ads.internal.downloader.DownloadRequest, com.vungle.ads.internal.downloader.AssetDownloadListener):void");
    }

    public void cancel(DownloadRequest downloadRequest) {
        if (downloadRequest != null && !downloadRequest.isCancelled()) {
            downloadRequest.cancel();
        }
    }

    public void cancelAll() {
        for (DownloadRequest cancel : this.transitioning) {
            cancel(cancel);
        }
        this.transitioning.clear();
    }

    public void download(DownloadRequest downloadRequest, AssetDownloadListener assetDownloadListener) {
        if (downloadRequest != null) {
            this.transitioning.add(downloadRequest);
            this.downloadExecutor.execute(new AssetDownloader$download$1(this, downloadRequest, assetDownloadListener), new a(this, downloadRequest, assetDownloadListener));
        }
    }
}
