package com.applovin.impl.sdk.d;

import java.util.Map;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private final String f15253a;

    /* renamed from: b  reason: collision with root package name */
    private final String f15254b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, String> f15255c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f15256d;

    public a(String str, String str2) {
        this(str, str2, (Map<String, String>) null, false);
    }

    public a(String str, String str2, Map<String, String> map, boolean z2) {
        this.f15253a = str;
        this.f15254b = str2;
        this.f15255c = map;
        this.f15256d = z2;
    }

    public String a() {
        return this.f15253a;
    }

    public String b() {
        return this.f15254b;
    }

    public Map<String, String> c() {
        return this.f15255c;
    }

    public boolean d() {
        return this.f15256d;
    }

    public String toString() {
        return "AdEventPostback{url='" + this.f15253a + '\'' + ", backupUrl='" + this.f15254b + '\'' + ", headers='" + this.f15255c + '\'' + ", shouldFireInWebView='" + this.f15256d + '\'' + '}';
    }
}
