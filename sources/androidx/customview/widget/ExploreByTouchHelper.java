package androidx.customview.widget;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.collection.SparseArrayCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewParentCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.core.view.accessibility.AccessibilityRecordCompat;
import androidx.customview.widget.FocusStrategy;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.util.ArrayList;
import java.util.List;

public abstract class ExploreByTouchHelper extends AccessibilityDelegateCompat {
    private static final String DEFAULT_CLASS_NAME = "android.view.View";
    public static final int HOST_ID = -1;
    public static final int INVALID_ID = Integer.MIN_VALUE;
    private static final Rect INVALID_PARENT_BOUNDS = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
    private static final FocusStrategy.BoundsAdapter<AccessibilityNodeInfoCompat> NODE_ADAPTER = new FocusStrategy.BoundsAdapter<AccessibilityNodeInfoCompat>() {
        /* renamed from: b */
        public void a(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, Rect rect) {
            accessibilityNodeInfoCompat.l(rect);
        }
    };
    private static final FocusStrategy.CollectionAdapter<SparseArrayCompat<AccessibilityNodeInfoCompat>, AccessibilityNodeInfoCompat> SPARSE_VALUES_ADAPTER = new FocusStrategy.CollectionAdapter<SparseArrayCompat<AccessibilityNodeInfoCompat>, AccessibilityNodeInfoCompat>() {
        /* renamed from: c */
        public AccessibilityNodeInfoCompat a(SparseArrayCompat<AccessibilityNodeInfoCompat> sparseArrayCompat, int i2) {
            return sparseArrayCompat.l(i2);
        }

        /* renamed from: d */
        public int b(SparseArrayCompat<AccessibilityNodeInfoCompat> sparseArrayCompat) {
            return sparseArrayCompat.k();
        }
    };
    int mAccessibilityFocusedVirtualViewId = Integer.MIN_VALUE;
    private final View mHost;
    private int mHoveredVirtualViewId = Integer.MIN_VALUE;
    int mKeyboardFocusedVirtualViewId = Integer.MIN_VALUE;
    private final AccessibilityManager mManager;
    private MyNodeProvider mNodeProvider;
    private final int[] mTempGlobalRect = new int[2];
    private final Rect mTempParentRect = new Rect();
    private final Rect mTempScreenRect = new Rect();
    private final Rect mTempVisibleRect = new Rect();

    private class MyNodeProvider extends AccessibilityNodeProviderCompat {
        MyNodeProvider() {
        }

        public AccessibilityNodeInfoCompat b(int i2) {
            return AccessibilityNodeInfoCompat.Q(ExploreByTouchHelper.this.obtainAccessibilityNodeInfo(i2));
        }

        public AccessibilityNodeInfoCompat d(int i2) {
            int i3;
            if (i2 == 2) {
                i3 = ExploreByTouchHelper.this.mAccessibilityFocusedVirtualViewId;
            } else {
                i3 = ExploreByTouchHelper.this.mKeyboardFocusedVirtualViewId;
            }
            if (i3 == Integer.MIN_VALUE) {
                return null;
            }
            return b(i3);
        }

        public boolean f(int i2, int i3, Bundle bundle) {
            return ExploreByTouchHelper.this.performAction(i2, i3, bundle);
        }
    }

    public ExploreByTouchHelper(View view) {
        if (view != null) {
            this.mHost = view;
            this.mManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
            view.setFocusable(true);
            if (ViewCompat.B(view) == 0) {
                ViewCompat.C0(view, 1);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("View may not be null");
    }

    private boolean clearAccessibilityFocus(int i2) {
        if (this.mAccessibilityFocusedVirtualViewId != i2) {
            return false;
        }
        this.mAccessibilityFocusedVirtualViewId = Integer.MIN_VALUE;
        this.mHost.invalidate();
        sendEventForVirtualView(i2, 65536);
        return true;
    }

    private boolean clickKeyboardFocusedVirtualView() {
        int i2 = this.mKeyboardFocusedVirtualViewId;
        return i2 != Integer.MIN_VALUE && onPerformActionForVirtualView(i2, 16, (Bundle) null);
    }

    private AccessibilityEvent createEvent(int i2, int i3) {
        if (i2 != -1) {
            return createEventForChild(i2, i3);
        }
        return createEventForHost(i3);
    }

    private AccessibilityEvent createEventForChild(int i2, int i3) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i3);
        AccessibilityNodeInfoCompat obtainAccessibilityNodeInfo = obtainAccessibilityNodeInfo(i2);
        obtain.getText().add(obtainAccessibilityNodeInfo.x());
        obtain.setContentDescription(obtainAccessibilityNodeInfo.r());
        obtain.setScrollable(obtainAccessibilityNodeInfo.L());
        obtain.setPassword(obtainAccessibilityNodeInfo.K());
        obtain.setEnabled(obtainAccessibilityNodeInfo.G());
        obtain.setChecked(obtainAccessibilityNodeInfo.E());
        onPopulateEventForVirtualView(i2, obtain);
        if (!obtain.getText().isEmpty() || obtain.getContentDescription() != null) {
            obtain.setClassName(obtainAccessibilityNodeInfo.o());
            AccessibilityRecordCompat.c(obtain, this.mHost, i2);
            obtain.setPackageName(this.mHost.getContext().getPackageName());
            return obtain;
        }
        throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
    }

    private AccessibilityEvent createEventForHost(int i2) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i2);
        this.mHost.onInitializeAccessibilityEvent(obtain);
        return obtain;
    }

    private AccessibilityNodeInfoCompat createNodeForChild(int i2) {
        boolean z2;
        AccessibilityNodeInfoCompat O = AccessibilityNodeInfoCompat.O();
        O.j0(true);
        O.l0(true);
        O.c0(DEFAULT_CLASS_NAME);
        Rect rect = INVALID_PARENT_BOUNDS;
        O.X(rect);
        O.Y(rect);
        O.u0(this.mHost);
        onPopulateNodeForVirtualView(i2, O);
        if (O.x() == null && O.r() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        O.l(this.mTempParentRect);
        if (!this.mTempParentRect.equals(rect)) {
            int k2 = O.k();
            if ((k2 & 64) != 0) {
                throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
            } else if ((k2 & 128) == 0) {
                O.s0(this.mHost.getContext().getPackageName());
                O.D0(this.mHost, i2);
                if (this.mAccessibilityFocusedVirtualViewId == i2) {
                    O.V(true);
                    O.a(128);
                } else {
                    O.V(false);
                    O.a(64);
                }
                if (this.mKeyboardFocusedVirtualViewId == i2) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    O.a(2);
                } else if (O.H()) {
                    O.a(1);
                }
                O.m0(z2);
                this.mHost.getLocationOnScreen(this.mTempGlobalRect);
                O.m(this.mTempScreenRect);
                if (this.mTempScreenRect.equals(rect)) {
                    O.l(this.mTempScreenRect);
                    if (O.f2855b != -1) {
                        AccessibilityNodeInfoCompat O2 = AccessibilityNodeInfoCompat.O();
                        for (int i3 = O.f2855b; i3 != -1; i3 = O2.f2855b) {
                            O2.v0(this.mHost, -1);
                            O2.X(INVALID_PARENT_BOUNDS);
                            onPopulateNodeForVirtualView(i3, O2);
                            O2.l(this.mTempParentRect);
                            Rect rect2 = this.mTempScreenRect;
                            Rect rect3 = this.mTempParentRect;
                            rect2.offset(rect3.left, rect3.top);
                        }
                        O2.S();
                    }
                    this.mTempScreenRect.offset(this.mTempGlobalRect[0] - this.mHost.getScrollX(), this.mTempGlobalRect[1] - this.mHost.getScrollY());
                }
                if (this.mHost.getLocalVisibleRect(this.mTempVisibleRect)) {
                    this.mTempVisibleRect.offset(this.mTempGlobalRect[0] - this.mHost.getScrollX(), this.mTempGlobalRect[1] - this.mHost.getScrollY());
                    if (this.mTempScreenRect.intersect(this.mTempVisibleRect)) {
                        O.Y(this.mTempScreenRect);
                        if (isVisibleToUser(this.mTempScreenRect)) {
                            O.H0(true);
                        }
                    }
                }
                return O;
            } else {
                throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
            }
        } else {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
    }

    private AccessibilityNodeInfoCompat createNodeForHost() {
        AccessibilityNodeInfoCompat P = AccessibilityNodeInfoCompat.P(this.mHost);
        ViewCompat.e0(this.mHost, P);
        ArrayList arrayList = new ArrayList();
        getVisibleVirtualViews(arrayList);
        if (P.n() <= 0 || arrayList.size() <= 0) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                P.d(this.mHost, ((Integer) arrayList.get(i2)).intValue());
            }
            return P;
        }
        throw new RuntimeException("Views cannot have both real and virtual children");
    }

    private SparseArrayCompat<AccessibilityNodeInfoCompat> getAllNodes() {
        ArrayList arrayList = new ArrayList();
        getVisibleVirtualViews(arrayList);
        SparseArrayCompat<AccessibilityNodeInfoCompat> sparseArrayCompat = new SparseArrayCompat<>();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            sparseArrayCompat.i(i2, createNodeForChild(i2));
        }
        return sparseArrayCompat;
    }

    private void getBoundsInParent(int i2, Rect rect) {
        obtainAccessibilityNodeInfo(i2).l(rect);
    }

    private static Rect guessPreviouslyFocusedRect(View view, int i2, Rect rect) {
        int width = view.getWidth();
        int height = view.getHeight();
        if (i2 == 17) {
            rect.set(width, 0, width, height);
        } else if (i2 == 33) {
            rect.set(0, height, width, height);
        } else if (i2 == 66) {
            rect.set(-1, 0, -1, height);
        } else if (i2 == 130) {
            rect.set(0, -1, width, -1);
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        return rect;
    }

    private boolean isVisibleToUser(Rect rect) {
        if (rect == null || rect.isEmpty() || this.mHost.getWindowVisibility() != 0) {
            return false;
        }
        ViewParent parent = this.mHost.getParent();
        while (parent instanceof View) {
            View view = (View) parent;
            if (view.getAlpha() <= 0.0f || view.getVisibility() != 0) {
                return false;
            }
            parent = view.getParent();
        }
        if (parent != null) {
            return true;
        }
        return false;
    }

    private static int keyToDirection(int i2) {
        if (i2 == 19) {
            return 33;
        }
        if (i2 == 21) {
            return 17;
        }
        if (i2 != 22) {
            return Sdk$SDKError.Reason.MRAID_DOWNLOAD_JS_ERROR_VALUE;
        }
        return 66;
    }

    private boolean moveFocus(int i2, Rect rect) {
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat;
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2;
        boolean z2;
        SparseArrayCompat<AccessibilityNodeInfoCompat> allNodes = getAllNodes();
        int i3 = this.mKeyboardFocusedVirtualViewId;
        int i4 = Integer.MIN_VALUE;
        if (i3 == Integer.MIN_VALUE) {
            accessibilityNodeInfoCompat = null;
        } else {
            accessibilityNodeInfoCompat = allNodes.e(i3);
        }
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat3 = accessibilityNodeInfoCompat;
        if (i2 == 1 || i2 == 2) {
            if (ViewCompat.D(this.mHost) == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            accessibilityNodeInfoCompat2 = (AccessibilityNodeInfoCompat) FocusStrategy.d(allNodes, SPARSE_VALUES_ADAPTER, NODE_ADAPTER, accessibilityNodeInfoCompat3, i2, z2, false);
        } else if (i2 == 17 || i2 == 33 || i2 == 66 || i2 == 130) {
            Rect rect2 = new Rect();
            int i5 = this.mKeyboardFocusedVirtualViewId;
            if (i5 != Integer.MIN_VALUE) {
                getBoundsInParent(i5, rect2);
            } else if (rect != null) {
                rect2.set(rect);
            } else {
                guessPreviouslyFocusedRect(this.mHost, i2, rect2);
            }
            accessibilityNodeInfoCompat2 = (AccessibilityNodeInfoCompat) FocusStrategy.c(allNodes, SPARSE_VALUES_ADAPTER, NODE_ADAPTER, accessibilityNodeInfoCompat3, rect2, i2);
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        if (accessibilityNodeInfoCompat2 != null) {
            i4 = allNodes.h(allNodes.g(accessibilityNodeInfoCompat2));
        }
        return requestKeyboardFocusForVirtualView(i4);
    }

    private boolean performActionForChild(int i2, int i3, Bundle bundle) {
        if (i3 == 1) {
            return requestKeyboardFocusForVirtualView(i2);
        }
        if (i3 == 2) {
            return clearKeyboardFocusForVirtualView(i2);
        }
        if (i3 == 64) {
            return requestAccessibilityFocus(i2);
        }
        if (i3 != 128) {
            return onPerformActionForVirtualView(i2, i3, bundle);
        }
        return clearAccessibilityFocus(i2);
    }

    private boolean performActionForHost(int i2, Bundle bundle) {
        return ViewCompat.g0(this.mHost, i2, bundle);
    }

    private boolean requestAccessibilityFocus(int i2) {
        int i3;
        if (!this.mManager.isEnabled() || !this.mManager.isTouchExplorationEnabled() || (i3 = this.mAccessibilityFocusedVirtualViewId) == i2) {
            return false;
        }
        if (i3 != Integer.MIN_VALUE) {
            clearAccessibilityFocus(i3);
        }
        this.mAccessibilityFocusedVirtualViewId = i2;
        this.mHost.invalidate();
        sendEventForVirtualView(i2, 32768);
        return true;
    }

    private void updateHoveredVirtualView(int i2) {
        int i3 = this.mHoveredVirtualViewId;
        if (i3 != i2) {
            this.mHoveredVirtualViewId = i2;
            sendEventForVirtualView(i2, 128);
            sendEventForVirtualView(i3, UserVerificationMethods.USER_VERIFY_HANDPRINT);
        }
    }

    public final boolean clearKeyboardFocusForVirtualView(int i2) {
        if (this.mKeyboardFocusedVirtualViewId != i2) {
            return false;
        }
        this.mKeyboardFocusedVirtualViewId = Integer.MIN_VALUE;
        onVirtualViewKeyboardFocusChanged(i2, false);
        sendEventForVirtualView(i2, 8);
        return true;
    }

    public final boolean dispatchHoverEvent(MotionEvent motionEvent) {
        if (!this.mManager.isEnabled() || !this.mManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 7 || action == 9) {
            int virtualViewAt = getVirtualViewAt(motionEvent.getX(), motionEvent.getY());
            updateHoveredVirtualView(virtualViewAt);
            if (virtualViewAt != Integer.MIN_VALUE) {
                return true;
            }
            return false;
        } else if (action != 10 || this.mHoveredVirtualViewId == Integer.MIN_VALUE) {
            return false;
        } else {
            updateHoveredVirtualView(Integer.MIN_VALUE);
            return true;
        }
    }

    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int i2 = 0;
        if (keyEvent.getAction() == 1) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode != 61) {
            if (keyCode != 66) {
                switch (keyCode) {
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                        if (!keyEvent.hasNoModifiers()) {
                            return false;
                        }
                        int keyToDirection = keyToDirection(keyCode);
                        int repeatCount = keyEvent.getRepeatCount() + 1;
                        boolean z2 = false;
                        while (i2 < repeatCount && moveFocus(keyToDirection, (Rect) null)) {
                            i2++;
                            z2 = true;
                        }
                        return z2;
                    case 23:
                        break;
                    default:
                        return false;
                }
            }
            if (!keyEvent.hasNoModifiers() || keyEvent.getRepeatCount() != 0) {
                return false;
            }
            clickKeyboardFocusedVirtualView();
            return true;
        } else if (keyEvent.hasNoModifiers()) {
            return moveFocus(2, (Rect) null);
        } else {
            if (keyEvent.hasModifiers(1)) {
                return moveFocus(1, (Rect) null);
            }
            return false;
        }
    }

    public final int getAccessibilityFocusedVirtualViewId() {
        return this.mAccessibilityFocusedVirtualViewId;
    }

    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view) {
        if (this.mNodeProvider == null) {
            this.mNodeProvider = new MyNodeProvider();
        }
        return this.mNodeProvider;
    }

    @Deprecated
    public int getFocusedVirtualView() {
        return getAccessibilityFocusedVirtualViewId();
    }

    public final int getKeyboardFocusedVirtualViewId() {
        return this.mKeyboardFocusedVirtualViewId;
    }

    /* access modifiers changed from: protected */
    public abstract int getVirtualViewAt(float f2, float f3);

    /* access modifiers changed from: protected */
    public abstract void getVisibleVirtualViews(List<Integer> list);

    public final void invalidateRoot() {
        invalidateVirtualView(-1, 1);
    }

    public final void invalidateVirtualView(int i2) {
        invalidateVirtualView(i2, 0);
    }

    /* access modifiers changed from: package-private */
    public AccessibilityNodeInfoCompat obtainAccessibilityNodeInfo(int i2) {
        if (i2 == -1) {
            return createNodeForHost();
        }
        return createNodeForChild(i2);
    }

    public final void onFocusChanged(boolean z2, int i2, Rect rect) {
        int i3 = this.mKeyboardFocusedVirtualViewId;
        if (i3 != Integer.MIN_VALUE) {
            clearKeyboardFocusForVirtualView(i3);
        }
        if (z2) {
            moveFocus(i2, rect);
        }
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        onPopulateEventForHost(accessibilityEvent);
    }

    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        onPopulateNodeForHost(accessibilityNodeInfoCompat);
    }

    /* access modifiers changed from: protected */
    public abstract boolean onPerformActionForVirtualView(int i2, int i3, Bundle bundle);

    /* access modifiers changed from: protected */
    public void onPopulateEventForHost(AccessibilityEvent accessibilityEvent) {
    }

    /* access modifiers changed from: protected */
    public void onPopulateEventForVirtualView(int i2, AccessibilityEvent accessibilityEvent) {
    }

    /* access modifiers changed from: protected */
    public void onPopulateNodeForHost(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
    }

    /* access modifiers changed from: protected */
    public abstract void onPopulateNodeForVirtualView(int i2, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat);

    /* access modifiers changed from: protected */
    public void onVirtualViewKeyboardFocusChanged(int i2, boolean z2) {
    }

    /* access modifiers changed from: package-private */
    public boolean performAction(int i2, int i3, Bundle bundle) {
        if (i2 != -1) {
            return performActionForChild(i2, i3, bundle);
        }
        return performActionForHost(i3, bundle);
    }

    public final boolean requestKeyboardFocusForVirtualView(int i2) {
        int i3;
        if ((!this.mHost.isFocused() && !this.mHost.requestFocus()) || (i3 = this.mKeyboardFocusedVirtualViewId) == i2) {
            return false;
        }
        if (i3 != Integer.MIN_VALUE) {
            clearKeyboardFocusForVirtualView(i3);
        }
        this.mKeyboardFocusedVirtualViewId = i2;
        onVirtualViewKeyboardFocusChanged(i2, true);
        sendEventForVirtualView(i2, 8);
        return true;
    }

    public final boolean sendEventForVirtualView(int i2, int i3) {
        ViewParent parent;
        if (i2 == Integer.MIN_VALUE || !this.mManager.isEnabled() || (parent = this.mHost.getParent()) == null) {
            return false;
        }
        return ViewParentCompat.h(parent, this.mHost, createEvent(i2, i3));
    }

    public final void invalidateVirtualView(int i2, int i3) {
        ViewParent parent;
        if (i2 != Integer.MIN_VALUE && this.mManager.isEnabled() && (parent = this.mHost.getParent()) != null) {
            AccessibilityEvent createEvent = createEvent(i2, 2048);
            AccessibilityEventCompat.b(createEvent, i3);
            ViewParentCompat.h(parent, this.mHost, createEvent);
        }
    }
}
