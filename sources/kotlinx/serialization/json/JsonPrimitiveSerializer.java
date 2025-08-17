package kotlinx.serialization.json;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.json.internal.JsonExceptionsKt;

public final class JsonPrimitiveSerializer implements KSerializer<JsonPrimitive> {

    /* renamed from: a  reason: collision with root package name */
    public static final JsonPrimitiveSerializer f41182a = new JsonPrimitiveSerializer();

    /* renamed from: b  reason: collision with root package name */
    private static final SerialDescriptor f41183b = SerialDescriptorsKt.d("kotlinx.serialization.json.JsonPrimitive", PrimitiveKind.STRING.f40915a, new SerialDescriptor[0], (Function1) null, 8, (Object) null);

    private JsonPrimitiveSerializer() {
    }

    /* renamed from: a */
    public JsonPrimitive deserialize(Decoder decoder) {
        Intrinsics.f(decoder, "decoder");
        JsonElement g2 = JsonElementSerializersKt.d(decoder).g();
        if (g2 instanceof JsonPrimitive) {
            return (JsonPrimitive) g2;
        }
        throw JsonExceptionsKt.f(-1, "Unexpected JSON element, expected JsonPrimitive, had " + Reflection.b(g2.getClass()), g2.toString());
    }

    /* renamed from: b */
    public void serialize(Encoder encoder, JsonPrimitive jsonPrimitive) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(jsonPrimitive, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        JsonElementSerializersKt.h(encoder);
        if (jsonPrimitive instanceof JsonNull) {
            encoder.e(JsonNullSerializer.f41170a, JsonNull.f41166d);
        } else {
            encoder.e(JsonLiteralSerializer.f41164a, (JsonLiteral) jsonPrimitive);
        }
    }

    public SerialDescriptor getDescriptor() {
        return f41183b;
    }
}
