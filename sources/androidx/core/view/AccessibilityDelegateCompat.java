package androidx.core.view;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.core.R$id;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;

public class AccessibilityDelegateCompat {
    private static final View.AccessibilityDelegate DEFAULT_DELEGATE = new View.AccessibilityDelegate();
    private final View.AccessibilityDelegate mBridge;
    private final View.AccessibilityDelegate mOriginalDelegate;

    static final class AccessibilityDelegateAdapter extends View.AccessibilityDelegate {

        /* renamed from: a  reason: collision with root package name */
        final AccessibilityDelegateCompat f2728a;

        AccessibilityDelegateAdapter(AccessibilityDelegateCompat accessibilityDelegateCompat) {
            this.f2728a = accessibilityDelegateCompat;
        }

        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.f2728a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
            AccessibilityNodeProviderCompat accessibilityNodeProvider = this.f2728a.getAccessibilityNodeProvider(view);
            if (accessibilityNodeProvider != null) {
                return (AccessibilityNodeProvider) accessibilityNodeProvider.e();
            }
            return null;
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f2728a.onInitializeAccessibilityEvent(view, accessibilityEvent);
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            AccessibilityNodeInfoCompat J0 = AccessibilityNodeInfoCompat.J0(accessibilityNodeInfo);
            J0.y0(ViewCompat.Y(view));
            J0.n0(ViewCompat.T(view));
            J0.t0(ViewCompat.r(view));
            J0.E0(ViewCompat.L(view));
            this.f2728a.onInitializeAccessibilityNodeInfo(view, J0);
            J0.f(accessibilityNodeInfo.getText(), view);
            List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> actionList = AccessibilityDelegateCompat.getActionList(view);
            for (int i2 = 0; i2 < actionList.size(); i2++) {
                J0.b(actionList.get(i2));
            }
        }

        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f2728a.onPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return this.f2728a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        }

        public boolean performAccessibilityAction(View view, int i2, Bundle bundle) {
            return this.f2728a.performAccessibilityAction(view, i2, bundle);
        }

        public void sendAccessibilityEvent(View view, int i2) {
            this.f2728a.sendAccessibilityEvent(view, i2);
        }

        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            this.f2728a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
        }
    }

    static class Api16Impl {
        private Api16Impl() {
        }

        static AccessibilityNodeProvider a(View.AccessibilityDelegate accessibilityDelegate, View view) {
            return accessibilityDelegate.getAccessibilityNodeProvider(view);
        }

        static boolean b(View.AccessibilityDelegate accessibilityDelegate, View view, int i2, Bundle bundle) {
            return accessibilityDelegate.performAccessibilityAction(view, i2, bundle);
        }
    }

    public AccessibilityDelegateCompat() {
        this(DEFAULT_DELEGATE);
    }

    static List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> getActionList(View view) {
        List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> list = (List) view.getTag(R$id.H);
        if (list == null) {
            return Collections.emptyList();
        }
        return list;
    }

    private boolean isSpanStillValid(ClickableSpan clickableSpan, View view) {
        if (clickableSpan != null) {
            ClickableSpan[] p2 = AccessibilityNodeInfoCompat.p(view.createAccessibilityNodeInfo().getText());
            int i2 = 0;
            while (p2 != null && i2 < p2.length) {
                if (clickableSpan.equals(p2[i2])) {
                    return true;
                }
                i2++;
            }
        }
        return false;
    }

    private boolean performClickableSpanAction(int i2, View view) {
        WeakReference weakReference;
        SparseArray sparseArray = (SparseArray) view.getTag(R$id.I);
        if (sparseArray == null || (weakReference = (WeakReference) sparseArray.get(i2)) == null) {
            return false;
        }
        ClickableSpan clickableSpan = (ClickableSpan) weakReference.get();
        if (!isSpanStillValid(clickableSpan, view)) {
            return false;
        }
        clickableSpan.onClick(view);
        return true;
    }

    public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        return this.mOriginalDelegate.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view) {
        AccessibilityNodeProvider a2 = Api16Impl.a(this.mOriginalDelegate, view);
        if (a2 != null) {
            return new AccessibilityNodeProviderCompat(a2);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public View.AccessibilityDelegate getBridge() {
        return this.mBridge;
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        this.mOriginalDelegate.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        this.mOriginalDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat.I0());
    }

    public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        this.mOriginalDelegate.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.mOriginalDelegate.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public boolean performAccessibilityAction(View view, int i2, Bundle bundle) {
        List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> actionList = getActionList(view);
        boolean z2 = false;
        int i3 = 0;
        while (true) {
            if (i3 >= actionList.size()) {
                break;
            }
            AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat = actionList.get(i3);
            if (accessibilityActionCompat.b() == i2) {
                z2 = accessibilityActionCompat.d(view, bundle);
                break;
            }
            i3++;
        }
        if (!z2) {
            z2 = Api16Impl.b(this.mOriginalDelegate, view, i2, bundle);
        }
        if (z2 || i2 != R$id.f2270a || bundle == null) {
            return z2;
        }
        return performClickableSpanAction(bundle.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1), view);
    }

    public void sendAccessibilityEvent(View view, int i2) {
        this.mOriginalDelegate.sendAccessibilityEvent(view, i2);
    }

    public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
        this.mOriginalDelegate.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    public AccessibilityDelegateCompat(View.AccessibilityDelegate accessibilityDelegate) {
        this.mOriginalDelegate = accessibilityDelegate;
        this.mBridge = new AccessibilityDelegateAdapter(this);
    }
}
