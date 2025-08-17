package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

public final class LongArrayBuilder extends PrimitiveArrayBuilder<long[]> {

    /* renamed from: a  reason: collision with root package name */
    private long[] f41014a;

    /* renamed from: b  reason: collision with root package name */
    private int f41015b;

    public LongArrayBuilder(long[] jArr) {
        Intrinsics.f(jArr, "bufferWithData");
        this.f41014a = jArr;
        this.f41015b = jArr.length;
        b(10);
    }

    public void b(int i2) {
        long[] jArr = this.f41014a;
        if (jArr.length < i2) {
            long[] copyOf = Arrays.copyOf(jArr, RangesKt___RangesKt.b(i2, jArr.length * 2));
            Intrinsics.e(copyOf, "copyOf(this, newSize)");
            this.f41014a = copyOf;
        }
    }

    public int d() {
        return this.f41015b;
    }

    public final void e(long j2) {
        PrimitiveArrayBuilder.c(this, 0, 1, (Object) null);
        long[] jArr = this.f41014a;
        int d2 = d();
        this.f41015b = d2 + 1;
        jArr[d2] = j2;
    }

    /* renamed from: f */
    public long[] a() {
        long[] copyOf = Arrays.copyOf(this.f41014a, d());
        Intrinsics.e(copyOf, "copyOf(this, newSize)");
        return copyOf;
    }
}
