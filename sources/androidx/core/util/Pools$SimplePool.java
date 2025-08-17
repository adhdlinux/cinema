package androidx.core.util;

public class Pools$SimplePool<T> implements Pools$Pool<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Object[] f2723a;

    /* renamed from: b  reason: collision with root package name */
    private int f2724b;

    public Pools$SimplePool(int i2) {
        if (i2 > 0) {
            this.f2723a = new Object[i2];
            return;
        }
        throw new IllegalArgumentException("The max pool size must be > 0");
    }

    private boolean a(T t2) {
        for (int i2 = 0; i2 < this.f2724b; i2++) {
            if (this.f2723a[i2] == t2) {
                return true;
            }
        }
        return false;
    }

    public T acquire() {
        int i2 = this.f2724b;
        if (i2 <= 0) {
            return null;
        }
        int i3 = i2 - 1;
        T[] tArr = this.f2723a;
        T t2 = tArr[i3];
        tArr[i3] = null;
        this.f2724b = i2 - 1;
        return t2;
    }

    public boolean release(T t2) {
        if (!a(t2)) {
            int i2 = this.f2724b;
            Object[] objArr = this.f2723a;
            if (i2 >= objArr.length) {
                return false;
            }
            objArr[i2] = t2;
            this.f2724b = i2 + 1;
            return true;
        }
        throw new IllegalStateException("Already in the pool!");
    }
}
