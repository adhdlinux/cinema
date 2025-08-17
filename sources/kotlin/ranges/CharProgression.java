package kotlin.ranges;

import kotlin.collections.CharIterator;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;

public class CharProgression implements Iterable<Character>, KMappedMarker {

    /* renamed from: e  reason: collision with root package name */
    public static final Companion f40445e = new Companion((DefaultConstructorMarker) null);

    /* renamed from: b  reason: collision with root package name */
    private final char f40446b;

    /* renamed from: c  reason: collision with root package name */
    private final char f40447c;

    /* renamed from: d  reason: collision with root package name */
    private final int f40448d;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public CharProgression(char c2, char c3, int i2) {
        if (i2 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        } else if (i2 != Integer.MIN_VALUE) {
            this.f40446b = c2;
            this.f40447c = (char) ProgressionUtilKt.c(c2, c3, i2);
            this.f40448d = i2;
        } else {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
    }

    public final char a() {
        return this.f40446b;
    }

    public final char b() {
        return this.f40447c;
    }

    /* renamed from: d */
    public CharIterator iterator() {
        return new CharProgressionIterator(this.f40446b, this.f40447c, this.f40448d);
    }
}
