package kotlin;

import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;

public final class Pair<A, B> implements Serializable {

    /* renamed from: b  reason: collision with root package name */
    private final A f40261b;

    /* renamed from: c  reason: collision with root package name */
    private final B f40262c;

    public Pair(A a2, B b2) {
        this.f40261b = a2;
        this.f40262c = b2;
    }

    public final A a() {
        return this.f40261b;
    }

    public final B b() {
        return this.f40262c;
    }

    public final A c() {
        return this.f40261b;
    }

    public final B d() {
        return this.f40262c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        return Intrinsics.a(this.f40261b, pair.f40261b) && Intrinsics.a(this.f40262c, pair.f40262c);
    }

    public int hashCode() {
        A a2 = this.f40261b;
        int i2 = 0;
        int hashCode = (a2 == null ? 0 : a2.hashCode()) * 31;
        B b2 = this.f40262c;
        if (b2 != null) {
            i2 = b2.hashCode();
        }
        return hashCode + i2;
    }

    public String toString() {
        return '(' + this.f40261b + ", " + this.f40262c + ')';
    }
}
