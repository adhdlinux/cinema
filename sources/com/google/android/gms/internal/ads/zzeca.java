package com.google.android.gms.internal.ads;

import com.unity3d.services.core.device.MimeTypes;

public enum zzeca {
    HTML_DISPLAY("htmlDisplay"),
    NATIVE_DISPLAY("nativeDisplay"),
    VIDEO(MimeTypes.BASE_TYPE_VIDEO);
    
    private final String zze;

    private zzeca(String str) {
        this.zze = str;
    }

    public final String toString() {
        return this.zze;
    }
}
