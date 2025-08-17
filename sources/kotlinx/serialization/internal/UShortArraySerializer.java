package kotlinx.serialization.internal;

import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;

public final class UShortArraySerializer extends PrimitiveArraySerializer<UShort, UShortArray, UShortArrayBuilder> {

    /* renamed from: c  reason: collision with root package name */
    public static final UShortArraySerializer f41111c = new UShortArraySerializer();

    private UShortArraySerializer() {
        super(BuiltinSerializersKt.w(UShort.f40293c));
    }

    public /* bridge */ /* synthetic */ int e(Object obj) {
        return v(((UShortArray) obj).r());
    }

    public /* bridge */ /* synthetic */ Object k(Object obj) {
        return y(((UShortArray) obj).r());
    }

    public /* bridge */ /* synthetic */ Object r() {
        return UShortArray.a(w());
    }

    public /* bridge */ /* synthetic */ void u(CompositeEncoder compositeEncoder, Object obj, int i2) {
        z(compositeEncoder, ((UShortArray) obj).r(), i2);
    }

    /* access modifiers changed from: protected */
    public int v(short[] sArr) {
        Intrinsics.f(sArr, "$this$collectionSize");
        return UShortArray.l(sArr);
    }

    /* access modifiers changed from: protected */
    public short[] w() {
        return UShortArray.b(0);
    }

    /* access modifiers changed from: protected */
    /* renamed from: x */
    public void h(CompositeDecoder compositeDecoder, int i2, UShortArrayBuilder uShortArrayBuilder, boolean z2) {
        Intrinsics.f(compositeDecoder, "decoder");
        Intrinsics.f(uShortArrayBuilder, "builder");
        uShortArrayBuilder.e(UShort.b(compositeDecoder.r(getDescriptor(), i2).s()));
    }

    /* access modifiers changed from: protected */
    public UShortArrayBuilder y(short[] sArr) {
        Intrinsics.f(sArr, "$this$toBuilder");
        return new UShortArrayBuilder(sArr, (DefaultConstructorMarker) null);
    }

    /* access modifiers changed from: protected */
    public void z(CompositeEncoder compositeEncoder, short[] sArr, int i2) {
        Intrinsics.f(compositeEncoder, "encoder");
        Intrinsics.f(sArr, "content");
        for (int i3 = 0; i3 < i2; i3++) {
            compositeEncoder.f(getDescriptor(), i3).q(UShortArray.j(sArr, i3));
        }
    }
}
