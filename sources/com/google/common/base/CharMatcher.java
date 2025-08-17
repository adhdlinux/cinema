package com.google.common.base;

public abstract class CharMatcher implements Predicate<Character> {

    static abstract class FastMatcher extends CharMatcher {
        FastMatcher() {
        }

        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return CharMatcher.super.apply((Character) obj);
        }
    }

    private static final class Is extends FastMatcher {

        /* renamed from: b  reason: collision with root package name */
        private final char f30385b;

        Is(char c2) {
            this.f30385b = c2;
        }

        public boolean e(char c2) {
            return c2 == this.f30385b;
        }

        public String toString() {
            return "CharMatcher.is('" + CharMatcher.g(this.f30385b) + "')";
        }
    }

    static abstract class NamedFastMatcher extends FastMatcher {

        /* renamed from: b  reason: collision with root package name */
        private final String f30386b;

        NamedFastMatcher(String str) {
            this.f30386b = (String) Preconditions.l(str);
        }

        public final String toString() {
            return this.f30386b;
        }
    }

    private static final class None extends NamedFastMatcher {

        /* renamed from: c  reason: collision with root package name */
        static final CharMatcher f30387c = new None();

        private None() {
            super("CharMatcher.none()");
        }

        public int c(CharSequence charSequence, int i2) {
            Preconditions.n(i2, charSequence.length());
            return -1;
        }

        public boolean e(char c2) {
            return false;
        }
    }

    protected CharMatcher() {
    }

    public static CharMatcher d(char c2) {
        return new Is(c2);
    }

    public static CharMatcher f() {
        return None.f30387c;
    }

    /* access modifiers changed from: private */
    public static String g(char c2) {
        char[] cArr = {'\\', 'u', 0, 0, 0, 0};
        for (int i2 = 0; i2 < 4; i2++) {
            cArr[5 - i2] = "0123456789ABCDEF".charAt(c2 & 15);
            c2 = (char) (c2 >> 4);
        }
        return String.copyValueOf(cArr);
    }

    @Deprecated
    /* renamed from: b */
    public boolean apply(Character ch) {
        return e(ch.charValue());
    }

    public int c(CharSequence charSequence, int i2) {
        int length = charSequence.length();
        Preconditions.n(i2, length);
        while (i2 < length) {
            if (e(charSequence.charAt(i2))) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public abstract boolean e(char c2);

    public String toString() {
        return super.toString();
    }
}
