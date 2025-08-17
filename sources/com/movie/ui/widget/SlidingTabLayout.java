package com.movie.ui.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class SlidingTabLayout extends HorizontalScrollView {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final SlidingTabStrip f33656b;

    /* renamed from: c  reason: collision with root package name */
    private int f33657c;

    /* renamed from: d  reason: collision with root package name */
    private int f33658d;

    /* renamed from: e  reason: collision with root package name */
    private int f33659e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public ViewPager f33660f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public ViewPager.OnPageChangeListener f33661g;

    private class InternalViewPagerListener implements ViewPager.OnPageChangeListener {

        /* renamed from: a  reason: collision with root package name */
        private int f33662a;

        private InternalViewPagerListener() {
        }

        public void a(int i2, float f2, int i3) {
            int i4;
            int childCount = SlidingTabLayout.this.f33656b.getChildCount();
            if (childCount != 0 && i2 >= 0 && i2 < childCount) {
                SlidingTabLayout.this.f33656b.b(i2, f2);
                View childAt = SlidingTabLayout.this.f33656b.getChildAt(i2);
                if (childAt != null) {
                    i4 = (int) (((float) childAt.getWidth()) * f2);
                } else {
                    i4 = 0;
                }
                SlidingTabLayout.this.h(i2, i4);
                if (SlidingTabLayout.this.f33661g != null) {
                    SlidingTabLayout.this.f33661g.a(i2, f2, i3);
                }
            }
        }

        public void b(int i2) {
            this.f33662a = i2;
            if (SlidingTabLayout.this.f33661g != null) {
                SlidingTabLayout.this.f33661g.b(i2);
            }
        }

        public void c(int i2) {
            if (this.f33662a == 0) {
                SlidingTabLayout.this.f33656b.b(i2, 0.0f);
                SlidingTabLayout.this.h(i2, 0);
            }
            if (SlidingTabLayout.this.f33661g != null) {
                SlidingTabLayout.this.f33661g.c(i2);
            }
        }
    }

    public interface OnTabClickListener {
    }

    private class TabClickListener implements View.OnClickListener {
        private TabClickListener() {
        }

        public void onClick(View view) {
            for (int i2 = 0; i2 < SlidingTabLayout.this.f33656b.getChildCount(); i2++) {
                if (view == SlidingTabLayout.this.f33656b.getChildAt(i2)) {
                    OnTabClickListener unused = SlidingTabLayout.this.getClass();
                    SlidingTabLayout.this.f33660f.setCurrentItem(i2);
                    return;
                }
            }
        }
    }

    public interface TabColorizer {
        int a(int i2);
    }

    public SlidingTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void g() {
        TextView textView;
        View view;
        PagerAdapter adapter = this.f33660f.getAdapter();
        TabClickListener tabClickListener = new TabClickListener();
        int i2 = 0;
        while (i2 < adapter.getCount()) {
            if (this.f33658d != 0) {
                view = LayoutInflater.from(getContext()).inflate(this.f33658d, this.f33656b, false);
                textView = (TextView) view.findViewById(this.f33659e);
            } else {
                view = null;
                textView = null;
            }
            if (view == null) {
                view = f(getContext());
            }
            if (textView == null && TextView.class.isInstance(view)) {
                textView = (TextView) view;
            }
            if (textView != null) {
                textView.setText(adapter.getPageTitle(i2));
                view.setOnClickListener(tabClickListener);
                this.f33656b.addView(view);
                i2++;
            } else {
                throw new IllegalArgumentException("tabTitleView == null");
            }
        }
    }

    /* access modifiers changed from: private */
    public void h(int i2, int i3) {
        View childAt;
        int childCount = this.f33656b.getChildCount();
        if (childCount != 0 && i2 >= 0 && i2 < childCount && (childAt = this.f33656b.getChildAt(i2)) != null) {
            int left = childAt.getLeft() + i3;
            if (i2 > 0 || i3 > 0) {
                left -= this.f33657c;
            }
            scrollTo(left, 0);
        }
    }

    /* access modifiers changed from: protected */
    public TextView f(Context context) {
        TextView textView = new TextView(context);
        textView.setGravity(17);
        textView.setTextSize(2, 12.0f);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        TypedValue typedValue = new TypedValue();
        getContext().getTheme().resolveAttribute(16843534, typedValue, true);
        textView.setBackgroundResource(typedValue.resourceId);
        textView.setAllCaps(true);
        int i2 = (int) (getResources().getDisplayMetrics().density * 16.0f);
        textView.setPadding(i2, i2, i2, i2);
        return textView;
    }

    public void i(int i2, int i3) {
        this.f33658d = i2;
        this.f33659e = i3;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewPager viewPager = this.f33660f;
        if (viewPager != null) {
            h(viewPager.getCurrentItem(), 0);
        }
    }

    public void setCustomTabColorizer(TabColorizer tabColorizer) {
        this.f33656b.c(tabColorizer);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.f33661g = onPageChangeListener;
    }

    public void setOnTabClickListener(OnTabClickListener onTabClickListener) {
    }

    public void setSelectedIndicatorColors(int... iArr) {
        this.f33656b.d(iArr);
    }

    public void setViewPager(ViewPager viewPager) {
        this.f33656b.removeAllViews();
        this.f33660f = viewPager;
        if (viewPager != null) {
            viewPager.setOnPageChangeListener(new InternalViewPagerListener());
            g();
        }
    }

    public SlidingTabLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        setHorizontalScrollBarEnabled(false);
        setFillViewport(true);
        this.f33657c = (int) (getResources().getDisplayMetrics().density * 24.0f);
        SlidingTabStrip slidingTabStrip = new SlidingTabStrip(context);
        this.f33656b = slidingTabStrip;
        addView(slidingTabStrip, -1, -2);
    }
}
