package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Analyzer {
    private Analyzer() {
    }

    public static void a(ConstraintWidgetContainer constraintWidgetContainer) {
        boolean z2;
        boolean z3;
        boolean z4;
        if ((constraintWidgetContainer.R0() & 32) != 32) {
            j(constraintWidgetContainer);
            return;
        }
        constraintWidgetContainer.O0 = true;
        constraintWidgetContainer.I0 = false;
        constraintWidgetContainer.J0 = false;
        constraintWidgetContainer.K0 = false;
        ArrayList<ConstraintWidget> arrayList = constraintWidgetContainer.f1986v0;
        List<ConstraintWidgetGroup> list = constraintWidgetContainer.H0;
        ConstraintWidget.DimensionBehaviour s2 = constraintWidgetContainer.s();
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (s2 == dimensionBehaviour) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (constraintWidgetContainer.B() == dimensionBehaviour) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z2 || z3) {
            z4 = true;
        } else {
            z4 = false;
        }
        list.clear();
        for (ConstraintWidget next : arrayList) {
            next.f1917r = null;
            next.f1904k0 = false;
            next.S();
        }
        for (ConstraintWidget next2 : arrayList) {
            if (next2.f1917r == null && !b(next2, list, z4)) {
                j(constraintWidgetContainer);
                constraintWidgetContainer.O0 = false;
                return;
            }
        }
        int i2 = 0;
        int i3 = 0;
        for (ConstraintWidgetGroup next3 : list) {
            i2 = Math.max(i2, c(next3, 0));
            i3 = Math.max(i3, c(next3, 1));
        }
        if (z2) {
            constraintWidgetContainer.g0(ConstraintWidget.DimensionBehaviour.FIXED);
            constraintWidgetContainer.y0(i2);
            constraintWidgetContainer.I0 = true;
            constraintWidgetContainer.J0 = true;
            constraintWidgetContainer.L0 = i2;
        }
        if (z3) {
            constraintWidgetContainer.u0(ConstraintWidget.DimensionBehaviour.FIXED);
            constraintWidgetContainer.b0(i3);
            constraintWidgetContainer.I0 = true;
            constraintWidgetContainer.K0 = true;
            constraintWidgetContainer.M0 = i3;
        }
        i(list, 0, constraintWidgetContainer.D());
        i(list, 1, constraintWidgetContainer.r());
    }

    private static boolean b(ConstraintWidget constraintWidget, List<ConstraintWidgetGroup> list, boolean z2) {
        ConstraintWidgetGroup constraintWidgetGroup = new ConstraintWidgetGroup(new ArrayList(), true);
        list.add(constraintWidgetGroup);
        return k(constraintWidget, constraintWidgetGroup, list, z2);
    }

    private static int c(ConstraintWidgetGroup constraintWidgetGroup, int i2) {
        boolean z2;
        int i3 = i2 * 2;
        List<ConstraintWidget> b2 = constraintWidgetGroup.b(i2);
        int size = b2.size();
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            ConstraintWidget constraintWidget = b2.get(i5);
            ConstraintAnchor[] constraintAnchorArr = constraintWidget.C;
            ConstraintAnchor constraintAnchor = constraintAnchorArr[i3 + 1].f1857d;
            if (constraintAnchor == null || !(constraintAnchorArr[i3].f1857d == null || constraintAnchor == null)) {
                z2 = true;
            } else {
                z2 = false;
            }
            i4 = Math.max(i4, d(constraintWidget, i2, z2, 0));
        }
        constraintWidgetGroup.f1944e[i2] = i4;
        return i4;
    }

    private static int d(ConstraintWidget constraintWidget, int i2, boolean z2, int i3) {
        boolean z3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        ConstraintWidget constraintWidget2 = constraintWidget;
        int i16 = i2;
        boolean z4 = z2;
        int i17 = 0;
        if (!constraintWidget2.f1900i0) {
            return 0;
        }
        if (constraintWidget2.f1927y.f1857d == null || i16 != 1) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (z4) {
            i7 = constraintWidget.j();
            i6 = constraintWidget.r() - constraintWidget.j();
            i5 = i16 * 2;
            i4 = i5 + 1;
        } else {
            i7 = constraintWidget.r() - constraintWidget.j();
            i6 = constraintWidget.j();
            i4 = i16 * 2;
            i5 = i4 + 1;
        }
        ConstraintAnchor[] constraintAnchorArr = constraintWidget2.C;
        if (constraintAnchorArr[i4].f1857d == null || constraintAnchorArr[i5].f1857d != null) {
            i8 = 1;
        } else {
            i8 = -1;
            int i18 = i4;
            i4 = i5;
            i5 = i18;
        }
        if (z3) {
            i9 = i3 - i7;
        } else {
            i9 = i3;
        }
        int d2 = (constraintAnchorArr[i5].d() * i8) + e(constraintWidget, i2);
        int i19 = i9 + d2;
        if (i16 == 0) {
            i10 = constraintWidget.D();
        } else {
            i10 = constraintWidget.r();
        }
        int i20 = i10 * i8;
        Iterator<ResolutionNode> it2 = constraintWidget2.C[i5].f().f1974a.iterator();
        while (it2.hasNext()) {
            i17 = Math.max(i17, d(((ResolutionAnchor) it2.next()).f1960c.f1855b, i16, z4, i19));
        }
        int i21 = 0;
        for (Iterator<ResolutionNode> it3 = constraintWidget2.C[i4].f().f1974a.iterator(); it3.hasNext(); it3 = it3) {
            i21 = Math.max(i21, d(((ResolutionAnchor) it3.next()).f1960c.f1855b, i16, z4, i20 + i19));
        }
        if (z3) {
            i17 -= i7;
            i12 = i21 + i6;
        } else {
            if (i16 == 0) {
                i11 = constraintWidget.D();
            } else {
                i11 = constraintWidget.r();
            }
            i12 = i21 + (i11 * i8);
        }
        int i22 = 1;
        if (i16 == 1) {
            Iterator<ResolutionNode> it4 = constraintWidget2.f1927y.f().f1974a.iterator();
            int i23 = 0;
            while (it4.hasNext()) {
                Iterator<ResolutionNode> it5 = it4;
                ResolutionAnchor resolutionAnchor = (ResolutionAnchor) it4.next();
                if (i8 == i22) {
                    i23 = Math.max(i23, d(resolutionAnchor.f1960c.f1855b, i16, z4, i7 + i19));
                    i15 = i4;
                } else {
                    i15 = i4;
                    i23 = Math.max(i23, d(resolutionAnchor.f1960c.f1855b, i16, z4, (i6 * i8) + i19));
                }
                it4 = it5;
                i4 = i15;
                i22 = 1;
            }
            i13 = i4;
            int i24 = i23;
            if (constraintWidget2.f1927y.f().f1974a.size() <= 0 || z3) {
                i14 = i24;
            } else if (i8 == 1) {
                i14 = i24 + i7;
            } else {
                i14 = i24 - i6;
            }
        } else {
            i13 = i4;
            i14 = 0;
        }
        int max = d2 + Math.max(i17, Math.max(i12, i14));
        int i25 = i20 + i19;
        if (i8 == -1) {
            int i26 = i25;
            i25 = i19;
            i19 = i26;
        }
        if (z4) {
            Optimizer.e(constraintWidget2, i16, i19);
            constraintWidget2.Z(i19, i25, i16);
        } else {
            constraintWidget2.f1917r.a(constraintWidget2, i16);
            constraintWidget2.q0(i19, i16);
        }
        if (constraintWidget.o(i2) == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget2.I != 0.0f) {
            constraintWidget2.f1917r.a(constraintWidget2, i16);
        }
        ConstraintAnchor[] constraintAnchorArr2 = constraintWidget2.C;
        if (!(constraintAnchorArr2[i5].f1857d == null || constraintAnchorArr2[i13].f1857d == null)) {
            ConstraintWidget u2 = constraintWidget.u();
            ConstraintAnchor[] constraintAnchorArr3 = constraintWidget2.C;
            if (constraintAnchorArr3[i5].f1857d.f1855b == u2 && constraintAnchorArr3[i13].f1857d.f1855b == u2) {
                constraintWidget2.f1917r.a(constraintWidget2, i16);
            }
        }
        return max;
    }

    private static int e(ConstraintWidget constraintWidget, int i2) {
        ConstraintWidget constraintWidget2;
        ConstraintAnchor constraintAnchor;
        float f2;
        int i3 = i2 * 2;
        ConstraintAnchor[] constraintAnchorArr = constraintWidget.C;
        ConstraintAnchor constraintAnchor2 = constraintAnchorArr[i3];
        ConstraintAnchor constraintAnchor3 = constraintAnchorArr[i3 + 1];
        ConstraintAnchor constraintAnchor4 = constraintAnchor2.f1857d;
        if (constraintAnchor4 == null || constraintAnchor4.f1855b != (constraintWidget2 = constraintWidget.F) || (constraintAnchor = constraintAnchor3.f1857d) == null || constraintAnchor.f1855b != constraintWidget2) {
            return 0;
        }
        int t2 = constraintWidget2.t(i2);
        if (i2 == 0) {
            f2 = constraintWidget.Z;
        } else {
            f2 = constraintWidget.f1884a0;
        }
        return (int) (((float) (((t2 - constraintAnchor2.d()) - constraintAnchor3.d()) - constraintWidget.t(i2))) * f2);
    }

    private static void f(ConstraintWidgetContainer constraintWidgetContainer, ConstraintWidget constraintWidget, ConstraintWidgetGroup constraintWidgetGroup) {
        constraintWidgetGroup.f1943d = false;
        constraintWidgetContainer.O0 = false;
        constraintWidget.f1900i0 = false;
    }

    private static int g(ConstraintWidget constraintWidget) {
        float f2;
        float f3;
        ConstraintWidget.DimensionBehaviour s2 = constraintWidget.s();
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (s2 == dimensionBehaviour) {
            if (constraintWidget.J == 0) {
                f3 = ((float) constraintWidget.r()) * constraintWidget.I;
            } else {
                f3 = ((float) constraintWidget.r()) / constraintWidget.I;
            }
            int i2 = (int) f3;
            constraintWidget.y0(i2);
            return i2;
        } else if (constraintWidget.B() != dimensionBehaviour) {
            return -1;
        } else {
            if (constraintWidget.J == 1) {
                f2 = ((float) constraintWidget.D()) * constraintWidget.I;
            } else {
                f2 = ((float) constraintWidget.D()) / constraintWidget.I;
            }
            int i3 = (int) f2;
            constraintWidget.b0(i3);
            return i3;
        }
    }

    private static void h(ConstraintAnchor constraintAnchor) {
        ResolutionAnchor f2 = constraintAnchor.f();
        ConstraintAnchor constraintAnchor2 = constraintAnchor.f1857d;
        if (constraintAnchor2 != null && constraintAnchor2.f1857d != constraintAnchor) {
            constraintAnchor2.f().a(f2);
        }
    }

    public static void i(List<ConstraintWidgetGroup> list, int i2, int i3) {
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            for (ConstraintWidget next : list.get(i4).c(i2)) {
                if (next.f1900i0) {
                    l(next, i2, i3);
                }
            }
        }
    }

    private static void j(ConstraintWidgetContainer constraintWidgetContainer) {
        constraintWidgetContainer.H0.clear();
        constraintWidgetContainer.H0.add(0, new ConstraintWidgetGroup(constraintWidgetContainer.f1986v0));
    }

    private static boolean k(ConstraintWidget constraintWidget, ConstraintWidgetGroup constraintWidgetGroup, List<ConstraintWidgetGroup> list, boolean z2) {
        boolean z3;
        boolean z4;
        ConstraintAnchor constraintAnchor;
        ConstraintWidget constraintWidget2;
        ConstraintAnchor constraintAnchor2;
        ConstraintWidget constraintWidget3;
        if (constraintWidget == null) {
            return true;
        }
        constraintWidget.f1902j0 = false;
        ConstraintWidgetContainer constraintWidgetContainer = (ConstraintWidgetContainer) constraintWidget.u();
        ConstraintWidgetGroup constraintWidgetGroup2 = constraintWidget.f1917r;
        if (constraintWidgetGroup2 == null) {
            constraintWidget.f1900i0 = true;
            constraintWidgetGroup.f1940a.add(constraintWidget);
            constraintWidget.f1917r = constraintWidgetGroup;
            if (constraintWidget.f1923u.f1857d == null && constraintWidget.f1925w.f1857d == null && constraintWidget.f1924v.f1857d == null && constraintWidget.f1926x.f1857d == null && constraintWidget.f1927y.f1857d == null && constraintWidget.B.f1857d == null) {
                f(constraintWidgetContainer, constraintWidget, constraintWidgetGroup);
                if (z2) {
                    return false;
                }
            }
            if (!(constraintWidget.f1924v.f1857d == null || constraintWidget.f1926x.f1857d == null)) {
                constraintWidgetContainer.B();
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.FIXED;
                if (z2) {
                    f(constraintWidgetContainer, constraintWidget, constraintWidgetGroup);
                    return false;
                } else if (!(constraintWidget.f1924v.f1857d.f1855b == constraintWidget.u() && constraintWidget.f1926x.f1857d.f1855b == constraintWidget.u())) {
                    f(constraintWidgetContainer, constraintWidget, constraintWidgetGroup);
                }
            }
            if (!(constraintWidget.f1923u.f1857d == null || constraintWidget.f1925w.f1857d == null)) {
                constraintWidgetContainer.s();
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.FIXED;
                if (z2) {
                    f(constraintWidgetContainer, constraintWidget, constraintWidgetGroup);
                    return false;
                } else if (!(constraintWidget.f1923u.f1857d.f1855b == constraintWidget.u() && constraintWidget.f1925w.f1857d.f1855b == constraintWidget.u())) {
                    f(constraintWidgetContainer, constraintWidget, constraintWidgetGroup);
                }
            }
            ConstraintWidget.DimensionBehaviour s2 = constraintWidget.s();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
            if (s2 == dimensionBehaviour3) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (constraintWidget.B() == dimensionBehaviour3) {
                z4 = true;
            } else {
                z4 = false;
            }
            if ((z3 ^ z4) && constraintWidget.I != 0.0f) {
                g(constraintWidget);
            } else if (constraintWidget.s() == dimensionBehaviour3 || constraintWidget.B() == dimensionBehaviour3) {
                f(constraintWidgetContainer, constraintWidget, constraintWidgetGroup);
                if (z2) {
                    return false;
                }
            }
            ConstraintAnchor constraintAnchor3 = constraintWidget.f1923u.f1857d;
            if (((constraintAnchor3 == null && constraintWidget.f1925w.f1857d == null) || ((constraintAnchor3 != null && constraintAnchor3.f1855b == constraintWidget.F && constraintWidget.f1925w.f1857d == null) || (((constraintAnchor2 = constraintWidget.f1925w.f1857d) != null && constraintAnchor2.f1855b == constraintWidget.F && constraintAnchor3 == null) || (constraintAnchor3 != null && constraintAnchor3.f1855b == (constraintWidget3 = constraintWidget.F) && constraintAnchor2 != null && constraintAnchor2.f1855b == constraintWidget3)))) && constraintWidget.B.f1857d == null && !(constraintWidget instanceof Guideline) && !(constraintWidget instanceof Helper)) {
                constraintWidgetGroup.f1945f.add(constraintWidget);
            }
            ConstraintAnchor constraintAnchor4 = constraintWidget.f1924v.f1857d;
            if (((constraintAnchor4 == null && constraintWidget.f1926x.f1857d == null) || ((constraintAnchor4 != null && constraintAnchor4.f1855b == constraintWidget.F && constraintWidget.f1926x.f1857d == null) || (((constraintAnchor = constraintWidget.f1926x.f1857d) != null && constraintAnchor.f1855b == constraintWidget.F && constraintAnchor4 == null) || (constraintAnchor4 != null && constraintAnchor4.f1855b == (constraintWidget2 = constraintWidget.F) && constraintAnchor != null && constraintAnchor.f1855b == constraintWidget2)))) && constraintWidget.B.f1857d == null && constraintWidget.f1927y.f1857d == null && !(constraintWidget instanceof Guideline) && !(constraintWidget instanceof Helper)) {
                constraintWidgetGroup.f1946g.add(constraintWidget);
            }
            if (constraintWidget instanceof Helper) {
                f(constraintWidgetContainer, constraintWidget, constraintWidgetGroup);
                if (z2) {
                    return false;
                }
                Helper helper = (Helper) constraintWidget;
                for (int i2 = 0; i2 < helper.f1958w0; i2++) {
                    if (!k(helper.f1957v0[i2], constraintWidgetGroup, list, z2)) {
                        return false;
                    }
                }
            }
            for (ConstraintAnchor constraintAnchor5 : constraintWidget.C) {
                ConstraintAnchor constraintAnchor6 = constraintAnchor5.f1857d;
                if (!(constraintAnchor6 == null || constraintAnchor6.f1855b == constraintWidget.u())) {
                    if (constraintAnchor5.f1856c == ConstraintAnchor.Type.CENTER) {
                        f(constraintWidgetContainer, constraintWidget, constraintWidgetGroup);
                        if (z2) {
                            return false;
                        }
                    } else {
                        h(constraintAnchor5);
                    }
                    if (!k(constraintAnchor5.f1857d.f1855b, constraintWidgetGroup, list, z2)) {
                        return false;
                    }
                }
            }
            return true;
        }
        if (constraintWidgetGroup2 != constraintWidgetGroup) {
            constraintWidgetGroup.f1940a.addAll(constraintWidgetGroup2.f1940a);
            constraintWidgetGroup.f1945f.addAll(constraintWidget.f1917r.f1945f);
            constraintWidgetGroup.f1946g.addAll(constraintWidget.f1917r.f1946g);
            ConstraintWidgetGroup constraintWidgetGroup3 = constraintWidget.f1917r;
            if (!constraintWidgetGroup3.f1943d) {
                constraintWidgetGroup.f1943d = false;
            }
            list.remove(constraintWidgetGroup3);
            for (ConstraintWidget constraintWidget4 : constraintWidget.f1917r.f1940a) {
                constraintWidget4.f1917r = constraintWidgetGroup;
            }
        }
        return true;
    }

    private static void l(ConstraintWidget constraintWidget, int i2, int i3) {
        boolean z2;
        int i4 = i2 * 2;
        ConstraintAnchor[] constraintAnchorArr = constraintWidget.C;
        ConstraintAnchor constraintAnchor = constraintAnchorArr[i4];
        ConstraintAnchor constraintAnchor2 = constraintAnchorArr[i4 + 1];
        if (constraintAnchor.f1857d == null || constraintAnchor2.f1857d == null) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2) {
            Optimizer.e(constraintWidget, i2, e(constraintWidget, i2) + constraintAnchor.d());
        } else if (constraintWidget.I == 0.0f || constraintWidget.o(i2) != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            int v2 = i3 - constraintWidget.v(i2);
            int t2 = v2 - constraintWidget.t(i2);
            constraintWidget.Z(t2, v2, i2);
            Optimizer.e(constraintWidget, i2, t2);
        } else {
            int g2 = g(constraintWidget);
            int i5 = (int) constraintWidget.C[i4].f().f1965h;
            int i6 = i5 + g2;
            constraintAnchor2.f().f1964g = constraintAnchor.f();
            constraintAnchor2.f().f1965h = (float) g2;
            constraintAnchor2.f().f1975b = 1;
            constraintWidget.Z(i5, i6, i2);
        }
    }
}
