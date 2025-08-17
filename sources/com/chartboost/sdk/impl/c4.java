package com.chartboost.sdk.impl;

import com.unity3d.services.core.device.MimeTypes;

public enum c4 {
    DEFINED_BY_JAVASCRIPT("definedByJavaScript"),
    HTML_DISPLAY("htmlDisplay"),
    NATIVE_DISPLAY("nativeDisplay"),
    VIDEO(MimeTypes.BASE_TYPE_VIDEO),
    AUDIO(MimeTypes.BASE_TYPE_AUDIO);
    

    /* renamed from: b  reason: collision with root package name */
    public final String f17326b;

    /* access modifiers changed from: public */
    c4(String str) {
        this.f17326b = str;
    }

    public String toString() {
        return this.f17326b;
    }
}
