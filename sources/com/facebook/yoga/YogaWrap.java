package com.facebook.yoga;

public enum YogaWrap {
    NO_WRAP(0),
    WRAP(1),
    WRAP_REVERSE(2);
    
    private final int mIntValue;

    private YogaWrap(int i2) {
        this.mIntValue = i2;
    }

    public static YogaWrap fromInt(int i2) {
        if (i2 == 0) {
            return NO_WRAP;
        }
        if (i2 == 1) {
            return WRAP;
        }
        if (i2 == 2) {
            return WRAP_REVERSE;
        }
        throw new IllegalArgumentException("Unknown enum value: " + i2);
    }

    public int intValue() {
        return this.mIntValue;
    }
}
