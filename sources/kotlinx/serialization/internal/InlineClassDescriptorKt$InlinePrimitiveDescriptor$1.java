package kotlinx.serialization.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;

public final class InlineClassDescriptorKt$InlinePrimitiveDescriptor$1 implements GeneratedSerializer<T> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ KSerializer<T> f41002a;

    InlineClassDescriptorKt$InlinePrimitiveDescriptor$1(KSerializer<T> kSerializer) {
        this.f41002a = kSerializer;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: kotlinx.serialization.KSerializer<?>[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public kotlinx.serialization.KSerializer<?>[] childSerializers() {
        /*
            r3 = this;
            r0 = 1
            kotlinx.serialization.KSerializer[] r0 = new kotlinx.serialization.KSerializer[r0]
            r1 = 0
            kotlinx.serialization.KSerializer<T> r2 = r3.f41002a
            r0[r1] = r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.internal.InlineClassDescriptorKt$InlinePrimitiveDescriptor$1.childSerializers():kotlinx.serialization.KSerializer[]");
    }

    public T deserialize(Decoder decoder) {
        Intrinsics.f(decoder, "decoder");
        throw new IllegalStateException("unsupported".toString());
    }

    public SerialDescriptor getDescriptor() {
        throw new IllegalStateException("unsupported".toString());
    }

    public void serialize(Encoder encoder, T t2) {
        Intrinsics.f(encoder, "encoder");
        throw new IllegalStateException("unsupported".toString());
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
