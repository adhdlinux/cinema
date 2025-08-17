package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import java.util.concurrent.ExecutionException;
import org.json.JSONObject;

public final class zzdwl {
    private final zzfwn zza;
    private final zzdvr zzb;
    private final zzgvy zzc;
    private final zzfgb zzd;
    private final Context zze;
    private final zzbzx zzf;

    public zzdwl(zzfwn zzfwn, zzdvr zzdvr, zzgvy zzgvy, zzfgb zzfgb, Context context, zzbzx zzbzx) {
        this.zza = zzfwn;
        this.zzb = zzdvr;
        this.zzc = zzgvy;
        this.zzd = zzfgb;
        this.zze = context;
        this.zzf = zzbzx;
    }

    private final zzfwm zzh(zzbue zzbue, zzdwk zzdwk, zzdwk zzdwk2, zzfvj zzfvj) {
        zzfwm zzfwm;
        String str = zzbue.zzd;
        zzt.zzp();
        if (zzs.zzy(str)) {
            zzfwm = zzfwc.zzg(new zzdwa(1));
        } else {
            zzfwm = zzfwc.zzf(zzdwk.zza(zzbue), ExecutionException.class, zzdwb.zza, this.zza);
        }
        return zzfwc.zzf(zzfwc.zzm(zzfvt.zzv(zzfwm), zzfvj, this.zza), zzdwa.class, new zzdwj(this, zzdwk2, zzbue, zzfvj), this.zza);
    }

    public final zzfwm zza(zzbue zzbue) {
        return zzh(zzbue, new zzdwh(this.zzb), new zzdwi(this), new zzdwg(zzbue));
    }

    public final zzfwm zzb(JSONObject jSONObject) {
        return zzfwc.zzm(zzfvt.zzv(zzfwc.zzh(jSONObject)), zzt.zzf().zza(this.zze, this.zzf, this.zzd).zza("AFMA_getAdDictionary", zzbmw.zza, zzdwf.zza), this.zza);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzfwm zzc(zzdwk zzdwk, zzbue zzbue, zzfvj zzfvj, zzdwa zzdwa) throws Exception {
        return zzfwc.zzm(zzdwk.zza(zzbue), zzfvj, this.zza);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzfwm zzd(zzbue zzbue) {
        return ((zzdyh) this.zzc.zzb()).zzb(zzbue, Binder.getCallingUid());
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzfwm zze(zzbue zzbue) {
        return this.zzb.zzc(zzbue.zzh);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzfwm zzf(zzbue zzbue) {
        return ((zzdyh) this.zzc.zzb()).zzi(zzbue.zzh);
    }

    public final zzfwm zzg(zzbue zzbue) {
        return zzh(zzbue, new zzdwd(this), new zzdwe(this), zzdwc.zza);
    }
}
