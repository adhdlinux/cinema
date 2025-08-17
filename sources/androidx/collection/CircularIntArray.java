package androidx.collection;

public final class CircularIntArray {

    /* renamed from: a  reason: collision with root package name */
    private int[] f1691a;

    /* renamed from: b  reason: collision with root package name */
    private int f1692b;

    /* renamed from: c  reason: collision with root package name */
    private int f1693c;

    /* renamed from: d  reason: collision with root package name */
    private int f1694d;

    public CircularIntArray() {
        this(8);
    }

    private void c() {
        int[] iArr = this.f1691a;
        int length = iArr.length;
        int i2 = this.f1692b;
        int i3 = length - i2;
        int i4 = length << 1;
        if (i4 >= 0) {
            int[] iArr2 = new int[i4];
            System.arraycopy(iArr, i2, iArr2, 0, i3);
            System.arraycopy(this.f1691a, 0, iArr2, i3, this.f1692b);
            this.f1691a = iArr2;
            this.f1692b = 0;
            this.f1693c = length;
            this.f1694d = i4 - 1;
            return;
        }
        throw new RuntimeException("Max array capacity exceeded");
    }

    public void a(int i2) {
        int[] iArr = this.f1691a;
        int i3 = this.f1693c;
        iArr[i3] = i2;
        int i4 = this.f1694d & (i3 + 1);
        this.f1693c = i4;
        if (i4 == this.f1692b) {
            c();
        }
    }

    public void b() {
        this.f1693c = this.f1692b;
    }

    public boolean d() {
        return this.f1692b == this.f1693c;
    }

    public int e() {
        int i2 = this.f1692b;
        if (i2 != this.f1693c) {
            int i3 = this.f1691a[i2];
            this.f1692b = (i2 + 1) & this.f1694d;
            return i3;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public CircularIntArray(int i2) {
        if (i2 < 1) {
            throw new IllegalArgumentException("capacity must be >= 1");
        } else if (i2 <= 1073741824) {
            i2 = Integer.bitCount(i2) != 1 ? Integer.highestOneBit(i2 - 1) << 1 : i2;
            this.f1694d = i2 - 1;
            this.f1691a = new int[i2];
        } else {
            throw new IllegalArgumentException("capacity must be <= 2^30");
        }
    }
}
