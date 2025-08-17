package kotlinx.serialization.descriptors;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.internal.SerialDescriptorForNullable;
import kotlinx.serialization.modules.SerializersModule;

public final class ContextAwareKt {
    public static final KClass<?> a(SerialDescriptor serialDescriptor) {
        Intrinsics.f(serialDescriptor, "<this>");
        if (serialDescriptor instanceof ContextDescriptor) {
            return ((ContextDescriptor) serialDescriptor).f40903b;
        }
        if (serialDescriptor instanceof SerialDescriptorForNullable) {
            return a(((SerialDescriptorForNullable) serialDescriptor).k());
        }
        return null;
    }

    public static final SerialDescriptor b(SerializersModule serializersModule, SerialDescriptor serialDescriptor) {
        KSerializer c2;
        Intrinsics.f(serializersModule, "<this>");
        Intrinsics.f(serialDescriptor, "descriptor");
        KClass<?> a2 = a(serialDescriptor);
        if (a2 == null || (c2 = SerializersModule.c(serializersModule, a2, (List) null, 2, (Object) null)) == null) {
            return null;
        }
        return c2.getDescriptor();
    }

    public static final SerialDescriptor c(SerialDescriptor serialDescriptor, KClass<?> kClass) {
        Intrinsics.f(serialDescriptor, "<this>");
        Intrinsics.f(kClass, "context");
        return new ContextDescriptor(serialDescriptor, kClass);
    }
}
