package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;

public final class Collections2 {

    static class FilteredCollection<E> extends AbstractCollection<E> {

        /* renamed from: b  reason: collision with root package name */
        final Collection<E> f30474b;

        /* renamed from: c  reason: collision with root package name */
        final Predicate<? super E> f30475c;

        FilteredCollection(Collection<E> collection, Predicate<? super E> predicate) {
            this.f30474b = collection;
            this.f30475c = predicate;
        }

        public boolean add(E e2) {
            Preconditions.d(this.f30475c.apply(e2));
            return this.f30474b.add(e2);
        }

        public boolean addAll(Collection<? extends E> collection) {
            for (Object apply : collection) {
                Preconditions.d(this.f30475c.apply(apply));
            }
            return this.f30474b.addAll(collection);
        }

        public void clear() {
            Iterables.h(this.f30474b, this.f30475c);
        }

        public boolean contains(Object obj) {
            if (Collections2.c(this.f30474b, obj)) {
                return this.f30475c.apply(obj);
            }
            return false;
        }

        public boolean containsAll(Collection<?> collection) {
            return Collections2.a(this, collection);
        }

        public boolean isEmpty() {
            return !Iterables.a(this.f30474b, this.f30475c);
        }

        public Iterator<E> iterator() {
            return Iterators.i(this.f30474b.iterator(), this.f30475c);
        }

        public boolean remove(Object obj) {
            return contains(obj) && this.f30474b.remove(obj);
        }

        public boolean removeAll(Collection<?> collection) {
            Iterator<E> it2 = this.f30474b.iterator();
            boolean z2 = false;
            while (it2.hasNext()) {
                E next = it2.next();
                if (this.f30475c.apply(next) && collection.contains(next)) {
                    it2.remove();
                    z2 = true;
                }
            }
            return z2;
        }

        public boolean retainAll(Collection<?> collection) {
            Iterator<E> it2 = this.f30474b.iterator();
            boolean z2 = false;
            while (it2.hasNext()) {
                E next = it2.next();
                if (this.f30475c.apply(next) && !collection.contains(next)) {
                    it2.remove();
                    z2 = true;
                }
            }
            return z2;
        }

        public int size() {
            int i2 = 0;
            for (E apply : this.f30474b) {
                if (this.f30475c.apply(apply)) {
                    i2++;
                }
            }
            return i2;
        }

        public Object[] toArray() {
            return Lists.i(iterator()).toArray();
        }

        public <T> T[] toArray(T[] tArr) {
            return Lists.i(iterator()).toArray(tArr);
        }
    }

    private Collections2() {
    }

    static boolean a(Collection<?> collection, Collection<?> collection2) {
        for (Object contains : collection2) {
            if (!collection.contains(contains)) {
                return false;
            }
        }
        return true;
    }

    static StringBuilder b(int i2) {
        CollectPreconditions.b(i2, "size");
        return new StringBuilder((int) Math.min(((long) i2) * 8, 1073741824));
    }

    static boolean c(Collection<?> collection, Object obj) {
        Preconditions.l(collection);
        try {
            return collection.contains(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }
}
