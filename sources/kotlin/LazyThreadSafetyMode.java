package kotlin;

import kotlin.enums.EnumEntriesKt;

public enum LazyThreadSafetyMode {
    SYNCHRONIZED,
    PUBLICATION,
    NONE;

    static {
        LazyThreadSafetyMode[] a2;
        f40260f = EnumEntriesKt.a(a2);
    }
}
