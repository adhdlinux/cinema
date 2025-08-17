package kotlinx.serialization.internal;

import kotlin.ULong;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

public final class ULongSerializer implements KSerializer<ULong> {

    /* renamed from: a  reason: collision with root package name */
    public static final ULongSerializer f41107a = new ULongSerializer();

    /* renamed from: b  reason: collision with root package name */
    private static final SerialDescriptor f41108b = InlineClassDescriptorKt.a("kotlin.ULong", BuiltinSerializersKt.E(LongCompanionObject.f40421a));

    private ULongSerializer() {
    }

    public long a(Decoder decoder) {
        Intrinsics.f(decoder, "decoder");
        return ULong.b(decoder.q(getDescriptor()).l());
    }

    public void b(Encoder encoder, long j2) {
        Intrinsics.f(encoder, "encoder");
        encoder.l(getDescriptor()).m(j2);
    }

    public /* bridge */ /* synthetic */ Object deserialize(Decoder decoder) {
        return ULong.a(a(decoder));
    }

    public SerialDescriptor getDescriptor() {
        return f41108b;
    }

    public /* bridge */ /* synthetic */ void serialize(Encoder encoder, Object obj) {
        b(encoder, ((ULong) obj).f());
    }
}
