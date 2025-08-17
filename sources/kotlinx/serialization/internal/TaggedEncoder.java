package kotlinx.serialization.internal;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.modules.SerializersModule;
import kotlinx.serialization.modules.SerializersModuleBuildersKt;

public abstract class TaggedEncoder<Tag> implements Encoder, CompositeEncoder {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<Tag> f41087a = new ArrayList<>();

    private final boolean H(SerialDescriptor serialDescriptor, int i2) {
        c0(a0(serialDescriptor, i2));
        return true;
    }

    public final void B(int i2) {
        Q(b0(), i2);
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
        U(a0(serialDescriptor, i2), s2);
    }

    public final void E(SerialDescriptor serialDescriptor, int i2, double d2) {
        Intrinsics.f(serialDescriptor, "descriptor");
        M(a0(serialDescriptor, i2), d2);
    }

    public final void F(SerialDescriptor serialDescriptor, int i2, long j2) {
        Intrinsics.f(serialDescriptor, "descriptor");
        R(a0(serialDescriptor, i2), j2);
    }

    public final void G(String str) {
        Intrinsics.f(str, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        V(b0(), str);
    }

    public <T> void I(SerializationStrategy<? super T> serializationStrategy, T t2) {
        Encoder.DefaultImpls.c(this, serializationStrategy, t2);
    }

    /* access modifiers changed from: protected */
    public void J(Tag tag, boolean z2) {
        W(tag, Boolean.valueOf(z2));
    }

    /* access modifiers changed from: protected */
    public void K(Tag tag, byte b2) {
        W(tag, Byte.valueOf(b2));
    }

    /* access modifiers changed from: protected */
    public void L(Tag tag, char c2) {
        W(tag, Character.valueOf(c2));
    }

    /* access modifiers changed from: protected */
    public void M(Tag tag, double d2) {
        W(tag, Double.valueOf(d2));
    }

    /* access modifiers changed from: protected */
    public void N(Tag tag, SerialDescriptor serialDescriptor, int i2) {
        Intrinsics.f(serialDescriptor, "enumDescriptor");
        W(tag, Integer.valueOf(i2));
    }

    /* access modifiers changed from: protected */
    public void O(Tag tag, float f2) {
        W(tag, Float.valueOf(f2));
    }

    /* access modifiers changed from: protected */
    public Encoder P(Tag tag, SerialDescriptor serialDescriptor) {
        Intrinsics.f(serialDescriptor, "inlineDescriptor");
        c0(tag);
        return this;
    }

    /* access modifiers changed from: protected */
    public void Q(Tag tag, int i2) {
        W(tag, Integer.valueOf(i2));
    }

    /* access modifiers changed from: protected */
    public void R(Tag tag, long j2) {
        W(tag, Long.valueOf(j2));
    }

    /* access modifiers changed from: protected */
    public void S(Tag tag) {
    }

    /* access modifiers changed from: protected */
    public void T(Tag tag) {
        throw new SerializationException("null is not supported");
    }

    /* access modifiers changed from: protected */
    public void U(Tag tag, short s2) {
        W(tag, Short.valueOf(s2));
    }

    /* access modifiers changed from: protected */
    public void V(Tag tag, String str) {
        Intrinsics.f(str, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        W(tag, str);
    }

    /* access modifiers changed from: protected */
    public void W(Tag tag, Object obj) {
        Intrinsics.f(obj, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        throw new SerializationException("Non-serializable " + Reflection.b(obj.getClass()) + " is not supported by " + Reflection.b(getClass()) + " encoder");
    }

    /* access modifiers changed from: protected */
    public void X(SerialDescriptor serialDescriptor) {
        Intrinsics.f(serialDescriptor, "descriptor");
    }

    /* access modifiers changed from: protected */
    public final Tag Y() {
        return CollectionsKt___CollectionsKt.K(this.f41087a);
    }

    /* access modifiers changed from: protected */
    public final Tag Z() {
        return CollectionsKt___CollectionsKt.L(this.f41087a);
    }

    public SerializersModule a() {
        return SerializersModuleBuildersKt.a();
    }

    /* access modifiers changed from: protected */
    public abstract Tag a0(SerialDescriptor serialDescriptor, int i2);

    public CompositeEncoder b(SerialDescriptor serialDescriptor) {
        Intrinsics.f(serialDescriptor, "descriptor");
        return this;
    }

    /* access modifiers changed from: protected */
    public final Tag b0() {
        if (!this.f41087a.isEmpty()) {
            ArrayList<Tag> arrayList = this.f41087a;
            return arrayList.remove(CollectionsKt__CollectionsKt.h(arrayList));
        }
        throw new SerializationException("No tag in stack for requested element");
    }

    public final void c(SerialDescriptor serialDescriptor) {
        Intrinsics.f(serialDescriptor, "descriptor");
        if (!this.f41087a.isEmpty()) {
            b0();
        }
        X(serialDescriptor);
    }

    /* access modifiers changed from: protected */
    public final void c0(Tag tag) {
        this.f41087a.add(tag);
    }

    public <T> void e(SerializationStrategy<? super T> serializationStrategy, T t2) {
        Encoder.DefaultImpls.d(this, serializationStrategy, t2);
    }

    public final Encoder f(SerialDescriptor serialDescriptor, int i2) {
        Intrinsics.f(serialDescriptor, "descriptor");
        return P(a0(serialDescriptor, i2), serialDescriptor.h(i2));
    }

    public final void g(double d2) {
        M(b0(), d2);
    }

    public final void h(byte b2) {
        K(b0(), b2);
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

    public final void k(SerialDescriptor serialDescriptor, int i2) {
        Intrinsics.f(serialDescriptor, "enumDescriptor");
        N(b0(), serialDescriptor, i2);
    }

    public final Encoder l(SerialDescriptor serialDescriptor) {
        Intrinsics.f(serialDescriptor, "descriptor");
        return P(b0(), serialDescriptor);
    }

    public final void m(long j2) {
        R(b0(), j2);
    }

    public final void n(SerialDescriptor serialDescriptor, int i2, char c2) {
        Intrinsics.f(serialDescriptor, "descriptor");
        L(a0(serialDescriptor, i2), c2);
    }

    public void o() {
        T(b0());
    }

    public final void p(SerialDescriptor serialDescriptor, int i2, byte b2) {
        Intrinsics.f(serialDescriptor, "descriptor");
        K(a0(serialDescriptor, i2), b2);
    }

    public final void q(short s2) {
        U(b0(), s2);
    }

    public final void r(boolean z2) {
        J(b0(), z2);
    }

    public final void s(SerialDescriptor serialDescriptor, int i2, float f2) {
        Intrinsics.f(serialDescriptor, "descriptor");
        O(a0(serialDescriptor, i2), f2);
    }

    public final void t(float f2) {
        O(b0(), f2);
    }

    public final void u(char c2) {
        L(b0(), c2);
    }

    public void v() {
        S(Y());
    }

    public final void w(SerialDescriptor serialDescriptor, int i2, int i3) {
        Intrinsics.f(serialDescriptor, "descriptor");
        Q(a0(serialDescriptor, i2), i3);
    }

    public final void x(SerialDescriptor serialDescriptor, int i2, boolean z2) {
        Intrinsics.f(serialDescriptor, "descriptor");
        J(a0(serialDescriptor, i2), z2);
    }

    public final void y(SerialDescriptor serialDescriptor, int i2, String str) {
        Intrinsics.f(serialDescriptor, "descriptor");
        Intrinsics.f(str, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        V(a0(serialDescriptor, i2), str);
    }

    public boolean z(SerialDescriptor serialDescriptor, int i2) {
        return CompositeEncoder.DefaultImpls.a(this, serialDescriptor, i2);
    }
}
