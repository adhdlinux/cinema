package com.bumptech.glide.load.resource;

import android.content.Context;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import java.security.MessageDigest;

public final class UnitTransformation<T> implements Transformation<T> {

    /* renamed from: b  reason: collision with root package name */
    private static final Transformation<?> f16806b = new UnitTransformation();

    private UnitTransformation() {
    }

    public static <T> UnitTransformation<T> c() {
        return (UnitTransformation) f16806b;
    }

    public Resource<T> a(Context context, Resource<T> resource, int i2, int i3) {
        return resource;
    }

    public void b(MessageDigest messageDigest) {
    }
}
