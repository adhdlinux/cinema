package kotlinx.serialization.encoding;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.modules.SerializersModule;

public interface Encoder {

    public static final class DefaultImpls {
        public static CompositeEncoder a(Encoder encoder, SerialDescriptor serialDescriptor, int i2) {
            Intrinsics.f(serialDescriptor, "descriptor");
            return encoder.b(serialDescriptor);
        }

        public static void b(Encoder encoder) {
        }

        public static <T> void c(Encoder encoder, SerializationStrategy<? super T> serializationStrategy, T t2) {
            Intrinsics.f(serializationStrategy, "serializer");
            if (serializationStrategy.getDescriptor().b()) {
                encoder.e(serializationStrategy, t2);
            } else if (t2 == null) {
                encoder.o();
            } else {
                encoder.v();
                encoder.e(serializationStrategy, t2);
            }
        }

        public static <T> void d(Encoder encoder, SerializationStrategy<? super T> serializationStrategy, T t2) {
            Intrinsics.f(serializationStrategy, "serializer");
            serializationStrategy.serialize(encoder, t2);
        }
    }

    void B(int i2);

    void G(String str);

    SerializersModule a();

    CompositeEncoder b(SerialDescriptor serialDescriptor);

    <T> void e(SerializationStrategy<? super T> serializationStrategy, T t2);

    void g(double d2);

    void h(byte b2);

    CompositeEncoder j(SerialDescriptor serialDescriptor, int i2);

    void k(SerialDescriptor serialDescriptor, int i2);

    Encoder l(SerialDescriptor serialDescriptor);

    void m(long j2);

    void o();

    void q(short s2);

    void r(boolean z2);

    void t(float f2);

    void u(char c2);

    void v();
}
