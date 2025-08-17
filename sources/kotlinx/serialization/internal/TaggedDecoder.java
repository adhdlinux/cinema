package kotlinx.serialization.internal;

import java.util.ArrayList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.modules.SerializersModule;
import kotlinx.serialization.modules.SerializersModuleBuildersKt;

public abstract class TaggedDecoder<Tag> implements Decoder, CompositeDecoder {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<Tag> f41079a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private boolean f41080b;

    private final <E> E a0(Tag tag, Function0<? extends E> function0) {
        Z(tag);
        E invoke = function0.invoke();
        if (!this.f41080b) {
            Y();
        }
        this.f41080b = false;
        return invoke;
    }

    public final char A(SerialDescriptor serialDescriptor, int i2) {
        Intrinsics.f(serialDescriptor, "descriptor");
        return L(X(serialDescriptor, i2));
    }

    public final byte B(SerialDescriptor serialDescriptor, int i2) {
        Intrinsics.f(serialDescriptor, "descriptor");
        return K(X(serialDescriptor, i2));
    }

    public final boolean C(SerialDescriptor serialDescriptor, int i2) {
        Intrinsics.f(serialDescriptor, "descriptor");
        return J(X(serialDescriptor, i2));
    }

    public boolean D() {
        Object W = W();
        if (W == null) {
            return false;
        }
        return S(W);
    }

    public final short E(SerialDescriptor serialDescriptor, int i2) {
        Intrinsics.f(serialDescriptor, "descriptor");
        return T(X(serialDescriptor, i2));
    }

    public final double F(SerialDescriptor serialDescriptor, int i2) {
        Intrinsics.f(serialDescriptor, "descriptor");
        return M(X(serialDescriptor, i2));
    }

    public <T> T G(DeserializationStrategy<T> deserializationStrategy) {
        return Decoder.DefaultImpls.a(this, deserializationStrategy);
    }

    public final byte H() {
        return K(Y());
    }

    /* access modifiers changed from: protected */
    public <T> T I(DeserializationStrategy<T> deserializationStrategy, T t2) {
        Intrinsics.f(deserializationStrategy, "deserializer");
        return G(deserializationStrategy);
    }

    /* access modifiers changed from: protected */
    public boolean J(Tag tag) {
        Object V = V(tag);
        Intrinsics.d(V, "null cannot be cast to non-null type kotlin.Boolean");
        return ((Boolean) V).booleanValue();
    }

    /* access modifiers changed from: protected */
    public byte K(Tag tag) {
        Object V = V(tag);
        Intrinsics.d(V, "null cannot be cast to non-null type kotlin.Byte");
        return ((Byte) V).byteValue();
    }

    /* access modifiers changed from: protected */
    public char L(Tag tag) {
        Object V = V(tag);
        Intrinsics.d(V, "null cannot be cast to non-null type kotlin.Char");
        return ((Character) V).charValue();
    }

    /* access modifiers changed from: protected */
    public double M(Tag tag) {
        Object V = V(tag);
        Intrinsics.d(V, "null cannot be cast to non-null type kotlin.Double");
        return ((Double) V).doubleValue();
    }

    /* access modifiers changed from: protected */
    public int N(Tag tag, SerialDescriptor serialDescriptor) {
        Intrinsics.f(serialDescriptor, "enumDescriptor");
        Object V = V(tag);
        Intrinsics.d(V, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer) V).intValue();
    }

    /* access modifiers changed from: protected */
    public float O(Tag tag) {
        Object V = V(tag);
        Intrinsics.d(V, "null cannot be cast to non-null type kotlin.Float");
        return ((Float) V).floatValue();
    }

    /* access modifiers changed from: protected */
    public Decoder P(Tag tag, SerialDescriptor serialDescriptor) {
        Intrinsics.f(serialDescriptor, "inlineDescriptor");
        Z(tag);
        return this;
    }

    /* access modifiers changed from: protected */
    public int Q(Tag tag) {
        Object V = V(tag);
        Intrinsics.d(V, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer) V).intValue();
    }

    /* access modifiers changed from: protected */
    public long R(Tag tag) {
        Object V = V(tag);
        Intrinsics.d(V, "null cannot be cast to non-null type kotlin.Long");
        return ((Long) V).longValue();
    }

    /* access modifiers changed from: protected */
    public boolean S(Tag tag) {
        return true;
    }

    /* access modifiers changed from: protected */
    public short T(Tag tag) {
        Object V = V(tag);
        Intrinsics.d(V, "null cannot be cast to non-null type kotlin.Short");
        return ((Short) V).shortValue();
    }

    /* access modifiers changed from: protected */
    public String U(Tag tag) {
        Object V = V(tag);
        Intrinsics.d(V, "null cannot be cast to non-null type kotlin.String");
        return (String) V;
    }

    /* access modifiers changed from: protected */
    public Object V(Tag tag) {
        throw new SerializationException(Reflection.b(getClass()) + " can't retrieve untyped values");
    }

    /* access modifiers changed from: protected */
    public final Tag W() {
        return CollectionsKt___CollectionsKt.L(this.f41079a);
    }

    /* access modifiers changed from: protected */
    public abstract Tag X(SerialDescriptor serialDescriptor, int i2);

    /* access modifiers changed from: protected */
    public final Tag Y() {
        ArrayList<Tag> arrayList = this.f41079a;
        Tag remove = arrayList.remove(CollectionsKt__CollectionsKt.h(arrayList));
        this.f41080b = true;
        return remove;
    }

    /* access modifiers changed from: protected */
    public final void Z(Tag tag) {
        this.f41079a.add(tag);
    }

    public SerializersModule a() {
        return SerializersModuleBuildersKt.a();
    }

    public CompositeDecoder b(SerialDescriptor serialDescriptor) {
        Intrinsics.f(serialDescriptor, "descriptor");
        return this;
    }

    public void c(SerialDescriptor serialDescriptor) {
        Intrinsics.f(serialDescriptor, "descriptor");
    }

    public final int e(SerialDescriptor serialDescriptor) {
        Intrinsics.f(serialDescriptor, "enumDescriptor");
        return N(Y(), serialDescriptor);
    }

    public final long f(SerialDescriptor serialDescriptor, int i2) {
        Intrinsics.f(serialDescriptor, "descriptor");
        return R(X(serialDescriptor, i2));
    }

    public final int h() {
        return Q(Y());
    }

    public final int i(SerialDescriptor serialDescriptor, int i2) {
        Intrinsics.f(serialDescriptor, "descriptor");
        return Q(X(serialDescriptor, i2));
    }

    public final Void j() {
        return null;
    }

    public int k(SerialDescriptor serialDescriptor) {
        return CompositeDecoder.DefaultImpls.a(this, serialDescriptor);
    }

    public final long l() {
        return R(Y());
    }

    public final String m(SerialDescriptor serialDescriptor, int i2) {
        Intrinsics.f(serialDescriptor, "descriptor");
        return U(X(serialDescriptor, i2));
    }

    public final <T> T n(SerialDescriptor serialDescriptor, int i2, DeserializationStrategy<T> deserializationStrategy, T t2) {
        Intrinsics.f(serialDescriptor, "descriptor");
        Intrinsics.f(deserializationStrategy, "deserializer");
        return a0(X(serialDescriptor, i2), new TaggedDecoder$decodeNullableSerializableElement$1(this, deserializationStrategy, t2));
    }

    public boolean p() {
        return CompositeDecoder.DefaultImpls.b(this);
    }

    public final Decoder q(SerialDescriptor serialDescriptor) {
        Intrinsics.f(serialDescriptor, "descriptor");
        return P(Y(), serialDescriptor);
    }

    public final Decoder r(SerialDescriptor serialDescriptor, int i2) {
        Intrinsics.f(serialDescriptor, "descriptor");
        return P(X(serialDescriptor, i2), serialDescriptor.h(i2));
    }

    public final short s() {
        return T(Y());
    }

    public final float t() {
        return O(Y());
    }

    public final float u(SerialDescriptor serialDescriptor, int i2) {
        Intrinsics.f(serialDescriptor, "descriptor");
        return O(X(serialDescriptor, i2));
    }

    public final double v() {
        return M(Y());
    }

    public final boolean w() {
        return J(Y());
    }

    public final char x() {
        return L(Y());
    }

    public final <T> T y(SerialDescriptor serialDescriptor, int i2, DeserializationStrategy<T> deserializationStrategy, T t2) {
        Intrinsics.f(serialDescriptor, "descriptor");
        Intrinsics.f(deserializationStrategy, "deserializer");
        return a0(X(serialDescriptor, i2), new TaggedDecoder$decodeSerializableElement$1(this, deserializationStrategy, t2));
    }

    public final String z() {
        return U(Y());
    }
}
