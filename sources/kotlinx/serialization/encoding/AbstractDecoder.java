package kotlinx.serialization.encoding;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Decoder;

public abstract class AbstractDecoder implements Decoder, CompositeDecoder {
    public final char A(SerialDescriptor serialDescriptor, int i2) {
        Intrinsics.f(serialDescriptor, "descriptor");
        return x();
    }

    public final byte B(SerialDescriptor serialDescriptor, int i2) {
        Intrinsics.f(serialDescriptor, "descriptor");
        return H();
    }

    public final boolean C(SerialDescriptor serialDescriptor, int i2) {
        Intrinsics.f(serialDescriptor, "descriptor");
        return w();
    }

    public boolean D() {
        return true;
    }

    public final short E(SerialDescriptor serialDescriptor, int i2) {
        Intrinsics.f(serialDescriptor, "descriptor");
        return s();
    }

    public final double F(SerialDescriptor serialDescriptor, int i2) {
        Intrinsics.f(serialDescriptor, "descriptor");
        return v();
    }

    public <T> T G(DeserializationStrategy<T> deserializationStrategy) {
        return Decoder.DefaultImpls.a(this, deserializationStrategy);
    }

    public byte H() {
        Object J = J();
        Intrinsics.d(J, "null cannot be cast to non-null type kotlin.Byte");
        return ((Byte) J).byteValue();
    }

    public <T> T I(DeserializationStrategy<T> deserializationStrategy, T t2) {
        Intrinsics.f(deserializationStrategy, "deserializer");
        return G(deserializationStrategy);
    }

    public Object J() {
        throw new SerializationException(Reflection.b(getClass()) + " can't retrieve untyped values");
    }

    public CompositeDecoder b(SerialDescriptor serialDescriptor) {
        Intrinsics.f(serialDescriptor, "descriptor");
        return this;
    }

    public void c(SerialDescriptor serialDescriptor) {
        Intrinsics.f(serialDescriptor, "descriptor");
    }

    public int e(SerialDescriptor serialDescriptor) {
        Intrinsics.f(serialDescriptor, "enumDescriptor");
        Object J = J();
        Intrinsics.d(J, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer) J).intValue();
    }

    public final long f(SerialDescriptor serialDescriptor, int i2) {
        Intrinsics.f(serialDescriptor, "descriptor");
        return l();
    }

    public int h() {
        Object J = J();
        Intrinsics.d(J, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer) J).intValue();
    }

    public final int i(SerialDescriptor serialDescriptor, int i2) {
        Intrinsics.f(serialDescriptor, "descriptor");
        return h();
    }

    public Void j() {
        return null;
    }

    public int k(SerialDescriptor serialDescriptor) {
        return CompositeDecoder.DefaultImpls.a(this, serialDescriptor);
    }

    public long l() {
        Object J = J();
        Intrinsics.d(J, "null cannot be cast to non-null type kotlin.Long");
        return ((Long) J).longValue();
    }

    public final String m(SerialDescriptor serialDescriptor, int i2) {
        Intrinsics.f(serialDescriptor, "descriptor");
        return z();
    }

    public final <T> T n(SerialDescriptor serialDescriptor, int i2, DeserializationStrategy<T> deserializationStrategy, T t2) {
        Intrinsics.f(serialDescriptor, "descriptor");
        Intrinsics.f(deserializationStrategy, "deserializer");
        if (deserializationStrategy.getDescriptor().b() || D()) {
            return I(deserializationStrategy, t2);
        }
        return j();
    }

    public boolean p() {
        return CompositeDecoder.DefaultImpls.b(this);
    }

    public Decoder q(SerialDescriptor serialDescriptor) {
        Intrinsics.f(serialDescriptor, "descriptor");
        return this;
    }

    public Decoder r(SerialDescriptor serialDescriptor, int i2) {
        Intrinsics.f(serialDescriptor, "descriptor");
        return q(serialDescriptor.h(i2));
    }

    public short s() {
        Object J = J();
        Intrinsics.d(J, "null cannot be cast to non-null type kotlin.Short");
        return ((Short) J).shortValue();
    }

    public float t() {
        Object J = J();
        Intrinsics.d(J, "null cannot be cast to non-null type kotlin.Float");
        return ((Float) J).floatValue();
    }

    public final float u(SerialDescriptor serialDescriptor, int i2) {
        Intrinsics.f(serialDescriptor, "descriptor");
        return t();
    }

    public double v() {
        Object J = J();
        Intrinsics.d(J, "null cannot be cast to non-null type kotlin.Double");
        return ((Double) J).doubleValue();
    }

    public boolean w() {
        Object J = J();
        Intrinsics.d(J, "null cannot be cast to non-null type kotlin.Boolean");
        return ((Boolean) J).booleanValue();
    }

    public char x() {
        Object J = J();
        Intrinsics.d(J, "null cannot be cast to non-null type kotlin.Char");
        return ((Character) J).charValue();
    }

    public <T> T y(SerialDescriptor serialDescriptor, int i2, DeserializationStrategy<T> deserializationStrategy, T t2) {
        Intrinsics.f(serialDescriptor, "descriptor");
        Intrinsics.f(deserializationStrategy, "deserializer");
        return I(deserializationStrategy, t2);
    }

    public String z() {
        Object J = J();
        Intrinsics.d(J, "null cannot be cast to non-null type kotlin.String");
        return (String) J;
    }
}
