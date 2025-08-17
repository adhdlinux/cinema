package androidx.constraintlayout.solver;

class Pools$SimplePool<T> implements Pools$Pool<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Object[] f1815a;

    /* renamed from: b  reason: collision with root package name */
    private int f1816b;

    Pools$SimplePool(int i2) {
        if (i2 > 0) {
            this.f1815a = new Object[i2];
            return;
        }
        throw new IllegalArgumentException("The max pool size must be > 0");
    }

    public void a(T[] tArr, int i2) {
        if (i2 > tArr.length) {
            i2 = tArr.length;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            T t2 = tArr[i3];
            int i4 = this.f1816b;
            Object[] objArr = this.f1815a;
            if (i4 < objArr.length) {
                objArr[i4] = t2;
                this.f1816b = i4 + 1;
            }
        }
    }

    public T acquire() {
        int i2 = this.f1816b;
        if (i2 <= 0) {
            return null;
        }
        int i3 = i2 - 1;
        T[] tArr = this.f1815a;
        T t2 = tArr[i3];
        tArr[i3] = null;
        this.f1816b = i2 - 1;
        return t2;
    }

    public boolean release(T t2) {
        int i2 = this.f1816b;
        Object[] objArr = this.f1815a;
        if (i2 >= objArr.length) {
            return false;
        }
        objArr[i2] = t2;
        this.f1816b = i2 + 1;
        return true;
    }
}
