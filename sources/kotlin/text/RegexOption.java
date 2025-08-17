package kotlin.text;

import kotlin.enums.EnumEntriesKt;

public enum RegexOption {
    IGNORE_CASE(2, 0, 2, (int) null),
    MULTILINE(8, 0, 2, (int) null),
    LITERAL(16, 0, 2, (int) null),
    UNIX_LINES(1, 0, 2, (int) null),
    COMMENTS(4, 0, 2, (int) null),
    DOT_MATCHES_ALL(32, 0, 2, (int) null),
    CANON_EQ(128, 0, 2, (int) null);
    

    /* renamed from: b  reason: collision with root package name */
    private final int f40555b;

    /* renamed from: c  reason: collision with root package name */
    private final int f40556c;

    static {
        RegexOption[] a2;
        f40554l = EnumEntriesKt.a(a2);
    }

    private RegexOption(int i2, int i3) {
        this.f40555b = i2;
        this.f40556c = i3;
    }

    public int b() {
        return this.f40555b;
    }
}
