package com.google.ar.core;

import com.google.ar.core.exceptions.FatalException;

public enum RecordingStatus {
    NONE(0),
    OK(1),
    IO_ERROR(2);
    
    final int nativeCode;

    private RecordingStatus(int i2) {
        this.nativeCode = i2;
    }

    static RecordingStatus forNumber(int i2) {
        for (RecordingStatus recordingStatus : values()) {
            if (recordingStatus.nativeCode == i2) {
                return recordingStatus;
            }
        }
        throw new FatalException(p.b((byte) 51, i2, "Unexpected value for native RecordingStatus, value="));
    }
}
