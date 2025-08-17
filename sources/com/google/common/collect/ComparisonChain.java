package com.google.common.collect;

import com.google.common.primitives.Booleans;
import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import java.util.Comparator;

public abstract class ComparisonChain {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final ComparisonChain f30500a = new ComparisonChain() {
        public ComparisonChain d(int i2, int i3) {
            return k(Ints.e(i2, i3));
        }

        public ComparisonChain e(long j2, long j3) {
            return k(Longs.a(j2, j3));
        }

        public <T> ComparisonChain f(T t2, T t3, Comparator<T> comparator) {
            return k(comparator.compare(t2, t3));
        }

        public ComparisonChain g(boolean z2, boolean z3) {
            return k(Booleans.a(z2, z3));
        }

        public ComparisonChain h(boolean z2, boolean z3) {
            return k(Booleans.a(z3, z2));
        }

        public int i() {
            return 0;
        }

        /* access modifiers changed from: package-private */
        public ComparisonChain k(int i2) {
            return i2 < 0 ? ComparisonChain.f30501b : i2 > 0 ? ComparisonChain.f30502c : ComparisonChain.f30500a;
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final ComparisonChain f30501b = new InactiveComparisonChain(-1);
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final ComparisonChain f30502c = new InactiveComparisonChain(1);

    private static final class InactiveComparisonChain extends ComparisonChain {

        /* renamed from: d  reason: collision with root package name */
        final int f30503d;

        InactiveComparisonChain(int i2) {
            super();
            this.f30503d = i2;
        }

        public ComparisonChain d(int i2, int i3) {
            return this;
        }

        public ComparisonChain e(long j2, long j3) {
            return this;
        }

        public <T> ComparisonChain f(T t2, T t3, Comparator<T> comparator) {
            return this;
        }

        public ComparisonChain g(boolean z2, boolean z3) {
            return this;
        }

        public ComparisonChain h(boolean z2, boolean z3) {
            return this;
        }

        public int i() {
            return this.f30503d;
        }
    }

    public static ComparisonChain j() {
        return f30500a;
    }

    public abstract ComparisonChain d(int i2, int i3);

    public abstract ComparisonChain e(long j2, long j3);

    public abstract <T> ComparisonChain f(T t2, T t3, Comparator<T> comparator);

    public abstract ComparisonChain g(boolean z2, boolean z3);

    public abstract ComparisonChain h(boolean z2, boolean z3);

    public abstract int i();

    private ComparisonChain() {
    }
}
