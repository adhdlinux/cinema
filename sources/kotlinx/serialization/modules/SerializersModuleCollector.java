package kotlinx.serialization.modules;

import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationStrategy;

public interface SerializersModuleCollector {

    public static final class DefaultImpls {
        public static <T> void a(SerializersModuleCollector serializersModuleCollector, KClass<T> kClass, KSerializer<T> kSerializer) {
            Intrinsics.f(kClass, "kClass");
            Intrinsics.f(kSerializer, "serializer");
            serializersModuleCollector.e(kClass, new SerializersModuleCollector$contextual$1(kSerializer));
        }
    }

    <Base, Sub extends Base> void a(KClass<Base> kClass, KClass<Sub> kClass2, KSerializer<Sub> kSerializer);

    <Base> void b(KClass<Base> kClass, Function1<? super String, ? extends DeserializationStrategy<? extends Base>> function1);

    <T> void c(KClass<T> kClass, KSerializer<T> kSerializer);

    <Base> void d(KClass<Base> kClass, Function1<? super Base, ? extends SerializationStrategy<? super Base>> function1);

    <T> void e(KClass<T> kClass, Function1<? super List<? extends KSerializer<?>>, ? extends KSerializer<?>> function1);
}
