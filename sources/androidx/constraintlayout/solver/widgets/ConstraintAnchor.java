package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.Cache;
import androidx.constraintlayout.solver.SolverVariable;

public class ConstraintAnchor {

    /* renamed from: a  reason: collision with root package name */
    private ResolutionAnchor f1854a = new ResolutionAnchor(this);

    /* renamed from: b  reason: collision with root package name */
    final ConstraintWidget f1855b;

    /* renamed from: c  reason: collision with root package name */
    final Type f1856c;

    /* renamed from: d  reason: collision with root package name */
    ConstraintAnchor f1857d;

    /* renamed from: e  reason: collision with root package name */
    public int f1858e = 0;

    /* renamed from: f  reason: collision with root package name */
    int f1859f = -1;

    /* renamed from: g  reason: collision with root package name */
    private Strength f1860g = Strength.NONE;

    /* renamed from: h  reason: collision with root package name */
    private ConnectionType f1861h = ConnectionType.RELAXED;

    /* renamed from: i  reason: collision with root package name */
    private int f1862i = 0;

    /* renamed from: j  reason: collision with root package name */
    SolverVariable f1863j;

    /* renamed from: androidx.constraintlayout.solver.widgets.ConstraintAnchor$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f1864a;

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
                f1864a = r0
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.CENTER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f1864a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f1864a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f1864a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f1864a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f1864a     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BASELINE     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f1864a     // Catch:{ NoSuchFieldError -> 0x0054 }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.CENTER_X     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f1864a     // Catch:{ NoSuchFieldError -> 0x0060 }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.CENTER_Y     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f1864a     // Catch:{ NoSuchFieldError -> 0x006c }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.NONE     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.ConstraintAnchor.AnonymousClass1.<clinit>():void");
        }
    }

    public enum ConnectionType {
        RELAXED,
        STRICT
    }

    public enum Strength {
        NONE,
        STRONG,
        WEAK
    }

    public enum Type {
        NONE,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        BASELINE,
        CENTER,
        CENTER_X,
        CENTER_Y
    }

    public ConstraintAnchor(ConstraintWidget constraintWidget, Type type) {
        this.f1855b = constraintWidget;
        this.f1856c = type;
    }

    public boolean a(ConstraintAnchor constraintAnchor, int i2, int i3, Strength strength, int i4, boolean z2) {
        if (constraintAnchor == null) {
            this.f1857d = null;
            this.f1858e = 0;
            this.f1859f = -1;
            this.f1860g = Strength.NONE;
            this.f1862i = 2;
            return true;
        } else if (!z2 && !l(constraintAnchor)) {
            return false;
        } else {
            this.f1857d = constraintAnchor;
            if (i2 > 0) {
                this.f1858e = i2;
            } else {
                this.f1858e = 0;
            }
            this.f1859f = i3;
            this.f1860g = strength;
            this.f1862i = i4;
            return true;
        }
    }

    public boolean b(ConstraintAnchor constraintAnchor, int i2, Strength strength, int i3) {
        return a(constraintAnchor, i2, -1, strength, i3, false);
    }

    public int c() {
        return this.f1862i;
    }

    public int d() {
        ConstraintAnchor constraintAnchor;
        if (this.f1855b.C() == 8) {
            return 0;
        }
        if (this.f1859f <= -1 || (constraintAnchor = this.f1857d) == null || constraintAnchor.f1855b.C() != 8) {
            return this.f1858e;
        }
        return this.f1859f;
    }

    public ConstraintWidget e() {
        return this.f1855b;
    }

    public ResolutionAnchor f() {
        return this.f1854a;
    }

    public SolverVariable g() {
        return this.f1863j;
    }

    public Strength h() {
        return this.f1860g;
    }

    public ConstraintAnchor i() {
        return this.f1857d;
    }

    public Type j() {
        return this.f1856c;
    }

    public boolean k() {
        return this.f1857d != null;
    }

    public boolean l(ConstraintAnchor constraintAnchor) {
        boolean z2;
        boolean z3;
        boolean z4 = false;
        if (constraintAnchor == null) {
            return false;
        }
        Type j2 = constraintAnchor.j();
        Type type = this.f1856c;
        if (j2 != type) {
            switch (AnonymousClass1.f1864a[type.ordinal()]) {
                case 1:
                    if (j2 == Type.BASELINE || j2 == Type.CENTER_X || j2 == Type.CENTER_Y) {
                        return false;
                    }
                    return true;
                case 2:
                case 3:
                    if (j2 == Type.LEFT || j2 == Type.RIGHT) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (!(constraintAnchor.e() instanceof Guideline)) {
                        return z2;
                    }
                    if (z2 || j2 == Type.CENTER_X) {
                        z4 = true;
                    }
                    return z4;
                case 4:
                case 5:
                    if (j2 == Type.TOP || j2 == Type.BOTTOM) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (!(constraintAnchor.e() instanceof Guideline)) {
                        return z3;
                    }
                    if (z3 || j2 == Type.CENTER_Y) {
                        z4 = true;
                    }
                    return z4;
                case 6:
                case 7:
                case 8:
                case 9:
                    return false;
                default:
                    throw new AssertionError(this.f1856c.name());
            }
        } else if (type != Type.BASELINE || (constraintAnchor.e().I() && e().I())) {
            return true;
        } else {
            return false;
        }
    }

    public void m() {
        this.f1857d = null;
        this.f1858e = 0;
        this.f1859f = -1;
        this.f1860g = Strength.STRONG;
        this.f1862i = 0;
        this.f1861h = ConnectionType.RELAXED;
        this.f1854a.e();
    }

    public void n(Cache cache) {
        SolverVariable solverVariable = this.f1863j;
        if (solverVariable == null) {
            this.f1863j = new SolverVariable(SolverVariable.Type.UNRESTRICTED, (String) null);
        } else {
            solverVariable.d();
        }
    }

    public String toString() {
        return this.f1855b.n() + ":" + this.f1856c.toString();
    }
}
