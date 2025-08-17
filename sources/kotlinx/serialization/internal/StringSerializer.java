package kotlinx.serialization.internal;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

public final class StringSerializer implements KSerializer<String> {

    /* renamed from: a  reason: collision with root package name */
    public static final StringSerializer f41077a = new StringSerializer();

    /* renamed from: b  reason: collision with root package name */
    private static final SerialDescriptor f41078b = new PrimitiveSerialDescriptor("kotlin.String", PrimitiveKind.STRING.f40915a);

    private StringSerializer() {
    }

    /* renamed from: a */
    public String deserialize(Decoder decoder) {
        Intrinsics.f(decoder, "decoder");
        return decoder.z();
    }

    /* renamed from: b */
    public void serialize(Encoder encoder, String str) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(str, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        encoder.G(str);
    }

    public SerialDescriptor getDescriptor() {
        return f41078b;
    }
}
