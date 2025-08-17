package com.iab.omid.library.vungle.adsession;

import com.unity3d.services.core.device.MimeTypes;

public enum CreativeType {
    DEFINED_BY_JAVASCRIPT("definedByJavaScript"),
    HTML_DISPLAY("htmlDisplay"),
    NATIVE_DISPLAY("nativeDisplay"),
    VIDEO(MimeTypes.BASE_TYPE_VIDEO),
    AUDIO(MimeTypes.BASE_TYPE_AUDIO);
    

    /* renamed from: b  reason: collision with root package name */
    private final String f31648b;

    private CreativeType(String str) {
        this.f31648b = str;
    }

    public String toString() {
        return this.f31648b;
    }
}
