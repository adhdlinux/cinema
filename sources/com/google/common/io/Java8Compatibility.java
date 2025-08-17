package com.google.common.io;

import java.nio.Buffer;

final class Java8Compatibility {
    private Java8Compatibility() {
    }

    static void a(Buffer buffer) {
        buffer.clear();
    }

    static void b(Buffer buffer) {
        buffer.flip();
    }
}
