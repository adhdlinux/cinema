package kotlinx.serialization;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlinx.serialization.internal.CachingKt;
import kotlinx.serialization.internal.ParametrizedSerializerCache;
import kotlinx.serialization.internal.SerializerCache;

public final class SerializersCacheKt {

    /* renamed from: a  reason: collision with root package name */
    private static final SerializerCache<? extends Object> f40887a = CachingKt.a(SerializersCacheKt$SERIALIZERS_CACHE$1.f40893f);

    /* renamed from: b  reason: collision with root package name */
    private static final SerializerCache<Object> f40888b = CachingKt.a(SerializersCacheKt$SERIALIZERS_CACHE_NULLABLE$1.f40894f);

    /* renamed from: c  reason: collision with root package name */
    private static final ParametrizedSerializerCache<? extends Object> f40889c = CachingKt.b(SerializersCacheKt$PARAMETRIZED_SERIALIZERS_CACHE$1.f40891f);

    /* renamed from: d  reason: collision with root package name */
    private static final ParametrizedSerializerCache<Object> f40890d = CachingKt.b(SerializersCacheKt$PARAMETRIZED_SERIALIZERS_CACHE_NULLABLE$1.f40892f);

    public static final KSerializer<Object> a(KClass<Object> kClass, boolean z2) {
        Intrinsics.f(kClass, "clazz");
        if (z2) {
            return f40888b.a(kClass);
        }
        KSerializer<? extends Object> a2 = f40887a.a(kClass);
        if (a2 != null) {
            return a2;
        }
        return null;
    }

    public static final Object b(KClass<Object> kClass, List<? extends KType> list, boolean z2) {
        Intrinsics.f(kClass, "clazz");
        Intrinsics.f(list, "types");
        if (!z2) {
            return f40889c.a(kClass, list);
        }
        return f40890d.a(kClass, list);
    }
}
