package com.vungle.ads.internal;

import android.content.Context;
import android.net.Uri;
import com.facebook.common.statfs.StatFsHelper;
import com.vungle.ads.AnalyticsClient;
import com.vungle.ads.InvalidEndpointError;
import com.vungle.ads.NetworkUnreachable;
import com.vungle.ads.ServiceLocator;
import com.vungle.ads.SingleValueMetric;
import com.vungle.ads.TimeIntervalMetric;
import com.vungle.ads.internal.model.ConfigPayload;
import com.vungle.ads.internal.model.Placement;
import com.vungle.ads.internal.network.Call;
import com.vungle.ads.internal.network.VungleApiClient;
import com.vungle.ads.internal.omsdk.OMInjector;
import com.vungle.ads.internal.persistence.FilePreferences;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import com.vungle.ads.internal.util.Logger;
import java.net.UnknownHostException;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonKt;

public final class ConfigManager {
    private static final int CONFIG_ALL_DATA = 2;
    private static final int CONFIG_LAST_VALIDATED_TIMESTAMP_ONLY = 1;
    public static final long CONFIG_LAST_VALIDATE_TS_DEFAULT = -1;
    private static final int CONFIG_NOT_AVAILABLE = 0;
    private static final int DEFAULT_SESSION_TIMEOUT_SECONDS = 900;
    private static final int DEFAULT_SIGNALS_SESSION_TIMEOUT_SECONDS = 1800;
    public static final ConfigManager INSTANCE = new ConfigManager();
    public static final String TAG = "ConfigManager";
    private static String applicationId;
    private static ConfigPayload config;
    private static String configExt;
    private static ConfigPayload.Endpoints endpoints;
    private static final Json json = JsonKt.b((Json) null, ConfigManager$json$1.INSTANCE, 1, (Object) null);
    private static List<Placement> placements;

    private ConfigManager() {
    }

    /* renamed from: fetchConfigAsync$lambda-0  reason: not valid java name */
    private static final VungleApiClient m146fetchConfigAsync$lambda0(Lazy<VungleApiClient> lazy) {
        return lazy.getValue();
    }

    /* renamed from: initWithConfig$lambda-2  reason: not valid java name */
    private static final FilePreferences m147initWithConfig$lambda2(Lazy<FilePreferences> lazy) {
        return lazy.getValue();
    }

    /* renamed from: initWithConfig$lambda-5  reason: not valid java name */
    private static final OMInjector m148initWithConfig$lambda5(Lazy<OMInjector> lazy) {
        return lazy.getValue();
    }

    public static /* synthetic */ void initWithConfig$vungle_ads_release$default(ConfigManager configManager, Context context, ConfigPayload configPayload, boolean z2, SingleValueMetric singleValueMetric, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            singleValueMetric = null;
        }
        configManager.initWithConfig$vungle_ads_release(context, configPayload, z2, singleValueMetric);
    }

    /* renamed from: updateConfigExtension$lambda-1  reason: not valid java name */
    private static final FilePreferences m149updateConfigExtension$lambda1(Lazy<FilePreferences> lazy) {
        return lazy.getValue();
    }

    public static /* synthetic */ boolean validateEndpoints$vungle_ads_release$default(ConfigManager configManager, ConfigPayload.Endpoints endpoints2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            endpoints2 = endpoints;
        }
        return configManager.validateEndpoints$vungle_ads_release(endpoints2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        r0 = (r0 = r0.getAutoRedirect()).getAfterClickDuration();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long afterClickDuration() {
        /*
            r2 = this;
            com.vungle.ads.internal.model.ConfigPayload r0 = config
            if (r0 == 0) goto L_0x0015
            com.vungle.ads.internal.model.ConfigPayload$AutoRedirect r0 = r0.getAutoRedirect()
            if (r0 == 0) goto L_0x0015
            java.lang.Long r0 = r0.getAfterClickDuration()
            if (r0 == 0) goto L_0x0015
            long r0 = r0.longValue()
            goto L_0x001a
        L_0x0015:
            r0 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        L_0x001a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.ConfigManager.afterClickDuration():long");
    }

    public final boolean allowAutoRedirects() {
        ConfigPayload.AutoRedirect autoRedirect;
        Boolean allowAutoRedirect;
        ConfigPayload configPayload = config;
        if (configPayload == null || (autoRedirect = configPayload.getAutoRedirect()) == null || (allowAutoRedirect = autoRedirect.getAllowAutoRedirect()) == null) {
            return false;
        }
        return allowAutoRedirect.booleanValue();
    }

    public final int checkConfigPayload$vungle_ads_release(ConfigPayload configPayload) {
        if (configPayload == null || configPayload.getConfigLastValidatedTimestamp() == null) {
            return 0;
        }
        Long configLastValidatedTimestamp = configPayload.getConfigLastValidatedTimestamp();
        if (configLastValidatedTimestamp != null && configLastValidatedTimestamp.longValue() == -1) {
            return 0;
        }
        if (configPayload.getEndpoints() == null) {
            return 1;
        }
        return 2;
    }

    public final void clearConfig$vungle_ads_release() {
        endpoints = null;
        placements = null;
        config = null;
    }

    public final long configLastValidatedTimestamp() {
        Long configLastValidatedTimestamp;
        ConfigPayload configPayload = config;
        if (configPayload == null || (configLastValidatedTimestamp = configPayload.getConfigLastValidatedTimestamp()) == null) {
            return -1;
        }
        return configLastValidatedTimestamp.longValue();
    }

    public final void fetchConfigAsync$vungle_ads_release(Context context, Function1<? super Boolean, Unit> function1) {
        boolean z2;
        Intrinsics.f(context, "context");
        Intrinsics.f(function1, "onComplete");
        ServiceLocator.Companion companion = ServiceLocator.Companion;
        Lazy a2 = LazyKt__LazyJVMKt.a(LazyThreadSafetyMode.SYNCHRONIZED, new ConfigManager$fetchConfigAsync$$inlined$inject$1(context));
        try {
            TimeIntervalMetric timeIntervalMetric = new TimeIntervalMetric(Sdk$SDKMetric.SDKMetricType.INIT_REQUEST_TO_RESPONSE_DURATION_MS);
            timeIntervalMetric.markStart();
            Call<ConfigPayload> config2 = m146fetchConfigAsync$lambda0(a2).config();
            if (config2 != null) {
                config2.enqueue(new ConfigManager$fetchConfigAsync$1(timeIntervalMetric, context, function1));
            }
        } catch (Throwable th) {
            if (th instanceof UnknownHostException) {
                z2 = true;
            } else {
                z2 = th instanceof SecurityException;
            }
            if (z2) {
                new NetworkUnreachable("Config unknown: " + th.getMessage()).logErrorNoReturnValue$vungle_ads_release();
            } else {
                new NetworkUnreachable("Config: " + th.getMessage()).logErrorNoReturnValue$vungle_ads_release();
            }
            function1.invoke(Boolean.FALSE);
        }
    }

    public final boolean fpdEnabled() {
        Boolean fpdEnabled;
        ConfigPayload configPayload = config;
        if (configPayload == null || (fpdEnabled = configPayload.getFpdEnabled()) == null) {
            return true;
        }
        return fpdEnabled.booleanValue();
    }

    public final String getAdsEndpoint() {
        ConfigPayload.Endpoints endpoints2 = endpoints;
        String str = null;
        String adsEndpoint = endpoints2 != null ? endpoints2.getAdsEndpoint() : null;
        if (!(adsEndpoint == null || adsEndpoint.length() == 0)) {
            str = adsEndpoint;
        }
        return str == null ? Constants.DEFAULT_ADS_ENDPOINT : str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0022 A[Catch:{ Exception -> 0x0089 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.vungle.ads.internal.model.ConfigPayload getCachedConfig(com.vungle.ads.internal.persistence.FilePreferences r7, java.lang.String r8) {
        /*
            r6 = this;
            java.lang.String r0 = "ConfigManager"
            java.lang.String r1 = "filePreferences"
            kotlin.jvm.internal.Intrinsics.f(r7, r1)
            java.lang.String r1 = "appId"
            kotlin.jvm.internal.Intrinsics.f(r8, r1)
            r1 = 0
            java.lang.String r2 = "config_app_id"
            java.lang.String r2 = r7.getString(r2)     // Catch:{ Exception -> 0x0089 }
            r3 = 1
            if (r2 == 0) goto L_0x001f
            int r4 = r2.length()     // Catch:{ Exception -> 0x0089 }
            if (r4 != 0) goto L_0x001d
            goto L_0x001f
        L_0x001d:
            r4 = 0
            goto L_0x0020
        L_0x001f:
            r4 = 1
        L_0x0020:
            if (r4 != 0) goto L_0x0081
            boolean r8 = kotlin.text.StringsKt__StringsJVMKt.t(r2, r8, r3)     // Catch:{ Exception -> 0x0089 }
            if (r8 != 0) goto L_0x0029
            goto L_0x0081
        L_0x0029:
            java.lang.String r8 = "config_response"
            java.lang.String r8 = r7.getString(r8)     // Catch:{ Exception -> 0x0089 }
            if (r8 == 0) goto L_0x0080
            java.lang.String r2 = "config_update_time"
            r3 = 0
            long r2 = r7.getLong(r2, r3)     // Catch:{ Exception -> 0x0089 }
            kotlinx.serialization.json.Json r7 = json     // Catch:{ Exception -> 0x0089 }
            kotlinx.serialization.modules.SerializersModule r4 = r7.a()     // Catch:{ Exception -> 0x0089 }
            java.lang.Class<com.vungle.ads.internal.model.ConfigPayload> r5 = com.vungle.ads.internal.model.ConfigPayload.class
            kotlin.reflect.KType r5 = kotlin.jvm.internal.Reflection.h(r5)     // Catch:{ Exception -> 0x0089 }
            kotlinx.serialization.KSerializer r4 = kotlinx.serialization.SerializersKt.b(r4, r5)     // Catch:{ Exception -> 0x0089 }
            java.lang.String r5 = "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>"
            kotlin.jvm.internal.Intrinsics.d(r4, r5)     // Catch:{ Exception -> 0x0089 }
            java.lang.Object r7 = r7.b(r4, r8)     // Catch:{ Exception -> 0x0089 }
            com.vungle.ads.internal.model.ConfigPayload r7 = (com.vungle.ads.internal.model.ConfigPayload) r7     // Catch:{ Exception -> 0x0089 }
            com.vungle.ads.internal.model.ConfigPayload$ConfigSettings r8 = r7.getConfigSettings()     // Catch:{ Exception -> 0x0089 }
            if (r8 == 0) goto L_0x0065
            java.lang.Long r8 = r8.getRefreshTime()     // Catch:{ Exception -> 0x0089 }
            if (r8 == 0) goto L_0x0065
            long r4 = r8.longValue()     // Catch:{ Exception -> 0x0089 }
            goto L_0x0067
        L_0x0065:
            r4 = -1
        L_0x0067:
            long r4 = r4 + r2
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0089 }
            int r8 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r8 >= 0) goto L_0x0078
            com.vungle.ads.internal.util.Logger$Companion r7 = com.vungle.ads.internal.util.Logger.Companion     // Catch:{ Exception -> 0x0089 }
            java.lang.String r8 = "cache config expired. re-config"
            r7.w(r0, r8)     // Catch:{ Exception -> 0x0089 }
            return r1
        L_0x0078:
            com.vungle.ads.internal.util.Logger$Companion r8 = com.vungle.ads.internal.util.Logger.Companion     // Catch:{ Exception -> 0x0089 }
            java.lang.String r2 = "use cache config."
            r8.w(r0, r2)     // Catch:{ Exception -> 0x0089 }
            return r7
        L_0x0080:
            return r1
        L_0x0081:
            com.vungle.ads.internal.util.Logger$Companion r7 = com.vungle.ads.internal.util.Logger.Companion     // Catch:{ Exception -> 0x0089 }
            java.lang.String r8 = "app id mismatch, re-config"
            r7.w(r0, r8)     // Catch:{ Exception -> 0x0089 }
            return r1
        L_0x0089:
            r7 = move-exception
            com.vungle.ads.internal.util.Logger$Companion r8 = com.vungle.ads.internal.util.Logger.Companion
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Error while parsing cached config: "
            r2.append(r3)
            java.lang.String r7 = r7.getMessage()
            r2.append(r7)
            java.lang.String r7 = r2.toString()
            r8.e(r0, r7)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.ConfigManager.getCachedConfig(com.vungle.ads.internal.persistence.FilePreferences, java.lang.String):com.vungle.ads.internal.model.ConfigPayload");
    }

    public final int getCleverCacheDiskPercentage() {
        ConfigPayload.CleverCache cleverCache;
        Integer diskPercentage;
        ConfigPayload configPayload = config;
        if (configPayload == null || (cleverCache = configPayload.getCleverCache()) == null || (diskPercentage = cleverCache.getDiskPercentage()) == null) {
            return 3;
        }
        return diskPercentage.intValue();
    }

    public final long getCleverCacheDiskSize() {
        ConfigPayload.CleverCache cleverCache;
        Long diskSize;
        ConfigPayload configPayload = config;
        if (configPayload == null || (cleverCache = configPayload.getCleverCache()) == null || (diskSize = cleverCache.getDiskSize()) == null) {
            return StatFsHelper.DEFAULT_DISK_OLIVE_LEVEL_IN_BYTES;
        }
        long j2 = (long) 1024;
        return diskSize.longValue() * j2 * j2;
    }

    public final String getConfigExtension() {
        String str = configExt;
        return str == null ? "" : str;
    }

    public final String getErrorLoggingEndpoint() {
        String str;
        boolean z2;
        ConfigPayload.Endpoints endpoints2 = endpoints;
        String str2 = null;
        if (endpoints2 != null) {
            str = endpoints2.getErrorLogsEndpoint();
        } else {
            str = null;
        }
        if (str == null || str.length() == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            str2 = str;
        }
        if (str2 == null) {
            return Constants.DEFAULT_ERROR_LOGS_ENDPOINT;
        }
        return str2;
    }

    public final String getGDPRButtonAccept() {
        ConfigPayload.UserPrivacy userPrivacy;
        ConfigPayload.GDPRSettings gdpr;
        ConfigPayload configPayload = config;
        if (configPayload == null || (userPrivacy = configPayload.getUserPrivacy()) == null || (gdpr = userPrivacy.getGdpr()) == null) {
            return null;
        }
        return gdpr.getButtonAccept();
    }

    public final String getGDPRButtonDeny() {
        ConfigPayload.UserPrivacy userPrivacy;
        ConfigPayload.GDPRSettings gdpr;
        ConfigPayload configPayload = config;
        if (configPayload == null || (userPrivacy = configPayload.getUserPrivacy()) == null || (gdpr = userPrivacy.getGdpr()) == null) {
            return null;
        }
        return gdpr.getButtonDeny();
    }

    public final String getGDPRConsentMessage() {
        ConfigPayload.UserPrivacy userPrivacy;
        ConfigPayload.GDPRSettings gdpr;
        ConfigPayload configPayload = config;
        if (configPayload == null || (userPrivacy = configPayload.getUserPrivacy()) == null || (gdpr = userPrivacy.getGdpr()) == null) {
            return null;
        }
        return gdpr.getConsentMessage();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0010, code lost:
        r0 = (r0 = (r0 = r0.getUserPrivacy()).getGdpr()).getConsentMessageVersion();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getGDPRConsentMessageVersion() {
        /*
            r1 = this;
            com.vungle.ads.internal.model.ConfigPayload r0 = config
            if (r0 == 0) goto L_0x0016
            com.vungle.ads.internal.model.ConfigPayload$UserPrivacy r0 = r0.getUserPrivacy()
            if (r0 == 0) goto L_0x0016
            com.vungle.ads.internal.model.ConfigPayload$GDPRSettings r0 = r0.getGdpr()
            if (r0 == 0) goto L_0x0016
            java.lang.String r0 = r0.getConsentMessageVersion()
            if (r0 != 0) goto L_0x0018
        L_0x0016:
            java.lang.String r0 = ""
        L_0x0018:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.ConfigManager.getGDPRConsentMessageVersion():java.lang.String");
    }

    public final String getGDPRConsentTitle() {
        ConfigPayload.UserPrivacy userPrivacy;
        ConfigPayload.GDPRSettings gdpr;
        ConfigPayload configPayload = config;
        if (configPayload == null || (userPrivacy = configPayload.getUserPrivacy()) == null || (gdpr = userPrivacy.getGdpr()) == null) {
            return null;
        }
        return gdpr.getConsentTitle();
    }

    public final boolean getGDPRIsCountryDataProtected() {
        ConfigPayload.UserPrivacy userPrivacy;
        ConfigPayload.GDPRSettings gdpr;
        Boolean isCountryDataProtected;
        ConfigPayload configPayload = config;
        if (configPayload == null || (userPrivacy = configPayload.getUserPrivacy()) == null || (gdpr = userPrivacy.getGdpr()) == null || (isCountryDataProtected = gdpr.isCountryDataProtected()) == null) {
            return false;
        }
        return isCountryDataProtected.booleanValue();
    }

    public final int getLogLevel() {
        ConfigPayload.LogMetricsSettings logMetricsSettings;
        Integer errorLogLevel;
        ConfigPayload configPayload = config;
        if (configPayload == null || (logMetricsSettings = configPayload.getLogMetricsSettings()) == null || (errorLogLevel = logMetricsSettings.getErrorLogLevel()) == null) {
            return AnalyticsClient.LogLevel.ERROR_LOG_LEVEL_ERROR.getLevel();
        }
        return errorLogLevel.intValue();
    }

    public final boolean getMetricsEnabled() {
        ConfigPayload.LogMetricsSettings logMetricsSettings;
        Boolean metricsEnabled;
        ConfigPayload configPayload = config;
        if (configPayload == null || (logMetricsSettings = configPayload.getLogMetricsSettings()) == null || (metricsEnabled = logMetricsSettings.getMetricsEnabled()) == null) {
            return false;
        }
        return metricsEnabled.booleanValue();
    }

    public final String getMetricsEndpoint() {
        String str;
        boolean z2;
        ConfigPayload.Endpoints endpoints2 = endpoints;
        String str2 = null;
        if (endpoints2 != null) {
            str = endpoints2.getMetricsEndpoint();
        } else {
            str = null;
        }
        if (str == null || str.length() == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            str2 = str;
        }
        if (str2 == null) {
            return Constants.DEFAULT_METRICS_ENDPOINT;
        }
        return str2;
    }

    public final String getMraidEndpoint() {
        ConfigPayload.Endpoints endpoints2 = endpoints;
        if (endpoints2 != null) {
            return endpoints2.getMraidEndpoint();
        }
        return null;
    }

    public final String getMraidJsVersion() {
        String mraidEndpoint = getMraidEndpoint();
        if (mraidEndpoint != null) {
            String str = "mraid_" + Uri.parse(mraidEndpoint).getLastPathSegment();
            if (str == null) {
                return "mraid_1";
            }
            return str;
        }
        return "mraid_1";
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: com.vungle.ads.internal.model.Placement} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: com.vungle.ads.internal.model.Placement} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.vungle.ads.internal.model.Placement} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: com.vungle.ads.internal.model.Placement} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.vungle.ads.internal.model.Placement getPlacement(java.lang.String r5) {
        /*
            r4 = this;
            java.util.List<com.vungle.ads.internal.model.Placement> r0 = placements
            r1 = 0
            if (r0 == 0) goto L_0x0025
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x000b:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0023
            java.lang.Object r2 = r0.next()
            r3 = r2
            com.vungle.ads.internal.model.Placement r3 = (com.vungle.ads.internal.model.Placement) r3
            java.lang.String r3 = r3.getReferenceId()
            boolean r3 = kotlin.jvm.internal.Intrinsics.a(r3, r5)
            if (r3 == 0) goto L_0x000b
            r1 = r2
        L_0x0023:
            com.vungle.ads.internal.model.Placement r1 = (com.vungle.ads.internal.model.Placement) r1
        L_0x0025:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.ConfigManager.getPlacement(java.lang.String):com.vungle.ads.internal.model.Placement");
    }

    public final String getRiEndpoint() {
        ConfigPayload.Endpoints endpoints2 = endpoints;
        if (endpoints2 != null) {
            return endpoints2.getRiEndpoint();
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.getSessionTimeout();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long getSessionTimeout() {
        /*
            r4 = this;
            com.vungle.ads.internal.model.ConfigPayload r0 = config
            if (r0 == 0) goto L_0x000f
            java.lang.Integer r0 = r0.getSessionTimeout()
            if (r0 == 0) goto L_0x000f
            int r0 = r0.intValue()
            goto L_0x0011
        L_0x000f:
            r0 = 900(0x384, float:1.261E-42)
        L_0x0011:
            long r0 = (long) r0
            r2 = 1000(0x3e8, double:4.94E-321)
            long r0 = r0 * r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.ConfigManager.getSessionTimeout():long");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.getSignalSessionTimeout();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long getSignalsSessionTimeout() {
        /*
            r4 = this;
            com.vungle.ads.internal.model.ConfigPayload r0 = config
            if (r0 == 0) goto L_0x000f
            java.lang.Integer r0 = r0.getSignalSessionTimeout()
            if (r0 == 0) goto L_0x000f
            int r0 = r0.intValue()
            goto L_0x0011
        L_0x000f:
            r0 = 1800(0x708, float:2.522E-42)
        L_0x0011:
            long r0 = (long) r0
            r2 = 1000(0x3e8, double:4.94E-321)
            long r0 = r0 * r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.ConfigManager.getSignalsSessionTimeout():long");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000c, code lost:
        r1 = (r1 = r1.getUserPrivacy()).getIab();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.vungle.ads.internal.model.ConfigPayload.IABSettings.TcfStatus getTcfStatus() {
        /*
            r2 = this;
            com.vungle.ads.internal.model.ConfigPayload$IABSettings$TcfStatus$Companion r0 = com.vungle.ads.internal.model.ConfigPayload.IABSettings.TcfStatus.Companion
            com.vungle.ads.internal.model.ConfigPayload r1 = config
            if (r1 == 0) goto L_0x0017
            com.vungle.ads.internal.model.ConfigPayload$UserPrivacy r1 = r1.getUserPrivacy()
            if (r1 == 0) goto L_0x0017
            com.vungle.ads.internal.model.ConfigPayload$IABSettings r1 = r1.getIab()
            if (r1 == 0) goto L_0x0017
            java.lang.Integer r1 = r1.getTcfStatus()
            goto L_0x0018
        L_0x0017:
            r1 = 0
        L_0x0018:
            com.vungle.ads.internal.model.ConfigPayload$IABSettings$TcfStatus r0 = r0.fromRawValue(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.ConfigManager.getTcfStatus():com.vungle.ads.internal.model.ConfigPayload$IABSettings$TcfStatus");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00aa, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void initWithConfig$vungle_ads_release(android.content.Context r10, com.vungle.ads.internal.model.ConfigPayload r11, boolean r12, com.vungle.ads.SingleValueMetric r13) {
        /*
            r9 = this;
            monitor-enter(r9)
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.f(r10, r0)     // Catch:{ all -> 0x00d5 }
            com.vungle.ads.ServiceLocator$Companion r0 = com.vungle.ads.ServiceLocator.Companion     // Catch:{ Exception -> 0x00b6 }
            kotlin.LazyThreadSafetyMode r0 = kotlin.LazyThreadSafetyMode.SYNCHRONIZED     // Catch:{ Exception -> 0x00b6 }
            com.vungle.ads.internal.ConfigManager$initWithConfig$$inlined$inject$1 r1 = new com.vungle.ads.internal.ConfigManager$initWithConfig$$inlined$inject$1     // Catch:{ Exception -> 0x00b6 }
            r1.<init>(r10)     // Catch:{ Exception -> 0x00b6 }
            kotlin.Lazy r1 = kotlin.LazyKt__LazyJVMKt.a(r0, r1)     // Catch:{ Exception -> 0x00b6 }
            int r2 = r9.checkConfigPayload$vungle_ads_release(r11)     // Catch:{ Exception -> 0x00b6 }
            if (r2 == 0) goto L_0x00ab
            r3 = 1
            if (r2 == r3) goto L_0x007f
            config = r11     // Catch:{ Exception -> 0x00b6 }
            r2 = 0
            if (r11 == 0) goto L_0x0026
            com.vungle.ads.internal.model.ConfigPayload$Endpoints r3 = r11.getEndpoints()     // Catch:{ Exception -> 0x00b6 }
            goto L_0x0027
        L_0x0026:
            r3 = r2
        L_0x0027:
            endpoints = r3     // Catch:{ Exception -> 0x00b6 }
            if (r11 == 0) goto L_0x002f
            java.util.List r2 = r11.getPlacements()     // Catch:{ Exception -> 0x00b6 }
        L_0x002f:
            placements = r2     // Catch:{ Exception -> 0x00b6 }
            com.vungle.ads.AnalyticsClient r3 = com.vungle.ads.AnalyticsClient.INSTANCE     // Catch:{ Exception -> 0x00b6 }
            int r2 = r9.getLogLevel()     // Catch:{ Exception -> 0x00b6 }
            boolean r4 = r9.getMetricsEnabled()     // Catch:{ Exception -> 0x00b6 }
            r3.updateErrorLevelAndMetricEnabled$vungle_ads_release(r2, r4)     // Catch:{ Exception -> 0x00b6 }
            if (r12 != 0) goto L_0x0054
            if (r11 == 0) goto L_0x0054
            com.vungle.ads.internal.persistence.FilePreferences r12 = m147initWithConfig$lambda2(r1)     // Catch:{ Exception -> 0x00b6 }
            r9.updateCachedConfig(r11, r12)     // Catch:{ Exception -> 0x00b6 }
            java.lang.String r11 = r11.getConfigExtension()     // Catch:{ Exception -> 0x00b6 }
            if (r11 == 0) goto L_0x0054
            com.vungle.ads.internal.ConfigManager r12 = INSTANCE     // Catch:{ Exception -> 0x00b6 }
            r12.updateConfigExtension$vungle_ads_release(r10, r11)     // Catch:{ Exception -> 0x00b6 }
        L_0x0054:
            boolean r11 = r9.omEnabled()     // Catch:{ Exception -> 0x00b6 }
            if (r11 == 0) goto L_0x006a
            com.vungle.ads.internal.ConfigManager$initWithConfig$$inlined$inject$2 r11 = new com.vungle.ads.internal.ConfigManager$initWithConfig$$inlined$inject$2     // Catch:{ Exception -> 0x00b6 }
            r11.<init>(r10)     // Catch:{ Exception -> 0x00b6 }
            kotlin.Lazy r10 = kotlin.LazyKt__LazyJVMKt.a(r0, r11)     // Catch:{ Exception -> 0x00b6 }
            com.vungle.ads.internal.omsdk.OMInjector r10 = m148initWithConfig$lambda5(r10)     // Catch:{ Exception -> 0x00b6 }
            r10.init()     // Catch:{ Exception -> 0x00b6 }
        L_0x006a:
            if (r13 == 0) goto L_0x0074
            r5 = 0
            r6 = 0
            r7 = 6
            r8 = 0
            r4 = r13
            com.vungle.ads.AnalyticsClient.logMetric$vungle_ads_release$default((com.vungle.ads.AnalyticsClient) r3, (com.vungle.ads.SingleValueMetric) r4, (com.vungle.ads.internal.util.LogEntry) r5, (java.lang.String) r6, (int) r7, (java.lang.Object) r8)     // Catch:{ Exception -> 0x00b6 }
        L_0x0074:
            com.vungle.ads.internal.privacy.PrivacyManager r10 = com.vungle.ads.internal.privacy.PrivacyManager.INSTANCE     // Catch:{ Exception -> 0x00b6 }
            boolean r11 = r9.shouldDisableAdId()     // Catch:{ Exception -> 0x00b6 }
            r10.updateDisableAdId(r11)     // Catch:{ Exception -> 0x00b6 }
            monitor-exit(r9)
            return
        L_0x007f:
            if (r12 != 0) goto L_0x00a9
            if (r11 == 0) goto L_0x00a9
            java.lang.Long r10 = r11.getConfigLastValidatedTimestamp()     // Catch:{ Exception -> 0x00b6 }
            if (r10 == 0) goto L_0x008e
            long r10 = r10.longValue()     // Catch:{ Exception -> 0x00b6 }
            goto L_0x0090
        L_0x008e:
            r10 = -1
        L_0x0090:
            com.vungle.ads.internal.model.ConfigPayload r12 = config     // Catch:{ Exception -> 0x00b6 }
            if (r12 != 0) goto L_0x0095
            goto L_0x009c
        L_0x0095:
            java.lang.Long r10 = java.lang.Long.valueOf(r10)     // Catch:{ Exception -> 0x00b6 }
            r12.setConfigLastValidatedTimestamp(r10)     // Catch:{ Exception -> 0x00b6 }
        L_0x009c:
            com.vungle.ads.internal.model.ConfigPayload r10 = config     // Catch:{ Exception -> 0x00b6 }
            if (r10 == 0) goto L_0x00a9
            com.vungle.ads.internal.ConfigManager r11 = INSTANCE     // Catch:{ Exception -> 0x00b6 }
            com.vungle.ads.internal.persistence.FilePreferences r12 = m147initWithConfig$lambda2(r1)     // Catch:{ Exception -> 0x00b6 }
            r11.updateCachedConfig(r10, r12)     // Catch:{ Exception -> 0x00b6 }
        L_0x00a9:
            monitor-exit(r9)
            return
        L_0x00ab:
            com.vungle.ads.internal.util.Logger$Companion r10 = com.vungle.ads.internal.util.Logger.Companion     // Catch:{ Exception -> 0x00b6 }
            java.lang.String r11 = "ConfigManager"
            java.lang.String r12 = "Config is not available."
            r10.e(r11, r12)     // Catch:{ Exception -> 0x00b6 }
            monitor-exit(r9)
            return
        L_0x00b6:
            r10 = move-exception
            com.vungle.ads.internal.util.Logger$Companion r11 = com.vungle.ads.internal.util.Logger.Companion     // Catch:{ all -> 0x00d5 }
            java.lang.String r12 = "ConfigManager"
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d5 }
            r13.<init>()     // Catch:{ all -> 0x00d5 }
            java.lang.String r0 = "Error while validating config: "
            r13.append(r0)     // Catch:{ all -> 0x00d5 }
            java.lang.String r10 = r10.getMessage()     // Catch:{ all -> 0x00d5 }
            r13.append(r10)     // Catch:{ all -> 0x00d5 }
            java.lang.String r10 = r13.toString()     // Catch:{ all -> 0x00d5 }
            r11.e(r12, r10)     // Catch:{ all -> 0x00d5 }
            monitor-exit(r9)
            return
        L_0x00d5:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.ConfigManager.initWithConfig$vungle_ads_release(android.content.Context, com.vungle.ads.internal.model.ConfigPayload, boolean, com.vungle.ads.SingleValueMetric):void");
    }

    public final boolean isCacheableAssetsRequired() {
        Boolean isCacheableAssetsRequired;
        ConfigPayload configPayload = config;
        if (configPayload == null || (isCacheableAssetsRequired = configPayload.isCacheableAssetsRequired()) == null) {
            return false;
        }
        return isCacheableAssetsRequired.booleanValue();
    }

    public final boolean isCleverCacheEnabled() {
        ConfigPayload.CleverCache cleverCache;
        Boolean enabled;
        ConfigPayload configPayload = config;
        if (configPayload == null || (cleverCache = configPayload.getCleverCache()) == null || (enabled = cleverCache.getEnabled()) == null) {
            return false;
        }
        return enabled.booleanValue();
    }

    public final boolean isReportIncentivizedEnabled() {
        Boolean isReportIncentivizedEnabled;
        ConfigPayload configPayload = config;
        if (configPayload == null || (isReportIncentivizedEnabled = configPayload.isReportIncentivizedEnabled()) == null) {
            return false;
        }
        return isReportIncentivizedEnabled.booleanValue();
    }

    public final boolean omEnabled() {
        ConfigPayload.ViewAbilitySettings viewAbility;
        Boolean om;
        ConfigPayload configPayload = config;
        if (configPayload == null || (viewAbility = configPayload.getViewAbility()) == null || (om = viewAbility.getOm()) == null) {
            return false;
        }
        return om.booleanValue();
    }

    public final List<Placement> placements() {
        return placements;
    }

    public final boolean rtaDebuggingEnabled() {
        Boolean rtaDebugging;
        ConfigPayload configPayload = config;
        if (configPayload == null || (rtaDebugging = configPayload.getRtaDebugging()) == null) {
            return false;
        }
        return rtaDebugging.booleanValue();
    }

    public final void setAppId$vungle_ads_release(String str) {
        Intrinsics.f(str, "applicationId");
        applicationId = str;
    }

    public final boolean shouldDisableAdId() {
        Boolean disableAdId;
        ConfigPayload configPayload = config;
        if (configPayload == null || (disableAdId = configPayload.getDisableAdId()) == null) {
            return true;
        }
        return disableAdId.booleanValue();
    }

    public final boolean signalsDisabled() {
        Boolean signalsDisabled;
        ConfigPayload configPayload = config;
        if (configPayload == null || (signalsDisabled = configPayload.getSignalsDisabled()) == null) {
            return false;
        }
        return signalsDisabled.booleanValue();
    }

    public final void updateCachedConfig(ConfigPayload configPayload, FilePreferences filePreferences) {
        Intrinsics.f(configPayload, "config");
        Intrinsics.f(filePreferences, "filePreferences");
        try {
            String str = applicationId;
            if (str == null) {
                Intrinsics.x("applicationId");
                str = null;
            }
            filePreferences.put("config_app_id", str);
            filePreferences.put("config_update_time", System.currentTimeMillis());
            Json json2 = json;
            KSerializer<Object> b2 = SerializersKt.b(json2.a(), Reflection.h(ConfigPayload.class));
            Intrinsics.d(b2, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            filePreferences.put("config_response", json2.c(b2, configPayload));
            filePreferences.apply();
        } catch (Exception e2) {
            Logger.Companion companion = Logger.Companion;
            companion.e(TAG, "Exception: " + e2.getMessage() + " for updating cached config");
        }
    }

    public final void updateConfigExtension$vungle_ads_release(Context context, String str) {
        Intrinsics.f(context, "context");
        Intrinsics.f(str, "ext");
        configExt = str;
        ServiceLocator.Companion companion = ServiceLocator.Companion;
        m149updateConfigExtension$lambda1(LazyKt__LazyJVMKt.a(LazyThreadSafetyMode.SYNCHRONIZED, new ConfigManager$updateConfigExtension$$inlined$inject$1(context))).put("config_extension", str).apply();
    }

    public final boolean validateConfig$vungle_ads_release(ConfigPayload configPayload) {
        ConfigPayload.Endpoints endpoints2;
        if (configPayload != null) {
            endpoints2 = configPayload.getEndpoints();
        } else {
            endpoints2 = null;
        }
        if (endpoints2 == null || !validateEndpoints$vungle_ads_release(configPayload.getEndpoints()) || configPayload.getPlacements() == null) {
            return false;
        }
        return true;
    }

    public final boolean validateEndpoints$vungle_ads_release(ConfigPayload.Endpoints endpoints2) {
        String str;
        boolean z2;
        boolean z3;
        String str2;
        boolean z4;
        String str3;
        boolean z5;
        String str4;
        boolean z6;
        String str5 = null;
        if (endpoints2 != null) {
            str = endpoints2.getAdsEndpoint();
        } else {
            str = null;
        }
        boolean z7 = false;
        if (str == null || str.length() == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            new InvalidEndpointError(Sdk$SDKError.Reason.INVALID_ADS_ENDPOINT, "The ads endpoint was not provided in the config.").logErrorNoReturnValue$vungle_ads_release();
            z3 = false;
        } else {
            z3 = true;
        }
        if (endpoints2 != null) {
            str2 = endpoints2.getRiEndpoint();
        } else {
            str2 = null;
        }
        if (str2 == null || str2.length() == 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4) {
            new InvalidEndpointError(Sdk$SDKError.Reason.INVALID_RI_ENDPOINT, "The ri endpoint was not provided in the config.").logErrorNoReturnValue$vungle_ads_release();
        }
        if (endpoints2 != null) {
            str3 = endpoints2.getMraidEndpoint();
        } else {
            str3 = null;
        }
        if (str3 == null || str3.length() == 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (z5) {
            new InvalidEndpointError(Sdk$SDKError.Reason.MRAID_DOWNLOAD_JS_ERROR, "The mraid endpoint was not provided in the config.").logErrorNoReturnValue$vungle_ads_release();
            z3 = false;
        }
        if (endpoints2 != null) {
            str4 = endpoints2.getMetricsEndpoint();
        } else {
            str4 = null;
        }
        if (str4 == null || str4.length() == 0) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z6) {
            new InvalidEndpointError(Sdk$SDKError.Reason.INVALID_METRICS_ENDPOINT, "The metrics endpoint was not provided in the config.").logErrorNoReturnValue$vungle_ads_release();
        }
        if (endpoints2 != null) {
            str5 = endpoints2.getErrorLogsEndpoint();
        }
        if (str5 == null || str5.length() == 0) {
            z7 = true;
        }
        if (z7) {
            Logger.Companion.e(TAG, "The error logging endpoint was not provided in the config.");
        }
        return z3;
    }
}
