package kotlin.collections;

import kotlin.jvm.internal.Intrinsics;

public final class IndexedValue<T> {

    /* renamed from: a  reason: collision with root package name */
    private final int f40322a;

    /* renamed from: b  reason: collision with root package name */
    private final T f40323b;

    public IndexedValue(int i2, T t2) {
        this.f40322a = i2;
        this.f40323b = t2;
    }

    public final int a() {
        return this.f40322a;
    }

    public final T b() {
        return this.f40323b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IndexedValue)) {
            return false;
        }
        IndexedValue indexedValue = (IndexedValue) obj;
        return this.f40322a == indexedValue.f40322a && Intrinsics.a(this.f40323b, indexedValue.f40323b);
    }

    public int hashCode() {
        int i2 = this.f40322a * 31;
        T t2 = this.f40323b;
        return i2 + (t2 == null ? 0 : t2.hashCode());
    }

    public String toString() {
        return "IndexedValue(index=" + this.f40322a + ", value=" + this.f40323b + ')';
    }
}
