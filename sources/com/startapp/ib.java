package com.startapp;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ib implements Iterator<Throwable> {

    /* renamed from: a  reason: collision with root package name */
    public Throwable f34695a;

    /* renamed from: b  reason: collision with root package name */
    public Throwable[] f34696b;

    /* renamed from: c  reason: collision with root package name */
    public int f34697c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f34698d;

    public ib(Throwable th) {
        this.f34695a = th;
        this.f34696b = th.getSuppressed();
    }

    /* renamed from: a */
    public Throwable next() {
        int i2;
        Throwable th = this.f34695a;
        boolean z2 = false;
        this.f34698d = false;
        if (th != null) {
            this.f34695a = th.getCause();
        } else {
            Throwable[] thArr = this.f34696b;
            if (thArr != null && (i2 = this.f34697c) < thArr.length) {
                if (i2 == 0) {
                    z2 = true;
                }
                this.f34698d = z2;
                this.f34697c = i2 + 1;
                th = thArr[i2];
            }
        }
        if (th != null) {
            return th;
        }
        throw new NoSuchElementException();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r2.f34696b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean hasNext() {
        /*
            r2 = this;
            java.lang.Throwable r0 = r2.f34695a
            if (r0 != 0) goto L_0x0010
            java.lang.Throwable[] r0 = r2.f34696b
            if (r0 == 0) goto L_0x000e
            int r1 = r2.f34697c
            int r0 = r0.length
            if (r1 >= r0) goto L_0x000e
            goto L_0x0010
        L_0x000e:
            r0 = 0
            goto L_0x0011
        L_0x0010:
            r0 = 1
        L_0x0011:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.ib.hasNext():boolean");
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}
