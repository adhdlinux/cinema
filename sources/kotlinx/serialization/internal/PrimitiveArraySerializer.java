package kotlinx.serialization.internal;

import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.PrimitiveArrayBuilder;

public abstract class PrimitiveArraySerializer<Element, Array, Builder extends PrimitiveArrayBuilder<Array>> extends CollectionLikeSerializer<Element, Array, Builder> {

    /* renamed from: b  reason: collision with root package name */
    private final SerialDescriptor f41063b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PrimitiveArraySerializer(KSerializer<Element> kSerializer) {
        super(kSerializer, (DefaultConstructorMarker) null);
        Intrinsics.f(kSerializer, "primitiveSerializer");
        this.f41063b = new PrimitiveArrayDescriptor(kSerializer.getDescriptor());
    }

    /* access modifiers changed from: protected */
    public final Iterator<Element> d(Array array) {
        throw new IllegalStateException("This method lead to boxing and must not be used, use writeContents instead".toString());
    }

    public final Array deserialize(Decoder decoder) {
        Intrinsics.f(decoder, "decoder");
        return f(decoder, null);
    }

    public final SerialDescriptor getDescriptor() {
        return this.f41063b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: o */
    public final Builder a() {
        return (PrimitiveArrayBuilder) k(r());
    }

    /* access modifiers changed from: protected */
    /* renamed from: p */
    public final int b(Builder builder) {
        Intrinsics.f(builder, "<this>");
        return builder.d();
    }

    /* access modifiers changed from: protected */
    /* renamed from: q */
    public final void c(Builder builder, int i2) {
        Intrinsics.f(builder, "<this>");
        builder.b(i2);
    }

    /* access modifiers changed from: protected */
    public abstract Array r();

    /* access modifiers changed from: protected */
    /* renamed from: s */
    public final void n(Builder builder, int i2, Element element) {
        Intrinsics.f(builder, "<this>");
        throw new IllegalStateException("This method lead to boxing and must not be used, use Builder.append instead".toString());
    }

    public final void serialize(Encoder encoder, Array array) {
        Intrinsics.f(encoder, "encoder");
        int e2 = e(array);
        SerialDescriptor serialDescriptor = this.f41063b;
        CompositeEncoder j2 = encoder.j(serialDescriptor, e2);
        u(j2, array, e2);
        j2.c(serialDescriptor);
    }

    /* access modifiers changed from: protected */
    /* renamed from: t */
    public final Array l(Builder builder) {
        Intrinsics.f(builder, "<this>");
        return builder.a();
    }

    /* access modifiers changed from: protected */
    public abstract void u(CompositeEncoder compositeEncoder, Array array, int i2);
}
