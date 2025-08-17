package com.iab.omid.library.adcolony.adsession;

public enum ImpressionType {
    DEFINED_BY_JAVASCRIPT("definedByJavaScript"),
    UNSPECIFIED("unspecified"),
    LOADED("loaded"),
    BEGIN_TO_RENDER("beginToRender"),
    ONE_PIXEL("onePixel"),
    VIEWABLE("viewable"),
    AUDIBLE("audible"),
    OTHER("other");
    

    /* renamed from: b  reason: collision with root package name */
    private final String f31331b;

    private ImpressionType(String str) {
        this.f31331b = str;
    }

    public String toString() {
        return this.f31331b;
    }
}
