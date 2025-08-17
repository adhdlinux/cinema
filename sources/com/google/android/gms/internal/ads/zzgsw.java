package com.google.android.gms.internal.ads;

public enum zzgsw {
    DOUBLE(zzgsx.DOUBLE, 1),
    FLOAT(zzgsx.FLOAT, 5),
    INT64(r5, 0),
    UINT64(r5, 0),
    INT32(r11, 0),
    FIXED64(r5, 1),
    FIXED32(r11, 5),
    BOOL(zzgsx.BOOLEAN, 0),
    STRING(zzgsx.STRING, 2),
    GROUP(r13, 3),
    MESSAGE(r13, 2),
    BYTES(zzgsx.BYTE_STRING, 2),
    UINT32(r11, 0),
    ENUM(zzgsx.ENUM, 0),
    SFIXED32(r11, 5),
    SFIXED64(r5, 1),
    SINT32(r11, 0),
    SINT64(r5, 0);
    
    private final zzgsx zzt;

    private zzgsw(zzgsx zzgsx, int i2) {
        this.zzt = zzgsx;
    }

    public final zzgsx zza() {
        return this.zzt;
    }
}
