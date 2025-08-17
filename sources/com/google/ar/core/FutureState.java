package com.google.ar.core;

import com.google.ar.core.exceptions.FatalException;

public enum FutureState {
    PENDING(0),
    CANCELLED(1),
    DONE(2);
    
    final int nativeCode;

    private FutureState(int i2) {
        this.nativeCode = i2;
    }

    static FutureState forNumber(int i2) {
        for (FutureState futureState : values()) {
            if (futureState.nativeCode == i2) {
                return futureState;
            }
        }
        throw new FatalException(p.b((byte) 47, i2, "Unexpected value for native FutureState, value="));
    }
}
