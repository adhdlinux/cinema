package com.bumptech.glide.load.engine.executor;

final class RuntimeCompat {
    private RuntimeCompat() {
    }

    static int a() {
        return Runtime.getRuntime().availableProcessors();
    }
}
