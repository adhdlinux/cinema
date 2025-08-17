package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.VelocityTracker;
import android.view.View;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;

abstract class HeaderBehavior<V extends View> extends ViewOffsetBehavior<V> {

    /* renamed from: d  reason: collision with root package name */
    private Runnable f29474d;

    /* renamed from: e  reason: collision with root package name */
    OverScroller f29475e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f29476f;

    /* renamed from: g  reason: collision with root package name */
    private int f29477g = -1;

    /* renamed from: h  reason: collision with root package name */
    private int f29478h;

    /* renamed from: i  reason: collision with root package name */
    private int f29479i = -1;

    /* renamed from: j  reason: collision with root package name */
    private VelocityTracker f29480j;

    private class FlingRunnable implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final CoordinatorLayout f29481b;

        /* renamed from: c  reason: collision with root package name */
        private final V f29482c;

        FlingRunnable(CoordinatorLayout coordinatorLayout, V v2) {
            this.f29481b = coordinatorLayout;
            this.f29482c = v2;
        }

        public void run() {
            OverScroller overScroller;
            if (this.f29482c != null && (overScroller = HeaderBehavior.this.f29475e) != null) {
                if (overScroller.computeScrollOffset()) {
                    HeaderBehavior headerBehavior = HeaderBehavior.this;
                    headerBehavior.O(this.f29481b, this.f29482c, headerBehavior.f29475e.getCurrY());
                    ViewCompat.j0(this.f29482c, this);
                    return;
                }
                HeaderBehavior.this.M(this.f29481b, this.f29482c);
            }
        }
    }

    public HeaderBehavior() {
    }

    private void H() {
        if (this.f29480j == null) {
            this.f29480j = VelocityTracker.obtain();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0021, code lost:
        if (r0 != 3) goto L_0x00ae;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean C(androidx.coordinatorlayout.widget.CoordinatorLayout r12, V r13, android.view.MotionEvent r14) {
        /*
            r11 = this;
            int r0 = r11.f29479i
            if (r0 >= 0) goto L_0x0012
            android.content.Context r0 = r12.getContext()
            android.view.ViewConfiguration r0 = android.view.ViewConfiguration.get(r0)
            int r0 = r0.getScaledTouchSlop()
            r11.f29479i = r0
        L_0x0012:
            int r0 = r14.getActionMasked()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x008d
            r3 = -1
            if (r0 == r1) goto L_0x005c
            r4 = 2
            if (r0 == r4) goto L_0x0025
            r12 = 3
            if (r0 == r12) goto L_0x007e
            goto L_0x00ae
        L_0x0025:
            int r0 = r11.f29477g
            int r0 = r14.findPointerIndex(r0)
            if (r0 != r3) goto L_0x002e
            return r2
        L_0x002e:
            float r0 = r14.getY(r0)
            int r0 = (int) r0
            int r2 = r11.f29478h
            int r2 = r2 - r0
            boolean r3 = r11.f29476f
            if (r3 != 0) goto L_0x0049
            int r3 = java.lang.Math.abs(r2)
            int r4 = r11.f29479i
            if (r3 <= r4) goto L_0x0049
            r11.f29476f = r1
            if (r2 <= 0) goto L_0x0048
            int r2 = r2 - r4
            goto L_0x0049
        L_0x0048:
            int r2 = r2 + r4
        L_0x0049:
            r6 = r2
            boolean r2 = r11.f29476f
            if (r2 == 0) goto L_0x00ae
            r11.f29478h = r0
            int r7 = r11.J(r13)
            r8 = 0
            r3 = r11
            r4 = r12
            r5 = r13
            r3.N(r4, r5, r6, r7, r8)
            goto L_0x00ae
        L_0x005c:
            android.view.VelocityTracker r0 = r11.f29480j
            if (r0 == 0) goto L_0x007e
            r0.addMovement(r14)
            android.view.VelocityTracker r0 = r11.f29480j
            r4 = 1000(0x3e8, float:1.401E-42)
            r0.computeCurrentVelocity(r4)
            android.view.VelocityTracker r0 = r11.f29480j
            int r4 = r11.f29477g
            float r10 = r0.getYVelocity(r4)
            int r0 = r11.K(r13)
            int r8 = -r0
            r9 = 0
            r5 = r11
            r6 = r12
            r7 = r13
            r5.I(r6, r7, r8, r9, r10)
        L_0x007e:
            r11.f29476f = r2
            r11.f29477g = r3
            android.view.VelocityTracker r12 = r11.f29480j
            if (r12 == 0) goto L_0x00ae
            r12.recycle()
            r12 = 0
            r11.f29480j = r12
            goto L_0x00ae
        L_0x008d:
            float r0 = r14.getX()
            int r0 = (int) r0
            float r3 = r14.getY()
            int r3 = (int) r3
            boolean r12 = r12.B(r13, r0, r3)
            if (r12 == 0) goto L_0x00b6
            boolean r12 = r11.G(r13)
            if (r12 == 0) goto L_0x00b6
            r11.f29478h = r3
            int r12 = r14.getPointerId(r2)
            r11.f29477g = r12
            r11.H()
        L_0x00ae:
            android.view.VelocityTracker r12 = r11.f29480j
            if (r12 == 0) goto L_0x00b5
            r12.addMovement(r14)
        L_0x00b5:
            return r1
        L_0x00b6:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.HeaderBehavior.C(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    /* access modifiers changed from: package-private */
    public boolean G(V v2) {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean I(CoordinatorLayout coordinatorLayout, V v2, int i2, int i3, float f2) {
        V v3 = v2;
        Runnable runnable = this.f29474d;
        if (runnable != null) {
            v2.removeCallbacks(runnable);
            this.f29474d = null;
        }
        if (this.f29475e == null) {
            this.f29475e = new OverScroller(v2.getContext());
        }
        this.f29475e.fling(0, D(), 0, Math.round(f2), 0, 0, i2, i3);
        if (this.f29475e.computeScrollOffset()) {
            CoordinatorLayout coordinatorLayout2 = coordinatorLayout;
            FlingRunnable flingRunnable = new FlingRunnable(coordinatorLayout, v2);
            this.f29474d = flingRunnable;
            ViewCompat.j0(v2, flingRunnable);
            return true;
        }
        CoordinatorLayout coordinatorLayout3 = coordinatorLayout;
        M(coordinatorLayout, v2);
        return false;
    }

    /* access modifiers changed from: package-private */
    public int J(V v2) {
        return -v2.getHeight();
    }

    /* access modifiers changed from: package-private */
    public int K(V v2) {
        return v2.getHeight();
    }

    /* access modifiers changed from: package-private */
    public int L() {
        return D();
    }

    /* access modifiers changed from: package-private */
    public void M(CoordinatorLayout coordinatorLayout, V v2) {
    }

    /* access modifiers changed from: package-private */
    public final int N(CoordinatorLayout coordinatorLayout, V v2, int i2, int i3, int i4) {
        return P(coordinatorLayout, v2, L() - i2, i3, i4);
    }

    /* access modifiers changed from: package-private */
    public int O(CoordinatorLayout coordinatorLayout, V v2, int i2) {
        return P(coordinatorLayout, v2, i2, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /* access modifiers changed from: package-private */
    public int P(CoordinatorLayout coordinatorLayout, V v2, int i2, int i3, int i4) {
        int b2;
        int D = D();
        if (i3 == 0 || D < i3 || D > i4 || D == (b2 = MathUtils.b(i2, i3, i4))) {
            return 0;
        }
        F(b2);
        return D - b2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002c, code lost:
        if (r0 != 3) goto L_0x0083;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean k(androidx.coordinatorlayout.widget.CoordinatorLayout r5, V r6, android.view.MotionEvent r7) {
        /*
            r4 = this;
            int r0 = r4.f29479i
            if (r0 >= 0) goto L_0x0012
            android.content.Context r0 = r5.getContext()
            android.view.ViewConfiguration r0 = android.view.ViewConfiguration.get(r0)
            int r0 = r0.getScaledTouchSlop()
            r4.f29479i = r0
        L_0x0012:
            int r0 = r7.getAction()
            r1 = 2
            r2 = 1
            if (r0 != r1) goto L_0x001f
            boolean r0 = r4.f29476f
            if (r0 == 0) goto L_0x001f
            return r2
        L_0x001f:
            int r0 = r7.getActionMasked()
            r3 = 0
            if (r0 == 0) goto L_0x0060
            r5 = -1
            if (r0 == r2) goto L_0x0051
            if (r0 == r1) goto L_0x002f
            r6 = 3
            if (r0 == r6) goto L_0x0051
            goto L_0x0083
        L_0x002f:
            int r6 = r4.f29477g
            if (r6 != r5) goto L_0x0034
            goto L_0x0083
        L_0x0034:
            int r6 = r7.findPointerIndex(r6)
            if (r6 != r5) goto L_0x003b
            goto L_0x0083
        L_0x003b:
            float r5 = r7.getY(r6)
            int r5 = (int) r5
            int r6 = r4.f29478h
            int r6 = r5 - r6
            int r6 = java.lang.Math.abs(r6)
            int r0 = r4.f29479i
            if (r6 <= r0) goto L_0x0083
            r4.f29476f = r2
            r4.f29478h = r5
            goto L_0x0083
        L_0x0051:
            r4.f29476f = r3
            r4.f29477g = r5
            android.view.VelocityTracker r5 = r4.f29480j
            if (r5 == 0) goto L_0x0083
            r5.recycle()
            r5 = 0
            r4.f29480j = r5
            goto L_0x0083
        L_0x0060:
            r4.f29476f = r3
            float r0 = r7.getX()
            int r0 = (int) r0
            float r1 = r7.getY()
            int r1 = (int) r1
            boolean r2 = r4.G(r6)
            if (r2 == 0) goto L_0x0083
            boolean r5 = r5.B(r6, r0, r1)
            if (r5 == 0) goto L_0x0083
            r4.f29478h = r1
            int r5 = r7.getPointerId(r3)
            r4.f29477g = r5
            r4.H()
        L_0x0083:
            android.view.VelocityTracker r5 = r4.f29480j
            if (r5 == 0) goto L_0x008a
            r5.addMovement(r7)
        L_0x008a:
            boolean r5 = r4.f29476f
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.HeaderBehavior.k(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    public HeaderBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
