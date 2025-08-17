package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.collections.CharIterator;
import kotlin.jvm.internal.Intrinsics;

public final class CharProgressionIterator extends CharIterator {

    /* renamed from: b  reason: collision with root package name */
    private final int f40449b;

    /* renamed from: c  reason: collision with root package name */
    private final int f40450c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f40451d;

    /* renamed from: e  reason: collision with root package name */
    private int f40452e;

    public CharProgressionIterator(char c2, char c3, int i2) {
        this.f40449b = i2;
        this.f40450c = c3;
        boolean z2 = true;
        if (i2 <= 0 ? Intrinsics.h(c2, c3) < 0 : Intrinsics.h(c2, c3) > 0) {
            z2 = false;
        }
        this.f40451d = z2;
        this.f40452e = !z2 ? c3 : c2;
    }

    public char a() {
        int i2 = this.f40452e;
        if (i2 != this.f40450c) {
            this.f40452e = this.f40449b + i2;
        } else if (this.f40451d) {
            this.f40451d = false;
        } else {
            throw new NoSuchElementException();
        }
        return (char) i2;
    }

    public boolean hasNext() {
        return this.f40451d;
    }
}
