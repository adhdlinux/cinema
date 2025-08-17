package com.facebook.yoga;

public enum YogaOverflow {
    VISIBLE(0),
    HIDDEN(1),
    SCROLL(2);
    
    private final int mIntValue;

    private YogaOverflow(int i2) {
        this.mIntValue = i2;
    }

    public static YogaOverflow fromInt(int i2) {
        if (i2 == 0) {
            return VISIBLE;
        }
        if (i2 == 1) {
            return HIDDEN;
        }
        if (i2 == 2) {
            return SCROLL;
        }
        throw new IllegalArgumentException("Unknown enum value: " + i2);
    }

    public int intValue() {
        return this.mIntValue;
    }
}
