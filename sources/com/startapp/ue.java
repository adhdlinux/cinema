package com.startapp;

import android.app.Activity;
import java.util.Arrays;
import java.util.Map;

public class ue extends ze {

    /* renamed from: a  reason: collision with root package name */
    public final int f36686a;

    public ue(int i2) {
        this.f36686a = i2;
    }

    public boolean a(Object obj) {
        if (!(obj instanceof q6)) {
            return false;
        }
        int i2 = ((q6) obj).f35650a0;
        if ((this.f36686a & i2) == i2) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && ue.class == obj.getClass() && this.f36686a == ((ue) obj).f36686a) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        Object[] objArr = {Integer.valueOf(this.f36686a)};
        Map<Activity, Integer> map = lb.f34876a;
        return Arrays.deepHashCode(objArr);
    }
}
