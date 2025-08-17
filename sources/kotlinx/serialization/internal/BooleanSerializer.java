package kotlinx.serialization.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

public final class BooleanSerializer implements KSerializer<Boolean> {

    /* renamed from: a  reason: collision with root package name */
    public static final BooleanSerializer f40947a = new BooleanSerializer();

    /* renamed from: b  reason: collision with root package name */
    private static final SerialDescriptor f40948b = new PrimitiveSerialDescriptor("kotlin.Boolean", PrimitiveKind.BOOLEAN.f40907a);

    private BooleanSerializer() {
    }

    /* renamed from: a */
    public Boolean deserialize(Decoder decoder) {
        Intrinsics.f(decoder, "decoder");
        return Boolean.valueOf(decoder.w());
    }

    public void b(Encoder encoder, boolean z2) {
        Intrinsics.f(encoder, "encoder");
        encoder.r(z2);
    }

    public SerialDescriptor getDescriptor() {
        return f40948b;
    }

    public /* bridge */ /* synthetic */ void serialize(Encoder encoder, Object obj) {
        b(encoder, ((Boolean) obj).booleanValue());
    }
}
