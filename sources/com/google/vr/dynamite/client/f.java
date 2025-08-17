package com.google.vr.dynamite.client;

import java.util.Objects;

final class f {

    /* renamed from: a  reason: collision with root package name */
    private final String f31149a;

    /* renamed from: b  reason: collision with root package name */
    private final String f31150b;

    public f(String str, String str2) {
        this.f31149a = str;
        this.f31150b = str2;
    }

    public final String a() {
        return this.f31149a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (!Objects.equals(this.f31149a, fVar.f31149a) || !Objects.equals(this.f31150b, fVar.f31150b)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (Objects.hashCode(this.f31149a) * 37) + Objects.hashCode(this.f31150b);
    }

    public final String toString() {
        return "[packageName=" + this.f31149a + ",libraryName=" + this.f31150b + "]";
    }
}
