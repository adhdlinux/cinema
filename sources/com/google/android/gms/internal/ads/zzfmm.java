package com.google.android.gms.internal.ads;

import android.app.PendingIntent;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;

public final class zzfmm {
    public static final int zza = (Build.VERSION.SDK_INT > 22 ? 67108864 : 0);
    public static final ClipData zzb = ClipData.newIntent("", new Intent());

    public static PendingIntent zza(Context context, int i2, Intent intent, int i3, int i4) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8 = true;
        if ((i3 & 88) == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        zzfph.zzf(z2, "Cannot set any dangerous parts of intent to be mutable.");
        if ((i3 & 1) == 0 || zzb(0, 3)) {
            z3 = true;
        } else {
            z3 = false;
        }
        zzfph.zzf(z3, "Cannot use Intent.FILL_IN_ACTION unless the action is marked as mutable.");
        if ((i3 & 2) == 0 || zzb(0, 5)) {
            z4 = true;
        } else {
            z4 = false;
        }
        zzfph.zzf(z4, "Cannot use Intent.FILL_IN_DATA unless the data is marked as mutable.");
        if ((i3 & 4) == 0 || zzb(0, 9)) {
            z5 = true;
        } else {
            z5 = false;
        }
        zzfph.zzf(z5, "Cannot use Intent.FILL_IN_CATEGORIES unless the category is marked as mutable.");
        if ((i3 & 128) == 0 || zzb(0, 17)) {
            z6 = true;
        } else {
            z6 = false;
        }
        zzfph.zzf(z6, "Cannot use Intent.FILL_IN_CLIP_DATA unless the clip data is marked as mutable.");
        if (intent.getComponent() != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        zzfph.zzf(z7, "Must set component on Intent.");
        if (zzb(0, 1)) {
            zzfph.zzf(!zzb(i3, 67108864), "Cannot set mutability flags if PendingIntent.FLAG_IMMUTABLE is set.");
        } else {
            if (Build.VERSION.SDK_INT >= 23 && !zzb(i3, 67108864)) {
                z8 = false;
            }
            zzfph.zzf(z8, "Must set PendingIntent.FLAG_IMMUTABLE for SDK >= 23 if no parts of intent are mutable.");
        }
        Intent intent2 = new Intent(intent);
        if (Build.VERSION.SDK_INT < 23 || !zzb(i3, 67108864)) {
            if (intent2.getPackage() == null) {
                intent2.setPackage(intent2.getComponent().getPackageName());
            }
            if (!zzb(0, 3) && intent2.getAction() == null) {
                intent2.setAction("");
            }
            if (!zzb(0, 9) && intent2.getCategories() == null) {
                intent2.addCategory("");
            }
            if (!zzb(0, 5) && intent2.getData() == null) {
                intent2.setDataAndType(Uri.EMPTY, "*/*");
            }
            if (!zzb(0, 17) && intent2.getClipData() == null) {
                intent2.setClipData(zzb);
            }
        }
        return PendingIntent.getService(context, 0, intent2, i3);
    }

    private static boolean zzb(int i2, int i3) {
        return (i2 & i3) == i3;
    }
}
