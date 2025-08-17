package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public abstract class ImmutableList<E> extends ImmutableCollection<E> implements List<E>, RandomAccess {

    /* renamed from: c  reason: collision with root package name */
    private static final UnmodifiableListIterator<Object> f30512c = new Itr(RegularImmutableList.f30639f, 0);

    public static final class Builder<E> extends ImmutableCollection.ArrayBasedBuilder<E> {
        public Builder() {
            this(4);
        }

        /* renamed from: h */
        public Builder<E> d(E e2) {
            super.a(e2);
            return this;
        }

        public Builder<E> i(E... eArr) {
            super.e(eArr);
            return this;
        }

        public Builder<E> j(Iterable<? extends E> iterable) {
            super.b(iterable);
            return this;
        }

        public ImmutableList<E> k() {
            this.f30509c = true;
            return ImmutableList.j(this.f30507a, this.f30508b);
        }

        Builder(int i2) {
            super(i2);
        }
    }

    static class Itr<E> extends AbstractIndexedListIterator<E> {

        /* renamed from: d  reason: collision with root package name */
        private final ImmutableList<E> f30513d;

        Itr(ImmutableList<E> immutableList, int i2) {
            super(immutableList.size(), i2);
            this.f30513d = immutableList;
        }

        /* access modifiers changed from: protected */
        public E a(int i2) {
            return this.f30513d.get(i2);
        }
    }

    private static class ReverseImmutableList<E> extends ImmutableList<E> {

        /* renamed from: d  reason: collision with root package name */
        private final transient ImmutableList<E> f30514d;

        ReverseImmutableList(ImmutableList<E> immutableList) {
            this.f30514d = immutableList;
        }

        private int B(int i2) {
            return (size() - 1) - i2;
        }

        private int C(int i2) {
            return size() - i2;
        }

        public boolean contains(Object obj) {
            return this.f30514d.contains(obj);
        }

        /* access modifiers changed from: package-private */
        public boolean g() {
            return this.f30514d.g();
        }

        public E get(int i2) {
            Preconditions.j(i2, size());
            return this.f30514d.get(B(i2));
        }

        public int indexOf(Object obj) {
            int lastIndexOf = this.f30514d.lastIndexOf(obj);
            if (lastIndexOf >= 0) {
                return B(lastIndexOf);
            }
            return -1;
        }

        public /* bridge */ /* synthetic */ Iterator iterator() {
            return ImmutableList.super.iterator();
        }

        public int lastIndexOf(Object obj) {
            int indexOf = this.f30514d.indexOf(obj);
            if (indexOf >= 0) {
                return B(indexOf);
            }
            return -1;
        }

        public /* bridge */ /* synthetic */ ListIterator listIterator() {
            return ImmutableList.super.listIterator();
        }

        public int size() {
            return this.f30514d.size();
        }

        public ImmutableList<E> x() {
            return this.f30514d;
        }

        /* renamed from: z */
        public ImmutableList<E> subList(int i2, int i3) {
            Preconditions.p(i2, i3, size());
            return this.f30514d.subList(C(i3), C(i2)).x();
        }

        public /* bridge */ /* synthetic */ ListIterator listIterator(int i2) {
            return ImmutableList.super.listIterator(i2);
        }
    }

    class SubList extends ImmutableList<E> {

        /* renamed from: d  reason: collision with root package name */
        final transient int f30515d;

        /* renamed from: e  reason: collision with root package name */
        final transient int f30516e;

        SubList(int i2, int i3) {
            this.f30515d = i2;
            this.f30516e = i3;
        }

        /* access modifiers changed from: package-private */
        public Object[] c() {
            return ImmutableList.this.c();
        }

        /* access modifiers changed from: package-private */
        public int d() {
            return ImmutableList.this.e() + this.f30515d + this.f30516e;
        }

        /* access modifiers changed from: package-private */
        public int e() {
            return ImmutableList.this.e() + this.f30515d;
        }

        /* access modifiers changed from: package-private */
        public boolean g() {
            return true;
        }

        public E get(int i2) {
            Preconditions.j(i2, this.f30516e);
            return ImmutableList.this.get(i2 + this.f30515d);
        }

        public /* bridge */ /* synthetic */ Iterator iterator() {
            return ImmutableList.super.iterator();
        }

        public /* bridge */ /* synthetic */ ListIterator listIterator() {
            return ImmutableList.super.listIterator();
        }

        public int size() {
            return this.f30516e;
        }

        /* renamed from: z */
        public ImmutableList<E> subList(int i2, int i3) {
            Preconditions.p(i2, i3, this.f30516e);
            ImmutableList immutableList = ImmutableList.this;
            int i4 = this.f30515d;
            return immutableList.subList(i2 + i4, i3 + i4);
        }

        public /* bridge */ /* synthetic */ ListIterator listIterator(int i2) {
            return ImmutableList.super.listIterator(i2);
        }
    }

    ImmutableList() {
    }

    static <E> ImmutableList<E> i(Object[] objArr) {
        return j(objArr, objArr.length);
    }

    static <E> ImmutableList<E> j(Object[] objArr, int i2) {
        if (i2 == 0) {
            return r();
        }
        return new RegularImmutableList(objArr, i2);
    }

    public static <E> Builder<E> k() {
        return new Builder<>();
    }

    public static <E> Builder<E> l(int i2) {
        CollectPreconditions.b(i2, "expectedSize");
        return new Builder<>(i2);
    }

    private static <E> ImmutableList<E> m(Object... objArr) {
        return i(ObjectArrays.b(objArr));
    }

    public static <E> ImmutableList<E> n(Collection<? extends E> collection) {
        if (!(collection instanceof ImmutableCollection)) {
            return m(collection.toArray());
        }
        ImmutableList<E> a2 = ((ImmutableCollection) collection).a();
        if (a2.g()) {
            return i(a2.toArray());
        }
        return a2;
    }

    public static <E> ImmutableList<E> o(E[] eArr) {
        if (eArr.length == 0) {
            return r();
        }
        return m((Object[]) eArr.clone());
    }

    public static <E> ImmutableList<E> r() {
        return RegularImmutableList.f30639f;
    }

    public static <E> ImmutableList<E> s(E e2) {
        return m(e2);
    }

    public static <E> ImmutableList<E> t(E e2, E e3) {
        return m(e2, e3);
    }

    public static <E> ImmutableList<E> u(E e2, E e3, E e4) {
        return m(e2, e3, e4);
    }

    public static <E> ImmutableList<E> v(E e2, E e3, E e4, E e5, E e6) {
        return m(e2, e3, e4, e5, e6);
    }

    @SafeVarargs
    public static <E> ImmutableList<E> w(E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9, E e10, E e11, E e12, E e13, E... eArr) {
        boolean z2;
        E[] eArr2 = eArr;
        if (eArr2.length <= 2147483635) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.e(z2, "the total number of elements must fit in an int");
        Object[] objArr = new Object[(eArr2.length + 12)];
        objArr[0] = e2;
        objArr[1] = e3;
        objArr[2] = e4;
        objArr[3] = e5;
        objArr[4] = e6;
        objArr[5] = e7;
        objArr[6] = e8;
        objArr[7] = e9;
        objArr[8] = e10;
        objArr[9] = e11;
        objArr[10] = e12;
        objArr[11] = e13;
        System.arraycopy(eArr2, 0, objArr, 12, eArr2.length);
        return m(objArr);
    }

    public static <E> ImmutableList<E> y(Comparator<? super E> comparator, Iterable<? extends E> iterable) {
        Preconditions.l(comparator);
        Object[] k2 = Iterables.k(iterable);
        ObjectArrays.b(k2);
        Arrays.sort(k2, comparator);
        return i(k2);
    }

    /* access modifiers changed from: package-private */
    public ImmutableList<E> A(int i2, int i3) {
        return new SubList(i2, i3 - i2);
    }

    @Deprecated
    public final ImmutableList<E> a() {
        return this;
    }

    @Deprecated
    public final void add(int i2, E e2) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean addAll(int i2, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public int b(Object[] objArr, int i2) {
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            objArr[i2 + i3] = get(i3);
        }
        return i2 + size;
    }

    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    public boolean equals(Object obj) {
        return Lists.c(this, obj);
    }

    /* renamed from: h */
    public UnmodifiableIterator<E> iterator() {
        return listIterator();
    }

    public int hashCode() {
        int size = size();
        int i2 = 1;
        for (int i3 = 0; i3 < size; i3++) {
            i2 = ~(~((i2 * 31) + get(i3).hashCode()));
        }
        return i2;
    }

    public int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        return Lists.d(this, obj);
    }

    public int lastIndexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        return Lists.f(this, obj);
    }

    /* renamed from: p */
    public UnmodifiableListIterator<E> listIterator() {
        return listIterator(0);
    }

    /* renamed from: q */
    public UnmodifiableListIterator<E> listIterator(int i2) {
        Preconditions.n(i2, size());
        if (isEmpty()) {
            return f30512c;
        }
        return new Itr(this, i2);
    }

    @Deprecated
    public final E remove(int i2) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final E set(int i2, E e2) {
        throw new UnsupportedOperationException();
    }

    public ImmutableList<E> x() {
        return size() <= 1 ? this : new ReverseImmutableList(this);
    }

    /* renamed from: z */
    public ImmutableList<E> subList(int i2, int i3) {
        Preconditions.p(i2, i3, size());
        int i4 = i3 - i2;
        if (i4 == size()) {
            return this;
        }
        if (i4 == 0) {
            return r();
        }
        return A(i2, i3);
    }
}
