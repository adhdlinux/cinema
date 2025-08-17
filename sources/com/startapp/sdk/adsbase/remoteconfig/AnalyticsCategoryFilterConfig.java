package com.startapp.sdk.adsbase.remoteconfig;

import android.app.Activity;
import com.startapp.j0;
import com.startapp.lb;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class AnalyticsCategoryFilterConfig implements Serializable {
    private static final long serialVersionUID = -706642555040875333L;
    @j0(type = ArrayList.class)
    private List<String> excludeAppActivity;
    @j0(type = ArrayList.class)
    private List<String> excludeValues;
    @j0(type = ArrayList.class)
    private List<String> fields;
    @j0(type = ArrayList.class)
    private List<String> includeAppActivity;
    @j0(type = ArrayList.class)
    private List<String> includeValues;
    private String interval;

    public List<String> a() {
        return this.excludeAppActivity;
    }

    public List<String> b() {
        return this.excludeValues;
    }

    public List<String> c() {
        return this.fields;
    }

    public List<String> d() {
        return this.includeAppActivity;
    }

    public List<String> e() {
        return this.includeValues;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AnalyticsCategoryFilterConfig.class != obj.getClass()) {
            return false;
        }
        AnalyticsCategoryFilterConfig analyticsCategoryFilterConfig = (AnalyticsCategoryFilterConfig) obj;
        if (!lb.a(this.includeValues, analyticsCategoryFilterConfig.includeValues) || !lb.a(this.excludeValues, analyticsCategoryFilterConfig.excludeValues) || !lb.a(this.includeAppActivity, analyticsCategoryFilterConfig.includeAppActivity) || !lb.a(this.excludeAppActivity, analyticsCategoryFilterConfig.excludeAppActivity) || !lb.a(this.fields, analyticsCategoryFilterConfig.fields) || !lb.a(this.interval, analyticsCategoryFilterConfig.interval)) {
            return false;
        }
        return true;
    }

    public String f() {
        return this.interval;
    }

    public int hashCode() {
        Object[] objArr = {this.includeValues, this.excludeValues, this.includeAppActivity, this.excludeAppActivity, this.fields, this.interval};
        Map<Activity, Integer> map = lb.f34876a;
        return Arrays.deepHashCode(objArr);
    }
}
