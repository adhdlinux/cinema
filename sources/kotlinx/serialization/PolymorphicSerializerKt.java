package kotlinx.serialization;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.KotlinNothingValueException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.AbstractPolymorphicSerializer;
import kotlinx.serialization.internal.AbstractPolymorphicSerializerKt;

public final class PolymorphicSerializerKt {
    public static final <T> DeserializationStrategy<? extends T> a(AbstractPolymorphicSerializer<T> abstractPolymorphicSerializer, CompositeDecoder compositeDecoder, String str) {
        Intrinsics.f(abstractPolymorphicSerializer, "<this>");
        Intrinsics.f(compositeDecoder, "decoder");
        DeserializationStrategy<? extends T> c2 = abstractPolymorphicSerializer.c(compositeDecoder, str);
        if (c2 != null) {
            return c2;
        }
        AbstractPolymorphicSerializerKt.a(str, abstractPolymorphicSerializer.e());
        throw new KotlinNothingValueException();
    }

    public static final <T> SerializationStrategy<T> b(AbstractPolymorphicSerializer<T> abstractPolymorphicSerializer, Encoder encoder, T t2) {
        Intrinsics.f(abstractPolymorphicSerializer, "<this>");
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(t2, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        SerializationStrategy<T> d2 = abstractPolymorphicSerializer.d(encoder, t2);
        if (d2 != null) {
            return d2;
        }
        AbstractPolymorphicSerializerKt.b(Reflection.b(t2.getClass()), abstractPolymorphicSerializer.e());
        throw new KotlinNothingValueException();
    }
}
