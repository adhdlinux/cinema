package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONObject;

public final /* synthetic */ class zzdjn implements Callable {
    public final /* synthetic */ zzdjo zza;
    public final /* synthetic */ zzfwm zzb;
    public final /* synthetic */ zzfwm zzc;
    public final /* synthetic */ zzfwm zzd;
    public final /* synthetic */ zzfwm zze;
    public final /* synthetic */ zzfwm zzf;
    public final /* synthetic */ JSONObject zzg;
    public final /* synthetic */ zzfwm zzh;
    public final /* synthetic */ zzfwm zzi;
    public final /* synthetic */ zzfwm zzj;
    public final /* synthetic */ zzfwm zzk;

    public /* synthetic */ zzdjn(zzdjo zzdjo, zzfwm zzfwm, zzfwm zzfwm2, zzfwm zzfwm3, zzfwm zzfwm4, zzfwm zzfwm5, JSONObject jSONObject, zzfwm zzfwm6, zzfwm zzfwm7, zzfwm zzfwm8, zzfwm zzfwm9) {
        this.zza = zzdjo;
        this.zzb = zzfwm;
        this.zzc = zzfwm2;
        this.zzd = zzfwm3;
        this.zze = zzfwm4;
        this.zzf = zzfwm5;
        this.zzg = jSONObject;
        this.zzh = zzfwm6;
        this.zzi = zzfwm7;
        this.zzj = zzfwm8;
        this.zzk = zzfwm9;
    }

    public final Object call() {
        zzfwm zzfwm = this.zzb;
        zzfwm zzfwm2 = this.zzc;
        zzfwm zzfwm3 = this.zzd;
        zzfwm zzfwm4 = this.zze;
        zzfwm zzfwm5 = this.zzf;
        JSONObject jSONObject = this.zzg;
        zzfwm zzfwm6 = this.zzh;
        zzfwm zzfwm7 = this.zzi;
        zzfwm zzfwm8 = this.zzj;
        zzfwm zzfwm9 = this.zzk;
        zzdha zzdha = (zzdha) zzfwm.get();
        zzdha.zzO((List) zzfwm2.get());
        zzdha.zzL((zzber) zzfwm3.get());
        zzdha.zzP((zzber) zzfwm4.get());
        zzdha.zzI((zzbej) zzfwm5.get());
        zzdha.zzR(zzdkb.zzj(jSONObject));
        zzdha.zzK(zzdkb.zzi(jSONObject));
        zzcez zzcez = (zzcez) zzfwm6.get();
        if (zzcez != null) {
            zzdha.zzab(zzcez);
            zzdha.zzaa(zzcez.zzF());
            zzdha.zzZ(zzcez.zzq());
        }
        zzcez zzcez2 = (zzcez) zzfwm7.get();
        if (zzcez2 != null) {
            zzdha.zzN(zzcez2);
            zzdha.zzac(zzcez2.zzF());
        }
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzeS)).booleanValue()) {
            zzdha.zzT(zzfwm8);
        } else {
            zzcez zzcez3 = (zzcez) zzfwm8.get();
            if (zzcez3 != null) {
                zzdha.zzS(zzcez3);
            }
        }
        for (zzdkf zzdkf : (List) zzfwm9.get()) {
            if (zzdkf.zza != 1) {
                zzdha.zzM(zzdkf.zzb, zzdkf.zzd);
            } else {
                zzdha.zzX(zzdkf.zzb, zzdkf.zzc);
            }
        }
        return zzdha;
    }
}
