package com.google.common.collect;

final class RegularImmutableSet<E> extends ImmutableSet<E> {

    /* renamed from: i  reason: collision with root package name */
    private static final Object[] f30656i;

    /* renamed from: j  reason: collision with root package name */
    static final RegularImmutableSet<Object> f30657j;

    /* renamed from: d  reason: collision with root package name */
    final transient Object[] f30658d;

    /* renamed from: e  reason: collision with root package name */
    private final transient int f30659e;

    /* renamed from: f  reason: collision with root package name */
    final transient Object[] f30660f;

    /* renamed from: g  reason: collision with root package name */
    private final transient int f30661g;

    /* renamed from: h  reason: collision with root package name */
    private final transient int f30662h;

    static {
        Object[] objArr = new Object[0];
        f30656i = objArr;
        f30657j = new RegularImmutableSet(objArr, 0, objArr, 0, 0);
    }

    RegularImmutableSet(Object[] objArr, int i2, Object[] objArr2, int i3, int i4) {
        this.f30658d = objArr;
        this.f30659e = i2;
        this.f30660f = objArr2;
        this.f30661g = i3;
        this.f30662h = i4;
    }

    /* access modifiers changed from: package-private */
    public int b(Object[] objArr, int i2) {
        System.arraycopy(this.f30658d, 0, objArr, i2, this.f30662h);
        return i2 + this.f30662h;
    }

    /* access modifiers changed from: package-private */
    public Object[] c() {
        return this.f30658d;
    }

    public boolean contains(Object obj) {
        Object[] objArr = this.f30660f;
        if (obj == null || objArr.length == 0) {
            return false;
        }
        int c2 = Hashing.c(obj);
        while (true) {
            int i2 = c2 & this.f30661g;
            Object obj2 = objArr[i2];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            c2 = i2 + 1;
        }
    }

    /* access modifiers changed from: package-private */
    public int d() {
        return this.f30662h;
    }

    /* access modifiers changed from: package-private */
    public int e() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public boolean g() {
        return false;
    }

    /* renamed from: h */
    public UnmodifiableIterator<E> iterator() {
        return a().iterator();
    }

    public int hashCode() {
        return this.f30659e;
    }

    /* access modifiers changed from: package-private */
    public ImmutableList<E> o() {
        return ImmutableList.j(this.f30658d, this.f30662h);
    }

    /* access modifiers changed from: package-private */
    public boolean p() {
        return true;
    }

    public int size() {
        return this.f30662h;
    }
}
