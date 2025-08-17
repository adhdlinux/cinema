package com.google.android.exoplayer2.source;

import android.util.SparseArray;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Consumer;

final class SpannedData<V> {

    /* renamed from: a  reason: collision with root package name */
    private int f25996a;

    /* renamed from: b  reason: collision with root package name */
    private final SparseArray<V> f25997b;

    /* renamed from: c  reason: collision with root package name */
    private final Consumer<V> f25998c;

    public SpannedData() {
        this(new u());
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void i(Object obj) {
    }

    public void b(int i2, V v2) {
        boolean z2;
        boolean z3 = false;
        if (this.f25996a == -1) {
            if (this.f25997b.size() == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            Assertions.g(z2);
            this.f25996a = 0;
        }
        if (this.f25997b.size() > 0) {
            SparseArray<V> sparseArray = this.f25997b;
            int keyAt = sparseArray.keyAt(sparseArray.size() - 1);
            if (i2 >= keyAt) {
                z3 = true;
            }
            Assertions.a(z3);
            if (keyAt == i2) {
                Consumer<V> consumer = this.f25998c;
                SparseArray<V> sparseArray2 = this.f25997b;
                consumer.accept(sparseArray2.valueAt(sparseArray2.size() - 1));
            }
        }
        this.f25997b.append(i2, v2);
    }

    public void c() {
        for (int i2 = 0; i2 < this.f25997b.size(); i2++) {
            this.f25998c.accept(this.f25997b.valueAt(i2));
        }
        this.f25996a = -1;
        this.f25997b.clear();
    }

    public void d(int i2) {
        int i3;
        int size = this.f25997b.size() - 1;
        while (size >= 0 && i2 < this.f25997b.keyAt(size)) {
            this.f25998c.accept(this.f25997b.valueAt(size));
            this.f25997b.removeAt(size);
            size--;
        }
        if (this.f25997b.size() > 0) {
            i3 = Math.min(this.f25996a, this.f25997b.size() - 1);
        } else {
            i3 = -1;
        }
        this.f25996a = i3;
    }

    public void e(int i2) {
        int i3 = 0;
        while (i3 < this.f25997b.size() - 1) {
            int i4 = i3 + 1;
            if (i2 >= this.f25997b.keyAt(i4)) {
                this.f25998c.accept(this.f25997b.valueAt(i3));
                this.f25997b.removeAt(i3);
                int i5 = this.f25996a;
                if (i5 > 0) {
                    this.f25996a = i5 - 1;
                }
                i3 = i4;
            } else {
                return;
            }
        }
    }

    public V f(int i2) {
        if (this.f25996a == -1) {
            this.f25996a = 0;
        }
        while (true) {
            int i3 = this.f25996a;
            if (i3 > 0 && i2 < this.f25997b.keyAt(i3)) {
                this.f25996a--;
            }
        }
        while (this.f25996a < this.f25997b.size() - 1 && i2 >= this.f25997b.keyAt(this.f25996a + 1)) {
            this.f25996a++;
        }
        return this.f25997b.valueAt(this.f25996a);
    }

    public V g() {
        SparseArray<V> sparseArray = this.f25997b;
        return sparseArray.valueAt(sparseArray.size() - 1);
    }

    public boolean h() {
        return this.f25997b.size() == 0;
    }

    public SpannedData(Consumer<V> consumer) {
        this.f25997b = new SparseArray<>();
        this.f25998c = consumer;
        this.f25996a = -1;
    }
}
