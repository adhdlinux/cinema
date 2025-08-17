package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.AbstractSequentialList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

public final class Lists {

    private static class RandomAccessReverseList<T> extends ReverseList<T> implements RandomAccess {
        RandomAccessReverseList(List<T> list) {
            super(list);
        }
    }

    private static class ReverseList<T> extends AbstractList<T> {

        /* renamed from: b  reason: collision with root package name */
        private final List<T> f30555b;

        ReverseList(List<T> list) {
            this.f30555b = (List) Preconditions.l(list);
        }

        private int c(int i2) {
            int size = size();
            Preconditions.j(i2, size);
            return (size - 1) - i2;
        }

        /* access modifiers changed from: private */
        public int d(int i2) {
            int size = size();
            Preconditions.n(i2, size);
            return size - i2;
        }

        public void add(int i2, T t2) {
            this.f30555b.add(d(i2), t2);
        }

        /* access modifiers changed from: package-private */
        public List<T> b() {
            return this.f30555b;
        }

        public void clear() {
            this.f30555b.clear();
        }

        public T get(int i2) {
            return this.f30555b.get(c(i2));
        }

        public Iterator<T> iterator() {
            return listIterator();
        }

        public ListIterator<T> listIterator(int i2) {
            final ListIterator<T> listIterator = this.f30555b.listIterator(d(i2));
            return new ListIterator<T>() {

                /* renamed from: b  reason: collision with root package name */
                boolean f30556b;

                public void add(T t2) {
                    listIterator.add(t2);
                    listIterator.previous();
                    this.f30556b = false;
                }

                public boolean hasNext() {
                    return listIterator.hasPrevious();
                }

                public boolean hasPrevious() {
                    return listIterator.hasNext();
                }

                public T next() {
                    if (hasNext()) {
                        this.f30556b = true;
                        return listIterator.previous();
                    }
                    throw new NoSuchElementException();
                }

                public int nextIndex() {
                    return ReverseList.this.d(listIterator.nextIndex());
                }

                public T previous() {
                    if (hasPrevious()) {
                        this.f30556b = true;
                        return listIterator.next();
                    }
                    throw new NoSuchElementException();
                }

                public int previousIndex() {
                    return nextIndex() - 1;
                }

                public void remove() {
                    CollectPreconditions.c(this.f30556b);
                    listIterator.remove();
                    this.f30556b = false;
                }

                public void set(T t2) {
                    Preconditions.q(this.f30556b);
                    listIterator.set(t2);
                }
            };
        }

        public T remove(int i2) {
            return this.f30555b.remove(c(i2));
        }

        /* access modifiers changed from: protected */
        public void removeRange(int i2, int i3) {
            subList(i2, i3).clear();
        }

        public T set(int i2, T t2) {
            return this.f30555b.set(c(i2), t2);
        }

        public int size() {
            return this.f30555b.size();
        }

        public List<T> subList(int i2, int i3) {
            Preconditions.p(i2, i3, size());
            return Lists.reverse(this.f30555b.subList(d(i3), d(i2)));
        }
    }

    private static class TransformingRandomAccessList<F, T> extends AbstractList<T> implements RandomAccess, Serializable {

        /* renamed from: b  reason: collision with root package name */
        final List<F> f30559b;

        /* renamed from: c  reason: collision with root package name */
        final Function<? super F, ? extends T> f30560c;

        TransformingRandomAccessList(List<F> list, Function<? super F, ? extends T> function) {
            this.f30559b = (List) Preconditions.l(list);
            this.f30560c = (Function) Preconditions.l(function);
        }

        public T get(int i2) {
            return this.f30560c.apply(this.f30559b.get(i2));
        }

        public boolean isEmpty() {
            return this.f30559b.isEmpty();
        }

        public Iterator<T> iterator() {
            return listIterator();
        }

        public ListIterator<T> listIterator(int i2) {
            return new TransformedListIterator<F, T>(this.f30559b.listIterator(i2)) {
                /* access modifiers changed from: package-private */
                public T a(F f2) {
                    return TransformingRandomAccessList.this.f30560c.apply(f2);
                }
            };
        }

        public T remove(int i2) {
            return this.f30560c.apply(this.f30559b.remove(i2));
        }

        /* access modifiers changed from: protected */
        public void removeRange(int i2, int i3) {
            this.f30559b.subList(i2, i3).clear();
        }

        public int size() {
            return this.f30559b.size();
        }
    }

    private static class TransformingSequentialList<F, T> extends AbstractSequentialList<T> implements Serializable {

        /* renamed from: b  reason: collision with root package name */
        final List<F> f30562b;

        /* renamed from: c  reason: collision with root package name */
        final Function<? super F, ? extends T> f30563c;

        TransformingSequentialList(List<F> list, Function<? super F, ? extends T> function) {
            this.f30562b = (List) Preconditions.l(list);
            this.f30563c = (Function) Preconditions.l(function);
        }

        public ListIterator<T> listIterator(int i2) {
            return new TransformedListIterator<F, T>(this.f30562b.listIterator(i2)) {
                /* access modifiers changed from: package-private */
                public T a(F f2) {
                    return TransformingSequentialList.this.f30563c.apply(f2);
                }
            };
        }

        /* access modifiers changed from: protected */
        public void removeRange(int i2, int i3) {
            this.f30562b.subList(i2, i3).clear();
        }

        public int size() {
            return this.f30562b.size();
        }
    }

    private Lists() {
    }

    static <T> List<T> a(Iterable<T> iterable) {
        return (List) iterable;
    }

    static int b(int i2) {
        CollectPreconditions.b(i2, "arraySize");
        return Ints.m(((long) i2) + 5 + ((long) (i2 / 10)));
    }

    static boolean c(List<?> list, Object obj) {
        if (obj == Preconditions.l(list)) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        List list2 = (List) obj;
        int size = list.size();
        if (size != list2.size()) {
            return false;
        }
        if (!(list instanceof RandomAccess) || !(list2 instanceof RandomAccess)) {
            return Iterators.e(list.iterator(), list2.iterator());
        }
        for (int i2 = 0; i2 < size; i2++) {
            if (!Objects.a(list.get(i2), list2.get(i2))) {
                return false;
            }
        }
        return true;
    }

    static int d(List<?> list, Object obj) {
        if (list instanceof RandomAccess) {
            return e(list, obj);
        }
        ListIterator<?> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            if (Objects.a(obj, listIterator.next())) {
                return listIterator.previousIndex();
            }
        }
        return -1;
    }

    private static int e(List<?> list, Object obj) {
        int size = list.size();
        int i2 = 0;
        if (obj == null) {
            while (i2 < size) {
                if (list.get(i2) == null) {
                    return i2;
                }
                i2++;
            }
            return -1;
        }
        while (i2 < size) {
            if (obj.equals(list.get(i2))) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    static int f(List<?> list, Object obj) {
        if (list instanceof RandomAccess) {
            return g(list, obj);
        }
        ListIterator<?> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            if (Objects.a(obj, listIterator.previous())) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    private static int g(List<?> list, Object obj) {
        if (obj == null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                if (list.get(size) == null) {
                    return size;
                }
            }
            return -1;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            if (obj.equals(list.get(size2))) {
                return size2;
            }
        }
        return -1;
    }

    public static <E> ArrayList<E> h() {
        return new ArrayList<>();
    }

    public static <E> ArrayList<E> i(Iterator<? extends E> it2) {
        ArrayList<E> h2 = h();
        Iterators.a(h2, it2);
        return h2;
    }

    @SafeVarargs
    public static <E> ArrayList<E> j(E... eArr) {
        Preconditions.l(eArr);
        ArrayList<E> arrayList = new ArrayList<>(b(eArr.length));
        Collections.addAll(arrayList, eArr);
        return arrayList;
    }

    public static <E> ArrayList<E> k(int i2) {
        CollectPreconditions.b(i2, "initialArraySize");
        return new ArrayList<>(i2);
    }

    public static <F, T> List<T> l(List<F> list, Function<? super F, ? extends T> function) {
        if (list instanceof RandomAccess) {
            return new TransformingRandomAccessList(list, function);
        }
        return new TransformingSequentialList(list, function);
    }

    public static <T> List<T> reverse(List<T> list) {
        if (list instanceof ImmutableList) {
            return ((ImmutableList) list).x();
        }
        if (list instanceof ReverseList) {
            return ((ReverseList) list).b();
        }
        if (list instanceof RandomAccess) {
            return new RandomAccessReverseList(list);
        }
        return new ReverseList(list);
    }
}
