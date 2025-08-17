package com.google.common.collect;

import com.google.common.base.Preconditions;

final class SingletonImmutableSet<E> extends ImmutableSet<E> {

    /* renamed from: d  reason: collision with root package name */
    final transient E f30674d;

    SingletonImmutableSet(E e2) {
        this.f30674d = Preconditions.l(e2);
    }

    public ImmutableList<E> a() {
        return ImmutableList.s(this.f30674d);
    }

    /* access modifiers changed from: package-private */
    public int b(Object[] objArr, int i2) {
        objArr[i2] = this.f30674d;
        return i2 + 1;
    }

    public boolean contains(Object obj) {
        return this.f30674d.equals(obj);
    }

    /* access modifiers changed from: package-private */
    public boolean g() {
        return false;
    }

    /* renamed from: h */
    public UnmodifiableIterator<E> iterator() {
        return Iterators.s(this.f30674d);
    }

    public final int hashCode() {
        return this.f30674d.hashCode();
    }

    public int size() {
        return 1;
    }

    public String toString() {
        return '[' + this.f30674d.toString() + ']';
    }
}
