package com.iab.omid.library.adcolony.adsession;

import com.iab.omid.library.adcolony.d.e;

public class Partner {

    /* renamed from: a  reason: collision with root package name */
    private final String f31337a;

    /* renamed from: b  reason: collision with root package name */
    private final String f31338b;

    private Partner(String str, String str2) {
        this.f31337a = str;
        this.f31338b = str2;
    }

    public static Partner a(String str, String str2) {
        e.f(str, "Name is null or empty");
        e.f(str2, "Version is null or empty");
        return new Partner(str, str2);
    }

    public String b() {
        return this.f31337a;
    }

    public String c() {
        return this.f31338b;
    }
}
