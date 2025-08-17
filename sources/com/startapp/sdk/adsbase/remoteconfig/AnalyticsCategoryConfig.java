package com.startapp.sdk.adsbase.remoteconfig;

import android.app.Activity;
import androidx.annotation.Keep;
import com.startapp.j0;
import com.startapp.jb;
import com.startapp.lb;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class AnalyticsCategoryConfig implements Serializable {
    private static final long serialVersionUID = 5410570404581113345L;
    private Double enabled;
    @j0(parser = FiltersParser.class, type = ArrayList.class, value = AnalyticsCategoryFilterConfig.class)
    private List<AnalyticsCategoryFilterConfig> filters;
    private String firstDelay;
    private Integer flags;
    private Integer priority;
    private Boolean sendViaDb;
    private String ttl;

    @Keep
    public static class FiltersParser extends jb<AnalyticsCategoryFilterConfig> {
        public FiltersParser() {
            super(AnalyticsCategoryFilterConfig.class);
        }
    }

    public Double a() {
        return this.enabled;
    }

    public List<AnalyticsCategoryFilterConfig> b() {
        return this.filters;
    }

    public String c() {
        return this.firstDelay;
    }

    public Integer d() {
        return this.flags;
    }

    public Integer e() {
        return this.priority;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AnalyticsCategoryConfig.class != obj.getClass()) {
            return false;
        }
        AnalyticsCategoryConfig analyticsCategoryConfig = (AnalyticsCategoryConfig) obj;
        if (!lb.a(this.enabled, analyticsCategoryConfig.enabled) || !lb.a(this.flags, analyticsCategoryConfig.flags) || !lb.a(this.priority, analyticsCategoryConfig.priority) || !lb.a(this.sendViaDb, analyticsCategoryConfig.sendViaDb) || !lb.a(this.ttl, analyticsCategoryConfig.ttl) || !lb.a(this.firstDelay, analyticsCategoryConfig.firstDelay) || !lb.a(this.filters, analyticsCategoryConfig.filters)) {
            return false;
        }
        return true;
    }

    public Boolean f() {
        return this.sendViaDb;
    }

    public String g() {
        return this.ttl;
    }

    public int hashCode() {
        Object[] objArr = {this.enabled, this.flags, this.priority, this.sendViaDb, this.ttl, this.firstDelay, this.filters};
        Map<Activity, Integer> map = lb.f34876a;
        return Arrays.deepHashCode(objArr);
    }
}
