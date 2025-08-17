package com.google.android.gms.internal.measurement;

public enum zznc {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(0.0f)),
    DOUBLE(Double.valueOf(0.0d)),
    BOOLEAN(Boolean.FALSE),
    STRING(""),
    BYTE_STRING(zzjb.zzb),
    ENUM((String) null),
    MESSAGE((String) null);
    
    private final Object zzk;

    private zznc(Object obj) {
        this.zzk = obj;
    }
}
