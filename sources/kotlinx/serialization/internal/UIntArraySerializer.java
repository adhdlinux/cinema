package kotlinx.serialization.internal;

import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;

public final class UIntArraySerializer extends PrimitiveArraySerializer<UInt, UIntArray, UIntArrayBuilder> {

    /* renamed from: c  reason: collision with root package name */
    public static final UIntArraySerializer f41101c = new UIntArraySerializer();

    private UIntArraySerializer() {
        super(BuiltinSerializersKt.u(UInt.f40282c));
    }

    public /* bridge */ /* synthetic */ int e(Object obj) {
        return v(((UIntArray) obj).r());
    }

    public /* bridge */ /* synthetic */ Object k(Object obj) {
        return y(((UIntArray) obj).r());
    }

    public /* bridge */ /* synthetic */ Object r() {
        return UIntArray.a(w());
    }

    public /* bridge */ /* synthetic */ void u(CompositeEncoder compositeEncoder, Object obj, int i2) {
        z(compositeEncoder, ((UIntArray) obj).r(), i2);
    }

    /* access modifiers changed from: protected */
    public int v(int[] iArr) {
        Intrinsics.f(iArr, "$this$collectionSize");
        return UIntArray.l(iArr);
    }

    /* access modifiers changed from: protected */
    public int[] w() {
        return UIntArray.b(0);
    }

    /* access modifiers changed from: protected */
    /* renamed from: x */
    public void h(CompositeDecoder compositeDecoder, int i2, UIntArrayBuilder uIntArrayBuilder, boolean z2) {
        Intrinsics.f(compositeDecoder, "decoder");
        Intrinsics.f(uIntArrayBuilder, "builder");
        uIntArrayBuilder.e(UInt.b(compositeDecoder.r(getDescriptor(), i2).h()));
    }

    /* access modifiers changed from: protected */
    public UIntArrayBuilder y(int[] iArr) {
        Intrinsics.f(iArr, "$this$toBuilder");
        return new UIntArrayBuilder(iArr, (DefaultConstructorMarker) null);
    }

    /* access modifiers changed from: protected */
    public void z(CompositeEncoder compositeEncoder, int[] iArr, int i2) {
        Intrinsics.f(compositeEncoder, "encoder");
        Intrinsics.f(iArr, "content");
        for (int i3 = 0; i3 < i2; i3++) {
            compositeEncoder.f(getDescriptor(), i3).B(UIntArray.j(iArr, i3));
        }
    }
}
