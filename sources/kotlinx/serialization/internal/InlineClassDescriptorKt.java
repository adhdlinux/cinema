package kotlinx.serialization.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;

public final class InlineClassDescriptorKt {
    public static final <T> SerialDescriptor a(String str, KSerializer<T> kSerializer) {
        Intrinsics.f(str, "name");
        Intrinsics.f(kSerializer, "primitiveSerializer");
        return new InlineClassDescriptor(str, new InlineClassDescriptorKt$InlinePrimitiveDescriptor$1(kSerializer));
    }
}
