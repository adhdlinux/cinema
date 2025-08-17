package kotlinx.serialization.json;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

public final class JsonElementSerializer implements KSerializer<JsonElement> {

    /* renamed from: a  reason: collision with root package name */
    public static final JsonElementSerializer f41153a = new JsonElementSerializer();

    /* renamed from: b  reason: collision with root package name */
    private static final SerialDescriptor f41154b = SerialDescriptorsKt.c("kotlinx.serialization.json.JsonElement", PolymorphicKind.SEALED.f40906a, new SerialDescriptor[0], JsonElementSerializer$descriptor$1.f41155f);

    private JsonElementSerializer() {
    }

    /* renamed from: a */
    public JsonElement deserialize(Decoder decoder) {
        Intrinsics.f(decoder, "decoder");
        return JsonElementSerializersKt.d(decoder).g();
    }

    /* renamed from: b */
    public void serialize(Encoder encoder, JsonElement jsonElement) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(jsonElement, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        JsonElementSerializersKt.h(encoder);
        if (jsonElement instanceof JsonPrimitive) {
            encoder.e(JsonPrimitiveSerializer.f41182a, jsonElement);
        } else if (jsonElement instanceof JsonObject) {
            encoder.e(JsonObjectSerializer.f41176a, jsonElement);
        } else if (jsonElement instanceof JsonArray) {
            encoder.e(JsonArraySerializer.f41122a, jsonElement);
        }
    }

    public SerialDescriptor getDescriptor() {
        return f41154b;
    }
}
