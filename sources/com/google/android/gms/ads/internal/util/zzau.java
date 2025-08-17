package com.google.android.gms.ads.internal.util;

import android.content.DialogInterface;
import android.net.Uri;
import com.google.android.gms.ads.internal.zzt;

final class zzau implements DialogInterface.OnClickListener {
    final /* synthetic */ zzav zza;

    zzau(zzav zzav) {
        this.zza = zzav;
    }

    public final void onClick(DialogInterface dialogInterface, int i2) {
        zzt.zzp();
        zzs.zzQ(this.zza.zza, Uri.parse("https://support.google.com/dfp_premium/answer/7160685#push"));
    }
}
