package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;

public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* renamed from: a  reason: collision with root package name */
    ViewDragHelper f29501a;

    /* renamed from: b  reason: collision with root package name */
    OnDismissListener f29502b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f29503c;

    /* renamed from: d  reason: collision with root package name */
    private float f29504d = 0.0f;

    /* renamed from: e  reason: collision with root package name */
    private boolean f29505e;

    /* renamed from: f  reason: collision with root package name */
    int f29506f = 2;

    /* renamed from: g  reason: collision with root package name */
    float f29507g = 0.5f;

    /* renamed from: h  reason: collision with root package name */
    float f29508h = 0.0f;

    /* renamed from: i  reason: collision with root package name */
    float f29509i = 0.5f;

    /* renamed from: j  reason: collision with root package name */
    private final ViewDragHelper.Callback f29510j = new ViewDragHelper.Callback() {

        /* renamed from: a  reason: collision with root package name */
        private int f29511a;

        /* renamed from: b  reason: collision with root package name */
        private int f29512b = -1;

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0023 A[ORIG_RETURN, RETURN, SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0030 A[ORIG_RETURN, RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private boolean n(android.view.View r7, float r8) {
            /*
                r6 = this;
                r0 = 0
                r1 = 1
                r2 = 0
                int r3 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
                if (r3 == 0) goto L_0x0032
                int r7 = androidx.core.view.ViewCompat.D(r7)
                if (r7 != r1) goto L_0x000f
                r7 = 1
                goto L_0x0010
            L_0x000f:
                r7 = 0
            L_0x0010:
                com.google.android.material.behavior.SwipeDismissBehavior r4 = com.google.android.material.behavior.SwipeDismissBehavior.this
                int r4 = r4.f29506f
                r5 = 2
                if (r4 != r5) goto L_0x0018
                return r1
            L_0x0018:
                if (r4 != 0) goto L_0x0025
                if (r7 == 0) goto L_0x0021
                int r7 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
                if (r7 >= 0) goto L_0x0024
                goto L_0x0023
            L_0x0021:
                if (r3 <= 0) goto L_0x0024
            L_0x0023:
                r0 = 1
            L_0x0024:
                return r0
            L_0x0025:
                if (r4 != r1) goto L_0x0031
                if (r7 == 0) goto L_0x002c
                if (r3 <= 0) goto L_0x0031
                goto L_0x0030
            L_0x002c:
                int r7 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
                if (r7 >= 0) goto L_0x0031
            L_0x0030:
                r0 = 1
            L_0x0031:
                return r0
            L_0x0032:
                int r8 = r7.getLeft()
                int r2 = r6.f29511a
                int r8 = r8 - r2
                int r7 = r7.getWidth()
                float r7 = (float) r7
                com.google.android.material.behavior.SwipeDismissBehavior r2 = com.google.android.material.behavior.SwipeDismissBehavior.this
                float r2 = r2.f29507g
                float r7 = r7 * r2
                int r7 = java.lang.Math.round(r7)
                int r8 = java.lang.Math.abs(r8)
                if (r8 < r7) goto L_0x004f
                r0 = 1
            L_0x004f:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.behavior.SwipeDismissBehavior.AnonymousClass1.n(android.view.View, float):boolean");
        }

        public int a(View view, int i2, int i3) {
            boolean z2;
            int i4;
            int i5;
            int width;
            if (ViewCompat.D(view) == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            int i6 = SwipeDismissBehavior.this.f29506f;
            if (i6 != 0) {
                if (i6 != 1) {
                    i4 = this.f29511a - view.getWidth();
                    i5 = view.getWidth() + this.f29511a;
                } else if (z2) {
                    i4 = this.f29511a;
                    width = view.getWidth();
                } else {
                    i4 = this.f29511a - view.getWidth();
                    i5 = this.f29511a;
                }
                return SwipeDismissBehavior.F(i4, i2, i5);
            } else if (z2) {
                i4 = this.f29511a - view.getWidth();
                i5 = this.f29511a;
                return SwipeDismissBehavior.F(i4, i2, i5);
            } else {
                i4 = this.f29511a;
                width = view.getWidth();
            }
            i5 = width + i4;
            return SwipeDismissBehavior.F(i4, i2, i5);
        }

        public int b(View view, int i2, int i3) {
            return view.getTop();
        }

        public int d(View view) {
            return view.getWidth();
        }

        public void i(View view, int i2) {
            this.f29512b = i2;
            this.f29511a = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }

        public void j(int i2) {
            OnDismissListener onDismissListener = SwipeDismissBehavior.this.f29502b;
            if (onDismissListener != null) {
                onDismissListener.b(i2);
            }
        }

        public void k(View view, int i2, int i3, int i4, int i5) {
            float width = ((float) this.f29511a) + (((float) view.getWidth()) * SwipeDismissBehavior.this.f29508h);
            float width2 = ((float) this.f29511a) + (((float) view.getWidth()) * SwipeDismissBehavior.this.f29509i);
            float f2 = (float) i2;
            if (f2 <= width) {
                view.setAlpha(1.0f);
            } else if (f2 >= width2) {
                view.setAlpha(0.0f);
            } else {
                view.setAlpha(SwipeDismissBehavior.E(0.0f, 1.0f - SwipeDismissBehavior.H(width, width2, f2), 1.0f));
            }
        }

        public void l(View view, float f2, float f3) {
            boolean z2;
            int i2;
            OnDismissListener onDismissListener;
            this.f29512b = -1;
            int width = view.getWidth();
            if (n(view, f2)) {
                int left = view.getLeft();
                int i3 = this.f29511a;
                if (left < i3) {
                    i2 = i3 - width;
                } else {
                    i2 = i3 + width;
                }
                z2 = true;
            } else {
                i2 = this.f29511a;
                z2 = false;
            }
            if (SwipeDismissBehavior.this.f29501a.N(i2, view.getTop())) {
                ViewCompat.j0(view, new SettleRunnable(view, z2));
            } else if (z2 && (onDismissListener = SwipeDismissBehavior.this.f29502b) != null) {
                onDismissListener.a(view);
            }
        }

        public boolean m(View view, int i2) {
            return this.f29512b == -1 && SwipeDismissBehavior.this.D(view);
        }
    };

    public interface OnDismissListener {
        void a(View view);

        void b(int i2);
    }

    private class SettleRunnable implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final View f29514b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f29515c;

        SettleRunnable(View view, boolean z2) {
            this.f29514b = view;
            this.f29515c = z2;
        }

        public void run() {
            OnDismissListener onDismissListener;
            ViewDragHelper viewDragHelper = SwipeDismissBehavior.this.f29501a;
            if (viewDragHelper != null && viewDragHelper.n(true)) {
                ViewCompat.j0(this.f29514b, this);
            } else if (this.f29515c && (onDismissListener = SwipeDismissBehavior.this.f29502b) != null) {
                onDismissListener.a(this.f29514b);
            }
        }
    }

    static float E(float f2, float f3, float f4) {
        return Math.min(Math.max(f2, f3), f4);
    }

    static int F(int i2, int i3, int i4) {
        return Math.min(Math.max(i2, i3), i4);
    }

    private void G(ViewGroup viewGroup) {
        ViewDragHelper viewDragHelper;
        if (this.f29501a == null) {
            if (this.f29505e) {
                viewDragHelper = ViewDragHelper.o(viewGroup, this.f29504d, this.f29510j);
            } else {
                viewDragHelper = ViewDragHelper.p(viewGroup, this.f29510j);
            }
            this.f29501a = viewDragHelper;
        }
    }

    static float H(float f2, float f3, float f4) {
        return (f4 - f2) / (f3 - f2);
    }

    public boolean C(CoordinatorLayout coordinatorLayout, V v2, MotionEvent motionEvent) {
        ViewDragHelper viewDragHelper = this.f29501a;
        if (viewDragHelper == null) {
            return false;
        }
        viewDragHelper.F(motionEvent);
        return true;
    }

    public boolean D(View view) {
        return true;
    }

    public int I() {
        ViewDragHelper viewDragHelper = this.f29501a;
        if (viewDragHelper != null) {
            return viewDragHelper.A();
        }
        return 0;
    }

    public void J(float f2) {
        this.f29509i = E(0.0f, f2, 1.0f);
    }

    public void K(OnDismissListener onDismissListener) {
        this.f29502b = onDismissListener;
    }

    public void L(float f2) {
        this.f29508h = E(0.0f, f2, 1.0f);
    }

    public void M(int i2) {
        this.f29506f = i2;
    }

    public boolean k(CoordinatorLayout coordinatorLayout, V v2, MotionEvent motionEvent) {
        boolean z2 = this.f29503c;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            z2 = coordinatorLayout.B(v2, (int) motionEvent.getX(), (int) motionEvent.getY());
            this.f29503c = z2;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f29503c = false;
        }
        if (!z2) {
            return false;
        }
        G(coordinatorLayout);
        return this.f29501a.O(motionEvent);
    }
}
