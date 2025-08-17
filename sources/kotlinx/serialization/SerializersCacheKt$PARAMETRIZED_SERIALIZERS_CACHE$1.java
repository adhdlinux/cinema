package kotlinx.serialization;

import java.util.List;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlinx.serialization.modules.SerializersModuleBuildersKt;

final class SerializersCacheKt$PARAMETRIZED_SERIALIZERS_CACHE$1 extends Lambda implements Function2<KClass<Object>, List<? extends KType>, KSerializer<? extends Object>> {

    /* renamed from: f  reason: collision with root package name */
    public static final SerializersCacheKt$PARAMETRIZED_SERIALIZERS_CACHE$1 f40891f = new SerializersCacheKt$PARAMETRIZED_SERIALIZERS_CACHE$1();

    SerializersCacheKt$PARAMETRIZED_SERIALIZERS_CACHE$1() {
        super(2);
    }

    /* renamed from: a */
    public final KSerializer<? extends Object> invoke(KClass<Object> kClass, List<? extends KType> list) {
        Intrinsics.f(kClass, "clazz");
        Intrinsics.f(list, "types");
        List<KSerializer<Object>> e2 = SerializersKt.e(SerializersModuleBuildersKt.a(), list, true);
        Intrinsics.c(e2);
        return SerializersKt.a(kClass, list, e2);
    }
}
