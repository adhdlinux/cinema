package com.startapp.sdk.adsbase.adrules;

import android.app.Activity;
import com.startapp.j0;
import com.startapp.lb;
import com.startapp.r7;
import com.startapp.sdk.adsbase.model.AdPreferences;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AdRules implements Serializable {
    private static final long serialVersionUID = 1;

    /* renamed from: a  reason: collision with root package name */
    public transient Set<Class<? extends AdRule>> f36306a = new HashSet();
    private boolean applyOnBannerRefresh = true;
    @j0(innerValue = AdRule.class, key = AdPreferences.Placement.class, type = HashMap.class, value = ArrayList.class)
    private Map<AdPreferences.Placement, List<AdRule>> placements = new HashMap();
    @j0(type = ArrayList.class, value = AdRule.class)
    private List<AdRule> session = new ArrayList();
    @j0(innerValue = AdRule.class, type = HashMap.class, value = ArrayList.class)
    private Map<String, List<AdRule>> tags = new HashMap();

    public boolean a() {
        return this.applyOnBannerRefresh;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AdRules.class != obj.getClass()) {
            return false;
        }
        AdRules adRules = (AdRules) obj;
        if (this.applyOnBannerRefresh != adRules.applyOnBannerRefresh || !lb.a(this.session, adRules.session) || !lb.a(this.placements, adRules.placements) || !lb.a(this.tags, adRules.tags)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        Object[] objArr = {this.session, this.placements, this.tags, Boolean.valueOf(this.applyOnBannerRefresh)};
        Map<Activity, Integer> map = lb.f34876a;
        return Arrays.deepHashCode(objArr);
    }

    public synchronized AdRulesResult a(AdPreferences.Placement placement, String str) {
        AdRulesResult a2;
        this.f36306a.clear();
        a2 = a(this.tags.get(str), r7.f35760a.f35763d.get(str), AdRuleLevel.TAG);
        if (a2.b()) {
            AdRuleLevel adRuleLevel = AdRuleLevel.PLACEMENT;
            placement.toString();
            a2 = a(this.placements.get(placement), r7.f35760a.f35762c.get(placement), adRuleLevel);
            if (a2.b()) {
                a2 = a(this.session, r7.f35760a.f35761b, AdRuleLevel.SESSION);
            }
        }
        return a2;
    }

    public final AdRulesResult a(List list, List list2, AdRuleLevel adRuleLevel) {
        if (list == null) {
            return new AdRulesResult(true, "");
        }
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            AdRule adRule = (AdRule) it2.next();
            if (adRule.f36301a || !this.f36306a.contains(adRule.getClass())) {
                if (!adRule.a(list2)) {
                    return new AdRulesResult(false, adRule.getClass().getSimpleName() + "_" + adRuleLevel + "");
                }
                this.f36306a.add(adRule.getClass());
            }
        }
        return new AdRulesResult(true, "");
    }
}
