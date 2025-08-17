package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;

public class ArrayRow implements LinearSystem.Row {

    /* renamed from: a  reason: collision with root package name */
    SolverVariable f1763a = null;

    /* renamed from: b  reason: collision with root package name */
    float f1764b = 0.0f;

    /* renamed from: c  reason: collision with root package name */
    boolean f1765c = false;

    /* renamed from: d  reason: collision with root package name */
    public final ArrayLinkedVariables f1766d;

    /* renamed from: e  reason: collision with root package name */
    boolean f1767e = false;

    public ArrayRow(Cache cache) {
        this.f1766d = new ArrayLinkedVariables(this, cache);
    }

    public void a(LinearSystem.Row row) {
        if (row instanceof ArrayRow) {
            ArrayRow arrayRow = (ArrayRow) row;
            this.f1763a = null;
            this.f1766d.c();
            int i2 = 0;
            while (true) {
                ArrayLinkedVariables arrayLinkedVariables = arrayRow.f1766d;
                if (i2 < arrayLinkedVariables.f1752a) {
                    this.f1766d.a(arrayLinkedVariables.h(i2), arrayRow.f1766d.i(i2), true);
                    i2++;
                } else {
                    return;
                }
            }
        }
    }

    public void b(SolverVariable solverVariable) {
        int i2 = solverVariable.f1821d;
        float f2 = 1.0f;
        if (i2 != 1) {
            if (i2 == 2) {
                f2 = 1000.0f;
            } else if (i2 == 3) {
                f2 = 1000000.0f;
            } else if (i2 == 4) {
                f2 = 1.0E9f;
            } else if (i2 == 5) {
                f2 = 1.0E12f;
            }
        }
        this.f1766d.l(solverVariable, f2);
    }

    public SolverVariable c(LinearSystem linearSystem, boolean[] zArr) {
        return this.f1766d.g(zArr, (SolverVariable) null);
    }

    public void clear() {
        this.f1766d.c();
        this.f1763a = null;
        this.f1764b = 0.0f;
    }

    public ArrayRow d(LinearSystem linearSystem, int i2) {
        this.f1766d.l(linearSystem.p(i2, "ep"), 1.0f);
        this.f1766d.l(linearSystem.p(i2, "em"), -1.0f);
        return this;
    }

    /* access modifiers changed from: package-private */
    public ArrayRow e(SolverVariable solverVariable, int i2) {
        this.f1766d.l(solverVariable, (float) i2);
        return this;
    }

    /* access modifiers changed from: package-private */
    public boolean f(LinearSystem linearSystem) {
        boolean z2;
        SolverVariable b2 = this.f1766d.b(linearSystem);
        if (b2 == null) {
            z2 = true;
        } else {
            v(b2);
            z2 = false;
        }
        if (this.f1766d.f1752a == 0) {
            this.f1767e = true;
        }
        return z2;
    }

    /* access modifiers changed from: package-private */
    public ArrayRow g(SolverVariable solverVariable, SolverVariable solverVariable2, int i2, float f2, SolverVariable solverVariable3, SolverVariable solverVariable4, int i3) {
        if (solverVariable2 == solverVariable3) {
            this.f1766d.l(solverVariable, 1.0f);
            this.f1766d.l(solverVariable4, 1.0f);
            this.f1766d.l(solverVariable2, -2.0f);
            return this;
        }
        if (f2 == 0.5f) {
            this.f1766d.l(solverVariable, 1.0f);
            this.f1766d.l(solverVariable2, -1.0f);
            this.f1766d.l(solverVariable3, -1.0f);
            this.f1766d.l(solverVariable4, 1.0f);
            if (i2 > 0 || i3 > 0) {
                this.f1764b = (float) ((-i2) + i3);
            }
        } else if (f2 <= 0.0f) {
            this.f1766d.l(solverVariable, -1.0f);
            this.f1766d.l(solverVariable2, 1.0f);
            this.f1764b = (float) i2;
        } else if (f2 >= 1.0f) {
            this.f1766d.l(solverVariable3, -1.0f);
            this.f1766d.l(solverVariable4, 1.0f);
            this.f1764b = (float) i3;
        } else {
            float f3 = 1.0f - f2;
            this.f1766d.l(solverVariable, f3 * 1.0f);
            this.f1766d.l(solverVariable2, f3 * -1.0f);
            this.f1766d.l(solverVariable3, -1.0f * f2);
            this.f1766d.l(solverVariable4, 1.0f * f2);
            if (i2 > 0 || i3 > 0) {
                this.f1764b = (((float) (-i2)) * f3) + (((float) i3) * f2);
            }
        }
        return this;
    }

    public SolverVariable getKey() {
        return this.f1763a;
    }

    /* access modifiers changed from: package-private */
    public ArrayRow h(SolverVariable solverVariable, int i2) {
        this.f1763a = solverVariable;
        float f2 = (float) i2;
        solverVariable.f1822e = f2;
        this.f1764b = f2;
        this.f1767e = true;
        return this;
    }

    /* access modifiers changed from: package-private */
    public ArrayRow i(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, float f2) {
        this.f1766d.l(solverVariable, -1.0f);
        this.f1766d.l(solverVariable2, 1.0f - f2);
        this.f1766d.l(solverVariable3, f2);
        return this;
    }

    public ArrayRow j(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f2) {
        this.f1766d.l(solverVariable, -1.0f);
        this.f1766d.l(solverVariable2, 1.0f);
        this.f1766d.l(solverVariable3, f2);
        this.f1766d.l(solverVariable4, -f2);
        return this;
    }

    public ArrayRow k(float f2, float f3, float f4, SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4) {
        this.f1764b = 0.0f;
        if (f3 == 0.0f || f2 == f4) {
            this.f1766d.l(solverVariable, 1.0f);
            this.f1766d.l(solverVariable2, -1.0f);
            this.f1766d.l(solverVariable4, 1.0f);
            this.f1766d.l(solverVariable3, -1.0f);
        } else if (f2 == 0.0f) {
            this.f1766d.l(solverVariable, 1.0f);
            this.f1766d.l(solverVariable2, -1.0f);
        } else if (f4 == 0.0f) {
            this.f1766d.l(solverVariable3, 1.0f);
            this.f1766d.l(solverVariable4, -1.0f);
        } else {
            float f5 = (f2 / f3) / (f4 / f3);
            this.f1766d.l(solverVariable, 1.0f);
            this.f1766d.l(solverVariable2, -1.0f);
            this.f1766d.l(solverVariable4, f5);
            this.f1766d.l(solverVariable3, -f5);
        }
        return this;
    }

    public ArrayRow l(SolverVariable solverVariable, int i2) {
        if (i2 < 0) {
            this.f1764b = (float) (i2 * -1);
            this.f1766d.l(solverVariable, 1.0f);
        } else {
            this.f1764b = (float) i2;
            this.f1766d.l(solverVariable, -1.0f);
        }
        return this;
    }

    public ArrayRow m(SolverVariable solverVariable, SolverVariable solverVariable2, int i2) {
        boolean z2 = false;
        if (i2 != 0) {
            if (i2 < 0) {
                i2 *= -1;
                z2 = true;
            }
            this.f1764b = (float) i2;
        }
        if (!z2) {
            this.f1766d.l(solverVariable, -1.0f);
            this.f1766d.l(solverVariable2, 1.0f);
        } else {
            this.f1766d.l(solverVariable, 1.0f);
            this.f1766d.l(solverVariable2, -1.0f);
        }
        return this;
    }

    public ArrayRow n(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i2) {
        boolean z2 = false;
        if (i2 != 0) {
            if (i2 < 0) {
                i2 *= -1;
                z2 = true;
            }
            this.f1764b = (float) i2;
        }
        if (!z2) {
            this.f1766d.l(solverVariable, -1.0f);
            this.f1766d.l(solverVariable2, 1.0f);
            this.f1766d.l(solverVariable3, 1.0f);
        } else {
            this.f1766d.l(solverVariable, 1.0f);
            this.f1766d.l(solverVariable2, -1.0f);
            this.f1766d.l(solverVariable3, -1.0f);
        }
        return this;
    }

    public ArrayRow o(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i2) {
        boolean z2 = false;
        if (i2 != 0) {
            if (i2 < 0) {
                i2 *= -1;
                z2 = true;
            }
            this.f1764b = (float) i2;
        }
        if (!z2) {
            this.f1766d.l(solverVariable, -1.0f);
            this.f1766d.l(solverVariable2, 1.0f);
            this.f1766d.l(solverVariable3, -1.0f);
        } else {
            this.f1766d.l(solverVariable, 1.0f);
            this.f1766d.l(solverVariable2, -1.0f);
            this.f1766d.l(solverVariable3, 1.0f);
        }
        return this;
    }

    public ArrayRow p(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f2) {
        this.f1766d.l(solverVariable3, 0.5f);
        this.f1766d.l(solverVariable4, 0.5f);
        this.f1766d.l(solverVariable, -0.5f);
        this.f1766d.l(solverVariable2, -0.5f);
        this.f1764b = -f2;
        return this;
    }

    /* access modifiers changed from: package-private */
    public void q() {
        float f2 = this.f1764b;
        if (f2 < 0.0f) {
            this.f1764b = f2 * -1.0f;
            this.f1766d.j();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean r() {
        SolverVariable solverVariable = this.f1763a;
        return solverVariable != null && (solverVariable.f1824g == SolverVariable.Type.UNRESTRICTED || this.f1764b >= 0.0f);
    }

    /* access modifiers changed from: package-private */
    public boolean s(SolverVariable solverVariable) {
        return this.f1766d.d(solverVariable);
    }

    public boolean t() {
        return this.f1763a == null && this.f1764b == 0.0f && this.f1766d.f1752a == 0;
    }

    public String toString() {
        return x();
    }

    /* access modifiers changed from: package-private */
    public SolverVariable u(SolverVariable solverVariable) {
        return this.f1766d.g((boolean[]) null, solverVariable);
    }

    /* access modifiers changed from: package-private */
    public void v(SolverVariable solverVariable) {
        SolverVariable solverVariable2 = this.f1763a;
        if (solverVariable2 != null) {
            this.f1766d.l(solverVariable2, -1.0f);
            this.f1763a = null;
        }
        float m2 = this.f1766d.m(solverVariable, true) * -1.0f;
        this.f1763a = solverVariable;
        if (m2 != 1.0f) {
            this.f1764b /= m2;
            this.f1766d.e(m2);
        }
    }

    public void w() {
        this.f1763a = null;
        this.f1766d.c();
        this.f1764b = 0.0f;
        this.f1767e = false;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00ce  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String x() {
        /*
            r10 = this;
            androidx.constraintlayout.solver.SolverVariable r0 = r10.f1763a
            java.lang.String r1 = ""
            if (r0 != 0) goto L_0x0018
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r1)
            java.lang.String r1 = "0"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            goto L_0x0029
        L_0x0018:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r1)
            androidx.constraintlayout.solver.SolverVariable r1 = r10.f1763a
            r0.append(r1)
            java.lang.String r0 = r0.toString()
        L_0x0029:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = " = "
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            float r1 = r10.f1764b
            r2 = 0
            r3 = 1
            r4 = 0
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 == 0) goto L_0x0056
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            float r0 = r10.f1764b
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r1 = 1
            goto L_0x0057
        L_0x0056:
            r1 = 0
        L_0x0057:
            androidx.constraintlayout.solver.ArrayLinkedVariables r5 = r10.f1766d
            int r5 = r5.f1752a
        L_0x005b:
            if (r2 >= r5) goto L_0x00ea
            androidx.constraintlayout.solver.ArrayLinkedVariables r6 = r10.f1766d
            androidx.constraintlayout.solver.SolverVariable r6 = r6.h(r2)
            if (r6 != 0) goto L_0x0067
            goto L_0x00e6
        L_0x0067:
            androidx.constraintlayout.solver.ArrayLinkedVariables r7 = r10.f1766d
            float r7 = r7.i(r2)
            int r8 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r8 != 0) goto L_0x0073
            goto L_0x00e6
        L_0x0073:
            java.lang.String r6 = r6.toString()
            r9 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r1 != 0) goto L_0x0091
            int r1 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r1 >= 0) goto L_0x00b8
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = "- "
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            goto L_0x00b6
        L_0x0091:
            if (r8 <= 0) goto L_0x00a5
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = " + "
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            goto L_0x00b8
        L_0x00a5:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = " - "
            r1.append(r0)
            java.lang.String r0 = r1.toString()
        L_0x00b6:
            float r7 = r7 * r9
        L_0x00b8:
            r1 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r1 != 0) goto L_0x00ce
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            r1.append(r6)
            java.lang.String r0 = r1.toString()
            goto L_0x00e5
        L_0x00ce:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            r1.append(r7)
            java.lang.String r0 = " "
            r1.append(r0)
            r1.append(r6)
            java.lang.String r0 = r1.toString()
        L_0x00e5:
            r1 = 1
        L_0x00e6:
            int r2 = r2 + 1
            goto L_0x005b
        L_0x00ea:
            if (r1 != 0) goto L_0x00fd
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = "0.0"
            r1.append(r0)
            java.lang.String r0 = r1.toString()
        L_0x00fd:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.ArrayRow.x():java.lang.String");
    }
}
