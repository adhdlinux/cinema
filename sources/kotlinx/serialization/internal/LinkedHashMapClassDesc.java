package kotlinx.serialization.internal;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;

public final class LinkedHashMapClassDesc extends MapLikeDescriptor {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LinkedHashMapClassDesc(SerialDescriptor serialDescriptor, SerialDescriptor serialDescriptor2) {
        super("kotlin.collections.LinkedHashMap", serialDescriptor, serialDescriptor2, (DefaultConstructorMarker) null);
        Intrinsics.f(serialDescriptor, "keyDesc");
        Intrinsics.f(serialDescriptor2, "valueDesc");
    }
}
