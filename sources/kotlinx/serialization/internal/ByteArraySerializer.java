package kotlinx.serialization.internal;

import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;

public final class ByteArraySerializer extends PrimitiveArraySerializer<Byte, byte[], ByteArrayBuilder> {

    /* renamed from: c  reason: collision with root package name */
    public static final ByteArraySerializer f40951c = new ByteArraySerializer();

    private ByteArraySerializer() {
        super(BuiltinSerializersKt.z(ByteCompanionObject.f40407a));
    }

    /* access modifiers changed from: protected */
    /* renamed from: v */
    public int e(byte[] bArr) {
        Intrinsics.f(bArr, "<this>");
        return bArr.length;
    }

    /* access modifiers changed from: protected */
    /* renamed from: w */
    public byte[] r() {
        return new byte[0];
    }

    /* access modifiers changed from: protected */
    /* renamed from: x */
    public void h(CompositeDecoder compositeDecoder, int i2, ByteArrayBuilder byteArrayBuilder, boolean z2) {
        Intrinsics.f(compositeDecoder, "decoder");
        Intrinsics.f(byteArrayBuilder, "builder");
        byteArrayBuilder.e(compositeDecoder.B(getDescriptor(), i2));
    }

    /* access modifiers changed from: protected */
    /* renamed from: y */
    public ByteArrayBuilder k(byte[] bArr) {
        Intrinsics.f(bArr, "<this>");
        return new ByteArrayBuilder(bArr);
    }

    /* access modifiers changed from: protected */
    /* renamed from: z */
    public void u(CompositeEncoder compositeEncoder, byte[] bArr, int i2) {
        Intrinsics.f(compositeEncoder, "encoder");
        Intrinsics.f(bArr, "content");
        for (int i3 = 0; i3 < i2; i3++) {
            compositeEncoder.p(getDescriptor(), i3, bArr[i3]);
        }
    }
}
