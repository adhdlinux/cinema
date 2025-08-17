package com.movie.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

public class MultiSwipeRefreshLayout extends SwipeRefreshLayout {

    /* renamed from: b  reason: collision with root package name */
    private CanChildScrollUpCallback f33653b;

    public interface CanChildScrollUpCallback {
        boolean n();
    }

    public MultiSwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean canChildScrollUp() {
        CanChildScrollUpCallback canChildScrollUpCallback = this.f33653b;
        if (canChildScrollUpCallback != null) {
            return canChildScrollUpCallback.n();
        }
        return super.canChildScrollUp();
    }

    public void setCanChildScrollUpCallback(CanChildScrollUpCallback canChildScrollUpCallback) {
        this.f33653b = canChildScrollUpCallback;
    }
}
