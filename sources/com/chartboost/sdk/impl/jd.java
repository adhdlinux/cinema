package com.chartboost.sdk.impl;

import android.view.SurfaceView;
import android.view.ViewGroup;
import android.widget.FrameLayout;

public abstract class jd {
    public static final void a(SurfaceView surfaceView, int i2, int i3, int i4, int i5) {
        FrameLayout.LayoutParams layoutParams;
        if (surfaceView != null) {
            float f2 = (float) i4;
            float f3 = (float) i2;
            float f4 = f2 / f3;
            float f5 = (float) i5;
            float f6 = (float) i3;
            float f7 = f5 / f6;
            float f8 = f3 / f6;
            ViewGroup.LayoutParams layoutParams2 = surfaceView.getLayoutParams();
            FrameLayout.LayoutParams layoutParams3 = null;
            if (layoutParams2 instanceof FrameLayout.LayoutParams) {
                layoutParams = (FrameLayout.LayoutParams) layoutParams2;
            } else {
                layoutParams = null;
            }
            if (layoutParams != null) {
                if (f4 > f7) {
                    layoutParams.width = (int) (f5 * f8);
                    layoutParams.height = i5;
                } else {
                    layoutParams.width = i4;
                    layoutParams.height = (int) (f2 / f8);
                }
                layoutParams.gravity = 17;
                layoutParams3 = layoutParams;
            }
            surfaceView.setLayoutParams(layoutParams3);
        }
    }
}
