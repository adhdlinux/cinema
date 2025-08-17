package kotlinx.serialization.internal;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;

public final class ArrayListClassDesc extends ListLikeDescriptor {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ArrayListClassDesc(SerialDescriptor serialDescriptor) {
        super(serialDescriptor, (DefaultConstructorMarker) null);
        Intrinsics.f(serialDescriptor, "elementDesc");
    }

    public String i() {
        return "kotlin.collections.ArrayList";
    }
}
