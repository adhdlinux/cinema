package com.google.common.base;

final class Absent<T> extends Optional<T> {

    /* renamed from: b  reason: collision with root package name */
    static final Absent<Object> f30376b = new Absent<>();

    private Absent() {
    }

    static <T> Optional<T> d() {
        return f30376b;
    }

    public T b() {
        throw new IllegalStateException("Optional.get() cannot be called on an absent value");
    }

    public boolean c() {
        return false;
    }

    public boolean equals(Object obj) {
        return obj == this;
    }

    public int hashCode() {
        return 2040732332;
    }

    public String toString() {
        return "Optional.absent()";
    }
}
