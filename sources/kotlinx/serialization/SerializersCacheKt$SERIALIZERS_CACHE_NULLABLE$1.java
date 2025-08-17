package kotlinx.serialization;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KClass;
import kotlinx.serialization.builtins.BuiltinSerializersKt;

final class SerializersCacheKt$SERIALIZERS_CACHE_NULLABLE$1 extends Lambda implements Function1<KClass<?>, KSerializer<Object>> {

    /* renamed from: f  reason: collision with root package name */
    public static final SerializersCacheKt$SERIALIZERS_CACHE_NULLABLE$1 f40894f = new SerializersCacheKt$SERIALIZERS_CACHE_NULLABLE$1();

    SerializersCacheKt$SERIALIZERS_CACHE_NULLABLE$1() {
        super(1);
    }

    /* renamed from: a */
    public final KSerializer<Object> invoke(KClass<?> kClass) {
        KSerializer<Object> s2;
        Intrinsics.f(kClass, "it");
        KSerializer<?> c2 = SerializersKt.c(kClass);
        if (c2 == null || (s2 = BuiltinSerializersKt.s(c2)) == null) {
            return null;
        }
        return s2;
    }
}
