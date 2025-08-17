package androidx.palette.graphics;

public final class Target {

    /* renamed from: e  reason: collision with root package name */
    public static final Target f10799e;

    /* renamed from: f  reason: collision with root package name */
    public static final Target f10800f;

    /* renamed from: g  reason: collision with root package name */
    public static final Target f10801g;

    /* renamed from: h  reason: collision with root package name */
    public static final Target f10802h;

    /* renamed from: i  reason: collision with root package name */
    public static final Target f10803i;

    /* renamed from: j  reason: collision with root package name */
    public static final Target f10804j;

    /* renamed from: a  reason: collision with root package name */
    final float[] f10805a;

    /* renamed from: b  reason: collision with root package name */
    final float[] f10806b;

    /* renamed from: c  reason: collision with root package name */
    final float[] f10807c = new float[3];

    /* renamed from: d  reason: collision with root package name */
    boolean f10808d = true;

    static {
        Target target = new Target();
        f10799e = target;
        m(target);
        p(target);
        Target target2 = new Target();
        f10800f = target2;
        o(target2);
        p(target2);
        Target target3 = new Target();
        f10801g = target3;
        l(target3);
        p(target3);
        Target target4 = new Target();
        f10802h = target4;
        m(target4);
        n(target4);
        Target target5 = new Target();
        f10803i = target5;
        o(target5);
        n(target5);
        Target target6 = new Target();
        f10804j = target6;
        l(target6);
        n(target6);
    }

    Target() {
        float[] fArr = new float[3];
        this.f10805a = fArr;
        float[] fArr2 = new float[3];
        this.f10806b = fArr2;
        r(fArr);
        r(fArr2);
        q();
    }

    private static void l(Target target) {
        float[] fArr = target.f10806b;
        fArr[1] = 0.26f;
        fArr[2] = 0.45f;
    }

    private static void m(Target target) {
        float[] fArr = target.f10806b;
        fArr[0] = 0.55f;
        fArr[1] = 0.74f;
    }

    private static void n(Target target) {
        float[] fArr = target.f10805a;
        fArr[1] = 0.3f;
        fArr[2] = 0.4f;
    }

    private static void o(Target target) {
        float[] fArr = target.f10806b;
        fArr[0] = 0.3f;
        fArr[1] = 0.5f;
        fArr[2] = 0.7f;
    }

    private static void p(Target target) {
        float[] fArr = target.f10805a;
        fArr[0] = 0.35f;
        fArr[1] = 1.0f;
    }

    private void q() {
        float[] fArr = this.f10807c;
        fArr[0] = 0.24f;
        fArr[1] = 0.52f;
        fArr[2] = 0.24f;
    }

    private static void r(float[] fArr) {
        fArr[0] = 0.0f;
        fArr[1] = 0.5f;
        fArr[2] = 1.0f;
    }

    public float a() {
        return this.f10807c[1];
    }

    public float b() {
        return this.f10806b[2];
    }

    public float c() {
        return this.f10805a[2];
    }

    public float d() {
        return this.f10806b[0];
    }

    public float e() {
        return this.f10805a[0];
    }

    public float f() {
        return this.f10807c[2];
    }

    public float g() {
        return this.f10807c[0];
    }

    public float h() {
        return this.f10806b[1];
    }

    public float i() {
        return this.f10805a[1];
    }

    public boolean j() {
        return this.f10808d;
    }

    /* access modifiers changed from: package-private */
    public void k() {
        float f2 = 0.0f;
        for (float f3 : this.f10807c) {
            if (f3 > 0.0f) {
                f2 += f3;
            }
        }
        if (f2 != 0.0f) {
            int length = this.f10807c.length;
            for (int i2 = 0; i2 < length; i2++) {
                float[] fArr = this.f10807c;
                float f4 = fArr[i2];
                if (f4 > 0.0f) {
                    fArr[i2] = f4 / f2;
                }
            }
        }
    }
}
