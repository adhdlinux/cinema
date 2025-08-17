package kotlinx.serialization.internal;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlinx.serialization.KSerializer;

final class ConcurrentHashMapParametrizedCache<T> implements ParametrizedSerializerCache<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Function2<KClass<Object>, List<? extends KType>, KSerializer<T>> f40969a;

    /* renamed from: b  reason: collision with root package name */
    private final ConcurrentHashMap<Class<?>, ParametrizedCacheEntry<T>> f40970b = new ConcurrentHashMap<>();

    public ConcurrentHashMapParametrizedCache(Function2<? super KClass<Object>, ? super List<? extends KType>, ? extends KSerializer<T>> function2) {
        Intrinsics.f(function2, "compute");
        this.f40969a = function2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0016, code lost:
        r2 = new kotlinx.serialization.internal.ParametrizedCacheEntry<>();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object a(kotlin.reflect.KClass<java.lang.Object> r4, java.util.List<? extends kotlin.reflect.KType> r5) {
        /*
            r3 = this;
            java.lang.String r0 = "key"
            kotlin.jvm.internal.Intrinsics.f(r4, r0)
            java.lang.String r0 = "types"
            kotlin.jvm.internal.Intrinsics.f(r5, r0)
            java.util.concurrent.ConcurrentHashMap<java.lang.Class<?>, kotlinx.serialization.internal.ParametrizedCacheEntry<T>> r0 = r3.f40970b
            java.lang.Class r1 = kotlin.jvm.JvmClassMappingKt.a(r4)
            java.lang.Object r2 = r0.get(r1)
            if (r2 != 0) goto L_0x0023
            kotlinx.serialization.internal.ParametrizedCacheEntry r2 = new kotlinx.serialization.internal.ParametrizedCacheEntry
            r2.<init>()
            java.lang.Object r0 = r0.putIfAbsent(r1, r2)
            if (r0 != 0) goto L_0x0022
            goto L_0x0023
        L_0x0022:
            r2 = r0
        L_0x0023:
            kotlinx.serialization.internal.ParametrizedCacheEntry r2 = (kotlinx.serialization.internal.ParametrizedCacheEntry) r2
            java.util.concurrent.ConcurrentHashMap r0 = r2.f41043a
            java.lang.Object r1 = r0.get(r5)
            if (r1 != 0) goto L_0x0056
            kotlin.Result$Companion r1 = kotlin.Result.f40263c     // Catch:{ all -> 0x003e }
            kotlin.jvm.functions.Function2<kotlin.reflect.KClass<java.lang.Object>, java.util.List<? extends kotlin.reflect.KType>, kotlinx.serialization.KSerializer<T>> r1 = r3.f40969a     // Catch:{ all -> 0x003e }
            java.lang.Object r4 = r1.invoke(r4, r5)     // Catch:{ all -> 0x003e }
            kotlinx.serialization.KSerializer r4 = (kotlinx.serialization.KSerializer) r4     // Catch:{ all -> 0x003e }
            java.lang.Object r4 = kotlin.Result.b(r4)     // Catch:{ all -> 0x003e }
            goto L_0x0049
        L_0x003e:
            r4 = move-exception
            kotlin.Result$Companion r1 = kotlin.Result.f40263c
            java.lang.Object r4 = kotlin.ResultKt.a(r4)
            java.lang.Object r4 = kotlin.Result.b(r4)
        L_0x0049:
            kotlin.Result r4 = kotlin.Result.a(r4)
            java.lang.Object r5 = r0.putIfAbsent(r5, r4)
            if (r5 != 0) goto L_0x0055
            r1 = r4
            goto L_0x0056
        L_0x0055:
            r1 = r5
        L_0x0056:
            java.lang.String r4 = "serializers.getOrPut(typ… { producer() }\n        }"
            kotlin.jvm.internal.Intrinsics.e(r1, r4)
            kotlin.Result r1 = (kotlin.Result) r1
            java.lang.Object r4 = r1.j()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.internal.ConcurrentHashMapParametrizedCache.a(kotlin.reflect.KClass, java.util.List):java.lang.Object");
    }
}
