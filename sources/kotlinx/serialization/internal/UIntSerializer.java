package kotlinx.serialization.internal;

import kotlin.UInt;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

public final class UIntSerializer implements KSerializer<UInt> {

    /* renamed from: a  reason: collision with root package name */
    public static final UIntSerializer f41102a = new UIntSerializer();

    /* renamed from: b  reason: collision with root package name */
    private static final SerialDescriptor f41103b = InlineClassDescriptorKt.a("kotlin.UInt", BuiltinSerializersKt.D(IntCompanionObject.f40420a));

    private UIntSerializer() {
    }

    public int a(Decoder decoder) {
        Intrinsics.f(decoder, "decoder");
        return UInt.b(decoder.q(getDescriptor()).h());
    }

    public void b(Encoder encoder, int i2) {
        Intrinsics.f(encoder, "encoder");
        encoder.l(getDescriptor()).B(i2);
    }

    public /* bridge */ /* synthetic */ Object deserialize(Decoder decoder) {
        return UInt.a(a(decoder));
    }

    public SerialDescriptor getDescriptor() {
        return f41103b;
    }

    public /* bridge */ /* synthetic */ void serialize(Encoder encoder, Object obj) {
        b(encoder, ((UInt) obj).f());
    }
}
