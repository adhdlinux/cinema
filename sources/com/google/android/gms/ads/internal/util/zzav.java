package com.google.android.gms.ads.internal.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.google.android.gms.ads.internal.zzt;

final class zzav implements Runnable {
    final /* synthetic */ Context zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ boolean zzc;
    final /* synthetic */ boolean zzd;

    zzav(zzaw zzaw, Context context, String str, boolean z2, boolean z3) {
        this.zza = context;
        this.zzb = str;
        this.zzc = z2;
        this.zzd = z3;
    }

    public final void run() {
        zzt.zzp();
        AlertDialog.Builder zzG = zzs.zzG(this.zza);
        zzG.setMessage(this.zzb);
        if (this.zzc) {
            zzG.setTitle("Error");
        } else {
            zzG.setTitle("Info");
        }
        if (this.zzd) {
            zzG.setNeutralButton("Dismiss", (DialogInterface.OnClickListener) null);
        } else {
            zzG.setPositiveButton("Learn More", new zzau(this));
            zzG.setNegativeButton("Dismiss", (DialogInterface.OnClickListener) null);
        }
        zzG.create().show();
    }
}
