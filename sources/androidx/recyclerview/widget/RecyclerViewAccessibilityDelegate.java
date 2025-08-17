package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import java.util.Map;
import java.util.WeakHashMap;

public class RecyclerViewAccessibilityDelegate extends AccessibilityDelegateCompat {

    /* renamed from: a  reason: collision with root package name */
    final RecyclerView f11297a;

    /* renamed from: b  reason: collision with root package name */
    private final ItemDelegate f11298b;

    public static class ItemDelegate extends AccessibilityDelegateCompat {

        /* renamed from: a  reason: collision with root package name */
        final RecyclerViewAccessibilityDelegate f11299a;

        /* renamed from: b  reason: collision with root package name */
        private Map<View, AccessibilityDelegateCompat> f11300b = new WeakHashMap();

        public ItemDelegate(RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate) {
            this.f11299a = recyclerViewAccessibilityDelegate;
        }

        /* access modifiers changed from: package-private */
        public AccessibilityDelegateCompat a(View view) {
            return this.f11300b.remove(view);
        }

        /* access modifiers changed from: package-private */
        public void b(View view) {
            AccessibilityDelegateCompat n2 = ViewCompat.n(view);
            if (n2 != null && n2 != this) {
                this.f11300b.put(view, n2);
            }
        }

        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            AccessibilityDelegateCompat accessibilityDelegateCompat = this.f11300b.get(view);
            if (accessibilityDelegateCompat != null) {
                return accessibilityDelegateCompat.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
            }
            return super.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view) {
            AccessibilityDelegateCompat accessibilityDelegateCompat = this.f11300b.get(view);
            if (accessibilityDelegateCompat != null) {
                return accessibilityDelegateCompat.getAccessibilityNodeProvider(view);
            }
            return super.getAccessibilityNodeProvider(view);
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            AccessibilityDelegateCompat accessibilityDelegateCompat = this.f11300b.get(view);
            if (accessibilityDelegateCompat != null) {
                accessibilityDelegateCompat.onInitializeAccessibilityEvent(view, accessibilityEvent);
            } else {
                super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            }
        }

        public void onInitializeAccessibilityNodeInfo(@SuppressLint({"InvalidNullabilityOverride"}) View view, @SuppressLint({"InvalidNullabilityOverride"}) AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            if (this.f11299a.b() || this.f11299a.f11297a.getLayoutManager() == null) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                return;
            }
            this.f11299a.f11297a.getLayoutManager().onInitializeAccessibilityNodeInfoForItem(view, accessibilityNodeInfoCompat);
            AccessibilityDelegateCompat accessibilityDelegateCompat = this.f11300b.get(view);
            if (accessibilityDelegateCompat != null) {
                accessibilityDelegateCompat.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            } else {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            }
        }

        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            AccessibilityDelegateCompat accessibilityDelegateCompat = this.f11300b.get(view);
            if (accessibilityDelegateCompat != null) {
                accessibilityDelegateCompat.onPopulateAccessibilityEvent(view, accessibilityEvent);
            } else {
                super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            }
        }

        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            AccessibilityDelegateCompat accessibilityDelegateCompat = this.f11300b.get(viewGroup);
            if (accessibilityDelegateCompat != null) {
                return accessibilityDelegateCompat.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
            }
            return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        }

        public boolean performAccessibilityAction(@SuppressLint({"InvalidNullabilityOverride"}) View view, int i2, @SuppressLint({"InvalidNullabilityOverride"}) Bundle bundle) {
            if (this.f11299a.b() || this.f11299a.f11297a.getLayoutManager() == null) {
                return super.performAccessibilityAction(view, i2, bundle);
            }
            AccessibilityDelegateCompat accessibilityDelegateCompat = this.f11300b.get(view);
            if (accessibilityDelegateCompat != null) {
                if (accessibilityDelegateCompat.performAccessibilityAction(view, i2, bundle)) {
                    return true;
                }
            } else if (super.performAccessibilityAction(view, i2, bundle)) {
                return true;
            }
            return this.f11299a.f11297a.getLayoutManager().performAccessibilityActionForItem(view, i2, bundle);
        }

        public void sendAccessibilityEvent(View view, int i2) {
            AccessibilityDelegateCompat accessibilityDelegateCompat = this.f11300b.get(view);
            if (accessibilityDelegateCompat != null) {
                accessibilityDelegateCompat.sendAccessibilityEvent(view, i2);
            } else {
                super.sendAccessibilityEvent(view, i2);
            }
        }

        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            AccessibilityDelegateCompat accessibilityDelegateCompat = this.f11300b.get(view);
            if (accessibilityDelegateCompat != null) {
                accessibilityDelegateCompat.sendAccessibilityEventUnchecked(view, accessibilityEvent);
            } else {
                super.sendAccessibilityEventUnchecked(view, accessibilityEvent);
            }
        }
    }

    public RecyclerViewAccessibilityDelegate(RecyclerView recyclerView) {
        this.f11297a = recyclerView;
        AccessibilityDelegateCompat a2 = a();
        if (a2 == null || !(a2 instanceof ItemDelegate)) {
            this.f11298b = new ItemDelegate(this);
        } else {
            this.f11298b = (ItemDelegate) a2;
        }
    }

    public AccessibilityDelegateCompat a() {
        return this.f11298b;
    }

    /* access modifiers changed from: package-private */
    public boolean b() {
        return this.f11297a.hasPendingAdapterUpdates();
    }

    public void onInitializeAccessibilityEvent(@SuppressLint({"InvalidNullabilityOverride"}) View view, @SuppressLint({"InvalidNullabilityOverride"}) AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        if ((view instanceof RecyclerView) && !b()) {
            RecyclerView recyclerView = (RecyclerView) view;
            if (recyclerView.getLayoutManager() != null) {
                recyclerView.getLayoutManager().onInitializeAccessibilityEvent(accessibilityEvent);
            }
        }
    }

    public void onInitializeAccessibilityNodeInfo(@SuppressLint({"InvalidNullabilityOverride"}) View view, @SuppressLint({"InvalidNullabilityOverride"}) AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        if (!b() && this.f11297a.getLayoutManager() != null) {
            this.f11297a.getLayoutManager().onInitializeAccessibilityNodeInfo(accessibilityNodeInfoCompat);
        }
    }

    public boolean performAccessibilityAction(@SuppressLint({"InvalidNullabilityOverride"}) View view, int i2, @SuppressLint({"InvalidNullabilityOverride"}) Bundle bundle) {
        if (super.performAccessibilityAction(view, i2, bundle)) {
            return true;
        }
        if (b() || this.f11297a.getLayoutManager() == null) {
            return false;
        }
        return this.f11297a.getLayoutManager().performAccessibilityAction(i2, bundle);
    }
}
