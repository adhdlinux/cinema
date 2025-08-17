package kotlinx.serialization.json.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.internal.ElementMarker;

public final class JsonElementMarker {

    /* renamed from: a  reason: collision with root package name */
    private final ElementMarker f41214a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f41215b;

    public JsonElementMarker(SerialDescriptor serialDescriptor) {
        Intrinsics.f(serialDescriptor, "descriptor");
        this.f41214a = new ElementMarker(serialDescriptor, new JsonElementMarker$origin$1(this));
    }

    /* access modifiers changed from: private */
    public final boolean e(SerialDescriptor serialDescriptor, int i2) {
        boolean z2 = !serialDescriptor.j(i2) && serialDescriptor.h(i2).b();
        this.f41215b = z2;
        return z2;
    }

    public final boolean b() {
        return this.f41215b;
    }

    public final void c(int i2) {
        this.f41214a.a(i2);
    }

    public final int d() {
        return this.f41214a.d();
    }
}
