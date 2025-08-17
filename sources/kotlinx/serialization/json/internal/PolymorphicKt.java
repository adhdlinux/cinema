package kotlinx.serialization.json.internal;

import java.lang.annotation.Annotation;
import kotlin.KotlinNothingValueException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.SealedClassSerializer;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.internal.AbstractPolymorphicSerializer;
import kotlinx.serialization.internal.JsonInternalDependenciesKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonClassDiscriminator;
import kotlinx.serialization.json.JsonDecoder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;

public final class PolymorphicKt {
    public static final void b(SerialKind serialKind) {
        Intrinsics.f(serialKind, "kind");
        if (serialKind instanceof SerialKind.ENUM) {
            throw new IllegalStateException("Enums cannot be serialized polymorphically with 'type' parameter. You can use 'JsonBuilder.useArrayPolymorphism' instead".toString());
        } else if (serialKind instanceof PrimitiveKind) {
            throw new IllegalStateException("Primitives cannot be serialized polymorphically with 'type' parameter. You can use 'JsonBuilder.useArrayPolymorphism' instead".toString());
        } else if (serialKind instanceof PolymorphicKind) {
            throw new IllegalStateException("Actual serializer for polymorphic cannot be polymorphic itself".toString());
        }
    }

    public static final String c(SerialDescriptor serialDescriptor, Json json) {
        Intrinsics.f(serialDescriptor, "<this>");
        Intrinsics.f(json, "json");
        for (Annotation next : serialDescriptor.getAnnotations()) {
            if (next instanceof JsonClassDiscriminator) {
                return ((JsonClassDiscriminator) next).discriminator();
            }
        }
        return json.e().c();
    }

    public static final <T> T d(JsonDecoder jsonDecoder, DeserializationStrategy<T> deserializationStrategy) {
        String str;
        JsonPrimitive l2;
        Intrinsics.f(jsonDecoder, "<this>");
        Intrinsics.f(deserializationStrategy, "deserializer");
        if (!(deserializationStrategy instanceof AbstractPolymorphicSerializer) || jsonDecoder.d().e().k()) {
            return deserializationStrategy.deserialize(jsonDecoder);
        }
        String c2 = c(deserializationStrategy.getDescriptor(), jsonDecoder.d());
        JsonElement g2 = jsonDecoder.g();
        SerialDescriptor descriptor = deserializationStrategy.getDescriptor();
        if (g2 instanceof JsonObject) {
            JsonObject jsonObject = (JsonObject) g2;
            JsonElement jsonElement = (JsonElement) jsonObject.get(c2);
            if (jsonElement == null || (l2 = JsonElementKt.l(jsonElement)) == null) {
                str = null;
            } else {
                str = l2.a();
            }
            DeserializationStrategy c3 = ((AbstractPolymorphicSerializer) deserializationStrategy).c(jsonDecoder, str);
            if (c3 != null) {
                return TreeJsonDecoderKt.b(jsonDecoder.d(), c2, jsonObject, c3);
            }
            e(str, jsonObject);
            throw new KotlinNothingValueException();
        }
        throw JsonExceptionsKt.e(-1, "Expected " + Reflection.b(JsonObject.class) + " as the serialized body of " + descriptor.i() + ", but had " + Reflection.b(g2.getClass()));
    }

    public static final Void e(String str, JsonObject jsonObject) {
        String str2;
        Intrinsics.f(jsonObject, "jsonTree");
        if (str == null) {
            str2 = "missing class discriminator ('null')";
        } else {
            str2 = "class discriminator '" + str + '\'';
        }
        throw JsonExceptionsKt.f(-1, "Polymorphic serializer was not found for " + str2, jsonObject.toString());
    }

    /* access modifiers changed from: private */
    public static final void f(SerializationStrategy<?> serializationStrategy, SerializationStrategy<Object> serializationStrategy2, String str) {
        if ((serializationStrategy instanceof SealedClassSerializer) && JsonInternalDependenciesKt.a(serializationStrategy2.getDescriptor()).contains(str)) {
            String i2 = serializationStrategy.getDescriptor().i();
            String i3 = serializationStrategy2.getDescriptor().i();
            throw new IllegalStateException(("Sealed class '" + i3 + "' cannot be serialized as base class '" + i2 + "' because it has property name that conflicts with JSON class discriminator '" + str + "'. You can either change class discriminator in JsonConfiguration, rename property with @SerialName annotation or fall back to array polymorphism").toString());
        }
    }
}
