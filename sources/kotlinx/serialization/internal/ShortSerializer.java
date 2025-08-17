package kotlinx.serialization.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

public final class ShortSerializer implements KSerializer<Short> {

    /* renamed from: a  reason: collision with root package name */
    public static final ShortSerializer f41075a = new ShortSerializer();

    /* renamed from: b  reason: collision with root package name */
    private static final SerialDescriptor f41076b = new PrimitiveSerialDescriptor("kotlin.Short", PrimitiveKind.SHORT.f40914a);

    private ShortSerializer() {
    }

    /* renamed from: a */
    public Short deserialize(Decoder decoder) {
        Intrinsics.f(decoder, "decoder");
        return Short.valueOf(decoder.s());
    }

    public void b(Encoder encoder, short s2) {
        Intrinsics.f(encoder, "encoder");
        encoder.q(s2);
    }

    public SerialDescriptor getDescriptor() {
        return f41076b;
    }

    public /* bridge */ /* synthetic */ void serialize(Encoder encoder, Object obj) {
        b(encoder, ((Number) obj).shortValue());
    }
}
