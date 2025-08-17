package io.reactivex.internal.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.concurrent.atomic.AtomicInteger;

public final class VolatileSizeArrayList<T> extends AtomicInteger implements List<T>, RandomAccess {

    /* renamed from: b  reason: collision with root package name */
    final ArrayList<T> f40078b = new ArrayList<>();

    public boolean add(T t2) {
        boolean add = this.f40078b.add(t2);
        lazySet(this.f40078b.size());
        return add;
    }

    public boolean addAll(Collection<? extends T> collection) {
        boolean addAll = this.f40078b.addAll(collection);
        lazySet(this.f40078b.size());
        return addAll;
    }

    public void clear() {
        this.f40078b.clear();
        lazySet(0);
    }

    public boolean contains(Object obj) {
        return this.f40078b.contains(obj);
    }

    public boolean containsAll(Collection<?> collection) {
        return this.f40078b.containsAll(collection);
    }

    public boolean equals(Object obj) {
        if (obj instanceof VolatileSizeArrayList) {
            return this.f40078b.equals(((VolatileSizeArrayList) obj).f40078b);
        }
        return this.f40078b.equals(obj);
    }

    public T get(int i2) {
        return this.f40078b.get(i2);
    }

    public int hashCode() {
        return this.f40078b.hashCode();
    }

    public int indexOf(Object obj) {
        return this.f40078b.indexOf(obj);
    }

    public boolean isEmpty() {
        return get() == 0;
    }

    public Iterator<T> iterator() {
        return this.f40078b.iterator();
    }

    public int lastIndexOf(Object obj) {
        return this.f40078b.lastIndexOf(obj);
    }

    public ListIterator<T> listIterator() {
        return this.f40078b.listIterator();
    }

    public boolean remove(Object obj) {
        boolean remove = this.f40078b.remove(obj);
        lazySet(this.f40078b.size());
        return remove;
    }

    public boolean removeAll(Collection<?> collection) {
        boolean removeAll = this.f40078b.removeAll(collection);
        lazySet(this.f40078b.size());
        return removeAll;
    }

    public boolean retainAll(Collection<?> collection) {
        boolean retainAll = this.f40078b.retainAll(collection);
        lazySet(this.f40078b.size());
        return retainAll;
    }

    public T set(int i2, T t2) {
        return this.f40078b.set(i2, t2);
    }

    public int size() {
        return get();
    }

    public List<T> subList(int i2, int i3) {
        return this.f40078b.subList(i2, i3);
    }

    public Object[] toArray() {
        return this.f40078b.toArray();
    }

    public String toString() {
        return this.f40078b.toString();
    }

    public ListIterator<T> listIterator(int i2) {
        return this.f40078b.listIterator(i2);
    }

    public <E> E[] toArray(E[] eArr) {
        return this.f40078b.toArray(eArr);
    }

    public void add(int i2, T t2) {
        this.f40078b.add(i2, t2);
        lazySet(this.f40078b.size());
    }

    public boolean addAll(int i2, Collection<? extends T> collection) {
        boolean addAll = this.f40078b.addAll(i2, collection);
        lazySet(this.f40078b.size());
        return addAll;
    }

    public T remove(int i2) {
        T remove = this.f40078b.remove(i2);
        lazySet(this.f40078b.size());
        return remove;
    }
}
