package com.bumptech.glide.signature;

import com.bumptech.glide.load.Key;
import java.security.MessageDigest;

public final class EmptySignature implements Key {

    /* renamed from: b  reason: collision with root package name */
    private static final EmptySignature f17128b = new EmptySignature();

    private EmptySignature() {
    }

    public static EmptySignature c() {
        return f17128b;
    }

    public void b(MessageDigest messageDigest) {
    }

    public String toString() {
        return "EmptySignature";
    }
}
