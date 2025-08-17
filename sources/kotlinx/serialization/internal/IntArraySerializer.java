package kotlinx.serialization.internal;

import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;

public final class IntArraySerializer extends PrimitiveArraySerializer<Integer, int[], IntArrayBuilder> {

    /* renamed from: c  reason: collision with root package name */
    public static final IntArraySerializer f41005c = new IntArraySerializer();

    private IntArraySerializer() {
        super(BuiltinSerializersKt.D(IntCompanionObject.f40420a));
    }

    /* access modifiers changed from: protected */
    /* renamed from: v */
    public int e(int[] iArr) {
        Intrinsics.f(iArr, "<this>");
        return iArr.length;
    }

    /* access modifiers changed from: protected */
    /* renamed from: w */
    public int[] r() {
        return new int[0];
    }

    /* access modifiers changed from: protected */
    /* renamed from: x */
    public void h(CompositeDecoder compositeDecoder, int i2, IntArrayBuilder intArrayBuilder, boolean z2) {
        Intrinsics.f(compositeDecoder, "decoder");
        Intrinsics.f(intArrayBuilder, "builder");
        intArrayBuilder.e(compositeDecoder.i(getDescriptor(), i2));
    }

    /* access modifiers changed from: protected */
    /* renamed from: y */
    public IntArrayBuilder k(int[] iArr) {
        Intrinsics.f(iArr, "<this>");
        return new IntArrayBuilder(iArr);
    }

    /* access modifiers changed from: protected */
    /* renamed from: z */
    public void u(CompositeEncoder compositeEncoder, int[] iArr, int i2) {
        Intrinsics.f(compositeEncoder, "encoder");
        Intrinsics.f(iArr, "content");
        for (int i3 = 0; i3 < i2; i3++) {
            compositeEncoder.w(getDescriptor(), i3, iArr[i3]);
        }
    }
}
