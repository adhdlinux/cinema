package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

public final class ShortArrayBuilder extends PrimitiveArrayBuilder<short[]> {

    /* renamed from: a  reason: collision with root package name */
    private short[] f41072a;

    /* renamed from: b  reason: collision with root package name */
    private int f41073b;

    public ShortArrayBuilder(short[] sArr) {
        Intrinsics.f(sArr, "bufferWithData");
        this.f41072a = sArr;
        this.f41073b = sArr.length;
        b(10);
    }

    public void b(int i2) {
        short[] sArr = this.f41072a;
        if (sArr.length < i2) {
            short[] copyOf = Arrays.copyOf(sArr, RangesKt___RangesKt.b(i2, sArr.length * 2));
            Intrinsics.e(copyOf, "copyOf(this, newSize)");
            this.f41072a = copyOf;
        }
    }

    public int d() {
        return this.f41073b;
    }

    public final void e(short s2) {
        PrimitiveArrayBuilder.c(this, 0, 1, (Object) null);
        short[] sArr = this.f41072a;
        int d2 = d();
        this.f41073b = d2 + 1;
        sArr[d2] = s2;
    }

    /* renamed from: f */
    public short[] a() {
        short[] copyOf = Arrays.copyOf(this.f41072a, d());
        Intrinsics.e(copyOf, "copyOf(this, newSize)");
        return copyOf;
    }
}
