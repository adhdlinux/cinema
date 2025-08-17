package com.google.android.gms.cast.framework.internal.featurehighlight;

import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.cast.framework.R;

final class zzi {
    private final Rect zza = new Rect();
    private final int zzb;
    private final int zzc;
    private final int zzd;
    private final int zze;
    private final zzh zzf;

    zzi(zzh zzh) {
        this.zzf = zzh;
        Resources resources = zzh.getResources();
        this.zzb = resources.getDimensionPixelSize(R.dimen.cast_libraries_material_featurehighlight_inner_radius);
        this.zzc = resources.getDimensionPixelOffset(R.dimen.cast_libraries_material_featurehighlight_inner_margin);
        this.zzd = resources.getDimensionPixelSize(R.dimen.cast_libraries_material_featurehighlight_text_max_width);
        this.zze = resources.getDimensionPixelSize(R.dimen.cast_libraries_material_featurehighlight_text_horizontal_offset);
    }

    private final int zzb(View view, int i2, int i3, int i4, int i5) {
        int i6;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i7 = i4 / 2;
        if (i5 - i2 <= i3 - i5) {
            i6 = (i5 - i7) + this.zze;
        } else {
            i6 = (i5 - i7) - this.zze;
        }
        int i8 = marginLayoutParams.leftMargin;
        if (i6 - i8 < i2) {
            return i2 + i8;
        }
        int i9 = marginLayoutParams.rightMargin;
        if (i6 + i4 + i9 > i3) {
            return (i3 - i4) - i9;
        }
        return i6;
    }

    private final void zzc(View view, int i2, int i3) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(View.MeasureSpec.makeMeasureSpec(Math.min((i2 - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin, this.zzd), 1073741824), View.MeasureSpec.makeMeasureSpec(i3, Integer.MIN_VALUE));
    }

    /* access modifiers changed from: package-private */
    public final void zza(Rect rect, Rect rect2) {
        View zzb2 = this.zzf.zzb();
        if (rect.isEmpty() || rect2.isEmpty()) {
            zzb2.layout(0, 0, 0, 0);
        } else {
            int centerY = rect.centerY();
            int centerX = rect.centerX();
            int centerY2 = rect2.centerY();
            int height = rect.height();
            int i2 = this.zzb;
            int max = Math.max(i2 + i2, height) / 2;
            int i3 = this.zzc;
            int i4 = centerY + max + i3;
            if (centerY < centerY2) {
                zzc(zzb2, rect2.width(), rect2.bottom - i4);
                int zzb3 = zzb(zzb2, rect2.left, rect2.right, zzb2.getMeasuredWidth(), centerX);
                zzb2.layout(zzb3, i4, zzb2.getMeasuredWidth() + zzb3, zzb2.getMeasuredHeight() + i4);
            } else {
                int i5 = (centerY - max) - i3;
                zzc(zzb2, rect2.width(), i5 - rect2.top);
                int zzb4 = zzb(zzb2, rect2.left, rect2.right, zzb2.getMeasuredWidth(), centerX);
                zzb2.layout(zzb4, i5 - zzb2.getMeasuredHeight(), zzb2.getMeasuredWidth() + zzb4, i5);
            }
        }
        this.zza.set(zzb2.getLeft(), zzb2.getTop(), zzb2.getRight(), zzb2.getBottom());
        this.zzf.zzf().zzf(rect, this.zza);
        this.zzf.zzd().zzb(rect);
    }
}
