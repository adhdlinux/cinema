package com.database.entitys;

import com.google.gson.Gson;

public class CrawlCount {

    /* renamed from: a  reason: collision with root package name */
    private int f19291a;

    /* renamed from: b  reason: collision with root package name */
    private String f19292b;

    /* renamed from: c  reason: collision with root package name */
    private String f19293c;

    /* renamed from: d  reason: collision with root package name */
    private int f19294d;

    public int a() {
        return this.f19294d;
    }

    public String b() {
        return this.f19293c;
    }

    public int c() {
        return this.f19291a;
    }

    public String d() {
        return this.f19292b;
    }

    public void e(int i2) {
        this.f19294d = i2;
    }

    public void f(String str) {
        this.f19293c = str;
    }

    public void g(int i2) {
        this.f19291a = i2;
    }

    public void h(String str) {
        this.f19292b = str;
    }

    public String toString() {
        return new Gson().u(this);
    }
}
