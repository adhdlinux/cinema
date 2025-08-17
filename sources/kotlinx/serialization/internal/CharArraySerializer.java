package kotlinx.serialization.internal;

import kotlin.jvm.internal.CharCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;

public final class CharArraySerializer extends PrimitiveArraySerializer<Character, char[], CharArrayBuilder> {

    /* renamed from: c  reason: collision with root package name */
    public static final CharArraySerializer f40958c = new CharArraySerializer();

    private CharArraySerializer() {
        super(BuiltinSerializersKt.A(CharCompanionObject.f40409a));
    }

    /* access modifiers changed from: protected */
    /* renamed from: v */
    public int e(char[] cArr) {
        Intrinsics.f(cArr, "<this>");
        return cArr.length;
    }

    /* access modifiers changed from: protected */
    /* renamed from: w */
    public char[] r() {
        return new char[0];
    }

    /* access modifiers changed from: protected */
    /* renamed from: x */
    public void h(CompositeDecoder compositeDecoder, int i2, CharArrayBuilder charArrayBuilder, boolean z2) {
        Intrinsics.f(compositeDecoder, "decoder");
        Intrinsics.f(charArrayBuilder, "builder");
        charArrayBuilder.e(compositeDecoder.A(getDescriptor(), i2));
    }

    /* access modifiers changed from: protected */
    /* renamed from: y */
    public CharArrayBuilder k(char[] cArr) {
        Intrinsics.f(cArr, "<this>");
        return new CharArrayBuilder(cArr);
    }

    /* access modifiers changed from: protected */
    /* renamed from: z */
    public void u(CompositeEncoder compositeEncoder, char[] cArr, int i2) {
        Intrinsics.f(compositeEncoder, "encoder");
        Intrinsics.f(cArr, "content");
        for (int i3 = 0; i3 < i2; i3++) {
            compositeEncoder.n(getDescriptor(), i3, cArr[i3]);
        }
    }
}
