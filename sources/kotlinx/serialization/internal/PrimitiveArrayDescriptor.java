package kotlinx.serialization.internal;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;

public final class PrimitiveArrayDescriptor extends ListLikeDescriptor {

    /* renamed from: c  reason: collision with root package name */
    private final String f41062c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PrimitiveArrayDescriptor(SerialDescriptor serialDescriptor) {
        super(serialDescriptor, (DefaultConstructorMarker) null);
        Intrinsics.f(serialDescriptor, "primitive");
        this.f41062c = serialDescriptor.i() + "Array";
    }

    public String i() {
        return this.f41062c;
    }
}
