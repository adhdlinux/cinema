package kotlinx.serialization.encoding;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.NoOpEncoder;

public abstract class AbstractEncoder implements Encoder, CompositeEncoder {
    public void B(int i2) {
        J(Integer.valueOf(i2));
    }

    public <T> void C(SerialDescriptor serialDescriptor, int i2, SerializationStrategy<? super T> serializationStrategy, T t2) {
        Intrinsics.f(serialDescriptor, "descriptor");
        Intrinsics.f(serializationStrategy, "serializer");
        if (H(serialDescriptor, i2)) {
            e(serializationStrategy, t2);
        }
    }

    public final void D(SerialDescriptor serialDescriptor, int i2, short s2) {
        Intrinsics.f(serialDescriptor, "descriptor");
        if (H(serialDescriptor, i2)) {
            q(s2);
        }
    }

    public final void E(SerialDescriptor serialDescriptor, int i2, double d2) {
        Intrinsics.f(serialDescriptor, "descriptor");
        if (H(serialDescriptor, i2)) {
            g(d2);
        }
    }

    public final void F(SerialDescriptor serialDescriptor, int i2, long j2) {
        Intrinsics.f(serialDescriptor, "descriptor");
        if (H(serialDescriptor, i2)) {
            m(j2);
        }
    }

    public void G(String str) {
        Intrinsics.f(str, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        J(str);
    }

    public boolean H(SerialDescriptor serialDescriptor, int i2) {
        Intrinsics.f(serialDescriptor, "descriptor");
        return true;
    }

    public <T> void I(SerializationStrategy<? super T> serializationStrategy, T t2) {
        Encoder.DefaultImpls.c(this, serializationStrategy, t2);
    }

    public void J(Object obj) {
        Intrinsics.f(obj, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        throw new SerializationException("Non-serializable " + Reflection.b(obj.getClass()) + " is not supported by " + Reflection.b(getClass()) + " encoder");
    }

    public CompositeEncoder b(SerialDescriptor serialDescriptor) {
        Intrinsics.f(serialDescriptor, "descriptor");
        return this;
    }

    public void c(SerialDescriptor serialDescriptor) {
        Intrinsics.f(serialDescriptor, "descriptor");
    }

    public <T> void e(SerializationStrategy<? super T> serializationStrategy, T t2) {
        Encoder.DefaultImpls.d(this, serializationStrategy, t2);
    }

    public final Encoder f(SerialDescriptor serialDescriptor, int i2) {
        Intrinsics.f(serialDescriptor, "descriptor");
        if (H(serialDescriptor, i2)) {
            return l(serialDescriptor.h(i2));
        }
        return NoOpEncoder.f41030a;
    }

    public void g(double d2) {
        J(Double.valueOf(d2));
    }

    public void h(byte b2) {
        J(Byte.valueOf(b2));
    }

    public <T> void i(SerialDescriptor serialDescriptor, int i2, SerializationStrategy<? super T> serializationStrategy, T t2) {
        Intrinsics.f(serialDescriptor, "descriptor");
        Intrinsics.f(serializationStrategy, "serializer");
        if (H(serialDescriptor, i2)) {
            I(serializationStrategy, t2);
        }
    }

    public CompositeEncoder j(SerialDescriptor serialDescriptor, int i2) {
        return Encoder.DefaultImpls.a(this, serialDescriptor, i2);
    }

    public void k(SerialDescriptor serialDescriptor, int i2) {
        Intrinsics.f(serialDescriptor, "enumDescriptor");
        J(Integer.valueOf(i2));
    }

    public Encoder l(SerialDescriptor serialDescriptor) {
        Intrinsics.f(serialDescriptor, "descriptor");
        return this;
    }

    public void m(long j2) {
        J(Long.valueOf(j2));
    }

    public final void n(SerialDescriptor serialDescriptor, int i2, char c2) {
        Intrinsics.f(serialDescriptor, "descriptor");
        if (H(serialDescriptor, i2)) {
            u(c2);
        }
    }

    public void o() {
        throw new SerializationException("'null' is not supported by default");
    }

    public final void p(SerialDescriptor serialDescriptor, int i2, byte b2) {
        Intrinsics.f(serialDescriptor, "descriptor");
        if (H(serialDescriptor, i2)) {
            h(b2);
        }
    }

    public void q(short s2) {
        J(Short.valueOf(s2));
    }

    public void r(boolean z2) {
        J(Boolean.valueOf(z2));
    }

    public final void s(SerialDescriptor serialDescriptor, int i2, float f2) {
        Intrinsics.f(serialDescriptor, "descriptor");
        if (H(serialDescriptor, i2)) {
            t(f2);
        }
    }

    public void t(float f2) {
        J(Float.valueOf(f2));
    }

    public void u(char c2) {
        J(Character.valueOf(c2));
    }

    public void v() {
        Encoder.DefaultImpls.b(this);
    }

    public final void w(SerialDescriptor serialDescriptor, int i2, int i3) {
        Intrinsics.f(serialDescriptor, "descriptor");
        if (H(serialDescriptor, i2)) {
            B(i3);
        }
    }

    public final void x(SerialDescriptor serialDescriptor, int i2, boolean z2) {
        Intrinsics.f(serialDescriptor, "descriptor");
        if (H(serialDescriptor, i2)) {
            r(z2);
        }
    }

    public final void y(SerialDescriptor serialDescriptor, int i2, String str) {
        Intrinsics.f(serialDescriptor, "descriptor");
        Intrinsics.f(str, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        if (H(serialDescriptor, i2)) {
            G(str);
        }
    }

    public boolean z(SerialDescriptor serialDescriptor, int i2) {
        return CompositeEncoder.DefaultImpls.a(this, serialDescriptor, i2);
    }
}
