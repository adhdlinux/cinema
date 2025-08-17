package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.Cache;
import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import java.util.ArrayList;

public class ConstraintWidget {

    /* renamed from: u0  reason: collision with root package name */
    public static float f1882u0 = 0.5f;
    ConstraintAnchor A = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
    ConstraintAnchor B;
    protected ConstraintAnchor[] C;
    protected ArrayList<ConstraintAnchor> D;
    protected DimensionBehaviour[] E;
    ConstraintWidget F;
    int G;
    int H;
    protected float I;
    protected int J;
    protected int K;
    protected int L;
    int M;
    int N;
    private int O;
    private int P;
    private int Q;
    private int R;
    protected int S;
    protected int T;
    int U;
    protected int V;
    protected int W;
    private int X;
    private int Y;
    float Z;

    /* renamed from: a  reason: collision with root package name */
    public int f1883a = -1;

    /* renamed from: a0  reason: collision with root package name */
    float f1884a0;

    /* renamed from: b  reason: collision with root package name */
    public int f1885b = -1;

    /* renamed from: b0  reason: collision with root package name */
    private Object f1886b0;

    /* renamed from: c  reason: collision with root package name */
    ResolutionDimension f1887c;

    /* renamed from: c0  reason: collision with root package name */
    private int f1888c0;

    /* renamed from: d  reason: collision with root package name */
    ResolutionDimension f1889d;

    /* renamed from: d0  reason: collision with root package name */
    private int f1890d0;

    /* renamed from: e  reason: collision with root package name */
    int f1891e = 0;

    /* renamed from: e0  reason: collision with root package name */
    private String f1892e0;

    /* renamed from: f  reason: collision with root package name */
    int f1893f = 0;

    /* renamed from: f0  reason: collision with root package name */
    private String f1894f0;

    /* renamed from: g  reason: collision with root package name */
    int[] f1895g = new int[2];

    /* renamed from: g0  reason: collision with root package name */
    boolean f1896g0;

    /* renamed from: h  reason: collision with root package name */
    int f1897h = 0;

    /* renamed from: h0  reason: collision with root package name */
    boolean f1898h0;

    /* renamed from: i  reason: collision with root package name */
    int f1899i = 0;

    /* renamed from: i0  reason: collision with root package name */
    boolean f1900i0;

    /* renamed from: j  reason: collision with root package name */
    float f1901j = 1.0f;

    /* renamed from: j0  reason: collision with root package name */
    boolean f1902j0;

    /* renamed from: k  reason: collision with root package name */
    int f1903k = 0;

    /* renamed from: k0  reason: collision with root package name */
    boolean f1904k0;

    /* renamed from: l  reason: collision with root package name */
    int f1905l = 0;

    /* renamed from: l0  reason: collision with root package name */
    int f1906l0;

    /* renamed from: m  reason: collision with root package name */
    float f1907m = 1.0f;

    /* renamed from: m0  reason: collision with root package name */
    int f1908m0;

    /* renamed from: n  reason: collision with root package name */
    boolean f1909n;

    /* renamed from: n0  reason: collision with root package name */
    boolean f1910n0;

    /* renamed from: o  reason: collision with root package name */
    boolean f1911o;

    /* renamed from: o0  reason: collision with root package name */
    boolean f1912o0;

    /* renamed from: p  reason: collision with root package name */
    int f1913p = -1;

    /* renamed from: p0  reason: collision with root package name */
    float[] f1914p0;

    /* renamed from: q  reason: collision with root package name */
    float f1915q = 1.0f;

    /* renamed from: q0  reason: collision with root package name */
    protected ConstraintWidget[] f1916q0;

    /* renamed from: r  reason: collision with root package name */
    ConstraintWidgetGroup f1917r = null;

    /* renamed from: r0  reason: collision with root package name */
    protected ConstraintWidget[] f1918r0;

    /* renamed from: s  reason: collision with root package name */
    private int[] f1919s = {Integer.MAX_VALUE, Integer.MAX_VALUE};

    /* renamed from: s0  reason: collision with root package name */
    ConstraintWidget f1920s0;

    /* renamed from: t  reason: collision with root package name */
    private float f1921t = 0.0f;

    /* renamed from: t0  reason: collision with root package name */
    ConstraintWidget f1922t0;

    /* renamed from: u  reason: collision with root package name */
    ConstraintAnchor f1923u = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);

    /* renamed from: v  reason: collision with root package name */
    ConstraintAnchor f1924v = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);

    /* renamed from: w  reason: collision with root package name */
    ConstraintAnchor f1925w = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);

    /* renamed from: x  reason: collision with root package name */
    ConstraintAnchor f1926x = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);

    /* renamed from: y  reason: collision with root package name */
    ConstraintAnchor f1927y = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);

    /* renamed from: z  reason: collision with root package name */
    ConstraintAnchor f1928z = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);

    /* renamed from: androidx.constraintlayout.solver.widgets.ConstraintWidget$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f1929a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f1930b;

        /* JADX WARNING: Can't wrap try/catch for region: R(29:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Can't wrap try/catch for region: R(31:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Can't wrap try/catch for region: R(32:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0044 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x004e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0058 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0062 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x006d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0083 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x008f */
        static {
            /*
                androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r0 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f1930b = r0
                r1 = 1
                androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r2 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f1930b     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f1930b     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = f1930b     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r5 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type[] r4 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                f1929a = r4
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r5 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                int[] r1 = f1929a     // Catch:{ NoSuchFieldError -> 0x004e }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP     // Catch:{ NoSuchFieldError -> 0x004e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r1[r4] = r0     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                int[] r0 = f1929a     // Catch:{ NoSuchFieldError -> 0x0058 }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT     // Catch:{ NoSuchFieldError -> 0x0058 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0058 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                int[] r0 = f1929a     // Catch:{ NoSuchFieldError -> 0x0062 }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM     // Catch:{ NoSuchFieldError -> 0x0062 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0062 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0062 }
            L_0x0062:
                int[] r0 = f1929a     // Catch:{ NoSuchFieldError -> 0x006d }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BASELINE     // Catch:{ NoSuchFieldError -> 0x006d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006d }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006d }
            L_0x006d:
                int[] r0 = f1929a     // Catch:{ NoSuchFieldError -> 0x0078 }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.CENTER     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f1929a     // Catch:{ NoSuchFieldError -> 0x0083 }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.CENTER_X     // Catch:{ NoSuchFieldError -> 0x0083 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0083 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0083 }
            L_0x0083:
                int[] r0 = f1929a     // Catch:{ NoSuchFieldError -> 0x008f }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.CENTER_Y     // Catch:{ NoSuchFieldError -> 0x008f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x008f }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x008f }
            L_0x008f:
                int[] r0 = f1929a     // Catch:{ NoSuchFieldError -> 0x009b }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.NONE     // Catch:{ NoSuchFieldError -> 0x009b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009b }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009b }
            L_0x009b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.ConstraintWidget.AnonymousClass1.<clinit>():void");
        }
    }

    public enum DimensionBehaviour {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public ConstraintWidget() {
        ConstraintAnchor constraintAnchor = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.B = constraintAnchor;
        this.C = new ConstraintAnchor[]{this.f1923u, this.f1925w, this.f1924v, this.f1926x, this.f1927y, constraintAnchor};
        this.D = new ArrayList<>();
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        this.E = new DimensionBehaviour[]{dimensionBehaviour, dimensionBehaviour};
        this.F = null;
        this.G = 0;
        this.H = 0;
        this.I = 0.0f;
        this.J = -1;
        this.K = 0;
        this.L = 0;
        this.M = 0;
        this.N = 0;
        this.O = 0;
        this.P = 0;
        this.Q = 0;
        this.R = 0;
        this.S = 0;
        this.T = 0;
        this.U = 0;
        float f2 = f1882u0;
        this.Z = f2;
        this.f1884a0 = f2;
        this.f1888c0 = 0;
        this.f1890d0 = 0;
        this.f1892e0 = null;
        this.f1894f0 = null;
        this.f1900i0 = false;
        this.f1902j0 = false;
        this.f1904k0 = false;
        this.f1906l0 = 0;
        this.f1908m0 = 0;
        this.f1914p0 = new float[]{-1.0f, -1.0f};
        this.f1916q0 = new ConstraintWidget[]{null, null};
        this.f1918r0 = new ConstraintWidget[]{null, null};
        this.f1920s0 = null;
        this.f1922t0 = null;
        a();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000e, code lost:
        r4 = r0[r4 + 1];
        r0 = r4.f1857d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean K(int r4) {
        /*
            r3 = this;
            int r4 = r4 * 2
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r3.C
            r1 = r0[r4]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r1.f1857d
            if (r2 == 0) goto L_0x001b
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r2.f1857d
            if (r2 == r1) goto L_0x001b
            r1 = 1
            int r4 = r4 + r1
            r4 = r0[r4]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r4.f1857d
            if (r0 == 0) goto L_0x001b
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r0.f1857d
            if (r0 != r4) goto L_0x001b
            goto L_0x001c
        L_0x001b:
            r1 = 0
        L_0x001c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.ConstraintWidget.K(int):boolean");
    }

    private void a() {
        this.D.add(this.f1923u);
        this.D.add(this.f1924v);
        this.D.add(this.f1925w);
        this.D.add(this.f1926x);
        this.D.add(this.f1928z);
        this.D.add(this.A);
        this.D.add(this.B);
        this.D.add(this.f1927y);
    }

    /* JADX WARNING: Removed duplicated region for block: B:152:0x028d  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x02d1  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x02e0  */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x0301  */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x030a  */
    /* JADX WARNING: Removed duplicated region for block: B:185:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x01c9 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void e(androidx.constraintlayout.solver.LinearSystem r26, boolean r27, androidx.constraintlayout.solver.SolverVariable r28, androidx.constraintlayout.solver.SolverVariable r29, androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour r30, boolean r31, androidx.constraintlayout.solver.widgets.ConstraintAnchor r32, androidx.constraintlayout.solver.widgets.ConstraintAnchor r33, int r34, int r35, int r36, int r37, float r38, boolean r39, boolean r40, int r41, int r42, int r43, float r44, boolean r45) {
        /*
            r25 = this;
            r0 = r25
            r10 = r26
            r11 = r28
            r12 = r29
            r13 = r32
            r14 = r33
            r1 = r36
            r2 = r37
            androidx.constraintlayout.solver.SolverVariable r15 = r10.r(r13)
            androidx.constraintlayout.solver.SolverVariable r9 = r10.r(r14)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r32.i()
            androidx.constraintlayout.solver.SolverVariable r8 = r10.r(r3)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r33.i()
            androidx.constraintlayout.solver.SolverVariable r7 = r10.r(r3)
            boolean r3 = r10.f1779g
            r6 = 1
            r4 = 0
            r5 = 6
            if (r3 == 0) goto L_0x0066
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r3 = r32.f()
            int r3 = r3.f1975b
            if (r3 != r6) goto L_0x0066
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r3 = r33.f()
            int r3 = r3.f1975b
            if (r3 != r6) goto L_0x0066
            androidx.constraintlayout.solver.Metrics r1 = androidx.constraintlayout.solver.LinearSystem.x()
            if (r1 == 0) goto L_0x0050
            androidx.constraintlayout.solver.Metrics r1 = androidx.constraintlayout.solver.LinearSystem.x()
            long r2 = r1.f1807s
            r6 = 1
            long r2 = r2 + r6
            r1.f1807s = r2
        L_0x0050:
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r1 = r32.f()
            r1.g(r10)
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r1 = r33.f()
            r1.g(r10)
            if (r40 != 0) goto L_0x0065
            if (r27 == 0) goto L_0x0065
            r10.i(r12, r9, r4, r5)
        L_0x0065:
            return
        L_0x0066:
            androidx.constraintlayout.solver.Metrics r3 = androidx.constraintlayout.solver.LinearSystem.x()
            if (r3 == 0) goto L_0x0078
            androidx.constraintlayout.solver.Metrics r3 = androidx.constraintlayout.solver.LinearSystem.x()
            long r4 = r3.B
            r16 = 1
            long r4 = r4 + r16
            r3.B = r4
        L_0x0078:
            boolean r16 = r32.k()
            boolean r17 = r33.k()
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r0.B
            boolean r20 = r3.k()
            if (r17 == 0) goto L_0x008b
            int r3 = r16 + 1
            goto L_0x008d
        L_0x008b:
            r3 = r16
        L_0x008d:
            if (r20 == 0) goto L_0x0091
            int r3 = r3 + 1
        L_0x0091:
            r5 = r3
            if (r39 == 0) goto L_0x0096
            r3 = 3
            goto L_0x0098
        L_0x0096:
            r3 = r41
        L_0x0098:
            int[] r21 = androidx.constraintlayout.solver.widgets.ConstraintWidget.AnonymousClass1.f1930b
            int r22 = r30.ordinal()
            r4 = r21[r22]
            r14 = 2
            r13 = 4
            if (r4 == r6) goto L_0x00ab
            if (r4 == r14) goto L_0x00ab
            r14 = 3
            if (r4 == r14) goto L_0x00ab
            if (r4 == r13) goto L_0x00ad
        L_0x00ab:
            r4 = 0
            goto L_0x00b1
        L_0x00ad:
            if (r3 != r13) goto L_0x00b0
            goto L_0x00ab
        L_0x00b0:
            r4 = 1
        L_0x00b1:
            int r14 = r0.f1890d0
            r13 = 8
            if (r14 != r13) goto L_0x00ba
            r4 = 0
            r13 = 0
            goto L_0x00bd
        L_0x00ba:
            r13 = r4
            r4 = r35
        L_0x00bd:
            if (r45 == 0) goto L_0x00d8
            if (r16 != 0) goto L_0x00cb
            if (r17 != 0) goto L_0x00cb
            if (r20 != 0) goto L_0x00cb
            r14 = r34
            r10.f(r15, r14)
            goto L_0x00d8
        L_0x00cb:
            if (r16 == 0) goto L_0x00d8
            if (r17 != 0) goto L_0x00d8
            int r14 = r32.d()
            r6 = 6
            r10.e(r15, r8, r14, r6)
            goto L_0x00d9
        L_0x00d8:
            r6 = 6
        L_0x00d9:
            if (r13 != 0) goto L_0x0105
            if (r31 == 0) goto L_0x00f2
            r6 = 0
            r14 = 3
            r10.e(r9, r15, r6, r14)
            r4 = 6
            if (r1 <= 0) goto L_0x00e8
            r10.i(r9, r15, r1, r4)
        L_0x00e8:
            r6 = 2147483647(0x7fffffff, float:NaN)
            if (r2 >= r6) goto L_0x00f0
            r10.k(r9, r15, r2, r4)
        L_0x00f0:
            r6 = 6
            goto L_0x00f6
        L_0x00f2:
            r14 = 3
            r10.e(r9, r15, r4, r6)
        L_0x00f6:
            r14 = r42
            r31 = r3
            r0 = r5
            r1 = r7
            r22 = r8
            r23 = r13
            r2 = 2
            r13 = r43
            goto L_0x01e0
        L_0x0105:
            r14 = 3
            r2 = -2
            r14 = r42
            r6 = r43
            if (r14 != r2) goto L_0x010e
            r14 = r4
        L_0x010e:
            if (r6 != r2) goto L_0x0111
            r6 = r4
        L_0x0111:
            r2 = 6
            if (r14 <= 0) goto L_0x011b
            r10.i(r9, r15, r14, r2)
            int r4 = java.lang.Math.max(r4, r14)
        L_0x011b:
            if (r6 <= 0) goto L_0x0124
            r10.k(r9, r15, r6, r2)
            int r4 = java.lang.Math.min(r4, r6)
        L_0x0124:
            r2 = 1
            if (r3 != r2) goto L_0x014d
            if (r27 == 0) goto L_0x0139
            r2 = 6
            r10.e(r9, r15, r4, r2)
            r31 = r3
            r0 = r5
            r1 = r7
            r22 = r8
            r35 = r13
            r8 = r4
            r13 = r6
            goto L_0x01c4
        L_0x0139:
            r2 = 6
            if (r40 == 0) goto L_0x0144
            r35 = r13
            r13 = 4
            r10.e(r9, r15, r4, r13)
            goto L_0x01bc
        L_0x0144:
            r35 = r13
            r2 = 1
            r13 = 4
            r10.e(r9, r15, r4, r2)
            goto L_0x01bc
        L_0x014d:
            r35 = r13
            r2 = 2
            r13 = 4
            if (r3 != r2) goto L_0x01bc
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r2 = r32.j()
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r13 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP
            if (r2 == r13) goto L_0x017f
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r2 = r32.j()
            r22 = r3
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r3 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM
            if (r2 != r3) goto L_0x0166
            goto L_0x0181
        L_0x0166:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r2 = r0.F
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r3 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r2.h(r3)
            androidx.constraintlayout.solver.SolverVariable r2 = r10.r(r2)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r3 = r0.F
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r13 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.h(r13)
            androidx.constraintlayout.solver.SolverVariable r3 = r10.r(r3)
            goto L_0x0197
        L_0x017f:
            r22 = r3
        L_0x0181:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r2 = r0.F
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r2.h(r13)
            androidx.constraintlayout.solver.SolverVariable r2 = r10.r(r2)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r3 = r0.F
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r13 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.h(r13)
            androidx.constraintlayout.solver.SolverVariable r3 = r10.r(r3)
        L_0x0197:
            r24 = r2
            r13 = r3
            androidx.constraintlayout.solver.ArrayRow r2 = r26.s()
            r19 = 1
            r21 = 6
            r0 = r22
            r3 = r9
            r22 = r8
            r8 = r4
            r4 = r15
            r31 = r0
            r0 = r5
            r5 = r13
            r13 = r6
            r6 = r24
            r1 = r7
            r7 = r44
            androidx.constraintlayout.solver.ArrayRow r2 = r2.j(r3, r4, r5, r6, r7)
            r10.d(r2)
            r4 = 0
            goto L_0x01c6
        L_0x01bc:
            r31 = r3
            r0 = r5
            r13 = r6
            r1 = r7
            r22 = r8
            r8 = r4
        L_0x01c4:
            r4 = r35
        L_0x01c6:
            r2 = 2
            if (r4 == 0) goto L_0x01de
            if (r0 == r2) goto L_0x01de
            if (r39 != 0) goto L_0x01de
            int r3 = java.lang.Math.max(r14, r8)
            if (r13 <= 0) goto L_0x01d7
            int r3 = java.lang.Math.min(r13, r3)
        L_0x01d7:
            r4 = 6
            r10.e(r9, r15, r3, r4)
            r23 = 0
            goto L_0x01e0
        L_0x01de:
            r23 = r4
        L_0x01e0:
            if (r45 == 0) goto L_0x0311
            if (r40 == 0) goto L_0x01e6
            goto L_0x0311
        L_0x01e6:
            r0 = 5
            if (r16 != 0) goto L_0x01f5
            if (r17 != 0) goto L_0x01f5
            if (r20 != 0) goto L_0x01f5
            if (r27 == 0) goto L_0x0305
            r8 = 0
            r10.i(r12, r9, r8, r0)
            goto L_0x0305
        L_0x01f5:
            r8 = 0
            if (r16 == 0) goto L_0x0201
            if (r17 != 0) goto L_0x0201
            if (r27 == 0) goto L_0x0305
            r10.i(r12, r9, r8, r0)
            goto L_0x0305
        L_0x0201:
            if (r16 != 0) goto L_0x0215
            if (r17 == 0) goto L_0x0215
            int r2 = r33.d()
            int r2 = -r2
            r3 = 6
            r10.e(r9, r1, r2, r3)
            if (r27 == 0) goto L_0x0305
            r10.i(r15, r11, r8, r0)
            goto L_0x0305
        L_0x0215:
            if (r16 == 0) goto L_0x0305
            if (r17 == 0) goto L_0x0305
            if (r23 == 0) goto L_0x0281
            r7 = r1
            if (r27 == 0) goto L_0x0224
            if (r36 != 0) goto L_0x0224
            r1 = 6
            r10.i(r9, r15, r8, r1)
        L_0x0224:
            if (r31 != 0) goto L_0x024e
            if (r13 > 0) goto L_0x022e
            if (r14 <= 0) goto L_0x022b
            goto L_0x022e
        L_0x022b:
            r5 = 6
            r6 = 0
            goto L_0x0230
        L_0x022e:
            r5 = 4
            r6 = 1
        L_0x0230:
            int r1 = r32.d()
            r4 = r22
            r10.e(r15, r4, r1, r5)
            int r1 = r33.d()
            int r1 = -r1
            r10.e(r9, r7, r1, r5)
            if (r13 > 0) goto L_0x0248
            if (r14 <= 0) goto L_0x0246
            goto L_0x0248
        L_0x0246:
            r1 = 0
            goto L_0x0249
        L_0x0248:
            r1 = 1
        L_0x0249:
            r13 = r6
            r14 = 1
            r16 = 5
            goto L_0x0259
        L_0x024e:
            r1 = r31
            r4 = r22
            r14 = 1
            if (r1 != r14) goto L_0x025c
            r1 = 1
            r13 = 1
            r16 = 6
        L_0x0259:
            r6 = r25
            goto L_0x028b
        L_0x025c:
            r2 = 3
            r6 = r25
            if (r1 != r2) goto L_0x027f
            if (r39 != 0) goto L_0x026c
            int r1 = r6.f1913p
            r2 = -1
            if (r1 == r2) goto L_0x026c
            if (r13 > 0) goto L_0x026c
            r5 = 6
            goto L_0x026d
        L_0x026c:
            r5 = 4
        L_0x026d:
            int r1 = r32.d()
            r10.e(r15, r4, r1, r5)
            int r1 = r33.d()
            int r1 = -r1
            r10.e(r9, r7, r1, r5)
            r1 = 1
            r13 = 1
            goto L_0x0289
        L_0x027f:
            r1 = 0
            goto L_0x0288
        L_0x0281:
            r6 = r25
            r7 = r1
            r4 = r22
            r14 = 1
            r1 = 1
        L_0x0288:
            r13 = 0
        L_0x0289:
            r16 = 5
        L_0x028b:
            if (r1 == 0) goto L_0x02d1
            int r5 = r32.d()
            int r17 = r33.d()
            r1 = r26
            r2 = r15
            r3 = r4
            r18 = r4
            r4 = r5
            r5 = r38
            r6 = r7
            r0 = r7
            r7 = r9
            r14 = r18
            r12 = 0
            r8 = r17
            r12 = r9
            r9 = r16
            r1.c(r2, r3, r4, r5, r6, r7, r8, r9)
            r1 = r32
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r1.f1857d
            androidx.constraintlayout.solver.widgets.ConstraintWidget r2 = r2.f1855b
            boolean r2 = r2 instanceof androidx.constraintlayout.solver.widgets.Barrier
            r3 = r33
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r3.f1857d
            androidx.constraintlayout.solver.widgets.ConstraintWidget r4 = r4.f1855b
            boolean r4 = r4 instanceof androidx.constraintlayout.solver.widgets.Barrier
            if (r2 == 0) goto L_0x02c7
            if (r4 != 0) goto L_0x02c7
            r6 = r27
            r2 = 6
            r5 = 5
            r19 = 1
            goto L_0x02de
        L_0x02c7:
            if (r2 != 0) goto L_0x02d8
            if (r4 == 0) goto L_0x02d8
            r19 = r27
            r2 = 5
            r5 = 6
            r6 = 1
            goto L_0x02de
        L_0x02d1:
            r1 = r32
            r3 = r33
            r14 = r4
            r0 = r7
            r12 = r9
        L_0x02d8:
            r6 = r27
            r19 = r6
            r2 = 5
            r5 = 5
        L_0x02de:
            if (r13 == 0) goto L_0x02e2
            r2 = 6
            r5 = 6
        L_0x02e2:
            if (r23 != 0) goto L_0x02e6
            if (r6 != 0) goto L_0x02e8
        L_0x02e6:
            if (r13 == 0) goto L_0x02ef
        L_0x02e8:
            int r1 = r32.d()
            r10.i(r15, r14, r1, r5)
        L_0x02ef:
            if (r23 != 0) goto L_0x02f3
            if (r19 != 0) goto L_0x02f5
        L_0x02f3:
            if (r13 == 0) goto L_0x02fd
        L_0x02f5:
            int r1 = r33.d()
            int r1 = -r1
            r10.k(r12, r0, r1, r2)
        L_0x02fd:
            r0 = 0
            r1 = 6
            if (r27 == 0) goto L_0x0308
            r10.i(r15, r11, r0, r1)
            goto L_0x0308
        L_0x0305:
            r12 = r9
            r0 = 0
            r1 = 6
        L_0x0308:
            if (r27 == 0) goto L_0x0310
            r2 = r29
            r3 = 0
            r10.i(r2, r12, r3, r1)
        L_0x0310:
            return
        L_0x0311:
            r2 = r12
            r1 = 6
            r3 = 0
            r4 = 2
            r12 = r9
            if (r0 >= r4) goto L_0x0320
            if (r27 == 0) goto L_0x0320
            r10.i(r15, r11, r3, r1)
            r10.i(r2, r12, r3, r1)
        L_0x0320:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.ConstraintWidget.e(androidx.constraintlayout.solver.LinearSystem, boolean, androidx.constraintlayout.solver.SolverVariable, androidx.constraintlayout.solver.SolverVariable, androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour, boolean, androidx.constraintlayout.solver.widgets.ConstraintAnchor, androidx.constraintlayout.solver.widgets.ConstraintAnchor, int, int, int, int, float, boolean, boolean, int, int, int, float, boolean):void");
    }

    /* access modifiers changed from: protected */
    public int A() {
        return this.L + this.T;
    }

    public void A0(int i2) {
        this.Y = i2;
    }

    public DimensionBehaviour B() {
        return this.E[1];
    }

    public void B0(int i2) {
        this.X = i2;
    }

    public int C() {
        return this.f1890d0;
    }

    public void C0(int i2) {
        this.K = i2;
    }

    public int D() {
        if (this.f1890d0 == 8) {
            return 0;
        }
        return this.G;
    }

    public void D0(int i2) {
        this.L = i2;
    }

    public int E() {
        return this.Y;
    }

    public void E0(boolean z2, boolean z3, boolean z4, boolean z5) {
        if (this.f1913p == -1) {
            if (z4 && !z5) {
                this.f1913p = 0;
            } else if (!z4 && z5) {
                this.f1913p = 1;
                if (this.J == -1) {
                    this.f1915q = 1.0f / this.f1915q;
                }
            }
        }
        if (this.f1913p == 0 && (!this.f1924v.k() || !this.f1926x.k())) {
            this.f1913p = 1;
        } else if (this.f1913p == 1 && (!this.f1923u.k() || !this.f1925w.k())) {
            this.f1913p = 0;
        }
        if (this.f1913p == -1 && (!this.f1924v.k() || !this.f1926x.k() || !this.f1923u.k() || !this.f1925w.k())) {
            if (this.f1924v.k() && this.f1926x.k()) {
                this.f1913p = 0;
            } else if (this.f1923u.k() && this.f1925w.k()) {
                this.f1915q = 1.0f / this.f1915q;
                this.f1913p = 1;
            }
        }
        if (this.f1913p == -1) {
            if (z2 && !z3) {
                this.f1913p = 0;
            } else if (!z2 && z3) {
                this.f1915q = 1.0f / this.f1915q;
                this.f1913p = 1;
            }
        }
        if (this.f1913p == -1) {
            int i2 = this.f1897h;
            if (i2 > 0 && this.f1903k == 0) {
                this.f1913p = 0;
            } else if (i2 == 0 && this.f1903k > 0) {
                this.f1915q = 1.0f / this.f1915q;
                this.f1913p = 1;
            }
        }
        if (this.f1913p == -1 && z2 && z3) {
            this.f1915q = 1.0f / this.f1915q;
            this.f1913p = 1;
        }
    }

    public int F() {
        return this.X;
    }

    public void F0() {
        int i2 = this.K;
        int i3 = this.L;
        this.O = i2;
        this.P = i3;
        this.Q = (this.G + i2) - i2;
        this.R = (this.H + i3) - i3;
    }

    public int G() {
        return this.K;
    }

    public void G0(LinearSystem linearSystem) {
        int y2 = linearSystem.y(this.f1923u);
        int y3 = linearSystem.y(this.f1924v);
        int y4 = linearSystem.y(this.f1925w);
        int y5 = linearSystem.y(this.f1926x);
        int i2 = y5 - y3;
        if (y4 - y2 < 0 || i2 < 0 || y2 == Integer.MIN_VALUE || y2 == Integer.MAX_VALUE || y3 == Integer.MIN_VALUE || y3 == Integer.MAX_VALUE || y4 == Integer.MIN_VALUE || y4 == Integer.MAX_VALUE || y5 == Integer.MIN_VALUE || y5 == Integer.MAX_VALUE) {
            y2 = 0;
            y5 = 0;
            y3 = 0;
            y4 = 0;
        }
        a0(y2, y3, y4, y5);
    }

    public int H() {
        return this.L;
    }

    public void H0() {
        for (int i2 = 0; i2 < 6; i2++) {
            this.C[i2].f().q();
        }
    }

    public boolean I() {
        return this.U > 0;
    }

    public void J(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i2, int i3) {
        h(type).a(constraintWidget.h(type2), i2, i3, ConstraintAnchor.Strength.STRONG, 0, true);
    }

    public boolean L() {
        if (this.f1923u.f().f1975b == 1 && this.f1925w.f().f1975b == 1 && this.f1924v.f().f1975b == 1 && this.f1926x.f().f1975b == 1) {
            return true;
        }
        return false;
    }

    public boolean M() {
        ConstraintAnchor constraintAnchor = this.f1923u;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.f1857d;
        if (constraintAnchor2 != null && constraintAnchor2.f1857d == constraintAnchor) {
            return true;
        }
        ConstraintAnchor constraintAnchor3 = this.f1925w;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.f1857d;
        return constraintAnchor4 != null && constraintAnchor4.f1857d == constraintAnchor3;
    }

    public boolean N() {
        ConstraintAnchor constraintAnchor = this.f1924v;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.f1857d;
        if (constraintAnchor2 != null && constraintAnchor2.f1857d == constraintAnchor) {
            return true;
        }
        ConstraintAnchor constraintAnchor3 = this.f1926x;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.f1857d;
        return constraintAnchor4 != null && constraintAnchor4.f1857d == constraintAnchor3;
    }

    public boolean O() {
        return this.f1893f == 0 && this.I == 0.0f && this.f1903k == 0 && this.f1905l == 0 && this.E[1] == DimensionBehaviour.MATCH_CONSTRAINT;
    }

    public boolean P() {
        return this.f1891e == 0 && this.I == 0.0f && this.f1897h == 0 && this.f1899i == 0 && this.E[0] == DimensionBehaviour.MATCH_CONSTRAINT;
    }

    public void Q() {
        this.f1923u.m();
        this.f1924v.m();
        this.f1925w.m();
        this.f1926x.m();
        this.f1927y.m();
        this.f1928z.m();
        this.A.m();
        this.B.m();
        this.F = null;
        this.f1921t = 0.0f;
        this.G = 0;
        this.H = 0;
        this.I = 0.0f;
        this.J = -1;
        this.K = 0;
        this.L = 0;
        this.O = 0;
        this.P = 0;
        this.Q = 0;
        this.R = 0;
        this.S = 0;
        this.T = 0;
        this.U = 0;
        this.V = 0;
        this.W = 0;
        this.X = 0;
        this.Y = 0;
        float f2 = f1882u0;
        this.Z = f2;
        this.f1884a0 = f2;
        DimensionBehaviour[] dimensionBehaviourArr = this.E;
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        dimensionBehaviourArr[0] = dimensionBehaviour;
        dimensionBehaviourArr[1] = dimensionBehaviour;
        this.f1886b0 = null;
        this.f1888c0 = 0;
        this.f1890d0 = 0;
        this.f1894f0 = null;
        this.f1896g0 = false;
        this.f1898h0 = false;
        this.f1906l0 = 0;
        this.f1908m0 = 0;
        this.f1910n0 = false;
        this.f1912o0 = false;
        float[] fArr = this.f1914p0;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.f1883a = -1;
        this.f1885b = -1;
        int[] iArr = this.f1919s;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.f1891e = 0;
        this.f1893f = 0;
        this.f1901j = 1.0f;
        this.f1907m = 1.0f;
        this.f1899i = Integer.MAX_VALUE;
        this.f1905l = Integer.MAX_VALUE;
        this.f1897h = 0;
        this.f1903k = 0;
        this.f1913p = -1;
        this.f1915q = 1.0f;
        ResolutionDimension resolutionDimension = this.f1887c;
        if (resolutionDimension != null) {
            resolutionDimension.e();
        }
        ResolutionDimension resolutionDimension2 = this.f1889d;
        if (resolutionDimension2 != null) {
            resolutionDimension2.e();
        }
        this.f1917r = null;
        this.f1900i0 = false;
        this.f1902j0 = false;
        this.f1904k0 = false;
    }

    public void R() {
        ConstraintWidget u2 = u();
        if (u2 == null || !(u2 instanceof ConstraintWidgetContainer) || !((ConstraintWidgetContainer) u()).S0()) {
            int size = this.D.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.D.get(i2).m();
            }
        }
    }

    public void S() {
        for (int i2 = 0; i2 < 6; i2++) {
            this.C[i2].f().e();
        }
    }

    public void T(Cache cache) {
        this.f1923u.n(cache);
        this.f1924v.n(cache);
        this.f1925w.n(cache);
        this.f1926x.n(cache);
        this.f1927y.n(cache);
        this.B.n(cache);
        this.f1928z.n(cache);
        this.A.n(cache);
    }

    public void U() {
    }

    public void V(int i2) {
        this.U = i2;
    }

    public void W(Object obj) {
        this.f1886b0 = obj;
    }

    public void X(String str) {
        this.f1892e0 = str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void Y(java.lang.String r9) {
        /*
            r8 = this;
            r0 = 0
            if (r9 == 0) goto L_0x0091
            int r1 = r9.length()
            if (r1 != 0) goto L_0x000b
            goto L_0x0091
        L_0x000b:
            int r1 = r9.length()
            r2 = 44
            int r2 = r9.indexOf(r2)
            r3 = 0
            r4 = 1
            r5 = -1
            if (r2 <= 0) goto L_0x0039
            int r6 = r1 + -1
            if (r2 >= r6) goto L_0x0039
            java.lang.String r6 = r9.substring(r3, r2)
            java.lang.String r7 = "W"
            boolean r7 = r6.equalsIgnoreCase(r7)
            if (r7 == 0) goto L_0x002b
            goto L_0x0036
        L_0x002b:
            java.lang.String r3 = "H"
            boolean r3 = r6.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x0035
            r3 = 1
            goto L_0x0036
        L_0x0035:
            r3 = -1
        L_0x0036:
            int r2 = r2 + r4
            r5 = r3
            r3 = r2
        L_0x0039:
            r2 = 58
            int r2 = r9.indexOf(r2)
            if (r2 < 0) goto L_0x0077
            int r1 = r1 - r4
            if (r2 >= r1) goto L_0x0077
            java.lang.String r1 = r9.substring(r3, r2)
            int r2 = r2 + r4
            java.lang.String r9 = r9.substring(r2)
            int r2 = r1.length()
            if (r2 <= 0) goto L_0x0087
            int r2 = r9.length()
            if (r2 <= 0) goto L_0x0087
            float r1 = java.lang.Float.parseFloat(r1)     // Catch:{ NumberFormatException -> 0x0086 }
            float r9 = java.lang.Float.parseFloat(r9)     // Catch:{ NumberFormatException -> 0x0086 }
            int r2 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r2 <= 0) goto L_0x0087
            int r2 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r2 <= 0) goto L_0x0087
            if (r5 != r4) goto L_0x0071
            float r9 = r9 / r1
            float r9 = java.lang.Math.abs(r9)     // Catch:{ NumberFormatException -> 0x0086 }
            goto L_0x0088
        L_0x0071:
            float r1 = r1 / r9
            float r9 = java.lang.Math.abs(r1)     // Catch:{ NumberFormatException -> 0x0086 }
            goto L_0x0088
        L_0x0077:
            java.lang.String r9 = r9.substring(r3)
            int r1 = r9.length()
            if (r1 <= 0) goto L_0x0087
            float r9 = java.lang.Float.parseFloat(r9)     // Catch:{ NumberFormatException -> 0x0086 }
            goto L_0x0088
        L_0x0086:
        L_0x0087:
            r9 = 0
        L_0x0088:
            int r0 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x0090
            r8.I = r9
            r8.J = r5
        L_0x0090:
            return
        L_0x0091:
            r8.I = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.ConstraintWidget.Y(java.lang.String):void");
    }

    public void Z(int i2, int i3, int i4) {
        if (i4 == 0) {
            f0(i2, i3);
        } else if (i4 == 1) {
            t0(i2, i3);
        }
        this.f1902j0 = true;
    }

    public void a0(int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8 = i4 - i2;
        int i9 = i5 - i3;
        this.K = i2;
        this.L = i3;
        if (this.f1890d0 == 8) {
            this.G = 0;
            this.H = 0;
            return;
        }
        DimensionBehaviour[] dimensionBehaviourArr = this.E;
        DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
        DimensionBehaviour dimensionBehaviour2 = DimensionBehaviour.FIXED;
        if (dimensionBehaviour == dimensionBehaviour2 && i8 < (i7 = this.G)) {
            i8 = i7;
        }
        if (dimensionBehaviourArr[1] == dimensionBehaviour2 && i9 < (i6 = this.H)) {
            i9 = i6;
        }
        this.G = i8;
        this.H = i9;
        int i10 = this.W;
        if (i9 < i10) {
            this.H = i10;
        }
        int i11 = this.V;
        if (i8 < i11) {
            this.G = i11;
        }
        this.f1902j0 = true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x018e  */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0191  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x01a3  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x020a  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x021b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x021c  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x027d  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x0286  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x028c  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x0294  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x02cb  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x02f4  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x02fe  */
    /* JADX WARNING: Removed duplicated region for block: B:161:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(androidx.constraintlayout.solver.LinearSystem r42) {
        /*
            r41 = this;
            r15 = r41
            r14 = r42
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r15.f1923u
            androidx.constraintlayout.solver.SolverVariable r21 = r14.r(r0)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r15.f1925w
            androidx.constraintlayout.solver.SolverVariable r10 = r14.r(r0)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r15.f1924v
            androidx.constraintlayout.solver.SolverVariable r6 = r14.r(r0)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r15.f1926x
            androidx.constraintlayout.solver.SolverVariable r4 = r14.r(r0)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r15.f1927y
            androidx.constraintlayout.solver.SolverVariable r3 = r14.r(r0)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r15.F
            r1 = 8
            r2 = 1
            r13 = 0
            if (r0 == 0) goto L_0x00af
            if (r0 == 0) goto L_0x0036
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r5 = r0.E
            r5 = r5[r13]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r7 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r5 != r7) goto L_0x0036
            r5 = 1
            goto L_0x0037
        L_0x0036:
            r5 = 0
        L_0x0037:
            if (r0 == 0) goto L_0x0043
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r0.E
            r0 = r0[r2]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r7 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r0 != r7) goto L_0x0043
            r0 = 1
            goto L_0x0044
        L_0x0043:
            r0 = 0
        L_0x0044:
            boolean r7 = r15.K(r13)
            if (r7 == 0) goto L_0x0053
            androidx.constraintlayout.solver.widgets.ConstraintWidget r7 = r15.F
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r7 = (androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer) r7
            r7.N0(r15, r13)
            r7 = 1
            goto L_0x0057
        L_0x0053:
            boolean r7 = r41.M()
        L_0x0057:
            boolean r8 = r15.K(r2)
            if (r8 == 0) goto L_0x0066
            androidx.constraintlayout.solver.widgets.ConstraintWidget r8 = r15.F
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r8 = (androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer) r8
            r8.N0(r15, r2)
            r8 = 1
            goto L_0x006a
        L_0x0066:
            boolean r8 = r41.N()
        L_0x006a:
            if (r5 == 0) goto L_0x0087
            int r9 = r15.f1890d0
            if (r9 == r1) goto L_0x0087
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r9 = r15.f1923u
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r9 = r9.f1857d
            if (r9 != 0) goto L_0x0087
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r9 = r15.f1925w
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r9 = r9.f1857d
            if (r9 != 0) goto L_0x0087
            androidx.constraintlayout.solver.widgets.ConstraintWidget r9 = r15.F
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r9 = r9.f1925w
            androidx.constraintlayout.solver.SolverVariable r9 = r14.r(r9)
            r14.i(r9, r10, r13, r2)
        L_0x0087:
            if (r0 == 0) goto L_0x00a8
            int r9 = r15.f1890d0
            if (r9 == r1) goto L_0x00a8
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r9 = r15.f1924v
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r9 = r9.f1857d
            if (r9 != 0) goto L_0x00a8
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r9 = r15.f1926x
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r9 = r9.f1857d
            if (r9 != 0) goto L_0x00a8
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r9 = r15.f1927y
            if (r9 != 0) goto L_0x00a8
            androidx.constraintlayout.solver.widgets.ConstraintWidget r9 = r15.F
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r9 = r9.f1926x
            androidx.constraintlayout.solver.SolverVariable r9 = r14.r(r9)
            r14.i(r9, r4, r13, r2)
        L_0x00a8:
            r12 = r0
            r0 = r5
            r16 = r7
            r22 = r8
            goto L_0x00b5
        L_0x00af:
            r0 = 0
            r12 = 0
            r16 = 0
            r22 = 0
        L_0x00b5:
            int r5 = r15.G
            int r7 = r15.V
            if (r5 >= r7) goto L_0x00bc
            goto L_0x00bd
        L_0x00bc:
            r7 = r5
        L_0x00bd:
            int r8 = r15.H
            int r9 = r15.W
            if (r8 >= r9) goto L_0x00c4
            goto L_0x00c5
        L_0x00c4:
            r9 = r8
        L_0x00c5:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r11 = r15.E
            r1 = r11[r13]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r13 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            r20 = r3
            if (r1 == r13) goto L_0x00d1
            r3 = 1
            goto L_0x00d2
        L_0x00d1:
            r3 = 0
        L_0x00d2:
            r11 = r11[r2]
            r24 = r4
            if (r11 == r13) goto L_0x00d9
            goto L_0x00da
        L_0x00d9:
            r2 = 0
        L_0x00da:
            int r4 = r15.J
            r15.f1913p = r4
            r25 = r6
            float r6 = r15.I
            r15.f1915q = r6
            r19 = r7
            int r7 = r15.f1891e
            r26 = r9
            int r9 = r15.f1893f
            r27 = 0
            r28 = r10
            int r27 = (r6 > r27 ? 1 : (r6 == r27 ? 0 : -1))
            if (r27 <= 0) goto L_0x0160
            int r10 = r15.f1890d0
            r14 = 8
            if (r10 == r14) goto L_0x0160
            r10 = 3
            if (r1 != r13) goto L_0x0100
            if (r7 != 0) goto L_0x0100
            r7 = 3
        L_0x0100:
            if (r11 != r13) goto L_0x0105
            if (r9 != 0) goto L_0x0105
            r9 = 3
        L_0x0105:
            if (r1 != r13) goto L_0x0111
            if (r11 != r13) goto L_0x0111
            if (r7 != r10) goto L_0x0111
            if (r9 != r10) goto L_0x0111
            r15.E0(r0, r12, r3, r2)
            goto L_0x0155
        L_0x0111:
            r2 = 4
            if (r1 != r13) goto L_0x012e
            if (r7 != r10) goto L_0x012e
            r3 = 0
            r15.f1913p = r3
            float r1 = (float) r8
            float r6 = r6 * r1
            int r1 = (int) r6
            r10 = r1
            if (r11 == r13) goto L_0x0129
            r31 = r9
            r29 = r26
            r26 = 0
            r30 = 4
            goto L_0x016a
        L_0x0129:
            r30 = r7
            r31 = r9
            goto L_0x015b
        L_0x012e:
            if (r11 != r13) goto L_0x0155
            if (r9 != r10) goto L_0x0155
            r3 = 1
            r15.f1913p = r3
            r3 = -1
            if (r4 != r3) goto L_0x013d
            r3 = 1065353216(0x3f800000, float:1.0)
            float r3 = r3 / r6
            r15.f1915q = r3
        L_0x013d:
            float r3 = r15.f1915q
            float r4 = (float) r5
            float r3 = r3 * r4
            int r3 = (int) r3
            r29 = r3
            r30 = r7
            if (r1 == r13) goto L_0x0150
            r10 = r19
            r26 = 0
            r31 = 4
            goto L_0x016a
        L_0x0150:
            r31 = r9
            r10 = r19
            goto L_0x015d
        L_0x0155:
            r30 = r7
            r31 = r9
            r10 = r19
        L_0x015b:
            r29 = r26
        L_0x015d:
            r26 = 1
            goto L_0x016a
        L_0x0160:
            r30 = r7
            r31 = r9
            r10 = r19
            r29 = r26
            r26 = 0
        L_0x016a:
            int[] r1 = r15.f1895g
            r2 = 0
            r1[r2] = r30
            r2 = 1
            r1[r2] = r31
            if (r26 == 0) goto L_0x017e
            int r1 = r15.f1913p
            r14 = -1
            if (r1 == 0) goto L_0x017b
            if (r1 != r14) goto L_0x017f
        L_0x017b:
            r27 = 1
            goto L_0x0181
        L_0x017e:
            r14 = -1
        L_0x017f:
            r27 = 0
        L_0x0181:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r1 = r15.E
            r2 = 0
            r1 = r1[r2]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r1 != r6) goto L_0x0191
            boolean r1 = r15 instanceof androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer
            if (r1 == 0) goto L_0x0191
            r32 = 1
            goto L_0x0193
        L_0x0191:
            r32 = 0
        L_0x0193:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r15.B
            boolean r1 = r1.k()
            r2 = 1
            r23 = r1 ^ 1
            int r1 = r15.f1883a
            r4 = 2
            r33 = 0
            if (r1 == r4) goto L_0x020a
            androidx.constraintlayout.solver.widgets.ConstraintWidget r1 = r15.F
            if (r1 == 0) goto L_0x01b2
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r1.f1925w
            r3 = r42
            androidx.constraintlayout.solver.SolverVariable r1 = r3.r(r1)
            r34 = r1
            goto L_0x01b6
        L_0x01b2:
            r3 = r42
            r34 = r33
        L_0x01b6:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r1 = r15.F
            if (r1 == 0) goto L_0x01c3
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r1.f1923u
            androidx.constraintlayout.solver.SolverVariable r1 = r3.r(r1)
            r35 = r1
            goto L_0x01c5
        L_0x01c3:
            r35 = r33
        L_0x01c5:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r1 = r15.E
            r13 = 0
            r5 = r1[r13]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r7 = r15.f1923u
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r8 = r15.f1925w
            int r9 = r15.K
            int r11 = r15.V
            int[] r1 = r15.f1919s
            r1 = r1[r13]
            r36 = r12
            r12 = r1
            float r1 = r15.Z
            r13 = r1
            int r1 = r15.f1897h
            r17 = r1
            int r1 = r15.f1899i
            r18 = r1
            float r1 = r15.f1901j
            r19 = r1
            r37 = r0
            r0 = r41
            r1 = r42
            r2 = r37
            r38 = r20
            r3 = r35
            r4 = r34
            r40 = r6
            r39 = r25
            r6 = r32
            r25 = r28
            r14 = r27
            r15 = r16
            r16 = r30
            r20 = r23
            r0.e(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            goto L_0x0214
        L_0x020a:
            r40 = r6
            r36 = r12
            r38 = r20
            r39 = r25
            r25 = r28
        L_0x0214:
            r15 = r41
            int r0 = r15.f1885b
            r1 = 2
            if (r0 != r1) goto L_0x021c
            return
        L_0x021c:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r15.E
            r14 = 1
            r0 = r0[r14]
            r1 = r40
            if (r0 != r1) goto L_0x022b
            boolean r0 = r15 instanceof androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer
            if (r0 == 0) goto L_0x022b
            r6 = 1
            goto L_0x022c
        L_0x022b:
            r6 = 0
        L_0x022c:
            if (r26 == 0) goto L_0x0238
            int r0 = r15.f1913p
            if (r0 == r14) goto L_0x0235
            r1 = -1
            if (r0 != r1) goto L_0x0238
        L_0x0235:
            r16 = 1
            goto L_0x023a
        L_0x0238:
            r16 = 0
        L_0x023a:
            int r0 = r15.U
            if (r0 <= 0) goto L_0x0273
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r15.f1927y
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r0 = r0.f()
            int r0 = r0.f1975b
            if (r0 != r14) goto L_0x0254
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r15.f1927y
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r0 = r0.f()
            r10 = r42
            r0.g(r10)
            goto L_0x0275
        L_0x0254:
            r10 = r42
            int r0 = r41.j()
            r1 = 6
            r2 = r38
            r4 = r39
            r10.e(r2, r4, r0, r1)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r15.f1927y
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r0.f1857d
            if (r0 == 0) goto L_0x0277
            androidx.constraintlayout.solver.SolverVariable r0 = r10.r(r0)
            r3 = 0
            r10.e(r2, r0, r3, r1)
            r20 = 0
            goto L_0x0279
        L_0x0273:
            r10 = r42
        L_0x0275:
            r4 = r39
        L_0x0277:
            r20 = r23
        L_0x0279:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r15.F
            if (r0 == 0) goto L_0x0286
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r0.f1926x
            androidx.constraintlayout.solver.SolverVariable r0 = r10.r(r0)
            r23 = r0
            goto L_0x0288
        L_0x0286:
            r23 = r33
        L_0x0288:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r15.F
            if (r0 == 0) goto L_0x0294
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r0.f1924v
            androidx.constraintlayout.solver.SolverVariable r0 = r10.r(r0)
            r3 = r0
            goto L_0x0296
        L_0x0294:
            r3 = r33
        L_0x0296:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r15.E
            r5 = r0[r14]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r7 = r15.f1924v
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r8 = r15.f1926x
            int r9 = r15.L
            int r11 = r15.W
            int[] r0 = r15.f1919s
            r12 = r0[r14]
            float r13 = r15.f1884a0
            int r0 = r15.f1903k
            r17 = r0
            int r0 = r15.f1905l
            r18 = r0
            float r0 = r15.f1907m
            r19 = r0
            r0 = r41
            r1 = r42
            r2 = r36
            r27 = r4
            r4 = r23
            r10 = r29
            r14 = r16
            r15 = r22
            r16 = r31
            r0.e(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            if (r26 == 0) goto L_0x02f4
            r6 = 6
            r7 = r41
            int r0 = r7.f1913p
            r1 = 1
            if (r0 != r1) goto L_0x02e3
            float r5 = r7.f1915q
            r0 = r42
            r1 = r24
            r2 = r27
            r3 = r25
            r4 = r21
            r0.l(r1, r2, r3, r4, r5, r6)
            goto L_0x02f6
        L_0x02e3:
            float r5 = r7.f1915q
            r6 = 6
            r0 = r42
            r1 = r25
            r2 = r21
            r3 = r24
            r4 = r27
            r0.l(r1, r2, r3, r4, r5, r6)
            goto L_0x02f6
        L_0x02f4:
            r7 = r41
        L_0x02f6:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r7.B
            boolean r0 = r0.k()
            if (r0 == 0) goto L_0x031e
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r7.B
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r0.i()
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r0.e()
            float r1 = r7.f1921t
            r2 = 1119092736(0x42b40000, float:90.0)
            float r1 = r1 + r2
            double r1 = (double) r1
            double r1 = java.lang.Math.toRadians(r1)
            float r1 = (float) r1
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r7.B
            int r2 = r2.d()
            r3 = r42
            r3.b(r7, r0, r1, r2)
        L_0x031e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.ConstraintWidget.b(androidx.constraintlayout.solver.LinearSystem):void");
    }

    public void b0(int i2) {
        this.H = i2;
        int i3 = this.W;
        if (i2 < i3) {
            this.H = i3;
        }
    }

    public boolean c() {
        return this.f1890d0 != 8;
    }

    public void c0(boolean z2) {
        this.f1911o = z2;
    }

    public void d(int i2) {
        Optimizer.a(i2, this);
    }

    public void d0(float f2) {
        this.Z = f2;
    }

    public void e0(int i2) {
        this.f1906l0 = i2;
    }

    public void f(ConstraintWidget constraintWidget, float f2, int i2) {
        ConstraintAnchor.Type type = ConstraintAnchor.Type.CENTER;
        J(type, constraintWidget, type, i2, 0);
        this.f1921t = f2;
    }

    public void f0(int i2, int i3) {
        this.K = i2;
        int i4 = i3 - i2;
        this.G = i4;
        int i5 = this.V;
        if (i4 < i5) {
            this.G = i5;
        }
    }

    public void g(LinearSystem linearSystem) {
        linearSystem.r(this.f1923u);
        linearSystem.r(this.f1924v);
        linearSystem.r(this.f1925w);
        linearSystem.r(this.f1926x);
        if (this.U > 0) {
            linearSystem.r(this.f1927y);
        }
    }

    public void g0(DimensionBehaviour dimensionBehaviour) {
        this.E[0] = dimensionBehaviour;
        if (dimensionBehaviour == DimensionBehaviour.WRAP_CONTENT) {
            y0(this.X);
        }
    }

    public ConstraintAnchor h(ConstraintAnchor.Type type) {
        switch (AnonymousClass1.f1929a[type.ordinal()]) {
            case 1:
                return this.f1923u;
            case 2:
                return this.f1924v;
            case 3:
                return this.f1925w;
            case 4:
                return this.f1926x;
            case 5:
                return this.f1927y;
            case 6:
                return this.B;
            case 7:
                return this.f1928z;
            case 8:
                return this.A;
            case 9:
                return null;
            default:
                throw new AssertionError(type.name());
        }
    }

    public void h0(int i2, int i3, int i4, float f2) {
        this.f1891e = i2;
        this.f1897h = i3;
        this.f1899i = i4;
        this.f1901j = f2;
        if (f2 < 1.0f && i2 == 0) {
            this.f1891e = 2;
        }
    }

    public ArrayList<ConstraintAnchor> i() {
        return this.D;
    }

    public void i0(float f2) {
        this.f1914p0[0] = f2;
    }

    public int j() {
        return this.U;
    }

    public void j0(int i2) {
        this.f1919s[1] = i2;
    }

    public float k(int i2) {
        if (i2 == 0) {
            return this.Z;
        }
        if (i2 == 1) {
            return this.f1884a0;
        }
        return -1.0f;
    }

    public void k0(int i2) {
        this.f1919s[0] = i2;
    }

    public int l() {
        return H() + this.H;
    }

    public void l0(int i2) {
        if (i2 < 0) {
            this.W = 0;
        } else {
            this.W = i2;
        }
    }

    public Object m() {
        return this.f1886b0;
    }

    public void m0(int i2) {
        if (i2 < 0) {
            this.V = 0;
        } else {
            this.V = i2;
        }
    }

    public String n() {
        return this.f1892e0;
    }

    public void n0(int i2, int i3) {
        this.S = i2;
        this.T = i3;
    }

    public DimensionBehaviour o(int i2) {
        if (i2 == 0) {
            return s();
        }
        if (i2 == 1) {
            return B();
        }
        return null;
    }

    public void o0(int i2, int i3) {
        this.K = i2;
        this.L = i3;
    }

    public int p() {
        return this.O + this.S;
    }

    public void p0(ConstraintWidget constraintWidget) {
        this.F = constraintWidget;
    }

    public int q() {
        return this.P + this.T;
    }

    /* access modifiers changed from: package-private */
    public void q0(int i2, int i3) {
        if (i3 == 0) {
            this.M = i2;
        } else if (i3 == 1) {
            this.N = i2;
        }
    }

    public int r() {
        if (this.f1890d0 == 8) {
            return 0;
        }
        return this.H;
    }

    public void r0(float f2) {
        this.f1884a0 = f2;
    }

    public DimensionBehaviour s() {
        return this.E[0];
    }

    public void s0(int i2) {
        this.f1908m0 = i2;
    }

    public int t(int i2) {
        if (i2 == 0) {
            return D();
        }
        if (i2 == 1) {
            return r();
        }
        return 0;
    }

    public void t0(int i2, int i3) {
        this.L = i2;
        int i4 = i3 - i2;
        this.H = i4;
        int i5 = this.W;
        if (i4 < i5) {
            this.H = i5;
        }
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        if (this.f1894f0 != null) {
            str = "type: " + this.f1894f0 + " ";
        } else {
            str = str2;
        }
        sb.append(str);
        if (this.f1892e0 != null) {
            str2 = "id: " + this.f1892e0 + " ";
        }
        sb.append(str2);
        sb.append("(");
        sb.append(this.K);
        sb.append(", ");
        sb.append(this.L);
        sb.append(") - (");
        sb.append(this.G);
        sb.append(" x ");
        sb.append(this.H);
        sb.append(") wrap: (");
        sb.append(this.X);
        sb.append(" x ");
        sb.append(this.Y);
        sb.append(")");
        return sb.toString();
    }

    public ConstraintWidget u() {
        return this.F;
    }

    public void u0(DimensionBehaviour dimensionBehaviour) {
        this.E[1] = dimensionBehaviour;
        if (dimensionBehaviour == DimensionBehaviour.WRAP_CONTENT) {
            b0(this.Y);
        }
    }

    /* access modifiers changed from: package-private */
    public int v(int i2) {
        if (i2 == 0) {
            return this.M;
        }
        if (i2 == 1) {
            return this.N;
        }
        return 0;
    }

    public void v0(int i2, int i3, int i4, float f2) {
        this.f1893f = i2;
        this.f1903k = i3;
        this.f1905l = i4;
        this.f1907m = f2;
        if (f2 < 1.0f && i2 == 0) {
            this.f1893f = 2;
        }
    }

    public ResolutionDimension w() {
        if (this.f1889d == null) {
            this.f1889d = new ResolutionDimension();
        }
        return this.f1889d;
    }

    public void w0(float f2) {
        this.f1914p0[1] = f2;
    }

    public ResolutionDimension x() {
        if (this.f1887c == null) {
            this.f1887c = new ResolutionDimension();
        }
        return this.f1887c;
    }

    public void x0(int i2) {
        this.f1890d0 = i2;
    }

    public int y() {
        return G() + this.G;
    }

    public void y0(int i2) {
        this.G = i2;
        int i3 = this.V;
        if (i2 < i3) {
            this.G = i3;
        }
    }

    /* access modifiers changed from: protected */
    public int z() {
        return this.K + this.S;
    }

    public void z0(boolean z2) {
        this.f1909n = z2;
    }
}
