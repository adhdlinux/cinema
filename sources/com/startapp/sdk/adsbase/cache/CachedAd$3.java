package com.startapp.sdk.adsbase.cache;

import android.content.Context;
import com.startapp.j8;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import com.startapp.sdk.adsbase.model.AdPreferences;

public class CachedAd$3 extends Ad {
    public final /* synthetic */ j8 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CachedAd$3(j8 j8Var, Context context, AdPreferences.Placement placement) {
        super(context, placement);
        this.this$0 = j8Var;
    }

    public void a(AdPreferences adPreferences, AdEventListener adEventListener) {
    }

    public String getAdId() {
        return null;
    }

    public String getBidToken() {
        return null;
    }

    public String getErrorMessage() {
        return "explicit call: nofill [204]";
    }
}
