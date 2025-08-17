package androidx.preference;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;

public class PreferenceCategory extends PreferenceGroup {
    public PreferenceCategory(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
    }

    public boolean isEnabled() {
        return false;
    }

    public void onBindViewHolder(PreferenceViewHolder preferenceViewHolder) {
        super.onBindViewHolder(preferenceViewHolder);
        if (Build.VERSION.SDK_INT >= 28) {
            preferenceViewHolder.itemView.setAccessibilityHeading(true);
        }
    }

    @Deprecated
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        AccessibilityNodeInfoCompat.CollectionItemInfoCompat q2;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfoCompat);
        if (Build.VERSION.SDK_INT < 28 && (q2 = accessibilityNodeInfoCompat.q()) != null) {
            accessibilityNodeInfoCompat.f0(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.g(q2.c(), q2.d(), q2.a(), q2.b(), true, q2.e()));
        }
    }

    public boolean shouldDisableDependents() {
        return !super.isEnabled();
    }

    public PreferenceCategory(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public PreferenceCategory(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, TypedArrayUtils.a(context, R$attr.preferenceCategoryStyle, 16842892));
    }

    public PreferenceCategory(Context context) {
        this(context, (AttributeSet) null);
    }
}
