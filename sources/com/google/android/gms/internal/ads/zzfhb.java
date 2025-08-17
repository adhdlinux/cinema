package com.google.android.gms.internal.ads;

import com.unity3d.services.core.device.MimeTypes;

public enum zzfhb {
    DEFINED_BY_JAVASCRIPT("definedByJavaScript"),
    HTML_DISPLAY("htmlDisplay"),
    NATIVE_DISPLAY("nativeDisplay"),
    VIDEO(MimeTypes.BASE_TYPE_VIDEO),
    AUDIO(MimeTypes.BASE_TYPE_AUDIO);
    
    private final String zzg;

    private zzfhb(String str) {
        this.zzg = str;
    }

    public final String toString() {
        return this.zzg;
    }
}
