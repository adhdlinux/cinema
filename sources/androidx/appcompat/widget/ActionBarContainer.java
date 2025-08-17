package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.R$id;
import androidx.appcompat.R$styleable;
import androidx.core.view.ViewCompat;
import com.google.ar.core.ImageMetadata;

public class ActionBarContainer extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    private boolean f965b;

    /* renamed from: c  reason: collision with root package name */
    private View f966c;

    /* renamed from: d  reason: collision with root package name */
    private View f967d;

    /* renamed from: e  reason: collision with root package name */
    private View f968e;

    /* renamed from: f  reason: collision with root package name */
    Drawable f969f;

    /* renamed from: g  reason: collision with root package name */
    Drawable f970g;

    /* renamed from: h  reason: collision with root package name */
    Drawable f971h;

    /* renamed from: i  reason: collision with root package name */
    boolean f972i;

    /* renamed from: j  reason: collision with root package name */
    boolean f973j;

    /* renamed from: k  reason: collision with root package name */
    private int f974k;

    private static class Api21Impl {
        private Api21Impl() {
        }

        public static void a(ActionBarContainer actionBarContainer) {
            actionBarContainer.invalidateOutline();
        }
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ViewCompat.v0(this, new ActionBarBackgroundDrawable(this));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f235a);
        this.f969f = obtainStyledAttributes.getDrawable(R$styleable.f238b);
        this.f970g = obtainStyledAttributes.getDrawable(R$styleable.f244d);
        this.f974k = obtainStyledAttributes.getDimensionPixelSize(R$styleable.f262j, -1);
        boolean z2 = true;
        if (getId() == R$id.N) {
            this.f972i = true;
            this.f971h = obtainStyledAttributes.getDrawable(R$styleable.f241c);
        }
        obtainStyledAttributes.recycle();
        if (!this.f972i ? !(this.f969f == null && this.f970g == null) : this.f971h != null) {
            z2 = false;
        }
        setWillNotDraw(z2);
    }

    private int a(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    private boolean b(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f969f;
        if (drawable != null && drawable.isStateful()) {
            this.f969f.setState(getDrawableState());
        }
        Drawable drawable2 = this.f970g;
        if (drawable2 != null && drawable2.isStateful()) {
            this.f970g.setState(getDrawableState());
        }
        Drawable drawable3 = this.f971h;
        if (drawable3 != null && drawable3.isStateful()) {
            this.f971h.setState(getDrawableState());
        }
    }

    public View getTabContainer() {
        return this.f966c;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f969f;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f970g;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.f971h;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.f967d = findViewById(R$id.f166a);
        this.f968e = findViewById(R$id.f171f);
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f965b || super.onInterceptTouchEvent(motionEvent);
    }

    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        boolean z3;
        Drawable drawable;
        super.onLayout(z2, i2, i3, i4, i5);
        View view = this.f966c;
        boolean z4 = true;
        boolean z5 = false;
        if (view == null || view.getVisibility() == 8) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (!(view == null || view.getVisibility() == 8)) {
            int measuredHeight = getMeasuredHeight();
            int i6 = ((FrameLayout.LayoutParams) view.getLayoutParams()).bottomMargin;
            view.layout(i2, (measuredHeight - view.getMeasuredHeight()) - i6, i4, measuredHeight - i6);
        }
        if (this.f972i) {
            Drawable drawable2 = this.f971h;
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            } else {
                z4 = false;
            }
        } else {
            if (this.f969f != null) {
                if (this.f967d.getVisibility() == 0) {
                    this.f969f.setBounds(this.f967d.getLeft(), this.f967d.getTop(), this.f967d.getRight(), this.f967d.getBottom());
                } else {
                    View view2 = this.f968e;
                    if (view2 == null || view2.getVisibility() != 0) {
                        this.f969f.setBounds(0, 0, 0, 0);
                    } else {
                        this.f969f.setBounds(this.f968e.getLeft(), this.f968e.getTop(), this.f968e.getRight(), this.f968e.getBottom());
                    }
                }
                z5 = true;
            }
            this.f973j = z3;
            if (!z3 || (drawable = this.f970g) == null) {
                z4 = z5;
            } else {
                drawable.setBounds(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
        }
        if (z4) {
            invalidate();
        }
    }

    public void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        if (this.f967d == null && View.MeasureSpec.getMode(i3) == Integer.MIN_VALUE && (i6 = this.f974k) >= 0) {
            i3 = View.MeasureSpec.makeMeasureSpec(Math.min(i6, View.MeasureSpec.getSize(i3)), Integer.MIN_VALUE);
        }
        super.onMeasure(i2, i3);
        if (this.f967d != null) {
            int mode = View.MeasureSpec.getMode(i3);
            View view = this.f966c;
            if (view != null && view.getVisibility() != 8 && mode != 1073741824) {
                if (!b(this.f967d)) {
                    i4 = a(this.f967d);
                } else if (!b(this.f968e)) {
                    i4 = a(this.f968e);
                } else {
                    i4 = 0;
                }
                if (mode == Integer.MIN_VALUE) {
                    i5 = View.MeasureSpec.getSize(i3);
                } else {
                    i5 = Integer.MAX_VALUE;
                }
                setMeasuredDimension(getMeasuredWidth(), Math.min(i4 + a(this.f966c), i5));
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.f969f;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
            unscheduleDrawable(this.f969f);
        }
        this.f969f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.f967d;
            if (view != null) {
                this.f969f.setBounds(view.getLeft(), this.f967d.getTop(), this.f967d.getRight(), this.f967d.getBottom());
            }
        }
        boolean z2 = true;
        if (!this.f972i ? !(this.f969f == null && this.f970g == null) : this.f971h != null) {
            z2 = false;
        }
        setWillNotDraw(z2);
        invalidate();
        Api21Impl.a(this);
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f971h;
        if (drawable3 != null) {
            drawable3.setCallback((Drawable.Callback) null);
            unscheduleDrawable(this.f971h);
        }
        this.f971h = drawable;
        boolean z2 = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f972i && (drawable2 = this.f971h) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!this.f972i ? this.f969f == null && this.f970g == null : this.f971h == null) {
            z2 = true;
        }
        setWillNotDraw(z2);
        invalidate();
        Api21Impl.a(this);
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f970g;
        if (drawable3 != null) {
            drawable3.setCallback((Drawable.Callback) null);
            unscheduleDrawable(this.f970g);
        }
        this.f970g = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f973j && (drawable2 = this.f970g) != null) {
                drawable2.setBounds(this.f966c.getLeft(), this.f966c.getTop(), this.f966c.getRight(), this.f966c.getBottom());
            }
        }
        boolean z2 = true;
        if (!this.f972i ? !(this.f969f == null && this.f970g == null) : this.f971h != null) {
            z2 = false;
        }
        setWillNotDraw(z2);
        invalidate();
        Api21Impl.a(this);
    }

    public void setTabContainer(ScrollingTabContainerView scrollingTabContainerView) {
        View view = this.f966c;
        if (view != null) {
            removeView(view);
        }
        this.f966c = scrollingTabContainerView;
        if (scrollingTabContainerView != null) {
            addView(scrollingTabContainerView);
            ViewGroup.LayoutParams layoutParams = scrollingTabContainerView.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            scrollingTabContainerView.setAllowCollapse(false);
        }
    }

    public void setTransitioning(boolean z2) {
        int i2;
        this.f965b = z2;
        if (z2) {
            i2 = ImageMetadata.HOT_PIXEL_MODE;
        } else {
            i2 = 262144;
        }
        setDescendantFocusability(i2);
    }

    public void setVisibility(int i2) {
        boolean z2;
        super.setVisibility(i2);
        if (i2 == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Drawable drawable = this.f969f;
        if (drawable != null) {
            drawable.setVisible(z2, false);
        }
        Drawable drawable2 = this.f970g;
        if (drawable2 != null) {
            drawable2.setVisible(z2, false);
        }
        Drawable drawable3 = this.f971h;
        if (drawable3 != null) {
            drawable3.setVisible(z2, false);
        }
    }

    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i2) {
        if (i2 != 0) {
            return super.startActionModeForChild(view, callback, i2);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        if ((drawable != this.f969f || this.f972i) && ((drawable != this.f970g || !this.f973j) && ((drawable != this.f971h || !this.f972i) && !super.verifyDrawable(drawable)))) {
            return false;
        }
        return true;
    }
}
