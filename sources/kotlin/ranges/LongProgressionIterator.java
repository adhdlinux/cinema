package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.collections.LongIterator;

public final class LongProgressionIterator extends LongIterator {

    /* renamed from: b  reason: collision with root package name */
    private final long f40469b;

    /* renamed from: c  reason: collision with root package name */
    private final long f40470c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f40471d;

    /* renamed from: e  reason: collision with root package name */
    private long f40472e;

    public LongProgressionIterator(long j2, long j3, long j4) {
        this.f40469b = j4;
        this.f40470c = j3;
        boolean z2 = true;
        int i2 = (j4 > 0 ? 1 : (j4 == 0 ? 0 : -1));
        int i3 = (j2 > j3 ? 1 : (j2 == j3 ? 0 : -1));
        if (i2 <= 0 ? i3 < 0 : i3 > 0) {
            z2 = false;
        }
        this.f40471d = z2;
        this.f40472e = !z2 ? j3 : j2;
    }

    public boolean hasNext() {
        return this.f40471d;
    }

    public long nextLong() {
        long j2 = this.f40472e;
        if (j2 != this.f40470c) {
            this.f40472e = this.f40469b + j2;
        } else if (this.f40471d) {
            this.f40471d = false;
        } else {
            throw new NoSuchElementException();
        }
        return j2;
    }
}
