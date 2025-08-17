package com.startapp.sdk.triggeredlinks;

import com.startapp.j0;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class AppEventsMetadata implements Serializable {
    private static final long serialVersionUID = -5670027899854165615L;
    @j0(type = HashMap.class)
    private Map<String, String> active;
    @j0(type = HashMap.class)
    private Map<String, String> inactive;
    @j0(type = HashMap.class)
    private Map<String, String> launch;
    @j0(type = HashMap.class, value = PeriodicAppEventMetadata.class)
    private Map<String, PeriodicAppEventMetadata> periodic;

    public Map<String, String> a() {
        return this.active;
    }

    public Map<String, String> b() {
        return this.inactive;
    }

    public Map<String, String> c() {
        return this.launch;
    }

    public Map<String, PeriodicAppEventMetadata> d() {
        return this.periodic;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AppEventsMetadata.class != obj.getClass()) {
            return false;
        }
        AppEventsMetadata appEventsMetadata = (AppEventsMetadata) obj;
        Map<String, String> map = this.launch;
        if (map == null ? appEventsMetadata.launch != null : !map.equals(appEventsMetadata.launch)) {
            return false;
        }
        Map<String, String> map2 = this.active;
        if (map2 == null ? appEventsMetadata.active != null : !map2.equals(appEventsMetadata.active)) {
            return false;
        }
        Map<String, String> map3 = this.inactive;
        if (map3 == null ? appEventsMetadata.inactive != null : !map3.equals(appEventsMetadata.inactive)) {
            return false;
        }
        Map<String, PeriodicAppEventMetadata> map4 = this.periodic;
        Map<String, PeriodicAppEventMetadata> map5 = appEventsMetadata.periodic;
        if (map4 != null) {
            return map4.equals(map5);
        }
        if (map5 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i2;
        int i3;
        int i4;
        Map<String, String> map = this.launch;
        int i5 = 0;
        if (map != null) {
            i2 = map.hashCode();
        } else {
            i2 = 0;
        }
        int i6 = i2 * 31;
        Map<String, String> map2 = this.active;
        if (map2 != null) {
            i3 = map2.hashCode();
        } else {
            i3 = 0;
        }
        int i7 = (i6 + i3) * 31;
        Map<String, String> map3 = this.inactive;
        if (map3 != null) {
            i4 = map3.hashCode();
        } else {
            i4 = 0;
        }
        int i8 = (i7 + i4) * 31;
        Map<String, PeriodicAppEventMetadata> map4 = this.periodic;
        if (map4 != null) {
            i5 = map4.hashCode();
        }
        return i8 + i5;
    }
}
