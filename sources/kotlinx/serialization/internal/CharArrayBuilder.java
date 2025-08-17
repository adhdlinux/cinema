package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

public final class CharArrayBuilder extends PrimitiveArrayBuilder<char[]> {

    /* renamed from: a  reason: collision with root package name */
    private char[] f40956a;

    /* renamed from: b  reason: collision with root package name */
    private int f40957b;

    public CharArrayBuilder(char[] cArr) {
        Intrinsics.f(cArr, "bufferWithData");
        this.f40956a = cArr;
        this.f40957b = cArr.length;
        b(10);
    }

    public void b(int i2) {
        char[] cArr = this.f40956a;
        if (cArr.length < i2) {
            char[] copyOf = Arrays.copyOf(cArr, RangesKt___RangesKt.b(i2, cArr.length * 2));
            Intrinsics.e(copyOf, "copyOf(this, newSize)");
            this.f40956a = copyOf;
        }
    }

    public int d() {
        return this.f40957b;
    }

    public final void e(char c2) {
        PrimitiveArrayBuilder.c(this, 0, 1, (Object) null);
        char[] cArr = this.f40956a;
        int d2 = d();
        this.f40957b = d2 + 1;
        cArr[d2] = c2;
    }

    /* renamed from: f */
    public char[] a() {
        char[] copyOf = Arrays.copyOf(this.f40956a, d());
        Intrinsics.e(copyOf, "copyOf(this, newSize)");
        return copyOf;
    }
}
