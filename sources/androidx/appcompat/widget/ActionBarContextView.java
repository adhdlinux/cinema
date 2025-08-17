package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;

public class ActionBarContextView extends AbsActionBarView {

    /* renamed from: j  reason: collision with root package name */
    private CharSequence f975j;

    /* renamed from: k  reason: collision with root package name */
    private CharSequence f976k;

    /* renamed from: l  reason: collision with root package name */
    private View f977l;

    /* renamed from: m  reason: collision with root package name */
    private View f978m;

    /* renamed from: n  reason: collision with root package name */
    private View f979n;

    /* renamed from: o  reason: collision with root package name */
    private LinearLayout f980o;

    /* renamed from: p  reason: collision with root package name */
    private TextView f981p;

    /* renamed from: q  reason: collision with root package name */
    private TextView f982q;

    /* renamed from: r  reason: collision with root package name */
    private int f983r;

    /* renamed from: s  reason: collision with root package name */
    private int f984s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f985t;

    /* renamed from: u  reason: collision with root package name */
    private int f986u;

    public ActionBarContextView(Context context) {
        this(context, (AttributeSet) null);
    }

    private void i() {
        int i2;
        if (this.f980o == null) {
            LayoutInflater.from(getContext()).inflate(R$layout.f192a, this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f980o = linearLayout;
            this.f981p = (TextView) linearLayout.findViewById(R$id.f170e);
            this.f982q = (TextView) this.f980o.findViewById(R$id.f169d);
            if (this.f983r != 0) {
                this.f981p.setTextAppearance(getContext(), this.f983r);
            }
            if (this.f984s != 0) {
                this.f982q.setTextAppearance(getContext(), this.f984s);
            }
        }
        this.f981p.setText(this.f975j);
        this.f982q.setText(this.f976k);
        boolean z2 = !TextUtils.isEmpty(this.f975j);
        boolean z3 = !TextUtils.isEmpty(this.f976k);
        TextView textView = this.f982q;
        int i3 = 0;
        if (z3) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        textView.setVisibility(i2);
        LinearLayout linearLayout2 = this.f980o;
        if (!z2 && !z3) {
            i3 = 8;
        }
        linearLayout2.setVisibility(i3);
        if (this.f980o.getParent() == null) {
            addView(this.f980o);
        }
    }

    public /* bridge */ /* synthetic */ ViewPropertyAnimatorCompat f(int i2, long j2) {
        return super.f(i2, j2);
    }

    public void g() {
        if (this.f977l == null) {
            k();
        }
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public CharSequence getSubtitle() {
        return this.f976k;
    }

    public CharSequence getTitle() {
        return this.f975j;
    }

    public void h(final ActionMode actionMode) {
        View view = this.f977l;
        if (view == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(this.f986u, this, false);
            this.f977l = inflate;
            addView(inflate);
        } else if (view.getParent() == null) {
            addView(this.f977l);
        }
        View findViewById = this.f977l.findViewById(R$id.f174i);
        this.f978m = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                actionMode.c();
            }
        });
        MenuBuilder menuBuilder = (MenuBuilder) actionMode.e();
        ActionMenuPresenter actionMenuPresenter = this.f956e;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.B();
        }
        ActionMenuPresenter actionMenuPresenter2 = new ActionMenuPresenter(getContext());
        this.f956e = actionMenuPresenter2;
        actionMenuPresenter2.M(true);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        menuBuilder.c(this.f956e, this.f954c);
        ActionMenuView actionMenuView = (ActionMenuView) this.f956e.r(this);
        this.f955d = actionMenuView;
        ViewCompat.v0(actionMenuView, (Drawable) null);
        addView(this.f955d, layoutParams);
    }

    public boolean j() {
        return this.f985t;
    }

    public void k() {
        removeAllViews();
        this.f979n = null;
        this.f955d = null;
        this.f956e = null;
        View view = this.f978m;
        if (view != null) {
            view.setOnClickListener((View.OnClickListener) null);
        }
    }

    public boolean l() {
        ActionMenuPresenter actionMenuPresenter = this.f956e;
        if (actionMenuPresenter != null) {
            return actionMenuPresenter.N();
        }
        return false;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ActionMenuPresenter actionMenuPresenter = this.f956e;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.E();
            this.f956e.F();
        }
    }

    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        boolean b2 = ViewUtils.b(this);
        if (b2) {
            i6 = (i4 - i2) - getPaddingRight();
        } else {
            i6 = getPaddingLeft();
        }
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i5 - i3) - getPaddingTop()) - getPaddingBottom();
        View view = this.f977l;
        if (!(view == null || view.getVisibility() == 8)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f977l.getLayoutParams();
            if (b2) {
                i8 = marginLayoutParams.rightMargin;
            } else {
                i8 = marginLayoutParams.leftMargin;
            }
            if (b2) {
                i9 = marginLayoutParams.leftMargin;
            } else {
                i9 = marginLayoutParams.rightMargin;
            }
            int d2 = AbsActionBarView.d(i6, i8, b2);
            i6 = AbsActionBarView.d(d2 + e(this.f977l, d2, paddingTop, paddingTop2, b2), i9, b2);
        }
        int i10 = i6;
        LinearLayout linearLayout = this.f980o;
        if (!(linearLayout == null || this.f979n != null || linearLayout.getVisibility() == 8)) {
            i10 += e(this.f980o, i10, paddingTop, paddingTop2, b2);
        }
        int i11 = i10;
        View view2 = this.f979n;
        if (view2 != null) {
            e(view2, i11, paddingTop, paddingTop2, b2);
        }
        if (b2) {
            i7 = getPaddingLeft();
        } else {
            i7 = (i4 - i2) - getPaddingRight();
        }
        ActionMenuView actionMenuView = this.f955d;
        if (actionMenuView != null) {
            e(actionMenuView, i7, paddingTop, paddingTop2, !b2);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int i4;
        boolean z2;
        int i5;
        int i6 = 1073741824;
        if (View.MeasureSpec.getMode(i2) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
        } else if (View.MeasureSpec.getMode(i3) != 0) {
            int size = View.MeasureSpec.getSize(i2);
            int i7 = this.f957f;
            if (i7 <= 0) {
                i7 = View.MeasureSpec.getSize(i3);
            }
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
            int i8 = i7 - paddingTop;
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i8, Integer.MIN_VALUE);
            View view = this.f977l;
            if (view != null) {
                int c2 = c(view, paddingLeft, makeMeasureSpec, 0);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f977l.getLayoutParams();
                paddingLeft = c2 - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
            }
            ActionMenuView actionMenuView = this.f955d;
            if (actionMenuView != null && actionMenuView.getParent() == this) {
                paddingLeft = c(this.f955d, paddingLeft, makeMeasureSpec, 0);
            }
            LinearLayout linearLayout = this.f980o;
            if (linearLayout != null && this.f979n == null) {
                if (this.f985t) {
                    this.f980o.measure(View.MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                    int measuredWidth = this.f980o.getMeasuredWidth();
                    if (measuredWidth <= paddingLeft) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        paddingLeft -= measuredWidth;
                    }
                    LinearLayout linearLayout2 = this.f980o;
                    if (z2) {
                        i5 = 0;
                    } else {
                        i5 = 8;
                    }
                    linearLayout2.setVisibility(i5);
                } else {
                    paddingLeft = c(linearLayout, paddingLeft, makeMeasureSpec, 0);
                }
            }
            View view2 = this.f979n;
            if (view2 != null) {
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                int i9 = layoutParams.width;
                if (i9 != -2) {
                    i4 = 1073741824;
                } else {
                    i4 = Integer.MIN_VALUE;
                }
                if (i9 >= 0) {
                    paddingLeft = Math.min(i9, paddingLeft);
                }
                int i10 = layoutParams.height;
                if (i10 == -2) {
                    i6 = Integer.MIN_VALUE;
                }
                if (i10 >= 0) {
                    i8 = Math.min(i10, i8);
                }
                this.f979n.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i4), View.MeasureSpec.makeMeasureSpec(i8, i6));
            }
            if (this.f957f <= 0) {
                int childCount = getChildCount();
                int i11 = 0;
                for (int i12 = 0; i12 < childCount; i12++) {
                    int measuredHeight = getChildAt(i12).getMeasuredHeight() + paddingTop;
                    if (measuredHeight > i11) {
                        i11 = measuredHeight;
                    }
                }
                setMeasuredDimension(size, i11);
                return;
            }
            setMeasuredDimension(size, i7);
        } else {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
        }
    }

    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setContentHeight(int i2) {
        this.f957f = i2;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.f979n;
        if (view2 != null) {
            removeView(view2);
        }
        this.f979n = view;
        if (!(view == null || (linearLayout = this.f980o) == null)) {
            removeView(linearLayout);
            this.f980o = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f976k = charSequence;
        i();
    }

    public void setTitle(CharSequence charSequence) {
        this.f975j = charSequence;
        i();
        ViewCompat.u0(this, charSequence);
    }

    public void setTitleOptional(boolean z2) {
        if (z2 != this.f985t) {
            requestLayout();
        }
        this.f985t = z2;
    }

    public /* bridge */ /* synthetic */ void setVisibility(int i2) {
        super.setVisibility(i2);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.f99j);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        TintTypedArray v2 = TintTypedArray.v(context, attributeSet, R$styleable.f302y, i2, 0);
        ViewCompat.v0(this, v2.g(R$styleable.f304z));
        this.f983r = v2.n(R$styleable.D, 0);
        this.f984s = v2.n(R$styleable.C, 0);
        this.f957f = v2.m(R$styleable.B, 0);
        this.f986u = v2.n(R$styleable.A, R$layout.f195d);
        v2.w();
    }
}
