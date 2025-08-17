package androidx.media3.exoplayer.source;

import android.util.SparseArray;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Consumer;

final class SpannedData<V> {

    /* renamed from: a  reason: collision with root package name */
    private int f7167a;

    /* renamed from: b  reason: collision with root package name */
    private final SparseArray<V> f7168b;

    /* renamed from: c  reason: collision with root package name */
    private final Consumer<V> f7169c;

    public SpannedData() {
        this(new y());
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void i(Object obj) {
    }

    public void b(int i2, V v2) {
        boolean z2;
        boolean z3 = false;
        if (this.f7167a == -1) {
            if (this.f7168b.size() == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            Assertions.h(z2);
            this.f7167a = 0;
        }
        if (this.f7168b.size() > 0) {
            SparseArray<V> sparseArray = this.f7168b;
            int keyAt = sparseArray.keyAt(sparseArray.size() - 1);
            if (i2 >= keyAt) {
                z3 = true;
            }
            Assertions.a(z3);
            if (keyAt == i2) {
                Consumer<V> consumer = this.f7169c;
                SparseArray<V> sparseArray2 = this.f7168b;
                consumer.accept(sparseArray2.valueAt(sparseArray2.size() - 1));
            }
        }
        this.f7168b.append(i2, v2);
    }

    public void c() {
        for (int i2 = 0; i2 < this.f7168b.size(); i2++) {
            this.f7169c.accept(this.f7168b.valueAt(i2));
        }
        this.f7167a = -1;
        this.f7168b.clear();
    }

    public void d(int i2) {
        int i3;
        int size = this.f7168b.size() - 1;
        while (size >= 0 && i2 < this.f7168b.keyAt(size)) {
            this.f7169c.accept(this.f7168b.valueAt(size));
            this.f7168b.removeAt(size);
            size--;
        }
        if (this.f7168b.size() > 0) {
            i3 = Math.min(this.f7167a, this.f7168b.size() - 1);
        } else {
            i3 = -1;
        }
        this.f7167a = i3;
    }

    public void e(int i2) {
        int i3 = 0;
        while (i3 < this.f7168b.size() - 1) {
            int i4 = i3 + 1;
            if (i2 >= this.f7168b.keyAt(i4)) {
                this.f7169c.accept(this.f7168b.valueAt(i3));
                this.f7168b.removeAt(i3);
                int i5 = this.f7167a;
                if (i5 > 0) {
                    this.f7167a = i5 - 1;
                }
                i3 = i4;
            } else {
                return;
            }
        }
    }

    public V f(int i2) {
        if (this.f7167a == -1) {
            this.f7167a = 0;
        }
        while (true) {
            int i3 = this.f7167a;
            if (i3 > 0 && i2 < this.f7168b.keyAt(i3)) {
                this.f7167a--;
            }
        }
        while (this.f7167a < this.f7168b.size() - 1 && i2 >= this.f7168b.keyAt(this.f7167a + 1)) {
            this.f7167a++;
        }
        return this.f7168b.valueAt(this.f7167a);
    }

    public V g() {
        SparseArray<V> sparseArray = this.f7168b;
        return sparseArray.valueAt(sparseArray.size() - 1);
    }

    public boolean h() {
        return this.f7168b.size() == 0;
    }

    public SpannedData(Consumer<V> consumer) {
        this.f7168b = new SparseArray<>();
        this.f7169c = consumer;
        this.f7167a = -1;
    }
}
