package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class DividerItemDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f11108d = {16843284};

    /* renamed from: a  reason: collision with root package name */
    private Drawable f11109a;

    /* renamed from: b  reason: collision with root package name */
    private int f11110b;

    /* renamed from: c  reason: collision with root package name */
    private final Rect f11111c = new Rect();

    @SuppressLint({"UnknownNullness"})
    public DividerItemDecoration(Context context, int i2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(f11108d);
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        this.f11109a = drawable;
        if (drawable == null) {
            Log.w("DividerItem", "@android:attr/listDivider was not set in the theme used for this DividerItemDecoration. Please set that attribute all call setDrawable()");
        }
        obtainStyledAttributes.recycle();
        l(i2);
    }

    private void j(Canvas canvas, RecyclerView recyclerView) {
        int i2;
        int i3;
        canvas.save();
        if (recyclerView.getClipToPadding()) {
            i3 = recyclerView.getPaddingTop();
            i2 = recyclerView.getHeight() - recyclerView.getPaddingBottom();
            canvas.clipRect(recyclerView.getPaddingLeft(), i3, recyclerView.getWidth() - recyclerView.getPaddingRight(), i2);
        } else {
            i2 = recyclerView.getHeight();
            i3 = 0;
        }
        int childCount = recyclerView.getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = recyclerView.getChildAt(i4);
            recyclerView.getLayoutManager().getDecoratedBoundsWithMargins(childAt, this.f11111c);
            int round = this.f11111c.right + Math.round(childAt.getTranslationX());
            this.f11109a.setBounds(round - this.f11109a.getIntrinsicWidth(), i3, round, i2);
            this.f11109a.draw(canvas);
        }
        canvas.restore();
    }

    private void k(Canvas canvas, RecyclerView recyclerView) {
        int i2;
        int i3;
        canvas.save();
        if (recyclerView.getClipToPadding()) {
            i3 = recyclerView.getPaddingLeft();
            i2 = recyclerView.getWidth() - recyclerView.getPaddingRight();
            canvas.clipRect(i3, recyclerView.getPaddingTop(), i2, recyclerView.getHeight() - recyclerView.getPaddingBottom());
        } else {
            i2 = recyclerView.getWidth();
            i3 = 0;
        }
        int childCount = recyclerView.getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = recyclerView.getChildAt(i4);
            recyclerView.getDecoratedBoundsWithMargins(childAt, this.f11111c);
            int round = this.f11111c.bottom + Math.round(childAt.getTranslationY());
            this.f11109a.setBounds(i3, round - this.f11109a.getIntrinsicHeight(), i2, round);
            this.f11109a.draw(canvas);
        }
        canvas.restore();
    }

    @SuppressLint({"UnknownNullness"})
    public void e(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        Drawable drawable = this.f11109a;
        if (drawable == null) {
            rect.set(0, 0, 0, 0);
        } else if (this.f11110b == 1) {
            rect.set(0, 0, 0, drawable.getIntrinsicHeight());
        } else {
            rect.set(0, 0, drawable.getIntrinsicWidth(), 0);
        }
    }

    @SuppressLint({"UnknownNullness"})
    public void g(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        if (recyclerView.getLayoutManager() != null && this.f11109a != null) {
            if (this.f11110b == 1) {
                k(canvas, recyclerView);
            } else {
                j(canvas, recyclerView);
            }
        }
    }

    public void l(int i2) {
        if (i2 == 0 || i2 == 1) {
            this.f11110b = i2;
            return;
        }
        throw new IllegalArgumentException("Invalid orientation. It should be either HORIZONTAL or VERTICAL");
    }
}
