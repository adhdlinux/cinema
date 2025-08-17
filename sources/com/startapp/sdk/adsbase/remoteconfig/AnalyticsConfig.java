package com.startapp.sdk.adsbase.remoteconfig;

import android.app.Activity;
import com.startapp.j0;
import com.startapp.lb;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class AnalyticsConfig implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public static final String f36371a = "https://infoevent.startappservice.com/tracking/infoEvent";
    private static final long serialVersionUID = 751871501407968688L;
    @j0(type = ArrayList.class)
    private List<String> admHeaders = Collections.singletonList("Server-Timing");
    private double admPrb = 0.0d;
    @j0(type = HashMap.class, value = AnalyticsCategoryConfig.class)
    private Map<String, AnalyticsCategoryConfig> categories;
    public boolean dns = false;
    private int fuIef;
    public String hostPeriodic;
    public String hostSecured;
    private String noNetworkTimeout;
    private int retryNum = 3;
    private int retryTime = 10;
    private boolean sendHopsOnFirstSucceededSmartRedirect = false;
    private boolean sendViewabilityInfo = false;
    private float succeededSmartRedirectInfoProbability = 0.01f;

    public AnalyticsConfig() {
        String str = f36371a;
        this.hostSecured = str;
        this.hostPeriodic = str;
    }

    public List<String> a() {
        return this.admHeaders;
    }

    public double b() {
        return this.admPrb;
    }

    public Map<String, AnalyticsCategoryConfig> c() {
        return this.categories;
    }

    public int d() {
        return this.fuIef;
    }

    public String e() {
        return this.noNetworkTimeout;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AnalyticsConfig.class != obj.getClass()) {
            return false;
        }
        AnalyticsConfig analyticsConfig = (AnalyticsConfig) obj;
        if (this.dns == analyticsConfig.dns && this.retryNum == analyticsConfig.retryNum && this.retryTime == analyticsConfig.retryTime && Float.compare(this.succeededSmartRedirectInfoProbability, analyticsConfig.succeededSmartRedirectInfoProbability) == 0 && this.sendHopsOnFirstSucceededSmartRedirect == analyticsConfig.sendHopsOnFirstSucceededSmartRedirect && this.sendViewabilityInfo == analyticsConfig.sendViewabilityInfo && Double.compare(this.admPrb, analyticsConfig.admPrb) == 0 && this.fuIef == analyticsConfig.fuIef && lb.a(this.hostSecured, analyticsConfig.hostSecured) && lb.a(this.hostPeriodic, analyticsConfig.hostPeriodic) && lb.a(this.noNetworkTimeout, analyticsConfig.noNetworkTimeout) && lb.a(this.categories, analyticsConfig.categories) && lb.a(this.admHeaders, analyticsConfig.admHeaders)) {
            return true;
        }
        return false;
    }

    public int f() {
        return this.retryNum;
    }

    public long g() {
        return TimeUnit.SECONDS.toMillis((long) this.retryTime);
    }

    public float h() {
        return this.succeededSmartRedirectInfoProbability;
    }

    public int hashCode() {
        Object[] objArr = {this.hostSecured, this.hostPeriodic, Boolean.valueOf(this.dns), Integer.valueOf(this.retryNum), Integer.valueOf(this.retryTime), Float.valueOf(this.succeededSmartRedirectInfoProbability), Boolean.valueOf(this.sendHopsOnFirstSucceededSmartRedirect), this.noNetworkTimeout, this.categories, Boolean.valueOf(this.sendViewabilityInfo), Double.valueOf(this.admPrb), this.admHeaders, Integer.valueOf(this.fuIef)};
        Map<Activity, Integer> map = lb.f34876a;
        return Arrays.deepHashCode(objArr);
    }

    public boolean i() {
        return this.sendHopsOnFirstSucceededSmartRedirect;
    }

    public boolean j() {
        return this.sendViewabilityInfo;
    }
}
