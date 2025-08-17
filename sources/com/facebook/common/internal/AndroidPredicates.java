package com.facebook.common.internal;

import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.STRICT)
public class AndroidPredicates {
    private AndroidPredicates() {
    }

    public static <T> Predicate<T> False() {
        return new Predicate<T>() {
            public boolean apply(T t2) {
                return false;
            }
        };
    }

    public static <T> Predicate<T> True() {
        return new Predicate<T>() {
            public boolean apply(T t2) {
                return true;
            }
        };
    }
}
