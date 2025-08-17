package kotlin.ranges;

import kotlin.collections.LongIterator;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;

public class LongProgression implements Iterable<Long>, KMappedMarker {

    /* renamed from: e  reason: collision with root package name */
    public static final Companion f40465e = new Companion((DefaultConstructorMarker) null);

    /* renamed from: b  reason: collision with root package name */
    private final long f40466b;

    /* renamed from: c  reason: collision with root package name */
    private final long f40467c;

    /* renamed from: d  reason: collision with root package name */
    private final long f40468d;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public LongProgression(long j2, long j3, long j4) {
        if (j4 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        } else if (j4 != Long.MIN_VALUE) {
            this.f40466b = j2;
            this.f40467c = ProgressionUtilKt.d(j2, j3, j4);
            this.f40468d = j4;
        } else {
            throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
        }
    }

    public final long a() {
        return this.f40466b;
    }

    public final long b() {
        return this.f40467c;
    }

    /* renamed from: d */
    public LongIterator iterator() {
        return new LongProgressionIterator(this.f40466b, this.f40467c, this.f40468d);
    }
}
