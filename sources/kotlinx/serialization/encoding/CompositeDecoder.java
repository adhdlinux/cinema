package kotlinx.serialization.encoding;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.modules.SerializersModule;

public interface CompositeDecoder {

    public static final class DefaultImpls {
        public static int a(CompositeDecoder compositeDecoder, SerialDescriptor serialDescriptor) {
            Intrinsics.f(serialDescriptor, "descriptor");
            return -1;
        }

        public static boolean b(CompositeDecoder compositeDecoder) {
            return false;
        }

        public static /* synthetic */ Object c(CompositeDecoder compositeDecoder, SerialDescriptor serialDescriptor, int i2, DeserializationStrategy deserializationStrategy, Object obj, int i3, Object obj2) {
            if (obj2 == null) {
                if ((i3 & 8) != 0) {
                    obj = null;
                }
                return compositeDecoder.y(serialDescriptor, i2, deserializationStrategy, obj);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decodeSerializableElement");
        }
    }

    char A(SerialDescriptor serialDescriptor, int i2);

    byte B(SerialDescriptor serialDescriptor, int i2);

    boolean C(SerialDescriptor serialDescriptor, int i2);

    short E(SerialDescriptor serialDescriptor, int i2);

    double F(SerialDescriptor serialDescriptor, int i2);

    SerializersModule a();

    void c(SerialDescriptor serialDescriptor);

    long f(SerialDescriptor serialDescriptor, int i2);

    int i(SerialDescriptor serialDescriptor, int i2);

    int k(SerialDescriptor serialDescriptor);

    String m(SerialDescriptor serialDescriptor, int i2);

    <T> T n(SerialDescriptor serialDescriptor, int i2, DeserializationStrategy<T> deserializationStrategy, T t2);

    int o(SerialDescriptor serialDescriptor);

    boolean p();

    Decoder r(SerialDescriptor serialDescriptor, int i2);

    float u(SerialDescriptor serialDescriptor, int i2);

    <T> T y(SerialDescriptor serialDescriptor, int i2, DeserializationStrategy<T> deserializationStrategy, T t2);
}
