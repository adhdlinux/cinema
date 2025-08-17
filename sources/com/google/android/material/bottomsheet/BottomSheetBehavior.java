package com.google.android.material.bottomsheet;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import com.google.android.material.R$dimen;
import com.google.android.material.R$styleable;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public boolean f29594a = true;

    /* renamed from: b  reason: collision with root package name */
    private float f29595b;

    /* renamed from: c  reason: collision with root package name */
    private int f29596c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f29597d;

    /* renamed from: e  reason: collision with root package name */
    private int f29598e;

    /* renamed from: f  reason: collision with root package name */
    private int f29599f;

    /* renamed from: g  reason: collision with root package name */
    int f29600g;

    /* renamed from: h  reason: collision with root package name */
    int f29601h;

    /* renamed from: i  reason: collision with root package name */
    int f29602i;

    /* renamed from: j  reason: collision with root package name */
    boolean f29603j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f29604k;

    /* renamed from: l  reason: collision with root package name */
    int f29605l = 4;

    /* renamed from: m  reason: collision with root package name */
    ViewDragHelper f29606m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f29607n;

    /* renamed from: o  reason: collision with root package name */
    private int f29608o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f29609p;

    /* renamed from: q  reason: collision with root package name */
    int f29610q;

    /* renamed from: r  reason: collision with root package name */
    WeakReference<V> f29611r;

    /* renamed from: s  reason: collision with root package name */
    WeakReference<View> f29612s;

    /* renamed from: t  reason: collision with root package name */
    private BottomSheetCallback f29613t;

    /* renamed from: u  reason: collision with root package name */
    private VelocityTracker f29614u;

    /* renamed from: v  reason: collision with root package name */
    int f29615v;

    /* renamed from: w  reason: collision with root package name */
    private int f29616w;

    /* renamed from: x  reason: collision with root package name */
    boolean f29617x;

    /* renamed from: y  reason: collision with root package name */
    private Map<View, Integer> f29618y;

    /* renamed from: z  reason: collision with root package name */
    private final ViewDragHelper.Callback f29619z = new ViewDragHelper.Callback() {
        public int a(View view, int i2, int i3) {
            return view.getLeft();
        }

        public int b(View view, int i2, int i3) {
            int i4;
            int E = BottomSheetBehavior.this.J();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            if (bottomSheetBehavior.f29603j) {
                i4 = bottomSheetBehavior.f29610q;
            } else {
                i4 = bottomSheetBehavior.f29602i;
            }
            return MathUtils.b(i2, E, i4);
        }

        public int e(View view) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            if (bottomSheetBehavior.f29603j) {
                return bottomSheetBehavior.f29610q;
            }
            return bottomSheetBehavior.f29602i;
        }

        public void j(int i2) {
            if (i2 == 1) {
                BottomSheetBehavior.this.T(1);
            }
        }

        public void k(View view, int i2, int i3, int i4, int i5) {
            BottomSheetBehavior.this.G(i3);
        }

        /* JADX WARNING: Removed duplicated region for block: B:42:0x00d6  */
        /* JADX WARNING: Removed duplicated region for block: B:43:0x00e7  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void l(android.view.View r7, float r8, float r9) {
            /*
                r6 = this;
                r0 = 0
                r1 = 6
                r2 = 3
                r3 = 0
                int r4 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
                if (r4 >= 0) goto L_0x0027
                com.google.android.material.bottomsheet.BottomSheetBehavior r8 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r8 = r8.f29594a
                if (r8 == 0) goto L_0x0016
                com.google.android.material.bottomsheet.BottomSheetBehavior r8 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r8 = r8.f29600g
                goto L_0x00c8
            L_0x0016:
                int r8 = r7.getTop()
                com.google.android.material.bottomsheet.BottomSheetBehavior r9 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r9 = r9.f29601h
                if (r8 <= r9) goto L_0x0022
                r0 = r9
                goto L_0x0023
            L_0x0022:
                r1 = 3
            L_0x0023:
                r8 = r0
                r2 = r1
                goto L_0x00c8
            L_0x0027:
                com.google.android.material.bottomsheet.BottomSheetBehavior r4 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r5 = r4.f29603j
                if (r5 == 0) goto L_0x0050
                boolean r4 = r4.U(r7, r9)
                if (r4 == 0) goto L_0x0050
                int r4 = r7.getTop()
                com.google.android.material.bottomsheet.BottomSheetBehavior r5 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r5 = r5.f29602i
                if (r4 > r5) goto L_0x0049
                float r4 = java.lang.Math.abs(r8)
                float r5 = java.lang.Math.abs(r9)
                int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
                if (r4 >= 0) goto L_0x0050
            L_0x0049:
                com.google.android.material.bottomsheet.BottomSheetBehavior r8 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r8 = r8.f29610q
                r2 = 5
                goto L_0x00c8
            L_0x0050:
                r4 = 4
                int r3 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
                if (r3 == 0) goto L_0x0068
                float r8 = java.lang.Math.abs(r8)
                float r9 = java.lang.Math.abs(r9)
                int r8 = (r8 > r9 ? 1 : (r8 == r9 ? 0 : -1))
                if (r8 <= 0) goto L_0x0062
                goto L_0x0068
            L_0x0062:
                com.google.android.material.bottomsheet.BottomSheetBehavior r8 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r8 = r8.f29602i
                r2 = 4
                goto L_0x00c8
            L_0x0068:
                int r8 = r7.getTop()
                com.google.android.material.bottomsheet.BottomSheetBehavior r9 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r9 = r9.f29594a
                if (r9 == 0) goto L_0x0094
                com.google.android.material.bottomsheet.BottomSheetBehavior r9 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r9 = r9.f29600g
                int r9 = r8 - r9
                int r9 = java.lang.Math.abs(r9)
                com.google.android.material.bottomsheet.BottomSheetBehavior r0 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r0 = r0.f29602i
                int r8 = r8 - r0
                int r8 = java.lang.Math.abs(r8)
                if (r9 >= r8) goto L_0x008e
                com.google.android.material.bottomsheet.BottomSheetBehavior r8 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r0 = r8.f29600g
                goto L_0x0022
            L_0x008e:
                com.google.android.material.bottomsheet.BottomSheetBehavior r8 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r0 = r8.f29602i
            L_0x0092:
                r1 = 4
                goto L_0x0023
            L_0x0094:
                com.google.android.material.bottomsheet.BottomSheetBehavior r9 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r3 = r9.f29601h
                if (r8 >= r3) goto L_0x00ac
                int r9 = r9.f29602i
                int r9 = r8 - r9
                int r9 = java.lang.Math.abs(r9)
                if (r8 >= r9) goto L_0x00a6
                goto L_0x0022
            L_0x00a6:
                com.google.android.material.bottomsheet.BottomSheetBehavior r8 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r0 = r8.f29601h
                goto L_0x0023
            L_0x00ac:
                int r9 = r8 - r3
                int r9 = java.lang.Math.abs(r9)
                com.google.android.material.bottomsheet.BottomSheetBehavior r0 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r0 = r0.f29602i
                int r8 = r8 - r0
                int r8 = java.lang.Math.abs(r8)
                if (r9 >= r8) goto L_0x00c3
                com.google.android.material.bottomsheet.BottomSheetBehavior r8 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r0 = r8.f29601h
                goto L_0x0023
            L_0x00c3:
                com.google.android.material.bottomsheet.BottomSheetBehavior r8 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r0 = r8.f29602i
                goto L_0x0092
            L_0x00c8:
                com.google.android.material.bottomsheet.BottomSheetBehavior r9 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                androidx.customview.widget.ViewDragHelper r9 = r9.f29606m
                int r0 = r7.getLeft()
                boolean r8 = r9.N(r0, r8)
                if (r8 == 0) goto L_0x00e7
                com.google.android.material.bottomsheet.BottomSheetBehavior r8 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                r9 = 2
                r8.T(r9)
                com.google.android.material.bottomsheet.BottomSheetBehavior$SettleRunnable r8 = new com.google.android.material.bottomsheet.BottomSheetBehavior$SettleRunnable
                com.google.android.material.bottomsheet.BottomSheetBehavior r9 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                r8.<init>(r7, r2)
                androidx.core.view.ViewCompat.j0(r7, r8)
                goto L_0x00ec
            L_0x00e7:
                com.google.android.material.bottomsheet.BottomSheetBehavior r7 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                r7.T(r2)
            L_0x00ec:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.AnonymousClass2.l(android.view.View, float, float):void");
        }

        public boolean m(View view, int i2) {
            WeakReference<V> weakReference;
            View view2;
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            int i3 = bottomSheetBehavior.f29605l;
            if (i3 == 1 || bottomSheetBehavior.f29617x) {
                return false;
            }
            if ((i3 != 3 || bottomSheetBehavior.f29615v != i2 || (view2 = bottomSheetBehavior.f29612s.get()) == null || !view2.canScrollVertically(-1)) && (weakReference = BottomSheetBehavior.this.f29611r) != null && weakReference.get() == view) {
                return true;
            }
            return false;
        }
    };

    public static abstract class BottomSheetCallback {
        public abstract void a(View view, float f2);

        public abstract void b(View view, int i2);
    }

    private class SettleRunnable implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final View f29625b;

        /* renamed from: c  reason: collision with root package name */
        private final int f29626c;

        SettleRunnable(View view, int i2) {
            this.f29625b = view;
            this.f29626c = i2;
        }

        public void run() {
            ViewDragHelper viewDragHelper = BottomSheetBehavior.this.f29606m;
            if (viewDragHelper == null || !viewDragHelper.n(true)) {
                BottomSheetBehavior.this.T(this.f29626c);
            } else {
                ViewCompat.j0(this.f29625b, this);
            }
        }
    }

    public BottomSheetBehavior() {
    }

    private void F() {
        if (this.f29594a) {
            this.f29602i = Math.max(this.f29610q - this.f29599f, this.f29600g);
        } else {
            this.f29602i = this.f29610q - this.f29599f;
        }
    }

    public static <V extends View> BottomSheetBehavior<V> I(V v2) {
        ViewGroup.LayoutParams layoutParams = v2.getLayoutParams();
        if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.Behavior f2 = ((CoordinatorLayout.LayoutParams) layoutParams).f();
            if (f2 instanceof BottomSheetBehavior) {
                return (BottomSheetBehavior) f2;
            }
            throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
        }
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }

    /* access modifiers changed from: private */
    public int J() {
        if (this.f29594a) {
            return this.f29600g;
        }
        return 0;
    }

    private float L() {
        VelocityTracker velocityTracker = this.f29614u;
        if (velocityTracker == null) {
            return 0.0f;
        }
        velocityTracker.computeCurrentVelocity(1000, this.f29595b);
        return this.f29614u.getYVelocity(this.f29615v);
    }

    private void M() {
        this.f29615v = -1;
        VelocityTracker velocityTracker = this.f29614u;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f29614u = null;
        }
    }

    private void W(boolean z2) {
        WeakReference<V> weakReference = this.f29611r;
        if (weakReference != null) {
            ViewParent parent = ((View) weakReference.get()).getParent();
            if (parent instanceof CoordinatorLayout) {
                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
                int childCount = coordinatorLayout.getChildCount();
                if (z2) {
                    if (this.f29618y == null) {
                        this.f29618y = new HashMap(childCount);
                    } else {
                        return;
                    }
                }
                for (int i2 = 0; i2 < childCount; i2++) {
                    V childAt = coordinatorLayout.getChildAt(i2);
                    if (childAt != this.f29611r.get()) {
                        if (!z2) {
                            Map<View, Integer> map = this.f29618y;
                            if (map != null && map.containsKey(childAt)) {
                                ViewCompat.C0(childAt, this.f29618y.get(childAt).intValue());
                            }
                        } else {
                            this.f29618y.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                            ViewCompat.C0(childAt, 4);
                        }
                    }
                }
                if (!z2) {
                    this.f29618y = null;
                }
            }
        }
    }

    public void B(CoordinatorLayout coordinatorLayout, V v2, View view, int i2) {
        int i3;
        int i4;
        int i5 = 3;
        if (v2.getTop() == J()) {
            T(3);
        } else if (view == this.f29612s.get() && this.f29609p) {
            if (this.f29608o > 0) {
                i3 = J();
            } else if (!this.f29603j || !U(v2, L())) {
                if (this.f29608o == 0) {
                    int top = v2.getTop();
                    if (!this.f29594a) {
                        int i6 = this.f29601h;
                        if (top < i6) {
                            if (top < Math.abs(top - this.f29602i)) {
                                i3 = 0;
                            } else {
                                i3 = this.f29601h;
                            }
                        } else if (Math.abs(top - i6) < Math.abs(top - this.f29602i)) {
                            i3 = this.f29601h;
                        } else {
                            i4 = this.f29602i;
                        }
                        i5 = 6;
                    } else if (Math.abs(top - this.f29600g) < Math.abs(top - this.f29602i)) {
                        i3 = this.f29600g;
                    } else {
                        i4 = this.f29602i;
                    }
                } else {
                    i4 = this.f29602i;
                }
                i5 = 4;
            } else {
                i3 = this.f29610q;
                i5 = 5;
            }
            if (this.f29606m.P(v2, v2.getLeft(), i3)) {
                T(2);
                ViewCompat.j0(v2, new SettleRunnable(v2, i5));
            } else {
                T(i5);
            }
            this.f29609p = false;
        }
    }

    public boolean C(CoordinatorLayout coordinatorLayout, V v2, MotionEvent motionEvent) {
        if (!v2.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.f29605l == 1 && actionMasked == 0) {
            return true;
        }
        ViewDragHelper viewDragHelper = this.f29606m;
        if (viewDragHelper != null) {
            viewDragHelper.F(motionEvent);
        }
        if (actionMasked == 0) {
            M();
        }
        if (this.f29614u == null) {
            this.f29614u = VelocityTracker.obtain();
        }
        this.f29614u.addMovement(motionEvent);
        if (actionMasked == 2 && !this.f29607n && Math.abs(((float) this.f29616w) - motionEvent.getY()) > ((float) this.f29606m.z())) {
            this.f29606m.c(v2, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.f29607n;
    }

    /* access modifiers changed from: package-private */
    public void G(int i2) {
        BottomSheetCallback bottomSheetCallback;
        View view = (View) this.f29611r.get();
        if (view != null && (bottomSheetCallback = this.f29613t) != null) {
            int i3 = this.f29602i;
            if (i2 > i3) {
                bottomSheetCallback.a(view, ((float) (i3 - i2)) / ((float) (this.f29610q - i3)));
            } else {
                bottomSheetCallback.a(view, ((float) (i3 - i2)) / ((float) (i3 - J())));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public View H(View view) {
        if (ViewCompat.W(view)) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View H = H(viewGroup.getChildAt(i2));
            if (H != null) {
                return H;
            }
        }
        return null;
    }

    public final int K() {
        return this.f29605l;
    }

    public void N(BottomSheetCallback bottomSheetCallback) {
        this.f29613t = bottomSheetCallback;
    }

    public void O(boolean z2) {
        int i2;
        if (this.f29594a != z2) {
            this.f29594a = z2;
            if (this.f29611r != null) {
                F();
            }
            if (!this.f29594a || this.f29605l != 6) {
                i2 = this.f29605l;
            } else {
                i2 = 3;
            }
            T(i2);
        }
    }

    public void P(boolean z2) {
        this.f29603j = z2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void Q(int r4) {
        /*
            r3 = this;
            r0 = -1
            r1 = 1
            r2 = 0
            if (r4 != r0) goto L_0x000c
            boolean r4 = r3.f29597d
            if (r4 != 0) goto L_0x0015
            r3.f29597d = r1
            goto L_0x0024
        L_0x000c:
            boolean r0 = r3.f29597d
            if (r0 != 0) goto L_0x0017
            int r0 = r3.f29596c
            if (r0 == r4) goto L_0x0015
            goto L_0x0017
        L_0x0015:
            r1 = 0
            goto L_0x0024
        L_0x0017:
            r3.f29597d = r2
            int r0 = java.lang.Math.max(r2, r4)
            r3.f29596c = r0
            int r0 = r3.f29610q
            int r0 = r0 - r4
            r3.f29602i = r0
        L_0x0024:
            if (r1 == 0) goto L_0x003a
            int r4 = r3.f29605l
            r0 = 4
            if (r4 != r0) goto L_0x003a
            java.lang.ref.WeakReference<V> r4 = r3.f29611r
            if (r4 == 0) goto L_0x003a
            java.lang.Object r4 = r4.get()
            android.view.View r4 = (android.view.View) r4
            if (r4 == 0) goto L_0x003a
            r4.requestLayout()
        L_0x003a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.Q(int):void");
    }

    public void R(boolean z2) {
        this.f29604k = z2;
    }

    public final void S(final int i2) {
        if (i2 != this.f29605l) {
            WeakReference<V> weakReference = this.f29611r;
            if (weakReference != null) {
                final View view = (View) weakReference.get();
                if (view != null) {
                    ViewParent parent = view.getParent();
                    if (parent == null || !parent.isLayoutRequested() || !ViewCompat.U(view)) {
                        V(view, i2);
                    } else {
                        view.post(new Runnable() {
                            public void run() {
                                BottomSheetBehavior.this.V(view, i2);
                            }
                        });
                    }
                }
            } else if (i2 == 4 || i2 == 3 || i2 == 6 || (this.f29603j && i2 == 5)) {
                this.f29605l = i2;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void T(int i2) {
        BottomSheetCallback bottomSheetCallback;
        if (this.f29605l != i2) {
            this.f29605l = i2;
            if (i2 == 6 || i2 == 3) {
                W(true);
            } else if (i2 == 5 || i2 == 4) {
                W(false);
            }
            View view = (View) this.f29611r.get();
            if (view != null && (bottomSheetCallback = this.f29613t) != null) {
                bottomSheetCallback.b(view, i2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean U(View view, float f2) {
        if (this.f29604k) {
            return true;
        }
        if (view.getTop() >= this.f29602i && Math.abs((((float) view.getTop()) + (f2 * 0.1f)) - ((float) this.f29602i)) / ((float) this.f29596c) > 0.5f) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void V(View view, int i2) {
        int i3;
        int i4;
        if (i2 == 4) {
            i3 = this.f29602i;
        } else if (i2 == 6) {
            i3 = this.f29601h;
            if (this.f29594a && i3 <= (i4 = this.f29600g)) {
                i3 = i4;
                i2 = 3;
            }
        } else if (i2 == 3) {
            i3 = J();
        } else if (!this.f29603j || i2 != 5) {
            throw new IllegalArgumentException("Illegal state argument: " + i2);
        } else {
            i3 = this.f29610q;
        }
        if (this.f29606m.P(view, view.getLeft(), i3)) {
            T(2);
            ViewCompat.j0(view, new SettleRunnable(view, i2));
            return;
        }
        T(i2);
    }

    public boolean k(CoordinatorLayout coordinatorLayout, V v2, MotionEvent motionEvent) {
        ViewDragHelper viewDragHelper;
        View view;
        boolean z2;
        if (!v2.isShown()) {
            this.f29607n = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            M();
        }
        if (this.f29614u == null) {
            this.f29614u = VelocityTracker.obtain();
        }
        this.f29614u.addMovement(motionEvent);
        View view2 = null;
        if (actionMasked == 0) {
            int x2 = (int) motionEvent.getX();
            this.f29616w = (int) motionEvent.getY();
            WeakReference<View> weakReference = this.f29612s;
            if (weakReference != null) {
                view = weakReference.get();
            } else {
                view = null;
            }
            if (view != null && coordinatorLayout.B(view, x2, this.f29616w)) {
                this.f29615v = motionEvent.getPointerId(motionEvent.getActionIndex());
                this.f29617x = true;
            }
            if (this.f29615v != -1 || coordinatorLayout.B(v2, x2, this.f29616w)) {
                z2 = false;
            } else {
                z2 = true;
            }
            this.f29607n = z2;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f29617x = false;
            this.f29615v = -1;
            if (this.f29607n) {
                this.f29607n = false;
                return false;
            }
        }
        if (!this.f29607n && (viewDragHelper = this.f29606m) != null && viewDragHelper.O(motionEvent)) {
            return true;
        }
        WeakReference<View> weakReference2 = this.f29612s;
        if (weakReference2 != null) {
            view2 = weakReference2.get();
        }
        if (actionMasked != 2 || view2 == null || this.f29607n || this.f29605l == 1 || coordinatorLayout.B(view2, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.f29606m == null || Math.abs(((float) this.f29616w) - motionEvent.getY()) <= ((float) this.f29606m.z())) {
            return false;
        }
        return true;
    }

    public boolean l(CoordinatorLayout coordinatorLayout, V v2, int i2) {
        if (ViewCompat.A(coordinatorLayout) && !ViewCompat.A(v2)) {
            v2.setFitsSystemWindows(true);
        }
        int top = v2.getTop();
        coordinatorLayout.I(v2, i2);
        this.f29610q = coordinatorLayout.getHeight();
        if (this.f29597d) {
            if (this.f29598e == 0) {
                this.f29598e = coordinatorLayout.getResources().getDimensionPixelSize(R$dimen.design_bottom_sheet_peek_height_min);
            }
            this.f29599f = Math.max(this.f29598e, this.f29610q - ((coordinatorLayout.getWidth() * 9) / 16));
        } else {
            this.f29599f = this.f29596c;
        }
        this.f29600g = Math.max(0, this.f29610q - v2.getHeight());
        this.f29601h = this.f29610q / 2;
        F();
        int i3 = this.f29605l;
        if (i3 == 3) {
            ViewCompat.c0(v2, J());
        } else if (i3 == 6) {
            ViewCompat.c0(v2, this.f29601h);
        } else if (this.f29603j && i3 == 5) {
            ViewCompat.c0(v2, this.f29610q);
        } else if (i3 == 4) {
            ViewCompat.c0(v2, this.f29602i);
        } else if (i3 == 1 || i3 == 2) {
            ViewCompat.c0(v2, top - v2.getTop());
        }
        if (this.f29606m == null) {
            this.f29606m = ViewDragHelper.p(coordinatorLayout, this.f29619z);
        }
        this.f29611r = new WeakReference<>(v2);
        this.f29612s = new WeakReference<>(H(v2));
        return true;
    }

    public boolean o(CoordinatorLayout coordinatorLayout, V v2, View view, float f2, float f3) {
        if (view != this.f29612s.get() || (this.f29605l == 3 && !super.o(coordinatorLayout, v2, view, f2, f3))) {
            return false;
        }
        return true;
    }

    public void q(CoordinatorLayout coordinatorLayout, V v2, View view, int i2, int i3, int[] iArr, int i4) {
        if (i4 != 1 && view == this.f29612s.get()) {
            int top = v2.getTop();
            int i5 = top - i3;
            if (i3 > 0) {
                if (i5 < J()) {
                    int J = top - J();
                    iArr[1] = J;
                    ViewCompat.c0(v2, -J);
                    T(3);
                } else {
                    iArr[1] = i3;
                    ViewCompat.c0(v2, -i3);
                    T(1);
                }
            } else if (i3 < 0 && !view.canScrollVertically(-1)) {
                int i6 = this.f29602i;
                if (i5 <= i6 || this.f29603j) {
                    iArr[1] = i3;
                    ViewCompat.c0(v2, -i3);
                    T(1);
                } else {
                    int i7 = top - i6;
                    iArr[1] = i7;
                    ViewCompat.c0(v2, -i7);
                    T(4);
                }
            }
            G(v2.getTop());
            this.f29608o = i3;
            this.f29609p = true;
        }
    }

    public void w(CoordinatorLayout coordinatorLayout, V v2, Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.w(coordinatorLayout, v2, savedState.b());
        int i2 = savedState.f29624d;
        if (i2 == 1 || i2 == 2) {
            this.f29605l = 4;
        } else {
            this.f29605l = i2;
        }
    }

    public Parcelable x(CoordinatorLayout coordinatorLayout, V v2) {
        return new SavedState(super.x(coordinatorLayout, v2), this.f29605l);
    }

    public boolean z(CoordinatorLayout coordinatorLayout, V v2, View view, View view2, int i2, int i3) {
        this.f29608o = 0;
        this.f29609p = false;
        if ((i2 & 2) != 0) {
            return true;
        }
        return false;
    }

    protected static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            /* renamed from: b */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            /* renamed from: c */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        };

        /* renamed from: d  reason: collision with root package name */
        final int f29624d;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f29624d = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f29624d);
        }

        public SavedState(Parcelable parcelable, int i2) {
            super(parcelable);
            this.f29624d = i2;
        }
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int i2;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.O);
        int i3 = R$styleable.R;
        TypedValue peekValue = obtainStyledAttributes.peekValue(i3);
        if (peekValue == null || (i2 = peekValue.data) != -1) {
            Q(obtainStyledAttributes.getDimensionPixelSize(i3, -1));
        } else {
            Q(i2);
        }
        P(obtainStyledAttributes.getBoolean(R$styleable.Q, false));
        O(obtainStyledAttributes.getBoolean(R$styleable.P, true));
        R(obtainStyledAttributes.getBoolean(R$styleable.S, false));
        obtainStyledAttributes.recycle();
        this.f29595b = (float) ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }
}
