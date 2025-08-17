package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

public final class FloatArrayBuilder extends PrimitiveArrayBuilder<float[]> {

    /* renamed from: a  reason: collision with root package name */
    private float[] f40994a;

    /* renamed from: b  reason: collision with root package name */
    private int f40995b;

    public FloatArrayBuilder(float[] fArr) {
        Intrinsics.f(fArr, "bufferWithData");
        this.f40994a = fArr;
        this.f40995b = fArr.length;
        b(10);
    }

    public void b(int i2) {
        float[] fArr = this.f40994a;
        if (fArr.length < i2) {
            float[] copyOf = Arrays.copyOf(fArr, RangesKt___RangesKt.b(i2, fArr.length * 2));
            Intrinsics.e(copyOf, "copyOf(this, newSize)");
            this.f40994a = copyOf;
        }
    }

    public int d() {
        return this.f40995b;
    }

    public final void e(float f2) {
        PrimitiveArrayBuilder.c(this, 0, 1, (Object) null);
        float[] fArr = this.f40994a;
        int d2 = d();
        this.f40995b = d2 + 1;
        fArr[d2] = f2;
    }

    /* renamed from: f */
    public float[] a() {
        float[] copyOf = Arrays.copyOf(this.f40994a, d());
        Intrinsics.e(copyOf, "copyOf(this, newSize)");
        return copyOf;
    }
}
