package com.github.ksoichiro.android.observablescrollview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

public class TouchInterceptionFrameLayout extends FrameLayout {

    public interface TouchInterceptionListener {
    }

    public TouchInterceptionFrameLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setScrollInterceptionListener(TouchInterceptionListener touchInterceptionListener) {
    }
}
