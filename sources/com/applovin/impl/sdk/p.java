package com.applovin.impl.sdk;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class p {

    /* renamed from: a  reason: collision with root package name */
    private final String f15749a = UUID.randomUUID().toString();

    /* renamed from: b  reason: collision with root package name */
    private final String f15750b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, Object> f15751c;

    /* renamed from: d  reason: collision with root package name */
    private final long f15752d;

    public p(String str, Map<String, String> map, Map<String, Object> map2) {
        this.f15750b = str;
        HashMap hashMap = new HashMap();
        this.f15751c = hashMap;
        hashMap.putAll(map);
        hashMap.put("applovin_sdk_super_properties", map2);
        this.f15752d = System.currentTimeMillis();
    }

    public String a() {
        return this.f15750b;
    }

    public Map<String, Object> b() {
        return this.f15751c;
    }

    public long c() {
        return this.f15752d;
    }

    public String d() {
        return this.f15749a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        p pVar = (p) obj;
        if (this.f15752d != pVar.f15752d) {
            return false;
        }
        String str = this.f15750b;
        if (str == null ? pVar.f15750b != null : !str.equals(pVar.f15750b)) {
            return false;
        }
        Map<String, Object> map = this.f15751c;
        if (map == null ? pVar.f15751c != null : !map.equals(pVar.f15751c)) {
            return false;
        }
        String str2 = this.f15749a;
        String str3 = pVar.f15749a;
        if (str2 != null) {
            return str2.equals(str3);
        }
        if (str3 == null) {
            return true;
        }
    }

    public int hashCode() {
        String str = this.f15750b;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Map<String, Object> map = this.f15751c;
        int hashCode2 = map != null ? map.hashCode() : 0;
        long j2 = this.f15752d;
        int i3 = (((hashCode + hashCode2) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        String str2 = this.f15749a;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return i3 + i2;
    }

    public String toString() {
        return "Event{name='" + this.f15750b + '\'' + ", id='" + this.f15749a + '\'' + ", creationTimestampMillis=" + this.f15752d + ", parameters=" + this.f15751c + '}';
    }
}
