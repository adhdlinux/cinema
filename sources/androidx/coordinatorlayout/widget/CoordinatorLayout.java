package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.R$attr;
import androidx.coordinatorlayout.R$style;
import androidx.coordinatorlayout.R$styleable;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Pools$Pool;
import androidx.core.util.Pools$SynchronizedPool;
import androidx.core.view.GravityCompat;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import com.facebook.imageutils.JfifUtil;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoordinatorLayout extends ViewGroup implements NestedScrollingParent2 {

    /* renamed from: u  reason: collision with root package name */
    static final String f2213u;

    /* renamed from: v  reason: collision with root package name */
    static final Class<?>[] f2214v = {Context.class, AttributeSet.class};

    /* renamed from: w  reason: collision with root package name */
    static final ThreadLocal<Map<String, Constructor<Behavior>>> f2215w = new ThreadLocal<>();

    /* renamed from: x  reason: collision with root package name */
    static final Comparator<View> f2216x = new ViewElevationComparator();

    /* renamed from: y  reason: collision with root package name */
    private static final Pools$Pool<Rect> f2217y = new Pools$SynchronizedPool(12);

    /* renamed from: b  reason: collision with root package name */
    private final List<View> f2218b;

    /* renamed from: c  reason: collision with root package name */
    private final DirectedAcyclicGraph<View> f2219c;

    /* renamed from: d  reason: collision with root package name */
    private final List<View> f2220d;

    /* renamed from: e  reason: collision with root package name */
    private final List<View> f2221e;

    /* renamed from: f  reason: collision with root package name */
    private final int[] f2222f;

    /* renamed from: g  reason: collision with root package name */
    private Paint f2223g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f2224h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f2225i;

    /* renamed from: j  reason: collision with root package name */
    private int[] f2226j;

    /* renamed from: k  reason: collision with root package name */
    private View f2227k;

    /* renamed from: l  reason: collision with root package name */
    private View f2228l;

    /* renamed from: m  reason: collision with root package name */
    private OnPreDrawListener f2229m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f2230n;

    /* renamed from: o  reason: collision with root package name */
    private WindowInsetsCompat f2231o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f2232p;

    /* renamed from: q  reason: collision with root package name */
    private Drawable f2233q;

    /* renamed from: r  reason: collision with root package name */
    ViewGroup.OnHierarchyChangeListener f2234r;

    /* renamed from: s  reason: collision with root package name */
    private OnApplyWindowInsetsListener f2235s;

    /* renamed from: t  reason: collision with root package name */
    private final NestedScrollingParentHelper f2236t;

    public interface AttachedBehavior {
        Behavior getBehavior();
    }

    public static abstract class Behavior<V extends View> {
        public Behavior() {
        }

        @Deprecated
        public void A(CoordinatorLayout coordinatorLayout, V v2, View view) {
        }

        public void B(CoordinatorLayout coordinatorLayout, V v2, View view, int i2) {
            if (i2 == 0) {
                A(coordinatorLayout, v2, view);
            }
        }

        public boolean C(CoordinatorLayout coordinatorLayout, V v2, MotionEvent motionEvent) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v2) {
            return d(coordinatorLayout, v2) > 0.0f;
        }

        public boolean b(CoordinatorLayout coordinatorLayout, V v2, Rect rect) {
            return false;
        }

        public int c(CoordinatorLayout coordinatorLayout, V v2) {
            return -16777216;
        }

        public float d(CoordinatorLayout coordinatorLayout, V v2) {
            return 0.0f;
        }

        public boolean e(CoordinatorLayout coordinatorLayout, V v2, View view) {
            return false;
        }

        public WindowInsetsCompat f(CoordinatorLayout coordinatorLayout, V v2, WindowInsetsCompat windowInsetsCompat) {
            return windowInsetsCompat;
        }

        public void g(LayoutParams layoutParams) {
        }

        public boolean h(CoordinatorLayout coordinatorLayout, V v2, View view) {
            return false;
        }

        public void i(CoordinatorLayout coordinatorLayout, V v2, View view) {
        }

        public void j() {
        }

        public boolean k(CoordinatorLayout coordinatorLayout, V v2, MotionEvent motionEvent) {
            return false;
        }

        public boolean l(CoordinatorLayout coordinatorLayout, V v2, int i2) {
            return false;
        }

        public boolean m(CoordinatorLayout coordinatorLayout, V v2, int i2, int i3, int i4, int i5) {
            return false;
        }

        public boolean n(CoordinatorLayout coordinatorLayout, V v2, View view, float f2, float f3, boolean z2) {
            return false;
        }

        public boolean o(CoordinatorLayout coordinatorLayout, V v2, View view, float f2, float f3) {
            return false;
        }

        @Deprecated
        public void p(CoordinatorLayout coordinatorLayout, V v2, View view, int i2, int i3, int[] iArr) {
        }

        public void q(CoordinatorLayout coordinatorLayout, V v2, View view, int i2, int i3, int[] iArr, int i4) {
            if (i4 == 0) {
                p(coordinatorLayout, v2, view, i2, i3, iArr);
            }
        }

        @Deprecated
        public void r(CoordinatorLayout coordinatorLayout, V v2, View view, int i2, int i3, int i4, int i5) {
        }

        public void s(CoordinatorLayout coordinatorLayout, V v2, View view, int i2, int i3, int i4, int i5, int i6) {
            if (i6 == 0) {
                r(coordinatorLayout, v2, view, i2, i3, i4, i5);
            }
        }

        @Deprecated
        public void t(CoordinatorLayout coordinatorLayout, V v2, View view, View view2, int i2) {
        }

        public void u(CoordinatorLayout coordinatorLayout, V v2, View view, View view2, int i2, int i3) {
            if (i3 == 0) {
                t(coordinatorLayout, v2, view, view2, i2);
            }
        }

        public boolean v(CoordinatorLayout coordinatorLayout, V v2, Rect rect, boolean z2) {
            return false;
        }

        public void w(CoordinatorLayout coordinatorLayout, V v2, Parcelable parcelable) {
        }

        public Parcelable x(CoordinatorLayout coordinatorLayout, V v2) {
            return View.BaseSavedState.EMPTY_STATE;
        }

        @Deprecated
        public boolean y(CoordinatorLayout coordinatorLayout, V v2, View view, View view2, int i2) {
            return false;
        }

        public boolean z(CoordinatorLayout coordinatorLayout, V v2, View view, View view2, int i2, int i3) {
            if (i3 == 0) {
                return y(coordinatorLayout, v2, view, view2, i2);
            }
            return false;
        }

        public Behavior(Context context, AttributeSet attributeSet) {
        }
    }

    @Deprecated
    @Retention(RetentionPolicy.RUNTIME)
    public @interface DefaultBehavior {
        Class<? extends Behavior> value();
    }

    private class HierarchyChangeListener implements ViewGroup.OnHierarchyChangeListener {
        HierarchyChangeListener() {
        }

        public void onChildViewAdded(View view, View view2) {
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.f2234r;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        public void onChildViewRemoved(View view, View view2) {
            CoordinatorLayout.this.H(2);
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.f2234r;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    class OnPreDrawListener implements ViewTreeObserver.OnPreDrawListener {
        OnPreDrawListener() {
        }

        public boolean onPreDraw() {
            CoordinatorLayout.this.H(0);
            return true;
        }
    }

    static class ViewElevationComparator implements Comparator<View> {
        ViewElevationComparator() {
        }

        /* renamed from: a */
        public int compare(View view, View view2) {
            float O = ViewCompat.O(view);
            float O2 = ViewCompat.O(view2);
            if (O > O2) {
                return -1;
            }
            if (O < O2) {
                return 1;
            }
            return 0;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.lang.Class<?>[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            java.lang.Class<androidx.coordinatorlayout.widget.CoordinatorLayout> r0 = androidx.coordinatorlayout.widget.CoordinatorLayout.class
            java.lang.Package r0 = r0.getPackage()
            if (r0 == 0) goto L_0x000d
            java.lang.String r0 = r0.getName()
            goto L_0x000e
        L_0x000d:
            r0 = 0
        L_0x000e:
            f2213u = r0
            androidx.coordinatorlayout.widget.CoordinatorLayout$ViewElevationComparator r0 = new androidx.coordinatorlayout.widget.CoordinatorLayout$ViewElevationComparator
            r0.<init>()
            f2216x = r0
            r0 = 2
            java.lang.Class[] r0 = new java.lang.Class[r0]
            r1 = 0
            java.lang.Class<android.content.Context> r2 = android.content.Context.class
            r0[r1] = r2
            r1 = 1
            java.lang.Class<android.util.AttributeSet> r2 = android.util.AttributeSet.class
            r0[r1] = r2
            f2214v = r0
            java.lang.ThreadLocal r0 = new java.lang.ThreadLocal
            r0.<init>()
            f2215w = r0
            androidx.core.util.Pools$SynchronizedPool r0 = new androidx.core.util.Pools$SynchronizedPool
            r1 = 12
            r0.<init>(r1)
            f2217y = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.<clinit>():void");
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.f2195a);
    }

    private boolean A(View view) {
        return this.f2219c.j(view);
    }

    private void C(View view, int i2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect a2 = a();
        a2.set(getPaddingLeft() + layoutParams.leftMargin, getPaddingTop() + layoutParams.topMargin, (getWidth() - getPaddingRight()) - layoutParams.rightMargin, (getHeight() - getPaddingBottom()) - layoutParams.bottomMargin);
        if (this.f2231o != null && ViewCompat.A(this) && !ViewCompat.A(view)) {
            a2.left += this.f2231o.i();
            a2.top += this.f2231o.k();
            a2.right -= this.f2231o.j();
            a2.bottom -= this.f2231o.h();
        }
        Rect a3 = a();
        GravityCompat.a(S(layoutParams.f2241c), view.getMeasuredWidth(), view.getMeasuredHeight(), a2, a3, i2);
        view.layout(a3.left, a3.top, a3.right, a3.bottom);
        O(a2);
        O(a3);
    }

    private void D(View view, View view2, int i2) {
        Rect a2 = a();
        Rect a3 = a();
        try {
            t(view2, a2);
            u(view, i2, a2, a3);
            view.layout(a3.left, a3.top, a3.right, a3.bottom);
        } finally {
            O(a2);
            O(a3);
        }
    }

    private void E(View view, int i2, int i3) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int b2 = GravityCompat.b(T(layoutParams.f2241c), i3);
        int i4 = b2 & 7;
        int i5 = b2 & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (i3 == 1) {
            i2 = width - i2;
        }
        int w2 = w(i2) - measuredWidth;
        if (i4 == 1) {
            w2 += measuredWidth / 2;
        } else if (i4 == 5) {
            w2 += measuredWidth;
        }
        int i6 = 0;
        if (i5 == 16) {
            i6 = 0 + (measuredHeight / 2);
        } else if (i5 == 80) {
            i6 = measuredHeight + 0;
        }
        int max = Math.max(getPaddingLeft() + layoutParams.leftMargin, Math.min(w2, ((width - getPaddingRight()) - measuredWidth) - layoutParams.rightMargin));
        int max2 = Math.max(getPaddingTop() + layoutParams.topMargin, Math.min(i6, ((height - getPaddingBottom()) - measuredHeight) - layoutParams.bottomMargin));
        view.layout(max, max2, measuredWidth + max, measuredHeight + max2);
    }

    private void F(View view, Rect rect, int i2) {
        boolean z2;
        boolean z3;
        int width;
        int i3;
        int i4;
        int i5;
        int height;
        int i6;
        int i7;
        int i8;
        if (ViewCompat.V(view) && view.getWidth() > 0 && view.getHeight() > 0) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Behavior f2 = layoutParams.f();
            Rect a2 = a();
            Rect a3 = a();
            a3.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            if (f2 == null || !f2.b(this, view, a2)) {
                a2.set(a3);
            } else if (!a3.contains(a2)) {
                throw new IllegalArgumentException("Rect should be within the child's bounds. Rect:" + a2.toShortString() + " | Bounds:" + a3.toShortString());
            }
            O(a3);
            if (a2.isEmpty()) {
                O(a2);
                return;
            }
            int b2 = GravityCompat.b(layoutParams.f2246h, i2);
            boolean z4 = true;
            if ((b2 & 48) != 48 || (i7 = (a2.top - layoutParams.topMargin) - layoutParams.f2248j) >= (i8 = rect.top)) {
                z2 = false;
            } else {
                V(view, i8 - i7);
                z2 = true;
            }
            if ((b2 & 80) == 80 && (height = ((getHeight() - a2.bottom) - layoutParams.bottomMargin) + layoutParams.f2248j) < (i6 = rect.bottom)) {
                V(view, height - i6);
                z2 = true;
            }
            if (!z2) {
                V(view, 0);
            }
            if ((b2 & 3) != 3 || (i4 = (a2.left - layoutParams.leftMargin) - layoutParams.f2247i) >= (i5 = rect.left)) {
                z3 = false;
            } else {
                U(view, i5 - i4);
                z3 = true;
            }
            if ((b2 & 5) != 5 || (width = ((getWidth() - a2.right) - layoutParams.rightMargin) + layoutParams.f2247i) >= (i3 = rect.right)) {
                z4 = z3;
            } else {
                U(view, width - i3);
            }
            if (!z4) {
                U(view, 0);
            }
            O(a2);
        }
    }

    static Behavior K(Context context, AttributeSet attributeSet, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(".")) {
            str = context.getPackageName() + str;
        } else if (str.indexOf(46) < 0) {
            String str2 = f2213u;
            if (!TextUtils.isEmpty(str2)) {
                str = str2 + '.' + str;
            }
        }
        try {
            ThreadLocal<Map<String, Constructor<Behavior>>> threadLocal = f2215w;
            Map map = threadLocal.get();
            if (map == null) {
                map = new HashMap();
                threadLocal.set(map);
            }
            Constructor<?> constructor = (Constructor) map.get(str);
            if (constructor == null) {
                constructor = context.getClassLoader().loadClass(str).getConstructor(f2214v);
                constructor.setAccessible(true);
                map.put(str, constructor);
            }
            return (Behavior) constructor.newInstance(new Object[]{context, attributeSet});
        } catch (Exception e2) {
            throw new RuntimeException("Could not inflate Behavior subclass " + str, e2);
        }
    }

    private boolean L(MotionEvent motionEvent, int i2) {
        MotionEvent motionEvent2 = motionEvent;
        int i3 = i2;
        int actionMasked = motionEvent.getActionMasked();
        List<View> list = this.f2220d;
        z(list);
        int size = list.size();
        MotionEvent motionEvent3 = null;
        boolean z2 = false;
        boolean z3 = false;
        for (int i4 = 0; i4 < size; i4++) {
            View view = list.get(i4);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Behavior f2 = layoutParams.f();
            if ((!z2 && !z3) || actionMasked == 0) {
                if (!z2 && f2 != null) {
                    if (i3 == 0) {
                        z2 = f2.k(this, view, motionEvent2);
                    } else if (i3 == 1) {
                        z2 = f2.C(this, view, motionEvent2);
                    }
                    if (z2) {
                        this.f2227k = view;
                    }
                }
                boolean c2 = layoutParams.c();
                boolean i5 = layoutParams.i(this, view);
                if (!i5 || c2) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                if (i5 && !z3) {
                    break;
                }
            } else if (f2 != null) {
                if (motionEvent3 == null) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    motionEvent3 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                }
                if (i3 == 0) {
                    f2.k(this, view, motionEvent3);
                } else if (i3 == 1) {
                    f2.C(this, view, motionEvent3);
                }
            }
        }
        list.clear();
        return z2;
    }

    private void M() {
        this.f2218b.clear();
        this.f2219c.c();
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            LayoutParams y2 = y(childAt);
            y2.d(this, childAt);
            this.f2219c.b(childAt);
            for (int i3 = 0; i3 < childCount; i3++) {
                if (i3 != i2) {
                    View childAt2 = getChildAt(i3);
                    if (y2.b(this, childAt, childAt2)) {
                        if (!this.f2219c.d(childAt2)) {
                            this.f2219c.b(childAt2);
                        }
                        this.f2219c.a(childAt2, childAt);
                    }
                }
            }
        }
        this.f2218b.addAll(this.f2219c.i());
        Collections.reverse(this.f2218b);
    }

    private static void O(Rect rect) {
        rect.setEmpty();
        f2217y.release(rect);
    }

    private void Q(boolean z2) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            Behavior f2 = ((LayoutParams) childAt.getLayoutParams()).f();
            if (f2 != null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                if (z2) {
                    f2.k(this, childAt, obtain);
                } else {
                    f2.C(this, childAt, obtain);
                }
                obtain.recycle();
            }
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            ((LayoutParams) getChildAt(i3).getLayoutParams()).m();
        }
        this.f2227k = null;
        this.f2224h = false;
    }

    private static int R(int i2) {
        if (i2 == 0) {
            return 17;
        }
        return i2;
    }

    private static int S(int i2) {
        if ((i2 & 7) == 0) {
            i2 |= 8388611;
        }
        return (i2 & 112) == 0 ? i2 | 48 : i2;
    }

    private static int T(int i2) {
        if (i2 == 0) {
            return 8388661;
        }
        return i2;
    }

    private void U(View view, int i2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i3 = layoutParams.f2247i;
        if (i3 != i2) {
            ViewCompat.b0(view, i2 - i3);
            layoutParams.f2247i = i2;
        }
    }

    private void V(View view, int i2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i3 = layoutParams.f2248j;
        if (i3 != i2) {
            ViewCompat.c0(view, i2 - i3);
            layoutParams.f2248j = i2;
        }
    }

    private void X() {
        if (ViewCompat.A(this)) {
            if (this.f2235s == null) {
                this.f2235s = new OnApplyWindowInsetsListener() {
                    public WindowInsetsCompat a(View view, WindowInsetsCompat windowInsetsCompat) {
                        return CoordinatorLayout.this.W(windowInsetsCompat);
                    }
                };
            }
            ViewCompat.G0(this, this.f2235s);
            setSystemUiVisibility(1280);
            return;
        }
        ViewCompat.G0(this, (OnApplyWindowInsetsListener) null);
    }

    private static Rect a() {
        Rect acquire = f2217y.acquire();
        if (acquire == null) {
            return new Rect();
        }
        return acquire;
    }

    private static int c(int i2, int i3, int i4) {
        return i2 < i3 ? i3 : i2 > i4 ? i4 : i2;
    }

    private void d(LayoutParams layoutParams, Rect rect, int i2, int i3) {
        int width = getWidth();
        int height = getHeight();
        int max = Math.max(getPaddingLeft() + layoutParams.leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i2) - layoutParams.rightMargin));
        int max2 = Math.max(getPaddingTop() + layoutParams.topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i3) - layoutParams.bottomMargin));
        rect.set(max, max2, i2 + max, i3 + max2);
    }

    private WindowInsetsCompat e(WindowInsetsCompat windowInsetsCompat) {
        Behavior f2;
        if (windowInsetsCompat.o()) {
            return windowInsetsCompat;
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (ViewCompat.A(childAt) && (f2 = ((LayoutParams) childAt.getLayoutParams()).f()) != null) {
                windowInsetsCompat = f2.f(this, childAt, windowInsetsCompat);
                if (windowInsetsCompat.o()) {
                    break;
                }
            }
        }
        return windowInsetsCompat;
    }

    private void v(View view, int i2, Rect rect, Rect rect2, LayoutParams layoutParams, int i3, int i4) {
        int i5;
        int i6;
        int b2 = GravityCompat.b(R(layoutParams.f2241c), i2);
        int b3 = GravityCompat.b(S(layoutParams.f2242d), i2);
        int i7 = b2 & 7;
        int i8 = b2 & 112;
        int i9 = b3 & 7;
        int i10 = b3 & 112;
        if (i9 == 1) {
            i5 = rect.left + (rect.width() / 2);
        } else if (i9 != 5) {
            i5 = rect.left;
        } else {
            i5 = rect.right;
        }
        if (i10 == 16) {
            i6 = rect.top + (rect.height() / 2);
        } else if (i10 != 80) {
            i6 = rect.top;
        } else {
            i6 = rect.bottom;
        }
        if (i7 == 1) {
            i5 -= i3 / 2;
        } else if (i7 != 5) {
            i5 -= i3;
        }
        if (i8 == 16) {
            i6 -= i4 / 2;
        } else if (i8 != 80) {
            i6 -= i4;
        }
        rect2.set(i5, i6, i3 + i5, i4 + i6);
    }

    private int w(int i2) {
        int[] iArr = this.f2226j;
        if (iArr == null) {
            Log.e("CoordinatorLayout", "No keylines defined for " + this + " - attempted index lookup " + i2);
            return 0;
        } else if (i2 >= 0 && i2 < iArr.length) {
            return iArr[i2];
        } else {
            Log.e("CoordinatorLayout", "Keyline index " + i2 + " out of range for " + this);
            return 0;
        }
    }

    private void z(List<View> list) {
        int i2;
        list.clear();
        boolean isChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i3 = childCount - 1; i3 >= 0; i3--) {
            if (isChildrenDrawingOrderEnabled) {
                i2 = getChildDrawingOrder(childCount, i3);
            } else {
                i2 = i3;
            }
            list.add(getChildAt(i2));
        }
        Comparator<View> comparator = f2216x;
        if (comparator != null) {
            Collections.sort(list, comparator);
        }
    }

    public boolean B(View view, int i2, int i3) {
        Rect a2 = a();
        t(view, a2);
        try {
            return a2.contains(i2, i3);
        } finally {
            O(a2);
        }
    }

    /* access modifiers changed from: package-private */
    public void G(View view, int i2) {
        Behavior f2;
        View view2 = view;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams.f2249k != null) {
            Rect a2 = a();
            Rect a3 = a();
            Rect a4 = a();
            t(layoutParams.f2249k, a2);
            boolean z2 = false;
            q(view2, false, a3);
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            int i3 = measuredHeight;
            v(view, i2, a2, a4, layoutParams, measuredWidth, measuredHeight);
            if (!(a4.left == a3.left && a4.top == a3.top)) {
                z2 = true;
            }
            d(layoutParams, a4, measuredWidth, i3);
            int i4 = a4.left - a3.left;
            int i5 = a4.top - a3.top;
            if (i4 != 0) {
                ViewCompat.b0(view2, i4);
            }
            if (i5 != 0) {
                ViewCompat.c0(view2, i5);
            }
            if (z2 && (f2 = layoutParams.f()) != null) {
                f2.h(this, view2, layoutParams.f2249k);
            }
            O(a2);
            O(a3);
            O(a4);
        }
    }

    /* access modifiers changed from: package-private */
    public final void H(int i2) {
        boolean z2;
        int i3 = i2;
        int D = ViewCompat.D(this);
        int size = this.f2218b.size();
        Rect a2 = a();
        Rect a3 = a();
        Rect a4 = a();
        for (int i4 = 0; i4 < size; i4++) {
            View view = this.f2218b.get(i4);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (i3 != 0 || view.getVisibility() != 8) {
                for (int i5 = 0; i5 < i4; i5++) {
                    if (layoutParams.f2250l == this.f2218b.get(i5)) {
                        G(view, D);
                    }
                }
                q(view, true, a3);
                if (layoutParams.f2245g != 0 && !a3.isEmpty()) {
                    int b2 = GravityCompat.b(layoutParams.f2245g, D);
                    int i6 = b2 & 112;
                    if (i6 == 48) {
                        a2.top = Math.max(a2.top, a3.bottom);
                    } else if (i6 == 80) {
                        a2.bottom = Math.max(a2.bottom, getHeight() - a3.top);
                    }
                    int i7 = b2 & 7;
                    if (i7 == 3) {
                        a2.left = Math.max(a2.left, a3.right);
                    } else if (i7 == 5) {
                        a2.right = Math.max(a2.right, getWidth() - a3.left);
                    }
                }
                if (layoutParams.f2246h != 0 && view.getVisibility() == 0) {
                    F(view, a2, D);
                }
                if (i3 != 2) {
                    x(view, a4);
                    if (!a4.equals(a3)) {
                        N(view, a3);
                    }
                }
                for (int i8 = i4 + 1; i8 < size; i8++) {
                    View view2 = this.f2218b.get(i8);
                    LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
                    Behavior f2 = layoutParams2.f();
                    if (f2 != null && f2.e(this, view2, view)) {
                        if (i3 != 0 || !layoutParams2.g()) {
                            if (i3 != 2) {
                                z2 = f2.h(this, view2, view);
                            } else {
                                f2.i(this, view2, view);
                                z2 = true;
                            }
                            if (i3 == 1) {
                                layoutParams2.p(z2);
                            }
                        } else {
                            layoutParams2.k();
                        }
                    }
                }
            }
        }
        O(a2);
        O(a3);
        O(a4);
    }

    public void I(View view, int i2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.a()) {
            View view2 = layoutParams.f2249k;
            if (view2 != null) {
                D(view, view2, i2);
                return;
            }
            int i3 = layoutParams.f2243e;
            if (i3 >= 0) {
                E(view, i3, i2);
            } else {
                C(view, i2);
            }
        } else {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        }
    }

    public void J(View view, int i2, int i3, int i4, int i5) {
        measureChildWithMargins(view, i2, i3, i4, i5);
    }

    /* access modifiers changed from: package-private */
    public void N(View view, Rect rect) {
        ((LayoutParams) view.getLayoutParams()).q(rect);
    }

    /* access modifiers changed from: package-private */
    public void P() {
        if (this.f2225i && this.f2229m != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f2229m);
        }
        this.f2230n = false;
    }

    /* access modifiers changed from: package-private */
    public final WindowInsetsCompat W(WindowInsetsCompat windowInsetsCompat) {
        boolean z2;
        if (ObjectsCompat.a(this.f2231o, windowInsetsCompat)) {
            return windowInsetsCompat;
        }
        this.f2231o = windowInsetsCompat;
        boolean z3 = true;
        if (windowInsetsCompat == null || windowInsetsCompat.k() <= 0) {
            z2 = false;
        } else {
            z2 = true;
        }
        this.f2232p = z2;
        if (z2 || getBackground() != null) {
            z3 = false;
        }
        setWillNotDraw(z3);
        WindowInsetsCompat e2 = e(windowInsetsCompat);
        requestLayout();
        return e2;
    }

    /* access modifiers changed from: package-private */
    public void b() {
        if (this.f2225i) {
            if (this.f2229m == null) {
                this.f2229m = new OnPreDrawListener();
            }
            getViewTreeObserver().addOnPreDrawListener(this.f2229m);
        }
        this.f2230n = true;
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Behavior behavior = layoutParams.f2239a;
        if (behavior != null) {
            float d2 = behavior.d(this, view);
            if (d2 > 0.0f) {
                if (this.f2223g == null) {
                    this.f2223g = new Paint();
                }
                this.f2223g.setColor(layoutParams.f2239a.c(this, view));
                this.f2223g.setAlpha(c(Math.round(d2 * 255.0f), 0, JfifUtil.MARKER_FIRST_BYTE));
                int save = canvas.save();
                if (view.isOpaque()) {
                    canvas.clipRect((float) view.getLeft(), (float) view.getTop(), (float) view.getRight(), (float) view.getBottom(), Region.Op.DIFFERENCE);
                }
                canvas.drawRect((float) getPaddingLeft(), (float) getPaddingTop(), (float) (getWidth() - getPaddingRight()), (float) (getHeight() - getPaddingBottom()), this.f2223g);
                canvas.restoreToCount(save);
            }
        }
        return super.drawChild(canvas, view, j2);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f2233q;
        boolean z2 = false;
        if (drawable != null && drawable.isStateful()) {
            z2 = false | drawable.setState(drawableState);
        }
        if (z2) {
            invalidate();
        }
    }

    public void f(View view) {
        List g2 = this.f2219c.g(view);
        if (g2 != null && !g2.isEmpty()) {
            for (int i2 = 0; i2 < g2.size(); i2++) {
                View view2 = (View) g2.get(i2);
                Behavior f2 = ((LayoutParams) view2.getLayoutParams()).f();
                if (f2 != null) {
                    f2.h(this, view2, view);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void g() {
        int childCount = getChildCount();
        boolean z2 = false;
        int i2 = 0;
        while (true) {
            if (i2 >= childCount) {
                break;
            } else if (A(getChildAt(i2))) {
                z2 = true;
                break;
            } else {
                i2++;
            }
        }
        if (z2 == this.f2230n) {
            return;
        }
        if (z2) {
            b();
        } else {
            P();
        }
    }

    /* access modifiers changed from: package-private */
    public final List<View> getDependencySortedChildren() {
        M();
        return Collections.unmodifiableList(this.f2218b);
    }

    public final WindowInsetsCompat getLastWindowInsets() {
        return this.f2231o;
    }

    public int getNestedScrollAxes() {
        return this.f2236t.a();
    }

    public Drawable getStatusBarBackground() {
        return this.f2233q;
    }

    /* access modifiers changed from: protected */
    public int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    /* access modifiers changed from: protected */
    public int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    public void i(View view, View view2, int i2, int i3) {
        Behavior f2;
        this.f2236t.c(view, view2, i2, i3);
        this.f2228l = view2;
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (layoutParams.j(i3) && (f2 = layoutParams.f()) != null) {
                f2.u(this, childAt, view, view2, i2, i3);
            }
        }
    }

    public void j(View view, int i2) {
        this.f2236t.e(view, i2);
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (layoutParams.j(i2)) {
                Behavior f2 = layoutParams.f();
                if (f2 != null) {
                    f2.B(this, childAt, view, i2);
                }
                layoutParams.l(i2);
                layoutParams.k();
            }
        }
        this.f2228l = null;
    }

    public void k(View view, int i2, int i3, int[] iArr, int i4) {
        Behavior f2;
        int i5;
        int i6;
        int childCount = getChildCount();
        boolean z2 = false;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() == 8) {
                int i10 = i4;
            } else {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.j(i4) && (f2 = layoutParams.f()) != null) {
                    int[] iArr2 = this.f2222f;
                    iArr2[1] = 0;
                    iArr2[0] = 0;
                    f2.q(this, childAt, view, i2, i3, iArr2, i4);
                    int[] iArr3 = this.f2222f;
                    if (i2 > 0) {
                        i5 = Math.max(i7, iArr3[0]);
                    } else {
                        i5 = Math.min(i7, iArr3[0]);
                    }
                    i7 = i5;
                    int[] iArr4 = this.f2222f;
                    if (i3 > 0) {
                        i6 = Math.max(i8, iArr4[1]);
                    } else {
                        i6 = Math.min(i8, iArr4[1]);
                    }
                    i8 = i6;
                    z2 = true;
                }
            }
        }
        iArr[0] = i7;
        iArr[1] = i8;
        if (z2) {
            H(1);
        }
    }

    /* renamed from: l */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public void n(View view, int i2, int i3, int i4, int i5, int i6) {
        Behavior f2;
        int childCount = getChildCount();
        boolean z2 = false;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() == 8) {
                int i8 = i6;
            } else {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.j(i6) && (f2 = layoutParams.f()) != null) {
                    f2.s(this, childAt, view, i2, i3, i4, i5, i6);
                    z2 = true;
                }
            }
        }
        if (z2) {
            H(1);
        }
    }

    public boolean o(View view, View view2, int i2, int i3) {
        int i4 = i3;
        int childCount = getChildCount();
        boolean z2 = false;
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                Behavior f2 = layoutParams.f();
                if (f2 != null) {
                    boolean z3 = f2.z(this, childAt, view, view2, i2, i3);
                    z2 |= z3;
                    layoutParams.r(i4, z3);
                } else {
                    layoutParams.r(i4, false);
                }
            }
        }
        return z2;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Q(false);
        if (this.f2230n) {
            if (this.f2229m == null) {
                this.f2229m = new OnPreDrawListener();
            }
            getViewTreeObserver().addOnPreDrawListener(this.f2229m);
        }
        if (this.f2231o == null && ViewCompat.A(this)) {
            ViewCompat.o0(this);
        }
        this.f2225i = true;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Q(false);
        if (this.f2230n && this.f2229m != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f2229m);
        }
        View view = this.f2228l;
        if (view != null) {
            onStopNestedScroll(view);
        }
        this.f2225i = false;
    }

    public void onDraw(Canvas canvas) {
        int i2;
        super.onDraw(canvas);
        if (this.f2232p && this.f2233q != null) {
            WindowInsetsCompat windowInsetsCompat = this.f2231o;
            if (windowInsetsCompat != null) {
                i2 = windowInsetsCompat.k();
            } else {
                i2 = 0;
            }
            if (i2 > 0) {
                this.f2233q.setBounds(0, 0, getWidth(), i2);
                this.f2233q.draw(canvas);
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            Q(true);
        }
        boolean L = L(motionEvent, 0);
        if (actionMasked == 1 || actionMasked == 3) {
            Q(true);
        }
        return L;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        Behavior f2;
        int D = ViewCompat.D(this);
        int size = this.f2218b.size();
        for (int i6 = 0; i6 < size; i6++) {
            View view = this.f2218b.get(i6);
            if (view.getVisibility() != 8 && ((f2 = ((LayoutParams) view.getLayoutParams()).f()) == null || !f2.l(this, view, D))) {
                I(view, D);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x011a, code lost:
        if (r0.m(r30, r20, r11, r21, r23, 0) == false) goto L_0x012a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x011d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r31, int r32) {
        /*
            r30 = this;
            r7 = r30
            r30.M()
            r30.g()
            int r8 = r30.getPaddingLeft()
            int r0 = r30.getPaddingTop()
            int r9 = r30.getPaddingRight()
            int r1 = r30.getPaddingBottom()
            int r10 = androidx.core.view.ViewCompat.D(r30)
            r2 = 1
            if (r10 != r2) goto L_0x0021
            r12 = 1
            goto L_0x0022
        L_0x0021:
            r12 = 0
        L_0x0022:
            int r13 = android.view.View.MeasureSpec.getMode(r31)
            int r14 = android.view.View.MeasureSpec.getSize(r31)
            int r15 = android.view.View.MeasureSpec.getMode(r32)
            int r16 = android.view.View.MeasureSpec.getSize(r32)
            int r17 = r8 + r9
            int r18 = r0 + r1
            int r0 = r30.getSuggestedMinimumWidth()
            int r1 = r30.getSuggestedMinimumHeight()
            androidx.core.view.WindowInsetsCompat r3 = r7.f2231o
            if (r3 == 0) goto L_0x004b
            boolean r3 = androidx.core.view.ViewCompat.A(r30)
            if (r3 == 0) goto L_0x004b
            r19 = 1
            goto L_0x004d
        L_0x004b:
            r19 = 0
        L_0x004d:
            java.util.List<android.view.View> r2 = r7.f2218b
            int r6 = r2.size()
            r5 = r0
            r4 = r1
            r2 = 0
            r3 = 0
        L_0x0057:
            if (r3 >= r6) goto L_0x016f
            java.util.List<android.view.View> r0 = r7.f2218b
            java.lang.Object r0 = r0.get(r3)
            r20 = r0
            android.view.View r20 = (android.view.View) r20
            int r0 = r20.getVisibility()
            r1 = 8
            if (r0 != r1) goto L_0x0073
            r22 = r3
            r29 = r6
            r28 = r8
            goto L_0x0167
        L_0x0073:
            android.view.ViewGroup$LayoutParams r0 = r20.getLayoutParams()
            r1 = r0
            androidx.coordinatorlayout.widget.CoordinatorLayout$LayoutParams r1 = (androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams) r1
            int r0 = r1.f2243e
            if (r0 < 0) goto L_0x00ba
            if (r13 == 0) goto L_0x00ba
            int r0 = r7.w(r0)
            int r11 = r1.f2241c
            int r11 = T(r11)
            int r11 = androidx.core.view.GravityCompat.b(r11, r10)
            r11 = r11 & 7
            r22 = r2
            r2 = 3
            if (r11 != r2) goto L_0x0097
            if (r12 == 0) goto L_0x009c
        L_0x0097:
            r2 = 5
            if (r11 != r2) goto L_0x00a8
            if (r12 == 0) goto L_0x00a8
        L_0x009c:
            int r2 = r14 - r9
            int r2 = r2 - r0
            r0 = 0
            int r2 = java.lang.Math.max(r0, r2)
            r21 = r2
            r11 = 0
            goto L_0x00bf
        L_0x00a8:
            if (r11 != r2) goto L_0x00ac
            if (r12 == 0) goto L_0x00b1
        L_0x00ac:
            r2 = 3
            if (r11 != r2) goto L_0x00bc
            if (r12 == 0) goto L_0x00bc
        L_0x00b1:
            int r0 = r0 - r8
            r11 = 0
            int r0 = java.lang.Math.max(r11, r0)
            r21 = r0
            goto L_0x00bf
        L_0x00ba:
            r22 = r2
        L_0x00bc:
            r11 = 0
            r21 = 0
        L_0x00bf:
            if (r19 == 0) goto L_0x00f1
            boolean r0 = androidx.core.view.ViewCompat.A(r20)
            if (r0 != 0) goto L_0x00f1
            androidx.core.view.WindowInsetsCompat r0 = r7.f2231o
            int r0 = r0.i()
            androidx.core.view.WindowInsetsCompat r2 = r7.f2231o
            int r2 = r2.j()
            int r0 = r0 + r2
            androidx.core.view.WindowInsetsCompat r2 = r7.f2231o
            int r2 = r2.k()
            androidx.core.view.WindowInsetsCompat r11 = r7.f2231o
            int r11 = r11.h()
            int r2 = r2 + r11
            int r0 = r14 - r0
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r13)
            int r2 = r16 - r2
            int r2 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r15)
            r11 = r0
            r23 = r2
            goto L_0x00f5
        L_0x00f1:
            r11 = r31
            r23 = r32
        L_0x00f5:
            androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior r0 = r1.f()
            if (r0 == 0) goto L_0x011d
            r24 = 0
            r2 = r1
            r1 = r30
            r26 = r2
            r25 = r22
            r2 = r20
            r22 = r3
            r3 = r11
            r27 = r4
            r4 = r21
            r28 = r8
            r8 = r5
            r5 = r23
            r29 = r6
            r6 = r24
            boolean r0 = r0.m(r1, r2, r3, r4, r5, r6)
            if (r0 != 0) goto L_0x0137
            goto L_0x012a
        L_0x011d:
            r26 = r1
            r27 = r4
            r29 = r6
            r28 = r8
            r25 = r22
            r22 = r3
            r8 = r5
        L_0x012a:
            r5 = 0
            r0 = r30
            r1 = r20
            r2 = r11
            r3 = r21
            r4 = r23
            r0.J(r1, r2, r3, r4, r5)
        L_0x0137:
            int r0 = r20.getMeasuredWidth()
            int r0 = r17 + r0
            r1 = r26
            int r2 = r1.leftMargin
            int r0 = r0 + r2
            int r2 = r1.rightMargin
            int r0 = r0 + r2
            int r0 = java.lang.Math.max(r8, r0)
            int r2 = r20.getMeasuredHeight()
            int r2 = r18 + r2
            int r3 = r1.topMargin
            int r2 = r2 + r3
            int r1 = r1.bottomMargin
            int r2 = r2 + r1
            r1 = r27
            int r1 = java.lang.Math.max(r1, r2)
            int r2 = r20.getMeasuredState()
            r11 = r25
            int r2 = android.view.View.combineMeasuredStates(r11, r2)
            r5 = r0
            r4 = r1
        L_0x0167:
            int r3 = r22 + 1
            r8 = r28
            r6 = r29
            goto L_0x0057
        L_0x016f:
            r11 = r2
            r1 = r4
            r8 = r5
            r0 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r0 = r0 & r11
            r2 = r31
            int r0 = android.view.View.resolveSizeAndState(r8, r2, r0)
            int r2 = r11 << 16
            r3 = r32
            int r1 = android.view.View.resolveSizeAndState(r1, r3, r2)
            r7.setMeasuredDimension(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onMeasure(int, int):void");
    }

    public boolean onNestedFling(View view, float f2, float f3, boolean z2) {
        Behavior f4;
        int childCount = getChildCount();
        boolean z3 = false;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.j(0) && (f4 = layoutParams.f()) != null) {
                    z3 |= f4.n(this, childAt, view, f2, f3, z2);
                }
            }
        }
        if (z3) {
            H(1);
        }
        return z3;
    }

    public boolean onNestedPreFling(View view, float f2, float f3) {
        Behavior f4;
        int childCount = getChildCount();
        boolean z2 = false;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.j(0) && (f4 = layoutParams.f()) != null) {
                    z2 |= f4.o(this, childAt, view, f2, f3);
                }
            }
        }
        return z2;
    }

    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
        k(view, i2, i3, iArr, 0);
    }

    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        n(view, i2, i3, i4, i5, 0);
    }

    public void onNestedScrollAccepted(View view, View view2, int i2) {
        i(view, view2, i2, 0);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.b());
        SparseArray<Parcelable> sparseArray = savedState.f2258d;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            int id = childAt.getId();
            Behavior f2 = y(childAt).f();
            if (!(id == -1 || f2 == null || (parcelable2 = sparseArray.get(id)) == null)) {
                f2.w(this, childAt, parcelable2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Parcelable x2;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            int id = childAt.getId();
            Behavior f2 = ((LayoutParams) childAt.getLayoutParams()).f();
            if (!(id == -1 || f2 == null || (x2 = f2.x(this, childAt)) == null)) {
                sparseArray.append(id, x2);
            }
        }
        savedState.f2258d = sparseArray;
        return savedState;
    }

    public boolean onStartNestedScroll(View view, View view2, int i2) {
        return o(view, view2, i2, 0);
    }

    public void onStopNestedScroll(View view) {
        j(view, 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0012, code lost:
        if (r3 != false) goto L_0x0016;
     */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            int r2 = r18.getActionMasked()
            android.view.View r3 = r0.f2227k
            r4 = 1
            r5 = 0
            if (r3 != 0) goto L_0x0015
            boolean r3 = r0.L(r1, r4)
            if (r3 == 0) goto L_0x002b
            goto L_0x0016
        L_0x0015:
            r3 = 0
        L_0x0016:
            android.view.View r6 = r0.f2227k
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            androidx.coordinatorlayout.widget.CoordinatorLayout$LayoutParams r6 = (androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams) r6
            androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior r6 = r6.f()
            if (r6 == 0) goto L_0x002b
            android.view.View r7 = r0.f2227k
            boolean r6 = r6.C(r0, r7, r1)
            goto L_0x002c
        L_0x002b:
            r6 = 0
        L_0x002c:
            android.view.View r7 = r0.f2227k
            r8 = 0
            if (r7 != 0) goto L_0x0037
            boolean r1 = super.onTouchEvent(r18)
            r6 = r6 | r1
            goto L_0x004a
        L_0x0037:
            if (r3 == 0) goto L_0x004a
            long r11 = android.os.SystemClock.uptimeMillis()
            r13 = 3
            r14 = 0
            r15 = 0
            r16 = 0
            r9 = r11
            android.view.MotionEvent r8 = android.view.MotionEvent.obtain(r9, r11, r13, r14, r15, r16)
            super.onTouchEvent(r8)
        L_0x004a:
            if (r8 == 0) goto L_0x004f
            r8.recycle()
        L_0x004f:
            if (r2 == r4) goto L_0x0054
            r1 = 3
            if (r2 != r1) goto L_0x0057
        L_0x0054:
            r0.Q(r5)
        L_0x0057:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* access modifiers changed from: protected */
    /* renamed from: p */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    /* access modifiers changed from: package-private */
    public void q(View view, boolean z2, Rect rect) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z2) {
            t(view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    public List<View> r(View view) {
        List<View> h2 = this.f2219c.h(view);
        this.f2221e.clear();
        if (h2 != null) {
            this.f2221e.addAll(h2);
        }
        return this.f2221e;
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z2) {
        Behavior f2 = ((LayoutParams) view.getLayoutParams()).f();
        if (f2 == null || !f2.v(this, view, rect, z2)) {
            return super.requestChildRectangleOnScreen(view, rect, z2);
        }
        return true;
    }

    public void requestDisallowInterceptTouchEvent(boolean z2) {
        super.requestDisallowInterceptTouchEvent(z2);
        if (z2 && !this.f2224h) {
            Q(false);
            this.f2224h = true;
        }
    }

    public List<View> s(View view) {
        List g2 = this.f2219c.g(view);
        this.f2221e.clear();
        if (g2 != null) {
            this.f2221e.addAll(g2);
        }
        return this.f2221e;
    }

    public void setFitsSystemWindows(boolean z2) {
        super.setFitsSystemWindows(z2);
        X();
    }

    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f2234r = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(Drawable drawable) {
        boolean z2;
        Drawable drawable2 = this.f2233q;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback((Drawable.Callback) null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.f2233q = drawable3;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.f2233q.setState(getDrawableState());
                }
                DrawableCompat.m(this.f2233q, ViewCompat.D(this));
                Drawable drawable4 = this.f2233q;
                if (getVisibility() == 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                drawable4.setVisible(z2, false);
                this.f2233q.setCallback(this);
            }
            ViewCompat.i0(this);
        }
    }

    public void setStatusBarBackgroundColor(int i2) {
        setStatusBarBackground(new ColorDrawable(i2));
    }

    public void setStatusBarBackgroundResource(int i2) {
        setStatusBarBackground(i2 != 0 ? ContextCompat.getDrawable(getContext(), i2) : null);
    }

    public void setVisibility(int i2) {
        boolean z2;
        super.setVisibility(i2);
        if (i2 == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Drawable drawable = this.f2233q;
        if (drawable != null && drawable.isVisible() != z2) {
            this.f2233q.setVisible(z2, false);
        }
    }

    /* access modifiers changed from: package-private */
    public void t(View view, Rect rect) {
        ViewGroupUtils.a(this, view, rect);
    }

    /* access modifiers changed from: package-private */
    public void u(View view, int i2, Rect rect, Rect rect2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        v(view, i2, rect, rect2, layoutParams, measuredWidth, measuredHeight);
        d(layoutParams, rect2, measuredWidth, measuredHeight);
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f2233q;
    }

    /* access modifiers changed from: package-private */
    public void x(View view, Rect rect) {
        rect.set(((LayoutParams) view.getLayoutParams()).h());
    }

    /* access modifiers changed from: package-private */
    public LayoutParams y(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.f2240b) {
            if (view instanceof AttachedBehavior) {
                Behavior behavior = ((AttachedBehavior) view).getBehavior();
                if (behavior == null) {
                    Log.e("CoordinatorLayout", "Attached behavior class is null");
                }
                layoutParams.o(behavior);
                layoutParams.f2240b = true;
            } else {
                DefaultBehavior defaultBehavior = null;
                for (Class cls = view.getClass(); cls != null; cls = cls.getSuperclass()) {
                    defaultBehavior = (DefaultBehavior) cls.getAnnotation(DefaultBehavior.class);
                    if (defaultBehavior != null) {
                        break;
                    }
                }
                if (defaultBehavior != null) {
                    try {
                        layoutParams.o((Behavior) defaultBehavior.value().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                    } catch (Exception e2) {
                        Log.e("CoordinatorLayout", "Default behavior class " + defaultBehavior.value().getName() + " could not be instantiated. Did you forget" + " a default constructor?", e2);
                    }
                }
                layoutParams.f2240b = true;
            }
        }
        return layoutParams;
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        TypedArray typedArray;
        this.f2218b = new ArrayList();
        this.f2219c = new DirectedAcyclicGraph<>();
        this.f2220d = new ArrayList();
        this.f2221e = new ArrayList();
        this.f2222f = new int[2];
        this.f2236t = new NestedScrollingParentHelper(this);
        if (i2 == 0) {
            typedArray = context.obtainStyledAttributes(attributeSet, R$styleable.f2198b, 0, R$style.f2196a);
        } else {
            typedArray = context.obtainStyledAttributes(attributeSet, R$styleable.f2198b, i2, 0);
        }
        int resourceId = typedArray.getResourceId(R$styleable.f2199c, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            this.f2226j = resources.getIntArray(resourceId);
            float f2 = resources.getDisplayMetrics().density;
            int length = this.f2226j.length;
            for (int i3 = 0; i3 < length; i3++) {
                int[] iArr = this.f2226j;
                iArr[i3] = (int) (((float) iArr[i3]) * f2);
            }
        }
        this.f2233q = typedArray.getDrawable(R$styleable.f2200d);
        typedArray.recycle();
        X();
        super.setOnHierarchyChangeListener(new HierarchyChangeListener());
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
        SparseArray<Parcelable> f2258d;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            int readInt = parcel.readInt();
            int[] iArr = new int[readInt];
            parcel.readIntArray(iArr);
            Parcelable[] readParcelableArray = parcel.readParcelableArray(classLoader);
            this.f2258d = new SparseArray<>(readInt);
            for (int i2 = 0; i2 < readInt; i2++) {
                this.f2258d.append(iArr[i2], readParcelableArray[i2]);
            }
        }

        public void writeToParcel(Parcel parcel, int i2) {
            int i3;
            super.writeToParcel(parcel, i2);
            SparseArray<Parcelable> sparseArray = this.f2258d;
            if (sparseArray != null) {
                i3 = sparseArray.size();
            } else {
                i3 = 0;
            }
            parcel.writeInt(i3);
            int[] iArr = new int[i3];
            Parcelable[] parcelableArr = new Parcelable[i3];
            for (int i4 = 0; i4 < i3; i4++) {
                iArr[i4] = this.f2258d.keyAt(i4);
                parcelableArr[i4] = this.f2258d.valueAt(i4);
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i2);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* renamed from: a  reason: collision with root package name */
        Behavior f2239a;

        /* renamed from: b  reason: collision with root package name */
        boolean f2240b = false;

        /* renamed from: c  reason: collision with root package name */
        public int f2241c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f2242d = 0;

        /* renamed from: e  reason: collision with root package name */
        public int f2243e = -1;

        /* renamed from: f  reason: collision with root package name */
        int f2244f = -1;

        /* renamed from: g  reason: collision with root package name */
        public int f2245g = 0;

        /* renamed from: h  reason: collision with root package name */
        public int f2246h = 0;

        /* renamed from: i  reason: collision with root package name */
        int f2247i;

        /* renamed from: j  reason: collision with root package name */
        int f2248j;

        /* renamed from: k  reason: collision with root package name */
        View f2249k;

        /* renamed from: l  reason: collision with root package name */
        View f2250l;

        /* renamed from: m  reason: collision with root package name */
        private boolean f2251m;

        /* renamed from: n  reason: collision with root package name */
        private boolean f2252n;

        /* renamed from: o  reason: collision with root package name */
        private boolean f2253o;

        /* renamed from: p  reason: collision with root package name */
        private boolean f2254p;

        /* renamed from: q  reason: collision with root package name */
        final Rect f2255q = new Rect();

        /* renamed from: r  reason: collision with root package name */
        Object f2256r;

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
        }

        private void n(View view, CoordinatorLayout coordinatorLayout) {
            View findViewById = coordinatorLayout.findViewById(this.f2244f);
            this.f2249k = findViewById;
            if (findViewById != null) {
                if (findViewById != coordinatorLayout) {
                    ViewParent parent = findViewById.getParent();
                    while (parent != coordinatorLayout && parent != null) {
                        if (parent != view) {
                            if (parent instanceof View) {
                                findViewById = (View) parent;
                            }
                            parent = parent.getParent();
                        } else if (coordinatorLayout.isInEditMode()) {
                            this.f2250l = null;
                            this.f2249k = null;
                            return;
                        } else {
                            throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                        }
                    }
                    this.f2250l = findViewById;
                } else if (coordinatorLayout.isInEditMode()) {
                    this.f2250l = null;
                    this.f2249k = null;
                } else {
                    throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
                }
            } else if (coordinatorLayout.isInEditMode()) {
                this.f2250l = null;
                this.f2249k = null;
            } else {
                throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + coordinatorLayout.getResources().getResourceName(this.f2244f) + " to anchor view " + view);
            }
        }

        private boolean s(View view, int i2) {
            int b2 = GravityCompat.b(((LayoutParams) view.getLayoutParams()).f2245g, i2);
            if (b2 == 0 || (GravityCompat.b(this.f2246h, i2) & b2) != b2) {
                return false;
            }
            return true;
        }

        private boolean t(View view, CoordinatorLayout coordinatorLayout) {
            if (this.f2249k.getId() != this.f2244f) {
                return false;
            }
            View view2 = this.f2249k;
            for (ViewParent parent = view2.getParent(); parent != coordinatorLayout; parent = parent.getParent()) {
                if (parent == null || parent == view) {
                    this.f2250l = null;
                    this.f2249k = null;
                    return false;
                }
                if (parent instanceof View) {
                    view2 = (View) parent;
                }
            }
            this.f2250l = view2;
            return true;
        }

        /* access modifiers changed from: package-private */
        public boolean a() {
            return this.f2249k == null && this.f2244f != -1;
        }

        /* access modifiers changed from: package-private */
        public boolean b(CoordinatorLayout coordinatorLayout, View view, View view2) {
            Behavior behavior;
            if (view2 == this.f2250l || s(view2, ViewCompat.D(coordinatorLayout)) || ((behavior = this.f2239a) != null && behavior.e(coordinatorLayout, view, view2))) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean c() {
            if (this.f2239a == null) {
                this.f2251m = false;
            }
            return this.f2251m;
        }

        /* access modifiers changed from: package-private */
        public View d(CoordinatorLayout coordinatorLayout, View view) {
            if (this.f2244f == -1) {
                this.f2250l = null;
                this.f2249k = null;
                return null;
            }
            if (this.f2249k == null || !t(view, coordinatorLayout)) {
                n(view, coordinatorLayout);
            }
            return this.f2249k;
        }

        public int e() {
            return this.f2244f;
        }

        public Behavior f() {
            return this.f2239a;
        }

        /* access modifiers changed from: package-private */
        public boolean g() {
            return this.f2254p;
        }

        /* access modifiers changed from: package-private */
        public Rect h() {
            return this.f2255q;
        }

        /* access modifiers changed from: package-private */
        public boolean i(CoordinatorLayout coordinatorLayout, View view) {
            boolean z2;
            boolean z3 = this.f2251m;
            if (z3) {
                return true;
            }
            Behavior behavior = this.f2239a;
            if (behavior != null) {
                z2 = behavior.a(coordinatorLayout, view);
            } else {
                z2 = false;
            }
            boolean z4 = z2 | z3;
            this.f2251m = z4;
            return z4;
        }

        /* access modifiers changed from: package-private */
        public boolean j(int i2) {
            if (i2 == 0) {
                return this.f2252n;
            }
            if (i2 != 1) {
                return false;
            }
            return this.f2253o;
        }

        /* access modifiers changed from: package-private */
        public void k() {
            this.f2254p = false;
        }

        /* access modifiers changed from: package-private */
        public void l(int i2) {
            r(i2, false);
        }

        /* access modifiers changed from: package-private */
        public void m() {
            this.f2251m = false;
        }

        public void o(Behavior behavior) {
            Behavior behavior2 = this.f2239a;
            if (behavior2 != behavior) {
                if (behavior2 != null) {
                    behavior2.j();
                }
                this.f2239a = behavior;
                this.f2256r = null;
                this.f2240b = true;
                if (behavior != null) {
                    behavior.g(this);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void p(boolean z2) {
            this.f2254p = z2;
        }

        /* access modifiers changed from: package-private */
        public void q(Rect rect) {
            this.f2255q.set(rect);
        }

        /* access modifiers changed from: package-private */
        public void r(int i2, boolean z2) {
            if (i2 == 0) {
                this.f2252n = z2;
            } else if (i2 == 1) {
                this.f2253o = z2;
            }
        }

        LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f2201e);
            this.f2241c = obtainStyledAttributes.getInteger(R$styleable.f2202f, 0);
            this.f2244f = obtainStyledAttributes.getResourceId(R$styleable.f2203g, -1);
            this.f2242d = obtainStyledAttributes.getInteger(R$styleable.f2204h, 0);
            this.f2243e = obtainStyledAttributes.getInteger(R$styleable.f2208l, -1);
            this.f2245g = obtainStyledAttributes.getInt(R$styleable.f2207k, 0);
            this.f2246h = obtainStyledAttributes.getInt(R$styleable.f2206j, 0);
            int i2 = R$styleable.f2205i;
            boolean hasValue = obtainStyledAttributes.hasValue(i2);
            this.f2240b = hasValue;
            if (hasValue) {
                this.f2239a = CoordinatorLayout.K(context, attributeSet, obtainStyledAttributes.getString(i2));
            }
            obtainStyledAttributes.recycle();
            Behavior behavior = this.f2239a;
            if (behavior != null) {
                behavior.g(this);
            }
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }
}
