package com.unity3d.services;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import com.unity3d.ads.IUnityAdsInitializationListener;
import com.unity3d.ads.UnityAds;
import com.unity3d.services.core.configuration.EnvironmentCheck;
import com.unity3d.services.core.configuration.InitializeEventsMetricSender;
import com.unity3d.services.core.device.Device;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.properties.ClientProperties;
import com.unity3d.services.core.properties.SdkProperties;
import com.unity3d.services.core.properties.Session;
import com.unity3d.services.core.request.metrics.InitMetric;
import kotlin.jvm.internal.Intrinsics;

public final class UnityServices {
    public static final UnityServices INSTANCE = new UnityServices();
    private static final boolean isSupported = true;

    public enum UnityServicesError {
        INVALID_ARGUMENT,
        INIT_SANITY_CHECK_FAIL
    }

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                com.unity3d.services.core.properties.SdkProperties$InitializationState[] r0 = com.unity3d.services.core.properties.SdkProperties.InitializationState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.unity3d.services.core.properties.SdkProperties$InitializationState r1 = com.unity3d.services.core.properties.SdkProperties.InitializationState.INITIALIZED_SUCCESSFULLY     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.unity3d.services.core.properties.SdkProperties$InitializationState r1 = com.unity3d.services.core.properties.SdkProperties.InitializationState.INITIALIZED_FAILED     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.unity3d.services.core.properties.SdkProperties$InitializationState r1 = com.unity3d.services.core.properties.SdkProperties.InitializationState.INITIALIZING     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.UnityServices.WhenMappings.<clinit>():void");
        }
    }

    private UnityServices() {
    }

    private final String createExpectedParametersString(String str, Object obj, Object obj2) {
        return "- " + str + " Current: " + obj + " | Received: " + obj2;
    }

    public static final boolean getDebugMode() {
        return SdkProperties.getDebugMode();
    }

    public static /* synthetic */ void getDebugMode$annotations() {
    }

    public static final String getVersion() {
        String versionName = SdkProperties.getVersionName();
        Intrinsics.e(versionName, "getVersionName()");
        return versionName;
    }

    public static /* synthetic */ void getVersion$annotations() {
    }

    public static final void initialize(Context context, String str, boolean z2, IUnityAdsInitializationListener iUnityAdsInitializationListener) {
        int i2;
        String str2;
        boolean z3;
        String str3;
        DeviceLog.entered();
        if (str != null && StringsKt__StringNumberConversionsKt.k(str) != null) {
            boolean z4 = false;
            if (SdkProperties.getCurrentInitializationState() != SdkProperties.InitializationState.NOT_INITIALIZED) {
                String gameId = ClientProperties.getGameId();
                boolean isTestMode = SdkProperties.isTestMode();
                StringBuilder sb = new StringBuilder();
                if (gameId != null && !Intrinsics.a(gameId, str)) {
                    sb.append(INSTANCE.createExpectedParametersString("Game ID", gameId, str));
                    Intrinsics.e(sb, "append(value)");
                    sb.append(10);
                    Intrinsics.e(sb, "append('\\n')");
                }
                if (isTestMode != z2) {
                    sb.append(INSTANCE.createExpectedParametersString("Test Mode", Boolean.valueOf(isTestMode), Boolean.valueOf(z2)));
                    Intrinsics.e(sb, "append(value)");
                    sb.append(10);
                    Intrinsics.e(sb, "append('\\n')");
                }
                String sb2 = sb.toString();
                Intrinsics.e(sb2, "StringBuilder().apply(builderAction).toString()");
                if (sb2.length() > 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    InitializeEventsMetricSender.getInstance().sendMetric(InitMetric.newInitDiffParams());
                    str3 = "different parameters: \n" + sb2;
                } else {
                    InitializeEventsMetricSender.getInstance().sendMetric(InitMetric.newInitSameParams());
                    str3 = "the same Game ID: " + str + " and Test Mode: " + z2 + " values.";
                }
                DeviceLog.warning("Unity Ads SDK initialize has already been called with " + str3 + " Responding with first initialization result.");
            }
            SdkProperties.addInitializationListener(iUnityAdsInitializationListener);
            SdkProperties.InitializationState currentInitializationState = SdkProperties.getCurrentInitializationState();
            if (currentInitializationState == null) {
                i2 = -1;
            } else {
                i2 = WhenMappings.$EnumSwitchMapping$0[currentInitializationState.ordinal()];
            }
            if (i2 == 1) {
                SdkProperties.notifyInitializationComplete();
            } else if (i2 == 2) {
                SdkProperties.notifyInitializationFailed(UnityAds.UnityAdsInitializationError.INTERNAL_ERROR, "Unity Ads SDK failed to initialize due to previous failed reason");
            } else if (i2 != 3) {
                SdkProperties.setInitializeState(SdkProperties.InitializationState.INITIALIZING);
                ClientProperties.setGameId(str);
                SdkProperties.setTestMode(z2);
                if (!isSupported) {
                    DeviceLog.error("Error while initializing Unity Services: device is not supported");
                    SdkProperties.notifyInitializationFailed(UnityAds.UnityAdsInitializationError.INTERNAL_ERROR, "Unity Ads SDK failed to initialize due to device is not supported");
                    return;
                }
                SdkProperties.setInitializationTime(Device.getElapsedRealtime());
                SdkProperties.setInitializationTimeSinceEpoch(System.currentTimeMillis());
                if (str.length() == 0) {
                    z4 = true;
                }
                if (z4) {
                    DeviceLog.error("Error while initializing Unity Services: empty game ID, halting Unity Ads init");
                    SdkProperties.notifyInitializationFailed(UnityAds.UnityAdsInitializationError.INVALID_ARGUMENT, "Unity Ads SDK failed to initialize due to empty game ID");
                } else if (context == null) {
                    DeviceLog.error("Error while initializing Unity Services: null context, halting Unity Ads init");
                    SdkProperties.notifyInitializationFailed(UnityAds.UnityAdsInitializationError.INVALID_ARGUMENT, "Unity Ads SDK failed to initialize due to null context");
                } else {
                    if (context instanceof Application) {
                        ClientProperties.setApplication((Application) context);
                    } else if (context instanceof Activity) {
                        Activity activity = (Activity) context;
                        if (activity.getApplication() != null) {
                            ClientProperties.setApplication(activity.getApplication());
                        } else {
                            DeviceLog.error("Error while initializing Unity Services: cannot retrieve application from context, halting Unity Ads init");
                            SdkProperties.notifyInitializationFailed(UnityAds.UnityAdsInitializationError.INVALID_ARGUMENT, "Unity Ads SDK failed to initialize due to inability to retrieve application from context");
                            return;
                        }
                    } else {
                        DeviceLog.error("Error while initializing Unity Services: invalid context, halting Unity Ads init");
                        SdkProperties.notifyInitializationFailed(UnityAds.UnityAdsInitializationError.INVALID_ARGUMENT, "Unity Ads SDK failed to initialize due to invalid context");
                        return;
                    }
                    if (z2) {
                        str2 = "test mode";
                    } else {
                        str2 = "production mode";
                    }
                    DeviceLog.info("Initializing Unity Services " + SdkProperties.getVersionName() + " (" + SdkProperties.getVersionCode() + ") with game id " + str + " in " + str2 + ", session " + Session.Default.getId());
                    SdkProperties.setDebugMode(SdkProperties.getDebugMode());
                    if (context.getApplicationContext() != null) {
                        ClientProperties.setApplicationContext(context.getApplicationContext());
                        if (!EnvironmentCheck.isEnvironmentOk()) {
                            DeviceLog.error("Error during Unity Services environment check, halting Unity Services init");
                            SdkProperties.notifyInitializationFailed(UnityAds.UnityAdsInitializationError.INTERNAL_ERROR, "Unity Ads SDK failed to initialize due to environment check failed");
                            return;
                        }
                        DeviceLog.info("Unity Services environment check OK");
                        UnityAdsSDK.INSTANCE.initialize();
                        return;
                    }
                    DeviceLog.error("Error while initializing Unity Services: cannot retrieve application context, halting Unity Ads init");
                    SdkProperties.notifyInitializationFailed(UnityAds.UnityAdsInitializationError.INVALID_ARGUMENT, "Unity Ads SDK failed to initialize due to inability to retrieve application context");
                }
            }
        } else if (iUnityAdsInitializationListener != null) {
            iUnityAdsInitializationListener.onInitializationFailed(UnityAds.UnityAdsInitializationError.INVALID_ARGUMENT, "gameId \"" + str + "\" should be a number.");
        }
    }

    public static final boolean isInitialized() {
        return SdkProperties.isInitialized();
    }

    public static /* synthetic */ void isInitialized$annotations() {
    }

    public static final boolean isSupported() {
        return isSupported;
    }

    public static /* synthetic */ void isSupported$annotations() {
    }

    public static final void setDebugMode(boolean z2) {
        SdkProperties.setDebugMode(z2);
    }
}
