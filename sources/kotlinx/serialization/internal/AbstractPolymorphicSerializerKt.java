package kotlinx.serialization.internal;

import kotlin.KotlinNothingValueException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.SerializationException;

public final class AbstractPolymorphicSerializerKt {
    public static final Void a(String str, KClass<?> kClass) {
        String str2;
        Intrinsics.f(kClass, "baseClass");
        String str3 = "in the scope of '" + kClass.e() + '\'';
        if (str == null) {
            str2 = "Class discriminator was missing and no default polymorphic serializers were registered " + str3;
        } else {
            str2 = "Class '" + str + "' is not registered for polymorphic serialization " + str3 + ".\nMark the base class as 'sealed' or register the serializer explicitly.";
        }
        throw new SerializationException(str2);
    }

    public static final Void b(KClass<?> kClass, KClass<?> kClass2) {
        Intrinsics.f(kClass, "subClass");
        Intrinsics.f(kClass2, "baseClass");
        String e2 = kClass.e();
        if (e2 == null) {
            e2 = String.valueOf(kClass);
        }
        a(e2, kClass2);
        throw new KotlinNothingValueException();
    }
}
