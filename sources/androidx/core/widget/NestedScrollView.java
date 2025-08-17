package androidx.core.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;
import androidx.core.R$attr;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingChild2;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityRecordCompat;
import com.facebook.imageutils.JfifUtil;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.util.ArrayList;

public class NestedScrollView extends FrameLayout implements NestedScrollingParent3, NestedScrollingChild2 {
    private static final float C = ((float) (Math.log(0.78d) / Math.log(0.9d)));
    private static final AccessibilityDelegate D = new AccessibilityDelegate();
    private static final int[] E = {16843130};
    private float A;
    private OnScrollChangeListener B;

    /* renamed from: b  reason: collision with root package name */
    private final float f2938b;

    /* renamed from: c  reason: collision with root package name */
    private long f2939c;

    /* renamed from: d  reason: collision with root package name */
    private final Rect f2940d;

    /* renamed from: e  reason: collision with root package name */
    private OverScroller f2941e;

    /* renamed from: f  reason: collision with root package name */
    public EdgeEffect f2942f;

    /* renamed from: g  reason: collision with root package name */
    public EdgeEffect f2943g;

    /* renamed from: h  reason: collision with root package name */
    private int f2944h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f2945i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f2946j;

    /* renamed from: k  reason: collision with root package name */
    private View f2947k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f2948l;

    /* renamed from: m  reason: collision with root package name */
    private VelocityTracker f2949m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f2950n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f2951o;

    /* renamed from: p  reason: collision with root package name */
    private int f2952p;

    /* renamed from: q  reason: collision with root package name */
    private int f2953q;

    /* renamed from: r  reason: collision with root package name */
    private int f2954r;

    /* renamed from: s  reason: collision with root package name */
    private int f2955s;

    /* renamed from: t  reason: collision with root package name */
    private final int[] f2956t;

    /* renamed from: u  reason: collision with root package name */
    private final int[] f2957u;

    /* renamed from: v  reason: collision with root package name */
    private int f2958v;

    /* renamed from: w  reason: collision with root package name */
    private int f2959w;

    /* renamed from: x  reason: collision with root package name */
    private SavedState f2960x;

    /* renamed from: y  reason: collision with root package name */
    private final NestedScrollingParentHelper f2961y;

    /* renamed from: z  reason: collision with root package name */
    private final NestedScrollingChildHelper f2962z;

    static class AccessibilityDelegate extends AccessibilityDelegateCompat {
        AccessibilityDelegate() {
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            boolean z2;
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityEvent.setClassName(ScrollView.class.getName());
            if (nestedScrollView.getScrollRange() > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            accessibilityEvent.setScrollable(z2);
            accessibilityEvent.setScrollX(nestedScrollView.getScrollX());
            accessibilityEvent.setScrollY(nestedScrollView.getScrollY());
            AccessibilityRecordCompat.a(accessibilityEvent, nestedScrollView.getScrollX());
            AccessibilityRecordCompat.b(accessibilityEvent, nestedScrollView.getScrollRange());
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            int scrollRange;
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityNodeInfoCompat.c0(ScrollView.class.getName());
            if (nestedScrollView.isEnabled() && (scrollRange = nestedScrollView.getScrollRange()) > 0) {
                accessibilityNodeInfoCompat.z0(true);
                if (nestedScrollView.getScrollY() > 0) {
                    accessibilityNodeInfoCompat.b(AccessibilityNodeInfoCompat.AccessibilityActionCompat.f2870r);
                    accessibilityNodeInfoCompat.b(AccessibilityNodeInfoCompat.AccessibilityActionCompat.C);
                }
                if (nestedScrollView.getScrollY() < scrollRange) {
                    accessibilityNodeInfoCompat.b(AccessibilityNodeInfoCompat.AccessibilityActionCompat.f2869q);
                    accessibilityNodeInfoCompat.b(AccessibilityNodeInfoCompat.AccessibilityActionCompat.E);
                }
            }
        }

        public boolean performAccessibilityAction(View view, int i2, Bundle bundle) {
            if (super.performAccessibilityAction(view, i2, bundle)) {
                return true;
            }
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            if (!nestedScrollView.isEnabled()) {
                return false;
            }
            int height = nestedScrollView.getHeight();
            Rect rect = new Rect();
            if (nestedScrollView.getMatrix().isIdentity() && nestedScrollView.getGlobalVisibleRect(rect)) {
                height = rect.height();
            }
            if (i2 != 4096) {
                if (i2 == 8192 || i2 == 16908344) {
                    int max = Math.max(nestedScrollView.getScrollY() - ((height - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                    if (max == nestedScrollView.getScrollY()) {
                        return false;
                    }
                    nestedScrollView.V(0, max, true);
                    return true;
                } else if (i2 != 16908346) {
                    return false;
                }
            }
            int min = Math.min(nestedScrollView.getScrollY() + ((height - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), nestedScrollView.getScrollRange());
            if (min == nestedScrollView.getScrollY()) {
                return false;
            }
            nestedScrollView.V(0, min, true);
            return true;
        }
    }

    static class Api21Impl {
        private Api21Impl() {
        }

        static boolean a(ViewGroup viewGroup) {
            return viewGroup.getClipToPadding();
        }
    }

    public interface OnScrollChangeListener {
        void a(NestedScrollView nestedScrollView, int i2, int i3, int i4, int i5);
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* renamed from: b */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public int f2963b;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.f2963b + "}";
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f2963b);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.f2963b = parcel.readInt();
        }
    }

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.f2267c);
    }

    private void A() {
        this.f2941e = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.f2952p = viewConfiguration.getScaledTouchSlop();
        this.f2953q = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f2954r = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    private void B() {
        if (this.f2949m == null) {
            this.f2949m = VelocityTracker.obtain();
        }
    }

    private void C(int i2, int i3) {
        this.f2944h = i2;
        this.f2955s = i3;
        W(2, 0);
    }

    private boolean D(View view) {
        return !F(view, 0, getHeight());
    }

    private static boolean E(View view, View view2) {
        if (view == view2) {
            return true;
        }
        ViewParent parent = view.getParent();
        if (!(parent instanceof ViewGroup) || !E((View) parent, view2)) {
            return false;
        }
        return true;
    }

    private boolean F(View view, int i2, int i3) {
        view.getDrawingRect(this.f2940d);
        offsetDescendantRectToMyCoords(view, this.f2940d);
        if (this.f2940d.bottom + i2 < getScrollY() || this.f2940d.top - i2 > getScrollY() + i3) {
            return false;
        }
        return true;
    }

    private void G(int i2, int i3, int[] iArr) {
        int scrollY = getScrollY();
        scrollBy(0, i2);
        int scrollY2 = getScrollY() - scrollY;
        if (iArr != null) {
            iArr[1] = iArr[1] + scrollY2;
        }
        this.f2962z.e(0, scrollY2, 0, i2 - scrollY2, (int[]) null, i3, iArr);
    }

    private void H(MotionEvent motionEvent) {
        int i2;
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f2955s) {
            if (actionIndex == 0) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            this.f2944h = (int) motionEvent.getY(i2);
            this.f2955s = motionEvent.getPointerId(i2);
            VelocityTracker velocityTracker = this.f2949m;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private void K() {
        VelocityTracker velocityTracker = this.f2949m;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f2949m = null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0061  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int L(int r4, float r5) {
        /*
            r3 = this;
            int r0 = r3.getWidth()
            float r0 = (float) r0
            float r5 = r5 / r0
            float r4 = (float) r4
            int r0 = r3.getHeight()
            float r0 = (float) r0
            float r4 = r4 / r0
            android.widget.EdgeEffect r0 = r3.f2942f
            float r0 = androidx.core.widget.EdgeEffectCompat.b(r0)
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x0031
            android.widget.EdgeEffect r0 = r3.f2942f
            float r4 = -r4
            float r4 = androidx.core.widget.EdgeEffectCompat.d(r0, r4, r5)
            float r4 = -r4
            android.widget.EdgeEffect r5 = r3.f2942f
            float r5 = androidx.core.widget.EdgeEffectCompat.b(r5)
            int r5 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r5 != 0) goto L_0x002f
            android.widget.EdgeEffect r5 = r3.f2942f
            r5.onRelease()
        L_0x002f:
            r1 = r4
            goto L_0x0054
        L_0x0031:
            android.widget.EdgeEffect r0 = r3.f2943g
            float r0 = androidx.core.widget.EdgeEffectCompat.b(r0)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x0054
            android.widget.EdgeEffect r0 = r3.f2943g
            r2 = 1065353216(0x3f800000, float:1.0)
            float r2 = r2 - r5
            float r4 = androidx.core.widget.EdgeEffectCompat.d(r0, r4, r2)
            android.widget.EdgeEffect r5 = r3.f2943g
            float r5 = androidx.core.widget.EdgeEffectCompat.b(r5)
            int r5 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r5 != 0) goto L_0x002f
            android.widget.EdgeEffect r5 = r3.f2943g
            r5.onRelease()
            goto L_0x002f
        L_0x0054:
            int r4 = r3.getHeight()
            float r4 = (float) r4
            float r1 = r1 * r4
            int r4 = java.lang.Math.round(r1)
            if (r4 == 0) goto L_0x0064
            r3.invalidate()
        L_0x0064:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.L(int, float):int");
    }

    private void M(boolean z2) {
        if (z2) {
            W(2, 1);
        } else {
            stopNestedScroll(1);
        }
        this.f2959w = getScrollY();
        ViewCompat.i0(this);
    }

    private boolean N(int i2, int i3, int i4) {
        boolean z2;
        int i5;
        int height = getHeight();
        int scrollY = getScrollY();
        int i6 = height + scrollY;
        boolean z3 = false;
        if (i2 == 33) {
            z2 = true;
        } else {
            z2 = false;
        }
        View t2 = t(z2, i3, i4);
        if (t2 == null) {
            t2 = this;
        }
        if (i3 < scrollY || i4 > i6) {
            if (z2) {
                i5 = i3 - scrollY;
            } else {
                i5 = i4 - i6;
            }
            O(i5, 0, 1, true);
            z3 = true;
        }
        if (t2 != findFocus()) {
            t2.requestFocus(i2);
        }
        return z3;
    }

    private int O(int i2, int i3, int i4, boolean z2) {
        int i5;
        int i6;
        boolean z3;
        boolean z4;
        int i7 = i3;
        int i8 = i4;
        if (i8 == 1) {
            W(2, i8);
        }
        boolean z5 = false;
        if (h(0, i2, this.f2957u, this.f2956t, i4)) {
            i6 = i2 - this.f2957u[1];
            i5 = this.f2956t[1] + 0;
        } else {
            i6 = i2;
            i5 = 0;
        }
        int scrollY = getScrollY();
        int scrollRange = getScrollRange();
        if (!c() || z2) {
            z3 = false;
        } else {
            z3 = true;
        }
        int i9 = scrollRange;
        if (!I(0, i6, 0, scrollY, 0, scrollRange, 0, 0, true) || x(i8)) {
            z4 = false;
        } else {
            z4 = true;
        }
        int scrollY2 = getScrollY() - scrollY;
        int[] iArr = this.f2957u;
        iArr[1] = 0;
        l(0, scrollY2, 0, i6 - scrollY2, this.f2956t, i4, iArr);
        int i10 = i5 + this.f2956t[1];
        int i11 = i6 - this.f2957u[1];
        int i12 = scrollY + i11;
        if (i12 < 0) {
            if (z3) {
                EdgeEffectCompat.d(this.f2942f, ((float) (-i11)) / ((float) getHeight()), ((float) i7) / ((float) getWidth()));
                if (!this.f2943g.isFinished()) {
                    this.f2943g.onRelease();
                }
            }
        } else if (i12 > i9 && z3) {
            EdgeEffectCompat.d(this.f2943g, ((float) i11) / ((float) getHeight()), 1.0f - (((float) i7) / ((float) getWidth())));
            if (!this.f2942f.isFinished()) {
                this.f2942f.onRelease();
            }
        }
        if (!this.f2942f.isFinished() || !this.f2943g.isFinished()) {
            ViewCompat.i0(this);
        } else {
            z5 = z4;
        }
        if (z5 && i8 == 0) {
            this.f2949m.clear();
        }
        if (i8 == 1) {
            stopNestedScroll(i8);
            this.f2942f.onRelease();
            this.f2943g.onRelease();
        }
        return i10;
    }

    private void P(View view) {
        view.getDrawingRect(this.f2940d);
        offsetDescendantRectToMyCoords(view, this.f2940d);
        int f2 = f(this.f2940d);
        if (f2 != 0) {
            scrollBy(0, f2);
        }
    }

    private boolean Q(Rect rect, boolean z2) {
        boolean z3;
        int f2 = f(rect);
        if (f2 != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            if (z2) {
                scrollBy(0, f2);
            } else {
                S(0, f2);
            }
        }
        return z3;
    }

    private boolean R(EdgeEffect edgeEffect, int i2) {
        if (i2 > 0) {
            return true;
        }
        if (w(-i2) < EdgeEffectCompat.b(edgeEffect) * ((float) getHeight())) {
            return true;
        }
        return false;
    }

    private void T(int i2, int i3, int i4, boolean z2) {
        if (getChildCount() != 0) {
            if (AnimationUtils.currentAnimationTimeMillis() - this.f2939c > 250) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                int scrollY = getScrollY();
                OverScroller overScroller = this.f2941e;
                int scrollX = getScrollX();
                overScroller.startScroll(scrollX, scrollY, 0, Math.max(0, Math.min(i3 + scrollY, Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom())))) - scrollY, i4);
                M(z2);
            } else {
                if (!this.f2941e.isFinished()) {
                    a();
                }
                scrollBy(i2, i3);
            }
            this.f2939c = AnimationUtils.currentAnimationTimeMillis();
        }
    }

    private boolean X(MotionEvent motionEvent) {
        boolean z2;
        if (EdgeEffectCompat.b(this.f2942f) != 0.0f) {
            EdgeEffectCompat.d(this.f2942f, 0.0f, motionEvent.getX() / ((float) getWidth()));
            z2 = true;
        } else {
            z2 = false;
        }
        if (EdgeEffectCompat.b(this.f2943g) == 0.0f) {
            return z2;
        }
        EdgeEffectCompat.d(this.f2943g, 0.0f, 1.0f - (motionEvent.getX() / ((float) getWidth())));
        return true;
    }

    private void a() {
        this.f2941e.abortAnimation();
        stopNestedScroll(1);
    }

    private boolean c() {
        int overScrollMode = getOverScrollMode();
        if (overScrollMode == 0) {
            return true;
        }
        if (overScrollMode != 1 || getScrollRange() <= 0) {
            return false;
        }
        return true;
    }

    private boolean d() {
        if (getChildCount() <= 0) {
            return false;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        if (childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin > (getHeight() - getPaddingTop()) - getPaddingBottom()) {
            return true;
        }
        return false;
    }

    private static int e(int i2, int i3, int i4) {
        if (i3 >= i4 || i2 < 0) {
            return 0;
        }
        return i3 + i2 > i4 ? i4 - i3 : i2;
    }

    private float getVerticalScrollFactorCompat() {
        if (this.A == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (context.getTheme().resolveAttribute(16842829, typedValue, true)) {
                this.A = typedValue.getDimension(context.getResources().getDisplayMetrics());
            } else {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
        }
        return this.A;
    }

    private void p(int i2) {
        if (i2 == 0) {
            return;
        }
        if (this.f2951o) {
            S(0, i2);
        } else {
            scrollBy(0, i2);
        }
    }

    private boolean q(int i2) {
        if (EdgeEffectCompat.b(this.f2942f) != 0.0f) {
            if (R(this.f2942f, i2)) {
                this.f2942f.onAbsorb(i2);
            } else {
                u(-i2);
            }
        } else if (EdgeEffectCompat.b(this.f2943g) == 0.0f) {
            return false;
        } else {
            int i3 = -i2;
            if (R(this.f2943g, i3)) {
                this.f2943g.onAbsorb(i3);
            } else {
                u(i3);
            }
        }
        return true;
    }

    private void r() {
        this.f2955s = -1;
        this.f2948l = false;
        K();
        stopNestedScroll(0);
        this.f2942f.onRelease();
        this.f2943g.onRelease();
    }

    private View t(boolean z2, int i2, int i3) {
        boolean z3;
        boolean z4;
        ArrayList<View> focusables = getFocusables(2);
        int size = focusables.size();
        View view = null;
        boolean z5 = false;
        for (int i4 = 0; i4 < size; i4++) {
            View view2 = focusables.get(i4);
            int top = view2.getTop();
            int bottom = view2.getBottom();
            if (i2 < bottom && top < i3) {
                if (i2 >= top || bottom >= i3) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                if (view == null) {
                    view = view2;
                    z5 = z3;
                } else {
                    if ((!z2 || top >= view.getTop()) && (z2 || bottom <= view.getBottom())) {
                        z4 = false;
                    } else {
                        z4 = true;
                    }
                    if (z5) {
                        if (z3) {
                            if (!z4) {
                            }
                        }
                    } else if (z3) {
                        view = view2;
                        z5 = true;
                    } else if (!z4) {
                    }
                    view = view2;
                }
            }
        }
        return view;
    }

    private float w(int i2) {
        double log = Math.log((double) ((((float) Math.abs(i2)) * 0.35f) / (this.f2938b * 0.015f)));
        float f2 = C;
        return (float) (((double) (this.f2938b * 0.015f)) * Math.exp((((double) f2) / (((double) f2) - 1.0d)) * log));
    }

    private boolean y(int i2, int i3) {
        if (getChildCount() <= 0) {
            return false;
        }
        int scrollY = getScrollY();
        View childAt = getChildAt(0);
        if (i3 < childAt.getTop() - scrollY || i3 >= childAt.getBottom() - scrollY || i2 < childAt.getLeft() || i2 >= childAt.getRight()) {
            return false;
        }
        return true;
    }

    private void z() {
        VelocityTracker velocityTracker = this.f2949m;
        if (velocityTracker == null) {
            this.f2949m = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0083 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean I(int r13, int r14, int r15, int r16, int r17, int r18, int r19, int r20, boolean r21) {
        /*
            r12 = this;
            r0 = r12
            int r1 = r12.getOverScrollMode()
            int r2 = r12.computeHorizontalScrollRange()
            int r3 = r12.computeHorizontalScrollExtent()
            r4 = 0
            r5 = 1
            if (r2 <= r3) goto L_0x0013
            r2 = 1
            goto L_0x0014
        L_0x0013:
            r2 = 0
        L_0x0014:
            int r3 = r12.computeVerticalScrollRange()
            int r6 = r12.computeVerticalScrollExtent()
            if (r3 <= r6) goto L_0x0020
            r3 = 1
            goto L_0x0021
        L_0x0020:
            r3 = 0
        L_0x0021:
            if (r1 == 0) goto L_0x002a
            if (r1 != r5) goto L_0x0028
            if (r2 == 0) goto L_0x0028
            goto L_0x002a
        L_0x0028:
            r2 = 0
            goto L_0x002b
        L_0x002a:
            r2 = 1
        L_0x002b:
            if (r1 == 0) goto L_0x0034
            if (r1 != r5) goto L_0x0032
            if (r3 == 0) goto L_0x0032
            goto L_0x0034
        L_0x0032:
            r1 = 0
            goto L_0x0035
        L_0x0034:
            r1 = 1
        L_0x0035:
            int r3 = r15 + r13
            if (r2 != 0) goto L_0x003b
            r2 = 0
            goto L_0x003d
        L_0x003b:
            r2 = r19
        L_0x003d:
            int r6 = r16 + r14
            if (r1 != 0) goto L_0x0043
            r1 = 0
            goto L_0x0045
        L_0x0043:
            r1 = r20
        L_0x0045:
            int r7 = -r2
            int r2 = r2 + r17
            int r8 = -r1
            int r1 = r1 + r18
            if (r3 <= r2) goto L_0x0050
            r3 = r2
        L_0x004e:
            r2 = 1
            goto L_0x0055
        L_0x0050:
            if (r3 >= r7) goto L_0x0054
            r3 = r7
            goto L_0x004e
        L_0x0054:
            r2 = 0
        L_0x0055:
            if (r6 <= r1) goto L_0x005a
            r6 = r1
        L_0x0058:
            r1 = 1
            goto L_0x005f
        L_0x005a:
            if (r6 >= r8) goto L_0x005e
            r6 = r8
            goto L_0x0058
        L_0x005e:
            r1 = 0
        L_0x005f:
            if (r1 == 0) goto L_0x007e
            boolean r7 = r12.x(r5)
            if (r7 != 0) goto L_0x007e
            android.widget.OverScroller r7 = r0.f2941e
            r8 = 0
            r9 = 0
            r10 = 0
            int r11 = r12.getScrollRange()
            r13 = r7
            r14 = r3
            r15 = r6
            r16 = r8
            r17 = r9
            r18 = r10
            r19 = r11
            r13.springBack(r14, r15, r16, r17, r18, r19)
        L_0x007e:
            r12.onOverScrolled(r3, r6, r2, r1)
            if (r2 != 0) goto L_0x0085
            if (r1 == 0) goto L_0x0086
        L_0x0085:
            r4 = 1
        L_0x0086:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.I(int, int, int, int, int, int, int, int, boolean):boolean");
    }

    public boolean J(int i2) {
        boolean z2;
        if (i2 == 130) {
            z2 = true;
        } else {
            z2 = false;
        }
        int height = getHeight();
        if (z2) {
            this.f2940d.top = getScrollY() + height;
            int childCount = getChildCount();
            if (childCount > 0) {
                View childAt = getChildAt(childCount - 1);
                int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
                Rect rect = this.f2940d;
                if (rect.top + height > bottom) {
                    rect.top = bottom - height;
                }
            }
        } else {
            this.f2940d.top = getScrollY() - height;
            Rect rect2 = this.f2940d;
            if (rect2.top < 0) {
                rect2.top = 0;
            }
        }
        Rect rect3 = this.f2940d;
        int i3 = rect3.top;
        int i4 = height + i3;
        rect3.bottom = i4;
        return N(i2, i3, i4);
    }

    public final void S(int i2, int i3) {
        T(i2, i3, 250, false);
    }

    /* access modifiers changed from: package-private */
    public void U(int i2, int i3, int i4, boolean z2) {
        T(i2 - getScrollX(), i3 - getScrollY(), i4, z2);
    }

    /* access modifiers changed from: package-private */
    public void V(int i2, int i3, boolean z2) {
        U(i2, i3, 250, z2);
    }

    public boolean W(int i2, int i3) {
        return this.f2962z.q(i2, i3);
    }

    public void addView(View view) {
        if (getChildCount() <= 0) {
            super.addView(view);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public boolean b(int i2) {
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i2);
        int maxScrollAmount = getMaxScrollAmount();
        if (findNextFocus == null || !F(findNextFocus, maxScrollAmount, getHeight())) {
            if (i2 == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i2 == 130 && getChildCount() > 0) {
                View childAt = getChildAt(0);
                maxScrollAmount = Math.min((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - ((getScrollY() + getHeight()) - getPaddingBottom()), maxScrollAmount);
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i2 != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            O(maxScrollAmount, 0, 1, true);
        } else {
            findNextFocus.getDrawingRect(this.f2940d);
            offsetDescendantRectToMyCoords(findNextFocus, this.f2940d);
            O(f(this.f2940d), 0, 1, true);
            findNextFocus.requestFocus(i2);
        }
        if (findFocus != null && findFocus.isFocused() && D(findFocus)) {
            int descendantFocusability = getDescendantFocusability();
            setDescendantFocusability(131072);
            requestFocus();
            setDescendantFocusability(descendantFocusability);
        }
        return true;
    }

    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    public void computeScroll() {
        if (!this.f2941e.isFinished()) {
            this.f2941e.computeScrollOffset();
            int currY = this.f2941e.getCurrY();
            int g2 = g(currY - this.f2959w);
            this.f2959w = currY;
            int[] iArr = this.f2957u;
            boolean z2 = false;
            iArr[1] = 0;
            h(0, g2, iArr, (int[]) null, 1);
            int i2 = g2 - this.f2957u[1];
            int scrollRange = getScrollRange();
            if (i2 != 0) {
                int scrollY = getScrollY();
                I(0, i2, getScrollX(), scrollY, 0, scrollRange, 0, 0, false);
                int scrollY2 = getScrollY() - scrollY;
                int i3 = i2 - scrollY2;
                int[] iArr2 = this.f2957u;
                iArr2[1] = 0;
                l(0, scrollY2, 0, i3, this.f2956t, 1, iArr2);
                i2 = i3 - this.f2957u[1];
            }
            if (i2 != 0) {
                int overScrollMode = getOverScrollMode();
                if (overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0)) {
                    z2 = true;
                }
                if (z2) {
                    if (i2 < 0) {
                        if (this.f2942f.isFinished()) {
                            this.f2942f.onAbsorb((int) this.f2941e.getCurrVelocity());
                        }
                    } else if (this.f2943g.isFinished()) {
                        this.f2943g.onAbsorb((int) this.f2941e.getCurrVelocity());
                    }
                }
                a();
            }
            if (!this.f2941e.isFinished()) {
                ViewCompat.i0(this);
            } else {
                stopNestedScroll(1);
            }
        }
    }

    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    public int computeVerticalScrollRange() {
        int childCount = getChildCount();
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (childCount == 0) {
            return height;
        }
        View childAt = getChildAt(0);
        int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
        int scrollY = getScrollY();
        int max = Math.max(0, bottom - height);
        if (scrollY < 0) {
            return bottom - scrollY;
        }
        if (scrollY > max) {
            return bottom + (scrollY - max);
        }
        return bottom;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || s(keyEvent);
    }

    public boolean dispatchNestedFling(float f2, float f3, boolean z2) {
        return this.f2962z.a(f2, f3, z2);
    }

    public boolean dispatchNestedPreFling(float f2, float f3) {
        return this.f2962z.b(f2, f3);
    }

    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return h(i2, i3, iArr, iArr2, 0);
    }

    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return this.f2962z.f(i2, i3, i4, i5, iArr);
    }

    public void draw(Canvas canvas) {
        int i2;
        super.draw(canvas);
        int scrollY = getScrollY();
        int i3 = 0;
        if (!this.f2942f.isFinished()) {
            int save = canvas.save();
            int width = getWidth();
            int height = getHeight();
            int min = Math.min(0, scrollY);
            if (Api21Impl.a(this)) {
                width -= getPaddingLeft() + getPaddingRight();
                i2 = getPaddingLeft() + 0;
            } else {
                i2 = 0;
            }
            if (Api21Impl.a(this)) {
                height -= getPaddingTop() + getPaddingBottom();
                min += getPaddingTop();
            }
            canvas.translate((float) i2, (float) min);
            this.f2942f.setSize(width, height);
            if (this.f2942f.draw(canvas)) {
                ViewCompat.i0(this);
            }
            canvas.restoreToCount(save);
        }
        if (!this.f2943g.isFinished()) {
            int save2 = canvas.save();
            int width2 = getWidth();
            int height2 = getHeight();
            int max = Math.max(getScrollRange(), scrollY) + height2;
            if (Api21Impl.a(this)) {
                width2 -= getPaddingLeft() + getPaddingRight();
                i3 = 0 + getPaddingLeft();
            }
            if (Api21Impl.a(this)) {
                height2 -= getPaddingTop() + getPaddingBottom();
                max -= getPaddingBottom();
            }
            canvas.translate((float) (i3 - width2), (float) max);
            canvas.rotate(180.0f, (float) width2, 0.0f);
            this.f2943g.setSize(width2, height2);
            if (this.f2943g.draw(canvas)) {
                ViewCompat.i0(this);
            }
            canvas.restoreToCount(save2);
        }
    }

    /* access modifiers changed from: protected */
    public int f(Rect rect) {
        int i2;
        int i3;
        int i4;
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i5 = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        if (rect.bottom < childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin) {
            i2 = i5 - verticalFadingEdgeLength;
        } else {
            i2 = i5;
        }
        int i6 = rect.bottom;
        if (i6 > i2 && rect.top > scrollY) {
            if (rect.height() > height) {
                i4 = rect.top - scrollY;
            } else {
                i4 = rect.bottom - i2;
            }
            return Math.min(i4 + 0, (childAt.getBottom() + layoutParams.bottomMargin) - i5);
        } else if (rect.top >= scrollY || i6 >= i2) {
            return 0;
        } else {
            if (rect.height() > height) {
                i3 = 0 - (i2 - rect.bottom);
            } else {
                i3 = 0 - (scrollY - rect.top);
            }
            return Math.max(i3, -getScrollY());
        }
    }

    /* access modifiers changed from: package-private */
    public int g(int i2) {
        int height = getHeight();
        if (i2 > 0 && EdgeEffectCompat.b(this.f2942f) != 0.0f) {
            int round = Math.round((((float) (-height)) / 4.0f) * EdgeEffectCompat.d(this.f2942f, (((float) (-i2)) * 4.0f) / ((float) height), 0.5f));
            if (round != i2) {
                this.f2942f.finish();
            }
            return i2 - round;
        } else if (i2 >= 0 || EdgeEffectCompat.b(this.f2943g) == 0.0f) {
            return i2;
        } else {
            float f2 = (float) height;
            int round2 = Math.round((f2 / 4.0f) * EdgeEffectCompat.d(this.f2943g, (((float) i2) * 4.0f) / f2, 0.5f));
            if (round2 != i2) {
                this.f2943g.finish();
            }
            return i2 - round2;
        }
    }

    /* access modifiers changed from: protected */
    public float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        View childAt = getChildAt(0);
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = ((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return ((float) bottom) / ((float) verticalFadingEdgeLength);
        }
        return 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (((float) getHeight()) * 0.5f);
    }

    public int getNestedScrollAxes() {
        return this.f2961y.a();
    }

    /* access modifiers changed from: package-private */
    public int getScrollRange() {
        if (getChildCount() <= 0) {
            return 0;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
    }

    /* access modifiers changed from: protected */
    public float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return ((float) scrollY) / ((float) verticalFadingEdgeLength);
        }
        return 1.0f;
    }

    public boolean h(int i2, int i3, int[] iArr, int[] iArr2, int i4) {
        return this.f2962z.d(i2, i3, iArr, iArr2, i4);
    }

    public boolean hasNestedScrollingParent() {
        return x(0);
    }

    public void i(View view, View view2, int i2, int i3) {
        this.f2961y.c(view, view2, i2, i3);
        W(2, i3);
    }

    public boolean isNestedScrollingEnabled() {
        return this.f2962z.m();
    }

    public void j(View view, int i2) {
        this.f2961y.e(view, i2);
        stopNestedScroll(i2);
    }

    public void k(View view, int i2, int i3, int[] iArr, int i4) {
        h(i2, i3, iArr, (int[]) null, i4);
    }

    public void l(int i2, int i3, int i4, int i5, int[] iArr, int i6, int[] iArr2) {
        this.f2962z.e(i2, i3, i4, i5, iArr, i6, iArr2);
    }

    public void m(View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
        G(i5, i6, iArr);
    }

    /* access modifiers changed from: protected */
    public void measureChild(View view, int i2, int i3) {
        view.measure(ViewGroup.getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight(), view.getLayoutParams().width), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    /* access modifiers changed from: protected */
    public void measureChildWithMargins(View view, int i2, int i3, int i4, int i5) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i3, marginLayoutParams.width), View.MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, 0));
    }

    public void n(View view, int i2, int i3, int i4, int i5, int i6) {
        G(i5, i6, (int[]) null);
    }

    public boolean o(View view, View view2, int i2, int i3) {
        return (i2 & 2) != 0;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f2946j = false;
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        int i2;
        float f2;
        if (motionEvent.getAction() != 8 || this.f2948l) {
            return false;
        }
        if (MotionEventCompat.a(motionEvent, 2)) {
            f2 = motionEvent.getAxisValue(9);
            i2 = (int) motionEvent.getX();
        } else if (MotionEventCompat.a(motionEvent, 4194304)) {
            float axisValue = motionEvent.getAxisValue(26);
            i2 = getWidth() / 2;
            f2 = axisValue;
        } else {
            f2 = 0.0f;
            i2 = 0;
        }
        if (f2 == 0.0f) {
            return false;
        }
        O(-((int) (f2 * getVerticalScrollFactorCompat())), i2, 1, MotionEventCompat.a(motionEvent, 8194));
        return true;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        boolean z2 = true;
        if (action == 2 && this.f2948l) {
            return true;
        }
        int i2 = action & JfifUtil.MARKER_FIRST_BYTE;
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 == 2) {
                    int i3 = this.f2955s;
                    if (i3 != -1) {
                        int findPointerIndex = motionEvent.findPointerIndex(i3);
                        if (findPointerIndex == -1) {
                            Log.e("NestedScrollView", "Invalid pointerId=" + i3 + " in onInterceptTouchEvent");
                        } else {
                            int y2 = (int) motionEvent.getY(findPointerIndex);
                            if (Math.abs(y2 - this.f2944h) > this.f2952p && (2 & getNestedScrollAxes()) == 0) {
                                this.f2948l = true;
                                this.f2944h = y2;
                                B();
                                this.f2949m.addMovement(motionEvent);
                                this.f2958v = 0;
                                ViewParent parent = getParent();
                                if (parent != null) {
                                    parent.requestDisallowInterceptTouchEvent(true);
                                }
                            }
                        }
                    }
                } else if (i2 != 3) {
                    if (i2 == 6) {
                        H(motionEvent);
                    }
                }
            }
            this.f2948l = false;
            this.f2955s = -1;
            K();
            if (this.f2941e.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                ViewCompat.i0(this);
            }
            stopNestedScroll(0);
        } else {
            int y3 = (int) motionEvent.getY();
            if (!y((int) motionEvent.getX(), y3)) {
                if (!X(motionEvent) && this.f2941e.isFinished()) {
                    z2 = false;
                }
                this.f2948l = z2;
                K();
            } else {
                this.f2944h = y3;
                this.f2955s = motionEvent.getPointerId(0);
                z();
                this.f2949m.addMovement(motionEvent);
                this.f2941e.computeScrollOffset();
                if (!X(motionEvent) && this.f2941e.isFinished()) {
                    z2 = false;
                }
                this.f2948l = z2;
                W(2, 0);
            }
        }
        return this.f2948l;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        int i6 = 0;
        this.f2945i = false;
        View view = this.f2947k;
        if (view != null && E(view, this)) {
            P(this.f2947k);
        }
        this.f2947k = null;
        if (!this.f2946j) {
            if (this.f2960x != null) {
                scrollTo(getScrollX(), this.f2960x.f2963b);
                this.f2960x = null;
            }
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                i6 = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            }
            int paddingTop = ((i5 - i3) - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            int e2 = e(scrollY, paddingTop, i6);
            if (e2 != scrollY) {
                scrollTo(getScrollX(), e2);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.f2946j = true;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.f2950n && View.MeasureSpec.getMode(i3) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int measuredHeight2 = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - layoutParams.topMargin) - layoutParams.bottomMargin;
            if (measuredHeight < measuredHeight2) {
                childAt.measure(ViewGroup.getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight() + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824));
            }
        }
    }

    public boolean onNestedFling(View view, float f2, float f3, boolean z2) {
        if (z2) {
            return false;
        }
        dispatchNestedFling(0.0f, f3, true);
        u((int) f3);
        return true;
    }

    public boolean onNestedPreFling(View view, float f2, float f3) {
        return dispatchNestedPreFling(f2, f3);
    }

    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
        k(view, i2, i3, iArr, 0);
    }

    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        G(i5, 0, (int[]) null);
    }

    public void onNestedScrollAccepted(View view, View view2, int i2) {
        i(view, view2, i2, 0);
    }

    /* access modifiers changed from: protected */
    public void onOverScrolled(int i2, int i3, boolean z2, boolean z3) {
        super.scrollTo(i2, i3);
    }

    /* access modifiers changed from: protected */
    public boolean onRequestFocusInDescendants(int i2, Rect rect) {
        View view;
        if (i2 == 2) {
            i2 = Sdk$SDKError.Reason.MRAID_DOWNLOAD_JS_ERROR_VALUE;
        } else if (i2 == 1) {
            i2 = 33;
        }
        if (rect == null) {
            view = FocusFinder.getInstance().findNextFocus(this, (View) null, i2);
        } else {
            view = FocusFinder.getInstance().findNextFocusFromRect(this, rect, i2);
        }
        if (view != null && !D(view)) {
            return view.requestFocus(i2, rect);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f2960x = savedState;
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f2963b = getScrollY();
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        super.onScrollChanged(i2, i3, i4, i5);
        OnScrollChangeListener onScrollChangeListener = this.B;
        if (onScrollChangeListener != null) {
            onScrollChangeListener.a(this, i2, i3, i4, i5);
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        View findFocus = findFocus();
        if (findFocus != null && this != findFocus && F(findFocus, 0, i5)) {
            findFocus.getDrawingRect(this.f2940d);
            offsetDescendantRectToMyCoords(findFocus, this.f2940d);
            p(f(this.f2940d));
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i2) {
        return o(view, view2, i2, 0);
    }

    public void onStopNestedScroll(View view) {
        j(view, 0);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        ViewParent parent;
        B();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f2958v = 0;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.offsetLocation(0.0f, (float) this.f2958v);
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                VelocityTracker velocityTracker = this.f2949m;
                velocityTracker.computeCurrentVelocity(1000, (float) this.f2954r);
                int yVelocity = (int) velocityTracker.getYVelocity(this.f2955s);
                if (Math.abs(yVelocity) >= this.f2953q) {
                    if (!q(yVelocity)) {
                        int i2 = -yVelocity;
                        float f2 = (float) i2;
                        if (!dispatchNestedPreFling(0.0f, f2)) {
                            dispatchNestedFling(0.0f, f2, true);
                            u(i2);
                        }
                    }
                } else if (this.f2941e.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    ViewCompat.i0(this);
                }
                r();
            } else if (actionMasked == 2) {
                int findPointerIndex = motionEvent.findPointerIndex(this.f2955s);
                if (findPointerIndex == -1) {
                    Log.e("NestedScrollView", "Invalid pointerId=" + this.f2955s + " in onTouchEvent");
                } else {
                    int y2 = (int) motionEvent.getY(findPointerIndex);
                    int i3 = this.f2944h - y2;
                    int L = i3 - L(i3, motionEvent.getX(findPointerIndex));
                    if (!this.f2948l && Math.abs(L) > this.f2952p) {
                        ViewParent parent2 = getParent();
                        if (parent2 != null) {
                            parent2.requestDisallowInterceptTouchEvent(true);
                        }
                        this.f2948l = true;
                        L = L > 0 ? L - this.f2952p : L + this.f2952p;
                    }
                    if (this.f2948l) {
                        int O = O(L, (int) motionEvent.getX(findPointerIndex), 0, false);
                        this.f2944h = y2 - O;
                        this.f2958v += O;
                    }
                }
            } else if (actionMasked == 3) {
                if (this.f2948l && getChildCount() > 0 && this.f2941e.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    ViewCompat.i0(this);
                }
                r();
            } else if (actionMasked == 5) {
                int actionIndex = motionEvent.getActionIndex();
                this.f2944h = (int) motionEvent.getY(actionIndex);
                this.f2955s = motionEvent.getPointerId(actionIndex);
            } else if (actionMasked == 6) {
                H(motionEvent);
                this.f2944h = (int) motionEvent.getY(motionEvent.findPointerIndex(this.f2955s));
            }
        } else if (getChildCount() == 0) {
            return false;
        } else {
            if (this.f2948l && (parent = getParent()) != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            if (!this.f2941e.isFinished()) {
                a();
            }
            C((int) motionEvent.getY(), motionEvent.getPointerId(0));
        }
        VelocityTracker velocityTracker2 = this.f2949m;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(obtain);
        }
        obtain.recycle();
        return true;
    }

    public void requestChildFocus(View view, View view2) {
        if (!this.f2945i) {
            P(view2);
        } else {
            this.f2947k = view2;
        }
        super.requestChildFocus(view, view2);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z2) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        return Q(rect, z2);
    }

    public void requestDisallowInterceptTouchEvent(boolean z2) {
        if (z2) {
            K();
        }
        super.requestDisallowInterceptTouchEvent(z2);
    }

    public void requestLayout() {
        this.f2945i = true;
        super.requestLayout();
    }

    public boolean s(KeyEvent keyEvent) {
        this.f2940d.setEmpty();
        boolean d2 = d();
        int i2 = Sdk$SDKError.Reason.MRAID_DOWNLOAD_JS_ERROR_VALUE;
        if (!d2) {
            if (!isFocused() || keyEvent.getKeyCode() == 4) {
                return false;
            }
            View findFocus = findFocus();
            if (findFocus == this) {
                findFocus = null;
            }
            View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, Sdk$SDKError.Reason.MRAID_DOWNLOAD_JS_ERROR_VALUE);
            if (findNextFocus == null || findNextFocus == this || !findNextFocus.requestFocus(Sdk$SDKError.Reason.MRAID_DOWNLOAD_JS_ERROR_VALUE)) {
                return false;
            }
            return true;
        } else if (keyEvent.getAction() != 0) {
            return false;
        } else {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 19) {
                if (keyCode != 20) {
                    if (keyCode != 62) {
                        return false;
                    }
                    if (keyEvent.isShiftPressed()) {
                        i2 = 33;
                    }
                    J(i2);
                    return false;
                } else if (!keyEvent.isAltPressed()) {
                    return b(Sdk$SDKError.Reason.MRAID_DOWNLOAD_JS_ERROR_VALUE);
                } else {
                    return v(Sdk$SDKError.Reason.MRAID_DOWNLOAD_JS_ERROR_VALUE);
                }
            } else if (!keyEvent.isAltPressed()) {
                return b(33);
            } else {
                return v(33);
            }
        }
    }

    public void scrollTo(int i2, int i3) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int e2 = e(i2, (getWidth() - getPaddingLeft()) - getPaddingRight(), childAt.getWidth() + layoutParams.leftMargin + layoutParams.rightMargin);
            int e3 = e(i3, (getHeight() - getPaddingTop()) - getPaddingBottom(), childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin);
            if (e2 != getScrollX() || e3 != getScrollY()) {
                super.scrollTo(e2, e3);
            }
        }
    }

    public void setFillViewport(boolean z2) {
        if (z2 != this.f2950n) {
            this.f2950n = z2;
            requestLayout();
        }
    }

    public void setNestedScrollingEnabled(boolean z2) {
        this.f2962z.n(z2);
    }

    public void setOnScrollChangeListener(OnScrollChangeListener onScrollChangeListener) {
        this.B = onScrollChangeListener;
    }

    public void setSmoothScrollingEnabled(boolean z2) {
        this.f2951o = z2;
    }

    public boolean shouldDelayChildPressedState() {
        return true;
    }

    public boolean startNestedScroll(int i2) {
        return W(i2, 0);
    }

    public void stopNestedScroll(int i2) {
        this.f2962z.s(i2);
    }

    public void u(int i2) {
        if (getChildCount() > 0) {
            this.f2941e.fling(getScrollX(), getScrollY(), 0, i2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
            M(true);
        }
    }

    public boolean v(int i2) {
        boolean z2;
        int childCount;
        if (i2 == 130) {
            z2 = true;
        } else {
            z2 = false;
        }
        int height = getHeight();
        Rect rect = this.f2940d;
        rect.top = 0;
        rect.bottom = height;
        if (z2 && (childCount = getChildCount()) > 0) {
            View childAt = getChildAt(childCount - 1);
            this.f2940d.bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
            Rect rect2 = this.f2940d;
            rect2.top = rect2.bottom - height;
        }
        Rect rect3 = this.f2940d;
        return N(i2, rect3.top, rect3.bottom);
    }

    public boolean x(int i2) {
        return this.f2962z.l(i2);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f2940d = new Rect();
        this.f2945i = true;
        this.f2946j = false;
        this.f2947k = null;
        this.f2948l = false;
        this.f2951o = true;
        this.f2955s = -1;
        this.f2956t = new int[2];
        this.f2957u = new int[2];
        this.f2942f = EdgeEffectCompat.a(context, attributeSet);
        this.f2943g = EdgeEffectCompat.a(context, attributeSet);
        this.f2938b = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        A();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, E, i2, 0);
        setFillViewport(obtainStyledAttributes.getBoolean(0, false));
        obtainStyledAttributes.recycle();
        this.f2961y = new NestedScrollingParentHelper(this);
        this.f2962z = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        ViewCompat.r0(this, D);
    }

    public void stopNestedScroll() {
        stopNestedScroll(0);
    }

    public void addView(View view, int i2) {
        if (getChildCount() <= 0) {
            super.addView(view, i2);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, i2, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }
}
