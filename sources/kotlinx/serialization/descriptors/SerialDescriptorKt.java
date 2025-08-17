package kotlinx.serialization.descriptors;

import kotlin.jvm.internal.Intrinsics;

public final class SerialDescriptorKt {
    public static final Iterable<SerialDescriptor> a(SerialDescriptor serialDescriptor) {
        Intrinsics.f(serialDescriptor, "<this>");
        return new SerialDescriptorKt$special$$inlined$Iterable$1(serialDescriptor);
    }

    public static final Iterable<String> b(SerialDescriptor serialDescriptor) {
        Intrinsics.f(serialDescriptor, "<this>");
        return new SerialDescriptorKt$special$$inlined$Iterable$2(serialDescriptor);
    }
}
