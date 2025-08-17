package kotlinx.serialization;

import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Encoder;

public interface SerializationStrategy<T> {
    SerialDescriptor getDescriptor();

    void serialize(Encoder encoder, T t2);
}
