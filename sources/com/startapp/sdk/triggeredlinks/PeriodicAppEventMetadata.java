package com.startapp.sdk.triggeredlinks;

import java.io.Serializable;

public class PeriodicAppEventMetadata implements Serializable {
    private static final long serialVersionUID = -3371103410620683752L;
    private int intervalInSeconds;
    private String url;

    public int a() {
        return this.intervalInSeconds;
    }

    public String b() {
        return this.url;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || PeriodicAppEventMetadata.class != obj.getClass()) {
            return false;
        }
        PeriodicAppEventMetadata periodicAppEventMetadata = (PeriodicAppEventMetadata) obj;
        if (this.intervalInSeconds != periodicAppEventMetadata.intervalInSeconds) {
            return false;
        }
        String str = this.url;
        String str2 = periodicAppEventMetadata.url;
        if (str != null) {
            return str.equals(str2);
        }
        if (str2 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i2;
        String str = this.url;
        if (str != null) {
            i2 = str.hashCode();
        } else {
            i2 = 0;
        }
        return (i2 * 31) + this.intervalInSeconds;
    }

    public String toString() {
        return super.toString();
    }
}
