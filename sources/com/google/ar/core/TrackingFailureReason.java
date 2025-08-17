package com.google.ar.core;

import com.google.ar.core.exceptions.FatalException;

public enum TrackingFailureReason {
    NONE(0),
    BAD_STATE(1),
    INSUFFICIENT_LIGHT(2),
    EXCESSIVE_MOTION(3),
    INSUFFICIENT_FEATURES(4),
    CAMERA_UNAVAILABLE(5);
    
    final int nativeCode;

    private TrackingFailureReason(int i2) {
        this.nativeCode = i2;
    }

    static TrackingFailureReason forNumber(int i2) {
        for (TrackingFailureReason trackingFailureReason : values()) {
            if (trackingFailureReason.nativeCode == i2) {
                return trackingFailureReason;
            }
        }
        throw new FatalException(p.b((byte) 57, i2, "Unexpected value for native TrackingFailureReason, value="));
    }
}
