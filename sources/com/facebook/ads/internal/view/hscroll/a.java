package com.facebook.ads.internal.view.hscroll;

import android.util.SparseArray;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private final SparseArray<int[]> f21599a = new SparseArray<>();

    public void a(int i2, int[] iArr) {
        this.f21599a.put(i2, iArr);
    }

    public int[] a(int i2) {
        return this.f21599a.get(i2);
    }

    public boolean b(int i2) {
        return this.f21599a.indexOfKey(i2) >= 0;
    }
}
