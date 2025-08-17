package androidx.slidingpanelayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.content.ContextCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import java.util.ArrayList;

public class SlidingPaneLayout extends ViewGroup {

    /* renamed from: b  reason: collision with root package name */
    private int f11573b = -858993460;

    /* renamed from: c  reason: collision with root package name */
    private int f11574c;

    /* renamed from: d  reason: collision with root package name */
    private Drawable f11575d;

    /* renamed from: e  reason: collision with root package name */
    private Drawable f11576e;

    /* renamed from: f  reason: collision with root package name */
    private final int f11577f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f11578g;

    /* renamed from: h  reason: collision with root package name */
    View f11579h;

    /* renamed from: i  reason: collision with root package name */
    float f11580i;

    /* renamed from: j  reason: collision with root package name */
    private float f11581j;

    /* renamed from: k  reason: collision with root package name */
    int f11582k;

    /* renamed from: l  reason: collision with root package name */
    boolean f11583l;

    /* renamed from: m  reason: collision with root package name */
    private int f11584m;

    /* renamed from: n  reason: collision with root package name */
    private float f11585n;

    /* renamed from: o  reason: collision with root package name */
    private float f11586o;

    /* renamed from: p  reason: collision with root package name */
    final ViewDragHelper f11587p;

    /* renamed from: q  reason: collision with root package name */
    boolean f11588q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f11589r = true;

    /* renamed from: s  reason: collision with root package name */
    private final Rect f11590s = new Rect();

    /* renamed from: t  reason: collision with root package name */
    final ArrayList<DisableLayerRunnable> f11591t = new ArrayList<>();

    class AccessibilityDelegate extends AccessibilityDelegateCompat {

        /* renamed from: a  reason: collision with root package name */
        private final Rect f11592a = new Rect();

        AccessibilityDelegate() {
        }

        private void a(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2) {
            Rect rect = this.f11592a;
            accessibilityNodeInfoCompat2.l(rect);
            accessibilityNodeInfoCompat.X(rect);
            accessibilityNodeInfoCompat2.m(rect);
            accessibilityNodeInfoCompat.Y(rect);
            accessibilityNodeInfoCompat.H0(accessibilityNodeInfoCompat2.N());
            accessibilityNodeInfoCompat.s0(accessibilityNodeInfoCompat2.v());
            accessibilityNodeInfoCompat.c0(accessibilityNodeInfoCompat2.o());
            accessibilityNodeInfoCompat.g0(accessibilityNodeInfoCompat2.r());
            accessibilityNodeInfoCompat.j0(accessibilityNodeInfoCompat2.G());
            accessibilityNodeInfoCompat.d0(accessibilityNodeInfoCompat2.F());
            accessibilityNodeInfoCompat.l0(accessibilityNodeInfoCompat2.H());
            accessibilityNodeInfoCompat.m0(accessibilityNodeInfoCompat2.I());
            accessibilityNodeInfoCompat.V(accessibilityNodeInfoCompat2.C());
            accessibilityNodeInfoCompat.A0(accessibilityNodeInfoCompat2.M());
            accessibilityNodeInfoCompat.q0(accessibilityNodeInfoCompat2.J());
            accessibilityNodeInfoCompat.a(accessibilityNodeInfoCompat2.k());
            accessibilityNodeInfoCompat.r0(accessibilityNodeInfoCompat2.t());
        }

        public boolean b(View view) {
            return SlidingPaneLayout.this.h(view);
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(SlidingPaneLayout.class.getName());
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            AccessibilityNodeInfoCompat Q = AccessibilityNodeInfoCompat.Q(accessibilityNodeInfoCompat);
            super.onInitializeAccessibilityNodeInfo(view, Q);
            a(accessibilityNodeInfoCompat, Q);
            Q.S();
            accessibilityNodeInfoCompat.c0(SlidingPaneLayout.class.getName());
            accessibilityNodeInfoCompat.C0(view);
            ViewParent J = ViewCompat.J(view);
            if (J instanceof View) {
                accessibilityNodeInfoCompat.u0((View) J);
            }
            int childCount = SlidingPaneLayout.this.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = SlidingPaneLayout.this.getChildAt(i2);
                if (!b(childAt) && childAt.getVisibility() == 0) {
                    ViewCompat.C0(childAt, 1);
                    accessibilityNodeInfoCompat.c(childAt);
                }
            }
        }

        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (!b(view)) {
                return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
            }
            return false;
        }
    }

    private class DisableLayerRunnable implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final View f11594b;

        DisableLayerRunnable(View view) {
            this.f11594b = view;
        }

        public void run() {
            if (this.f11594b.getParent() == SlidingPaneLayout.this) {
                this.f11594b.setLayerType(0, (Paint) null);
                SlidingPaneLayout.this.g(this.f11594b);
            }
            SlidingPaneLayout.this.f11591t.remove(this);
        }
    }

    private class DragHelperCallback extends ViewDragHelper.Callback {
        DragHelperCallback() {
        }

        public int a(View view, int i2, int i3) {
            LayoutParams layoutParams = (LayoutParams) SlidingPaneLayout.this.f11579h.getLayoutParams();
            if (SlidingPaneLayout.this.i()) {
                int width = SlidingPaneLayout.this.getWidth() - ((SlidingPaneLayout.this.getPaddingRight() + layoutParams.rightMargin) + SlidingPaneLayout.this.f11579h.getWidth());
                return Math.max(Math.min(i2, width), width - SlidingPaneLayout.this.f11582k);
            }
            int paddingLeft = SlidingPaneLayout.this.getPaddingLeft() + layoutParams.leftMargin;
            return Math.min(Math.max(i2, paddingLeft), SlidingPaneLayout.this.f11582k + paddingLeft);
        }

        public int b(View view, int i2, int i3) {
            return view.getTop();
        }

        public int d(View view) {
            return SlidingPaneLayout.this.f11582k;
        }

        public void f(int i2, int i3) {
            SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
            slidingPaneLayout.f11587p.c(slidingPaneLayout.f11579h, i3);
        }

        public void i(View view, int i2) {
            SlidingPaneLayout.this.p();
        }

        public void j(int i2) {
            if (SlidingPaneLayout.this.f11587p.A() == 0) {
                SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
                if (slidingPaneLayout.f11580i == 0.0f) {
                    slidingPaneLayout.r(slidingPaneLayout.f11579h);
                    SlidingPaneLayout slidingPaneLayout2 = SlidingPaneLayout.this;
                    slidingPaneLayout2.d(slidingPaneLayout2.f11579h);
                    SlidingPaneLayout.this.f11588q = false;
                    return;
                }
                slidingPaneLayout.e(slidingPaneLayout.f11579h);
                SlidingPaneLayout.this.f11588q = true;
            }
        }

        public void k(View view, int i2, int i3, int i4, int i5) {
            SlidingPaneLayout.this.l(i2);
            SlidingPaneLayout.this.invalidate();
        }

        public void l(View view, float f2, float f3) {
            int i2;
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (SlidingPaneLayout.this.i()) {
                int paddingRight = SlidingPaneLayout.this.getPaddingRight() + layoutParams.rightMargin;
                if (f2 < 0.0f || (f2 == 0.0f && SlidingPaneLayout.this.f11580i > 0.5f)) {
                    paddingRight += SlidingPaneLayout.this.f11582k;
                }
                i2 = (SlidingPaneLayout.this.getWidth() - paddingRight) - SlidingPaneLayout.this.f11579h.getWidth();
            } else {
                i2 = layoutParams.leftMargin + SlidingPaneLayout.this.getPaddingLeft();
                int i3 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
                if (i3 > 0 || (i3 == 0 && SlidingPaneLayout.this.f11580i > 0.5f)) {
                    i2 += SlidingPaneLayout.this.f11582k;
                }
            }
            SlidingPaneLayout.this.f11587p.N(i2, view.getTop());
            SlidingPaneLayout.this.invalidate();
        }

        public boolean m(View view, int i2) {
            if (SlidingPaneLayout.this.f11583l) {
                return false;
            }
            return ((LayoutParams) view.getLayoutParams()).f11599b;
        }
    }

    public interface PanelSlideListener {
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            /* renamed from: b */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            /* renamed from: c */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        };

        /* renamed from: d  reason: collision with root package name */
        boolean f11602d;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f11602d ? 1 : 0);
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f11602d = parcel.readInt() != 0;
        }
    }

    public SlidingPaneLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.f11577f = (int) ((32.0f * f2) + 0.5f);
        setWillNotDraw(false);
        ViewCompat.r0(this, new AccessibilityDelegate());
        ViewCompat.C0(this, 1);
        ViewDragHelper o2 = ViewDragHelper.o(this, 0.5f, new DragHelperCallback());
        this.f11587p = o2;
        o2.M(f2 * 400.0f);
    }

    private boolean b(View view, int i2) {
        if (!this.f11589r && !q(0.0f, i2)) {
            return false;
        }
        this.f11588q = false;
        return true;
    }

    private void c(View view, float f2, int i2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f2 > 0.0f && i2 != 0) {
            int i3 = (((int) (((float) ((-16777216 & i2) >>> 24)) * f2)) << 24) | (i2 & 16777215);
            if (layoutParams.f11601d == null) {
                layoutParams.f11601d = new Paint();
            }
            layoutParams.f11601d.setColorFilter(new PorterDuffColorFilter(i3, PorterDuff.Mode.SRC_OVER));
            if (view.getLayerType() != 2) {
                view.setLayerType(2, layoutParams.f11601d);
            }
            g(view);
        } else if (view.getLayerType() != 0) {
            Paint paint = layoutParams.f11601d;
            if (paint != null) {
                paint.setColorFilter((ColorFilter) null);
            }
            DisableLayerRunnable disableLayerRunnable = new DisableLayerRunnable(view);
            this.f11591t.add(disableLayerRunnable);
            ViewCompat.j0(this, disableLayerRunnable);
        }
    }

    private boolean n(View view, int i2) {
        if (!this.f11589r && !q(1.0f, i2)) {
            return false;
        }
        this.f11588q = true;
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void o(float r10) {
        /*
            r9 = this;
            boolean r0 = r9.i()
            android.view.View r1 = r9.f11579h
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            androidx.slidingpanelayout.widget.SlidingPaneLayout$LayoutParams r1 = (androidx.slidingpanelayout.widget.SlidingPaneLayout.LayoutParams) r1
            boolean r2 = r1.f11600c
            r3 = 0
            if (r2 == 0) goto L_0x001c
            if (r0 == 0) goto L_0x0016
            int r1 = r1.rightMargin
            goto L_0x0018
        L_0x0016:
            int r1 = r1.leftMargin
        L_0x0018:
            if (r1 > 0) goto L_0x001c
            r1 = 1
            goto L_0x001d
        L_0x001c:
            r1 = 0
        L_0x001d:
            int r2 = r9.getChildCount()
        L_0x0021:
            if (r3 >= r2) goto L_0x0059
            android.view.View r4 = r9.getChildAt(r3)
            android.view.View r5 = r9.f11579h
            if (r4 != r5) goto L_0x002c
            goto L_0x0056
        L_0x002c:
            float r5 = r9.f11581j
            r6 = 1065353216(0x3f800000, float:1.0)
            float r5 = r6 - r5
            int r7 = r9.f11584m
            float r8 = (float) r7
            float r5 = r5 * r8
            int r5 = (int) r5
            r9.f11581j = r10
            float r8 = r6 - r10
            float r7 = (float) r7
            float r8 = r8 * r7
            int r7 = (int) r8
            int r5 = r5 - r7
            if (r0 == 0) goto L_0x0044
            int r5 = -r5
        L_0x0044:
            r4.offsetLeftAndRight(r5)
            if (r1 == 0) goto L_0x0056
            float r5 = r9.f11581j
            if (r0 == 0) goto L_0x004f
            float r5 = r5 - r6
            goto L_0x0051
        L_0x004f:
            float r5 = r6 - r5
        L_0x0051:
            int r6 = r9.f11574c
            r9.c(r4, r5, r6)
        L_0x0056:
            int r3 = r3 + 1
            goto L_0x0021
        L_0x0059:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.slidingpanelayout.widget.SlidingPaneLayout.o(float):void");
    }

    private static boolean s(View view) {
        return view.isOpaque();
    }

    public boolean a() {
        return b(this.f11579h, 0);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public void computeScroll() {
        if (!this.f11587p.n(true)) {
            return;
        }
        if (!this.f11578g) {
            this.f11587p.a();
        } else {
            ViewCompat.i0(this);
        }
    }

    /* access modifiers changed from: package-private */
    public void d(View view) {
        sendAccessibilityEvent(32);
    }

    public void draw(Canvas canvas) {
        Drawable drawable;
        View view;
        int i2;
        int i3;
        super.draw(canvas);
        if (i()) {
            drawable = this.f11576e;
        } else {
            drawable = this.f11575d;
        }
        if (getChildCount() > 1) {
            view = getChildAt(1);
        } else {
            view = null;
        }
        if (view != null && drawable != null) {
            int top = view.getTop();
            int bottom = view.getBottom();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            if (i()) {
                i3 = view.getRight();
                i2 = intrinsicWidth + i3;
            } else {
                int left = view.getLeft();
                int i4 = left - intrinsicWidth;
                i2 = left;
                i3 = i4;
            }
            drawable.setBounds(i3, top, i2, bottom);
            drawable.draw(canvas);
        }
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int save = canvas.save();
        if (this.f11578g && !layoutParams.f11599b && this.f11579h != null) {
            canvas.getClipBounds(this.f11590s);
            if (i()) {
                Rect rect = this.f11590s;
                rect.left = Math.max(rect.left, this.f11579h.getRight());
            } else {
                Rect rect2 = this.f11590s;
                rect2.right = Math.min(rect2.right, this.f11579h.getLeft());
            }
            canvas.clipRect(this.f11590s);
        }
        boolean drawChild = super.drawChild(canvas, view, j2);
        canvas.restoreToCount(save);
        return drawChild;
    }

    /* access modifiers changed from: package-private */
    public void e(View view) {
        sendAccessibilityEvent(32);
    }

    /* access modifiers changed from: package-private */
    public void f(View view) {
    }

    /* access modifiers changed from: package-private */
    public void g(View view) {
        ViewCompat.E0(view, ((LayoutParams) view.getLayoutParams()).f11601d);
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    public int getCoveredFadeColor() {
        return this.f11574c;
    }

    public int getParallaxDistance() {
        return this.f11584m;
    }

    public int getSliderFadeColor() {
        return this.f11573b;
    }

    /* access modifiers changed from: package-private */
    public boolean h(View view) {
        if (view == null) {
            return false;
        }
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!this.f11578g || !layoutParams.f11600c || this.f11580i <= 0.0f) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean i() {
        return ViewCompat.D(this) == 1;
    }

    public boolean j() {
        return !this.f11578g || this.f11580i == 1.0f;
    }

    public boolean k() {
        return this.f11578g;
    }

    /* access modifiers changed from: package-private */
    public void l(int i2) {
        int i3;
        int i4;
        if (this.f11579h == null) {
            this.f11580i = 0.0f;
            return;
        }
        boolean i5 = i();
        LayoutParams layoutParams = (LayoutParams) this.f11579h.getLayoutParams();
        int width = this.f11579h.getWidth();
        if (i5) {
            i2 = (getWidth() - i2) - width;
        }
        if (i5) {
            i3 = getPaddingRight();
        } else {
            i3 = getPaddingLeft();
        }
        if (i5) {
            i4 = layoutParams.rightMargin;
        } else {
            i4 = layoutParams.leftMargin;
        }
        float f2 = ((float) (i2 - (i3 + i4))) / ((float) this.f11582k);
        this.f11580i = f2;
        if (this.f11584m != 0) {
            o(f2);
        }
        if (layoutParams.f11600c) {
            c(this.f11579h, this.f11580i, this.f11573b);
        }
        f(this.f11579h);
    }

    public boolean m() {
        return n(this.f11579h, 0);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f11589r = true;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f11589r = true;
        int size = this.f11591t.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f11591t.get(i2).run();
        }
        this.f11591t.clear();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z2;
        View childAt;
        int actionMasked = motionEvent.getActionMasked();
        if (!this.f11578g && actionMasked == 0 && getChildCount() > 1 && (childAt = getChildAt(1)) != null) {
            this.f11588q = !this.f11587p.E(childAt, (int) motionEvent.getX(), (int) motionEvent.getY());
        }
        if (!this.f11578g || (this.f11583l && actionMasked != 0)) {
            this.f11587p.b();
            return super.onInterceptTouchEvent(motionEvent);
        } else if (actionMasked == 3 || actionMasked == 1) {
            this.f11587p.b();
            return false;
        } else {
            if (actionMasked == 0) {
                this.f11583l = false;
                float x2 = motionEvent.getX();
                float y2 = motionEvent.getY();
                this.f11585n = x2;
                this.f11586o = y2;
                if (this.f11587p.E(this.f11579h, (int) x2, (int) y2) && h(this.f11579h)) {
                    z2 = true;
                    if (this.f11587p.O(motionEvent) && !z2) {
                        return false;
                    }
                }
            } else if (actionMasked == 2) {
                float x3 = motionEvent.getX();
                float y3 = motionEvent.getY();
                float abs = Math.abs(x3 - this.f11585n);
                float abs2 = Math.abs(y3 - this.f11586o);
                if (abs > ((float) this.f11587p.z()) && abs2 > abs) {
                    this.f11587p.b();
                    this.f11583l = true;
                    return false;
                }
            }
            z2 = false;
            return this.f11587p.O(motionEvent) ? true : true;
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        boolean z3;
        float f2;
        boolean i13 = i();
        if (i13) {
            this.f11587p.L(2);
        } else {
            this.f11587p.L(1);
        }
        int i14 = i4 - i2;
        if (i13) {
            i6 = getPaddingRight();
        } else {
            i6 = getPaddingLeft();
        }
        if (i13) {
            i7 = getPaddingLeft();
        } else {
            i7 = getPaddingRight();
        }
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        if (this.f11589r) {
            if (!this.f11578g || !this.f11588q) {
                f2 = 0.0f;
            } else {
                f2 = 1.0f;
            }
            this.f11580i = f2;
        }
        int i15 = i6;
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt = getChildAt(i16);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                if (layoutParams.f11599b) {
                    int i17 = i14 - i7;
                    int min = (Math.min(i6, i17 - this.f11577f) - i15) - (layoutParams.leftMargin + layoutParams.rightMargin);
                    this.f11582k = min;
                    if (i13) {
                        i12 = layoutParams.rightMargin;
                    } else {
                        i12 = layoutParams.leftMargin;
                    }
                    if (i15 + i12 + min + (measuredWidth / 2) > i17) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    layoutParams.f11600c = z3;
                    int i18 = (int) (((float) min) * this.f11580i);
                    i15 += i12 + i18;
                    this.f11580i = ((float) i18) / ((float) min);
                    i8 = 0;
                } else if (!this.f11578g || (i11 = this.f11584m) == 0) {
                    i15 = i6;
                    i8 = 0;
                } else {
                    i8 = (int) ((1.0f - this.f11580i) * ((float) i11));
                    i15 = i6;
                }
                if (i13) {
                    i9 = (i14 - i15) + i8;
                    i10 = i9 - measuredWidth;
                } else {
                    i10 = i15 - i8;
                    i9 = i10 + measuredWidth;
                }
                childAt.layout(i10, paddingTop, i9, childAt.getMeasuredHeight() + paddingTop);
                i6 += childAt.getWidth();
            }
        }
        if (this.f11589r) {
            if (this.f11578g) {
                if (this.f11584m != 0) {
                    o(this.f11580i);
                }
                if (((LayoutParams) this.f11579h.getLayoutParams()).f11600c) {
                    c(this.f11579h, this.f11580i, this.f11573b);
                }
            } else {
                for (int i19 = 0; i19 < childCount; i19++) {
                    c(getChildAt(i19), 0.0f, this.f11573b);
                }
            }
            r(this.f11579h);
        }
        this.f11589r = false;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        boolean z2;
        int i8;
        int i9;
        int i10;
        int i11;
        float f2;
        int i12;
        int i13;
        int i14;
        boolean z3;
        int i15;
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        if (mode != 1073741824) {
            if (!isInEditMode()) {
                throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
            } else if (mode != Integer.MIN_VALUE && mode == 0) {
                size = 300;
            }
        } else if (mode2 == 0) {
            if (!isInEditMode()) {
                throw new IllegalStateException("Height must not be UNSPECIFIED");
            } else if (mode2 == 0) {
                mode2 = Integer.MIN_VALUE;
                size2 = 300;
            }
        }
        boolean z4 = false;
        if (mode2 == Integer.MIN_VALUE) {
            i4 = (size2 - getPaddingTop()) - getPaddingBottom();
            i5 = 0;
        } else if (mode2 != 1073741824) {
            i5 = 0;
            i4 = 0;
        } else {
            i5 = (size2 - getPaddingTop()) - getPaddingBottom();
            i4 = i5;
        }
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int childCount = getChildCount();
        if (childCount > 2) {
            Log.e("SlidingPaneLayout", "onMeasure: More than two child views are not supported.");
        }
        this.f11579h = null;
        int i16 = paddingLeft;
        int i17 = 0;
        boolean z5 = false;
        float f3 = 0.0f;
        while (true) {
            i6 = 8;
            if (i17 >= childCount) {
                break;
            }
            View childAt = getChildAt(i17);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (childAt.getVisibility() == 8) {
                layoutParams.f11600c = z4;
            } else {
                float f4 = layoutParams.f11598a;
                if (f4 > 0.0f) {
                    f3 += f4;
                    if (layoutParams.width == 0) {
                    }
                }
                int i18 = layoutParams.leftMargin + layoutParams.rightMargin;
                int i19 = layoutParams.width;
                if (i19 == -2) {
                    i12 = View.MeasureSpec.makeMeasureSpec(paddingLeft - i18, Integer.MIN_VALUE);
                    f2 = f3;
                    i13 = Integer.MIN_VALUE;
                } else {
                    f2 = f3;
                    i13 = Integer.MIN_VALUE;
                    if (i19 == -1) {
                        i12 = View.MeasureSpec.makeMeasureSpec(paddingLeft - i18, 1073741824);
                    } else {
                        i12 = View.MeasureSpec.makeMeasureSpec(i19, 1073741824);
                    }
                }
                int i20 = layoutParams.height;
                if (i20 == -2) {
                    i14 = View.MeasureSpec.makeMeasureSpec(i4, i13);
                } else {
                    if (i20 == -1) {
                        i15 = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
                    } else {
                        i15 = View.MeasureSpec.makeMeasureSpec(i20, 1073741824);
                    }
                    i14 = i15;
                }
                childAt.measure(i12, i14);
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (mode2 == i13 && measuredHeight > i5) {
                    i5 = Math.min(measuredHeight, i4);
                }
                i16 -= measuredWidth;
                if (i16 < 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                layoutParams.f11599b = z3;
                z5 |= z3;
                if (z3) {
                    this.f11579h = childAt;
                }
                f3 = f2;
            }
            i17++;
            z4 = false;
        }
        if (z5 || f3 > 0.0f) {
            int i21 = paddingLeft - this.f11577f;
            int i22 = 0;
            while (i22 < childCount) {
                View childAt2 = getChildAt(i22);
                if (childAt2.getVisibility() != i6) {
                    LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                    if (childAt2.getVisibility() != i6) {
                        if (layoutParams2.width != 0 || layoutParams2.f11598a <= 0.0f) {
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                        if (z2) {
                            i8 = 0;
                        } else {
                            i8 = childAt2.getMeasuredWidth();
                        }
                        if (!z5 || childAt2 == this.f11579h) {
                            if (layoutParams2.f11598a > 0.0f) {
                                if (layoutParams2.width == 0) {
                                    int i23 = layoutParams2.height;
                                    if (i23 == -2) {
                                        i9 = View.MeasureSpec.makeMeasureSpec(i4, Integer.MIN_VALUE);
                                    } else if (i23 == -1) {
                                        i9 = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
                                    } else {
                                        i9 = View.MeasureSpec.makeMeasureSpec(i23, 1073741824);
                                    }
                                } else {
                                    i9 = View.MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                                }
                                if (z5) {
                                    int i24 = paddingLeft - (layoutParams2.leftMargin + layoutParams2.rightMargin);
                                    i7 = i21;
                                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i24, 1073741824);
                                    if (i8 != i24) {
                                        childAt2.measure(makeMeasureSpec, i9);
                                    }
                                    i22++;
                                    i21 = i7;
                                    i6 = 8;
                                } else {
                                    i7 = i21;
                                    childAt2.measure(View.MeasureSpec.makeMeasureSpec(i8 + ((int) ((layoutParams2.f11598a * ((float) Math.max(0, i16))) / f3)), 1073741824), i9);
                                    i22++;
                                    i21 = i7;
                                    i6 = 8;
                                }
                            }
                        } else if (layoutParams2.width < 0 && (i8 > i21 || layoutParams2.f11598a > 0.0f)) {
                            if (z2) {
                                int i25 = layoutParams2.height;
                                if (i25 == -2) {
                                    i11 = View.MeasureSpec.makeMeasureSpec(i4, Integer.MIN_VALUE);
                                    i10 = 1073741824;
                                } else if (i25 == -1) {
                                    i10 = 1073741824;
                                    i11 = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
                                } else {
                                    i10 = 1073741824;
                                    i11 = View.MeasureSpec.makeMeasureSpec(i25, 1073741824);
                                }
                            } else {
                                i10 = 1073741824;
                                i11 = View.MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                            }
                            childAt2.measure(View.MeasureSpec.makeMeasureSpec(i21, i10), i11);
                        }
                    }
                }
                i7 = i21;
                i22++;
                i21 = i7;
                i6 = 8;
            }
        }
        setMeasuredDimension(size, i5 + getPaddingTop() + getPaddingBottom());
        this.f11578g = z5;
        if (this.f11587p.A() != 0 && !z5) {
            this.f11587p.a();
        }
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.b());
        if (savedState.f11602d) {
            m();
        } else {
            a();
        }
        this.f11588q = savedState.f11602d;
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        boolean z2;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (k()) {
            z2 = j();
        } else {
            z2 = this.f11588q;
        }
        savedState.f11602d = z2;
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 != i4) {
            this.f11589r = true;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f11578g) {
            return super.onTouchEvent(motionEvent);
        }
        this.f11587p.F(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            this.f11585n = x2;
            this.f11586o = y2;
        } else if (actionMasked == 1 && h(this.f11579h)) {
            float x3 = motionEvent.getX();
            float y3 = motionEvent.getY();
            float f2 = x3 - this.f11585n;
            float f3 = y3 - this.f11586o;
            int z2 = this.f11587p.z();
            if ((f2 * f2) + (f3 * f3) < ((float) (z2 * z2)) && this.f11587p.E(this.f11579h, (int) x3, (int) y3)) {
                b(this.f11579h, 0);
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void p() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 4) {
                childAt.setVisibility(0);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean q(float f2, int i2) {
        int i3;
        if (!this.f11578g) {
            return false;
        }
        boolean i4 = i();
        LayoutParams layoutParams = (LayoutParams) this.f11579h.getLayoutParams();
        if (i4) {
            i3 = (int) (((float) getWidth()) - ((((float) (getPaddingRight() + layoutParams.rightMargin)) + (f2 * ((float) this.f11582k))) + ((float) this.f11579h.getWidth())));
        } else {
            i3 = (int) (((float) (getPaddingLeft() + layoutParams.leftMargin)) + (f2 * ((float) this.f11582k)));
        }
        ViewDragHelper viewDragHelper = this.f11587p;
        View view = this.f11579h;
        if (!viewDragHelper.P(view, i3, view.getTop())) {
            return false;
        }
        p();
        ViewCompat.i0(this);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void r(View view) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        View childAt;
        boolean z2;
        int i8;
        int i9;
        int i10;
        View view2 = view;
        boolean i11 = i();
        if (i11) {
            i2 = getWidth() - getPaddingRight();
        } else {
            i2 = getPaddingLeft();
        }
        if (i11) {
            i3 = getPaddingLeft();
        } else {
            i3 = getWidth() - getPaddingRight();
        }
        int paddingTop = getPaddingTop();
        int height = getHeight() - getPaddingBottom();
        if (view2 == null || !s(view)) {
            i7 = 0;
            i6 = 0;
            i5 = 0;
            i4 = 0;
        } else {
            i7 = view.getLeft();
            i6 = view.getRight();
            i5 = view.getTop();
            i4 = view.getBottom();
        }
        int childCount = getChildCount();
        int i12 = 0;
        while (true) {
            if (i12 < childCount && (childAt = getChildAt(i12)) != view2) {
                if (childAt.getVisibility() == 8) {
                    z2 = i11;
                } else {
                    if (i11) {
                        i8 = i3;
                    } else {
                        i8 = i2;
                    }
                    int max = Math.max(i8, childAt.getLeft());
                    int max2 = Math.max(paddingTop, childAt.getTop());
                    z2 = i11;
                    if (i11) {
                        i9 = i2;
                    } else {
                        i9 = i3;
                    }
                    int min = Math.min(i9, childAt.getRight());
                    int min2 = Math.min(height, childAt.getBottom());
                    if (max < i7 || max2 < i5 || min > i6 || min2 > i4) {
                        i10 = 0;
                    } else {
                        i10 = 4;
                    }
                    childAt.setVisibility(i10);
                }
                i12++;
                view2 = view;
                i11 = z2;
            } else {
                return;
            }
        }
    }

    public void requestChildFocus(View view, View view2) {
        boolean z2;
        super.requestChildFocus(view, view2);
        if (!isInTouchMode() && !this.f11578g) {
            if (view == this.f11579h) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.f11588q = z2;
        }
    }

    public void setCoveredFadeColor(int i2) {
        this.f11574c = i2;
    }

    public void setPanelSlideListener(PanelSlideListener panelSlideListener) {
    }

    public void setParallaxDistance(int i2) {
        this.f11584m = i2;
        requestLayout();
    }

    @Deprecated
    public void setShadowDrawable(Drawable drawable) {
        setShadowDrawableLeft(drawable);
    }

    public void setShadowDrawableLeft(Drawable drawable) {
        this.f11575d = drawable;
    }

    public void setShadowDrawableRight(Drawable drawable) {
        this.f11576e = drawable;
    }

    @Deprecated
    public void setShadowResource(int i2) {
        setShadowDrawable(getResources().getDrawable(i2));
    }

    public void setShadowResourceLeft(int i2) {
        setShadowDrawableLeft(ContextCompat.getDrawable(getContext(), i2));
    }

    public void setShadowResourceRight(int i2) {
        setShadowDrawableRight(ContextCompat.getDrawable(getContext(), i2));
    }

    public void setSliderFadeColor(int i2) {
        this.f11573b = i2;
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* renamed from: e  reason: collision with root package name */
        private static final int[] f11597e = {16843137};

        /* renamed from: a  reason: collision with root package name */
        public float f11598a = 0.0f;

        /* renamed from: b  reason: collision with root package name */
        boolean f11599b;

        /* renamed from: c  reason: collision with root package name */
        boolean f11600c;

        /* renamed from: d  reason: collision with root package name */
        Paint f11601d;

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f11597e);
            this.f11598a = obtainStyledAttributes.getFloat(0, 0.0f);
            obtainStyledAttributes.recycle();
        }
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }
}
