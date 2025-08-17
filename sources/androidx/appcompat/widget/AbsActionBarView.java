package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$styleable;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;

abstract class AbsActionBarView extends ViewGroup {

    /* renamed from: b  reason: collision with root package name */
    protected final VisibilityAnimListener f953b;

    /* renamed from: c  reason: collision with root package name */
    protected final Context f954c;

    /* renamed from: d  reason: collision with root package name */
    protected ActionMenuView f955d;

    /* renamed from: e  reason: collision with root package name */
    protected ActionMenuPresenter f956e;

    /* renamed from: f  reason: collision with root package name */
    protected int f957f;

    /* renamed from: g  reason: collision with root package name */
    protected ViewPropertyAnimatorCompat f958g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f959h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f960i;

    protected class VisibilityAnimListener implements ViewPropertyAnimatorListener {

        /* renamed from: a  reason: collision with root package name */
        private boolean f961a = false;

        /* renamed from: b  reason: collision with root package name */
        int f962b;

        protected VisibilityAnimListener() {
        }

        public void a(View view) {
            this.f961a = true;
        }

        public void b(View view) {
            if (!this.f961a) {
                AbsActionBarView absActionBarView = AbsActionBarView.this;
                absActionBarView.f958g = null;
                AbsActionBarView.super.setVisibility(this.f962b);
            }
        }

        public void c(View view) {
            AbsActionBarView.super.setVisibility(0);
            this.f961a = false;
        }

        public VisibilityAnimListener d(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, int i2) {
            AbsActionBarView.this.f958g = viewPropertyAnimatorCompat;
            this.f962b = i2;
            return this;
        }
    }

    AbsActionBarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    protected static int d(int i2, int i3, boolean z2) {
        return z2 ? i2 - i3 : i2 + i3;
    }

    /* access modifiers changed from: protected */
    public int c(View view, int i2, int i3, int i4) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i2, Integer.MIN_VALUE), i3);
        return Math.max(0, (i2 - view.getMeasuredWidth()) - i4);
    }

    /* access modifiers changed from: protected */
    public int e(View view, int i2, int i3, int i4, boolean z2) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i5 = i3 + ((i4 - measuredHeight) / 2);
        if (z2) {
            view.layout(i2 - measuredWidth, i5, i2, measuredHeight + i5);
        } else {
            view.layout(i2, i5, i2 + measuredWidth, measuredHeight + i5);
        }
        if (z2) {
            return -measuredWidth;
        }
        return measuredWidth;
    }

    public ViewPropertyAnimatorCompat f(int i2, long j2) {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.f958g;
        if (viewPropertyAnimatorCompat != null) {
            viewPropertyAnimatorCompat.c();
        }
        if (i2 == 0) {
            if (getVisibility() != 0) {
                setAlpha(0.0f);
            }
            ViewPropertyAnimatorCompat b2 = ViewCompat.d(this).b(1.0f);
            b2.f(j2);
            b2.h(this.f953b.d(b2, i2));
            return b2;
        }
        ViewPropertyAnimatorCompat b3 = ViewCompat.d(this).b(0.0f);
        b3.f(j2);
        b3.h(this.f953b.d(b3, i2));
        return b3;
    }

    public int getAnimatedVisibility() {
        if (this.f958g != null) {
            return this.f953b.f962b;
        }
        return getVisibility();
    }

    public int getContentHeight() {
        return this.f957f;
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes((AttributeSet) null, R$styleable.f235a, R$attr.f92c, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(R$styleable.f262j, 0));
        obtainStyledAttributes.recycle();
        ActionMenuPresenter actionMenuPresenter = this.f956e;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.I(configuration);
        }
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f960i = false;
        }
        if (!this.f960i) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.f960i = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f960i = false;
        }
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f959h = false;
        }
        if (!this.f959h) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.f959h = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f959h = false;
        }
        return true;
    }

    public void setContentHeight(int i2) {
        this.f957f = i2;
        requestLayout();
    }

    public void setVisibility(int i2) {
        if (i2 != getVisibility()) {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.f958g;
            if (viewPropertyAnimatorCompat != null) {
                viewPropertyAnimatorCompat.c();
            }
            super.setVisibility(i2);
        }
    }

    AbsActionBarView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f953b = new VisibilityAnimListener();
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(R$attr.f90a, typedValue, true) || typedValue.resourceId == 0) {
            this.f954c = context;
        } else {
            this.f954c = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }
}
