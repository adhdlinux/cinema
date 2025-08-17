package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;

public class Optimizer {

    /* renamed from: a  reason: collision with root package name */
    static boolean[] f1959a = new boolean[3];

    static void a(int i2, ConstraintWidget constraintWidget) {
        boolean z2;
        boolean z3;
        boolean z4;
        ConstraintWidget constraintWidget2 = constraintWidget;
        constraintWidget.H0();
        ResolutionAnchor f2 = constraintWidget2.f1923u.f();
        ResolutionAnchor f3 = constraintWidget2.f1924v.f();
        ResolutionAnchor f4 = constraintWidget2.f1925w.f();
        ResolutionAnchor f5 = constraintWidget2.f1926x.f();
        if ((i2 & 8) == 8) {
            z2 = true;
        } else {
            z2 = false;
        }
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = constraintWidget2.E[0];
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (dimensionBehaviour != dimensionBehaviour2 || !d(constraintWidget2, 0)) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (!(f2.f1966i == 4 || f4.f1966i == 4)) {
            if (constraintWidget2.E[0] == ConstraintWidget.DimensionBehaviour.FIXED || (z3 && constraintWidget.C() == 8)) {
                ConstraintAnchor constraintAnchor = constraintWidget2.f1923u.f1857d;
                if (constraintAnchor == null && constraintWidget2.f1925w.f1857d == null) {
                    f2.p(1);
                    f4.p(1);
                    if (z2) {
                        f4.j(f2, 1, constraintWidget.x());
                    } else {
                        f4.i(f2, constraintWidget.D());
                    }
                } else if (constraintAnchor != null && constraintWidget2.f1925w.f1857d == null) {
                    f2.p(1);
                    f4.p(1);
                    if (z2) {
                        f4.j(f2, 1, constraintWidget.x());
                    } else {
                        f4.i(f2, constraintWidget.D());
                    }
                } else if (constraintAnchor == null && constraintWidget2.f1925w.f1857d != null) {
                    f2.p(1);
                    f4.p(1);
                    f2.i(f4, -constraintWidget.D());
                    if (z2) {
                        f2.j(f4, -1, constraintWidget.x());
                    } else {
                        f2.i(f4, -constraintWidget.D());
                    }
                } else if (!(constraintAnchor == null || constraintWidget2.f1925w.f1857d == null)) {
                    f2.p(2);
                    f4.p(2);
                    if (z2) {
                        constraintWidget.x().a(f2);
                        constraintWidget.x().a(f4);
                        f2.o(f4, -1, constraintWidget.x());
                        f4.o(f2, 1, constraintWidget.x());
                    } else {
                        f2.n(f4, (float) (-constraintWidget.D()));
                        f4.n(f2, (float) constraintWidget.D());
                    }
                }
            } else if (z3) {
                int D = constraintWidget.D();
                f2.p(1);
                f4.p(1);
                ConstraintAnchor constraintAnchor2 = constraintWidget2.f1923u.f1857d;
                if (constraintAnchor2 == null && constraintWidget2.f1925w.f1857d == null) {
                    if (z2) {
                        f4.j(f2, 1, constraintWidget.x());
                    } else {
                        f4.i(f2, D);
                    }
                } else if (constraintAnchor2 == null || constraintWidget2.f1925w.f1857d != null) {
                    if (constraintAnchor2 != null || constraintWidget2.f1925w.f1857d == null) {
                        if (!(constraintAnchor2 == null || constraintWidget2.f1925w.f1857d == null)) {
                            if (z2) {
                                constraintWidget.x().a(f2);
                                constraintWidget.x().a(f4);
                            }
                            if (constraintWidget2.I == 0.0f) {
                                f2.p(3);
                                f4.p(3);
                                f2.n(f4, 0.0f);
                                f4.n(f2, 0.0f);
                            } else {
                                f2.p(2);
                                f4.p(2);
                                f2.n(f4, (float) (-D));
                                f4.n(f2, (float) D);
                                constraintWidget2.y0(D);
                            }
                        }
                    } else if (z2) {
                        f2.j(f4, -1, constraintWidget.x());
                    } else {
                        f2.i(f4, -D);
                    }
                } else if (z2) {
                    f4.j(f2, 1, constraintWidget.x());
                } else {
                    f4.i(f2, D);
                }
            }
        }
        if (constraintWidget2.E[1] != dimensionBehaviour2 || !d(constraintWidget2, 1)) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (f3.f1966i != 4 && f5.f1966i != 4) {
            if (constraintWidget2.E[1] == ConstraintWidget.DimensionBehaviour.FIXED || (z4 && constraintWidget.C() == 8)) {
                ConstraintAnchor constraintAnchor3 = constraintWidget2.f1924v.f1857d;
                if (constraintAnchor3 == null && constraintWidget2.f1926x.f1857d == null) {
                    f3.p(1);
                    f5.p(1);
                    if (z2) {
                        f5.j(f3, 1, constraintWidget.w());
                    } else {
                        f5.i(f3, constraintWidget.r());
                    }
                    ConstraintAnchor constraintAnchor4 = constraintWidget2.f1927y;
                    if (constraintAnchor4.f1857d != null) {
                        constraintAnchor4.f().p(1);
                        f3.h(1, constraintWidget2.f1927y.f(), -constraintWidget2.U);
                    }
                } else if (constraintAnchor3 != null && constraintWidget2.f1926x.f1857d == null) {
                    f3.p(1);
                    f5.p(1);
                    if (z2) {
                        f5.j(f3, 1, constraintWidget.w());
                    } else {
                        f5.i(f3, constraintWidget.r());
                    }
                    if (constraintWidget2.U > 0) {
                        constraintWidget2.f1927y.f().h(1, f3, constraintWidget2.U);
                    }
                } else if (constraintAnchor3 == null && constraintWidget2.f1926x.f1857d != null) {
                    f3.p(1);
                    f5.p(1);
                    if (z2) {
                        f3.j(f5, -1, constraintWidget.w());
                    } else {
                        f3.i(f5, -constraintWidget.r());
                    }
                    if (constraintWidget2.U > 0) {
                        constraintWidget2.f1927y.f().h(1, f3, constraintWidget2.U);
                    }
                } else if (constraintAnchor3 != null && constraintWidget2.f1926x.f1857d != null) {
                    f3.p(2);
                    f5.p(2);
                    if (z2) {
                        f3.o(f5, -1, constraintWidget.w());
                        f5.o(f3, 1, constraintWidget.w());
                        constraintWidget.w().a(f3);
                        constraintWidget.x().a(f5);
                    } else {
                        f3.n(f5, (float) (-constraintWidget.r()));
                        f5.n(f3, (float) constraintWidget.r());
                    }
                    if (constraintWidget2.U > 0) {
                        constraintWidget2.f1927y.f().h(1, f3, constraintWidget2.U);
                    }
                }
            } else if (z4) {
                int r2 = constraintWidget.r();
                f3.p(1);
                f5.p(1);
                ConstraintAnchor constraintAnchor5 = constraintWidget2.f1924v.f1857d;
                if (constraintAnchor5 == null && constraintWidget2.f1926x.f1857d == null) {
                    if (z2) {
                        f5.j(f3, 1, constraintWidget.w());
                    } else {
                        f5.i(f3, r2);
                    }
                } else if (constraintAnchor5 == null || constraintWidget2.f1926x.f1857d != null) {
                    if (constraintAnchor5 != null || constraintWidget2.f1926x.f1857d == null) {
                        if (constraintAnchor5 != null && constraintWidget2.f1926x.f1857d != null) {
                            if (z2) {
                                constraintWidget.w().a(f3);
                                constraintWidget.x().a(f5);
                            }
                            if (constraintWidget2.I == 0.0f) {
                                f3.p(3);
                                f5.p(3);
                                f3.n(f5, 0.0f);
                                f5.n(f3, 0.0f);
                                return;
                            }
                            f3.p(2);
                            f5.p(2);
                            f3.n(f5, (float) (-r2));
                            f5.n(f3, (float) r2);
                            constraintWidget2.b0(r2);
                            if (constraintWidget2.U > 0) {
                                constraintWidget2.f1927y.f().h(1, f3, constraintWidget2.U);
                            }
                        }
                    } else if (z2) {
                        f3.j(f5, -1, constraintWidget.w());
                    } else {
                        f3.i(f5, -r2);
                    }
                } else if (z2) {
                    f5.j(f3, 1, constraintWidget.w());
                } else {
                    f5.i(f3, r2);
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002e, code lost:
        r7 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003c, code lost:
        if (r7 == 2) goto L_0x002c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002a, code lost:
        if (r7 == 2) goto L_0x002c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x01c1  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00f4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static boolean b(androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r23, androidx.constraintlayout.solver.LinearSystem r24, int r25, int r26, androidx.constraintlayout.solver.widgets.ChainHead r27) {
        /*
            r0 = r24
            r1 = r25
            r2 = r27
            androidx.constraintlayout.solver.widgets.ConstraintWidget r3 = r2.f1837a
            androidx.constraintlayout.solver.widgets.ConstraintWidget r4 = r2.f1839c
            androidx.constraintlayout.solver.widgets.ConstraintWidget r5 = r2.f1838b
            androidx.constraintlayout.solver.widgets.ConstraintWidget r6 = r2.f1840d
            androidx.constraintlayout.solver.widgets.ConstraintWidget r7 = r2.f1841e
            float r2 = r2.f1847k
            r8 = r23
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r8 = r8.E
            r8 = r8[r1]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r8 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r8 = 2
            r9 = 1
            if (r1 != 0) goto L_0x0030
            int r7 = r7.f1906l0
            if (r7 != 0) goto L_0x0024
            r11 = 1
            goto L_0x0025
        L_0x0024:
            r11 = 0
        L_0x0025:
            if (r7 != r9) goto L_0x0029
            r12 = 1
            goto L_0x002a
        L_0x0029:
            r12 = 0
        L_0x002a:
            if (r7 != r8) goto L_0x002e
        L_0x002c:
            r7 = 1
            goto L_0x003f
        L_0x002e:
            r7 = 0
            goto L_0x003f
        L_0x0030:
            int r7 = r7.f1908m0
            if (r7 != 0) goto L_0x0036
            r11 = 1
            goto L_0x0037
        L_0x0036:
            r11 = 0
        L_0x0037:
            if (r7 != r9) goto L_0x003b
            r12 = 1
            goto L_0x003c
        L_0x003b:
            r12 = 0
        L_0x003c:
            if (r7 != r8) goto L_0x002e
            goto L_0x002c
        L_0x003f:
            r14 = r3
            r9 = 0
            r13 = 0
            r15 = 0
            r16 = 0
            r17 = 0
        L_0x0047:
            r8 = 8
            if (r13 != 0) goto L_0x00f7
            int r10 = r14.C()
            if (r10 == r8) goto L_0x0095
            int r15 = r15 + 1
            if (r1 != 0) goto L_0x005a
            int r10 = r14.D()
            goto L_0x005e
        L_0x005a:
            int r10 = r14.r()
        L_0x005e:
            float r10 = (float) r10
            float r16 = r16 + r10
            if (r14 == r5) goto L_0x006e
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r10 = r14.C
            r10 = r10[r26]
            int r10 = r10.d()
            float r10 = (float) r10
            float r16 = r16 + r10
        L_0x006e:
            if (r14 == r6) goto L_0x007d
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r10 = r14.C
            int r19 = r26 + 1
            r10 = r10[r19]
            int r10 = r10.d()
            float r10 = (float) r10
            float r16 = r16 + r10
        L_0x007d:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r10 = r14.C
            r10 = r10[r26]
            int r10 = r10.d()
            float r10 = (float) r10
            float r17 = r17 + r10
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r10 = r14.C
            int r19 = r26 + 1
            r10 = r10[r19]
            int r10 = r10.d()
            float r10 = (float) r10
            float r17 = r17 + r10
        L_0x0095:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r10 = r14.C
            r10 = r10[r26]
            int r10 = r14.C()
            if (r10 == r8) goto L_0x00d3
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r8 = r14.E
            r8 = r8[r1]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r10 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r8 != r10) goto L_0x00d3
            int r9 = r9 + 1
            if (r1 != 0) goto L_0x00bb
            int r8 = r14.f1891e
            if (r8 == 0) goto L_0x00b1
            r8 = 0
            return r8
        L_0x00b1:
            r8 = 0
            int r10 = r14.f1897h
            if (r10 != 0) goto L_0x00ba
            int r10 = r14.f1899i
            if (r10 == 0) goto L_0x00ca
        L_0x00ba:
            return r8
        L_0x00bb:
            r8 = 0
            int r10 = r14.f1893f
            if (r10 == 0) goto L_0x00c1
            return r8
        L_0x00c1:
            int r10 = r14.f1903k
            if (r10 != 0) goto L_0x00d2
            int r10 = r14.f1905l
            if (r10 == 0) goto L_0x00ca
            goto L_0x00d2
        L_0x00ca:
            float r10 = r14.I
            r18 = 0
            int r10 = (r10 > r18 ? 1 : (r10 == r18 ? 0 : -1))
            if (r10 == 0) goto L_0x00d3
        L_0x00d2:
            return r8
        L_0x00d3:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r8 = r14.C
            int r10 = r26 + 1
            r8 = r8[r10]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r8 = r8.f1857d
            if (r8 == 0) goto L_0x00ee
            androidx.constraintlayout.solver.widgets.ConstraintWidget r8 = r8.f1855b
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r10 = r8.C
            r10 = r10[r26]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r10 = r10.f1857d
            if (r10 == 0) goto L_0x00ee
            androidx.constraintlayout.solver.widgets.ConstraintWidget r10 = r10.f1855b
            if (r10 == r14) goto L_0x00ec
            goto L_0x00ee
        L_0x00ec:
            r10 = r8
            goto L_0x00ef
        L_0x00ee:
            r10 = 0
        L_0x00ef:
            if (r10 == 0) goto L_0x00f4
            r14 = r10
            goto L_0x0047
        L_0x00f4:
            r13 = 1
            goto L_0x0047
        L_0x00f7:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r10 = r3.C
            r10 = r10[r26]
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r10 = r10.f()
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r13 = r4.C
            int r19 = r26 + 1
            r13 = r13[r19]
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r13 = r13.f()
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r8 = r10.f1962e
            if (r8 == 0) goto L_0x0370
            r20 = r3
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r3 = r13.f1962e
            if (r3 != 0) goto L_0x0115
            goto L_0x0370
        L_0x0115:
            int r8 = r8.f1975b
            r0 = 1
            if (r8 != r0) goto L_0x036e
            int r3 = r3.f1975b
            if (r3 == r0) goto L_0x0120
            goto L_0x036e
        L_0x0120:
            if (r9 <= 0) goto L_0x0126
            if (r9 == r15) goto L_0x0126
            r0 = 0
            return r0
        L_0x0126:
            if (r7 != 0) goto L_0x012f
            if (r11 != 0) goto L_0x012f
            if (r12 == 0) goto L_0x012d
            goto L_0x012f
        L_0x012d:
            r0 = 0
            goto L_0x0148
        L_0x012f:
            if (r5 == 0) goto L_0x013b
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r5.C
            r0 = r0[r26]
            int r0 = r0.d()
            float r0 = (float) r0
            goto L_0x013c
        L_0x013b:
            r0 = 0
        L_0x013c:
            if (r6 == 0) goto L_0x0148
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r6.C
            r3 = r3[r19]
            int r3 = r3.d()
            float r3 = (float) r3
            float r0 = r0 + r3
        L_0x0148:
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r3 = r10.f1962e
            float r3 = r3.f1965h
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r6 = r13.f1962e
            float r6 = r6.f1965h
            int r8 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r8 >= 0) goto L_0x0156
            float r6 = r6 - r3
            goto L_0x0158
        L_0x0156:
            float r6 = r3 - r6
        L_0x0158:
            float r6 = r6 - r16
            r21 = 1
            if (r9 <= 0) goto L_0x0210
            if (r9 != r15) goto L_0x0210
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r14.u()
            if (r0 == 0) goto L_0x0174
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r14.u()
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r0.E
            r0 = r0[r1]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r5 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r0 != r5) goto L_0x0174
            r0 = 0
            return r0
        L_0x0174:
            float r6 = r6 + r16
            float r6 = r6 - r17
            r0 = r3
            r3 = r20
        L_0x017b:
            if (r3 == 0) goto L_0x020e
            androidx.constraintlayout.solver.Metrics r5 = androidx.constraintlayout.solver.LinearSystem.f1772r
            if (r5 == 0) goto L_0x0193
            long r7 = r5.B
            long r7 = r7 - r21
            r5.B = r7
            long r7 = r5.f1807s
            long r7 = r7 + r21
            r5.f1807s = r7
            long r7 = r5.f1813y
            long r7 = r7 + r21
            r5.f1813y = r7
        L_0x0193:
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r5 = r3.f1918r0
            r5 = r5[r1]
            if (r5 != 0) goto L_0x019f
            if (r3 != r4) goto L_0x019c
            goto L_0x019f
        L_0x019c:
            r8 = r24
            goto L_0x020b
        L_0x019f:
            float r7 = (float) r9
            float r7 = r6 / r7
            r8 = 0
            int r11 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r11 <= 0) goto L_0x01b7
            float[] r7 = r3.f1914p0
            r7 = r7[r1]
            r8 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r8 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
            if (r8 != 0) goto L_0x01b4
            r18 = 0
            goto L_0x01b9
        L_0x01b4:
            float r7 = r7 * r6
            float r7 = r7 / r2
        L_0x01b7:
            r18 = r7
        L_0x01b9:
            int r7 = r3.C()
            r8 = 8
            if (r7 != r8) goto L_0x01c3
            r18 = 0
        L_0x01c3:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r7 = r3.C
            r7 = r7[r26]
            int r7 = r7.d()
            float r7 = (float) r7
            float r0 = r0 + r7
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r7 = r3.C
            r7 = r7[r26]
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r7 = r7.f()
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r8 = r10.f1964g
            r7.l(r8, r0)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r7 = r3.C
            r7 = r7[r19]
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r7 = r7.f()
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r8 = r10.f1964g
            float r0 = r0 + r18
            r7.l(r8, r0)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r7 = r3.C
            r7 = r7[r26]
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r7 = r7.f()
            r8 = r24
            r7.g(r8)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r7 = r3.C
            r7 = r7[r19]
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r7 = r7.f()
            r7.g(r8)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r3.C
            r3 = r3[r19]
            int r3 = r3.d()
            float r3 = (float) r3
            float r0 = r0 + r3
        L_0x020b:
            r3 = r5
            goto L_0x017b
        L_0x020e:
            r0 = 1
            return r0
        L_0x0210:
            r8 = r24
            r2 = 0
            int r2 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r2 >= 0) goto L_0x021a
            r7 = 1
            r11 = 0
            r12 = 0
        L_0x021a:
            if (r7 == 0) goto L_0x029a
            float r6 = r6 - r0
            r2 = r20
            float r0 = r2.k(r1)
            float r6 = r6 * r0
            float r3 = r3 + r6
            r0 = r3
        L_0x0227:
            r3 = r2
            if (r3 == 0) goto L_0x02a1
            androidx.constraintlayout.solver.Metrics r2 = androidx.constraintlayout.solver.LinearSystem.f1772r
            if (r2 == 0) goto L_0x0240
            long r5 = r2.B
            long r5 = r5 - r21
            r2.B = r5
            long r5 = r2.f1807s
            long r5 = r5 + r21
            r2.f1807s = r5
            long r5 = r2.f1813y
            long r5 = r5 + r21
            r2.f1813y = r5
        L_0x0240:
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r2 = r3.f1918r0
            r2 = r2[r1]
            if (r2 != 0) goto L_0x0248
            if (r3 != r4) goto L_0x0227
        L_0x0248:
            if (r1 != 0) goto L_0x024f
            int r5 = r3.D()
            goto L_0x0253
        L_0x024f:
            int r5 = r3.r()
        L_0x0253:
            float r5 = (float) r5
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r6 = r3.C
            r6 = r6[r26]
            int r6 = r6.d()
            float r6 = (float) r6
            float r0 = r0 + r6
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r6 = r3.C
            r6 = r6[r26]
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r6 = r6.f()
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r7 = r10.f1964g
            r6.l(r7, r0)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r6 = r3.C
            r6 = r6[r19]
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r6 = r6.f()
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r7 = r10.f1964g
            float r0 = r0 + r5
            r6.l(r7, r0)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r5 = r3.C
            r5 = r5[r26]
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r5 = r5.f()
            r5.g(r8)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r5 = r3.C
            r5 = r5[r19]
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r5 = r5.f()
            r5.g(r8)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r3.C
            r3 = r3[r19]
            int r3 = r3.d()
            float r3 = (float) r3
            float r0 = r0 + r3
            goto L_0x0227
        L_0x029a:
            r2 = r20
            if (r11 != 0) goto L_0x02a4
            if (r12 == 0) goto L_0x02a1
            goto L_0x02a4
        L_0x02a1:
            r0 = 1
            goto L_0x036d
        L_0x02a4:
            if (r11 == 0) goto L_0x02a8
        L_0x02a6:
            float r6 = r6 - r0
            goto L_0x02ab
        L_0x02a8:
            if (r12 == 0) goto L_0x02ab
            goto L_0x02a6
        L_0x02ab:
            int r0 = r15 + 1
            float r0 = (float) r0
            float r0 = r6 / r0
            if (r12 == 0) goto L_0x02bd
            r7 = 1
            if (r15 <= r7) goto L_0x02b9
            int r0 = r15 + -1
            float r0 = (float) r0
            goto L_0x02bb
        L_0x02b9:
            r0 = 1073741824(0x40000000, float:2.0)
        L_0x02bb:
            float r0 = r6 / r0
        L_0x02bd:
            int r6 = r2.C()
            r7 = 8
            if (r6 == r7) goto L_0x02c8
            float r6 = r3 + r0
            goto L_0x02c9
        L_0x02c8:
            r6 = r3
        L_0x02c9:
            if (r12 == 0) goto L_0x02d8
            r7 = 1
            if (r15 <= r7) goto L_0x02d8
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r6 = r5.C
            r6 = r6[r26]
            int r6 = r6.d()
            float r6 = (float) r6
            float r6 = r6 + r3
        L_0x02d8:
            if (r11 == 0) goto L_0x02e6
            if (r5 == 0) goto L_0x02e6
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r5.C
            r3 = r3[r26]
            int r3 = r3.d()
            float r3 = (float) r3
            float r6 = r6 + r3
        L_0x02e6:
            r3 = r2
            if (r3 == 0) goto L_0x02a1
            androidx.constraintlayout.solver.Metrics r2 = androidx.constraintlayout.solver.LinearSystem.f1772r
            if (r2 == 0) goto L_0x02ff
            long r11 = r2.B
            long r11 = r11 - r21
            r2.B = r11
            long r11 = r2.f1807s
            long r11 = r11 + r21
            r2.f1807s = r11
            long r11 = r2.f1813y
            long r11 = r11 + r21
            r2.f1813y = r11
        L_0x02ff:
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r2 = r3.f1918r0
            r2 = r2[r1]
            if (r2 != 0) goto L_0x030b
            if (r3 != r4) goto L_0x0308
            goto L_0x030b
        L_0x0308:
            r7 = 8
            goto L_0x02e6
        L_0x030b:
            if (r1 != 0) goto L_0x0312
            int r7 = r3.D()
            goto L_0x0316
        L_0x0312:
            int r7 = r3.r()
        L_0x0316:
            float r7 = (float) r7
            if (r3 == r5) goto L_0x0323
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r9 = r3.C
            r9 = r9[r26]
            int r9 = r9.d()
            float r9 = (float) r9
            float r6 = r6 + r9
        L_0x0323:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r9 = r3.C
            r9 = r9[r26]
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r9 = r9.f()
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r11 = r10.f1964g
            r9.l(r11, r6)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r9 = r3.C
            r9 = r9[r19]
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r9 = r9.f()
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r11 = r10.f1964g
            float r12 = r6 + r7
            r9.l(r11, r12)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r9 = r3.C
            r9 = r9[r26]
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r9 = r9.f()
            r9.g(r8)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r9 = r3.C
            r9 = r9[r19]
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r9 = r9.f()
            r9.g(r8)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r3.C
            r3 = r3[r19]
            int r3 = r3.d()
            float r3 = (float) r3
            float r7 = r7 + r3
            float r6 = r6 + r7
            if (r2 == 0) goto L_0x0308
            int r3 = r2.C()
            r7 = 8
            if (r3 == r7) goto L_0x02e6
            float r6 = r6 + r0
            goto L_0x02e6
        L_0x036d:
            return r0
        L_0x036e:
            r0 = 0
            return r0
        L_0x0370:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.Optimizer.b(androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer, androidx.constraintlayout.solver.LinearSystem, int, int, androidx.constraintlayout.solver.widgets.ChainHead):boolean");
    }

    static void c(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, ConstraintWidget constraintWidget) {
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = constraintWidgetContainer.E[0];
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (dimensionBehaviour != dimensionBehaviour2 && constraintWidget.E[0] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            int i2 = constraintWidget.f1923u.f1858e;
            int D = constraintWidgetContainer.D() - constraintWidget.f1925w.f1858e;
            ConstraintAnchor constraintAnchor = constraintWidget.f1923u;
            constraintAnchor.f1863j = linearSystem.r(constraintAnchor);
            ConstraintAnchor constraintAnchor2 = constraintWidget.f1925w;
            constraintAnchor2.f1863j = linearSystem.r(constraintAnchor2);
            linearSystem.f(constraintWidget.f1923u.f1863j, i2);
            linearSystem.f(constraintWidget.f1925w.f1863j, D);
            constraintWidget.f1883a = 2;
            constraintWidget.f0(i2, D);
        }
        if (constraintWidgetContainer.E[1] != dimensionBehaviour2 && constraintWidget.E[1] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            int i3 = constraintWidget.f1924v.f1858e;
            int r2 = constraintWidgetContainer.r() - constraintWidget.f1926x.f1858e;
            ConstraintAnchor constraintAnchor3 = constraintWidget.f1924v;
            constraintAnchor3.f1863j = linearSystem.r(constraintAnchor3);
            ConstraintAnchor constraintAnchor4 = constraintWidget.f1926x;
            constraintAnchor4.f1863j = linearSystem.r(constraintAnchor4);
            linearSystem.f(constraintWidget.f1924v.f1863j, i3);
            linearSystem.f(constraintWidget.f1926x.f1863j, r2);
            if (constraintWidget.U > 0 || constraintWidget.C() == 8) {
                ConstraintAnchor constraintAnchor5 = constraintWidget.f1927y;
                constraintAnchor5.f1863j = linearSystem.r(constraintAnchor5);
                linearSystem.f(constraintWidget.f1927y.f1863j, constraintWidget.U + i3);
            }
            constraintWidget.f1885b = 2;
            constraintWidget.t0(i3, r2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0037 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean d(androidx.constraintlayout.solver.widgets.ConstraintWidget r5, int r6) {
        /*
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r5.E
            r1 = r0[r6]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r2 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            r3 = 0
            if (r1 == r2) goto L_0x000a
            return r3
        L_0x000a:
            float r1 = r5.I
            r2 = 0
            r4 = 1
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 == 0) goto L_0x0019
            if (r6 != 0) goto L_0x0015
            goto L_0x0016
        L_0x0015:
            r4 = 0
        L_0x0016:
            r5 = r0[r4]
            return r3
        L_0x0019:
            if (r6 != 0) goto L_0x0029
            int r6 = r5.f1891e
            if (r6 == 0) goto L_0x0020
            return r3
        L_0x0020:
            int r6 = r5.f1897h
            if (r6 != 0) goto L_0x0028
            int r5 = r5.f1899i
            if (r5 == 0) goto L_0x0037
        L_0x0028:
            return r3
        L_0x0029:
            int r6 = r5.f1893f
            if (r6 == 0) goto L_0x002e
            return r3
        L_0x002e:
            int r6 = r5.f1903k
            if (r6 != 0) goto L_0x0038
            int r5 = r5.f1905l
            if (r5 == 0) goto L_0x0037
            goto L_0x0038
        L_0x0037:
            return r4
        L_0x0038:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.Optimizer.d(androidx.constraintlayout.solver.widgets.ConstraintWidget, int):boolean");
    }

    static void e(ConstraintWidget constraintWidget, int i2, int i3) {
        int i4 = i2 * 2;
        int i5 = i4 + 1;
        constraintWidget.C[i4].f().f1964g = constraintWidget.u().f1923u.f();
        constraintWidget.C[i4].f().f1965h = (float) i3;
        constraintWidget.C[i4].f().f1975b = 1;
        constraintWidget.C[i5].f().f1964g = constraintWidget.C[i4].f();
        constraintWidget.C[i5].f().f1965h = (float) constraintWidget.t(i2);
        constraintWidget.C[i5].f().f1975b = 1;
    }
}
