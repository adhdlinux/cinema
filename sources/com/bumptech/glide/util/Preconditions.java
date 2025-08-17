package com.bumptech.glide.util;

import android.text.TextUtils;
import java.util.Collection;

public final class Preconditions {
    private Preconditions() {
    }

    public static void a(boolean z2, String str) {
        if (!z2) {
            throw new IllegalArgumentException(str);
        }
    }

    public static String b(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        throw new IllegalArgumentException("Must not be null or empty");
    }

    public static <T extends Collection<Y>, Y> T c(T t2) {
        if (!t2.isEmpty()) {
            return t2;
        }
        throw new IllegalArgumentException("Must not be empty.");
    }

    public static <T> T d(T t2) {
        return e(t2, "Argument must not be null");
    }

    public static <T> T e(T t2, String str) {
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException(str);
    }
}
