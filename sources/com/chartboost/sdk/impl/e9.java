package com.chartboost.sdk.impl;

public class e9 {

    /* renamed from: a  reason: collision with root package name */
    public final String f17620a;

    /* renamed from: b  reason: collision with root package name */
    public final String f17621b;

    public e9(String str, String str2) {
        this.f17620a = str;
        this.f17621b = str2;
    }

    public static e9 a(String str, String str2) {
        df.a(str, "Name is null or empty");
        df.a(str2, "Version is null or empty");
        return new e9(str, str2);
    }

    public String b() {
        return this.f17621b;
    }

    public String a() {
        return this.f17620a;
    }
}
