package com.startapp.sdk.adsbase.cache;

import java.io.Serializable;

public class CachedVideoAd implements Serializable {
    private static final long serialVersionUID = 1;
    private String filename;
    private long lastUseTimestamp;
    private String videoLocation;

    public CachedVideoAd(String str) {
        this.filename = str;
    }

    public String a() {
        return this.videoLocation;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || CachedVideoAd.class != obj.getClass()) {
            return false;
        }
        CachedVideoAd cachedVideoAd = (CachedVideoAd) obj;
        String str = this.filename;
        if (str == null) {
            if (cachedVideoAd.filename != null) {
                return false;
            }
        } else if (!str.equals(cachedVideoAd.filename)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i2;
        String str = this.filename;
        if (str == null) {
            i2 = 0;
        } else {
            i2 = str.hashCode();
        }
        return i2 + 31;
    }

    public void a(String str) {
        this.videoLocation = str;
    }

    public void a(long j2) {
        this.lastUseTimestamp = j2;
    }
}
