package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;

public abstract class ImmutableCollection<E> extends AbstractCollection<E> implements Serializable {

    /* renamed from: b  reason: collision with root package name */
    private static final Object[] f30506b = new Object[0];

    static abstract class ArrayBasedBuilder<E> extends Builder<E> {

        /* renamed from: a  reason: collision with root package name */
        Object[] f30507a;

        /* renamed from: b  reason: collision with root package name */
        int f30508b = 0;

        /* renamed from: c  reason: collision with root package name */
        boolean f30509c;

        ArrayBasedBuilder(int i2) {
            CollectPreconditions.b(i2, "initialCapacity");
            this.f30507a = new Object[i2];
        }

        private void g(int i2) {
            Object[] objArr = this.f30507a;
            if (objArr.length < i2) {
                this.f30507a = Arrays.copyOf(objArr, Builder.c(objArr.length, i2));
                this.f30509c = false;
            } else if (this.f30509c) {
                this.f30507a = (Object[]) objArr.clone();
                this.f30509c = false;
            }
        }

        public Builder<E> b(Iterable<? extends E> iterable) {
            if (iterable instanceof Collection) {
                Collection collection = (Collection) iterable;
                g(this.f30508b + collection.size());
                if (collection instanceof ImmutableCollection) {
                    this.f30508b = ((ImmutableCollection) collection).b(this.f30507a, this.f30508b);
                    return this;
                }
            }
            super.b(iterable);
            return this;
        }

        /* renamed from: d */
        public ArrayBasedBuilder<E> a(E e2) {
            Preconditions.l(e2);
            g(this.f30508b + 1);
            Object[] objArr = this.f30507a;
            int i2 = this.f30508b;
            this.f30508b = i2 + 1;
            objArr[i2] = e2;
            return this;
        }

        public Builder<E> e(E... eArr) {
            f(eArr, eArr.length);
            return this;
        }

        /* access modifiers changed from: package-private */
        public final void f(Object[] objArr, int i2) {
            ObjectArrays.c(objArr, i2);
            g(this.f30508b + i2);
            System.arraycopy(objArr, 0, this.f30507a, this.f30508b, i2);
            this.f30508b += i2;
        }
    }

    public static abstract class Builder<E> {
        Builder() {
        }

        static int c(int i2, int i3) {
            if (i3 >= 0) {
                int i4 = i2 + (i2 >> 1) + 1;
                if (i4 < i3) {
                    i4 = Integer.highestOneBit(i3 - 1) << 1;
                }
                if (i4 < 0) {
                    return Integer.MAX_VALUE;
                }
                return i4;
            }
            throw new AssertionError("cannot store more than MAX_VALUE elements");
        }

        public abstract Builder<E> a(E e2);

        public Builder<E> b(Iterable<? extends E> iterable) {
            for (Object a2 : iterable) {
                a(a2);
            }
            return this;
        }
    }

    ImmutableCollection() {
    }

    public ImmutableList<E> a() {
        return isEmpty() ? ImmutableList.r() : ImmutableList.i(toArray());
    }

    @Deprecated
    public final boolean add(E e2) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public int b(Object[] objArr, int i2) {
        UnmodifiableIterator h2 = iterator();
        while (h2.hasNext()) {
            objArr[i2] = h2.next();
            i2++;
        }
        return i2;
    }

    /* access modifiers changed from: package-private */
    public Object[] c() {
        return null;
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public abstract boolean contains(Object obj);

    /* access modifiers changed from: package-private */
    public int d() {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public int e() {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public abstract boolean g();

    /* renamed from: h */
    public abstract UnmodifiableIterator<E> iterator();

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

    public final Object[] toArray() {
        return toArray(f30506b);
    }

    public final <T> T[] toArray(T[] tArr) {
        Preconditions.l(tArr);
        int size = size();
        if (tArr.length < size) {
            Object[] c2 = c();
            if (c2 != null) {
                return Platform.a(c2, e(), d(), tArr);
            }
            tArr = ObjectArrays.d(tArr, size);
        } else if (tArr.length > size) {
            tArr[size] = null;
        }
        b(tArr, 0);
        return tArr;
    }
}
