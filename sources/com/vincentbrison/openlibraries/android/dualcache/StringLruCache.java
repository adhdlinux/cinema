package com.vincentbrison.openlibraries.android.dualcache;

import java.nio.charset.Charset;

class StringLruCache extends RamLruCache<String, String> {
    public StringLruCache(int i2) {
        super(i2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public int g(String str, String str2) {
        return str2.getBytes(Charset.defaultCharset()).length;
    }
}
