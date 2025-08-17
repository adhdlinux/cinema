package com.facebook.yoga;

public enum YogaPrintOptions {
    LAYOUT(1),
    STYLE(2),
    CHILDREN(4);
    
    private final int mIntValue;

    private YogaPrintOptions(int i2) {
        this.mIntValue = i2;
    }

    public static YogaPrintOptions fromInt(int i2) {
        if (i2 == 1) {
            return LAYOUT;
        }
        if (i2 == 2) {
            return STYLE;
        }
        if (i2 == 4) {
            return CHILDREN;
        }
        throw new IllegalArgumentException("Unknown enum value: " + i2);
    }

    public int intValue() {
        return this.mIntValue;
    }
}
