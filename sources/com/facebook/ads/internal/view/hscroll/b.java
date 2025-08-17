package com.facebook.ads.internal.view.hscroll;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.ads.internal.view.hscroll.d;

public class b extends d implements d.a {

    /* renamed from: c  reason: collision with root package name */
    private final HScrollLinearLayoutManager f21600c;

    /* renamed from: d  reason: collision with root package name */
    private a f21601d;

    /* renamed from: e  reason: collision with root package name */
    private int f21602e = -1;

    /* renamed from: f  reason: collision with root package name */
    private int f21603f = -1;

    /* renamed from: g  reason: collision with root package name */
    private int f21604g = 0;

    /* renamed from: h  reason: collision with root package name */
    private int f21605h = 0;

    public interface a {
        void a(int i2, int i3);
    }

    public b(Context context) {
        super(context);
        this.f21600c = new HScrollLinearLayoutManager(context, new c(), new a());
        a();
    }

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21600c = new HScrollLinearLayoutManager(context, new c(), new a());
        a();
    }

    public b(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f21600c = new HScrollLinearLayoutManager(context, new c(), new a());
        a();
    }

    private void a() {
        this.f21600c.setOrientation(0);
        setLayoutManager(this.f21600c);
        setSaveEnabled(false);
        setSnapDelegate(this);
    }

    private void a(int i2, int i3) {
        if (i2 != this.f21602e || i3 != this.f21603f) {
            this.f21602e = i2;
            this.f21603f = i3;
            a aVar = this.f21601d;
            if (aVar != null) {
                aVar.a(i2, i3);
            }
        }
    }

    private int b(int i2) {
        int i3 = this.f21605h * 2;
        int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - i3;
        int itemCount = getAdapter().getItemCount();
        int i4 = 0;
        int i5 = Integer.MAX_VALUE;
        while (i5 > i2) {
            i4++;
            if (i4 >= itemCount) {
                return i2;
            }
            i5 = (int) (((float) (measuredWidth - (i4 * i3))) / (((float) i4) + 0.333f));
        }
        return i5;
    }

    public int a(int i2) {
        int abs = Math.abs(i2);
        if (abs <= this.f21606a) {
            return 0;
        }
        int i3 = this.f21604g;
        if (i3 == 0) {
            return 1;
        }
        return 1 + (abs / i3);
    }

    /* access modifiers changed from: protected */
    public void a(int i2, boolean z2) {
        super.a(i2, z2);
        a(i2, 0);
    }

    public int getChildSpacing() {
        return this.f21605h;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int round = Math.round(((float) getMeasuredWidth()) / 1.91f);
        int mode = View.MeasureSpec.getMode(i3);
        if (mode == Integer.MIN_VALUE) {
            round = Math.min(View.MeasureSpec.getSize(i3), round);
        } else if (mode == 1073741824) {
            round = View.MeasureSpec.getSize(i3);
        }
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int b2 = b(round - paddingTop);
        setMeasuredDimension(getMeasuredWidth(), paddingTop + b2);
        setChildWidth(b2 + (this.f21605h * 2));
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        this.f21600c.a(adapter == null ? -1 : adapter.hashCode());
        super.setAdapter(adapter);
    }

    public void setChildSpacing(int i2) {
        this.f21605h = i2;
    }

    public void setChildWidth(int i2) {
        this.f21604g = i2;
        int measuredWidth = getMeasuredWidth();
        this.f21600c.b((((measuredWidth - getPaddingLeft()) - getPaddingRight()) - this.f21604g) / 2);
        this.f21600c.a(((double) this.f21604g) / ((double) measuredWidth));
    }

    public void setCurrentPosition(int i2) {
        a(i2, false);
    }

    public void setOnPageChangedListener(a aVar) {
        this.f21601d = aVar;
    }
}
