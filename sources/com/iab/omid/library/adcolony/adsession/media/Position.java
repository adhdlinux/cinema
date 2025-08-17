package com.iab.omid.library.adcolony.adsession.media;

public enum Position {
    PREROLL("preroll"),
    MIDROLL("midroll"),
    POSTROLL("postroll"),
    STANDALONE("standalone");
    

    /* renamed from: b  reason: collision with root package name */
    private final String f31363b;

    private Position(String str) {
        this.f31363b = str;
    }

    public String toString() {
        return this.f31363b;
    }
}
