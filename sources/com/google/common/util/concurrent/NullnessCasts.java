package com.google.common.util.concurrent;

final class NullnessCasts {
    private NullnessCasts() {
    }

    static <T> T a() {
        return null;
    }
}
