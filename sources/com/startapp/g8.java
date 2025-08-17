package com.startapp;

import com.startapp.sdk.adsbase.StartAppSDKInternal;
import com.startapp.sdk.adsbase.cache.CacheMetaData;
import com.startapp.sdk.adsbase.model.AdPreferences;

public class g8 extends f8 {
    public g8(j8 j8Var) {
        super(j8Var);
    }

    public boolean a() {
        String str = StartAppSDKInternal.f36218a;
        StartAppSDKInternal startAppSDKInternal = StartAppSDKInternal.c.f36252a;
        AdPreferences.Placement placement = this.f34519a.f34743a;
        if (!startAppSDKInternal.f36223f || startAppSDKInternal.f36226i || (startAppSDKInternal.f36224g && (placement != AdPreferences.Placement.INAPP_RETURN || !CacheMetaData.f36308a.a().g()))) {
            return false;
        }
        return true;
    }

    public long b() {
        v6 v6Var = this.f34519a.f34747e;
        if (v6Var == null) {
            return -1;
        }
        Long c2 = v6Var.c();
        Long b2 = v6Var.b();
        if (c2 == null || b2 == null) {
            return -1;
        }
        long longValue = c2.longValue() - (System.currentTimeMillis() - b2.longValue());
        if (longValue >= 0) {
            return longValue;
        }
        return 0;
    }
}
