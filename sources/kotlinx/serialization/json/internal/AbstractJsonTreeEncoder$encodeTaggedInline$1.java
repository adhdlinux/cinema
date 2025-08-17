package kotlinx.serialization.json.internal;

import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.encoding.AbstractEncoder;
import kotlinx.serialization.json.JsonLiteral;
import kotlinx.serialization.modules.SerializersModule;
import q1.c;
import q1.d;

public final class AbstractJsonTreeEncoder$encodeTaggedInline$1 extends AbstractEncoder {

    /* renamed from: a  reason: collision with root package name */
    private final SerializersModule f41196a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ AbstractJsonTreeEncoder f41197b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f41198c;

    AbstractJsonTreeEncoder$encodeTaggedInline$1(AbstractJsonTreeEncoder abstractJsonTreeEncoder, String str) {
        this.f41197b = abstractJsonTreeEncoder;
        this.f41198c = str;
        this.f41196a = abstractJsonTreeEncoder.d().a();
    }

    public void B(int i2) {
        K(c.a(UInt.b(i2), 10));
    }

    public final void K(String str) {
        Intrinsics.f(str, "s");
        this.f41197b.w0(this.f41198c, new JsonLiteral(str, false));
    }

    public SerializersModule a() {
        return this.f41196a;
    }

    public void h(byte b2) {
        K(UByte.e(UByte.b(b2)));
    }

    public void m(long j2) {
        K(d.a(ULong.b(j2), 10));
    }

    public void q(short s2) {
        K(UShort.e(UShort.b(s2)));
    }
}
