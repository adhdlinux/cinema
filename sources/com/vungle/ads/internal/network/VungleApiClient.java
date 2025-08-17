package com.vungle.ads.internal.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.security.NetworkSecurityPolicy;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.webkit.URLUtil;
import androidx.core.content.PermissionChecker;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.ImagesContract;
import com.uwetrottmann.trakt5.TraktV2;
import com.vungle.ads.AnalyticsClient;
import com.vungle.ads.ServiceLocator;
import com.vungle.ads.TimeIntervalMetric;
import com.vungle.ads.VungleAdSize;
import com.vungle.ads.VungleAds;
import com.vungle.ads.fpd.FirstPartyData;
import com.vungle.ads.internal.ConfigManager;
import com.vungle.ads.internal.model.AdPayload;
import com.vungle.ads.internal.model.AdvertisingInfo;
import com.vungle.ads.internal.model.AppNode;
import com.vungle.ads.internal.model.CommonRequestBody;
import com.vungle.ads.internal.model.ConfigPayload;
import com.vungle.ads.internal.model.DeviceNode;
import com.vungle.ads.internal.model.ErrorInfo;
import com.vungle.ads.internal.model.Placement;
import com.vungle.ads.internal.persistence.FilePreferences;
import com.vungle.ads.internal.platform.AndroidPlatform;
import com.vungle.ads.internal.platform.Platform;
import com.vungle.ads.internal.privacy.COPPA;
import com.vungle.ads.internal.privacy.PrivacyManager;
import com.vungle.ads.internal.protos.Sdk$MetricBatch;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import com.vungle.ads.internal.protos.Sdk$SDKErrorBatch;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import com.vungle.ads.internal.signals.SignalManager;
import com.vungle.ads.internal.ui.AdActivity;
import com.vungle.ads.internal.util.FileUtility;
import com.vungle.ads.internal.util.LogEntry;
import com.vungle.ads.internal.util.Logger;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonKt;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.GzipSink;
import okio.Okio;

public final class VungleApiClient {
    /* access modifiers changed from: private */
    public static final String BASE_URL = "https://config.ads.vungle.com/";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "VungleApiClient";
    private static final Json json = JsonKt.b((Json) null, VungleApiClient$Companion$json$1.INSTANCE, 1, (Object) null);
    private static final Set<Interceptor> logInterceptors = new HashSet();
    private static final Set<Interceptor> networkInterceptors = new HashSet();
    private AdvertisingInfo advertisingInfo;
    private VungleApi api;
    private AppNode appBody;
    private final Context applicationContext;
    private DeviceNode baseDeviceInfo;
    private final FilePreferences filePreferences;
    private VungleApi gzipApi;
    private Boolean isGooglePlayServicesAvailable;
    private final Platform platform;
    private Interceptor responseInterceptor;
    private Map<String, Long> retryAfterDataMap;
    private final Lazy signalManager$delegate;
    /* access modifiers changed from: private */
    public String uaString = System.getProperty("http.agent");

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String getBASE_URL$vungle_ads_release() {
            return VungleApiClient.BASE_URL;
        }

        public final void reset$vungle_ads_release() {
            VungleHeader.INSTANCE.reset();
        }
    }

    public static final class GzipRequestInterceptor implements Interceptor {
        private static final String CONTENT_ENCODING = "Content-Encoding";
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private static final String GZIP = "gzip";

        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private final RequestBody gzip(RequestBody requestBody) throws IOException {
            Buffer buffer = new Buffer();
            BufferedSink c2 = Okio.c(new GzipSink(buffer));
            requestBody.writeTo(c2);
            c2.close();
            return new VungleApiClient$GzipRequestInterceptor$gzip$1(requestBody, buffer);
        }

        public Response intercept(Interceptor.Chain chain) throws IOException {
            Intrinsics.f(chain, "chain");
            Request request = chain.request();
            RequestBody body = request.body();
            if (body == null || request.header(CONTENT_ENCODING) != null) {
                return chain.proceed(request);
            }
            return chain.proceed(request.newBuilder().header(CONTENT_ENCODING, GZIP).method(request.method(), gzip(body)).build());
        }
    }

    public VungleApiClient(Context context, Platform platform2, FilePreferences filePreferences2) {
        Intrinsics.f(context, "applicationContext");
        Intrinsics.f(platform2, "platform");
        Intrinsics.f(filePreferences2, "filePreferences");
        this.applicationContext = context;
        this.platform = platform2;
        this.filePreferences = filePreferences2;
        ServiceLocator.Companion companion = ServiceLocator.Companion;
        this.signalManager$delegate = LazyKt__LazyJVMKt.a(LazyThreadSafetyMode.SYNCHRONIZED, new VungleApiClient$special$$inlined$inject$1(context));
        this.retryAfterDataMap = new ConcurrentHashMap();
        this.responseInterceptor = new d(this);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        OkHttpClient.Builder proxySelector = builder.readTimeout(60, timeUnit).connectTimeout(60, timeUnit).addInterceptor(this.responseInterceptor).proxySelector(new VungleApiClient$builder$1());
        OkHttpClient build = proxySelector.build();
        OkHttpClient build2 = proxySelector.addInterceptor(new GzipRequestInterceptor()).build();
        this.api = new VungleApiImpl(build);
        this.gzipApi = new VungleApiImpl(build2);
    }

    private final String bodyToString(RequestBody requestBody) {
        try {
            Buffer buffer = new Buffer();
            if (requestBody == null) {
                return "";
            }
            requestBody.writeTo(buffer);
            return buffer.f0();
        } catch (Exception unused) {
            return "";
        }
    }

    private final Response defaultErrorResponse(Request request) {
        return new Response.Builder().request(request).code(500).protocol(Protocol.HTTP_1_1).message("Server is busy").body(ResponseBody.Companion.create("{\"Error\":\"Server is busy\"}", MediaType.Companion.parse("application/json; charset=utf-8"))).build();
    }

    public static /* synthetic */ void getAppBody$vungle_ads_release$annotations() {
    }

    private final DeviceNode getBasicDeviceBody(Context context) {
        String str;
        Context context2 = context;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Object systemService = context2.getSystemService("window");
        Intrinsics.d(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
        if (defaultDisplay != null) {
            defaultDisplay.getMetrics(displayMetrics);
        }
        String str2 = Build.MANUFACTURER;
        Intrinsics.e(str2, "MANUFACTURER");
        String str3 = Build.MODEL;
        Intrinsics.e(str3, "MODEL");
        String str4 = Build.VERSION.RELEASE;
        Intrinsics.e(str4, "RELEASE");
        String carrierName$vungle_ads_release = AndroidPlatform.Companion.getCarrierName$vungle_ads_release(context2);
        if (Intrinsics.a("Amazon", str2)) {
            str = "amazon";
        } else {
            str = "android";
        }
        DeviceNode deviceNode = new DeviceNode(str2, str3, str4, carrierName$vungle_ads_release, str, displayMetrics.widthPixels, displayMetrics.heightPixels, this.uaString, (String) null, (Integer) null, (DeviceNode.VungleExt) null, 1792, (DefaultConstructorMarker) null);
        try {
            String userAgent = this.platform.getUserAgent();
            this.uaString = userAgent;
            deviceNode.setUa(userAgent);
            initUserAgentLazy();
            AdvertisingInfo advertisingInfo2 = this.advertisingInfo;
            if (advertisingInfo2 == null) {
                advertisingInfo2 = this.platform.getAdvertisingInfo();
            }
            this.advertisingInfo = advertisingInfo2;
        } catch (Exception e2) {
            Logger.Companion companion = Logger.Companion;
            companion.e(TAG, "Cannot Get UserAgent. Setting Default Device UserAgent." + e2.getLocalizedMessage());
        }
        return deviceNode;
    }

    private final String getConnectionType() {
        if (PermissionChecker.a(this.applicationContext, "android.permission.ACCESS_NETWORK_STATE") != 0) {
            return null;
        }
        Object systemService = this.applicationContext.getSystemService("connectivity");
        Intrinsics.d(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return "NONE";
        }
        int type = activeNetworkInfo.getType();
        if (type == 0) {
            return "MOBILE";
        }
        if (type == 1 || type == 6) {
            return "WIFI";
        }
        if (type == 7) {
            return "BLUETOOTH";
        }
        if (type != 9) {
            return "UNKNOWN";
        }
        return "ETHERNET";
    }

    private final DeviceNode getDeviceBody() throws IllegalStateException {
        return getDeviceBody$vungle_ads_release(false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001a  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0027 A[SYNTHETIC, Splitter:B:14:0x0027] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x005c A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.vungle.ads.internal.model.CommonRequestBody.RequestExt getExtBody(boolean r8) {
        /*
            r7 = this;
            com.vungle.ads.internal.ConfigManager r0 = com.vungle.ads.internal.ConfigManager.INSTANCE
            java.lang.String r0 = r0.getConfigExtension()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0017
            int r3 = r0.length()
            if (r3 != 0) goto L_0x0012
            r3 = 1
            goto L_0x0013
        L_0x0012:
            r3 = 0
        L_0x0013:
            if (r3 != r1) goto L_0x0017
            r3 = 1
            goto L_0x0018
        L_0x0017:
            r3 = 0
        L_0x0018:
            if (r3 == 0) goto L_0x0022
            com.vungle.ads.internal.persistence.FilePreferences r0 = r7.filePreferences
            java.lang.String r3 = "config_extension"
            java.lang.String r0 = r0.getString(r3)
        L_0x0022:
            r3 = 0
            if (r8 != 0) goto L_0x0027
        L_0x0025:
            r8 = r3
            goto L_0x004e
        L_0x0027:
            com.vungle.ads.internal.signals.SignalManager r8 = r7.getSignalManager()     // Catch:{ Exception -> 0x0030 }
            java.lang.String r8 = r8.generateSignals()     // Catch:{ Exception -> 0x0030 }
            goto L_0x004e
        L_0x0030:
            r8 = move-exception
            com.vungle.ads.internal.util.Logger$Companion r4 = com.vungle.ads.internal.util.Logger.Companion
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Couldn't convert signals for sending. Error: "
            r5.append(r6)
            java.lang.String r8 = r8.getMessage()
            r5.append(r8)
            java.lang.String r8 = r5.toString()
            java.lang.String r5 = "VungleApiClient"
            r4.e(r5, r8)
            goto L_0x0025
        L_0x004e:
            if (r0 == 0) goto L_0x0059
            int r4 = r0.length()
            if (r4 != 0) goto L_0x0057
            goto L_0x0059
        L_0x0057:
            r4 = 0
            goto L_0x005a
        L_0x0059:
            r4 = 1
        L_0x005a:
            if (r4 == 0) goto L_0x0069
            if (r8 == 0) goto L_0x0066
            int r4 = r8.length()
            if (r4 != 0) goto L_0x0065
            goto L_0x0066
        L_0x0065:
            r1 = 0
        L_0x0066:
            if (r1 == 0) goto L_0x0069
            return r3
        L_0x0069:
            com.vungle.ads.internal.model.CommonRequestBody$RequestExt r1 = new com.vungle.ads.internal.model.CommonRequestBody$RequestExt
            com.vungle.ads.internal.ConfigManager r2 = com.vungle.ads.internal.ConfigManager.INSTANCE
            long r2 = r2.configLastValidatedTimestamp()
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r1.<init>(r0, r8, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.network.VungleApiClient.getExtBody(boolean):com.vungle.ads.internal.model.CommonRequestBody$RequestExt");
    }

    static /* synthetic */ CommonRequestBody.RequestExt getExtBody$default(VungleApiClient vungleApiClient, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z2 = false;
        }
        return vungleApiClient.getExtBody(z2);
    }

    public static /* synthetic */ void getGzipApi$vungle_ads_release$annotations() {
    }

    private final String getPlacementID(RequestBody requestBody) {
        List<String> placements;
        String str;
        try {
            Json json2 = json;
            String bodyToString = bodyToString(requestBody);
            KSerializer<Object> b2 = SerializersKt.b(json2.a(), Reflection.h(CommonRequestBody.class));
            Intrinsics.d(b2, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            CommonRequestBody.RequestParam request = ((CommonRequestBody) json2.b(b2, bodyToString)).getRequest();
            if (request == null || (placements = request.getPlacements()) == null || (str = placements.get(0)) == null) {
                return "";
            }
            return str;
        } catch (Exception unused) {
            return "";
        }
    }

    public static /* synthetic */ void getResponseInterceptor$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getRetryAfterDataMap$vungle_ads_release$annotations() {
    }

    private final SignalManager getSignalManager() {
        return (SignalManager) this.signalManager$delegate.getValue();
    }

    private final CommonRequestBody.User getUserBody(boolean z2) {
        CommonRequestBody.User user = new CommonRequestBody.User((CommonRequestBody.GDPR) null, (CommonRequestBody.CCPA) null, (CommonRequestBody.COPPA) null, (FirstPartyData) null, (CommonRequestBody.IAB) null, 31, (DefaultConstructorMarker) null);
        PrivacyManager privacyManager = PrivacyManager.INSTANCE;
        user.setGdpr(new CommonRequestBody.GDPR(privacyManager.getConsentStatus(), privacyManager.getConsentSource(), privacyManager.getConsentTimestamp(), privacyManager.getConsentMessageVersion()));
        user.setCcpa(new CommonRequestBody.CCPA(privacyManager.getCcpaStatus()));
        if (privacyManager.getCoppaStatus() != COPPA.COPPA_NOTSET) {
            user.setCoppa(new CommonRequestBody.COPPA(privacyManager.getCoppaStatus().getValue()));
        }
        if (privacyManager.shouldSendTCFString()) {
            user.setIab(new CommonRequestBody.IAB(privacyManager.getIABTCFString()));
        }
        if (z2) {
            user.setFpd(VungleAds.firstPartyData);
        }
        return user;
    }

    static /* synthetic */ CommonRequestBody.User getUserBody$default(VungleApiClient vungleApiClient, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z2 = false;
        }
        return vungleApiClient.getUserBody(z2);
    }

    private final void initUserAgentLazy() {
        TimeIntervalMetric timeIntervalMetric = new TimeIntervalMetric(Sdk$SDKMetric.SDKMetricType.USER_AGENT_LOAD_DURATION_MS);
        timeIntervalMetric.markStart();
        this.platform.getUserAgentLazy(new VungleApiClient$initUserAgentLazy$1(timeIntervalMetric, this));
    }

    public static /* synthetic */ ErrorInfo pingTPAT$default(VungleApiClient vungleApiClient, String str, Map map, String str2, HttpMethod httpMethod, LogEntry logEntry, int i2, Object obj) {
        Map map2;
        String str3;
        LogEntry logEntry2;
        if ((i2 & 2) != 0) {
            map2 = null;
        } else {
            map2 = map;
        }
        if ((i2 & 4) != 0) {
            str3 = null;
        } else {
            str3 = str2;
        }
        if ((i2 & 8) != 0) {
            httpMethod = HttpMethod.GET;
        }
        HttpMethod httpMethod2 = httpMethod;
        if ((i2 & 16) != 0) {
            logEntry2 = null;
        } else {
            logEntry2 = logEntry;
        }
        return vungleApiClient.pingTPAT(str, map2, str3, httpMethod2, logEntry2);
    }

    public static /* synthetic */ CommonRequestBody requestBody$default(VungleApiClient vungleApiClient, boolean z2, boolean z3, int i2, Object obj) throws IllegalStateException {
        if ((i2 & 1) != 0) {
            z2 = false;
        }
        if ((i2 & 2) != 0) {
            z3 = false;
        }
        return vungleApiClient.requestBody(z2, z3);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        com.vungle.ads.internal.util.Logger.Companion.d(TAG, "Retry-After value is not an valid value");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00a4, code lost:
        r11 = com.vungle.ads.internal.util.Logger.Companion;
        r11.e(TAG, "OOM for " + r1.url());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        return r10.defaultErrorResponse(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        return r11;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0070 */
    /* JADX WARNING: Removed duplicated region for block: B:25:? A[ExcHandler: OutOfMemoryError (unused java.lang.OutOfMemoryError), SYNTHETIC, Splitter:B:1:0x0010] */
    /* renamed from: responseInterceptor$lambda-0  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final okhttp3.Response m192responseInterceptor$lambda0(com.vungle.ads.internal.network.VungleApiClient r10, okhttp3.Interceptor.Chain r11) {
        /*
            java.lang.String r0 = "VungleApiClient"
            java.lang.String r1 = "this$0"
            kotlin.jvm.internal.Intrinsics.f(r10, r1)
            java.lang.String r1 = "chain"
            kotlin.jvm.internal.Intrinsics.f(r11, r1)
            okhttp3.Request r1 = r11.request()
            okhttp3.Response r11 = r11.proceed(r1)     // Catch:{ OutOfMemoryError -> 0x00a4, Exception -> 0x0078 }
            okhttp3.Headers r2 = r11.headers()     // Catch:{ OutOfMemoryError -> 0x00a4, Exception -> 0x0078 }
            java.lang.String r3 = "Retry-After"
            java.lang.String r2 = r2.get(r3)     // Catch:{ OutOfMemoryError -> 0x00a4, Exception -> 0x0078 }
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x002b
            int r5 = r2.length()     // Catch:{ OutOfMemoryError -> 0x00a4, Exception -> 0x0078 }
            if (r5 != 0) goto L_0x0029
            goto L_0x002b
        L_0x0029:
            r5 = 0
            goto L_0x002c
        L_0x002b:
            r5 = 1
        L_0x002c:
            if (r5 != 0) goto L_0x00c2
            long r5 = java.lang.Long.parseLong(r2)     // Catch:{ Exception -> 0x0070, OutOfMemoryError -> 0x00a4 }
            r7 = 0
            int r2 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r2 <= 0) goto L_0x00c2
            okhttp3.HttpUrl r2 = r1.url()     // Catch:{ Exception -> 0x0070, OutOfMemoryError -> 0x00a4 }
            java.lang.String r2 = r2.encodedPath()     // Catch:{ Exception -> 0x0070, OutOfMemoryError -> 0x00a4 }
            r7 = 1000(0x3e8, float:1.401E-42)
            long r7 = (long) r7     // Catch:{ Exception -> 0x0070, OutOfMemoryError -> 0x00a4 }
            long r5 = r5 * r7
            long r7 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0070, OutOfMemoryError -> 0x00a4 }
            long r5 = r5 + r7
            java.lang.String r7 = "ads"
            r8 = 2
            r9 = 0
            boolean r2 = kotlin.text.StringsKt__StringsJVMKt.s(r2, r7, r4, r8, r9)     // Catch:{ Exception -> 0x0070, OutOfMemoryError -> 0x00a4 }
            if (r2 == 0) goto L_0x00c2
            okhttp3.RequestBody r2 = r1.body()     // Catch:{ Exception -> 0x0070, OutOfMemoryError -> 0x00a4 }
            java.lang.String r2 = r10.getPlacementID(r2)     // Catch:{ Exception -> 0x0070, OutOfMemoryError -> 0x00a4 }
            int r7 = r2.length()     // Catch:{ Exception -> 0x0070, OutOfMemoryError -> 0x00a4 }
            if (r7 <= 0) goto L_0x0063
            goto L_0x0064
        L_0x0063:
            r3 = 0
        L_0x0064:
            if (r3 == 0) goto L_0x00c2
            java.lang.Long r3 = java.lang.Long.valueOf(r5)     // Catch:{ Exception -> 0x0070, OutOfMemoryError -> 0x00a4 }
            java.util.Map<java.lang.String, java.lang.Long> r4 = r10.retryAfterDataMap     // Catch:{ Exception -> 0x0070, OutOfMemoryError -> 0x00a4 }
            r4.put(r2, r3)     // Catch:{ Exception -> 0x0070, OutOfMemoryError -> 0x00a4 }
            goto L_0x00c2
        L_0x0070:
            com.vungle.ads.internal.util.Logger$Companion r2 = com.vungle.ads.internal.util.Logger.Companion     // Catch:{ OutOfMemoryError -> 0x00a4, Exception -> 0x0078 }
            java.lang.String r3 = "Retry-After value is not an valid value"
            r2.d(r0, r3)     // Catch:{ OutOfMemoryError -> 0x00a4, Exception -> 0x0078 }
            goto L_0x00c2
        L_0x0078:
            r11 = move-exception
            com.vungle.ads.internal.util.Logger$Companion r2 = com.vungle.ads.internal.util.Logger.Companion
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Exception: "
            r3.append(r4)
            java.lang.String r11 = r11.getMessage()
            r3.append(r11)
            java.lang.String r11 = " for "
            r3.append(r11)
            okhttp3.HttpUrl r11 = r1.url()
            r3.append(r11)
            java.lang.String r11 = r3.toString()
            r2.e(r0, r11)
            okhttp3.Response r11 = r10.defaultErrorResponse(r1)
            goto L_0x00c2
        L_0x00a4:
            com.vungle.ads.internal.util.Logger$Companion r11 = com.vungle.ads.internal.util.Logger.Companion
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "OOM for "
            r2.append(r3)
            okhttp3.HttpUrl r3 = r1.url()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r11.e(r0, r2)
            okhttp3.Response r11 = r10.defaultErrorResponse(r1)
        L_0x00c2:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.network.VungleApiClient.m192responseInterceptor$lambda0(com.vungle.ads.internal.network.VungleApiClient, okhttp3.Interceptor$Chain):okhttp3.Response");
    }

    public final void addPlaySvcAvailabilityInCookie(boolean z2) {
        this.filePreferences.put("isPlaySvcAvailable", z2).apply();
    }

    public final boolean checkIsRetryAfterActive(String str) {
        long j2;
        Intrinsics.f(str, "placementID");
        Long l2 = this.retryAfterDataMap.get(str);
        if (l2 != null) {
            j2 = l2.longValue();
        } else {
            j2 = 0;
        }
        if (j2 > System.currentTimeMillis()) {
            return true;
        }
        this.retryAfterDataMap.remove(str);
        return false;
    }

    public final Call<ConfigPayload> config() throws IOException {
        AppNode appNode = this.appBody;
        if (appNode == null) {
            return null;
        }
        CommonRequestBody commonRequestBody = new CommonRequestBody(getDeviceBody$vungle_ads_release(true), appNode, getUserBody$default(this, false, 1, (Object) null), (CommonRequestBody.RequestExt) null, (CommonRequestBody.RequestParam) null, 24, (DefaultConstructorMarker) null);
        CommonRequestBody.RequestExt extBody$default = getExtBody$default(this, false, 1, (Object) null);
        if (extBody$default != null) {
            commonRequestBody.setExt(extBody$default);
        }
        FileUtility fileUtility = FileUtility.INSTANCE;
        String str = BASE_URL;
        if (!fileUtility.isValidUrl(str)) {
            str = "https://config.ads.vungle.com/";
        }
        if (!StringsKt__StringsJVMKt.s(str, "/", false, 2, (Object) null)) {
            str = str + '/';
        }
        return this.api.config(VungleHeader.INSTANCE.getHeaderUa(), str + "config", commonRequestBody);
    }

    public final AppNode getAppBody$vungle_ads_release() {
        return this.appBody;
    }

    public final String getConnectionTypeDetail(int i2) {
        if (i2 == 1) {
            return "gprs";
        }
        if (i2 == 2) {
            return "edge";
        }
        if (i2 == 20) {
            return "5g";
        }
        switch (i2) {
            case 4:
                return "wcdma";
            case 5:
                return "cdma_evdo_0";
            case 6:
                return "cdma_evdo_a";
            case 7:
                return "cdma_1xrtt";
            case 8:
                return "hsdpa";
            case 9:
                return "hsupa";
            default:
                switch (i2) {
                    case 12:
                        return "cdma_evdo_b";
                    case 13:
                        return "lte";
                    case 14:
                        return "hrpd";
                    default:
                        return "unknown";
                }
        }
    }

    public final String getConnectionTypeDetail$vungle_ads_release() {
        if (PermissionChecker.a(this.applicationContext, "android.permission.ACCESS_NETWORK_STATE") != 0) {
            return null;
        }
        Object systemService = this.applicationContext.getSystemService("connectivity");
        Intrinsics.d(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            return getConnectionTypeDetail(activeNetworkInfo.getSubtype());
        }
        return "unknown";
    }

    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01f4, code lost:
        if (r1.applicationContext.getPackageManager().hasSystemFeature("android.hardware.touchscreen") != false) goto L_0x01d8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized com.vungle.ads.internal.model.DeviceNode getDeviceBody$vungle_ads_release(boolean r25) throws java.lang.IllegalStateException {
        /*
            r24 = this;
            r1 = r24
            monitor-enter(r24)
            com.vungle.ads.internal.model.DeviceNode r0 = r1.baseDeviceInfo     // Catch:{ all -> 0x0219 }
            if (r0 != 0) goto L_0x000f
            android.content.Context r0 = r1.applicationContext     // Catch:{ all -> 0x0219 }
            com.vungle.ads.internal.model.DeviceNode r0 = r1.getBasicDeviceBody(r0)     // Catch:{ all -> 0x0219 }
            r1.baseDeviceInfo = r0     // Catch:{ all -> 0x0219 }
        L_0x000f:
            r2 = r0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 2047(0x7ff, float:2.868E-42)
            r15 = 0
            com.vungle.ads.internal.model.DeviceNode r0 = com.vungle.ads.internal.model.DeviceNode.copy$default(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)     // Catch:{ all -> 0x0219 }
            com.vungle.ads.internal.model.DeviceNode$VungleExt r2 = new com.vungle.ads.internal.model.DeviceNode$VungleExt     // Catch:{ all -> 0x0219 }
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 262143(0x3ffff, float:3.6734E-40)
            r22 = 0
            r23 = r2
            r2.<init>((boolean) r3, (java.lang.String) r4, (java.lang.Integer) r5, (float) r6, (java.lang.String) r7, (int) r8, (java.lang.String) r9, (java.lang.String) r10, (java.lang.String) r11, (java.lang.String) r12, (java.lang.String) r13, (float) r14, (int) r15, (boolean) r16, (int) r17, (boolean) r18, (java.lang.String) r19, (java.lang.String) r20, (int) r21, (kotlin.jvm.internal.DefaultConstructorMarker) r22)     // Catch:{ all -> 0x0219 }
            com.vungle.ads.internal.model.AdvertisingInfo r2 = r1.advertisingInfo     // Catch:{ all -> 0x0219 }
            if (r2 != 0) goto L_0x004f
            com.vungle.ads.internal.platform.Platform r2 = r1.platform     // Catch:{ all -> 0x0219 }
            com.vungle.ads.internal.model.AdvertisingInfo r2 = r2.getAdvertisingInfo()     // Catch:{ all -> 0x0219 }
        L_0x004f:
            r1.advertisingInfo = r2     // Catch:{ all -> 0x0219 }
            r3 = 0
            if (r2 == 0) goto L_0x0059
            java.lang.String r2 = r2.getAdvertisingId()     // Catch:{ all -> 0x0219 }
            goto L_0x005a
        L_0x0059:
            r2 = r3
        L_0x005a:
            com.vungle.ads.internal.model.AdvertisingInfo r4 = r1.advertisingInfo     // Catch:{ all -> 0x0219 }
            if (r4 == 0) goto L_0x0067
            boolean r4 = r4.getLimitAdTracking()     // Catch:{ all -> 0x0219 }
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)     // Catch:{ all -> 0x0219 }
            goto L_0x0068
        L_0x0067:
            r4 = r3
        L_0x0068:
            com.vungle.ads.internal.privacy.PrivacyManager r5 = com.vungle.ads.internal.privacy.PrivacyManager.INSTANCE     // Catch:{ all -> 0x0219 }
            boolean r6 = r5.shouldSendAdIds()     // Catch:{ all -> 0x0219 }
            if (r6 == 0) goto L_0x0093
            if (r2 == 0) goto L_0x008b
            java.lang.String r6 = "Amazon"
            java.lang.String r7 = android.os.Build.MANUFACTURER     // Catch:{ all -> 0x0219 }
            boolean r6 = kotlin.jvm.internal.Intrinsics.a(r6, r7)     // Catch:{ all -> 0x0219 }
            if (r6 == 0) goto L_0x0082
            r6 = r23
            r6.setAmazonAdvertisingId(r2)     // Catch:{ all -> 0x0219 }
            goto L_0x0087
        L_0x0082:
            r6 = r23
            r6.setGaid(r2)     // Catch:{ all -> 0x0219 }
        L_0x0087:
            r0.setIfa(r2)     // Catch:{ all -> 0x0219 }
            goto L_0x0095
        L_0x008b:
            r6 = r23
            java.lang.String r2 = ""
            r0.setIfa(r2)     // Catch:{ all -> 0x0219 }
            goto L_0x0095
        L_0x0093:
            r6 = r23
        L_0x0095:
            if (r25 != 0) goto L_0x009d
            boolean r2 = r5.shouldSendAdIds()     // Catch:{ all -> 0x0219 }
            if (r2 != 0) goto L_0x00a6
        L_0x009d:
            r0.setIfa(r3)     // Catch:{ all -> 0x0219 }
            r6.setGaid(r3)     // Catch:{ all -> 0x0219 }
            r6.setAmazonAdvertisingId(r3)     // Catch:{ all -> 0x0219 }
        L_0x00a6:
            java.lang.Boolean r2 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x0219 }
            boolean r4 = kotlin.jvm.internal.Intrinsics.a(r4, r2)     // Catch:{ all -> 0x0219 }
            r7 = 0
            r8 = 1
            if (r4 == 0) goto L_0x00b5
            java.lang.Integer r4 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0219 }
            goto L_0x00b9
        L_0x00b5:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r7)     // Catch:{ all -> 0x0219 }
        L_0x00b9:
            r0.setLmt(r4)     // Catch:{ all -> 0x0219 }
            java.lang.Boolean r4 = r24.isGooglePlayServicesAvailable()     // Catch:{ all -> 0x0219 }
            boolean r2 = kotlin.jvm.internal.Intrinsics.a(r2, r4)     // Catch:{ all -> 0x0219 }
            r6.setGooglePlayServicesAvailable(r2)     // Catch:{ all -> 0x0219 }
            com.vungle.ads.internal.privacy.PrivacyManager$DeviceIdAllowed r2 = r5.allowDeviceIDFromTCF()     // Catch:{ all -> 0x0219 }
            com.vungle.ads.internal.privacy.PrivacyManager$DeviceIdAllowed r4 = com.vungle.ads.internal.privacy.PrivacyManager.DeviceIdAllowed.DISABLE_ID     // Catch:{ all -> 0x0219 }
            if (r2 == r4) goto L_0x00ed
            com.vungle.ads.internal.platform.Platform r2 = r1.platform     // Catch:{ all -> 0x0219 }
            java.lang.String r2 = r2.getAppSetId()     // Catch:{ all -> 0x0219 }
            if (r2 == 0) goto L_0x00da
            r6.setAppSetId(r2)     // Catch:{ all -> 0x0219 }
        L_0x00da:
            com.vungle.ads.internal.platform.Platform r2 = r1.platform     // Catch:{ all -> 0x0219 }
            java.lang.Integer r2 = r2.getAppSetIdScope()     // Catch:{ all -> 0x0219 }
            if (r2 == 0) goto L_0x00ed
            int r2 = r2.intValue()     // Catch:{ all -> 0x0219 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0219 }
            r6.setAppSetIdScope(r2)     // Catch:{ all -> 0x0219 }
        L_0x00ed:
            android.content.Context r2 = r1.applicationContext     // Catch:{ all -> 0x0219 }
            android.content.IntentFilter r4 = new android.content.IntentFilter     // Catch:{ all -> 0x0219 }
            java.lang.String r5 = "android.intent.action.BATTERY_CHANGED"
            r4.<init>(r5)     // Catch:{ all -> 0x0219 }
            android.content.Intent r2 = r2.registerReceiver(r3, r4)     // Catch:{ all -> 0x0219 }
            r3 = 4
            if (r2 == 0) goto L_0x0140
            java.lang.String r4 = "level"
            r5 = -1
            int r4 = r2.getIntExtra(r4, r5)     // Catch:{ all -> 0x0219 }
            java.lang.String r9 = "scale"
            int r9 = r2.getIntExtra(r9, r5)     // Catch:{ all -> 0x0219 }
            if (r4 <= 0) goto L_0x0114
            if (r9 <= 0) goto L_0x0114
            float r4 = (float) r4     // Catch:{ all -> 0x0219 }
            float r9 = (float) r9     // Catch:{ all -> 0x0219 }
            float r4 = r4 / r9
            r6.setBatteryLevel(r4)     // Catch:{ all -> 0x0219 }
        L_0x0114:
            java.lang.String r4 = "status"
            int r4 = r2.getIntExtra(r4, r5)     // Catch:{ all -> 0x0219 }
            if (r4 == r5) goto L_0x013d
            r9 = 2
            if (r4 == r9) goto L_0x0125
            r10 = 5
            if (r4 == r10) goto L_0x0125
            java.lang.String r2 = "NOT_CHARGING"
            goto L_0x0142
        L_0x0125:
            java.lang.String r4 = "plugged"
            int r2 = r2.getIntExtra(r4, r5)     // Catch:{ all -> 0x0219 }
            if (r2 == r8) goto L_0x013a
            if (r2 == r9) goto L_0x0137
            if (r2 == r3) goto L_0x0134
            java.lang.String r2 = "BATTERY_PLUGGED_OTHERS"
            goto L_0x0142
        L_0x0134:
            java.lang.String r2 = "BATTERY_PLUGGED_WIRELESS"
            goto L_0x0142
        L_0x0137:
            java.lang.String r2 = "BATTERY_PLUGGED_USB"
            goto L_0x0142
        L_0x013a:
            java.lang.String r2 = "BATTERY_PLUGGED_AC"
            goto L_0x0142
        L_0x013d:
            java.lang.String r2 = "UNKNOWN"
            goto L_0x0142
        L_0x0140:
            java.lang.String r2 = "UNKNOWN"
        L_0x0142:
            r6.setBatteryState(r2)     // Catch:{ all -> 0x0219 }
            android.content.Context r2 = r1.applicationContext     // Catch:{ all -> 0x0219 }
            java.lang.String r4 = "power"
            java.lang.Object r2 = r2.getSystemService(r4)     // Catch:{ all -> 0x0219 }
            java.lang.String r4 = "null cannot be cast to non-null type android.os.PowerManager"
            kotlin.jvm.internal.Intrinsics.d(r2, r4)     // Catch:{ all -> 0x0219 }
            android.os.PowerManager r2 = (android.os.PowerManager) r2     // Catch:{ all -> 0x0219 }
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0219 }
            boolean r2 = r2.isPowerSaveMode()     // Catch:{ all -> 0x0219 }
            r6.setBatterySaverEnabled(r2)     // Catch:{ all -> 0x0219 }
            java.lang.String r2 = r24.getConnectionType()     // Catch:{ all -> 0x0219 }
            if (r2 == 0) goto L_0x0166
            r6.setConnectionType(r2)     // Catch:{ all -> 0x0219 }
        L_0x0166:
            java.lang.String r2 = r24.getConnectionTypeDetail$vungle_ads_release()     // Catch:{ all -> 0x0219 }
            if (r2 == 0) goto L_0x016f
            r6.setConnectionTypeDetail(r2)     // Catch:{ all -> 0x0219 }
        L_0x016f:
            java.util.Locale r2 = java.util.Locale.getDefault()     // Catch:{ all -> 0x0219 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0219 }
            r6.setLocale(r2)     // Catch:{ all -> 0x0219 }
            java.util.Locale r2 = java.util.Locale.getDefault()     // Catch:{ all -> 0x0219 }
            java.lang.String r2 = r2.getLanguage()     // Catch:{ all -> 0x0219 }
            r6.setLanguage(r2)     // Catch:{ all -> 0x0219 }
            java.util.TimeZone r2 = java.util.TimeZone.getDefault()     // Catch:{ all -> 0x0219 }
            java.lang.String r2 = r2.getID()     // Catch:{ all -> 0x0219 }
            r6.setTimeZone(r2)     // Catch:{ all -> 0x0219 }
            com.vungle.ads.internal.platform.Platform r2 = r1.platform     // Catch:{ all -> 0x0219 }
            float r2 = r2.getVolumeLevel()     // Catch:{ all -> 0x0219 }
            r6.setVolumeLevel(r2)     // Catch:{ all -> 0x0219 }
            com.vungle.ads.internal.platform.Platform r2 = r1.platform     // Catch:{ all -> 0x0219 }
            boolean r2 = r2.isSoundEnabled()     // Catch:{ all -> 0x0219 }
            if (r2 == 0) goto L_0x01a3
            r2 = 1
            goto L_0x01a4
        L_0x01a3:
            r2 = 0
        L_0x01a4:
            r6.setSoundEnabled(r2)     // Catch:{ all -> 0x0219 }
            java.lang.String r2 = "Amazon"
            java.lang.String r5 = android.os.Build.MANUFACTURER     // Catch:{ all -> 0x0219 }
            boolean r2 = kotlin.jvm.internal.Intrinsics.a(r2, r5)     // Catch:{ all -> 0x0219 }
            if (r2 == 0) goto L_0x01be
            android.content.Context r2 = r1.applicationContext     // Catch:{ all -> 0x0219 }
            android.content.pm.PackageManager r2 = r2.getPackageManager()     // Catch:{ all -> 0x0219 }
            java.lang.String r3 = "amazon.hardware.fire_tv"
            boolean r2 = r2.hasSystemFeature(r3)     // Catch:{ all -> 0x0219 }
            goto L_0x01f7
        L_0x01be:
            r2 = 23
            if (r4 < r2) goto L_0x01da
            android.content.Context r2 = r1.applicationContext     // Catch:{ all -> 0x0219 }
            java.lang.String r4 = "uimode"
            java.lang.Object r2 = r2.getSystemService(r4)     // Catch:{ all -> 0x0219 }
            java.lang.String r4 = "null cannot be cast to non-null type android.app.UiModeManager"
            kotlin.jvm.internal.Intrinsics.d(r2, r4)     // Catch:{ all -> 0x0219 }
            android.app.UiModeManager r2 = (android.app.UiModeManager) r2     // Catch:{ all -> 0x0219 }
            int r2 = r2.getCurrentModeType()     // Catch:{ all -> 0x0219 }
            if (r2 != r3) goto L_0x01d8
            goto L_0x01f6
        L_0x01d8:
            r2 = 0
            goto L_0x01f7
        L_0x01da:
            android.content.Context r2 = r1.applicationContext     // Catch:{ all -> 0x0219 }
            android.content.pm.PackageManager r2 = r2.getPackageManager()     // Catch:{ all -> 0x0219 }
            java.lang.String r3 = "com.google.android.tv"
            boolean r2 = r2.hasSystemFeature(r3)     // Catch:{ all -> 0x0219 }
            if (r2 != 0) goto L_0x01f6
            android.content.Context r2 = r1.applicationContext     // Catch:{ all -> 0x0219 }
            android.content.pm.PackageManager r2 = r2.getPackageManager()     // Catch:{ all -> 0x0219 }
            java.lang.String r3 = "android.hardware.touchscreen"
            boolean r2 = r2.hasSystemFeature(r3)     // Catch:{ all -> 0x0219 }
            if (r2 != 0) goto L_0x01d8
        L_0x01f6:
            r2 = 1
        L_0x01f7:
            r6.setTv(r2)     // Catch:{ all -> 0x0219 }
            com.vungle.ads.internal.platform.Platform r2 = r1.platform     // Catch:{ all -> 0x0219 }
            boolean r2 = r2.isSideLoaded()     // Catch:{ all -> 0x0219 }
            r6.setSideloadEnabled(r2)     // Catch:{ all -> 0x0219 }
            com.vungle.ads.internal.platform.Platform r2 = r1.platform     // Catch:{ all -> 0x0219 }
            boolean r2 = r2.isSdCardPresent()     // Catch:{ all -> 0x0219 }
            if (r2 == 0) goto L_0x020c
            r7 = 1
        L_0x020c:
            r6.setSdCardAvailable(r7)     // Catch:{ all -> 0x0219 }
            java.lang.String r2 = r1.uaString     // Catch:{ all -> 0x0219 }
            r0.setUa(r2)     // Catch:{ all -> 0x0219 }
            r0.setExt(r6)     // Catch:{ all -> 0x0219 }
            monitor-exit(r24)
            return r0
        L_0x0219:
            r0 = move-exception
            monitor-exit(r24)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.network.VungleApiClient.getDeviceBody$vungle_ads_release(boolean):com.vungle.ads.internal.model.DeviceNode");
    }

    public final VungleApi getGzipApi$vungle_ads_release() {
        return this.gzipApi;
    }

    public final Boolean getPlayServicesAvailabilityFromAPI() {
        boolean z2;
        try {
            GoogleApiAvailabilityLight instance = GoogleApiAvailabilityLight.getInstance();
            Intrinsics.e(instance, "getInstance()");
            if (instance.isGooglePlayServicesAvailable(this.applicationContext) == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            Boolean valueOf = Boolean.valueOf(z2);
            addPlaySvcAvailabilityInCookie(valueOf.booleanValue());
            return valueOf;
        } catch (NoClassDefFoundError unused) {
            Logger.Companion.w(TAG, "Play services Not available");
            Boolean bool = Boolean.FALSE;
            try {
                addPlaySvcAvailabilityInCookie(false);
                return bool;
            } catch (Exception unused2) {
                Logger.Companion.w(TAG, "Failure to write GPS availability to DB");
                return bool;
            }
        } catch (Exception unused3) {
            Logger.Companion.w(TAG, "Unexpected exception from Play services lib.");
            return null;
        }
    }

    public final Boolean getPlayServicesAvailabilityFromCookie() {
        return this.filePreferences.getBoolean("isPlaySvcAvailable");
    }

    public final Interceptor getResponseInterceptor$vungle_ads_release() {
        return this.responseInterceptor;
    }

    public final Map<String, Long> getRetryAfterDataMap$vungle_ads_release() {
        return this.retryAfterDataMap;
    }

    public final long getRetryAfterHeaderValue(String str) {
        Intrinsics.f(str, "placementID");
        Long l2 = this.retryAfterDataMap.get(str);
        if (l2 != null) {
            return l2.longValue();
        }
        return 0;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(11:1|2|3|4|5|(1:7)(1:8)|9|10|11|12|13) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0052 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void initialize(java.lang.String r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            java.lang.String r0 = "appId"
            kotlin.jvm.internal.Intrinsics.f(r6, r0)     // Catch:{ all -> 0x0074 }
            com.vungle.ads.internal.network.VungleApi r0 = r5.api     // Catch:{ all -> 0x0074 }
            r0.setAppId(r6)     // Catch:{ all -> 0x0074 }
            com.vungle.ads.internal.network.VungleApi r0 = r5.gzipApi     // Catch:{ all -> 0x0074 }
            r0.setAppId(r6)     // Catch:{ all -> 0x0074 }
            java.lang.String r0 = "1.0"
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0052 }
            r2 = 33
            if (r1 < r2) goto L_0x0034
            android.content.Context r1 = r5.applicationContext     // Catch:{ Exception -> 0x0052 }
            android.content.pm.PackageManager r1 = r1.getPackageManager()     // Catch:{ Exception -> 0x0052 }
            android.content.Context r2 = r5.applicationContext     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = r2.getPackageName()     // Catch:{ Exception -> 0x0052 }
            r3 = 0
            android.content.pm.PackageManager$PackageInfoFlags r3 = android.content.pm.PackageManager.PackageInfoFlags.of(r3)     // Catch:{ Exception -> 0x0052 }
            android.content.pm.PackageInfo r1 = r1.getPackageInfo(r2, r3)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "{\n                    ap…      )\n                }"
            kotlin.jvm.internal.Intrinsics.e(r1, r2)     // Catch:{ Exception -> 0x0052 }
            goto L_0x004a
        L_0x0034:
            android.content.Context r1 = r5.applicationContext     // Catch:{ Exception -> 0x0052 }
            android.content.pm.PackageManager r1 = r1.getPackageManager()     // Catch:{ Exception -> 0x0052 }
            android.content.Context r2 = r5.applicationContext     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = r2.getPackageName()     // Catch:{ Exception -> 0x0052 }
            r3 = 0
            android.content.pm.PackageInfo r1 = r1.getPackageInfo(r2, r3)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "{\n                    ap…      )\n                }"
            kotlin.jvm.internal.Intrinsics.e(r1, r2)     // Catch:{ Exception -> 0x0052 }
        L_0x004a:
            java.lang.String r1 = r1.versionName     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "packageInfo.versionName"
            kotlin.jvm.internal.Intrinsics.e(r1, r2)     // Catch:{ Exception -> 0x0052 }
            r0 = r1
        L_0x0052:
            android.content.Context r1 = r5.applicationContext     // Catch:{ all -> 0x0074 }
            com.vungle.ads.internal.model.DeviceNode r1 = r5.getBasicDeviceBody(r1)     // Catch:{ all -> 0x0074 }
            r5.baseDeviceInfo = r1     // Catch:{ all -> 0x0074 }
            com.vungle.ads.internal.model.AppNode r1 = new com.vungle.ads.internal.model.AppNode     // Catch:{ all -> 0x0074 }
            android.content.Context r2 = r5.applicationContext     // Catch:{ all -> 0x0074 }
            java.lang.String r2 = r2.getPackageName()     // Catch:{ all -> 0x0074 }
            java.lang.String r3 = "applicationContext.packageName"
            kotlin.jvm.internal.Intrinsics.e(r2, r3)     // Catch:{ all -> 0x0074 }
            r1.<init>(r2, r0, r6)     // Catch:{ all -> 0x0074 }
            r5.appBody = r1     // Catch:{ all -> 0x0074 }
            java.lang.Boolean r6 = r5.getPlayServicesAvailabilityFromAPI()     // Catch:{ all -> 0x0074 }
            r5.isGooglePlayServicesAvailable = r6     // Catch:{ all -> 0x0074 }
            monitor-exit(r5)
            return
        L_0x0074:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.network.VungleApiClient.initialize(java.lang.String):void");
    }

    public final Boolean isGooglePlayServicesAvailable() {
        if (this.isGooglePlayServicesAvailable == null) {
            this.isGooglePlayServicesAvailable = getPlayServicesAvailabilityFromCookie();
        }
        if (this.isGooglePlayServicesAvailable == null) {
            this.isGooglePlayServicesAvailable = getPlayServicesAvailabilityFromAPI();
        }
        return this.isGooglePlayServicesAvailable;
    }

    public final ErrorInfo pingTPAT(String str, Map<String, String> map, String str2, HttpMethod httpMethod, LogEntry logEntry) {
        boolean z2;
        boolean z3;
        RequestBody requestBody;
        Integer num;
        Response raw;
        Intrinsics.f(str, ImagesContract.URL);
        Intrinsics.f(httpMethod, "requestType");
        if (str.length() == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2 || HttpUrl.Companion.parse(str) == null) {
            return new ErrorInfo(Sdk$SDKError.Reason.TPAT_ERROR, "Invalid URL : " + str, true);
        }
        try {
            String host = new URL(str).getHost();
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 24) {
                z3 = NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(host);
            } else if (i2 >= 23) {
                z3 = NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted();
            } else {
                z3 = true;
            }
            if (!z3 && URLUtil.isHttpUrl(str)) {
                return new ErrorInfo(Sdk$SDKError.Reason.TPAT_ERROR, "Clear Text Traffic is blocked", false, 4, (DefaultConstructorMarker) null);
            }
            try {
                String str3 = this.uaString;
                if (str3 == null) {
                    str3 = "";
                }
                String str4 = str3;
                String str5 = null;
                if (str2 != null) {
                    requestBody = RequestBody.Companion.create(str2, MediaType.Companion.parse(TraktV2.CONTENT_TYPE_JSON));
                } else {
                    requestBody = null;
                }
                Response<Void> execute = this.api.pingTPAT(str4, str, httpMethod, map, requestBody).execute();
                if (execute != null) {
                    if (execute.isSuccessful()) {
                        return null;
                    }
                }
                if (execute == null || (raw = execute.raw()) == null) {
                    num = null;
                } else {
                    num = Integer.valueOf(raw.code());
                }
                if (CollectionsKt___CollectionsKt.z(CollectionsKt__CollectionsKt.i(301, Integer.valueOf(Sdk$SDKError.Reason.INVALID_IFA_STATUS_VALUE), 307, 308), num)) {
                    AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, Sdk$SDKMetric.SDKMetricType.NOTIFICATION_REDIRECT, 0, logEntry, str, 2, (Object) null);
                    return null;
                }
                Sdk$SDKError.Reason reason = Sdk$SDKError.Reason.TPAT_ERROR;
                StringBuilder sb = new StringBuilder();
                sb.append("Tpat failed with error: ");
                sb.append(num);
                sb.append(", message: ");
                if (execute != null) {
                    str5 = execute.message();
                }
                sb.append(str5);
                return new ErrorInfo(reason, sb.toString(), false, 4, (DefaultConstructorMarker) null);
            } catch (Exception e2) {
                Sdk$SDKError.Reason reason2 = Sdk$SDKError.Reason.TPAT_ERROR;
                String localizedMessage = e2.getLocalizedMessage();
                if (localizedMessage == null) {
                    localizedMessage = "IOException";
                }
                return new ErrorInfo(reason2, localizedMessage, false, 4, (DefaultConstructorMarker) null);
            }
        } catch (MalformedURLException e3) {
            Sdk$SDKError.Reason reason3 = Sdk$SDKError.Reason.TPAT_ERROR;
            String localizedMessage2 = e3.getLocalizedMessage();
            if (localizedMessage2 == null) {
                localizedMessage2 = "MalformedURLException";
            }
            return new ErrorInfo(reason3, localizedMessage2, true);
        }
    }

    public final void reportErrors(BlockingQueue<Sdk$SDKError.Builder> blockingQueue, AnalyticsClient.RequestListener requestListener) {
        boolean z2;
        long j2;
        Intrinsics.f(blockingQueue, "errors");
        Intrinsics.f(requestListener, "requestListener");
        String errorLoggingEndpoint = ConfigManager.INSTANCE.getErrorLoggingEndpoint();
        if (errorLoggingEndpoint.length() == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            requestListener.onFailure();
            return;
        }
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        for (Sdk$SDKError.Builder builder : blockingQueue) {
            builder.setSessionId(getSignalManager().getUuid());
            Placement placement = ConfigManager.INSTANCE.getPlacement(builder.getPlacementReferenceId());
            if (placement != null) {
                if (placement.getHeaderBidding()) {
                    j2 = 1;
                } else {
                    j2 = 0;
                }
                builder.setIsHbPlacement(j2);
                String type = placement.getType();
                if (type == null) {
                    type = "";
                }
                builder.setPlacementType(type);
            }
            String connectionType = getConnectionType();
            if (connectionType != null) {
                builder.setConnectionType(connectionType);
            }
            String connectionTypeDetail$vungle_ads_release = getConnectionTypeDetail$vungle_ads_release();
            if (connectionTypeDetail$vungle_ads_release != null) {
                builder.setConnectionTypeDetail(connectionTypeDetail$vungle_ads_release);
            }
            Sdk$SDKError sdk$SDKError = (Sdk$SDKError) builder.build();
            Logger.Companion companion = Logger.Companion;
            companion.e(TAG, "Sending Error: " + sdk$SDKError.getReason());
            linkedBlockingQueue.add(sdk$SDKError);
        }
        Sdk$SDKErrorBatch sdk$SDKErrorBatch = (Sdk$SDKErrorBatch) Sdk$SDKErrorBatch.newBuilder().addAllErrors(linkedBlockingQueue).build();
        RequestBody.Companion companion2 = RequestBody.Companion;
        byte[] byteArray = sdk$SDKErrorBatch.toByteArray();
        Intrinsics.e(byteArray, "batch.toByteArray()");
        this.api.sendErrors(VungleHeader.INSTANCE.getHeaderUa(), errorLoggingEndpoint, companion2.create(byteArray, MediaType.Companion.parse("application/x-protobuf"), 0, sdk$SDKErrorBatch.toByteArray().length)).enqueue(new VungleApiClient$reportErrors$2(requestListener));
    }

    public final void reportMetrics(BlockingQueue<Sdk$SDKMetric.Builder> blockingQueue, AnalyticsClient.RequestListener requestListener) {
        boolean z2;
        long j2;
        Intrinsics.f(blockingQueue, "metrics");
        Intrinsics.f(requestListener, "requestListener");
        String metricsEndpoint = ConfigManager.INSTANCE.getMetricsEndpoint();
        if (metricsEndpoint.length() == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            requestListener.onFailure();
            return;
        }
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        for (Sdk$SDKMetric.Builder builder : blockingQueue) {
            builder.setSessionId(getSignalManager().getUuid());
            Placement placement = ConfigManager.INSTANCE.getPlacement(builder.getPlacementReferenceId());
            if (placement != null) {
                if (placement.getHeaderBidding()) {
                    j2 = 1;
                } else {
                    j2 = 0;
                }
                builder.setIsHbPlacement(j2);
                String type = placement.getType();
                if (type == null) {
                    type = "";
                }
                builder.setPlacementType(type);
            }
            String connectionType = getConnectionType();
            if (connectionType != null) {
                builder.setConnectionType(connectionType);
            }
            String connectionTypeDetail$vungle_ads_release = getConnectionTypeDetail$vungle_ads_release();
            if (connectionTypeDetail$vungle_ads_release != null) {
                builder.setConnectionTypeDetail(connectionTypeDetail$vungle_ads_release);
            }
            Sdk$SDKMetric sdk$SDKMetric = (Sdk$SDKMetric) builder.build();
            Logger.Companion companion = Logger.Companion;
            companion.e(TAG, "Sending Metric: " + sdk$SDKMetric.getType());
            linkedBlockingQueue.add(sdk$SDKMetric);
        }
        RequestBody.Companion companion2 = RequestBody.Companion;
        MediaType parse = MediaType.Companion.parse("application/x-protobuf");
        byte[] byteArray = ((Sdk$MetricBatch) Sdk$MetricBatch.newBuilder().addAllMetrics(linkedBlockingQueue).build()).toByteArray();
        Intrinsics.e(byteArray, "batch.toByteArray()");
        this.api.sendMetrics(VungleHeader.INSTANCE.getHeaderUa(), metricsEndpoint, RequestBody.Companion.create$default(companion2, parse, byteArray, 0, 0, 12, (Object) null)).enqueue(new VungleApiClient$reportMetrics$2(requestListener));
    }

    public final Call<AdPayload> requestAd(String str, VungleAdSize vungleAdSize) throws IllegalStateException {
        Intrinsics.f(str, "placement");
        ConfigManager configManager = ConfigManager.INSTANCE;
        String adsEndpoint = configManager.getAdsEndpoint();
        CommonRequestBody requestBody = requestBody(!configManager.signalsDisabled(), configManager.fpdEnabled());
        CommonRequestBody.RequestParam requestParam = new CommonRequestBody.RequestParam(CollectionsKt__CollectionsJVMKt.b(str), (CommonRequestBody.AdSizeParam) null, (Long) null, (String) null, (String) null, (String) null, 62, (DefaultConstructorMarker) null);
        if (vungleAdSize != null) {
            requestParam.setAdSize(new CommonRequestBody.AdSizeParam(vungleAdSize.getWidth(), vungleAdSize.getHeight()));
        }
        requestBody.setRequest(requestParam);
        return this.gzipApi.ads(VungleHeader.INSTANCE.getHeaderUa(), adsEndpoint, requestBody);
    }

    public final CommonRequestBody requestBody(boolean z2, boolean z3) throws IllegalStateException {
        CommonRequestBody commonRequestBody = new CommonRequestBody(getDeviceBody(), this.appBody, getUserBody(z3), (CommonRequestBody.RequestExt) null, (CommonRequestBody.RequestParam) null, 24, (DefaultConstructorMarker) null);
        CommonRequestBody.RequestExt extBody = getExtBody(z2);
        if (extBody != null) {
            commonRequestBody.setExt(extBody);
        }
        return commonRequestBody;
    }

    public final Call<Void> ri(CommonRequestBody.RequestParam requestParam) {
        boolean z2;
        AppNode appNode;
        Intrinsics.f(requestParam, AdActivity.REQUEST_KEY_EXTRA);
        String riEndpoint = ConfigManager.INSTANCE.getRiEndpoint();
        if (riEndpoint == null || riEndpoint.length() == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2 || (appNode = this.appBody) == null) {
            return null;
        }
        CommonRequestBody commonRequestBody = new CommonRequestBody(getDeviceBody(), appNode, getUserBody$default(this, false, 1, (Object) null), (CommonRequestBody.RequestExt) null, (CommonRequestBody.RequestParam) null, 24, (DefaultConstructorMarker) null);
        commonRequestBody.setRequest(requestParam);
        CommonRequestBody.RequestExt extBody$default = getExtBody$default(this, false, 1, (Object) null);
        if (extBody$default != null) {
            commonRequestBody.setExt(extBody$default);
        }
        return this.api.ri(VungleHeader.INSTANCE.getHeaderUa(), riEndpoint, commonRequestBody);
    }

    public final void sendAdMarkup(String str, String str2) {
        Intrinsics.f(str, "adMarkup");
        Intrinsics.f(str2, "endpoint");
        this.api.sendAdMarkup(str2, RequestBody.Companion.create(str, MediaType.Companion.parse(TraktV2.CONTENT_TYPE_JSON))).enqueue(new VungleApiClient$sendAdMarkup$1());
    }

    public final void setAppBody$vungle_ads_release(AppNode appNode) {
        this.appBody = appNode;
    }

    public final void setGzipApi$vungle_ads_release(VungleApi vungleApi) {
        Intrinsics.f(vungleApi, "<set-?>");
        this.gzipApi = vungleApi;
    }

    public final void setResponseInterceptor$vungle_ads_release(Interceptor interceptor) {
        Intrinsics.f(interceptor, "<set-?>");
        this.responseInterceptor = interceptor;
    }

    public final void setRetryAfterDataMap$vungle_ads_release(Map<String, Long> map) {
        Intrinsics.f(map, "<set-?>");
        this.retryAfterDataMap = map;
    }
}
