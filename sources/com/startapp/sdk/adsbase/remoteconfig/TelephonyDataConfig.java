package com.startapp.sdk.adsbase.remoteconfig;

import android.app.Activity;
import com.startapp.j0;
import com.startapp.lb;
import com.startapp.z8;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class TelephonyDataConfig implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public static final TelephonyDataConfig f36415a = new TelephonyDataConfig();
    private static final long serialVersionUID = -7175662234963204913L;
    @j0(type = ArrayList.class)
    private List<String> categories = Collections.singletonList(z8.f37002i.a());
    private boolean enabled = true;
    private String param;

    public List<String> a() {
        return this.categories;
    }

    public String b() {
        return this.param;
    }

    public boolean c() {
        return this.enabled;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TelephonyDataConfig.class != obj.getClass()) {
            return false;
        }
        TelephonyDataConfig telephonyDataConfig = (TelephonyDataConfig) obj;
        if (this.enabled != telephonyDataConfig.enabled || !lb.a(this.categories, telephonyDataConfig.categories) || !lb.a(this.param, telephonyDataConfig.param)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        Object[] objArr = {Boolean.valueOf(this.enabled), this.categories, this.param};
        Map<Activity, Integer> map = lb.f34876a;
        return Arrays.deepHashCode(objArr);
    }
}
