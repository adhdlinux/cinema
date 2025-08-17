package com.startapp.sdk.adsbase.consent;

import android.app.Activity;
import com.startapp.lb;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Map;

public final class ConsentTypeInfoConfig implements Serializable {
    private static final long serialVersionUID = 1;
    private Integer falseClick;
    private Integer impression;
    private Integer trueClick;

    public Integer a() {
        return this.falseClick;
    }

    public Integer b() {
        return this.impression;
    }

    public Integer c() {
        return this.trueClick;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ConsentTypeInfoConfig.class != obj.getClass()) {
            return false;
        }
        ConsentTypeInfoConfig consentTypeInfoConfig = (ConsentTypeInfoConfig) obj;
        if (!lb.a(this.impression, consentTypeInfoConfig.impression) || !lb.a(this.trueClick, consentTypeInfoConfig.trueClick) || !lb.a(this.falseClick, consentTypeInfoConfig.falseClick)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        Object[] objArr = {this.impression, this.trueClick, this.falseClick};
        Map<Activity, Integer> map = lb.f34876a;
        return Arrays.deepHashCode(objArr);
    }
}
