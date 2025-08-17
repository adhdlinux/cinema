package com.startapp.sdk.adsbase.remoteconfig;

import android.app.Activity;
import com.startapp.j0;
import com.startapp.lb;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TelephonyMetadata implements Serializable {
    private static final long serialVersionUID = -644112324647697192L;
    @j0(type = HashMap.class, value = TelephonyDataConfig.class)
    private Map<String, TelephonyDataConfig> data;
    private boolean enabled = true;
    private int ief = 0;
    private double iep = 0.0d;
    private boolean rciu;

    public int a() {
        return this.ief;
    }

    public double b() {
        return this.iep;
    }

    public boolean c() {
        return this.enabled;
    }

    public boolean d() {
        return this.rciu;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TelephonyMetadata.class != obj.getClass()) {
            return false;
        }
        TelephonyMetadata telephonyMetadata = (TelephonyMetadata) obj;
        if (this.enabled == telephonyMetadata.enabled && this.ief == telephonyMetadata.ief && Double.compare(this.iep, telephonyMetadata.iep) == 0 && this.rciu == telephonyMetadata.rciu && lb.a(this.data, telephonyMetadata.data)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        Object[] objArr = {Boolean.valueOf(this.enabled), Integer.valueOf(this.ief), Double.valueOf(this.iep), Boolean.valueOf(this.rciu), this.data};
        Map<Activity, Integer> map = lb.f34876a;
        return Arrays.deepHashCode(objArr);
    }

    public TelephonyDataConfig a(String str) {
        Map<String, TelephonyDataConfig> map = this.data;
        TelephonyDataConfig telephonyDataConfig = map != null ? map.get(str) : null;
        return telephonyDataConfig != null ? telephonyDataConfig : TelephonyDataConfig.f36415a;
    }
}
