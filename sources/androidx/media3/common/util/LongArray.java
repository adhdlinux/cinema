package androidx.media3.common.util;

import java.util.Arrays;

public final class LongArray {

    /* renamed from: a  reason: collision with root package name */
    private int f4674a;

    /* renamed from: b  reason: collision with root package name */
    private long[] f4675b;

    public LongArray() {
        this(32);
    }

    public void a(long j2) {
        int i2 = this.f4674a;
        long[] jArr = this.f4675b;
        if (i2 == jArr.length) {
            this.f4675b = Arrays.copyOf(jArr, i2 * 2);
        }
        long[] jArr2 = this.f4675b;
        int i3 = this.f4674a;
        this.f4674a = i3 + 1;
        jArr2[i3] = j2;
    }

    public long b(int i2) {
        if (i2 >= 0 && i2 < this.f4674a) {
            return this.f4675b[i2];
        }
        throw new IndexOutOfBoundsException("Invalid index " + i2 + ", size is " + this.f4674a);
    }

    public int c() {
        return this.f4674a;
    }

    public LongArray(int i2) {
        this.f4675b = new long[i2];
    }
}
