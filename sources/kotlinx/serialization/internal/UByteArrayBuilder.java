package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.UByteArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class UByteArrayBuilder extends PrimitiveArrayBuilder<UByteArray> {

    /* renamed from: a  reason: collision with root package name */
    private byte[] f41094a;

    /* renamed from: b  reason: collision with root package name */
    private int f41095b;

    private UByteArrayBuilder(byte[] bArr) {
        this.f41094a = bArr;
        this.f41095b = UByteArray.l(bArr);
        b(10);
    }

    public /* synthetic */ UByteArrayBuilder(byte[] bArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(bArr);
    }

    public /* bridge */ /* synthetic */ Object a() {
        return UByteArray.a(f());
    }

    public void b(int i2) {
        if (UByteArray.l(this.f41094a) < i2) {
            byte[] bArr = this.f41094a;
            byte[] copyOf = Arrays.copyOf(bArr, RangesKt___RangesKt.b(i2, UByteArray.l(bArr) * 2));
            Intrinsics.e(copyOf, "copyOf(this, newSize)");
            this.f41094a = UByteArray.d(copyOf);
        }
    }

    public int d() {
        return this.f41095b;
    }

    public final void e(byte b2) {
        PrimitiveArrayBuilder.c(this, 0, 1, (Object) null);
        byte[] bArr = this.f41094a;
        int d2 = d();
        this.f41095b = d2 + 1;
        UByteArray.p(bArr, d2, b2);
    }

    public byte[] f() {
        byte[] copyOf = Arrays.copyOf(this.f41094a, d());
        Intrinsics.e(copyOf, "copyOf(this, newSize)");
        return UByteArray.d(copyOf);
    }
}
