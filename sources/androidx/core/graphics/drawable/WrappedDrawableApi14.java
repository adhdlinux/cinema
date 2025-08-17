package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;

class WrappedDrawableApi14 extends Drawable implements Drawable.Callback, WrappedDrawable, TintAwareDrawable {

    /* renamed from: h  reason: collision with root package name */
    static final PorterDuff.Mode f2588h = PorterDuff.Mode.SRC_IN;

    /* renamed from: b  reason: collision with root package name */
    private int f2589b;

    /* renamed from: c  reason: collision with root package name */
    private PorterDuff.Mode f2590c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f2591d;

    /* renamed from: e  reason: collision with root package name */
    WrappedDrawableState f2592e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f2593f;

    /* renamed from: g  reason: collision with root package name */
    Drawable f2594g;

    WrappedDrawableApi14(WrappedDrawableState wrappedDrawableState, Resources resources) {
        this.f2592e = wrappedDrawableState;
        e(resources);
    }

    private WrappedDrawableState d() {
        return new WrappedDrawableState(this.f2592e);
    }

    private void e(Resources resources) {
        Drawable.ConstantState constantState;
        WrappedDrawableState wrappedDrawableState = this.f2592e;
        if (wrappedDrawableState != null && (constantState = wrappedDrawableState.f2597b) != null) {
            b(constantState.newDrawable(resources));
        }
    }

    private boolean f(int[] iArr) {
        if (!c()) {
            return false;
        }
        WrappedDrawableState wrappedDrawableState = this.f2592e;
        ColorStateList colorStateList = wrappedDrawableState.f2598c;
        PorterDuff.Mode mode = wrappedDrawableState.f2599d;
        if (colorStateList == null || mode == null) {
            this.f2591d = false;
            clearColorFilter();
        } else {
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (!(this.f2591d && colorForState == this.f2589b && mode == this.f2590c)) {
                setColorFilter(colorForState, mode);
                this.f2589b = colorForState;
                this.f2590c = mode;
                this.f2591d = true;
                return true;
            }
        }
        return false;
    }

    public final Drawable a() {
        return this.f2594g;
    }

    public final void b(Drawable drawable) {
        Drawable drawable2 = this.f2594g;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
        }
        this.f2594g = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            setVisible(drawable.isVisible(), true);
            setState(drawable.getState());
            setLevel(drawable.getLevel());
            setBounds(drawable.getBounds());
            WrappedDrawableState wrappedDrawableState = this.f2592e;
            if (wrappedDrawableState != null) {
                wrappedDrawableState.f2597b = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }

    /* access modifiers changed from: protected */
    public boolean c() {
        throw null;
    }

    public void draw(Canvas canvas) {
        this.f2594g.draw(canvas);
    }

    public int getChangingConfigurations() {
        int i2;
        int changingConfigurations = super.getChangingConfigurations();
        WrappedDrawableState wrappedDrawableState = this.f2592e;
        if (wrappedDrawableState != null) {
            i2 = wrappedDrawableState.getChangingConfigurations();
        } else {
            i2 = 0;
        }
        return changingConfigurations | i2 | this.f2594g.getChangingConfigurations();
    }

    public Drawable.ConstantState getConstantState() {
        WrappedDrawableState wrappedDrawableState = this.f2592e;
        if (wrappedDrawableState == null || !wrappedDrawableState.a()) {
            return null;
        }
        this.f2592e.f2596a = getChangingConfigurations();
        return this.f2592e;
    }

    public Drawable getCurrent() {
        return this.f2594g.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.f2594g.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return this.f2594g.getIntrinsicWidth();
    }

    public int getLayoutDirection() {
        return DrawableCompat.f(this.f2594g);
    }

    public int getMinimumHeight() {
        return this.f2594g.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return this.f2594g.getMinimumWidth();
    }

    public int getOpacity() {
        return this.f2594g.getOpacity();
    }

    public boolean getPadding(Rect rect) {
        return this.f2594g.getPadding(rect);
    }

    public int[] getState() {
        return this.f2594g.getState();
    }

    public Region getTransparentRegion() {
        return this.f2594g.getTransparentRegion();
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public boolean isAutoMirrored() {
        return DrawableCompat.h(this.f2594g);
    }

    public boolean isStateful() {
        ColorStateList colorStateList;
        WrappedDrawableState wrappedDrawableState;
        if (!c() || (wrappedDrawableState = this.f2592e) == null) {
            colorStateList = null;
        } else {
            colorStateList = wrappedDrawableState.f2598c;
        }
        if ((colorStateList == null || !colorStateList.isStateful()) && !this.f2594g.isStateful()) {
            return false;
        }
        return true;
    }

    public void jumpToCurrentState() {
        this.f2594g.jumpToCurrentState();
    }

    public Drawable mutate() {
        Drawable.ConstantState constantState;
        if (!this.f2593f && super.mutate() == this) {
            this.f2592e = d();
            Drawable drawable = this.f2594g;
            if (drawable != null) {
                drawable.mutate();
            }
            WrappedDrawableState wrappedDrawableState = this.f2592e;
            if (wrappedDrawableState != null) {
                Drawable drawable2 = this.f2594g;
                if (drawable2 != null) {
                    constantState = drawable2.getConstantState();
                } else {
                    constantState = null;
                }
                wrappedDrawableState.f2597b = constantState;
            }
            this.f2593f = true;
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f2594g;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    public boolean onLayoutDirectionChanged(int i2) {
        return DrawableCompat.m(this.f2594g, i2);
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i2) {
        return this.f2594g.setLevel(i2);
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        scheduleSelf(runnable, j2);
    }

    public void setAlpha(int i2) {
        this.f2594g.setAlpha(i2);
    }

    public void setAutoMirrored(boolean z2) {
        DrawableCompat.j(this.f2594g, z2);
    }

    public void setChangingConfigurations(int i2) {
        this.f2594g.setChangingConfigurations(i2);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f2594g.setColorFilter(colorFilter);
    }

    public void setDither(boolean z2) {
        this.f2594g.setDither(z2);
    }

    public void setFilterBitmap(boolean z2) {
        this.f2594g.setFilterBitmap(z2);
    }

    public boolean setState(int[] iArr) {
        boolean state = this.f2594g.setState(iArr);
        if (f(iArr) || state) {
            return true;
        }
        return false;
    }

    public void setTint(int i2) {
        setTintList(ColorStateList.valueOf(i2));
    }

    public void setTintList(ColorStateList colorStateList) {
        this.f2592e.f2598c = colorStateList;
        f(getState());
    }

    public void setTintMode(PorterDuff.Mode mode) {
        this.f2592e.f2599d = mode;
        f(getState());
    }

    public boolean setVisible(boolean z2, boolean z3) {
        return super.setVisible(z2, z3) || this.f2594g.setVisible(z2, z3);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }

    WrappedDrawableApi14(Drawable drawable) {
        this.f2592e = d();
        b(drawable);
    }
}
