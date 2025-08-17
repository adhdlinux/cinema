package kotlinx.serialization.encoding;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;

public interface CompositeEncoder {

    public static final class DefaultImpls {
        public static boolean a(CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor, int i2) {
            Intrinsics.f(serialDescriptor, "descriptor");
            return true;
        }
    }

    <T> void C(SerialDescriptor serialDescriptor, int i2, SerializationStrategy<? super T> serializationStrategy, T t2);

    void D(SerialDescriptor serialDescriptor, int i2, short s2);

    void E(SerialDescriptor serialDescriptor, int i2, double d2);

    void F(SerialDescriptor serialDescriptor, int i2, long j2);

    void c(SerialDescriptor serialDescriptor);

    Encoder f(SerialDescriptor serialDescriptor, int i2);

    <T> void i(SerialDescriptor serialDescriptor, int i2, SerializationStrategy<? super T> serializationStrategy, T t2);

    void n(SerialDescriptor serialDescriptor, int i2, char c2);

    void p(SerialDescriptor serialDescriptor, int i2, byte b2);

    void s(SerialDescriptor serialDescriptor, int i2, float f2);

    void w(SerialDescriptor serialDescriptor, int i2, int i3);

    void x(SerialDescriptor serialDescriptor, int i2, boolean z2);

    void y(SerialDescriptor serialDescriptor, int i2, String str);

    boolean z(SerialDescriptor serialDescriptor, int i2);
}
