package com.uwetrottmann.trakt5.enums;

public enum Rating implements TraktEnum {
    WEAKSAUCE(1),
    TERRIBLE(2),
    BAD(3),
    POOR(4),
    MEH(5),
    FAIR(6),
    GOOD(7),
    GREAT(8),
    SUPERB(9),
    TOTALLYNINJA(10);
    
    public int value;

    private Rating(int i2) {
        this.value = i2;
    }

    public static Rating fromValue(int i2) {
        return values()[i2 - 1];
    }

    public String toString() {
        return String.valueOf(this.value);
    }
}
