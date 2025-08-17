package com.chartboost.sdk;

import android.util.Log;
import com.chartboost.sdk.impl.i3;
import com.google.android.gms.cast.MediaTrack;
import com.unity3d.ads.metadata.InAppPurchaseMetaData;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

public final class Analytics {
    public static final Analytics INSTANCE = new Analytics();

    public enum CustomEventType {
        CustomEventType1,
        CustomEventType2,
        CustomEventType3
    }

    public enum IAPPurchaseInfo {
        PRODUCT_ID,
        PRODUCT_TITLE,
        PRODUCT_DESCRIPTION,
        PRODUCT_PRICE,
        PRODUCT_CURRENCY_CODE,
        GOOGLE_PURCHASE_DATA,
        GOOGLE_PURCHASE_SIGNATURE,
        AMAZON_PURCHASE_TOKEN,
        AMAZON_USER_ID
    }

    public enum IAPType {
        GOOGLE_PLAY,
        AMAZON
    }

    public enum LevelType {
        HIGHEST_LEVEL_REACHED(1),
        CURRENT_AREA(2),
        CHARACTER_LEVEL(3),
        OTHER_SEQUENTIAL(4),
        OTHER_NONSEQUENTIAL(5);
        
        private final int levelType;

        private LevelType(int i2) {
            this.levelType = i2;
        }

        public final int getLevelType() {
            return this.levelType;
        }
    }

    public enum MiscRevenueGeneratingEventType {
        MiscRevenueGeneratingEventType1,
        MiscRevenueGeneratingEventType2,
        MiscRevenueGeneratingEventType3
    }

    private Analytics() {
    }

    public static final void trackInAppAmazonStorePurchaseEvent(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        String str8 = str;
        Intrinsics.f(str, "title");
        String str9 = str2;
        Intrinsics.f(str2, MediaTrack.ROLE_DESCRIPTION);
        String str10 = str3;
        Intrinsics.f(str3, InAppPurchaseMetaData.KEY_PRICE);
        String str11 = str4;
        Intrinsics.f(str4, "currency");
        Intrinsics.f(str5, "productID");
        if (!Chartboost.isSdkStarted()) {
            Log.e("PostInstallTracker", "You need call Chartboost.startWithAppId() before tracking in-app purchases");
            return;
        }
        i3.f17882b.k().a().a(str5, str, str2, str3, str4, (String) null, (String) null, str6, str7, IAPType.AMAZON);
    }

    public static final void trackInAppGooglePlayPurchaseEvent(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        String str8 = str;
        Intrinsics.f(str, "title");
        String str9 = str2;
        Intrinsics.f(str2, MediaTrack.ROLE_DESCRIPTION);
        String str10 = str3;
        Intrinsics.f(str3, InAppPurchaseMetaData.KEY_PRICE);
        String str11 = str4;
        Intrinsics.f(str4, "currency");
        Intrinsics.f(str5, "productID");
        if (!Chartboost.isSdkStarted()) {
            Log.e("PostInstallTracker", "You need call Chartboost.startWithAppId() before tracking in-app purchases");
            return;
        }
        i3.f17882b.k().a().a(str5, str, str2, str3, str4, str6, str7, (String) null, (String) null, IAPType.GOOGLE_PLAY);
    }

    public static final void trackInAppPurchaseEvent(HashMap<IAPPurchaseInfo, String> hashMap, IAPType iAPType) {
        Intrinsics.f(hashMap, "iAPPurchaseInfoMap");
        Intrinsics.f(iAPType, "iapType");
        if (!Chartboost.isSdkStarted()) {
            Log.e("PostInstallTracker", "You need call Chartboost.startWithAppId() before tracking in-app purchases");
            return;
        }
        String str = hashMap.get(IAPPurchaseInfo.GOOGLE_PURCHASE_DATA);
        String str2 = hashMap.get(IAPPurchaseInfo.GOOGLE_PURCHASE_SIGNATURE);
        String str3 = hashMap.get(IAPPurchaseInfo.AMAZON_USER_ID);
        String str4 = hashMap.get(IAPPurchaseInfo.AMAZON_PURCHASE_TOKEN);
        String str5 = hashMap.get(IAPPurchaseInfo.PRODUCT_ID);
        String str6 = hashMap.get(IAPPurchaseInfo.PRODUCT_TITLE);
        String str7 = hashMap.get(IAPPurchaseInfo.PRODUCT_DESCRIPTION);
        String str8 = hashMap.get(IAPPurchaseInfo.PRODUCT_PRICE);
        String str9 = hashMap.get(IAPPurchaseInfo.PRODUCT_CURRENCY_CODE);
        if (str5 == null || str5.length() == 0 || str6 == null || str6.length() == 0 || str7 == null || str7.length() == 0 || str8 == null || str8.length() == 0 || str9 == null || str9.length() == 0) {
            Log.e("PostInstallTracker", "Null object is passed. Please pass a valid value object");
        } else {
            i3.f17882b.k().a().a(str5, str6, str7, str8, str9, str, str2, str3, str4, iAPType);
        }
    }

    public static final void trackLevelInfo(String str, LevelType levelType, int i2, String str2) {
        Intrinsics.f(str, "eventLabel");
        Intrinsics.f(levelType, "type");
        Intrinsics.f(str2, MediaTrack.ROLE_DESCRIPTION);
        trackLevelInfo(str, levelType, i2, 0, str2);
    }

    public static final void trackLevelInfo(String str, LevelType levelType, int i2, int i3, String str2) {
        Intrinsics.f(str, "eventLabel");
        Intrinsics.f(levelType, "type");
        Intrinsics.f(str2, MediaTrack.ROLE_DESCRIPTION);
        if (!Chartboost.isSdkStarted()) {
            Log.e("PostInstallTracker", "You need call Chartboost.startWithAppId() before tracking in-app purchases");
            return;
        }
        i3.f17882b.k().a().a(str, levelType, i2, i3, str2, System.currentTimeMillis());
    }
}
