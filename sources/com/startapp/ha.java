package com.startapp;

import android.app.Activity;
import com.startapp.sdk.adsbase.model.AdPreferences;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ha {

    /* renamed from: a  reason: collision with root package name */
    public final Map<a, String> f34636a = new ConcurrentHashMap();

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final AdPreferences.Placement f34637a;

        /* renamed from: b  reason: collision with root package name */
        public final int f34638b;

        public a(AdPreferences.Placement placement, int i2) {
            this.f34637a = placement;
            this.f34638b = i2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f34638b == aVar.f34638b && this.f34637a == aVar.f34637a) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            Object[] objArr = {this.f34637a, Integer.valueOf(this.f34638b)};
            Map<Activity, Integer> map = lb.f34876a;
            return Arrays.deepHashCode(objArr);
        }
    }
}
