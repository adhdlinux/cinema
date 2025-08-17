package kotlinx.serialization.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

public final class CharSerializer implements KSerializer<Character> {

    /* renamed from: a  reason: collision with root package name */
    public static final CharSerializer f40959a = new CharSerializer();

    /* renamed from: b  reason: collision with root package name */
    private static final SerialDescriptor f40960b = new PrimitiveSerialDescriptor("kotlin.Char", PrimitiveKind.CHAR.f40909a);

    private CharSerializer() {
    }

    /* renamed from: a */
    public Character deserialize(Decoder decoder) {
        Intrinsics.f(decoder, "decoder");
        return Character.valueOf(decoder.x());
    }

    public void b(Encoder encoder, char c2) {
        Intrinsics.f(encoder, "encoder");
        encoder.u(c2);
    }

    public SerialDescriptor getDescriptor() {
        return f40960b;
    }

    public /* bridge */ /* synthetic */ void serialize(Encoder encoder, Object obj) {
        b(encoder, ((Character) obj).charValue());
    }
}
