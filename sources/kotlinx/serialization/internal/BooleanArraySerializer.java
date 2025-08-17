package kotlinx.serialization.internal;

import kotlin.jvm.internal.BooleanCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;

public final class BooleanArraySerializer extends PrimitiveArraySerializer<Boolean, boolean[], BooleanArrayBuilder> {

    /* renamed from: c  reason: collision with root package name */
    public static final BooleanArraySerializer f40946c = new BooleanArraySerializer();

    private BooleanArraySerializer() {
        super(BuiltinSerializersKt.y(BooleanCompanionObject.f40406a));
    }

    /* access modifiers changed from: protected */
    /* renamed from: v */
    public int e(boolean[] zArr) {
        Intrinsics.f(zArr, "<this>");
        return zArr.length;
    }

    /* access modifiers changed from: protected */
    /* renamed from: w */
    public boolean[] r() {
        return new boolean[0];
    }

    /* access modifiers changed from: protected */
    /* renamed from: x */
    public void h(CompositeDecoder compositeDecoder, int i2, BooleanArrayBuilder booleanArrayBuilder, boolean z2) {
        Intrinsics.f(compositeDecoder, "decoder");
        Intrinsics.f(booleanArrayBuilder, "builder");
        booleanArrayBuilder.e(compositeDecoder.C(getDescriptor(), i2));
    }

    /* access modifiers changed from: protected */
    /* renamed from: y */
    public BooleanArrayBuilder k(boolean[] zArr) {
        Intrinsics.f(zArr, "<this>");
        return new BooleanArrayBuilder(zArr);
    }

    /* access modifiers changed from: protected */
    /* renamed from: z */
    public void u(CompositeEncoder compositeEncoder, boolean[] zArr, int i2) {
        Intrinsics.f(compositeEncoder, "encoder");
        Intrinsics.f(zArr, "content");
        for (int i3 = 0; i3 < i2; i3++) {
            compositeEncoder.x(getDescriptor(), i3, zArr[i3]);
        }
    }
}
