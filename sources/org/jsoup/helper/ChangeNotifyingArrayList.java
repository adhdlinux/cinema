package org.jsoup.helper;

import java.util.ArrayList;
import java.util.Collection;

public abstract class ChangeNotifyingArrayList<E> extends ArrayList<E> {
    public ChangeNotifyingArrayList(int i2) {
        super(i2);
    }

    public abstract void a();

    public boolean add(E e2) {
        a();
        return super.add(e2);
    }

    public boolean addAll(Collection<? extends E> collection) {
        a();
        return super.addAll(collection);
    }

    public void clear() {
        a();
        super.clear();
    }

    public E remove(int i2) {
        a();
        return super.remove(i2);
    }

    public boolean removeAll(Collection<?> collection) {
        a();
        return super.removeAll(collection);
    }

    /* access modifiers changed from: protected */
    public void removeRange(int i2, int i3) {
        a();
        super.removeRange(i2, i3);
    }

    public boolean retainAll(Collection<?> collection) {
        a();
        return super.retainAll(collection);
    }

    public E set(int i2, E e2) {
        a();
        return super.set(i2, e2);
    }

    public void add(int i2, E e2) {
        a();
        super.add(i2, e2);
    }

    public boolean addAll(int i2, Collection<? extends E> collection) {
        a();
        return super.addAll(i2, collection);
    }

    public boolean remove(Object obj) {
        a();
        return super.remove(obj);
    }
}
