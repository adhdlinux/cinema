package com.facebook.ads.internal.f;

import java.util.HashMap;
import java.util.Map;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private final String f20147a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, String> f20148b;

    /* renamed from: c  reason: collision with root package name */
    private final String f20149c;

    public b(String str, Map<String, String> map) {
        this(str, map, false);
    }

    public b(String str, Map<String, String> map, boolean z2) {
        this.f20147a = str;
        this.f20148b = map;
        this.f20149c = z2 ? "1" : "0";
    }

    public Map<String, String> a() {
        HashMap hashMap = new HashMap();
        hashMap.put("stacktrace", this.f20147a);
        hashMap.put("caught_exception", this.f20149c);
        hashMap.putAll(this.f20148b);
        return hashMap;
    }
}
