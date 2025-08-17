package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

public final class BooleanArrayBuilder extends PrimitiveArrayBuilder<boolean[]> {

    /* renamed from: a  reason: collision with root package name */
    private boolean[] f40944a;

    /* renamed from: b  reason: collision with root package name */
    private int f40945b;

    public BooleanArrayBuilder(boolean[] zArr) {
        Intrinsics.f(zArr, "bufferWithData");
        this.f40944a = zArr;
        this.f40945b = zArr.length;
        b(10);
    }

    public void b(int i2) {
        boolean[] zArr = this.f40944a;
        if (zArr.length < i2) {
            boolean[] copyOf = Arrays.copyOf(zArr, RangesKt___RangesKt.b(i2, zArr.length * 2));
            Intrinsics.e(copyOf, "copyOf(this, newSize)");
            this.f40944a = copyOf;
        }
    }

    public int d() {
        return this.f40945b;
    }

    public final void e(boolean z2) {
        PrimitiveArrayBuilder.c(this, 0, 1, (Object) null);
        boolean[] zArr = this.f40944a;
        int d2 = d();
        this.f40945b = d2 + 1;
        zArr[d2] = z2;
    }

    /* renamed from: f */
    public boolean[] a() {
        boolean[] copyOf = Arrays.copyOf(this.f40944a, d());
        Intrinsics.e(copyOf, "copyOf(this, newSize)");
        return copyOf;
    }
}
