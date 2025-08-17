package kotlinx.serialization.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

public final class IntSerializer implements KSerializer<Integer> {

    /* renamed from: a  reason: collision with root package name */
    public static final IntSerializer f41006a = new IntSerializer();

    /* renamed from: b  reason: collision with root package name */
    private static final SerialDescriptor f41007b = new PrimitiveSerialDescriptor("kotlin.Int", PrimitiveKind.INT.f40912a);

    private IntSerializer() {
    }

    /* renamed from: a */
    public Integer deserialize(Decoder decoder) {
        Intrinsics.f(decoder, "decoder");
        return Integer.valueOf(decoder.h());
    }

    public void b(Encoder encoder, int i2) {
        Intrinsics.f(encoder, "encoder");
        encoder.B(i2);
    }

    public SerialDescriptor getDescriptor() {
        return f41007b;
    }

    public /* bridge */ /* synthetic */ void serialize(Encoder encoder, Object obj) {
        b(encoder, ((Number) obj).intValue());
    }
}
