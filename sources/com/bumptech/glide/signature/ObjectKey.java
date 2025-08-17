package com.bumptech.glide.signature;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;

public final class ObjectKey implements Key {

    /* renamed from: b  reason: collision with root package name */
    private final Object f17129b;

    public ObjectKey(Object obj) {
        this.f17129b = Preconditions.d(obj);
    }

    public void b(MessageDigest messageDigest) {
        messageDigest.update(this.f17129b.toString().getBytes(Key.f16305a));
    }

    public boolean equals(Object obj) {
        if (obj instanceof ObjectKey) {
            return this.f17129b.equals(((ObjectKey) obj).f17129b);
        }
        return false;
    }

    public int hashCode() {
        return this.f17129b.hashCode();
    }

    public String toString() {
        return "ObjectKey{object=" + this.f17129b + '}';
    }
}
