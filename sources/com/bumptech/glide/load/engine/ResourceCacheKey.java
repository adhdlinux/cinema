package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.util.LruCache;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

final class ResourceCacheKey implements Key {

    /* renamed from: j  reason: collision with root package name */
    private static final LruCache<Class<?>, byte[]> f16563j = new LruCache<>(50);

    /* renamed from: b  reason: collision with root package name */
    private final ArrayPool f16564b;

    /* renamed from: c  reason: collision with root package name */
    private final Key f16565c;

    /* renamed from: d  reason: collision with root package name */
    private final Key f16566d;

    /* renamed from: e  reason: collision with root package name */
    private final int f16567e;

    /* renamed from: f  reason: collision with root package name */
    private final int f16568f;

    /* renamed from: g  reason: collision with root package name */
    private final Class<?> f16569g;

    /* renamed from: h  reason: collision with root package name */
    private final Options f16570h;

    /* renamed from: i  reason: collision with root package name */
    private final Transformation<?> f16571i;

    ResourceCacheKey(ArrayPool arrayPool, Key key, Key key2, int i2, int i3, Transformation<?> transformation, Class<?> cls, Options options) {
        this.f16564b = arrayPool;
        this.f16565c = key;
        this.f16566d = key2;
        this.f16567e = i2;
        this.f16568f = i3;
        this.f16571i = transformation;
        this.f16569g = cls;
        this.f16570h = options;
    }

    private byte[] c() {
        LruCache<Class<?>, byte[]> lruCache = f16563j;
        byte[] g2 = lruCache.g(this.f16569g);
        if (g2 != null) {
            return g2;
        }
        byte[] bytes = this.f16569g.getName().getBytes(Key.f16305a);
        lruCache.k(this.f16569g, bytes);
        return bytes;
    }

    public void b(MessageDigest messageDigest) {
        byte[] bArr = (byte[]) this.f16564b.d(8, byte[].class);
        ByteBuffer.wrap(bArr).putInt(this.f16567e).putInt(this.f16568f).array();
        this.f16566d.b(messageDigest);
        this.f16565c.b(messageDigest);
        messageDigest.update(bArr);
        Transformation<?> transformation = this.f16571i;
        if (transformation != null) {
            transformation.b(messageDigest);
        }
        this.f16570h.b(messageDigest);
        messageDigest.update(c());
        this.f16564b.put(bArr);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ResourceCacheKey)) {
            return false;
        }
        ResourceCacheKey resourceCacheKey = (ResourceCacheKey) obj;
        if (this.f16568f != resourceCacheKey.f16568f || this.f16567e != resourceCacheKey.f16567e || !Util.c(this.f16571i, resourceCacheKey.f16571i) || !this.f16569g.equals(resourceCacheKey.f16569g) || !this.f16565c.equals(resourceCacheKey.f16565c) || !this.f16566d.equals(resourceCacheKey.f16566d) || !this.f16570h.equals(resourceCacheKey.f16570h)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode = (((((this.f16565c.hashCode() * 31) + this.f16566d.hashCode()) * 31) + this.f16567e) * 31) + this.f16568f;
        Transformation<?> transformation = this.f16571i;
        if (transformation != null) {
            hashCode = (hashCode * 31) + transformation.hashCode();
        }
        return (((hashCode * 31) + this.f16569g.hashCode()) * 31) + this.f16570h.hashCode();
    }

    public String toString() {
        return "ResourceCacheKey{sourceKey=" + this.f16565c + ", signature=" + this.f16566d + ", width=" + this.f16567e + ", height=" + this.f16568f + ", decodedResourceClass=" + this.f16569g + ", transformation='" + this.f16571i + '\'' + ", options=" + this.f16570h + '}';
    }
}
