package com.applovin.impl.sdk.b;

import java.util.Map;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private final String f15172a;

    /* renamed from: b  reason: collision with root package name */
    private Map<String, String> f15173b;

    private c(String str, Map<String, String> map) {
        this.f15172a = str;
        this.f15173b = map;
    }

    public static c a(String str) {
        return a(str, (Map<String, String>) null);
    }

    public static c a(String str, Map<String, String> map) {
        return new c(str, map);
    }

    public Map<String, String> a() {
        return this.f15173b;
    }

    public String b() {
        return this.f15172a;
    }

    public String toString() {
        return "PendingReward{result='" + this.f15172a + '\'' + "params='" + this.f15173b + '\'' + '}';
    }
}
