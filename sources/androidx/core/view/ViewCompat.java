package androidx.core.view;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContentInfo;
import android.view.Display;
import android.view.KeyEvent;
import android.view.OnReceiveContentListener;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.collection.SimpleArrayMap;
import androidx.core.R$id;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@SuppressLint({"PrivateConstructorForUtilityClass"})
public class ViewCompat {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicInteger f2767a = new AtomicInteger(1);

    /* renamed from: b  reason: collision with root package name */
    private static WeakHashMap<View, ViewPropertyAnimatorCompat> f2768b = null;

    /* renamed from: c  reason: collision with root package name */
    private static Field f2769c;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f2770d = false;

    /* renamed from: e  reason: collision with root package name */
    private static ThreadLocal<Rect> f2771e;

    /* renamed from: f  reason: collision with root package name */
    private static final int[] f2772f = {R$id.f2271b, R$id.f2272c, R$id.f2283n, R$id.f2294y, R$id.B, R$id.C, R$id.D, R$id.E, R$id.F, R$id.G, R$id.f2273d, R$id.f2274e, R$id.f2275f, R$id.f2276g, R$id.f2277h, R$id.f2278i, R$id.f2279j, R$id.f2280k, R$id.f2281l, R$id.f2282m, R$id.f2284o, R$id.f2285p, R$id.f2286q, R$id.f2287r, R$id.f2288s, R$id.f2289t, R$id.f2290u, R$id.f2291v, R$id.f2292w, R$id.f2293x, R$id.f2295z, R$id.A};

    /* renamed from: g  reason: collision with root package name */
    private static final OnReceiveContentViewBehavior f2773g = new f0();

    /* renamed from: h  reason: collision with root package name */
    private static final AccessibilityPaneVisibilityManager f2774h = new AccessibilityPaneVisibilityManager();

    static class AccessibilityPaneVisibilityManager implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {

        /* renamed from: b  reason: collision with root package name */
        private final WeakHashMap<View, Boolean> f2775b = new WeakHashMap<>();

        AccessibilityPaneVisibilityManager() {
        }

        private void b(View view, boolean z2) {
            boolean z3;
            int i2;
            if (!view.isShown() || view.getWindowVisibility() != 0) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (z2 != z3) {
                if (z3) {
                    i2 = 16;
                } else {
                    i2 = 32;
                }
                ViewCompat.a0(view, i2);
                this.f2775b.put(view, Boolean.valueOf(z3));
            }
        }

        private void c(View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        private void e(View view) {
            Api16Impl.o(view.getViewTreeObserver(), this);
        }

        /* access modifiers changed from: package-private */
        public void a(View view) {
            boolean z2;
            WeakHashMap<View, Boolean> weakHashMap = this.f2775b;
            if (!view.isShown() || view.getWindowVisibility() != 0) {
                z2 = false;
            } else {
                z2 = true;
            }
            weakHashMap.put(view, Boolean.valueOf(z2));
            view.addOnAttachStateChangeListener(this);
            if (Api19Impl.b(view)) {
                c(view);
            }
        }

        /* access modifiers changed from: package-private */
        public void d(View view) {
            this.f2775b.remove(view);
            view.removeOnAttachStateChangeListener(this);
            e(view);
        }

        public void onGlobalLayout() {
            if (Build.VERSION.SDK_INT < 28) {
                for (Map.Entry next : this.f2775b.entrySet()) {
                    b((View) next.getKey(), ((Boolean) next.getValue()).booleanValue());
                }
            }
        }

        public void onViewAttachedToWindow(View view) {
            c(view);
        }

        public void onViewDetachedFromWindow(View view) {
        }
    }

    static abstract class AccessibilityViewProperty<T> {

        /* renamed from: a  reason: collision with root package name */
        private final int f2776a;

        /* renamed from: b  reason: collision with root package name */
        private final Class<T> f2777b;

        /* renamed from: c  reason: collision with root package name */
        private final int f2778c;

        /* renamed from: d  reason: collision with root package name */
        private final int f2779d;

        AccessibilityViewProperty(int i2, Class<T> cls, int i3) {
            this(i2, cls, 0, i3);
        }

        private boolean b() {
            return true;
        }

        private boolean c() {
            return Build.VERSION.SDK_INT >= this.f2778c;
        }

        /* access modifiers changed from: package-private */
        public boolean a(Boolean bool, Boolean bool2) {
            boolean z2;
            boolean z3;
            if (bool == null || !bool.booleanValue()) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (bool2 == null || !bool2.booleanValue()) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (z2 == z3) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public abstract T d(View view);

        /* access modifiers changed from: package-private */
        public abstract void e(View view, T t2);

        /* access modifiers changed from: package-private */
        public T f(View view) {
            if (c()) {
                return d(view);
            }
            if (!b()) {
                return null;
            }
            T tag = view.getTag(this.f2776a);
            if (this.f2777b.isInstance(tag)) {
                return tag;
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public void g(View view, T t2) {
            if (c()) {
                e(view, t2);
            } else if (b() && h(f(view), t2)) {
                ViewCompat.l(view);
                view.setTag(this.f2776a, t2);
                ViewCompat.a0(view, this.f2779d);
            }
        }

        /* access modifiers changed from: package-private */
        public abstract boolean h(T t2, T t3);

        AccessibilityViewProperty(int i2, Class<T> cls, int i3, int i4) {
            this.f2776a = i2;
            this.f2777b = cls;
            this.f2779d = i3;
            this.f2778c = i4;
        }
    }

    static class Api15Impl {
        private Api15Impl() {
        }

        static boolean a(View view) {
            return view.hasOnClickListeners();
        }
    }

    static class Api16Impl {
        private Api16Impl() {
        }

        static AccessibilityNodeProvider a(View view) {
            return view.getAccessibilityNodeProvider();
        }

        static boolean b(View view) {
            return view.getFitsSystemWindows();
        }

        static int c(View view) {
            return view.getImportantForAccessibility();
        }

        static int d(View view) {
            return view.getMinimumHeight();
        }

        static int e(View view) {
            return view.getMinimumWidth();
        }

        static ViewParent f(View view) {
            return view.getParentForAccessibility();
        }

        static int g(View view) {
            return view.getWindowSystemUiVisibility();
        }

        static boolean h(View view) {
            return view.hasOverlappingRendering();
        }

        static boolean i(View view) {
            return view.hasTransientState();
        }

        static boolean j(View view, int i2, Bundle bundle) {
            return view.performAccessibilityAction(i2, bundle);
        }

        static void k(View view) {
            view.postInvalidateOnAnimation();
        }

        static void l(View view, int i2, int i3, int i4, int i5) {
            view.postInvalidateOnAnimation(i2, i3, i4, i5);
        }

        static void m(View view, Runnable runnable) {
            view.postOnAnimation(runnable);
        }

        static void n(View view, Runnable runnable, long j2) {
            view.postOnAnimationDelayed(runnable, j2);
        }

        static void o(ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
            viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
        }

        static void p(View view) {
            view.requestFitSystemWindows();
        }

        static void q(View view, Drawable drawable) {
            view.setBackground(drawable);
        }

        static void r(View view, boolean z2) {
            view.setHasTransientState(z2);
        }

        static void s(View view, int i2) {
            view.setImportantForAccessibility(i2);
        }
    }

    static class Api17Impl {
        private Api17Impl() {
        }

        static int a() {
            return View.generateViewId();
        }

        static Display b(View view) {
            return view.getDisplay();
        }

        static int c(View view) {
            return view.getLabelFor();
        }

        static int d(View view) {
            return view.getLayoutDirection();
        }

        static int e(View view) {
            return view.getPaddingEnd();
        }

        static int f(View view) {
            return view.getPaddingStart();
        }

        static boolean g(View view) {
            return view.isPaddingRelative();
        }

        static void h(View view, int i2) {
            view.setLabelFor(i2);
        }

        static void i(View view, Paint paint) {
            view.setLayerPaint(paint);
        }

        static void j(View view, int i2) {
            view.setLayoutDirection(i2);
        }

        static void k(View view, int i2, int i3, int i4, int i5) {
            view.setPaddingRelative(i2, i3, i4, i5);
        }
    }

    static class Api18Impl {
        private Api18Impl() {
        }

        static Rect a(View view) {
            return view.getClipBounds();
        }

        static boolean b(View view) {
            return view.isInLayout();
        }

        static void c(View view, Rect rect) {
            view.setClipBounds(rect);
        }
    }

    static class Api19Impl {
        private Api19Impl() {
        }

        static int a(View view) {
            return view.getAccessibilityLiveRegion();
        }

        static boolean b(View view) {
            return view.isAttachedToWindow();
        }

        static boolean c(View view) {
            return view.isLaidOut();
        }

        static boolean d(View view) {
            return view.isLayoutDirectionResolved();
        }

        static void e(ViewParent viewParent, View view, View view2, int i2) {
            viewParent.notifySubtreeAccessibilityStateChanged(view, view2, i2);
        }

        static void f(View view, int i2) {
            view.setAccessibilityLiveRegion(i2);
        }

        static void g(AccessibilityEvent accessibilityEvent, int i2) {
            accessibilityEvent.setContentChangeTypes(i2);
        }
    }

    static class Api20Impl {
        private Api20Impl() {
        }

        static WindowInsets a(View view, WindowInsets windowInsets) {
            return view.dispatchApplyWindowInsets(windowInsets);
        }

        static WindowInsets b(View view, WindowInsets windowInsets) {
            return view.onApplyWindowInsets(windowInsets);
        }

        static void c(View view) {
            view.requestApplyInsets();
        }
    }

    private static class Api21Impl {
        private Api21Impl() {
        }

        static void a(WindowInsets windowInsets, View view) {
            View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view.getTag(R$id.S);
            if (onApplyWindowInsetsListener != null) {
                onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
            }
        }

        static WindowInsetsCompat b(View view, WindowInsetsCompat windowInsetsCompat, Rect rect) {
            WindowInsets u2 = windowInsetsCompat.u();
            if (u2 != null) {
                return WindowInsetsCompat.w(view.computeSystemWindowInsets(u2, rect), view);
            }
            rect.setEmpty();
            return windowInsetsCompat;
        }

        static boolean c(View view, float f2, float f3, boolean z2) {
            return view.dispatchNestedFling(f2, f3, z2);
        }

        static boolean d(View view, float f2, float f3) {
            return view.dispatchNestedPreFling(f2, f3);
        }

        static boolean e(View view, int i2, int i3, int[] iArr, int[] iArr2) {
            return view.dispatchNestedPreScroll(i2, i3, iArr, iArr2);
        }

        static boolean f(View view, int i2, int i3, int i4, int i5, int[] iArr) {
            return view.dispatchNestedScroll(i2, i3, i4, i5, iArr);
        }

        static ColorStateList g(View view) {
            return view.getBackgroundTintList();
        }

        static PorterDuff.Mode h(View view) {
            return view.getBackgroundTintMode();
        }

        static float i(View view) {
            return view.getElevation();
        }

        public static WindowInsetsCompat j(View view) {
            return WindowInsetsCompat.Api21ReflectionHolder.a(view);
        }

        static String k(View view) {
            return view.getTransitionName();
        }

        static float l(View view) {
            return view.getTranslationZ();
        }

        static float m(View view) {
            return view.getZ();
        }

        static boolean n(View view) {
            return view.hasNestedScrollingParent();
        }

        static boolean o(View view) {
            return view.isImportantForAccessibility();
        }

        static boolean p(View view) {
            return view.isNestedScrollingEnabled();
        }

        static void q(View view, ColorStateList colorStateList) {
            view.setBackgroundTintList(colorStateList);
        }

        static void r(View view, PorterDuff.Mode mode) {
            view.setBackgroundTintMode(mode);
        }

        static void s(View view, float f2) {
            view.setElevation(f2);
        }

        static void t(View view, boolean z2) {
            view.setNestedScrollingEnabled(z2);
        }

        static void u(final View view, final OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
            if (Build.VERSION.SDK_INT < 30) {
                view.setTag(R$id.L, onApplyWindowInsetsListener);
            }
            if (onApplyWindowInsetsListener == null) {
                view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(R$id.S));
            } else {
                view.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {

                    /* renamed from: a  reason: collision with root package name */
                    WindowInsetsCompat f2780a = null;

                    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                        WindowInsetsCompat w2 = WindowInsetsCompat.w(windowInsets, view);
                        int i2 = Build.VERSION.SDK_INT;
                        if (i2 < 30) {
                            Api21Impl.a(windowInsets, view);
                            if (w2.equals(this.f2780a)) {
                                return onApplyWindowInsetsListener.a(view, w2).u();
                            }
                        }
                        this.f2780a = w2;
                        WindowInsetsCompat a2 = onApplyWindowInsetsListener.a(view, w2);
                        if (i2 >= 30) {
                            return a2.u();
                        }
                        ViewCompat.o0(view);
                        return a2.u();
                    }
                });
            }
        }

        static void v(View view, String str) {
            view.setTransitionName(str);
        }

        static void w(View view, float f2) {
            view.setTranslationZ(f2);
        }

        static void x(View view, float f2) {
            view.setZ(f2);
        }

        static boolean y(View view, int i2) {
            return view.startNestedScroll(i2);
        }

        static void z(View view) {
            view.stopNestedScroll();
        }
    }

    private static class Api23Impl {
        private Api23Impl() {
        }

        public static WindowInsetsCompat a(View view) {
            WindowInsets a2 = view.getRootWindowInsets();
            if (a2 == null) {
                return null;
            }
            WindowInsetsCompat v2 = WindowInsetsCompat.v(a2);
            v2.s(v2);
            v2.d(view.getRootView());
            return v2;
        }

        static int b(View view) {
            return view.getScrollIndicators();
        }

        static void c(View view, int i2) {
            view.setScrollIndicators(i2);
        }

        static void d(View view, int i2, int i3) {
            view.setScrollIndicators(i2, i3);
        }
    }

    static class Api24Impl {
        private Api24Impl() {
        }

        static void a(View view) {
            view.cancelDragAndDrop();
        }

        static void b(View view) {
            view.dispatchFinishTemporaryDetach();
        }

        static void c(View view) {
            view.dispatchStartTemporaryDetach();
        }

        static void d(View view, PointerIcon pointerIcon) {
            view.setPointerIcon(pointerIcon);
        }

        static boolean e(View view, ClipData clipData, View.DragShadowBuilder dragShadowBuilder, Object obj, int i2) {
            return view.startDragAndDrop(clipData, dragShadowBuilder, obj, i2);
        }

        static void f(View view, View.DragShadowBuilder dragShadowBuilder) {
            view.updateDragShadow(dragShadowBuilder);
        }
    }

    static class Api26Impl {
        private Api26Impl() {
        }

        static void a(View view, Collection<View> collection, int i2) {
            view.addKeyboardNavigationClusters(collection, i2);
        }

        static int b(View view) {
            return view.getImportantForAutofill();
        }

        static int c(View view) {
            return view.getNextClusterForwardId();
        }

        static boolean d(View view) {
            return view.hasExplicitFocusable();
        }

        static boolean e(View view) {
            return view.isFocusedByDefault();
        }

        static boolean f(View view) {
            return view.isImportantForAutofill();
        }

        static boolean g(View view) {
            return view.isKeyboardNavigationCluster();
        }

        static View h(View view, View view2, int i2) {
            return view.keyboardNavigationClusterSearch(view2, i2);
        }

        static boolean i(View view) {
            return view.restoreDefaultFocus();
        }

        static void j(View view, String... strArr) {
            view.setAutofillHints(strArr);
        }

        static void k(View view, boolean z2) {
            view.setFocusedByDefault(z2);
        }

        static void l(View view, int i2) {
            view.setImportantForAutofill(i2);
        }

        static void m(View view, boolean z2) {
            view.setKeyboardNavigationCluster(z2);
        }

        static void n(View view, int i2) {
            view.setNextClusterForwardId(i2);
        }

        static void o(View view, CharSequence charSequence) {
            view.setTooltipText(charSequence);
        }
    }

    static class Api28Impl {
        private Api28Impl() {
        }

        static void a(View view, OnUnhandledKeyEventListenerCompat onUnhandledKeyEventListenerCompat) {
            int i2 = R$id.R;
            SimpleArrayMap simpleArrayMap = (SimpleArrayMap) view.getTag(i2);
            if (simpleArrayMap == null) {
                simpleArrayMap = new SimpleArrayMap();
                view.setTag(i2, simpleArrayMap);
            }
            Objects.requireNonNull(onUnhandledKeyEventListenerCompat);
            n1 n1Var = new n1(onUnhandledKeyEventListenerCompat);
            simpleArrayMap.put(onUnhandledKeyEventListenerCompat, n1Var);
            view.addOnUnhandledKeyEventListener(n1Var);
        }

        static CharSequence b(View view) {
            return view.getAccessibilityPaneTitle();
        }

        static boolean c(View view) {
            return view.isAccessibilityHeading();
        }

        static boolean d(View view) {
            return view.isScreenReaderFocusable();
        }

        static void e(View view, OnUnhandledKeyEventListenerCompat onUnhandledKeyEventListenerCompat) {
            View.OnUnhandledKeyEventListener onUnhandledKeyEventListener;
            SimpleArrayMap simpleArrayMap = (SimpleArrayMap) view.getTag(R$id.R);
            if (simpleArrayMap != null && (onUnhandledKeyEventListener = (View.OnUnhandledKeyEventListener) simpleArrayMap.get(onUnhandledKeyEventListenerCompat)) != null) {
                view.removeOnUnhandledKeyEventListener(onUnhandledKeyEventListener);
            }
        }

        static <T> T f(View view, int i2) {
            return view.requireViewById(i2);
        }

        static void g(View view, boolean z2) {
            view.setAccessibilityHeading(z2);
        }

        static void h(View view, CharSequence charSequence) {
            view.setAccessibilityPaneTitle(charSequence);
        }

        static void i(View view, boolean z2) {
            view.setScreenReaderFocusable(z2);
        }
    }

    private static class Api29Impl {
        private Api29Impl() {
        }

        static View.AccessibilityDelegate a(View view) {
            return view.getAccessibilityDelegate();
        }

        static List<Rect> b(View view) {
            return view.getSystemGestureExclusionRects();
        }

        static void c(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i2, int i3) {
            view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i2, i3);
        }

        static void d(View view, List<Rect> list) {
            view.setSystemGestureExclusionRects(list);
        }
    }

    private static class Api30Impl {
        private Api30Impl() {
        }

        static CharSequence a(View view) {
            return view.getStateDescription();
        }

        static void b(View view, CharSequence charSequence) {
            view.setStateDescription(charSequence);
        }
    }

    private static final class Api31Impl {
        private Api31Impl() {
        }

        public static String[] a(View view) {
            return view.getReceiveContentMimeTypes();
        }

        public static ContentInfoCompat b(View view, ContentInfoCompat contentInfoCompat) {
            ContentInfo f2 = contentInfoCompat.f();
            ContentInfo a2 = view.performReceiveContent(f2);
            if (a2 == null) {
                return null;
            }
            if (a2 == f2) {
                return contentInfoCompat;
            }
            return ContentInfoCompat.g(a2);
        }

        public static void c(View view, String[] strArr, OnReceiveContentListener onReceiveContentListener) {
            if (onReceiveContentListener == null) {
                view.setOnReceiveContentListener(strArr, (OnReceiveContentListener) null);
            } else {
                view.setOnReceiveContentListener(strArr, new OnReceiveContentListenerAdapter(onReceiveContentListener));
            }
        }
    }

    private static final class OnReceiveContentListenerAdapter implements OnReceiveContentListener {

        /* renamed from: a  reason: collision with root package name */
        private final OnReceiveContentListener f2783a;

        OnReceiveContentListenerAdapter(OnReceiveContentListener onReceiveContentListener) {
            this.f2783a = onReceiveContentListener;
        }

        public ContentInfo onReceiveContent(View view, ContentInfo contentInfo) {
            ContentInfoCompat g2 = ContentInfoCompat.g(contentInfo);
            ContentInfoCompat a2 = this.f2783a.a(view, g2);
            if (a2 == null) {
                return null;
            }
            if (a2 == g2) {
                return contentInfo;
            }
            return a2.f();
        }
    }

    public interface OnUnhandledKeyEventListenerCompat {
        boolean onUnhandledKeyEvent(View view, KeyEvent keyEvent);
    }

    static class UnhandledKeyEventManager {

        /* renamed from: d  reason: collision with root package name */
        private static final ArrayList<WeakReference<View>> f2784d = new ArrayList<>();

        /* renamed from: a  reason: collision with root package name */
        private WeakHashMap<View, Boolean> f2785a = null;

        /* renamed from: b  reason: collision with root package name */
        private SparseArray<WeakReference<View>> f2786b = null;

        /* renamed from: c  reason: collision with root package name */
        private WeakReference<KeyEvent> f2787c = null;

        UnhandledKeyEventManager() {
        }

        static UnhandledKeyEventManager a(View view) {
            int i2 = R$id.Q;
            UnhandledKeyEventManager unhandledKeyEventManager = (UnhandledKeyEventManager) view.getTag(i2);
            if (unhandledKeyEventManager != null) {
                return unhandledKeyEventManager;
            }
            UnhandledKeyEventManager unhandledKeyEventManager2 = new UnhandledKeyEventManager();
            view.setTag(i2, unhandledKeyEventManager2);
            return unhandledKeyEventManager2;
        }

        private View c(View view, KeyEvent keyEvent) {
            WeakHashMap<View, Boolean> weakHashMap = this.f2785a;
            if (weakHashMap != null && weakHashMap.containsKey(view)) {
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                        View c2 = c(viewGroup.getChildAt(childCount), keyEvent);
                        if (c2 != null) {
                            return c2;
                        }
                    }
                }
                if (e(view, keyEvent)) {
                    return view;
                }
            }
            return null;
        }

        private SparseArray<WeakReference<View>> d() {
            if (this.f2786b == null) {
                this.f2786b = new SparseArray<>();
            }
            return this.f2786b;
        }

        private boolean e(View view, KeyEvent keyEvent) {
            ArrayList arrayList = (ArrayList) view.getTag(R$id.R);
            if (arrayList == null) {
                return false;
            }
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (((OnUnhandledKeyEventListenerCompat) arrayList.get(size)).onUnhandledKeyEvent(view, keyEvent)) {
                    return true;
                }
            }
            return false;
        }

        private void g() {
            WeakHashMap<View, Boolean> weakHashMap = this.f2785a;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            ArrayList<WeakReference<View>> arrayList = f2784d;
            if (!arrayList.isEmpty()) {
                synchronized (arrayList) {
                    if (this.f2785a == null) {
                        this.f2785a = new WeakHashMap<>();
                    }
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        ArrayList<WeakReference<View>> arrayList2 = f2784d;
                        View view = (View) arrayList2.get(size).get();
                        if (view == null) {
                            arrayList2.remove(size);
                        } else {
                            this.f2785a.put(view, Boolean.TRUE);
                            for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                                this.f2785a.put((View) parent, Boolean.TRUE);
                            }
                        }
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public boolean b(View view, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0) {
                g();
            }
            View c2 = c(view, keyEvent);
            if (keyEvent.getAction() == 0) {
                int keyCode = keyEvent.getKeyCode();
                if (c2 != null && !KeyEvent.isModifierKey(keyCode)) {
                    d().put(keyCode, new WeakReference(c2));
                }
            }
            if (c2 != null) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean f(KeyEvent keyEvent) {
            WeakReference weakReference;
            int indexOfKey;
            WeakReference<KeyEvent> weakReference2 = this.f2787c;
            if (weakReference2 != null && weakReference2.get() == keyEvent) {
                return false;
            }
            this.f2787c = new WeakReference<>(keyEvent);
            SparseArray<WeakReference<View>> d2 = d();
            if (keyEvent.getAction() != 1 || (indexOfKey = d2.indexOfKey(keyEvent.getKeyCode())) < 0) {
                weakReference = null;
            } else {
                weakReference = d2.valueAt(indexOfKey);
                d2.removeAt(indexOfKey);
            }
            if (weakReference == null) {
                weakReference = d2.get(keyEvent.getKeyCode());
            }
            if (weakReference == null) {
                return false;
            }
            View view = (View) weakReference.get();
            if (view != null && ViewCompat.U(view)) {
                e(view, keyEvent);
            }
            return true;
        }
    }

    @Deprecated
    protected ViewCompat() {
    }

    public static boolean A(View view) {
        return Api16Impl.b(view);
    }

    @Deprecated
    public static void A0(View view, boolean z2) {
        view.setFitsSystemWindows(z2);
    }

    public static int B(View view) {
        return Api16Impl.c(view);
    }

    public static void B0(View view, boolean z2) {
        Api16Impl.r(view, z2);
    }

    @SuppressLint({"InlinedApi"})
    public static int C(View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.b(view);
        }
        return 0;
    }

    public static void C0(View view, int i2) {
        Api16Impl.s(view, i2);
    }

    public static int D(View view) {
        return Api17Impl.d(view);
    }

    public static void D0(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.l(view, i2);
        }
    }

    public static int E(View view) {
        return Api16Impl.d(view);
    }

    public static void E0(View view, Paint paint) {
        Api17Impl.i(view, paint);
    }

    public static int F(View view) {
        return Api16Impl.e(view);
    }

    public static void F0(View view, boolean z2) {
        Api21Impl.t(view, z2);
    }

    public static String[] G(View view) {
        if (Build.VERSION.SDK_INT >= 31) {
            return Api31Impl.a(view);
        }
        return (String[]) view.getTag(R$id.N);
    }

    public static void G0(View view, OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        Api21Impl.u(view, onApplyWindowInsetsListener);
    }

    public static int H(View view) {
        return Api17Impl.e(view);
    }

    public static void H0(View view, int i2, int i3, int i4, int i5) {
        Api17Impl.k(view, i2, i3, i4, i5);
    }

    public static int I(View view) {
        return Api17Impl.f(view);
    }

    public static void I0(View view, PointerIconCompat pointerIconCompat) {
        Object obj;
        if (Build.VERSION.SDK_INT >= 24) {
            if (pointerIconCompat != null) {
                obj = pointerIconCompat.a();
            } else {
                obj = null;
            }
            Api24Impl.d(view, (PointerIcon) obj);
        }
    }

    public static ViewParent J(View view) {
        return Api16Impl.f(view);
    }

    public static void J0(View view, boolean z2) {
        q0().g(view, Boolean.valueOf(z2));
    }

    public static WindowInsetsCompat K(View view) {
        if (Build.VERSION.SDK_INT >= 23) {
            return Api23Impl.a(view);
        }
        return Api21Impl.j(view);
    }

    public static void K0(View view, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 23) {
            Api23Impl.d(view, i2, i3);
        }
    }

    public static CharSequence L(View view) {
        return O0().f(view);
    }

    public static void L0(View view, CharSequence charSequence) {
        O0().g(view, charSequence);
    }

    public static String M(View view) {
        return Api21Impl.k(view);
    }

    public static void M0(View view, String str) {
        Api21Impl.v(view, str);
    }

    @Deprecated
    public static int N(View view) {
        return Api16Impl.g(view);
    }

    private static void N0(View view) {
        if (B(view) == 0) {
            C0(view, 1);
        }
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            if (B((View) parent) == 4) {
                C0(view, 2);
                return;
            }
        }
    }

    public static float O(View view) {
        return Api21Impl.m(view);
    }

    private static AccessibilityViewProperty<CharSequence> O0() {
        return new AccessibilityViewProperty<CharSequence>(R$id.P, CharSequence.class, 64, 30) {
            /* access modifiers changed from: package-private */
            /* renamed from: i */
            public CharSequence d(View view) {
                return Api30Impl.a(view);
            }

            /* access modifiers changed from: package-private */
            /* renamed from: j */
            public void e(View view, CharSequence charSequence) {
                Api30Impl.b(view, charSequence);
            }

            /* access modifiers changed from: package-private */
            /* renamed from: k */
            public boolean h(CharSequence charSequence, CharSequence charSequence2) {
                return !TextUtils.equals(charSequence, charSequence2);
            }
        };
    }

    public static boolean P(View view) {
        return o(view) != null;
    }

    public static void P0(View view) {
        Api21Impl.z(view);
    }

    public static boolean Q(View view) {
        return Api15Impl.a(view);
    }

    public static void Q0(View view, int i2) {
        if (view instanceof NestedScrollingChild2) {
            ((NestedScrollingChild2) view).stopNestedScroll(i2);
        } else if (i2 == 0) {
            P0(view);
        }
    }

    public static boolean R(View view) {
        return Api16Impl.h(view);
    }

    private static void R0(View view) {
        float translationY = view.getTranslationY();
        view.setTranslationY(1.0f + translationY);
        view.setTranslationY(translationY);
    }

    public static boolean S(View view) {
        return Api16Impl.i(view);
    }

    public static boolean T(View view) {
        Boolean f2 = b().f(view);
        if (f2 == null || !f2.booleanValue()) {
            return false;
        }
        return true;
    }

    public static boolean U(View view) {
        return Api19Impl.b(view);
    }

    public static boolean V(View view) {
        return Api19Impl.c(view);
    }

    public static boolean W(View view) {
        return Api21Impl.p(view);
    }

    public static boolean X(View view) {
        return Api17Impl.g(view);
    }

    public static boolean Y(View view) {
        Boolean f2 = q0().f(view);
        if (f2 == null || !f2.booleanValue()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ ContentInfoCompat Z(ContentInfoCompat contentInfoCompat) {
        return contentInfoCompat;
    }

    static void a0(View view, int i2) {
        boolean z2;
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            if (r(view) == null || !view.isShown() || view.getWindowVisibility() != 0) {
                z2 = false;
            } else {
                z2 = true;
            }
            int i3 = 32;
            if (q(view) != 0 || z2) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain();
                if (!z2) {
                    i3 = 2048;
                }
                obtain.setEventType(i3);
                Api19Impl.g(obtain, i2);
                if (z2) {
                    obtain.getText().add(r(view));
                    N0(view);
                }
                view.sendAccessibilityEventUnchecked(obtain);
            } else if (i2 == 32) {
                AccessibilityEvent obtain2 = AccessibilityEvent.obtain();
                view.onInitializeAccessibilityEvent(obtain2);
                obtain2.setEventType(32);
                Api19Impl.g(obtain2, i2);
                obtain2.setSource(view);
                view.onPopulateAccessibilityEvent(obtain2);
                obtain2.getText().add(r(view));
                accessibilityManager.sendAccessibilityEvent(obtain2);
            } else if (view.getParent() != null) {
                try {
                    Api19Impl.e(view.getParent(), view, view, i2);
                } catch (AbstractMethodError e2) {
                    Log.e("ViewCompat", view.getParent().getClass().getSimpleName() + " does not fully implement ViewParent", e2);
                }
            }
        }
    }

    private static AccessibilityViewProperty<Boolean> b() {
        return new AccessibilityViewProperty<Boolean>(R$id.J, Boolean.class, 28) {
            /* access modifiers changed from: package-private */
            /* renamed from: i */
            public Boolean d(View view) {
                return Boolean.valueOf(Api28Impl.c(view));
            }

            /* access modifiers changed from: package-private */
            /* renamed from: j */
            public void e(View view, Boolean bool) {
                Api28Impl.g(view, bool.booleanValue());
            }

            /* access modifiers changed from: package-private */
            /* renamed from: k */
            public boolean h(Boolean bool, Boolean bool2) {
                return !a(bool, bool2);
            }
        };
    }

    public static void b0(View view, int i2) {
        boolean z2;
        if (Build.VERSION.SDK_INT >= 23) {
            view.offsetLeftAndRight(i2);
            return;
        }
        Rect y2 = y();
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            y2.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            z2 = !y2.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        } else {
            z2 = false;
        }
        f(view, i2);
        if (z2 && y2.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View) parent).invalidate(y2);
        }
    }

    private static void c(View view, AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat) {
        l(view);
        m0(accessibilityActionCompat.b(), view);
        s(view).add(accessibilityActionCompat);
        a0(view, 0);
    }

    public static void c0(View view, int i2) {
        boolean z2;
        if (Build.VERSION.SDK_INT >= 23) {
            view.offsetTopAndBottom(i2);
            return;
        }
        Rect y2 = y();
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            y2.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            z2 = !y2.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        } else {
            z2 = false;
        }
        g(view, i2);
        if (z2 && y2.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View) parent).invalidate(y2);
        }
    }

    public static ViewPropertyAnimatorCompat d(View view) {
        if (f2768b == null) {
            f2768b = new WeakHashMap<>();
        }
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = f2768b.get(view);
        if (viewPropertyAnimatorCompat != null) {
            return viewPropertyAnimatorCompat;
        }
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = new ViewPropertyAnimatorCompat(view);
        f2768b.put(view, viewPropertyAnimatorCompat2);
        return viewPropertyAnimatorCompat2;
    }

    public static WindowInsetsCompat d0(View view, WindowInsetsCompat windowInsetsCompat) {
        WindowInsets u2 = windowInsetsCompat.u();
        if (u2 != null) {
            WindowInsets b2 = Api20Impl.b(view, u2);
            if (!b2.equals(u2)) {
                return WindowInsetsCompat.w(b2, view);
            }
        }
        return windowInsetsCompat;
    }

    @Deprecated
    public static boolean e(View view, int i2) {
        return view.canScrollVertically(i2);
    }

    public static void e0(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        view.onInitializeAccessibilityNodeInfo(accessibilityNodeInfoCompat.I0());
    }

    private static void f(View view, int i2) {
        view.offsetLeftAndRight(i2);
        if (view.getVisibility() == 0) {
            R0(view);
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                R0((View) parent);
            }
        }
    }

    private static AccessibilityViewProperty<CharSequence> f0() {
        return new AccessibilityViewProperty<CharSequence>(R$id.K, CharSequence.class, 8, 28) {
            /* access modifiers changed from: package-private */
            /* renamed from: i */
            public CharSequence d(View view) {
                return Api28Impl.b(view);
            }

            /* access modifiers changed from: package-private */
            /* renamed from: j */
            public void e(View view, CharSequence charSequence) {
                Api28Impl.h(view, charSequence);
            }

            /* access modifiers changed from: package-private */
            /* renamed from: k */
            public boolean h(CharSequence charSequence, CharSequence charSequence2) {
                return !TextUtils.equals(charSequence, charSequence2);
            }
        };
    }

    private static void g(View view, int i2) {
        view.offsetTopAndBottom(i2);
        if (view.getVisibility() == 0) {
            R0(view);
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                R0((View) parent);
            }
        }
    }

    public static boolean g0(View view, int i2, Bundle bundle) {
        return Api16Impl.j(view, i2, bundle);
    }

    public static WindowInsetsCompat h(View view, WindowInsetsCompat windowInsetsCompat, Rect rect) {
        return Api21Impl.b(view, windowInsetsCompat, rect);
    }

    public static ContentInfoCompat h0(View view, ContentInfoCompat contentInfoCompat) {
        if (Log.isLoggable("ViewCompat", 3)) {
            Log.d("ViewCompat", "performReceiveContent: " + contentInfoCompat + ", view=" + view.getClass().getSimpleName() + "[" + view.getId() + "]");
        }
        if (Build.VERSION.SDK_INT >= 31) {
            return Api31Impl.b(view, contentInfoCompat);
        }
        OnReceiveContentListener onReceiveContentListener = (OnReceiveContentListener) view.getTag(R$id.M);
        if (onReceiveContentListener == null) {
            return z(view).onReceiveContent(contentInfoCompat);
        }
        ContentInfoCompat a2 = onReceiveContentListener.a(view, contentInfoCompat);
        if (a2 == null) {
            return null;
        }
        return z(view).onReceiveContent(a2);
    }

    public static WindowInsetsCompat i(View view, WindowInsetsCompat windowInsetsCompat) {
        WindowInsets u2 = windowInsetsCompat.u();
        if (u2 != null) {
            WindowInsets a2 = Api20Impl.a(view, u2);
            if (!a2.equals(u2)) {
                return WindowInsetsCompat.w(a2, view);
            }
        }
        return windowInsetsCompat;
    }

    public static void i0(View view) {
        Api16Impl.k(view);
    }

    static boolean j(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return UnhandledKeyEventManager.a(view).b(view, keyEvent);
    }

    public static void j0(View view, Runnable runnable) {
        Api16Impl.m(view, runnable);
    }

    static boolean k(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return UnhandledKeyEventManager.a(view).f(keyEvent);
    }

    @SuppressLint({"LambdaLast"})
    public static void k0(View view, Runnable runnable, long j2) {
        Api16Impl.n(view, runnable, j2);
    }

    static void l(View view) {
        AccessibilityDelegateCompat n2 = n(view);
        if (n2 == null) {
            n2 = new AccessibilityDelegateCompat();
        }
        r0(view, n2);
    }

    public static void l0(View view, int i2) {
        m0(i2, view);
        a0(view, 0);
    }

    public static int m() {
        return Api17Impl.a();
    }

    private static void m0(int i2, View view) {
        List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> s2 = s(view);
        for (int i3 = 0; i3 < s2.size(); i3++) {
            if (s2.get(i3).b() == i2) {
                s2.remove(i3);
                return;
            }
        }
    }

    public static AccessibilityDelegateCompat n(View view) {
        View.AccessibilityDelegate o2 = o(view);
        if (o2 == null) {
            return null;
        }
        if (o2 instanceof AccessibilityDelegateCompat.AccessibilityDelegateAdapter) {
            return ((AccessibilityDelegateCompat.AccessibilityDelegateAdapter) o2).f2728a;
        }
        return new AccessibilityDelegateCompat(o2);
    }

    public static void n0(View view, AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat, CharSequence charSequence, AccessibilityViewCommand accessibilityViewCommand) {
        if (accessibilityViewCommand == null && charSequence == null) {
            l0(view, accessibilityActionCompat.b());
        } else {
            c(view, accessibilityActionCompat.a(charSequence, accessibilityViewCommand));
        }
    }

    private static View.AccessibilityDelegate o(View view) {
        if (Build.VERSION.SDK_INT >= 29) {
            return Api29Impl.a(view);
        }
        return p(view);
    }

    public static void o0(View view) {
        Api20Impl.c(view);
    }

    private static View.AccessibilityDelegate p(View view) {
        if (f2770d) {
            return null;
        }
        if (f2769c == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                f2769c = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                f2770d = true;
                return null;
            }
        }
        try {
            Object obj = f2769c.get(view);
            if (obj instanceof View.AccessibilityDelegate) {
                return (View.AccessibilityDelegate) obj;
            }
            return null;
        } catch (Throwable unused2) {
            f2770d = true;
            return null;
        }
    }

    public static void p0(View view, @SuppressLint({"ContextFirst"}) Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 29) {
            Api29Impl.c(view, context, iArr, attributeSet, typedArray, i2, i3);
        }
    }

    public static int q(View view) {
        return Api19Impl.a(view);
    }

    private static AccessibilityViewProperty<Boolean> q0() {
        return new AccessibilityViewProperty<Boolean>(R$id.O, Boolean.class, 28) {
            /* access modifiers changed from: package-private */
            /* renamed from: i */
            public Boolean d(View view) {
                return Boolean.valueOf(Api28Impl.d(view));
            }

            /* access modifiers changed from: package-private */
            /* renamed from: j */
            public void e(View view, Boolean bool) {
                Api28Impl.i(view, bool.booleanValue());
            }

            /* access modifiers changed from: package-private */
            /* renamed from: k */
            public boolean h(Boolean bool, Boolean bool2) {
                return !a(bool, bool2);
            }
        };
    }

    public static CharSequence r(View view) {
        return f0().f(view);
    }

    public static void r0(View view, AccessibilityDelegateCompat accessibilityDelegateCompat) {
        View.AccessibilityDelegate accessibilityDelegate;
        if (accessibilityDelegateCompat == null && (o(view) instanceof AccessibilityDelegateCompat.AccessibilityDelegateAdapter)) {
            accessibilityDelegateCompat = new AccessibilityDelegateCompat();
        }
        if (accessibilityDelegateCompat == null) {
            accessibilityDelegate = null;
        } else {
            accessibilityDelegate = accessibilityDelegateCompat.getBridge();
        }
        view.setAccessibilityDelegate(accessibilityDelegate);
    }

    private static List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> s(View view) {
        int i2 = R$id.H;
        ArrayList arrayList = (ArrayList) view.getTag(i2);
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        view.setTag(i2, arrayList2);
        return arrayList2;
    }

    public static void s0(View view, boolean z2) {
        b().g(view, Boolean.valueOf(z2));
    }

    public static ColorStateList t(View view) {
        return Api21Impl.g(view);
    }

    public static void t0(View view, int i2) {
        Api19Impl.f(view, i2);
    }

    public static PorterDuff.Mode u(View view) {
        return Api21Impl.h(view);
    }

    public static void u0(View view, CharSequence charSequence) {
        f0().g(view, charSequence);
        if (charSequence != null) {
            f2774h.a(view);
        } else {
            f2774h.d(view);
        }
    }

    public static Rect v(View view) {
        return Api18Impl.a(view);
    }

    public static void v0(View view, Drawable drawable) {
        Api16Impl.q(view, drawable);
    }

    public static Display w(View view) {
        return Api17Impl.b(view);
    }

    public static void w0(View view, ColorStateList colorStateList) {
        boolean z2;
        int i2 = Build.VERSION.SDK_INT;
        Api21Impl.q(view, colorStateList);
        if (i2 == 21) {
            Drawable background = view.getBackground();
            if (Api21Impl.g(view) == null && Api21Impl.h(view) == null) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (background != null && z2) {
                if (background.isStateful()) {
                    background.setState(view.getDrawableState());
                }
                Api16Impl.q(view, background);
            }
        }
    }

    public static float x(View view) {
        return Api21Impl.i(view);
    }

    public static void x0(View view, PorterDuff.Mode mode) {
        boolean z2;
        int i2 = Build.VERSION.SDK_INT;
        Api21Impl.r(view, mode);
        if (i2 == 21) {
            Drawable background = view.getBackground();
            if (Api21Impl.g(view) == null && Api21Impl.h(view) == null) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (background != null && z2) {
                if (background.isStateful()) {
                    background.setState(view.getDrawableState());
                }
                Api16Impl.q(view, background);
            }
        }
    }

    private static Rect y() {
        if (f2771e == null) {
            f2771e = new ThreadLocal<>();
        }
        Rect rect = f2771e.get();
        if (rect == null) {
            rect = new Rect();
            f2771e.set(rect);
        }
        rect.setEmpty();
        return rect;
    }

    public static void y0(View view, Rect rect) {
        Api18Impl.c(view, rect);
    }

    private static OnReceiveContentViewBehavior z(View view) {
        if (view instanceof OnReceiveContentViewBehavior) {
            return (OnReceiveContentViewBehavior) view;
        }
        return f2773g;
    }

    public static void z0(View view, float f2) {
        Api21Impl.s(view, f2);
    }
}
