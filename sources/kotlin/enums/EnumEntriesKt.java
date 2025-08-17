package kotlin.enums;

import kotlin.jvm.internal.Intrinsics;

public final class EnumEntriesKt {
    public static final <E extends Enum<E>> EnumEntries<E> a(E[] eArr) {
        Intrinsics.f(eArr, "entries");
        return new EnumEntriesList(eArr);
    }
}
