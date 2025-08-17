package kotlinx.serialization.internal;

import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

public final class UByteSerializer implements KSerializer<UByte> {

    /* renamed from: a  reason: collision with root package name */
    public static final UByteSerializer f41097a = new UByteSerializer();

    /* renamed from: b  reason: collision with root package name */
    private static final SerialDescriptor f41098b = InlineClassDescriptorKt.a("kotlin.UByte", BuiltinSerializersKt.z(ByteCompanionObject.f40407a));

    private UByteSerializer() {
    }

    public byte a(Decoder decoder) {
        Intrinsics.f(decoder, "decoder");
        return UByte.b(decoder.q(getDescriptor()).H());
    }

    public void b(Encoder encoder, byte b2) {
        Intrinsics.f(encoder, "encoder");
        encoder.l(getDescriptor()).h(b2);
    }

    public /* bridge */ /* synthetic */ Object deserialize(Decoder decoder) {
        return UByte.a(a(decoder));
    }

    public SerialDescriptor getDescriptor() {
        return f41098b;
    }

    public /* bridge */ /* synthetic */ void serialize(Encoder encoder, Object obj) {
        b(encoder, ((UByte) obj).f());
    }
}
