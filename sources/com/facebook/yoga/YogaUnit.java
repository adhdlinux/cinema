package com.facebook.yoga;

public enum YogaUnit {
    UNDEFINED(0),
    POINT(1),
    PERCENT(2),
    AUTO(3);
    
    private final int mIntValue;

    private YogaUnit(int i2) {
        this.mIntValue = i2;
    }

    public static YogaUnit fromInt(int i2) {
        if (i2 == 0) {
            return UNDEFINED;
        }
        if (i2 == 1) {
            return POINT;
        }
        if (i2 == 2) {
            return PERCENT;
        }
        if (i2 == 3) {
            return AUTO;
        }
        throw new IllegalArgumentException("Unknown enum value: " + i2);
    }

    public int intValue() {
        return this.mIntValue;
    }
}
