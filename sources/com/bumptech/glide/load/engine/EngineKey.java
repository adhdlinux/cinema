package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;
import java.util.Map;

class EngineKey implements Key {

    /* renamed from: b  reason: collision with root package name */
    private final Object f16517b;

    /* renamed from: c  reason: collision with root package name */
    private final int f16518c;

    /* renamed from: d  reason: collision with root package name */
    private final int f16519d;

    /* renamed from: e  reason: collision with root package name */
    private final Class<?> f16520e;

    /* renamed from: f  reason: collision with root package name */
    private final Class<?> f16521f;

    /* renamed from: g  reason: collision with root package name */
    private final Key f16522g;

    /* renamed from: h  reason: collision with root package name */
    private final Map<Class<?>, Transformation<?>> f16523h;

    /* renamed from: i  reason: collision with root package name */
    private final Options f16524i;

    /* renamed from: j  reason: collision with root package name */
    private int f16525j;

    EngineKey(Object obj, Key key, int i2, int i3, Map<Class<?>, Transformation<?>> map, Class<?> cls, Class<?> cls2, Options options) {
        this.f16517b = Preconditions.d(obj);
        this.f16522g = (Key) Preconditions.e(key, "Signature must not be null");
        this.f16518c = i2;
        this.f16519d = i3;
        this.f16523h = (Map) Preconditions.d(map);
        this.f16520e = (Class) Preconditions.e(cls, "Resource class must not be null");
        this.f16521f = (Class) Preconditions.e(cls2, "Transcode class must not be null");
        this.f16524i = (Options) Preconditions.d(options);
    }

    public void b(MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof EngineKey)) {
            return false;
        }
        EngineKey engineKey = (EngineKey) obj;
        if (!this.f16517b.equals(engineKey.f16517b) || !this.f16522g.equals(engineKey.f16522g) || this.f16519d != engineKey.f16519d || this.f16518c != engineKey.f16518c || !this.f16523h.equals(engineKey.f16523h) || !this.f16520e.equals(engineKey.f16520e) || !this.f16521f.equals(engineKey.f16521f) || !this.f16524i.equals(engineKey.f16524i)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        if (this.f16525j == 0) {
            int hashCode = this.f16517b.hashCode();
            this.f16525j = hashCode;
            int hashCode2 = (((((hashCode * 31) + this.f16522g.hashCode()) * 31) + this.f16518c) * 31) + this.f16519d;
            this.f16525j = hashCode2;
            int hashCode3 = (hashCode2 * 31) + this.f16523h.hashCode();
            this.f16525j = hashCode3;
            int hashCode4 = (hashCode3 * 31) + this.f16520e.hashCode();
            this.f16525j = hashCode4;
            int hashCode5 = (hashCode4 * 31) + this.f16521f.hashCode();
            this.f16525j = hashCode5;
            this.f16525j = (hashCode5 * 31) + this.f16524i.hashCode();
        }
        return this.f16525j;
    }

    public String toString() {
        return "EngineKey{model=" + this.f16517b + ", width=" + this.f16518c + ", height=" + this.f16519d + ", resourceClass=" + this.f16520e + ", transcodeClass=" + this.f16521f + ", signature=" + this.f16522g + ", hashCode=" + this.f16525j + ", transformations=" + this.f16523h + ", options=" + this.f16524i + '}';
    }
}
