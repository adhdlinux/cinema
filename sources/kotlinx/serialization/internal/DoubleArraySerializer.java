package kotlinx.serialization.internal;

import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;

public final class DoubleArraySerializer extends PrimitiveArraySerializer<Double, double[], DoubleArrayBuilder> {

    /* renamed from: c  reason: collision with root package name */
    public static final DoubleArraySerializer f40973c = new DoubleArraySerializer();

    private DoubleArraySerializer() {
        super(BuiltinSerializersKt.B(DoubleCompanionObject.f40418a));
    }

    /* access modifiers changed from: protected */
    /* renamed from: v */
    public int e(double[] dArr) {
        Intrinsics.f(dArr, "<this>");
        return dArr.length;
    }

    /* access modifiers changed from: protected */
    /* renamed from: w */
    public double[] r() {
        return new double[0];
    }

    /* access modifiers changed from: protected */
    /* renamed from: x */
    public void h(CompositeDecoder compositeDecoder, int i2, DoubleArrayBuilder doubleArrayBuilder, boolean z2) {
        Intrinsics.f(compositeDecoder, "decoder");
        Intrinsics.f(doubleArrayBuilder, "builder");
        doubleArrayBuilder.e(compositeDecoder.F(getDescriptor(), i2));
    }

    /* access modifiers changed from: protected */
    /* renamed from: y */
    public DoubleArrayBuilder k(double[] dArr) {
        Intrinsics.f(dArr, "<this>");
        return new DoubleArrayBuilder(dArr);
    }

    /* access modifiers changed from: protected */
    /* renamed from: z */
    public void u(CompositeEncoder compositeEncoder, double[] dArr, int i2) {
        Intrinsics.f(compositeEncoder, "encoder");
        Intrinsics.f(dArr, "content");
        for (int i3 = 0; i3 < i2; i3++) {
            compositeEncoder.E(getDescriptor(), i3, dArr[i3]);
        }
    }
}
