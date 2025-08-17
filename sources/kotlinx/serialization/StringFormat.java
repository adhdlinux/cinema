package kotlinx.serialization;

public interface StringFormat extends SerialFormat {
    <T> T b(DeserializationStrategy<T> deserializationStrategy, String str);

    <T> String c(SerializationStrategy<? super T> serializationStrategy, T t2);
}
