package kotlinx.serialization;

import java.util.List;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlinx.serialization.modules.SerializersModule;

public final class SerializersKt {
    public static final KSerializer<? extends Object> a(KClass<Object> kClass, List<? extends KType> list, List<? extends KSerializer<Object>> list2) {
        return SerializersKt__SerializersKt.d(kClass, list, list2);
    }

    public static final KSerializer<Object> b(SerializersModule serializersModule, KType kType) {
        return SerializersKt__SerializersKt.e(serializersModule, kType);
    }

    public static final <T> KSerializer<T> c(KClass<T> kClass) {
        return SerializersKt__SerializersKt.g(kClass);
    }

    public static final KSerializer<Object> d(SerializersModule serializersModule, KType kType) {
        return SerializersKt__SerializersKt.h(serializersModule, kType);
    }

    public static final List<KSerializer<Object>> e(SerializersModule serializersModule, List<? extends KType> list, boolean z2) {
        return SerializersKt__SerializersKt.i(serializersModule, list, z2);
    }
}
