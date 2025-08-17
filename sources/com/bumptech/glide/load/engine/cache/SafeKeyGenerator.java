package com.bumptech.glide.load.engine.cache;

import androidx.core.util.Pools$Pool;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.LruCache;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.StateVerifier;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SafeKeyGenerator {

    /* renamed from: a  reason: collision with root package name */
    private final LruCache<Key, String> f16651a = new LruCache<>(1000);

    /* renamed from: b  reason: collision with root package name */
    private final Pools$Pool<PoolableDigestContainer> f16652b = FactoryPools.d(10, new FactoryPools.Factory<PoolableDigestContainer>() {
        /* renamed from: a */
        public PoolableDigestContainer create() {
            try {
                return new PoolableDigestContainer(MessageDigest.getInstance("SHA-256"));
            } catch (NoSuchAlgorithmException e2) {
                throw new RuntimeException(e2);
            }
        }
    });

    private static final class PoolableDigestContainer implements FactoryPools.Poolable {

        /* renamed from: b  reason: collision with root package name */
        final MessageDigest f16654b;

        /* renamed from: c  reason: collision with root package name */
        private final StateVerifier f16655c = StateVerifier.a();

        PoolableDigestContainer(MessageDigest messageDigest) {
            this.f16654b = messageDigest;
        }

        public StateVerifier b() {
            return this.f16655c;
        }
    }

    private String a(Key key) {
        PoolableDigestContainer poolableDigestContainer = (PoolableDigestContainer) Preconditions.d(this.f16652b.acquire());
        try {
            key.b(poolableDigestContainer.f16654b);
            return Util.s(poolableDigestContainer.f16654b.digest());
        } finally {
            this.f16652b.release(poolableDigestContainer);
        }
    }

    public String b(Key key) {
        String g2;
        synchronized (this.f16651a) {
            g2 = this.f16651a.g(key);
        }
        if (g2 == null) {
            g2 = a(key);
        }
        synchronized (this.f16651a) {
            this.f16651a.k(key, g2);
        }
        return g2;
    }
}
