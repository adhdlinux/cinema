package kotlinx.serialization.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

public final class ByteSerializer implements KSerializer<Byte> {

    /* renamed from: a  reason: collision with root package name */
    public static final ByteSerializer f40952a = new ByteSerializer();

    /* renamed from: b  reason: collision with root package name */
    private static final SerialDescriptor f40953b = new PrimitiveSerialDescriptor("kotlin.Byte", PrimitiveKind.BYTE.f40908a);

    private ByteSerializer() {
    }

    /* renamed from: a */
    public Byte deserialize(Decoder decoder) {
        Intrinsics.f(decoder, "decoder");
        return Byte.valueOf(decoder.H());
    }

    public void b(Encoder encoder, byte b2) {
        Intrinsics.f(encoder, "encoder");
        encoder.h(b2);
    }

    public SerialDescriptor getDescriptor() {
        return f40953b;
    }

    public /* bridge */ /* synthetic */ void serialize(Encoder encoder, Object obj) {
        b(encoder, ((Number) obj).byteValue());
    }
}
