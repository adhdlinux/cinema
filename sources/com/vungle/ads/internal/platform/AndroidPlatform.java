package com.vungle.ads.internal.platform;

import android.content.ContentResolver;
import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import android.os.Environment;
import android.os.PowerManager;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import androidx.core.util.Consumer;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.appset.AppSet;
import com.google.android.gms.appset.AppSetIdClient;
import com.google.android.gms.appset.AppSetIdInfo;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.tasks.Task;
import com.unity3d.services.core.device.MimeTypes;
import com.vungle.ads.internal.executor.VungleThreadPoolExecutor;
import com.vungle.ads.internal.model.AdvertisingInfo;
import com.vungle.ads.internal.util.Logger;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class AndroidPlatform implements Platform {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "AndroidPlatform";
    private AdvertisingInfo advertisingInfo;
    private String appSetId;
    private Integer appSetIdScope;
    private final AudioManager audioManager;
    private final Context context;
    private final boolean isSideLoaded;
    private final PowerManager powerManager;
    private final VungleThreadPoolExecutor uaExecutor;
    private String userAgent;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String getCarrierName$vungle_ads_release(Context context) {
            Intrinsics.f(context, "context");
            Object systemService = context.getSystemService("phone");
            Intrinsics.d(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
            return ((TelephonyManager) systemService).getNetworkOperatorName();
        }
    }

    public AndroidPlatform(Context context2, VungleThreadPoolExecutor vungleThreadPoolExecutor) {
        Intrinsics.f(context2, "context");
        Intrinsics.f(vungleThreadPoolExecutor, "uaExecutor");
        this.context = context2;
        this.uaExecutor = vungleThreadPoolExecutor;
        updateAppSetID();
        Object systemService = context2.getSystemService("power");
        Intrinsics.d(systemService, "null cannot be cast to non-null type android.os.PowerManager");
        this.powerManager = (PowerManager) systemService;
        Object systemService2 = context2.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        Intrinsics.d(systemService2, "null cannot be cast to non-null type android.media.AudioManager");
        this.audioManager = (AudioManager) systemService2;
    }

    private final AdvertisingInfo getAmazonAdvertisingInfo() {
        AdvertisingInfo advertisingInfo2 = new AdvertisingInfo();
        try {
            ContentResolver contentResolver = this.context.getContentResolver();
            boolean z2 = true;
            if (Settings.Secure.getInt(contentResolver, "limit_ad_tracking") != 1) {
                z2 = false;
            }
            advertisingInfo2.setLimitAdTracking(z2);
            advertisingInfo2.setAdvertisingId(Settings.Secure.getString(contentResolver, "advertising_id"));
        } catch (Settings.SettingNotFoundException e2) {
            Logger.Companion.w(TAG, "Error getting Amazon advertising info: Setting not found.", e2);
        } catch (Exception e3) {
            Logger.Companion.w(TAG, "Error getting Amazon advertising info", e3);
        }
        return advertisingInfo2;
    }

    private final AdvertisingInfo getGoogleAdvertisingInfo() {
        AdvertisingInfo advertisingInfo2 = new AdvertisingInfo();
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.context);
            Intrinsics.e(advertisingIdInfo, "getAdvertisingIdInfo(context)");
            advertisingInfo2.setAdvertisingId(advertisingIdInfo.getId());
            advertisingInfo2.setLimitAdTracking(advertisingIdInfo.isLimitAdTrackingEnabled());
        } catch (NoClassDefFoundError e2) {
            Logger.Companion companion = Logger.Companion;
            companion.e(TAG, "Play services Not available: " + e2.getLocalizedMessage());
            advertisingInfo2.setAdvertisingId(Settings.Secure.getString(this.context.getContentResolver(), "advertising_id"));
        } catch (GooglePlayServicesNotAvailableException e3) {
            Logger.Companion companion2 = Logger.Companion;
            companion2.e(TAG, "Play services Not available: " + e3.getLocalizedMessage());
        } catch (Exception e4) {
            Logger.Companion companion3 = Logger.Companion;
            companion3.e(TAG, "Error getting Google advertising info: " + e4.getLocalizedMessage());
        }
        return advertisingInfo2;
    }

    /* access modifiers changed from: private */
    /* renamed from: getUserAgentLazy$lambda-0  reason: not valid java name */
    public static final void m195getUserAgentLazy$lambda0(AndroidPlatform androidPlatform, Consumer consumer) {
        Intrinsics.f(androidPlatform, "this$0");
        Intrinsics.f(consumer, "$consumer");
        new WebViewUtil(androidPlatform.context).getUserAgent(consumer);
    }

    private final void updateAppSetID() {
        boolean z2;
        String str = this.appSetId;
        if (str == null || str.length() == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            try {
                AppSetIdClient client = AppSet.getClient(this.context);
                Intrinsics.e(client, "getClient(context)");
                Task<AppSetIdInfo> appSetIdInfo = client.getAppSetIdInfo();
                Intrinsics.e(appSetIdInfo, "client.appSetIdInfo");
                appSetIdInfo.addOnSuccessListener(new a(this));
            } catch (NoClassDefFoundError e2) {
                Logger.Companion companion = Logger.Companion;
                companion.e(TAG, "Required libs to get AppSetID Not available: " + e2.getLocalizedMessage());
            } catch (Exception e3) {
                Logger.Companion companion2 = Logger.Companion;
                companion2.e(TAG, "Error getting AppSetID: " + e3.getLocalizedMessage());
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: updateAppSetID$lambda-2  reason: not valid java name */
    public static final void m196updateAppSetID$lambda2(AndroidPlatform androidPlatform, AppSetIdInfo appSetIdInfo) {
        Intrinsics.f(androidPlatform, "this$0");
        if (appSetIdInfo != null) {
            androidPlatform.appSetId = appSetIdInfo.getId();
            androidPlatform.appSetIdScope = Integer.valueOf(appSetIdInfo.getScope());
        }
    }

    public AdvertisingInfo getAdvertisingInfo() {
        AdvertisingInfo advertisingInfo2;
        boolean z2;
        AdvertisingInfo advertisingInfo3 = this.advertisingInfo;
        if (advertisingInfo3 != null) {
            String advertisingId = advertisingInfo3.getAdvertisingId();
            if (advertisingId == null || advertisingId.length() == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                return advertisingInfo3;
            }
        }
        if (StringsKt__StringsJVMKt.t(Build.MANUFACTURER, "Amazon", true)) {
            advertisingInfo2 = getAmazonAdvertisingInfo();
        } else {
            advertisingInfo2 = getGoogleAdvertisingInfo();
        }
        this.advertisingInfo = advertisingInfo2;
        return advertisingInfo2;
    }

    public String getAppSetId() {
        return this.appSetId;
    }

    public Integer getAppSetIdScope() {
        return this.appSetIdScope;
    }

    public String getCarrierName() {
        String carrierName$vungle_ads_release = Companion.getCarrierName$vungle_ads_release(this.context);
        Intrinsics.e(carrierName$vungle_ads_release, "getCarrierName(context)");
        return carrierName$vungle_ads_release;
    }

    public String getUserAgent() {
        String str = this.userAgent;
        return str == null ? System.getProperty("http.agent") : str;
    }

    public void getUserAgentLazy(Consumer<String> consumer) {
        Intrinsics.f(consumer, "consumer");
        this.uaExecutor.execute(new b(this, consumer));
    }

    public float getVolumeLevel() {
        try {
            return ((float) this.audioManager.getStreamVolume(3)) / ((float) this.audioManager.getStreamMaxVolume(3));
        } catch (Exception unused) {
            return 0.0f;
        }
    }

    public boolean isBatterySaverEnabled() {
        return this.powerManager.isPowerSaveMode();
    }

    public boolean isSdCardPresent() {
        try {
            return Intrinsics.a(Environment.getExternalStorageState(), "mounted");
        } catch (Exception e2) {
            Logger.Companion.e(TAG, "Acquiring external storage state failed", e2);
            return false;
        }
    }

    public boolean isSideLoaded() {
        return this.isSideLoaded;
    }

    public boolean isSilentModeEnabled() {
        try {
            if (this.audioManager.getRingerMode() == 0 || this.audioManager.getRingerMode() == 1) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean isSoundEnabled() {
        try {
            return this.audioManager.getStreamVolume(3) > 0;
        } catch (Exception unused) {
            return true;
        }
    }

    public void setUserAgent(String str) {
        this.userAgent = str;
    }
}
