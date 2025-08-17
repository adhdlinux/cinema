package com.google.ar.core;

import com.google.ar.core.exceptions.FatalException;

public enum PlaybackStatus {
    NONE(0),
    OK(1),
    IO_ERROR(2),
    FINISHED(3);
    
    final int nativeCode;

    private PlaybackStatus(int i2) {
        this.nativeCode = i2;
    }

    static PlaybackStatus forNumber(int i2) {
        for (PlaybackStatus playbackStatus : values()) {
            if (playbackStatus.nativeCode == i2) {
                return playbackStatus;
            }
        }
        throw new FatalException(p.b((byte) 50, i2, "Unexpected value for native PlaybackStatus, value="));
    }
}
