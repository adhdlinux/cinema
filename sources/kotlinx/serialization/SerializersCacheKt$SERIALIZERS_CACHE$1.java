package kotlinx.serialization;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KClass;

final class SerializersCacheKt$SERIALIZERS_CACHE$1 extends Lambda implements Function1<KClass<?>, KSerializer<? extends Object>> {

    /* renamed from: f  reason: collision with root package name */
    public static final SerializersCacheKt$SERIALIZERS_CACHE$1 f40893f = new SerializersCacheKt$SERIALIZERS_CACHE$1();

    SerializersCacheKt$SERIALIZERS_CACHE$1() {
        super(1);
    }

    /* renamed from: a */
    public final KSerializer<? extends Object> invoke(KClass<?> kClass) {
        Intrinsics.f(kClass, "it");
        return SerializersKt.c(kClass);
    }
}
