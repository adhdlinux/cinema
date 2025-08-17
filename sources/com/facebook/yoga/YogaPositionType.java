package com.facebook.yoga;

public enum YogaPositionType {
    STATIC(0),
    RELATIVE(1),
    ABSOLUTE(2);
    
    private final int mIntValue;

    private YogaPositionType(int i2) {
        this.mIntValue = i2;
    }

    public static YogaPositionType fromInt(int i2) {
        if (i2 == 0) {
            return STATIC;
        }
        if (i2 == 1) {
            return RELATIVE;
        }
        if (i2 == 2) {
            return ABSOLUTE;
        }
        throw new IllegalArgumentException("Unknown enum value: " + i2);
    }

    public int intValue() {
        return this.mIntValue;
    }
}
