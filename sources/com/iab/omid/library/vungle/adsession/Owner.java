package com.iab.omid.library.vungle.adsession;

public enum Owner {
    NATIVE("native"),
    JAVASCRIPT("javascript"),
    NONE("none");
    

    /* renamed from: b  reason: collision with root package name */
    private final String f31676b;

    private Owner(String str) {
        this.f31676b = str;
    }

    public String toString() {
        return this.f31676b;
    }
}
