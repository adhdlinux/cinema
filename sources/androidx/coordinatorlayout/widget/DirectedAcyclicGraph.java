package androidx.coordinatorlayout.widget;

import androidx.collection.SimpleArrayMap;
import androidx.core.util.Pools$Pool;
import androidx.core.util.Pools$SimplePool;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public final class DirectedAcyclicGraph<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Pools$Pool<ArrayList<T>> f2259a = new Pools$SimplePool(10);

    /* renamed from: b  reason: collision with root package name */
    private final SimpleArrayMap<T, ArrayList<T>> f2260b = new SimpleArrayMap<>();

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList<T> f2261c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    private final HashSet<T> f2262d = new HashSet<>();

    private void e(T t2, ArrayList<T> arrayList, HashSet<T> hashSet) {
        if (!arrayList.contains(t2)) {
            if (!hashSet.contains(t2)) {
                hashSet.add(t2);
                ArrayList arrayList2 = this.f2260b.get(t2);
                if (arrayList2 != null) {
                    int size = arrayList2.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        e(arrayList2.get(i2), arrayList, hashSet);
                    }
                }
                hashSet.remove(t2);
                arrayList.add(t2);
                return;
            }
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
    }

    private ArrayList<T> f() {
        ArrayList<T> acquire = this.f2259a.acquire();
        if (acquire == null) {
            return new ArrayList<>();
        }
        return acquire;
    }

    private void k(ArrayList<T> arrayList) {
        arrayList.clear();
        this.f2259a.release(arrayList);
    }

    public void a(T t2, T t3) {
        if (!this.f2260b.containsKey(t2) || !this.f2260b.containsKey(t3)) {
            throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
        }
        ArrayList arrayList = this.f2260b.get(t2);
        if (arrayList == null) {
            arrayList = f();
            this.f2260b.put(t2, arrayList);
        }
        arrayList.add(t3);
    }

    public void b(T t2) {
        if (!this.f2260b.containsKey(t2)) {
            this.f2260b.put(t2, null);
        }
    }

    public void c() {
        int size = this.f2260b.size();
        for (int i2 = 0; i2 < size; i2++) {
            ArrayList n2 = this.f2260b.n(i2);
            if (n2 != null) {
                k(n2);
            }
        }
        this.f2260b.clear();
    }

    public boolean d(T t2) {
        return this.f2260b.containsKey(t2);
    }

    public List g(T t2) {
        return this.f2260b.get(t2);
    }

    public List<T> h(T t2) {
        int size = this.f2260b.size();
        ArrayList arrayList = null;
        for (int i2 = 0; i2 < size; i2++) {
            ArrayList n2 = this.f2260b.n(i2);
            if (n2 != null && n2.contains(t2)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(this.f2260b.j(i2));
            }
        }
        return arrayList;
    }

    public ArrayList<T> i() {
        this.f2261c.clear();
        this.f2262d.clear();
        int size = this.f2260b.size();
        for (int i2 = 0; i2 < size; i2++) {
            e(this.f2260b.j(i2), this.f2261c, this.f2262d);
        }
        return this.f2261c;
    }

    public boolean j(T t2) {
        int size = this.f2260b.size();
        for (int i2 = 0; i2 < size; i2++) {
            ArrayList n2 = this.f2260b.n(i2);
            if (n2 != null && n2.contains(t2)) {
                return true;
            }
        }
        return false;
    }
}
