package androidx.core.view.accessibility;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

public final class AccessibilityClickableSpanCompat extends ClickableSpan {

    /* renamed from: b  reason: collision with root package name */
    private final int f2849b;

    /* renamed from: c  reason: collision with root package name */
    private final AccessibilityNodeInfoCompat f2850c;

    /* renamed from: d  reason: collision with root package name */
    private final int f2851d;

    public AccessibilityClickableSpanCompat(int i2, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, int i3) {
        this.f2849b = i2;
        this.f2850c = accessibilityNodeInfoCompat;
        this.f2851d = i3;
    }

    public void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f2849b);
        this.f2850c.R(this.f2851d, bundle);
    }
}
