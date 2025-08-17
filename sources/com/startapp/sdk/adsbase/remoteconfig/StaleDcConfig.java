package com.startapp.sdk.adsbase.remoteconfig;

import android.app.Activity;
import com.startapp.lb;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Map;

public class StaleDcConfig implements Serializable {
    private int ief = 0;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && StaleDcConfig.class == obj.getClass() && this.ief == ((StaleDcConfig) obj).ief) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        Object[] objArr = {Integer.valueOf(this.ief)};
        Map<Activity, Integer> map = lb.f34876a;
        return Arrays.deepHashCode(objArr);
    }
}
