package kotlinx.serialization.internal;

import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;

public final class UByteArraySerializer extends PrimitiveArraySerializer<UByte, UByteArray, UByteArrayBuilder> {

    /* renamed from: c  reason: collision with root package name */
    public static final UByteArraySerializer f41096c = new UByteArraySerializer();

    private UByteArraySerializer() {
        super(BuiltinSerializersKt.t(UByte.f40277c));
    }

    public /* bridge */ /* synthetic */ int e(Object obj) {
        return v(((UByteArray) obj).r());
    }

    public /* bridge */ /* synthetic */ Object k(Object obj) {
        return y(((UByteArray) obj).r());
    }

    public /* bridge */ /* synthetic */ Object r() {
        return UByteArray.a(w());
    }

    public /* bridge */ /* synthetic */ void u(CompositeEncoder compositeEncoder, Object obj, int i2) {
        z(compositeEncoder, ((UByteArray) obj).r(), i2);
    }

    /* access modifiers changed from: protected */
    public int v(byte[] bArr) {
        Intrinsics.f(bArr, "$this$collectionSize");
        return UByteArray.l(bArr);
    }

    /* access modifiers changed from: protected */
    public byte[] w() {
        return UByteArray.b(0);
    }

    /* access modifiers changed from: protected */
    /* renamed from: x */
    public void h(CompositeDecoder compositeDecoder, int i2, UByteArrayBuilder uByteArrayBuilder, boolean z2) {
        Intrinsics.f(compositeDecoder, "decoder");
        Intrinsics.f(uByteArrayBuilder, "builder");
        uByteArrayBuilder.e(UByte.b(compositeDecoder.r(getDescriptor(), i2).H()));
    }

    /* access modifiers changed from: protected */
    public UByteArrayBuilder y(byte[] bArr) {
        Intrinsics.f(bArr, "$this$toBuilder");
        return new UByteArrayBuilder(bArr, (DefaultConstructorMarker) null);
    }

    /* access modifiers changed from: protected */
    public void z(CompositeEncoder compositeEncoder, byte[] bArr, int i2) {
        Intrinsics.f(compositeEncoder, "encoder");
        Intrinsics.f(bArr, "content");
        for (int i3 = 0; i3 < i2; i3++) {
            compositeEncoder.f(getDescriptor(), i3).h(UByteArray.j(bArr, i3));
        }
    }
}
