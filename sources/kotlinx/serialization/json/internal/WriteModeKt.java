package kotlinx.serialization.json.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.ContextAwareKt;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.modules.SerializersModule;

public final class WriteModeKt {
    public static final SerialDescriptor a(SerialDescriptor serialDescriptor, SerializersModule serializersModule) {
        SerialDescriptor a2;
        Intrinsics.f(serialDescriptor, "<this>");
        Intrinsics.f(serializersModule, "module");
        if (Intrinsics.a(serialDescriptor.d(), SerialKind.CONTEXTUAL.f40937a)) {
            SerialDescriptor b2 = ContextAwareKt.b(serializersModule, serialDescriptor);
            if (b2 == null || (a2 = a(b2, serializersModule)) == null) {
                return serialDescriptor;
            }
            return a2;
        } else if (serialDescriptor.isInline()) {
            return a(serialDescriptor.h(0), serializersModule);
        } else {
            return serialDescriptor;
        }
    }

    public static final WriteMode b(Json json, SerialDescriptor serialDescriptor) {
        Intrinsics.f(json, "<this>");
        Intrinsics.f(serialDescriptor, "desc");
        SerialKind d2 = serialDescriptor.d();
        if (d2 instanceof PolymorphicKind) {
            return WriteMode.POLY_OBJ;
        }
        if (Intrinsics.a(d2, StructureKind.LIST.f40940a)) {
            return WriteMode.LIST;
        }
        if (!Intrinsics.a(d2, StructureKind.MAP.f40941a)) {
            return WriteMode.OBJ;
        }
        SerialDescriptor a2 = a(serialDescriptor.h(0), json.a());
        SerialKind d3 = a2.d();
        if ((d3 instanceof PrimitiveKind) || Intrinsics.a(d3, SerialKind.ENUM.f40938a)) {
            return WriteMode.MAP;
        }
        if (json.e().b()) {
            return WriteMode.LIST;
        }
        throw JsonExceptionsKt.d(a2);
    }
}
