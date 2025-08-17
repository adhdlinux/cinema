package com.iab.omid.library.vungle.adsession;

import com.iab.omid.library.vungle.utils.g;

public class Partner {

    /* renamed from: a  reason: collision with root package name */
    private final String f31677a;

    /* renamed from: b  reason: collision with root package name */
    private final String f31678b;

    private Partner(String str, String str2) {
        this.f31677a = str;
        this.f31678b = str2;
    }

    public static Partner a(String str, String str2) {
        g.e(str, "Name is null or empty");
        g.e(str2, "Version is null or empty");
        return new Partner(str, str2);
    }

    public String b() {
        return this.f31677a;
    }

    public String c() {
        return this.f31678b;
    }
}
