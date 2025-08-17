package com.facebook.common.internal;

import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.STRICT)
public class Suppliers {
    public static final Supplier<Boolean> BOOLEAN_FALSE = new Supplier<Boolean>() {
        public Boolean get() {
            return Boolean.FALSE;
        }
    };
    public static final Supplier<Boolean> BOOLEAN_TRUE = new Supplier<Boolean>() {
        public Boolean get() {
            return Boolean.TRUE;
        }
    };

    public static <T> Supplier<T> of(final T t2) {
        return new Supplier<T>() {
            public T get() {
                return t2;
            }
        };
    }
}
