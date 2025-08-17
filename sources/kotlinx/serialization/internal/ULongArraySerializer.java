package kotlinx.serialization.internal;

import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;

public final class ULongArraySerializer extends PrimitiveArraySerializer<ULong, ULongArray, ULongArrayBuilder> {

    /* renamed from: c  reason: collision with root package name */
    public static final ULongArraySerializer f41106c = new ULongArraySerializer();

    private ULongArraySerializer() {
        super(BuiltinSerializersKt.v(ULong.f40287c));
    }

    public /* bridge */ /* synthetic */ int e(Object obj) {
        return v(((ULongArray) obj).r());
    }

    public /* bridge */ /* synthetic */ Object k(Object obj) {
        return y(((ULongArray) obj).r());
    }

    public /* bridge */ /* synthetic */ Object r() {
        return ULongArray.a(w());
    }

    public /* bridge */ /* synthetic */ void u(CompositeEncoder compositeEncoder, Object obj, int i2) {
        z(compositeEncoder, ((ULongArray) obj).r(), i2);
    }

    /* access modifiers changed from: protected */
    public int v(long[] jArr) {
        Intrinsics.f(jArr, "$this$collectionSize");
        return ULongArray.l(jArr);
    }

    /* access modifiers changed from: protected */
    public long[] w() {
        return ULongArray.b(0);
    }

    /* access modifiers changed from: protected */
    /* renamed from: x */
    public void h(CompositeDecoder compositeDecoder, int i2, ULongArrayBuilder uLongArrayBuilder, boolean z2) {
        Intrinsics.f(compositeDecoder, "decoder");
        Intrinsics.f(uLongArrayBuilder, "builder");
        uLongArrayBuilder.e(ULong.b(compositeDecoder.r(getDescriptor(), i2).l()));
    }

    /* access modifiers changed from: protected */
    public ULongArrayBuilder y(long[] jArr) {
        Intrinsics.f(jArr, "$this$toBuilder");
        return new ULongArrayBuilder(jArr, (DefaultConstructorMarker) null);
    }

    /* access modifiers changed from: protected */
    public void z(CompositeEncoder compositeEncoder, long[] jArr, int i2) {
        Intrinsics.f(compositeEncoder, "encoder");
        Intrinsics.f(jArr, "content");
        for (int i3 = 0; i3 < i2; i3++) {
            compositeEncoder.f(getDescriptor(), i3).m(ULongArray.j(jArr, i3));
        }
    }
}
