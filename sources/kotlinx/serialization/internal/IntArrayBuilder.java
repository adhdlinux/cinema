package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

public final class IntArrayBuilder extends PrimitiveArrayBuilder<int[]> {

    /* renamed from: a  reason: collision with root package name */
    private int[] f41003a;

    /* renamed from: b  reason: collision with root package name */
    private int f41004b;

    public IntArrayBuilder(int[] iArr) {
        Intrinsics.f(iArr, "bufferWithData");
        this.f41003a = iArr;
        this.f41004b = iArr.length;
        b(10);
    }

    public void b(int i2) {
        int[] iArr = this.f41003a;
        if (iArr.length < i2) {
            int[] copyOf = Arrays.copyOf(iArr, RangesKt___RangesKt.b(i2, iArr.length * 2));
            Intrinsics.e(copyOf, "copyOf(this, newSize)");
            this.f41003a = copyOf;
        }
    }

    public int d() {
        return this.f41004b;
    }

    public final void e(int i2) {
        PrimitiveArrayBuilder.c(this, 0, 1, (Object) null);
        int[] iArr = this.f41003a;
        int d2 = d();
        this.f41004b = d2 + 1;
        iArr[d2] = i2;
    }

    /* renamed from: f */
    public int[] a() {
        int[] copyOf = Arrays.copyOf(this.f41003a, d());
        Intrinsics.e(copyOf, "copyOf(this, newSize)");
        return copyOf;
    }
}
