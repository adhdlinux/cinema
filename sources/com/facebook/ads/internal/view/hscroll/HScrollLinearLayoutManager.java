package com.facebook.ads.internal.view.hscroll;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

public class HScrollLinearLayoutManager extends LinearLayoutManager {

    /* renamed from: a  reason: collision with root package name */
    private final c f21590a;

    /* renamed from: b  reason: collision with root package name */
    private final a f21591b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f21592c;

    /* renamed from: d  reason: collision with root package name */
    private int[] f21593d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public int f21594e = 0;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public float f21595f = 50.0f;

    /* renamed from: g  reason: collision with root package name */
    private a f21596g;

    /* renamed from: h  reason: collision with root package name */
    private int f21597h;

    private class a extends LinearSmoothScroller {
        public a(Context context) {
            super(context);
        }

        public int calculateDxToMakeVisible(View view, int i2) {
            RecyclerView.LayoutManager layoutManager = getLayoutManager();
            if (!layoutManager.canScrollHorizontally()) {
                return 0;
            }
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return calculateDtToFit(layoutManager.getDecoratedLeft(view) - layoutParams.leftMargin, layoutManager.getDecoratedRight(view) + layoutParams.rightMargin, layoutManager.getPaddingLeft(), layoutManager.getWidth() - layoutManager.getPaddingRight(), i2) + HScrollLinearLayoutManager.this.f21594e;
        }

        /* access modifiers changed from: protected */
        public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
            return HScrollLinearLayoutManager.this.f21595f / ((float) displayMetrics.densityDpi);
        }

        public PointF computeScrollVectorForPosition(int i2) {
            return HScrollLinearLayoutManager.this.computeScrollVectorForPosition(i2);
        }

        /* access modifiers changed from: protected */
        public int getHorizontalSnapPreference() {
            return -1;
        }
    }

    public HScrollLinearLayoutManager(Context context, c cVar, a aVar) {
        super(context);
        this.f21592c = context;
        this.f21590a = cVar;
        this.f21591b = aVar;
        this.f21597h = -1;
        this.f21596g = new a(context);
    }

    public void a(double d2) {
        if (d2 <= 0.0d) {
            d2 = 1.0d;
        }
        this.f21595f = (float) (50.0d / d2);
        this.f21596g = new a(this.f21592c);
    }

    /* access modifiers changed from: package-private */
    public void a(int i2) {
        this.f21597h = i2;
    }

    public void b(int i2) {
        this.f21594e = i2;
    }

    public void onMeasure(RecyclerView.Recycler recycler, RecyclerView.State state, int i2, int i3) {
        int[] iArr;
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        if ((mode == 1073741824 && getOrientation() == 1) || (mode2 == 1073741824 && getOrientation() == 0)) {
            super.onMeasure(recycler, state, i2, i3);
            return;
        }
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        if (this.f21591b.b(this.f21597h)) {
            iArr = this.f21591b.a(this.f21597h);
        } else {
            int[] iArr2 = {0, 0};
            if (state.b() >= 1) {
                int childCount = getChildCount() > 0 ? 1 : getChildCount();
                for (int i4 = 0; i4 < childCount; i4++) {
                    this.f21593d = this.f21590a.a(findViewByPosition(i4), View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                    if (getOrientation() == 0) {
                        int i5 = iArr2[0];
                        int[] iArr3 = this.f21593d;
                        iArr2[0] = i5 + iArr3[0];
                        if (i4 == 0) {
                            iArr2[1] = iArr3[1] + getPaddingTop() + getPaddingBottom();
                        }
                    } else {
                        int i6 = iArr2[1];
                        int[] iArr4 = this.f21593d;
                        iArr2[1] = i6 + iArr4[1];
                        if (i4 == 0) {
                            iArr2[0] = iArr4[0] + getPaddingLeft() + getPaddingRight();
                        }
                    }
                }
                int i7 = this.f21597h;
                if (i7 != -1) {
                    this.f21591b.a(i7, iArr2);
                }
            }
            iArr = iArr2;
        }
        if (mode == 1073741824) {
            iArr[0] = size;
        }
        if (mode2 == 1073741824) {
            iArr[1] = size2;
        }
        setMeasuredDimension(iArr[0], iArr[1]);
    }

    public void scrollToPosition(int i2) {
        super.scrollToPositionWithOffset(i2, this.f21594e);
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i2) {
        this.f21596g.setTargetPosition(i2);
        startSmoothScroll(this.f21596g);
    }
}
