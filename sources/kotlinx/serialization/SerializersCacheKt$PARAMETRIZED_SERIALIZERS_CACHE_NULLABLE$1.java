package kotlinx.serialization;

import java.util.List;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.modules.SerializersModuleBuildersKt;

final class SerializersCacheKt$PARAMETRIZED_SERIALIZERS_CACHE_NULLABLE$1 extends Lambda implements Function2<KClass<Object>, List<? extends KType>, KSerializer<Object>> {

    /* renamed from: f  reason: collision with root package name */
    public static final SerializersCacheKt$PARAMETRIZED_SERIALIZERS_CACHE_NULLABLE$1 f40892f = new SerializersCacheKt$PARAMETRIZED_SERIALIZERS_CACHE_NULLABLE$1();

    SerializersCacheKt$PARAMETRIZED_SERIALIZERS_CACHE_NULLABLE$1() {
        super(2);
    }

    /* renamed from: a */
    public final KSerializer<Object> invoke(KClass<Object> kClass, List<? extends KType> list) {
        KSerializer<Object> s2;
        Intrinsics.f(kClass, "clazz");
        Intrinsics.f(list, "types");
        List<KSerializer<Object>> e2 = SerializersKt.e(SerializersModuleBuildersKt.a(), list, true);
        Intrinsics.c(e2);
        KSerializer<? extends Object> a2 = SerializersKt.a(kClass, list, e2);
        if (a2 == null || (s2 = BuiltinSerializersKt.s(a2)) == null) {
            return null;
        }
        return s2;
    }
}
