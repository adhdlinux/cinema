package com.original.tase.model;

import java.util.HashMap;
import java.util.Map;

public class ResolveResult {
    private boolean alldebrid;
    private boolean debrid;
    private long filesize;
    private HashMap<String, String> playHeader;
    private boolean premiumize;
    private boolean realdebrid;
    private String resolvedLink;
    private String resolvedQuality;
    private String resolverFileName;
    private String resolverName;

    public ResolveResult(String str, String str2, String str3) {
        this.resolverName = str;
        this.resolvedLink = str2;
        this.resolvedQuality = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ResolveResult resolveResult = (ResolveResult) obj;
        if (isDebrid() != resolveResult.isDebrid()) {
            return false;
        }
        String str = this.resolverName;
        if (str != null) {
            if (!str.equals(resolveResult.resolverName)) {
                return false;
            }
        } else if (resolveResult.resolverName != null) {
            return false;
        }
        String str2 = this.resolvedLink;
        if (str2 != null) {
            if (!str2.equals(resolveResult.resolvedLink)) {
                return false;
            }
        } else if (resolveResult.resolvedLink != null) {
            return false;
        }
        String str3 = this.resolvedQuality;
        if (str3 != null) {
            if (!str3.equals(resolveResult.resolvedQuality)) {
                return false;
            }
        } else if (resolveResult.resolvedQuality != null) {
            return false;
        }
        HashMap<String, String> hashMap = this.playHeader;
        if (hashMap != null) {
            return hashMap.equals(resolveResult.playHeader);
        }
        if (resolveResult.playHeader != null) {
            return false;
        }
        return true;
    }

    public long getFilesize() {
        return this.filesize;
    }

    public HashMap<String, String> getPlayHeader() {
        return this.playHeader;
    }

    public String getResolvedLink() {
        return this.resolvedLink;
    }

    public String getResolvedQuality() {
        return this.resolvedQuality;
    }

    public String getResolverFileName() {
        return this.resolverFileName;
    }

    public String getResolverName() {
        return this.resolverName;
    }

    public int hashCode() {
        int i2;
        int i3;
        int i4;
        String str = this.resolverName;
        int i5 = 0;
        if (str != null) {
            i2 = str.hashCode();
        } else {
            i2 = 0;
        }
        int i6 = i2 * 31;
        String str2 = this.resolvedLink;
        if (str2 != null) {
            i3 = str2.hashCode();
        } else {
            i3 = 0;
        }
        int i7 = (i3 + i6) * 31;
        String str3 = this.resolvedQuality;
        if (str3 != null) {
            i4 = str3.hashCode();
        } else {
            i4 = 0;
        }
        int i8 = (i4 + i7) * 31;
        HashMap<String, String> hashMap = this.playHeader;
        if (hashMap != null) {
            i5 = hashMap.hashCode();
        }
        return ((i5 + i8) * 31) + (isDebrid() ? 1 : 0);
    }

    public boolean isAlldebrid() {
        return this.alldebrid;
    }

    public boolean isDebrid() {
        boolean z2 = this.alldebrid || this.realdebrid || this.premiumize;
        this.debrid = z2;
        return z2;
    }

    public boolean isPremiumize() {
        return this.premiumize;
    }

    public boolean isRealdebrid() {
        return this.realdebrid;
    }

    public void setAlldebrid(boolean z2) {
        this.alldebrid = z2;
    }

    public void setFilesize(long j2) {
        this.filesize = j2;
    }

    public void setPlayHeader(HashMap<String, String> hashMap) {
        if (this.playHeader == null) {
            this.playHeader = hashMap;
            return;
        }
        for (Map.Entry next : hashMap.entrySet()) {
            if (!this.playHeader.entrySet().contains(next)) {
                this.playHeader.put((String) next.getKey(), (String) next.getValue());
            }
        }
    }

    public void setPremiumize(boolean z2) {
        this.premiumize = z2;
    }

    public void setRealdebrid(boolean z2) {
        this.realdebrid = z2;
    }

    public ResolveResult setResolvedLink(String str) {
        this.resolvedLink = str;
        return this;
    }

    public void setResolvedQuality(String str) {
        this.resolvedQuality = str;
    }

    public void setResolverFileName(String str) {
        this.resolverFileName = str;
    }

    public ResolveResult setResolverName(String str) {
        this.resolverName = str;
        return this;
    }

    public String toString() {
        return "ResolveResult{resolverName='" + this.resolverName + '\'' + ", resolvedLink='" + this.resolvedLink + '\'' + ", resolvedQuality='" + this.resolvedQuality + '\'' + ", playHeader=" + this.playHeader + ", debrid=" + this.debrid + '}';
    }

    public ResolveResult(String str, String str2, int i2) {
        this(str, str2, String.valueOf(i2));
    }
}
