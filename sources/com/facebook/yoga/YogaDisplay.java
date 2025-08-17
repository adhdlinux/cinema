package com.facebook.yoga;

public enum YogaDisplay {
    FLEX(0),
    NONE(1);
    
    private final int mIntValue;

    private YogaDisplay(int i2) {
        this.mIntValue = i2;
    }

    public static YogaDisplay fromInt(int i2) {
        if (i2 == 0) {
            return FLEX;
        }
        if (i2 == 1) {
            return NONE;
        }
        throw new IllegalArgumentException("Unknown enum value: " + i2);
    }

    public int intValue() {
        return this.mIntValue;
    }
}
