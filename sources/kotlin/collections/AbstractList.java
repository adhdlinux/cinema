package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

public abstract class AbstractList<E> extends AbstractCollection<E> implements List<E> {

    /* renamed from: b  reason: collision with root package name */
    public static final Companion f40302b = new Companion((DefaultConstructorMarker) null);

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(int i2, int i3, int i4) {
            if (i2 < 0 || i3 > i4) {
                throw new IndexOutOfBoundsException("startIndex: " + i2 + ", endIndex: " + i3 + ", size: " + i4);
            } else if (i2 > i3) {
                throw new IllegalArgumentException("startIndex: " + i2 + " > endIndex: " + i3);
            }
        }

        public final void b(int i2, int i3) {
            if (i2 < 0 || i2 >= i3) {
                throw new IndexOutOfBoundsException("index: " + i2 + ", size: " + i3);
            }
        }

        public final void c(int i2, int i3) {
            if (i2 < 0 || i2 > i3) {
                throw new IndexOutOfBoundsException("index: " + i2 + ", size: " + i3);
            }
        }

        public final void d(int i2, int i3, int i4) {
            if (i2 < 0 || i3 > i4) {
                throw new IndexOutOfBoundsException("fromIndex: " + i2 + ", toIndex: " + i3 + ", size: " + i4);
            } else if (i2 > i3) {
                throw new IllegalArgumentException("fromIndex: " + i2 + " > toIndex: " + i3);
            }
        }

        public final boolean e(Collection<?> collection, Collection<?> collection2) {
            Intrinsics.f(collection, "c");
            Intrinsics.f(collection2, "other");
            if (collection.size() != collection2.size()) {
                return false;
            }
            Iterator<?> it2 = collection2.iterator();
            for (Object a2 : collection) {
                if (!Intrinsics.a(a2, it2.next())) {
                    return false;
                }
            }
            return true;
        }

        public final int f(Collection<?> collection) {
            int i2;
            Intrinsics.f(collection, "c");
            int i3 = 1;
            for (Object next : collection) {
                int i4 = i3 * 31;
                if (next != null) {
                    i2 = next.hashCode();
                } else {
                    i2 = 0;
                }
                i3 = i4 + i2;
            }
            return i3;
        }
    }

    private class IteratorImpl implements Iterator<E>, KMappedMarker {

        /* renamed from: b  reason: collision with root package name */
        private int f40303b;

        public IteratorImpl() {
        }

        /* access modifiers changed from: protected */
        public final int a() {
            return this.f40303b;
        }

        /* access modifiers changed from: protected */
        public final void b(int i2) {
            this.f40303b = i2;
        }

        public boolean hasNext() {
            return this.f40303b < AbstractList.this.size();
        }

        public E next() {
            if (hasNext()) {
                AbstractList<E> abstractList = AbstractList.this;
                int i2 = this.f40303b;
                this.f40303b = i2 + 1;
                return abstractList.get(i2);
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    private class ListIteratorImpl extends AbstractList<E>.IteratorImpl implements ListIterator<E> {
        public ListIteratorImpl(int i2) {
            super();
            AbstractList.f40302b.c(i2, AbstractList.this.size());
            b(i2);
        }

        public void add(E e2) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public boolean hasPrevious() {
            return a() > 0;
        }

        public int nextIndex() {
            return a();
        }

        public E previous() {
            if (hasPrevious()) {
                AbstractList<E> abstractList = AbstractList.this;
                b(a() - 1);
                return abstractList.get(a());
            }
            throw new NoSuchElementException();
        }

        public int previousIndex() {
            return a() - 1;
        }

        public void set(E e2) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    private static final class SubList<E> extends AbstractList<E> implements RandomAccess {

        /* renamed from: c  reason: collision with root package name */
        private final AbstractList<E> f40306c;

        /* renamed from: d  reason: collision with root package name */
        private final int f40307d;

        /* renamed from: e  reason: collision with root package name */
        private int f40308e;

        public SubList(AbstractList<? extends E> abstractList, int i2, int i3) {
            Intrinsics.f(abstractList, "list");
            this.f40306c = abstractList;
            this.f40307d = i2;
            AbstractList.f40302b.d(i2, i3, abstractList.size());
            this.f40308e = i3 - i2;
        }

        public int a() {
            return this.f40308e;
        }

        public E get(int i2) {
            AbstractList.f40302b.b(i2, this.f40308e);
            return this.f40306c.get(this.f40307d + i2);
        }
    }

    protected AbstractList() {
    }

    public void add(int i2, E e2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(int i2, Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        return f40302b.e(this, (Collection) obj);
    }

    public abstract E get(int i2);

    public int hashCode() {
        return f40302b.f(this);
    }

    public int indexOf(E e2) {
        int i2 = 0;
        for (Object a2 : this) {
            if (Intrinsics.a(a2, e2)) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public Iterator<E> iterator() {
        return new IteratorImpl();
    }

    public int lastIndexOf(E e2) {
        ListIterator listIterator = listIterator(size());
        while (listIterator.hasPrevious()) {
            if (Intrinsics.a(listIterator.previous(), e2)) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    public ListIterator<E> listIterator() {
        return new ListIteratorImpl(0);
    }

    public E remove(int i2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public E set(int i2, E e2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public List<E> subList(int i2, int i3) {
        return new SubList(this, i2, i3);
    }

    public ListIterator<E> listIterator(int i2) {
        return new ListIteratorImpl(i2);
    }
}
