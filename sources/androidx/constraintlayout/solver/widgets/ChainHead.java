package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.ArrayList;

public class ChainHead {

    /* renamed from: a  reason: collision with root package name */
    protected ConstraintWidget f1837a;

    /* renamed from: b  reason: collision with root package name */
    protected ConstraintWidget f1838b;

    /* renamed from: c  reason: collision with root package name */
    protected ConstraintWidget f1839c;

    /* renamed from: d  reason: collision with root package name */
    protected ConstraintWidget f1840d;

    /* renamed from: e  reason: collision with root package name */
    protected ConstraintWidget f1841e;

    /* renamed from: f  reason: collision with root package name */
    protected ConstraintWidget f1842f;

    /* renamed from: g  reason: collision with root package name */
    protected ConstraintWidget f1843g;

    /* renamed from: h  reason: collision with root package name */
    protected ArrayList<ConstraintWidget> f1844h;

    /* renamed from: i  reason: collision with root package name */
    protected int f1845i;

    /* renamed from: j  reason: collision with root package name */
    protected int f1846j;

    /* renamed from: k  reason: collision with root package name */
    protected float f1847k = 0.0f;

    /* renamed from: l  reason: collision with root package name */
    private int f1848l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f1849m;

    /* renamed from: n  reason: collision with root package name */
    protected boolean f1850n;

    /* renamed from: o  reason: collision with root package name */
    protected boolean f1851o;

    /* renamed from: p  reason: collision with root package name */
    protected boolean f1852p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f1853q;

    public ChainHead(ConstraintWidget constraintWidget, int i2, boolean z2) {
        this.f1837a = constraintWidget;
        this.f1848l = i2;
        this.f1849m = z2;
    }

    private void b() {
        int i2;
        int i3 = this.f1848l * 2;
        ConstraintWidget constraintWidget = this.f1837a;
        boolean z2 = false;
        ConstraintWidget constraintWidget2 = constraintWidget;
        boolean z3 = false;
        while (!z3) {
            this.f1845i++;
            ConstraintWidget[] constraintWidgetArr = constraintWidget.f1918r0;
            int i4 = this.f1848l;
            ConstraintWidget constraintWidget3 = null;
            constraintWidgetArr[i4] = null;
            constraintWidget.f1916q0[i4] = null;
            if (constraintWidget.C() != 8) {
                if (this.f1838b == null) {
                    this.f1838b = constraintWidget;
                }
                this.f1840d = constraintWidget;
                ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget.E;
                int i5 = this.f1848l;
                if (dimensionBehaviourArr[i5] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && ((i2 = constraintWidget.f1895g[i5]) == 0 || i2 == 3 || i2 == 2)) {
                    this.f1846j++;
                    float f2 = constraintWidget.f1914p0[i5];
                    if (f2 > 0.0f) {
                        this.f1847k += f2;
                    }
                    if (c(constraintWidget, i5)) {
                        if (f2 < 0.0f) {
                            this.f1850n = true;
                        } else {
                            this.f1851o = true;
                        }
                        if (this.f1844h == null) {
                            this.f1844h = new ArrayList<>();
                        }
                        this.f1844h.add(constraintWidget);
                    }
                    if (this.f1842f == null) {
                        this.f1842f = constraintWidget;
                    }
                    ConstraintWidget constraintWidget4 = this.f1843g;
                    if (constraintWidget4 != null) {
                        constraintWidget4.f1916q0[this.f1848l] = constraintWidget;
                    }
                    this.f1843g = constraintWidget;
                }
            }
            if (constraintWidget2 != constraintWidget) {
                constraintWidget2.f1918r0[this.f1848l] = constraintWidget;
            }
            ConstraintAnchor constraintAnchor = constraintWidget.C[i3 + 1].f1857d;
            if (constraintAnchor != null) {
                ConstraintWidget constraintWidget5 = constraintAnchor.f1855b;
                ConstraintAnchor constraintAnchor2 = constraintWidget5.C[i3].f1857d;
                if (constraintAnchor2 != null && constraintAnchor2.f1855b == constraintWidget) {
                    constraintWidget3 = constraintWidget5;
                }
            }
            if (constraintWidget3 == null) {
                constraintWidget3 = constraintWidget;
                z3 = true;
            }
            constraintWidget2 = constraintWidget;
            constraintWidget = constraintWidget3;
        }
        this.f1839c = constraintWidget;
        if (this.f1848l != 0 || !this.f1849m) {
            this.f1841e = this.f1837a;
        } else {
            this.f1841e = constraintWidget;
        }
        if (this.f1851o && this.f1850n) {
            z2 = true;
        }
        this.f1852p = z2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0010, code lost:
        r2 = r2.f1895g[r3];
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean c(androidx.constraintlayout.solver.widgets.ConstraintWidget r2, int r3) {
        /*
            int r0 = r2.C()
            r1 = 8
            if (r0 == r1) goto L_0x001b
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r2.E
            r0 = r0[r3]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r1 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r0 != r1) goto L_0x001b
            int[] r2 = r2.f1895g
            r2 = r2[r3]
            if (r2 == 0) goto L_0x0019
            r3 = 3
            if (r2 != r3) goto L_0x001b
        L_0x0019:
            r2 = 1
            goto L_0x001c
        L_0x001b:
            r2 = 0
        L_0x001c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.ChainHead.c(androidx.constraintlayout.solver.widgets.ConstraintWidget, int):boolean");
    }

    public void a() {
        if (!this.f1853q) {
            b();
        }
        this.f1853q = true;
    }
}
