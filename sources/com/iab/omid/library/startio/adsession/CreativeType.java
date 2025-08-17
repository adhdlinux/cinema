package com.iab.omid.library.startio.adsession;

import com.unity3d.services.core.device.MimeTypes;

public enum CreativeType {
    DEFINED_BY_JAVASCRIPT("definedByJavaScript"),
    HTML_DISPLAY("htmlDisplay"),
    NATIVE_DISPLAY("nativeDisplay"),
    VIDEO(MimeTypes.BASE_TYPE_VIDEO);
    

    /* renamed from: b  reason: collision with root package name */
    private final String f31590b;

    /* access modifiers changed from: public */
    CreativeType(String str) {
        this.f31590b = str;
    }

    public String toString() {
        return this.f31590b;
    }
}
