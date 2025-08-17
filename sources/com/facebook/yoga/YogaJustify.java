package com.facebook.yoga;

public enum YogaJustify {
    FLEX_START(0),
    CENTER(1),
    FLEX_END(2),
    SPACE_BETWEEN(3),
    SPACE_AROUND(4),
    SPACE_EVENLY(5);
    
    private final int mIntValue;

    private YogaJustify(int i2) {
        this.mIntValue = i2;
    }

    public static YogaJustify fromInt(int i2) {
        if (i2 == 0) {
            return FLEX_START;
        }
        if (i2 == 1) {
            return CENTER;
        }
        if (i2 == 2) {
            return FLEX_END;
        }
        if (i2 == 3) {
            return SPACE_BETWEEN;
        }
        if (i2 == 4) {
            return SPACE_AROUND;
        }
        if (i2 == 5) {
            return SPACE_EVENLY;
        }
        throw new IllegalArgumentException("Unknown enum value: " + i2);
    }

    public int intValue() {
        return this.mIntValue;
    }
}
