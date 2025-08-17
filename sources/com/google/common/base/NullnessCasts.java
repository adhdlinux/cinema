package com.google.common.base;

final class NullnessCasts {
    private NullnessCasts() {
    }

    static <T> T a(T t2) {
        return t2;
    }
}
