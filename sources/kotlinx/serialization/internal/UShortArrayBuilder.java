package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.UShortArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class UShortArrayBuilder extends PrimitiveArrayBuilder<UShortArray> {

    /* renamed from: a  reason: collision with root package name */
    private short[] f41109a;

    /* renamed from: b  reason: collision with root package name */
    private int f41110b;

    private UShortArrayBuilder(short[] sArr) {
        this.f41109a = sArr;
        this.f41110b = UShortArray.l(sArr);
        b(10);
    }

    public /* synthetic */ UShortArrayBuilder(short[] sArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(sArr);
    }

    public /* bridge */ /* synthetic */ Object a() {
        return UShortArray.a(f());
    }

    public void b(int i2) {
        if (UShortArray.l(this.f41109a) < i2) {
            short[] sArr = this.f41109a;
            short[] copyOf = Arrays.copyOf(sArr, RangesKt___RangesKt.b(i2, UShortArray.l(sArr) * 2));
            Intrinsics.e(copyOf, "copyOf(this, newSize)");
            this.f41109a = UShortArray.d(copyOf);
        }
    }

    public int d() {
        return this.f41110b;
    }

    public final void e(short s2) {
        PrimitiveArrayBuilder.c(this, 0, 1, (Object) null);
        short[] sArr = this.f41109a;
        int d2 = d();
        this.f41110b = d2 + 1;
        UShortArray.p(sArr, d2, s2);
    }

    public short[] f() {
        short[] copyOf = Arrays.copyOf(this.f41109a, d());
        Intrinsics.e(copyOf, "copyOf(this, newSize)");
        return UShortArray.d(copyOf);
    }
}
