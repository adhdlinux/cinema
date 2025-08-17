package com.google.android.gms.cast.framework.internal.featurehighlight;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import androidx.annotation.Keep;
import androidx.core.graphics.ColorUtils;
import com.google.android.gms.cast.framework.R;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.cast.zzek;
import com.google.android.gms.internal.cast.zzel;

class OuterHighlightDrawable extends Drawable {
    private final int zza;
    private final int zzb;
    private final int zzc;
    private final Rect zzd = new Rect();
    private final Rect zze = new Rect();
    private final Paint zzf;
    private float zzg;
    private float zzh;
    private float zzi;
    private float zzj;
    private float zzk;
    private float zzl;
    private int zzm;

    public OuterHighlightDrawable(Context context) {
        int i2;
        Paint paint = new Paint();
        this.zzf = paint;
        this.zzh = 1.0f;
        this.zzk = 0.0f;
        this.zzl = 0.0f;
        this.zzm = 244;
        if (PlatformVersion.isAtLeastLollipop()) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(16843827, typedValue, true);
            i2 = ColorUtils.p(typedValue.data, 244);
        } else {
            i2 = context.getResources().getColor(R.color.cast_libraries_material_featurehighlight_outer_highlight_default_color);
        }
        paint.setColor(i2);
        this.zzm = paint.getAlpha();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        Resources resources = context.getResources();
        this.zza = resources.getDimensionPixelSize(R.dimen.cast_libraries_material_featurehighlight_center_threshold);
        this.zzb = resources.getDimensionPixelSize(R.dimen.cast_libraries_material_featurehighlight_center_horizontal_offset);
        this.zzc = resources.getDimensionPixelSize(R.dimen.cast_libraries_material_featurehighlight_outer_padding);
    }

    private static final float zzh(float f2, float f3, Rect rect) {
        float f4 = (float) rect.left;
        float f5 = (float) rect.top;
        float f6 = (float) rect.right;
        float f7 = (float) rect.bottom;
        float zza2 = zzel.zza(f2, f3, f4, f5);
        float zza3 = zzel.zza(f2, f3, f6, f5);
        int i2 = (zza2 > zza3 ? 1 : (zza2 == zza3 ? 0 : -1));
        float zza4 = zzel.zza(f2, f3, f6, f7);
        float zza5 = zzel.zza(f2, f3, f4, f7);
        if (i2 <= 0 || zza2 <= zza4 || zza2 <= zza5) {
            if (zza3 > zza4 && zza3 > zza5) {
                zza2 = zza3;
            } else if (zza4 <= zza5) {
                zza2 = zza5;
            } else {
                zza2 = zza4;
            }
        }
        return (float) Math.ceil((double) zza2);
    }

    public final void draw(Canvas canvas) {
        canvas.drawCircle(this.zzi + this.zzk, this.zzj + this.zzl, this.zzg * this.zzh, this.zzf);
    }

    public final int getAlpha() {
        return this.zzf.getAlpha();
    }

    public final int getOpacity() {
        return -3;
    }

    public final void setAlpha(int i2) {
        this.zzf.setAlpha(i2);
        invalidateSelf();
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.zzf.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Keep
    public void setScale(float f2) {
        this.zzh = f2;
        invalidateSelf();
    }

    @Keep
    public void setTranslationX(float f2) {
        this.zzk = f2;
        invalidateSelf();
    }

    @Keep
    public void setTranslationY(float f2) {
        this.zzl = f2;
        invalidateSelf();
    }

    public final float zza() {
        return this.zzi;
    }

    public final float zzb() {
        return this.zzj;
    }

    public final int zzc() {
        return this.zzf.getColor();
    }

    public final Animator zzd(float f2, float f3) {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat("scale", new float[]{0.0f, 1.0f}), PropertyValuesHolder.ofFloat("translationX", new float[]{f2, 0.0f}), PropertyValuesHolder.ofFloat("translationY", new float[]{f3, 0.0f}), PropertyValuesHolder.ofInt("alpha", new int[]{0, this.zzm})});
        ofPropertyValuesHolder.setInterpolator(zzek.zzc());
        return ofPropertyValuesHolder.setDuration(350);
    }

    public final void zze(int i2) {
        this.zzf.setColor(i2);
        this.zzm = this.zzf.getAlpha();
        invalidateSelf();
    }

    public final void zzf(Rect rect, Rect rect2) {
        float f2;
        this.zzd.set(rect);
        this.zze.set(rect2);
        float exactCenterX = rect.exactCenterX();
        float exactCenterY = rect.exactCenterY();
        Rect bounds = getBounds();
        if (Math.min(exactCenterY - ((float) bounds.top), ((float) bounds.bottom) - exactCenterY) < ((float) this.zza)) {
            this.zzi = exactCenterX;
            this.zzj = exactCenterY;
        } else {
            if (exactCenterX <= bounds.exactCenterX()) {
                f2 = rect2.exactCenterX() + ((float) this.zzb);
            } else {
                f2 = rect2.exactCenterX() - ((float) this.zzb);
            }
            this.zzi = f2;
            exactCenterY = rect2.exactCenterY();
            this.zzj = exactCenterY;
        }
        this.zzg = ((float) this.zzc) + Math.max(zzh(this.zzi, exactCenterY, rect), zzh(this.zzi, this.zzj, rect2));
        invalidateSelf();
    }

    public final boolean zzg(float f2, float f3) {
        return zzel.zza(f2, f3, this.zzi, this.zzj) < this.zzg;
    }
}
