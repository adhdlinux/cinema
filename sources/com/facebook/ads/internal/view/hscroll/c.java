package com.facebook.ads.internal.view.hscroll;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

public class c {
    public int[] a(View view, int i2, int i3) {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i2, view.getPaddingLeft() + view.getPaddingRight(), layoutParams.width), ViewGroup.getChildMeasureSpec(i3, view.getPaddingTop() + view.getPaddingBottom(), layoutParams.height));
        return new int[]{view.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin, view.getMeasuredHeight() + layoutParams.bottomMargin + layoutParams.topMargin};
    }
}
