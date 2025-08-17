package androidx.preference;

import android.os.Bundle;
import android.view.View;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate;

@Deprecated
public class PreferenceRecyclerViewAccessibilityDelegate extends RecyclerViewAccessibilityDelegate {

    /* renamed from: c  reason: collision with root package name */
    final RecyclerView f10879c;

    /* renamed from: d  reason: collision with root package name */
    final AccessibilityDelegateCompat f10880d = super.a();

    /* renamed from: e  reason: collision with root package name */
    final AccessibilityDelegateCompat f10881e = new AccessibilityDelegateCompat() {
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            Preference item;
            PreferenceRecyclerViewAccessibilityDelegate.this.f10880d.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            int childAdapterPosition = PreferenceRecyclerViewAccessibilityDelegate.this.f10879c.getChildAdapterPosition(view);
            RecyclerView.Adapter adapter = PreferenceRecyclerViewAccessibilityDelegate.this.f10879c.getAdapter();
            if ((adapter instanceof PreferenceGroupAdapter) && (item = ((PreferenceGroupAdapter) adapter).getItem(childAdapterPosition)) != null) {
                item.onInitializeAccessibilityNodeInfo(accessibilityNodeInfoCompat);
            }
        }

        public boolean performAccessibilityAction(View view, int i2, Bundle bundle) {
            return PreferenceRecyclerViewAccessibilityDelegate.this.f10880d.performAccessibilityAction(view, i2, bundle);
        }
    };

    public PreferenceRecyclerViewAccessibilityDelegate(RecyclerView recyclerView) {
        super(recyclerView);
        this.f10879c = recyclerView;
    }

    public AccessibilityDelegateCompat a() {
        return this.f10881e;
    }
}
