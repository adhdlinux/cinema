package com.google.gson;

import java.lang.reflect.Field;
import java.util.Objects;

public final class FieldAttributes {

    /* renamed from: a  reason: collision with root package name */
    private final Field f30824a;

    public FieldAttributes(Field field) {
        Objects.requireNonNull(field);
        this.f30824a = field;
    }

    public String toString() {
        return this.f30824a.toString();
    }
}
