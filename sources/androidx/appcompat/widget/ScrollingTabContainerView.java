package androidx.appcompat.widget;

import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.view.ActionBarPolicy;
import androidx.appcompat.widget.LinearLayoutCompat;

public class ScrollingTabContainerView extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {

    /* renamed from: k  reason: collision with root package name */
    private static final Interpolator f1356k = new DecelerateInterpolator();

    /* renamed from: b  reason: collision with root package name */
    Runnable f1357b;

    /* renamed from: c  reason: collision with root package name */
    private TabClickListener f1358c;

    /* renamed from: d  reason: collision with root package name */
    LinearLayoutCompat f1359d;

    /* renamed from: e  reason: collision with root package name */
    private Spinner f1360e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f1361f;

    /* renamed from: g  reason: collision with root package name */
    int f1362g;

    /* renamed from: h  reason: collision with root package name */
    int f1363h;

    /* renamed from: i  reason: collision with root package name */
    private int f1364i;

    /* renamed from: j  reason: collision with root package name */
    private int f1365j;

    private class TabAdapter extends BaseAdapter {
        TabAdapter() {
        }

        public int getCount() {
            return ScrollingTabContainerView.this.f1359d.getChildCount();
        }

        public Object getItem(int i2) {
            return ((TabView) ScrollingTabContainerView.this.f1359d.getChildAt(i2)).b();
        }

        public long getItemId(int i2) {
            return (long) i2;
        }

        public View getView(int i2, View view, ViewGroup viewGroup) {
            if (view == null) {
                return ScrollingTabContainerView.this.c((ActionBar.Tab) getItem(i2), true);
            }
            ((TabView) view).a((ActionBar.Tab) getItem(i2));
            return view;
        }
    }

    private class TabClickListener implements View.OnClickListener {
        TabClickListener() {
        }

        public void onClick(View view) {
            boolean z2;
            ((TabView) view).b().e();
            int childCount = ScrollingTabContainerView.this.f1359d.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = ScrollingTabContainerView.this.f1359d.getChildAt(i2);
                if (childAt == view) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                childAt.setSelected(z2);
            }
        }
    }

    private class TabView extends LinearLayout {

        /* renamed from: b  reason: collision with root package name */
        private final int[] f1370b;

        /* renamed from: c  reason: collision with root package name */
        private ActionBar.Tab f1371c;

        /* renamed from: d  reason: collision with root package name */
        private TextView f1372d;

        /* renamed from: e  reason: collision with root package name */
        private ImageView f1373e;

        /* renamed from: f  reason: collision with root package name */
        private View f1374f;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public TabView(android.content.Context r6, androidx.appcompat.app.ActionBar.Tab r7, boolean r8) {
            /*
                r4 = this;
                androidx.appcompat.widget.ScrollingTabContainerView.this = r5
                int r5 = androidx.appcompat.R$attr.f93d
                r0 = 0
                r4.<init>(r6, r0, r5)
                r1 = 1
                int[] r1 = new int[r1]
                r2 = 16842964(0x10100d4, float:2.3694152E-38)
                r3 = 0
                r1[r3] = r2
                r4.f1370b = r1
                r4.f1371c = r7
                androidx.appcompat.widget.TintTypedArray r5 = androidx.appcompat.widget.TintTypedArray.v(r6, r0, r1, r5, r3)
                boolean r6 = r5.s(r3)
                if (r6 == 0) goto L_0x0026
                android.graphics.drawable.Drawable r6 = r5.g(r3)
                r4.setBackgroundDrawable(r6)
            L_0x0026:
                r5.w()
                if (r8 == 0) goto L_0x0031
                r5 = 8388627(0x800013, float:1.175497E-38)
                r4.setGravity(r5)
            L_0x0031:
                r4.c()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ScrollingTabContainerView.TabView.<init>(androidx.appcompat.widget.ScrollingTabContainerView, android.content.Context, androidx.appcompat.app.ActionBar$Tab, boolean):void");
        }

        public void a(ActionBar.Tab tab) {
            this.f1371c = tab;
            c();
        }

        public ActionBar.Tab b() {
            return this.f1371c;
        }

        public void c() {
            ActionBar.Tab tab = this.f1371c;
            View b2 = tab.b();
            CharSequence charSequence = null;
            if (b2 != null) {
                ViewParent parent = b2.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(b2);
                    }
                    addView(b2);
                }
                this.f1374f = b2;
                TextView textView = this.f1372d;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.f1373e;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.f1373e.setImageDrawable((Drawable) null);
                    return;
                }
                return;
            }
            View view = this.f1374f;
            if (view != null) {
                removeView(view);
                this.f1374f = null;
            }
            Drawable c2 = tab.c();
            CharSequence d2 = tab.d();
            if (c2 != null) {
                if (this.f1373e == null) {
                    AppCompatImageView appCompatImageView = new AppCompatImageView(getContext());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    appCompatImageView.setLayoutParams(layoutParams);
                    addView(appCompatImageView, 0);
                    this.f1373e = appCompatImageView;
                }
                this.f1373e.setImageDrawable(c2);
                this.f1373e.setVisibility(0);
            } else {
                ImageView imageView2 = this.f1373e;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                    this.f1373e.setImageDrawable((Drawable) null);
                }
            }
            boolean z2 = !TextUtils.isEmpty(d2);
            if (z2) {
                if (this.f1372d == null) {
                    AppCompatTextView appCompatTextView = new AppCompatTextView(getContext(), (AttributeSet) null, R$attr.f94e);
                    appCompatTextView.setEllipsize(TextUtils.TruncateAt.END);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.gravity = 16;
                    appCompatTextView.setLayoutParams(layoutParams2);
                    addView(appCompatTextView);
                    this.f1372d = appCompatTextView;
                }
                this.f1372d.setText(d2);
                this.f1372d.setVisibility(0);
            } else {
                TextView textView2 = this.f1372d;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                    this.f1372d.setText((CharSequence) null);
                }
            }
            ImageView imageView3 = this.f1373e;
            if (imageView3 != null) {
                imageView3.setContentDescription(tab.a());
            }
            if (!z2) {
                charSequence = tab.a();
            }
            TooltipCompat.a(this, charSequence);
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        public void onMeasure(int i2, int i3) {
            int i4;
            super.onMeasure(i2, i3);
            if (ScrollingTabContainerView.this.f1362g > 0 && getMeasuredWidth() > (i4 = ScrollingTabContainerView.this.f1362g)) {
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(i4, 1073741824), i3);
            }
        }

        public void setSelected(boolean z2) {
            boolean z3;
            if (isSelected() != z2) {
                z3 = true;
            } else {
                z3 = false;
            }
            super.setSelected(z2);
            if (z3 && z2) {
                sendAccessibilityEvent(4);
            }
        }
    }

    private Spinner b() {
        AppCompatSpinner appCompatSpinner = new AppCompatSpinner(getContext(), (AttributeSet) null, R$attr.f97h);
        appCompatSpinner.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
        appCompatSpinner.setOnItemSelectedListener(this);
        return appCompatSpinner;
    }

    private boolean d() {
        Spinner spinner = this.f1360e;
        return spinner != null && spinner.getParent() == this;
    }

    private void e() {
        if (!d()) {
            if (this.f1360e == null) {
                this.f1360e = b();
            }
            removeView(this.f1359d);
            addView(this.f1360e, new ViewGroup.LayoutParams(-2, -1));
            if (this.f1360e.getAdapter() == null) {
                this.f1360e.setAdapter(new TabAdapter());
            }
            Runnable runnable = this.f1357b;
            if (runnable != null) {
                removeCallbacks(runnable);
                this.f1357b = null;
            }
            this.f1360e.setSelection(this.f1365j);
        }
    }

    private boolean f() {
        if (!d()) {
            return false;
        }
        removeView(this.f1360e);
        addView(this.f1359d, new ViewGroup.LayoutParams(-2, -1));
        setTabSelected(this.f1360e.getSelectedItemPosition());
        return false;
    }

    public void a(int i2) {
        final View childAt = this.f1359d.getChildAt(i2);
        Runnable runnable = this.f1357b;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        AnonymousClass1 r02 = new Runnable() {
            public void run() {
                ScrollingTabContainerView.this.smoothScrollTo(childAt.getLeft() - ((ScrollingTabContainerView.this.getWidth() - childAt.getWidth()) / 2), 0);
                ScrollingTabContainerView.this.f1357b = null;
            }
        };
        this.f1357b = r02;
        post(r02);
    }

    /* access modifiers changed from: package-private */
    public TabView c(ActionBar.Tab tab, boolean z2) {
        TabView tabView = new TabView(getContext(), tab, z2);
        if (z2) {
            tabView.setBackgroundDrawable((Drawable) null);
            tabView.setLayoutParams(new AbsListView.LayoutParams(-1, this.f1364i));
        } else {
            tabView.setFocusable(true);
            if (this.f1358c == null) {
                this.f1358c = new TabClickListener();
            }
            tabView.setOnClickListener(this.f1358c);
        }
        return tabView;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Runnable runnable = this.f1357b;
        if (runnable != null) {
            post(runnable);
        }
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ActionBarPolicy b2 = ActionBarPolicy.b(getContext());
        setContentHeight(b2.f());
        this.f1363h = b2.e();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.f1357b;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j2) {
        ((TabView) view).b().e();
    }

    public void onMeasure(int i2, int i3) {
        boolean z2;
        int mode = View.MeasureSpec.getMode(i2);
        boolean z3 = true;
        if (mode == 1073741824) {
            z2 = true;
        } else {
            z2 = false;
        }
        setFillViewport(z2);
        int childCount = this.f1359d.getChildCount();
        if (childCount <= 1 || !(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            this.f1362g = -1;
        } else {
            if (childCount > 2) {
                this.f1362g = (int) (((float) View.MeasureSpec.getSize(i2)) * 0.4f);
            } else {
                this.f1362g = View.MeasureSpec.getSize(i2) / 2;
            }
            this.f1362g = Math.min(this.f1362g, this.f1363h);
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f1364i, 1073741824);
        if (z2 || !this.f1361f) {
            z3 = false;
        }
        if (z3) {
            this.f1359d.measure(0, makeMeasureSpec);
            if (this.f1359d.getMeasuredWidth() > View.MeasureSpec.getSize(i2)) {
                e();
            } else {
                f();
            }
        } else {
            f();
        }
        int measuredWidth = getMeasuredWidth();
        super.onMeasure(i2, makeMeasureSpec);
        int measuredWidth2 = getMeasuredWidth();
        if (z2 && measuredWidth != measuredWidth2) {
            setTabSelected(this.f1365j);
        }
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void setAllowCollapse(boolean z2) {
        this.f1361f = z2;
    }

    public void setContentHeight(int i2) {
        this.f1364i = i2;
        requestLayout();
    }

    public void setTabSelected(int i2) {
        boolean z2;
        this.f1365j = i2;
        int childCount = this.f1359d.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = this.f1359d.getChildAt(i3);
            if (i3 == i2) {
                z2 = true;
            } else {
                z2 = false;
            }
            childAt.setSelected(z2);
            if (z2) {
                a(i2);
            }
        }
        Spinner spinner = this.f1360e;
        if (spinner != null && i2 >= 0) {
            spinner.setSelection(i2);
        }
    }
}
