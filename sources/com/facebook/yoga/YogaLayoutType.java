package com.facebook.yoga;

public enum YogaLayoutType {
    LAYOUT(0),
    MEASURE(1),
    CACHED_LAYOUT(2),
    CACHED_MEASURE(3);
    
    private final int mIntValue;

    private YogaLayoutType(int i2) {
        this.mIntValue = i2;
    }

    public static YogaLayoutType fromInt(int i2) {
        if (i2 == 0) {
            return LAYOUT;
        }
        if (i2 == 1) {
            return MEASURE;
        }
        if (i2 == 2) {
            return CACHED_LAYOUT;
        }
        if (i2 == 3) {
            return CACHED_MEASURE;
        }
        throw new IllegalArgumentException("Unknown enum value: " + i2);
    }

    public int intValue() {
        return this.mIntValue;
    }
}
