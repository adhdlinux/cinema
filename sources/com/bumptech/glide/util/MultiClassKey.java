package com.bumptech.glide.util;

public class MultiClassKey {

    /* renamed from: a  reason: collision with root package name */
    private Class<?> f17151a;

    /* renamed from: b  reason: collision with root package name */
    private Class<?> f17152b;

    /* renamed from: c  reason: collision with root package name */
    private Class<?> f17153c;

    public MultiClassKey() {
    }

    public void a(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        this.f17151a = cls;
        this.f17152b = cls2;
        this.f17153c = cls3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MultiClassKey multiClassKey = (MultiClassKey) obj;
        if (this.f17151a.equals(multiClassKey.f17151a) && this.f17152b.equals(multiClassKey.f17152b) && Util.c(this.f17153c, multiClassKey.f17153c)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i2;
        int hashCode = ((this.f17151a.hashCode() * 31) + this.f17152b.hashCode()) * 31;
        Class<?> cls = this.f17153c;
        if (cls != null) {
            i2 = cls.hashCode();
        } else {
            i2 = 0;
        }
        return hashCode + i2;
    }

    public String toString() {
        return "MultiClassKey{first=" + this.f17151a + ", second=" + this.f17152b + '}';
    }

    public MultiClassKey(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        a(cls, cls2, cls3);
    }
}
