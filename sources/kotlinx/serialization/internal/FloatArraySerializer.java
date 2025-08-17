package kotlinx.serialization.internal;

import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;

public final class FloatArraySerializer extends PrimitiveArraySerializer<Float, float[], FloatArrayBuilder> {

    /* renamed from: c  reason: collision with root package name */
    public static final FloatArraySerializer f40996c = new FloatArraySerializer();

    private FloatArraySerializer() {
        super(BuiltinSerializersKt.C(FloatCompanionObject.f40419a));
    }

    /* access modifiers changed from: protected */
    /* renamed from: v */
    public int e(float[] fArr) {
        Intrinsics.f(fArr, "<this>");
        return fArr.length;
    }

    /* access modifiers changed from: protected */
    /* renamed from: w */
    public float[] r() {
        return new float[0];
    }

    /* access modifiers changed from: protected */
    /* renamed from: x */
    public void h(CompositeDecoder compositeDecoder, int i2, FloatArrayBuilder floatArrayBuilder, boolean z2) {
        Intrinsics.f(compositeDecoder, "decoder");
        Intrinsics.f(floatArrayBuilder, "builder");
        floatArrayBuilder.e(compositeDecoder.u(getDescriptor(), i2));
    }

    /* access modifiers changed from: protected */
    /* renamed from: y */
    public FloatArrayBuilder k(float[] fArr) {
        Intrinsics.f(fArr, "<this>");
        return new FloatArrayBuilder(fArr);
    }

    /* access modifiers changed from: protected */
    /* renamed from: z */
    public void u(CompositeEncoder compositeEncoder, float[] fArr, int i2) {
        Intrinsics.f(compositeEncoder, "encoder");
        Intrinsics.f(fArr, "content");
        for (int i3 = 0; i3 < i2; i3++) {
            compositeEncoder.s(getDescriptor(), i3, fArr[i3]);
        }
    }
}
