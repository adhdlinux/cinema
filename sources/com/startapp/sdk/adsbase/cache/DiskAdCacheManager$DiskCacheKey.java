package com.startapp.sdk.adsbase.cache;

import com.startapp.sdk.adsbase.model.AdPreferences;
import java.io.Serializable;

public class DiskAdCacheManager$DiskCacheKey implements Serializable {
    private static final long serialVersionUID = 1;
    public AdPreferences adPreferences;
    private int numberOfLoadedAd;
    public AdPreferences.Placement placement;

    public DiskAdCacheManager$DiskCacheKey(AdPreferences.Placement placement2, AdPreferences adPreferences2) {
        this.placement = placement2;
        this.adPreferences = adPreferences2;
    }

    public int a() {
        return this.numberOfLoadedAd;
    }

    public void a(int i2) {
        this.numberOfLoadedAd = i2;
    }
}
