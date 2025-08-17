package com.movie.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ViewAnimator;

public final class BetterViewAnimator extends ViewAnimator {
    public BetterViewAnimator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public int getDisplayedChildId() {
        return getChildAt(getDisplayedChild()).getId();
    }

    public void setDisplayedChildId(int i2) {
        if (getDisplayedChildId() != i2) {
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                if (getChildAt(i3).getId() == i2) {
                    setDisplayedChild(i3);
                    return;
                }
            }
            String resourceEntryName = getResources().getResourceEntryName(i2);
            throw new IllegalArgumentException("No view with ID " + resourceEntryName);
        }
    }
}
