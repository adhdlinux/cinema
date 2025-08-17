package kotlinx.serialization.internal;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;

final class ConcurrentHashMapCache<T> implements SerializerCache<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Function1<KClass<?>, KSerializer<T>> f40967a;

    /* renamed from: b  reason: collision with root package name */
    private final ConcurrentHashMap<Class<?>, CacheEntry<T>> f40968b = new ConcurrentHashMap<>();

    public ConcurrentHashMapCache(Function1<? super KClass<?>, ? extends KSerializer<T>> function1) {
        Intrinsics.f(function1, "compute");
        this.f40967a = function1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0011, code lost:
        r2 = new kotlinx.serialization.internal.CacheEntry<>(r4.f40967a.invoke(r5));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public kotlinx.serialization.KSerializer<T> a(kotlin.reflect.KClass<java.lang.Object> r5) {
        /*
            r4 = this;
            java.lang.String r0 = "key"
            kotlin.jvm.internal.Intrinsics.f(r5, r0)
            java.util.concurrent.ConcurrentHashMap<java.lang.Class<?>, kotlinx.serialization.internal.CacheEntry<T>> r0 = r4.f40968b
            java.lang.Class r1 = kotlin.jvm.JvmClassMappingKt.a(r5)
            java.lang.Object r2 = r0.get(r1)
            if (r2 != 0) goto L_0x0026
            kotlinx.serialization.internal.CacheEntry r2 = new kotlinx.serialization.internal.CacheEntry
            kotlin.jvm.functions.Function1<kotlin.reflect.KClass<?>, kotlinx.serialization.KSerializer<T>> r3 = r4.f40967a
            java.lang.Object r5 = r3.invoke(r5)
            kotlinx.serialization.KSerializer r5 = (kotlinx.serialization.KSerializer) r5
            r2.<init>(r5)
            java.lang.Object r5 = r0.putIfAbsent(r1, r2)
            if (r5 != 0) goto L_0x0025
            goto L_0x0026
        L_0x0025:
            r2 = r5
        L_0x0026:
            kotlinx.serialization.internal.CacheEntry r2 = (kotlinx.serialization.internal.CacheEntry) r2
            kotlinx.serialization.KSerializer<T> r5 = r2.f40954a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.internal.ConcurrentHashMapCache.a(kotlin.reflect.KClass):kotlinx.serialization.KSerializer");
    }
}
