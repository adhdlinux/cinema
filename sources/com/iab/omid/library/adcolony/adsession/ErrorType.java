package com.iab.omid.library.adcolony.adsession;

import com.unity3d.services.core.device.MimeTypes;

public enum ErrorType {
    GENERIC("generic"),
    VIDEO(MimeTypes.BASE_TYPE_VIDEO);
    

    /* renamed from: b  reason: collision with root package name */
    private final String f31316b;

    private ErrorType(String str) {
        this.f31316b = str;
    }

    public String toString() {
        return this.f31316b;
    }
}
