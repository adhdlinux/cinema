package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R$attr;
import com.google.android.material.R$layout;
import com.google.android.material.snackbar.BaseTransientBottomBar;

public final class Snackbar extends BaseTransientBottomBar<Snackbar> {

    /* renamed from: o  reason: collision with root package name */
    private static final int[] f30038o = {R$attr.snackbarButtonStyle};

    /* renamed from: m  reason: collision with root package name */
    private final AccessibilityManager f30039m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f30040n;

    public static final class SnackbarLayout extends BaseTransientBottomBar.SnackbarBaseLayout {
        public SnackbarLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        /* access modifiers changed from: protected */
        public void onMeasure(int i2, int i3) {
            super.onMeasure(i2, i3);
            int childCount = getChildCount();
            int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                if (childAt.getLayoutParams().width == -1) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(childAt.getMeasuredHeight(), 1073741824));
                }
            }
        }
    }

    private Snackbar(ViewGroup viewGroup, View view, ContentViewCallback contentViewCallback) {
        super(viewGroup, view, contentViewCallback);
        this.f30039m = (AccessibilityManager) viewGroup.getContext().getSystemService("accessibility");
    }

    private static ViewGroup u(View view) {
        ViewGroup viewGroup = null;
        while (!(view instanceof CoordinatorLayout)) {
            if (view instanceof FrameLayout) {
                if (view.getId() == 16908290) {
                    return (ViewGroup) view;
                }
                viewGroup = (ViewGroup) view;
            }
            if (view != null) {
                ViewParent parent = view.getParent();
                if (parent instanceof View) {
                    view = (View) parent;
                    continue;
                } else {
                    view = null;
                    continue;
                }
            }
            if (view == null) {
                return viewGroup;
            }
        }
        return (ViewGroup) view;
    }

    protected static boolean v(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(f30038o);
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        obtainStyledAttributes.recycle();
        if (resourceId != -1) {
            return true;
        }
        return false;
    }

    public static Snackbar w(View view, CharSequence charSequence, int i2) {
        int i3;
        ViewGroup u2 = u(view);
        if (u2 != null) {
            LayoutInflater from = LayoutInflater.from(u2.getContext());
            if (v(u2.getContext())) {
                i3 = R$layout.mtrl_layout_snackbar_include;
            } else {
                i3 = R$layout.design_layout_snackbar_include;
            }
            SnackbarContentLayout snackbarContentLayout = (SnackbarContentLayout) from.inflate(i3, u2, false);
            Snackbar snackbar = new Snackbar(u2, snackbarContentLayout, snackbarContentLayout);
            snackbar.y(charSequence);
            snackbar.q(i2);
            return snackbar;
        }
        throw new IllegalArgumentException("No suitable parent found from the given view. Please provide a valid view.");
    }

    public void e() {
        super.e();
    }

    public int g() {
        if (!this.f30040n || !this.f30039m.isTouchExplorationEnabled()) {
            return super.g();
        }
        return -2;
    }

    public void s() {
        super.s();
    }

    public Snackbar x(CharSequence charSequence, final View.OnClickListener onClickListener) {
        Button actionView = ((SnackbarContentLayout) this.f30009c.getChildAt(0)).getActionView();
        if (TextUtils.isEmpty(charSequence) || onClickListener == null) {
            actionView.setVisibility(8);
            actionView.setOnClickListener((View.OnClickListener) null);
            this.f30040n = false;
        } else {
            this.f30040n = true;
            actionView.setVisibility(0);
            actionView.setText(charSequence);
            actionView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    onClickListener.onClick(view);
                    Snackbar.this.f(1);
                }
            });
        }
        return this;
    }

    public Snackbar y(CharSequence charSequence) {
        ((SnackbarContentLayout) this.f30009c.getChildAt(0)).getMessageView().setText(charSequence);
        return this;
    }
}
