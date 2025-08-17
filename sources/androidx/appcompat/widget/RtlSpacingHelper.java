package androidx.appcompat.widget;

class RtlSpacingHelper {

    /* renamed from: a  reason: collision with root package name */
    private int f1348a = 0;

    /* renamed from: b  reason: collision with root package name */
    private int f1349b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f1350c = Integer.MIN_VALUE;

    /* renamed from: d  reason: collision with root package name */
    private int f1351d = Integer.MIN_VALUE;

    /* renamed from: e  reason: collision with root package name */
    private int f1352e = 0;

    /* renamed from: f  reason: collision with root package name */
    private int f1353f = 0;

    /* renamed from: g  reason: collision with root package name */
    private boolean f1354g = false;

    /* renamed from: h  reason: collision with root package name */
    private boolean f1355h = false;

    RtlSpacingHelper() {
    }

    public int a() {
        return this.f1354g ? this.f1348a : this.f1349b;
    }

    public int b() {
        return this.f1348a;
    }

    public int c() {
        return this.f1349b;
    }

    public int d() {
        return this.f1354g ? this.f1349b : this.f1348a;
    }

    public void e(int i2, int i3) {
        this.f1355h = false;
        if (i2 != Integer.MIN_VALUE) {
            this.f1352e = i2;
            this.f1348a = i2;
        }
        if (i3 != Integer.MIN_VALUE) {
            this.f1353f = i3;
            this.f1349b = i3;
        }
    }

    public void f(boolean z2) {
        if (z2 != this.f1354g) {
            this.f1354g = z2;
            if (!this.f1355h) {
                this.f1348a = this.f1352e;
                this.f1349b = this.f1353f;
            } else if (z2) {
                int i2 = this.f1351d;
                if (i2 == Integer.MIN_VALUE) {
                    i2 = this.f1352e;
                }
                this.f1348a = i2;
                int i3 = this.f1350c;
                if (i3 == Integer.MIN_VALUE) {
                    i3 = this.f1353f;
                }
                this.f1349b = i3;
            } else {
                int i4 = this.f1350c;
                if (i4 == Integer.MIN_VALUE) {
                    i4 = this.f1352e;
                }
                this.f1348a = i4;
                int i5 = this.f1351d;
                if (i5 == Integer.MIN_VALUE) {
                    i5 = this.f1353f;
                }
                this.f1349b = i5;
            }
        }
    }

    public void g(int i2, int i3) {
        this.f1350c = i2;
        this.f1351d = i3;
        this.f1355h = true;
        if (this.f1354g) {
            if (i3 != Integer.MIN_VALUE) {
                this.f1348a = i3;
            }
            if (i2 != Integer.MIN_VALUE) {
                this.f1349b = i2;
                return;
            }
            return;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f1348a = i2;
        }
        if (i3 != Integer.MIN_VALUE) {
            this.f1349b = i3;
        }
    }
}
