package com.google.ar.core;

import com.google.ar.core.exceptions.FatalException;

public enum VpsAvailability {
    UNKNOWN(0),
    AVAILABLE(1),
    UNAVAILABLE(2),
    ERROR_INTERNAL(-1),
    ERROR_NETWORK_CONNECTION(-2),
    ERROR_NOT_AUTHORIZED(-3),
    ERROR_RESOURCE_EXHAUSTED(-4);
    
    final int nativeCode;

    private VpsAvailability(int i2) {
        this.nativeCode = i2;
    }

    static VpsAvailability forNumber(int i2) {
        for (VpsAvailability vpsAvailability : values()) {
            if (vpsAvailability.nativeCode == i2) {
                return vpsAvailability;
            }
        }
        throw new FatalException(p.b((byte) 51, i2, "Unexpected value for native VpsAvailability, value="));
    }
}
