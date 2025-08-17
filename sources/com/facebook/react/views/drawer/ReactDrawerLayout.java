package com.facebook.react.views.drawer;

import android.view.MotionEvent;
import android.view.View;
import androidx.drawerlayout.widget.DrawerLayout;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.uimanager.events.NativeGestureUtil;

class ReactDrawerLayout extends DrawerLayout {
    public static final int DEFAULT_DRAWER_WIDTH = -1;
    private int mDrawerPosition = 8388611;
    private int mDrawerWidth = -1;

    public ReactDrawerLayout(ReactContext reactContext) {
        super(reactContext);
    }

    /* access modifiers changed from: package-private */
    public void closeDrawer() {
        closeDrawer(this.mDrawerPosition);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        try {
            if (!super.onInterceptTouchEvent(motionEvent)) {
                return false;
            }
            NativeGestureUtil.notifyNativeGestureStarted(this, motionEvent);
            return true;
        } catch (IllegalArgumentException e2) {
            FLog.w(ReactConstants.TAG, "Error intercepting touch event.", (Throwable) e2);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public void openDrawer() {
        openDrawer(this.mDrawerPosition);
    }

    /* access modifiers changed from: package-private */
    public void setDrawerPosition(int i2) {
        this.mDrawerPosition = i2;
        setDrawerProperties();
    }

    /* access modifiers changed from: package-private */
    public void setDrawerProperties() {
        if (getChildCount() == 2) {
            View childAt = getChildAt(1);
            DrawerLayout.LayoutParams layoutParams = (DrawerLayout.LayoutParams) childAt.getLayoutParams();
            layoutParams.f3030a = this.mDrawerPosition;
            layoutParams.width = this.mDrawerWidth;
            childAt.setLayoutParams(layoutParams);
            childAt.setClickable(true);
        }
    }

    /* access modifiers changed from: package-private */
    public void setDrawerWidth(int i2) {
        this.mDrawerWidth = i2;
        setDrawerProperties();
    }
}
