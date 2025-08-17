package kotlinx.serialization.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

public final class DoubleSerializer implements KSerializer<Double> {

    /* renamed from: a  reason: collision with root package name */
    public static final DoubleSerializer f40974a = new DoubleSerializer();

    /* renamed from: b  reason: collision with root package name */
    private static final SerialDescriptor f40975b = new PrimitiveSerialDescriptor("kotlin.Double", PrimitiveKind.DOUBLE.f40910a);

    private DoubleSerializer() {
    }

    /* renamed from: a */
    public Double deserialize(Decoder decoder) {
        Intrinsics.f(decoder, "decoder");
        return Double.valueOf(decoder.v());
    }

    public void b(Encoder encoder, double d2) {
        Intrinsics.f(encoder, "encoder");
        encoder.g(d2);
    }

    public SerialDescriptor getDescriptor() {
        return f40975b;
    }

    public /* bridge */ /* synthetic */ void serialize(Encoder encoder, Object obj) {
        b(encoder, ((Number) obj).doubleValue());
    }
}
