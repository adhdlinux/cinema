package androidx.constraintlayout.solver.widgets;

public class ResolutionDimension extends ResolutionNode {

    /* renamed from: c  reason: collision with root package name */
    float f1973c = 0.0f;

    public void e() {
        super.e();
        this.f1973c = 0.0f;
    }

    public void g() {
        this.f1975b = 2;
    }

    public void h(int i2) {
        int i3 = this.f1975b;
        if (i3 == 0 || this.f1973c != ((float) i2)) {
            this.f1973c = (float) i2;
            if (i3 == 1) {
                c();
            }
            b();
        }
    }
}
