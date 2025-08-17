package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

public final class ByteArrayBuilder extends PrimitiveArrayBuilder<byte[]> {

    /* renamed from: a  reason: collision with root package name */
    private byte[] f40949a;

    /* renamed from: b  reason: collision with root package name */
    private int f40950b;

    public ByteArrayBuilder(byte[] bArr) {
        Intrinsics.f(bArr, "bufferWithData");
        this.f40949a = bArr;
        this.f40950b = bArr.length;
        b(10);
    }

    public void b(int i2) {
        byte[] bArr = this.f40949a;
        if (bArr.length < i2) {
            byte[] copyOf = Arrays.copyOf(bArr, RangesKt___RangesKt.b(i2, bArr.length * 2));
            Intrinsics.e(copyOf, "copyOf(this, newSize)");
            this.f40949a = copyOf;
        }
    }

    public int d() {
        return this.f40950b;
    }

    public final void e(byte b2) {
        PrimitiveArrayBuilder.c(this, 0, 1, (Object) null);
        byte[] bArr = this.f40949a;
        int d2 = d();
        this.f40950b = d2 + 1;
        bArr[d2] = b2;
    }

    /* renamed from: f */
    public byte[] a() {
        byte[] copyOf = Arrays.copyOf(this.f40949a, d());
        Intrinsics.e(copyOf, "copyOf(this, newSize)");
        return copyOf;
    }
}
