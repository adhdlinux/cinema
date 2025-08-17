package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Objects;

class RegularImmutableList<E> extends ImmutableList<E> {

    /* renamed from: f  reason: collision with root package name */
    static final ImmutableList<Object> f30639f = new RegularImmutableList(new Object[0], 0);

    /* renamed from: d  reason: collision with root package name */
    final transient Object[] f30640d;

    /* renamed from: e  reason: collision with root package name */
    private final transient int f30641e;

    RegularImmutableList(Object[] objArr, int i2) {
        this.f30640d = objArr;
        this.f30641e = i2;
    }

    /* access modifiers changed from: package-private */
    public int b(Object[] objArr, int i2) {
        System.arraycopy(this.f30640d, 0, objArr, i2, this.f30641e);
        return i2 + this.f30641e;
    }

    /* access modifiers changed from: package-private */
    public Object[] c() {
        return this.f30640d;
    }

    /* access modifiers changed from: package-private */
    public int d() {
        return this.f30641e;
    }

    /* access modifiers changed from: package-private */
    public int e() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public boolean g() {
        return false;
    }

    public E get(int i2) {
        Preconditions.j(i2, this.f30641e);
        E e2 = this.f30640d[i2];
        Objects.requireNonNull(e2);
        return e2;
    }

    public int size() {
        return this.f30641e;
    }
}
