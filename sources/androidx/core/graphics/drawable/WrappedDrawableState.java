package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;

final class WrappedDrawableState extends Drawable.ConstantState {

    /* renamed from: a  reason: collision with root package name */
    int f2596a;

    /* renamed from: b  reason: collision with root package name */
    Drawable.ConstantState f2597b;

    /* renamed from: c  reason: collision with root package name */
    ColorStateList f2598c = null;

    /* renamed from: d  reason: collision with root package name */
    PorterDuff.Mode f2599d = WrappedDrawableApi14.f2588h;

    WrappedDrawableState(WrappedDrawableState wrappedDrawableState) {
        if (wrappedDrawableState != null) {
            this.f2596a = wrappedDrawableState.f2596a;
            this.f2597b = wrappedDrawableState.f2597b;
            this.f2598c = wrappedDrawableState.f2598c;
            this.f2599d = wrappedDrawableState.f2599d;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        return this.f2597b != null;
    }

    public int getChangingConfigurations() {
        int i2;
        int i3 = this.f2596a;
        Drawable.ConstantState constantState = this.f2597b;
        if (constantState != null) {
            i2 = constantState.getChangingConfigurations();
        } else {
            i2 = 0;
        }
        return i3 | i2;
    }

    public Drawable newDrawable() {
        return newDrawable((Resources) null);
    }

    public Drawable newDrawable(Resources resources) {
        return new WrappedDrawableApi21(this, resources);
    }
}
