package com.facebook.yoga;

public enum YogaMeasureMode {
    UNDEFINED(0),
    EXACTLY(1),
    AT_MOST(2);
    
    private final int mIntValue;

    private YogaMeasureMode(int i2) {
        this.mIntValue = i2;
    }

    public static YogaMeasureMode fromInt(int i2) {
        if (i2 == 0) {
            return UNDEFINED;
        }
        if (i2 == 1) {
            return EXACTLY;
        }
        if (i2 == 2) {
            return AT_MOST;
        }
        throw new IllegalArgumentException("Unknown enum value: " + i2);
    }

    public int intValue() {
        return this.mIntValue;
    }
}
