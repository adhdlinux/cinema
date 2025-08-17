package kotlin.enums;

import java.io.Serializable;
import java.lang.Enum;
import kotlin.collections.AbstractList;
import kotlin.jvm.internal.Intrinsics;

final class EnumEntriesList<T extends Enum<T>> extends AbstractList<T> implements EnumEntries<T>, Serializable {

    /* renamed from: c  reason: collision with root package name */
    private final T[] f40378c;

    public EnumEntriesList(T[] tArr) {
        Intrinsics.f(tArr, "entries");
        this.f40378c = tArr;
    }

    public int a() {
        return this.f40378c.length;
    }

    public boolean b(T t2) {
        Intrinsics.f(t2, "element");
        if (((Enum) ArraysKt___ArraysKt.z(this.f40378c, t2.ordinal())) == t2) {
            return true;
        }
        return false;
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof Enum)) {
            return false;
        }
        return b((Enum) obj);
    }

    /* renamed from: d */
    public T get(int i2) {
        AbstractList.f40302b.b(i2, this.f40378c.length);
        return this.f40378c[i2];
    }

    public int e(T t2) {
        Intrinsics.f(t2, "element");
        int ordinal = t2.ordinal();
        if (((Enum) ArraysKt___ArraysKt.z(this.f40378c, ordinal)) == t2) {
            return ordinal;
        }
        return -1;
    }

    public int g(T t2) {
        Intrinsics.f(t2, "element");
        return indexOf(t2);
    }

    public final /* bridge */ int indexOf(Object obj) {
        if (!(obj instanceof Enum)) {
            return -1;
        }
        return e((Enum) obj);
    }

    public final /* bridge */ int lastIndexOf(Object obj) {
        if (!(obj instanceof Enum)) {
            return -1;
        }
        return g((Enum) obj);
    }
}
