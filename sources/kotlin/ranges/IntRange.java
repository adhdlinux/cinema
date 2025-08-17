package kotlin.ranges;

import kotlin.jvm.internal.DefaultConstructorMarker;

public final class IntRange extends IntProgression {

    /* renamed from: f  reason: collision with root package name */
    public static final Companion f40463f = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public static final IntRange f40464g = new IntRange(1, 0);

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final IntRange a() {
            return IntRange.f40464g;
        }
    }

    public IntRange(int i2, int i3) {
        super(i2, i3, 1);
    }

    public boolean contains(int i2) {
        return a() <= i2 && i2 <= b();
    }

    public boolean equals(Object obj) {
        if (obj instanceof IntRange) {
            if (!isEmpty() || !((IntRange) obj).isEmpty()) {
                IntRange intRange = (IntRange) obj;
                if (!(a() == intRange.a() && b() == intRange.b())) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public Integer h() {
        return Integer.valueOf(b());
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (a() * 31) + b();
    }

    public Integer i() {
        return Integer.valueOf(a());
    }

    public boolean isEmpty() {
        return a() > b();
    }

    public String toString() {
        return a() + ".." + b();
    }
}
