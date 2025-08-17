package com.startapp.sdk.adsbase.cache;

import android.app.Activity;
import com.startapp.lb;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.model.AdPreferences;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

public class CacheKey implements Serializable {
    private static final long serialVersionUID = -5317700110100638162L;
    private String adTag;
    private String advertiserId;
    private Set<String> categories;
    private Set<String> categoriesExclude;
    private String country;
    private boolean forceFullpage;
    private boolean forceOfferWall2D;
    private boolean forceOfferWall3D;
    private boolean forceOverlay;
    private Double minCpm;
    private AdPreferences.Placement placement;
    private String productId;
    private String template;
    private boolean testMode;
    private Ad.AdType type;
    private boolean videoMuted;

    public CacheKey(AdPreferences.Placement placement2, AdPreferences adPreferences) {
        this.placement = placement2;
        this.categories = adPreferences.getCategories();
        this.categoriesExclude = adPreferences.getCategoriesExclude();
        this.videoMuted = adPreferences.isVideoMuted();
        this.minCpm = adPreferences.getMinCpm();
        this.forceOfferWall3D = adPreferences.isForceOfferWall3D();
        this.forceOfferWall2D = adPreferences.isForceOfferWall2D();
        this.forceFullpage = adPreferences.isForceFullpage();
        this.forceOverlay = adPreferences.isForceOverlay();
        this.testMode = adPreferences.isTestMode();
        this.adTag = adPreferences.getAdTag();
        this.productId = adPreferences.getCustomProductId();
        this.country = adPreferences.getCountry();
        this.advertiserId = adPreferences.getAdvertiserId();
        this.template = adPreferences.getTemplate();
        this.type = adPreferences.getType();
    }

    public AdPreferences.Placement a() {
        return this.placement;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || CacheKey.class != obj.getClass()) {
            return false;
        }
        CacheKey cacheKey = (CacheKey) obj;
        if (this.forceOfferWall3D != cacheKey.forceOfferWall3D || this.forceOfferWall2D != cacheKey.forceOfferWall2D || this.forceFullpage != cacheKey.forceFullpage || this.forceOverlay != cacheKey.forceOverlay || this.testMode != cacheKey.testMode || this.videoMuted != cacheKey.videoMuted || this.placement != cacheKey.placement || !lb.a(this.categories, cacheKey.categories) || !lb.a(this.categoriesExclude, cacheKey.categoriesExclude) || !lb.a(this.minCpm, cacheKey.minCpm) || !lb.a(this.adTag, cacheKey.adTag) || !lb.a(this.productId, cacheKey.productId) || !lb.a(this.country, cacheKey.country) || !lb.a(this.advertiserId, cacheKey.advertiserId) || !lb.a(this.template, cacheKey.template) || this.type != cacheKey.type) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        Object[] objArr = {this.placement, this.categories, this.categoriesExclude, this.minCpm, Boolean.valueOf(this.forceOfferWall3D), Boolean.valueOf(this.forceOfferWall2D), Boolean.valueOf(this.forceFullpage), Boolean.valueOf(this.forceOverlay), Boolean.valueOf(this.testMode), Boolean.valueOf(this.videoMuted), this.adTag, this.productId, this.country, this.advertiserId, this.template, this.type};
        Map<Activity, Integer> map = lb.f34876a;
        return Arrays.deepHashCode(objArr);
    }

    public String toString() {
        return "CacheKey [placement=" + this.placement + ", categories=" + this.categories + ", categoriesExclude=" + this.categoriesExclude + ", forceOfferWall3D=" + this.forceOfferWall3D + ", forceOfferWall2D=" + this.forceOfferWall2D + ", forceFullpage=" + this.forceFullpage + ", forceOverlay=" + this.forceOverlay + ", testMode=" + this.testMode + ", minCpm=" + this.minCpm + ", country=" + this.country + ", advertiserId=" + this.advertiserId + ", template=" + this.template + ", type=" + this.type + ", adTag=" + this.adTag + ", productId=" + this.productId + ", videoMuted=" + this.videoMuted + "]";
    }
}
