package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.SolverVariable;
import java.util.Arrays;

public class ArrayLinkedVariables {

    /* renamed from: a  reason: collision with root package name */
    int f1752a = 0;

    /* renamed from: b  reason: collision with root package name */
    private final ArrayRow f1753b;

    /* renamed from: c  reason: collision with root package name */
    private final Cache f1754c;

    /* renamed from: d  reason: collision with root package name */
    private int f1755d = 8;

    /* renamed from: e  reason: collision with root package name */
    private SolverVariable f1756e = null;

    /* renamed from: f  reason: collision with root package name */
    private int[] f1757f = new int[8];

    /* renamed from: g  reason: collision with root package name */
    private int[] f1758g = new int[8];

    /* renamed from: h  reason: collision with root package name */
    private float[] f1759h = new float[8];

    /* renamed from: i  reason: collision with root package name */
    private int f1760i = -1;

    /* renamed from: j  reason: collision with root package name */
    private int f1761j = -1;

    /* renamed from: k  reason: collision with root package name */
    private boolean f1762k = false;

    ArrayLinkedVariables(ArrayRow arrayRow, Cache cache) {
        this.f1753b = arrayRow;
        this.f1754c = cache;
    }

    private boolean k(SolverVariable solverVariable, LinearSystem linearSystem) {
        return solverVariable.f1827j <= 1;
    }

    /* access modifiers changed from: package-private */
    public final void a(SolverVariable solverVariable, float f2, boolean z2) {
        if (f2 != 0.0f) {
            int i2 = this.f1760i;
            if (i2 == -1) {
                this.f1760i = 0;
                this.f1759h[0] = f2;
                this.f1757f[0] = solverVariable.f1819b;
                this.f1758g[0] = -1;
                solverVariable.f1827j++;
                solverVariable.a(this.f1753b);
                this.f1752a++;
                if (!this.f1762k) {
                    int i3 = this.f1761j + 1;
                    this.f1761j = i3;
                    int[] iArr = this.f1757f;
                    if (i3 >= iArr.length) {
                        this.f1762k = true;
                        this.f1761j = iArr.length - 1;
                        return;
                    }
                    return;
                }
                return;
            }
            int i4 = 0;
            int i5 = -1;
            while (i2 != -1 && i4 < this.f1752a) {
                int i6 = this.f1757f[i2];
                int i7 = solverVariable.f1819b;
                if (i6 == i7) {
                    float[] fArr = this.f1759h;
                    float f3 = fArr[i2] + f2;
                    fArr[i2] = f3;
                    if (f3 == 0.0f) {
                        if (i2 == this.f1760i) {
                            this.f1760i = this.f1758g[i2];
                        } else {
                            int[] iArr2 = this.f1758g;
                            iArr2[i5] = iArr2[i2];
                        }
                        if (z2) {
                            solverVariable.c(this.f1753b);
                        }
                        if (this.f1762k) {
                            this.f1761j = i2;
                        }
                        solverVariable.f1827j--;
                        this.f1752a--;
                        return;
                    }
                    return;
                }
                if (i6 < i7) {
                    i5 = i2;
                }
                i2 = this.f1758g[i2];
                i4++;
            }
            int i8 = this.f1761j;
            int i9 = i8 + 1;
            if (this.f1762k) {
                int[] iArr3 = this.f1757f;
                if (iArr3[i8] != -1) {
                    i8 = iArr3.length;
                }
            } else {
                i8 = i9;
            }
            int[] iArr4 = this.f1757f;
            if (i8 >= iArr4.length && this.f1752a < iArr4.length) {
                int i10 = 0;
                while (true) {
                    int[] iArr5 = this.f1757f;
                    if (i10 >= iArr5.length) {
                        break;
                    } else if (iArr5[i10] == -1) {
                        i8 = i10;
                        break;
                    } else {
                        i10++;
                    }
                }
            }
            int[] iArr6 = this.f1757f;
            if (i8 >= iArr6.length) {
                i8 = iArr6.length;
                int i11 = this.f1755d * 2;
                this.f1755d = i11;
                this.f1762k = false;
                this.f1761j = i8 - 1;
                this.f1759h = Arrays.copyOf(this.f1759h, i11);
                this.f1757f = Arrays.copyOf(this.f1757f, this.f1755d);
                this.f1758g = Arrays.copyOf(this.f1758g, this.f1755d);
            }
            this.f1757f[i8] = solverVariable.f1819b;
            this.f1759h[i8] = f2;
            if (i5 != -1) {
                int[] iArr7 = this.f1758g;
                iArr7[i8] = iArr7[i5];
                iArr7[i5] = i8;
            } else {
                this.f1758g[i8] = this.f1760i;
                this.f1760i = i8;
            }
            solverVariable.f1827j++;
            solverVariable.a(this.f1753b);
            this.f1752a++;
            if (!this.f1762k) {
                this.f1761j++;
            }
            int i12 = this.f1761j;
            int[] iArr8 = this.f1757f;
            if (i12 >= iArr8.length) {
                this.f1762k = true;
                this.f1761j = iArr8.length - 1;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0090 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.constraintlayout.solver.SolverVariable b(androidx.constraintlayout.solver.LinearSystem r15) {
        /*
            r14 = this;
            int r0 = r14.f1760i
            r1 = 0
            r2 = 0
            r3 = 0
            r3 = r1
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
        L_0x000b:
            r9 = -1
            if (r0 == r9) goto L_0x0098
            int r9 = r14.f1752a
            if (r4 >= r9) goto L_0x0098
            float[] r9 = r14.f1759h
            r10 = r9[r0]
            androidx.constraintlayout.solver.Cache r11 = r14.f1754c
            androidx.constraintlayout.solver.SolverVariable[] r11 = r11.f1770c
            int[] r12 = r14.f1757f
            r12 = r12[r0]
            r11 = r11[r12]
            int r12 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r12 >= 0) goto L_0x0033
            r12 = -1165815185(0xffffffffba83126f, float:-0.001)
            int r12 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r12 <= 0) goto L_0x0042
            r9[r0] = r2
            androidx.constraintlayout.solver.ArrayRow r9 = r14.f1753b
            r11.c(r9)
            goto L_0x0041
        L_0x0033:
            r12 = 981668463(0x3a83126f, float:0.001)
            int r12 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r12 >= 0) goto L_0x0042
            r9[r0] = r2
            androidx.constraintlayout.solver.ArrayRow r9 = r14.f1753b
            r11.c(r9)
        L_0x0041:
            r10 = 0
        L_0x0042:
            int r9 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r9 == 0) goto L_0x0090
            androidx.constraintlayout.solver.SolverVariable$Type r9 = r11.f1824g
            androidx.constraintlayout.solver.SolverVariable$Type r12 = androidx.constraintlayout.solver.SolverVariable.Type.UNRESTRICTED
            r13 = 1
            if (r9 != r12) goto L_0x006c
            if (r3 != 0) goto L_0x0057
            boolean r3 = r14.k(r11, r15)
        L_0x0053:
            r5 = r3
            r7 = r10
            r3 = r11
            goto L_0x0090
        L_0x0057:
            int r9 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
            if (r9 <= 0) goto L_0x0060
            boolean r3 = r14.k(r11, r15)
            goto L_0x0053
        L_0x0060:
            if (r5 != 0) goto L_0x0090
            boolean r9 = r14.k(r11, r15)
            if (r9 == 0) goto L_0x0090
            r7 = r10
            r3 = r11
            r5 = 1
            goto L_0x0090
        L_0x006c:
            if (r3 != 0) goto L_0x0090
            int r9 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r9 >= 0) goto L_0x0090
            if (r1 != 0) goto L_0x007c
            boolean r1 = r14.k(r11, r15)
        L_0x0078:
            r6 = r1
            r8 = r10
            r1 = r11
            goto L_0x0090
        L_0x007c:
            int r9 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r9 <= 0) goto L_0x0085
            boolean r1 = r14.k(r11, r15)
            goto L_0x0078
        L_0x0085:
            if (r6 != 0) goto L_0x0090
            boolean r9 = r14.k(r11, r15)
            if (r9 == 0) goto L_0x0090
            r8 = r10
            r1 = r11
            r6 = 1
        L_0x0090:
            int[] r9 = r14.f1758g
            r0 = r9[r0]
            int r4 = r4 + 1
            goto L_0x000b
        L_0x0098:
            if (r3 == 0) goto L_0x009b
            return r3
        L_0x009b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.ArrayLinkedVariables.b(androidx.constraintlayout.solver.LinearSystem):androidx.constraintlayout.solver.SolverVariable");
    }

    public final void c() {
        int i2 = this.f1760i;
        int i3 = 0;
        while (i2 != -1 && i3 < this.f1752a) {
            SolverVariable solverVariable = this.f1754c.f1770c[this.f1757f[i2]];
            if (solverVariable != null) {
                solverVariable.c(this.f1753b);
            }
            i2 = this.f1758g[i2];
            i3++;
        }
        this.f1760i = -1;
        this.f1761j = -1;
        this.f1762k = false;
        this.f1752a = 0;
    }

    /* access modifiers changed from: package-private */
    public final boolean d(SolverVariable solverVariable) {
        int i2 = this.f1760i;
        if (i2 == -1) {
            return false;
        }
        int i3 = 0;
        while (i2 != -1 && i3 < this.f1752a) {
            if (this.f1757f[i2] == solverVariable.f1819b) {
                return true;
            }
            i2 = this.f1758g[i2];
            i3++;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void e(float f2) {
        int i2 = this.f1760i;
        int i3 = 0;
        while (i2 != -1 && i3 < this.f1752a) {
            float[] fArr = this.f1759h;
            fArr[i2] = fArr[i2] / f2;
            i2 = this.f1758g[i2];
            i3++;
        }
    }

    public final float f(SolverVariable solverVariable) {
        int i2 = this.f1760i;
        int i3 = 0;
        while (i2 != -1 && i3 < this.f1752a) {
            if (this.f1757f[i2] == solverVariable.f1819b) {
                return this.f1759h[i2];
            }
            i2 = this.f1758g[i2];
            i3++;
        }
        return 0.0f;
    }

    /* access modifiers changed from: package-private */
    public SolverVariable g(boolean[] zArr, SolverVariable solverVariable) {
        SolverVariable.Type type;
        int i2 = this.f1760i;
        int i3 = 0;
        SolverVariable solverVariable2 = null;
        float f2 = 0.0f;
        while (i2 != -1 && i3 < this.f1752a) {
            float f3 = this.f1759h[i2];
            if (f3 < 0.0f) {
                SolverVariable solverVariable3 = this.f1754c.f1770c[this.f1757f[i2]];
                if ((zArr == null || !zArr[solverVariable3.f1819b]) && solverVariable3 != solverVariable && (((type = solverVariable3.f1824g) == SolverVariable.Type.SLACK || type == SolverVariable.Type.ERROR) && f3 < f2)) {
                    f2 = f3;
                    solverVariable2 = solverVariable3;
                }
            }
            i2 = this.f1758g[i2];
            i3++;
        }
        return solverVariable2;
    }

    /* access modifiers changed from: package-private */
    public final SolverVariable h(int i2) {
        int i3 = this.f1760i;
        int i4 = 0;
        while (i3 != -1 && i4 < this.f1752a) {
            if (i4 == i2) {
                return this.f1754c.f1770c[this.f1757f[i3]];
            }
            i3 = this.f1758g[i3];
            i4++;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final float i(int i2) {
        int i3 = this.f1760i;
        int i4 = 0;
        while (i3 != -1 && i4 < this.f1752a) {
            if (i4 == i2) {
                return this.f1759h[i3];
            }
            i3 = this.f1758g[i3];
            i4++;
        }
        return 0.0f;
    }

    /* access modifiers changed from: package-private */
    public void j() {
        int i2 = this.f1760i;
        int i3 = 0;
        while (i2 != -1 && i3 < this.f1752a) {
            float[] fArr = this.f1759h;
            fArr[i2] = fArr[i2] * -1.0f;
            i2 = this.f1758g[i2];
            i3++;
        }
    }

    public final void l(SolverVariable solverVariable, float f2) {
        if (f2 == 0.0f) {
            m(solverVariable, true);
            return;
        }
        int i2 = this.f1760i;
        if (i2 == -1) {
            this.f1760i = 0;
            this.f1759h[0] = f2;
            this.f1757f[0] = solverVariable.f1819b;
            this.f1758g[0] = -1;
            solverVariable.f1827j++;
            solverVariable.a(this.f1753b);
            this.f1752a++;
            if (!this.f1762k) {
                int i3 = this.f1761j + 1;
                this.f1761j = i3;
                int[] iArr = this.f1757f;
                if (i3 >= iArr.length) {
                    this.f1762k = true;
                    this.f1761j = iArr.length - 1;
                    return;
                }
                return;
            }
            return;
        }
        int i4 = 0;
        int i5 = -1;
        while (i2 != -1 && i4 < this.f1752a) {
            int i6 = this.f1757f[i2];
            int i7 = solverVariable.f1819b;
            if (i6 == i7) {
                this.f1759h[i2] = f2;
                return;
            }
            if (i6 < i7) {
                i5 = i2;
            }
            i2 = this.f1758g[i2];
            i4++;
        }
        int i8 = this.f1761j;
        int i9 = i8 + 1;
        if (this.f1762k) {
            int[] iArr2 = this.f1757f;
            if (iArr2[i8] != -1) {
                i8 = iArr2.length;
            }
        } else {
            i8 = i9;
        }
        int[] iArr3 = this.f1757f;
        if (i8 >= iArr3.length && this.f1752a < iArr3.length) {
            int i10 = 0;
            while (true) {
                int[] iArr4 = this.f1757f;
                if (i10 >= iArr4.length) {
                    break;
                } else if (iArr4[i10] == -1) {
                    i8 = i10;
                    break;
                } else {
                    i10++;
                }
            }
        }
        int[] iArr5 = this.f1757f;
        if (i8 >= iArr5.length) {
            i8 = iArr5.length;
            int i11 = this.f1755d * 2;
            this.f1755d = i11;
            this.f1762k = false;
            this.f1761j = i8 - 1;
            this.f1759h = Arrays.copyOf(this.f1759h, i11);
            this.f1757f = Arrays.copyOf(this.f1757f, this.f1755d);
            this.f1758g = Arrays.copyOf(this.f1758g, this.f1755d);
        }
        this.f1757f[i8] = solverVariable.f1819b;
        this.f1759h[i8] = f2;
        if (i5 != -1) {
            int[] iArr6 = this.f1758g;
            iArr6[i8] = iArr6[i5];
            iArr6[i5] = i8;
        } else {
            this.f1758g[i8] = this.f1760i;
            this.f1760i = i8;
        }
        solverVariable.f1827j++;
        solverVariable.a(this.f1753b);
        int i12 = this.f1752a + 1;
        this.f1752a = i12;
        if (!this.f1762k) {
            this.f1761j++;
        }
        int[] iArr7 = this.f1757f;
        if (i12 >= iArr7.length) {
            this.f1762k = true;
        }
        if (this.f1761j >= iArr7.length) {
            this.f1762k = true;
            this.f1761j = iArr7.length - 1;
        }
    }

    public final float m(SolverVariable solverVariable, boolean z2) {
        if (this.f1756e == solverVariable) {
            this.f1756e = null;
        }
        int i2 = this.f1760i;
        if (i2 == -1) {
            return 0.0f;
        }
        int i3 = 0;
        int i4 = -1;
        while (i2 != -1 && i3 < this.f1752a) {
            if (this.f1757f[i2] == solverVariable.f1819b) {
                if (i2 == this.f1760i) {
                    this.f1760i = this.f1758g[i2];
                } else {
                    int[] iArr = this.f1758g;
                    iArr[i4] = iArr[i2];
                }
                if (z2) {
                    solverVariable.c(this.f1753b);
                }
                solverVariable.f1827j--;
                this.f1752a--;
                this.f1757f[i2] = -1;
                if (this.f1762k) {
                    this.f1761j = i2;
                }
                return this.f1759h[i2];
            }
            i3++;
            i4 = i2;
            i2 = this.f1758g[i2];
        }
        return 0.0f;
    }

    /* access modifiers changed from: package-private */
    public final void n(ArrayRow arrayRow, ArrayRow arrayRow2, boolean z2) {
        int i2 = this.f1760i;
        while (true) {
            int i3 = 0;
            while (i2 != -1 && i3 < this.f1752a) {
                int i4 = this.f1757f[i2];
                SolverVariable solverVariable = arrayRow2.f1763a;
                if (i4 == solverVariable.f1819b) {
                    float f2 = this.f1759h[i2];
                    m(solverVariable, z2);
                    ArrayLinkedVariables arrayLinkedVariables = arrayRow2.f1766d;
                    int i5 = arrayLinkedVariables.f1760i;
                    int i6 = 0;
                    while (i5 != -1 && i6 < arrayLinkedVariables.f1752a) {
                        a(this.f1754c.f1770c[arrayLinkedVariables.f1757f[i5]], arrayLinkedVariables.f1759h[i5] * f2, z2);
                        i5 = arrayLinkedVariables.f1758g[i5];
                        i6++;
                    }
                    arrayRow.f1764b += arrayRow2.f1764b * f2;
                    if (z2) {
                        arrayRow2.f1763a.c(arrayRow);
                    }
                    i2 = this.f1760i;
                } else {
                    i2 = this.f1758g[i2];
                    i3++;
                }
            }
            return;
        }
    }

    /* access modifiers changed from: package-private */
    public void o(ArrayRow arrayRow, ArrayRow[] arrayRowArr) {
        int i2 = this.f1760i;
        while (true) {
            int i3 = 0;
            while (i2 != -1 && i3 < this.f1752a) {
                SolverVariable solverVariable = this.f1754c.f1770c[this.f1757f[i2]];
                if (solverVariable.f1820c != -1) {
                    float f2 = this.f1759h[i2];
                    m(solverVariable, true);
                    ArrayRow arrayRow2 = arrayRowArr[solverVariable.f1820c];
                    if (!arrayRow2.f1767e) {
                        ArrayLinkedVariables arrayLinkedVariables = arrayRow2.f1766d;
                        int i4 = arrayLinkedVariables.f1760i;
                        int i5 = 0;
                        while (i4 != -1 && i5 < arrayLinkedVariables.f1752a) {
                            a(this.f1754c.f1770c[arrayLinkedVariables.f1757f[i4]], arrayLinkedVariables.f1759h[i4] * f2, true);
                            i4 = arrayLinkedVariables.f1758g[i4];
                            i5++;
                        }
                    }
                    arrayRow.f1764b += arrayRow2.f1764b * f2;
                    arrayRow2.f1763a.c(arrayRow);
                    i2 = this.f1760i;
                } else {
                    i2 = this.f1758g[i2];
                    i3++;
                }
            }
            return;
        }
    }

    public String toString() {
        int i2 = this.f1760i;
        String str = "";
        int i3 = 0;
        while (i2 != -1 && i3 < this.f1752a) {
            str = ((str + " -> ") + this.f1759h[i2] + " : ") + this.f1754c.f1770c[this.f1757f[i2]];
            i2 = this.f1758g[i2];
            i3++;
        }
        return str;
    }
}
