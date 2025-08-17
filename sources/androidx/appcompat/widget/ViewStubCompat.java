package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.R$styleable;
import java.lang.ref.WeakReference;

public final class ViewStubCompat extends View {

    /* renamed from: b  reason: collision with root package name */
    private int f1547b;

    /* renamed from: c  reason: collision with root package name */
    private int f1548c;

    /* renamed from: d  reason: collision with root package name */
    private WeakReference<View> f1549d;

    /* renamed from: e  reason: collision with root package name */
    private LayoutInflater f1550e;

    public interface OnInflateListener {
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public View a() {
        ViewParent parent = getParent();
        if (!(parent instanceof ViewGroup)) {
            throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
        } else if (this.f1547b != 0) {
            ViewGroup viewGroup = (ViewGroup) parent;
            LayoutInflater layoutInflater = this.f1550e;
            if (layoutInflater == null) {
                layoutInflater = LayoutInflater.from(getContext());
            }
            View inflate = layoutInflater.inflate(this.f1547b, viewGroup, false);
            int i2 = this.f1548c;
            if (i2 != -1) {
                inflate.setId(i2);
            }
            int indexOfChild = viewGroup.indexOfChild(this);
            viewGroup.removeViewInLayout(this);
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams != null) {
                viewGroup.addView(inflate, indexOfChild, layoutParams);
            } else {
                viewGroup.addView(inflate, indexOfChild);
            }
            this.f1549d = new WeakReference<>(inflate);
            return inflate;
        } else {
            throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
    }

    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
    }

    public int getInflatedId() {
        return this.f1548c;
    }

    public LayoutInflater getLayoutInflater() {
        return this.f1550e;
    }

    public int getLayoutResource() {
        return this.f1547b;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        setMeasuredDimension(0, 0);
    }

    public void setInflatedId(int i2) {
        this.f1548c = i2;
    }

    public void setLayoutInflater(LayoutInflater layoutInflater) {
        this.f1550e = layoutInflater;
    }

    public void setLayoutResource(int i2) {
        this.f1547b = i2;
    }

    public void setOnInflateListener(OnInflateListener onInflateListener) {
    }

    public void setVisibility(int i2) {
        WeakReference<View> weakReference = this.f1549d;
        if (weakReference != null) {
            View view = weakReference.get();
            if (view != null) {
                view.setVisibility(i2);
                return;
            }
            throw new IllegalStateException("setVisibility called on un-referenced view");
        }
        super.setVisibility(i2);
        if (i2 == 0 || i2 == 4) {
            a();
        }
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f1547b = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.e4, i2, 0);
        this.f1548c = obtainStyledAttributes.getResourceId(R$styleable.h4, -1);
        this.f1547b = obtainStyledAttributes.getResourceId(R$styleable.g4, 0);
        setId(obtainStyledAttributes.getResourceId(R$styleable.f4, -1));
        obtainStyledAttributes.recycle();
        setVisibility(8);
        setWillNotDraw(true);
    }
}
