package androidx.constraintlayout.solver.widgets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConstraintWidgetGroup {

    /* renamed from: a  reason: collision with root package name */
    public List<ConstraintWidget> f1940a;

    /* renamed from: b  reason: collision with root package name */
    int f1941b = -1;

    /* renamed from: c  reason: collision with root package name */
    int f1942c = -1;

    /* renamed from: d  reason: collision with root package name */
    public boolean f1943d = false;

    /* renamed from: e  reason: collision with root package name */
    public final int[] f1944e = {-1, -1};

    /* renamed from: f  reason: collision with root package name */
    List<ConstraintWidget> f1945f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    List<ConstraintWidget> f1946g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    HashSet<ConstraintWidget> f1947h = new HashSet<>();

    /* renamed from: i  reason: collision with root package name */
    HashSet<ConstraintWidget> f1948i = new HashSet<>();

    /* renamed from: j  reason: collision with root package name */
    List<ConstraintWidget> f1949j = new ArrayList();

    /* renamed from: k  reason: collision with root package name */
    List<ConstraintWidget> f1950k = new ArrayList();

    ConstraintWidgetGroup(List<ConstraintWidget> list) {
        this.f1940a = list;
    }

    private void e(ArrayList<ConstraintWidget> arrayList, ConstraintWidget constraintWidget) {
        ConstraintWidget constraintWidget2;
        if (!constraintWidget.f1904k0) {
            arrayList.add(constraintWidget);
            constraintWidget.f1904k0 = true;
            if (!constraintWidget.L()) {
                if (constraintWidget instanceof Helper) {
                    Helper helper = (Helper) constraintWidget;
                    int i2 = helper.f1958w0;
                    for (int i3 = 0; i3 < i2; i3++) {
                        e(arrayList, helper.f1957v0[i3]);
                    }
                }
                for (ConstraintAnchor constraintAnchor : constraintWidget.C) {
                    ConstraintAnchor constraintAnchor2 = constraintAnchor.f1857d;
                    if (!(constraintAnchor2 == null || (constraintWidget2 = constraintAnchor2.f1855b) == constraintWidget.u())) {
                        e(arrayList, constraintWidget2);
                    }
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0083  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void f(androidx.constraintlayout.solver.widgets.ConstraintWidget r7) {
        /*
            r6 = this;
            boolean r0 = r7.f1900i0
            if (r0 == 0) goto L_0x00d6
            boolean r0 = r7.L()
            if (r0 == 0) goto L_0x000b
            return
        L_0x000b:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r7.f1925w
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r0.f1857d
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0015
            r3 = 1
            goto L_0x0016
        L_0x0015:
            r3 = 0
        L_0x0016:
            if (r3 == 0) goto L_0x0019
            goto L_0x001d
        L_0x0019:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r7.f1923u
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r0.f1857d
        L_0x001d:
            if (r0 == 0) goto L_0x0041
            androidx.constraintlayout.solver.widgets.ConstraintWidget r4 = r0.f1855b
            boolean r5 = r4.f1902j0
            if (r5 != 0) goto L_0x0028
            r6.f(r4)
        L_0x0028:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r4 = r0.f1856c
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r5 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT
            if (r4 != r5) goto L_0x0038
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r0.f1855b
            int r4 = r0.K
            int r0 = r0.D()
            int r4 = r4 + r0
            goto L_0x0042
        L_0x0038:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r5 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT
            if (r4 != r5) goto L_0x0041
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r0.f1855b
            int r4 = r0.K
            goto L_0x0042
        L_0x0041:
            r4 = 0
        L_0x0042:
            if (r3 == 0) goto L_0x004c
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r7.f1925w
            int r0 = r0.d()
            int r4 = r4 - r0
            goto L_0x0058
        L_0x004c:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r7.f1923u
            int r0 = r0.d()
            int r3 = r7.D()
            int r0 = r0 + r3
            int r4 = r4 + r0
        L_0x0058:
            int r0 = r7.D()
            int r0 = r4 - r0
            r7.f0(r0, r4)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r7.f1927y
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r0.f1857d
            if (r0 == 0) goto L_0x0083
            androidx.constraintlayout.solver.widgets.ConstraintWidget r2 = r0.f1855b
            boolean r3 = r2.f1902j0
            if (r3 != 0) goto L_0x0070
            r6.f(r2)
        L_0x0070:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r0.f1855b
            int r2 = r0.L
            int r0 = r0.U
            int r2 = r2 + r0
            int r0 = r7.U
            int r2 = r2 - r0
            int r0 = r7.H
            int r0 = r0 + r2
            r7.t0(r2, r0)
            r7.f1902j0 = r1
            return
        L_0x0083:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r7.f1926x
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r0.f1857d
            if (r0 == 0) goto L_0x008a
            r2 = 1
        L_0x008a:
            if (r2 == 0) goto L_0x008d
            goto L_0x0091
        L_0x008d:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r7.f1924v
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r0.f1857d
        L_0x0091:
            if (r0 == 0) goto L_0x00b5
            androidx.constraintlayout.solver.widgets.ConstraintWidget r3 = r0.f1855b
            boolean r5 = r3.f1902j0
            if (r5 != 0) goto L_0x009c
            r6.f(r3)
        L_0x009c:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r3 = r0.f1856c
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r5 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM
            if (r3 != r5) goto L_0x00ad
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r0.f1855b
            int r3 = r0.L
            int r0 = r0.r()
            int r4 = r3 + r0
            goto L_0x00b5
        L_0x00ad:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r5 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP
            if (r3 != r5) goto L_0x00b5
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r0.f1855b
            int r4 = r0.L
        L_0x00b5:
            if (r2 == 0) goto L_0x00bf
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r7.f1926x
            int r0 = r0.d()
            int r4 = r4 - r0
            goto L_0x00cb
        L_0x00bf:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r7.f1924v
            int r0 = r0.d()
            int r2 = r7.r()
            int r0 = r0 + r2
            int r4 = r4 + r0
        L_0x00cb:
            int r0 = r7.r()
            int r0 = r4 - r0
            r7.t0(r0, r4)
            r7.f1902j0 = r1
        L_0x00d6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.ConstraintWidgetGroup.f(androidx.constraintlayout.solver.widgets.ConstraintWidget):void");
    }

    /* access modifiers changed from: package-private */
    public void a(ConstraintWidget constraintWidget, int i2) {
        if (i2 == 0) {
            this.f1947h.add(constraintWidget);
        } else if (i2 == 1) {
            this.f1948i.add(constraintWidget);
        }
    }

    public List<ConstraintWidget> b(int i2) {
        if (i2 == 0) {
            return this.f1945f;
        }
        if (i2 == 1) {
            return this.f1946g;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public Set<ConstraintWidget> c(int i2) {
        if (i2 == 0) {
            return this.f1947h;
        }
        if (i2 == 1) {
            return this.f1948i;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public List<ConstraintWidget> d() {
        if (!this.f1949j.isEmpty()) {
            return this.f1949j;
        }
        int size = this.f1940a.size();
        for (int i2 = 0; i2 < size; i2++) {
            ConstraintWidget constraintWidget = this.f1940a.get(i2);
            if (!constraintWidget.f1900i0) {
                e((ArrayList) this.f1949j, constraintWidget);
            }
        }
        this.f1950k.clear();
        this.f1950k.addAll(this.f1940a);
        this.f1950k.removeAll(this.f1949j);
        return this.f1949j;
    }

    /* access modifiers changed from: package-private */
    public void g() {
        int size = this.f1950k.size();
        for (int i2 = 0; i2 < size; i2++) {
            f(this.f1950k.get(i2));
        }
    }

    ConstraintWidgetGroup(List<ConstraintWidget> list, boolean z2) {
        this.f1940a = list;
        this.f1943d = z2;
    }
}
