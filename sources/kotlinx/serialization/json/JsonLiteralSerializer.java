package kotlinx.serialization.json;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.ULong;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.UStringsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.json.internal.JsonExceptionsKt;

final class JsonLiteralSerializer implements KSerializer<JsonLiteral> {

    /* renamed from: a  reason: collision with root package name */
    public static final JsonLiteralSerializer f41164a = new JsonLiteralSerializer();

    /* renamed from: b  reason: collision with root package name */
    private static final SerialDescriptor f41165b = SerialDescriptorsKt.a("kotlinx.serialization.json.JsonLiteral", PrimitiveKind.STRING.f40915a);

    private JsonLiteralSerializer() {
    }

    /* renamed from: a */
    public JsonLiteral deserialize(Decoder decoder) {
        Intrinsics.f(decoder, "decoder");
        JsonElement g2 = JsonElementSerializersKt.d(decoder).g();
        if (g2 instanceof JsonLiteral) {
            return (JsonLiteral) g2;
        }
        throw JsonExceptionsKt.f(-1, "Unexpected JSON element, expected JsonLiteral, had " + Reflection.b(g2.getClass()), g2.toString());
    }

    /* renamed from: b */
    public void serialize(Encoder encoder, JsonLiteral jsonLiteral) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(jsonLiteral, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        JsonElementSerializersKt.h(encoder);
        if (jsonLiteral.b()) {
            encoder.G(jsonLiteral.a());
            return;
        }
        Long n2 = JsonElementKt.n(jsonLiteral);
        if (n2 != null) {
            encoder.m(n2.longValue());
            return;
        }
        ULong h2 = UStringsKt.h(jsonLiteral.a());
        if (h2 != null) {
            encoder.l(BuiltinSerializersKt.v(ULong.f40287c).getDescriptor()).m(h2.f());
            return;
        }
        Double h3 = JsonElementKt.h(jsonLiteral);
        if (h3 != null) {
            encoder.g(h3.doubleValue());
            return;
        }
        Boolean e2 = JsonElementKt.e(jsonLiteral);
        if (e2 != null) {
            encoder.r(e2.booleanValue());
        } else {
            encoder.G(jsonLiteral.a());
        }
    }

    public SerialDescriptor getDescriptor() {
        return f41165b;
    }
}
