package com.nononsenseapps.filepicker;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class DividerItemDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: a  reason: collision with root package name */
    private Drawable f33724a;

    public DividerItemDecoration(Drawable drawable) {
        this.f33724a = drawable;
    }

    public void e(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        super.e(rect, view, recyclerView, state);
        if (recyclerView.getChildAdapterPosition(view) != 0) {
            rect.top = this.f33724a.getIntrinsicHeight();
        }
    }

    public void g(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        int paddingLeft = recyclerView.getPaddingLeft();
        int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
        int childCount = recyclerView.getChildCount();
        for (int i2 = 0; i2 < childCount - 1; i2++) {
            View childAt = recyclerView.getChildAt(i2);
            int bottom = childAt.getBottom() + ((RecyclerView.LayoutParams) childAt.getLayoutParams()).bottomMargin;
            this.f33724a.setBounds(paddingLeft, bottom, width, this.f33724a.getIntrinsicHeight() + bottom);
            this.f33724a.draw(canvas);
        }
    }
}
