package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

public final class DoubleArrayBuilder extends PrimitiveArrayBuilder<double[]> {

    /* renamed from: a  reason: collision with root package name */
    private double[] f40971a;

    /* renamed from: b  reason: collision with root package name */
    private int f40972b;

    public DoubleArrayBuilder(double[] dArr) {
        Intrinsics.f(dArr, "bufferWithData");
        this.f40971a = dArr;
        this.f40972b = dArr.length;
        b(10);
    }

    public void b(int i2) {
        double[] dArr = this.f40971a;
        if (dArr.length < i2) {
            double[] copyOf = Arrays.copyOf(dArr, RangesKt___RangesKt.b(i2, dArr.length * 2));
            Intrinsics.e(copyOf, "copyOf(this, newSize)");
            this.f40971a = copyOf;
        }
    }

    public int d() {
        return this.f40972b;
    }

    public final void e(double d2) {
        PrimitiveArrayBuilder.c(this, 0, 1, (Object) null);
        double[] dArr = this.f40971a;
        int d3 = d();
        this.f40972b = d3 + 1;
        dArr[d3] = d2;
    }

    /* renamed from: f */
    public double[] a() {
        double[] copyOf = Arrays.copyOf(this.f40971a, d());
        Intrinsics.e(copyOf, "copyOf(this, newSize)");
        return copyOf;
    }
}
