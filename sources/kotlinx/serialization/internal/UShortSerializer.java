package kotlinx.serialization.internal;

import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.ShortCompanionObject;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

public final class UShortSerializer implements KSerializer<UShort> {

    /* renamed from: a  reason: collision with root package name */
    public static final UShortSerializer f41112a = new UShortSerializer();

    /* renamed from: b  reason: collision with root package name */
    private static final SerialDescriptor f41113b = InlineClassDescriptorKt.a("kotlin.UShort", BuiltinSerializersKt.F(ShortCompanionObject.f40432a));

    private UShortSerializer() {
    }

    public short a(Decoder decoder) {
        Intrinsics.f(decoder, "decoder");
        return UShort.b(decoder.q(getDescriptor()).s());
    }

    public void b(Encoder encoder, short s2) {
        Intrinsics.f(encoder, "encoder");
        encoder.l(getDescriptor()).q(s2);
    }

    public /* bridge */ /* synthetic */ Object deserialize(Decoder decoder) {
        return UShort.a(a(decoder));
    }

    public SerialDescriptor getDescriptor() {
        return f41113b;
    }

    public /* bridge */ /* synthetic */ void serialize(Encoder encoder, Object obj) {
        b(encoder, ((UShort) obj).f());
    }
}
