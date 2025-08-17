package com.google.android.exoplayer2.util;

import android.util.SparseBooleanArray;

public final class FlagSet {

    /* renamed from: a  reason: collision with root package name */
    private final SparseBooleanArray f28671a;

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final SparseBooleanArray f28672a = new SparseBooleanArray();

        /* renamed from: b  reason: collision with root package name */
        private boolean f28673b;

        public Builder a(int i2) {
            Assertions.g(!this.f28673b);
            this.f28672a.append(i2, true);
            return this;
        }

        public Builder b(FlagSet flagSet) {
            for (int i2 = 0; i2 < flagSet.d(); i2++) {
                a(flagSet.c(i2));
            }
            return this;
        }

        public Builder c(int... iArr) {
            for (int a2 : iArr) {
                a(a2);
            }
            return this;
        }

        public Builder d(int i2, boolean z2) {
            return z2 ? a(i2) : this;
        }

        public FlagSet e() {
            Assertions.g(!this.f28673b);
            this.f28673b = true;
            return new FlagSet(this.f28672a);
        }
    }

    public boolean a(int i2) {
        return this.f28671a.get(i2);
    }

    public boolean b(int... iArr) {
        for (int a2 : iArr) {
            if (a(a2)) {
                return true;
            }
        }
        return false;
    }

    public int c(int i2) {
        Assertions.c(i2, 0, d());
        return this.f28671a.keyAt(i2);
    }

    public int d() {
        return this.f28671a.size();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FlagSet)) {
            return false;
        }
        FlagSet flagSet = (FlagSet) obj;
        if (Util.f28808a >= 24) {
            return this.f28671a.equals(flagSet.f28671a);
        }
        if (d() != flagSet.d()) {
            return false;
        }
        for (int i2 = 0; i2 < d(); i2++) {
            if (c(i2) != flagSet.c(i2)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        if (Util.f28808a >= 24) {
            return this.f28671a.hashCode();
        }
        int d2 = d();
        for (int i2 = 0; i2 < d(); i2++) {
            d2 = (d2 * 31) + c(i2);
        }
        return d2;
    }

    private FlagSet(SparseBooleanArray sparseBooleanArray) {
        this.f28671a = sparseBooleanArray;
    }
}
