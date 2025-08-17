package kotlinx.serialization.json.internal;

import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind;
import kotlinx.serialization.modules.SerializersModuleCollector;

public final class PolymorphismValidator implements SerializersModuleCollector {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f41254a;

    /* renamed from: b  reason: collision with root package name */
    private final String f41255b;

    public PolymorphismValidator(boolean z2, String str) {
        Intrinsics.f(str, "discriminator");
        this.f41254a = z2;
        this.f41255b = str;
    }

    private final void f(SerialDescriptor serialDescriptor, KClass<?> kClass) {
        int e2 = serialDescriptor.e();
        int i2 = 0;
        while (i2 < e2) {
            String f2 = serialDescriptor.f(i2);
            if (!Intrinsics.a(f2, this.f41255b)) {
                i2++;
            } else {
                throw new IllegalArgumentException("Polymorphic serializer for " + kClass + " has property '" + f2 + "' that conflicts with JSON class discriminator. You can either change class discriminator in JsonConfiguration, rename property with @SerialName annotation or fall back to array polymorphism");
            }
        }
    }

    private final void g(SerialDescriptor serialDescriptor, KClass<?> kClass) {
        SerialKind d2 = serialDescriptor.d();
        if ((d2 instanceof PolymorphicKind) || Intrinsics.a(d2, SerialKind.CONTEXTUAL.f40937a)) {
            throw new IllegalArgumentException("Serializer for " + kClass.e() + " can't be registered as a subclass for polymorphic serialization because its kind " + d2 + " is not concrete. To work with multiple hierarchies, register it as a base class.");
        } else if (!this.f41254a) {
            if (Intrinsics.a(d2, StructureKind.LIST.f40940a) || Intrinsics.a(d2, StructureKind.MAP.f40941a) || (d2 instanceof PrimitiveKind) || (d2 instanceof SerialKind.ENUM)) {
                throw new IllegalArgumentException("Serializer for " + kClass.e() + " of kind " + d2 + " cannot be serialized polymorphically with class discriminator.");
            }
        }
    }

    public <Base, Sub extends Base> void a(KClass<Base> kClass, KClass<Sub> kClass2, KSerializer<Sub> kSerializer) {
        Intrinsics.f(kClass, "baseClass");
        Intrinsics.f(kClass2, "actualClass");
        Intrinsics.f(kSerializer, "actualSerializer");
        SerialDescriptor descriptor = kSerializer.getDescriptor();
        g(descriptor, kClass2);
        if (!this.f41254a) {
            f(descriptor, kClass2);
        }
    }

    public <Base> void b(KClass<Base> kClass, Function1<? super String, ? extends DeserializationStrategy<? extends Base>> function1) {
        Intrinsics.f(kClass, "baseClass");
        Intrinsics.f(function1, "defaultDeserializerProvider");
    }

    public <T> void c(KClass<T> kClass, KSerializer<T> kSerializer) {
        SerializersModuleCollector.DefaultImpls.a(this, kClass, kSerializer);
    }

    public <Base> void d(KClass<Base> kClass, Function1<? super Base, ? extends SerializationStrategy<? super Base>> function1) {
        Intrinsics.f(kClass, "baseClass");
        Intrinsics.f(function1, "defaultSerializerProvider");
    }

    public <T> void e(KClass<T> kClass, Function1<? super List<? extends KSerializer<?>>, ? extends KSerializer<?>> function1) {
        Intrinsics.f(kClass, "kClass");
        Intrinsics.f(function1, "provider");
    }
}
