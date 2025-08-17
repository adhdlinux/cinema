package kotlinx.serialization.encoding;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.modules.SerializersModule;

public interface Decoder {

    public static final class DefaultImpls {
        public static <T> T a(Decoder decoder, DeserializationStrategy<T> deserializationStrategy) {
            Intrinsics.f(deserializationStrategy, "deserializer");
            return deserializationStrategy.deserialize(decoder);
        }
    }

    boolean D();

    <T> T G(DeserializationStrategy<T> deserializationStrategy);

    byte H();

    SerializersModule a();

    CompositeDecoder b(SerialDescriptor serialDescriptor);

    int e(SerialDescriptor serialDescriptor);

    int h();

    Void j();

    long l();

    Decoder q(SerialDescriptor serialDescriptor);

    short s();

    float t();

    double v();

    boolean w();

    char x();

    String z();
}
