package com.google.common.collect;

final class NullnessCasts {
    private NullnessCasts() {
    }

    static <T> T a(T t2) {
        return t2;
    }

    static <T> T b() {
        return null;
    }
}
