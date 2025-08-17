package com.google.android.gms.internal.measurement;

public enum zznb {
    DOUBLE(zznc.DOUBLE, 1),
    FLOAT(zznc.FLOAT, 5),
    INT64(r5, 0),
    UINT64(r5, 0),
    INT32(r11, 0),
    FIXED64(r5, 1),
    FIXED32(r11, 5),
    BOOL(zznc.BOOLEAN, 0),
    STRING(zznc.STRING, 2),
    GROUP(r13, 3),
    MESSAGE(r13, 2),
    BYTES(zznc.BYTE_STRING, 2),
    UINT32(r11, 0),
    ENUM(zznc.ENUM, 0),
    SFIXED32(r11, 5),
    SFIXED64(r5, 1),
    SINT32(r11, 0),
    SINT64(r5, 0);
    
    private final zznc zzt;

    private zznb(zznc zznc, int i2) {
        this.zzt = zznc;
    }

    public final zznc zza() {
        return this.zzt;
    }
}
