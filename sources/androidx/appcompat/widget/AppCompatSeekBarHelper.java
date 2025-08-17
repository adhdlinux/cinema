package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.appcompat.R$styleable;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;

class AppCompatSeekBarHelper extends AppCompatProgressBarHelper {

    /* renamed from: d  reason: collision with root package name */
    private final SeekBar f1161d;

    /* renamed from: e  reason: collision with root package name */
    private Drawable f1162e;

    /* renamed from: f  reason: collision with root package name */
    private ColorStateList f1163f = null;

    /* renamed from: g  reason: collision with root package name */
    private PorterDuff.Mode f1164g = null;

    /* renamed from: h  reason: collision with root package name */
    private boolean f1165h = false;

    /* renamed from: i  reason: collision with root package name */
    private boolean f1166i = false;

    AppCompatSeekBarHelper(SeekBar seekBar) {
        super(seekBar);
        this.f1161d = seekBar;
    }

    private void f() {
        Drawable drawable = this.f1162e;
        if (drawable == null) {
            return;
        }
        if (this.f1165h || this.f1166i) {
            Drawable r2 = DrawableCompat.r(drawable.mutate());
            this.f1162e = r2;
            if (this.f1165h) {
                DrawableCompat.o(r2, this.f1163f);
            }
            if (this.f1166i) {
                DrawableCompat.p(this.f1162e, this.f1164g);
            }
            if (this.f1162e.isStateful()) {
                this.f1162e.setState(this.f1161d.getDrawableState());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void c(AttributeSet attributeSet, int i2) {
        super.c(attributeSet, i2);
        Context context = this.f1161d.getContext();
        int[] iArr = R$styleable.V;
        TintTypedArray v2 = TintTypedArray.v(context, attributeSet, iArr, i2, 0);
        SeekBar seekBar = this.f1161d;
        ViewCompat.p0(seekBar, seekBar.getContext(), iArr, attributeSet, v2.r(), i2, 0);
        Drawable h2 = v2.h(R$styleable.W);
        if (h2 != null) {
            this.f1161d.setThumb(h2);
        }
        j(v2.g(R$styleable.X));
        int i3 = R$styleable.Z;
        if (v2.s(i3)) {
            this.f1164g = DrawableUtils.e(v2.k(i3, -1), this.f1164g);
            this.f1166i = true;
        }
        int i4 = R$styleable.Y;
        if (v2.s(i4)) {
            this.f1163f = v2.c(i4);
            this.f1165h = true;
        }
        v2.w();
        f();
    }

    /* access modifiers changed from: package-private */
    public void g(Canvas canvas) {
        int i2;
        if (this.f1162e != null) {
            int max = this.f1161d.getMax();
            int i3 = 1;
            if (max > 1) {
                int intrinsicWidth = this.f1162e.getIntrinsicWidth();
                int intrinsicHeight = this.f1162e.getIntrinsicHeight();
                if (intrinsicWidth >= 0) {
                    i2 = intrinsicWidth / 2;
                } else {
                    i2 = 1;
                }
                if (intrinsicHeight >= 0) {
                    i3 = intrinsicHeight / 2;
                }
                this.f1162e.setBounds(-i2, -i3, i2, i3);
                float width = ((float) ((this.f1161d.getWidth() - this.f1161d.getPaddingLeft()) - this.f1161d.getPaddingRight())) / ((float) max);
                int save = canvas.save();
                canvas.translate((float) this.f1161d.getPaddingLeft(), (float) (this.f1161d.getHeight() / 2));
                for (int i4 = 0; i4 <= max; i4++) {
                    this.f1162e.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(save);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void h() {
        Drawable drawable = this.f1162e;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.f1161d.getDrawableState())) {
            this.f1161d.invalidateDrawable(drawable);
        }
    }

    /* access modifiers changed from: package-private */
    public void i() {
        Drawable drawable = this.f1162e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    /* access modifiers changed from: package-private */
    public void j(Drawable drawable) {
        Drawable drawable2 = this.f1162e;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
        }
        this.f1162e = drawable;
        if (drawable != null) {
            drawable.setCallback(this.f1161d);
            DrawableCompat.m(drawable, ViewCompat.D(this.f1161d));
            if (drawable.isStateful()) {
                drawable.setState(this.f1161d.getDrawableState());
            }
            f();
        }
        this.f1161d.invalidate();
    }
}
