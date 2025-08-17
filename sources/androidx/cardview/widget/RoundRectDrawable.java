package androidx.cardview.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

class RoundRectDrawable extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    private float f1657a;

    /* renamed from: b  reason: collision with root package name */
    private final Paint f1658b;

    /* renamed from: c  reason: collision with root package name */
    private final RectF f1659c;

    /* renamed from: d  reason: collision with root package name */
    private final Rect f1660d;

    /* renamed from: e  reason: collision with root package name */
    private float f1661e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f1662f = false;

    /* renamed from: g  reason: collision with root package name */
    private boolean f1663g = true;

    /* renamed from: h  reason: collision with root package name */
    private ColorStateList f1664h;

    /* renamed from: i  reason: collision with root package name */
    private PorterDuffColorFilter f1665i;

    /* renamed from: j  reason: collision with root package name */
    private ColorStateList f1666j;

    /* renamed from: k  reason: collision with root package name */
    private PorterDuff.Mode f1667k = PorterDuff.Mode.SRC_IN;

    RoundRectDrawable(ColorStateList colorStateList, float f2) {
        this.f1657a = f2;
        this.f1658b = new Paint(5);
        e(colorStateList);
        this.f1659c = new RectF();
        this.f1660d = new Rect();
    }

    private PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    private void e(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f1664h = colorStateList;
        this.f1658b.setColor(colorStateList.getColorForState(getState(), this.f1664h.getDefaultColor()));
    }

    private void i(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        this.f1659c.set((float) rect.left, (float) rect.top, (float) rect.right, (float) rect.bottom);
        this.f1660d.set(rect);
        if (this.f1662f) {
            float b2 = RoundRectDrawableWithShadow.b(this.f1661e, this.f1657a, this.f1663g);
            this.f1660d.inset((int) Math.ceil((double) RoundRectDrawableWithShadow.a(this.f1661e, this.f1657a, this.f1663g)), (int) Math.ceil((double) b2));
            this.f1659c.set(this.f1660d);
        }
    }

    public ColorStateList b() {
        return this.f1664h;
    }

    /* access modifiers changed from: package-private */
    public float c() {
        return this.f1661e;
    }

    public float d() {
        return this.f1657a;
    }

    public void draw(Canvas canvas) {
        boolean z2;
        Paint paint = this.f1658b;
        if (this.f1665i == null || paint.getColorFilter() != null) {
            z2 = false;
        } else {
            paint.setColorFilter(this.f1665i);
            z2 = true;
        }
        RectF rectF = this.f1659c;
        float f2 = this.f1657a;
        canvas.drawRoundRect(rectF, f2, f2, paint);
        if (z2) {
            paint.setColorFilter((ColorFilter) null);
        }
    }

    public void f(ColorStateList colorStateList) {
        e(colorStateList);
        invalidateSelf();
    }

    /* access modifiers changed from: package-private */
    public void g(float f2, boolean z2, boolean z3) {
        if (f2 != this.f1661e || this.f1662f != z2 || this.f1663g != z3) {
            this.f1661e = f2;
            this.f1662f = z2;
            this.f1663g = z3;
            i((Rect) null);
            invalidateSelf();
        }
    }

    public int getOpacity() {
        return -3;
    }

    public void getOutline(Outline outline) {
        outline.setRoundRect(this.f1660d, this.f1657a);
    }

    /* access modifiers changed from: package-private */
    public void h(float f2) {
        if (f2 != this.f1657a) {
            this.f1657a = f2;
            i((Rect) null);
            invalidateSelf();
        }
    }

    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.f1666j;
        if ((colorStateList2 == null || !colorStateList2.isStateful()) && (((colorStateList = this.f1664h) == null || !colorStateList.isStateful()) && !super.isStateful())) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        i(rect);
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        boolean z2;
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.f1664h;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        if (colorForState != this.f1658b.getColor()) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            this.f1658b.setColor(colorForState);
        }
        ColorStateList colorStateList2 = this.f1666j;
        if (colorStateList2 == null || (mode = this.f1667k) == null) {
            return z2;
        }
        this.f1665i = a(colorStateList2, mode);
        return true;
    }

    public void setAlpha(int i2) {
        this.f1658b.setAlpha(i2);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f1658b.setColorFilter(colorFilter);
    }

    public void setTintList(ColorStateList colorStateList) {
        this.f1666j = colorStateList;
        this.f1665i = a(colorStateList, this.f1667k);
        invalidateSelf();
    }

    public void setTintMode(PorterDuff.Mode mode) {
        this.f1667k = mode;
        this.f1665i = a(this.f1666j, mode);
        invalidateSelf();
    }
}
