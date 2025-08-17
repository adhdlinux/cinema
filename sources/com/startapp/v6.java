package com.startapp;

import android.content.Context;
import com.startapp.sdk.adsbase.ActivityExtra;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import com.startapp.sdk.adsbase.model.AdPreferences;

public interface v6 {
    void a(boolean z2);

    boolean a();

    boolean a(String str);

    Long b();

    Long c();

    boolean d();

    Ad.AdState getState();

    boolean isBelowMinCPM();

    boolean isReady();

    boolean load(AdPreferences adPreferences, AdEventListener adEventListener);

    void setActivityExtra(ActivityExtra activityExtra);

    void setContext(Context context);
}
