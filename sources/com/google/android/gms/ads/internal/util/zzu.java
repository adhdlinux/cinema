package com.google.android.gms.ads.internal.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.Configuration;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzbbm;
import com.google.android.gms.internal.ads.zzbzk;

@TargetApi(24)
public class zzu extends zzt {
    static final boolean zzf(int i2, int i3, int i4) {
        return Math.abs(i2 - i3) <= i4;
    }

    public final boolean zze(Activity activity, Configuration configuration) {
        int i2;
        if (!((Boolean) zzba.zzc().zzb(zzbbm.zzeB)).booleanValue()) {
            return false;
        }
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzeD)).booleanValue()) {
            return activity.isInMultiWindowMode();
        }
        zzay.zzb();
        int zzx = zzbzk.zzx(activity, configuration.screenHeightDp);
        int zzx2 = zzbzk.zzx(activity, configuration.screenWidthDp);
        zzt.zzp();
        DisplayMetrics zzq = zzs.zzq((WindowManager) activity.getApplicationContext().getSystemService("window"));
        int i3 = zzq.heightPixels;
        int i4 = zzq.widthPixels;
        int identifier = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            i2 = activity.getResources().getDimensionPixelSize(identifier);
        } else {
            i2 = 0;
        }
        int round = ((int) Math.round(((double) activity.getResources().getDisplayMetrics().density) + 0.5d)) * ((Integer) zzba.zzc().zzb(zzbbm.zzez)).intValue();
        if (!zzf(i3, zzx + i2, round) || !zzf(i4, zzx2, round)) {
            return true;
        }
        return false;
    }
}
