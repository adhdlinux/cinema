package com.startapp.sdk.ads.banner;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import com.startapp.sdk.ads.banner.bannerstandard.BannerStandard;
import com.startapp.sdk.ads.banner.bannerstandard.BannerStandardAd;
import com.startapp.sdk.adsbase.model.AdPreferences;

public class Mrec extends BannerStandard {
    public Mrec(Activity activity) {
        super(activity);
    }

    public String e() {
        return "StartApp Mrec";
    }

    public int getHeightInDp() {
        return 250;
    }

    public int getWidthInDp() {
        return 300;
    }

    public void loadAd(int i2, int i3) {
        super.loadAd(getWidthInDp(), getHeightInDp());
    }

    public int r() {
        return 1;
    }

    public Mrec(Activity activity, AdPreferences adPreferences) {
        super(activity, adPreferences);
    }

    public Mrec(Activity activity, BannerListener bannerListener) {
        super(activity, bannerListener);
    }

    public Mrec(Activity activity, AdPreferences adPreferences, BannerListener bannerListener) {
        super(activity, adPreferences, bannerListener);
    }

    public Mrec(Activity activity, AttributeSet attributeSet) {
        super(activity, attributeSet);
    }

    public Mrec(Activity activity, AttributeSet attributeSet, int i2) {
        super(activity, attributeSet, i2);
    }

    @Deprecated
    public Mrec(Context context) {
        super(context);
    }

    @Deprecated
    public Mrec(Context context, AdPreferences adPreferences) {
        super(context, adPreferences);
    }

    @Deprecated
    public Mrec(Context context, BannerListener bannerListener) {
        super(context, bannerListener);
    }

    @Deprecated
    public Mrec(Context context, AdPreferences adPreferences, BannerListener bannerListener) {
        super(context, adPreferences, bannerListener);
    }

    @Deprecated
    public Mrec(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Deprecated
    public Mrec(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public Mrec(Context context, boolean z2, AdPreferences adPreferences, BannerStandardAd bannerStandardAd) {
        super(context, z2, adPreferences, bannerStandardAd);
    }
}
