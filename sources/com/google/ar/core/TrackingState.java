package com.google.ar.core;

import com.google.ar.core.exceptions.FatalException;

public enum TrackingState {
    TRACKING(0),
    PAUSED(1),
    STOPPED(2);
    
    final int nativeCode;

    private TrackingState(int i2) {
        this.nativeCode = i2;
    }

    static TrackingState forNumber(int i2) {
        for (TrackingState trackingState : values()) {
            if (trackingState.nativeCode == i2) {
                return trackingState;
            }
        }
        throw new FatalException(p.b((byte) 49, i2, "Unexpected value for native TrackingState, value="));
    }
}
