package com.google.android.material.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Checkable;
import androidx.appcompat.R$attr;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;

public class CheckableImageButton extends AppCompatImageButton implements Checkable {

    /* renamed from: f  reason: collision with root package name */
    private static final int[] f29812f = {16842912};

    /* renamed from: e  reason: collision with root package name */
    private boolean f29813e;

    public CheckableImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.G);
    }

    public boolean isChecked() {
        return this.f29813e;
    }

    public int[] onCreateDrawableState(int i2) {
        if (!this.f29813e) {
            return super.onCreateDrawableState(i2);
        }
        int[] iArr = f29812f;
        return View.mergeDrawableStates(super.onCreateDrawableState(i2 + iArr.length), iArr);
    }

    public void setChecked(boolean z2) {
        if (this.f29813e != z2) {
            this.f29813e = z2;
            refreshDrawableState();
            sendAccessibilityEvent(2048);
        }
    }

    public void toggle() {
        setChecked(!this.f29813e);
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        ViewCompat.r0(this, new AccessibilityDelegateCompat() {
            public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                super.onInitializeAccessibilityEvent(view, accessibilityEvent);
                accessibilityEvent.setChecked(CheckableImageButton.this.isChecked());
            }

            public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                accessibilityNodeInfoCompat.a0(true);
                accessibilityNodeInfoCompat.b0(CheckableImageButton.this.isChecked());
            }
        });
    }
}
