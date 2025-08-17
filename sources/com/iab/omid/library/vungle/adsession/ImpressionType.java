package com.iab.omid.library.vungle.adsession;

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
    private final String f31668b;

    private ImpressionType(String str) {
        this.f31668b = str;
    }

    public String toString() {
        return this.f31668b;
    }
}
