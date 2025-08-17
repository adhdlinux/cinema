package androidx.appcompat.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.DrawableCompat;

public class DrawableWrapperCompat extends Drawable implements Drawable.Callback {

    /* renamed from: b  reason: collision with root package name */
    private Drawable f627b;

    public DrawableWrapperCompat(Drawable drawable) {
        a(drawable);
    }

    public void a(Drawable drawable) {
        Drawable drawable2 = this.f627b;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
        }
        this.f627b = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }

    public void draw(Canvas canvas) {
        this.f627b.draw(canvas);
    }

    public int getChangingConfigurations() {
        return this.f627b.getChangingConfigurations();
    }

    public Drawable getCurrent() {
        return this.f627b.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.f627b.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return this.f627b.getIntrinsicWidth();
    }

    public int getMinimumHeight() {
        return this.f627b.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return this.f627b.getMinimumWidth();
    }

    public int getOpacity() {
        return this.f627b.getOpacity();
    }

    public boolean getPadding(Rect rect) {
        return this.f627b.getPadding(rect);
    }

    public int[] getState() {
        return this.f627b.getState();
    }

    public Region getTransparentRegion() {
        return this.f627b.getTransparentRegion();
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public boolean isAutoMirrored() {
        return DrawableCompat.h(this.f627b);
    }

    public boolean isStateful() {
        return this.f627b.isStateful();
    }

    public void jumpToCurrentState() {
        this.f627b.jumpToCurrentState();
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        this.f627b.setBounds(rect);
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i2) {
        return this.f627b.setLevel(i2);
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        scheduleSelf(runnable, j2);
    }

    public void setAlpha(int i2) {
        this.f627b.setAlpha(i2);
    }

    public void setAutoMirrored(boolean z2) {
        DrawableCompat.j(this.f627b, z2);
    }

    public void setChangingConfigurations(int i2) {
        this.f627b.setChangingConfigurations(i2);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f627b.setColorFilter(colorFilter);
    }

    public void setDither(boolean z2) {
        this.f627b.setDither(z2);
    }

    public void setFilterBitmap(boolean z2) {
        this.f627b.setFilterBitmap(z2);
    }

    public void setHotspot(float f2, float f3) {
        DrawableCompat.k(this.f627b, f2, f3);
    }

    public void setHotspotBounds(int i2, int i3, int i4, int i5) {
        DrawableCompat.l(this.f627b, i2, i3, i4, i5);
    }

    public boolean setState(int[] iArr) {
        return this.f627b.setState(iArr);
    }

    public void setTint(int i2) {
        DrawableCompat.n(this.f627b, i2);
    }

    public void setTintList(ColorStateList colorStateList) {
        DrawableCompat.o(this.f627b, colorStateList);
    }

    public void setTintMode(PorterDuff.Mode mode) {
        DrawableCompat.p(this.f627b, mode);
    }

    public boolean setVisible(boolean z2, boolean z3) {
        return super.setVisible(z2, z3) || this.f627b.setVisible(z2, z3);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
