package kotlinx.serialization.internal;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.AbstractEncoder;
import kotlinx.serialization.modules.SerializersModule;
import kotlinx.serialization.modules.SerializersModuleBuildersKt;

public final class NoOpEncoder extends AbstractEncoder {

    /* renamed from: a  reason: collision with root package name */
    public static final NoOpEncoder f41030a = new NoOpEncoder();

    /* renamed from: b  reason: collision with root package name */
    private static final SerializersModule f41031b = SerializersModuleBuildersKt.a();

    private NoOpEncoder() {
    }

    public void B(int i2) {
    }

    public void G(String str) {
        Intrinsics.f(str, AppMeasurementSdk.ConditionalUserProperty.VALUE);
    }

    public void J(Object obj) {
        Intrinsics.f(obj, AppMeasurementSdk.ConditionalUserProperty.VALUE);
    }

    public SerializersModule a() {
        return f41031b;
    }

    public void g(double d2) {
    }

    public void h(byte b2) {
    }

    public void k(SerialDescriptor serialDescriptor, int i2) {
        Intrinsics.f(serialDescriptor, "enumDescriptor");
    }

    public void m(long j2) {
    }

    public void o() {
    }

    public void q(short s2) {
    }

    public void r(boolean z2) {
    }

    public void t(float f2) {
    }

    public void u(char c2) {
    }
}
