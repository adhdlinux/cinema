package com.google.android.material.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;

public class VisibilityAwareImageButton extends ImageButton {

    /* renamed from: b  reason: collision with root package name */
    private int f29914b;

    public VisibilityAwareImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void b(int i2, boolean z2) {
        super.setVisibility(i2);
        if (z2) {
            this.f29914b = i2;
        }
    }

    public final int getUserSetVisibility() {
        return this.f29914b;
    }

    public void setVisibility(int i2) {
        b(i2, true);
    }

    public VisibilityAwareImageButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f29914b = getVisibility();
    }
}
