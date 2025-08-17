package com.facebook.soloader;

class MergedSoMapping {
    MergedSoMapping() {
    }

    static void invokeJniOnload(String str) {
        throw new IllegalArgumentException("Unknown library: " + str);
    }

    static String mapLibName(String str) {
        return null;
    }
}
