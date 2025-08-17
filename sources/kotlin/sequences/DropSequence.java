package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

public final class DropSequence<T> implements Sequence<T>, DropTakeSequence<T> {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Sequence<T> f40492a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final int f40493b;

    public DropSequence(Sequence<? extends T> sequence, int i2) {
        boolean z2;
        Intrinsics.f(sequence, "sequence");
        this.f40492a = sequence;
        this.f40493b = i2;
        if (i2 >= 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            throw new IllegalArgumentException(("count must be non-negative, but was " + i2 + '.').toString());
        }
    }

    public Sequence<T> a(int i2) {
        int i3 = this.f40493b + i2;
        return i3 < 0 ? new DropSequence(this, i2) : new DropSequence(this.f40492a, i3);
    }

    public Iterator<T> iterator() {
        return new DropSequence$iterator$1(this);
    }
}
