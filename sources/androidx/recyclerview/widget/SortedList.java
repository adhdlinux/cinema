package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import java.lang.reflect.Array;
import java.util.Comparator;

public class SortedList<T> {

    /* renamed from: a  reason: collision with root package name */
    T[] f11308a;

    /* renamed from: b  reason: collision with root package name */
    private T[] f11309b;

    /* renamed from: c  reason: collision with root package name */
    private int f11310c;

    /* renamed from: d  reason: collision with root package name */
    private int f11311d;

    /* renamed from: e  reason: collision with root package name */
    private Callback f11312e;

    /* renamed from: f  reason: collision with root package name */
    private BatchedCallback f11313f;

    /* renamed from: g  reason: collision with root package name */
    private int f11314g = 0;

    /* renamed from: h  reason: collision with root package name */
    private final Class<T> f11315h;

    public static class BatchedCallback<T2> extends Callback<T2> {

        /* renamed from: b  reason: collision with root package name */
        final Callback<T2> f11316b;

        /* renamed from: c  reason: collision with root package name */
        private final BatchingListUpdateCallback f11317c;

        @SuppressLint({"UnknownNullness"})
        public BatchedCallback(Callback<T2> callback) {
            this.f11316b = callback;
            this.f11317c = new BatchingListUpdateCallback(callback);
        }

        public void a(int i2, int i3) {
            this.f11317c.a(i2, i3);
        }

        public void b(int i2, int i3) {
            this.f11317c.b(i2, i3);
        }

        @SuppressLint({"UnknownNullness"})
        public void c(int i2, int i3, Object obj) {
            this.f11317c.c(i2, i3, obj);
        }

        public int compare(T2 t2, T2 t22) {
            return this.f11316b.compare(t2, t22);
        }

        public void d(int i2, int i3) {
            this.f11317c.d(i2, i3);
        }

        public boolean e(T2 t2, T2 t22) {
            return this.f11316b.e(t2, t22);
        }

        public boolean f(T2 t2, T2 t22) {
            return this.f11316b.f(t2, t22);
        }

        public Object g(T2 t2, T2 t22) {
            return this.f11316b.g(t2, t22);
        }

        public void h(int i2, int i3) {
            this.f11317c.c(i2, i3, (Object) null);
        }

        public void i() {
            this.f11317c.e();
        }
    }

    public static abstract class Callback<T2> implements Comparator<T2>, ListUpdateCallback {
        @SuppressLint({"UnknownNullness"})
        public void c(int i2, int i3, Object obj) {
            h(i2, i3);
        }

        public abstract int compare(T2 t2, T2 t22);

        public abstract boolean e(T2 t2, T2 t22);

        public abstract boolean f(T2 t2, T2 t22);

        public Object g(T2 t2, T2 t22) {
            return null;
        }

        public abstract void h(int i2, int i3);
    }

    public SortedList(Class<T> cls, Callback<T> callback, int i2) {
        this.f11315h = cls;
        this.f11308a = (Object[]) Array.newInstance(cls, i2);
        this.f11312e = callback;
    }

    private int b(T t2, boolean z2) {
        int f2 = f(t2, this.f11308a, 0, this.f11314g, 1);
        if (f2 == -1) {
            f2 = 0;
        } else if (f2 < this.f11314g) {
            T t3 = this.f11308a[f2];
            if (this.f11312e.f(t3, t2)) {
                if (this.f11312e.e(t3, t2)) {
                    this.f11308a[f2] = t2;
                    return f2;
                }
                this.f11308a[f2] = t2;
                Callback callback = this.f11312e;
                callback.c(f2, 1, callback.g(t3, t2));
                return f2;
            }
        }
        c(f2, t2);
        if (z2) {
            this.f11312e.a(f2, 1);
        }
        return f2;
    }

    private void c(int i2, T t2) {
        int i3 = this.f11314g;
        if (i2 <= i3) {
            T[] tArr = this.f11308a;
            if (i3 == tArr.length) {
                T[] tArr2 = (Object[]) Array.newInstance(this.f11315h, tArr.length + 10);
                System.arraycopy(this.f11308a, 0, tArr2, 0, i2);
                tArr2[i2] = t2;
                System.arraycopy(this.f11308a, i2, tArr2, i2 + 1, this.f11314g - i2);
                this.f11308a = tArr2;
            } else {
                System.arraycopy(tArr, i2, tArr, i2 + 1, i3 - i2);
                this.f11308a[i2] = t2;
            }
            this.f11314g++;
            return;
        }
        throw new IndexOutOfBoundsException("cannot add item to " + i2 + " because size is " + this.f11314g);
    }

    private int f(T t2, T[] tArr, int i2, int i3, int i4) {
        while (i2 < i3) {
            int i5 = (i2 + i3) / 2;
            T t3 = tArr[i5];
            int compare = this.f11312e.compare(t3, t2);
            if (compare < 0) {
                i2 = i5 + 1;
            } else if (compare != 0) {
                i3 = i5;
            } else if (this.f11312e.f(t3, t2)) {
                return i5;
            } else {
                int h2 = h(t2, i5, i2, i3);
                if (i4 != 1) {
                    return h2;
                }
                if (h2 == -1) {
                    return i5;
                }
                return h2;
            }
        }
        if (i4 == 1) {
            return i2;
        }
        return -1;
    }

    private int h(T t2, int i2, int i3, int i4) {
        T t3;
        int i5 = i2 - 1;
        while (i5 >= i3) {
            T t4 = this.f11308a[i5];
            if (this.f11312e.compare(t4, t2) != 0) {
                break;
            } else if (this.f11312e.f(t4, t2)) {
                return i5;
            } else {
                i5--;
            }
        }
        do {
            i2++;
            if (i2 >= i4) {
                return -1;
            }
            t3 = this.f11308a[i2];
            if (this.f11312e.compare(t3, t2) != 0) {
                return -1;
            }
        } while (!this.f11312e.f(t3, t2));
        return i2;
    }

    private void j() {
        if (this.f11309b != null) {
            throw new IllegalStateException("Data cannot be mutated in the middle of a batch update operation such as addAll or replaceAll.");
        }
    }

    public int a(T t2) {
        j();
        return b(t2, true);
    }

    public void d() {
        j();
        Callback callback = this.f11312e;
        if (!(callback instanceof BatchedCallback)) {
            if (this.f11313f == null) {
                this.f11313f = new BatchedCallback(callback);
            }
            this.f11312e = this.f11313f;
        }
    }

    public void e() {
        j();
        Callback callback = this.f11312e;
        if (callback instanceof BatchedCallback) {
            ((BatchedCallback) callback).i();
        }
        Callback callback2 = this.f11312e;
        BatchedCallback batchedCallback = this.f11313f;
        if (callback2 == batchedCallback) {
            this.f11312e = batchedCallback.f11316b;
        }
    }

    public T g(int i2) throws IndexOutOfBoundsException {
        int i3;
        if (i2 >= this.f11314g || i2 < 0) {
            throw new IndexOutOfBoundsException("Asked to get item at " + i2 + " but size is " + this.f11314g);
        }
        T[] tArr = this.f11309b;
        if (tArr == null || i2 < (i3 = this.f11311d)) {
            return this.f11308a[i2];
        }
        return tArr[(i2 - i3) + this.f11310c];
    }

    public int i() {
        return this.f11314g;
    }
}
