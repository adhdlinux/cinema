package com.google.android.gms.internal.cast;

public enum zzvg {
    DOUBLE(zzvh.DOUBLE, 1),
    FLOAT(zzvh.FLOAT, 5),
    INT64(r5, 0),
    UINT64(r5, 0),
    INT32(r11, 0),
    FIXED64(r5, 1),
    FIXED32(r11, 5),
    BOOL(zzvh.BOOLEAN, 0),
    STRING(zzvh.STRING, 2),
    GROUP(r13, 3),
    MESSAGE(r13, 2),
    BYTES(zzvh.BYTE_STRING, 2),
    UINT32(r11, 0),
    ENUM(zzvh.ENUM, 0),
    SFIXED32(r11, 5),
    SFIXED64(r5, 1),
    SINT32(r11, 0),
    SINT64(r5, 0);
    
    private final zzvh zzt;

    private zzvg(zzvh zzvh, int i2) {
        this.zzt = zzvh;
    }

    public final zzvh zza() {
        return this.zzt;
    }
}
