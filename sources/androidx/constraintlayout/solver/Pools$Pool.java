package androidx.constraintlayout.solver;

interface Pools$Pool<T> {
    void a(T[] tArr, int i2);

    T acquire();

    boolean release(T t2);
}
