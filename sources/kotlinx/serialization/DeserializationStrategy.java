package kotlinx.serialization;

import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;

public interface DeserializationStrategy<T> {
    T deserialize(Decoder decoder);

    SerialDescriptor getDescriptor();
}
