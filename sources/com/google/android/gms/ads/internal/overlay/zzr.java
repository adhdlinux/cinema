package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import com.facebook.hermes.intl.Constants;
import com.google.android.gms.ads.impl.R;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.ads.zzbbm;
import com.google.android.gms.internal.ads.zzbzk;
import com.google.android.gms.internal.ads.zzbzr;

public final class zzr extends FrameLayout implements View.OnClickListener {
    /* access modifiers changed from: private */
    public final ImageButton zza;
    private final zzad zzb;

    public zzr(Context context, zzq zzq, zzad zzad) {
        super(context);
        zzp zzp;
        this.zzb = zzad;
        setOnClickListener(this);
        ImageButton imageButton = new ImageButton(context);
        this.zza = imageButton;
        zzc();
        imageButton.setBackgroundColor(0);
        imageButton.setOnClickListener(this);
        zzay.zzb();
        int zzx = zzbzk.zzx(context, zzq.zza);
        zzay.zzb();
        int zzx2 = zzbzk.zzx(context, 0);
        zzay.zzb();
        int zzx3 = zzbzk.zzx(context, zzq.zzb);
        zzay.zzb();
        imageButton.setPadding(zzx, zzx2, zzx3, zzbzk.zzx(context, zzq.zzc));
        imageButton.setContentDescription("Interstitial close button");
        zzay.zzb();
        int zzx4 = zzbzk.zzx(context, zzq.zzd + zzq.zza + zzq.zzb);
        zzay.zzb();
        addView(imageButton, new FrameLayout.LayoutParams(zzx4, zzbzk.zzx(context, zzq.zzd + zzq.zzc), 17));
        long longValue = ((Long) zzba.zzc().zzb(zzbbm.zzaZ)).longValue();
        if (longValue > 0) {
            if (((Boolean) zzba.zzc().zzb(zzbbm.zzba)).booleanValue()) {
                zzp = new zzp(this);
            } else {
                zzp = null;
            }
            imageButton.setAlpha(0.0f);
            imageButton.animate().alpha(1.0f).setDuration(longValue).setListener(zzp);
        }
    }

    private final void zzc() {
        String str = (String) zzba.zzc().zzb(zzbbm.zzaY);
        if (!PlatformVersion.isAtLeastLollipop() || TextUtils.isEmpty(str) || Constants.COLLATION_DEFAULT.equals(str)) {
            this.zza.setImageResource(17301527);
            return;
        }
        Resources zzd = zzt.zzo().zzd();
        if (zzd != null) {
            Drawable drawable = null;
            try {
                if ("white".equals(str)) {
                    drawable = zzd.getDrawable(R.drawable.admob_close_button_white_circle_black_cross);
                } else if ("black".equals(str)) {
                    drawable = zzd.getDrawable(R.drawable.admob_close_button_black_circle_white_cross);
                }
            } catch (Resources.NotFoundException unused) {
                zzbzr.zze("Close button resource not found, falling back to default.");
            }
            if (drawable == null) {
                this.zza.setImageResource(17301527);
                return;
            }
            this.zza.setImageDrawable(drawable);
            this.zza.setScaleType(ImageView.ScaleType.CENTER);
            return;
        }
        this.zza.setImageResource(17301527);
    }

    public final void onClick(View view) {
        zzad zzad = this.zzb;
        if (zzad != null) {
            zzad.zzj();
        }
    }

    public final void zzb(boolean z2) {
        if (z2) {
            this.zza.setVisibility(8);
            if (((Long) zzba.zzc().zzb(zzbbm.zzaZ)).longValue() > 0) {
                this.zza.animate().cancel();
                this.zza.clearAnimation();
                return;
            }
            return;
        }
        this.zza.setVisibility(0);
    }
}
