package com.facebook.react.touch;

import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.ViewParent;

public class JSResponderHandler implements OnInterceptTouchEventListener {
    private static final int JS_RESPONDER_UNSET = -1;
    private volatile int mCurrentJSResponder = -1;
    private ViewParent mViewParentBlockingNativeResponder;

    private void maybeUnblockNativeResponder() {
        ViewParent viewParent = this.mViewParentBlockingNativeResponder;
        if (viewParent != null) {
            viewParent.requestDisallowInterceptTouchEvent(false);
            this.mViewParentBlockingNativeResponder = null;
        }
    }

    public void clearJSResponder() {
        this.mCurrentJSResponder = -1;
        maybeUnblockNativeResponder();
    }

    public boolean onInterceptTouchEvent(ViewGroup viewGroup, MotionEvent motionEvent) {
        int i2 = this.mCurrentJSResponder;
        if (i2 == -1 || motionEvent.getAction() == 1 || viewGroup.getId() != i2) {
            return false;
        }
        return true;
    }

    public void setJSResponder(int i2, ViewParent viewParent) {
        this.mCurrentJSResponder = i2;
        maybeUnblockNativeResponder();
        if (viewParent != null) {
            viewParent.requestDisallowInterceptTouchEvent(true);
            this.mViewParentBlockingNativeResponder = viewParent;
        }
    }
}
