package com.facebook.yoga;

public enum YogaFlexDirection {
    COLUMN(0),
    COLUMN_REVERSE(1),
    ROW(2),
    ROW_REVERSE(3);
    
    private final int mIntValue;

    private YogaFlexDirection(int i2) {
        this.mIntValue = i2;
    }

    public static YogaFlexDirection fromInt(int i2) {
        if (i2 == 0) {
            return COLUMN;
        }
        if (i2 == 1) {
            return COLUMN_REVERSE;
        }
        if (i2 == 2) {
            return ROW;
        }
        if (i2 == 3) {
            return ROW_REVERSE;
        }
        throw new IllegalArgumentException("Unknown enum value: " + i2);
    }

    public int intValue() {
        return this.mIntValue;
    }
}
