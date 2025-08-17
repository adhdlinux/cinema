package com.applovin.impl.sdk.utils;

import java.lang.Comparable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.RandomAccess;
import java.util.Set;

public class l<T extends Comparable<? super T>> implements RandomAccess, Set<T> {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<T> f15894a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private final HashSet<T> f15895b = new HashSet<>();

    public T a() {
        return (Comparable) this.f15894a.get(size() - 1);
    }

    public T a(int i2) {
        return (Comparable) this.f15894a.get(i2);
    }

    public void a(int i2, T t2) {
        this.f15895b.remove((Comparable) this.f15894a.get(i2));
        this.f15894a.set(i2, t2);
        this.f15895b.add(t2);
    }

    /* renamed from: a */
    public boolean add(T t2) {
        if (contains(t2)) {
            return false;
        }
        if (isEmpty() || t2.compareTo(a()) > 0) {
            this.f15894a.add(t2);
        } else {
            this.f15894a.add(c(t2), t2);
        }
        return this.f15895b.add(t2);
    }

    public boolean addAll(Collection<? extends T> collection) {
        Iterator<? extends T> it2 = collection.iterator();
        while (true) {
            boolean z2 = false;
            while (true) {
                if (!it2.hasNext()) {
                    return z2;
                }
                if (add((Comparable) it2.next()) || z2) {
                    z2 = true;
                }
            }
        }
    }

    public int b(T t2) {
        if (t2 == null || !contains(t2)) {
            return -1;
        }
        return c(t2);
    }

    public T b(int i2) {
        T t2 = (Comparable) this.f15894a.remove(i2);
        this.f15895b.remove(t2);
        return t2;
    }

    public int c(T t2) {
        int binarySearch = Collections.binarySearch(this.f15894a, t2);
        if (binarySearch < 0) {
            return ~binarySearch;
        }
        Comparable a2 = a(binarySearch);
        while (binarySearch >= 0 && a2 == a(binarySearch)) {
            binarySearch--;
        }
        return binarySearch + 1;
    }

    public void clear() {
        this.f15894a.clear();
        this.f15895b.clear();
    }

    public boolean contains(Object obj) {
        return this.f15895b.contains(obj);
    }

    public boolean containsAll(Collection<?> collection) {
        return this.f15895b.containsAll(collection);
    }

    public int d(T t2) {
        int binarySearch = Collections.binarySearch(this.f15894a, t2);
        if (binarySearch < 0) {
            return ~binarySearch;
        }
        Comparable a2 = a(binarySearch);
        while (binarySearch < size() && a2 == a(binarySearch)) {
            binarySearch++;
        }
        return binarySearch;
    }

    public boolean isEmpty() {
        return this.f15894a.isEmpty();
    }

    public Iterator<T> iterator() {
        return this.f15894a.iterator();
    }

    public boolean remove(Object obj) {
        int b2 = b((Comparable) obj);
        if (b2 == -1) {
            return false;
        }
        this.f15894a.remove(b2);
        return this.f15895b.remove(obj);
    }

    public boolean removeAll(Collection<?> collection) {
        Iterator<?> it2 = collection.iterator();
        while (true) {
            boolean z2 = false;
            while (true) {
                if (!it2.hasNext()) {
                    return false;
                }
                Object next = it2.next();
                if (z2 || remove(next)) {
                    z2 = true;
                }
            }
        }
    }

    public boolean retainAll(Collection<?> collection) {
        boolean z2 = false;
        for (int size = size() - 1; size >= 0; size--) {
            Comparable comparable = (Comparable) this.f15894a.get(size);
            if (!collection.contains(comparable)) {
                this.f15894a.remove(size);
                this.f15895b.remove(comparable);
                z2 = true;
            }
        }
        return z2;
    }

    public int size() {
        return this.f15894a.size();
    }

    public Object[] toArray() {
        return this.f15894a.toArray();
    }

    public <T1> T1[] toArray(T1[] t1Arr) {
        return this.f15894a.toArray(t1Arr);
    }
}
