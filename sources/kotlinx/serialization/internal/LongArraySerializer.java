package kotlinx.serialization.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;

public final class LongArraySerializer extends PrimitiveArraySerializer<Long, long[], LongArrayBuilder> {

    /* renamed from: c  reason: collision with root package name */
    public static final LongArraySerializer f41016c = new LongArraySerializer();

    private LongArraySerializer() {
        super(BuiltinSerializersKt.E(LongCompanionObject.f40421a));
    }

    /* access modifiers changed from: protected */
    /* renamed from: v */
    public int e(long[] jArr) {
        Intrinsics.f(jArr, "<this>");
        return jArr.length;
    }

    /* access modifiers changed from: protected */
    /* renamed from: w */
    public long[] r() {
        return new long[0];
    }

    /* access modifiers changed from: protected */
    /* renamed from: x */
    public void h(CompositeDecoder compositeDecoder, int i2, LongArrayBuilder longArrayBuilder, boolean z2) {
        Intrinsics.f(compositeDecoder, "decoder");
        Intrinsics.f(longArrayBuilder, "builder");
        longArrayBuilder.e(compositeDecoder.f(getDescriptor(), i2));
    }

    /* access modifiers changed from: protected */
    /* renamed from: y */
    public LongArrayBuilder k(long[] jArr) {
        Intrinsics.f(jArr, "<this>");
        return new LongArrayBuilder(jArr);
    }

    /* access modifiers changed from: protected */
    /* renamed from: z */
    public void u(CompositeEncoder compositeEncoder, long[] jArr, int i2) {
        Intrinsics.f(compositeEncoder, "encoder");
        Intrinsics.f(jArr, "content");
        for (int i3 = 0; i3 < i2; i3++) {
            compositeEncoder.F(getDescriptor(), i3, jArr[i3]);
        }
    }
}
