package com.iab.omid.library.adcolony.adsession;

public enum Owner {
    NATIVE("native"),
    JAVASCRIPT("javascript"),
    NONE("none");
    

    /* renamed from: b  reason: collision with root package name */
    private final String f31336b;

    private Owner(String str) {
        this.f31336b = str;
    }

    public String toString() {
        return this.f31336b;
    }
}
