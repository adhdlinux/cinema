package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.collections.IntIterator;

public final class IntProgressionIterator extends IntIterator {

    /* renamed from: b  reason: collision with root package name */
    private final int f40459b;

    /* renamed from: c  reason: collision with root package name */
    private final int f40460c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f40461d;

    /* renamed from: e  reason: collision with root package name */
    private int f40462e;

    public IntProgressionIterator(int i2, int i3, int i4) {
        this.f40459b = i4;
        this.f40460c = i3;
        boolean z2 = true;
        if (i4 <= 0 ? i2 < i3 : i2 > i3) {
            z2 = false;
        }
        this.f40461d = z2;
        this.f40462e = !z2 ? i3 : i2;
    }

    public boolean hasNext() {
        return this.f40461d;
    }

    public int nextInt() {
        int i2 = this.f40462e;
        if (i2 != this.f40460c) {
            this.f40462e = this.f40459b + i2;
        } else if (this.f40461d) {
            this.f40461d = false;
        } else {
            throw new NoSuchElementException();
        }
        return i2;
    }
}
