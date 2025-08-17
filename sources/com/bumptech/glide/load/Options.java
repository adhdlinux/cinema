package com.bumptech.glide.load;

import androidx.collection.ArrayMap;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import java.security.MessageDigest;

public final class Options implements Key {

    /* renamed from: b  reason: collision with root package name */
    private final ArrayMap<Option<?>, Object> f16311b = new CachedHashCodeArrayMap();

    private static <T> void f(Option<T> option, Object obj, MessageDigest messageDigest) {
        option.g(obj, messageDigest);
    }

    public void b(MessageDigest messageDigest) {
        for (int i2 = 0; i2 < this.f16311b.size(); i2++) {
            f(this.f16311b.j(i2), this.f16311b.n(i2), messageDigest);
        }
    }

    public <T> T c(Option<T> option) {
        return this.f16311b.containsKey(option) ? this.f16311b.get(option) : option.c();
    }

    public void d(Options options) {
        this.f16311b.k(options.f16311b);
    }

    public <T> Options e(Option<T> option, T t2) {
        this.f16311b.put(option, t2);
        return this;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Options) {
            return this.f16311b.equals(((Options) obj).f16311b);
        }
        return false;
    }

    public int hashCode() {
        return this.f16311b.hashCode();
    }

    public String toString() {
        return "Options{values=" + this.f16311b + '}';
    }
}
