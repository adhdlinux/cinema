package kotlin.ranges;

import kotlin.jvm.internal.DefaultConstructorMarker;

public final class LongRange extends LongProgression {

    /* renamed from: f  reason: collision with root package name */
    public static final Companion f40473f = new Companion((DefaultConstructorMarker) null);

    /* renamed from: g  reason: collision with root package name */
    private static final LongRange f40474g = new LongRange(1, 0);

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public LongRange(long j2, long j3) {
        super(j2, j3, 1);
    }

    public boolean e(long j2) {
        return a() <= j2 && j2 <= b();
    }

    public boolean equals(Object obj) {
        if (obj instanceof LongRange) {
            if (!isEmpty() || !((LongRange) obj).isEmpty()) {
                LongRange longRange = (LongRange) obj;
                if (!(a() == longRange.a() && b() == longRange.b())) {
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
        return (int) ((((long) 31) * (a() ^ (a() >>> 32))) + (b() ^ (b() >>> 32)));
    }

    public boolean isEmpty() {
        return a() > b();
    }

    public String toString() {
        return a() + ".." + b();
    }
}
