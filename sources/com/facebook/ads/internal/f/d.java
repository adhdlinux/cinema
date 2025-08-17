package com.facebook.ads.internal.f;

import java.util.Map;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private double f20153a;

    /* renamed from: b  reason: collision with root package name */
    private double f20154b = (((double) System.currentTimeMillis()) / 1000.0d);

    /* renamed from: c  reason: collision with root package name */
    private String f20155c;

    /* renamed from: d  reason: collision with root package name */
    private Map<String, String> f20156d;

    public d(double d2, String str, Map<String, String> map) {
        this.f20153a = d2;
        this.f20155c = str;
        this.f20156d = map;
    }

    public String a() {
        return "debug";
    }

    public double b() {
        return this.f20154b;
    }

    public double c() {
        return this.f20153a;
    }

    public String d() {
        return this.f20155c;
    }

    public Map<String, String> e() {
        return this.f20156d;
    }
}
