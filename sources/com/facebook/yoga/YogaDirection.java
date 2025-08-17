package com.facebook.yoga;

public enum YogaDirection {
    INHERIT(0),
    LTR(1),
    RTL(2);
    
    private final int mIntValue;

    private YogaDirection(int i2) {
        this.mIntValue = i2;
    }

    public static YogaDirection fromInt(int i2) {
        if (i2 == 0) {
            return INHERIT;
        }
        if (i2 == 1) {
            return LTR;
        }
        if (i2 == 2) {
            return RTL;
        }
        throw new IllegalArgumentException("Unknown enum value: " + i2);
    }

    public int intValue() {
        return this.mIntValue;
    }
}
