package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;

public class ResolutionAnchor extends ResolutionNode {

    /* renamed from: c  reason: collision with root package name */
    ConstraintAnchor f1960c;

    /* renamed from: d  reason: collision with root package name */
    float f1961d;

    /* renamed from: e  reason: collision with root package name */
    ResolutionAnchor f1962e;

    /* renamed from: f  reason: collision with root package name */
    float f1963f;

    /* renamed from: g  reason: collision with root package name */
    ResolutionAnchor f1964g;

    /* renamed from: h  reason: collision with root package name */
    float f1965h;

    /* renamed from: i  reason: collision with root package name */
    int f1966i = 0;

    /* renamed from: j  reason: collision with root package name */
    private ResolutionAnchor f1967j;

    /* renamed from: k  reason: collision with root package name */
    private float f1968k;

    /* renamed from: l  reason: collision with root package name */
    private ResolutionDimension f1969l = null;

    /* renamed from: m  reason: collision with root package name */
    private int f1970m = 1;

    /* renamed from: n  reason: collision with root package name */
    private ResolutionDimension f1971n = null;

    /* renamed from: o  reason: collision with root package name */
    private int f1972o = 1;

    public ResolutionAnchor(ConstraintAnchor constraintAnchor) {
        this.f1960c = constraintAnchor;
    }

    public void e() {
        super.e();
        this.f1962e = null;
        this.f1963f = 0.0f;
        this.f1969l = null;
        this.f1970m = 1;
        this.f1971n = null;
        this.f1972o = 1;
        this.f1964g = null;
        this.f1965h = 0.0f;
        this.f1961d = 0.0f;
        this.f1967j = null;
        this.f1968k = 0.0f;
        this.f1966i = 0;
    }

    public void f() {
        int i2;
        ResolutionAnchor resolutionAnchor;
        ResolutionAnchor resolutionAnchor2;
        ResolutionAnchor resolutionAnchor3;
        ResolutionAnchor resolutionAnchor4;
        ResolutionAnchor resolutionAnchor5;
        ResolutionAnchor resolutionAnchor6;
        float f2;
        float f3;
        float f4;
        ResolutionAnchor resolutionAnchor7;
        boolean z2 = true;
        if (this.f1975b != 1 && (i2 = this.f1966i) != 4) {
            ResolutionDimension resolutionDimension = this.f1969l;
            if (resolutionDimension != null) {
                if (resolutionDimension.f1975b == 1) {
                    this.f1963f = ((float) this.f1970m) * resolutionDimension.f1973c;
                } else {
                    return;
                }
            }
            ResolutionDimension resolutionDimension2 = this.f1971n;
            if (resolutionDimension2 != null) {
                if (resolutionDimension2.f1975b == 1) {
                    this.f1968k = ((float) this.f1972o) * resolutionDimension2.f1973c;
                } else {
                    return;
                }
            }
            if (i2 == 1 && ((resolutionAnchor7 = this.f1962e) == null || resolutionAnchor7.f1975b == 1)) {
                if (resolutionAnchor7 == null) {
                    this.f1964g = this;
                    this.f1965h = this.f1963f;
                } else {
                    this.f1964g = resolutionAnchor7.f1964g;
                    this.f1965h = resolutionAnchor7.f1965h + this.f1963f;
                }
                b();
            } else if (i2 == 2 && (resolutionAnchor4 = this.f1962e) != null && resolutionAnchor4.f1975b == 1 && (resolutionAnchor5 = this.f1967j) != null && (resolutionAnchor6 = resolutionAnchor5.f1962e) != null && resolutionAnchor6.f1975b == 1) {
                if (LinearSystem.x() != null) {
                    LinearSystem.x().f1811w++;
                }
                ResolutionAnchor resolutionAnchor8 = this.f1962e;
                this.f1964g = resolutionAnchor8.f1964g;
                ResolutionAnchor resolutionAnchor9 = this.f1967j;
                ResolutionAnchor resolutionAnchor10 = resolutionAnchor9.f1962e;
                resolutionAnchor9.f1964g = resolutionAnchor10.f1964g;
                ConstraintAnchor constraintAnchor = this.f1960c;
                ConstraintAnchor.Type type = constraintAnchor.f1856c;
                ConstraintAnchor.Type type2 = ConstraintAnchor.Type.RIGHT;
                int i3 = 0;
                if (!(type == type2 || type == ConstraintAnchor.Type.BOTTOM)) {
                    z2 = false;
                }
                if (z2) {
                    f2 = resolutionAnchor8.f1965h - resolutionAnchor10.f1965h;
                } else {
                    f2 = resolutionAnchor10.f1965h - resolutionAnchor8.f1965h;
                }
                if (type == ConstraintAnchor.Type.LEFT || type == type2) {
                    f4 = f2 - ((float) constraintAnchor.f1855b.D());
                    f3 = this.f1960c.f1855b.Z;
                } else {
                    f4 = f2 - ((float) constraintAnchor.f1855b.r());
                    f3 = this.f1960c.f1855b.f1884a0;
                }
                int d2 = this.f1960c.d();
                int d3 = this.f1967j.f1960c.d();
                if (this.f1960c.i() == this.f1967j.f1960c.i()) {
                    f3 = 0.5f;
                    d3 = 0;
                } else {
                    i3 = d2;
                }
                float f5 = (float) i3;
                float f6 = (float) d3;
                float f7 = (f4 - f5) - f6;
                if (z2) {
                    ResolutionAnchor resolutionAnchor11 = this.f1967j;
                    resolutionAnchor11.f1965h = resolutionAnchor11.f1962e.f1965h + f6 + (f7 * f3);
                    this.f1965h = (this.f1962e.f1965h - f5) - (f7 * (1.0f - f3));
                } else {
                    this.f1965h = this.f1962e.f1965h + f5 + (f7 * f3);
                    ResolutionAnchor resolutionAnchor12 = this.f1967j;
                    resolutionAnchor12.f1965h = (resolutionAnchor12.f1962e.f1965h - f6) - (f7 * (1.0f - f3));
                }
                b();
                this.f1967j.b();
            } else if (i2 == 3 && (resolutionAnchor = this.f1962e) != null && resolutionAnchor.f1975b == 1 && (resolutionAnchor2 = this.f1967j) != null && (resolutionAnchor3 = resolutionAnchor2.f1962e) != null && resolutionAnchor3.f1975b == 1) {
                if (LinearSystem.x() != null) {
                    LinearSystem.x().f1812x++;
                }
                ResolutionAnchor resolutionAnchor13 = this.f1962e;
                this.f1964g = resolutionAnchor13.f1964g;
                ResolutionAnchor resolutionAnchor14 = this.f1967j;
                ResolutionAnchor resolutionAnchor15 = resolutionAnchor14.f1962e;
                resolutionAnchor14.f1964g = resolutionAnchor15.f1964g;
                this.f1965h = resolutionAnchor13.f1965h + this.f1963f;
                resolutionAnchor14.f1965h = resolutionAnchor15.f1965h + resolutionAnchor14.f1963f;
                b();
                this.f1967j.b();
            } else if (i2 == 5) {
                this.f1960c.f1855b.U();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void g(LinearSystem linearSystem) {
        SolverVariable g2 = this.f1960c.g();
        ResolutionAnchor resolutionAnchor = this.f1964g;
        if (resolutionAnchor == null) {
            linearSystem.f(g2, (int) (this.f1965h + 0.5f));
        } else {
            linearSystem.e(g2, linearSystem.r(resolutionAnchor.f1960c), (int) (this.f1965h + 0.5f), 6);
        }
    }

    public void h(int i2, ResolutionAnchor resolutionAnchor, int i3) {
        this.f1966i = i2;
        this.f1962e = resolutionAnchor;
        this.f1963f = (float) i3;
        resolutionAnchor.a(this);
    }

    public void i(ResolutionAnchor resolutionAnchor, int i2) {
        this.f1962e = resolutionAnchor;
        this.f1963f = (float) i2;
        resolutionAnchor.a(this);
    }

    public void j(ResolutionAnchor resolutionAnchor, int i2, ResolutionDimension resolutionDimension) {
        this.f1962e = resolutionAnchor;
        resolutionAnchor.a(this);
        this.f1969l = resolutionDimension;
        this.f1970m = i2;
        resolutionDimension.a(this);
    }

    public float k() {
        return this.f1965h;
    }

    public void l(ResolutionAnchor resolutionAnchor, float f2) {
        int i2 = this.f1975b;
        if (i2 == 0 || !(this.f1964g == resolutionAnchor || this.f1965h == f2)) {
            this.f1964g = resolutionAnchor;
            this.f1965h = f2;
            if (i2 == 1) {
                c();
            }
            b();
        }
    }

    /* access modifiers changed from: package-private */
    public String m(int i2) {
        return i2 == 1 ? "DIRECT" : i2 == 2 ? "CENTER" : i2 == 3 ? "MATCH" : i2 == 4 ? "CHAIN" : i2 == 5 ? "BARRIER" : "UNCONNECTED";
    }

    public void n(ResolutionAnchor resolutionAnchor, float f2) {
        this.f1967j = resolutionAnchor;
        this.f1968k = f2;
    }

    public void o(ResolutionAnchor resolutionAnchor, int i2, ResolutionDimension resolutionDimension) {
        this.f1967j = resolutionAnchor;
        this.f1971n = resolutionDimension;
        this.f1972o = i2;
    }

    public void p(int i2) {
        this.f1966i = i2;
    }

    public void q() {
        ConstraintAnchor i2 = this.f1960c.i();
        if (i2 != null) {
            if (i2.i() == this.f1960c) {
                this.f1966i = 4;
                i2.f().f1966i = 4;
            }
            int d2 = this.f1960c.d();
            ConstraintAnchor.Type type = this.f1960c.f1856c;
            if (type == ConstraintAnchor.Type.RIGHT || type == ConstraintAnchor.Type.BOTTOM) {
                d2 = -d2;
            }
            i(i2.f(), d2);
        }
    }

    public String toString() {
        if (this.f1975b != 1) {
            return "{ " + this.f1960c + " UNRESOLVED} type: " + m(this.f1966i);
        } else if (this.f1964g == this) {
            return "[" + this.f1960c + ", RESOLVED: " + this.f1965h + "]  type: " + m(this.f1966i);
        } else {
            return "[" + this.f1960c + ", RESOLVED: " + this.f1964g + ":" + this.f1965h + "] type: " + m(this.f1966i);
        }
    }
}
