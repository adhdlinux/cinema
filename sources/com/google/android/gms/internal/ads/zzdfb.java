package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;

public final class zzdfb implements zzcvg, zzdcd {
    private final zzbxe zza;
    private final Context zzb;
    private final zzbxw zzc;
    private final View zzd;
    private String zze;
    private final zzaxj zzf;

    public zzdfb(zzbxe zzbxe, Context context, zzbxw zzbxw, View view, zzaxj zzaxj) {
        this.zza = zzbxe;
        this.zzb = context;
        this.zzc = zzbxw;
        this.zzd = view;
        this.zzf = zzaxj;
    }

    public final void zzbr() {
    }

    public final void zzf() {
    }

    public final void zzg() {
        String str;
        if (this.zzf != zzaxj.APP_OPEN) {
            String zzd2 = this.zzc.zzd(this.zzb);
            this.zze = zzd2;
            zzaxj zzaxj = this.zzf;
            String valueOf = String.valueOf(zzd2);
            if (zzaxj == zzaxj.REWARD_BASED_VIDEO_AD) {
                str = "/Rewarded";
            } else {
                str = "/Interstitial";
            }
            this.zze = valueOf.concat(str);
        }
    }

    public final void zzj() {
        this.zza.zzb(false);
    }

    public final void zzm() {
    }

    public final void zzo() {
        View view = this.zzd;
        if (!(view == null || this.zze == null)) {
            this.zzc.zzs(view.getContext(), this.zze);
        }
        this.zza.zzb(true);
    }

    public final void zzp(zzbuu zzbuu, String str, String str2) {
        if (this.zzc.zzu(this.zzb)) {
            try {
                zzbxw zzbxw = this.zzc;
                Context context = this.zzb;
                zzbxw.zzo(context, zzbxw.zza(context), this.zza.zza(), zzbuu.zzc(), zzbuu.zzb());
            } catch (RemoteException e2) {
                zzbzr.zzk("Remote Exception to get reward item.", e2);
            }
        }
    }

    public final void zzq() {
    }
}
