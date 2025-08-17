package com.vungle.ads.internal.privacy;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.vungle.ads.ServiceLocator;
import com.vungle.ads.internal.ConfigManager;
import com.vungle.ads.internal.model.ConfigPayload;
import com.vungle.ads.internal.persistence.FilePreferences;
import com.vungle.ads.internal.util.Logger;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

public final class PrivacyManager {
    public static final PrivacyManager INSTANCE = new PrivacyManager();
    private static PrivacyConsent ccpaConsent;
    private static final AtomicReference<Boolean> coppaStatus = new AtomicReference<>();
    private static final AtomicReference<Boolean> disableAdId = new AtomicReference<>();
    private static FilePreferences filePreferences;
    private static String gdprConsent;
    private static String gdprConsentMessageVersion;
    private static String gdprConsentSource;
    private static Long gdprConsentTimestamp;
    private static final AtomicBoolean initialized = new AtomicBoolean(false);
    private static SharedPreferences sharedPreferences;

    public enum DeviceIdAllowed {
        ALLOW_ID,
        DISABLE_ID,
        FALLBACK
    }

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[DeviceIdAllowed.values().length];
            iArr[DeviceIdAllowed.DISABLE_ID.ordinal()] = 1;
            iArr[DeviceIdAllowed.FALLBACK.ordinal()] = 2;
            iArr[DeviceIdAllowed.ALLOW_ID.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[ConfigPayload.IABSettings.TcfStatus.values().length];
            iArr2[ConfigPayload.IABSettings.TcfStatus.DISABLE_ID.ordinal()] = 1;
            iArr2[ConfigPayload.IABSettings.TcfStatus.ALLOW_ID.ordinal()] = 2;
            iArr2[ConfigPayload.IABSettings.TcfStatus.LEGACY.ordinal()] = 3;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    private PrivacyManager() {
    }

    private final void saveCcpaConsent(PrivacyConsent privacyConsent) {
        FilePreferences put;
        FilePreferences filePreferences2 = filePreferences;
        if (filePreferences2 != null && (put = filePreferences2.put("ccpa_status", privacyConsent.getValue())) != null) {
            put.apply();
        }
    }

    private final void saveCoppaConsent(boolean z2) {
        FilePreferences put;
        FilePreferences filePreferences2 = filePreferences;
        if (filePreferences2 != null && (put = filePreferences2.put("is_coppa", z2)) != null) {
            put.apply();
        }
    }

    private final void saveGdprConsent(String str, String str2, String str3, long j2) {
        FilePreferences put;
        FilePreferences put2;
        FilePreferences put3;
        FilePreferences put4;
        FilePreferences filePreferences2 = filePreferences;
        if (filePreferences2 != null && (put = filePreferences2.put("gdpr_status", str)) != null && (put2 = put.put("gdpr_source", str2)) != null && (put3 = put2.put("gdpr_message_version", str3)) != null && (put4 = put3.put("gdpr_timestamp", j2)) != null) {
            put4.apply();
        }
    }

    public final DeviceIdAllowed allowDeviceIDFromTCF() {
        int i2;
        Boolean gdprAppliesFromPreferences = getGdprAppliesFromPreferences();
        if (Intrinsics.a(gdprAppliesFromPreferences, Boolean.TRUE)) {
            ConfigPayload.IABSettings.TcfStatus tcfStatus = ConfigManager.INSTANCE.getTcfStatus();
            if (tcfStatus == null) {
                i2 = -1;
            } else {
                i2 = WhenMappings.$EnumSwitchMapping$1[tcfStatus.ordinal()];
            }
            if (i2 != -1) {
                if (i2 == 1) {
                    return DeviceIdAllowed.DISABLE_ID;
                }
                if (i2 == 2) {
                    return DeviceIdAllowed.ALLOW_ID;
                }
                if (i2 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
            }
            return DeviceIdAllowed.FALLBACK;
        } else if (gdprAppliesFromPreferences == null) {
            return DeviceIdAllowed.FALLBACK;
        } else {
            return DeviceIdAllowed.ALLOW_ID;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.getValue();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getCcpaStatus() {
        /*
            r1 = this;
            com.vungle.ads.internal.privacy.PrivacyConsent r0 = ccpaConsent
            if (r0 == 0) goto L_0x000a
            java.lang.String r0 = r0.getValue()
            if (r0 != 0) goto L_0x0010
        L_0x000a:
            com.vungle.ads.internal.privacy.PrivacyConsent r0 = com.vungle.ads.internal.privacy.PrivacyConsent.OPT_IN
            java.lang.String r0 = r0.getValue()
        L_0x0010:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.privacy.PrivacyManager.getCcpaStatus():java.lang.String");
    }

    public final String getConsentMessageVersion() {
        String str = gdprConsentMessageVersion;
        return str == null ? "" : str;
    }

    public final String getConsentSource() {
        String str = gdprConsentSource;
        return str == null ? "no_interaction" : str;
    }

    public final String getConsentStatus() {
        String str = gdprConsent;
        return str == null ? "unknown" : str;
    }

    public final long getConsentTimestamp() {
        Long l2 = gdprConsentTimestamp;
        if (l2 != null) {
            return l2.longValue();
        }
        return 0;
    }

    public final COPPA getCoppaStatus() {
        AtomicReference<Boolean> atomicReference = coppaStatus;
        if (atomicReference.get() == null) {
            return COPPA.COPPA_NOTSET;
        }
        if (Intrinsics.a(atomicReference.get(), Boolean.TRUE)) {
            return COPPA.COPPA_ENABLED;
        }
        if (Intrinsics.a(atomicReference.get(), Boolean.FALSE)) {
            return COPPA.COPPA_DISABLED;
        }
        return COPPA.COPPA_NOTSET;
    }

    public final Boolean getDisableAdId$vungle_ads_release() {
        return disableAdId.get();
    }

    public final Boolean getGdprAppliesFromPreferences() {
        Object obj;
        Object obj2;
        Integer num;
        String string;
        Integer num2;
        try {
            Result.Companion companion = Result.f40263c;
            SharedPreferences sharedPreferences2 = sharedPreferences;
            if (sharedPreferences2 != null) {
                num2 = Integer.valueOf(sharedPreferences2.getInt("IABTCF_gdprApplies", -1));
            } else {
                num2 = null;
            }
            obj = Result.b(num2);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.f40263c;
            obj = Result.b(ResultKt.a(th));
        }
        if (Result.e(obj) != null) {
            try {
                SharedPreferences sharedPreferences3 = sharedPreferences;
                if (sharedPreferences3 == null || (string = sharedPreferences3.getString("IABTCF_gdprApplies", "-1")) == null) {
                    num = null;
                } else {
                    Intrinsics.e(string, "getString(IABTCF_GDPR_APPLIES, \"-1\")");
                    num = Integer.valueOf(Integer.parseInt(string));
                }
                obj2 = Result.b(num);
            } catch (Throwable th2) {
                Result.Companion companion3 = Result.f40263c;
                obj2 = Result.b(ResultKt.a(th2));
            }
            obj = obj2;
        }
        if (Result.g(obj)) {
            obj = null;
        }
        Integer num3 = (Integer) obj;
        if (num3 != null && num3.intValue() == 1) {
            return Boolean.TRUE;
        }
        if (num3 != null && num3.intValue() == 0) {
            return Boolean.FALSE;
        }
        return null;
    }

    public final String getIABTCFString() {
        SharedPreferences sharedPreferences2 = sharedPreferences;
        String string = sharedPreferences2 != null ? sharedPreferences2.getString("IABTCF_TCString", "") : null;
        return string == null ? "" : string;
    }

    public final String getPreviousTcfToken() {
        FilePreferences filePreferences2 = filePreferences;
        if (filePreferences2 != null) {
            return filePreferences2.getString("previous_tcf_token", "");
        }
        return null;
    }

    public final SharedPreferences getSharedPreferences() {
        return sharedPreferences;
    }

    public final synchronized void init(Context context) {
        Intrinsics.f(context, "context");
        AtomicBoolean atomicBoolean = initialized;
        if (atomicBoolean.get()) {
            Logger.Companion.w("PrivacyManager", "PrivacyManager already initialized");
            return;
        }
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        FilePreferences filePreferences2 = (FilePreferences) ServiceLocator.Companion.getInstance(context).getService(FilePreferences.class);
        filePreferences = filePreferences2;
        AtomicReference<Boolean> atomicReference = disableAdId;
        Boolean bool = atomicReference.get();
        if (bool != null) {
            saveDisableAdId(bool.booleanValue());
        } else {
            Boolean bool2 = filePreferences2.getBoolean("disable_ad_id");
            if (bool2 != null) {
                atomicReference.set(Boolean.valueOf(bool2.booleanValue()));
            }
        }
        String str = gdprConsent;
        long j2 = 0;
        if (str != null) {
            String str2 = gdprConsentSource;
            if (str2 == null) {
                str2 = "";
            }
            String str3 = str2;
            String str4 = gdprConsentMessageVersion;
            if (str4 == null) {
                str4 = "";
            }
            String str5 = str4;
            Long l2 = gdprConsentTimestamp;
            if (l2 != null) {
                j2 = l2.longValue();
            }
            saveGdprConsent(str, str3, str5, j2);
        } else {
            String string = filePreferences2.getString("gdpr_status");
            PrivacyConsent privacyConsent = PrivacyConsent.OPT_IN;
            if (Intrinsics.a(string, privacyConsent.getValue())) {
                string = privacyConsent.getValue();
            } else {
                PrivacyConsent privacyConsent2 = PrivacyConsent.OPT_OUT;
                if (Intrinsics.a(string, privacyConsent2.getValue())) {
                    string = privacyConsent2.getValue();
                }
            }
            gdprConsent = string;
            gdprConsentSource = filePreferences2.getString("gdpr_source");
            gdprConsentMessageVersion = filePreferences2.getString("gdpr_message_version");
            gdprConsentTimestamp = Long.valueOf(filePreferences2.getLong("gdpr_timestamp", 0));
        }
        PrivacyConsent privacyConsent3 = ccpaConsent;
        if (privacyConsent3 != null) {
            saveCcpaConsent(privacyConsent3);
        } else {
            String string2 = filePreferences2.getString("ccpa_status");
            PrivacyConsent privacyConsent4 = PrivacyConsent.OPT_OUT;
            if (!Intrinsics.a(privacyConsent4.getValue(), string2)) {
                privacyConsent4 = PrivacyConsent.OPT_IN;
            }
            ccpaConsent = privacyConsent4;
        }
        AtomicReference<Boolean> atomicReference2 = coppaStatus;
        Boolean bool3 = atomicReference2.get();
        if (bool3 != null) {
            saveCoppaConsent(bool3.booleanValue());
        } else {
            Boolean bool4 = filePreferences2.getBoolean("is_coppa");
            if (bool4 != null) {
                atomicReference2.set(Boolean.valueOf(bool4.booleanValue()));
            }
        }
        atomicBoolean.set(true);
    }

    public final void saveDisableAdId(boolean z2) {
        FilePreferences put;
        FilePreferences filePreferences2 = filePreferences;
        if (filePreferences2 != null && (put = filePreferences2.put("disable_ad_id", z2)) != null) {
            put.apply();
        }
    }

    public final void setPreviousTcfToken(String str) {
        boolean z2;
        FilePreferences filePreferences2;
        FilePreferences put;
        if (str == null || str.length() == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2 && (filePreferences2 = filePreferences) != null && (put = filePreferences2.put("previous_tcf_token", str)) != null) {
            put.apply();
        }
    }

    public final void setSharedPreferences(SharedPreferences sharedPreferences2) {
        sharedPreferences = sharedPreferences2;
    }

    public final boolean shouldReturnTrueForLegacy$vungle_ads_release() {
        String iABTCFString = getIABTCFString();
        if (Intrinsics.a(getPreviousTcfToken(), iABTCFString)) {
            return false;
        }
        setPreviousTcfToken(iABTCFString);
        return true;
    }

    public final boolean shouldSendAdIds() {
        int i2 = WhenMappings.$EnumSwitchMapping$0[allowDeviceIDFromTCF().ordinal()];
        if (i2 == 1) {
            return false;
        }
        if (i2 == 2 || i2 == 3) {
            Boolean disableAdId$vungle_ads_release = getDisableAdId$vungle_ads_release();
            if (disableAdId$vungle_ads_release == null || disableAdId$vungle_ads_release.booleanValue()) {
                return false;
            }
            return true;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final boolean shouldSendTCFString() {
        int i2;
        if (!Intrinsics.a(getGdprAppliesFromPreferences(), Boolean.TRUE)) {
            return false;
        }
        ConfigPayload.IABSettings.TcfStatus tcfStatus = ConfigManager.INSTANCE.getTcfStatus();
        if (tcfStatus == null) {
            i2 = -1;
        } else {
            i2 = WhenMappings.$EnumSwitchMapping$1[tcfStatus.ordinal()];
        }
        if (i2 != -1) {
            if (i2 == 1 || i2 == 2) {
                return true;
            }
            if (i2 != 3) {
                throw new NoWhenBranchMatchedException();
            }
        }
        return shouldReturnTrueForLegacy$vungle_ads_release();
    }

    public final void updateCcpaConsent(PrivacyConsent privacyConsent) {
        Intrinsics.f(privacyConsent, "consent");
        ccpaConsent = privacyConsent;
        saveCcpaConsent(privacyConsent);
    }

    public final void updateCoppaConsent(boolean z2) {
        coppaStatus.set(Boolean.valueOf(z2));
        saveCoppaConsent(z2);
    }

    public final void updateDisableAdId(boolean z2) {
        disableAdId.set(Boolean.valueOf(z2));
        saveDisableAdId(z2);
    }

    public final void updateGdprConsent(String str, String str2, String str3) {
        Intrinsics.f(str, "consent");
        Intrinsics.f(str2, "source");
        gdprConsent = str;
        gdprConsentSource = str2;
        gdprConsentMessageVersion = str3;
        long currentTimeMillis = System.currentTimeMillis() / ((long) 1000);
        gdprConsentTimestamp = Long.valueOf(currentTimeMillis);
        String str4 = gdprConsentMessageVersion;
        if (str4 == null) {
            str4 = "";
        }
        saveGdprConsent(str, str2, str4, currentTimeMillis);
    }
}
