package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.ArrayList;

public class Barrier extends Helper {

    /* renamed from: x0  reason: collision with root package name */
    private int f1834x0 = 0;

    /* renamed from: y0  reason: collision with root package name */
    private ArrayList<ResolutionAnchor> f1835y0 = new ArrayList<>(4);

    /* renamed from: z0  reason: collision with root package name */
    private boolean f1836z0 = true;

    public void K0(boolean z2) {
        this.f1836z0 = z2;
    }

    public void L0(int i2) {
        this.f1834x0 = i2;
    }

    public void S() {
        super.S();
        this.f1835y0.clear();
    }

    public void U() {
        ResolutionAnchor resolutionAnchor;
        float f2;
        ResolutionAnchor resolutionAnchor2;
        int i2 = this.f1834x0;
        float f3 = Float.MAX_VALUE;
        if (i2 != 0) {
            if (i2 == 1) {
                resolutionAnchor = this.f1925w.f();
            } else if (i2 == 2) {
                resolutionAnchor = this.f1924v.f();
            } else if (i2 == 3) {
                resolutionAnchor = this.f1926x.f();
            } else {
                return;
            }
            f3 = 0.0f;
        } else {
            resolutionAnchor = this.f1923u.f();
        }
        int size = this.f1835y0.size();
        ResolutionAnchor resolutionAnchor3 = null;
        int i3 = 0;
        while (i3 < size) {
            ResolutionAnchor resolutionAnchor4 = this.f1835y0.get(i3);
            if (resolutionAnchor4.f1975b == 1) {
                int i4 = this.f1834x0;
                if (i4 == 0 || i4 == 2) {
                    f2 = resolutionAnchor4.f1965h;
                    if (f2 < f3) {
                        resolutionAnchor2 = resolutionAnchor4.f1964g;
                    } else {
                        i3++;
                    }
                } else {
                    f2 = resolutionAnchor4.f1965h;
                    if (f2 > f3) {
                        resolutionAnchor2 = resolutionAnchor4.f1964g;
                    } else {
                        i3++;
                    }
                }
                resolutionAnchor3 = resolutionAnchor2;
                f3 = f2;
                i3++;
            } else {
                return;
            }
        }
        if (LinearSystem.x() != null) {
            LinearSystem.x().f1814z++;
        }
        resolutionAnchor.f1964g = resolutionAnchor3;
        resolutionAnchor.f1965h = f3;
        resolutionAnchor.b();
        int i5 = this.f1834x0;
        if (i5 == 0) {
            this.f1925w.f().l(resolutionAnchor3, f3);
        } else if (i5 == 1) {
            this.f1923u.f().l(resolutionAnchor3, f3);
        } else if (i5 == 2) {
            this.f1926x.f().l(resolutionAnchor3, f3);
        } else if (i5 == 3) {
            this.f1924v.f().l(resolutionAnchor3, f3);
        }
    }

    public void b(LinearSystem linearSystem) {
        ConstraintAnchor[] constraintAnchorArr;
        boolean z2;
        int i2;
        int i3;
        ConstraintAnchor[] constraintAnchorArr2 = this.C;
        constraintAnchorArr2[0] = this.f1923u;
        constraintAnchorArr2[2] = this.f1924v;
        constraintAnchorArr2[1] = this.f1925w;
        constraintAnchorArr2[3] = this.f1926x;
        int i4 = 0;
        while (true) {
            constraintAnchorArr = this.C;
            if (i4 >= constraintAnchorArr.length) {
                break;
            }
            ConstraintAnchor constraintAnchor = constraintAnchorArr[i4];
            constraintAnchor.f1863j = linearSystem.r(constraintAnchor);
            i4++;
        }
        int i5 = this.f1834x0;
        if (i5 >= 0 && i5 < 4) {
            ConstraintAnchor constraintAnchor2 = constraintAnchorArr[i5];
            int i6 = 0;
            while (true) {
                if (i6 >= this.f1958w0) {
                    z2 = false;
                    break;
                }
                ConstraintWidget constraintWidget = this.f1957v0[i6];
                if ((this.f1836z0 || constraintWidget.c()) && ((((i2 = this.f1834x0) == 0 || i2 == 1) && constraintWidget.s() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) || (((i3 = this.f1834x0) == 2 || i3 == 3) && constraintWidget.B() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT))) {
                    z2 = true;
                } else {
                    i6++;
                }
            }
            int i7 = this.f1834x0;
            if (i7 == 0 || i7 == 1 ? u().s() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT : u().B() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                z2 = false;
            }
            for (int i8 = 0; i8 < this.f1958w0; i8++) {
                ConstraintWidget constraintWidget2 = this.f1957v0[i8];
                if (this.f1836z0 || constraintWidget2.c()) {
                    SolverVariable r2 = linearSystem.r(constraintWidget2.C[this.f1834x0]);
                    ConstraintAnchor[] constraintAnchorArr3 = constraintWidget2.C;
                    int i9 = this.f1834x0;
                    constraintAnchorArr3[i9].f1863j = r2;
                    if (i9 == 0 || i9 == 2) {
                        linearSystem.j(constraintAnchor2.f1863j, r2, z2);
                    } else {
                        linearSystem.h(constraintAnchor2.f1863j, r2, z2);
                    }
                }
            }
            int i10 = this.f1834x0;
            if (i10 == 0) {
                linearSystem.e(this.f1925w.f1863j, this.f1923u.f1863j, 0, 6);
                if (!z2) {
                    linearSystem.e(this.f1923u.f1863j, this.F.f1925w.f1863j, 0, 5);
                }
            } else if (i10 == 1) {
                linearSystem.e(this.f1923u.f1863j, this.f1925w.f1863j, 0, 6);
                if (!z2) {
                    linearSystem.e(this.f1923u.f1863j, this.F.f1923u.f1863j, 0, 5);
                }
            } else if (i10 == 2) {
                linearSystem.e(this.f1926x.f1863j, this.f1924v.f1863j, 0, 6);
                if (!z2) {
                    linearSystem.e(this.f1924v.f1863j, this.F.f1926x.f1863j, 0, 5);
                }
            } else if (i10 == 3) {
                linearSystem.e(this.f1924v.f1863j, this.f1926x.f1863j, 0, 6);
                if (!z2) {
                    linearSystem.e(this.f1924v.f1863j, this.F.f1924v.f1863j, 0, 5);
                }
            }
        }
    }

    public boolean c() {
        return true;
    }

    public void d(int i2) {
        ResolutionAnchor resolutionAnchor;
        ResolutionAnchor resolutionAnchor2;
        ConstraintWidget constraintWidget = this.F;
        if (constraintWidget != null && ((ConstraintWidgetContainer) constraintWidget).X0(2)) {
            int i3 = this.f1834x0;
            if (i3 == 0) {
                resolutionAnchor = this.f1923u.f();
            } else if (i3 == 1) {
                resolutionAnchor = this.f1925w.f();
            } else if (i3 == 2) {
                resolutionAnchor = this.f1924v.f();
            } else if (i3 == 3) {
                resolutionAnchor = this.f1926x.f();
            } else {
                return;
            }
            resolutionAnchor.p(5);
            int i4 = this.f1834x0;
            if (i4 == 0 || i4 == 1) {
                this.f1924v.f().l((ResolutionAnchor) null, 0.0f);
                this.f1926x.f().l((ResolutionAnchor) null, 0.0f);
            } else {
                this.f1923u.f().l((ResolutionAnchor) null, 0.0f);
                this.f1925w.f().l((ResolutionAnchor) null, 0.0f);
            }
            this.f1835y0.clear();
            for (int i5 = 0; i5 < this.f1958w0; i5++) {
                ConstraintWidget constraintWidget2 = this.f1957v0[i5];
                if (this.f1836z0 || constraintWidget2.c()) {
                    int i6 = this.f1834x0;
                    if (i6 == 0) {
                        resolutionAnchor2 = constraintWidget2.f1923u.f();
                    } else if (i6 == 1) {
                        resolutionAnchor2 = constraintWidget2.f1925w.f();
                    } else if (i6 == 2) {
                        resolutionAnchor2 = constraintWidget2.f1924v.f();
                    } else if (i6 != 3) {
                        resolutionAnchor2 = null;
                    } else {
                        resolutionAnchor2 = constraintWidget2.f1926x.f();
                    }
                    if (resolutionAnchor2 != null) {
                        this.f1835y0.add(resolutionAnchor2);
                        resolutionAnchor2.a(resolutionAnchor);
                    }
                }
            }
        }
    }
}
