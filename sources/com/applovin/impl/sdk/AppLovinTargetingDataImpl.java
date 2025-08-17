package com.applovin.impl.sdk;

import android.text.TextUtils;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinAdContentRating;
import com.applovin.sdk.AppLovinGender;
import com.applovin.sdk.AppLovinTargetingData;
import com.google.android.gms.common.Scopes;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppLovinTargetingDataImpl implements AppLovinTargetingData {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, String> f14973a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final Object f14974b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private Integer f14975c = null;

    /* renamed from: d  reason: collision with root package name */
    private AppLovinGender f14976d = null;

    /* renamed from: e  reason: collision with root package name */
    private AppLovinAdContentRating f14977e = null;

    /* renamed from: f  reason: collision with root package name */
    private String f14978f = null;

    /* renamed from: g  reason: collision with root package name */
    private String f14979g = null;

    /* renamed from: h  reason: collision with root package name */
    private List<String> f14980h = null;

    /* renamed from: i  reason: collision with root package name */
    private List<String> f14981i = null;

    private void a(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.f14974b) {
                if (StringUtils.isValidString(str2)) {
                    this.f14973a.put(str, str2);
                } else {
                    this.f14973a.remove(str);
                }
            }
        }
    }

    public void clearAll() {
        synchronized (this.f14974b) {
            this.f14973a.clear();
        }
    }

    public Map<String, String> getAllData() {
        HashMap hashMap;
        synchronized (this.f14974b) {
            hashMap = new HashMap(this.f14973a);
        }
        return hashMap;
    }

    public String getEmail() {
        return this.f14978f;
    }

    public AppLovinGender getGender() {
        return this.f14976d;
    }

    public List<String> getInterests() {
        return this.f14981i;
    }

    public List<String> getKeywords() {
        return this.f14980h;
    }

    public AppLovinAdContentRating getMaximumAdContentRating() {
        return this.f14977e;
    }

    public String getPhoneNumber() {
        return this.f14979g;
    }

    public Integer getYearOfBirth() {
        return this.f14975c;
    }

    public void setEmail(String str) {
        a(Scopes.EMAIL, str != null ? StringUtils.toFullSHA1Hash(str.toLowerCase().trim()) : str);
        this.f14978f = str;
    }

    public void setGender(AppLovinGender appLovinGender) {
        String str;
        if (appLovinGender != null) {
            if (appLovinGender == AppLovinGender.FEMALE) {
                str = "F";
            } else if (appLovinGender == AppLovinGender.MALE) {
                str = "M";
            } else if (appLovinGender == AppLovinGender.OTHER) {
                str = "O";
            }
            a("gender", str);
            this.f14976d = appLovinGender;
        }
        str = null;
        a("gender", str);
        this.f14976d = appLovinGender;
    }

    public void setInterests(List<String> list) {
        a("interests", list == null ? null : CollectionUtils.implode(list, list.size()));
        this.f14981i = list;
    }

    public void setKeywords(List<String> list) {
        a("keywords", list == null ? null : CollectionUtils.implode(list, list.size()));
        this.f14980h = list;
    }

    public void setMaximumAdContentRating(AppLovinAdContentRating appLovinAdContentRating) {
        a("maximum_ad_content_rating", (appLovinAdContentRating == null || appLovinAdContentRating == AppLovinAdContentRating.NONE) ? null : Integer.toString(appLovinAdContentRating.ordinal()));
        this.f14977e = appLovinAdContentRating;
    }

    public void setPhoneNumber(String str) {
        a("phone_number", str != null ? StringUtils.toFullSHA1Hash(str.replaceAll("[^0-9]", "")) : str);
        this.f14979g = str;
    }

    public void setYearOfBirth(Integer num) {
        a("year_of_birth", num == null ? null : Integer.toString(num.intValue()));
        this.f14975c = num;
    }
}
