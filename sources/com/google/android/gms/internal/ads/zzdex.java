package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import androidx.collection.ArrayMap;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.zzt;

public final class zzdex implements zzcwu, zzo, zzcwa {
    zzfgw zza;
    private final Context zzb;
    private final zzcez zzc;
    private final zzezn zzd;
    private final zzbzx zze;
    private final zzaxj zzf;

    public zzdex(Context context, zzcez zzcez, zzezn zzezn, zzbzx zzbzx, zzaxj zzaxj) {
        this.zzb = context;
        this.zzc = zzcez;
        this.zzd = zzezn;
        this.zze = zzbzx;
        this.zzf = zzaxj;
    }

    public final void zzb() {
        if (this.zza != null && this.zzc != null) {
            if (!((Boolean) zzba.zzc().zzb(zzbbm.zzeR)).booleanValue()) {
                this.zzc.zzd("onSdkImpression", new ArrayMap());
            }
        }
    }

    public final void zzbF() {
    }

    public final void zzbo() {
    }

    public final void zzby() {
    }

    public final void zze() {
    }

    public final void zzf(int i2) {
        this.zza = null;
    }

    public final void zzl() {
        if (this.zza != null && this.zzc != null) {
            if (((Boolean) zzba.zzc().zzb(zzbbm.zzeR)).booleanValue()) {
                this.zzc.zzd("onSdkImpression", new ArrayMap());
            }
        }
    }

    public final void zzn() {
        zzeca zzeca;
        zzecb zzecb;
        zzecb zzecb2;
        zzaxj zzaxj = this.zzf;
        if ((zzaxj == zzaxj.REWARD_BASED_VIDEO_AD || zzaxj == zzaxj.INTERSTITIAL || zzaxj == zzaxj.APP_OPEN) && this.zzd.zzU && this.zzc != null && zzt.zzA().zzj(this.zzb)) {
            zzbzx zzbzx = this.zze;
            String str = zzbzx.zzb + "." + zzbzx.zzc;
            String zza2 = this.zzd.zzW.zza();
            if (this.zzd.zzW.zzb() == 1) {
                zzeca = zzeca.VIDEO;
                zzecb = zzecb.DEFINED_BY_JAVASCRIPT;
            } else {
                if (this.zzd.zzZ == 2) {
                    zzecb2 = zzecb.UNSPECIFIED;
                } else {
                    zzecb2 = zzecb.BEGIN_TO_RENDER;
                }
                zzecb = zzecb2;
                zzeca = zzeca.HTML_DISPLAY;
            }
            zzfgw zza3 = zzt.zzA().zza(str, this.zzc.zzG(), "", "javascript", zza2, zzecb, zzeca, this.zzd.zzam);
            this.zza = zza3;
            if (zza3 != null) {
                zzt.zzA().zzh(this.zza, (View) this.zzc);
                this.zzc.zzap(this.zza);
                zzt.zzA().zzi(this.zza);
                this.zzc.zzd("onSdkLoaded", new ArrayMap());
            }
        }
    }
}
