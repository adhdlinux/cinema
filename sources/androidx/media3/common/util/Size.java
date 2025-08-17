package androidx.media3.common.util;

public final class Size {

    /* renamed from: c  reason: collision with root package name */
    public static final Size f4698c = new Size(-1, -1);

    /* renamed from: d  reason: collision with root package name */
    public static final Size f4699d = new Size(0, 0);

    /* renamed from: a  reason: collision with root package name */
    private final int f4700a;

    /* renamed from: b  reason: collision with root package name */
    private final int f4701b;

    public Size(int i2, int i3) {
        boolean z2;
        if ((i2 == -1 || i2 >= 0) && (i3 == -1 || i3 >= 0)) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.a(z2);
        this.f4700a = i2;
        this.f4701b = i3;
    }

    public int a() {
        return this.f4701b;
    }

    public int b() {
        return this.f4700a;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Size)) {
            return false;
        }
        Size size = (Size) obj;
        if (this.f4700a == size.f4700a && this.f4701b == size.f4701b) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i2 = this.f4701b;
        int i3 = this.f4700a;
        return i2 ^ ((i3 >>> 16) | (i3 << 16));
    }

    public String toString() {
        return this.f4700a + "x" + this.f4701b;
    }
}
