package kotlin;

import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;

public final class Triple<A, B, C> implements Serializable {

    /* renamed from: b  reason: collision with root package name */
    private final A f40274b;

    /* renamed from: c  reason: collision with root package name */
    private final B f40275c;

    /* renamed from: d  reason: collision with root package name */
    private final C f40276d;

    public Triple(A a2, B b2, C c2) {
        this.f40274b = a2;
        this.f40275c = b2;
        this.f40276d = c2;
    }

    public final A a() {
        return this.f40274b;
    }

    public final B b() {
        return this.f40275c;
    }

    public final C c() {
        return this.f40276d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Triple)) {
            return false;
        }
        Triple triple = (Triple) obj;
        return Intrinsics.a(this.f40274b, triple.f40274b) && Intrinsics.a(this.f40275c, triple.f40275c) && Intrinsics.a(this.f40276d, triple.f40276d);
    }

    public int hashCode() {
        A a2 = this.f40274b;
        int i2 = 0;
        int hashCode = (a2 == null ? 0 : a2.hashCode()) * 31;
        B b2 = this.f40275c;
        int hashCode2 = (hashCode + (b2 == null ? 0 : b2.hashCode())) * 31;
        C c2 = this.f40276d;
        if (c2 != null) {
            i2 = c2.hashCode();
        }
        return hashCode2 + i2;
    }

    public String toString() {
        return '(' + this.f40274b + ", " + this.f40275c + ", " + this.f40276d + ')';
    }
}
