package com.vincentbrison.openlibraries.android.dualcache;

public class ReferenceLruCache<T> extends RamLruCache<String, T> {
    public ReferenceLruCache(int i2, SizeOf<T> sizeOf) {
        super(i2);
    }

    public /* bridge */ /* synthetic */ void i(int i2) {
        super.i(i2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public int g(String str, T t2) {
        throw null;
    }
}
