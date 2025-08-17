package com.yoku.house.ads.helper;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.TextView;

public class RunningTextView extends TextView {
    public RunningTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean isFocused() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z2, int i2, Rect rect) {
        if (z2) {
            super.onFocusChanged(z2, i2, rect);
        }
    }

    public void onWindowFocusChanged(boolean z2) {
        if (z2) {
            super.onWindowFocusChanged(z2);
        }
    }

    public RunningTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
