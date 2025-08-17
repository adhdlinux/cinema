package kotlinx.serialization.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.ShortCompanionObject;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;

public final class ShortArraySerializer extends PrimitiveArraySerializer<Short, short[], ShortArrayBuilder> {

    /* renamed from: c  reason: collision with root package name */
    public static final ShortArraySerializer f41074c = new ShortArraySerializer();

    private ShortArraySerializer() {
        super(BuiltinSerializersKt.F(ShortCompanionObject.f40432a));
    }

    /* access modifiers changed from: protected */
    /* renamed from: v */
    public int e(short[] sArr) {
        Intrinsics.f(sArr, "<this>");
        return sArr.length;
    }

    /* access modifiers changed from: protected */
    /* renamed from: w */
    public short[] r() {
        return new short[0];
    }

    /* access modifiers changed from: protected */
    /* renamed from: x */
    public void h(CompositeDecoder compositeDecoder, int i2, ShortArrayBuilder shortArrayBuilder, boolean z2) {
        Intrinsics.f(compositeDecoder, "decoder");
        Intrinsics.f(shortArrayBuilder, "builder");
        shortArrayBuilder.e(compositeDecoder.E(getDescriptor(), i2));
    }

    /* access modifiers changed from: protected */
    /* renamed from: y */
    public ShortArrayBuilder k(short[] sArr) {
        Intrinsics.f(sArr, "<this>");
        return new ShortArrayBuilder(sArr);
    }

    /* access modifiers changed from: protected */
    /* renamed from: z */
    public void u(CompositeEncoder compositeEncoder, short[] sArr, int i2) {
        Intrinsics.f(compositeEncoder, "encoder");
        Intrinsics.f(sArr, "content");
        for (int i3 = 0; i3 < i2; i3++) {
            compositeEncoder.D(getDescriptor(), i3, sArr[i3]);
        }
    }
}
