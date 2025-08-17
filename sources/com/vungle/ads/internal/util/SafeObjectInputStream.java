package com.vungle.ads.internal.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

public final class SafeObjectInputStream extends ObjectInputStream {
    private final List<Class<?>> allowed;

    public SafeObjectInputStream(InputStream inputStream, List<? extends Class<?>> list) {
        super(inputStream);
        this.allowed = list;
    }

    /* access modifiers changed from: protected */
    public Class<?> resolveClass(ObjectStreamClass objectStreamClass) throws ClassNotFoundException, IOException {
        Intrinsics.f(objectStreamClass, "desc");
        Class<?> resolveClass = super.resolveClass(objectStreamClass);
        if (this.allowed == null || Number.class.isAssignableFrom(resolveClass) || Intrinsics.a(String.class, resolveClass) || Intrinsics.a(Boolean.class, resolveClass) || resolveClass.isArray() || this.allowed.contains(resolveClass)) {
            Intrinsics.e(resolveClass, "c");
            return resolveClass;
        }
        throw new IOException("Deserialization is not allowed for " + objectStreamClass.getName());
    }
}
