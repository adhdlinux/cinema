package kotlinx.serialization.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

public final class DurationSerializer implements KSerializer<Duration> {

    /* renamed from: a  reason: collision with root package name */
    public static final DurationSerializer f40976a = new DurationSerializer();

    /* renamed from: b  reason: collision with root package name */
    private static final SerialDescriptor f40977b = new PrimitiveSerialDescriptor("kotlin.time.Duration", PrimitiveKind.STRING.f40915a);

    private DurationSerializer() {
    }

    public long a(Decoder decoder) {
        Intrinsics.f(decoder, "decoder");
        return Duration.f40567c.c(decoder.z());
    }

    public void b(Encoder encoder, long j2) {
        Intrinsics.f(encoder, "encoder");
        encoder.G(Duration.B(j2));
    }

    public /* bridge */ /* synthetic */ Object deserialize(Decoder decoder) {
        return Duration.e(a(decoder));
    }

    public SerialDescriptor getDescriptor() {
        return f40977b;
    }

    public /* bridge */ /* synthetic */ void serialize(Encoder encoder, Object obj) {
        b(encoder, ((Duration) obj).F());
    }
}
