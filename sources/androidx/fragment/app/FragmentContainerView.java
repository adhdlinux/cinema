package androidx.fragment.app;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.R$styleable;
import java.util.ArrayList;

public final class FragmentContainerView extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<View> f3393b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<View> f3394c;

    /* renamed from: d  reason: collision with root package name */
    private View.OnApplyWindowInsetsListener f3395d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f3396e;

    public FragmentContainerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a(View view) {
        ArrayList<View> arrayList = this.f3394c;
        if (arrayList != null && arrayList.contains(view)) {
            if (this.f3393b == null) {
                this.f3393b = new ArrayList<>();
            }
            this.f3393b.add(view);
        }
    }

    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (FragmentManager.A0(view) != null) {
            super.addView(view, i2, layoutParams);
            return;
        }
        throw new IllegalStateException("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.");
    }

    /* access modifiers changed from: protected */
    public boolean addViewInLayout(View view, int i2, ViewGroup.LayoutParams layoutParams, boolean z2) {
        if (FragmentManager.A0(view) != null) {
            return super.addViewInLayout(view, i2, layoutParams, z2);
        }
        throw new IllegalStateException("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.");
    }

    public WindowInsets dispatchApplyWindowInsets(WindowInsets windowInsets) {
        WindowInsetsCompat windowInsetsCompat;
        WindowInsetsCompat v2 = WindowInsetsCompat.v(windowInsets);
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = this.f3395d;
        if (onApplyWindowInsetsListener != null) {
            windowInsetsCompat = WindowInsetsCompat.v(onApplyWindowInsetsListener.onApplyWindowInsets(this, windowInsets));
        } else {
            windowInsetsCompat = ViewCompat.d0(this, v2);
        }
        if (!windowInsetsCompat.o()) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                ViewCompat.i(getChildAt(i2), windowInsetsCompat);
            }
        }
        return windowInsets;
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        if (this.f3396e && this.f3393b != null) {
            for (int i2 = 0; i2 < this.f3393b.size(); i2++) {
                super.drawChild(canvas, this.f3393b.get(i2), getDrawingTime());
            }
        }
        super.dispatchDraw(canvas);
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j2) {
        ArrayList<View> arrayList;
        if (!this.f3396e || (arrayList = this.f3393b) == null || arrayList.size() <= 0 || !this.f3393b.contains(view)) {
            return super.drawChild(canvas, view, j2);
        }
        return false;
    }

    public void endViewTransition(View view) {
        ArrayList<View> arrayList = this.f3394c;
        if (arrayList != null) {
            arrayList.remove(view);
            ArrayList<View> arrayList2 = this.f3393b;
            if (arrayList2 != null && arrayList2.remove(view)) {
                this.f3396e = true;
            }
        }
        super.endViewTransition(view);
    }

    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        return windowInsets;
    }

    public void removeAllViewsInLayout() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            a(getChildAt(childCount));
        }
        super.removeAllViewsInLayout();
    }

    /* access modifiers changed from: protected */
    public void removeDetachedView(View view, boolean z2) {
        if (z2) {
            a(view);
        }
        super.removeDetachedView(view, z2);
    }

    public void removeView(View view) {
        a(view);
        super.removeView(view);
    }

    public void removeViewAt(int i2) {
        a(getChildAt(i2));
        super.removeViewAt(i2);
    }

    public void removeViewInLayout(View view) {
        a(view);
        super.removeViewInLayout(view);
    }

    public void removeViews(int i2, int i3) {
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            a(getChildAt(i4));
        }
        super.removeViews(i2, i3);
    }

    public void removeViewsInLayout(int i2, int i3) {
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            a(getChildAt(i4));
        }
        super.removeViewsInLayout(i2, i3);
    }

    /* access modifiers changed from: package-private */
    public void setDrawDisappearingViewsLast(boolean z2) {
        this.f3396e = z2;
    }

    public void setLayoutTransition(LayoutTransition layoutTransition) {
        throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
    }

    public void setOnApplyWindowInsetsListener(View.OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        this.f3395d = onApplyWindowInsetsListener;
    }

    public void startViewTransition(View view) {
        if (view.getParent() == this) {
            if (this.f3394c == null) {
                this.f3394c = new ArrayList<>();
            }
            this.f3394c.add(view);
        }
        super.startViewTransition(view);
    }

    public FragmentContainerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        String str;
        this.f3396e = true;
        if (attributeSet != null) {
            String classAttribute = attributeSet.getClassAttribute();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f3259h);
            if (classAttribute == null) {
                classAttribute = obtainStyledAttributes.getString(R$styleable.f3260i);
                str = "android:name";
            } else {
                str = "class";
            }
            obtainStyledAttributes.recycle();
            if (classAttribute != null && !isInEditMode()) {
                throw new UnsupportedOperationException("FragmentContainerView must be within a FragmentActivity to use " + str + "=\"" + classAttribute + "\"");
            }
        }
    }

    FragmentContainerView(Context context, AttributeSet attributeSet, FragmentManager fragmentManager) {
        super(context, attributeSet);
        String str;
        this.f3396e = true;
        String classAttribute = attributeSet.getClassAttribute();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f3259h);
        classAttribute = classAttribute == null ? obtainStyledAttributes.getString(R$styleable.f3260i) : classAttribute;
        String string = obtainStyledAttributes.getString(R$styleable.f3261j);
        obtainStyledAttributes.recycle();
        int id = getId();
        Fragment h02 = fragmentManager.h0(id);
        if (classAttribute != null && h02 == null) {
            if (id <= 0) {
                if (string != null) {
                    str = " with tag " + string;
                } else {
                    str = "";
                }
                throw new IllegalStateException("FragmentContainerView must have an android:id to add Fragment " + classAttribute + str);
            }
            Fragment a2 = fragmentManager.r0().a(context.getClassLoader(), classAttribute);
            a2.onInflate(context, attributeSet, (Bundle) null);
            fragmentManager.n().t(true).d(this, a2, string).k();
        }
        fragmentManager.V0(this);
    }
}
