package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.ArrayList;

public class Guideline extends ConstraintWidget {
    private boolean A0;
    private int B0;
    private Rectangle C0;
    private int D0;

    /* renamed from: v0  reason: collision with root package name */
    protected float f1951v0 = -1.0f;

    /* renamed from: w0  reason: collision with root package name */
    protected int f1952w0 = -1;

    /* renamed from: x0  reason: collision with root package name */
    protected int f1953x0 = -1;

    /* renamed from: y0  reason: collision with root package name */
    private ConstraintAnchor f1954y0 = this.f1924v;

    /* renamed from: z0  reason: collision with root package name */
    private int f1955z0;

    /* renamed from: androidx.constraintlayout.solver.widgets.Guideline$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f1956a;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|(3:17|18|20)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type[] r0 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f1956a = r0
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f1956a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f1956a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f1956a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f1956a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BASELINE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f1956a     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.CENTER     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f1956a     // Catch:{ NoSuchFieldError -> 0x0054 }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.CENTER_X     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f1956a     // Catch:{ NoSuchFieldError -> 0x0060 }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.CENTER_Y     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f1956a     // Catch:{ NoSuchFieldError -> 0x006c }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.NONE     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.Guideline.AnonymousClass1.<clinit>():void");
        }
    }

    public Guideline() {
        this.f1955z0 = 0;
        this.A0 = false;
        this.B0 = 0;
        this.C0 = new Rectangle();
        this.D0 = 8;
        this.D.clear();
        this.D.add(this.f1954y0);
        int length = this.C.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.C[i2] = this.f1954y0;
        }
    }

    public void G0(LinearSystem linearSystem) {
        if (u() != null) {
            int y2 = linearSystem.y(this.f1954y0);
            if (this.f1955z0 == 1) {
                C0(y2);
                D0(0);
                b0(u().r());
                y0(0);
                return;
            }
            C0(0);
            D0(y2);
            y0(u().D());
            b0(0);
        }
    }

    public int I0() {
        return this.f1955z0;
    }

    public void J0(int i2) {
        if (i2 > -1) {
            this.f1951v0 = -1.0f;
            this.f1952w0 = i2;
            this.f1953x0 = -1;
        }
    }

    public void K0(int i2) {
        if (i2 > -1) {
            this.f1951v0 = -1.0f;
            this.f1952w0 = -1;
            this.f1953x0 = i2;
        }
    }

    public void L0(float f2) {
        if (f2 > -1.0f) {
            this.f1951v0 = f2;
            this.f1952w0 = -1;
            this.f1953x0 = -1;
        }
    }

    public void M0(int i2) {
        if (this.f1955z0 != i2) {
            this.f1955z0 = i2;
            this.D.clear();
            if (this.f1955z0 == 1) {
                this.f1954y0 = this.f1923u;
            } else {
                this.f1954y0 = this.f1924v;
            }
            this.D.add(this.f1954y0);
            int length = this.C.length;
            for (int i3 = 0; i3 < length; i3++) {
                this.C[i3] = this.f1954y0;
            }
        }
    }

    public void b(LinearSystem linearSystem) {
        boolean z2;
        ConstraintWidgetContainer constraintWidgetContainer = (ConstraintWidgetContainer) u();
        if (constraintWidgetContainer != null) {
            ConstraintAnchor h2 = constraintWidgetContainer.h(ConstraintAnchor.Type.LEFT);
            ConstraintAnchor h3 = constraintWidgetContainer.h(ConstraintAnchor.Type.RIGHT);
            ConstraintWidget constraintWidget = this.F;
            boolean z3 = true;
            if (constraintWidget == null || constraintWidget.E[0] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (this.f1955z0 == 0) {
                h2 = constraintWidgetContainer.h(ConstraintAnchor.Type.TOP);
                h3 = constraintWidgetContainer.h(ConstraintAnchor.Type.BOTTOM);
                ConstraintWidget constraintWidget2 = this.F;
                if (constraintWidget2 == null || constraintWidget2.E[1] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    z3 = false;
                }
                z2 = z3;
            }
            if (this.f1952w0 != -1) {
                SolverVariable r2 = linearSystem.r(this.f1954y0);
                linearSystem.e(r2, linearSystem.r(h2), this.f1952w0, 6);
                if (z2) {
                    linearSystem.i(linearSystem.r(h3), r2, 0, 5);
                }
            } else if (this.f1953x0 != -1) {
                SolverVariable r3 = linearSystem.r(this.f1954y0);
                SolverVariable r4 = linearSystem.r(h3);
                linearSystem.e(r3, r4, -this.f1953x0, 6);
                if (z2) {
                    linearSystem.i(r3, linearSystem.r(h2), 0, 5);
                    linearSystem.i(r4, r3, 0, 5);
                }
            } else if (this.f1951v0 != -1.0f) {
                linearSystem.d(LinearSystem.t(linearSystem, linearSystem.r(this.f1954y0), linearSystem.r(h2), linearSystem.r(h3), this.f1951v0, this.A0));
            }
        }
    }

    public boolean c() {
        return true;
    }

    public void d(int i2) {
        ConstraintWidget u2 = u();
        if (u2 != null) {
            if (I0() == 1) {
                this.f1924v.f().h(1, u2.f1924v.f(), 0);
                this.f1926x.f().h(1, u2.f1924v.f(), 0);
                if (this.f1952w0 != -1) {
                    this.f1923u.f().h(1, u2.f1923u.f(), this.f1952w0);
                    this.f1925w.f().h(1, u2.f1923u.f(), this.f1952w0);
                } else if (this.f1953x0 != -1) {
                    this.f1923u.f().h(1, u2.f1925w.f(), -this.f1953x0);
                    this.f1925w.f().h(1, u2.f1925w.f(), -this.f1953x0);
                } else if (this.f1951v0 != -1.0f && u2.s() == ConstraintWidget.DimensionBehaviour.FIXED) {
                    int i3 = (int) (((float) u2.G) * this.f1951v0);
                    this.f1923u.f().h(1, u2.f1923u.f(), i3);
                    this.f1925w.f().h(1, u2.f1923u.f(), i3);
                }
            } else {
                this.f1923u.f().h(1, u2.f1923u.f(), 0);
                this.f1925w.f().h(1, u2.f1923u.f(), 0);
                if (this.f1952w0 != -1) {
                    this.f1924v.f().h(1, u2.f1924v.f(), this.f1952w0);
                    this.f1926x.f().h(1, u2.f1924v.f(), this.f1952w0);
                } else if (this.f1953x0 != -1) {
                    this.f1924v.f().h(1, u2.f1926x.f(), -this.f1953x0);
                    this.f1926x.f().h(1, u2.f1926x.f(), -this.f1953x0);
                } else if (this.f1951v0 != -1.0f && u2.B() == ConstraintWidget.DimensionBehaviour.FIXED) {
                    int i4 = (int) (((float) u2.H) * this.f1951v0);
                    this.f1924v.f().h(1, u2.f1924v.f(), i4);
                    this.f1926x.f().h(1, u2.f1924v.f(), i4);
                }
            }
        }
    }

    public ConstraintAnchor h(ConstraintAnchor.Type type) {
        switch (AnonymousClass1.f1956a[type.ordinal()]) {
            case 1:
            case 2:
                if (this.f1955z0 == 1) {
                    return this.f1954y0;
                }
                break;
            case 3:
            case 4:
                if (this.f1955z0 == 0) {
                    return this.f1954y0;
                }
                break;
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return null;
        }
        throw new AssertionError(type.name());
    }

    public ArrayList<ConstraintAnchor> i() {
        return this.D;
    }
}
