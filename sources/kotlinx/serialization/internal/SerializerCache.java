package kotlinx.serialization.internal;

import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;

public interface SerializerCache<T> {
    KSerializer<T> a(KClass<Object> kClass);
}
