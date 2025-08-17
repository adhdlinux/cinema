package com.google.protobuf;

final class Android {
    private static boolean ASSUME_ANDROID;
    private static final boolean IS_ROBOLECTRIC;
    private static final Class<?> MEMORY_CLASS = getClassForName("libcore.io.Memory");

    static {
        boolean z2;
        if (ASSUME_ANDROID || getClassForName("org.robolectric.Robolectric") == null) {
            z2 = false;
        } else {
            z2 = true;
        }
        IS_ROBOLECTRIC = z2;
    }

    private Android() {
    }

    private static <T> Class<T> getClassForName(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    static Class<?> getMemoryClass() {
        return MEMORY_CLASS;
    }

    static boolean isOnAndroidDevice() {
        return ASSUME_ANDROID || (MEMORY_CLASS != null && !IS_ROBOLECTRIC);
    }
}
