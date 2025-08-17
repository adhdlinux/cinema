package androidx.media3.common.util;

import java.util.NoSuchElementException;

public final class LongArrayQueue {

    /* renamed from: a  reason: collision with root package name */
    private int f4676a;

    /* renamed from: b  reason: collision with root package name */
    private int f4677b;

    /* renamed from: c  reason: collision with root package name */
    private int f4678c;

    /* renamed from: d  reason: collision with root package name */
    private long[] f4679d;

    /* renamed from: e  reason: collision with root package name */
    private int f4680e;

    public LongArrayQueue() {
        this(16);
    }

    public void a() {
        this.f4676a = 0;
        this.f4677b = -1;
        this.f4678c = 0;
    }

    public long b() {
        if (this.f4678c != 0) {
            return this.f4679d[this.f4676a];
        }
        throw new NoSuchElementException();
    }

    public boolean c() {
        return this.f4678c == 0;
    }

    public long d() {
        int i2 = this.f4678c;
        if (i2 != 0) {
            long[] jArr = this.f4679d;
            int i3 = this.f4676a;
            long j2 = jArr[i3];
            this.f4676a = this.f4680e & (i3 + 1);
            this.f4678c = i2 - 1;
            return j2;
        }
        throw new NoSuchElementException();
    }

    public LongArrayQueue(int i2) {
        Assertions.a(i2 >= 0 && i2 <= 1073741824);
        i2 = i2 == 0 ? 1 : i2;
        i2 = Integer.bitCount(i2) != 1 ? Integer.highestOneBit(i2 - 1) << 1 : i2;
        this.f4676a = 0;
        this.f4677b = -1;
        this.f4678c = 0;
        long[] jArr = new long[i2];
        this.f4679d = jArr;
        this.f4680e = jArr.length - 1;
    }
}
