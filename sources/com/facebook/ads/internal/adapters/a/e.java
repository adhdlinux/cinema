package com.facebook.ads.internal.adapters.a;

import java.io.Serializable;

public class e implements Serializable {
    private static final long serialVersionUID = -4041915335826065133L;

    /* renamed from: a  reason: collision with root package name */
    private final String f19713a;

    /* renamed from: b  reason: collision with root package name */
    private final String f19714b;

    e(String str, String str2) {
        this.f19713a = a(str);
        this.f19714b = a(str2);
    }

    private static String a(String str) {
        return "null".equalsIgnoreCase(str) ? "" : str;
    }

    public String a() {
        return this.f19713a;
    }

    public String b() {
        return this.f19714b;
    }
}
