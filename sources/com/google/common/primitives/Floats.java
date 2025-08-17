package com.google.common.primitives;

public final class Floats extends FloatsMethodsForWeb {
    private Floats() {
    }

    public static int a(float f2) {
        return Float.valueOf(f2).hashCode();
    }
}
