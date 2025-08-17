package kotlinx.serialization;

import kotlinx.serialization.descriptors.SerialDescriptor;

public interface KSerializer<T> extends SerializationStrategy<T>, DeserializationStrategy<T> {
    SerialDescriptor getDescriptor();
}
