package kotlin.ranges;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class CharRange extends CharProgression {

    /* renamed from: f  reason: collision with root package name */
    public static final Companion f40453f = new Companion((DefaultConstructorMarker) null);

    /* renamed from: g  reason: collision with root package name */
    private static final CharRange f40454g = new CharRange(1, 0);

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public CharRange(char c2, char c3) {
        super(c2, c3, 1);
    }

    public boolean e(char c2) {
        return Intrinsics.h(a(), c2) <= 0 && Intrinsics.h(c2, b()) <= 0;
    }

    public boolean equals(Object obj) {
        if (obj instanceof CharRange) {
            if (!isEmpty() || !((CharRange) obj).isEmpty()) {
                CharRange charRange = (CharRange) obj;
                if (!(a() == charRange.a() && b() == charRange.b())) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (a() * 31) + b();
    }

    public boolean isEmpty() {
        return Intrinsics.h(a(), b()) > 0;
    }

    public String toString() {
        return a() + ".." + b();
    }
}
