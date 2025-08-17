package androidx.drawerlayout.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import com.facebook.imageutils.JfifUtil;
import java.util.ArrayList;
import java.util.List;

public class DrawerLayout extends ViewGroup {
    private static final boolean ALLOW_EDGE_LOCK = false;
    static final boolean CAN_HIDE_DESCENDANTS = true;
    private static final boolean CHILDREN_DISALLOW_INTERCEPT = true;
    private static final int DEFAULT_SCRIM_COLOR = -1728053248;
    private static final int DRAWER_ELEVATION = 10;
    static final int[] LAYOUT_ATTRS = {16842931};
    public static final int LOCK_MODE_LOCKED_CLOSED = 1;
    public static final int LOCK_MODE_LOCKED_OPEN = 2;
    public static final int LOCK_MODE_UNDEFINED = 3;
    public static final int LOCK_MODE_UNLOCKED = 0;
    private static final int MIN_DRAWER_MARGIN = 64;
    private static final int MIN_FLING_VELOCITY = 400;
    private static final int PEEK_DELAY = 160;
    private static final boolean SET_DRAWER_SHADOW_FROM_ELEVATION = true;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;
    private static final String TAG = "DrawerLayout";
    private static final int[] THEME_ATTRS = {16843828};
    private static final float TOUCH_SLOP_SENSITIVITY = 1.0f;
    private final ChildAccessibilityDelegate mChildAccessibilityDelegate;
    private Rect mChildHitRect;
    private Matrix mChildInvertedMatrix;
    private boolean mChildrenCanceledTouch;
    private boolean mDisallowInterceptRequested;
    private boolean mDrawStatusBarBackground;
    private float mDrawerElevation;
    private int mDrawerState;
    private boolean mFirstLayout;
    private boolean mInLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private Object mLastInsets;
    private final ViewDragCallback mLeftCallback;
    private final ViewDragHelper mLeftDragger;
    private DrawerListener mListener;
    private List<DrawerListener> mListeners;
    private int mLockModeEnd;
    private int mLockModeLeft;
    private int mLockModeRight;
    private int mLockModeStart;
    private int mMinDrawerMargin;
    private final ArrayList<View> mNonDrawerViews;
    private final ViewDragCallback mRightCallback;
    private final ViewDragHelper mRightDragger;
    private int mScrimColor;
    private float mScrimOpacity;
    private Paint mScrimPaint;
    private Drawable mShadowEnd;
    private Drawable mShadowLeft;
    private Drawable mShadowLeftResolved;
    private Drawable mShadowRight;
    private Drawable mShadowRightResolved;
    private Drawable mShadowStart;
    private Drawable mStatusBarBackground;
    private CharSequence mTitleLeft;
    private CharSequence mTitleRight;

    class AccessibilityDelegate extends AccessibilityDelegateCompat {

        /* renamed from: a  reason: collision with root package name */
        private final Rect f3028a = new Rect();

        AccessibilityDelegate() {
        }

        private void a(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, ViewGroup viewGroup) {
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if (DrawerLayout.includeChildForAccessibility(childAt)) {
                    accessibilityNodeInfoCompat.c(childAt);
                }
            }
        }

        private void b(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2) {
            Rect rect = this.f3028a;
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
        }

        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            CharSequence drawerTitle;
            if (accessibilityEvent.getEventType() != 32) {
                return super.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
            }
            List<CharSequence> text = accessibilityEvent.getText();
            View findVisibleDrawer = DrawerLayout.this.findVisibleDrawer();
            if (findVisibleDrawer == null || (drawerTitle = DrawerLayout.this.getDrawerTitle(DrawerLayout.this.getDrawerViewAbsoluteGravity(findVisibleDrawer))) == null) {
                return true;
            }
            text.add(drawerTitle);
            return true;
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(DrawerLayout.class.getName());
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            if (DrawerLayout.CAN_HIDE_DESCENDANTS) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            } else {
                AccessibilityNodeInfoCompat Q = AccessibilityNodeInfoCompat.Q(accessibilityNodeInfoCompat);
                super.onInitializeAccessibilityNodeInfo(view, Q);
                accessibilityNodeInfoCompat.C0(view);
                ViewParent J = ViewCompat.J(view);
                if (J instanceof View) {
                    accessibilityNodeInfoCompat.u0((View) J);
                }
                b(accessibilityNodeInfoCompat, Q);
                Q.S();
                a(accessibilityNodeInfoCompat, (ViewGroup) view);
            }
            accessibilityNodeInfoCompat.c0(DrawerLayout.class.getName());
            accessibilityNodeInfoCompat.l0(false);
            accessibilityNodeInfoCompat.m0(false);
            accessibilityNodeInfoCompat.T(AccessibilityNodeInfoCompat.AccessibilityActionCompat.f2857e);
            accessibilityNodeInfoCompat.T(AccessibilityNodeInfoCompat.AccessibilityActionCompat.f2858f);
        }

        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (DrawerLayout.CAN_HIDE_DESCENDANTS || DrawerLayout.includeChildForAccessibility(view)) {
                return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
            }
            return false;
        }
    }

    static final class ChildAccessibilityDelegate extends AccessibilityDelegateCompat {
        ChildAccessibilityDelegate() {
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            if (!DrawerLayout.includeChildForAccessibility(view)) {
                accessibilityNodeInfoCompat.u0((View) null);
            }
        }
    }

    public interface DrawerListener {
        void onDrawerClosed(View view);

        void onDrawerOpened(View view);

        void onDrawerSlide(View view, float f2);

        void onDrawerStateChanged(int i2);
    }

    private class ViewDragCallback extends ViewDragHelper.Callback {

        /* renamed from: a  reason: collision with root package name */
        private final int f3039a;

        /* renamed from: b  reason: collision with root package name */
        private ViewDragHelper f3040b;

        /* renamed from: c  reason: collision with root package name */
        private final Runnable f3041c = new Runnable() {
            public void run() {
                ViewDragCallback.this.o();
            }
        };

        ViewDragCallback(int i2) {
            this.f3039a = i2;
        }

        private void n() {
            int i2 = 3;
            if (this.f3039a == 3) {
                i2 = 5;
            }
            View findDrawerWithGravity = DrawerLayout.this.findDrawerWithGravity(i2);
            if (findDrawerWithGravity != null) {
                DrawerLayout.this.closeDrawer(findDrawerWithGravity);
            }
        }

        public int a(View view, int i2, int i3) {
            if (DrawerLayout.this.checkDrawerViewAbsoluteGravity(view, 3)) {
                return Math.max(-view.getWidth(), Math.min(i2, 0));
            }
            int width = DrawerLayout.this.getWidth();
            return Math.max(width - view.getWidth(), Math.min(i2, width));
        }

        public int b(View view, int i2, int i3) {
            return view.getTop();
        }

        public int d(View view) {
            if (DrawerLayout.this.isDrawerView(view)) {
                return view.getWidth();
            }
            return 0;
        }

        public void f(int i2, int i3) {
            View view;
            if ((i2 & 1) == 1) {
                view = DrawerLayout.this.findDrawerWithGravity(3);
            } else {
                view = DrawerLayout.this.findDrawerWithGravity(5);
            }
            if (view != null && DrawerLayout.this.getDrawerLockMode(view) == 0) {
                this.f3040b.c(view, i3);
            }
        }

        public boolean g(int i2) {
            return false;
        }

        public void h(int i2, int i3) {
            DrawerLayout.this.postDelayed(this.f3041c, 160);
        }

        public void i(View view, int i2) {
            ((LayoutParams) view.getLayoutParams()).f3032c = false;
            n();
        }

        public void j(int i2) {
            DrawerLayout.this.updateDrawerState(this.f3039a, i2, this.f3040b.w());
        }

        public void k(View view, int i2, int i3, int i4, int i5) {
            float f2;
            int i6;
            int width = view.getWidth();
            if (DrawerLayout.this.checkDrawerViewAbsoluteGravity(view, 3)) {
                f2 = (float) (i2 + width);
            } else {
                f2 = (float) (DrawerLayout.this.getWidth() - i2);
            }
            float f3 = f2 / ((float) width);
            DrawerLayout.this.setDrawerViewOffset(view, f3);
            if (f3 == 0.0f) {
                i6 = 4;
            } else {
                i6 = 0;
            }
            view.setVisibility(i6);
            DrawerLayout.this.invalidate();
        }

        public void l(View view, float f2, float f3) {
            int i2;
            float drawerViewOffset = DrawerLayout.this.getDrawerViewOffset(view);
            int width = view.getWidth();
            if (DrawerLayout.this.checkDrawerViewAbsoluteGravity(view, 3)) {
                int i3 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
                if (i3 > 0 || (i3 == 0 && drawerViewOffset > 0.5f)) {
                    i2 = 0;
                } else {
                    i2 = -width;
                }
            } else {
                int width2 = DrawerLayout.this.getWidth();
                if (f2 < 0.0f || (f2 == 0.0f && drawerViewOffset > 0.5f)) {
                    width2 -= width;
                }
                i2 = width2;
            }
            this.f3040b.N(i2, view.getTop());
            DrawerLayout.this.invalidate();
        }

        public boolean m(View view, int i2) {
            if (!DrawerLayout.this.isDrawerView(view) || !DrawerLayout.this.checkDrawerViewAbsoluteGravity(view, this.f3039a) || DrawerLayout.this.getDrawerLockMode(view) != 0) {
                return false;
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        public void o() {
            boolean z2;
            View view;
            int i2;
            int x2 = this.f3040b.x();
            int i3 = 0;
            if (this.f3039a == 3) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                view = DrawerLayout.this.findDrawerWithGravity(3);
                if (view != null) {
                    i3 = -view.getWidth();
                }
                i2 = i3 + x2;
            } else {
                view = DrawerLayout.this.findDrawerWithGravity(5);
                i2 = DrawerLayout.this.getWidth() - x2;
            }
            if (view == null) {
                return;
            }
            if (((z2 && view.getLeft() < i2) || (!z2 && view.getLeft() > i2)) && DrawerLayout.this.getDrawerLockMode(view) == 0) {
                this.f3040b.P(view, i2, view.getTop());
                ((LayoutParams) view.getLayoutParams()).f3032c = true;
                DrawerLayout.this.invalidate();
                n();
                DrawerLayout.this.cancelChildViewTouch();
            }
        }

        public void p() {
            DrawerLayout.this.removeCallbacks(this.f3041c);
        }

        public void q(ViewDragHelper viewDragHelper) {
            this.f3040b = viewDragHelper;
        }
    }

    public DrawerLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    private boolean dispatchTransformedGenericPointerEvent(MotionEvent motionEvent, View view) {
        if (!view.getMatrix().isIdentity()) {
            MotionEvent transformedMotionEvent = getTransformedMotionEvent(motionEvent, view);
            boolean dispatchGenericMotionEvent = view.dispatchGenericMotionEvent(transformedMotionEvent);
            transformedMotionEvent.recycle();
            return dispatchGenericMotionEvent;
        }
        float scrollX = (float) (getScrollX() - view.getLeft());
        float scrollY = (float) (getScrollY() - view.getTop());
        motionEvent.offsetLocation(scrollX, scrollY);
        boolean dispatchGenericMotionEvent2 = view.dispatchGenericMotionEvent(motionEvent);
        motionEvent.offsetLocation(-scrollX, -scrollY);
        return dispatchGenericMotionEvent2;
    }

    private MotionEvent getTransformedMotionEvent(MotionEvent motionEvent, View view) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.offsetLocation((float) (getScrollX() - view.getLeft()), (float) (getScrollY() - view.getTop()));
        Matrix matrix = view.getMatrix();
        if (!matrix.isIdentity()) {
            if (this.mChildInvertedMatrix == null) {
                this.mChildInvertedMatrix = new Matrix();
            }
            matrix.invert(this.mChildInvertedMatrix);
            obtain.transform(this.mChildInvertedMatrix);
        }
        return obtain;
    }

    static String gravityToString(int i2) {
        if ((i2 & 3) == 3) {
            return "LEFT";
        }
        if ((i2 & 5) == 5) {
            return "RIGHT";
        }
        return Integer.toHexString(i2);
    }

    private static boolean hasOpaqueBackground(View view) {
        Drawable background = view.getBackground();
        if (background == null || background.getOpacity() != -1) {
            return false;
        }
        return true;
    }

    private boolean hasPeekingDrawer() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            if (((LayoutParams) getChildAt(i2).getLayoutParams()).f3032c) {
                return true;
            }
        }
        return false;
    }

    private boolean hasVisibleDrawer() {
        return findVisibleDrawer() != null;
    }

    static boolean includeChildForAccessibility(View view) {
        if (ViewCompat.B(view) == 4 || ViewCompat.B(view) == 2) {
            return false;
        }
        return true;
    }

    private boolean isInBoundsOfChild(float f2, float f3, View view) {
        if (this.mChildHitRect == null) {
            this.mChildHitRect = new Rect();
        }
        view.getHitRect(this.mChildHitRect);
        return this.mChildHitRect.contains((int) f2, (int) f3);
    }

    private boolean mirror(Drawable drawable, int i2) {
        if (drawable == null || !DrawableCompat.h(drawable)) {
            return false;
        }
        DrawableCompat.m(drawable, i2);
        return true;
    }

    private Drawable resolveLeftShadow() {
        int D = ViewCompat.D(this);
        if (D == 0) {
            Drawable drawable = this.mShadowStart;
            if (drawable != null) {
                mirror(drawable, D);
                return this.mShadowStart;
            }
        } else {
            Drawable drawable2 = this.mShadowEnd;
            if (drawable2 != null) {
                mirror(drawable2, D);
                return this.mShadowEnd;
            }
        }
        return this.mShadowLeft;
    }

    private Drawable resolveRightShadow() {
        int D = ViewCompat.D(this);
        if (D == 0) {
            Drawable drawable = this.mShadowEnd;
            if (drawable != null) {
                mirror(drawable, D);
                return this.mShadowEnd;
            }
        } else {
            Drawable drawable2 = this.mShadowStart;
            if (drawable2 != null) {
                mirror(drawable2, D);
                return this.mShadowStart;
            }
        }
        return this.mShadowRight;
    }

    private void resolveShadowDrawables() {
        if (!SET_DRAWER_SHADOW_FROM_ELEVATION) {
            this.mShadowLeftResolved = resolveLeftShadow();
            this.mShadowRightResolved = resolveRightShadow();
        }
    }

    private void updateChildrenImportantForAccessibility(View view, boolean z2) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((z2 || isDrawerView(childAt)) && (!z2 || childAt != view)) {
                ViewCompat.C0(childAt, 4);
            } else {
                ViewCompat.C0(childAt, 1);
            }
        }
    }

    public void addDrawerListener(DrawerListener drawerListener) {
        if (drawerListener != null) {
            if (this.mListeners == null) {
                this.mListeners = new ArrayList();
            }
            this.mListeners.add(drawerListener);
        }
    }

    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        if (getDescendantFocusability() != 393216) {
            int childCount = getChildCount();
            boolean z2 = false;
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                if (!isDrawerView(childAt)) {
                    this.mNonDrawerViews.add(childAt);
                } else if (isDrawerOpen(childAt)) {
                    childAt.addFocusables(arrayList, i2, i3);
                    z2 = true;
                }
            }
            if (!z2) {
                int size = this.mNonDrawerViews.size();
                for (int i5 = 0; i5 < size; i5++) {
                    View view = this.mNonDrawerViews.get(i5);
                    if (view.getVisibility() == 0) {
                        view.addFocusables(arrayList, i2, i3);
                    }
                }
            }
            this.mNonDrawerViews.clear();
        }
    }

    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i2, layoutParams);
        if (findOpenDrawer() != null || isDrawerView(view)) {
            ViewCompat.C0(view, 4);
        } else {
            ViewCompat.C0(view, 1);
        }
        if (!CAN_HIDE_DESCENDANTS) {
            ViewCompat.r0(view, this.mChildAccessibilityDelegate);
        }
    }

    /* access modifiers changed from: package-private */
    public void cancelChildViewTouch() {
        if (!this.mChildrenCanceledTouch) {
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                getChildAt(i2).dispatchTouchEvent(obtain);
            }
            obtain.recycle();
            this.mChildrenCanceledTouch = true;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean checkDrawerViewAbsoluteGravity(View view, int i2) {
        return (getDrawerViewAbsoluteGravity(view) & i2) == i2;
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public void closeDrawer(View view) {
        closeDrawer(view, true);
    }

    public void closeDrawers() {
        closeDrawers(false);
    }

    public void computeScroll() {
        int childCount = getChildCount();
        float f2 = 0.0f;
        for (int i2 = 0; i2 < childCount; i2++) {
            f2 = Math.max(f2, ((LayoutParams) getChildAt(i2).getLayoutParams()).f3031b);
        }
        this.mScrimOpacity = f2;
        boolean n2 = this.mLeftDragger.n(true);
        boolean n3 = this.mRightDragger.n(true);
        if (n2 || n3) {
            ViewCompat.i0(this);
        }
    }

    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) == 0 || motionEvent.getAction() == 10 || this.mScrimOpacity <= 0.0f) {
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        int childCount = getChildCount();
        if (childCount == 0) {
            return false;
        }
        float x2 = motionEvent.getX();
        float y2 = motionEvent.getY();
        for (int i2 = childCount - 1; i2 >= 0; i2--) {
            View childAt = getChildAt(i2);
            if (isInBoundsOfChild(x2, y2, childAt) && !isContentView(childAt) && dispatchTransformedGenericPointerEvent(motionEvent, childAt)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void dispatchOnDrawerClosed(View view) {
        View rootView;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if ((layoutParams.f3033d & 1) == 1) {
            layoutParams.f3033d = 0;
            List<DrawerListener> list = this.mListeners;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.mListeners.get(size).onDrawerClosed(view);
                }
            }
            updateChildrenImportantForAccessibility(view, false);
            if (hasWindowFocus() && (rootView = getRootView()) != null) {
                rootView.sendAccessibilityEvent(32);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void dispatchOnDrawerOpened(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if ((layoutParams.f3033d & 1) == 0) {
            layoutParams.f3033d = 1;
            List<DrawerListener> list = this.mListeners;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.mListeners.get(size).onDrawerOpened(view);
                }
            }
            updateChildrenImportantForAccessibility(view, true);
            if (hasWindowFocus()) {
                sendAccessibilityEvent(32);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void dispatchOnDrawerSlide(View view, float f2) {
        List<DrawerListener> list = this.mListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mListeners.get(size).onDrawerSlide(view, f2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j2) {
        Canvas canvas2 = canvas;
        View view2 = view;
        int height = getHeight();
        boolean isContentView = isContentView(view2);
        int width = getWidth();
        int save = canvas.save();
        int i2 = 0;
        if (isContentView) {
            int childCount = getChildCount();
            int i3 = 0;
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                if (childAt != view2 && childAt.getVisibility() == 0 && hasOpaqueBackground(childAt) && isDrawerView(childAt) && childAt.getHeight() >= height) {
                    if (checkDrawerViewAbsoluteGravity(childAt, 3)) {
                        int right = childAt.getRight();
                        if (right > i3) {
                            i3 = right;
                        }
                    } else {
                        int left = childAt.getLeft();
                        if (left < width) {
                            width = left;
                        }
                    }
                }
            }
            canvas.clipRect(i3, 0, width, getHeight());
            i2 = i3;
        }
        boolean drawChild = super.drawChild(canvas, view, j2);
        canvas.restoreToCount(save);
        float f2 = this.mScrimOpacity;
        if (f2 > 0.0f && isContentView) {
            int i5 = this.mScrimColor;
            this.mScrimPaint.setColor((i5 & 16777215) | (((int) (((float) ((-16777216 & i5) >>> 24)) * f2)) << 24));
            canvas.drawRect((float) i2, 0.0f, (float) width, (float) getHeight(), this.mScrimPaint);
        } else if (this.mShadowLeftResolved != null && checkDrawerViewAbsoluteGravity(view2, 3)) {
            int intrinsicWidth = this.mShadowLeftResolved.getIntrinsicWidth();
            int right2 = view.getRight();
            float max = Math.max(0.0f, Math.min(((float) right2) / ((float) this.mLeftDragger.x()), 1.0f));
            this.mShadowLeftResolved.setBounds(right2, view.getTop(), intrinsicWidth + right2, view.getBottom());
            this.mShadowLeftResolved.setAlpha((int) (max * 255.0f));
            this.mShadowLeftResolved.draw(canvas);
        } else if (this.mShadowRightResolved != null && checkDrawerViewAbsoluteGravity(view2, 5)) {
            int intrinsicWidth2 = this.mShadowRightResolved.getIntrinsicWidth();
            int left2 = view.getLeft();
            float max2 = Math.max(0.0f, Math.min(((float) (getWidth() - left2)) / ((float) this.mRightDragger.x()), 1.0f));
            this.mShadowRightResolved.setBounds(left2 - intrinsicWidth2, view.getTop(), left2, view.getBottom());
            this.mShadowRightResolved.setAlpha((int) (max2 * 255.0f));
            this.mShadowRightResolved.draw(canvas);
        }
        return drawChild;
    }

    /* access modifiers changed from: package-private */
    public View findDrawerWithGravity(int i2) {
        int b2 = GravityCompat.b(i2, ViewCompat.D(this)) & 7;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if ((getDrawerViewAbsoluteGravity(childAt) & 7) == b2) {
                return childAt;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public View findOpenDrawer() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((((LayoutParams) childAt.getLayoutParams()).f3033d & 1) == 1) {
                return childAt;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public View findVisibleDrawer() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (isDrawerView(childAt) && isDrawerVisible(childAt)) {
                return childAt;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    public float getDrawerElevation() {
        if (SET_DRAWER_SHADOW_FROM_ELEVATION) {
            return this.mDrawerElevation;
        }
        return 0.0f;
    }

    public int getDrawerLockMode(int i2) {
        int D = ViewCompat.D(this);
        if (i2 == 3) {
            int i3 = this.mLockModeLeft;
            if (i3 != 3) {
                return i3;
            }
            int i4 = D == 0 ? this.mLockModeStart : this.mLockModeEnd;
            if (i4 != 3) {
                return i4;
            }
            return 0;
        } else if (i2 == 5) {
            int i5 = this.mLockModeRight;
            if (i5 != 3) {
                return i5;
            }
            int i6 = D == 0 ? this.mLockModeEnd : this.mLockModeStart;
            if (i6 != 3) {
                return i6;
            }
            return 0;
        } else if (i2 == 8388611) {
            int i7 = this.mLockModeStart;
            if (i7 != 3) {
                return i7;
            }
            int i8 = D == 0 ? this.mLockModeLeft : this.mLockModeRight;
            if (i8 != 3) {
                return i8;
            }
            return 0;
        } else if (i2 != 8388613) {
            return 0;
        } else {
            int i9 = this.mLockModeEnd;
            if (i9 != 3) {
                return i9;
            }
            int i10 = D == 0 ? this.mLockModeRight : this.mLockModeLeft;
            if (i10 != 3) {
                return i10;
            }
            return 0;
        }
    }

    public CharSequence getDrawerTitle(int i2) {
        int b2 = GravityCompat.b(i2, ViewCompat.D(this));
        if (b2 == 3) {
            return this.mTitleLeft;
        }
        if (b2 == 5) {
            return this.mTitleRight;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public int getDrawerViewAbsoluteGravity(View view) {
        return GravityCompat.b(((LayoutParams) view.getLayoutParams()).f3030a, ViewCompat.D(this));
    }

    /* access modifiers changed from: package-private */
    public float getDrawerViewOffset(View view) {
        return ((LayoutParams) view.getLayoutParams()).f3031b;
    }

    public Drawable getStatusBarBackgroundDrawable() {
        return this.mStatusBarBackground;
    }

    /* access modifiers changed from: package-private */
    public boolean isContentView(View view) {
        return ((LayoutParams) view.getLayoutParams()).f3030a == 0;
    }

    public boolean isDrawerOpen(View view) {
        if (isDrawerView(view)) {
            return (((LayoutParams) view.getLayoutParams()).f3033d & 1) == 1;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    /* access modifiers changed from: package-private */
    public boolean isDrawerView(View view) {
        int b2 = GravityCompat.b(((LayoutParams) view.getLayoutParams()).f3030a, ViewCompat.D(view));
        if ((b2 & 3) == 0 && (b2 & 5) == 0) {
            return false;
        }
        return true;
    }

    public boolean isDrawerVisible(View view) {
        if (isDrawerView(view)) {
            return ((LayoutParams) view.getLayoutParams()).f3031b > 0.0f;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    /* access modifiers changed from: package-private */
    public void moveDrawerToOffset(View view, float f2) {
        float drawerViewOffset = getDrawerViewOffset(view);
        float width = (float) view.getWidth();
        int i2 = ((int) (width * f2)) - ((int) (drawerViewOffset * width));
        if (!checkDrawerViewAbsoluteGravity(view, 3)) {
            i2 = -i2;
        }
        view.offsetLeftAndRight(i2);
        setDrawerViewOffset(view, f2);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mFirstLayout = true;
    }

    public void onDraw(Canvas canvas) {
        int i2;
        super.onDraw(canvas);
        if (this.mDrawStatusBarBackground && this.mStatusBarBackground != null) {
            Object obj = this.mLastInsets;
            if (obj != null) {
                i2 = ((WindowInsets) obj).getSystemWindowInsetTop();
            } else {
                i2 = 0;
            }
            if (i2 > 0) {
                this.mStatusBarBackground.setBounds(0, 0, getWidth(), i2);
                this.mStatusBarBackground.draw(canvas);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001b, code lost:
        if (r0 != 3) goto L_0x0038;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            int r0 = r7.getActionMasked()
            androidx.customview.widget.ViewDragHelper r1 = r6.mLeftDragger
            boolean r1 = r1.O(r7)
            androidx.customview.widget.ViewDragHelper r2 = r6.mRightDragger
            boolean r2 = r2.O(r7)
            r1 = r1 | r2
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L_0x003a
            if (r0 == r2) goto L_0x0031
            r7 = 2
            r4 = 3
            if (r0 == r7) goto L_0x001e
            if (r0 == r4) goto L_0x0031
            goto L_0x0038
        L_0x001e:
            androidx.customview.widget.ViewDragHelper r7 = r6.mLeftDragger
            boolean r7 = r7.e(r4)
            if (r7 == 0) goto L_0x0038
            androidx.drawerlayout.widget.DrawerLayout$ViewDragCallback r7 = r6.mLeftCallback
            r7.p()
            androidx.drawerlayout.widget.DrawerLayout$ViewDragCallback r7 = r6.mRightCallback
            r7.p()
            goto L_0x0038
        L_0x0031:
            r6.closeDrawers(r2)
            r6.mDisallowInterceptRequested = r3
            r6.mChildrenCanceledTouch = r3
        L_0x0038:
            r7 = 0
            goto L_0x0064
        L_0x003a:
            float r0 = r7.getX()
            float r7 = r7.getY()
            r6.mInitialMotionX = r0
            r6.mInitialMotionY = r7
            float r4 = r6.mScrimOpacity
            r5 = 0
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto L_0x005f
            androidx.customview.widget.ViewDragHelper r4 = r6.mLeftDragger
            int r0 = (int) r0
            int r7 = (int) r7
            android.view.View r7 = r4.u(r0, r7)
            if (r7 == 0) goto L_0x005f
            boolean r7 = r6.isContentView(r7)
            if (r7 == 0) goto L_0x005f
            r7 = 1
            goto L_0x0060
        L_0x005f:
            r7 = 0
        L_0x0060:
            r6.mDisallowInterceptRequested = r3
            r6.mChildrenCanceledTouch = r3
        L_0x0064:
            if (r1 != 0) goto L_0x0074
            if (r7 != 0) goto L_0x0074
            boolean r7 = r6.hasPeekingDrawer()
            if (r7 != 0) goto L_0x0074
            boolean r7 = r6.mChildrenCanceledTouch
            if (r7 == 0) goto L_0x0073
            goto L_0x0074
        L_0x0073:
            r2 = 0
        L_0x0074:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 != 4 || !hasVisibleDrawer()) {
            return super.onKeyDown(i2, keyEvent);
        }
        keyEvent.startTracking();
        return true;
    }

    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (i2 != 4) {
            return super.onKeyUp(i2, keyEvent);
        }
        View findVisibleDrawer = findVisibleDrawer();
        if (findVisibleDrawer != null && getDrawerLockMode(findVisibleDrawer) == 0) {
            closeDrawers();
        }
        if (findVisibleDrawer != null) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        float f2;
        int i6;
        boolean z3;
        int i7;
        this.mInLayout = true;
        int i8 = i4 - i2;
        int childCount = getChildCount();
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (isContentView(childAt)) {
                    int i10 = layoutParams.leftMargin;
                    childAt.layout(i10, layoutParams.topMargin, childAt.getMeasuredWidth() + i10, layoutParams.topMargin + childAt.getMeasuredHeight());
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (checkDrawerViewAbsoluteGravity(childAt, 3)) {
                        float f3 = (float) measuredWidth;
                        i6 = (-measuredWidth) + ((int) (layoutParams.f3031b * f3));
                        f2 = ((float) (measuredWidth + i6)) / f3;
                    } else {
                        float f4 = (float) measuredWidth;
                        int i11 = i8 - ((int) (layoutParams.f3031b * f4));
                        f2 = ((float) (i8 - i11)) / f4;
                        i6 = i11;
                    }
                    if (f2 != layoutParams.f3031b) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    int i12 = layoutParams.f3030a & 112;
                    if (i12 == 16) {
                        int i13 = i5 - i3;
                        int i14 = (i13 - measuredHeight) / 2;
                        int i15 = layoutParams.topMargin;
                        if (i14 < i15) {
                            i14 = i15;
                        } else {
                            int i16 = i14 + measuredHeight;
                            int i17 = layoutParams.bottomMargin;
                            if (i16 > i13 - i17) {
                                i14 = (i13 - i17) - measuredHeight;
                            }
                        }
                        childAt.layout(i6, i14, measuredWidth + i6, measuredHeight + i14);
                    } else if (i12 != 80) {
                        int i18 = layoutParams.topMargin;
                        childAt.layout(i6, i18, measuredWidth + i6, measuredHeight + i18);
                    } else {
                        int i19 = i5 - i3;
                        childAt.layout(i6, (i19 - layoutParams.bottomMargin) - childAt.getMeasuredHeight(), measuredWidth + i6, i19 - layoutParams.bottomMargin);
                    }
                    if (z3) {
                        setDrawerViewOffset(childAt, f2);
                    }
                    if (layoutParams.f3031b > 0.0f) {
                        i7 = 0;
                    } else {
                        i7 = 4;
                    }
                    if (childAt.getVisibility() != i7) {
                        childAt.setVisibility(i7);
                    }
                }
            }
        }
        this.mInLayout = false;
        this.mFirstLayout = false;
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"WrongConstant"})
    public void onMeasure(int i2, int i3) {
        boolean z2;
        boolean z3;
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        if (!(mode == 1073741824 && mode2 == 1073741824)) {
            if (isInEditMode()) {
                if (mode != Integer.MIN_VALUE && mode == 0) {
                    size = 300;
                }
                if (mode2 != Integer.MIN_VALUE && mode2 == 0) {
                    size2 = 300;
                }
            } else {
                throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
            }
        }
        setMeasuredDimension(size, size2);
        if (this.mLastInsets == null || !ViewCompat.A(this)) {
            z2 = false;
        } else {
            z2 = true;
        }
        int D = ViewCompat.D(this);
        int childCount = getChildCount();
        boolean z4 = false;
        boolean z5 = false;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (z2) {
                    int b2 = GravityCompat.b(layoutParams.f3030a, D);
                    if (ViewCompat.A(childAt)) {
                        WindowInsets windowInsets = (WindowInsets) this.mLastInsets;
                        if (b2 == 3) {
                            windowInsets = windowInsets.replaceSystemWindowInsets(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), 0, windowInsets.getSystemWindowInsetBottom());
                        } else if (b2 == 5) {
                            windowInsets = windowInsets.replaceSystemWindowInsets(0, windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
                        }
                        childAt.dispatchApplyWindowInsets(windowInsets);
                    } else {
                        WindowInsets windowInsets2 = (WindowInsets) this.mLastInsets;
                        if (b2 == 3) {
                            windowInsets2 = windowInsets2.replaceSystemWindowInsets(windowInsets2.getSystemWindowInsetLeft(), windowInsets2.getSystemWindowInsetTop(), 0, windowInsets2.getSystemWindowInsetBottom());
                        } else if (b2 == 5) {
                            windowInsets2 = windowInsets2.replaceSystemWindowInsets(0, windowInsets2.getSystemWindowInsetTop(), windowInsets2.getSystemWindowInsetRight(), windowInsets2.getSystemWindowInsetBottom());
                        }
                        layoutParams.leftMargin = windowInsets2.getSystemWindowInsetLeft();
                        layoutParams.topMargin = windowInsets2.getSystemWindowInsetTop();
                        layoutParams.rightMargin = windowInsets2.getSystemWindowInsetRight();
                        layoutParams.bottomMargin = windowInsets2.getSystemWindowInsetBottom();
                    }
                }
                if (isContentView(childAt)) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec((size - layoutParams.leftMargin) - layoutParams.rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec((size2 - layoutParams.topMargin) - layoutParams.bottomMargin, 1073741824));
                } else if (isDrawerView(childAt)) {
                    if (SET_DRAWER_SHADOW_FROM_ELEVATION) {
                        float x2 = ViewCompat.x(childAt);
                        float f2 = this.mDrawerElevation;
                        if (x2 != f2) {
                            ViewCompat.z0(childAt, f2);
                        }
                    }
                    int drawerViewAbsoluteGravity = getDrawerViewAbsoluteGravity(childAt) & 7;
                    if (drawerViewAbsoluteGravity == 3) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if ((!z3 || !z4) && (z3 || !z5)) {
                        if (z3) {
                            z4 = true;
                        } else {
                            z5 = true;
                        }
                        childAt.measure(ViewGroup.getChildMeasureSpec(i2, this.mMinDrawerMargin + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), ViewGroup.getChildMeasureSpec(i3, layoutParams.topMargin + layoutParams.bottomMargin, layoutParams.height));
                    } else {
                        throw new IllegalStateException("Child drawer has absolute gravity " + gravityToString(drawerViewAbsoluteGravity) + " but this " + TAG + " already has a " + "drawer view along that edge");
                    }
                } else {
                    throw new IllegalStateException("Child " + childAt + " at index " + i4 + " does not have a valid layout_gravity - must be Gravity.LEFT, " + "Gravity.RIGHT or Gravity.NO_GRAVITY");
                }
            }
            int i5 = i2;
            int i6 = i3;
        }
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        View findDrawerWithGravity;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.b());
        int i2 = savedState.f3034d;
        if (!(i2 == 0 || (findDrawerWithGravity = findDrawerWithGravity(i2)) == null)) {
            openDrawer(findDrawerWithGravity);
        }
        int i3 = savedState.f3035e;
        if (i3 != 3) {
            setDrawerLockMode(i3, 3);
        }
        int i4 = savedState.f3036f;
        if (i4 != 3) {
            setDrawerLockMode(i4, 5);
        }
        int i5 = savedState.f3037g;
        if (i5 != 3) {
            setDrawerLockMode(i5, 8388611);
        }
        int i6 = savedState.f3038h;
        if (i6 != 3) {
            setDrawerLockMode(i6, 8388613);
        }
    }

    public void onRtlPropertiesChanged(int i2) {
        resolveShadowDrawables();
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        boolean z2;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        int childCount = getChildCount();
        int i2 = 0;
        while (true) {
            if (i2 >= childCount) {
                break;
            }
            LayoutParams layoutParams = (LayoutParams) getChildAt(i2).getLayoutParams();
            int i3 = layoutParams.f3033d;
            boolean z3 = true;
            if (i3 == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (i3 != 2) {
                z3 = false;
            }
            if (z2 || z3) {
                savedState.f3034d = layoutParams.f3030a;
            } else {
                i2++;
            }
        }
        savedState.f3035e = this.mLockModeLeft;
        savedState.f3036f = this.mLockModeRight;
        savedState.f3037g = this.mLockModeStart;
        savedState.f3038h = this.mLockModeEnd;
        return savedState;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z2;
        View findOpenDrawer;
        this.mLeftDragger.F(motionEvent);
        this.mRightDragger.F(motionEvent);
        int action = motionEvent.getAction() & JfifUtil.MARKER_FIRST_BYTE;
        if (action == 0) {
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            this.mInitialMotionX = x2;
            this.mInitialMotionY = y2;
            this.mDisallowInterceptRequested = false;
            this.mChildrenCanceledTouch = false;
        } else if (action == 1) {
            float x3 = motionEvent.getX();
            float y3 = motionEvent.getY();
            View u2 = this.mLeftDragger.u((int) x3, (int) y3);
            if (u2 != null && isContentView(u2)) {
                float f2 = x3 - this.mInitialMotionX;
                float f3 = y3 - this.mInitialMotionY;
                int z3 = this.mLeftDragger.z();
                if (!((f2 * f2) + (f3 * f3) >= ((float) (z3 * z3)) || (findOpenDrawer = findOpenDrawer()) == null || getDrawerLockMode(findOpenDrawer) == 2)) {
                    z2 = false;
                    closeDrawers(z2);
                    this.mDisallowInterceptRequested = false;
                }
            }
            z2 = true;
            closeDrawers(z2);
            this.mDisallowInterceptRequested = false;
        } else if (action == 3) {
            closeDrawers(true);
            this.mDisallowInterceptRequested = false;
            this.mChildrenCanceledTouch = false;
        }
        return true;
    }

    public void openDrawer(View view) {
        openDrawer(view, true);
    }

    public void removeDrawerListener(DrawerListener drawerListener) {
        List<DrawerListener> list;
        if (drawerListener != null && (list = this.mListeners) != null) {
            list.remove(drawerListener);
        }
    }

    public void requestDisallowInterceptTouchEvent(boolean z2) {
        super.requestDisallowInterceptTouchEvent(z2);
        this.mDisallowInterceptRequested = z2;
        if (z2) {
            closeDrawers(true);
        }
    }

    public void requestLayout() {
        if (!this.mInLayout) {
            super.requestLayout();
        }
    }

    public void setChildInsets(Object obj, boolean z2) {
        boolean z3;
        this.mLastInsets = obj;
        this.mDrawStatusBarBackground = z2;
        if (z2 || getBackground() != null) {
            z3 = false;
        } else {
            z3 = true;
        }
        setWillNotDraw(z3);
        requestLayout();
    }

    public void setDrawerElevation(float f2) {
        this.mDrawerElevation = f2;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (isDrawerView(childAt)) {
                ViewCompat.z0(childAt, this.mDrawerElevation);
            }
        }
    }

    @Deprecated
    public void setDrawerListener(DrawerListener drawerListener) {
        DrawerListener drawerListener2 = this.mListener;
        if (drawerListener2 != null) {
            removeDrawerListener(drawerListener2);
        }
        if (drawerListener != null) {
            addDrawerListener(drawerListener);
        }
        this.mListener = drawerListener;
    }

    public void setDrawerLockMode(int i2) {
        setDrawerLockMode(i2, 3);
        setDrawerLockMode(i2, 5);
    }

    public void setDrawerShadow(Drawable drawable, int i2) {
        if (!SET_DRAWER_SHADOW_FROM_ELEVATION) {
            if ((i2 & 8388611) == 8388611) {
                this.mShadowStart = drawable;
            } else if ((i2 & 8388613) == 8388613) {
                this.mShadowEnd = drawable;
            } else if ((i2 & 3) == 3) {
                this.mShadowLeft = drawable;
            } else if ((i2 & 5) == 5) {
                this.mShadowRight = drawable;
            } else {
                return;
            }
            resolveShadowDrawables();
            invalidate();
        }
    }

    public void setDrawerTitle(int i2, CharSequence charSequence) {
        int b2 = GravityCompat.b(i2, ViewCompat.D(this));
        if (b2 == 3) {
            this.mTitleLeft = charSequence;
        } else if (b2 == 5) {
            this.mTitleRight = charSequence;
        }
    }

    /* access modifiers changed from: package-private */
    public void setDrawerViewOffset(View view, float f2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f2 != layoutParams.f3031b) {
            layoutParams.f3031b = f2;
            dispatchOnDrawerSlide(view, f2);
        }
    }

    public void setScrimColor(int i2) {
        this.mScrimColor = i2;
        invalidate();
    }

    public void setStatusBarBackground(Drawable drawable) {
        this.mStatusBarBackground = drawable;
        invalidate();
    }

    public void setStatusBarBackgroundColor(int i2) {
        this.mStatusBarBackground = new ColorDrawable(i2);
        invalidate();
    }

    /* access modifiers changed from: package-private */
    public void updateDrawerState(int i2, int i3, View view) {
        int i4;
        int A = this.mLeftDragger.A();
        int A2 = this.mRightDragger.A();
        if (A == 1 || A2 == 1) {
            i4 = 1;
        } else {
            i4 = 2;
            if (!(A == 2 || A2 == 2)) {
                i4 = 0;
            }
        }
        if (view != null && i3 == 0) {
            float f2 = ((LayoutParams) view.getLayoutParams()).f3031b;
            if (f2 == 0.0f) {
                dispatchOnDrawerClosed(view);
            } else if (f2 == 1.0f) {
                dispatchOnDrawerOpened(view);
            }
        }
        if (i4 != this.mDrawerState) {
            this.mDrawerState = i4;
            List<DrawerListener> list = this.mListeners;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.mListeners.get(size).onDrawerStateChanged(i4);
                }
            }
        }
    }

    public DrawerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void closeDrawer(View view, boolean z2) {
        if (isDrawerView(view)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (this.mFirstLayout) {
                layoutParams.f3031b = 0.0f;
                layoutParams.f3033d = 0;
            } else if (z2) {
                layoutParams.f3033d |= 4;
                if (checkDrawerViewAbsoluteGravity(view, 3)) {
                    this.mLeftDragger.P(view, -view.getWidth(), view.getTop());
                } else {
                    this.mRightDragger.P(view, getWidth(), view.getTop());
                }
            } else {
                moveDrawerToOffset(view, 0.0f);
                updateDrawerState(layoutParams.f3030a, 0, view);
                view.setVisibility(4);
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    /* access modifiers changed from: package-private */
    public void closeDrawers(boolean z2) {
        boolean z3;
        int childCount = getChildCount();
        boolean z4 = false;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (isDrawerView(childAt) && (!z2 || layoutParams.f3032c)) {
                int width = childAt.getWidth();
                if (checkDrawerViewAbsoluteGravity(childAt, 3)) {
                    z3 = this.mLeftDragger.P(childAt, -width, childAt.getTop());
                } else {
                    z3 = this.mRightDragger.P(childAt, getWidth(), childAt.getTop());
                }
                z4 |= z3;
                layoutParams.f3032c = false;
            }
        }
        this.mLeftCallback.p();
        this.mRightCallback.p();
        if (z4) {
            invalidate();
        }
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public void openDrawer(View view, boolean z2) {
        if (isDrawerView(view)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (this.mFirstLayout) {
                layoutParams.f3031b = 1.0f;
                layoutParams.f3033d = 1;
                updateChildrenImportantForAccessibility(view, true);
            } else if (z2) {
                layoutParams.f3033d |= 2;
                if (checkDrawerViewAbsoluteGravity(view, 3)) {
                    this.mLeftDragger.P(view, 0, view.getTop());
                } else {
                    this.mRightDragger.P(view, getWidth() - view.getWidth(), view.getTop());
                }
            } else {
                moveDrawerToOffset(view, 1.0f);
                updateDrawerState(layoutParams.f3030a, 0, view);
                view.setVisibility(0);
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    public DrawerLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mChildAccessibilityDelegate = new ChildAccessibilityDelegate();
        this.mScrimColor = DEFAULT_SCRIM_COLOR;
        this.mScrimPaint = new Paint();
        this.mFirstLayout = true;
        this.mLockModeLeft = 3;
        this.mLockModeRight = 3;
        this.mLockModeStart = 3;
        this.mLockModeEnd = 3;
        this.mShadowStart = null;
        this.mShadowEnd = null;
        this.mShadowLeft = null;
        this.mShadowRight = null;
        setDescendantFocusability(262144);
        float f2 = getResources().getDisplayMetrics().density;
        this.mMinDrawerMargin = (int) ((64.0f * f2) + 0.5f);
        float f3 = 400.0f * f2;
        ViewDragCallback viewDragCallback = new ViewDragCallback(3);
        this.mLeftCallback = viewDragCallback;
        ViewDragCallback viewDragCallback2 = new ViewDragCallback(5);
        this.mRightCallback = viewDragCallback2;
        ViewDragHelper o2 = ViewDragHelper.o(this, 1.0f, viewDragCallback);
        this.mLeftDragger = o2;
        o2.L(1);
        o2.M(f3);
        viewDragCallback.q(o2);
        ViewDragHelper o3 = ViewDragHelper.o(this, 1.0f, viewDragCallback2);
        this.mRightDragger = o3;
        o3.L(2);
        o3.M(f3);
        viewDragCallback2.q(o3);
        setFocusableInTouchMode(true);
        ViewCompat.C0(this, 1);
        ViewCompat.r0(this, new AccessibilityDelegate());
        setMotionEventSplittingEnabled(false);
        if (ViewCompat.A(this)) {
            setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
                public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    boolean z2;
                    DrawerLayout drawerLayout = (DrawerLayout) view;
                    if (windowInsets.getSystemWindowInsetTop() > 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    drawerLayout.setChildInsets(windowInsets, z2);
                    return windowInsets.consumeSystemWindowInsets();
                }
            });
            setSystemUiVisibility(1280);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(THEME_ATTRS);
            try {
                this.mStatusBarBackground = obtainStyledAttributes.getDrawable(0);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        this.mDrawerElevation = f2 * 10.0f;
        this.mNonDrawerViews = new ArrayList<>();
    }

    public void setDrawerLockMode(int i2, int i3) {
        View findDrawerWithGravity;
        int b2 = GravityCompat.b(i3, ViewCompat.D(this));
        if (i3 == 3) {
            this.mLockModeLeft = i2;
        } else if (i3 == 5) {
            this.mLockModeRight = i2;
        } else if (i3 == 8388611) {
            this.mLockModeStart = i2;
        } else if (i3 == 8388613) {
            this.mLockModeEnd = i2;
        }
        if (i2 != 0) {
            (b2 == 3 ? this.mLeftDragger : this.mRightDragger).b();
        }
        if (i2 == 1) {
            View findDrawerWithGravity2 = findDrawerWithGravity(b2);
            if (findDrawerWithGravity2 != null) {
                closeDrawer(findDrawerWithGravity2);
            }
        } else if (i2 == 2 && (findDrawerWithGravity = findDrawerWithGravity(b2)) != null) {
            openDrawer(findDrawerWithGravity);
        }
    }

    public void setStatusBarBackground(int i2) {
        this.mStatusBarBackground = i2 != 0 ? ContextCompat.getDrawable(getContext(), i2) : null;
        invalidate();
    }

    public boolean isDrawerVisible(int i2) {
        View findDrawerWithGravity = findDrawerWithGravity(i2);
        if (findDrawerWithGravity != null) {
            return isDrawerVisible(findDrawerWithGravity);
        }
        return false;
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public int f3030a = 0;

        /* renamed from: b  reason: collision with root package name */
        float f3031b;

        /* renamed from: c  reason: collision with root package name */
        boolean f3032c;

        /* renamed from: d  reason: collision with root package name */
        int f3033d;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, DrawerLayout.LAYOUT_ATTRS);
            this.f3030a = obtainStyledAttributes.getInt(0, 0);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.f3030a = layoutParams.f3030a;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    public boolean isDrawerOpen(int i2) {
        View findDrawerWithGravity = findDrawerWithGravity(i2);
        if (findDrawerWithGravity != null) {
            return isDrawerOpen(findDrawerWithGravity);
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
        int f3034d = 0;

        /* renamed from: e  reason: collision with root package name */
        int f3035e;

        /* renamed from: f  reason: collision with root package name */
        int f3036f;

        /* renamed from: g  reason: collision with root package name */
        int f3037g;

        /* renamed from: h  reason: collision with root package name */
        int f3038h;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f3034d = parcel.readInt();
            this.f3035e = parcel.readInt();
            this.f3036f = parcel.readInt();
            this.f3037g = parcel.readInt();
            this.f3038h = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f3034d);
            parcel.writeInt(this.f3035e);
            parcel.writeInt(this.f3036f);
            parcel.writeInt(this.f3037g);
            parcel.writeInt(this.f3038h);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public void setDrawerShadow(int i2, int i3) {
        setDrawerShadow(ContextCompat.getDrawable(getContext(), i2), i3);
    }

    public int getDrawerLockMode(View view) {
        if (isDrawerView(view)) {
            return getDrawerLockMode(((LayoutParams) view.getLayoutParams()).f3030a);
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    public void setDrawerLockMode(int i2, View view) {
        if (isDrawerView(view)) {
            setDrawerLockMode(i2, ((LayoutParams) view.getLayoutParams()).f3030a);
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a " + "drawer with appropriate layout_gravity");
    }

    public void closeDrawer(int i2) {
        closeDrawer(i2, true);
    }

    public void closeDrawer(int i2, boolean z2) {
        View findDrawerWithGravity = findDrawerWithGravity(i2);
        if (findDrawerWithGravity != null) {
            closeDrawer(findDrawerWithGravity, z2);
            return;
        }
        throw new IllegalArgumentException("No drawer view found with gravity " + gravityToString(i2));
    }

    public void openDrawer(int i2) {
        openDrawer(i2, true);
    }

    public void openDrawer(int i2, boolean z2) {
        View findDrawerWithGravity = findDrawerWithGravity(i2);
        if (findDrawerWithGravity != null) {
            openDrawer(findDrawerWithGravity, z2);
            return;
        }
        throw new IllegalArgumentException("No drawer view found with gravity " + gravityToString(i2));
    }
}
