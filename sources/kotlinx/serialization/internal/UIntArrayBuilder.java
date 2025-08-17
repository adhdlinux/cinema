package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.UIntArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class UIntArrayBuilder extends PrimitiveArrayBuilder<UIntArray> {

    /* renamed from: a  reason: collision with root package name */
    private int[] f41099a;

    /* renamed from: b  reason: collision with root package name */
    private int f41100b;

    private UIntArrayBuilder(int[] iArr) {
        this.f41099a = iArr;
        this.f41100b = UIntArray.l(iArr);
        b(10);
    }

    public /* synthetic */ UIntArrayBuilder(int[] iArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(iArr);
    }

    public /* bridge */ /* synthetic */ Object a() {
        return UIntArray.a(f());
    }

    public void b(int i2) {
        if (UIntArray.l(this.f41099a) < i2) {
            int[] iArr = this.f41099a;
            int[] copyOf = Arrays.copyOf(iArr, RangesKt___RangesKt.b(i2, UIntArray.l(iArr) * 2));
            Intrinsics.e(copyOf, "copyOf(this, newSize)");
            this.f41099a = UIntArray.d(copyOf);
        }
    }

    public int d() {
        return this.f41100b;
    }

    public final void e(int i2) {
        PrimitiveArrayBuilder.c(this, 0, 1, (Object) null);
        int[] iArr = this.f41099a;
        int d2 = d();
        this.f41100b = d2 + 1;
        UIntArray.p(iArr, d2, i2);
    }

    public int[] f() {
        int[] copyOf = Arrays.copyOf(this.f41099a, d());
        Intrinsics.e(copyOf, "copyOf(this, newSize)");
        return UIntArray.d(copyOf);
    }
}
