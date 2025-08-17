package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.Arrays;
import java.util.HashMap;

public class LinearSystem {

    /* renamed from: q  reason: collision with root package name */
    private static int f1771q = 1000;

    /* renamed from: r  reason: collision with root package name */
    public static Metrics f1772r;

    /* renamed from: a  reason: collision with root package name */
    int f1773a;

    /* renamed from: b  reason: collision with root package name */
    private HashMap<String, SolverVariable> f1774b;

    /* renamed from: c  reason: collision with root package name */
    private Row f1775c;

    /* renamed from: d  reason: collision with root package name */
    private int f1776d;

    /* renamed from: e  reason: collision with root package name */
    private int f1777e;

    /* renamed from: f  reason: collision with root package name */
    ArrayRow[] f1778f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f1779g;

    /* renamed from: h  reason: collision with root package name */
    private boolean[] f1780h;

    /* renamed from: i  reason: collision with root package name */
    int f1781i;

    /* renamed from: j  reason: collision with root package name */
    int f1782j;

    /* renamed from: k  reason: collision with root package name */
    private int f1783k;

    /* renamed from: l  reason: collision with root package name */
    final Cache f1784l;

    /* renamed from: m  reason: collision with root package name */
    private SolverVariable[] f1785m;

    /* renamed from: n  reason: collision with root package name */
    private int f1786n;

    /* renamed from: o  reason: collision with root package name */
    private ArrayRow[] f1787o;

    /* renamed from: p  reason: collision with root package name */
    private final Row f1788p;

    interface Row {
        void a(Row row);

        void b(SolverVariable solverVariable);

        SolverVariable c(LinearSystem linearSystem, boolean[] zArr);

        void clear();

        SolverVariable getKey();
    }

    public LinearSystem() {
        this.f1773a = 0;
        this.f1774b = null;
        this.f1776d = 32;
        this.f1777e = 32;
        this.f1778f = null;
        this.f1779g = false;
        this.f1780h = new boolean[32];
        this.f1781i = 1;
        this.f1782j = 0;
        this.f1783k = 32;
        this.f1785m = new SolverVariable[f1771q];
        this.f1786n = 0;
        this.f1787o = new ArrayRow[32];
        this.f1778f = new ArrayRow[32];
        D();
        Cache cache = new Cache();
        this.f1784l = cache;
        this.f1775c = new GoalRow(cache);
        this.f1788p = new ArrayRow(cache);
    }

    private final int C(Row row, boolean z2) {
        Metrics metrics = f1772r;
        if (metrics != null) {
            metrics.f1796h++;
        }
        for (int i2 = 0; i2 < this.f1781i; i2++) {
            this.f1780h[i2] = false;
        }
        boolean z3 = false;
        int i3 = 0;
        while (!z3) {
            Metrics metrics2 = f1772r;
            if (metrics2 != null) {
                metrics2.f1797i++;
            }
            i3++;
            if (i3 >= this.f1781i * 2) {
                return i3;
            }
            if (row.getKey() != null) {
                this.f1780h[row.getKey().f1819b] = true;
            }
            SolverVariable c2 = row.c(this, this.f1780h);
            if (c2 != null) {
                boolean[] zArr = this.f1780h;
                int i4 = c2.f1819b;
                if (zArr[i4]) {
                    return i3;
                }
                zArr[i4] = true;
            }
            if (c2 != null) {
                float f2 = Float.MAX_VALUE;
                int i5 = -1;
                for (int i6 = 0; i6 < this.f1782j; i6++) {
                    ArrayRow arrayRow = this.f1778f[i6];
                    if (arrayRow.f1763a.f1824g != SolverVariable.Type.UNRESTRICTED && !arrayRow.f1767e && arrayRow.s(c2)) {
                        float f3 = arrayRow.f1766d.f(c2);
                        if (f3 < 0.0f) {
                            float f4 = (-arrayRow.f1764b) / f3;
                            if (f4 < f2) {
                                i5 = i6;
                                f2 = f4;
                            }
                        }
                    }
                }
                if (i5 > -1) {
                    ArrayRow arrayRow2 = this.f1778f[i5];
                    arrayRow2.f1763a.f1820c = -1;
                    Metrics metrics3 = f1772r;
                    if (metrics3 != null) {
                        metrics3.f1798j++;
                    }
                    arrayRow2.v(c2);
                    SolverVariable solverVariable = arrayRow2.f1763a;
                    solverVariable.f1820c = i5;
                    solverVariable.f(arrayRow2);
                }
            }
            z3 = true;
        }
        return i3;
    }

    private void D() {
        int i2 = 0;
        while (true) {
            ArrayRow[] arrayRowArr = this.f1778f;
            if (i2 < arrayRowArr.length) {
                ArrayRow arrayRow = arrayRowArr[i2];
                if (arrayRow != null) {
                    this.f1784l.f1768a.release(arrayRow);
                }
                this.f1778f[i2] = null;
                i2++;
            } else {
                return;
            }
        }
    }

    private final void F(ArrayRow arrayRow) {
        if (this.f1782j > 0) {
            arrayRow.f1766d.o(arrayRow, this.f1778f);
            if (arrayRow.f1766d.f1752a == 0) {
                arrayRow.f1767e = true;
            }
        }
    }

    private SolverVariable a(SolverVariable.Type type, String str) {
        SolverVariable acquire = this.f1784l.f1769b.acquire();
        if (acquire == null) {
            acquire = new SolverVariable(type, str);
            acquire.e(type, str);
        } else {
            acquire.d();
            acquire.e(type, str);
        }
        int i2 = this.f1786n;
        int i3 = f1771q;
        if (i2 >= i3) {
            int i4 = i3 * 2;
            f1771q = i4;
            this.f1785m = (SolverVariable[]) Arrays.copyOf(this.f1785m, i4);
        }
        SolverVariable[] solverVariableArr = this.f1785m;
        int i5 = this.f1786n;
        this.f1786n = i5 + 1;
        solverVariableArr[i5] = acquire;
        return acquire;
    }

    private void g(ArrayRow arrayRow) {
        arrayRow.d(this, 0);
    }

    private final void m(ArrayRow arrayRow) {
        ArrayRow arrayRow2 = this.f1778f[this.f1782j];
        if (arrayRow2 != null) {
            this.f1784l.f1768a.release(arrayRow2);
        }
        ArrayRow[] arrayRowArr = this.f1778f;
        int i2 = this.f1782j;
        arrayRowArr[i2] = arrayRow;
        SolverVariable solverVariable = arrayRow.f1763a;
        solverVariable.f1820c = i2;
        this.f1782j = i2 + 1;
        solverVariable.f(arrayRow);
    }

    private void o() {
        for (int i2 = 0; i2 < this.f1782j; i2++) {
            ArrayRow arrayRow = this.f1778f[i2];
            arrayRow.f1763a.f1822e = arrayRow.f1764b;
        }
    }

    public static ArrayRow t(LinearSystem linearSystem, SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, float f2, boolean z2) {
        ArrayRow s2 = linearSystem.s();
        if (z2) {
            linearSystem.g(s2);
        }
        return s2.i(solverVariable, solverVariable2, solverVariable3, f2);
    }

    private int v(Row row) throws Exception {
        float f2;
        boolean z2;
        int i2 = 0;
        while (true) {
            f2 = 0.0f;
            if (i2 >= this.f1782j) {
                z2 = false;
                break;
            }
            ArrayRow arrayRow = this.f1778f[i2];
            if (arrayRow.f1763a.f1824g != SolverVariable.Type.UNRESTRICTED && arrayRow.f1764b < 0.0f) {
                z2 = true;
                break;
            }
            i2++;
        }
        if (!z2) {
            return 0;
        }
        boolean z3 = false;
        int i3 = 0;
        while (!z3) {
            Metrics metrics = f1772r;
            if (metrics != null) {
                metrics.f1799k++;
            }
            i3++;
            float f3 = Float.MAX_VALUE;
            int i4 = 0;
            int i5 = -1;
            int i6 = -1;
            int i7 = 0;
            while (i4 < this.f1782j) {
                ArrayRow arrayRow2 = this.f1778f[i4];
                if (arrayRow2.f1763a.f1824g != SolverVariable.Type.UNRESTRICTED && !arrayRow2.f1767e && arrayRow2.f1764b < f2) {
                    int i8 = 1;
                    while (i8 < this.f1781i) {
                        SolverVariable solverVariable = this.f1784l.f1770c[i8];
                        float f4 = arrayRow2.f1766d.f(solverVariable);
                        if (f4 > f2) {
                            for (int i9 = 0; i9 < 7; i9++) {
                                float f5 = solverVariable.f1823f[i9] / f4;
                                if ((f5 < f3 && i9 == i7) || i9 > i7) {
                                    i6 = i8;
                                    i7 = i9;
                                    f3 = f5;
                                    i5 = i4;
                                }
                            }
                        }
                        i8++;
                        f2 = 0.0f;
                    }
                }
                i4++;
                f2 = 0.0f;
            }
            if (i5 != -1) {
                ArrayRow arrayRow3 = this.f1778f[i5];
                arrayRow3.f1763a.f1820c = -1;
                Metrics metrics2 = f1772r;
                if (metrics2 != null) {
                    metrics2.f1798j++;
                }
                arrayRow3.v(this.f1784l.f1770c[i6]);
                SolverVariable solverVariable2 = arrayRow3.f1763a;
                solverVariable2.f1820c = i5;
                solverVariable2.f(arrayRow3);
            } else {
                z3 = true;
            }
            if (i3 > this.f1781i / 2) {
                z3 = true;
            }
            f2 = 0.0f;
        }
        return i3;
    }

    public static Metrics x() {
        return f1772r;
    }

    private void z() {
        int i2 = this.f1776d * 2;
        this.f1776d = i2;
        this.f1778f = (ArrayRow[]) Arrays.copyOf(this.f1778f, i2);
        Cache cache = this.f1784l;
        cache.f1770c = (SolverVariable[]) Arrays.copyOf(cache.f1770c, this.f1776d);
        int i3 = this.f1776d;
        this.f1780h = new boolean[i3];
        this.f1777e = i3;
        this.f1783k = i3;
        Metrics metrics = f1772r;
        if (metrics != null) {
            metrics.f1792d++;
            metrics.f1804p = Math.max(metrics.f1804p, (long) i3);
            Metrics metrics2 = f1772r;
            metrics2.D = metrics2.f1804p;
        }
    }

    public void A() throws Exception {
        Metrics metrics = f1772r;
        if (metrics != null) {
            metrics.f1793e++;
        }
        if (this.f1779g) {
            if (metrics != null) {
                metrics.f1806r++;
            }
            boolean z2 = false;
            int i2 = 0;
            while (true) {
                if (i2 >= this.f1782j) {
                    z2 = true;
                    break;
                } else if (!this.f1778f[i2].f1767e) {
                    break;
                } else {
                    i2++;
                }
            }
            if (!z2) {
                B(this.f1775c);
                return;
            }
            Metrics metrics2 = f1772r;
            if (metrics2 != null) {
                metrics2.f1805q++;
            }
            o();
            return;
        }
        B(this.f1775c);
    }

    /* access modifiers changed from: package-private */
    public void B(Row row) throws Exception {
        Metrics metrics = f1772r;
        if (metrics != null) {
            metrics.f1808t++;
            metrics.f1809u = Math.max(metrics.f1809u, (long) this.f1781i);
            Metrics metrics2 = f1772r;
            metrics2.f1810v = Math.max(metrics2.f1810v, (long) this.f1782j);
        }
        F((ArrayRow) row);
        v(row);
        C(row, false);
        o();
    }

    public void E() {
        Cache cache;
        int i2 = 0;
        while (true) {
            cache = this.f1784l;
            SolverVariable[] solverVariableArr = cache.f1770c;
            if (i2 >= solverVariableArr.length) {
                break;
            }
            SolverVariable solverVariable = solverVariableArr[i2];
            if (solverVariable != null) {
                solverVariable.d();
            }
            i2++;
        }
        cache.f1769b.a(this.f1785m, this.f1786n);
        this.f1786n = 0;
        Arrays.fill(this.f1784l.f1770c, (Object) null);
        HashMap<String, SolverVariable> hashMap = this.f1774b;
        if (hashMap != null) {
            hashMap.clear();
        }
        this.f1773a = 0;
        this.f1775c.clear();
        this.f1781i = 1;
        for (int i3 = 0; i3 < this.f1782j; i3++) {
            this.f1778f[i3].f1765c = false;
        }
        D();
        this.f1782j = 0;
    }

    public void b(ConstraintWidget constraintWidget, ConstraintWidget constraintWidget2, float f2, int i2) {
        ConstraintWidget constraintWidget3 = constraintWidget;
        ConstraintWidget constraintWidget4 = constraintWidget2;
        ConstraintAnchor.Type type = ConstraintAnchor.Type.LEFT;
        SolverVariable r2 = r(constraintWidget3.h(type));
        ConstraintAnchor.Type type2 = ConstraintAnchor.Type.TOP;
        SolverVariable r3 = r(constraintWidget3.h(type2));
        ConstraintAnchor.Type type3 = ConstraintAnchor.Type.RIGHT;
        SolverVariable r4 = r(constraintWidget3.h(type3));
        ConstraintAnchor.Type type4 = ConstraintAnchor.Type.BOTTOM;
        SolverVariable r5 = r(constraintWidget3.h(type4));
        SolverVariable r6 = r(constraintWidget4.h(type));
        SolverVariable r7 = r(constraintWidget4.h(type2));
        SolverVariable r8 = r(constraintWidget4.h(type3));
        SolverVariable r9 = r(constraintWidget4.h(type4));
        ArrayRow s2 = s();
        double d2 = (double) f2;
        SolverVariable solverVariable = r8;
        double d3 = (double) i2;
        s2.p(r3, r5, r7, r9, (float) (Math.sin(d2) * d3));
        d(s2);
        ArrayRow s3 = s();
        s3.p(r2, r4, r6, solverVariable, (float) (Math.cos(d2) * d3));
        d(s3);
    }

    public void c(SolverVariable solverVariable, SolverVariable solverVariable2, int i2, float f2, SolverVariable solverVariable3, SolverVariable solverVariable4, int i3, int i4) {
        int i5 = i4;
        ArrayRow s2 = s();
        s2.g(solverVariable, solverVariable2, i2, f2, solverVariable3, solverVariable4, i3);
        if (i5 != 6) {
            s2.d(this, i5);
        }
        d(s2);
    }

    public void d(ArrayRow arrayRow) {
        SolverVariable u2;
        if (arrayRow != null) {
            Metrics metrics = f1772r;
            if (metrics != null) {
                metrics.f1794f++;
                if (arrayRow.f1767e) {
                    metrics.f1795g++;
                }
            }
            boolean z2 = true;
            if (this.f1782j + 1 >= this.f1783k || this.f1781i + 1 >= this.f1777e) {
                z();
            }
            boolean z3 = false;
            if (!arrayRow.f1767e) {
                F(arrayRow);
                if (!arrayRow.t()) {
                    arrayRow.q();
                    if (arrayRow.f(this)) {
                        SolverVariable q2 = q();
                        arrayRow.f1763a = q2;
                        m(arrayRow);
                        this.f1788p.a(arrayRow);
                        C(this.f1788p, true);
                        if (q2.f1820c == -1) {
                            if (arrayRow.f1763a == q2 && (u2 = arrayRow.u(q2)) != null) {
                                Metrics metrics2 = f1772r;
                                if (metrics2 != null) {
                                    metrics2.f1798j++;
                                }
                                arrayRow.v(u2);
                            }
                            if (!arrayRow.f1767e) {
                                arrayRow.f1763a.f(arrayRow);
                            }
                            this.f1782j--;
                        }
                    } else {
                        z2 = false;
                    }
                    if (arrayRow.r()) {
                        z3 = z2;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            if (!z3) {
                m(arrayRow);
            }
        }
    }

    public ArrayRow e(SolverVariable solverVariable, SolverVariable solverVariable2, int i2, int i3) {
        ArrayRow s2 = s();
        s2.m(solverVariable, solverVariable2, i2);
        if (i3 != 6) {
            s2.d(this, i3);
        }
        d(s2);
        return s2;
    }

    public void f(SolverVariable solverVariable, int i2) {
        int i3 = solverVariable.f1820c;
        if (i3 != -1) {
            ArrayRow arrayRow = this.f1778f[i3];
            if (arrayRow.f1767e) {
                arrayRow.f1764b = (float) i2;
            } else if (arrayRow.f1766d.f1752a == 0) {
                arrayRow.f1767e = true;
                arrayRow.f1764b = (float) i2;
            } else {
                ArrayRow s2 = s();
                s2.l(solverVariable, i2);
                d(s2);
            }
        } else {
            ArrayRow s3 = s();
            s3.h(solverVariable, i2);
            d(s3);
        }
    }

    public void h(SolverVariable solverVariable, SolverVariable solverVariable2, boolean z2) {
        ArrayRow s2 = s();
        SolverVariable u2 = u();
        u2.f1821d = 0;
        s2.n(solverVariable, solverVariable2, u2, 0);
        if (z2) {
            n(s2, (int) (s2.f1766d.f(u2) * -1.0f), 1);
        }
        d(s2);
    }

    public void i(SolverVariable solverVariable, SolverVariable solverVariable2, int i2, int i3) {
        ArrayRow s2 = s();
        SolverVariable u2 = u();
        u2.f1821d = 0;
        s2.n(solverVariable, solverVariable2, u2, i2);
        if (i3 != 6) {
            n(s2, (int) (s2.f1766d.f(u2) * -1.0f), i3);
        }
        d(s2);
    }

    public void j(SolverVariable solverVariable, SolverVariable solverVariable2, boolean z2) {
        ArrayRow s2 = s();
        SolverVariable u2 = u();
        u2.f1821d = 0;
        s2.o(solverVariable, solverVariable2, u2, 0);
        if (z2) {
            n(s2, (int) (s2.f1766d.f(u2) * -1.0f), 1);
        }
        d(s2);
    }

    public void k(SolverVariable solverVariable, SolverVariable solverVariable2, int i2, int i3) {
        ArrayRow s2 = s();
        SolverVariable u2 = u();
        u2.f1821d = 0;
        s2.o(solverVariable, solverVariable2, u2, i2);
        if (i3 != 6) {
            n(s2, (int) (s2.f1766d.f(u2) * -1.0f), i3);
        }
        d(s2);
    }

    public void l(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f2, int i2) {
        ArrayRow s2 = s();
        s2.j(solverVariable, solverVariable2, solverVariable3, solverVariable4, f2);
        if (i2 != 6) {
            s2.d(this, i2);
        }
        d(s2);
    }

    /* access modifiers changed from: package-private */
    public void n(ArrayRow arrayRow, int i2, int i3) {
        arrayRow.e(p(i3, (String) null), i2);
    }

    public SolverVariable p(int i2, String str) {
        Metrics metrics = f1772r;
        if (metrics != null) {
            metrics.f1801m++;
        }
        if (this.f1781i + 1 >= this.f1777e) {
            z();
        }
        SolverVariable a2 = a(SolverVariable.Type.ERROR, str);
        int i3 = this.f1773a + 1;
        this.f1773a = i3;
        this.f1781i++;
        a2.f1819b = i3;
        a2.f1821d = i2;
        this.f1784l.f1770c[i3] = a2;
        this.f1775c.b(a2);
        return a2;
    }

    public SolverVariable q() {
        Metrics metrics = f1772r;
        if (metrics != null) {
            metrics.f1803o++;
        }
        if (this.f1781i + 1 >= this.f1777e) {
            z();
        }
        SolverVariable a2 = a(SolverVariable.Type.SLACK, (String) null);
        int i2 = this.f1773a + 1;
        this.f1773a = i2;
        this.f1781i++;
        a2.f1819b = i2;
        this.f1784l.f1770c[i2] = a2;
        return a2;
    }

    public SolverVariable r(Object obj) {
        SolverVariable solverVariable = null;
        if (obj == null) {
            return null;
        }
        if (this.f1781i + 1 >= this.f1777e) {
            z();
        }
        if (obj instanceof ConstraintAnchor) {
            ConstraintAnchor constraintAnchor = (ConstraintAnchor) obj;
            solverVariable = constraintAnchor.g();
            if (solverVariable == null) {
                constraintAnchor.n(this.f1784l);
                solverVariable = constraintAnchor.g();
            }
            int i2 = solverVariable.f1819b;
            if (i2 == -1 || i2 > this.f1773a || this.f1784l.f1770c[i2] == null) {
                if (i2 != -1) {
                    solverVariable.d();
                }
                int i3 = this.f1773a + 1;
                this.f1773a = i3;
                this.f1781i++;
                solverVariable.f1819b = i3;
                solverVariable.f1824g = SolverVariable.Type.UNRESTRICTED;
                this.f1784l.f1770c[i3] = solverVariable;
            }
        }
        return solverVariable;
    }

    public ArrayRow s() {
        ArrayRow acquire = this.f1784l.f1768a.acquire();
        if (acquire == null) {
            acquire = new ArrayRow(this.f1784l);
        } else {
            acquire.w();
        }
        SolverVariable.b();
        return acquire;
    }

    public SolverVariable u() {
        Metrics metrics = f1772r;
        if (metrics != null) {
            metrics.f1802n++;
        }
        if (this.f1781i + 1 >= this.f1777e) {
            z();
        }
        SolverVariable a2 = a(SolverVariable.Type.SLACK, (String) null);
        int i2 = this.f1773a + 1;
        this.f1773a = i2;
        this.f1781i++;
        a2.f1819b = i2;
        this.f1784l.f1770c[i2] = a2;
        return a2;
    }

    public Cache w() {
        return this.f1784l;
    }

    public int y(Object obj) {
        SolverVariable g2 = ((ConstraintAnchor) obj).g();
        if (g2 != null) {
            return (int) (g2.f1822e + 0.5f);
        }
        return 0;
    }
}
