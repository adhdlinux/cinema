package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzm;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.overlay.zzz;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzj;
import com.google.android.gms.ads.internal.zzt;

final class zzeee implements zzdew {
    private final Context zza;
    private final zzbzx zzb;
    private final zzfwm zzc;
    private final zzezn zzd;
    private final zzcez zze;
    private final zzfai zzf;
    private final zzbil zzg;
    private final boolean zzh;
    private final zzebl zzi;

    zzeee(Context context, zzbzx zzbzx, zzfwm zzfwm, zzezn zzezn, zzcez zzcez, zzfai zzfai, boolean z2, zzbil zzbil, zzebl zzebl) {
        this.zza = context;
        this.zzb = zzbzx;
        this.zzc = zzfwm;
        this.zzd = zzezn;
        this.zze = zzcez;
        this.zzf = zzfai;
        this.zzg = zzbil;
        this.zzh = z2;
        this.zzi = zzebl;
    }

    public final void zza(boolean z2, Context context, zzcvt zzcvt) {
        boolean z3;
        boolean z4;
        float f2;
        zzebl zzebl;
        zzddo zzddo = (zzddo) zzfwc.zzp(this.zzc);
        this.zze.zzan(true);
        if (this.zzh) {
            z3 = this.zzg.zze(false);
        } else {
            z3 = false;
        }
        zzt.zzp();
        boolean zzE = zzs.zzE(this.zza);
        boolean z5 = this.zzh;
        if (z5) {
            z4 = this.zzg.zzd();
        } else {
            z4 = false;
        }
        if (z5) {
            f2 = this.zzg.zza();
        } else {
            f2 = 0.0f;
        }
        zzj zzj = new zzj(z3, zzE, z4, f2, -1, z2, this.zzd.zzP, false);
        if (zzcvt != null) {
            zzcvt.zzf();
        }
        zzt.zzi();
        zzdel zzh2 = zzddo.zzh();
        zzcez zzcez = this.zze;
        zzezn zzezn = this.zzd;
        int i2 = zzezn.zzR;
        zzbzx zzbzx = this.zzb;
        String str = zzezn.zzC;
        zzezs zzezs = zzezn.zzt;
        String str2 = zzezs.zzb;
        String str3 = zzezs.zza;
        String str4 = this.zzf.zzf;
        if (zzezn.zzaj) {
            zzebl = this.zzi;
        } else {
            zzebl = null;
        }
        zzebl zzebl2 = zzebl;
        AdOverlayInfoParcel adOverlayInfoParcel = r4;
        AdOverlayInfoParcel adOverlayInfoParcel2 = new AdOverlayInfoParcel((zza) null, (zzo) zzh2, (zzz) null, zzcez, i2, zzbzx, str, zzj, str2, str3, str4, zzcvt, (zzbrm) zzebl2);
        zzm.zza(context, adOverlayInfoParcel, true);
    }
}
