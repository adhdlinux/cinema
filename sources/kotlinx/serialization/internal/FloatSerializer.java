package kotlinx.serialization.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

public final class FloatSerializer implements KSerializer<Float> {

    /* renamed from: a  reason: collision with root package name */
    public static final FloatSerializer f40997a = new FloatSerializer();

    /* renamed from: b  reason: collision with root package name */
    private static final SerialDescriptor f40998b = new PrimitiveSerialDescriptor("kotlin.Float", PrimitiveKind.FLOAT.f40911a);

    private FloatSerializer() {
    }

    /* renamed from: a */
    public Float deserialize(Decoder decoder) {
        Intrinsics.f(decoder, "decoder");
        return Float.valueOf(decoder.t());
    }

    public void b(Encoder encoder, float f2) {
        Intrinsics.f(encoder, "encoder");
        encoder.t(f2);
    }

    public SerialDescriptor getDescriptor() {
        return f40998b;
    }

    public /* bridge */ /* synthetic */ void serialize(Encoder encoder, Object obj) {
        b(encoder, ((Number) obj).floatValue());
    }
}
