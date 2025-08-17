package com.google.common.base;

final class Platform {

    /* renamed from: a  reason: collision with root package name */
    private static final PatternCompiler f30402a = b();

    private static final class JdkPatternCompiler implements PatternCompiler {
        private JdkPatternCompiler() {
        }
    }

    private Platform() {
    }

    static String a(String str) {
        if (d(str)) {
            return null;
        }
        return str;
    }

    private static PatternCompiler b() {
        return new JdkPatternCompiler();
    }

    static String c(String str) {
        return str == null ? "" : str;
    }

    static boolean d(String str) {
        return str == null || str.isEmpty();
    }
}
