package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConstraintWidgetContainer extends WidgetContainer {
    int A0;
    int B0;
    int C0;
    int D0 = 0;
    int E0 = 0;
    ChainHead[] F0 = new ChainHead[4];
    ChainHead[] G0 = new ChainHead[4];
    public List<ConstraintWidgetGroup> H0 = new ArrayList();
    public boolean I0 = false;
    public boolean J0 = false;
    public boolean K0 = false;
    public int L0 = 0;
    public int M0 = 0;
    private int N0 = 7;
    public boolean O0 = false;
    private boolean P0 = false;
    private boolean Q0 = false;
    int R0 = 0;

    /* renamed from: w0  reason: collision with root package name */
    private boolean f1936w0 = false;

    /* renamed from: x0  reason: collision with root package name */
    protected LinearSystem f1937x0 = new LinearSystem();

    /* renamed from: y0  reason: collision with root package name */
    private Snapshot f1938y0;

    /* renamed from: z0  reason: collision with root package name */
    int f1939z0;

    private void P0(ConstraintWidget constraintWidget) {
        int i2 = this.D0 + 1;
        ChainHead[] chainHeadArr = this.G0;
        if (i2 >= chainHeadArr.length) {
            this.G0 = (ChainHead[]) Arrays.copyOf(chainHeadArr, chainHeadArr.length * 2);
        }
        this.G0[this.D0] = new ChainHead(constraintWidget, 0, U0());
        this.D0++;
    }

    private void Q0(ConstraintWidget constraintWidget) {
        int i2 = this.E0 + 1;
        ChainHead[] chainHeadArr = this.F0;
        if (i2 >= chainHeadArr.length) {
            this.F0 = (ChainHead[]) Arrays.copyOf(chainHeadArr, chainHeadArr.length * 2);
        }
        this.F0[this.E0] = new ChainHead(constraintWidget, 1, U0());
        this.E0++;
    }

    private void b1() {
        this.D0 = 0;
        this.E0 = 0;
    }

    /* JADX WARNING: type inference failed for: r8v17, types: [boolean] */
    /* JADX WARNING: type inference failed for: r8v21 */
    /* JADX WARNING: type inference failed for: r8v22 */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0247  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0258  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0275  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0282  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0287  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0184  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x018f  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01e7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void K0() {
        /*
            r21 = this;
            r1 = r21
            int r2 = r1.K
            int r3 = r1.L
            int r0 = r21.D()
            r4 = 0
            int r5 = java.lang.Math.max(r4, r0)
            int r0 = r21.r()
            int r6 = java.lang.Math.max(r4, r0)
            r1.P0 = r4
            r1.Q0 = r4
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r1.F
            if (r0 == 0) goto L_0x0046
            androidx.constraintlayout.solver.widgets.Snapshot r0 = r1.f1938y0
            if (r0 != 0) goto L_0x002a
            androidx.constraintlayout.solver.widgets.Snapshot r0 = new androidx.constraintlayout.solver.widgets.Snapshot
            r0.<init>(r1)
            r1.f1938y0 = r0
        L_0x002a:
            androidx.constraintlayout.solver.widgets.Snapshot r0 = r1.f1938y0
            r0.b(r1)
            int r0 = r1.f1939z0
            r1.C0(r0)
            int r0 = r1.A0
            r1.D0(r0)
            r21.R()
            androidx.constraintlayout.solver.LinearSystem r0 = r1.f1937x0
            androidx.constraintlayout.solver.Cache r0 = r0.w()
            r1.T(r0)
            goto L_0x004a
        L_0x0046:
            r1.K = r4
            r1.L = r4
        L_0x004a:
            int r0 = r1.N0
            r7 = 32
            r8 = 8
            r9 = 1
            if (r0 == 0) goto L_0x006a
            boolean r0 = r1.X0(r8)
            if (r0 != 0) goto L_0x005c
            r21.Z0()
        L_0x005c:
            boolean r0 = r1.X0(r7)
            if (r0 != 0) goto L_0x0065
            r21.W0()
        L_0x0065:
            androidx.constraintlayout.solver.LinearSystem r0 = r1.f1937x0
            r0.f1779g = r9
            goto L_0x006e
        L_0x006a:
            androidx.constraintlayout.solver.LinearSystem r0 = r1.f1937x0
            r0.f1779g = r4
        L_0x006e:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r1.E
            r10 = r0[r9]
            r11 = r0[r4]
            r21.b1()
            java.util.List<androidx.constraintlayout.solver.widgets.ConstraintWidgetGroup> r0 = r1.H0
            int r0 = r0.size()
            if (r0 != 0) goto L_0x0090
            java.util.List<androidx.constraintlayout.solver.widgets.ConstraintWidgetGroup> r0 = r1.H0
            r0.clear()
            java.util.List<androidx.constraintlayout.solver.widgets.ConstraintWidgetGroup> r0 = r1.H0
            androidx.constraintlayout.solver.widgets.ConstraintWidgetGroup r12 = new androidx.constraintlayout.solver.widgets.ConstraintWidgetGroup
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.ConstraintWidget> r13 = r1.f1986v0
            r12.<init>(r13)
            r0.add(r4, r12)
        L_0x0090:
            java.util.List<androidx.constraintlayout.solver.widgets.ConstraintWidgetGroup> r0 = r1.H0
            int r12 = r0.size()
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.ConstraintWidget> r13 = r1.f1986v0
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r0 = r21.s()
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r14 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r0 == r14) goto L_0x00a9
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r0 = r21.B()
            if (r0 != r14) goto L_0x00a7
            goto L_0x00a9
        L_0x00a7:
            r14 = 0
            goto L_0x00aa
        L_0x00a9:
            r14 = 1
        L_0x00aa:
            r0 = 0
            r15 = 0
        L_0x00ac:
            if (r15 >= r12) goto L_0x02ec
            boolean r8 = r1.O0
            if (r8 != 0) goto L_0x02ec
            java.util.List<androidx.constraintlayout.solver.widgets.ConstraintWidgetGroup> r8 = r1.H0
            java.lang.Object r8 = r8.get(r15)
            androidx.constraintlayout.solver.widgets.ConstraintWidgetGroup r8 = (androidx.constraintlayout.solver.widgets.ConstraintWidgetGroup) r8
            boolean r8 = r8.f1943d
            if (r8 == 0) goto L_0x00c4
            r20 = r3
            r19 = r12
            goto L_0x02de
        L_0x00c4:
            boolean r8 = r1.X0(r7)
            if (r8 == 0) goto L_0x00f7
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r8 = r21.s()
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r7 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r8 != r7) goto L_0x00e9
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r8 = r21.B()
            if (r8 != r7) goto L_0x00e9
            java.util.List<androidx.constraintlayout.solver.widgets.ConstraintWidgetGroup> r7 = r1.H0
            java.lang.Object r7 = r7.get(r15)
            androidx.constraintlayout.solver.widgets.ConstraintWidgetGroup r7 = (androidx.constraintlayout.solver.widgets.ConstraintWidgetGroup) r7
            java.util.List r7 = r7.d()
            java.util.ArrayList r7 = (java.util.ArrayList) r7
            r1.f1986v0 = r7
            goto L_0x00f7
        L_0x00e9:
            java.util.List<androidx.constraintlayout.solver.widgets.ConstraintWidgetGroup> r7 = r1.H0
            java.lang.Object r7 = r7.get(r15)
            androidx.constraintlayout.solver.widgets.ConstraintWidgetGroup r7 = (androidx.constraintlayout.solver.widgets.ConstraintWidgetGroup) r7
            java.util.List<androidx.constraintlayout.solver.widgets.ConstraintWidget> r7 = r7.f1940a
            java.util.ArrayList r7 = (java.util.ArrayList) r7
            r1.f1986v0 = r7
        L_0x00f7:
            r21.b1()
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.ConstraintWidget> r7 = r1.f1986v0
            int r7 = r7.size()
            r8 = 0
        L_0x0101:
            if (r8 >= r7) goto L_0x0119
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.ConstraintWidget> r4 = r1.f1986v0
            java.lang.Object r4 = r4.get(r8)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r4 = (androidx.constraintlayout.solver.widgets.ConstraintWidget) r4
            boolean r9 = r4 instanceof androidx.constraintlayout.solver.widgets.WidgetContainer
            if (r9 == 0) goto L_0x0114
            androidx.constraintlayout.solver.widgets.WidgetContainer r4 = (androidx.constraintlayout.solver.widgets.WidgetContainer) r4
            r4.K0()
        L_0x0114:
            int r8 = r8 + 1
            r4 = 0
            r9 = 1
            goto L_0x0101
        L_0x0119:
            r4 = r0
            r0 = 0
            r8 = 1
        L_0x011c:
            if (r8 == 0) goto L_0x02cb
            r17 = r4
            r9 = 1
            int r4 = r0 + 1
            androidx.constraintlayout.solver.LinearSystem r0 = r1.f1937x0     // Catch:{ Exception -> 0x0160 }
            r0.E()     // Catch:{ Exception -> 0x0160 }
            r21.b1()     // Catch:{ Exception -> 0x0160 }
            androidx.constraintlayout.solver.LinearSystem r0 = r1.f1937x0     // Catch:{ Exception -> 0x0160 }
            r1.g(r0)     // Catch:{ Exception -> 0x0160 }
            r0 = 0
        L_0x0131:
            if (r0 >= r7) goto L_0x0147
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.ConstraintWidget> r9 = r1.f1986v0     // Catch:{ Exception -> 0x0160 }
            java.lang.Object r9 = r9.get(r0)     // Catch:{ Exception -> 0x0160 }
            androidx.constraintlayout.solver.widgets.ConstraintWidget r9 = (androidx.constraintlayout.solver.widgets.ConstraintWidget) r9     // Catch:{ Exception -> 0x0160 }
            r18 = r8
            androidx.constraintlayout.solver.LinearSystem r8 = r1.f1937x0     // Catch:{ Exception -> 0x015c }
            r9.g(r8)     // Catch:{ Exception -> 0x015c }
            int r0 = r0 + 1
            r8 = r18
            goto L_0x0131
        L_0x0147:
            r18 = r8
            androidx.constraintlayout.solver.LinearSystem r0 = r1.f1937x0     // Catch:{ Exception -> 0x015c }
            boolean r8 = r1.O0(r0)     // Catch:{ Exception -> 0x015c }
            if (r8 == 0) goto L_0x0159
            androidx.constraintlayout.solver.LinearSystem r0 = r1.f1937x0     // Catch:{ Exception -> 0x0157 }
            r0.A()     // Catch:{ Exception -> 0x0157 }
            goto L_0x0159
        L_0x0157:
            r0 = move-exception
            goto L_0x0163
        L_0x0159:
            r19 = r12
            goto L_0x0182
        L_0x015c:
            r0 = move-exception
            r8 = r18
            goto L_0x0163
        L_0x0160:
            r0 = move-exception
            r18 = r8
        L_0x0163:
            r0.printStackTrace()
            java.io.PrintStream r9 = java.lang.System.out
            r18 = r8
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r19 = r12
            java.lang.String r12 = "EXCEPTION : "
            r8.append(r12)
            r8.append(r0)
            java.lang.String r0 = r8.toString()
            r9.println(r0)
            r8 = r18
        L_0x0182:
            if (r8 == 0) goto L_0x018f
            androidx.constraintlayout.solver.LinearSystem r8 = r1.f1937x0
            boolean[] r9 = androidx.constraintlayout.solver.widgets.Optimizer.f1959a
            r1.f1(r8, r9)
        L_0x018b:
            r20 = r3
            r3 = 2
            goto L_0x01db
        L_0x018f:
            androidx.constraintlayout.solver.LinearSystem r8 = r1.f1937x0
            r1.G0(r8)
            r8 = 0
        L_0x0195:
            if (r8 >= r7) goto L_0x018b
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.ConstraintWidget> r9 = r1.f1986v0
            java.lang.Object r9 = r9.get(r8)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r9 = (androidx.constraintlayout.solver.widgets.ConstraintWidget) r9
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r12 = r9.E
            r16 = 0
            r12 = r12[r16]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r0 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r12 != r0) goto L_0x01bc
            int r12 = r9.D()
            r20 = r3
            int r3 = r9.F()
            if (r12 >= r3) goto L_0x01be
            boolean[] r0 = androidx.constraintlayout.solver.widgets.Optimizer.f1959a
            r3 = 2
            r12 = 1
            r0[r3] = r12
            goto L_0x01db
        L_0x01bc:
            r20 = r3
        L_0x01be:
            r12 = 1
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r3 = r9.E
            r3 = r3[r12]
            if (r3 != r0) goto L_0x01d5
            int r0 = r9.r()
            int r3 = r9.E()
            if (r0 >= r3) goto L_0x01d5
            boolean[] r0 = androidx.constraintlayout.solver.widgets.Optimizer.f1959a
            r3 = 2
            r0[r3] = r12
            goto L_0x01db
        L_0x01d5:
            r3 = 2
            int r8 = r8 + 1
            r3 = r20
            goto L_0x0195
        L_0x01db:
            if (r14 == 0) goto L_0x0247
            r8 = 8
            if (r4 >= r8) goto L_0x0247
            boolean[] r0 = androidx.constraintlayout.solver.widgets.Optimizer.f1959a
            boolean r0 = r0[r3]
            if (r0 == 0) goto L_0x0247
            r0 = 0
            r3 = 0
            r9 = 0
        L_0x01ea:
            if (r0 >= r7) goto L_0x0210
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.ConstraintWidget> r12 = r1.f1986v0
            java.lang.Object r12 = r12.get(r0)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r12 = (androidx.constraintlayout.solver.widgets.ConstraintWidget) r12
            int r8 = r12.K
            int r18 = r12.D()
            int r8 = r8 + r18
            int r3 = java.lang.Math.max(r3, r8)
            int r8 = r12.L
            int r12 = r12.r()
            int r8 = r8 + r12
            int r9 = java.lang.Math.max(r9, r8)
            int r0 = r0 + 1
            r8 = 8
            goto L_0x01ea
        L_0x0210:
            int r0 = r1.V
            int r0 = java.lang.Math.max(r0, r3)
            int r3 = r1.W
            int r3 = java.lang.Math.max(r3, r9)
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r8 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r11 != r8) goto L_0x0232
            int r9 = r21.D()
            if (r9 >= r0) goto L_0x0232
            r1.y0(r0)
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r1.E
            r9 = 0
            r0[r9] = r8
            r0 = 1
            r17 = 1
            goto L_0x0233
        L_0x0232:
            r0 = 0
        L_0x0233:
            if (r10 != r8) goto L_0x0248
            int r9 = r21.r()
            if (r9 >= r3) goto L_0x0248
            r1.b0(r3)
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r1.E
            r3 = 1
            r0[r3] = r8
            r0 = 1
            r17 = 1
            goto L_0x0248
        L_0x0247:
            r0 = 0
        L_0x0248:
            int r3 = r1.V
            int r8 = r21.D()
            int r3 = java.lang.Math.max(r3, r8)
            int r8 = r21.D()
            if (r3 <= r8) goto L_0x0265
            r1.y0(r3)
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r1.E
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r8 = 0
            r0[r8] = r3
            r0 = 1
            r17 = 1
        L_0x0265:
            int r3 = r1.W
            int r8 = r21.r()
            int r3 = java.lang.Math.max(r3, r8)
            int r8 = r21.r()
            if (r3 <= r8) goto L_0x0282
            r1.b0(r3)
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r1.E
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r8 = 1
            r0[r8] = r3
            r0 = 1
            r9 = 1
            goto L_0x0285
        L_0x0282:
            r8 = 1
            r9 = r17
        L_0x0285:
            if (r9 != 0) goto L_0x02c2
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r3 = r1.E
            r12 = 0
            r3 = r3[r12]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r12 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r3 != r12) goto L_0x02a6
            if (r5 <= 0) goto L_0x02a6
            int r3 = r21.D()
            if (r3 <= r5) goto L_0x02a6
            r1.P0 = r8
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r1.E
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r9 = 0
            r0[r9] = r3
            r1.y0(r5)
            r0 = 1
            r9 = 1
        L_0x02a6:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r3 = r1.E
            r3 = r3[r8]
            if (r3 != r12) goto L_0x02c2
            if (r6 <= 0) goto L_0x02c2
            int r3 = r21.r()
            if (r3 <= r6) goto L_0x02c2
            r1.Q0 = r8
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r1.E
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r0[r8] = r3
            r1.b0(r6)
            r8 = 1
            r9 = 1
            goto L_0x02c3
        L_0x02c2:
            r8 = r0
        L_0x02c3:
            r0 = r4
            r4 = r9
            r12 = r19
            r3 = r20
            goto L_0x011c
        L_0x02cb:
            r20 = r3
            r17 = r4
            r19 = r12
            java.util.List<androidx.constraintlayout.solver.widgets.ConstraintWidgetGroup> r0 = r1.H0
            java.lang.Object r0 = r0.get(r15)
            androidx.constraintlayout.solver.widgets.ConstraintWidgetGroup r0 = (androidx.constraintlayout.solver.widgets.ConstraintWidgetGroup) r0
            r0.g()
            r0 = r17
        L_0x02de:
            int r15 = r15 + 1
            r12 = r19
            r3 = r20
            r4 = 0
            r7 = 32
            r8 = 8
            r9 = 1
            goto L_0x00ac
        L_0x02ec:
            r20 = r3
            r1.f1986v0 = r13
            androidx.constraintlayout.solver.widgets.ConstraintWidget r3 = r1.F
            if (r3 == 0) goto L_0x0320
            int r2 = r1.V
            int r3 = r21.D()
            int r2 = java.lang.Math.max(r2, r3)
            int r3 = r1.W
            int r4 = r21.r()
            int r3 = java.lang.Math.max(r3, r4)
            androidx.constraintlayout.solver.widgets.Snapshot r4 = r1.f1938y0
            r4.a(r1)
            int r4 = r1.f1939z0
            int r2 = r2 + r4
            int r4 = r1.B0
            int r2 = r2 + r4
            r1.y0(r2)
            int r2 = r1.A0
            int r3 = r3 + r2
            int r2 = r1.C0
            int r3 = r3 + r2
            r1.b0(r3)
            goto L_0x0326
        L_0x0320:
            r1.K = r2
            r2 = r20
            r1.L = r2
        L_0x0326:
            if (r0 == 0) goto L_0x0330
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r1.E
            r2 = 0
            r0[r2] = r11
            r2 = 1
            r0[r2] = r10
        L_0x0330:
            androidx.constraintlayout.solver.LinearSystem r0 = r1.f1937x0
            androidx.constraintlayout.solver.Cache r0 = r0.w()
            r1.T(r0)
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r0 = r21.J0()
            if (r1 != r0) goto L_0x0342
            r21.F0()
        L_0x0342:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer.K0():void");
    }

    /* access modifiers changed from: package-private */
    public void N0(ConstraintWidget constraintWidget, int i2) {
        if (i2 == 0) {
            P0(constraintWidget);
        } else if (i2 == 1) {
            Q0(constraintWidget);
        }
    }

    public boolean O0(LinearSystem linearSystem) {
        b(linearSystem);
        int size = this.f1986v0.size();
        for (int i2 = 0; i2 < size; i2++) {
            ConstraintWidget constraintWidget = this.f1986v0.get(i2);
            if (constraintWidget instanceof ConstraintWidgetContainer) {
                ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget.E;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[1];
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                if (dimensionBehaviour == dimensionBehaviour3) {
                    constraintWidget.g0(ConstraintWidget.DimensionBehaviour.FIXED);
                }
                if (dimensionBehaviour2 == dimensionBehaviour3) {
                    constraintWidget.u0(ConstraintWidget.DimensionBehaviour.FIXED);
                }
                constraintWidget.b(linearSystem);
                if (dimensionBehaviour == dimensionBehaviour3) {
                    constraintWidget.g0(dimensionBehaviour);
                }
                if (dimensionBehaviour2 == dimensionBehaviour3) {
                    constraintWidget.u0(dimensionBehaviour2);
                }
            } else {
                Optimizer.c(this, linearSystem, constraintWidget);
                constraintWidget.b(linearSystem);
            }
        }
        if (this.D0 > 0) {
            Chain.a(this, linearSystem, 0);
        }
        if (this.E0 > 0) {
            Chain.a(this, linearSystem, 1);
        }
        return true;
    }

    public void Q() {
        this.f1937x0.E();
        this.f1939z0 = 0;
        this.B0 = 0;
        this.A0 = 0;
        this.C0 = 0;
        this.H0.clear();
        this.O0 = false;
        super.Q();
    }

    public int R0() {
        return this.N0;
    }

    public boolean S0() {
        return false;
    }

    public boolean T0() {
        return this.Q0;
    }

    public boolean U0() {
        return this.f1936w0;
    }

    public boolean V0() {
        return this.P0;
    }

    public void W0() {
        if (!X0(8)) {
            d(this.N0);
        }
        e1();
    }

    public boolean X0(int i2) {
        return (this.N0 & i2) == i2;
    }

    public void Y0(int i2, int i3) {
        ResolutionDimension resolutionDimension;
        ResolutionDimension resolutionDimension2;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = this.E[0];
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (!(dimensionBehaviour == dimensionBehaviour2 || (resolutionDimension2 = this.f1887c) == null)) {
            resolutionDimension2.h(i2);
        }
        if (this.E[1] != dimensionBehaviour2 && (resolutionDimension = this.f1889d) != null) {
            resolutionDimension.h(i3);
        }
    }

    public void Z0() {
        int size = this.f1986v0.size();
        S();
        for (int i2 = 0; i2 < size; i2++) {
            this.f1986v0.get(i2).S();
        }
    }

    public void a1() {
        Z0();
        d(this.N0);
    }

    public void c1(int i2) {
        this.N0 = i2;
    }

    public void d(int i2) {
        super.d(i2);
        int size = this.f1986v0.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.f1986v0.get(i3).d(i2);
        }
    }

    public void d1(boolean z2) {
        this.f1936w0 = z2;
    }

    public void e1() {
        ResolutionAnchor f2 = h(ConstraintAnchor.Type.LEFT).f();
        ResolutionAnchor f3 = h(ConstraintAnchor.Type.TOP).f();
        f2.l((ResolutionAnchor) null, 0.0f);
        f3.l((ResolutionAnchor) null, 0.0f);
    }

    public void f1(LinearSystem linearSystem, boolean[] zArr) {
        zArr[2] = false;
        G0(linearSystem);
        int size = this.f1986v0.size();
        for (int i2 = 0; i2 < size; i2++) {
            ConstraintWidget constraintWidget = this.f1986v0.get(i2);
            constraintWidget.G0(linearSystem);
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = constraintWidget.E[0];
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
            if (dimensionBehaviour == dimensionBehaviour2 && constraintWidget.D() < constraintWidget.F()) {
                zArr[2] = true;
            }
            if (constraintWidget.E[1] == dimensionBehaviour2 && constraintWidget.r() < constraintWidget.E()) {
                zArr[2] = true;
            }
        }
    }
}
