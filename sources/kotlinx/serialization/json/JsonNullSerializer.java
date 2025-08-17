package kotlinx.serialization.json;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.json.internal.JsonDecodingException;

public final class JsonNullSerializer implements KSerializer<JsonNull> {

    /* renamed from: a  reason: collision with root package name */
    public static final JsonNullSerializer f41170a = new JsonNullSerializer();

    /* renamed from: b  reason: collision with root package name */
    private static final SerialDescriptor f41171b = SerialDescriptorsKt.d("kotlinx.serialization.json.JsonNull", SerialKind.ENUM.f40938a, new SerialDescriptor[0], (Function1) null, 8, (Object) null);

    private JsonNullSerializer() {
    }

    /* renamed from: a */
    public JsonNull deserialize(Decoder decoder) {
        Intrinsics.f(decoder, "decoder");
        JsonElementSerializersKt.g(decoder);
        if (!decoder.D()) {
            decoder.j();
            return JsonNull.f41166d;
        }
        throw new JsonDecodingException("Expected 'null' literal");
    }

    /* renamed from: b */
    public void serialize(Encoder encoder, JsonNull jsonNull) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(jsonNull, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        JsonElementSerializersKt.h(encoder);
        encoder.o();
    }

    public SerialDescriptor getDescriptor() {
        return f41171b;
    }
}
