package kotlin.ranges;

import kotlin.collections.IntIterator;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;

public class IntProgression implements Iterable<Integer>, KMappedMarker {

    /* renamed from: e  reason: collision with root package name */
    public static final Companion f40455e = new Companion((DefaultConstructorMarker) null);

    /* renamed from: b  reason: collision with root package name */
    private final int f40456b;

    /* renamed from: c  reason: collision with root package name */
    private final int f40457c;

    /* renamed from: d  reason: collision with root package name */
    private final int f40458d;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final IntProgression a(int i2, int i3, int i4) {
            return new IntProgression(i2, i3, i4);
        }
    }

    public IntProgression(int i2, int i3, int i4) {
        if (i4 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        } else if (i4 != Integer.MIN_VALUE) {
            this.f40456b = i2;
            this.f40457c = ProgressionUtilKt.c(i2, i3, i4);
            this.f40458d = i4;
        } else {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
    }

    public final int a() {
        return this.f40456b;
    }

    public final int b() {
        return this.f40457c;
    }

    public final int d() {
        return this.f40458d;
    }

    /* renamed from: e */
    public IntIterator iterator() {
        return new IntProgressionIterator(this.f40456b, this.f40457c, this.f40458d);
    }

    public boolean equals(Object obj) {
        if (obj instanceof IntProgression) {
            if (!isEmpty() || !((IntProgression) obj).isEmpty()) {
                IntProgression intProgression = (IntProgression) obj;
                if (!(this.f40456b == intProgression.f40456b && this.f40457c == intProgression.f40457c && this.f40458d == intProgression.f40458d)) {
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
        return (((this.f40456b * 31) + this.f40457c) * 31) + this.f40458d;
    }

    public boolean isEmpty() {
        if (this.f40458d > 0) {
            if (this.f40456b > this.f40457c) {
                return true;
            }
        } else if (this.f40456b < this.f40457c) {
            return true;
        }
        return false;
    }

    public String toString() {
        int i2;
        StringBuilder sb;
        if (this.f40458d > 0) {
            sb = new StringBuilder();
            sb.append(this.f40456b);
            sb.append("..");
            sb.append(this.f40457c);
            sb.append(" step ");
            i2 = this.f40458d;
        } else {
            sb = new StringBuilder();
            sb.append(this.f40456b);
            sb.append(" downTo ");
            sb.append(this.f40457c);
            sb.append(" step ");
            i2 = -this.f40458d;
        }
        sb.append(i2);
        return sb.toString();
    }
}
