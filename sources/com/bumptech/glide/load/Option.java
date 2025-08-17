package com.bumptech.glide.load;

import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;

public final class Option<T> {

    /* renamed from: e  reason: collision with root package name */
    private static final CacheKeyUpdater<Object> f16306e = new CacheKeyUpdater<Object>() {
        public void a(byte[] bArr, Object obj, MessageDigest messageDigest) {
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final T f16307a;

    /* renamed from: b  reason: collision with root package name */
    private final CacheKeyUpdater<T> f16308b;

    /* renamed from: c  reason: collision with root package name */
    private final String f16309c;

    /* renamed from: d  reason: collision with root package name */
    private volatile byte[] f16310d;

    public interface CacheKeyUpdater<T> {
        void a(byte[] bArr, T t2, MessageDigest messageDigest);
    }

    private Option(String str, T t2, CacheKeyUpdater<T> cacheKeyUpdater) {
        this.f16309c = Preconditions.b(str);
        this.f16307a = t2;
        this.f16308b = (CacheKeyUpdater) Preconditions.d(cacheKeyUpdater);
    }

    public static <T> Option<T> a(String str, T t2, CacheKeyUpdater<T> cacheKeyUpdater) {
        return new Option<>(str, t2, cacheKeyUpdater);
    }

    private static <T> CacheKeyUpdater<T> b() {
        return f16306e;
    }

    private byte[] d() {
        if (this.f16310d == null) {
            this.f16310d = this.f16309c.getBytes(Key.f16305a);
        }
        return this.f16310d;
    }

    public static <T> Option<T> e(String str) {
        return new Option<>(str, (Object) null, b());
    }

    public static <T> Option<T> f(String str, T t2) {
        return new Option<>(str, t2, b());
    }

    public T c() {
        return this.f16307a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Option) {
            return this.f16309c.equals(((Option) obj).f16309c);
        }
        return false;
    }

    public void g(T t2, MessageDigest messageDigest) {
        this.f16308b.a(d(), t2, messageDigest);
    }

    public int hashCode() {
        return this.f16309c.hashCode();
    }

    public String toString() {
        return "Option{key='" + this.f16309c + '\'' + '}';
    }
}
