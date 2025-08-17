package kotlinx.serialization.json.internal;

import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;
import q1.c;
import q1.i;
import q1.j;

public final class ComposerForUnsignedNumbers extends Composer {

    /* renamed from: c  reason: collision with root package name */
    private final boolean f41208c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ComposerForUnsignedNumbers(JsonWriter jsonWriter, boolean z2) {
        super(jsonWriter);
        Intrinsics.f(jsonWriter, "writer");
        this.f41208c = z2;
    }

    public void d(byte b2) {
        boolean z2 = this.f41208c;
        String e2 = UByte.e(UByte.b(b2));
        if (z2) {
            m(e2);
        } else {
            j(e2);
        }
    }

    public void h(int i2) {
        boolean z2 = this.f41208c;
        int b2 = UInt.b(i2);
        if (z2) {
            m(c.a(b2, 10));
        } else {
            j(c.a(b2, 10));
        }
    }

    public void i(long j2) {
        boolean z2 = this.f41208c;
        long b2 = ULong.b(j2);
        if (z2) {
            m(j.a(b2, 10));
        } else {
            j(i.a(b2, 10));
        }
    }

    public void k(short s2) {
        boolean z2 = this.f41208c;
        String e2 = UShort.e(UShort.b(s2));
        if (z2) {
            m(e2);
        } else {
            j(e2);
        }
    }
}
