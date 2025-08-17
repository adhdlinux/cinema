package com.startapp.sdk.adsbase.model;

import android.app.Activity;
import android.content.Context;
import com.startapp.lb;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.SDKAdPreferences;
import com.startapp.sdk.adsbase.StartAppSDKInternal;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AdPreferences implements Serializable {
    public static final String TYPE_APP_WALL = "APP_WALL";
    public static final String TYPE_BANNER = "BANNER";
    public static final String TYPE_INAPP_EXIT = "INAPP_EXIT";
    public static final String TYPE_SCRINGO_TOOLBAR = "SCRINGO_TOOLBAR";
    public static final String TYPE_TEXT = "TEXT";
    private static final long serialVersionUID = 6348347121407735103L;
    private String adTag = null;
    public String advertiserId = null;
    private String age = null;
    private Boolean ai = null;
    private Boolean as = null;
    private Integer autoLoadAmount;
    private Set<String> categories = null;
    private Set<String> categoriesExclude = null;
    public String country = null;
    public boolean forceFullpage = false;
    public boolean forceOfferWall2D = false;
    public boolean forceOfferWall3D = false;
    public boolean forceOverlay = false;
    private SDKAdPreferences.Gender gender = null;
    private boolean hardwareAccelerated = StartAppSDKInternal.a().d();
    private String keywords = null;
    private Double latitude = null;
    private Double longitude = null;
    public Double minCpm = null;
    public Set<String> packageInclude = null;
    private String productId;
    public String template = null;
    private boolean testMode = false;
    public Ad.AdType type = null;
    private boolean videoMuted = false;

    public enum Placement {
        INAPP_FULL_SCREEN(1),
        INAPP_BANNER(2),
        INAPP_OFFER_WALL(3),
        INAPP_SPLASH(4),
        INAPP_OVERLAY(5),
        INAPP_NATIVE(6),
        DEVICE_SIDEBAR(7),
        INAPP_RETURN(8),
        INAPP_BROWSER(9);
        
        private int index;

        /* access modifiers changed from: public */
        Placement(int i2) {
            this.index = i2;
        }

        public int a() {
            return this.index;
        }

        public static Placement a(int i2) {
            Placement placement = INAPP_FULL_SCREEN;
            Placement[] values = values();
            for (int i3 = 0; i3 < 9; i3++) {
                Placement placement2 = values[i3];
                if (placement2.index == i2) {
                    return placement2;
                }
            }
            return placement;
        }
    }

    public AdPreferences() {
    }

    public Integer a() {
        return this.autoLoadAmount;
    }

    public AdPreferences addCategory(String str) {
        if (this.categories == null) {
            this.categories = new HashSet();
        }
        this.categories.add(str);
        return this;
    }

    public AdPreferences addCategoryExclude(String str) {
        if (this.categoriesExclude == null) {
            this.categoriesExclude = new HashSet();
        }
        this.categoriesExclude.add(str);
        return this;
    }

    public boolean b() {
        return this.hardwareAccelerated;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AdPreferences adPreferences = (AdPreferences) obj;
        if (this.forceOfferWall3D != adPreferences.forceOfferWall3D || this.forceOfferWall2D != adPreferences.forceOfferWall2D || this.forceFullpage != adPreferences.forceFullpage || this.forceOverlay != adPreferences.forceOverlay || this.testMode != adPreferences.testMode || this.videoMuted != adPreferences.videoMuted || this.hardwareAccelerated != adPreferences.hardwareAccelerated || !lb.a(this.autoLoadAmount, adPreferences.autoLoadAmount) || !lb.a(this.country, adPreferences.country) || !lb.a(this.advertiserId, adPreferences.advertiserId) || !lb.a(this.template, adPreferences.template) || this.type != adPreferences.type || !lb.a(this.packageInclude, adPreferences.packageInclude) || !lb.a(this.minCpm, adPreferences.minCpm) || !lb.a(this.longitude, adPreferences.longitude) || !lb.a(this.latitude, adPreferences.latitude) || !lb.a(this.keywords, adPreferences.keywords) || this.gender != adPreferences.gender || !lb.a(this.age, adPreferences.age) || !lb.a(this.ai, adPreferences.ai) || !lb.a(this.as, adPreferences.as) || !lb.a(this.adTag, adPreferences.adTag) || !lb.a(this.productId, adPreferences.productId) || !lb.a(this.categories, adPreferences.categories) || !lb.a(this.categoriesExclude, adPreferences.categoriesExclude)) {
            return false;
        }
        return true;
    }

    public String getAdTag() {
        return this.adTag;
    }

    public String getAdvertiserId() {
        return this.advertiserId;
    }

    public String getAge(Context context) {
        String str = this.age;
        if (str != null) {
            return str;
        }
        String str2 = StartAppSDKInternal.f36218a;
        return StartAppSDKInternal.c.f36252a.c(context).getAge();
    }

    public Boolean getAi() {
        return this.ai;
    }

    public Boolean getAs() {
        return this.as;
    }

    public Set<String> getCategories() {
        return this.categories;
    }

    public Set<String> getCategoriesExclude() {
        return this.categoriesExclude;
    }

    public String getCountry() {
        return this.country;
    }

    public String getCustomProductId() {
        return this.productId;
    }

    public SDKAdPreferences.Gender getGender(Context context) {
        SDKAdPreferences.Gender gender2 = this.gender;
        if (gender2 != null) {
            return gender2;
        }
        String str = StartAppSDKInternal.f36218a;
        return StartAppSDKInternal.c.f36252a.c(context).getGender();
    }

    public String getKeywords() {
        return this.keywords;
    }

    public Double getLatitude() {
        return this.latitude;
    }

    public Double getLongitude() {
        return this.longitude;
    }

    public Double getMinCpm() {
        return this.minCpm;
    }

    public String getTemplate() {
        return this.template;
    }

    public Ad.AdType getType() {
        return this.type;
    }

    public int hashCode() {
        Object[] objArr = {this.country, this.advertiserId, this.template, this.type, this.packageInclude, Boolean.valueOf(this.forceOfferWall3D), Boolean.valueOf(this.forceOfferWall2D), Boolean.valueOf(this.forceFullpage), Boolean.valueOf(this.forceOverlay), this.minCpm, Boolean.valueOf(this.testMode), this.longitude, this.latitude, this.keywords, this.gender, this.age, this.ai, this.as, Boolean.valueOf(this.videoMuted), this.adTag, this.productId, Boolean.valueOf(this.hardwareAccelerated), this.autoLoadAmount, this.categories, this.categoriesExclude};
        Map<Activity, Integer> map = lb.f34876a;
        return Arrays.deepHashCode(objArr);
    }

    public boolean isForceFullpage() {
        return this.forceFullpage;
    }

    public boolean isForceOfferWall2D() {
        return this.forceOfferWall2D;
    }

    public boolean isForceOfferWall3D() {
        return this.forceOfferWall3D;
    }

    public boolean isForceOverlay() {
        return this.forceOverlay;
    }

    public boolean isSimpleToken() {
        return true;
    }

    public boolean isTestMode() {
        return this.testMode;
    }

    public boolean isVideoMuted() {
        return this.videoMuted;
    }

    public AdPreferences muteVideo() {
        this.videoMuted = true;
        return this;
    }

    public AdPreferences setAdTag(String str) {
        this.adTag = str;
        return this;
    }

    public AdPreferences setAge(Integer num) {
        this.age = Integer.toString(num.intValue());
        return this;
    }

    public AdPreferences setAi(Boolean bool) {
        this.ai = bool;
        return this;
    }

    public AdPreferences setAs(Boolean bool) {
        this.as = bool;
        return this;
    }

    public void setAutoLoadAmount(int i2) {
        if (i2 > 0) {
            this.autoLoadAmount = Integer.valueOf(i2);
        }
    }

    public AdPreferences setCustomProductId(String str) {
        this.productId = str;
        return this;
    }

    public AdPreferences setGender(SDKAdPreferences.Gender gender2) {
        this.gender = gender2;
        return this;
    }

    public void setHardwareAccelerated(boolean z2) {
        this.hardwareAccelerated = z2;
    }

    public AdPreferences setKeywords(String str) {
        this.keywords = str;
        return this;
    }

    public AdPreferences setLatitude(double d2) {
        this.latitude = Double.valueOf(d2);
        return this;
    }

    public AdPreferences setLongitude(double d2) {
        this.longitude = Double.valueOf(d2);
        return this;
    }

    public void setMinCpm(Double d2) {
        this.minCpm = d2;
    }

    public AdPreferences setTestMode(boolean z2) {
        this.testMode = z2;
        return this;
    }

    public void setType(Ad.AdType adType) {
        this.type = adType;
    }

    public String toString() {
        return super.toString();
    }

    public AdPreferences setAge(String str) {
        this.age = str;
        return this;
    }

    public AdPreferences(AdPreferences adPreferences) {
        this.country = adPreferences.country;
        this.advertiserId = adPreferences.advertiserId;
        this.template = adPreferences.template;
        this.type = adPreferences.type;
        if (adPreferences.packageInclude != null) {
            this.packageInclude = new HashSet(adPreferences.packageInclude);
        }
        this.minCpm = adPreferences.minCpm;
        this.forceOfferWall3D = adPreferences.forceOfferWall3D;
        this.forceOfferWall2D = adPreferences.forceOfferWall2D;
        this.forceFullpage = adPreferences.forceFullpage;
        this.forceOverlay = adPreferences.forceOverlay;
        this.testMode = adPreferences.testMode;
        this.longitude = adPreferences.longitude;
        this.latitude = adPreferences.latitude;
        this.keywords = adPreferences.keywords;
        this.gender = adPreferences.gender;
        this.age = adPreferences.age;
        this.ai = adPreferences.ai;
        this.as = adPreferences.as;
        this.videoMuted = adPreferences.videoMuted;
        this.adTag = adPreferences.adTag;
        this.hardwareAccelerated = adPreferences.hardwareAccelerated;
        this.autoLoadAmount = adPreferences.autoLoadAmount;
        this.productId = adPreferences.productId;
        if (adPreferences.categories != null) {
            this.categories = new HashSet(adPreferences.categories);
        }
        if (adPreferences.categoriesExclude != null) {
            this.categoriesExclude = new HashSet(adPreferences.categoriesExclude);
        }
    }
}
