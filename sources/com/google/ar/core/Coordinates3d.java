package com.google.ar.core;

import com.google.ar.core.exceptions.FatalException;

public enum Coordinates3d {
    EIS_TEXTURE_NORMALIZED(0),
    EIS_NORMALIZED_DEVICE_COORDINATES(1);
    
    final int nativeCode;

    private Coordinates3d(int i2) {
        this.nativeCode = i2;
    }

    static Coordinates3d forNumber(int i2) {
        for (Coordinates3d coordinates3d : values()) {
            if (coordinates3d.nativeCode == i2) {
                return coordinates3d;
            }
        }
        throw new FatalException(p.b((byte) 51, i2, "Unexpected value for native Coordinates3d, value = "));
    }
}
