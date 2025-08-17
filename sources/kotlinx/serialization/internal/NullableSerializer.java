package kotlinx.serialization.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

public final class NullableSerializer<T> implements KSerializer<T> {

    /* renamed from: a  reason: collision with root package name */
    private final KSerializer<T> f41032a;

    /* renamed from: b  reason: collision with root package name */
    private final SerialDescriptor f41033b;

    public NullableSerializer(KSerializer<T> kSerializer) {
        Intrinsics.f(kSerializer, "serializer");
        this.f41032a = kSerializer;
        this.f41033b = new SerialDescriptorForNullable(kSerializer.getDescriptor());
    }

    public T deserialize(Decoder decoder) {
        Intrinsics.f(decoder, "decoder");
        if (decoder.D()) {
            return decoder.G(this.f41032a);
        }
        return decoder.j();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !Intrinsics.a(Reflection.b(NullableSerializer.class), Reflection.b(obj.getClass())) || !Intrinsics.a(this.f41032a, ((NullableSerializer) obj).f41032a)) {
            return false;
        }
        return true;
    }

    public SerialDescriptor getDescriptor() {
        return this.f41033b;
    }

    public int hashCode() {
        return this.f41032a.hashCode();
    }

    public void serialize(Encoder encoder, T t2) {
        Intrinsics.f(encoder, "encoder");
        if (t2 != null) {
            encoder.v();
            encoder.e(this.f41032a, t2);
            return;
        }
        encoder.o();
    }
}
