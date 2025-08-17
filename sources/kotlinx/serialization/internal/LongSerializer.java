package kotlinx.serialization.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

public final class LongSerializer implements KSerializer<Long> {

    /* renamed from: a  reason: collision with root package name */
    public static final LongSerializer f41017a = new LongSerializer();

    /* renamed from: b  reason: collision with root package name */
    private static final SerialDescriptor f41018b = new PrimitiveSerialDescriptor("kotlin.Long", PrimitiveKind.LONG.f40913a);

    private LongSerializer() {
    }

    /* renamed from: a */
    public Long deserialize(Decoder decoder) {
        Intrinsics.f(decoder, "decoder");
        return Long.valueOf(decoder.l());
    }

    public void b(Encoder encoder, long j2) {
        Intrinsics.f(encoder, "encoder");
        encoder.m(j2);
    }

    public SerialDescriptor getDescriptor() {
        return f41018b;
    }

    public /* bridge */ /* synthetic */ void serialize(Encoder encoder, Object obj) {
        b(encoder, ((Number) obj).longValue());
    }
}
