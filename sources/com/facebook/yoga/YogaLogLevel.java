package com.facebook.yoga;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public enum YogaLogLevel {
    ERROR(0),
    WARN(1),
    INFO(2),
    DEBUG(3),
    VERBOSE(4),
    FATAL(5);
    
    private final int mIntValue;

    private YogaLogLevel(int i2) {
        this.mIntValue = i2;
    }

    @DoNotStrip
    public static YogaLogLevel fromInt(int i2) {
        if (i2 == 0) {
            return ERROR;
        }
        if (i2 == 1) {
            return WARN;
        }
        if (i2 == 2) {
            return INFO;
        }
        if (i2 == 3) {
            return DEBUG;
        }
        if (i2 == 4) {
            return VERBOSE;
        }
        if (i2 == 5) {
            return FATAL;
        }
        throw new IllegalArgumentException("Unknown enum value: " + i2);
    }

    public int intValue() {
        return this.mIntValue;
    }
}
