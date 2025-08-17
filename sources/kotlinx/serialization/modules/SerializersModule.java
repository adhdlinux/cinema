package kotlinx.serialization.modules;

import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KClass;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationStrategy;

public abstract class SerializersModule {
    private SerializersModule() {
    }

    public /* synthetic */ SerializersModule(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static /* synthetic */ KSerializer c(SerializersModule serializersModule, KClass kClass, List list, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                list = CollectionsKt__CollectionsKt.f();
            }
            return serializersModule.b(kClass, list);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getContextual");
    }

    public abstract void a(SerializersModuleCollector serializersModuleCollector);

    public abstract <T> KSerializer<T> b(KClass<T> kClass, List<? extends KSerializer<?>> list);

    public abstract <T> DeserializationStrategy<? extends T> d(KClass<? super T> kClass, String str);

    public abstract <T> SerializationStrategy<T> e(KClass<? super T> kClass, T t2);
}
