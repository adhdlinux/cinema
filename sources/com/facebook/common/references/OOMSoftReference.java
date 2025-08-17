package com.facebook.common.references;

import com.facebook.infer.annotation.Nullsafe;
import java.lang.ref.SoftReference;

@Nullsafe(Nullsafe.Mode.STRICT)
public class OOMSoftReference<T> {
    SoftReference<T> softRef1 = null;
    SoftReference<T> softRef2 = null;
    SoftReference<T> softRef3 = null;

    public void clear() {
        SoftReference<T> softReference = this.softRef1;
        if (softReference != null) {
            softReference.clear();
            this.softRef1 = null;
        }
        SoftReference<T> softReference2 = this.softRef2;
        if (softReference2 != null) {
            softReference2.clear();
            this.softRef2 = null;
        }
        SoftReference<T> softReference3 = this.softRef3;
        if (softReference3 != null) {
            softReference3.clear();
            this.softRef3 = null;
        }
    }

    public T get() {
        SoftReference<T> softReference = this.softRef1;
        if (softReference == null) {
            return null;
        }
        return softReference.get();
    }

    public void set(T t2) {
        this.softRef1 = new SoftReference<>(t2);
        this.softRef2 = new SoftReference<>(t2);
        this.softRef3 = new SoftReference<>(t2);
    }
}
