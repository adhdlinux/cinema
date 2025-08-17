package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import java.security.MessageDigest;

final class DataCacheKey implements Key {

    /* renamed from: b  reason: collision with root package name */
    private final Key f16379b;

    /* renamed from: c  reason: collision with root package name */
    private final Key f16380c;

    DataCacheKey(Key key, Key key2) {
        this.f16379b = key;
        this.f16380c = key2;
    }

    public void b(MessageDigest messageDigest) {
        this.f16379b.b(messageDigest);
        this.f16380c.b(messageDigest);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DataCacheKey)) {
            return false;
        }
        DataCacheKey dataCacheKey = (DataCacheKey) obj;
        if (!this.f16379b.equals(dataCacheKey.f16379b) || !this.f16380c.equals(dataCacheKey.f16380c)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.f16379b.hashCode() * 31) + this.f16380c.hashCode();
    }

    public String toString() {
        return "DataCacheKey{sourceKey=" + this.f16379b + ", signature=" + this.f16380c + '}';
    }
}
