package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;

public final class Sets {

    /* renamed from: com.google.common.collect.Sets$1  reason: invalid class name */
    class AnonymousClass1 extends SetView<Object> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Set f30665b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Set f30666c;

        /* renamed from: a */
        public UnmodifiableIterator<Object> iterator() {
            return new AbstractIterator<Object>() {

                /* renamed from: d  reason: collision with root package name */
                final Iterator<Object> f30667d;

                /* renamed from: e  reason: collision with root package name */
                final Iterator<Object> f30668e;

                {
                    this.f30667d = AnonymousClass1.this.f30665b.iterator();
                    this.f30668e = AnonymousClass1.this.f30666c.iterator();
                }

                /* access modifiers changed from: protected */
                public Object a() {
                    if (this.f30667d.hasNext()) {
                        return this.f30667d.next();
                    }
                    while (this.f30668e.hasNext()) {
                        Object next = this.f30668e.next();
                        if (!AnonymousClass1.this.f30665b.contains(next)) {
                            return next;
                        }
                    }
                    return b();
                }
            };
        }

        public boolean contains(Object obj) {
            return this.f30665b.contains(obj) || this.f30666c.contains(obj);
        }

        public boolean isEmpty() {
            return this.f30665b.isEmpty() && this.f30666c.isEmpty();
        }

        public int size() {
            int size = this.f30665b.size();
            for (Object contains : this.f30666c) {
                if (!this.f30665b.contains(contains)) {
                    size++;
                }
            }
            return size;
        }
    }

    private static class FilteredSet<E> extends Collections2.FilteredCollection<E> implements Set<E> {
        FilteredSet(Set<E> set, Predicate<? super E> predicate) {
            super(set, predicate);
        }

        public boolean equals(Object obj) {
            return Sets.a(this, obj);
        }

        public int hashCode() {
            return Sets.d(this);
        }
    }

    private static class FilteredSortedSet<E> extends FilteredSet<E> implements SortedSet<E> {
        FilteredSortedSet(SortedSet<E> sortedSet, Predicate<? super E> predicate) {
            super(sortedSet, predicate);
        }

        public Comparator<? super E> comparator() {
            return ((SortedSet) this.f30474b).comparator();
        }

        public E first() {
            return Iterators.j(this.f30474b.iterator(), this.f30475c);
        }

        public SortedSet<E> headSet(E e2) {
            return new FilteredSortedSet(((SortedSet) this.f30474b).headSet(e2), this.f30475c);
        }

        public E last() {
            SortedSet sortedSet = (SortedSet) this.f30474b;
            while (true) {
                E last = sortedSet.last();
                if (this.f30475c.apply(last)) {
                    return last;
                }
                sortedSet = sortedSet.headSet(last);
            }
        }

        public SortedSet<E> subSet(E e2, E e3) {
            return new FilteredSortedSet(((SortedSet) this.f30474b).subSet(e2, e3), this.f30475c);
        }

        public SortedSet<E> tailSet(E e2) {
            return new FilteredSortedSet(((SortedSet) this.f30474b).tailSet(e2), this.f30475c);
        }
    }

    static abstract class ImprovedAbstractSet<E> extends AbstractSet<E> {
        ImprovedAbstractSet() {
        }

        public boolean removeAll(Collection<?> collection) {
            return Sets.i(this, collection);
        }

        public boolean retainAll(Collection<?> collection) {
            return super.retainAll((Collection) Preconditions.l(collection));
        }
    }

    public static abstract class SetView<E> extends AbstractSet<E> {
        /* synthetic */ SetView(AnonymousClass1 r12) {
            this();
        }

        /* renamed from: a */
        public abstract UnmodifiableIterator<E> iterator();

        @Deprecated
        public final boolean add(E e2) {
            throw new UnsupportedOperationException();
        }

        @Deprecated
        public final boolean addAll(Collection<? extends E> collection) {
            throw new UnsupportedOperationException();
        }

        @Deprecated
        public final void clear() {
            throw new UnsupportedOperationException();
        }

        @Deprecated
        public final boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Deprecated
        public final boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Deprecated
        public final boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        private SetView() {
        }
    }

    private Sets() {
    }

    static boolean a(Set<?> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() != set2.size() || !set.containsAll(set2)) {
                    return false;
                }
                return true;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public static <E> Set<E> b(Set<E> set, Predicate<? super E> predicate) {
        if (set instanceof SortedSet) {
            return c((SortedSet) set, predicate);
        }
        if (!(set instanceof FilteredSet)) {
            return new FilteredSet((Set) Preconditions.l(set), (Predicate) Preconditions.l(predicate));
        }
        FilteredSet filteredSet = (FilteredSet) set;
        return new FilteredSet((Set) filteredSet.f30474b, Predicates.b(filteredSet.f30475c, predicate));
    }

    public static <E> SortedSet<E> c(SortedSet<E> sortedSet, Predicate<? super E> predicate) {
        if (!(sortedSet instanceof FilteredSet)) {
            return new FilteredSortedSet((SortedSet) Preconditions.l(sortedSet), (Predicate) Preconditions.l(predicate));
        }
        FilteredSet filteredSet = (FilteredSet) sortedSet;
        return new FilteredSortedSet((SortedSet) filteredSet.f30474b, Predicates.b(filteredSet.f30475c, predicate));
    }

    static int d(Set<?> set) {
        int i2;
        int i3 = 0;
        for (Object next : set) {
            if (next != null) {
                i2 = next.hashCode();
            } else {
                i2 = 0;
            }
            i3 = ~(~(i3 + i2));
        }
        return i3;
    }

    public static <E> SetView<E> e(final Set<E> set, final Set<?> set2) {
        Preconditions.m(set, "set1");
        Preconditions.m(set2, "set2");
        return new SetView<E>() {
            /* renamed from: a */
            public UnmodifiableIterator<E> iterator() {
                return new AbstractIterator<E>() {

                    /* renamed from: d  reason: collision with root package name */
                    final Iterator<E> f30672d;

                    {
                        this.f30672d = set.iterator();
                    }

                    /* access modifiers changed from: protected */
                    public E a() {
                        while (this.f30672d.hasNext()) {
                            E next = this.f30672d.next();
                            if (set2.contains(next)) {
                                return next;
                            }
                        }
                        return b();
                    }
                };
            }

            public boolean contains(Object obj) {
                return set.contains(obj) && set2.contains(obj);
            }

            public boolean containsAll(Collection<?> collection) {
                return set.containsAll(collection) && set2.containsAll(collection);
            }

            public boolean isEmpty() {
                return Collections.disjoint(set2, set);
            }

            public int size() {
                int i2 = 0;
                for (Object contains : set) {
                    if (set2.contains(contains)) {
                        i2++;
                    }
                }
                return i2;
            }
        };
    }

    public static <E> HashSet<E> f() {
        return new HashSet<>();
    }

    public static <E> HashSet<E> g(int i2) {
        return new HashSet<>(Maps.a(i2));
    }

    public static <E> Set<E> h() {
        return Collections.newSetFromMap(Maps.h());
    }

    static boolean i(Set<?> set, Collection<?> collection) {
        Preconditions.l(collection);
        if (collection instanceof Multiset) {
            collection = ((Multiset) collection).f();
        }
        if (!(collection instanceof Set) || collection.size() <= set.size()) {
            return j(set, collection.iterator());
        }
        return Iterators.q(set.iterator(), collection);
    }

    static boolean j(Set<?> set, Iterator<?> it2) {
        boolean z2 = false;
        while (it2.hasNext()) {
            z2 |= set.remove(it2.next());
        }
        return z2;
    }
}
