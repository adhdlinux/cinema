package com.bumptech.glide.load;

import java.nio.charset.Charset;
import java.security.MessageDigest;

public interface Key {

    /* renamed from: a  reason: collision with root package name */
    public static final Charset f16305a = Charset.forName("UTF-8");

    void b(MessageDigest messageDigest);

    boolean equals(Object obj);

    int hashCode();
}
