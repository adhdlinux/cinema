package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.ULongArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class ULongArrayBuilder extends PrimitiveArrayBuilder<ULongArray> {

    /* renamed from: a  reason: collision with root package name */
    private long[] f41104a;

    /* renamed from: b  reason: collision with root package name */
    private int f41105b;

    private ULongArrayBuilder(long[] jArr) {
        this.f41104a = jArr;
        this.f41105b = ULongArray.l(jArr);
        b(10);
    }

    public /* synthetic */ ULongArrayBuilder(long[] jArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(jArr);
    }

    public /* bridge */ /* synthetic */ Object a() {
        return ULongArray.a(f());
    }

    public void b(int i2) {
        if (ULongArray.l(this.f41104a) < i2) {
            long[] jArr = this.f41104a;
            long[] copyOf = Arrays.copyOf(jArr, RangesKt___RangesKt.b(i2, ULongArray.l(jArr) * 2));
            Intrinsics.e(copyOf, "copyOf(this, newSize)");
            this.f41104a = ULongArray.d(copyOf);
        }
    }

    public int d() {
        return this.f41105b;
    }

    public final void e(long j2) {
        PrimitiveArrayBuilder.c(this, 0, 1, (Object) null);
        long[] jArr = this.f41104a;
        int d2 = d();
        this.f41105b = d2 + 1;
        ULongArray.p(jArr, d2, j2);
    }

    public long[] f() {
        long[] copyOf = Arrays.copyOf(this.f41104a, d());
        Intrinsics.e(copyOf, "copyOf(this, newSize)");
        return ULongArray.d(copyOf);
    }
}
