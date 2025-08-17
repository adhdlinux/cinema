package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.j2objc.annotations.RetainedWith;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;

public abstract class ImmutableSet<E> extends ImmutableCollection<E> implements Set<E> {
    @RetainedWith

    /* renamed from: c  reason: collision with root package name */
    private transient ImmutableList<E> f30544c;

    public static class Builder<E> extends ImmutableCollection.ArrayBasedBuilder<E> {

        /* renamed from: d  reason: collision with root package name */
        Object[] f30545d;

        /* renamed from: e  reason: collision with root package name */
        private int f30546e;

        public Builder() {
            super(4);
        }

        private void k(E e2) {
            Objects.requireNonNull(this.f30545d);
            int length = this.f30545d.length - 1;
            int hashCode = e2.hashCode();
            int b2 = Hashing.b(hashCode);
            while (true) {
                int i2 = b2 & length;
                Object[] objArr = this.f30545d;
                Object obj = objArr[i2];
                if (obj == null) {
                    objArr[i2] = e2;
                    this.f30546e += hashCode;
                    super.a(e2);
                    return;
                } else if (!obj.equals(e2)) {
                    b2 = i2 + 1;
                } else {
                    return;
                }
            }
        }

        /* renamed from: h */
        public Builder<E> d(E e2) {
            Preconditions.l(e2);
            if (this.f30545d == null || ImmutableSet.k(this.f30508b) > this.f30545d.length) {
                this.f30545d = null;
                super.a(e2);
                return this;
            }
            k(e2);
            return this;
        }

        public Builder<E> i(E... eArr) {
            if (this.f30545d != null) {
                for (E h2 : eArr) {
                    d(h2);
                }
            } else {
                super.e(eArr);
            }
            return this;
        }

        public Builder<E> j(Iterable<? extends E> iterable) {
            Preconditions.l(iterable);
            if (this.f30545d != null) {
                for (Object h2 : iterable) {
                    d(h2);
                }
            } else {
                super.b(iterable);
            }
            return this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: com.google.common.collect.RegularImmutableSet} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: com.google.common.collect.ImmutableSet} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v16, resolved type: com.google.common.collect.RegularImmutableSet} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: com.google.common.collect.RegularImmutableSet} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.google.common.collect.ImmutableSet<E> l() {
            /*
                r8 = this;
                int r0 = r8.f30508b
                if (r0 == 0) goto L_0x005c
                r1 = 1
                if (r0 == r1) goto L_0x004f
                java.lang.Object[] r2 = r8.f30545d
                if (r2 == 0) goto L_0x003b
                int r0 = com.google.common.collect.ImmutableSet.k(r0)
                java.lang.Object[] r2 = r8.f30545d
                int r2 = r2.length
                if (r0 != r2) goto L_0x003b
                int r0 = r8.f30508b
                java.lang.Object[] r2 = r8.f30507a
                int r2 = r2.length
                boolean r0 = com.google.common.collect.ImmutableSet.v(r0, r2)
                if (r0 == 0) goto L_0x0028
                java.lang.Object[] r0 = r8.f30507a
                int r2 = r8.f30508b
                java.lang.Object[] r0 = java.util.Arrays.copyOf(r0, r2)
                goto L_0x002a
            L_0x0028:
                java.lang.Object[] r0 = r8.f30507a
            L_0x002a:
                r3 = r0
                com.google.common.collect.RegularImmutableSet r0 = new com.google.common.collect.RegularImmutableSet
                int r4 = r8.f30546e
                java.lang.Object[] r5 = r8.f30545d
                int r2 = r5.length
                int r6 = r2 + -1
                int r7 = r8.f30508b
                r2 = r0
                r2.<init>(r3, r4, r5, r6, r7)
                goto L_0x0049
            L_0x003b:
                int r0 = r8.f30508b
                java.lang.Object[] r2 = r8.f30507a
                com.google.common.collect.ImmutableSet r0 = com.google.common.collect.ImmutableSet.l(r0, r2)
                int r2 = r0.size()
                r8.f30508b = r2
            L_0x0049:
                r8.f30509c = r1
                r1 = 0
                r8.f30545d = r1
                return r0
            L_0x004f:
                java.lang.Object[] r0 = r8.f30507a
                r1 = 0
                r0 = r0[r1]
                java.util.Objects.requireNonNull(r0)
                com.google.common.collect.ImmutableSet r0 = com.google.common.collect.ImmutableSet.r(r0)
                return r0
            L_0x005c:
                com.google.common.collect.ImmutableSet r0 = com.google.common.collect.ImmutableSet.q()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.ImmutableSet.Builder.l():com.google.common.collect.ImmutableSet");
        }
    }

    ImmutableSet() {
    }

    static int k(int i2) {
        int max = Math.max(i2, 2);
        boolean z2 = true;
        if (max < 751619276) {
            int highestOneBit = Integer.highestOneBit(max - 1) << 1;
            while (((double) highestOneBit) * 0.7d < ((double) max)) {
                highestOneBit <<= 1;
            }
            return highestOneBit;
        }
        if (max >= 1073741824) {
            z2 = false;
        }
        Preconditions.e(z2, "collection too large");
        return 1073741824;
    }

    /* access modifiers changed from: private */
    public static <E> ImmutableSet<E> l(int i2, Object... objArr) {
        if (i2 == 0) {
            return q();
        }
        if (i2 != 1) {
            int k2 = k(i2);
            Object[] objArr2 = new Object[k2];
            int i3 = k2 - 1;
            int i4 = 0;
            int i5 = 0;
            for (int i6 = 0; i6 < i2; i6++) {
                Object a2 = ObjectArrays.a(objArr[i6], i6);
                int hashCode = a2.hashCode();
                int b2 = Hashing.b(hashCode);
                while (true) {
                    int i7 = b2 & i3;
                    Object obj = objArr2[i7];
                    if (obj == null) {
                        objArr[i5] = a2;
                        objArr2[i7] = a2;
                        i4 += hashCode;
                        i5++;
                        break;
                    } else if (obj.equals(a2)) {
                        break;
                    } else {
                        b2++;
                    }
                }
            }
            Arrays.fill(objArr, i5, i2, (Object) null);
            if (i5 == 1) {
                Object obj2 = objArr[0];
                Objects.requireNonNull(obj2);
                return new SingletonImmutableSet(obj2);
            } else if (k(i5) < k2 / 2) {
                return l(i5, objArr);
            } else {
                if (v(i5, objArr.length)) {
                    objArr = Arrays.copyOf(objArr, i5);
                }
                return new RegularImmutableSet(objArr, i4, objArr2, i3, i5);
            }
        } else {
            Object obj3 = objArr[0];
            Objects.requireNonNull(obj3);
            return r(obj3);
        }
    }

    public static <E> ImmutableSet<E> m(Collection<? extends E> collection) {
        if ((collection instanceof ImmutableSet) && !(collection instanceof SortedSet)) {
            ImmutableSet<E> immutableSet = (ImmutableSet) collection;
            if (!immutableSet.g()) {
                return immutableSet;
            }
        }
        Object[] array = collection.toArray();
        return l(array.length, array);
    }

    public static <E> ImmutableSet<E> n(E[] eArr) {
        int length = eArr.length;
        if (length == 0) {
            return q();
        }
        if (length != 1) {
            return l(eArr.length, (Object[]) eArr.clone());
        }
        return r(eArr[0]);
    }

    public static <E> ImmutableSet<E> q() {
        return RegularImmutableSet.f30657j;
    }

    public static <E> ImmutableSet<E> r(E e2) {
        return new SingletonImmutableSet(e2);
    }

    public static <E> ImmutableSet<E> s(E e2, E e3) {
        return l(2, e2, e3);
    }

    public static <E> ImmutableSet<E> t(E e2, E e3, E e4) {
        return l(3, e2, e3, e4);
    }

    public static <E> ImmutableSet<E> u(E e2, E e3, E e4, E e5, E e6) {
        return l(5, e2, e3, e4, e5, e6);
    }

    /* access modifiers changed from: private */
    public static boolean v(int i2, int i3) {
        return i2 < (i3 >> 1) + (i3 >> 2);
    }

    public ImmutableList<E> a() {
        ImmutableList<E> immutableList = this.f30544c;
        if (immutableList != null) {
            return immutableList;
        }
        ImmutableList<E> o2 = o();
        this.f30544c = o2;
        return o2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImmutableSet) || !p() || !((ImmutableSet) obj).p() || hashCode() == obj.hashCode()) {
            return Sets.a(this, obj);
        }
        return false;
    }

    /* renamed from: h */
    public abstract UnmodifiableIterator<E> iterator();

    public int hashCode() {
        return Sets.d(this);
    }

    /* access modifiers changed from: package-private */
    public ImmutableList<E> o() {
        return ImmutableList.i(toArray());
    }

    /* access modifiers changed from: package-private */
    public boolean p() {
        return false;
    }
}
